
public class EstrategiaInvalidaException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EstrategiaInvalidaException(){
		super("Estrategias devem ser P, R ou S");
		
	}

}
