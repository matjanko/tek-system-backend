package com.github.matjanko.teksystem.dictonaries.model.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityCategoryDictionaryRepository extends JpaRepository<ActivityCategoryDictionary, Long> {

}
