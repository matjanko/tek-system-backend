package com.github.matjanko.teksystem.reports.worktime.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Repository
public interface MonthlyWorkTimeRepository extends JpaRepository<MonthlyWorkTime, Long> {

    List<MonthlyWorkTime> findAllByYearAndMonth(@NotBlank String year, @NotBlank String month);

}
