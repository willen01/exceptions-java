package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    // Com o static não será instanciado um novo simpledateformat para cada objeto reservation existente.
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration() {
        // diferença entre checkIn e checkOut em milisegundos.
        long diff = checkout.getTime() - checkin.getTime();

        // Converte os milisegundos para dias.
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkin, Date checkout) {
        Date now = new Date();
        if(checkin.before(now) || checkout.before(now)) {
            return " Reservation dates for updates must be future dates";
        }
        if (!checkout.after(checkin)){
            return "Error in reservation: Check-out date must be after check-in date ";
        }
        this.checkin = checkin;
        this.checkout = checkout;
        return null; // Se esse método retornar null é porque não aconteceu nenhum erro.
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkin)
                + ", checkout: "
                + sdf.format(checkout)
                + ", "
                + duration()
                +  " nights";
    }
}
