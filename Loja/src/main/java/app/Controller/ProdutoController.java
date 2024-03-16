package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Produto;
import app.Service.ProdutoService;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {
	
	@Autowired
	public ProdutoService produtoService;
	
	@PostMapping("/save")
	public ResponseEntity <String> save(@RequestBody Produto produto){
		try {
			String mensagem = this.produtoService.save(produto);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("erro: "+e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Produto produto
			, @PathVariable long id) {
		try {
			String mensagem = this.produtoService.update(id, produto);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
	
		} catch (Exception e) {
			return new ResponseEntity<String>("erro: "+e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Produto>> listAll(){
		try {
			List<Produto> lista = this.produtoService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Produto> findById(@PathVariable long id){
		try {
			Produto produto = this.produtoService.findById(id);
			return new ResponseEntity<>(produto, HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNome/{nome}")
	public ResponseEntity<List<Produto>> findByNome (@PathVariable String nome){
		
		try {
			
			List<Produto> lista = this.produtoService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/findByValor/{valor}")
	public ResponseEntity<List<Produto>> findByValor (@PathVariable Integer valor){
		
		try {
			
			List<Produto> lista = this.produtoService.findByValor(valor);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/findByProdutocaro/{valor}")
	public ResponseEntity<List<Produto>> findByProdutocaro (@PathVariable int valor){
		
		try {
			
			List<Produto> lista = this.produtoService.findByProdutocaro(valor);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}
		
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String mensagem = this.produtoService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}
}
