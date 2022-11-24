package br.com.daniel.dominio.repositorios;

import br.com.daniel.dominio.entidades.OrdemItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemItemRepositorio extends JpaRepository<OrdemItem, Long> {
}
