package com.github.matjanko.teksystem.dictonaries.model.project;

import com.github.matjanko.teksystem.dictonaries.model.Dictionary;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "V_DICT_PROJECT")
@Getter
public class ProjectDictionary extends Dictionary {

    @Column(name = "PROJECT_INDEX")
    private String index;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

}
