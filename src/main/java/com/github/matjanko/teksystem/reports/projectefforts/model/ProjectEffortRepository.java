package com.github.matjanko.teksystem.reports.projectefforts.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectEffortRepository extends JpaRepository<ProjectEffort, Long> {

}
