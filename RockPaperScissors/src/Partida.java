
public class Partida {
	
	public Partida partida1;
	public Partida partida2;
	private String[] vencedor; // = new String[2];

	public Partida(String[] jogador) {
		this.vencedor = jogador;
	}

	public Partida() {
		
	}

	public String getNomeVencedorTorneio() {
		return this.getVencedor()[0];
	}

	public String getEstrategiaVencedorTorneio() {
		return this.getVencedor()[1];
	}
	
	private String[] getVencedor(){
		if(this.vencedor == null /*[0].length() == 0*/){
			String[] vencedor1 = this.partida1.getVencedor();
			String[] vencedor2 = this.partida2.getVencedor();
			RockPaperScissors jogo = new RockPaperScissors(vencedor1, vencedor2);
			this.vencedor = jogo.getVencedor();
		}
		return this.vencedor;
	}

}
