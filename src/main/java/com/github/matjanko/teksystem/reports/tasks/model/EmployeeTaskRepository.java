package com.github.matjanko.teksystem.reports.tasks.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTaskRepository extends JpaRepository<EmployeeTask, Long>, JpaSpecificationExecutor<EmployeeTask> {

}
