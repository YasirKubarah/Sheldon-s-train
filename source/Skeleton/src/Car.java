/**
 * Car is the abstract class that is the parent class of Engine and PassengerCar.
 */
public abstract class Car extends SkeletonBaseClass{
	protected boolean isVisible;
	protected Field field;
	protected Car nextCar;
	/**
	 * This method is constructor
	 *
	 * @param variableName String
	 */
	public Car(String variableName) {
		super(variableName);
	    this.isVisible = true;
	}
	/**
	 * This method sets the visibility of the car.
	 */
	public void setVisible() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		this.isVisible = true;
		System.out.println("<= void");
	}
	/**
	 * This method sets the visibility of the car.
	 */
	public void setInvisible() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		this.isVisible = false;
		System.out.println("<= void");
	}
	/**
	 * This method sets the Field for the current car
	 *
	 * @param f Field
	 */
	public void setField(Field f) {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+f.variableName+")");
		this.field =  f;
		System.out.println("<= void");
	}
	/**
	 * This method gets the Field the car is currently on.
	 *
	 * @return field Field
	 */
	public Field getField() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		System.out.println("<= [field:"+field.getClass().getSimpleName()+"]");
		return this.field;
	}
	/**
	 * This method sets the next car reference.
	 *
	 * @param nc Car
	 */
	public void setNext(Car nc) {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+nc.variableName+")");
		this.nextCar = nc;
		System.out.println("<= void");
	}
	/**
	 * This method activates the Car.
	 */
	public void activate(){
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		System.out.println("<= void");
	}
	/**
	 * This method remove passengers from the car, if the color of the car matches that of the station.
	 *
	 * @param st Station
	 */
	public void removePassenger(Station st) throws ColorMismatchException {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+st.variableName+")");
		System.out.println("<= void");
	}
	/**
	 * This method moves car to the given field.
	 *
	 * @param f Field
	 */
	public void moveTo(Field f){
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+f.variableName+")");
		System.out.println("<= void");
	}
	/**
	 * This method detects the collision after move.
	 */
	public void collide(){
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		Game g = Game.getInstance();
		g.endGame();
		System.out.println("<= void");
	}
}
