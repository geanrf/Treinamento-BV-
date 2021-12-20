package br.com.microprojeto.atomico.controller;

import br.com.microprojeto.atomico.business.RuleToTest;
import br.com.microprojeto.atomico.entity.CadastrarPessoaDto;
import br.com.microprojeto.atomico.entity.Pessoa;
import br.com.microprojeto.atomico.service.PessoaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PessoaControllerTest {

    @InjectMocks
    private PessoaController pessoaController;

    @Mock
    private PessoaService pessoaService;

    @Mock
    private RuleToTest ruleToTest;


   @Test
    @DisplayName("Deve retornar à pessoa, conforme o CPF informado. !")
    public void findPeople() {

       Pessoa pessoa = new Pessoa("1", "Gean", "88076894328", "90060000932", "RUa Oscar", "236", "60440510", "85", "85913106");
       List fakeListData = new ArrayList();
       fakeListData.add(pessoa);
       Map<HttpStatus, String> fakeError = new HashMap<>();

       Mockito.when(ruleToTest.consultaListaErro("88076894328")).thenReturn(fakeError);
       Mockito.when(pessoaService.consultarPessoa("88076894328")).thenReturn(fakeListData);


       ResponseEntity fakeResponse = new ResponseEntity(fakeListData, HttpStatus.OK);

       assertEquals(fakeResponse, pessoaController.consultarPessoa("88076894328"));
    }

    @Test
    @DisplayName("Não deve retornar à pessoa, conforme o CPF informado. !")
    public void notFindPeople() {

        Map<HttpStatus, String> fakeError = new HashMap<>();

        fakeError.put(HttpStatus.I_AM_A_TEAPOT, "Parâmetro invalido");
        Mockito.when(ruleToTest.consultaListaErro("8807689432")).thenReturn(fakeError);


        ResponseEntity fakeResponse = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        assertEquals(fakeResponse, pessoaController.consultarPessoa("8807689432"));
    }





    ////////////////////////////////////////////////////////// CADASTRO /////////////////////////////////////////////////////////////////////////////



    @Test
    @DisplayName("Não deve cadastrar uma pessoa")
    public void notHaveAdd()  {

        CadastrarPessoaDto cadastrarPessoaDto = new CadastrarPessoaDto("Gean", "88", "90060000932", "RUa Oscar", "236", "60440510", "85", "85913106");
        Map<HttpStatus, String> fakeError = new HashMap<>();
        fakeError.put(HttpStatus.I_AM_A_TEAPOT, "CPF invalido, gentileza informar um CPF válido");
        Mockito.when(ruleToTest.cadastroListaErros(cadastrarPessoaDto)).thenReturn(fakeError);
        ResponseEntity fakeResponse = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(fakeResponse, pessoaController.cadastrarPessoa(cadastrarPessoaDto));

    }


    @Test
    @DisplayName("Deve cadastrar uma pessoa")
    public void savePeople()  {

        CadastrarPessoaDto cadastrarPessoaDto = new CadastrarPessoaDto("Gean", "88076894328", "90060000932", "RUa Oscar", "236", "60440510", "85", "85913106");
        ResponseEntity fakeResponse = new ResponseEntity(HttpStatus.OK);

        Map<HttpStatus, String> fakeError = new HashMap<>();
        Mockito.when(ruleToTest.cadastroListaErros(cadastrarPessoaDto)).thenReturn(fakeError);

        assertEquals(fakeResponse, pessoaController.cadastrarPessoa(cadastrarPessoaDto));

    }


}