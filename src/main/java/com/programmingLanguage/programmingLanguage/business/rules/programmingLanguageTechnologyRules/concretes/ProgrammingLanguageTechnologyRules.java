package com.programmingLanguage.programmingLanguage.business.rules.programmingLanguageTechnologyRules.concretes;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageTechnologyRequest.CreateProgrammingLanguageTechnologyRequest;
import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageTechnologyRequest.UpdateProgrammingLanguageTechnologyRequest;
import com.programmingLanguage.programmingLanguage.business.rules.programmingLanguageTechnologyRules.abstracts.ProgrammingLanguageTechnologyRulesService;
import com.programmingLanguage.programmingLanguage.core.utilities.exceptions.BusinessException;
import com.programmingLanguage.programmingLanguage.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import com.programmingLanguage.programmingLanguage.entities.concretes.ProgrammingLanguageTechnology;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageTechnologyRules implements ProgrammingLanguageTechnologyRulesService{

	private ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;
	
	@Override
	public void checkIfProgrammingLanguageNameTechnologyExists(String name) {
		if(programmingLanguageTechnologyRepository.existsByName(name)) {
			throw new BusinessException("Programming Language technology already exists.");
		}
	}
	
	@Override
	public void checkIfProgrammingLanguageNameTechnologyIgnoreCase(String name) {
			if(programmingLanguageTechnologyRepository.findByNameIgnoreCase(name) != null) {
				throw new BusinessException("Programming Language technology already exists.");
			}
		}
	
	@Override
	public void checkIfProgrammingLanguageTechnologyBlankAndNull(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) {
		if(createProgrammingLanguageTechnologyRequest.getName().isBlank() || createProgrammingLanguageTechnologyRequest.getName().isEmpty()) {
			throw new BusinessException("The programming language technology cannot be empty.");
		}
	}
	
	@Override
	public void checkIfProgrammingLanguageTechnologyBlankAndNull(UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) {
		if(updateProgrammingLanguageTechnologyRequest.getName().isBlank() || updateProgrammingLanguageTechnologyRequest.getName().isEmpty()) {
			throw new BusinessException("The programming language cannot be empty.");
		}
	}
	
	@Override
	public ProgrammingLanguageTechnology checkIfGetByIdProgrammingLanguageTechnology(int id) {
		Optional<ProgrammingLanguageTechnology> programmingLanguageTechnology = this.programmingLanguageTechnologyRepository.findById(id);
		if(programmingLanguageTechnology.isPresent()) {
			return programmingLanguageTechnologyRepository.findById(id).get();
		} else {
			throw new BusinessException("There is no programming language registered to this id number.");
		}
	}

}
