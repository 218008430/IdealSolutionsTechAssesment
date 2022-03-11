package EthanGeorge.JobListing.services;

import EthanGeorge.JobListing.entity.JobRepository;
import EthanGeorge.JobListing.entity.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ethan
 */
@Service
public class JobServiceImpl implements JobService{
    
    
    private JobRepository jobRepository;
    
    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    
     @Override
    public List<Jobs> findAll() {
        return this.jobRepository.findAll();
    }
    
    @Override
    public Jobs findById(int jobId) {
        Optional<Jobs> result = this.jobRepository.findById(jobId);

        Jobs job = null;

        if (result.isPresent()) {
            job = result.get();
        } else {
          
            throw new RuntimeException("Did not find Job" + jobId);
        }

        return job;
    }
    
    @Transactional
    @Override
    public Integer save(Jobs job) {
        Jobs savedJob = this.jobRepository.save(job);

        if(savedJob != null){
            return savedJob.getId();
        }else{
            return null;
        }
    }
    
     @Transactional
    @Override
    public boolean update(Jobs job){
        Integer updatedJobId = this.jobRepository.update(job.getjobName(), job.getjobDescription(), job.getjobRequirements(), job.getjobField());

        if (updatedJobId != null){
            return true;
        }else{
            return false;
        }
    }
    
    @Transactional
    @Override
    public boolean deleteById(int jobId) {
        this.jobRepository.deleteById(jobId);

        if(this.jobRepository.findById(jobId) == null){
            return true;
        }else{
            return false;
        }
    }
}
