package com.example.demo.repositry;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PetrolModel;
@Repository
public interface PetrolRepo extends JpaRepository<PetrolModel, Integer> {

	PetrolModel findByDate(LocalDate date);

}
