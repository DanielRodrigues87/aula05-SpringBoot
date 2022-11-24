package br.com.daniel.dominio;

import br.com.daniel.dominio.entidades.*;
import br.com.daniel.dominio.repositorios.ClienteRepositorio;
import br.com.daniel.dominio.repositorios.OrdemItemRepositorio;
import br.com.daniel.dominio.repositorios.OrdemRepositorio;
import br.com.daniel.dominio.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication
public class DominioApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@Autowired
	private OrdemRepositorio ordemRepositorio;

	@Autowired
	private OrdemItemRepositorio ordemItemRepositorio;




	public static void main(String[] args) {
		SpringApplication.run(DominioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente c1 = new Cliente(null,"Gabriela Anjos","gabi@gmail.com");

		clienteRepositorio.save(c1);

		Produto p1 = new Produto(null, "TV", 1000.0);
		Produto p2 = new Produto(null, "Mouse", 40.0);
		Produto p3 = new Produto(null, "PC", 1200.0);

		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3));

		Ordem o1 = new Ordem(null, Instant.parse("2021-04-18T11:25:09Z"), OrderStatus.PAID,c1);
		Ordem o2 = new Ordem(null, Instant.parse("2021-04-20T13:30:00Z"), OrderStatus.WAITING, c1);

		ordemRepositorio.saveAll(Arrays.asList(o1,o2));

		OrdemItem i1 = new OrdemItem(null, 1, 1000.0, p1, o1);
		OrdemItem i2 = new OrdemItem(null, 2, 40.0, p2, o1);
		OrdemItem i3 = new OrdemItem(null, 1, 40.0, p2, o2);
		OrdemItem i4 = new OrdemItem(null, 1, 1200.0, p3, o2);

		ordemItemRepositorio.saveAll(Arrays.asList(i1, i2, i3, i4));

	}
}
