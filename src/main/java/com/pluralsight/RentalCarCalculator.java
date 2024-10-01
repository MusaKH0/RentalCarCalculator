package com.pluralsight;

import java.util.*;

public class RentalCarCalculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Establish KNOWN values, from requirements.
        double priceOfCarRentalPerDay = 29.99;
        double priceOfTollTagPerDay = 3.95;
        double priceOfGPSPerDay = 2.95;
        double priceOfRoadsideAssistancePerDay = 3.95;
        float underAgeSurchargePercentage = 0.30f;
        int underageSurchargeCutoffAge = 25;



        //Establish KNOWN values, from user.
        String pickupDate = promptForString("When will you pick this up? (Ex. YYYY/MM/DD): ");
        short numberOfDays = promptForShort("How many days will you need this car for?: ");
        boolean needsTollTag = promptforYesNo("Do you need a toll tag?: ");
        boolean needsGPS = promptforYesNo("Do you need a GPS?: ");
        boolean needsRoadsideAssistance = promptforYesNo("Do you need Roadside assistance?: ");
        short age = promptForByte("What is your age?: ");


        //Calculate Unknown Values
        double basicCarRentalFee = numberOfDays * priceOfCarRentalPerDay;
        double costOfTollTag = (needsTollTag) ? (numberOfDays * priceOfTollTagPerDay) : 0;
        double costOfGPS = (needsGPS) ? (numberOfDays * priceOfGPSPerDay) : 0;
        double costOfRA = (needsRoadsideAssistance) ? (numberOfDays * priceOfRoadsideAssistancePerDay) : 0;
        double optionsTotalFee = costOfRA + costOfGPS + costOfTollTag;
        double underageSurcharge = (age > underageSurchargeCutoffAge) ? (underAgeSurchargePercentage * priceOfCarRentalPerDay) : 0;
        double totalCost = basicCarRentalFee + optionsTotalFee + underageSurcharge;


        //Display the results
        System.out.printf("Basic Car Rental Fee  :  %.2f\n", basicCarRentalFee);
        System.out.printf("Options Fee           :  %.2f\n", optionsTotalFee);
        System.out.printf("Underage Surcharge Fee:  %.2f\n", underageSurcharge);
        System.out.println("-------------------------------------");
        System.out.printf("TOTAL                 :  %.2f\n", totalCost);


//        System.out.println(pickupDate);
//        System.out.println(needsTollTag);
    }



    public static String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static boolean promptforYesNo(String prompt){
        System.out.print(prompt + " ( Y for Yes, N for No ) ?: ");
        String userInput = scanner.nextLine();
        return (userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("YES"));
    }

    public static short promptForShort(String prompt){
        System.out.print(prompt);
        short userInput = scanner.nextShort();
        scanner.nextLine();
        return userInput;
    }

    public static byte promptForByte(String prompt) {
        System.out.print(prompt);
        byte userInput = scanner.nextByte();
        scanner.nextLine();
        return userInput;
    }
}


