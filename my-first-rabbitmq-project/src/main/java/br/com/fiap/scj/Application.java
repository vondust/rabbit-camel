package br.com.fiap.scj;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		Pessoa gabiru = Pessoa.builder().cpf("123.456.789-00").nome("gabiru").idade(33).build();
		Pessoa carlos = Pessoa.builder().cpf("888.888.888-88").nome("carlos").idade(37).build();
		Arrays.asList(gabiru, carlos).forEach(pessoa -> System.out.println(pessoa.apresentar()));

		return null;
	}

}
