package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import application.model.Especialidade;

public class EspecialidadeDAO implements IEspecialidadeDAO{
	private Connection c;
	
    public EspecialidadeDAO() throws ClassNotFoundException, SQLException{
        GenericDAO gDao = new GenericDAO();
        c = gDao.getConnection();
    }

    @Override
    public void insereEspecialidade(Especialidade e) throws SQLException {
    	String sql = "INSERT INTO especialidade VALUES (?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, e.getId());
        ps.setString(2, e.getNomeEspecialidade());
        ps.execute();
        ps.close();
    }

    @Override
    public void atualizaEspecialidade(Especialidade e) throws SQLException {
    	String sql = "UPDATE especialidade set especialidade = ? WHERE id= ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, e.getNomeEspecialidade());
        ps.setInt(2, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void excluiEspecialidade(Especialidade e) throws SQLException {
    	String sql = "DELETE especialidade WHERE id= ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public Especialidade consultaEspecialidade(Especialidade e) throws SQLException {
    	String sql = "SELECT id, especialidade FROM especialidade WHERE id= ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, e.getId());
        int cont = 0;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            e.setNomeEspecialidade(rs.getString("especialidade"));
            cont++;
        }
        if (cont == 0){
            e = new Especialidade();
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<Especialidade> listaEspecialidade() throws SQLException {
    	String sql = "SELECT id, especialidade FROM especialidade";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Especialidade> listaEspecialidade = new ArrayList<Especialidade>();
        while(rs.next()){
            Especialidade e = new Especialidade();
            e.setId(rs.getInt("id"));
            e.setNomeEspecialidade(rs.getString("especialidade"));
            listaEspecialidade.add(e);
        }
        rs.close();
        ps.close();
        return listaEspecialidade;
    }
}