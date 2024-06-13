/**
 * Program to make a seating chart and add names
 *
 * @author Gregory Ross McTaggart
 * @version June 13, 2024
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
        boolean notZero = false;

        // Introduces program's placeholder name
        System.out.printf("Welcome to Express Seat Charter%n%n");

        do {
            try {
                System.out.printf("How many rows and columns? (Format: \"X X\"): ");
                numRows = input.nextInt();
                numColumns = input.nextInt();

                // While Loop used to ensure that values only greater than 0 are
                // accepted into the program 
                while (!notZero) {
                    if (numRows > 0 && numColumns > 0) {
                        notZero = true;
                    } else if (numRows <= 0 || numColumns <= 0) {
                        System.out.printf("Please enter values greater than zero.%n%n");
                        break;
                    }
                    // Pass While Loop when conditions are met

                    System.out.print("Please type 'exit' to close program. Name? ");
                    input.nextLine();
                    name = input.nextLine();

                    // Initializes custom 2D array with inputted values
                    // And reminds user of what they entered
                    SCChild sc = new SCChild(numRows, numColumns);
                    System.out.printf("%nThere are %d rows and %d columns available%n",
                            sc.getRows(), sc.getColumns());

                    // Core loop of program
                    // While Loop used to continually 
                    // add names to elements in the 2D array
                    while (!(name.equals("exit") || name.equals("EXIT"))) {
                        try {
                            System.out.print("Row & Column? ");
                            row = input.nextInt();
                            column = input.nextInt();
                            System.out.println();

                            sc.addPerson(row, column, name);

                            System.out.print("Name? ");
                            
                            input.nextLine(); // To clear the input buffer 
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
                    // Boolean to prevent further looping
                    validData = true;
                    // Chart generation block
                    System.out.printf("%n\tChart Begin%n%n");
                    sc.printSeatingChart();
                    System.out.printf("%n%n\tChart End%n");
                    // Tells user how many chairs are occupied and how many 
                    // are unoccupied
                    System.out.printf("%nYou have %d assigned chairs and %d empty chairs%n",
                            sc.getAssigned(), sc.getEmpty());
                    // Prints name in alphabetical order, starting with first
                    // character
                    sc.printNames();
                    // Prints names in order of first 
                    // element to last element
                    sc.printNamesNumeric();
                }
            } catch (InputMismatchException ie) {
                System.err.printf("%nThat is not a valid input.%n"
                        + "Please enter an integer in the format \"X X\".%n%n");
                input.nextLine(); // To clear the input buffer
            }
        } while (!validData);
        input.close();
    }
}
