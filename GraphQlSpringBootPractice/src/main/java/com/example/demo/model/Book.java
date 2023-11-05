package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "Id",sequenceName = "Id",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Id")
	private int id;
	private String title;
	private String descp;
	private String author;
	private double price;
	private int pages;
}
