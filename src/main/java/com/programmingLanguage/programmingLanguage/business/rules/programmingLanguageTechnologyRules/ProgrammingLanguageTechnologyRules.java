package com.programmingLanguage.programmingLanguage.business.rules.programmingLanguageTechnologyRules;

import org.springframework.stereotype.Service;

import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageTechnologyRequest.CreateProgrammingLanguageTechnologyRequest;
import com.programmingLanguage.programmingLanguage.core.utilities.exceptions.BusinessException;
import com.programmingLanguage.programmingLanguage.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageTechnologyRules {

	private ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;
	
	public void checkIfProgrammingLanguageTechnologyName(String name) {
		if(programmingLanguageTechnologyRepository.existsByName(name)) {
			throw new BusinessException("Programming Language technology already exists.");
		}
	}
	
	public void checkIfProgrammingLanguageTechnologyBlankAndNull(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) {
		if(createProgrammingLanguageTechnologyRequest.getName().isBlank() || createProgrammingLanguageTechnologyRequest.getName().isEmpty()) {
			throw new BusinessException("The programming language technology cannot be empty.");
		}
	}
}
