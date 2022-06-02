package com.example.TrainingCRMv1.crm.v1.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Subscribtion", schema = "TrainingCRM", catalog = "TrainingCRM")
public class Subscribtion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subscribtion_id", nullable = false)
    private long subscribtionId;
    @Basic
    @Column(name = "subscribtion_type", nullable = false, length = -1)
    private String subscribtionType;
    @Basic
    @Column(name = "subscribtion_start_date", nullable = false)
    private Date subscribtionStartDate;
    @Basic
    @Column(name = "subscribtion_end_date", nullable = false)
    private Date subscribtionEndDate;


    @ManyToMany(mappedBy = "subscribtions")
    private Set<Users> usersSet;// для каких юзеров подписка

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_id") // по каким полям связывать (foreign key) correct
    private Gym gym; // для какого зала подписка


    @Basic
    @Column(name = "subscribtion_name", nullable = false, length = -1)
    private String subscribtionName;
    @Basic
    @Column(name = "subscribtion_for", nullable = true, length = -1)
    private String subscribtionFor;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscribtion subscribtion = (Subscribtion) o;
        return subscribtionId==subscribtion.subscribtionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscribtionId);
    }
}
