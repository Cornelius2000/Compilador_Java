import java.io.File;
import java.util.Scanner;

//"a".equals(x)
public class MeuScanner{

	public static void main(String[] args) {
		try{

			int i,x,val,interador = 0;
			char a,n,o,c,c2;
			char[] comentario;

			File file = new File("lin.bd"); 
			Scanner input = new Scanner(file);

			while(input.hasNextLine()){
				String line = input.nextLine();

				System.out.println(line.length());
				System.out.println(line);

				for(i = 0; i<line.length(); i++){
					//joga os valor da linha pra variavel c 
					String c = line.substring(0,i+1));

					//checa se c faz parte de uma entidade
					if(c == null){
						continue;
					}

					//comeca um comentario, tem q ignorar até o ponto final
					if(c == #){
						//deixa passar o comentario 
					}

				}
				
				break;	
				
			}

			input.close();

		}catch(Exception e){
			System.out.println("Erro!");
			e.printStackTrace();
		}
	}

}