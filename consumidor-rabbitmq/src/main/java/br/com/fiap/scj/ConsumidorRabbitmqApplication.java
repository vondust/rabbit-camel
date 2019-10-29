package br.com.fiap.scj;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class ConsumidorRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumidorRabbitmqApplication.class, args);
	}

	@RabbitListener(queues = "fiap.scj.messages")
	public void receivedMessage(String message) {
		System.out.println("Mensagem recebida: " + message);
	}

}
