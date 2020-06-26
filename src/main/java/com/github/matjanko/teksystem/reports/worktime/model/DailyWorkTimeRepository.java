package com.github.matjanko.teksystem.reports.worktime.model;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface DailyWorkTimeRepository extends JpaRepository<DailyWorkTime, Long> {

    List<DailyWorkTime> findAllByYearAndMonthAndEmployeeId(
            @NotBlank String year, @NotBlank String month, @NotNull Long employeeId);
}
