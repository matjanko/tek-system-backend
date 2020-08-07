package com.github.matjanko.teksystem.dictonaries.model.activity;

import com.github.matjanko.teksystem.dictonaries.model.Dictionary;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "V_DICT_ACTIVITY_CATEGORY")
@Getter
public class ActivityCategoryDictionary extends Dictionary {

}
