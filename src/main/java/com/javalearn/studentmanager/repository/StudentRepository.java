package com.javalearn.studentmanager.repository;

import com.javalearn.studentmanager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    List<Student> findByOrderByStudentIdAsc();

    //@Query(value="select * from Student s where s.lastname = :lastname",
    //        nativeQuery=true)
    //List<Student> findByLastname(@Param("lastname") String lastname);

    @Query(value="select * from Student s where s.groupe_id = :groupe",
            nativeQuery=true)
    List<Student> findByGroupe(@Param("groupe") long groupe);

    List<Student> findByLastname(String lastname);


}
