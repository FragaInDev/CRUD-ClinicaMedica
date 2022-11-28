package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Clinica;

public interface IClinicaDAO {
        public void insereClinica(Clinica c) throws SQLException;
        public void atualizaClinica(Clinica c) throws SQLException;
        public void excluiClinica(Clinica c) throws SQLException;
        public Clinica consultaClinica(Clinica c) throws SQLException;
        public List<Clinica> listaClinica() throws SQLException;
}
