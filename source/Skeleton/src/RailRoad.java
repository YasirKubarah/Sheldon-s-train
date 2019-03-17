/**
 * RailRoad is the simplest type of the field of the Stage. On every tick cars move on one RailRoad Field. It has two
 * entrances and can only hold one car at a time.
 */
public class RailRoad extends Field {
	/**
	 * This method is constructor
	 *
	 * @param variableName
	 */
	public RailRoad(String variableName) {
		super(variableName);
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+this.getClass().getSimpleName()+"("+variableName+")");
	}
}
