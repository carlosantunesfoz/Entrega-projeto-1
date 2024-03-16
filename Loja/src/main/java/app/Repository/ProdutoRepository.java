package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.Entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findByNome(String nome);
	
	public List<Produto> findByValor(Integer valor);
	
	@Query("FROM Produto p WHERE p.valor > :valor")
	public List<Produto> findByProdutocaro(int valor);
}
