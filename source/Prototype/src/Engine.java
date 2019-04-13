/**
 * The Car that leads the train. Unlike PassengerCar engine does not contain any passengers.
 */
public class Engine extends Car {
	/**
	 * This method is constructor
	 */
	public Engine() {
		super();
	}
	/**
	 * This method moves the engine on every tick of the timer (according to the given direction).
	 */
	public void move() {
		Field currentField = this.field;
		Field nextField = field.getDirection();
		if (field != null) { field.removeCar();}
		try {
			nextField.acceptCar(this,field);
		} catch(TrainCollisionException e){
			return;
		}
		catch (ColorMismatchException e){
		}
        if (nextCar != null) {
            if(currentField!=null){ nextCar.moveTo(currentField); }
        }
	}
}
