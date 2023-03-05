package com.programmingLanguage.programmingLanguage.business.rules.programmingLanguageTechnologyRules;

import org.springframework.stereotype.Service;

import com.programmingLanguage.programmingLanguage.core.utilities.exceptions.BusinessException;
import com.programmingLanguage.programmingLanguage.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageTechnologyRules {

	private ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;
	
	public void checkIfProgrammingLanguageTechnologyName(String name) {
		if(programmingLanguageTechnologyRepository.existsByName(name)) {
			throw new BusinessException("Programming Language already exists.");
		}
	}
}
