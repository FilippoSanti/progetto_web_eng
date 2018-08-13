package model;

public class Notification {

    private int id_notifica, id_utente, id_azienda;
    private String testo;

    public Notification() {
        this.id_azienda = 0;
        this.id_notifica = 0;
        this.id_utente = 0;
        this.testo = "";
    }

    public Notification(int id_notifica, int id_utente, int id_azienda, String testo) {
        this.id_notifica = id_notifica;
        this.id_utente = id_utente;
        this.id_azienda = id_azienda;
        this.testo = testo;
    }


    public int getId_notifica() {
        return id_notifica;
    }

    public void setId_notifica(int id_notifica) {
        this.id_notifica = id_notifica;
    }

    public int getId_utente() {
        return id_utente;
    }

    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }

    public int getId_azienda() {
        return id_azienda;
    }

    public void setId_azienda(int id_azienda) {
        this.id_azienda = id_azienda;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }
}