/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EthanGeorge.JobListing.services;

import EthanGeorge.JobListing.entity.Jobs;

import java.util.List;

/**
 *
 * @author Ethan
 */
public interface JobService {

    public List<Jobs> findAll();

   public Jobs findById(int jobId);

    public Integer save(Jobs job);

    public boolean update(Jobs job);

    public boolean deleteById(int jobId);
}
