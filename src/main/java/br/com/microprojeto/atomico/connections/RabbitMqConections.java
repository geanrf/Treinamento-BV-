package br.com.microprojeto.atomico.connections;

import br.com.microprojeto.atomico.constantes.RabbitmqConstantes;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class RabbitMqConections {

    private static final String  NOME_EXCHANGE = "amq_direct";

    private AmqpAdmin amqpAdmin;

    public RabbitMqConections(AmqpAdmin amqpAdmin){

        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila (String nomeFila){

        return new Queue(nomeFila, true, false, false );


    }

    private DirectExchange trocaDireta(){

        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding relacionamento(Queue fila, DirectExchange troca){
       return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null );
    }

    @PostConstruct
    private void adiciona(){

        Queue filaRetorno = this.fila(RabbitmqConstantes.FILA_RETORNO);
        Queue filaCadastro = this.fila(RabbitmqConstantes.FILA_CADASTRO);


        DirectExchange troca = this.trocaDireta();

        Binding ligacaoCadastro = this.relacionamento(filaCadastro, troca);
        Binding ligacaoRetorno = this.relacionamento(filaRetorno, troca);


        //Criação das filas no RabbitMQ
        this.amqpAdmin.declareQueue(filaCadastro);
        this.amqpAdmin.declareQueue(filaRetorno);


        this.amqpAdmin.declareExchange(troca);

        this.amqpAdmin.declareBinding(ligacaoCadastro);
        this.amqpAdmin.declareBinding(ligacaoRetorno);

    }


}
