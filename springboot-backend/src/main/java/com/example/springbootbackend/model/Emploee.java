package com.example.springbootbackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(name="emploee")
public class Emploee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

//  @Column(name = "f_Name" ,nullable = false)
  private String fName;

//  @Column(name = "l_Name",nullable = false)
  private String lName;
}
