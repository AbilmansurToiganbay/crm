package com.example.TrainingCRMv1.crm.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", schema = "trainingcrm", catalog = "trainingcrm")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Basic
    @Column(name = "username", nullable = false, length = -1)
    private String username;
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
    @Basic
    @Column(name = "dob", nullable = true)
    private Date dob;
    @Basic
    @Column(name = "registration_date", nullable = true)
    private Date registrationDate;
    @Basic
    @Column(name = "phone_number", nullable = true, length = -1)
    private String phoneNumber;
    @Basic
    @Column(name = "belt_status", nullable = true, length = -1)
    private String beltStatus;
    @Basic
    @Column(name = "first_name", nullable = true, length = -1)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = -1)
    private String lastName;
    @Basic
    @Column(name = "rank", nullable = true)
    private Long rank;
    @Basic
    @Column(name = "contract", nullable = true)
    private Boolean contract;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Roles> roles;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinTable(name = "user_gym",
            joinColumns = @JoinColumn(name = "gym_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Gym> gyms = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinTable(name = "User_Subscribtions",
            joinColumns = @JoinColumn(name = "subscribtion_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Subscribtion> subscribtions;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, optional = false)
    private Activity activity;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users that = (Users) o;
        return userId == that.userId && Objects.equals(username, that.username) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(dob, that.dob) && Objects.equals(registrationDate, that.registrationDate) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(beltStatus, that.beltStatus) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(rank, that.rank) && Objects.equals(contract, that.contract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, password, dob, registrationDate, phoneNumber, beltStatus, firstName, lastName, rank, contract);
    }
}
