package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
