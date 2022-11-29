package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Receituario;
import application.persistence.ReceituarioDAO;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReceituarioController implements IReceituarioController {

	private TextField tfIdReceituario;
	private TextField tfIdConsultaReceituario;
	private TextField tfPrescricao;
	private TextArea taListarReceituarios;

	public ReceituarioController(TextField tfIdReceituario, TextField tfIdConsultaReceituario,
			TextField tfPrescricao, TextArea taListarReceituarios) {
		this.tfIdReceituario = tfIdReceituario;
		this.tfIdConsultaReceituario = tfIdConsultaReceituario;
		this.tfPrescricao = tfPrescricao;
		this.taListarReceituarios = taListarReceituarios;
	}

	@Override
	public void adicionarReceituario(Receituario re) throws ClassNotFoundException, SQLException {
		ReceituarioDAO receitaDao = new ReceituarioDAO();
		receitaDao.adicionaReceituario(re);
		limparCamposReceituario();
		buscarReceituarios();
	}

	@Override
	public void atualizarReceituario(Receituario re) throws ClassNotFoundException, SQLException {
		ReceituarioDAO receitaDao = new ReceituarioDAO();
		receitaDao.atualizaReceituario(re);
		limparCamposReceituario();
		buscarReceituarios();
	}

	@Override
	public void excluirReceituario(Receituario re) throws ClassNotFoundException, SQLException {
		ReceituarioDAO receitaDao = new ReceituarioDAO();
		receitaDao.excluiReceituario(re);
		limparCamposReceituario();
		buscarReceituarios();
	}

	@Override
	public void buscarReceituario(Receituario re) throws ClassNotFoundException, SQLException {
		limparCamposReceituario();
		ReceituarioDAO receitaDao = new ReceituarioDAO();
		re = receitaDao.buscaReceituario(re);
		tfIdReceituario.setText(String.valueOf(re.getId()));
		tfIdConsultaReceituario.setText(String.valueOf(re.getConsultaId().getId()));
		tfPrescricao.setText(re.getPrescricao());
	}

	@Override
	public void buscarReceituarios() throws ClassNotFoundException, SQLException {
		limparCamposReceituario();

		ReceituarioDAO receitaDao = new ReceituarioDAO();
		List<Receituario> listaReceituarios = receitaDao.buscaReceituarios();

		taListarReceituarios.setText("");

		StringBuffer sb = new StringBuffer("Id\t\t\t\tConsulta\t\t\t\tPrescrição\n");
		for (Receituario re : listaReceituarios) {
			sb.append(re.getId() + "\t\t\t\t" + re.getConsultaId() + "\t\t\t\t" + re.getPrescricao() + "\n");
		}
		taListarReceituarios.setText(sb.toString());
	}

	private void limparCamposReceituario() {
		tfIdReceituario.setText("");
		tfIdConsultaReceituario.setText("");
		tfPrescricao.setText("");

	}

}
