package com.github.matjanko.teksystem.reports.tasks.model.spec;

import com.github.matjanko.teksystem.reports.tasks.model.EmployeeTask;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class EmployeeTaskWithProjectName implements Specification<EmployeeTask> {

    private final String projectName;

    @Override
    public Predicate toPredicate(Root<EmployeeTask> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (projectName == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.equal(root.get("projectName"), this.projectName);
    }
}
