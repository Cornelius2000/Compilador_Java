class Interpretador{
	private int i;
	private Variavel[] vari;
	public Operador o;
	public char op;
	private String[] operaçaoMatematica = {"+","-","*","/","%"};
	public int[] valorInt;
	public double[] valorDbl;


	public Interpretador(){
		this.o = new Operador();
		this.valorInt = new int[2];
		for (int y=0;y<2;y++){this.valorInt[y]=-1;}
		this.valorDbl = new double[2];
		for (int y=0;y<2;y++){this.valorDbl[y]=-1.1;}
		this.vari = new Variavel[15];
		for (int i=0;i<this.vari.length;i++){
			this.vari[i] = new Variavel();
		}
	}
	public void limpaValor(){//serve para limpar os valores que serão feitas as operações
		this.valorInt = new int[2];
		for (int y=0;y<2;y++){this.valorInt[y]=-1;}
	}
	public void setOperador(char c){//fica armazenado a operaçao que sera feita
		this.op = c;
	}
	public void setValoresInt(int v,int i){//colocar os valores Inteiros das operações
		this.valorInt[i] = v;
	}
	public void setValoresDbl(double v,int i){//colocar os valores Double das operações
		this.valorDbl[i] = v;
	}
	public void setVari(Variavel[] v){
		this.vari = v;
	}
	public Variavel[] getVari(){
		return this.vari;
	}
	public void desvOperaçaoDbl(int i){//aqui vai ser verificado qual é a operação a ser feita, ***SOMENTE PARA INTEIROS, FALTA COMPLETAR
		if (this.op == '+'){
			//System.out.println("eae "+this.valorInt[0]+" "+this.valorInt[1]);
			o.setSoma1(this.valorDbl[0],this.valorDbl[1]);
			this.vari[i].valorQuebrado = o.soma1;
		}
		if (this.op == '-'){
			o.setDiminui1(this.valorDbl[0],this.valorDbl[1]);
			this.vari[i].valorQuebrado = o.diminui1;
		}
		if (this.op == '*'){
			o.setMultiplica1(this.valorDbl[0],this.valorDbl[1]);
			this.vari[i].valorQuebrado = o.multiplica1;
		}
		if (this.op == '/'){
			o.setDivisao1(this.valorDbl[0],this.valorDbl[1]);
			this.vari[i].valorQuebrado = o.divisao1;
		}
		if (this.op == '%'){
			o.setResto1(this.valorDbl[0],this.valorDbl[1]);
			this.vari[i].valorQuebrado = o.resto1;
		}
		if (this.op == '!'){
			o.setDivisaoInteira1(this.valorDbl[0],this.valorDbl[1]);
			this.vari[i].valorInteiro = (int)o.divisaoInteira1;
		}
	}
	public void desvOperaçaoInt(int i){//aqui vai ser verificado qual é a operação a ser feita, ***SOMENTE PARA INTEIROS, FALTA COMPLETAR
		if (this.op == '+'){
			//System.out.println("eae "+this.valorInt[0]+" "+this.valorInt[1]);
			o.setSoma(this.valorInt[0],this.valorInt[1]);
			this.vari[i].valorInteiro = o.soma;
		}
		if (this.op == '-'){
			o.setDiminui(this.valorInt[0],this.valorInt[1]);
			this.vari[i].valorInteiro = o.diminui;
		}
		if (this.op == '*'){
			o.setMultiplica(this.valorInt[0],this.valorInt[1]);
			this.vari[i].valorInteiro = o.multiplica;
		}
		if (this.op == '/'){
			o.setDivisao(this.valorInt[0],this.valorInt[1]);
			this.vari[i].valorQuebrado = o.divisao;
		}
		if (this.op == '%'){
			o.setResto(this.valorInt[0],this.valorInt[1]);
			this.vari[i].valorInteiro = o.resto;
		}
		if (this.op == '!'){
			o.setDivisaoInteira(this.valorInt[0],this.valorInt[1]);
			this.vari[i].valorInteiro = o.divisaoInteira;
		}
	}
	public void imprime(){
		for (int x=0;x < this.vari.length;x++){
			if ((this.vari[x].nome != "@")&&(this.vari[x].valorInteiro != -99)){
				System.out.println(this.vari[x].nome+" "+this.vari[x].valorInteiro);
			}
			if ((this.vari[x].nome != "@")&&(this.vari[x].valorQuebrado != -99)){
				System.out.print(this.vari[x].nome+" ");
				System.out.printf("%.2f %n", this.vari[x].valorQuebrado);
			}
		}
		//System.out.println(this.op);
	}
}
