package application.controller;

import java.sql.SQLException;

import application.model.Clinica;

public interface IClinicaController {

        public void insereClinica(Clinica c) throws ClassNotFoundException, SQLException;
        public void atualizaClinica(Clinica c) throws ClassNotFoundException, SQLException;
        public void excluiClinica(Clinica c) throws ClassNotFoundException, SQLException;
        public void consultaClinica(Clinica c) throws ClassNotFoundException, SQLException;
        public void buscarClinicas() throws ClassNotFoundException, SQLException;
} 