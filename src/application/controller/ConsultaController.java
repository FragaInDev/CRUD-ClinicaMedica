package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Consulta;
import application.persistence.ConsultaDAO;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConsultaController implements IConsultaController {

	private TextField tfIdConsulta;
	private TextField tfPacienteConsulta;
	private TextField tfMedicoConsulta;
	private TextField tfClinicaConsulta;
	private TextField tfDataConsulta;
	private TextField tfHoraConsulta;
	private TextField tfObserConsulta;
	private TextArea taListaConsulta;

	public ConsultaController(TextField tfIdConsulta, TextField tfPacienteConsulta, TextField tfMedicoConsulta,
			TextField tfClinicaConsulta, TextField tfDataConsulta, TextField tfHoraConsulta,
			TextField tfObserConsulta, TextArea taListaConsulta) {
		this.tfIdConsulta = tfIdConsulta;
		this.tfPacienteConsulta = tfPacienteConsulta;
		this.tfMedicoConsulta = tfMedicoConsulta;
		this.tfClinicaConsulta = tfClinicaConsulta;
		this.tfDataConsulta = tfDataConsulta;
		this.tfHoraConsulta = tfHoraConsulta;
		this.tfObserConsulta = tfObserConsulta;
		this.taListaConsulta = taListaConsulta;
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
		consultaDao.buscaConsulta(co);

		tfIdConsulta.setText(Integer.toString(co.getId()));
		tfPacienteConsulta.setText(co.getPacienteCpf().getCpf());
		tfMedicoConsulta.setText(co.getMedicoCrm().getCrm());
		tfClinicaConsulta.setText(Integer.toString(co.getClinicaId().getId()));
		tfDataConsulta.setText(co.getData());
		tfHoraConsulta.setText(co.getHora());
		tfObserConsulta.setText(co.getObservacao());
	}

	@Override
	public void buscarConsultas() throws ClassNotFoundException, SQLException {
		limparCamposConsulta();
		ConsultaDAO consultaDao = new ConsultaDAO();
		List<Consulta> listaConsultas = consultaDao.buscaConsultas();

		taListaConsulta.setText("");

		StringBuffer sb = new StringBuffer(
				"Id\t\t\t\tPaciente\t\t\t\tMédico\t\t\t\tClínica\t\t\t\tData\t\t\t\tHora\t\t\t\tObservação\n");
		for (Consulta co : listaConsultas) {
			sb.append(co.getId() + "\t\t\t\t" + co.getPacienteCpf().getCpf() + "\t\t\t" + co.getMedicoCrm().getCrm() + "\t\t\t\t"
					+ co.getClinicaId().getId() + "\t\t\t\t\t" + co.getData() + "\t\t" + co.getHora() + "\t\t\t\t"
					+ co.getObservacao() + "\n");
		}
		taListaConsulta.setText(sb.toString());
	}

	private void limparCamposConsulta() {
		tfIdConsulta.setText("");
		tfPacienteConsulta.setText("");
		tfMedicoConsulta.setText("");
		tfClinicaConsulta.setText("");
		tfDataConsulta.setText("");
		tfHoraConsulta.setText("");
		tfObserConsulta.setText("");
	}

}