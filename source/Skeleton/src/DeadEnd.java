/**
 * Deadend is the type of Field that has only one entrance without any exit. If the engine enters the DeadEnd it
 * loses the game.
 */
public class DeadEnd extends Field {
	/**
	 * This method is constructor
	 *
	 * @param variableName String
	 */
	public DeadEnd(String variableName) {
		super(variableName);
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+this.getClass().getSimpleName()+"()");
	}
	/**
	 * This method accepts car from one of the entrance. We need to know the exact entrance in order to determine the
	 * direction of the car ( which  neighboring field it should move next)
	 *
	 * @param c Car
	 * @param from Field
	 * @exception TrainCollisionException Train Collision Exception
	 */
	@Override
	public void acceptCar(Car c, Field from) throws TrainCollisionException, ColorMismatchException {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+c.variableName+
				", "+from.variableName +")");
		c.collide();
		System.out.println("<= void");
		throw new TrainCollisionException();
	}
}
