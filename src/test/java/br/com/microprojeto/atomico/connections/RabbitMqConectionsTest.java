package br.com.microprojeto.atomico.connections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.AmqpAdmin;


@ExtendWith(MockitoExtension.class)
class RabbitMqConectionsTest {

    @InjectMocks
    RabbitMqConections rabbitMqConections;

    @Mock
    AmqpAdmin amqpAdmin;

    @Test
    public void deveConectar() {

    RabbitMqConections rabbitMqConections = new RabbitMqConections(amqpAdmin);

    }

}