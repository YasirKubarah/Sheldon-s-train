import java.util.ArrayList;

/**
 * Switch is one of the most important Field type. It has multiple entry points, but only two of them are active at
 * any given time.
 */
public class Switch extends Field {
	public ArrayList<Field> directions;
	/**
	 * This method is constructor
	 */
	public Switch() {
		super();
		directions= new ArrayList<>();
	}
	/**
	 * This method adds the field to the directions collection.
	 * @param f Field
	 */
	public void addDirection(Field f) {
		this.directions.add(f);

	}
	/**
	 * This method changes the direction of the switch (two of the entrances can be chosen from the directions).
	 */
	public void changeDirection() {
	}

}
