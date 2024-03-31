
import java.util.Scanner;
public class SafeInput {
    /**
     * Gets a non-zero length string from the user.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    // program-2
    public static int getInt(Scanner pipe, String prompt) {
        int intValue = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print("\n" + prompt + ": ");
                intValue = Integer.parseInt(pipe.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } while (!validInput);

        return intValue;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double doubleValue = 0.0;
        boolean validInput = false;

        do {
            try {
                System.out.print("\n" + prompt + ": ");
                doubleValue = Double.parseDouble(pipe.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid double.");
            }
        } while (!validInput);

        return doubleValue;
    }

    // program-3
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int userInput;
        do {
            System.out.print("\n" + prompt + ": ");
            while (!pipe.hasNextInt()) {
                pipe.next(); // clear trash input
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.print(prompt + ": ");
            }
            userInput = pipe.nextInt();
            pipe.nextLine(); // clear the newline character
        } while (userInput < low || userInput > high);

        return userInput;
    }

    // program-4
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double userInput;
        do {
            System.out.print("\n" + prompt + ": ");
            while (!pipe.hasNextDouble()) {
                pipe.next(); // clear trash input
                System.out.println("Invalid input. Please enter a valid double.");
                System.out.print(prompt + ": ");
            }
            userInput = pipe.nextDouble();
            pipe.nextLine(); // clear the newline character
        } while (userInput < low || userInput > high);

        return userInput;
    }

    // program-5
    public static String getRegExString(Scanner pipe, String prompt, String pattern) {
        String userInput;
        boolean validInput;

        do {
            System.out.print("\n" + prompt + ": ");
            userInput = pipe.nextLine();

            validInput = userInput.matches(pattern);

            if (!validInput) {
                System.out.println("Invalid input. Please enter a valid string matching the pattern.");
            }

        } while (!validInput);

        return userInput;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String userInput;
        boolean validInput;

        do {
            System.out.print("\n" + prompt + ": ");
            userInput = pipe.nextLine().toUpperCase();

            validInput = userInput.equals("Y") || userInput.equals("N");

            if (!validInput) {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }

        } while (!validInput);

        return userInput.equals("Y");
    }

    // Part H
    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int msgWidth = msg.length();

        int starsOnEachSide = (totalWidth - msgWidth - 6) / 2;

        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("***");
        for (int i = 0; i < starsOnEachSide; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < starsOnEachSide; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
//------Lab10 code
