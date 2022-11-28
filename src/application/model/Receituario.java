package application.model;

public class Receituario {
    private int id;
    private Consulta consultaId;
    private String prescricao;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Consulta getConsultaId() {
        return consultaId;
    }
    public void setConsultaId(Consulta consultaId) {
        this.consultaId = consultaId;
    }
    public String getPrescricao() {
        return prescricao;
    }
    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }
    @Override
    public String toString() {
        return "[id=" + id + ", consultaId=" + consultaId + ", prescricao=" + prescricao + "]";
    }
}
