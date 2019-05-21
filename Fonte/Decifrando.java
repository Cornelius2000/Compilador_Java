import java.util.ArrayList;

class Decifrando{
	public Condicional cond = new Condicional();
	private char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private char[] numeros = {'0','1','2','3','4','5','6','7','8','9','.'};
	private char[] operaçoes = {'+','-','*','/','%','!'};
	private char[] importante = {'(',')','=',':','{','}','"','>','<'};
	public ArrayList< Character > nome,valor,parametro;
	private char passouIgual,retornoMetodos,operacao,num,alfa;
	public int val,qntAspas=0,interador=0;
	public String nomeFinal,valorFinal,bla,controlador;
	public boolean temVariavel=false,aspas = false,importa = false,numero = false;

	public Decifrando(){
		this.passouIgual='N';
		this.val=0;
		this.nomeFinal="";
		this.valorFinal="";
		this.nome = new ArrayList< Character >();
		this.valor = new ArrayList< Character >();
		this.parametro = new ArrayList< Character >();
	}

	public char cheqDados(char n){
		while (n != ';'){ // enquanto o caracter for diferente de ";", ele entra neste while
			this.nomeFinal="";
			this.valorFinal="";
			for (int i=0;i<importante.length;i++){// anda pelo vetor importante para ver se n não é um caracter diferente
				if (n == importante[i]){
					importa = true;
					retornoMetodos = cheqChar(n); //chama a função cheqChar, desta mesma classe
					return retornoMetodos;
				}
			}
			retornoMetodos = setAlf(n);// se chegar aqui é pq não é um caracter importante, entao chama a setAlf,que vai procurar se é uma letra
			if (retornoMetodos == '1'){retornoMetodos = setNumero(n);} //se o retorno for 1, é pq não é uma letra, entao chama o setInt, para ver se é um numero
			if (retornoMetodos == 'O'){ // se for O, é pq é um operador, entao chama a classe setOpe
				retornoMetodos = setOpe(n);
				if (retornoMetodos != '1'){return n;}//se o retorno for diferente de 1, quer dizer que foi encontrado um operador
			}
			return 'P';
		}
		return 'F';
	}
	public char setAlf(char n){
		for (int x=0;x<26;x++){ // percorre o vetor alfabeto para ver se é uma letra
			alfa = alfabeto[x];
			if (n == this.alfa){
				if ((importa == true)&&(cond.operadorIF == true)){
					parametro.add(n);
					return '0';
				}
				if (this.passouIgual == 'S'){
					temVariavel = true;
					setNome(n); //manda para a função que salva os caracters no vetor
					return '0';
				}
				setNome(n); //manda para a função que salva os caracters no vetor
				return '0';
			}
		}
		return '1';
	}
	public char setNumero(char n){
		for (int x=0;x<11;x++){
			num = numeros[x];
			if (n==num){
				if ((importa == true)&&(cond.operadorIF == true)){
					parametro.add(n);
					numero = true;
					return '0';
				}
				if (this.passouIgual == 'S'){
					setValor(n); //manda para função que salva os numeros
					return '0';
				}
				setNome(n);
			}
		}
		return 'O';
	}
	public char setOpe(char n){
		for (int x=0;x<6;x++){
			this.operacao = operaçoes[x];
			if (n == this.operacao){return n;}// retorna o operador;
		}
		return '1';
	}
	/* Nesta função ja foi implementado o "imp(variavel)",
	porem falta implementar quando for para imprimir algo que estiver dentro de aspas. exe:"imp("valor = ")"*/

	public char cheqChar(char n){//aqui só entra se for um caracter especial, ****FALTA TERMINAR***
		if (n == '{'){
			cond.decifraOperador();
		}
		if (n == '='){
			if (cond.operadorIF == true){cond.op1.add(n);}
			this.passouIgual = 'S';
			return 'I';
		}
		if (n == '('){
			bla = getNome();
			if (bla.equals("imp")){
				controlador = bla;
				limpaNome();
				return 'P';
			}
			if (bla.equals("se")){
				limpaNome();
				cond.operadorIF = true;
				return 'P';
			}
		}
		if (n == ')'){
			bla = getNome();
			if (cond.operadorIF == true){return 'C';}
			if (bla == ""){aspas = true;}
			return 'B';
		}
		if (n == '"'){
			qntAspas ++;
			if (qntAspas > 1){
				aspas = false;
				limpaNome();
				return 'P';
			}
			aspas = true;
			limpaNome();
			return 'A';
		}
		if (n == '>'){
			if (cond.operadorIF == true){
				cond.op1.add(n);
				return 'C';
			}
		}
		if (n == '<'){
			if (cond.operadorIF == true){
				cond.op1.add(n);
				return 'C';
			}
		}
		return 'P';
	}
	public void setParametro(double d){
		if(interador>1){interador=0;}
		cond.parametro[interador] = d;
		interador++;
	}
	public void setValor(char n){//vai salvar os caracters dentro do vetor
		this.valor.add(n);
	}
	public void setNome(char n){//vai salvar os caracters dentro do vetor
		this.nome.add(n);
	}
	public String getNome(){//retorna somente o nome
		for (int i=0;i<this.nome.size();i++){
			this.nomeFinal += nome.get(i);
		}
		return this.nomeFinal;
	}
	public String getValor(){ //retorna o valor(em String)
		for (int i=0;i<this.valor.size();i++){
			this.valorFinal += valor.get(i);
		}
		return this.valorFinal;
	}
	public void limpaVal(){//limpa o vetor Valor
		this.valor.clear();
	}
	public void limpaNome(){//limpa o vetor nome
		temVariavel = false;
		bla = "";
		this.nome.clear();
	}
	public void limpaVet(){// limpa os dois
		qntAspas = 0;
		aspas = false;
		temVariavel = false;
		controlador = "";
		importa = false;
		numero = false;
		this.passouIgual = 'N';
		this.nome.clear();
		this.valor.clear();
	}
	public void clearCondional(){
		cond.retornoIF = true;
		cond.operadorIF = false;
		cond.op = "";
		cond.condicaoIF.clear();
		cond.op1.clear();
	}
	public boolean getCondicional(){
		return cond.retornoIF;
	}
}
