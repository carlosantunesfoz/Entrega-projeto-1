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

import app.Entity.Funcionario;
import app.Service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario/")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Funcionario funcionario) {
		try {
			String mensagem = this.funcionarioService.save(funcionario);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro:"+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Funcionario funcionario,
			@PathVariable long id){
		try {
			String mensagem = this.funcionarioService.update(id, funcionario);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("erro:"+e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Funcionario>> listAll(){
		try {
			List<Funcionario> lista = this.funcionarioService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{}")
	public ResponseEntity<Funcionario> findById(@PathVariable long id) {
		try {
			Funcionario funcionario = this.funcionarioService.findById(id);
			return new ResponseEntity<>(funcionario, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> delete(@PathVariable long id){
			try {
				String mensagem = this.funcionarioService.delete(id);
				return new ResponseEntity<>(mensagem, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>("Erro: "
						+e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
	
}
