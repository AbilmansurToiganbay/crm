package com.example.TrainingCRMv1.crm.v1.services;

import com.example.TrainingCRMv1.crm.v1.entity.Users;
import com.example.TrainingCRMv1.crm.v1.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private  final UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public List<Users> findAll(String email){
        return repository.findByEmail(email);
    }

    public Users add(Users user){
        return repository.save(user);
    }
    public Users update(Users user){
        return repository.save(user);
    }
    public void delete(Users user){
        repository.delete(user);
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }
}
