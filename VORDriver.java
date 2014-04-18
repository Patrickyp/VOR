
public class VORDriver {
	public static void main(String[] args){
		VOR myvor = new VOR();
		//radio Radial, station code, signal Quality, pilot Radial
		myvor.newSignal(180, 999, "bad", 0);
		myvor.print();
		myvor.newSignal(120, 999, "", 31);
		myvor.print();
	}
}
