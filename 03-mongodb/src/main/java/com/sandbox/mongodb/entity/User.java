package com.sandbox.mongodb.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document
public class User {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HashMap getDetail() {
        return detail;
    }

    public void setDetail(HashMap detail) {
        this.detail = detail;
    }

    @JsonProperty("Name")
    private String name;
    @JsonProperty("LastName")
    private String lastName;
    private HashMap detail;
}
