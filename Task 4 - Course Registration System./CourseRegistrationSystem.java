import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public int getAvailableSlots() {
        return capacity - registeredStudents.size();
    }

    List<Student> registeredStudents = new ArrayList<>();
}

class Student {
    int studentID;
    String name;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }
}

public class CourseRegistrationSystem {
    static List<Course> courses = new ArrayList<>();
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        courses.add(new Course("C001", "Java Programming", "Introduction to Java", 30, "Mon 10:00 AM"));
        courses.add(new Course("C002", "Database Management", "Fundamentals of DBMS", 25, "Tue 2:00 PM"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Course Listing");
            System.out.println("2. Student Registration");
            System.out.println("3. Course Removal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    displayCourseListing();
                    break;
                case 2:
                    registerStudent(scanner);
                    break;
                case 3:
                    removeCourse(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayCourseListing() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course.courseCode + " - " + course.title + " (" + course.getAvailableSlots() + " slots available)");
            System.out.println("Description: " + course.description);
            System.out.println("Schedule: " + course.schedule);
            System.out.println("--------------------------");
        }
    }

    private static void registerStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        Student student = new Student(studentID, name);
        students.add(student);

        displayCourseListing();
        System.out.print("Enter the course code to register: ");
        String courseCode = scanner.next();

        Course selectedCourse = findCourseByCode(courseCode);
        if (selectedCourse != null && selectedCourse.getAvailableSlots() > 0) {
            selectedCourse.registeredStudents.add(student);
            System.out.println("Registration successful!");
        } else {
            System.out.println("Course is full or does not exist. Registration failed.");
        }
    }

    private static void removeCourse(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();

        Student student = findStudentByID(studentID);
        if (student != null) {
            System.out.println("Registered Courses:");
            for (Course course : courses) {
                if (course.registeredStudents.contains(student)) {
                    System.out.println(course.courseCode + " - " + course.title);
                }
            }

            System.out.print("Enter the course code to remove: ");
            String courseCode = scanner.next();

            Course selectedCourse = findCourseByCode(courseCode);
            if (selectedCourse != null && selectedCourse.registeredStudents.contains(student)) {
                selectedCourse.registeredStudents.remove(student);
                System.out.println("Course removal successful!");
            } else {
                System.out.println("Student is not registered for this course.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.courseCode.equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static Student findStudentByID(int studentID) {
        for (Student student : students) {
            if (student.studentID == studentID) {
                return student;
            }
        }
        return null;
    }
}
