package modelo.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity	
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	 //relacionamento 1 pra 1 ele vai criar a chave 
	//estrangeira de assento na tabela cliente
	@OneToOne(cascade = CascadeType.PERSIST) //pra fazer operecoa em cascada(incluir editar deletar) mais de 1 com {}
	@JoinColumn(name = "assento_id", unique = true) //para n ter repetido so 1 por assento
	private Assento assento;
	
	public Cliente() {
		
	}

	public Cliente(String nome, Assento assento) {
		
		this.nome = nome;
		this.assento = assento;
		
	}

	public Long getId() {
		
		return id;
	}

	public void setId(Long id) {
		
		this.id = id;
	}

	public String getNome() {
		
		return nome;
	}

	public void setNome(String nome) {
		
		this.nome = nome;
	}

	public Assento getAssento() {
		
		return assento;
	}

	public void setAssento(Assento assento) {
		
		this.assento = assento;
	}
	
	
}
