# Corbi Linguagem
---

#### autores 
>Vinicius Cornelius

>Eduardo Rubi Cardoso
---



### INTRODUÇÃO:
    Corbi é uma linguagem de fácil manuseio, visando criar seus programas mais simples de 
    uma forma rápida e prática, sem muitas complicações.
    Sua extenção é dada no tipo de arquivo .crb
---



### Sintaxe:
	Para determinar o fim de cada linha, é utilizado o ponto e virgula ; já
	para a indentação dos blocos de código, usa as chaves { indicando o começoe },
	o fim do mesmo.
	Preferencialmente a identação não é obrigatória, mas de bom costume usa-se todos os
	blocos alinhados para evitar pequenos 'bugs' e dor de cabeça.
---



### Palavras reservadas da linguagem:
	
	| se | ent | enq | double | imp | fl | str |
---



### Operadores
		| +  |  soma
		| -  |  diferença|
		| /  |  divisão
		| !  |  divisão inteira
		| ** |  potência
		| *  |  multiplicação
		| =  |  atribuição
		| == |  comparação
		| != |  comparaçao(diferença)
		| >= |  maior igual
		| <= |  menor igual
		| %  |  resto(mod)
---



### Declaração de Variaveis e Atribuição |  =

		Para declarar uma variavel é preciso utilizar uma letra do alfabeto,ou mais,
		se preferir porém é melhor utilizar sómente uma para evitar futuros erros.
		Logo, para atribuir um valor int, ou double basta atribuir o valor normalmente
		que ele irá reconhecer que se trata desse tipo. 
		Todos os valores inteiros são convertidos para double.
		Já para atribuir uma String (str), a uma variavel, basta coloca-lá entre aspas
		e igualar, veja que não é necessário antes de atribuir especificar que é um numero
		ou uma letra, por esse fato é preciso ter cuidado na hora de realizar as operaçoes
		para não dar conflitos entre tipos, caso isso ocorra o programa abortará a execução.

>exemplo:

	 		a = 1;
			c = "ola";
			b = a+5;
			ab = 10;
---



### Controlador de Fluxo | se

		Para definir uma condição entre variaveis, é possível usar dois parametros apenas,
		parametro1 seguido da condição, e parametro2. É preciso também abrir chave na mesma
		linha de sua declaração e fecha-lá após o bloco de código a ser executado, tomando
		o cuidado para q o fechamento fique com uma identação correta, e apenas ela de caracter
		nessa linha, para assim evitar conflitos.
		As condições de comparação possível são: >, <, ==, >=, <=, != ;

>exemplo: 

			se(parametro1 condição parametro2){
				código a se executado.......;
				código a se executado.......;
				código a se executado.......;
			}
		
			a = 1;
			b = 5;
			se(b > a){
				a = a + 1;
			}
			
----
### Controlador de Fluxo | ent

		Caso o a condição do se que foi abordado logo acima, for falsa, então
		ele pula o bloco e executa diretamente o bloco dentro do ent{ }
		Como pode se notar no exemplo em que ele vai incrementar o b
		
>exemplo:

			a = 1;
			b = 5;
			se(a > b){
				a = a + 1;
			}
			else{
				b = b + 1;
			}
---



### Estrutura de Repetição | enq[] 
    
    A Estrutura de repetição é semelhante com o comparador, para usá-lá
    é preciso ter dois parametros e uma condição, iniciando o bloco com 
    um colchete, enq(parametro1 > parametro2) [  se caso essa condição
    não for atendida, ou seja for false, ele para de executar e pula até 
    encontrar ] que define o final do bloco. Caso contrário ele repete o 
    bloco infinitamente.
	
>exemplo:

		int i;
		i = 0;
		enq(i < 10)[
		  imp(i);
		  i = i+1;
		]
    
    
 ---
