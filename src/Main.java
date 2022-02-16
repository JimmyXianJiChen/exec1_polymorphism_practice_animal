import java.util.Scanner;

public class Main {
    public static boolean isAvailableWeight(String str){
        try{
            Float.parseFloat(str);
            return true;
        }
        catch(Exception e){
            System.out.println("Invalid weight!");
            System.out.println("Please try again!");
            return false;
        }
    }
    public static boolean isAvailableIndex(String str, int num){
        try{
            Integer.parseInt(str);
        }
        catch(Exception e){
            System.out.println("Invalid index!");
            System.out.println("Please try again!");
            return false;
        }
        if(Integer.parseInt(str) < 0 || Integer.parseInt(str)>num){
            System.out.println("Index out of range!");
            System.out.println("Please try again!");
            return false;
        }
        return true;
    }
    public static boolean genreOrNameIsBlank(String genre, String name){
        if(genre.isBlank()||name.isBlank()||genre.isEmpty()||name.isEmpty()){
            System.out.println("The genre and name of the animal can't be blank!!");
            System.out.println("Please try again!");
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cmd;
        String[] arg;
        AnimalArray arr = new AnimalArray();
        System.out.println(
        """
        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        command instructions:
        -----------------------------------------------------
        add: add an animal to the list at the end of the list
        insert: insert an animal to the specified index in the list
        delete: delete the animal at the specified index in the list
        sort: sort the animals in the array by their weights/names
        show: show all the animals in the list by their current order
        exist: quit the application
        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        """
        );
        boolean go = true;
        while(go){
            System.out.println("Which action do you want to take? (add/insert/delete/sort/show/exit)");
            cmd = sc.nextLine();
            switch (cmd){
                case "add":
                    System.out.println("Please enter the genre, name, and weight of the animal in order:");
                    cmd = sc.nextLine();
                    arg = cmd.split(" ");
                    if(arg.length!=3){
                        System.out.println("The number of parameters is not correct!");
                        System.out.println("Please try again!");
                        break;
                    }
                    else if(!isAvailableWeight(arg[2])||genreOrNameIsBlank(arg[0],arg[1])){
                        break;
                    }
                    switch (arg[0]){
                        case("dog"):{
                            arr.addAnimal(new Dog(arg[1],  Float.parseFloat(arg[2])));
                            break;
                        }
                        case("cat"):{
                            arr.addAnimal(new Cat(arg[1],  Float.parseFloat(arg[2])));
                            break;
                        }
                        case("mouse"):{
                            arr.addAnimal(new Mouse(arg[1],  Float.parseFloat(arg[2])));
                            break;
                        }
                        default:{
                            System.out.println("Animal Type doesn't exist, please try other species.");
                            break;
                        }
                    }
                    break;
                case "insert":{
                    System.out.println("Please enter the index, genre, name, and weight of the animal in order:");
                    cmd = sc.nextLine();
                    arg = cmd.split(" ");

                    if(arg.length!=4){
                        System.out.println("The number of parameters is not correct!");
                        System.out.println("Please try again!");
                        break;
                    }
                    else if(!isAvailableIndex(arg[0], arr.getAnimalNum())||genreOrNameIsBlank(arg[1],arg[2])||!isAvailableWeight(arg[3])){
                        break;
                    }

                    switch (arg[1]){
                        case("dog"):{
                            arr.addAnimalAt(Integer.parseInt(arg[0]),new Dog(arg[2],  Float.parseFloat(arg[3])));
                            break;
                        }
                        case("cat"):{
                            arr.addAnimalAt(Integer.parseInt(arg[0]),new Cat(arg[2],  Float.parseFloat(arg[3])));
                            break;
                        }
                        case("mouse"):{
                            arr.addAnimalAt(Integer.parseInt(arg[0]),new Mouse(arg[2],  Float.parseFloat(arg[3])));
                            break;
                        }
                        default:{
                            System.out.println("Animal Type doesn't exist, please try other species.");
                            break;
                        }
                    }
                    break;
                }
                case "delete":{
                    System.out.println("Which animal do you want to delete? (Please enter the index)");
                    cmd = sc.nextLine();
                    if(!isAvailableIndex(cmd, arr.getAnimalNum())) {
                        break;
                    }
                    arr.delete(Integer.parseInt(cmd));
                    break;
                }
                case "sort":{
                    System.out.println("Which sorting method do you want to use? (byWeight/byName)");
                    cmd = sc.nextLine();
                    switch (cmd){
                        case "byWeight":{
                            arr.sortByWeight();
                            break;
                        }
                        case "byName":{
                            arr.sortByName();
                            break;
                        }
                        default:{
                            System.out.println("Sorting method: " + cmd + " does not exist!");
                            System.out.println("Please try again!");
                            break;
                        }
                    }
                    break;
                }
                case "show":{
                    arr.printAllAnimals();
                    break;
                }
                case "exit":{
                    go = false;
                    break;
                }
                default:{
                    System.out.println("Action" + cmd + " not found, please enter an available command!");
                    break;
                }
            }
            System.out.println("============================================");
        }
        System.out.println("============================================");
        System.out.println("Program exited!");
        System.out.println("============================================");
    }
}
