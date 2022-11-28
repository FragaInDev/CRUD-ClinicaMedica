package application.persistence;
import java.sql.SQLException;
import java.util.List;

import application.model.Especialidade;
import application.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MedicoDAO implements IMedicoDAO{
	private Connection c;
    public MedicoDAO() throws ClassNotFoundException, SQLException{
        GenericDAO gDao = new GenericDAO();
        c = gDao.getConnection();
    }
    
    @Override
    public void insereMedico(Medico m) throws SQLException {

    	String sql = "INSERT INTO medico VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, m.getCrm());
        ps.setString(2, m.getNome());
        ps.setString(3, m.getLogradouro());
        ps.setString(4, m.getNumEnd());
        ps.setString(5, m.getCep());
        ps.setString(6, m.getComplemento());
        ps.setString(7, m.getTelefone());
        ps.setString(8, m.getEmail());
        ps.setObject(9, m.getEspecialidade());
        ps.execute();
        ps.close();
    }

    @Override
    public void atualizaMedico(Medico m) throws SQLException {
    	
    	String sql = "UPDATE medico set nome = ?, logradouro = ?, numero = ?, cep = ?, complemento = ?, telefone = ?, email = ? WHERE crm = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, m.getNome());
        ps.setString(2, m.getLogradouro());
        ps.setString(3, m.getNumEnd());
        ps.setString(4, m.getCep());
        ps.setString(5, m.getComplemento());
        ps.setString(6, m.getTelefone());
        ps.setString(7, m.getEmail());
        ps.setString(8, m.getCrm());
        ps.execute();
        ps.close();
    }

    @Override
    public void excluiMedico(Medico m) throws SQLException {
    	String sql = "DELETE medico WHERE crm = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, m.getCrm());
        ps.execute();
        ps.close();
    }

    @Override
    public Medico consultaMedico(Medico m) throws SQLException {
    	String sql = "SELECT crm, nome, logradouro, numero, cep, complemento, telefone, email FROM medico WHERE crm = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, m.getCrm());
        int cont = 0;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            m.setNome(rs.getString("nome"));
            m.setLogradouro(rs.getString("logradouro"));
            m.setNumEnd(rs.getString("numero"));
            m.setCep(rs.getString("cep"));
            m.setComplemento(rs.getString("complemento"));
            m.setTelefone(rs.getString("telefone"));
            m.setEmail(rs.getString("email"));
            cont++;
        }
        if (cont == 0){
            m = new Medico();
        }
        rs.close();
        ps.close();
        return m;
    }

    @Override
    public List<Medico> listaMedico() throws SQLException {
    	String sql = "SELECT crm, nome, logradouro, numero, cep, complemento, telefone, email FROM medico";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Medico> listaMedico = new ArrayList<Medico>();
        while(rs.next()){
            Medico m = new Medico();
            m.setCrm(rs.getString("crm"));
            m.setNome(rs.getString("nome"));
            m.setLogradouro(rs.getString("logradouro"));
            m.setNumEnd(rs.getString("numero"));
            m.setCep(rs.getString("cep"));
            m.setComplemento(rs.getString("complemento"));
            m.setTelefone(rs.getString("telefone"));
            m.setEmail(rs.getString("email"));
            listaMedico.add(m);
        }
        rs.close();
        ps.close();
        return listaMedico;
    }
}