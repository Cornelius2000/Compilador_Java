class Interpretador{
	private Variavel[] vari;
	//public Operaçoes op;
	private String[] operaçaoMatematica = {"+","-","*","/","%"};

	public Interpretador(){
		//this.op = new Operaçoes();
		this.vari = new Variavel[5];
		for (int i=0;i<this.vari.length;i++){
			this.vari[i] = new Variavel();
		}
	}
	public void setVari(Variavel[] v){
		this.vari = v;
	}
	public Variavel[] getVari(){
		return this.vari;
	}
	public void imprime(){
		for (int x=0;x < this.vari.length;x++){
			System.out.println(this.vari[x].nome+" "+this.vari[x].valor);
		}
	}
}