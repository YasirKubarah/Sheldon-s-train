import java.net.PortUnreachableException;
import java.util.ArrayList;

/**
 * Field is abstract class, the atomic part of the stage. Every stage is made up of fields situated next to each other
 * on all directions (up, down, left, right). Fields can accept car’s from the neighboring field and execute
 * corresponding action, depending on the type of field.
 */
public abstract class Field{
	protected ArrayList<Car> cars;
	protected Field entrance1;
	protected Field entrance2;
	protected Stage stage;
	/**
	 * This method is constructor
	 */
	public Field() {
		this.cars = new ArrayList<>();
	}
	/**
	 * This method adds car to the ArrayList of cars that the field is holding.
	 *
	 * @param car Car
	 */
	public void pushCar(Car car) {
		this.cars.add(car);
	}
	/**
	 * This method sets entrance1 attribute.
	 *
	 * @param f Field
	 */
	public void setEntrance1(Field f) {
		this.entrance1 = f;
	}
	/**
	 * This method sets entrance2 attribute.
	 *
	 * @param f Field
	 */
	public void setEntrance2(Field f) {
        this.entrance2 = f;
	}
	/**
	 * This method sets stage attribute.
	 *
	 * @param stage Stage
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	/**
	 * This method accepts car from one of the entrance. We need to know the exact entrance in order to determine the
	 * direction of the car (which neighboring field it should move next)
	 *
	 * @param c Field
	 * @param from Field
	 * @exception TrainCollisionException Train Collision Exception
	 * @exception ColorMismatchException Color Mismatch Exception
	 */
	public void acceptCar(Car c, Field from) throws TrainCollisionException, ColorMismatchException {
		if(from != null){
			if (this.entrance1 != from){
				this.entrance2 = this.entrance1;
				this.entrance1 = from;
			}
		}

		if (this.cars.size()>0){
			c.collide();
			System.out.println("Collision Detected: " + Prototype.carIdToObjectId.get(c) + ":" + Prototype.carIdToObjectId.get(this.cars.get(0)));
			throw new TrainCollisionException();
		}
		else {
			this.cars.add(c);
			c.setField(this);
		}
	}
	/**
	 * This method removes car from the current field. This function is called when the car moves away from the field.
	 */
	public void removeCar() {
        this.cars.remove(0);
	}
	/**
	 * This method returns the field onto which the car should go next, considering the current car and the direction
	 * it came from.
	 *
	 * @return f Field
	 */
	public Field getDirection() {
		return this.entrance2;
	}
}
