package tictactoe.teste;
import tictactoe.Jogo;
import static org.junit.Assert.*;

import org.junit.Test;

public class JogoTeste{

	@Test
	public void verificarTabuleiro(){
		Jogo j = new Jogo();
		assertEquals(3, j.getLinhas());
		assertEquals(3, j.getColunas());
	}
	
	@Test
	public void veirificarJogadaX(){
		Jogo j = new Jogo();
		int x = 0, y = 0;
		j.jogarX(x, y);
		assertEquals('X', j.getXY(x, y));
	}
	
	@Test
	public void veirificarJogadaO(){
		Jogo j = new Jogo();
		int x = 0, y = 0;
		j.jogarO(x, y);
		assertEquals('O', j.getXY(x, y));
	}
	
	@Test
	public void verificarJogadaForaDoTabuleiro(){
		Jogo j = new Jogo();
		j.jogarO(5, 5);
		assertEquals('I', j.getXY(5, 5));
	}
	
	@Test
	public void verificarJogadaSobreposta(){
		Jogo j = new Jogo();
		j.jogarX(0, 0);
		j.jogarO(0, 0);
		
		assertEquals('X', j.getXY(0, 0));
	}
	
	@Test
	public void verificarVitoria(){
		Jogo j = new Jogo();
		
		j.jogarO(0, 0);	j.jogarO(1, 1);	j.jogarO(2, 2);
		//assertEquals('O', j.vencedor());
		
		// Linha 0
		j.jogarO(0, 0);	j.jogarO(0, 1);	j.jogarO(0, 2);
		assertEquals('O', j.vencedor());
		
		// Linha 1
		j.jogarO(1, 0);	j.jogarO(1, 1);	j.jogarO(1, 2);
		assertEquals('O', j.vencedor());
		
		// Linha 2
		j.jogarO(2, 0);	j.jogarO(2, 1);	j.jogarO(2, 2);
		assertEquals('O', j.vencedor());
		
		j = new Jogo();
		
		// Coluna 0
		j.jogarO(0, 0);	j.jogarO(1, 0);	j.jogarO(2, 0);
		assertEquals('O', j.vencedor());
		
		j = new Jogo();
		
		// Diagonal 
		j.jogarO(0, 0);	j.jogarO(1, 1);	j.jogarO(2, 2);
		assertEquals('O', j.vencedor());
		
		
	}
}
