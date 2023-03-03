import entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException { // O método main pode lançar uma excessão do tipo ParseException

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (DD/MM/YYYY): ");
        Date checkIn = sdf.parse(sc.next()); // Pode lançar uma excessão

        System.out.print("Checkout date (DD/MM/YYYY): ");
        Date checkout = sdf.parse(sc.next());

        // Verifica de data de checkout está vindo antes da data de checkin
        if (!checkout.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date ");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = sdf.parse(sc.next()); // Pode lançar uma excessão

            System.out.print("Checkout date (DD/MM/YYYY): ");
            checkout = sdf.parse(sc.next());

            // Verificar se as datas de checkin e checkout são anteriores à data atual
            Date now = new Date();
            if(checkIn.before(now) || checkout.before(now)) {
                System.out.println("Error in reservation: Reservation dates for updates must be future dates");
            }
            else if (!checkout.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date ");
            }
            else {
                // Atualiza data de reserva
                reservation.updateDates(checkIn, checkout);
                System.out.println("Reservation: " + reservation);
            }

        }
        sc.close();
    }
}