/**
 * Deadend is the type of Field that has only one entrance without any exit. If the engine enters the DeadEnd it
 * loses the game.
 */
public class DeadEnd extends Field {
	/**
	 * This method is constructor
	 */
	public DeadEnd() {
		super();
	}
	/**
	 * This method accepts car from entrance. If this method is called by any Car the game is over.
	 *
	 * @param c Car
	 * @param from Field
	 * @exception TrainCollisionException Train Collision Exception
	 */
	@Override
	public void acceptCar(Car c, Field from) throws TrainCollisionException, ColorMismatchException {
		c.collide();
		throw new TrainCollisionException();
	}
}
