import java.util.LinkedList;
import java.util.Stack;

public class MathEvaluation {
	private String input;
	private Stack<Integer> pilha = new Stack();
	private LinkedList<Integer> pilhaPostFix = new LinkedList<Integer>();

	
	public MathEvaluation(String input) {
		this.input = input;
		this.gerarTokens();
		this.gerarTokensPostFix();
	}
	
	private void gerarTokens()
	{
		String[] tokens = this.input.split(" ");
		for(int i = 0; i < tokens.length; i++){
			System.out.println(tokens[i]);
			if(tokens[i].length() == 1){
				char token = tokens[i].charAt(0);
				if('0' <= token && token <= '9'){
					System.out.println("eh um digito");
					pilha.push(Integer.parseInt(tokens[i]));
				}
				else{
					pilha.push((int)token);
				}
			}
			else{
				pilha.push(Integer.parseInt(tokens[i]));
			}
		}
	}
	
	//* =  / =
	
	private void gerarTokensPostFix()
	{
		LinkedList<Integer> pilhaNumeros = new LinkedList<Integer>();
		int nivelParenteses = 0;
		for(int i = 0; i < pilha.size(); i++){
			if(pilha.elementAt(i) == '(')
				nivelParenteses++;
			else if(pilha.elementAt(i) == ')')
				nivelParenteses--;
			
			else if(pilha.elementAt(i) == '*'  || pilha.elementAt(i) == '/' ){
				pilhaPostFix.addFirst(pilha.elementAt(i));
			}
			else if(pilha.elementAt(i) == '+'  || pilha.elementAt(i) == '-'){
				if(nivelParenteses > 0)
					pilhaPostFix.addFirst(pilha.elementAt(i));
				else
					pilhaPostFix.addLast(pilha.elementAt(i));
			}
			else{
				pilhaNumeros.addFirst(pilha.elementAt(i)); 
			}
		}
		for(int i = 0; i < pilhaNumeros.size(); i++){
			pilhaPostFix.addFirst(pilhaNumeros.get(i));
		}
	}
	
	public int popPostFix() {
		return pilhaPostFix.poll();
	}
	
	public int pop() {
		return pilha.pop();
	}
	
	public static void main(){
		MathEvaluation m = new MathEvaluation("3 + 2");
		m.pop();
	}

	public int calcularExpressao() {
		Stack<Integer> resultado = new Stack();
		for(int i = 0; i < pilhaPostFix.size(); i++)
		{
			int el = pilhaPostFix.get(i); 
			if(el != '*' && el != '/' && el != '+' && el != '-') 
				resultado.push(el);
			else{
				int el1, el2, res = 0;
				el2 = resultado.pop();
				el1 = resultado.pop();
				
				switch(el)
				{
				case '*':
					res = el2 * el1;
					break;
				case '/':
					res = el2 / el1;
					break;
				case '+':
					res = el2 + el1;
					break;
				case '-':
					res = el2 - el1;
					break;
				}
				resultado.push(res);
			}
		}
		return resultado.pop();
	}
}
