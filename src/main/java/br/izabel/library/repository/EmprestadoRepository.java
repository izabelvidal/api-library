package br.izabel.library.repository;

import br.izabel.library.domain.Emprestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestadoRepository extends JpaRepository<Emprestado, Integer> {
}
