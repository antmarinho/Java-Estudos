package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//melhor estrategia e a joined
@Inheritance(strategy = InheritanceType.JOINED) //cria 2 tabela chave primaria vai como estrangeira pra outra tabela
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //cria uma tabela so jutanto o pai e os filhos
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AL") // pra saber se e aluno ou aluno bolsista na hora q criou no main
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //heranca table par classe cria uma tabela pra cada classe filho e 1 pai
public class Aluno {
	
	@Id
	private Long matricula;
	
	private String nome;
	
	
	public Aluno() {
		
		
	}

	public Aluno(Long matricula, String nome) {
		
		this.matricula = matricula;
		this.nome = nome;
		
	}

	public Long getMatricula() {
		
		return matricula;
	}

	public void setMatricula(Long matricula) {
		
		this.matricula = matricula;
	}

	public String getNome() {
		
		return nome;
	}

	public void setNome(String nome) {
		
		this.nome = nome;
	}


}
