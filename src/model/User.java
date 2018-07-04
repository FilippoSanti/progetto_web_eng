package model;

import java.util.Date;

public class User {
    String nome, cognome, provincia, provincia_n, residenza, citta, corso, email, tel, userType ;
    Date date;
    int cap;
    int id;
    boolean handicap;


    public User() {

        this.nome        = "";
        this.cognome     = "";
        this.date        = null;
        this.provincia   = "";
        this.provincia_n = "";
        this.residenza   = "";
        this.citta       = "";
        this.corso       = "";
        this.email       = "";
        this.handicap    = false;
        this.tel         = "";
        this.userType    = "";
        this.cap         = 0;
        this.id          = 0;

    }

    public User(String n, String c, Date d, String p, String pn,
                String r, String ct, String cr, String em, boolean hc, String tel, String userType, int cap, int id) {

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
        this.userType    = userType;
        this.cap         = cap;
        this.id          = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public boolean getHandicap() {
        return handicap;
    }

    public void setHandicap(boolean handicap) {
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

    public String getUserType () {return this.userType; }

    public void setUserType (String userType) { this.userType = userType; }

}