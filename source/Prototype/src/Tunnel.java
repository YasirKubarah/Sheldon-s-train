/**
 * Tunnel is the type of the Field that can teleport train from one Field to another that is not adjacent to it.
 */
public class Tunnel extends Field {
	private Tunnel exitTunnel;
	private boolean isActive;
	private Field tunnelEntrance;
	/**
	 * This method is constructor
	 */
	public Tunnel() {
		super();
		this.isActive = false;
	}
	/**
	 * This method sets exitTunnel attribute.
	 *
	 * @param t Tunnel
	 */
	public void setExitTunnel(Tunnel t) {
		this.exitTunnel = t;
	}
	/**
	 * This method sets tunnelEntrance attribute.
	 *
	 * @param f Field
	 */
	public void setTunnelEntrance(Field f) {
		this.tunnelEntrance = f;
	}
	/**
	 * This method activates the tunnel.
	 */
	public void activate() {
		this.isActive = true;
		if(exitTunnel!=null){
			if (!exitTunnel.isActive) {
				exitTunnel.activate();
			}
		}
	}
	/**
	 * This method deactivates the tunnel.
	 */
	public void deactivate() {
		this.isActive = false;
		if(exitTunnel!=null){
			if (exitTunnel.isActive){
				exitTunnel.deactivate();
			}
		}
	}
	/**
	 * This method accepts the car to the tunnel.
	 *
	 * @param c Car
	 * @param from Field
	 * @exception TrainCollisionException Train Collision Exception
	 */
	@Override
	public void acceptCar(Car c, Field from) throws TrainCollisionException, ColorMismatchException {
		if (!isActive){
			c.collide();
			throw new TrainCollisionException();
		}
		if(from != null){
			if (this.entrance1 != from){
				this.entrance2 = this.entrance1;
				this.entrance1 = from;
			}
		}
		if (this.cars.size()>0){
			c.collide();
			throw new TrainCollisionException();
		}
		else {
			this.cars.add(c);
			c.setField(this);
			if(this.isActive){
				if (c.isVisible) {c.setInvisible();}
				else{c.setVisible();}
			}
		}
	}
	/**
	 * This method returns the field onto which the car should go next, considering the current car and the direction
	 * it came from.
	 *
	 * no arguments
	 * @return f neighbouring field
	 * no raises
	 */
	@Override
	public Field getDirection() {
		if (this.isActive){
			return this.tunnelEntrance;
		}
		else {
			return this.entrance2;
		}
	}

	public String toString(){

		return "Tunnel: " + Prototype.fieldIdToObjectId.get(this) + "," + Prototype.fieldIdToObjectId.get(entrance1)  +
				"," + Prototype.fieldIdToObjectId.get(entrance2) + ",NONE,NONE," + isActive + "," +
				Prototype.fieldIdToObjectId.get(exitTunnel) + "," + Prototype.fieldIdToObjectId.get(tunnelEntrance);
		//<ID>,<cars>,<entrance1>,<entrance2>,[<color>],[<directions>],[<isActive>],[<exitTunnel>],[<tunnelEntrance>]

	}
}
