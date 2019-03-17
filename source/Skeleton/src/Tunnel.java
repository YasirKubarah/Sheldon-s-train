/**
 * Tunnel is the type of the Field that can teleport train from one Field to another that is not adjacent to it.
 */
public class Tunnel extends Field {
	private boolean isActive;
	private Tunnel exitTunnel;
	private Field tunnelEntrance;
	/**
	 * This method is constructor
	 *
	 * @param variableName String
	 */
	public Tunnel(String variableName) {
		super(variableName);
		this.isActive = false;
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+this.getClass().getSimpleName()+"("+variableName+")");
	}
	/**
	 * This method is setter of exitTunnel attribute
	 *
	 * @param t Tunnel
	 */
	public void setExitTunnel(Tunnel t) {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+t.variableName+")");
		this.exitTunnel = t;
		System.out.println("<= void");
	}
	/**
	 * This method is setter of tunnelEntrance attribute
	 *
	 * @param f Field
	 */
	public void setTunnelEntrance(Field f) {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+f.variableName+")");
		this.tunnelEntrance = f;
		System.out.println("<= void");
	}
	/**
	 * This method activates the tunnel.
	 */
	public void activate() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		this.isActive = true;
		if(exitTunnel!=null){
			if (!exitTunnel.isActive) {
				exitTunnel.activate();
			}
		}
		System.out.println("<= void");
	}
	/**
	 * This method deactivates the tunnel.
	 */
	public void deactivate() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		this.isActive = false;
		if(exitTunnel!=null){
			if (exitTunnel.isActive){
				exitTunnel.deactivate();
			}
		}
		System.out.println("<= void");
	}
	/**
	 * This method accepts car from one of the entrance. We need to know the exact entrance in order to determine the
	 * direction of the car ( which  neighboring field it should move next)
	 * @param c Car
	 * @param from Field
	 * @exception TrainCollisionException Train Collision Exception
	 */
	@Override
	public void acceptCar(Car c, Field from) throws TrainCollisionException, ColorMismatchException {
		if(from == null){
			System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
					+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+c.variableName+
					", from)");
		}
		else{
			System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
					+(new Object(){}).getClass().getEnclosingMethod().getName()+"("+c.variableName+
					", "+from.variableName +")");
		}
		if (this.cars.size()>0){
			c.collide();
			System.out.println("<= void");
			throw new TrainCollisionException();
		}
		else {
			this.cars.add(c);
			c.setField(this);
			if(this.isActive){
				if (c.isVisible) {c.setInvisible();}
				else{c.setVisible();}
			}
			System.out.println("<= void");
		}
	}
	/**
	 * This method - considering the current car and the direction it came from, this function returns the field onto
	 * which the car should go next.
	 * no arguments
	 * @return f neighbouring field
	 * no raises
	 */
	@Override
	public Field getDirection() {
		System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
				+(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
		if (this.isActive){
			System.out.println("<= ["+tunnelEntrance.variableName+":"+tunnelEntrance.getClass().getSimpleName()+"]");
			return this.tunnelEntrance;
		}
		else {
			System.out.println("<= ["+entrance2.variableName+":"+entrance2.getClass().getSimpleName()+"]");
			return this.entrance2;
		}
	}
}
