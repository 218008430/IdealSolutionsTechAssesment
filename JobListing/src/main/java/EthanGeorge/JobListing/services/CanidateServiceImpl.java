/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EthanGeorge.JobListing.services;

import EthanGeorge.JobListing.entity.CanidateRepository;
import EthanGeorge.JobListing.entity.Canidates;
import EthanGeorge.JobListing.entity.JobRepository;
import EthanGeorge.JobListing.entity.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Ethan
 */

@Service
public class CanidateServiceImpl implements CanidateService{
    
     private CanidateRepository canidateRepository;
    private Canidates canidate;
    
    @Autowired
    public CanidateServiceImpl(CanidateRepository canidateRepository) {
        this.canidateRepository = canidateRepository;
    }
    
     @Override
    public List<Canidates> findAll() {
        return this.canidateRepository.findAll();
    }
    
    @Override
    public Canidates findById(int canidateId) {
        Optional<Canidates> result = this.canidateRepository.findById(canidateId);

        Canidates canidate = null;

        if (result.isPresent()) {
            canidate = result.get();
        } else {
         
            throw new RuntimeException("Did not find Canidate " + canidateId);
        }

        return canidate;
    }
    
    @Transactional
    @Override
    public Integer save(Canidates canidate) {
        Canidates savedCanidate = this.canidateRepository.save(canidate);

        if(savedCanidate != null){
            return savedCanidate.getId();
        }else{
            return null;
        }
    }
    
     @Transactional
    @Override
    public boolean update(Canidates canidate){
        Integer updatedCanidateId = this.canidateRepository.update(canidate.getcanidateName(), canidate.getcanidateSurname(), canidate.getcanidateJob(), canidate.getcanidateField());

        if (updatedCanidateId != null){
            return true;
        }else{
            return false;
        }
    }
    
    @Transactional
    @Override
    public boolean deleteById(int canidateId) {
        this.canidateRepository.deleteById(canidateId);

        if(this.canidateRepository.findById(canidateId) == null){
            return true;
        }else{
            return false;
        }
    }
}
