package ca.bcit.comp2613.coursematerial.day03;

import java.util.Random;

public class SimpsonsWithPossibleRuntimeExceptionDemo {
	
	
	public static void main(String[] args) {
		SimpsonsFamily simpsonsFamily = new SimpsonsFamily() {
			@Override
			public void maggieTurnOnTV() throws DontKnowHowException {
				Random rand = new Random();
				if (rand.nextInt() % 5 == 0) { // modulus - means 20% of the time (at least I think so ;))
					System.out.println("Marge calls out - DINNER TIME");
					throw new DinnerTimeException();
				}
				super.maggieTurnOnTV();
			}
		};
		
		try {
			simpsonsFamily.homerTurnOnTV();
		} catch (DontKnowHowException e) {			
			e.printStackTrace();
		}
	}

	

}
