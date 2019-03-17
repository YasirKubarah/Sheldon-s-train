import java.util.Scanner;
/**
 * This class is Skeleton
 */
public class Skeleton {
    /**
     * This method is main function
     * @param args command line arguments
     * no returns
     * no raises
     */
    static public void main(String[] args){
        String commandNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skeleton started\n");
        while(true){
            System.out.println("\nPlease choose command from the list bellow:");
            System.out.print("\t1. Move Train\n\t2. Collide Trains\n\t3. Arrive to Station\n\t4. Activate Tunnel\n" +
                    "\t5. Deactivate Tunnel\n\t6. Enter Tunnel\n\t7. Control Switch\n\t8. Pass Switch\n\t0. Exit" +
                    "\n\nOption:");
            commandNumber = scanner.nextLine();

            switch (commandNumber){
                case "1":
                    moveTrain();
                    break;
                case "2":
                    collideTrains();
                    break;
                case "3":
                    arriveToStation();
                    break;
                case "4":
                    activateTunnel();
                    break;
                case "5":
                    deactivateTunnel();
                    break;
                case "6":
                    enterTunnel();
                    break;
                case "7":
                    controlSwitch();
                    break;
                case "8":
                    passSwitch();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("\nError: unknown command number, please try again.\n");
                    break;
            }

        }
    }
    /**
     * This method simulates "Move Train" command
     * no arguments
     * no returns
     * no raises
     */
    static private void moveTrain(){

        System.out.println("\n1. Move Train\n");

        System.out.println("Initialization");
        Engine e = new Engine("e");
        RailRoad cf = new RailRoad("cf");
        Field nf = new RailRoad("nf");
        Field pf = new RailRoad("pf");
        PassengerCar nc = new PassengerCar("nc");
        PassengerCar nc1 = new PassengerCar("nc1");

        e.setField(cf);
        cf.pushCar(e);
        cf.setEntrance1(pf);
        pf.setEntrance2(cf);
        cf.setEntrance2(nf);
        nf.setEntrance1(cf);
        e.setNext(nc);
        nc.setField(pf);
        pf.pushCar(nc);
        nc.setNext(nc1);

        System.out.println("\nSimulation");
        e.move();
    }
    /**
     * This method simulates "Collide Trains" command
     * no arguments
     * no returns
     * no raises
     */
    static private void collideTrains(){

        System.out.println("\n2. Collide Trains\n");

        String command;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\nIs There another engine on the nf field? (Yes/No)");
            System.out.print("Option:");
            command = scanner.nextLine();

            if (command.equals("Yes"))
                break;
            else if (command.equals("No"))
                break;
            else
                System.out.println("\nError: unknown command number, please try again.\n");
        }
        System.out.println("Initialization");
        Engine e1 = new Engine("e1");

        Field cf = new RailRoad("cf");
        Field nf = new RailRoad("nf");
        if (command.equals("Yes")) {
            Engine e2 = new Engine("e2");
            e2.setField(nf);
            nf.pushCar(e2);
        }
        Game g = Game.getInstance();
        e1.setField(cf);
        cf.pushCar(e1);
        cf.setEntrance2(nf);

        System.out.println("\nSimulation");
        e1.move();
    }
    /**
     * This method simulates "Arrive to Station" command
     * no arguments
     * no returns
     * no raises
     */
    static private void arriveToStation(){
        System.out.println("\n3. Arrive to Station\n");

        String command;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\nIs c active? (Yes/No)");
            System.out.print("Option:");
            command = scanner.nextLine();

            if (command.equals("Yes"))
                break;
            else if (command.equals("No"))
                break;
            else
                System.out.println("\nError: unknown command number, please try again.\n");
        }

        System.out.println("Initialization");
        PassengerCar c = new PassengerCar("c");
        Station st = new Station("st");
        Car nc = new PassengerCar("nc");
        Stage s = new Stage("s");
        RailRoad cf = new RailRoad("cf");

        c.setPassengerCount(1);
        s.setPassengerCount(5);
        c.setColor(Color.RED);
        st.setColor(Color.RED);
        st.setStage(s);
        if (command.equals("Yes")) {
            c.activate();
        }
        c.setNext(nc);

        System.out.println("\nSimulation");
        c.moveTo(st);
    }
    /**
     * This method simulates " Activate Tunnel" command
     * no arguments
     * no returns
     * no raises
     */
    static private void activateTunnel(){

        System.out.println("\n4. Activate Tunnel\n");

        System.out.println("Initialization");
        Tunnel t1 = new Tunnel("t1");
        Tunnel t2 = new Tunnel("t2");
        t1.setExitTunnel(t2);
        t2.setExitTunnel(t1);
        t1.deactivate();
        t2.deactivate();


        System.out.println("\nSimulation");
        t1.activate();
    }
    /**
     * This method simulates "Deactivate Tunnel" command
     * no arguments
     * no returns
     * no raises
     */
    static private void deactivateTunnel(){

        System.out.println("\n5. Deactivate Tunnel\n");

        System.out.println("Initialization");
        Tunnel t1 = new Tunnel("t1");
        Tunnel t2 = new Tunnel("t2");
        t1.setExitTunnel(t2);
        t2.setExitTunnel(t1);
        t1.activate();
        t2.activate();

        System.out.println("\nSimulation");
        t1.deactivate();
    }
    /**
     * This method simulates "Enter Tunnel" command
     * no arguments
     * no returns
     * no raises
     */
    static private void enterTunnel(){
        System.out.println("\n6. Enter Tunnel\n");

        System.out.println("Initialization");
        Engine e = new Engine("e");
        Tunnel t1 = new Tunnel("t1");
        RailRoad cf = new RailRoad("cf");
        e.setField(cf);
        cf.pushCar(e);
        cf.setEntrance2(t1);
        t1.activate();

        System.out.println("\nSimulation");
        e.move();
    }
    /**
     * This method simulates "Control Switch" command
     * no arguments
     * no returns
     * no raises
     */
    static private void controlSwitch(){
        System.out.println("\n7. Control Switch\n");

        System.out.println("Initialization");
        Switch sw =new Switch("sw");

        System.out.println("\nSimulation");
        sw.changeDirection();
    }
    /**
     * This method simulates "Pass Switch" command
     * no arguments
     * no returns
     * no raises
     */
    static private void passSwitch(){
        System.out.println("\n8. Pass Switch\n");

        System.out.println("Initialization");
        Engine e = new Engine("e");
        Switch cf = new Switch("cf");
        Field nf = new RailRoad("nf");
        Field pf = new RailRoad("pf");
        PassengerCar nc = new PassengerCar("nc");
        PassengerCar nc1 = new PassengerCar("nc1");

        e.setField(cf);
        cf.pushCar(e);
        cf.setEntrance1(pf);
        pf.setEntrance2(cf);
        cf.setEntrance2(nf);
        nf.setEntrance1(cf);
        e.setNext(nc);
        nc.setField(pf);
        pf.pushCar(nc);
        nc.setNext(nc1);

        System.out.println("\nSimulation");
        e.move();

    }
}
