package br.com.fiap.scj;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;

public class IntegrarFilasRouter extends RouteBuilder {

	@Value("{route.fiap.input.endpoint}")
	private String endpointInput;

	@Value("{route.fiap.output.endpoint}")
	private String endpointOutput;

	@Override
	public void configure() throws Exception {
		from(endpointInput)
		.tracing()
		.log("input >>>>> ${body}")
		.doTry()
			.process(exchange -> exchange.getIn().getBody())
		.to(endpointOutput)
		.log("output >>>>> ${body}")
		.doCatch(RuntimeException.class)
			.setBody(constant("${body}"))
			.log("Message to be sent: ${body}")
			.log("Erro!")
		.end();
	}
}
