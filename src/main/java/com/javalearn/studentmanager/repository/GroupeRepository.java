package com.javalearn.studentmanager.repository;

import com.javalearn.studentmanager.entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    public List<Groupe> findByOrderByGroupeIdAsc();
}
