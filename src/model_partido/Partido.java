package model_partido;

public class Partido {
    private int idpartido;
    private String nome;

    public Partido() { }

    public Partido(int idpartido, String nome) {
        this.idpartido = idpartido;
        this.nome = nome;
    }

    public int getIdpartido() {
        return idpartido;
    }

    public void setIdpartido(int idpartido) {
        this.idpartido = idpartido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
