package model;

import java.util.Calendar;

public class Rent {
    private User rentUser;
    private Book rentBook;
    private Calendar rentDay;
    private Calendar returnDay;
    private double fine;

    public Rent(User userToRente, Book bookToRent){
        this.rentUser = userToRente;
        this.rentBook = bookToRent;
        this.rentDay = getCurrentDay();
       // this.rentDay =;
    }

    public static Calendar getCurrentDay(){
        return Calendar.getInstance();
    }

        /*public static Calendar getReturnDay(Calendar rentDay){
            return Calendar.getInstance();
        }*/


}
