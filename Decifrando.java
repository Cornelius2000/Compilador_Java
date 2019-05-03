class Decifrando{
	private char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private char[] numeros = {'0','1','2','3','4','5','6','7','8','9'};
	private char[] operaçao = {'+','-','*','/','%'};
	private char[] importante = {'(',')','=',':','{','}',' '};
	private char[] nome;
	private char[] valor;
	private char c,c1,a,res,o;
	private int x,i,val,inc;
	public String nomeFinal,valorFinal,bla;

	public Decifrando(){
		this.x=0;
		this.c1='N';
		this.i=0;
		this.inc=-1;
		this.val=0;
		this.nomeFinal="";
		this.valorFinal="";
		this.nome = new char[15];
		for (i=0;i<nome.length;i++){this.nome[i]='@';}
		this.valor = new char[15];
		for (i=0;i<valor.length;i++){this.valor[i]='@';}
	}

	public char cheqDados(char n){
		inc++;
		//System.out.println(inc);
		while (n != ';'){ // enquanto o caracter for diferente de ";", ele entra neste while
			this.nomeFinal="";
			this.valorFinal="";
			for (i=0;i<importante.length;i++){// anda pelo vetor importante para ver se n não é um caracter diferente
				if (n == importante[i]){
					res = cheqChar(n); //chama a função cheqChar, desta mesma classe
					return res;
				}
			}
			res = setAlf(n,inc);// se chegar aqui é pq não é um caracter importante, entao chama a setAlf,que vai procurar se é uma letra
			if (res == 'I'){res = setInt(n,inc);} //se o retorno for 1, é pq não é uma letra, entao chama o setInt, para ver se é um numero
			if (res == 'O'){ // se for O, é pq é um operador, entao chama a classe setOpe
				res = setOpe(n);
				if (res != '1'){return n;}//se o retorno for diferente de 1, quer dizer que foi encontrado um operador
			}
			return 'P';
		}
		return 'F';
	}
	public char setAlf(char n,int inc){
		for (x=0;x<26;x++){ // percorre o vetor alfabeto para ver se é uma letra
			a = alfabeto[x];
			//System.out.println(n+" "+a);
			if (n == a){
				setNome(n,inc); //manda para a função que salva os caracters no vetor
				return '0';
			}
		}
		return 'I';
	}
	public char setInt(char n,int inc){
		for (x=0;x<10;x++){ 
			c = numeros[x];
			//System.out.println(n+" "+c);
			if (this.c1 == 'S'){
				if (n == c){
					setValor(n,inc); //manda para função que salva os numeros
					return '0';
				}
			}
			setNome(n,inc);
		}
		return 'O';
	}
	public char setOpe(char n){
		for (x=0;x<5;x++){ 
			o = operaçao[x]; 
			//System.out.println(n+" "+c);
			if (n == o){
				return n;// retorna o operador;
			}
		}
		return '1';
	}
	/* Nesta função ja foi implementado o "imp(variavel)",
	porem falta implementar quando for para imprimir algo que estiver dentro de aspas. exe:"imp("valor = ")"*/
	
	public char cheqChar(char n){//aqui só entra se for um caracter especial, ****FALTA TERMINAR***
		if (n == '='){
			this.c1 = 'S';
			return 'I';
		}
		if (n == ' '){return 'P';}
		if (n == '('){
			bla = getNome();
			if (bla == "imp"){
				//System.out.println(bla);
				return 'P';
			}
			limpaNome();
		}
		if (n == ')'){
			bla = getNome();
			//System.out.println(bla);
			return 'B';
		}
		return 'P';
	}
	public void setValor(char n,int i){//vai salvar os caracters dentro do vetor
		this.valor[i]=n;
		//System.out.println("XX "+n);
	}
	public void setNome(char n,int i){//vai salvar os caracters dentro do vetor
		this.nome[i]=n;
		//System.out.println("XX "+n);
	}
	public String getNome(){//retorna somente o nome
		for (int d=0;d<this.nome.length;d++){
			if (this.nome[d] != '@'){
				this.nomeFinal=this.nomeFinal+this.nome[d];
				if (this.nomeFinal == "int"){return "tipo";}
			}
		}
		return this.nomeFinal;
	}
	public String getValor(){ //retorna o valor(em String)
		for (int d=0;d<this.valor.length;d++){
			if (this.valor[d] != '@'){this.valorFinal=this.valorFinal+this.valor[d];}
		}
		if (this.valorFinal == ""){return "000";}
		//System.out.println("VAL = "+this.valorFinal);
		return this.valorFinal;
	}
	public void limpaVal(){//limpa o vetor Valor
		this.inc = -1;
		this.valor = new char[15];
		for (i=0;i<valor.length;i++){this.valor[i]='@';}
	}
	public void limpaNome(){//limpa o vetor nome
		this.inc = -1;
		this.nome = new char[15];
		for (i=0;i<nome.length;i++){this.nome[i]='@';}
	}
	public void limpaVet(){// limpa os dois
		this.c1 = 'N';
		this.inc = -1;
		this.nome = new char[15];
		for (i=0;i<nome.length;i++){this.nome[i]='@';}
		this.valor = new char[15];
		for (i=0;i<valor.length;i++){this.valor[i]='@';}
	}
}