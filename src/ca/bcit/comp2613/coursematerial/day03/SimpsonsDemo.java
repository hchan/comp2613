package ca.bcit.comp2613.coursematerial.day03;

public class SimpsonsDemo {
	
	
	public static void main(String[] args) {
		SimpsonsFamily simpsonsFamily = new SimpsonsFamily();
		try {
			simpsonsFamily.homerTurnOnTV();
		} catch (DontKnowHowException e) {			
			e.printStackTrace();
		}
	}

	

}
