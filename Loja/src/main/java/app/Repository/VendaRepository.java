package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.Entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

	public List<Venda> findByEndereco(String endereco);
	
	public List<Venda> findByValortotal(Integer valor);
	
	@Query("FROM Venda v WHERE p.valorTotal > :valorTotal")
	public List<Venda> findByVendaalta(Integer valor);
	
}
