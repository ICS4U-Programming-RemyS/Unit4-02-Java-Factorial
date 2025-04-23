import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**.
*
* This program will read an multiple lines of integers from the a input file.
* If the data is valid then it will calculate the factorial of each integer
*
* @author Remy Skelton
* @version 1.0
* @since 2025-04-23
*/

final class Factorial {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private Factorial() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {
        // Print the welcome message
        System.out.println("Welcome to the Factorial program!");
        System.out.print("This program reads multiple lines");
        System.out.print(" of integers from input.txt, ");
        System.out.print("calculates the factorial of each integer, and ");
        System.out.println("and writes the result to output.txt.");

        // Read from input.txt
        File inputFile = new File("input.txt");
        Scanner scanner = new Scanner(inputFile);

        // Make outputWriter to write to output.txt
        FileWriter outputWriter = new FileWriter("output.txt");

        // Create outputStr
        String outputStr = "";

        // While loop to read String from input.txt
        while (scanner.hasNextLine()) {

            // Set line equal to the next line
            String line = scanner.nextLine();

            // Split the line by spaces to see if there are multiple numbers
            String[] lineNumbers = line.split(" ");

            // Go through each number in the line
            for (String numberStr : lineNumbers) {
                // Check if the number
                try {
                    // Make the string into an integer
                    int number = Integer.parseInt(numberStr);

                    // Check if the number is empty or negative
                    if (number < 0) {
                        // Print an error message
                        outputStr += "Invalid input: "
                                + numberStr
                        + " is not a valid positive integer.\n";

                        // Restarts the loop if the number is empty or negative
                        continue;
                    }

                    // Call the recFactorial method
                    int numberFactorial = recFactorial(number);

                    // Add the factorial result to the output string
                    outputStr += number + "! = " + numberFactorial + "\n";

                } catch (NumberFormatException e) {
                    // Print an error message
                    outputStr += "Invalid input: "
                            + numberStr
                    + " is not a valid integer.\n";
                    continue;
                }
            }

        }

        // Write the output string to output.txt
        outputWriter.write(outputStr);

        // Print the factorial results to the console
        System.out.println("Factorial results written to output.txt.");

        // Close the scanner
        scanner.close();

        // Close the output writer
        outputWriter.close();
    }
    /**.
     * This method calculates the factorial of a number
     *
     * @param number The factorial will be found of this number
     * @return The factorial of the number
     */
    public static int recFactorial(final int number) {
        // Check if the number is 0
        if (number == 0) {
            // Return 1 as the factorial of 0 is 1
            return 1;
        } else {
            // Call the recFactorial method with the number decremented by 1
            return number * recFactorial(number - 1);
        }
    }
}
