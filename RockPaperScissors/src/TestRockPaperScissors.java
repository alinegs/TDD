import static org.junit.Assert.*;

import org.junit.Test;


public class TestRockPaperScissors {

	@Test
	public void testCriacaoDeJogada() throws EstrategiaInvalidaException{
		String[] jogador1 =  new String[] {"Charles", "S"};
		String[] jogador2 =  new String[] {"Aline", "P"};
		RockPaperScissors jogo = new RockPaperScissors(jogador1, jogador2);
		assertEquals("Charles", jogo.getNomeJogador1());
		assertEquals("S", jogo.getEstrategiaJogador1());
		assertEquals("Aline", jogo.getNomeJogador2());
		assertEquals("P", jogo.getEstrategiaJogador2());
	}
	
	@Test(expected=EstrategiaInvalidaException.class)
	public void testJogadaInvalida() throws EstrategiaInvalidaException{
		String[] jogador1 =  new String[] {"Charles", "s"};
		String[] jogador2 =  new String[] {"Aline", "p"};
		RockPaperScissors jogo = new RockPaperScissors(jogador1, jogador2);
		jogo.getEstrategiaJogador1();
		jogo.getEstrategiaJogador2();
	}
	
	@Test
	public void testVencedorComDoisJogadores()  throws EstrategiaInvalidaException{
		
		String[][][] valores = new String[][][]
		{
				{{"Charles", "P"}, {"Aline", "P"}},
				{{"Charles", "P"}, {"Aline", "R"}},
				{{"Charles", "P"}, {"Aline", "S"}},
				{{"Charles", "R"}, {"Aline", "P"}},
				{{"Charles", "R"}, {"Aline", "R"}},
				{{"Charles", "R"}, {"Aline", "S"}},
				{{"Charles", "S"}, {"Aline", "P"}},
				{{"Charles", "S"}, {"Aline", "R"}},
				{{"Charles", "S"}, {"Aline", "S"}},
		};
		RockPaperScissors jogo1 = new RockPaperScissors(valores[0][0], valores[0][1]);
		RockPaperScissors jogo2 = new RockPaperScissors(valores[1][0], valores[1][1]);
		RockPaperScissors jogo3 = new RockPaperScissors(valores[2][0], valores[2][1]);
		RockPaperScissors jogo4 = new RockPaperScissors(valores[3][0], valores[3][1]);
		RockPaperScissors jogo5 = new RockPaperScissors(valores[4][0], valores[4][1]);
		RockPaperScissors jogo6 = new RockPaperScissors(valores[5][0], valores[5][1]);
		RockPaperScissors jogo7 = new RockPaperScissors(valores[6][0], valores[6][1]);
		RockPaperScissors jogo8 = new RockPaperScissors(valores[7][0], valores[7][1]);
		RockPaperScissors jogo9 = new RockPaperScissors(valores[8][0], valores[8][1]);
		
		assertEquals("Charles", jogo1.getVencedor()[0] );
		assertEquals("P", jogo1.getVencedor()[1] );
		assertEquals("Charles", jogo2.getVencedor()[0] );
		assertEquals("P", jogo2.getVencedor()[1] );
		assertEquals("Aline", jogo3.getVencedor()[0] );
		assertEquals("S", jogo3.getVencedor()[1] );
		assertEquals("Aline", jogo4.getVencedor()[0] );
		assertEquals("P", jogo4.getVencedor()[1] );
		assertEquals("Charles", jogo5.getVencedor()[0] );
		assertEquals("R", jogo5.getVencedor()[1] );
		assertEquals("Charles", jogo6.getVencedor()[0] );
		assertEquals("R", jogo6.getVencedor()[1] );
		assertEquals("Charles", jogo7.getVencedor()[0] );
		assertEquals("S", jogo7.getVencedor()[1] );
		assertEquals("Aline", jogo8.getVencedor()[0] );
		assertEquals("R", jogo8.getVencedor()[1] );
		assertEquals("Charles", jogo9.getVencedor()[0] );
		assertEquals("S", jogo9.getVencedor()[1] );		
	} 
	
	@Test
	public void testVencedorTorneio()  throws EstrategiaInvalidaException{
		
		String[] jogador1 = new String[] {"Armando", "P"};
		String[] jogador2 = new String[] {"Dave", "S"};
		String[] jogador3 = new String[] {"Richard", "R"};
		String[] jogador4 = new String[] {"Michael", "S"};
		String[] jogador5 = new String[] {"Allen", "S"};
		String[] jogador6 = new String[] {"Omer", "P"};
		String[] jogador7 = new String[] {"David E.", "R"};
		String[] jogador8 = new String[] {"Richard X.", "P"};

		
		Partida partida1 = new Partida();
		partida1.partida1 = new Partida(jogador1);
		partida1.partida2 =  new Partida(jogador2);


		Partida partida2 = new Partida();
		partida2.partida1 = new Partida(jogador3);
		partida2.partida2 =  new Partida(jogador4);
		
		Partida partida3 = new Partida();
		partida3.partida1 = new Partida(jogador5);
		partida3.partida2 =  new Partida(jogador6);
		
		Partida partida4 = new Partida();
		partida4.partida1 = new Partida(jogador7);
		partida4.partida2 =  new Partida(jogador8);

		Partida partida5 = new Partida();
		partida5.partida1 = partida1;
		partida5.partida2 = partida2;
		
		Partida partida6 = new Partida();
		partida6.partida1 = partida3;
		partida6.partida2 = partida4;

		Partida partida7 = new Partida();
		partida7.partida1 = partida5;
		partida7.partida2 = partida6;

		assertEquals("Richard", partida7.getNomeVencedorTorneio());
		assertEquals("R", partida7.getEstrategiaVencedorTorneio());
		
		
	}

}
