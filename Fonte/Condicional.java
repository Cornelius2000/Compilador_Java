import java.util.ArrayList;

class Condicional{
	private char[] condicional = {'|','$','=','>','<'};
	public ArrayList< Character > condicaoIF;
	public boolean operadorIF = false,retornoIF = true,pulaIF = false;
	public double[] parametro;
	public ArrayList< Character > op1;
	public String op;

	public Condicional(){
		this.condicaoIF = new ArrayList< Character >();
		this.op1 = new ArrayList< Character >();
		this.parametro = new double[2];
	}

	public void decifraOperador(){ //vai verificar qual é o operador dentro do if, precisa passar ele como parametro
		this.op = "";
		for(int i = 0; i < op1.size(); i++){
			this.op += op1.get(i);
		}
		retornoIF = veriCondicao();
		operadorIF = false;
 	}
	public boolean veriCondicao(){
		if(this.op.equals("==")){
			if(parametro[0] == parametro[1]){return true;}
		}
		if(this.op.equals(">=")){
			if(parametro[0] >= parametro[1]){return true;}
		}
		if(this.op.equals("<=")){
			if(parametro[0] <= parametro[1]){return true;}
		}
		if(this.op.equals(">")){
			if(parametro[0] > parametro[1]){return true;}
		}
		if(this.op.equals("<")){
			if(parametro[0] < parametro[1]){return true;}
		}
		return false;
	}

}
