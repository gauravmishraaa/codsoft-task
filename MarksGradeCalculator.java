 import java.util.Scanner;

public class MarksGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        int totalMarks = 0;

        for(int i = 1; i <= n; i++) {
            System.out.print("Enter marks for subject " + i + " (0-100): ");
            int m = sc.nextInt();
            if(m < 0 || m > 100) {
                System.out.println("Invalid mark! Please enter 0–100.");
                i--; // repeat this subject
                continue;
            }
            totalMarks += m;
        }

        double average = (double) totalMarks / n;
        char grade;

        if (average >= 90) grade = 'A';
        else if (average >= 80) grade = 'B';
        else if (average >= 70) grade = 'C';
        else if (average >= 60) grade = 'D';
        else if (average >= 40) grade = 'E';
        else grade = 'F';

        System.out.println("\n===== Results =====");
        System.out.println("Total Marks   : " + totalMarks + " out of " + (100 * n));
        System.out.printf("Average %%     : %.2f%%\n", average);
        System.out.println("Grade Assigned: " + grade);

        sc.close();
    }
}
 
