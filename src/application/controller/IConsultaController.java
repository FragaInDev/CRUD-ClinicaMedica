package application.controller;

import java.sql.SQLException;

import application.model.Consulta;

public interface IConsultaController {
    public void adicionarConsulta(Consulta co) throws ClassNotFoundException, SQLException;
    public void atualizarConsulta(Consulta co) throws ClassNotFoundException, SQLException;
    public void excluirConsulta(Consulta co) throws ClassNotFoundException, SQLException;
    public void buscarConsulta(Consulta co) throws ClassNotFoundException, SQLException;
    public void buscarConsultas() throws ClassNotFoundException, SQLException;

}