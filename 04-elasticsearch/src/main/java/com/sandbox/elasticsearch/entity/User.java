package com.sandbox.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
@Document(indexName = "users",type="User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    public String id;

    @Field(name = "name",type = FieldType.Text)
    public  String name;

    @Field(name = "lastName",type = FieldType.Text)
    public  String lastName;

    @Field(name = "address",type = FieldType.Text)
    public String address;

    @Field(name = "Birthdate",type = FieldType.Date)
    public Date Birthdate;
}

