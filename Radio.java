import java.util.Random;

public class Radio{
    
    int radial;
    String code;
    boolean signal, station;
    Random random = new Random();
    String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    StringBuilder sb;
    
    
    public Radio (int x) {
        
    }

    public int getRadial() {
    	
        return this.radial;
    }
    
    public String get_Station() {
        int temp = 0;
        StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < 3; i++) {
        	temp = random.nextInt(letters.length - 1);
        	sb.append(letters[temp]);
        }
    	code = sb.toString();
        return this.code;
    }
    
    public String get_Station() {
        return station;
    }
    
    public boolean over_Station() {
        return overstation;
    }
    
    public boolean signal_status() {
    	if(radial == 90) {
    		signal = false;
    	}
    	// Change later.
    	else if(radial == 0) {
    		signal = false;
    	}
    	else
    		signal = true;
        return this.signal;
    }
    
}
