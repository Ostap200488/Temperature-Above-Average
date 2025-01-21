import java.util.Scanner;

public class TemperatureAnalysis {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Step 1: Input number of days
        System.out.print("How many days' temperatures? ");
        int numDays = console.nextInt();

        // Step 2: Array to store temperatures and calculate the sum
        int[] temps = new int[numDays];
        int sum = 0;

        for (int i = 0; i < numDays; i++) {
            System.out.print("Day " + (i + 1) + "'s high temp: ");
            temps[i] = console.nextInt();
            sum += temps[i];
        }

        // Step 3: Calculate the average temperature
        double average = (double) sum / numDays;

        // Step 4: Count the number of days above average
        int aboveAvgCount = 0;
        for (int temp : temps) {
            if (temp > average) {
                aboveAvgCount++;
            }
        }

        // Output results
        System.out.println();
        System.out.println("Average Temperature = " + average);
        System.out.println(aboveAvgCount + " days above average.");

        console.close();
    }
}