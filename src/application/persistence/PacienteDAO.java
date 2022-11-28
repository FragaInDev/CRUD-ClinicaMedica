package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Paciente;

public class PacienteDAO implements IPacienteDAO {

    private Connection c;

    public PacienteDAO() throws ClassNotFoundException, SQLException{
        GenericDAO gDao = new GenericDAO();
        c = gDao.getConnection();
    }

    @Override
    public void inserePaciente(Paciente p) throws SQLException {
        String sql = "INSERT INTO paciente VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, p.getCpf());
        ps.setString(2, p.getNome());
        ps.setString(3, p.getLogradouro());
        ps.setString(4, p.getNumero());
        ps.setString(5, p.getCep());
        ps.setString(6, p.getComplemento());
        ps.setString(7, p.getTelefone());
        ps.setString(8, p.getTipoSanguineo());
        ps.setString(9, p.getEmail());

        ps.execute();
        ps.close();

        
    }

    @Override
    public void atualizaPaciente(Paciente p) throws SQLException {
        String sql = "UPDATE paciente set nome = ?, logradouro = ?, numero = ?, cep = ?, complemento = ?, telefone = ?, tipoSanguineo = ?, email = ? WHERE cpf = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        
        ps.setString(1, p.getNome());
        ps.setString(2, p.getLogradouro());
        ps.setString(3, p.getNumero());
        ps.setString(4, p.getCep());
        ps.setString(5, p.getComplemento());
        ps.setString(6, p.getTelefone());
        ps.setString(7, p.getTipoSanguineo());
        ps.setString(8, p.getEmail());
        ps.setString(9, p.getCpf());

        ps.execute();
        ps.close();
    }

    @Override
    public void excluiPaciente(Paciente p) throws SQLException {
        String sql = "DELETE paciente WHERE cpf = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, p.getCpf());

        ps.execute();
        ps.close();
        
    }

    @Override
    public Paciente consultaPaciente(Paciente p) throws SQLException {
        String sql = "SELECT cpf, nome, logradouro, numero, cep, complemento, telefone, tipoSanguineo, email FROM paciente WHERE cpf = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, p.getCpf());

        int cont = 0;
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            p.setNome(rs.getString("nome"));
            p.setLogradouro(rs.getString("logradouro"));
            p.setNumero(rs.getString("numero"));
            p.setCep(rs.getString("cep"));
            p.setComplemento(rs.getString("complemento"));
            p.setTelefone(rs.getString("telefone"));
            p.setTipoSanguineo(rs.getString("tipoSanguineo"));
            p.setEmail(rs.getString("email"));

            cont++;

        }

        if (cont == 0){
            p = new Paciente();
        }

        rs.close();
        ps.close();

        return p;
    }


    @Override
    public List<Paciente> listaPaciente() throws SQLException {
        String sql = "SELECT cpf, nome, logradouro, numero, cep, complemento, telefone, tipoSanguineo, email FROM paciente";

        PreparedStatement ps = c.prepareStatement(sql);
       
        ResultSet rs = ps.executeQuery();

        List<Paciente> listaPaciente = new ArrayList<Paciente>();

        while(rs.next()){
            Paciente p = new Paciente();
            p.setCpf(rs.getString("cpf"));
            p.setNome(rs.getString("nome"));
            p.setLogradouro(rs.getString("logradouro"));
            p.setNumero(rs.getString("numero"));
            p.setCep(rs.getString("cep"));
            p.setComplemento(rs.getString("complemento"));
            p.setTelefone(rs.getString("telefone"));
            p.setTipoSanguineo(rs.getString("tipoSanguineo"));
            p.setEmail(rs.getString("email"));

            listaPaciente.add(p);

        }

        rs.close();
        ps.close();

        return listaPaciente;
    }
    
}