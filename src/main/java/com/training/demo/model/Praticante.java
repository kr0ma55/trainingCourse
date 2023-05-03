package com.training.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="PRATICANTE")
public class Praticante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;
    @Column(name="NICK_NAME")
    private String nickName;
    @Column(name="COLORE")
    private String colore;



}


