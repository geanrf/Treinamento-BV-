package br.com.microprojeto.atomico.service;

import br.com.microprojeto.atomico.entity.CadastrarPessoaDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    private PessoaService pessoaService;

    @Test
    @DisplayName("Deve cadastrar uma pessoa")
    public void cadastrarPessoa() {

        CadastrarPessoaDto cadastrarPessoaDTO = new CadastrarPessoaDto("Gean", "88076894328", "6044545456", "Rua Oscar Lopes", "236", "60442510", "85", "85913106");
        pessoaService.cadastrarPessoa(cadastrarPessoaDTO);

    }

}