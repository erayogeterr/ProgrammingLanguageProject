package com.programmingLanguage.programmingLanguage.business.rules.programmingLanguageRules;

import org.springframework.stereotype.Service;

import com.programmingLanguage.programmingLanguage.core.utilities.exceptions.BusinessException;
import com.programmingLanguage.programmingLanguage.dataAccess.abstracts.ProgrammingLanguageRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageRules {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	public void checkIfProgrammingLanguageNameExists(String name) {
		if(programmingLanguageRepository.existsByName(name)) {
			throw new BusinessException("Programming Language already exists.");
		}
	}
}