package model;

public class AgreementDocument {

    public AgreementDocument() {

    }

    public String getNome_azienda() {
        return nome_azienda;
    }

    public void setNome_azienda(String nome_azienda) {
        this.nome_azienda = nome_azienda;
    }

    public String getSede_legale() {
        return sede_legale;
    }

    public void setSede_legale(String sede_legale) {
        this.sede_legale = sede_legale;
    }

    public String getProv_sede() {
        return prov_sede;
    }

    public void setProv_sede(String prov_sede) {
        this.prov_sede = prov_sede;
    }

    public String getCf_piva_azienda() {
        return cf_piva_azienda;
    }

    public void setCf_piva_azienda(String cf_piva_azienda) {
        this.cf_piva_azienda = cf_piva_azienda;
    }

    public String getNome_rapp() {
        return nome_rapp;
    }

    public void setNome_rapp(String nome_rapp) {
        this.nome_rapp = nome_rapp;
    }



    public AgreementDocument(String nome_azienda, String sede_legale, String prov_sede, String cf_piva_azienda, String cognome_rapp, String nome_rapp) {

        this.nome_azienda = nome_azienda;
        this.sede_legale = sede_legale;
        this.prov_sede = prov_sede;
        this.cf_piva_azienda = cf_piva_azienda;
        this.cognome_rapp = cognome_rapp;
        this.nome_rapp = nome_rapp;
    }

    public String getForo_comp() {
        return foro_comp;
    }

    public void setForo_comp(String foro_comp) {
        this.foro_comp = foro_comp;
    }

    private String nome_azienda, sede_legale, prov_sede, cf_piva_azienda, cognome_rapp, nome_rapp, foro_comp;

}