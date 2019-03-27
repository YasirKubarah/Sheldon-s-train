/**
 * The Car that leads the train. Unlike PassengerCar engine doesn’t contain any passengers.
 */
public class Engine extends Car {
	/**
	 * This method is constructor
	 *
	 * @param variableName String
	 */
	public Engine(String variableName) {
		super(variableName);
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+this.getClass().getSimpleName()+"("+variableName+")");
	}
	/**
	 * This method moves the engine on every tick of the timer (according to the given direction).
	 */
	public void move() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		Field currentField = this.field;
		Field nextField = field.getDirection();
		if (field != null) { field.removeCar();}
		try {
			nextField.acceptCar(this,field);
		} catch(TrainCollisionException e){
			System.out.println("<= void");
			return;
		}
		catch (ColorMismatchException e){
		}
        if (nextCar != null) {
            if(currentField!=null){ nextCar.moveTo(currentField); }
        }
		System.out.println("<= void");
	}
}
