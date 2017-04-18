package com.example.btis.viewpager22.PerfilUsuari;

/**
 * Created by BTIS on 24/03/2017.
 */

/*
Classe corresponent als events guardats al perfil d'usuari
 */

public class Pendent {

    private int escutLocal;
    private int escutVisitant;
    private String nomLocal;
    private String nomVisitant;
    private String dia;
    private String hora;

    public Pendent(int escutLocal, int escutVisitant, String nomLocal, String nomVisitant, String dia, String hora) {

        this.escutLocal = escutLocal;
        this.escutVisitant = escutVisitant;
        this.nomLocal = nomLocal;
        this.nomVisitant = nomVisitant;
        this.dia = dia;
        this.hora = hora;
    }

    public String getHora() {
        return hora;
    }

    public String getDia() {
        return dia;
    }

    public int getEscutLocal() {
        return escutLocal;
    }

    public int getEscutVisitant() {
        return escutVisitant;
    }

    public String getNomLocal() {
        return nomLocal;
    }

    public String getNomVisitant() {
        return nomVisitant;
    }
}
