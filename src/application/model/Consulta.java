package application.model;

public class Consulta {
    private int id;
    private Paciente paciente;
    private Medico medico;
    private Clinica clinica;
    private String data;
    private String hora;
    private String observacao;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Paciente getPacienteCpf() {
        return paciente;
    }
    public void setPacienteCpf(Paciente paciente) {
        this.paciente = paciente;
    }
    public Medico getMedicoCrm() {
        return medico;
    }
    public void setMedicoCrm(Medico medico) {
        this.medico = medico;
    }
    public Clinica getClinicaId() {
        return clinica;
    }
    public void setClinicaId(Clinica clinica) {
        this.clinica = clinica;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    @Override
    public String toString() {
        return "[id=" + id + ", pacienteCpf=" + paciente + ", medicoCrm=" + medico + ", clinicaId="
                + clinica + ", data=" + data + ", hora=" + hora + ", observacao=" + observacao + "]";
    }

}
