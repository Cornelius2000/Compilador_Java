class Operador{
	public double soma, diminui, multiplica, divisao, resto, divisaoInteira;

	public Operador(){
		this.soma = 0;
		this.diminui = 0;
		this.multiplica = 0;
		this.divisao = 0;
		this.divisaoInteira = 0;
		this.resto = 0;
	}
	public void setSoma(double a,double b){
		this.soma = a + b;
	}
	public void setDiminui(double a,double b){
		this.diminui = a - b;
	}
	public void setMultiplica(double a,double b){
		this.multiplica = a * b;
	}
	public void setDivisao(double a,double b){
		this.divisao = ((double )a / b);
	}
	public void setResto(double a,double b){
		this.resto = a % b;
	}
	public void setDivisaoInteira(double a,double b){
		this.divisaoInteira = a / b;
	}
}