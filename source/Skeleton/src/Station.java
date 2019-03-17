/**
 * Station acts as an ordinary RailRoad, except if certain conditions are true, passengers can depart the Car that
 * enters the Station Field.
 */
public class Station extends Field {
	public Color color;
	/**
	 * This method is constructor
	 *
	 * @param variableName String
	 */
	public Station(String variableName) {
		super(variableName);
		System.out.println("=> [" + this.variableName + ":" + this.getClass().getSimpleName() + "]."
				+ this.getClass().getSimpleName() + "(" + variableName + ")");
	}
	/**
	 * This method setter of color attribute
	 *
	 * @param c Color
	 */
	public void setColor(Color c) {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"(c)");
		this.color = c;
		System.out.println("<= void");
	}
	/**
	 * This method getter of color attribute
	 *
	 * @return color Color
	 */
	public Color getColor() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		System.out.println("<= [color:"+color.getClass().getSimpleName()+"]");
		return color;
	}
	/**
	 * This method accepts car from one of the entrance. We need to know the exact entrance in order to determine the
	 * direction of the car ( which  neighboring field it should move next)
	 *
	 * @param c Car
	 * @param from Field
	 * @exception TrainCollisionException Train Collision Exception
	 * @exception ColorMismatchException Color Mismatch Exception
	 */
	@Override
	public void acceptCar(Car c, Field from) throws TrainCollisionException,ColorMismatchException  {
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
			try {
				c.removePassenger(this);
			}catch (ColorMismatchException e){
				System.out.println("<= void");
				return;
			}
			this.stage.passengerDelivered();
			System.out.println("<= void");
		}
	}
}