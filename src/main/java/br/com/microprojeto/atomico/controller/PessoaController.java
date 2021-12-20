package br.com.microprojeto.atomico.controller;

import br.com.microprojeto.atomico.business.RuleToTest;
import br.com.microprojeto.atomico.entity.CadastrarPessoaDto;
import br.com.microprojeto.atomico.entity.Pessoa;
import br.com.microprojeto.atomico.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;


    @Autowired
    RuleToTest motorDeRegras;



    @PostMapping(path = "/cadastrar")

    public ResponseEntity <Void> cadastrarPessoa(@RequestBody CadastrarPessoaDto pessoa) {

        Map BAD_REQUEST = motorDeRegras.cadastroListaErros(pessoa);

        pessoaService.cadastrarPessoa(pessoa);

        if(BAD_REQUEST.isEmpty()) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else {

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


    @GetMapping(path = "/consultar/{cpfPessoa}")
    public ResponseEntity<List<Pessoa>> consultarPessoa(@PathVariable String cpfPessoa) {


        Map BAD_REQUEST = motorDeRegras.consultaListaErro(cpfPessoa);

        if(BAD_REQUEST.isEmpty()) {

            return new ResponseEntity<>(pessoaService.consultarPessoa(cpfPessoa), HttpStatus.OK);
        }
        else{

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }




}
