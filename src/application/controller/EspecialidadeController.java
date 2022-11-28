package application.controller;

import java.sql.SQLException;
import java.util.List;
import application.model.Especialidade;
import application.persistence.EspecialidadeDAO;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EspecialidadeController implements IEspecialidadeController{
	
	private TextField tfIdEspecialidade;
	private TextField tfEspecialidade;
    private TextArea taListaEspecialidade;
    
    public EspecialidadeController(TextField tfIdEspecialidade, TextField tfEspecialidade,
			TextArea taListaEspecialidade) {
		this.tfIdEspecialidade = tfIdEspecialidade;
		this.tfEspecialidade = tfEspecialidade;
		this.taListaEspecialidade = taListaEspecialidade;
	}
	
    private void limpaCampoEspecialidade(){
    	tfIdEspecialidade.setText("");
        tfEspecialidade.setText("");
    }
	@Override
	public void inserirEspecialidade(Especialidade e) throws ClassNotFoundException, SQLException {
		EspecialidadeDAO eDao = new EspecialidadeDAO();
        eDao.insereEspecialidade(e);
        limpaCampoEspecialidade();
        buscarEspecialidades();
	}
	@Override
	public void atualizarEspecialidade(Especialidade e) throws ClassNotFoundException, SQLException {
		EspecialidadeDAO eDao = new EspecialidadeDAO();
        eDao.atualizaEspecialidade(e);
        limpaCampoEspecialidade();
        buscarEspecialidades();
	}
	@Override
	public void excluirEspecialidade(Especialidade e) throws ClassNotFoundException, SQLException {
		EspecialidadeDAO eDao = new EspecialidadeDAO();
        eDao.excluiEspecialidade(e);
        limpaCampoEspecialidade();
        buscarEspecialidades();
	}
	@Override
	public void buscarEspecialidade(Especialidade e) throws ClassNotFoundException, SQLException {
		limpaCampoEspecialidade();
		EspecialidadeDAO eDao = new EspecialidadeDAO();
        eDao.consultaEspecialidade(e);
        tfIdEspecialidade.setText(Integer.toString(e.getId()));
        tfEspecialidade.setText(e.getNomeEspecialidade());
	}
	@Override
	public void buscarEspecialidades() throws ClassNotFoundException, SQLException {
		limpaCampoEspecialidade();
		taListaEspecialidade.setText("");
		
		EspecialidadeDAO eDao = new EspecialidadeDAO();
				List<Especialidade> listaEspecialidades = eDao.listaEspecialidade();

        StringBuffer buffer = new StringBuffer("ID\t\t\t\t\tEspecialidade\n");

        for(Especialidade e : listaEspecialidades){
            buffer.append(e.getId()+"\t\t\t\t"+e.getNomeEspecialidade()+"\n");
        }
        taListaEspecialidade.setText(buffer.toString());
	}
}