package modelo.umparamuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import modelo.basico.Produto;

@Entity
@Table(name = "itens_pedidos")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int qtd;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private Double preco;
	
	@ManyToOne(fetch = FetchType.EAGER) // relacao 1 para N
	private Pedido pedido;
	
	@ManyToOne(fetch = FetchType.EAGER) //por padrao
	private Produto produto;
	
	
	public ItemPedido() {
		
		
	}

	public ItemPedido(int qtd, Pedido pedido, Produto produto) {
		
		this.qtd = qtd;
		this.setPedido(pedido);
		this.setProduto(produto);
		
	}

	public Long getId() {
		
		return id;
	}

	public void setId(Long id) {
		
		this.id = id;
	}

	public int getQtd() {
		
		return qtd;
	}

	public void setQtd(int qtd) {
		
		this.qtd = qtd;
	}

	public Double getPreco() {
		
		return preco;
	}

	public void setPreco(Double preco) {
		
		this.preco = preco;
	}

	public Pedido getPedido() {
		
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		
		this.pedido = pedido;
	}

	public Produto getProduto() {
		
		return produto;
	}

	public void setProduto(Produto produto) {
		
		this.produto = produto;
		
		if(produto != null && this.preco == null)
			this.setPreco(produto.getPreco());
		
	}
	

}
