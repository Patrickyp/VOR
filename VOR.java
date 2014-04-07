/**
 * Representation of a VOR.  With each new radio signal, calculated values 
 * are stored as variables that can be accessed from another class.
 * 
 */
public class VOR {
	
	/* radio inputs, */
	
	private int stationRad; 
	String sigQuality; 
	int stationCode; 
	
	/* pilot/GUI input */
	
	private int intendedRad; 
	
	/* Calculated values, updated with every new signal*/
	
	String direction = ""; //either "to"/"from"/"bad"
	int degOffset; //number of degrees from intendedRad
	
	
	/**
	 * Constructor, create a new VOR object
	 */
	public VOR(){
		
	}
	/**
	 * Give this VOR a new input signal, updates calculated values and stationCode.
	 * @param radial The radial input from pilot
	 * @param stationCode Morse code of the station where this signal came from.
	 * @param quality True = good signal, false = bad signal
	 */
	public void newSignal(int radial, int stationCode, String quality){
		this.stationRad = radial; 
		this.stationCode = stationCode; 
		this.sigQuality = quality;
		//update calculated values
		this.direction = calcDirection();
		this.degOffset = calcRadial();
	}
	
	/**
	 * Helper method
	 * @return
	 */
	private int calcRadial(){
		//to be implemented
		return 0;
	}
	
	/**
	 * Helper method
	 * @return
	 */
	private String calcDirection(){
		//to be implemented
		return "";
	}
	
	
	
}
