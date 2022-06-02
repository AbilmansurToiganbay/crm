package com.example.TrainingCRMv1.crm.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name = "Activity", schema = "TrainingCRM", catalog = "TrainingCRM")
public class Activity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "activity_id", nullable = false)
    private long activityId;
    @NotBlank
    @Column(updatable = false)
    private String uuid;
    @Type(type = "org.hibernate.type.NumericBooleanType") // для автоматической конвертации числа в true/false
    @Column(name = "activated", nullable = true)
    private Short activated;// становится true только после подтверждения активации пользователем (обратно false уже стать не может по логике)

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return activityId==activity.activityId;
    }


    @Override
    public int hashCode() {
        return Objects.hash(activityId);
    }
}
