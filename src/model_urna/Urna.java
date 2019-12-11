package model_urna;

import model_eleitor.Eleitor;

public class Urna {
    private Eleitor eleitor;
    private int numero;

    public Urna() {
    }

    public Urna(Eleitor eleitor, int numero) {
        this.eleitor = eleitor;
        this.numero = numero;
    }

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
