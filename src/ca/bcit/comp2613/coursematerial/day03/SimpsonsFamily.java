package ca.bcit.comp2613.coursematerial.day03;

public class SimpsonsFamily {
	// what happens when I remove the throws clause from this method signature?
	public void homerTurnOnTV() throws DontKnowHowException {
		bartTurnOnTV();

	}

	public void bartTurnOnTV() throws DontKnowHowException {
		// student TODO - create your own exception for Bart
		// i.e. IFailedGrade3Exception
		// student TODO modify DontKnowHowException to add a ctor for your new Exception
		lisaTurnOnTV();

	}

	public void lisaTurnOnTV() throws DontKnowHowException {
		// student TODO - create your own exception for Lisa
		// i.e. IReadOnlyBooksException
		// student TODO modify DontKnowHowException to add a ctor for your new Exception
		
			maggieTurnOnTV();
	}

	public void maggieTurnOnTV() throws DontKnowHowException {
		// question : Let's say Maggie can't walk yet.
		// how do we create a CantWalkException and encapsulate this
		// in DontKnowHowException
		// take a 5 min lab time break to explore exceptions
		// student TODO modify DontKnowHowException to add a ctor for your new Exception
		throw new DontKnowHowException();

	}
}
