package tictactoe;

public class Jogo {
	
	char tabuleiro[][] = new char[3][3];

	public int getLinhas() {
		return tabuleiro.length;
	}

	public int getColunas() {
		return tabuleiro[0].length;
	}
	
	private void jogar(char letra, int x, int y){
		boolean xEstaDentroDoLimite = 0 <= x && x < getColunas();
		boolean yEstaDentroDoLimite = 0 <= y && y < getLinhas();
		boolean espacoEhVazio = getXY(x, y) == 0;
		if(xEstaDentroDoLimite && yEstaDentroDoLimite && espacoEhVazio)
			tabuleiro[x][y] = letra;
	}

	public void jogarX(int x, int y) {
		jogar('X', x, y);
	}

	public char getXY(int x, int y) {
		if(0 <= x && x < getColunas() && 0 <= y && y < getLinhas())
			return tabuleiro[x][y];
		return 'I';
	}

	
	public void jogarO(int x, int y) {
		jogar('O', x, y);
	}
	
	public char vencedor(){
		
		char vencedor = vencedorLinhas();
		
		if(vencedor!=0){
			return vencedor;
		}else{
			vencedor = vencedorColunas();
			if(vencedor!=0){
				return vencedor;
			}else{
				return vencedorDiagonal();
			}
		}
	}
	
	private char vencedorDiagonal() {
		
		
		if( (getXY(0, 0) == getXY(1, 1)) && (getXY(1, 1) == getXY(2, 2)) )
			return getXY(0,0);
		
		if( (getXY(0, 2) == getXY(1, 1)) && (getXY(1, 1) == getXY(2, 0)) )
			return getXY(0,2);
		
		return 0;
		
	}

	public char vencedorLinhas(){
		
		char vencedor = 0;
		
		// Linhas
		char corrente = 0, anterior = 0;
		int i, j;
		for(i = 0; i < getLinhas(); i++){
			anterior = getXY(i, 0);
			for(j = 1; j < getColunas(); j++){
				corrente = getXY(i, j); 
				if(corrente == anterior)
					continue;
				else
					break;
			}
			
			if(j == getColunas() && corrente == anterior)	
				return corrente;
		}
		
		return vencedor;
		
	}
	
	public char vencedorColunas(){
		
		char vencedor = 0;
		char corrente = 0, anterior = 0;
		int i, j;
		
		// Colunas
		for(j = 0; j < getColunas(); j++){
			anterior = getXY(0, j);
			for(i = 1; i < getLinhas(); i++){
				corrente = getXY(i, j); 
				if(corrente == anterior)
					continue;
				else
					break;
			}
			
			if(i == getLinhas() && corrente == anterior)	
				return corrente;
		}
		
		return vencedor;
		
	}
	
	
}
