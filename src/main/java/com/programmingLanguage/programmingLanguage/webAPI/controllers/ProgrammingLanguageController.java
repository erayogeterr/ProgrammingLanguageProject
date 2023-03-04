package com.programmingLanguage.programmingLanguage.webAPI.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programmingLanguage.programmingLanguage.business.abstracts.ProgrammingLanguageService;
import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageRequest.CreateProgrammingLanguageRequest;
import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageRequest.UpdateProgrammingLanguageRequest;
import com.programmingLanguage.programmingLanguage.business.dtos.response.ProgrammingLanguageResponse.GetAllProgrammingLanguageResponse;
import com.programmingLanguage.programmingLanguage.business.dtos.response.ProgrammingLanguageResponse.GetByIdProgrammingLanguageResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("v1/api/programminglanguages")
@AllArgsConstructor
public class ProgrammingLanguageController {

	private ProgrammingLanguageService programmingLanguageService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllProgrammingLanguageResponse> getAll() {
		return this.programmingLanguageService.getAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public GetByIdProgrammingLanguageResponse getById(@PathVariable int id) {
		return this.programmingLanguageService.getByProgrammingLanguageId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CreateProgrammingLanguageRequest add(@RequestBody() CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		return this.programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UpdateProgrammingLanguageRequest update(@RequestBody() int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		return this.programmingLanguageService.update(id,updateProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(int id) {
		this.programmingLanguageService.delete(id);
	}
	
}
