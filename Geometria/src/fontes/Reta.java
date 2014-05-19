package fontes;


public class Reta {

	Ponto ponto1 = new Ponto(0, 0);
	Ponto ponto2 = new Ponto(0, 0);
	
	int coeficienteAngular;
	
	
	public Reta(Ponto ponto1, Ponto ponto2) {
		super();
		this.ponto1 = ponto1;
		this.ponto2 = ponto2;
	}
	

	public Ponto getPonto1(){
		return ponto1;
	}

	public Ponto getPonto2(){
		return ponto2;
	}


	public boolean isPontoEquals(Ponto ponto1, Ponto ponto2) {
		
		boolean pontoIgual = true;
		
		if((ponto1.getCoordenadaX() == ponto2.getCoordenadaX())
				&&(ponto1.getCoordenadaY() == ponto2.getCoordenadaY()))
			pontoIgual = true;
		else
			pontoIgual = false;
		
		return pontoIgual;
	}


	public int getCoeficienteAngular() {
		return coeficienteAngular;
	}


	public void setCoeficienteAngular(int coeficienteAngular) {
		this.coeficienteAngular = coeficienteAngular;
	}


	public void setPonto1(Ponto ponto1) {
		this.ponto1 = ponto1;
	}


	public void setPonto2(Ponto ponto2) {
		this.ponto2 = ponto2;
	}


	public int calculaCoeficienteAngular(){
		
		int x1 = this.getPonto1().getCoordenadaX();
		int y1 =this.getPonto1().getCoordenadaY();
		
		int x0 = this.getPonto2().getCoordenadaX();
		int y0 =this.getPonto2().getCoordenadaY();
		this.coeficienteAngular = (y1-y0) / (x1-x0);
		return coeficienteAngular;
			
	}

	

}