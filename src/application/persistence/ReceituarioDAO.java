package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Consulta;
import application.model.Receituario;

public class ReceituarioDAO implements IReceituarioDAO {

	private Connection c;

	public ReceituarioDAO() throws ClassNotFoundException, SQLException {
		GenericDAO gDao = new GenericDAO();
		c = gDao.getConnection();
	}

	@Override
	public void adicionaReceituario(Receituario re) throws SQLException {
		String sql = "INSERT INTO receita VALUES (?,?,?)";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, re.getId());
		ps.setInt(2, re.getConsultaId().getId());
		ps.setString(3, re.getPrescricao());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizaReceituario(Receituario re) throws SQLException {
		String sql = "UPDATE receita SET idConsulta = ?, prescricao = ? WHERE id = ?";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, re.getConsultaId().getId());
		ps.setString(2, re.getPrescricao());
		ps.setInt(3, re.getId());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiReceituario(Receituario re) throws SQLException {
		String sql = "DELETE receita WHERE id = ?";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, re.getId());
		ps.execute();
		ps.close();
	}

	@Override
	public Receituario buscaReceituario(Receituario re) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT re.id AS idReceituario, re.prescricao AS prescricaoReceituario, ");
		sql.append("co.id AS idConsulta, co.paciente AS pacienteConsulta, co.medico AS medicoConsulta, co.clinica AS clinicaConsulta, co.data AS dataConsulta, co.hora AS horaConsulta, co.observacao ");
		sql.append("FROM receituario re INNER JOIN consulta co ");
		sql.append("ON re.idConsulta = co.id ");
		sql.append("WHERE re.id = ?");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, re.getId());
		ResultSet rs = ps.executeQuery();
		int cont = 0;
		if (rs.next()) {
			Consulta co = new Consulta();
			co.setId(rs.getInt("idConsulta"));
			
			re.setPrescricao(rs.getString("prescricaoReceituario"));
			re.setConsultaId(co);
			cont++;
			}
		
		if (cont == 0) {
			re = new Receituario();
			Consulta co = new Consulta();
			re.setConsultaId(co);
			}
		rs.close();
		ps.close();
		return re;
	}

	@Override
	public List<Receituario> buscaReceituarios() throws SQLException {
		List<Receituario> listaReceituarios = new ArrayList<Receituario>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT re.id AS idReceituario, re.prescricao AS prescricaoReceituario, ");
		sql.append("co.id AS idConsulta, co.paciente AS pacienteConsulta, co.medico AS medicoConsulta, co.clinica AS clinicaConsulta, co.data AS dataConsulta, co.hora AS horaConsulta, co.observacao ");
		sql.append("FROM receituario re INNER JOIN consulta co ");
		sql.append("ON re.idConsulta = co.id");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Consulta co = new Consulta();
			co.setId(rs.getInt("idConsulta"));
			
			
			Receituario re = new Receituario();
			re.setId(rs.getInt("idReceituario"));		
			re.setConsultaId(co);
			re.setPrescricao(rs.getString("prescricaoReceituario"));
		
			listaReceituarios.add(re);
		}
		rs.close();
		ps.close();
		return listaReceituarios;
	}
}