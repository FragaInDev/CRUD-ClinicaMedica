package application.persistence;

import java.sql.Connection;
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
		ps.setString(5, co.getData());
		ps.setString(6, co.getHora());
		ps.setString(7, co.getObservacao());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizaConsulta(Consulta co) throws SQLException {
		String sql = "UPDATE consulta SET pacienteCPF = ?, medicoCRM = ?, clinicaID = ?, dataConsulta = ?, horaConsulta = ?, observacao = ? WHERE id = ?";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, co.getPacienteCpf().getCpf());
		ps.setString(2, co.getMedicoCrm().getCrm());
		ps.setInt(3, co.getClinicaId().getId());
		ps.setString(4, co.getData());
		ps.setString(5, co.getHora());
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
		sql.append("SELECT co.id, co.dataConsulta AS Data, co.horaConsulta AS Horario, co.observacao AS Observacao, ");
		sql.append("p.cpf AS Paciente, m.crm AS Medico, cl.id AS Clinica ");
		sql.append("FROM consulta co, paciente p, medico m, clinica cl ");
		sql.append ("WHERE co.id = ? ");
		sql.append ("AND co.pacienteCPF = p.cpf ");
		sql.append("AND co.medicoCRM = m.crm ");
		sql.append("AND co.clinicaID = cl.id");

		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, co.getId());

		ResultSet rs = ps.executeQuery();
		int cont = 0;
		if (rs.next()) {
			Paciente pa = new Paciente();
			pa.setCpf(rs.getString("Paciente"));
			
			Medico me = new Medico();
			me.setCrm(rs.getString("Medico"));;
			
			Clinica cl = new Clinica();
			cl.setId(rs.getInt("Clinica"));
			
			co.setData(rs.getString("Data"));
			co.setHora(rs.getString("Horario"));
			co.setObservacao(rs.getString("Observacao"));
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
		sql.append("SELECT co.id, co.dataConsulta AS Data, co.horaConsulta AS Horario, co.observacao AS Observacao, ");
		sql.append("p.cpf AS Paciente, m.crm AS Medico, cl.id AS Clinica ");
		sql.append("FROM consulta co, paciente p, medico m, clinica cl ");
		sql.append ("WHERE co.pacienteCPF = p.cpf ");
		sql.append("AND co.medicoCRM = m.crm ");
		sql.append("AND co.clinicaID = cl.id");
		
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Paciente pa = new Paciente();
			pa.setCpf(rs.getString("Paciente"));
			
			Medico me = new Medico();
			me.setCrm(rs.getString("Medico"));;
			
			Clinica cl = new Clinica();
			cl.setId(rs.getInt("Clinica"));
			
			Consulta co = new Consulta();
			co.setId(rs.getInt("id"));
			co.setPacienteCpf(pa);
			co.setMedicoCrm(me);
			co.setClinicaId(cl);
			co.setData(rs.getString("Data"));
			co.setHora(rs.getString("Horario"));
			co.setObservacao(rs.getString("Observacao"));

			listaConsultas.add(co);
		}
		rs.close();
		ps.close();
		return listaConsultas;
	}
}