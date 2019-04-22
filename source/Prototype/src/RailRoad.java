/**
 * RailRoad is the simplest type of the field of the Stage. On every tick cars move on one RailRoad field. It has two
 * entrances and can only hold one car at a time.
 */
public class RailRoad extends Field {
	/**
	 * This method is constructor
	 */
	public RailRoad() {
		super();
	}

	@Override
	public String toString(){

		return "RailRoad: " + Prototype.fieldIdToObjectId.get(this) + "," + Prototype.fieldIdToObjectId.get(entrance1)  +
				"," + Prototype.fieldIdToObjectId.get(entrance2) + ",NONE,NONE,NONE,NONE,NONE"+Prototype.fieldIdToObjectId.get(cars);
		//<ID>,<cars>,<entrance1>,<entrance2>,[<color>],[<directions>],[<isActive>],[<exitTunnel>],[<tunnelEntrance>]

	}
}
