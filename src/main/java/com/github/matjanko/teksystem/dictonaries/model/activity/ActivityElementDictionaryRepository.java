package com.github.matjanko.teksystem.dictonaries.model.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityElementDictionaryRepository extends JpaRepository<ActivityElementDictionary, Long> {

    List<ActivityElementDictionary> findAllBySubcategoryId(Long subcategoryId);
}
