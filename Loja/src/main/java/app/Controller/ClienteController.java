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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Cliente;
import app.Service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Cliente cliente){
	try {
		String mensagem = this.clienteService.save(cliente);
		return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		
	} catch (Exception e) {
		return new ResponseEntity<String>("Erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	}
		
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Cliente cliente, @PathVariable long id) {
		try {
			String mensagem = this.clienteService.update(id, cliente);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Cliente>> listAll(){
		try {
			List<Cliente> lista = this.clienteService.listAll();
			return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable long id){
		
		try {
			Cliente cliente = this.clienteService.findById(id);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByIdade/{telefone}")
	public ResponseEntity<Cliente> findByIdade(@RequestParam int telefone){
		try {
			Cliente cliente = this.clienteService.findByTelefone(telefone);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNome/{nome}")
	public ResponseEntity<Cliente> findByNome(@RequestParam String nome){
		try {
			Cliente cliente = this.clienteService.findByNome(nome);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findByIdademaior/{idade}")
	public ResponseEntity<List<Cliente>> findByIdadeMaior (@RequestParam int idade){
		try {
			List<Cliente> lista = this.clienteService.findByIdademaior(idade);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.clienteService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
