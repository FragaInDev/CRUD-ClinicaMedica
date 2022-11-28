package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Clinica;
import application.persistence.ClinicaDAO;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClinicaController implements IClinicaController {
	
	private TextField tfIdClinica;
	private TextField tfNomeClinica;
	private TextField tfTelClinica;
	private TextField tfEmailClinica;
	private TextField tfLogradouroClinica;
	private TextField tfCepClinica;
	private TextField tfComplClinica;
	private TextField tfNumClinica;
	private TextArea taListaClinica;
	
	

	public ClinicaController(TextField tfIdClinica, TextField tfNomeClinica, TextField tfTelClinica,
			TextField tfEmailClinica, TextField tfLogradouroClinica, TextField tfCepClinica, TextField tfComplClinica,
			TextField tfNumClinica, TextArea taListaClinica) {
	
		this.tfIdClinica = tfIdClinica;
		this.tfNomeClinica = tfNomeClinica;
		this.tfTelClinica = tfTelClinica;
		this.tfEmailClinica = tfEmailClinica;
		this.tfLogradouroClinica = tfLogradouroClinica;
		this.tfCepClinica = tfCepClinica;
		this.tfComplClinica = tfComplClinica;
		this.tfNumClinica = tfNumClinica;
		this.taListaClinica = taListaClinica;
	}

	private void limpaCamposClinica() {
		tfIdClinica.setText("");
		tfNomeClinica.setText("");
		tfTelClinica.setText("");
		tfEmailClinica.setText("");
		tfLogradouroClinica.setText("");
		tfCepClinica.setText("");
		tfComplClinica.setText("");
		tfNumClinica.setText("");
	}

	@Override
	public void insereClinica(Clinica c) throws ClassNotFoundException, SQLException {
		ClinicaDAO cDAO = new ClinicaDAO();
		cDAO.insereClinica(c);
		limpaCamposClinica();
		buscarClinicas();
	}

	@Override
	public void atualizaClinica(Clinica c) throws ClassNotFoundException, SQLException {
		ClinicaDAO cDAO = new ClinicaDAO();
		cDAO.atualizaClinica(c);
		limpaCamposClinica();
		buscarClinicas();		
	}

	@Override
	public void excluiClinica(Clinica c) throws ClassNotFoundException, SQLException {
		ClinicaDAO cDAO = new ClinicaDAO();
		cDAO.excluiClinica(c);
		limpaCamposClinica();
		buscarClinicas();		
	}

	@Override
	public void consultaClinica(Clinica c) throws ClassNotFoundException, SQLException {
		limpaCamposClinica();

		ClinicaDAO cDAO = new ClinicaDAO();
		c = cDAO.consultaClinica(c);

		tfIdClinica.setText(Integer.toString(c.getId()));
		tfNomeClinica.setText(c.getNome());
		tfTelClinica.setText(c.getTelefone());
		tfEmailClinica.setText(c.getEmail());
		tfLogradouroClinica.setText(c.getLogradouro());
		tfCepClinica.setText(c.getCep());
		tfComplClinica.setText(c.getComplemento());
		tfNumClinica.setText(c.getNumEnd());
	}

	@Override
	public void buscarClinicas() throws ClassNotFoundException, SQLException {
		limpaCamposClinica();
		taListaClinica.setText("");
		ClinicaDAO cDAO = new ClinicaDAO();
		List<Clinica> listaClinica = cDAO.listaClinica();
		
		StringBuffer buffer = new StringBuffer("Id\t\t\t\tNome\t\t\t\tLogradouro\t\t\t\tNumero\t\t\t\tCEP\t\t\t\tComplemento\t\t\t\tTelefone\t\t\t\tEmail\n");
		
		for (Clinica c : listaClinica) {
			buffer.append(c.getId()+"\t\t\t\t"+c.getNome()+"\t\t\t\t"+c.getLogradouro()+"\t\t\t\t"+c.getNumEnd()+"\t\t\t\t"+c.getCep()+"\t\t\t\t"+c.getComplemento()+"\t\t\t\t"+c.getTelefone()+"\t\t\t\t"+c.getEmail()+"\n");
			taListaClinica.setText(buffer.toString());
		}
	}
	
	

	
}