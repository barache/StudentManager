package com.javalearn.studentmanager.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    @Column(length = 40, nullable = false)
    private String firstname;
    @Column(length = 40, nullable = false)
    private String lastname;
    @Column(length = 40)
    private String email;
    @Column(length = 12)
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

}
