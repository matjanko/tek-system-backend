package com.github.matjanko.teksystem.dictonaries.model.employee;

import com.github.matjanko.teksystem.dictonaries.model.Dictionary;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "V_DICT_EMPLOYEE")
@Getter
public class EmployeeDictionary extends Dictionary {

}
