package application.controller;

import java.sql.SQLException;

import application.model.Receituario;

public interface IReceituarioController {

    public void adicionarReceituario(Receituario re) throws ClassNotFoundException,SQLException;
    public void atualizarReceituario(Receituario re) throws ClassNotFoundException,SQLException;
    public void excluirReceituario(Receituario re) throws ClassNotFoundException,SQLException;
    public void buscarReceituario(Receituario re) throws ClassNotFoundException,SQLException;
    public void buscarReceituarios() throws ClassNotFoundException,SQLException;
} 
