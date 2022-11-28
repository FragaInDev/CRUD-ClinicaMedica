package application.controller;

import java.sql.SQLException;

import application.model.Paciente;

public interface IPacienteController {
    public void inserirPaciente(Paciente p) throws ClassNotFoundException, SQLException;
    public void atualizarPaciente(Paciente p) throws ClassNotFoundException, SQLException;
    public void excluirPaciente(Paciente p) throws ClassNotFoundException, SQLException;
    public void buscarPaciente(Paciente p) throws ClassNotFoundException, SQLException;
    public void buscarPacientes() throws ClassNotFoundException, SQLException;
}
