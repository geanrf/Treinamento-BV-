package br.com.microprojeto.atomico.repository;

import br.com.microprojeto.atomico.entity.CadastrarPessoaDto;
import br.com.microprojeto.atomico.entity.Pessoa;

import java.util.List;

public interface PessoaRepository {

    String BUSCAR_POR_PESSOA_SQL = " Select = from pessoa.pessoa where cpf =";

    String CADASTRAR_PESSOA_SQL = "INSERT INTO pessoa.pessoa(nome, cpf, rg, logradouro, num_Logradouro, cep, ddd, telefone) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


    List<Pessoa> consultarPessoa(String cpf);

    int cadastrarPessoa(CadastrarPessoaDto cadastrarPessoa);
}
