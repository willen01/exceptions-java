import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            Date checkIn = sdf.parse(sc.next()); // Pode lançar uma excessão

            System.out.print("Checkout date (DD/MM/YYYY): ");
            Date checkout = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = sdf.parse(sc.next()); // Pode lançar uma excessão

            System.out.print("Checkout date (DD/MM/YYYY): ");
            checkout = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkout);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e) {
            System.out.println("Invalid date format!");
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error ");
        }
        sc.close();
    }
}