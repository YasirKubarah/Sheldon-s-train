import java.util.ArrayList;
/**
 * The main timer of the game. On Every tick every engine makes a move.
 */
public class Timer extends SkeletonBaseClass{
    private static Timer ourInstance = new Timer();
    public static Timer getInstance() { return ourInstance;}
    private ArrayList<Engine> engines;
    /**
     * This method is constructor
     */
    private Timer() {
        super("t");
        System.out.println("=> ["+variableName+":"+this.getClass().getSimpleName()+"]."
                +this.getClass().getSimpleName()+"()");
    }
    /**
     * This method - Tick that fires moves on every engine in the engines collection.
     */
    public void tick() {
        System.out.println("=> ["+variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        for (Engine engine: this.engines){
            engine.move();
        }
        System.out.println("<= void");
    }
    /**
     * This method adds engine to the engines array.
     *
     * @param e Engine
     */
    public void addEngine(Engine e) {
        System.out.println("=> ["+variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"("+e.variableName+")");
        engines.add(e);
        System.out.println("<= void");
    }
}
