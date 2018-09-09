package model;

public class InternshipRequest {

    private int internship_request_id, azienda_id, internship_id, student_id;
    private boolean accettata;
    private String cfu, tutor_name, tutor_surname, tutor_email, attivita_svolta, valutazione;

    public String getValutazione() {
        return valutazione;
    }

    public void setValutazione(String valutazione) {
        this.valutazione = valutazione;
    }

    public String getAttivita_svolta() {

        return attivita_svolta;
    }

    public void setAttivita_svolta(String attivita_svolta) {
        this.attivita_svolta = attivita_svolta;
    }

    public InternshipRequest() {

    }

    public void setAzienda_id(int azienda_id) {
        this.azienda_id = azienda_id;
    }

    public void setAccettata(boolean accettata) {
        this.accettata = accettata;
    }

    public void setInternship_id(int internship_id) {
        this.internship_id = internship_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setInternship_request_id(int iternship_request_id) {
        this.internship_request_id = iternship_request_id;
    }

    public boolean isAccettata() {
        return accettata;
    }

    public int getAzienda_id() {
        return azienda_id;
    }

    public int getInternship_id() {
        return internship_id;
    }

    public int getInternship_request_id() {
        return internship_request_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getCfu() {
        return cfu;
    }

    public String getTutor_name() {
        return tutor_name;
    }

    public String getTutor_email() {
        return tutor_email;
    }

    public String getTutor_surname(){
        return tutor_surname;
    }

    public void setCfu(String cfu) {
        this.cfu = cfu;
    }

    public void setTutor_name(String tutor_name) {
        this.tutor_name = tutor_name;
    }

    public void setTutor_email(String tutor_email) {
        this.tutor_email = tutor_email;
    }

    public void setTutor_surname(String tutor_surname) {
        this.tutor_surname = tutor_surname;
    }

    public InternshipRequest(int iternship_request_id, int azienda_id, int internship_id, int student_id, boolean accettata, String cfu, String tutor_name, String tutor_surname, String tutor_email ){
        this.accettata = accettata;
        this.azienda_id = azienda_id;
        this.internship_request_id = internship_request_id;
        this.internship_id = internship_id;
        this.student_id = student_id;
        this.cfu = cfu;
        this.tutor_name = tutor_name;
        this.tutor_surname = tutor_surname;
        this.tutor_email = tutor_email;
   }
}