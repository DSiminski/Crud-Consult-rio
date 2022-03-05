package Dao;

import Factory.ConnectionFactory;
import Model.Agendamento;
import Model.Medico;
import Model.Paciente;
import Model.StatusAgendamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDao {

    private static Connection connection;

    public AgendamentoDao()  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agenda (cadastrado,id_paciente,id_medico,status_agendamento,data_agendamento,encaixe)" +
                "VALUES(now(),?,?,?,?,?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1,agendamento.getPaciente().getId());
            preparedStatement.setLong(2, agendamento.getMedico().getId());
            preparedStatement.setString(3, agendamento.getStatusAgendamento().valor);
            preparedStatement.setTimestamp(4, Timestamp.valueOf(agendamento.getDataAgendamento()));
            preparedStatement.setBoolean(5, agendamento.getEncaixe());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                agendamento.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Agendamento> findAllAgendamento(){

        String sql = "SELECT * FROM agenda";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Agendamento> listaDeAgendas = new ArrayList<>();

            while (resultSet.next()){
                Agendamento agenda = new Agendamento();

                agenda.setId(resultSet.getLong("id"));
                agenda.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    agenda.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    agenda.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                PacienteDao pacienteDao = new PacienteDao();
                Paciente paciente = pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente"));
                agenda.setPaciente(paciente);

                MedicoDao medicoDao = new MedicoDao();
                Medico medico = medicoDao.findByIdMedico(resultSet.getLong("id_medico"));
                agenda.setMedico(medico);

                switch (resultSet.getString("status_agendamento")){
                    case "Pendente":
                        agenda.setStatusAgendamento(StatusAgendamento.pendente);
                        break;
                    case "Aprovado":
                        agenda.setStatusAgendamento(StatusAgendamento.aprovado);
                        break;
                    case "Cancelado":
                        agenda.setStatusAgendamento(StatusAgendamento.cancelado);
                        break;
                    case "Compareceu":
                        agenda.setStatusAgendamento(StatusAgendamento.compareceu);
                        break;
                    case "Não Compareceu":
                        agenda.setStatusAgendamento(StatusAgendamento.ncompareceu);
                        break;
                    case "Rejeitado":
                        agenda.setStatusAgendamento(StatusAgendamento.rejeitado);
                        break;
                }

                agenda.setDataAgendamento(resultSet.getTimestamp("data_agendamento").toLocalDateTime());
                agenda.setEncaixe(resultSet.getBoolean("encaixe"));

                listaDeAgendas.add(agenda);
            }

            return listaDeAgendas;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Agendamento findByIdAgendamento(Long agenda_id){

        String sql = "SELECT * FROM agenda WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, agenda_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Agendamento agendamento = new Agendamento();

                agendamento.setId(resultSet.getLong("id"));
                agendamento.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    agendamento.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    agendamento.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                PacienteDao pacienteDao = new PacienteDao();
                Paciente paciente = pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente"));
                agendamento.setPaciente(paciente);

                MedicoDao medicoDao = new MedicoDao();
                Medico medico = medicoDao.findByIdMedico(resultSet.getLong("id_medico"));
                agendamento.setMedico(medico);

                switch (resultSet.getString("status_agendamento")){
                    case "Pendente":
                        agendamento.setStatusAgendamento(StatusAgendamento.pendente);
                        break;
                    case "Aprovado":
                        agendamento.setStatusAgendamento(StatusAgendamento.aprovado);
                        break;
                    case "Cancelado":
                        agendamento.setStatusAgendamento(StatusAgendamento.cancelado);
                        break;
                    case "Compareceu":
                        agendamento.setStatusAgendamento(StatusAgendamento.compareceu);
                        break;
                    case "Não Compareceu":
                        agendamento.setStatusAgendamento(StatusAgendamento.ncompareceu);
                        break;
                    case "Rejeitado":
                        agendamento.setStatusAgendamento(StatusAgendamento.rejeitado);
                        break;
                }

                agendamento.setDataAgendamento(resultSet.getTimestamp("data_agendamento").toLocalDateTime());
                agendamento.setEncaixe(resultSet.getBoolean("encaixe"));

                return agendamento;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateAgendamento(Agendamento agendamento){

        String sql = "UPDATE agenda SET atualizado = now(),id_paciente = ?,id_medico = ?," +
                "status_agendamento = ?,data_agendamento = ?,encaixe = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,agendamento.getPaciente().getId());
            preparedStatement.setLong(2,agendamento.getMedico().getId());
            preparedStatement.setString(3,agendamento.getStatusAgendamento().valor);
            preparedStatement.setTimestamp(4,Timestamp.valueOf(agendamento.getDataAgendamento()));
            preparedStatement.setBoolean(5,agendamento.getEncaixe());
            preparedStatement.setLong(6, agendamento.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void disableAgendamento(Agendamento agendamento){

        String sql = "UPDATE agenda SET excluido = now() WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, agendamento.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }


}

