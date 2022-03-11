/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EthanGeorge.JobListing.services;

import EthanGeorge.JobListing.entity.Canidates;
import java.util.List;

/**
 *
 * @author Ethan
 */
public interface CanidateService {

    public Canidates findById(int canidateId);

    public boolean deleteById(int canidateId);

    public boolean update(Canidates canidate);

    public List<Canidates> findAll();

    public int save(Canidates canidate);
    
}
