/*I = igual;
  P = proximo;
  B = busca;
  F = Fim;
  S = Operação;
	L = Laço;
*/
class Inserir{
	public String nome,valor,comparador,textoImprimir="0";
	public int posicaOperador=0,posicao;
	public double valorInserir,valorPosicao;
	public char retornoDecifrando, operador='0';
	public boolean variavelExistente=false,imprimivel = false;
	public Interpretador intp = new Interpretador();
	public Variavel[] v = intp.getVari();
	public Decifrando d = new Decifrando();
	public Imprimir imp = new Imprimir();

	public char insere(char n,int i){
		d.posicaoLinha = i;
		if (posicaOperador == 1){posicaOperador = 0;}
		retornoDecifrando = d.cheqDados(n);//chama a funçao cheqDados, e passa o caracter que esta selecionado, tem um char como retorno
		if (retornoDecifrando == 'I'){// se retornar um "I", quer dizer que foi encontrado um igual na linha
			variavelExistente = procura();
			if (variavelExistente == false){declaraNome(i);}
			return 'P';
		}
		if (retornoDecifrando == 'B'){ //se o retorno for B, ele entra neste if,
			if (d.aspas == false){
				if (d.controlador.equals("imp")){
					imprimivel = true;
					if (textoImprimir != "0"){
						imp.imprimeJunto(buscaVariavel(),textoImprimir);
						return 'F';
					}
					imp.imprime(buscaVariavel());
					return 'F';
				}
			}//chama a função
			else{
				if (d.controlador.equals("imp")){
					imprimivel = true;
					imprimeTexto();
					return 'F';
				}
			}
			return 'F';
		}
		if (retornoDecifrando == 'C'){
			desvendaCondicional();
			return 'P';
		}
		if (retornoDecifrando == 'A'){return 'A';}
		if ((retornoDecifrando != 'F')&&(retornoDecifrando != 'I')&&(retornoDecifrando != 'P')){ // Se não retornar nehuma das opções, quer dizer que é um operador
			iniciaOperacao();
			limpaValor();  // limpa o valor do vetor da classe Decifrando;
			return 'P';
		}
		if (retornoDecifrando == 'F'){ //se chegar no ";", entra neste if
			if (imprimivel == true){return 'F';}
			if (operador != '0'){ // se tiver um operador em op
				posicaOperador++;
				continuaOperacao();
				return 'S';
			}
			if (variavelExistente == false){setValor(i);}
			else {setValor(posicao);}
			limpa();
			return 'F';
		}
		return 'P';
	}
	public void desvendaCondicional(){
		nome="";
		for (int i=0;i<d.parametro.size();i++){
			nome += d.parametro.get(i);
		}
		if(d.numero == false){
			d.bla = nome;
			d.setParametro(buscaVariavel());
			d.parametro.clear();
		}
		else{
			d.setParametro(Double.parseDouble(nome));
			d.numero = false;
			d.parametro.clear();
		}
	}
	public void declaraNome(int i){
		v[i].nome=nome;//manda para o vetor, da classe variavel
		d.limpaNome();
	}
	public boolean procura(){
		String varr;
		nome = d.getNome();// salva o nome
		for (int i=0;i<v.length;i++){
			varr = v[i].nome;
			if (varr.equals(nome)){
				posicao = i;
				valorPosicao = v[i].valor;
				d.limpaNome();
				return true;
			}
		}
		return false;
	}
	public void transformaValor(){
		valor = ""; // zera a string valor
		valor = d.getValor(); // busca o valor que esta antes do operador
		valorInserir = Double.parseDouble(valor);
	}
	public void iniciaOperacao(){
		if (d.temVariavel == true){
			d.bla = d.getNome();
			valorInserir = buscaVariavel();
			d.temVariavel = false;
			d.limpaNome();
		}
		else{transformaValor();}
		operador = retornoDecifrando; // salva o operador em op
		intp.setOperador(retornoDecifrando); // manda o operador para a função na classe interpretador
		intp.setValores(valorInserir,posicaOperador);
	}
	public void continuaOperacao(){
		if (d.temVariavel == true){
			d.bla = d.getNome();
			valorInserir = buscaVariavel();
			d.temVariavel = false;
		}
		else{transformaValor();}
		intp.setValores(valorInserir,posicaOperador);
	}
	public void setValor(int posicao){
		if (d.temVariavel == true){
			d.bla = d.getNome();
			valorInserir = buscaVariavel();
		}
		else{transformaValor();}
		v[posicao].valor = valorInserir;
	}
	public void clearIf(){
		d.clearCondional();
	}
	public boolean getIf(){
		return d.getCondicional();
	}
	public void imprimeTexto(){
		System.out.println(textoImprimir);
	}
	public void imprime(){
		intp.imprime();
	}
	public void limpa(){
		nome="";
		textoImprimir="0";
		imprimivel = false;
		d.limpaVet();
	}
	public void limpaValor(){
		d.limpaVal();
	}
	public void operaçao(int i){
		if (this.operador != '0'){
			if (variavelExistente == false){intp.desvOperaçao(i);}//chama a função desvOperação, da classe interpretador, com o numero da linha que esta lendo
			else {intp.desvOperaçao(posicao);}
			this.operador = '0'; // transforma op para 0
			intp.limpaValor(); // limpa o vetor de interpretador
		}
	}
	public double buscaVariavel(){//se o que estiver dentro de 'd.bla', for uma variavel, ele printa o valor
		for (int i=0;i<v.length;i++){ //for do tamanho do vetor variaveis
			comparador = v[i].nome;
			if (comparador.equals(d.bla)){
				if (v[i].valor != -99){
					return v[i].valor;
				}
				break;
			}
		}
		return 0;
	}
}
