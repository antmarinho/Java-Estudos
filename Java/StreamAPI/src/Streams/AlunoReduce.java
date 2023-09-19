package Streams;

import java.util.Objects;

public class AlunoReduce {
	
	final String nome;
	final double nota;
	final boolean bComport;
	
	public AlunoReduce(String nome, double nota) {
		
		this(nome,nota,true);

	}

	public AlunoReduce(String nome, double nota, boolean bComport) {
		
		this.nome = nome;
		this.nota = nota;
		this.bComport = bComport;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(bComport, nome, nota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoReduce other = (AlunoReduce) obj;
		return bComport == other.bComport && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(nota) == Double.doubleToLongBits(other.nota);
	}

	
	
	
}
