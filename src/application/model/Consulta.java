package application.model;

import java.sql.Date;
import java.sql.Time;

public class Consulta {
    private int id;
    private Paciente paciente;
    private Medico medico;
    private Clinica clinica;
    private Date data;
    private Time hora;
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
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Time getHora() {
        return hora;
    }
    public void setHora(Time hora) {
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
