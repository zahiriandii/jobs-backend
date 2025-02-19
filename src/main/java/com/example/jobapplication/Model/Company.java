package com.example.jobapplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("contactEmail")
    private String contactEmail;
    @JsonProperty("contactPhone")
    private String contactPhone;

    public Company(Long id, String name, String description, String contactEmail, String contactPhone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public Company()
    {}

}
