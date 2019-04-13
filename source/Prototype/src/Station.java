/**
 * Station acts as an ordinary RailRoad, except if certain conditions are true, passengers can depart the Car that
 * enters the Station Field.
 */
public class Station extends Field {
	public Color color;
	/**
	 * This method is constructor
	 */
	public Station() {
		super();
	}
	/**
	 * This method sets color attribute.
	 *
	 * @param c Color
	 */
	public void setColor(Color c) {
		this.color = c;
	}
	/**
	 * This method returns color of the station.
	 *
	 * @return color Color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * This method this method accept car, if the type of the car is PassengerCar and all the previous Cars are empty,
	 * passengers leave the current car.
	 *
	 * @param c Car
	 * @param from Field
	 * @exception TrainCollisionException Train Collision Exception
	 * @exception ColorMismatchException Color Mismatch Exception
	 */
	@Override
	public void acceptCar(Car c, Field from) throws TrainCollisionException,ColorMismatchException  {
		if(from == null){
		}
		else{
		}
		if (this.cars.size()>0){
			c.collide();
			throw new TrainCollisionException();
		}
		else {
			this.cars.add(c);
			c.setField(this);
			try {
				c.removePassenger(this);
			}catch (ColorMismatchException e){
				return;
			}
			this.stage.passengerDelivered();
		}
	}
}