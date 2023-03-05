package com.programmingLanguage.programmingLanguage.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programmingLanguage.programmingLanguage.entities.concretes.ProgrammingLanguageTechnology;

public interface ProgrammingLanguageTechnologyRepository extends JpaRepository<ProgrammingLanguageTechnology, Integer> {
	boolean existsByName(String name);
}
