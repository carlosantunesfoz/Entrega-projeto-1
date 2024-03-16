package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Funcionario;
import app.Repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public String save(Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
		return "adcionamos o novato";
	}
	
	public String update(long id, Funcionario funcionario) {
		funcionario.setId(id);
		this.funcionarioRepository.save(funcionario);
		return "Alteramos os dados cadastrais";
	}
	
	public List<Funcionario> listAll() {
		return this.funcionarioRepository.findAll();
	}
	
	public Funcionario findById(long id) {
		var funcionario = this.funcionarioRepository.findById(id).get();
		return funcionario;
	}
	
	public List<Funcionario> findByNome(String nome){
		var funcionario = this.funcionarioRepository.findByNome(nome);
		return funcionario;
	}
	
	public List<Funcionario> findByIdade(Integer idade){
		var funcionario = this.funcionarioRepository.findByIdade(idade);
		return funcionario;
	}
	
	public List<Funcionario> findByMatriculamenor(int matricula){
		return this.funcionarioRepository.findByMatriculamenor(matricula);
	}
	
	public String delete (long id) {
		this.funcionarioRepository.deleteById(id);
		return "demitido com sucesso";
	}
}
