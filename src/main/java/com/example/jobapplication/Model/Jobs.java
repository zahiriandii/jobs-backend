package com.example.jobapplication.Model;

import jakarta.persistence.*;

@Entity
public class Jobs
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type;
    private String description;
    private String location;
    private String salary;
    @OneToOne
    private Company company;

    public Jobs(Long id, String title, String type, String description, String location, String salary, Company company) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.location = location;
        this.salary = salary;
        this.company = company;
    }
    public Jobs()
    {}

}
