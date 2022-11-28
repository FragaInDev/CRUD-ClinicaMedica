package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Consulta;
import application.persistence.ConsultaDAO;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConsultaController implements IConsultaController {

	private TextField txtIdConsulta;
	private TextField txtCpfPacienteConsulta;
	private TextField txtCrmMedicoConsulta;
	private TextField txtIdClinicaConsulta;
	private TextField txtDataConsulta;
	private TextField txtHoraConsulta;
	private TextField txtObservacaoConsulta;
	private TextArea taListarConsultas;

	public ConsultaController(TextField txtIdConsulta, TextField txtCpfPacienteConsulta, TextField txtCrmMedicoConsulta,
			TextField txtIdClinicaConsulta, TextField txtDataConsulta, TextField txtHoraConsulta,
			TextField txtObservacaoConsulta, TextArea taListarConsultas) {
		this.txtIdConsulta = txtIdConsulta;
		this.txtCpfPacienteConsulta = txtCpfPacienteConsulta;
		this.txtCrmMedicoConsulta = txtCrmMedicoConsulta;
		this.txtIdClinicaConsulta = txtIdClinicaConsulta;
		this.txtDataConsulta = txtDataConsulta;
		this.txtHoraConsulta = txtHoraConsulta;
		this.txtObservacaoConsulta = txtObservacaoConsulta;
		this.taListarConsultas = taListarConsultas;
	}

	@Override
	public void adicionarConsulta(Consulta co) throws ClassNotFoundException, SQLException {
		ConsultaDAO consultaDao = new ConsultaDAO();
		consultaDao.adicionaConsulta(co);
		limparCamposConsulta();
		buscarConsultas();
	}

	@Override
	public void atualizarConsulta(Consulta co) throws ClassNotFoundException, SQLException {
		ConsultaDAO consultaDao = new ConsultaDAO();
		consultaDao.atualizaConsulta(co);
		limparCamposConsulta();
		buscarConsultas();
	}

	@Override
	public void excluirConsulta(Consulta co) throws ClassNotFoundException, SQLException {
		ConsultaDAO consultaDao = new ConsultaDAO();
		consultaDao.excluiConsulta(co);
		limparCamposConsulta();
		buscarConsultas();
	}

	@Override
	public void buscarConsulta(Consulta co) throws ClassNotFoundException, SQLException {
		limparCamposConsulta();
		ConsultaDAO consultaDao = new ConsultaDAO();
		co = consultaDao.buscaConsulta(co);

		txtIdConsulta.setText(String.valueOf(co.getId()));
		txtCpfPacienteConsulta.setText(co.getPacienteCpf().getCpf());
		txtCrmMedicoConsulta.setText(co.getMedicoCrm().getCrm());
		txtIdClinicaConsulta.setText(String.valueOf(co.getClinicaId().getId()));
		txtDataConsulta.setText(String.valueOf(co.getData()));
		txtHoraConsulta.setText(String.valueOf(co.getHora()));
		txtObservacaoConsulta.setText(co.getObservacao());
	}

	@Override
	public void buscarConsultas() throws ClassNotFoundException, SQLException {
		limparCamposConsulta();
		ConsultaDAO consultaDao = new ConsultaDAO();
		List<Consulta> listaConsultas = consultaDao.buscaConsultas();

		taListarConsultas.setText("");

		StringBuffer sb = new StringBuffer(
				"Id\t\t\t\tPaciente\t\t\t\tMédico\t\t\t\tClínica\t\t\t\tData\t\t\t\tHora\t\t\t\tObservação\n");
		for (Consulta co : listaConsultas) {
			sb.append(co.getId() + "\t\t\t\t" + co.getPacienteCpf() + "\t\t\t\t" + co.getMedicoCrm() + "\t\t\t\t"
					+ co.getClinicaId() + "\t\t\t\t" + co.getData() + "\t\t\t\t" + co.getHora() + "\t\t\t\t"
					+ co.getObservacao() + "\n");
		}
		taListarConsultas.setText(sb.toString());
	}

	private void limparCamposConsulta() {
		txtIdConsulta.setText("");
		txtCpfPacienteConsulta.setText("");
		txtCrmMedicoConsulta.setText("");
		txtIdClinicaConsulta.setText("");
		txtDataConsulta.setText("");
		txtHoraConsulta.setText("");
		txtObservacaoConsulta.setText("");
	}

}