package com.github.matjanko.teksystem.dictonaries.model.projectstage;

import com.github.matjanko.teksystem.dictonaries.model.Dictionary;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT_STAGE")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "PROJECT_STAGE_ID")),
        @AttributeOverride(name = "name", column = @Column(name = "PROJECT_STAGE_NAME"))
})
public class ProjectStage extends Dictionary {

}
