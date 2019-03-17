import java.util.ArrayList;

/**
 * The Game is a singleton class that manages the global state of the game. It contains the collection of stages and
 * is responsible for loading new stages and managing its lifecycle.
 */
public class Game extends SkeletonBaseClass{
    private static Game ourInstance = new Game();
    public static Game getInstance() {
        return ourInstance;
    }
    private ArrayList<Stage> stages;
    private Stage currectStage;
    /**
     * This method is constructor
     */
    private Game(){
        super("g");
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +this.getClass().getSimpleName()+"()");
    }
    /**
     * This method is setter of stages attribute
     *
     * @param stages ArrayList<Stage
     */
    public void setStages(ArrayList<Stage> stages) {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"(stages)");
        this.stages = stages;
        System.out.println("<= void");
    }
    /**
     * This method is getter of stages attribute
     *
     * @return stages
     */
    public ArrayList<Stage> getStages() {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        System.out.println("<= [stages:"+stages.getClass().getSimpleName()+"]");
        return stages;
    }
    /**
     * This method is setter of currectStage attribute
     *
     * @param currectStage Stage
     */
    public void setCurrectStage(Stage currectStage) {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"("+currectStage.variableName+")");
        this.currectStage = currectStage;
        System.out.println("<= void");
    }
    /**
     * This method is getter of currectStage attribute
     *
     * @return currectStage
     */
    public Stage getCurrectStage() {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        System.out.println("<= [currectStage:"+currectStage.getClass().getSimpleName()+"]");
        return currectStage;
    }
    /**
     * This method adds stage to the stages array.
     *
     * @param s Stage
     */
    public void addStage(Stage s) {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"("+s.variableName+")");
        this.stages.add(s);
        System.out.println("<= void");
    }
    /**
     * This method sets up all the necessary data structures for the game to start. It loads the stages
     * into memory and launches the first stage.
     */
    public void startGame() {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        System.out.println("<= void");
    }
    /**
     * This method unloads the current stage and loads the next one from the stages collection.
     */
    public void nextLevel() {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        System.out.println("<= void");
    }
    /**
     * This method is run when the game is finished
     */
    public void endGame() {
        System.out.println("=> ["+this.variableName+":"+this.getClass().getSimpleName()+"]."
                +(new Object(){}).getClass().getEnclosingMethod().getName()+"()");
        System.out.println("<= void");
    }

}
