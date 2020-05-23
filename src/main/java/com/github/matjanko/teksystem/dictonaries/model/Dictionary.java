package com.github.matjanko.teksystem.dictonaries.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
public abstract class Dictionary {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

}
