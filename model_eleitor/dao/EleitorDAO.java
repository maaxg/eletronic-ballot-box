package model_eleitor.dao;


import connection.ConnectionFactory;
import model_eleitor.Eleitor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EleitorDAO {
    private Connection con = null;
    private ConnectionFactory cf = new ConnectionFactory();
    public EleitorDAO(){
        con = ConnectionFactory.getConnection();
    }
    public boolean save(Eleitor e){
        String sql = "INSERT INTO eleitor(nome, cpf, cep, bairro, rua, numero) VALUES(?,?,?,?,?,?);";
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getCpf());
            stmt.setString(3, e.getCep());
            stmt.setString(4, e.getBairro());
            stmt.setString(5, e.getRua());
            stmt.setInt(6, e.getNumero());
            stmt.executeUpdate();
            return true;
        }catch (SQLException ex){
            System.err.println("Erro " + ex);
            return false;
        }
    }
    public boolean checkCpf(String cpf){
        String sql = "SELECT * FROM eleitor WHERE cpf = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);

            rs = stmt.executeQuery();
            if(rs.next()){
                check = true;
                JOptionPane.showMessageDialog(null,"Everything is fine");
            }else{
                JOptionPane.showMessageDialog(null, "CPF já cadastrado");
            }

        }catch (SQLException e){
            System.err.println("Erro " + e.getErrorCode());
        }
        return check;
    }
}
