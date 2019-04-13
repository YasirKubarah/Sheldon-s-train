/**
 * Car is the abstract class that is the parent class of Engine and PassengerCar classes.
 */
public abstract class Car{
	protected Field field;
	protected boolean isVisible;
	protected Car nextCar;
	/**
	 * This method is constructor
	 */
	public Car() {
	    this.isVisible = true;
	}
	/**
	 * This method sets the Field for the current car.
	 *
	 * @param f Field
	 */
	public void setField(Field f) {
		this.field =  f;
	}
	/**
	 * This method returns the Field the car is currently on.
	 *
	 * @return field Field
	 */
	public Field getField() {
		return this.field;
	}
	/**
	 * This method sets the visibility of the car to visible.
	 */
	public void setVisible() {
		this.isVisible = true;
	}
	/**
	 * This method sets the visibility of the car to invisible.
	 */
	public void setInvisible() {
		this.isVisible = false;
	}

	/**
	 * This method sets the next car for the current car.
	 *
	 * @param nc Car
	 */
	public void setNext(Car nc) {
		this.nextCar = nc;
	}
	/**
	 * This method activates the car.
	 */
	public void activate(){
	}
	/**
	 * This method removes passengers from the car, if the color of the car matches that of the station.
	 *
	 * @param st Station
	 */
	public void removePassenger(Station st) throws ColorMismatchException {
	}
	/**
	 * This method moves car to the given field.
	 *
	 * @param f Field
	 */
	public void moveTo(Field f){
	}
	/**
	 * This method detects the collision after move.
	 */
	public void collide(){
		Game g = Game.getInstance();
		g.endGame();
	}
}
