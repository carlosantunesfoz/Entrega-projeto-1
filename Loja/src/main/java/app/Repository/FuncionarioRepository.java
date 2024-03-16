package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.Entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	public List<Funcionario> findByNome(String nome);
	
	public List<Funcionario> findByIdade(Integer idade);
	
	
	@Query("FROM Funcionario f WHERE f.matricula < :matricula")
	public List<Funcionario> findByMatriculamenor(int matricula);
	
}
