package br.com.microprojeto.atomico.consumer;

import br.com.microprojeto.atomico.constantes.RabbitmqConstantes;
import br.com.microprojeto.atomico.entity.CadastrarPessoaDto;
import br.com.microprojeto.atomico.service.PessoaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroConsumer {

    @Autowired
    private PessoaService pessoaService;

    @RabbitListener(queues = RabbitmqConstantes.FILA_CADASTRO)
    private void consumidor(String mensagem) throws JsonProcessingException {

        CadastrarPessoaDto cadastrarPessoaDto = (new Gson()).fromJson(mensagem, CadastrarPessoaDto.class);
        pessoaService.cadastrarPessoa(cadastrarPessoaDto);

    }


}
