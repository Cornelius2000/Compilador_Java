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

			File file = new File("lin.bd"); //texte.erc é so o nome do arquivo, pode ser qualque nome e qualquer extenção
			Scanner input = new Scanner(file);
			Inserir ins = new Inserir();

			while(input.hasNextLine()){
				line = input.nextLine(); //captura uma linha do testo
				for (i=0;i<line.length();i++){ //anda caracter por caracter desta linha
					c = line.charAt(i); // salva este caracter na variavel c
					//c2 = line.charAt(i++);
<<<<<<< Updated upstream
					ret = ins.insere(c,interador);//chama a funçao insere, e passa o caracter que esta selecionado com o valor da linha, tem um char como retorno
					//som++;
					if (ret == 'S'){ //se o retorno for um S, quer dizer que foi encontrado uma operação
						ins.operaçao(interador);
						break;
					}
					//*****NÃO SEI SE ESTÁ FUNCIONANDO, FALTA ACERTAR ESSA PARTE PARA CHAMAR O IF E O LAÇO
					if(ret == 'C'){//se for um C, quer dizer que tem uma condição(if), chama a class Condicional
						Condicional(parametro);//tem que passar algum parametro
					}
					if(ret == 'L'){ // se for L, é um laço, chama o construtor do laço
						Laco();//
					}

					if (ret == 'F'){
=======
					if(som == 1){som = 0;}

					ret = d.cheqDados(c); //chama a funçao cheqDados,  e passa o caracter que esta selecionado, tem um char como retorno
					if (ret == 'I'){ // se retornar um "I", quer dizer que foi encontrado um igual na linha
						nome = d.getNome(); // salva o nome
						v[interador].nome=nome; //manda para o vetor, da classe variavel
						continue;
					}
					if ((ret != 'F')&&(ret != 'I')&&(ret != 'P')){ // Se não retornar nehuma das opções, quer dizer que é um operador
						op = ret; // salva o operador em op
						intp.setOperador(ret); // manda o operador para a função na classe interpretador
						valor = ""; // zera a string valor
						valor = d.getValor(); // busca o valor que esta antes do operador
						val = Integer.parseInt(valor); // transforma para inteiro
						intp.setValoresInt(val,som); // passa esse valor para um vetor da classe interpretador(que depois vai ser feita a soma)
						d.limpaVal(); // limpa o valor do vetor da classe Decifrando;
						continue;
					}
					if (ret == 'F'){ //se chegar no ";", entra neste if
						if (op != '0'){ // se tiver um operador em op
							som++;
							valor = "";
							valor = d.getValor();
							val = Integer.parseInt(valor);
							intp.setValoresInt(val,som);
							//op = '0';
						}
						else { //se não tiver nenhuma operação na linha, entra neste if e faz como se fosse um valor normal
							valor = "";
							valor = d.getValor();
							val = Integer.parseInt(valor);
							v[interador].valorInteiro=val;
						}
>>>>>>> Stashed changes
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
