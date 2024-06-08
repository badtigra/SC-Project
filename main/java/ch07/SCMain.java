/**
 * Program to make a seating chart and add names
 *
 * @author Gregory Ross McTaggart
 * @version June 4, 2024
 */
package ch07;

import java.util.Scanner;

public class SCMain {

    /**
     * main - read input to build seating chart
     *
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SCConstructor sc = new SCConstructor();
        String name;
        int row;
        int column;
        
        System.out.printf("Welcome to Express Seat Charter%nPlease type 'exit' to close program%n%n");
        System.out.print("Name? ");
        name = input.nextLine();
        System.out.printf("%nThere are 4 rows and 6 columns%n");
        
        while (!(name.equals("exit") || name.equals("EXIT"))) {
            System.out.print("Row & Column? ");
            row = input.nextInt();
            column = input.nextInt();
            System.out.println();
            
            sc.addPerson(row, column, name);
            
            System.out.print("Name? ");
            // name = input.next();
            
            // Saved for full names later on
            input.nextLine(); // Required to keep next line from skipping, why?
            name = input.nextLine(); 
            
            System.out.println();
        }
        
        sc.printSeatingChart();
        System.out.printf("%nYou have %d assigned chairs and %d empty chairs%n", sc.getAssigned(), sc.getEmpty());
        sc.printNames();
        sc.printNamesNumeric();
        
        input.close();
    }
}
