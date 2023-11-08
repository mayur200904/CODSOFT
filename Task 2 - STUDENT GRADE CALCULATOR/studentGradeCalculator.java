import java.util.Scanner;

public class studentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total_Marks = 0;

        System.out.print("Enter the number of subjects: ");
        int totalSubjects = sc.nextInt();

        
        for (int i = 1; i <= totalSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            int marks = sc.nextInt();
            total_Marks += marks;
        }

        
        double average_Percentage = (double) total_Marks / totalSubjects;

        // Grade calculation based on average percentage
        char grade;
        if (average_Percentage >= 90) {
            grade = 'A';
        } else if (average_Percentage >= 80) {
            grade = 'B';
        } else if (average_Percentage >= 70) {
            grade = 'C';
        } else if (average_Percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Displaying results
        System.out.println("Total Marks: " + total_Marks);
        System.out.println("Average Percentage: " + average_Percentage);
        System.out.println("Grade: " + grade);
        
        
        sc.close();
    }
}
