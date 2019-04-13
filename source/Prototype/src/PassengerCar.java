/**
 *The type of the Car that can transport passengers. It has associated color and in case this case ever ends up on a
 *  Station Field that matches it’s color passengers leave the Car.
 */
public class PassengerCar extends Car {
    private Color color;
	private boolean isActive;
	private int passengerCount;
	/**
	 * This method is constructor
	 */
	public PassengerCar() {
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
     * This method returns color of car.
     *
     * @return color
     */
	public Color getColor() {
	    return color;
	}
    /**
     * This method sets passengerCount attribute
     *
     * @param pc int
     */
    public void setPassengerCount(int pc) {
        this.passengerCount = pc;
    }
    /**
     * This method returns number of passengers in the car.
     *
     * @return passengerCount int
     */
	public int getPassengerCount() {
	    return passengerCount;
	}
    /**
     * This method remove passengers from the car, if the color of the car matches that of the station.
     *
     * @param st Station
     */
    @Override
	public void removePassenger(Station st) throws ColorMismatchException {
        if(isActive){
            if (this.color == st.getColor()){
                this.passengerCount--;
                if (this.passengerCount==0){
                    this.activateNextCar();
                }
            }
            else{
                throw new ColorMismatchException();
            }
        }
        else{
            throw new ColorMismatchException();
        }
	}
    /**
     * This method activates the car.
     */
	public void activate() {
        this.isActive = true;
	}
    /**
     * This method activates the next car.
     */
	public void activateNextCar() {
        nextCar.activate();
	}
    /**
     * This method moves car to the given field.
     *
     * @param f Field
     */
    @Override
	public void moveTo(Field f) {
        Field currentField = this.field;
        if (field!= null) {field.removeCar();}
        try {
            f.acceptCar(this,field);
        }catch(TrainCollisionException e){
            return;
        }
        catch (ColorMismatchException e){
        }
        if (nextCar != null) {
            if(currentField!=null){ nextCar.moveTo(currentField); }
        }
	}
}
