/**
 * Used to keep track of assigned and unassigned seats
 *
 * @author Gregory Ross McTaggart
 * @version June 4, 2024
 */
package ch07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SCConstructor {

    // Can remove constant state to allow further customization 
    public static final int NUM_ROWS = 4;
    public static final int NUM_COLUMNS = 6;

    String[][] names = new String[NUM_ROWS][NUM_COLUMNS]; // Stores name location
    ArrayList<String> storedNames = new ArrayList<String>(); // Stores names for input into chart

    /**
     * SeatChart - Initialize all seats to "________" (8 wide)
     *
     * @return void
     */
    public SCConstructor() {
        for (String[] underscore : names) {
            Arrays.fill(underscore, "________");
        }
    }

    /**
     * printSeatingChart - prints each name 10 characters wide
     *
     * @return void
     */
    public void printSeatingChart() {
        for (String[] person : names) {
            for (String name : person) {
                // System.out.printf("%10s ", name);
                System.out.printf("%s\t", name);
            }
            System.out.println();
        }
    }

    /**
     * addPerson - puts name in correct element of 2-dimensional array
     *
     * @param row - which row (1 based)
     * @param column - which column (1 based)
     * @param name - which name
     * @return void
     */
    public void addPerson(int row, int column, String name) {
        names[row - 1][column - 1] = name;
        storedNames.add(name);
    }

    /**
     * getEmpty - Calculate and return number of unassigned seats
     *
     * @return total
     */
    public int getEmpty() {
        int total = 0;
        for (String[] unassigned : names) {
            for (String name : unassigned) {
                if ("________".equals(name)) {
                    total += 1;
                }
            }
        }
        return total;
    }

    /**
     * getAssigned - Calculate and return number of assigned seats
     *
     * @return total
     */
    public int getAssigned() {
        int total = 0;
        for (String[] assigned : names) {
            for (String name : assigned) {
                if (!"________".equals(name)) {
                    total += 1;
                }
            }
        }
        return total;
    }

    /**
     * printNames - Prints all names in sorted order (Alphabetically)
     *
     * @return void
     */
    public void printNames() {
        System.out.printf("%n--Your Attendees--%n");
        Collections.sort(storedNames);
        for (String w : storedNames) {
            System.out.printf("%s%n", w);
        }
    }

    /**
     * printNamesNumeric - Prints all names in left to right seating order
     *
     * @return void
     */
    public void printNamesNumeric() {
        System.out.printf("%n--In Numerical--%n");
        for (String[] w : names) {
            for (String n : w) {
                if (n.equals("________")) {
                    continue;
                } else {
                    System.out.printf("%s%n", n);
                }
                // System.out.printf("%s%n", n.replaceAll("________", "").strip()); // Figure out how to remove whitespace
            }
        }
    }
}
