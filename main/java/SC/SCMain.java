/**
 * Program to make a seating chart and add names
 *
 * @author Gregory Ross McTaggart
 * @version June 4, 2024
 */
package SC;

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

        String name;
        int row;
        int column;
        int numRows;
        int numColumns;

        System.out.printf("Welcome to Express Seat Charter%n%n");

        System.out.printf("How many rows and columns? (Format: \"X X\"): ");
        numRows = input.nextInt();
        numColumns = input.nextInt();
        SCChild sc = new SCChild(numRows, numColumns);

        System.out.print("Please type 'exit' to close program. Name? ");
        input.nextLine();
        name = input.nextLine();

        System.out.printf("%nThere are %d rows and %d columns available%n", 
                sc.getRows(), sc.getColumns());

        while (!(name.equals("exit") || name.equals("EXIT"))) {
            System.out.print("Row & Column? ");
            row = input.nextInt();
            column = input.nextInt();
            System.out.println();

            sc.addPerson(row, column, name);

            System.out.print("Name? ");

            input.nextLine(); 
            name = input.nextLine();

            System.out.println();
        }

        sc.printSeatingChart();
        System.out.printf("%nYou have %d assigned chairs and %d empty chairs%n",
                sc.getAssigned(), sc.getEmpty());
        sc.printNames();
        sc.printNamesNumeric();

        input.close();
    }
}
