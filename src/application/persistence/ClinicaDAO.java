package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Clinica;

public class ClinicaDAO implements IClinicaDAO {
	private Connection con;
	
	public ClinicaDAO() throws ClassNotFoundException, SQLException {
		GenericDAO gDao = new GenericDAO ();
		con = gDao.getConnection();
	}

	@Override
	public void insereClinica(Clinica c) throws SQLException {
		String sql = "INSERT INTO clinica VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setString(3, c.getLogradouro());
		ps.setString(4, c.getNumEnd());
		ps.setString(5, c.getCep());
		ps.setString(6, c.getComplemento());
		ps.setString(7, c.getTelefone());
		ps.setString(8, c.getEmail());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizaClinica(Clinica c) throws SQLException {
		String sql = "UPDATE clinica SET nome= ?, logradouro= ?, numero= ?, cep= ?, complemento= ?, telefone= ?, email= ? WHERE id= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setString(3, c.getLogradouro());
		ps.setString(4, c.getNumEnd());
		ps.setString(5, c.getCep());
		ps.setString(6, c.getComplemento());
		ps.setString(7, c.getTelefone());
		ps.setString(8, c.getEmail());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiClinica(Clinica c) throws SQLException {
		String sql = "DELETE clinica WHERE id= ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getId());
		
		ps.execute();
		ps.close();		
	}

	@Override
	public Clinica consultaClinica(Clinica c) throws SQLException {
		String sql = "SELECT id, nome, logradouro, numero, cep, complemento, telefone, email FROM clinica WHERE id= ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getId());
		
		int count = 0;
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			c.setNome(rs.getString("nome"));
			c.setLogradouro(rs.getString("logradouro"));
			c.setNumEnd(rs.getString("numero"));
			c.setComplemento(rs.getString("complemento"));
			c.setCep(rs.getString("cep"));
			c.setTelefone(rs.getString("telefone"));
			c.setEmail(rs.getString("email"));
			count++;
		}
		
		if (count == 0) {
			c = new Clinica();
		}
		
		ps.close();
		ps.close();	
		return c;
	}

	@Override
	public List<Clinica> listaClinica() throws SQLException {
		String sql = "SELECT id, nome, logradouro, numero, cep, complemento, telefone, email FROM clinica";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Clinica> listaClinica = new ArrayList<Clinica>();
		
		while (rs.next()) {
			Clinica c = new Clinica ();
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setLogradouro(rs.getString("logradouro"));
			c.setNumEnd(rs.getString("numero"));
			c.setComplemento(rs.getString("complemento"));
			c.setCep(rs.getString("cep"));
			c.setTelefone(rs.getString("telefone"));
			c.setEmail(rs.getString("email"));
			
			listaClinica.add(c);	
		}
		
		rs.close();
		ps.close();
		
		return listaClinica;
	}

}