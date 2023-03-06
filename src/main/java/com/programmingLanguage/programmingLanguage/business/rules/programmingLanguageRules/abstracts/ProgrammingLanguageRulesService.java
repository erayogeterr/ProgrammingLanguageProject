package com.programmingLanguage.programmingLanguage.business.rules.programmingLanguageRules.abstracts;

import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageRequest.CreateProgrammingLanguageRequest;
import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageRequest.UpdateProgrammingLanguageRequest;
import com.programmingLanguage.programmingLanguage.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRulesService {
	void checkIfProgrammingLanguageNameExists(String name);
	void checkIfProgrammingLanguageBlankAndNull(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
	void checkIfDeleteByIdProgrammingLanguage(int id);
	void chechIfUpdateByIdProgrammingLanguage(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
	ProgrammingLanguage checkIfGetByIdProgrammingLanguage(int id);
}
