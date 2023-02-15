import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Booth {
    //Data (Global)
    public  int vaccinationStock = 150;
    public  String customerName;
    public  String choice;
    public  String boothArr[] = new String[6];

    //All the Methods
    public void viewOptions(){
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
        this.initiateMethod();
    }

    //This method will view all the booths and their status
    public void viewBooths(){
        for (int i=0; i < 6; i++){
            if(boothArr[i].equals(" ")){
                System.out.println("Booth " + i + " is empty");
            } else {
                System.out.println("Booth " + i + " is occupied by " + boothArr[i]);
            }
        } this.initiateMethod();
    }

    //This method will add vaccines to the stock after it is 130, if not it will give a message
    public void addVaccinations(){
        if (vaccinationStock == 20){
            System.out.println("WARNING! Only 20 vaccines remaining in the stock. Refilling.....");
            vaccinationStock = vaccinationStock + 130;
        } else {
            System.out.println("Still there are enough vaccines, no need of refilling.");
        }
        this.initiateMethod();
    }

    //This method will add patients to a booth according to their preferred vaccine type
    public void addPatient(){
        Patient patient_1 = new Patient();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the First Name: ");
        customerName = userInput.nextLine();

        System.out.println("Enter the Surname: ");
        String surName1 = userInput.nextLine();
        patient_1.setSurName(surName1);

        System.out.println("Enter the Age: ");
        String patientAge1 = userInput.nextLine();
        patient_1.setpAge(patientAge1);

        System.out.println("Enter the City: ");
        String cityName1 = userInput.nextLine();
        patient_1.setCityName(cityName1);

        System.out.println("Enter the NIC: ");
        String nicNum1 = userInput.nextLine();
        patient_1.setIdNumber(nicNum1);

        System.out.println("Please enter your Vaccine type AstraZeneca (1), Sinopharm (2), Pfizer (3): ");
        String vaccina1 = userInput.nextLine();
        patient_1.setVaccineName(vaccina1);

        if (vaccina1.equals("1")){
           if(boothArr[0].equals(" ")){
               boothArr[0] = customerName;
               vaccinationStock = vaccinationStock - 1;
               System.out.println("*******");
               this.initiateMethod();

           }
           else if (boothArr[1].equals(" ")) {
               boothArr[1] = customerName;
               vaccinationStock = vaccinationStock - 1;
               System.out.println("*******");
               this.initiateMethod();

           }
           else {
               System.out.println("Please Wait!");
               this.initiateMethod();
           }
        }
        else if (vaccina1.equals("2")){
            if(boothArr[2].equals(" ")){
                boothArr[2] = customerName;
                vaccinationStock = vaccinationStock - 1;
                System.out.println("*******");
                this.initiateMethod();

            }
            else if (boothArr[3].equals(" ")) {
                boothArr[3] = customerName;
                vaccinationStock = vaccinationStock - 1;
                System.out.println("*******");
                this.initiateMethod();

            }
            else {
                System.out.println("Please Wait!");
                this.initiateMethod();
            }
        }
        else if (vaccina1.equals("3")){
            if(boothArr[4].equals(" ")){
                boothArr[4] = customerName;
                vaccinationStock = vaccinationStock - 1;
                System.out.println("*******");
                this.initiateMethod();

            }
            else if (boothArr[5].equals(" ")) {
                boothArr[5] = customerName;
                vaccinationStock = vaccinationStock - 1;
                System.out.println("*******");
                this.initiateMethod();

            }
            else {
                System.out.println("Please Wait!");
                this.initiateMethod();
            }
          }
        else {
            System.out.println("Invalid choice! Please enter a value between 1-3.");
        }
    }

    //This method will view all the vacant booths
    public void viewEmptyBooths(){
        for (int i = 0; i < 6; i++){
            if (boothArr[i].equals(" ")){
                System.out.println("Booth " + i + " is empty.");
            }
        }
        this.initiateMethod();
    }

    //This method will show all the remaining vaccinations
    public void viewRemainingVaccinations(){
        int vacAmount = vaccinationStock;
        System.out.println("Remaining Amount of Vaccinations is: "+ vacAmount);
        this.initiateMethod();
    }

    //This method will remove a patient from the entered booth number
    public void removePatient(){
        Scanner userInput =  new Scanner(System.in);
        System.out.println("Enter the booth number that you want to remove the patient (0-5): ");
        int boothNum = userInput.nextInt();
        boothArr[boothNum] = " ";
        this.initiateMethod();
    }

    //This method will store patient name in a text file
    public void storeData() {
        try {
            FileWriter myWriter = new FileWriter("Patients.txt");
            int len = boothArr.length;
            for (int i = 0; i < len; i++) {
                myWriter.write(boothArr[i] + "\t" + "");
            }
            this.initiateMethod();
            myWriter.close();
            System.out.println("Successfully entered the patient name to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred when storing the name.");
            e.printStackTrace();
        }
    }

    //This method will read the data that is stored in the text file
    public void loadData(){
        try {
            File myObj = new File("Patients.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            this.initiateMethod();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when loading the name.");
            e.printStackTrace();
        }
    }

    //This method will start the program and get the user input
    public void initiateMethod(){
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
        else if ((choice.equals("109")) || (choice.equals("EXT"))) {
            System.exit(0);
        } else  {
            System.out.println("Invalid User Input.");
        }
    }

    ////This method will erase what is in the booth array in the beginning of the program
    public void initiateBoothArr(){
        for(int i = 0; i < 6; i++){
            boothArr[i] = " ";
        } this.viewOptions();
    }

    public void sortNames(){
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
        this.initiateMethod();

    }



}
