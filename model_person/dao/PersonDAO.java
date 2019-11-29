package model_person.dao;

import connection.ConnectionFactory;
import model_person.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDAO {
    private Connection con = null;
    ConnectionFactory cf = new ConnectionFactory();

    public PersonDAO(){con = ConnectionFactory.getConnection(); }

    public boolean save(Person p){
        String sql = "INSERT into person(id, nome, usuario, senha, cpf, data_nasc) VALUES(?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getLogin());
            stmt.setString(4,p.getSenha());
            stmt.setString(5, p.getCpf());
            stmt.setString(6, p.getData_nasc());
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Erro " + e);
            return false;
        }
    }




}
