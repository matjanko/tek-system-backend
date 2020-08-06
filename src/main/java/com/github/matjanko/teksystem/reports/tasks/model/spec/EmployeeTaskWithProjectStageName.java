package com.github.matjanko.teksystem.reports.tasks.model.spec;

import com.github.matjanko.teksystem.reports.tasks.model.EmployeeTask;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class EmployeeTaskWithProjectStageName implements Specification<EmployeeTask> {

    private final String projectStageName;

    @Override
    public Predicate toPredicate(Root<EmployeeTask> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (projectStageName == null) {
            return cb.isTrue(cb.literal(true));
        }
        return cb.equal(root.get("projectStageName"), this.projectStageName);
    }
}
