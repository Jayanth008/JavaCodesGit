package com.bookauthor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookauthor.entity.ImportDataCSVEntity;

@Repository
public interface ImportDataCSVRepo extends JpaRepository<ImportDataCSVEntity, Integer> {

}
