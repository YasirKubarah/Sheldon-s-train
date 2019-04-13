import java.util.ArrayList;

/**
 * Stage class holds the state of the current Stage: It contains all the fields that make up the map and the current
 * passenger count.
 */
public class Stage{
	private int passengerCount;
	private ArrayList<Field> fields;
	/**
	 * This method is constructor
	 */
	public Stage() {
		super();
		this.fields = new ArrayList<>();
	}
	/**
	 * This method sets the passenger count
	 */
	public void setPassengerCount(int pc) {
		this.passengerCount = pc;
	}
	/**
	 * This method adds field to the field collection.
	 */
	public void addField(Field f) {
		this.fields.add(f);
	}
	/**
	 * This method is called every time PassengerCar delivers a passenger.
	 */
	public void passengerDelivered() {
		passengerCount = passengerCount -1;
	}
}
