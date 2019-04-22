import java.util.ArrayList;

/**
 * The Game is a singleton class that manages the global state of the game. It contains the collection of stages and
 * is responsible for loading new stages and managing its lifecycle.
 */
public class Game{
    private static Game ourInstance = new Game();
    public static Game getInstance() {
        return ourInstance;
    }
    private Stage currectStage;
    private ArrayList<Stage> stages;
    /**
     * This method is constructor
     */
    private Game(){
        super();
    }
    /**
     * This method adds stage to the stages array.
     *
     * @param s Stage
     */
    public void addStage(Stage s) {
        this.stages.add(s);
    }
    /**
     * This method sets up all the necessary data structures for the game to start. It loads the stages
     * into memory and launches the first stage.
     */
    public void startGame() {
    }
    /**
     * This method unloads the current stage and loads the next one from the stages collection.
     */
    public void nextLevel() {
    }
    /**
     * This method is run when the game is finished
     */
    public void endGame() {
        System.out.println("Game Over");
    }

}
