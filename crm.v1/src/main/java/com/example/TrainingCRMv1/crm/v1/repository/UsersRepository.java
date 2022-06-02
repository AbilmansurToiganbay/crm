package com.example.TrainingCRMv1.crm.v1.repository;

import com.example.TrainingCRMv1.crm.v1.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findByEmail(String email);

}
