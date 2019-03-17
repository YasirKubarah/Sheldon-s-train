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
     *
	 * @param variableName String
	 */
	public PassengerCar(String variableName) {
		super(variableName);
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +this.getClass().getSimpleName()+"("+variableName+")");
	}
    /**
     * This method is setter of color attribute
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
     * This method is getter of color attribute
     *
     * @return color
     */
	public Color getColor() {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        System.out.println("<= [color:"+color.getClass().getSimpleName()+"]");
	    return color;
	}
    /**
     * This method is setter of passengerCount attribute
     *
     * @param pc int
     */
    public void setPassengerCount(int pc) {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"(pc)");
        this.passengerCount = pc;
        System.out.println("<= void");
    }
    /**
     * This method is getter of passengerCount attribute
     *
     * @return passengerCount int
     */
	public int getPassengerCount() {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        System.out.println("<= [passengerCount:int]");
	    return passengerCount;
	}
    /**
     * This method remove passengers from the car, if the color of the car matches that of the station.
     *
     * @param st Station
     */
    @Override
	public void removePassenger(Station st) throws ColorMismatchException {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"("+st.variableName+")");
        if(isActive){
            if (this.color == st.getColor()){
                this.passengerCount--;
                if (this.passengerCount==0){
                    this.activateNextCar();
                }
            }
            else{
                System.out.println("<= void");
                throw new ColorMismatchException();
            }
        }
        else{
            System.out.println("<= void");
            throw new ColorMismatchException();
        }
        System.out.println("<= void");
	}
    /**
     * This method activates the Car.
     */
	public void activate() {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        this.isActive = true;
        System.out.println("<= void");
	}
    /**
     * This method activates the Car.
     */
	public void activateNextCar() {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        nextCar.activate();
        System.out.println("<= void");
	}
    /**
     * This method moves car to the given field.
     *
     * @param f Field
     */
    @Override
	public void moveTo(Field f) {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"("+f.variableName+")");
        Field currentField = this.field;
        if (field!= null) {field.removeCar();}
        try {
            f.acceptCar(this,field);
        }catch(TrainCollisionException e){
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
