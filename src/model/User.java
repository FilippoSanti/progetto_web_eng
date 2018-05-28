package model;

public class User {
    String nome, cognome, date, provincia, provincia_n, residenza, citta, corso, email, handicap, tel;
    int cap;

    public User() {

        this.nome        = "";
        this.cognome     = "";
        this.date        = "";
        this.provincia   = "";
        this.provincia_n = "";
        this.residenza   = "";
        this.citta       = "";
        this.corso       = "";
        this.email       = "";
        this.handicap    = "";
        this.tel         = "";
        this.cap         = 0;

    }

    public User(String n, String c, String d, String p, String pn,
                String r, String ct, String cr, String em, String hc, String tel, int cap) {

        this.nome        = n;
        this.cognome     = c;
        this.date        = d;
        this.provincia   = p;
        this.provincia_n = pn;
        this.residenza   = r;
        this.citta       = ct;
        this.corso       = cr;
        this.email       = em;
        this.handicap    = hc;
        this.tel         = tel;
        this.cap         = cap;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia_n() {
        return provincia_n;
    }

    public void setProvincia_n(String provincia_n) {
        this.provincia_n = provincia_n;
    }

    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCorso() {
        return corso;
    }

    public void setCorso(String corso) {
        this.corso = corso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHandicap() {
        return handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

}