package model;

public class Internship {

    private int iternship_id, azienda_id;
    private String nome,  dettagli, luogo,mesi, orari, ore, meseInziale, meseFinale, obiettivi, modalita, rimborsi_spese_facilitazioni_previste;

    public String getDettagli() {
        return dettagli;
    }

    public String getNome() {
        return nome;
    }

    public void setDettagli(String dettagli) {
        this.dettagli = dettagli;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIternship_id() {
        return iternship_id;
    }

    public void setIternship_id(int iternship_id) {
        this.iternship_id = iternship_id;
    }

    public int getAzienda_id() { return azienda_id;}

    public void setAzienda_id(int azienda_id) {
        this.azienda_id = azienda_id;
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

    public void setMeseFinale(String meseFinale) {
        this.meseFinale = meseFinale;
    }

    public void setMeseInziale(String meseInziale) {
        this.meseInziale = meseInziale;
    }

    public void setMesi(String mesi) {
        this.mesi = mesi;
    }

    public String getMesi() {
        return mesi;
    }

    public String getMeseInziale()
    {
        return meseInziale;
    }

    public String getMeseFinale() {
        return meseFinale;
    }

    public void setRimborsi_spese_facilitazioni_previste(String rimborsi_spese_facilitazioni_previste) {
        this.rimborsi_spese_facilitazioni_previste = rimborsi_spese_facilitazioni_previste;
    }

    public Internship(int iternship_id, int azienda_id,String  nome, String dettagli, String luogo, String mesi, String orari, String ore, String meseInziale, String meseFinale, String obiettivi, String modalita, String rimborsi_spese_facilitazioni_previste) {
        this.iternship_id = iternship_id;
        this.azienda_id = azienda_id;
        this.nome = nome;
        this.dettagli = dettagli;
        this.luogo = luogo;
        this.mesi = mesi;
        this.orari = orari;
        this.ore = ore;
        this.meseInziale = meseInziale;
        this.meseFinale = meseFinale;
        this.obiettivi = obiettivi;
        this.modalita = modalita;
        this.rimborsi_spese_facilitazioni_previste = rimborsi_spese_facilitazioni_previste;
    }
}