import java.util.ArrayList; 

class Arquivo{
	public String nome="",linhas;
	public Inserir ins = new Inserir();
	public ArrayList< String >linha;
	public ArrayList< Character >texto;
	private int posicaoChar;
	public char caracter,retorno,passos;

	public Arquivo(){
		this.linha = new ArrayList< String >();
		this.texto = new ArrayList< Character >();
		this.posicaoChar = -1;
	}
	public void setLinha(){
		for (int i=0;i<linha.size();i++){
			this.linhas = linha.get(i);
			quebraLinha(i);
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