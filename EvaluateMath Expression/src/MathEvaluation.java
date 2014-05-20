import java.util.Stack;


public class MathEvaluation {
	private String input;
	private Stack<Integer> pilha = new Stack();
	private Stack<Integer> pilhaPostFix = new Stack();

	
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
		for(int i = 0; i < pilha.size(); i++){		
			if (pilha.elementAt(i) == '*'  || pilha.elementAt(i) == '/' )
				pilhaPostFix.push(pilha.elementAt(i));
		}
		
		for(int i = 0; i < pilha.size(); i++){		
			if (pilha.elementAt(i) == '+'  || pilha.elementAt(i) == '-' )
				pilhaPostFix.push(pilha.elementAt(i));
		}
		
	}
	
	public int popPostFix() {
		return pilhaPostFix.pop();
	}
	public int pop() {
		return pilha.pop();
	}
	
	public static void main(){
		MathEvaluation m = new MathEvaluation("3 + 2");
		m.pop();
	}

}
