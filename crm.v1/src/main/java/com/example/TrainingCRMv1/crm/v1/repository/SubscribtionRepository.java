package com.example.TrainingCRMv1.crm.v1.repository;

import com.example.TrainingCRMv1.crm.v1.entity.Subscribtion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscribtionRepository extends JpaRepository<Subscribtion, Long> {
}
