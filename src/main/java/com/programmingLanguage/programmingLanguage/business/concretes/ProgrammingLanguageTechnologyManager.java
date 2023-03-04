package com.programmingLanguage.programmingLanguage.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.programmingLanguage.programmingLanguage.business.abstracts.ProgrammingLanguageTechnologyService;
import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageTechnologyRequest.CreateProgrammingLanguageTechnologyRequest;
import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageTechnologyRequest.UpdateProgrammingLanguageTechnologyRequest;
import com.programmingLanguage.programmingLanguage.business.dtos.response.ProgrammingLanguageTechnologyResponse.GetAllProgrammingLanguageTechnologyResponse;
import com.programmingLanguage.programmingLanguage.business.dtos.response.ProgrammingLanguageTechnologyResponse.GetByIdProgrammingLanguageTechnologyResponse;
import com.programmingLanguage.programmingLanguage.core.utilities.mappers.ModelMapperService;
import com.programmingLanguage.programmingLanguage.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import com.programmingLanguage.programmingLanguage.entities.concretes.ProgrammingLanguageTechnology;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService{
	
	private ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllProgrammingLanguageTechnologyResponse> getAll() {
		List<ProgrammingLanguageTechnology> programmingLanguageTechnologies = programmingLanguageTechnologyRepository.findAll();
		List<GetAllProgrammingLanguageTechnologyResponse> programmingLanguagesTechnologyResponse = programmingLanguageTechnologies.stream().map(programmingLanguageTechnology -> this.modelMapperService.forResponse().map(programmingLanguageTechnology, GetAllProgrammingLanguageTechnologyResponse.class)).collect(Collectors.toList());	
		return programmingLanguagesTechnologyResponse;
	}

	@Override
	public GetByIdProgrammingLanguageTechnologyResponse getByProgrammingLanguageTechnologyId(int id) {
		ProgrammingLanguageTechnology programmingLanguageTechnology = this.programmingLanguageTechnologyRepository.findById(id).orElseThrow();
		GetByIdProgrammingLanguageTechnologyResponse getByIdProgrammingLanguageTechnologyResponse = this.modelMapperService.forResponse().map(programmingLanguageTechnology, GetByIdProgrammingLanguageTechnologyResponse.class);
		return getByIdProgrammingLanguageTechnologyResponse;
	}

	@Override
	public CreateProgrammingLanguageTechnologyRequest add(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) {
		ProgrammingLanguageTechnology programmingLanguageTechnology = this.modelMapperService.forRequest().map(createProgrammingLanguageTechnologyRequest, ProgrammingLanguageTechnology.class);
		this.programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
		return createProgrammingLanguageTechnologyRequest;
	}

	@Override
	public UpdateProgrammingLanguageTechnologyRequest update(int id,UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) {
		ProgrammingLanguageTechnology programmingLanguageTechnology = this.modelMapperService.forRequest().map(updateProgrammingLanguageTechnologyRequest, ProgrammingLanguageTechnology.class);
		this.programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
		return updateProgrammingLanguageTechnologyRequest;
	}

	@Override
	public void delete(int id) {
		this.programmingLanguageTechnologyRepository.deleteById(id);
	}

}
