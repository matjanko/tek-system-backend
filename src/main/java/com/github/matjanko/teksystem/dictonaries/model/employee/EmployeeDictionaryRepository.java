package com.github.matjanko.teksystem.dictonaries.model.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDictionaryRepository extends JpaRepository<EmployeeDictionary, Long> {

}
