import java.util.ArrayList;

/**
 * Switch is one of the most important Field type. It has multiple entry points, but only two of them are active at
 * any given time.
 */
public class Switch extends Field {
	public ArrayList<Field> directions;
	/**
	 * This method is constructor
	 *
	 * @param variableName String
	 */
	public Switch(String variableName) {
		super(variableName);
		directions= new ArrayList<>();
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+this.getClass().getSimpleName()+"("+variableName+")");
	}
	/**
	 * This method is setter of directions attribute
	 *
	 * @param directions ArrayList<Field>
	 */
	public void setDirections(ArrayList<Field> directions) {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"(directions)");
		this.directions = directions;
		System.out.println("<= void");
	}
	/**
	 * This method is getter of directions attribute
	 *
	 * @return  directions ArrayList<Field>
	 */
	public ArrayList<Field> getDirections() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		System.out.println("<= [directions:ArrayList<Filed>]");
		return directions;
	}
	/**
	 * This method - adds the field to the directions array.
	 * @param f Field
	 */
	public void addDirection(Field f) {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+f.variableName+")");
		this.directions.add(f);
		System.out.println("<= void");
	}
	/**
	 * This method - User changes the direction of the switch. two of the entrances can be chosen from
	 * the directions array.
	 */
	public void changeDirection() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		System.out.println("<= void");
	}

}
