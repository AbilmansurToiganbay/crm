package com.example.TrainingCRMv1.crm.v1.services;

import com.example.TrainingCRMv1.crm.v1.entity.Gym;
import com.example.TrainingCRMv1.crm.v1.repository.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {
    private  final GymRepository repository;

    public GymService(GymRepository repository) {
        this.repository = repository;
    }

    public List<Gym> findAll(String email){
        return repository.findByGymEmail(email);
    }
    public Gym add(Gym gym){
        return repository.save(gym);
    }
    public Gym update(Gym gym){
        return repository.save(gym);
    }
    public void delete(Gym gym){
        repository.delete(gym);
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }
}
