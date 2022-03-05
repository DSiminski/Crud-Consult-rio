package Model;

import java.time.LocalDateTime;

public class Agendamento extends AbstractEntity {

    private Paciente paciente;
    private Medico medico;
    private Secretaria secretaria;
    private StatusAgendamento statusAgendamento;
    private LocalDateTime dataAgendamento;
    private Boolean encaixe;

    public Agendamento() {
    }

    public Agendamento(Paciente paciente, Medico medico, Secretaria secretaria, StatusAgendamento statusAgendamento, LocalDateTime dataAgendamento, Boolean encaixe) {
        this.paciente = paciente;
        this.medico = medico;
        this.secretaria = secretaria;
        this.statusAgendamento = statusAgendamento;
        this.dataAgendamento = dataAgendamento;
        this.encaixe = encaixe;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Boolean getEncaixe() {
        return encaixe;
    }

    public void setEncaixe(Boolean encaixe) {
        this.encaixe = encaixe;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "paciente=" + paciente +
                ", medico=" + medico +
                ", secretaria=" + secretaria +
                ", statusAgendamento=" + statusAgendamento +
                ", dataAgendamento=" + dataAgendamento +
                ", encaixe=" + encaixe +
                '}';
    }
}
