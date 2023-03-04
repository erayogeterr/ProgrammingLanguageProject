package com.programmingLanguage.programmingLanguage.business.dtos.request.ProgrammingLanguageTechnologyRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgrammingLanguageTechnologyRequest {
	private int programmingLanguageId;
	private String name;
}
