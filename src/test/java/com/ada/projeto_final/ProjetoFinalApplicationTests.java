package com.ada.projeto_final;

import com.ada.projeto_final.dto.FilmeDTO;
import com.ada.projeto_final.resource.FlixResource;
import com.ada.projeto_final.service.FlixService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProjetoFinalApplicationTests {

	@InjectMocks
	FlixResource resource;

	@Mock
	FlixService service;

	@Test
	void cadastrarFilme() {
		resource.cadastrarFilme(new FilmeDTO());
	}

}
