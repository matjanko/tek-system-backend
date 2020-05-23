package com.github.matjanko.teksystem.dictonaries.model.projectstage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectStageRepository extends JpaRepository<ProjectStage, Long> {

}
