package Model;

import java.math.BigDecimal;

public class Convenio extends AbstractEntity {

    private String nome;
    private BigDecimal valor;
    private String id_convenio;
    private String numero_cartao_convenio;

    public Convenio() {
    }

    public Convenio(String nome, BigDecimal valor, String id_convenio, String numero_cartao_convenio) {
        this.nome = nome;
        this.valor = valor;
        this.id_convenio = id_convenio;
        this.numero_cartao_convenio = numero_cartao_convenio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getId_convenio() {
        return id_convenio;
    }

    public void setId_convenio(String id_convenio) {
        this.id_convenio = id_convenio;
    }

    public String getNumero_cartao_convenio() {
        return numero_cartao_convenio;
    }

    public void setNumero_cartao_convenio(String numero_cartao_convenio) {
        this.numero_cartao_convenio = numero_cartao_convenio;
    }

    @Override
    public String toString() {
        return "Convenio{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", id_convenio='" + id_convenio + '\'' +
                ", numero_cartao_convenio='" + numero_cartao_convenio + '\'' +
                '}';
    }
}
