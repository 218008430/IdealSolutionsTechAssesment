/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EthanGeorge.JobListing.entity;

import javax.persistence.*;

/**
 *
 * @author Ethan George
 */
@Entity
@Table(name = "Jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "jobName")
    private String jobName;

    @Column(name = "jobDescription")
    private String jobDescription;

    @Column(name = "jobRequirements")
    private String jobRequirements;

    @Column(name = "jobField")
    private String jobField;

    public Jobs() {

        jobName = "Software Developer";
        jobDescription = "Fullstack developer ";
        jobRequirements = "Certificate Systems Development";
        jobField = "Milnerton";
    }

    public Jobs(String jobName, String jobDescription, String jobRequirements, String jobField) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.jobRequirements = jobRequirements;
        this.jobField = jobField;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return 0;

    }

    public String getjobName() {
        return jobName;
    }

    public String setjobName(String jobName) {
        this.jobName = jobName;
        return null;

    }

    public String getjobDescription() {
        return jobDescription;
    }

    public String setjobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return null;

    }

    public String setjobRequirements() {
        return jobRequirements;
    }

    public String getjobRequirements() {
        this.jobDescription = jobRequirements;
        return null;
    }

    public String getjobField() {
        return jobField;
    }

    public String setjobField(String jobField) {
        this.jobField = jobField;
        return null;
    }

    @Override
    public String toString() {
        return "Jobs[id = " + this.id + " , jobName = " + this.jobName + ", jobDescription=" + this.jobDescription + ",jobRequirements=" + this.jobRequirements + ", jobField=" + this.jobField + "]";
    }
}
