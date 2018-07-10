package model;

public class Internship {

    private int iternship_id;
    private String luogo, orari, ore, obiettivi, modalita, rimborsi_spese_facilitazioni_previste;

    public int getIternship_id() {
        return iternship_id;
    }

    public void setIternship_id(int iternship_id) {
        this.iternship_id = iternship_id;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getOrari() {
        return orari;
    }

    public void setOrari(String orari) {
        this.orari = orari;
    }

    public String getOre() {
        return ore;
    }

    public void setOre(String ore) {
        this.ore = ore;
    }

    public String getObiettivi() {
        return obiettivi;
    }

    public void setObiettivi(String obiettivi) {
        this.obiettivi = obiettivi;
    }

    public String getModalita() {
        return modalita;
    }

    public void setModalita(String modalita) {
        this.modalita = modalita;
    }

    public String getRimborsi_spese_facilitazioni_previste() {
        return rimborsi_spese_facilitazioni_previste;
    }

    public void setRimborsi_spese_facilitazioni_previste(String rimborsi_spese_facilitazioni_previste) {
        this.rimborsi_spese_facilitazioni_previste = rimborsi_spese_facilitazioni_previste;
    }

    public Internship(int iternship_id, String luogo, String orari, String ore, String obiettivi, String modalita, String rimborsi_spese_facilitazioni_previste) {
        this.iternship_id = iternship_id;
        this.luogo = luogo;
        this.orari = orari;
        this.ore = ore;
        this.obiettivi = obiettivi;
        this.modalita = modalita;
        this.rimborsi_spese_facilitazioni_previste = rimborsi_spese_facilitazioni_previste;
    }
}