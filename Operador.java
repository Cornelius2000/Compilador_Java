class Operador{
	public int soma, diminui, multiplica, divisao, resto;
	public double soma1, diminui1, multiplica1, divisao1, resto1;

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
		this.divisao = a / b;
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
}