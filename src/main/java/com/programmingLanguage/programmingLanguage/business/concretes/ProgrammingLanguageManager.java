package com.programmingLanguage.programmingLanguage.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.programmingLanguage.programmingLanguage.business.abstracts.ProgrammingLanguageService;
import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageRequest.CreateProgrammingLanguageRequest;
import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageRequest.UpdateProgrammingLanguageRequest;
import com.programmingLanguage.programmingLanguage.business.dtos.response.ProgrammingLanguageResponse.GetAllProgrammingLanguageResponse;
import com.programmingLanguage.programmingLanguage.business.dtos.response.ProgrammingLanguageResponse.GetByIdProgrammingLanguageResponse;
import com.programmingLanguage.programmingLanguage.business.rules.programmingLanguageRules.ProgrammingLanguageRules;
import com.programmingLanguage.programmingLanguage.core.utilities.mappers.ModelMapperService;
import com.programmingLanguage.programmingLanguage.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.programmingLanguage.programmingLanguage.entities.concretes.ProgrammingLanguage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ModelMapperService modelMapperService;
	private ProgrammingLanguageRules programmingLanguageRules;
	
	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguageResponse> programmingLanguagesResponse = programmingLanguages.stream().map(programmingLanguage -> this.modelMapperService.forResponse().map(programmingLanguage, GetAllProgrammingLanguageResponse.class)).collect(Collectors.toList());
		return programmingLanguagesResponse;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getByProgrammingLanguageId(int id) {
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(id).orElseThrow();
		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = this.modelMapperService.forResponse().map(programmingLanguage, GetByIdProgrammingLanguageResponse.class);
		return getByIdProgrammingLanguageResponse;
	}

	@Override
	public CreateProgrammingLanguageRequest add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		this.programmingLanguageRules.checkIfProgrammingLanguageNameExists(createProgrammingLanguageRequest.getName());
		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(createProgrammingLanguageRequest, ProgrammingLanguage.class); // createBrandRequest // nesnesini Brand // classına maple.
		this.programmingLanguageRepository.save(programmingLanguage);
		return createProgrammingLanguageRequest;
	}

	@Override
	public UpdateProgrammingLanguageRequest update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
		this.programmingLanguageRepository.save(programmingLanguage);
		return updateProgrammingLanguageRequest;
	}

	@Override
	public void delete(int id) {
		this.programmingLanguageRepository.deleteById(id);
	}

}
