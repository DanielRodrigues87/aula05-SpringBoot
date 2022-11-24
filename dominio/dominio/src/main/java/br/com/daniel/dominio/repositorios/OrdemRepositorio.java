package br.com.daniel.dominio.repositorios;

import br.com.daniel.dominio.entidades.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemRepositorio extends JpaRepository<Ordem,Long> {
}
