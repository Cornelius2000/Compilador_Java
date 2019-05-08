class Operador{
	public int soma, diminui, multiplica, resto, divisaoInteira;
	public double soma1, diminui1, multiplica1, divisao1, resto1, divisao, divisaoInteira1;

	public Operador(){
		this.soma = 0;
		this.diminui = 0;
		this.multiplica = 0;
		this.divisao = 0;
		this.divisaoInteira = 0;
		this.resto = 0;
		this.soma1 = 0.0;
		this.diminui1 = 0.0;
		this.multiplica1 = 0.0;
		this.divisao1 = 0.0;
		this.resto1 = 0.0;
		this.divisaoInteira1 = 0.0;
	}
	public void setSoma(int a,int b){
		this.soma = a + b;
	}
	public void setDiminui(int a,int b){
		this.diminui = a - b;
	}
	public void setMultiplica(int a,int b){
		this.multiplica = a * b;
	}
	public void setDivisao(int a,int b){
		this.divisao = ((double )a / b);
	}
	public void setResto(int a,int b){
		this.resto = a % b;
	}
	public void setSoma1(double a,double b){
		this.soma1 = a + b;
	}
	public void setDiminui1(double a,double b){
		this.diminui1 = a - b;
	}
	public void setMultiplica1(double a,double b){
		this.multiplica1 = a * b;
	}
	public void setDivisao1(double a,double b){
		this.divisao1 = a / b;
	}
	public void setResto1(double a,double b){
		this.resto1 = a % b;
	}
	public void setDivisaoInteira(int a,int b){
		this.divisaoInteira = a / b;
	}
	public void setDivisaoInteira1(double a,double b){
		this.divisaoInteira1 = a / b;
	}
}