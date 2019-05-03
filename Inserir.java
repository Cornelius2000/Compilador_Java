/*I = igual;
  P = proximo;
  B = busca;
  F = Fim;
  S = Operação;	
*/




class Inserir{
	private String nome,valor,comparador;
	private int val,som=0;
	private char ret, op='0';
	public Interpretador intp = new Interpretador();
	public Variavel[] v = intp.getVari();
	public Decifrando d = new Decifrando();

	public char insere(char n,int i){
		if (som == 1){som=0;}
		ret = d.cheqDados(n);//chama a funçao cheqDados, e passa o caracter que esta selecionado, tem um char como retorno
		if (ret == 'I'){// se retornar um "I", quer dizer que foi encontrado um igual na linha
			nome = d.getNome();// salva o nome
			v[i].nome=nome;//manda para o vetor, da classe variavel
			return 'P';
		}
		if (ret == 'B'){ //se o retorno for B, ele entra neste if,
			buscaVariavel(); //chama a função
			return 'F';
		}
		if ((ret != 'F')&&(ret != 'I')&&(ret != 'P')){ // Se não retornar nehuma das opções, quer dizer que é um operador
			op = ret; // salva o operador em op
			intp.setOperador(ret); // manda o operador para a função na classe interpretador
			valor = ""; // zera a string valor
			valor = d.getValor(); // busca o valor que esta antes do operador
			val = Integer.parseInt(valor); // transforma para inteiro
			intp.setValoresInt(val,som); // passa esse valor para um vetor da classe interpretador(que depois vai ser feita a soma
			limpaValor();  // limpa o valor do vetor da classe Decifrando;
			return 'P';
		}
		if (ret == 'F'){ //se chegar no ";", entra neste if
			if (op != '0'){ // se tiver um operador em op
				som++;
				valor = "";
				valor = d.getValor();
				val = Integer.parseInt(valor);
				intp.setValoresInt(val,som);
				return 'S';
			}
			else {  //se não tiver nenhuma operação na linha, entra neste if e faz como se fosse um valor normal
				valor = "";
				valor = d.getValor();
				val = Integer.parseInt(valor);
				v[i].valorInteiro=val;
			}
			d.limpaVet();
			return 'F';
		}
		return 'P';
	}
	public void imprime(){
		intp.imprime();
	}
	public void limpa(){
		d.limpaVet();
	}
	public void limpaValor(){
		d.limpaVal();
	}
	public void operaçao(int i){
		if (this.op != '0'){
			intp.desvOperaçao(i); //chama a função desvOperação, da classe interpretador, com o numero da linha que esta lendo
			this.op = '0'; // transforma op para 0
			intp.limpaValor(); // limpa o vetor de interpretador
		}
	}
	public void buscaVariavel(){
		for (int i=0;i<v.length;i++){ //for do tamanho do vetor variaveis
			comparador = v[i].nome;
			if (comparador.equals(d.bla)){System.out.println(v[i].valorInteiro);} //se o que estiver dentro de 'd.bla', for uma variavel, ele printa o valor
			else{
				//System.out.println("Variavel não existente!!!");
				break;
			}
		}
	}
}