package com.example.TrainingCRMv1.crm.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Gym", schema = "trainingCRM", catalog = "TrainingCRM")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Gym {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "gym_id", nullable = false)
    private long gymId;
    @Basic
    @Column(name = "gym_name", nullable = false, length = -1)
    private String gymName;
    @Basic
    @Column(name = "gym_address", nullable = true, length = -1)
    private String gymAddress;
    @Basic
    @Column(name = "gym_email", nullable = true, length = -1)
    private String gymEmail;
    @Basic
    @Column(name = "gym_phone_number", nullable = true, length = -1)
    private String gymPhoneNumber;
    @Basic
    @Column(name = "gym_description", nullable = true, length = -1)
    private String gymDescription;

    @OneToMany(mappedBy = "gym",fetch = FetchType.LAZY)//correct
    private Set<Subscribtion> subscribtions = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinTable(name = "User_Gym",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "gym_id"))
    private Set<Users> users = new HashSet<>(); // юзеры в этом тренажерном зале


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gym gym = (Gym) o;
        return gymId == gym.gymId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gymId);
    }
}
