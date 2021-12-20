package br.com.microprojeto.atomico.service;


import br.com.microprojeto.atomico.constantes.RabbitmqConstantes;
import br.com.microprojeto.atomico.entity.CadastrarPessoaDto;
import br.com.microprojeto.atomico.entity.Pessoa;
import br.com.microprojeto.atomico.repository.PessoaRepositoryImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepositoryImpl pessoaRepo;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public List<Pessoa> consultarPessoa(String cpfPessoa) {

        return pessoaRepo.consultarPessoa(cpfPessoa);
    }

    public void cadastrarPessoa(CadastrarPessoaDto cadastrarPessoa) {
        try {
            pessoaRepo.cadastrarPessoa(cadastrarPessoa);
            rabbitTemplate.convertAndSend(RabbitmqConstantes.FILA_RETORNO, "Cadastro realizdo com sucesso");
        } catch (Exception e) {
            rabbitTemplate.convertAndSend(RabbitmqConstantes.FILA_RETORNO, "\nMensagem recebida.\nPorem erro ao persistir.");
        }
    }

}

