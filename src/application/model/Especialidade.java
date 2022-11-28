package application.model;

public class Especialidade {
    private int id;
    private String nomeEspecialidade;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }
    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", nome=" + nomeEspecialidade +"]";
    }
}
