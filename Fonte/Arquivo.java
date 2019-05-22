import java.util.ArrayList; 

class Arquivo{
	public String nome="",linhas;
	public Inserir ins = new Inserir();
	public ArrayList< String >arquivoLeitura;
	public ArrayList< Character >texto;
	private int posicaoChar,linhaInicial,posicaoChave=-1,linhaRepetir=0,linhaFinal =0;
	public char caracter,retorno,passos;
	public boolean repetirLaco = false;

	public Arquivo(){
		this.arquivoLeitura = new ArrayList< String >();
		this.texto = new ArrayList< Character >();
		this.posicaoChar = -1;
	}
	public void setLinha(){
		for (linhaInicial=0;linhaInicial<arquivoLeitura.size();linhaInicial++){
			this.linhas = arquivoLeitura.get(linhaInicial);
			if ((linhaInicial == linhaFinal)&&(repetirLaco == true)){
				linhaInicial = linhaRepetir;
				continue;
			}
			if (ins.getIf() == false){
				condicional();
				continue;
			}
			if (ins.getRepete() == true){
				repetirLaco = true;
				linhaRepetir = linhaInicial - 2;
				laço();
			}
			quebraLinha(linhaInicial);
		}
	}
	public void quebraLinha(int i){
		for (int d=0;d<linhas.length();d++){ //anda caracter por caracter desta linha
			caracter = linhas.charAt(d); // salva este caracter na variavel c
			retorno = ins.insere(caracter,i);//chama a funçao insere, e passa o caracter que esta selecionado com o valor da linha, tem um char como retorno
			if (retorno == 'S'){
				ins.operaçao(i);
				continue;
			}
			if (retorno == 'F'){
				passos = 'F';
				continue;
			}
			if (retorno == 'A'){imprimivel();}
		}
		ins.limpa();// limpa os vetores da classe Decifrando
	}
	public void laço(){
		String busca;
		for (int i=linhaInicial;i<arquivoLeitura.size();i++){
			busca = arquivoLeitura.get(i);
			posicaoChave = busca.indexOf('}');
			if (posicaoChave != -1){
				linhaFinal = i;					
				ins.clearIf();
				break;
			}
		}
	}
	public void condicional(){
		String busca;
		for (int i=linhaInicial;i<arquivoLeitura.size();i++){
			busca = arquivoLeitura.get(i);
			posicaoChave = busca.indexOf('}');
			if (posicaoChave != -1){
				linhaInicial = i;
				ins.setRodouIf();
				ins.clearIf();
				break;
			}
		}
	}
	public void imprimivel(){
		posicaoChar = linhas.indexOf('"');
		for(int z=posicaoChar+1;z<linhas.length();z++){
			caracter = linhas.charAt(z);
			if(linhas.charAt(z) == '"'){
				break;
			}
			texto.add(caracter);
		}
		for(int z=0;z<texto.size();z++){
			nome = nome+texto.get(z);
		}
		ins.textoImprimir = nome;
		nome = "";
		texto.clear();
	}
	public void imprime(){
		ins.imprime();
	}
}