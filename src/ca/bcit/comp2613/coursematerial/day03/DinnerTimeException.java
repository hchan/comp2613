package ca.bcit.comp2613.coursematerial.day03;

// question ... what happens when I change this to Exception instead of RuntimeException ?
// question ... did I have to change the method signature in the SimpsonsFamily ?
public class DinnerTimeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// question ... how do I display this field back to the catcher of this exception ?
	private int randInt;
	public DinnerTimeException(int randInt) {
		this.randInt = randInt;
	}
	public int getRandInt() {
		return randInt;
	}
	public void setRandInt(int randInt) {
		this.randInt = randInt;
	}

}
