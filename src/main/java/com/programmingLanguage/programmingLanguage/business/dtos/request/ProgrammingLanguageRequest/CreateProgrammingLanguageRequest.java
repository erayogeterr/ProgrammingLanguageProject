package com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgrammingLanguageRequest {
	
	@NotNull
	@NotBlank
	@Size(min = 3, max = 20)
	private String name;
	

}
