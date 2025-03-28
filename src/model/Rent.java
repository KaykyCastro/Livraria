package model;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Rent {
    private User rentUser;
    private Book rentBook;
    private LocalDateTime rentDay;
    private LocalDateTime returnDay;
    private double fine;
    private static final double FINE_AMOUNT = 5;
    private final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);

    public Rent(User userToRente, Book bookToRent){
        this.rentUser = userToRente;
        this.rentBook = bookToRent;
        this.rentDay = LocalDateTime.now();
        this.returnDay = rentDay.plusDays(7);
    }

    public User getRentUser() {
        return rentUser;
    }

    public void setRentUser(User rentUser) {
        this.rentUser = rentUser;
    }

    public Book getRentBook() {
        return rentBook;
    }

    public void setRentBook(Book rentBook) {
        this.rentBook = rentBook;
    }

    public LocalDateTime getRentDay() {
        return rentDay;
    }

    public LocalDateTime getReturnDay() {
        return returnDay;
    }

    public double getFine() {
        return fine;
    }

    public double gerateFine() {
        if(LocalDateTime.now().isAfter(returnDay)){
            fine += FINE_AMOUNT;
            System.out.println("Multa adicionada com sucesso!");
            Runnable gerateFineTask = new Runnable() {
                @Override
                public void run() {
                    fine += FINE_AMOUNT;
                    System.out.println("Multa adicionada com sucesso!");
                }
            };

            schedule.scheduleAtFixedRate(gerateFineTask, 1, 1, TimeUnit.DAYS);
        }
        return fine;
    }

}
