
public class RockPaperScissors {
	
	private String[] jogador1;
	private String[] jogador2;

	public RockPaperScissors(String[] jogador1, String[] jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
	}

	public String getNomeJogador1() {
		return this.jogador1[0];
	}

	public String getEstrategiaJogador1() throws EstrategiaInvalidaException{
		String estrategia = this.jogador1[1];
		if(estrategia.equals("P") || estrategia.equals("R") || estrategia.equals("S"))
			return estrategia;
		throw new EstrategiaInvalidaException();
	}

	public String getNomeJogador2() {
		return this.jogador2[0];
	}

	public String getEstrategiaJogador2() throws EstrategiaInvalidaException {
		String estrategia = this.jogador2[1];
		if(estrategia.equals("P") || estrategia.equals("R") || estrategia.equals("S"))
			return estrategia;
		throw new EstrategiaInvalidaException();
	}

	public String[] getVencedor() {
		String s1 = getEstrategiaJogador1(), s2 = getEstrategiaJogador2();
		if((s1 == s2) || (s1 == "P" && s2 == "R") || (s1 == "R" && s2 == "S") || (s1 == "S" && s2 == "P"))
				return this.jogador1;
		if((s1 == "P" && s2 == "S") || (s1 == "R" && s2 == "P") || (s1 == "S" && s2 == "R"))
			return this.jogador2;
		return null;
	}
}
