import java.util.ArrayList;

/**
 * Field is the atomic part of the Stage. Every stage is made up of fields situated next to each other on all
 * directions (up, down, left, right). Fields can accept Car’s from the neighboring field and execute corresponding
 * action, depending on the type of Field.
 */
public abstract class Field extends SkeletonBaseClass{
    protected Stage stage;
	protected ArrayList<Car> cars;
	protected Field entrance1;
	protected Field entrance2;
	/**
	 * This method is constructor
	 *
	 * @param variableName String
	 */
	public Field(String variableName) {
		super(variableName);
		this.cars = new ArrayList<>();
	}
	/**
	 * This method is setter of stage attribute
	 *
	 * @param stage Stage
	 */
	public void setStage(Stage stage) {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"("+stage.variableName+")");
		this.stage = stage;
		System.out.println("<= void");
	}
	/**
	 * This method is setter of entrance1 attribute
	 *
	 * @param f Field
	 */
	public void setEntrance1(Field f) {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"("+f.variableName+")");
		this.entrance1 = f;
        System.out.println("<= void");
	}
	/**
	 * This method is setter of entrance2 attribute
	 *
	 * @param f Field
	 */
	public void setEntrance2(Field f) {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"("+f.variableName+")");
        this.entrance2 = f;
        System.out.println("<= void");
	}
	/**
	 * This method adds car
	 *
	 * @param car Car
	 */
	public void pushCar(Car car) {

		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+car.variableName+")");
		this.cars.add(car);
		System.out.println("<= void");
	}
	/**
	 * This method accepts car from one of the entrance. We need to know the exact entrance in order to determine the
	 * direction of the car ( which  neighboring field it should move next)
	 *
	 * @param c Field
	 * @param from Field
	 * @exception TrainCollisionException Train Collision Exception
	 * @exception ColorMismatchException Color Mismatch Exception
	 */
	public void acceptCar(Car c, Field from) throws TrainCollisionException, ColorMismatchException {
		if(from == null){
			System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
					+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+c.variableName+
					", from)");
		}
		else{
			System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
					+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+c.variableName+
					", "+from.variableName +")");
		}
		if (this.cars.size()>0){
			c.collide();
			System.out.println("<= void");
			throw new TrainCollisionException();
		}
		else {
			this.cars.add(c);
			c.setField(this);
			System.out.println("<= void");
		}
	}
	/**
	 * This method removes car from the current field. This function is called when the car moves away from the field.
	 */
	public void removeCar() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        this.cars.remove(0);
		System.out.println("<= void");
	}
	/**
	 * This method - considering the current car and the direction it came from, this function returns the field onto
	 * which the car should go next.
	 *
	 * @return f Field
	 */
	public Field getDirection() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        System.out.println("<= ["+entrance2.variableName+":"+entrance2.getClass().getSimpleName()+"]");
		return this.entrance2;
	}
}
