/**
 * Program to make a seating chart and add names
 * Drives SCChild
 *
 * @author Gregory Ross McTaggart
 * @version June 11, 2024
 */
package SC;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SCMain {

    /**
     * main - read input to build seating chart
     *
     * @param args - command line arguments
     * @return void
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name;
        int row;
        int column;
        int numRows;
        int numColumns;
        boolean validData = false;
        
        System.out.printf("Welcome to Express Seat Charter%n%n");
        
        do {
            try {
                System.out.printf("How many rows and columns? (Format: \"X X\"): ");
                numRows = input.nextInt(); // Need handling in case 0 is entered
                numColumns = input.nextInt(); // Need handling in case 0 is entered


                System.out.print("Please type 'exit' to close program. Name? ");
                input.nextLine();
                name = input.nextLine();

                SCChild sc = new SCChild(numRows, numColumns);
                System.out.printf("%nThere are %d rows and %d columns available%n",
                        sc.getRows(), sc.getColumns());

                while (!(name.equals("exit") || name.equals("EXIT"))) {
                    try {
                        System.out.print("Row & Column? ");
                        row = input.nextInt();
                        column = input.nextInt();
                        System.out.println();

                        sc.addPerson(row, column, name);

                        System.out.print("Name? ");

                        input.nextLine();
                        name = input.nextLine();

                        System.out.println();

                    } catch (InputMismatchException ie) {
                        System.err.printf("%nThat is not a valid input.%n"
                                + "Please enter an integer in the format \"X X\".%n");
                        input.next();
                    } catch (ArrayIndexOutOfBoundsException ai) {
                        System.err.printf("That is not a valid position.%n"
                                + "Please enter an integer in the format \"X X\".%n");
                    } finally {

                    }
                }
                validData = true;
                System.out.printf("%nChart Begin%n%n");
                sc.printSeatingChart();
                System.out.printf("%n%nChart End%n");
                System.out.printf("%nYou have %d assigned chairs and %d empty chairs%n",
                        sc.getAssigned(), sc.getEmpty());
                sc.printNames();
                sc.printNamesNumeric();

            } catch (InputMismatchException ie) {
                System.err.printf("%nThat is not a valid input.%n"
                        + "Please enter an integer in the format \"X X\".%n");
                input.next();
            }
        } while (!validData);
        input.close();
    }
}
