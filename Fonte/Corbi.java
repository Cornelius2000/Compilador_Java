//Classe Main, está funcionando, só ainda nao foi implementado para numeros double;
/* Retornos:
	I = igual;
	P = próximo;
	F = fim (;);
	S = Esta fazendo uma operação; */

import java.io.File;
import java.util.Scanner;

class Corbi{
	public static void main(String[] args){
		try {
			String line;
			int interador=0;
			char caracter,caracterProximo,ret;

			File file = new File(args[0]); //texte.erc é so o nome do arquivo, pode ser qualque nome e qualquer extenção
			Scanner input = new Scanner(file);
			Arquivo arq = new Arquivo();

			while(input.hasNextLine()){
				line = input.nextLine(); //captura uma linha do testo
				arq.arquivoLeitura.add(line);
				interador++; // controla as posiçoes do vetor
			}
			arq.setLinha();
			//arq.imprime();
			input.close();
		}
		catch(Exception e){
			System.out.println("ERRO: "+e.getMessage());
			e.printStackTrace();
		}
	}
}
