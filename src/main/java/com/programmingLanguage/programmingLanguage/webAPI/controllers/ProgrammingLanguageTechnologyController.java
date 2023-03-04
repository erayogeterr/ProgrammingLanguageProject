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

import com.programmingLanguage.programmingLanguage.business.abstracts.ProgrammingLanguageTechnologyService;
import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageTechnologyRequest.CreateProgrammingLanguageTechnologyRequest;
import com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageTechnologyRequest.UpdateProgrammingLanguageTechnologyRequest;
import com.programmingLanguage.programmingLanguage.business.dtos.response.ProgrammingLanguageTechnologyResponse.GetAllProgrammingLanguageTechnologyResponse;
import com.programmingLanguage.programmingLanguage.business.dtos.response.ProgrammingLanguageTechnologyResponse.GetByIdProgrammingLanguageTechnologyResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("v1/api/programminglanguagetechnology")
@AllArgsConstructor
public class ProgrammingLanguageTechnologyController {

	private ProgrammingLanguageTechnologyService programmingLanguageTechnologyService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllProgrammingLanguageTechnologyResponse> getAll() {
		return this.programmingLanguageTechnologyService.getAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public GetByIdProgrammingLanguageTechnologyResponse getById(@PathVariable int id) {
		return this.programmingLanguageTechnologyService.getByProgrammingLanguageTechnologyId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CreateProgrammingLanguageTechnologyRequest add(@RequestBody () CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) {
		return this.programmingLanguageTechnologyService.add(createProgrammingLanguageTechnologyRequest);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UpdateProgrammingLanguageTechnologyRequest update(@RequestBody int id, UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) {
		return this.programmingLanguageTechnologyService.update(id, updateProgrammingLanguageTechnologyRequest);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(int id) {
		this.programmingLanguageTechnologyService.delete(id);
	}
}
