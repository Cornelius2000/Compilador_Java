import java.io.File;
import java.util.Scanner;

//"a".equals(x)
public class MeuScanner{
	public static void main(String[] args) {
		try{

			int i,x,val,interador = 0;
			char a,n,o,c2;
			char[] comentario;

			File file = new File("texte.erc"); 
			Scanner input = new Scanner(file);

			System.out.println("+++"+input.hasNextLine());

			while(input.hasNextLine()){

				String line = input.nextLine();

				// System.out.println(line.length());
				// System.out.println(line);

				for(i = 0; i < line.length(); i++){
					//joga os valor da linha pra variavel c 
				 	String c = line.substring(0,i+1);
					// c = line.charAt(i);

					System.out.println(c);

					//checa se c faz parte de uma entidade
					if(c.equals(null)){
					 	continue;
					}

					 //comeca um comentario, tem q ignorar até o ponto final
					if(c.equals("#")){
					 	//deixa passar o comentario 
					 	break;
					}

					//checa a Entidade, chama a primeira parte para declarar as variaveis usadas no codigo
					if(c.equals("DecInit")){
					 	System.out.println("Começa a declaração ");
					 	int parametro = 0;

					 	if (c.equals("in")){
					 		// System.out.println("tamanho da lina::: "+c.length());
					 		//********dando erro*********
					 		Variavel parametro = new Variavel();
					 		parametro.setInt(parametro);
					 	}

					 	// if (c.equals("str")){
					 	// 	Variavel(String parametro);
					 	// }
					 	// if (c.equals("fl")){
					 	// 	Variavel(float parametro);
					 	// }
					 	continue;
					 }
					

					//checa a Arquitetura, executa a logica do programa
					if(c == "LogicInit"){

					 	System.out.println("Começa a Logica ");
					// 	break;
					}

				}	
			}

			input.close();

		}catch(Exception e){
			System.out.println("Erro!");
			e.printStackTrace();
		}
	}

}