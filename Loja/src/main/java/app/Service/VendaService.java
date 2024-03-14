package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Venda;
import app.Repository.VendaRepository;

@Service
public class VendaService {
	@Autowired
	private VendaRepository vendaRepository;
	
	public String save(Venda venda) {
		this.vendaRepository.save(venda);
		return venda.getValorTotal()+ "vendido com sucesso";
	}
	
	public String update(long id, Venda venda) {
		venda.setId(id);
		this.vendaRepository.save(venda);
		return "Alteramos os dados da venda com sucesso";
	}
	
	public List<Venda> listAll() {
		return this.vendaRepository.findAll();
	}
	
	public Venda findById (long id) {
		var venda = this.vendaRepository.findById(id).get();
		return venda;
	}
	
	public String delete(long id) {
		this.vendaRepository.deleteById(id);
		return "cancelamos a venda com sucesso";
	}
	
}
