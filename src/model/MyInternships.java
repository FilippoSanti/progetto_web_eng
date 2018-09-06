package model;

public class MyInternships {

    private int internship_id;
    private String internship_name;
    private String company_name;
    private String internship_status;
    private String manage_internships;

    public String getInternship_name() {
        return internship_name;
    }

    public void setInternship_name(String internship_name) {
        this.internship_name = internship_name;
    }

    private String htmlcolor;

    public MyInternships(int internship_id, String company_name, String internship_status, String manage_internships, String htmlcolor,
                         String internship_name) {
        this.internship_id = internship_id;
        this.company_name = company_name;
        this.internship_status = internship_status;
        this.manage_internships = manage_internships;
        this.htmlcolor = htmlcolor;
        this.internship_name = internship_name;
    }

    public MyInternships() {

    }

    public String getHtmlcolor() {
        return htmlcolor;
    }

    public void setHtmlcolor(String htmlcolor) {
        this.htmlcolor = htmlcolor;
    }

    public int getInternship_id() {
        return internship_id;
    }

    public void setInternship_id(int internship_id) {
        this.internship_id = internship_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getInternship_status() {
        return internship_status;
    }

    public void setInternship_status(String internship_status) {
        this.internship_status = internship_status;
    }

    public String getManage_internships() {
        return manage_internships;
    }

    public void setManage_internships(String manage_internships) {
        this.manage_internships = manage_internships;
    }
}