import java.util.Random;

public class Radio{
    
    int radial;
    String station;
    boolean signal;
    Random random = new Random();
    String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    StringBuilder sb;
    
    
    public Radio (int x) {
        
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
    	code = sb.toString();
        return this.code;
    }
    
    public void reset() {
        generate_Radial();
        generate_Station();
        //over_Station(); Implement in another class.
    }
    
    public int getRadial() {
    	
        return this.radial;
    }
    
    
    public String get_Station() {
        return station;
    }
    
    public boolean over_Station() {
        return overstation;
    }
    
}
