import java.util.Random;

public class Radio {
    
    int radial;
    String station;
    boolean signal;	// Variable that determines wheter or not your over a station.
    Random random = new Random();
    String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    StringBuilder sb;
    
    
    public Radio (boolean timed) {
        this(false);
    }

    public int generate_Radial() {
        this.radial = random.nextInt(360);
    }

    public String generate_Station() {
        int temp = 0;
        sb = new StringBuilder();
    	for(int i = 0; i < 3; i++) {
        	temp = random.nextInt(letters.length - 1);
        	sb.append(letters[temp]);
        }
    	station = sb.toString();
        return this.station;
    }
    
    public void reset() {
        generate_Radial();
        generate_Station();
        gen_Random_OverStation();
    }
    
	public int gen_RandomInt(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}
	
	private void gen_Random_OverStation() {
		this.signal = (gen_RandomInt(0, 23) == 0);
	}
    
    public int getRadial() {
        return this.radial;
    }
    
    public String get_Station() {
        return station;
    }
    
    public boolean over_Station() {
        return signal;
    }
    
}
