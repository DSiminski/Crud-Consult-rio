package Model;

public class Especialidade extends AbstractEntity {

    private String nome;

    public Especialidade() {
    }

    public Especialidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Especialidade{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
