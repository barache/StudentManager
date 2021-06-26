package com.javalearn.studentmanager.repository;

import com.javalearn.studentmanager.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course,String> {
}
