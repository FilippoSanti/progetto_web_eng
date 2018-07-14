package model;

public class Internship_request {

    private int internship_request_id, azienda_id, internship_id, student_id;
    private boolean accettata;

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

   public Internship_request(int iternship_request_id, int azienda_id, int internship_id, int student_id, boolean accettata ){
        this.accettata = accettata;
        this.azienda_id = azienda_id;
        this.internship_request_id = internship_request_id;
        this.internship_id = internship_id;
        this.student_id = student_id;
   }
}