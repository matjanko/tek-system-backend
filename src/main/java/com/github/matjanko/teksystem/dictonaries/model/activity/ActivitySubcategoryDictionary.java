package com.github.matjanko.teksystem.dictonaries.model.activity;

import com.github.matjanko.teksystem.dictonaries.model.Dictionary;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "V_DICT_ACTIVITY_SUBCATEGORY")
@Getter
public class ActivitySubcategoryDictionary extends Dictionary {

    @Column(name = "ACTIVITY_CATEGORY_ID")
    private Long categoryId;
}
