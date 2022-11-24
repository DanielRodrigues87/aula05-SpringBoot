package br.com.daniel.dominio.repositorios;

import br.com.daniel.dominio.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {
}
