package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Receituario;

public interface IReceituarioDAO {

    public void adicionaReceituario(Receituario re) throws SQLException;
    public void atualizaReceituario(Receituario re) throws SQLException;
    public void excluiReceituario(Receituario re) throws SQLException;
    public Receituario buscaReceituario(Receituario re) throws SQLException;
    public List<Receituario> buscaReceituarios() throws SQLException;
}
