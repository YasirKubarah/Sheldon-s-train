import java.util.ArrayList;

/**
 * Stage class holds the state of the current Stage: It contains all the fields that make up the map and the current
 * passenger count.
 */
public class Stage extends SkeletonBaseClass{
	private int passengerCount;
	private ArrayList<Field> fields;
	/**
	 * This method is constructor
	 *
	 * @param variableName String
	 */
	public Stage(String variableName) {
		super(variableName);
		this.fields = new ArrayList<>();
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+this.getClass().getSimpleName()+"("+variableName+")");
	}
	/**
	 * This method sets the passenger count
	 */
	public void setPassengerCount(int pc) {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"(pc)");
		System.out.println("<= void");
		this.passengerCount = pc;
	}
	/**
	 * This method adds field to the field array.
	 */
	public void addField(Field f) {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+f.variableName+")");
		this.fields.add(f);
		System.out.println("<= void");
	}
	/**
	 * This method - every time PassengerCar delivers a passenger this method is called.
	 */
	public void passengerDelivered() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		passengerCount = passengerCount -1;
		System.out.println("<= void");
	}
}
