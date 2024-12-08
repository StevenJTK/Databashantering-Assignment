package se.steven.database;

import java.util.Date;

public class Role {

    private Integer role_id;
    private String title;
    private String description;
    private double salary;
    private java.sql.Date creation_date = java.sql.Date.valueOf("1998-04-02");


    // Constructors

    public Role(Integer role_id, String title, String description, double salary, java.sql.Date creation_date) {
        this.role_id = role_id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creation_date = creation_date;
    }


    public Role(String title, String description, double salary, java.sql.Date creation_date) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creation_date = creation_date;
    }

    public Role() {

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









}