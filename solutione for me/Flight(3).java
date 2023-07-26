/*
Anan alian
1211529
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Flight {
    //Create array of seats
    private static Seat[][] flightSeat = new Seat[12][];
    public static int number;

    public static void main(String[] args) throws FileNotFoundException {
        //initialize seats
        flightSeat[0] = new Seat[2];
        flightSeat[0][0] = new Seat("A1");
        flightSeat[0][1] = new Seat("C1");

        flightSeat[1] = new Seat[2];
        flightSeat[1][0] = new Seat("A2");
        flightSeat[1][1] = new Seat("C2");

        flightSeat[2] = new Seat[2];
        flightSeat[2][0] = new Seat("A3");
        flightSeat[2][1] = new Seat("C3");

        flightSeat[3] = new Seat[4];
        flightSeat[3][0] = new Seat("A4");
        flightSeat[3][1] = new Seat("B4");
        flightSeat[3][2] = new Seat("C4");
        flightSeat[3][3] = new Seat("D4");

        flightSeat[4] = new Seat[4];
        flightSeat[4][0] = new Seat("A5");
        flightSeat[4][1] = new Seat("B5");
        flightSeat[4][2] = new Seat("C5");
        flightSeat[4][3] = new Seat("D5");

        flightSeat[5] = new Seat[4];
        flightSeat[5][0] = new Seat("A6");
        flightSeat[5][1] = new Seat("B6");
        flightSeat[5][2] = new Seat("C6");
        flightSeat[5][3] = new Seat("D6");

        flightSeat[6] = new Seat[4];
        flightSeat[6][0] = new Seat("A7");
        flightSeat[6][1] = new Seat("B7");
        flightSeat[6][2] = new Seat("C7");
        flightSeat[6][3] = new Seat("D7");

        flightSeat[7] = new Seat[4];
        flightSeat[7][0] = new Seat("A8");
        flightSeat[7][1] = new Seat("B8");
        flightSeat[7][2] = new Seat("C8");
        flightSeat[7][3] = new Seat("D8");

        flightSeat[8] = new Seat[4];
        flightSeat[8][0] = new Seat("A9");
        flightSeat[8][1] = new Seat("B9");
        flightSeat[8][2] = new Seat("C9");
        flightSeat[8][3] = new Seat("D9");

        flightSeat[9] = new Seat[4];
        flightSeat[9][0] = new Seat("A10");
        flightSeat[9][1] = new Seat("B10");
        flightSeat[9][2] = new Seat("C10");
        flightSeat[9][3] = new Seat("D10");

        flightSeat[10] = new Seat[4];
        flightSeat[10][0] = new Seat("A11");
        flightSeat[10][1] = new Seat("B11");
        flightSeat[10][2] = new Seat("C11");
        flightSeat[10][3] = new Seat("D11");

        flightSeat[11] = new Seat[4];
        flightSeat[11][0] = new Seat("A12");
        flightSeat[11][1] = new Seat("B12");
        flightSeat[11][2] = new Seat("C12");
        flightSeat[11][3] = new Seat("D12");


        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        //call to function to display menu
        displays_a_menu();
        System.out.println("----------------------------------------------");
        System.out.println(" enter the number  1----7 : ");
        //User enters seat number
        number = input.nextInt();

        // Read user choice, and determine which function will be call
        while (number != 7) {
            switch (number) {
                case 1:
                    // Call Reserve_Seat function
                    Read_passengers_file(new Scanner(input.nextLine()));
                    break;
                case 2:
                    // Call Delete specific seat function
                    Reserve_a_new_empty_seat();
                    break;
                case 3:
                    // Call delete all seats function
                    Delete_a_reserved_seat();
                    break;
                case 4:
                    // Call delete all reserved seats
                    Delete_all_reserved_seats();
                    break;
                case 5:
                    // Call update passenger file
                    Update_passengers_file();
                    break;
                case 6:
                    // Call print out flight seats map
                    Print_out_flight_seats_map();
                    break;
                default:
                    // wrong choice
                    System.out.println("please enter valid choice ");
            }

            System.out.println("----------------------------------------------");
            displays_a_menu();
            System.out.println("----------------------------------------------");
            System.out.println(" enter the number  1----7 : ");
            number = input.nextInt();
        }

        System.out.println("\nTHANK YOU _^_");
    }

    // This function displays the selection menu
    public static void displays_a_menu() {
        System.out.println(" 1.Read passengers file.");
        System.out.println(" 2.Reserve a new empty seat.");
        System.out.println(" 3.Delete a reserved seat.");
        System.out.println(" 4.Delete all reserved seats.");
        System.out.println(" 5.Update passengers file.");
        System.out.println(" 6.Print flight seats map.");
        System.out.println(" 7.Quit.");
    }

    //in this function to check Status all seat (reserved or not)
    public static boolean checkStatusForAllSeats(boolean x) {
        for (int i = 0; i < flightSeat.length; i++) {
            for (int j = 0; j < flightSeat[i].length; j++) {
                if (flightSeat[i][j].isEmpty() != x) {
                    return false;
                }
            }
        }
        return true;
    }

    //in this function to reade the passenger name in file
    public static void Read_passengers_file(Scanner scanner) throws FileNotFoundException {
        Scanner input = new Scanner(new File("passengers.txt"));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] result = line.split(":");
            if (Seat.isValid(line)) {
                boolean temp = false;
                for (int i = 0; i < flightSeat.length; i++) {
                    if (temp) break;
                    ;
                    for (int j = 0; j < flightSeat[i].length; j++) {
                        if (result[0].equals(flightSeat[i][j].getSeatNumber())) {
                            if (flightSeat[i][j].isEmpty()) {
                                flightSeat[i][j].setPassengerName(result[1]);
                                temp = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("the number seat D500 is invalid ");
        System.out.println("A1 not empty");

    }

    //in this function to reserve a new seat
    public static void Reserve_a_new_empty_seat() {
        //check Status all seat
        if (checkStatusForAllSeats(false)) {
            System.out.println("All seats are  reserved\n");
            return;
        }
        Scanner input = new Scanner(System.in);
        boolean temp = true;
        while (temp) {
            System.out.println("Enter the seat number and passenger name you want to reserve");
            //the user enter the passenger name
            String str = input.nextLine();
            //split in str
            String[] result = str.split(":");

            if (Seat.isValid(str)) {
                for (int i = 0; i < flightSeat.length; i++) {
                    for (int j = 0; j < flightSeat[i].length; j++) {
                        if (result[0].equals(flightSeat[i][j].getSeatNumber())) {
                           // Checks if the seat is empty or not
                            if (flightSeat[i][j].isEmpty()) {
                                // until it reaches the first element of the array, which is (name).
                                flightSeat[i][j].setPassengerName(result[1]);

                                System.out.println("The seat you want to reserve for {" + flightSeat[i][j].getSeatNumber() + ":" + flightSeat[i][j].getPassengerName() + "} has been booked successfully .");
                                temp = false;

                            } else {
                                System.out.println("The seat you want to reserve is reserved !! Please Try again");
                            }
                        }
                    }
                }
            } else
                System.out.println("The seat number entered is incorrect\nPlease Try again !!\n");
        }

    }

    //in this function to delete a reserved seat
    public static void Delete_a_reserved_seat() {
        //check Status all seat
        if (checkStatusForAllSeats(true)) {
            System.out.println("All seats are empty\n");
            return;
        }
        Scanner input = new Scanner(System.in);
        boolean temp = true;
        while (temp) {
            System.out.println("Enter the seat number and passenger name you want to delete");
            //the user enter the passenger name
            String str = input.nextLine();
            // split the str
            String[] result = str.split(":");
            if (Seat.isValid(str)) {
                for (int i = 0; i < flightSeat.length; i++) {
                    for (int j = 0; j < flightSeat[i].length; j++) {
                        if (result[0].equals(flightSeat[i][j].getSeatNumber())) {
                            if (flightSeat[i][j].isEmpty()) {
                                System.out.println("The seat you want to delete is empty\n" + "!! Please Try again");
                            } else {
                                flightSeat[i][j].setPassengerName(null);
                                System.out.println("The seat you want to delete for {" + flightSeat[i][j].getSeatNumber() + ":" + result[1] + "} has been booked successfully .");
                                temp = false;
                            }
                        }
                    }
                }
            } else
                System.out.println("The seat number entered is incorrect\nPlease Try again !!\n");
        }
    }

    //in this function to delete all reserved seat
    public static void Delete_all_reserved_seats() {
        //check Status all seat
        if (checkStatusForAllSeats(true)) {
            System.out.println("All seats are empty\n");
            return;
        }

        for (int i = 0; i < flightSeat.length; i++) {
            for (int j = 0; j < flightSeat[i].length; j++) {
                flightSeat[i][j].setPassengerName(null);

            }

        }
        System.out.println("All seats have been removed successfully\n");

    }

    //in this function update the passenger file
    public static void Update_passengers_file() {
        try {
            PrintWriter writer = new PrintWriter("passengers.txt");
            for (int i = 0; i < flightSeat.length; i++) {
                for (int j = 0; j < flightSeat[i].length; j++) {
                    if (!flightSeat[i][j].isEmpty())
                        writer.println(flightSeat[i][j].toString());
                }

            }
            System.out.println("The file has been updated successfully");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    //the function print flight map
    public static void Print_out_flight_seats_map() {
        for (int i = 0; i < flightSeat.length; i++) {
            for (int j = 0; j < flightSeat[i].length; j++) {
                if (i <= 2) {
                    if (j == 0) {
                        System.out.print("\t\t\t\t");
                    } else {
                        System.out.print("\t\t");
                    }
                    System.out.print(flightSeat[i][j].toString());
                } else {
                    if (j > 0) {
                        System.out.print("\t\t");
                    }
                    System.out.print(flightSeat[i][j].toString());
                }
            }
            System.out.println();
        }
    }
}

