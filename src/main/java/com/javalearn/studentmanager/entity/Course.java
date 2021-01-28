package com.javalearn.studentmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @Column(length = 30)
    private String CourseId;
    @Column(length = 80)
    private String nameCourse;
}
