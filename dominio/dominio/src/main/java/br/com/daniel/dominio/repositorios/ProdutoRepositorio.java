package br.com.daniel.dominio.repositorios;

import br.com.daniel.dominio.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {
}
