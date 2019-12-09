package model_candidato;

import model_partido.Partido;

public class Candidato {
    private int idcandidato;
    private String nome_candidato;
    private int numero;
    private Partido partido;

    public Candidato() {
    }

    public Candidato(int idcandidato) {
        this.idcandidato = idcandidato;
    }

    public Candidato(int idcandidato, String nome_candidato, int numero, Partido partido) {
        this.idcandidato = idcandidato;
        this.nome_candidato = nome_candidato;
        this.numero = numero;
        this.partido = partido;

    }

    public int getIdcandidato() {
        return idcandidato;
    }

    public void setIdcandidato(int idcandidato) {
        this.idcandidato = idcandidato;
    }

    public String getNome_candidato() {
        return nome_candidato;
    }

    public void setNome_candidato(String nome_candidato) {
        this.nome_candidato = nome_candidato;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Partido getPartido() {
        return partido;
    }
    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public String toString() {
        return "nome_candidato='" + getNome_candidato() + '\'' +
                ", numero=" + getNumero()+
                ", partido=" + partido.getNome();
    }
}
