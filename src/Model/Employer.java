package Model;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;


public class Employer extends Customer
{
    private String jobTitle;
    private String jobDescription;
    private String company;
    private Calendar calendar;
    private java.util.Date date;
    private java.sql.Date dateSql;
    private int totalFees;

    public Employer(){}
    
    public Employer(String jobTitle, String jobDescription, String company, Calendar calendar, java.util.Date date,
            java.sql.Date dateSql, String email, String password, String type, String firstName, String lastName, int id,int totalfees) {
        super(email, password, type, firstName, lastName,id);
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.company = company;
        this.calendar = calendar;
        this.date = date;
        this.dateSql = dateSql;
        this.totalFees = totalFees;
    }
    
    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return this.jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public java.util.Date getDate() {
        return this.date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public java.sql.Date getDateSql() {
        return this.dateSql;
    }

    public void setDateSql(java.sql.Date dateSql) {
        this.dateSql = dateSql;
    }
    
    @Override
    public int getId() {
        return this.id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(int totalFees) {
        this.totalFees = totalFees;
    }
    

    @Override
    public String toString() {
        return "{" +
            " jobTitle='" + getJobTitle() + "'" +
            ", jobDescription='" + getJobDescription() + "'" +
            ", company='" + getCompany() + "'" +
            ", calendar='" + getCalendar() + "'" +
            ", date='" + getDate() + "'" +
            ", dateSql='" + getDateSql() + "'" +
            "}";
    }
}
