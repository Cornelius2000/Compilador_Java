//Classe Main, está funcionando, só ainda nao foi implementado para numeros double;
/* Retornos:
	I = igual;
	P = próximo;
	F = fim (;);
	S = Esta fazendo uma operação; */



import java.io.File;
import java.util.Scanner;

class Main{
	public static void main(String[] args){
		try {
			String line;
			int i,interador=0;
			char c,c2,ret;

			File file = new File("texte.erc"); //texte.erc é so o nome do arquivo, pode ser qualque nome e qualquer extenção
			Scanner input = new Scanner(file);
			Inserir ins = new Inserir();

			while(input.hasNextLine()){
				line = input.nextLine(); //captura uma linha do testo
				for (i=0;i<line.length();i++){ //anda caracter por caracter desta linha
					c = line.charAt(i); // salva este caracter na variavel c
					//c2 = line.charAt(i++);
					ret = ins.insere(c,interador);//chama a funçao insere, e passa o caracter que esta selecionado com o valor da linha, tem um char como retorno
					//som++;
					if (ret == 'S'){ //se o retorno for um S, quer dizer que foi encontrado uma operação
						ins.operaçao(interador);
						break;
					}
					if (ret == 'F'){
						break;
					}
				}
				ins.limpa(); // limpa os vetores da classe Decifrando
				interador++; // controla as posiçoes do vetor
			}
			ins.imprime();
			input.close();
		}
		catch(Exception e){
			System.out.println("blablabla");
			e.printStackTrace();
		}
	}
}