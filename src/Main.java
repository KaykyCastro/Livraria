import collection.ListBook;
import collection.ListRentals;
import collection.ListUser;
import enums.Menus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListUser userManager = new ListUser();
        ListBook bookManager = new ListBook();
        ListRentals rentalsManager = new ListRentals();

        int opt = 0;

        while (opt != 9){
            System.out.println("Select the options");
            Menus.selectOption(0);

            opt = sc.nextInt();


        }

    }
}