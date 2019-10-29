package br.com.fiap.scj;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Produtor implements CommandLineRunner{

	private final RabbitTemplate rabbitTemplate;
	
	public Produtor(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("sending message...");
		this.rabbitTemplate.convertAndSend("fiap.scj.messages", null, "Hello from GABIRU!");
	}

}
