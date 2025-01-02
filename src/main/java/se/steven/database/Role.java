package se.steven.database;

import java.sql.Date;


public class Role {

    private Integer role_id;
    private String title;
    private String description;
    private double salary;
    private java.sql.Date creation_date;

    public Role(String title, String description, double salary, Date creation_date) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creation_date = creation_date;
    }

    public Role(Integer role_id, String title) {
        this.role_id = role_id;
        this.title = title;
    }

    public Role(Integer role_id, String title, String description, double salary, Date creationDate) {
        this.role_id = role_id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creation_date = creationDate;
    }


    public Role(String title) {
        this.title = title;
    }


    public Integer getRole_id() {

        return role_id;
    }

    public String getTitle() {

        return title;
    }

    public String getDescription() {

        return description;
    }

    public double getSalary() {

        return salary;
    }

    public java.sql.Date getCreation_date() {

        return creation_date;
    }


    public void setTitle(String title) {
        this.title = title;
    }
}