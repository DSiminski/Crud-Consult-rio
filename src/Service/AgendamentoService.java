package Service;

import Dao.AgendamentoDao;
import Model.Agendamento;

import java.util.List;

public class AgendamentoService {

    AgendamentoDao agendamentoDao = new AgendamentoDao();

    public void insertAAgendamento(Agendamento agendamento){
        agendamentoDao.insertAgendamento(agendamento);
    }

    public void updateAgendamento(Agendamento agendamento){
        agendamentoDao.updateAgendamento(agendamento);
    }

    public void disableAgendamento(Agendamento agendamento){
        agendamentoDao.disableAgendamento(agendamento);
    }

    public List<Agendamento> findAllAgendamento(){
        return agendamentoDao.findAllAgendamento();
    }

    public Agendamento findByIdAgendamento(Long id){
        return agendamentoDao.findByIdAgendamento(id);
    }

}

