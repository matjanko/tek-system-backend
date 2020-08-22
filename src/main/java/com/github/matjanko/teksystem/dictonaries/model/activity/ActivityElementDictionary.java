package com.github.matjanko.teksystem.dictonaries.model.activity;

import com.github.matjanko.teksystem.dictonaries.model.Dictionary;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "V_DICT_ACTIVITY_ELEMENT")
@Getter
public class ActivityElementDictionary extends Dictionary {

    @Column(name = "ACTIVITY_SUBCATEGORY_ID")
    private Long subcategoryId;
}
