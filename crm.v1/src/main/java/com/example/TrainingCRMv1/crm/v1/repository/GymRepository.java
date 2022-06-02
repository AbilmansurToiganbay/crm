package com.example.TrainingCRMv1.crm.v1.repository;

import com.example.TrainingCRMv1.crm.v1.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository extends JpaRepository<Gym, Long> {

   // @Query(value = "from Gym join Gym.users u where u.email=:email")
//    @Query(value = "SELECT Gym.gym_id, Gym.gym_name, Users.email FROM Gym AS g" +
//            "inner join UserGym AS ug" +
//            "on g.gym_id = ug.gym_id " +
//            "inner join ",
//            nativeQuery = true)
    List<Gym> findByGymEmail(String email);

}
