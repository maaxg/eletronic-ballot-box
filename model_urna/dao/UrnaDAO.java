package model_urna.dao;

import connection.ConnectionFactory;
import model_urna.Urna;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UrnaDAO {
    private Connection con = null;
    public UrnaDAO(){con = ConnectionFactory.getConnection();
    }

    public boolean save(Urna u){
        String sql = "INSERT INTO urna(cpf, numero) VALUES(?, ?);";
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getEleitor().getCpf());
            stmt.setInt(2, u.getNumero());
            stmt.executeUpdate();
            return true;
        }catch (SQLException ex){
            System.err.println("Erro " + ex.getMessage());
            return false;
        }

    }
    public boolean checkCPF(String cpf){
        String sql = "Select * from urna where cpf = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        try{
            stmt = con.prepareStatement(sql);

            stmt.setString(1, cpf);

            rs = stmt.executeQuery();

            if(rs.next()){
                check = true;
                JOptionPane.showMessageDialog(null,"Um voto com esse cpf já foi feito");
            }else{
                JOptionPane.showMessageDialog(null,"Voto Realizado com sucesso");
            }

        }catch (SQLException ex){
            System.err.println("Erro " + ex.getMessage());
        }
        return check;
    }

}
