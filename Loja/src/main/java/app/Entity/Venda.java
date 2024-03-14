package app.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String endereço;
	private Integer valorTotal;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	/*@JoinColumn(name = "cliente_id")
	@JsonIgnoreProperties("venda")*/
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("venda")
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "venda_produto")
	private List<Produto> produto;
}
