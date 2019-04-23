class Interpretador{
	private Variaveis[] vari;
	//public Operaçoes op;
	private String[] operaçaoMatematica = {"+","-","*","/","%"};

	public Interpretador(){
		//this.op = new Operaçoes();
		this.vari = new Variaveis[5];
		for (int i=0;i<this.vari.length;i++){
			this.vari[i] = new Variaveis();
		}
	}
	public void setVari(Variaveis[] v){
		this.vari = v;
	}
	public Variaveis[] getVari(){
		return this.vari;
	}
	public void imprime(){
		for (int x=0;x < this.vari.length;x++){
			System.out.println(this.vari[x].nome+" "+this.vari[x].valor);
		}
	}
}