package br.com.microprojeto.atomico.business;

import br.com.microprojeto.atomico.entity.CadastrarPessoaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class RuleToTest {



    public Map cadastroListaErros(CadastrarPessoaDto pessoa) {

        Map <HttpStatus, String> erros = new HashMap<>();

        if (pessoa.getNome() == null) {

            erros.put(HttpStatus.BAD_REQUEST, " Parâmetro não informado " );

        }
        if (pessoa.getLogradouro() == null) {

            erros.put(HttpStatus.BAD_REQUEST, " Parâmetro não informado " );

        }
        if (pessoa.getRg() == null) {

            erros.put(HttpStatus.BAD_REQUEST, " Parâmetro não informado " );

        }

        if (pessoa.getCpf() == "") {

            erros.put(HttpStatus.NOT_ACCEPTABLE, " Parâmetro invalido ");

        }
        if (pessoa.getDdd() == "") {

            erros.put(HttpStatus.NOT_ACCEPTABLE, " Parâmetro invalido ");

        }
        if (pessoa.getNumLogradouro() == "") {

            erros.put(HttpStatus.NOT_ACCEPTABLE, " Parâmetro invalido ");

        }
        if (pessoa.getTelefone() == "") {

            erros.put(HttpStatus.NOT_ACCEPTABLE, " Parâmetro invalido ");

        }
        if (pessoa.getCep() == "") {

            erros.put(HttpStatus.NOT_ACCEPTABLE, " Parâmetro invalido ");

        }
        if (String.valueOf(pessoa.getCpf()).length() != 11) {

            erros.put(HttpStatus.I_AM_A_TEAPOT, "CPF invalido, gentileza informar um CPF válido");

        }
        return erros;


    }


//////////////////////////////////// CONSULTA ///////////////////////////////////////////////////////////////////////////////////////////



    public  Map consultaListaErro(String cpfPessoa) {

        Map <HttpStatus, String> erros = new HashMap<>();

        if (cpfPessoa == null) {

            erros.put(HttpStatus.BAD_REQUEST, " Parâmetro não informado ");

        }
        else
        if (cpfPessoa.equals ("")) {

            erros.put(HttpStatus.NOT_ACCEPTABLE, "Parâmetro invalido" );

        }
        else
        if (cpfPessoa.length() != 11) {

            erros.put(HttpStatus.I_AM_A_TEAPOT, "Parâmetro invalido");

        }

        return erros;

    }


}
