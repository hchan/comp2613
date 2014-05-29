package ca.bcit.comp2613.coursematerial.day03;

import java.util.Random;

public class SimpsonsWithPossibleRuntimeExceptionDemo {
	
	
	public static void main(String[] args) {
		SimpsonsFamily simpsonsFamily = new SimpsonsFamily() {
			@Override
			public void maggieTurnOnTV() throws DontKnowHowException {
				Random rand = new Random();
				int randInt = rand.nextInt();
				if (randInt % 5 == 0) { // modulus - means 20% of the time (at least I think so ;))
					System.out.println("Marge calls out - DINNER TIME");
					throw new DinnerTimeException(randInt); 
				}
				super.maggieTurnOnTV();
			}
		};
		
		try {
			simpsonsFamily.homerTurnOnTV();
		} catch (DontKnowHowException e) {			
			e.printStackTrace(); // welcome to printing the stacktrace
		} 
		// question ... how do I print "Doh" even if I don't catch all the exceptions ... hint f*n*lly
	}

	

}
