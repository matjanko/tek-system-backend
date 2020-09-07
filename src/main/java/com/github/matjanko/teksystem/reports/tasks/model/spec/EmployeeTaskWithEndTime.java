package com.github.matjanko.teksystem.reports.tasks.model.spec;

import com.github.matjanko.teksystem.reports.tasks.model.EmployeeTask;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class EmployeeTaskWithEndTime implements Specification<EmployeeTask> {

    private final String endTime;

    @Override
    public Predicate toPredicate(Root<EmployeeTask> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (endTime == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.lessThanOrEqualTo(root.get("endTime"), LocalDate.parse(
                this.endTime, DateTimeFormatter.ISO_DATE).atStartOfDay());
    }
}
