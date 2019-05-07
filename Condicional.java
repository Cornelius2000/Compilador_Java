//FALTA ACABAR, NÃO ENTENDI ALGUMAS PARTES, SE VAI SER CHAMADO O CÓDIGO DA AQUI, OU NA MAIN ?????
class Condicional extends Interpretador{
  public char[] operador = {"$$", "|$", ">", "<", "==", ">=", "<="};
  public char op;

//construtor vai chamar os metodos para verificar se entra no if
  public Condicional(parametro){
    getOperador(parametro);
    verificaIf();//vai ter que ter algum parametro para fazer a verificação, só não sei qual é o tipo necessário
  }
  
//retorna TRUE se a condição do if for verdadeira, caso contrario retorna false
  public int verificaIf(parametro1, parametro2){// falta definit o tipo da variavel
    if(parametro1 this.op parametro2){
      return true;
    }
    return false;
  }

  public String getOperador(String o){ //vai verificar qual é o operador dentro do if, precisa passar ele como parametro
    for(i=0; i < operador.length; i++){
      if(this.operador[i] == o){
        if(this.operador[i] == "$$"){// se for o operador and($$), vai retornar && para fazer a verificação da condição
          return this.op = "&&";
        }
        if(this.operador[i] == "|$"){// se for o operador or(|$), vai retornar || para fazer a verificação da condição
          return this.op = "||";
        }
        return this.op = this.operador[i]; //caso não retornar and ou or, retorna outro operador direto que é igual ao do java
      }
    }
  }

}
