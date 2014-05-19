import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import fontes.Ponto;
import fontes.Reta;

public class Linha2DTeste {

	@Test
	public void verificaPontoNulo(){
		
		Ponto ponto = new Ponto(0, 0);
		
		assertNotNull("Deve haver um ponto", ponto);
	}
	
	@Test
	public void verificaCoordenadaNula() {
	
		Ponto ponto = new Ponto(0, 0);
				
		assertNotNull("Coordenada nao pode ser nula", ponto.getCoordenadaX());
		assertNotNull("Coordenada nao pode ser nula", ponto.getCoordenadaY());		
	}
	
	@Test
	public void verificaValorSetado(){
		
		int coordenadaX = 1;
		int coordenadaY = 3;
		
		Ponto ponto = new Ponto(1, 3);
				
		assertEquals("Valor esperado deve ser igual ao real", coordenadaX, ponto.getCoordenadaX());
		assertEquals("Valor esperado deve ser igual ao real", coordenadaY, ponto.getCoordenadaY());
	}
	
	@Test 
	public void verificaSeExisteReta(){
		
		
		Ponto ponto1 = new Ponto(1,2);
		Ponto ponto2 = new Ponto(3,4);
		
		Reta reta = new Reta(ponto1, ponto2);
		
		assertNotNull("Deve existir uma reta", reta);
		assertNotNull("A reta deve retornar um ponto", reta.getPonto1());
		assertNotNull("A reta deve retornar um ponto", reta.getPonto2());	
	}
	
	
	@Test
	public void verificaSeEReta(){
		
		int coordenadaX = 2;
		int coordenadaY = 0;
		int coordenadaX2 = 1;
		int coordenadaY2 = 4;
		
		Ponto ponto1 = new Ponto(coordenadaX,coordenadaY);
		Ponto ponto2 = new Ponto(coordenadaX2, coordenadaY2);
		
		Reta reta = new Reta(ponto2, ponto2);
		
		assertFalse(reta.isPontoEquals(ponto1, ponto2));
	}
	
	@Test
	public void verificaSeInterceptam(){
	
		Reta reta1 = new Reta(new Ponto(1,1), new Ponto(2,2));
		Reta reta2 = new Reta(new Ponto(3,1), new Ponto(4,1));
		
		assertNotSame(reta1.calculaCoeficienteAngular(), reta2.calculaCoeficienteAngular());
		
	}
	
	@Test
	public void verificaSeNaoInterceptam(){
	
		Reta reta1 = new Reta(new Ponto(1,1), new Ponto(2,2));
		Reta reta2 = new Reta(new Ponto(3,3), new Ponto(2,2));
		
		assertEquals(reta1.calculaCoeficienteAngular(), reta2.calculaCoeficienteAngular());
		
	}
	
	@Test
	public void verificaSeDivisorEhZero(){
		boolean tratou = true;
		////try{
			Reta reta1 = new Reta(new Ponto(1,1), new Ponto(1,9));
			reta1.getCoeficienteAngular();
			System.out.println(reta1.getCoeficienteAngular());
			tratou = false;
		///}
		//catch(ArithmeticException e){
			
		//}
		assertEquals(true, tratou);
    }
}