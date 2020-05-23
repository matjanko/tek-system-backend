package com.github.matjanko.teksystem.dictonaries.model.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDictionaryRepository extends JpaRepository<CustomerDictionary, Long> {

}
