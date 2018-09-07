package model;

public class Internship {

    private int iternship_id, azienda_id;

    private boolean  Company_headquarters, Remote_connection , refound_of_expenses, company_refactory, training_aid, nothing;

    private String nome, dettagli, luogo, mesi, orari, ore, meseInziale, meseFinale, obiettivi, modalita, rimborsi_spese_facilitazioni_previste, settore;




    public String getDettagli() {
        return dettagli;
    }


    public String getNome() {
        return nome;
    }

    public void setDettagli(String dettagli) {
        this.dettagli = dettagli;
    }

    public String getSettore() {
        return settore;
    }

    public void setSettore(String settore) {
        this.settore = settore;
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

    public Internship()
    {
        this.iternship_id = 0;
        this.azienda_id = 0;
        this.nome = "";
        this.dettagli = "";
        this.luogo = "";
        this.mesi = "";
        this.orari = "";
        this.ore = ore;
        this.meseInziale = "";
        this.meseFinale = "";
        this.obiettivi = "";
        this.modalita = "";
        this.rimborsi_spese_facilitazioni_previste = "";
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

    public boolean isCompany_headquarters() {
        return Company_headquarters;
    }

    public void setCompany_headquarters(boolean company_headquarters) {
        Company_headquarters = company_headquarters;
    }

    public boolean isRemote_connection() {
        return Remote_connection;
    }

    public void setRemote_connection(boolean remote_connection) {
        Remote_connection = remote_connection;
    }

    public boolean isRefound_of_expenses() {
        return refound_of_expenses;
    }

    public void setRefound_of_expenses(boolean refound_of_expenses) {
        this.refound_of_expenses = refound_of_expenses;
    }

    public boolean isCompany_refactory() {
        return company_refactory;
    }

    public void setCompany_refactory(boolean company_refactory) {
        this.company_refactory = company_refactory;
    }

    public boolean isTraining_aid() {
        return training_aid;
    }

    public void setTraining_aid(boolean training_aid) {
        this.training_aid = training_aid;
    }

    public boolean isNothing() {
        return nothing;
    }

    public void setNothing(boolean nothing) {
        this.nothing = nothing;
    }

}