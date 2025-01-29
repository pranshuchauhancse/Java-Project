import java.util.Scanner;

public class ProjectMarkCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of subjects
        int numSubjects = 5;  // You can change this number based on the number of subjects
        int totalMarks = 0;
        double averagePercentage = 0;
        String grade = "";

        // Take input for marks in each subject
        System.out.println("Enter marks obtained in each subject (out of 100):");
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;  // Sum the marks
        }

        // Calculate average percentage
        averagePercentage = (double) totalMarks / numSubjects;

        // Assign grade based on average percentage
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 75) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * 100));
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}