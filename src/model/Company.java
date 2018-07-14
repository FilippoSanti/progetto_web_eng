package model;

public class Company {

    private String ragione_sociale;
    private String indirizzo_sede_leg;
    private String cf_rappresentante;
    private String partita_iva_rap;
    private String nome_cognome_rap;
    private String telefono_tirocini;
    private String descrizione;
    private String email_tirocini;
    private String foro_competente;
    private String provincia;
    private String email_login;
    private String ripeti_pass;
    private String nome_cognome_tir;
    private int company_id;

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Company() {
        this.ragione_sociale = "";
        this.indirizzo_sede_leg = "";
        this.cf_rappresentante = "";
        this.partita_iva_rap = "";
        this.nome_cognome_rap = "";
        this.telefono_tirocini = "";
        this.email_tirocini = "";
        this.foro_competente = "";
        this.provincia = "";
        this.email_login = "";
        this.ripeti_pass = "";
        this.company_id = 0;
        this.nome_cognome_tir = "";
        this.descrizione = "";

    }
    public Company(String nome_cognome_tir, String ragione_sociale, String indirizzo_sede_leg, String cf_rappresentante, String partita_iva_rap, String nome_cognome_rap, String telefono_tirocini, String email_tirocini,
                   String foro_competente, String provincia, String email_login, int company_id, String descrizione) {
        this.nome_cognome_tir = nome_cognome_tir;
        this.ragione_sociale = ragione_sociale;
        this.indirizzo_sede_leg = indirizzo_sede_leg;
        this.cf_rappresentante = cf_rappresentante;
        this.partita_iva_rap = partita_iva_rap;
        this.nome_cognome_rap = nome_cognome_rap;
        this.telefono_tirocini = telefono_tirocini;
        this.email_tirocini = email_tirocini;
        this.foro_competente = foro_competente;
        this.provincia = provincia;
        this.email_login = email_login;
        this.ripeti_pass = ripeti_pass;
        this.company_id = company_id;
        this.descrizione = descrizione;
    }

    public String getNome_cognome_tir() {
        return nome_cognome_tir;
    }

    public void setNome_cognome_tir(String nome_cognome_tir) {
        this.nome_cognome_tir = nome_cognome_tir;
    }

    public String getRagione_sociale() {
        return ragione_sociale;
    }

    public void setRagione_sociale(String ragione_sociale) {
        this.ragione_sociale = ragione_sociale;
    }

    public String getIndirizzo_sede_leg() {
        return indirizzo_sede_leg;
    }

    public void setIndirizzo_sede_leg(String indirizzo_sede_leg) {
        this.indirizzo_sede_leg = indirizzo_sede_leg;
    }

    public String getCf_rappresentante() {
        return cf_rappresentante;
    }

    public void setCf_rappresentante(String cf_rappresentante) {
        this.cf_rappresentante = cf_rappresentante;
    }

    public String getPartita_iva_rap() {
        return partita_iva_rap;
    }

    public void setPartita_iva_rap(String partita_iva_rap) {
        this.partita_iva_rap = partita_iva_rap;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getNome_cognome_rap() {
        return nome_cognome_rap;
    }

    public void setNome_cognome_rap(String nome_cognome_rap) {
        this.nome_cognome_rap = nome_cognome_rap;
    }

    public String getTelefono_tirocini() {
        return telefono_tirocini;
    }

    public void setTelefono_tirocini(String telefono_tirocini) {
        this.telefono_tirocini = telefono_tirocini;
    }

    public String getEmail_tirocini() {
        return email_tirocini;
    }

    public void setEmail_tirocini(String email_tirocini) {
        this.email_tirocini = email_tirocini;
    }

    public String getForo_competente() {
        return foro_competente;
    }

    public void setForo_competente(String foro_competente) {
        this.foro_competente = foro_competente;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEmail_login() {
        return email_login;
    }

    public void setEmail_login(String email_login) {
        this.email_login = email_login;
    }

    public String getRipeti_pass() {
        return ripeti_pass;
    }

    public void setRipeti_pass(String ripeti_pass) {
        this.ripeti_pass = ripeti_pass;
    }
}
