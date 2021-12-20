package br.com.microprojeto.atomico.business;


import br.com.microprojeto.atomico.entity.CadastrarPessoaDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RuleEngineTest {

    @InjectMocks
    private br.com.microprojeto.atomico.business.RuleToTest RuleToTest;


    @Test
    @DisplayName("Nome Nulo")
    public void peopleNula()  {

        CadastrarPessoaDto cadastrarPessoaDTO = new CadastrarPessoaDto(null, null, null, null, null, null, null, null);
        Map<HttpStatus,String> fakeErro = new HashMap<>();
        fakeErro.put(HttpStatus.I_AM_A_TEAPOT, "CPF invalido, gentileza informar um CPF válido");
        fakeErro.put(HttpStatus.BAD_REQUEST, " Parâmetro não informado ");
        assertEquals(fakeErro, RuleToTest.cadastroListaErros(cadastrarPessoaDTO));

    }



    @Test
    @DisplayName("Cpf Vazio")
    public void cpfVoid()  {

        CadastrarPessoaDto cadastrarPessoaDTO = new CadastrarPessoaDto("", "", "", "", "", "", "", "");
        Map<HttpStatus,String> fakeErro = new HashMap<>();
        fakeErro.put(HttpStatus.I_AM_A_TEAPOT, "CPF invalido, gentileza informar um CPF válido");
        fakeErro.put(HttpStatus.NOT_ACCEPTABLE, " Parâmetro invalido ");
        assertEquals(fakeErro, RuleToTest.cadastroListaErros(cadastrarPessoaDTO));

    }


    @Test
    @DisplayName("Cadastro Invalido")
    public void peopleInvalido()  {

        CadastrarPessoaDto cadastrarPessoaDTO = new CadastrarPessoaDto("Gean", "10", "6044545456", "Rua Oscar Lopes", "236", "60442510", "85", "85913106");
        Map<HttpStatus,String> fakeErro = new HashMap<>();
        fakeErro.put(HttpStatus.I_AM_A_TEAPOT, "CPF invalido, gentileza informar um CPF válido");
        assertEquals(fakeErro, RuleToTest.cadastroListaErros(cadastrarPessoaDTO));

    }

    @Test
    @DisplayName("Cadastro não localizado")
    public void peopleNoFind()  {

        CadastrarPessoaDto cadastrarPessoaDTO = new CadastrarPessoaDto("Gean", "9", "6044545456", "Rua Oscar Lopes", "236", "60442510", "85", "85913106");
        Map<HttpStatus,String> fakeErro = new HashMap<>();
        fakeErro.put(HttpStatus.I_AM_A_TEAPOT, "CPF invalido, gentileza informar um CPF válido");
        assertEquals(fakeErro, RuleToTest.cadastroListaErros(cadastrarPessoaDTO));

    }


    @Test
    @DisplayName("Deve cadastrar uma pessoa")
    public void savePeople()  {

        CadastrarPessoaDto cadastrarPessoaDTO = new CadastrarPessoaDto("Gean", "88076894328", "6044545456", "Rua Oscar Lopes", "236", "60442510", "85", "85913106");
        Map<HttpStatus,String> fakeErro = new HashMap<>();
        assertEquals(fakeErro, RuleToTest.cadastroListaErros(cadastrarPessoaDTO));


    }



//////////////////////////////////////////////// CONSULTA /////////////////////////////////////////////////////////////////////////////////


    @Test
    @DisplayName("Deve retornar à pessoa, conforme o CPF informado. !")
    public void findPessoa() {
        Map<HttpStatus,String> fakeErro = new HashMap<>();
        assertEquals(fakeErro, RuleToTest.consultaListaErro("88076894328"));
    }

    @Test
    @DisplayName("NÃO Deve retornar à pessoa, CPF estará nulo. !")
    public void shouldntfindPessoaCPFNull() {

        Map<HttpStatus,String> result = RuleToTest.consultaListaErro( null);
        assertTrue(result.containsKey(HttpStatus.BAD_REQUEST));
    }

    @Test
    @DisplayName("Deve retornar vazio")
    public void deveRetornarazio() {

        Map<HttpStatus,String> result = RuleToTest.consultaListaErro("");
        assertTrue(result.containsKey(HttpStatus.NOT_ACCEPTABLE));
    }




    @Test
    @DisplayName("Retorna dados invalidos")
    public void deveRetornarDadosInvalido() {

        Map<HttpStatus,String> result = RuleToTest.consultaListaErro("9");
        assertTrue(result.containsKey(HttpStatus.I_AM_A_TEAPOT));
    }


    @Test
    @DisplayName("Retorna, cadastro não localizado")
    public void deveRetornarCadastroNãoLocalizado() {


        Map<HttpStatus,String> result = RuleToTest.consultaListaErro("10");
        assertTrue(result.containsKey(HttpStatus.I_AM_A_TEAPOT));

    }


}