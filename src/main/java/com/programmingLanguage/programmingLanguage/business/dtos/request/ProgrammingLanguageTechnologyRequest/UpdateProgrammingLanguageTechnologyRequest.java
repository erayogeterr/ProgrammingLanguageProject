package com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageTechnologyRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProgrammingLanguageTechnologyRequest {

	private int id;
	private int programmingLanguageId;
	private String name;
	
}
