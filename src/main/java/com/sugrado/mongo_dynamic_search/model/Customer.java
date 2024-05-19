package com.sugrado.mongo_dynamic_search.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {
    @Id
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String homePhone;
    private String nationalityId;
    private LocalDate birthDate;
    private String motherName;
    private String fatherName;
    private String gender;
    private String email;
    private String mobilePhone;
}
