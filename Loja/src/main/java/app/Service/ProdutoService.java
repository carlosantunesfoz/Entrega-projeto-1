package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Funcionario;
import app.Entity.Produto;
import app.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public String save (Produto produto) {
		this.produtoRepository.save(produto);
		return produto.getNome()+ "Produto adcionado com sucesso";
	}
	
	public String update(long id, Produto produto) {
		produto.setId(id);
		this.produtoRepository.save(produto);
		return "Alteramos o produto com sucesso";
	}
	
	public List<Produto> listAll() {
		return this.produtoRepository.findAll();
	}
	
	public Produto findById(Long id) {
		var produto = this.produtoRepository.findById(id).get();
		return produto;
	}
	
	public List<Produto> findByNome(String nome){
		var produto =  this.produtoRepository.findByNome(nome);
		return produto;
	}
	
	public List<Produto> findByValor(Integer valor){
		var produto =  this.produtoRepository.findByValor(valor);
		return produto;
	}
	
	public List<Produto> findByProdutocaro(int valor){
		return this.produtoRepository.findByProdutocaro(valor);
	}
	
	public String delete(Long id) {
		this.produtoRepository.deleteById(id);
		return "produto retirado com sucesso";
	}
}
