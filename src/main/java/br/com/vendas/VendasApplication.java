package br.com.vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import br.com.vendas.entity.Cliente;
import br.com.vendas.repository.ClienteRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.vendas.*" })
@EntityScan("br.com.vendas.*")
public class VendasApplication {
	
	@Bean
	public String init(@Autowired ClienteRepository repository) {
		Cliente cliente = new Cliente();
		cliente.setNome("Teste");
		repository.save(cliente);
		return "OK";
		
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
