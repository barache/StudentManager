package com.javalearn.studentmanager.controller;


import com.javalearn.studentmanager.entity.Groupe;
import com.javalearn.studentmanager.exception.ResourceNotFoundException;
import com.javalearn.studentmanager.repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class GroupeController {

    @Autowired
    private GroupeRepository groupeRepository;

    @GetMapping("/groupes")
    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    @PostMapping("/groupes")
    public Groupe createGroupe(@RequestBody Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @GetMapping("/groupes/{id}")
    public ResponseEntity<Groupe> getEmployeeById(@PathVariable(value = "id") Long groupeid)
            throws ResourceNotFoundException {
        Groupe groupe = groupeRepository.findById(groupeid)
                .orElseThrow(() -> new ResourceNotFoundException("Groupe not found for this id : " + groupeid));
        return ResponseEntity.ok().body(groupe);
    }

    @DeleteMapping("/groupes/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long groupeId)
            throws ResourceNotFoundException {
        Groupe groupe = groupeRepository.findById(groupeId)
                .orElseThrow(() -> new ResourceNotFoundException("Groupe not found for this id :: " + groupeId));

        groupeRepository.delete(groupe);
        String reponse = "Deleted";
        return reponse;
    }

}
