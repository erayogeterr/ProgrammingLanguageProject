package com.programmingLanguage.programmingLanguage.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programmingLanguage.programmingLanguage.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer>{

}
