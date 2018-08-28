package model;

public class MyInternships {

    private int internship_id;
    private String company_name;
    private String internship_status;
    private String manage_internships;

    private String htmlcolor;

    public MyInternships(int internship_id, String company_name, String internship_status, String manage_internships) {
        this.internship_id = internship_id;
        this.company_name = company_name;
        this.internship_status = internship_status;
        this.manage_internships = manage_internships;
        this.htmlcolor = htmlcolor;
    }

    public String getHtmlcolor() {
        return htmlcolor;
    }

    public void setHtmlcolor(String htmlcolor) {
        this.htmlcolor = htmlcolor;
    }

    public MyInternships() {

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