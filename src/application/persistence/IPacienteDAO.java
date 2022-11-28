package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Paciente;

public interface IPacienteDAO {
    public void inserePaciente(Paciente p) throws SQLException;
    public void atualizaPaciente(Paciente p) throws SQLException;
    public void excluiPaciente(Paciente p) throws SQLException;
    public Paciente consultaPaciente(Paciente p) throws SQLException;
    public List<Paciente> listaPaciente() throws SQLException;
}
