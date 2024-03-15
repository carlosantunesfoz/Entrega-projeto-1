package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	/*public List<Cliente> findByIdade(String idade);*/
	
}
