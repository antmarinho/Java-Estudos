package Lambda;

@FunctionalInterface // so pode ter 1 metodo na interface pra associar a um funcao lambda
public interface Calculo {
	
	double executar(double a, double b);

}
