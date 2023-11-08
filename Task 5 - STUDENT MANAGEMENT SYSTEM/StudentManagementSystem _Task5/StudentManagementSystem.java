import java.util.ArrayList;
import java.util.List;

// StudentManagementSystem class to manage students
class StudentManagementSystem {
    private List<Student> students;

    // Constructor
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Remove a student
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    // Search for a student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber() + ", Grade: " + student.getGrade());
        }
    }
}
