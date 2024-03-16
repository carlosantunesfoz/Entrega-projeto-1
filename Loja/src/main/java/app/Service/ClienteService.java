package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Cliente;
import app.Repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public String save(Cliente cliente) {
		this.clienteRepository.save(cliente);
		return cliente.getNome()+ "Cliente adcionado com sucesso";
	}
	
	public String update(long id, Cliente cliente) {
		
		cliente.setId(id);
		this.clienteRepository.save(cliente);
		return "Alteramos seus dados com sucesso";		
	}
	
	public List<Cliente> listAll(){
		
		return this.clienteRepository.findAll();
	}
	
	public Cliente findById(long id) {
		
		var cliente = this.clienteRepository.findById(id).get();
		return cliente;
	}
	
	public Cliente findByTelefone(int telefone) {
		var cliente = this.clienteRepository.findByTelefone(telefone);
		return cliente;
	}
	
	/*public List<Cliente>findByIdademaior(int idade) {
		return this.clienteRepository.findByIdademaior(idade);
	}*/
	
	public Cliente findByNome(String nome) {
		var cliente = this.clienteRepository.findByNome(nome);
		return cliente;
	}
	
	public String delete(Long id) {		
		this.clienteRepository.deleteById(id);
		return "cliente removido do sismtema";
	}
}
