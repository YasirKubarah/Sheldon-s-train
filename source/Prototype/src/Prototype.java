import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/**
 * This class is Prototype
 */
public class Prototype {
    /**
     * This method is main function
     * @param args command line arguments
     * no returns
     * no raises
     */

    public static HashMap<Field, Integer> fieldIdToObjectId = new HashMap<>();
    public static HashMap<Car, Integer> carIdToObjectId = new HashMap<>();

    private static ArrayList<Car> carList = new ArrayList<>();


    static private boolean hasArguments(int n, String[] line){
        if((n + 1) != line.length) {
            System.err.println("Incorrect Syntax: Command " + line[0] + " expects " + n + " arguments");
            return false;
        }
        return true;
    }

    static private void loadTrains(String filename, Stage stage) throws IOException, ColorMismatchException, TrainCollisionException {
        BufferedReader br;
        List<String[]> records = new ArrayList<>();
        int engineNumber = 0;

            //br = new BufferedReader(new FileReader("C:\\Users\\vashakid\\Desktop\\Prototype\\src\\stage1.csv"));
            br = new BufferedReader(new FileReader(filename));
            String line;
            br.readLine(); // first row
            while ((line = br.readLine()) != null){
                records.add(line.split(";"));
            }
            if (records.size() <=1) {
                System.out.println("Loading Trains Failed");
                return;

            }
            for(int i = 0; i < records.size(); i++){
                Car car;
                if(records.get(i)[6].equals("NONE")){
                    car = new Engine();
                    engineNumber++;
                } else {
                    car = new PassengerCar();
                }

                if (records.get(i)[1].equals("TRUE")){
                    car.setVisible();
                } else {
                    car.setInvisible();
                }

                Field field = stage.fields.get(Integer.parseInt(records.get(i)[2]));
                if ((i + 1) >= records.size() || records.get(i+1).equals("NONE")){
                    int currFieldID = Integer.parseInt(records.get(i)[2]);
                    int prevFieldID = Integer.parseInt(records.get(i - 1)[2]);
                    field.acceptCar(car, stage.fields.get(2 * currFieldID - prevFieldID));
                } else {
                    field.acceptCar(car, stage.fields.get(Integer.parseInt(records.get(i+1)[2])));
                }
                //field.acceptCar(car);
                car.setField(field);

                carList.add(car);
                carIdToObjectId.put(car, i + 1);
            }

            if (engineNumber == 0) {
                System.out.println("Loading Trains Failed");
                return;
            }




            for(int i = 0; i < records.size(); i++){
                Car c = carList.get(i);
                if (!records.get(i)[3].equals("NONE")){
                    c.setNext(carList.get(Integer.parseInt(records.get(i)[3]) - 1));
                }
                if (PassengerCar.class.isInstance(c)){
                    ((PassengerCar)c).setColor(Color.valueOf(records.get(i)[4]));
                    if (records.get(i)[5].equals("TRUE")){
                        ((PassengerCar)c).activate();
                    }
                    ((PassengerCar)c).setPassengerCount(Integer.parseInt(records.get(i)[6]));
                }
            }

            System.out.println("Trains Loaded Successfully");




    }

    static private Stage loadStage(String filename){
        Stage stage_one = new Stage();
        List<String[]> records = new ArrayList<>();
        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(filename));
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\t");
                records.add(values);
            }
            br.close();

        }
        catch (Exception e) {
            //TODO: handle exception
            //br.close();
        }


        if(records.size()!= 100){
            System.out.println("Stage Loading Failed ");
            return null;
        }
        stage_one.addField(null);
        for (int i = 0; i < records.size(); i++) {
            if (!records.get(i)[0].equals("NONE")) {
                if(!records.get(i)[0].equals(Integer.toString(i+1))){
                    System.out.println("Stage Loading Failed ");
                    return null;
                }
            }

            boolean hasTwoEntrances = (!records.get(i)[2].equals("NONE")) && (!records.get(i)[3].equals("NONE"));
            boolean entrancesNotSame = !records.get(i)[2].equals(records.get(i)[3]);
            boolean twoEntranceCheck = hasTwoEntrances && entrancesNotSame;

            boolean hasExitTunnel = !records.get(i)[7].equals("NONE");
            boolean stationHasColor = !records.get(i)[4].equals("NONE");


            if(!records.get(i)[7].equals("NONE")) {
                if (hasTwoEntrances && hasExitTunnel) {
                    Tunnel t = new Tunnel();
                    fieldIdToObjectId.put(t, i + 1);
                    stage_one.addField(t);
                } else {
                    System.out.println("Stage Loading Failed ");
                    return null;
                }
            }
            else if (!records.get(i)[5].equals("NONE")) {
                if(twoEntranceCheck) {
                    Switch s = new Switch();
                    fieldIdToObjectId.put(s, i + 1);
                    stage_one.addField(s);
                } else {
                    System.out.println("Stage Loading Failed");
                    return null;
                }
            }
            else if (!records.get(i)[4].equals("NONE")) {
                if(twoEntranceCheck && stationHasColor) {
                    Station s = new Station();
                    fieldIdToObjectId.put(s, i + 1);
                    stage_one.addField(s);
                }else {
                    System.out.println("Stage Loading Failed");
                    return null;
                }
            }
            else if (records.get(i)[3].equals("NONE") && !records.get(i)[2].equals("NONE")) {
                DeadEnd de = new DeadEnd();
                fieldIdToObjectId.put(de, i + 1);
                stage_one.addField(de);
            }
            else if (records.get(i)[3].equals("NONE") && records.get(i)[2].equals("NONE")) {
                stage_one.addField(null);
            }
            else {
                if(twoEntranceCheck) {
                    RailRoad r = new RailRoad();
                    fieldIdToObjectId.put(r, i + 1);
                    stage_one.addField(r);
                }else{
                    System.out.println("Stage Loading Failed");
                    return null;
                }
            }
        }
        if(stage_one.fields.size()!= 101) {
            System.out.println("Stage Loading Failed");
            return null;
        }


        for (int i = 0; i < records.size(); i++) {
            String[] row = records.get(i);
            Field field = stage_one.fields.get(i+1);
            if(RailRoad.class.isInstance(field)) {
                field.setEntrance1(stage_one.fields.get(Integer.parseInt(row[2])));
                field.setEntrance2(stage_one.fields.get(Integer.parseInt(row[3])));
            }
            else if(Station.class.isInstance(field)) {
                field.setEntrance1(stage_one.fields.get(Integer.parseInt(row[2])));
                field.setEntrance2(stage_one.fields.get(Integer.parseInt(row[3])));
                Station station = (Station)field;
                station.setColor(Color.valueOf(row[4]));
            }
            else if(DeadEnd.class.isInstance(field)) {
                field.setEntrance1(stage_one.fields.get(Integer.parseInt(row[2])));
            }
            else if(Switch.class.isInstance(field)) {
                field.setEntrance1(stage_one.fields.get(Integer.parseInt(row[2])));
                field.setEntrance2(stage_one.fields.get(Integer.parseInt(row[3])));
                Switch aswitch = (Switch) field;
                int[] directions = new int[4];
                String[] directions_string = row[5].split(":");
                for (int a = 0; a < directions_string.length; a++) {
                    directions[a] = Integer.parseInt(directions_string[a]);
                    aswitch.addDirection(stage_one.fields.get(directions[a]));
                }

            } else if (Tunnel.class.isInstance(field)) {

                field.setEntrance1(stage_one.fields.get(Integer.parseInt(row[2])));
                field.setEntrance2(stage_one.fields.get(Integer.parseInt(row[3])));
                Tunnel tunnel = (Tunnel)field;
                tunnel.deactivate();
                tunnel.setExitTunnel((Tunnel)stage_one.fields.get(Integer.parseInt(row[7])));
                Tunnel test_tunnel = null;
                if(!row[8].equals("NONE"))
                    test_tunnel = (Tunnel)stage_one.fields.get(Integer.parseInt(row[8]));
                tunnel.setTunnelEntrance(test_tunnel);
            }
        }

        System.out.println("Stage Loaded Successfully");
        return stage_one;
    }

    static public void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prototype started\n");

        Stage stage = null;

        boolean stageLoadedBool = false;
        boolean trainsLoadedBool = false;
        boolean tunnelWarning = false;
        boolean tunnelseSetBool = false;

        boolean readInput = true;
        while(readInput){
            String[] line = scanner.nextLine().split(" "); // Split input line with spacel

            switch (line[0]){
                case "loadStage":
                        if(hasArguments(1, line)){
                            stage = loadStage(line[1]);
                            stageLoadedBool = true;
                        }
                        break;
                case "printStage":
                    if(hasArguments(0, line)){
                        for(Field f: stage.fields){
                            if(f != null)
                                System.out.println(f);
                        }
                    }
                    break;
                case "loadTrains":
                    if(hasArguments(1, line)){
                        try {
                            loadTrains(line[1], stage);
                        } catch (ColorMismatchException e) {
                            e.printStackTrace();
                        } catch (TrainCollisionException e) {

                        }
                        trainsLoadedBool = true;
                    }
                    break;

                case "moveTrains":
                    if(hasArguments(0, line)){
                        for(Car c: carList){
                            if (Engine.class.isInstance(c)){
                                ((Engine) c).move();
                            }
                        }
                    }
                    break;

                case "printTrains":
                    if(hasArguments(0, line)){
                        for(Car c: carList){

                            System.out.println(c);
                        }
                    }
                    break;

                case "changeSwitch":
                    if(hasArguments(1, line)){
                        for(Field f: fieldIdToObjectId.keySet()){
                            if (Integer.parseInt(line[1]) == fieldIdToObjectId.get(f)){
                                ((Switch) f).changeDirection();
                            }
                        }
                    }
                    break;
                case "activateTunnel":
                    if(hasArguments(1, line)){
                        for(Field f: fieldIdToObjectId.keySet()){
                            if (Integer.parseInt(line[1]) == fieldIdToObjectId.get(f)){
                                ((Tunnel) f).activate();
                                System.out.println("Tunnel Created");
                            }
                        }
                    }
                    break;
                case "deactivateTunnel":
                    if(hasArguments(1, line)){
                        for(Field f: fieldIdToObjectId.keySet()){
                            if (Integer.parseInt(line[1]) == fieldIdToObjectId.get(f)){
                                ((Tunnel) f).deactivate();
                            }
                        }
                    }
                    break;
                case "exit":
                    readInput = false;
                    break;

                default: System.err.println("Invalid command");
            }
            if(stageLoadedBool && trainsLoadedBool && !tunnelWarning) {
                System.out.println("Ready to Setup Tunnels");
                tunnelWarning = true;
            }

        }

        scanner.close();

    }
}
