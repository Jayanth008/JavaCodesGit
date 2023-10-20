package com.example.demo.repositry;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GoldModel;

@Repository
public interface GoldRepo extends JpaRepository<GoldModel, Integer> {
	GoldModel findByDate(LocalDate date);

}
