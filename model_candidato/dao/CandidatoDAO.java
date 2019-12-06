package model_candidato.dao;

import connection.ConnectionFactory;
import model_candidato.Candidato;
import model_partido.Partido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDAO {
    private Connection con = null;

    public CandidatoDAO(){con = ConnectionFactory.getConnection(); }

    public boolean save_candidato(Candidato c){
        String sql = "INSERT into candidato(idcandidato, nome, numero, idpartido, nome_partido) VALUES(?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, c.getIdcandidato());
            stmt.setString(2, c.getNome_candidato());
            stmt.setInt(3, c.getNumero());
            stmt.setInt(4, c.getPartido().getIdpartido());
            stmt.setString(5, c.getPartido().getNome());
            stmt.executeUpdate();
            return true;
        }catch (SQLException ex){
            System.err.println("Erro " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Candidato> findAll(){
        String sql = "SELECT * from candidato;";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Candidato> cand = new ArrayList<>();

        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Candidato c = new Candidato();

                c.setNome_candidato(rs.getString("nome"));
                c.setNumero(rs.getInt("numero"));
                Partido p = new Partido();
                p.setNome(rs.getString("nome_partido"));
                c.setPartido(p);
                cand.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cand;
    }

}
