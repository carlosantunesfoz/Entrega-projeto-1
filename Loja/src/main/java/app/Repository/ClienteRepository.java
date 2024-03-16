package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.Entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	public Cliente findByTelefone(int telefone);
	
	public Cliente findByNome(String nome);

	
	/*@Query("FROM Cliente c WHERE c.idade < :idade")
	public List<Cliente> findByIdademaior(int idade);*/
}