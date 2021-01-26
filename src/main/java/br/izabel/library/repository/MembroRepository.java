package br.izabel.library.repository;

import br.izabel.library.domain.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<Membro, Integer> {
}
