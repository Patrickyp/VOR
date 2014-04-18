/**
 * Representation of a VOR.  With each new radio signal, calculated values 
 * are stored as variables that can be accessed from another class.
 */
public class VOR {
	
	/* radio inputs, */
	
	int stationRad; 
	String sigQuality; //ignore for now
	int stationCode;  //ignore for now
	
	/* pilot/GUI input */
	
	int pilotRad; 
	
	/* Calculated values, updated with every new signal*/
	
	String direction = ""; //either "to"/"from"/"bad"
	int degOffset; //number of degrees from intendedRad
	int side; //which side is the needle tilting, -1 = left, 1 = right
	
	/**
	 * Constructor, create a new VOR object
	 */
	public VOR(){
		
	}
	/**
	 * Give this VOR a new input signal, updates calculated values and stationCode.
	 * @param radial The radial input from radio.
	 * @param stationCode Station ID code.
	 * @param quality True = good signal, false = bad signal
	 * @param intendedRad The radial from pilot.
	 */
	public void newSignal(int radial, int stationCode, String quality, int intendedRad){
		this.stationRad = radial; 
		this.stationCode = stationCode; //irrelevant for now
		this.sigQuality = quality;
		this.pilotRad = intendedRad;
		//update calculated values
		this.direction = calcToFrom(); //to, from or red
		this.degOffset = calcDeflection(); //needle centered, or tilted?
	}
	
	/**
	 * Helper method, calculates the deflection of the bar/needle from center,
	 * @return negative = towards left, positive = towards right, 0 = centered
	 */
	private int calcDeflection(){
		int deflect = findDistance(pilotRad, stationRad, true);
		//closer to opposite side of pilotRad, calculate deflection from there
		if(deflect > 90){
			deflect = 180 - deflect;
		}
		return deflect;		
	}
	
	/**
	 * Calculate whether from/to/between based on pilotRad and stationRad
	 * @return
	 */
	private String calcToFrom(){
		//if radial is within 90degrees of pilot radial, direction is "from"
		if(findDistance(stationRad, pilotRad, false) <89){
			return "FROM";
		}
		if(findDistance(stationRad, pilotRad, false) > 91){
			return "TO";
		}
		//too close to 90 degrees, neither from nor to
		return "RED";
	}
	/**
	 * Find the closer distance between 2 degree values
	 * @param deg1 first degree
	 * @param deg2 second degree
	 * @param update whether to update side variable 
	 * @return
	 */
	public int findDistance(int deg1, int deg2, boolean update){
		int posD = Integer.MIN_VALUE;
		int negD = Integer.MIN_VALUE;
		//same degree distance must be 0
		if(deg2 == deg1){
			return 0;
		}
		//posD = distance clockwise from deg1->deg2, negD = counterclockwise
		if(deg2 > deg1){
			posD = deg2 - deg1;
			negD = deg1 + 360 - deg2;
		}
		if(deg2 < deg1){
			negD = deg1 - deg2; //negative since we are finding the distance backwards from deg1 to deg2
			posD = deg2 + 360 - deg1;
		}
		//return the smaller distance
		if(posD < negD){
			//update direction of needle, -1 = to left, 1 = to right
			if(update){
				side = -1;
				//System.out.println("POSITIVE DIS: " + posD);
			}
			return posD;
		}
		//backward is closer
		if(update){
			side = 1;
			//System.out.println("NEGATIVE DIS: " + negD);
		}
		return negD;
	}
	
	/**
	 * Print the input/calculated values
	 */
	public void print(){
		System.out.println("------------------------");
		//System.out.println("StationCode: " + this.stationCode);
		System.out.println("Radio Radial: " + this.stationRad);
		System.out.println("Pilot Radial: " + this.pilotRad);
		if(this.degOffset > 10){
			System.out.println("Needle Deflection: 10 bars");
		}
		else{
			System.out.println("Needle Deflection: " + this.degOffset + " bars");
		}
		if(this.side <0){
			System.out.println("Needle Dir: Left");
		}
		else if(this.side == 0){
			System.out.println("Needle Dir: Center");
		}
		else{
			System.out.println("Needle Dir: Right");
		}
		System.out.println("To/From: " + this.direction);
	}
}
