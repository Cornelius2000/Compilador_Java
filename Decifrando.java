class Decifrando{
	private char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private char[] numeros = {'0','1','2','3','4','5','6','7','8','9','.'};
	private char[] operaçoes = {'+','-','*','/','%','!'};
	private char[] importante = {'(',')','=',':','{','}','"'};
	private char[] nome;
	private char[] valor;
	private char iff,passouIgual,retornoMetodos,operacao,num,alfa;
	private int val,incremento,qntAspas=0;
	public String nomeFinal,valorFinal,bla,controlador;
	public char[] condicao;
	public boolean temVariavel=false, aspas = false;

	public Decifrando(){
		this.passouIgual='N';
		this.incremento=-1;
		this.val=0;
		this.nomeFinal="";
		this.valorFinal="";
		this.nome = new char[15];
		this.valor = new char[15];
		for (int i=0;i<nome.length;i++){
			this.nome[i]='@';
		}
		for (int i=0;i<valor.length;i++){
			this.valor[i]='@';
		}
	}

	public char cheqDados(char n){
		/*if(this.nome == "if"){ //se o nome for igual a if ele pega os parametros
			iff = true;
		}*/
		/*if(iff == true){
			ifResult = cheqIf(n); //chama o cheqIf para jogar guardar os parametros dentro do vetor, para usar depois
			if(ifResult == false){// se for falso, quer dizer que os parametros acabaram, portanto não chama mais
				iff = false;
			}
		}*/

		incremento++;
		//System.out.println(incremento);
		while (n != ';'){ // enquanto o caracter for diferente de ";", ele entra neste while
			this.nomeFinal="";
			this.valorFinal="";
			for (int i=0;i<importante.length;i++){// anda pelo vetor importante para ver se n não é um caracter diferente
				if (n == importante[i]){
					retornoMetodos = cheqChar(n); //chama a função cheqChar, desta mesma classe
					return retornoMetodos;
				}
			}
			retornoMetodos = setAlf(n,incremento);// se chegar aqui é pq não é um caracter importante, entao chama a setAlf,que vai procurar se é uma letra
			if (retornoMetodos == '1'){retornoMetodos = setNumero(n,incremento);} //se o retorno for 1, é pq não é uma letra, entao chama o setInt, para ver se é um numero
			if (retornoMetodos == 'O'){ // se for O, é pq é um operador, entao chama a classe setOpe
				retornoMetodos = setOpe(n);
				if (retornoMetodos != '1'){return n;}//se o retorno for diferente de 1, quer dizer que foi encontrado um operador
			}
			return 'P';
		}
		return 'F';
	}

	/*public char cheqIf(char n){
		this.condicao = n; //armazena as condições(parametros) do if dentro do vetor
		if(n == ")"){//se for ) quer dizer que if acabou seus paremetros
			return false;
		}
		return true;
	}

	public String getCondicao(){
		return this.condicao;
	}
	*/
	public char setAlf(char n,int incremento){
		for (int x=0;x<26;x++){ // percorre o vetor alfabeto para ver se é uma letra
			alfa = alfabeto[x];
			if (n == this.alfa){
				if (this.passouIgual == 'S'){
					temVariavel = true;
					setNome(n,incremento); //manda para a função que salva os caracters no vetor
					//System.out.println(n+"   eaeaeeeae    "+getNome());
					return '0';
				}
				setNome(n,incremento); //manda para a função que salva os caracters no vetor
				return '0';
			}
		}
		return '1';
	}
	public char setNumero(char n,int incremento){
		for (int x=0;x<11;x++){
			num = numeros[x];
			if (n==num){
				if (this.passouIgual == 'S'){
					setValor(n,incremento); //manda para função que salva os numeros
					return '0';
				}
				setNome(n,incremento);
			}
		}
		return 'O';
	}
	public char setOpe(char n){
		for (int x=0;x<6;x++){
			this.operacao = operaçoes[x];
			if (n == this.operacao){
				return n;// retorna o operador;
			}
		}
		return '1';
	}
	/* Nesta função ja foi implementado o "imp(variavel)",
	porem falta implementar quando for para imprimir algo que estiver dentro de aspas. exe:"imp("valor = ")"*/

	public char cheqChar(char n){//aqui só entra se for um caracter especial, ****FALTA TERMINAR***
		if (n == '='){
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
		}
		if (n == ')'){
			bla = getNome();
			return 'B';
		}
		if (n == '"'){
			qntAspas ++;
			if (qntAspas > 1){return 'P';}
			aspas = true;
			limpaNome();
			return 'A';
		}
		return 'P';
	}
	public void setValor(char n,int i){//vai salvar os caracters dentro do vetor
		this.valor[i]=n;
	}
	public void setNome(char n,int i){//vai salvar os caracters dentro do vetor
		this.nome[i]=n;
	}
	public String getNome(){//retorna somente o nome
		for (int i=0;i<this.nome.length;i++){
			if (this.nome[i] != '@'){
				this.nomeFinal=this.nomeFinal+this.nome[i];
				if (this.nomeFinal == "int"){return "tipo";}
			}
		}
		return this.nomeFinal;
	}
	public String getValor(){ //retorna o valor(em String)
		for (int i=0;i<this.valor.length;i++){
			if (this.valor[i] != '@'){this.valorFinal=this.valorFinal+this.valor[i];}
		}
		if (this.valorFinal == ""){return "000";}
		return this.valorFinal;
	}
	public void limpaVal(){//limpa o vetor Valor
		this.incremento = -1;
		this.valor = new char[15];
		for (int i=0;i<valor.length;i++){this.valor[i]='@';}
	}
	public void limpaNome(){//limpa o vetor nome
		temVariavel = false;
		bla = "";
		this.incremento = -1;
		this.nome = new char[15];
		for (int i=0;i<nome.length;i++){this.nome[i]='@';}
	}
	public void limpaVet(){// limpa os dois
		qntAspas = 0;
		aspas = false;
		temVariavel = false;
		controlador = "";
		this.passouIgual = 'N';
		this.incremento = -1;
		this.nome = new char[15];
		for (int i=0;i<nome.length;i++){this.nome[i]='@';}
		this.valor = new char[15];
		for (int i=0;i<valor.length;i++){this.valor[i]='@';}
	}
}
