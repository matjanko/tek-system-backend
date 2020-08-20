package com.github.matjanko.teksystem.dictonaries.model.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivitySubcategoryDictionaryRepository extends JpaRepository<ActivitySubcategoryDictionary, Long> {

    List<ActivitySubcategoryDictionary> findAllByCategoryId(Long categoryId);
}
