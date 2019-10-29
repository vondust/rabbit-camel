package br.com.fiap.scj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString(exclude = { "cpf" })
@EqualsAndHashCode
@Builder
public class Pessoa {

	private String cpf;

	@Getter
	private String nome;

	@Getter
	private int idade;

	public String apresentar() {
		return String.format("Prazer, meu nome é %s e tenho %s anos", this.nome, this.idade);
	}
}
