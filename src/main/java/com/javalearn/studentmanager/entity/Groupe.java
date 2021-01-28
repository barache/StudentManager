package com.javalearn.studentmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Groupe implements Serializable {
    @Id
    @Column(nullable = false, unique = true)
    private long groupeId;

    @Column(length = 80, nullable = false, unique = true)
    private String groupeName;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name ="groupe_id",referencedColumnName = "groupeId")
    private List<Student> students;
}
