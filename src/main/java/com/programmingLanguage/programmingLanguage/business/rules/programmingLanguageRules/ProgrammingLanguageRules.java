package com.programmingLanguage.programmingLanguage.business.rules.programmingLanguageRules;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageRequest.CreateProgrammingLanguageRequest;
import com.programmingLanguage.programmingLanguage.core.utilities.exceptions.BusinessException;
import com.programmingLanguage.programmingLanguage.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.programmingLanguage.programmingLanguage.entities.concretes.ProgrammingLanguage;

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
	
	public void checkIfProgrammingLanguageBlankAndNull(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		if(createProgrammingLanguageRequest.getName().isBlank() || createProgrammingLanguageRequest.getName().isEmpty()) {
			throw new BusinessException("The programming language cannot be empty.");
		}
	}
	
	public ProgrammingLanguage checkIfGetByIdProgrammingLanguage(int id) {
		Optional<ProgrammingLanguage> programmingLanguage = this.programmingLanguageRepository.findById(id);
		if(programmingLanguage.isPresent()) {
			return programmingLanguageRepository.findById(id).get();
		} else {
			throw new BusinessException("There is no programming language registered to this id number.");
		}
	}
	
	public void checkIfDeleteByIdProgrammingLanguage(int id) {
		Optional<ProgrammingLanguage> programmingLanguage = this.programmingLanguageRepository.findById(id);
		if(programmingLanguage.isPresent()) {
			this.programmingLanguageRepository.deleteById(id);
		} else {
			throw new BusinessException("There is no programming language registered to this id number.");
		}
	}
}
