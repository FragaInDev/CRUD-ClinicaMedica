package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Medico;
import application.persistence.MedicoDAO;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MedicoController implements IMedicoController{
	
	private TextField tfCrm;
    private TextField tfNomeMedico;
    private TextField tfLogradouroMedico;
    private TextField tfNumMedico;
    private TextField tfCepMedico;
	private TextField tfComplMedico;
    private TextField tfTelMedico;
    private TextField tfEmailMedico;
    private TextField tfIdEspecialidadeMedico;
    private Label lblEspecialidade;
    private TextArea taListarMedicos;
    
    public MedicoController(TextField tfCrm, TextField tfNomeMedico, TextField tfLogradouroMedico,
			TextField tfNumMedico, TextField tfCepMedico, TextField tfComplMedico, TextField tfTelMedico,
			TextField tfEmailMedico, TextField tfIdEspecialidadeMedico, Label lblEspecialidade, TextArea taListarMedicos) {
		this.tfCrm = tfCrm;
		this.tfNomeMedico = tfNomeMedico;
		this.tfLogradouroMedico = tfLogradouroMedico;
		this.tfNumMedico = tfNumMedico;
		this.tfCepMedico = tfCepMedico;
		this.tfComplMedico = tfComplMedico;
		this.tfTelMedico = tfTelMedico;
		this.tfEmailMedico = tfEmailMedico;
        this.tfIdEspecialidadeMedico = tfIdEspecialidadeMedico;
        this.lblEspecialidade = lblEspecialidade; 
		this.taListarMedicos = taListarMedicos;
	}

	@Override
	public void inserirMedico(Medico m) throws ClassNotFoundException, SQLException {
		MedicoDAO mDao = new MedicoDAO();
        mDao.insereMedico(m);
        limpaCampoMedico();
        buscarMedicos();
	}

	@Override
	public void atualizarMedico(Medico m) throws ClassNotFoundException, SQLException {
		MedicoDAO mDao = new MedicoDAO();
        mDao.atualizaMedico(m);
        limpaCampoMedico();
        buscarMedicos();
	}

	@Override
	public void excluirMedico(Medico m) throws ClassNotFoundException, SQLException {
		MedicoDAO mDao = new MedicoDAO();
        mDao.excluiMedico(m);
        limpaCampoMedico();
        buscarMedicos();
	}

	@Override
	public void buscarMedico(Medico m) throws ClassNotFoundException, SQLException {
		limpaCampoMedico();
        
		MedicoDAO mDao = new MedicoDAO();
        mDao.consultaMedico(m);

        tfCrm.setText(m.getCrm());
        tfNomeMedico.setText(m.getNome());
        tfLogradouroMedico.setText(m.getLogradouro());
        tfNumMedico.setText(m.getNumEnd());
        tfCepMedico.setText(m.getCep());
        tfComplMedico.setText(m.getComplemento());
        tfTelMedico.setText(m.getTelefone());
        tfEmailMedico.setText(m.getEmail());
        tfIdEspecialidadeMedico.setText(Integer.toString(m.getEspecialidade().getId()));
        lblEspecialidade.setText(m.getEspecialidade().getNomeEspecialidade());
	}

	@Override
	public void buscarMedicos() throws ClassNotFoundException, SQLException {
		limpaCampoMedico();
		taListarMedicos.setText("");
		
		MedicoDAO mDao = new MedicoDAO();
		List<Medico> listaMedicos = mDao.listaMedico();

        StringBuffer buffer = new StringBuffer("CRM\t\t\t\tNome\t\t\t\t\tLogradouro\t\t\tnumero\t\t\tCEP\t\t\tComplemento\t\t\tTelefone\t\t\tEmail\t\t\t\t\t\tEspecialidade\n");

        for(Medico m : listaMedicos){
            buffer.append(m.getCrm()+"\t\t"+m.getNome()+"\t\t\t\t"+m.getLogradouro()+"\t\t\t"+m.getNumEnd()+"\t\t\t"+m.getCep()+"\t\t\t"+m.getComplemento()+"\t\t\t"+m.getTelefone()+"\t\t\t"+m.getEmail()+"\t\t\t\t\t"+m.getEspecialidade()+"\n");
        }
        taListarMedicos.setText(buffer.toString());
	}
	
    private void limpaCampoMedico(){
        tfCrm.setText("");
        tfNomeMedico.setText("");
        tfLogradouroMedico.setText("");
        tfNumMedico.setText("");
        tfCepMedico.setText("");
    	tfComplMedico.setText("");
        tfTelMedico.setText("");
        tfEmailMedico.setText("");
        tfIdEspecialidadeMedico.setText("");
        lblEspecialidade.setText("");
    }
	
	
	
}