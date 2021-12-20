package br.com.microprojeto.atomico.repository;

import br.com.microprojeto.atomico.entity.CadastrarPessoaDto;
import br.com.microprojeto.atomico.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Pessoa> consultarPessoa(String cpf) {

       return jdbcTemplate.query(BUSCAR_POR_PESSOA_SQL+(cpf), (rs, rowNum)
               -> new Pessoa(
                       rs.getString("id"),
                       rs.getString("nome"),
                       rs.getString("CPF"),
                       rs.getString("RG"),
                       rs.getString("logradouro"),
                       rs.getString("num_Logradouro"),
                       rs.getString("CEP"),
                       rs.getString("DDD"),
                       rs.getString("telefone")));
    }

	@Override
    public int cadastrarPessoa(CadastrarPessoaDto cadastrarPessoa) {

    	return jdbcTemplate.update(  CADASTRAR_PESSOA_SQL,
	    			cadastrarPessoa.getNome(),
	    			cadastrarPessoa.getCpf(),
	    			cadastrarPessoa.getRg(),
	    			cadastrarPessoa.getLogradouro(),
	    			cadastrarPessoa.getNumLogradouro(),
	    			cadastrarPessoa.getCep(),
	    			cadastrarPessoa.getDdd(),
	    			cadastrarPessoa.getTelefone());
    	
    }
    
  
    


}
