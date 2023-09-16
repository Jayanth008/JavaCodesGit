package com.bookauthor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportDataCSVEntity {
	@Id
	private int id;
	private String name;
	private int age;
	private String email;

}
