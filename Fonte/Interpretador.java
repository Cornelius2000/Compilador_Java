import java.util.ArrayList;

class Interpretador{
	private Variavel[] vari;
	public Operador o;
	public char operaçao;
	public ArrayList< Double > valor;


	public Interpretador(){
		this.o = new Operador();
		this.valor = new ArrayList< Double >();
		this.vari = new Variavel[15];
		for (int i=0;i<this.vari.length;i++){
			this.vari[i] = new Variavel();
		}
	}
	public void limpaValor(){//serve para limpar os valores que serão feitas as operações
		this.valor.clear();
	}
	public void setOperador(char c){//fica armazenado a operaçao que sera feita
		this.operaçao = c;
	}
	public void setValores(double v,int i){//colocar os valores Double das operações
		this.valor.add(v);
	}
	public void setVari(Variavel[] v){
		this.vari = v;
	}
	public Variavel[] getVari(){
		return this.vari;
	}
	public void desvOperaçao(int i){//aqui vai ser verificado qual é a operação a ser feita
		if (this.operaçao == '+'){
			o.setSoma(this.valor.get(0),this.valor.get(1));
			this.vari[i].valor = o.soma;
		}
		if (this.operaçao == '-'){
			o.setDiminui(this.valor.get(0),this.valor.get(1));
			this.vari[i].valor = o.diminui;
		}
		if (this.operaçao == '*'){
			o.setMultiplica(this.valor.get(0),this.valor.get(1));
			this.vari[i].valor = o.multiplica;
		}
		if (this.operaçao == '/'){
			o.setDivisao(this.valor.get(0),this.valor.get(1));
			this.vari[i].valor = o.divisao;
		}
		if (this.operaçao == '%'){
			o.setResto(this.valor.get(0),this.valor.get(1));
			this.vari[i].valor = o.resto;
		}
		if (this.operaçao == '!'){
			o.setDivisaoInteira(this.valor.get(0),this.valor.get(1));
			this.vari[i].valor = (int)o.divisaoInteira;
		}
	}
	public void imprime(){
		for (int x=0;x < this.vari.length;x++){
			if ((this.vari[x].nome != "@")&&(this.vari[x].valor != -99)){
				System.out.print(this.vari[x].nome+" ");
				System.out.printf("%.2f %n", this.vari[x].valor);
			}
		}
	}
}
