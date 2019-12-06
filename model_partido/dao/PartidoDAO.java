package model_partido.dao;

import connection.ConnectionFactory;
import model_partido.Partido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidoDAO {
    private Connection con = null;
    public PartidoDAO(){con = ConnectionFactory.getConnection();
    }
    public boolean save_partido(Partido p){
        String sql = "INSERT into partido(idpartido, nomepartido) VALUES(?, ?);";
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getIdpartido());
            stmt.setString(2, p.getNome());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Partido> findAll(){
        String sql = "select * from partido";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Partido> part = new ArrayList<>();

        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Partido p = new Partido();
                p.setIdpartido(rs.getInt("idpartido"));
                p.setNome(rs.getString("nomepartido"));
                part.add(p);
            }

        }catch (SQLException ex){
            System.err.println("Erro " + ex);
        }
        return part;
    }
}
