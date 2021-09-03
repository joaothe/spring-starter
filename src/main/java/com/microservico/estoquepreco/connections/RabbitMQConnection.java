package com.microservico.estoquepreco.connections;

import com.microservico.estoquepreco.constantes.RabbitmqConstantes;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {
	private static final String NOME_EXCHANGE = "amq.direct";
	
	private Queue fila (String nomeFila) {
		return new Queue(nomeFila, true, false, false);
	}
	
	private DirectExchange trocaDireta() {
		return new DirectExchange(NOME_EXCHANGE);
	}
	
	private Binding relacionamento(Queue fila, DirectExchange troca) {
		return new Binding(fila.getName(), Binding.DestinationType.EXCHANGE, troca.getName(), fila.getName(), null);
	}
	
	private void adiciona() {
		Queue filaEstoque = this.fila(RabbitmqConstantes.FILA_ESTOQUE);
		Queue filaPreco = this.fila(RabbitmqConstantes.FILA_PRECO);
		
		DirectExchange troca = this.trocaDireta();
	}

}
