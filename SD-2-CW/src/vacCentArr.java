import java.util.Scanner;    // Import the Scanner class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class vacCentArr{
    //Global Variables
    private static int vaccinationStock = 150;
    public static String customerName;
    public static String choice;
    public static String boothArr[] = new String[6];

    //Main Method
    public static void main(String[] args){
        viewOptions();
        initiateBoothArr();
        initiateMethod();
    }

    //This method will show all the options to the user
    public static void viewOptions(){
        System.out.println("100 or VVB: View all Vaccination Booths");
        System.out.println("101 or VEB: View all Empty Booths");
        System.out.println("102 or APB: Add Patient to a Booth");
        System.out.println("103 or RPB: Remove Patient from a Booth");
        System.out.println("104 or VPS: View Patients Sorted");
        System.out.println("105 or SPD: Store Program Data into file");
        System.out.println("106 or LPD: Load Program Data from file");
        System.out.println("107 or VRV: View Remaining Vaccinations");
        System.out.println("108 or AVS: Add Vaccinations to the Stock");
        System.out.println("999 or EXT: Exit the Program");
    }

    //This method will show all the booths and their current status
    public static void viewBooths(){
        for (int i=0; i < 6; i++){
            if(boothArr[i].equals(" ")){
                System.out.println("Booth " + i + " is empty");
            } else {
                System.out.println("Booth " + i + " is occupied by " + boothArr[i]);
            }
        } initiateMethod();
    }

    //This method will increment the vaccine stock upto 150
    public static void addVaccinations(){
        if (vaccinationStock == 20){
            System.out.println("WARNING! Only 20 vaccines remaining in the stock. Refilling.....");
            vaccinationStock = vaccinationStock + 130;
        } else {
            System.out.println("Still there are enough vaccines, no need of refilling.");
        }
        initiateMethod();
    }

    //This method will add a patient to a booth
    public static void addPatient(){
        Scanner userInput =  new Scanner(System.in);
        System.out.println("Enter Patient's Name: ");
        customerName = userInput.nextLine();

        int i=0;
        while(i<6){
            if(boothArr[i].equals(" ")) {
                boothArr[i] = customerName;
                vaccinationStock = vaccinationStock - 1;
                System.out.println("*******");
                initiateMethod();
            }
            i=i+1;
        }
    }

    //This method will show all the current empty booths
    public static void viewEmptyBooths(){
        for (int i = 0; i < 6; i++){
            if (boothArr[i].equals(" ")){
                System.out.println("Booth " + i + " is empty.");
            }
        }
        initiateMethod();
    }

    //This method will show the current vaccine amount in the stock
    public static void viewRemainingVaccinations(){
        int vacAmount = vaccinationStock;
        System.out.println("Remaining Amount of Vaccinations is: "+ vacAmount);
        initiateMethod();
    }

    //This method is to remove a patient from a booth
    public static void removePatient(){
        Scanner userInput =  new Scanner(System.in);
        System.out.println("Enter the booth number that you want to remove the patient (0-5): ");
        int boothNum = userInput.nextInt();
        boothArr[boothNum] = " ";
        initiateMethod();
    }

    //This method will write patient names in the text file
    public static void storeData() {
        try {
            FileWriter myWriter = new FileWriter("Patients.txt");
            int len = boothArr.length;
            for (int i = 0; i < len; i++) {
                myWriter.write(boothArr[i] + "\t" + "");
            }
            myWriter.close();
            System.out.println("Successfully entered the patient name to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred when storing the name.");
            e.printStackTrace();
        }
    }

    //This method will read what is written in the text file
    public static void loadData(){
        try {
            File myObj = new File("Patients.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when loading the name.");
            e.printStackTrace();
        }
    }

    //This method will start the program right after the options are shown
    public static void initiateMethod(){
        Scanner userInput = new Scanner(System.in);
        choice = userInput.nextLine();
        if ((choice.equals("100")) || (choice.equals("VVB"))){
            viewBooths();
        }
        else if ((choice.equals("101")) || (choice.equals("VEB"))){
            viewEmptyBooths();
        }
        else if ((choice.equals("102")) || (choice.equals("APB"))) {
            addPatient();
        }
        else if ((choice.equals("103")) || (choice.equals("RPB"))) {
            removePatient();
        }
        else if ((choice.equals("104")) || (choice.equals("VPS"))) {
            sortNames();
        }
        else if ((choice.equals("105")) || (choice.equals("SPD"))) {
            storeData();
        }
        else if ((choice.equals("106")) || (choice.equals("LPD"))) {
            loadData();
        }
        else if ((choice.equals("107")) || (choice.equals("VRV"))) {
            viewRemainingVaccinations();
        }
        else if ((choice.equals("108")) || (choice.equals("AVS"))) {
            addVaccinations();
        }
        else if ((choice.equals("999")) || (choice.equals("EXT"))) {
            System.exit(0);
        } else  {
            System.out.println("Invalid User Input.");
        }
    }


    //This method will erase what is in the booth array in the beginning of the program
    public static void  initiateBoothArr(){
        for(int i = 0; i < 6; i++){
            boothArr[i] = " ";
        }
    }

    //This method will sort all the names in an alphabetical order
    public static void sortNames(){
        int n = 5;
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // to compare one string with other strings
                if (boothArr[i].compareTo(boothArr[j]) > 0) {
                    // swapping
                    temp = boothArr[i];
                    boothArr[i] = boothArr[j];
                    boothArr[j] = temp;

                    // print output array
                    System.out.println("The names in alphabetical order are: ");
                    for (i = 0; i < n; i++) {
                        System.out.println(boothArr[i]);
                    }
                }
            }
        }
        initiateMethod();
    }
}



