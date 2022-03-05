package Model;

import java.math.BigDecimal;

public class Medico extends Pessoa{

    private Especialidade especialidade;
    private String CRM;
    private BigDecimal porcenParticipacao;
    private String consultorio;
    private String IdMedico;

    public Medico() {
    }

    public Medico(Especialidade especialidade, String CRM, BigDecimal porcenParticipacao, String consultorio,String IdMedico) {
        this.especialidade = especialidade;
        this.CRM = CRM;
        this.porcenParticipacao = porcenParticipacao;
        this.consultorio = consultorio;
        this.IdMedico = IdMedico;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public BigDecimal getPorcenParticipacao() {
        return porcenParticipacao;
    }

    public void setPorcenParticipacao(BigDecimal porcenParticipacao) {
        this.porcenParticipacao = porcenParticipacao;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getIdMedico() {
        return IdMedico;
    }

    public void setIdMedico(String idMedico) {
        IdMedico = idMedico;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "especialidade=" + especialidade +
                ", CRM='" + CRM + '\'' +
                ", porcenParticipacao=" + porcenParticipacao +
                ", consultorio='" + consultorio + '\'' +
                ", IdMedico='" + IdMedico + '\'' +
                '}';
    }
}
