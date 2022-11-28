package application.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import application.model.Clinica;
import application.model.Consulta;
import application.model.Medico;
import application.model.Paciente;

public class ConsultaDAO implements IConsultaDAO {

	private Connection c;

	public ConsultaDAO() throws ClassNotFoundException, SQLException {
		GenericDAO gDao = new GenericDAO();
		c = gDao.getConnection();
	}

	@Override
	public void adicionaConsulta(Consulta co) throws SQLException {
		String sql = "INSERT INTO consulta VALUES (?,?,?,?,?,?,?)";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, co.getId());
		ps.setString(2, co.getPacienteCpf().getCpf());
		ps.setString(3, co.getMedicoCrm().getCrm());
		ps.setInt(4, co.getClinicaId().getId());
		ps.setDate(5, (Date) co.getData());
		ps.setTime(6, co.getHora());
		ps.setString(7, co.getObservacao());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizaConsulta(Consulta co) throws SQLException {
		String sql = "UPDATE consulta SET CpfPaciente = ?, crmMedico = ?, IdClinica = ?, data = ?, hora = ?, observacao = ? WHERE id = ?";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, co.getPacienteCpf().getCpf());
		ps.setString(2, co.getMedicoCrm().getCrm());
		ps.setInt(3, co.getClinicaId().getId());
		ps.setDate(4, (Date) co.getData());
		ps.setTime(5, co.getHora());
		ps.setString(6, co.getObservacao());
		ps.setInt(7, co.getId());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiConsulta(Consulta co) throws SQLException {
		String sql = "DELETE consulta WHERE id = ?";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, co.getId());
		ps.execute();
		ps.close();

	}

	@Override
	public Consulta buscaConsulta(Consulta co) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT co.id AS idConsulta, co.data AS dataConsulta, co.hora AS horaConsulta, co.observacao AS observacaoConsulta, ");
		sql.append("pa.cpf AS cpfPaciente, me.crm AS crmMedico, cl.id AS idClinica ");
		sql.append("FROM consulta co, paciente pa, medico me, clinica cl ");
		sql.append ("WHERE co.idConsulta = pa.cpf ");
		sql.append("AND co.idMedico = me.crm ");
		sql.append("AND co.idClinica = cl.id ");
		sql.append("AND WHERE co.id = ?");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, co.getId());
		ResultSet rs = ps.executeQuery();
		int cont = 0;
		if (rs.next()) {
			Paciente pa = new Paciente();
			pa.setCpf(rs.getString("cpfPaciente"));
			
			Medico me = new Medico();
			me.setCrm(rs.getString("crmMedico"));;
			
			Clinica cl = new Clinica();
			cl.setId(rs.getInt("clinicaId"));
			
			co.setData(rs.getDate("dataConsulta"));
			co.setHora(rs.getTime("horaConsulta"));
			co.setObservacao(rs.getString("observacaoConsulta"));
			cont++;
		}
		if (cont == 0) {
			co = new Consulta();
			Paciente pa = new Paciente();
			co.setPacienteCpf (pa);
			Medico me = new Medico();
			co.setMedicoCrm (me);
			Clinica cl = new Clinica();
			co.setClinicaId (cl);
		}
		rs.close();
		ps.close();
		return co;
	}

	@Override
	public List<Consulta> buscaConsultas() throws SQLException {
		List<Consulta> listaConsultas = new ArrayList<Consulta>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT co.id AS idConsulta, co.data AS dataConsulta, co.hora AS horaConsulta, co.observacao AS observacaoConsulta, ");
		sql.append("pa.cpf AS cpfPaciente, me.crm AS crmMedico, cl.id AS idClinica ");
		sql.append("FROM consulta co, paciente pa, medico me, clinica cl ");
		sql.append ("WHERE co.idConsulta = pa.cpf ");
		sql.append("AND co.idMedico = me.crm ");
		sql.append("AND co.idClinica = cl.id");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Paciente pa = new Paciente();
			pa.setCpf(rs.getString("cpfPaciente"));
			
			Medico me = new Medico();
			me.setCrm(rs.getString("crmMedico"));;
			
			Clinica cl = new Clinica();
			cl.setId(rs.getInt("clinicaId"));
			
			Consulta co = new Consulta();
			co.setId(rs.getInt("idConsulta"));
			co.setPacienteCpf(pa);
			co.setMedicoCrm(me);
			co.setClinicaId(cl);
			co.setData(rs.getDate("dataConsulta"));
			co.setHora(rs.getTime("horaConsulta"));
			co.setObservacao(rs.getString("observacaoConsulta"));

			listaConsultas.add(co);
		}
		rs.close();
		ps.close();
		return listaConsultas;
	}
}