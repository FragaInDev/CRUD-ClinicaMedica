package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Paciente;
import application.persistence.PacienteDAO;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PacienteController implements IPacienteController {

    private TextField tfCpf;
    private TextField tfNomePaciente;
    private TextField tfLogradouroPaciente;
    private TextField tfNumPaciente;
    private TextField tfCepPaciente;
    private TextField tfComplePaciente;
    private TextField tfTelPaciente;
    private TextField tfSanguePaciente;
    private TextField tfEmailPaciente;
    private TextArea taListarPaciente;

    
    public PacienteController(TextField tfCpf, TextField tfNomePaciente, TextField tfLogradouroPaciente,
            TextField tfNumPaciente, TextField tfCepPaciente, TextField tfComplePaciente, TextField tfTelPaciente,
            TextField tfSanguePaciente, TextField tfEmailPaciente, TextArea taListarPaciente) {
        this.tfCpf = tfCpf;
        this.tfNomePaciente = tfNomePaciente;
        this.tfLogradouroPaciente = tfLogradouroPaciente;
        this.tfNumPaciente = tfNumPaciente;
        this.tfCepPaciente = tfCepPaciente;
        this.tfComplePaciente = tfComplePaciente;
        this.tfTelPaciente = tfTelPaciente;
        this.tfSanguePaciente = tfSanguePaciente;
        this.tfEmailPaciente = tfEmailPaciente;
        this.taListarPaciente = taListarPaciente;
    }

    @Override
    public void inserirPaciente(Paciente p) throws ClassNotFoundException, SQLException {
        PacienteDAO pDao = new PacienteDAO();
        
        pDao.inserePaciente(p);
        limpaCampoPaciente();
        buscarPacientes();
    }

    @Override
    public void atualizarPaciente(Paciente p) throws ClassNotFoundException, SQLException {
        PacienteDAO pDao = new PacienteDAO();
        
        pDao.atualizaPaciente(p);
        limpaCampoPaciente();
        buscarPacientes();
    }

    @Override
    public void excluirPaciente(Paciente p) throws ClassNotFoundException, SQLException {
        PacienteDAO pDao = new PacienteDAO();
        
        pDao.excluiPaciente(p);
        limpaCampoPaciente();
        buscarPacientes();
    }

    @Override
    public void buscarPaciente(Paciente p) throws ClassNotFoundException, SQLException {
        limpaCampoPaciente();
        
        PacienteDAO pDao = new PacienteDAO();
        p = pDao.consultaPaciente(p);

        tfCpf.setText(p.getCpf());
        tfNomePaciente.setText(p.getNome());
        tfLogradouroPaciente.setText(p.getLogradouro());
        tfNumPaciente.setText(String.valueOf(p.getNumero()));
        tfCepPaciente.setText(p.getCep());
        tfComplePaciente.setText(p.getComplemento());
        tfTelPaciente.setText(p.getTelefone());
        tfSanguePaciente.setText(p.getTipoSanguineo());
        tfEmailPaciente.setText(p.getEmail());
        
    }

    @Override
    public void buscarPacientes() throws ClassNotFoundException, SQLException {
        limpaCampoPaciente();
        taListarPaciente.setText("");

        PacienteDAO pDao = new PacienteDAO();
        List<Paciente> listaPacientes = pDao.listaPaciente();

        StringBuffer buffer = new StringBuffer("\t CPF\tNome\tLogradouro\tnumero\tCEP\tComplemento\ttipo Sanguineo\temail");

        for(Paciente p : listaPacientes){
            buffer.append(p.getCpf()+"\t"+p.getNome()+"\t"+p.getLogradouro()+"\t"+p.getNumero()+"\t"+p.getCep()+"\t"+p.getComplemento()+"\t"+p.getTipoSanguineo()+"\t"+p.getEmail());
        }

        taListarPaciente.setText(buffer.toString());
        
    }

    private void limpaCampoPaciente(){
        tfCpf.setText("");
        tfNomePaciente.setText("");
        tfLogradouroPaciente.setText("");
        tfNumPaciente.setText("");
        tfCepPaciente.setText("");
        tfComplePaciente.setText("");
        tfTelPaciente.setText("");
        tfSanguePaciente.setText("");
        tfEmailPaciente.setText("");
    }
    
}