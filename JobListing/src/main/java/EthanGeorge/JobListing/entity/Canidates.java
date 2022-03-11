/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EthanGeorge.JobListing.entity;

import javax.persistence.*;

/**
 *
 * @author Ethan
 */
@Entity
@Table(name = "Canidates")
public class Canidates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "canidateName")
    private String canidateName;

    @Column(name = "canidateSurname")
    private String canidateSurname;

    @Column(name = "canidateJob")
    private String canidateJob;

    @Column(name = "canidateField")
    private String canidateField;

    public Canidates() {
        canidateName = "Ethan ";
        canidateSurname = "George";
        canidateJob = "Software Developer";
        canidateField = "Milnertron";
        
         canidateName = "Leaviel ";
        canidateSurname = "Gouws";
        canidateJob = "Marketing";
        canidateField = "Piketberg";
    }

    public Canidates(String canidateName, String canidateSurname, String canidateJob, String canidateField) {
        this.canidateName = canidateName;
        this.canidateSurname = canidateSurname;
        this.canidateJob = canidateJob;
        this.canidateField = canidateField;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return 0;

    }

    public String getcanidateName() {
        return canidateName;
    }

    public String setcanidateName(String canidateName) {
        this.canidateName = canidateName;
        return null;

    }

    public String getcanidateSurname() {
        return canidateSurname;
    }

    public String setcanidateSurname(String canidateSurname) {
        this.canidateSurname = canidateSurname;
        return null;

    }

    public String setcanidateJob(String canidateJob) {
        return canidateJob;
    }

    public String getcanidateJob() {
        this.canidateJob = canidateJob;
        return null;
    }

    public String getcanidateField() {
        return canidateField;
    }

    public String setcanidateField(String canidateField) {
        this.canidateField = canidateField;
        return null;
    }

    @Override
    public String toString() {
        return "Canidates[id = " + this.id + " , canidateName = " + this.canidateName + ", canidateSurname=" + this.canidateSurname + ",canidateJob=" + this.canidateJob + ", canidateField=" + this.canidateField + "]";
    }
}
