package com.example.jobapplication.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Jobs
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private String type;
    @Column(length = 500)
    @JsonProperty("description")
    private String description;
    @JsonProperty("location")
    private String location;
    @JsonProperty("salary")
    private String salary;
    @ManyToOne
    @JsonManagedReference
    private Company company;

    public Jobs(Long id, String title, String type, String description, String location, String salary,Company company) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.location = location;
        this.salary = salary;
        this.company=company;
    }
    public Jobs()
    {}

}
