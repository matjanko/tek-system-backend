package com.github.matjanko.teksystem.dictonaries.model.projectstage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectStageDictionaryRepository extends JpaRepository<ProjectStageDictionary, Long> {

}
