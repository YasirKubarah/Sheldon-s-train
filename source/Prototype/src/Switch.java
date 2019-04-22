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
		int directionCount = directions.size();
		for(int i=0;i<directionCount; i++){
			if (directions.get(i) == this.entrance2)
			{
				if((i+1)==directionCount){
					this.entrance2 = directions.get(0);
				}
				else{
					this.entrance2 = directions.get(i+1);
				}
				break;
			}
		}
		System.out.println("Switch Direction changed: " + Prototype.fieldIdToObjectId.get(entrance1) + ":" + Prototype.fieldIdToObjectId.get(entrance2));
	}

	@Override
	public String toString(){
		String dirs = "";
		for (Field f: directions) {
			dirs += Prototype.fieldIdToObjectId.get(f) + ":";
		}
		return "Switch: " + Prototype.fieldIdToObjectId.get(this) + "," + Prototype.fieldIdToObjectId.get(entrance1)  +
				"," + Prototype.fieldIdToObjectId.get(entrance2) + ",NONE," + dirs + ",NONE,NONE,NONE";
		//<ID>,<cars>,<entrance1>,<entrance2>,[<color>],[<directions>],[<isActive>],[<exitTunnel>],[<tunnelEntrance>]

	}

}
