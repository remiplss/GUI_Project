import java.sql.*;
import java.util.Calendar;
import java.util.Date;


public class JobSeeker extends Customer
{

    private String firstName;
    private String lastName;
    private String phone;
    private String job;
    private String status;
    private Calendar calendar;
    private java.util.Date date;
    private java.sql.Date dateSql;

    

    //Constructor//
    public JobSeeker(){}
    /*public JobSeeker(String email, String password, String type,String firstName, String lastName,
     String phone, String job, String status, Calendar calendar, java.util.Date date, java.sql.Date dateSql) 
     {
        super(email,password,type);

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.job = job;
        this.status = status;
        this.calendar = calendar;
        this.date = date;
        this.dateSql = dateSql;
    }*/

    public JobSeeker(String phone, String job, String status, Calendar calendar, java.util.Date date, java.sql.Date dateSql, String email, String password, String type, String firstName, String lastName) {
        super(email, password, type, firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.job = job;
        this.status = status;
        this.calendar = calendar;
        this.date = date;
        this.dateSql = dateSql;
    }
    
    
    

/*
    //Getters/Setters//
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }*/

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    //toString()//
    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", phone='" + getPhone() + "'" +
            ", job='" + getJob() + "'" +
            ", status='" + getStatus() + "'" +
            ", calendar='" + getCalendar() + "'" +
            ", date='" + getDate() + "'" +
            ", dateSql='" + getDateSql() + "'" +
            "}";
    }
    
}
