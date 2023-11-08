import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        while (true) {
            System.out.println("Student Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    Student student = new Student(name, rollNumber, grade);
                    studentManagementSystem.addStudent(student);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter student roll number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    studentManagementSystem.removeStudent(rollToRemove);
                    System.out.println("Student removed successfully!");
                    break;
                case 3:
                    System.out.print("Enter student roll number to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student foundStudent = studentManagementSystem.searchStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found - Name: " + foundStudent.getName() + ", Roll Number: " + foundStudent.getRollNumber() + ", Grade: " + foundStudent.getGrade());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    System.out.println("All Students:");
                    studentManagementSystem.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
