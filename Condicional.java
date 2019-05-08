//FALTA ACABAR, NÃO ENTENDI ALGUMAS PARTES, SE VAI SER CHAMADO O CÓDIGO DA AQUI, OU NA MAIN ?????
class Condicional extends Decifrando{
  public char[] operador = {"$$", "|$", ">", "<", "==", ">=", "<="};
  public char op;
  public char[] params;

//construtor ainda n faz nada
  public Condicional (char parametro){}

//retorna TRUE se a condição do if for verdadeira, caso contrario retorna false
  public int verificaIf(char parametro1, char parametro2){// falta definit o tipo da variavel
    if(parametro1 this.op parametro2){
      return true;
    }
    return false;
  }

  public String getDecifraOperador(char o){ //vai verificar qual é o operador dentro do if, precisa passar ele como parametro
    for(int i = 0; i < operador.length; i++){
      if(this.operador[i] == o){
        if(this.operador[i] == o){// se for o operador and($$), vai retornar && para fazer a verificação da condição
          return this.op = "&&";
        }
        if(this.operador[i] == o){// se for o operador or(|$), vai retornar || para fazer a verificação da condição
          return this.op = "||";
        }
        return this.op = this.operador[i]; //caso não retornar and ou or, retorna outro operador direto que é igual ao do java
      }
    }
  }

  public String getParametro(){// essa função vai pegar as condição, dividir e jogar no vetor de params cada parametro em uma posição
    int cont = 0;
    char flag = "";
    for(int i = 0; i < condicao.length; i++){
      if(condicao[i] != "@" || condicao[i] != null){ // se for um espaço vazio no vetor, quer dizer que é o fim do parametro e começo do outro
        flag += condicao[i];
      }else{
        this.params[cont] = flag;
        flag = "";
        cont++;
      }
    }
  }

  public String 

}
