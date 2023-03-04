package com.programmingLanguage.programmingLanguage.business.dtos.response.ProgrammingLanguageResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdProgrammingLanguageResponse {
	private int id;
	private String name;
}
