//Tenho que ajeitar melhor essa main, criar uma classe que decifre o caracter e retorne o seu valor;
//nao consegui testar para ver se esta funcionando. Porem nao da erro de compilação
import java.io.File;
import java.util.Scanner;

class Main{
	public static void main(String[] args){
		try {

			char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			char[] numeros = {'0','1','2','3','4','5','6','7','8','9'};
			char[] operaçao = {'+','-','*','/','%','='};
			String line,nome="",valor="";
			int i,x,val,interador=0;
			char a,n,o,c,c2;

			File file = new File("texte.erc"); //texte.erc é so o nome do arquivo, pode ser qualque nome e qualquer extenção
			Scanner input = new Scanner(file);
			Interpretador intp = new Interpretador();
			Variavel[] v = intp.getVari();

			while(input.hasNextLine()){
				line = input.nextLine(); //captura uma linha do testo
				for (i=0;i<line.length();i++){ //anda caracter por caracter desta linha
					c = line.charAt(i); // salva este caracter na variavel c;
					//c2 = line.charAt(i++);
					while(c!=';'){
						for (x=0;x<26;x++){ //percorre o vetor alfabeto e salva na variavel a
							a = alfabeto[x];
							if (c == a){
								nome=nome+c; //se for uma letra, ela concatena na variavel nome
								continue;
							}
							if (c == '='){
								v[interador].nome = nome; //quando o caracter for igual ao "=", ele salva o nome, no vetor
								continue;
							}
						}
						for (x=0;x<10;x++){ //faz a mesma coisa que o for de antes, mas com os numeros
							n = numeros[x]; //porem ele salva como string
							if (c == n){
								valor = valor+c;
								continue;
							}
						}

					}
					val = Integer.parseInt(valor); //transforma a string valor em inteiro
					v[interador].valor=val; // manda para o vetor na mesma posição que o nome
				}
				interador++; // controla as posiçoes do vetor
				//System.out.println(line);
			}
			intp.imprime();
			input.close();
		}
		catch(Exception e){
			System.out.println("blablabla");
			e.printStackTrace();
		}
	}
}