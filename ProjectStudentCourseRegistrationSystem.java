import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String code, title;
    int capacity, enrolled;

    public Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public boolean registerStudent() {
        if (enrolled < capacity) {
            enrolled++;
            return true;
        }
        return false;
    }

    public boolean dropStudent() {
        if (enrolled > 0) {
            enrolled--;
            return true;
        }
        return false;
    }

    public void displayCourse() {
        System.out.println(code + " - " + title + " | Slots: " + (capacity - enrolled) + "/" + capacity);
    }
}

class Student {
    String id, name;
    ArrayList<Course> registeredCourses = new ArrayList<>();

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean registerCourse(Course course) {
        if (course.registerStudent()) {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    public boolean dropCourse(String courseCode) {
        for (Course course : registeredCourses) {
            if (course.code.equals(courseCode)) {
                course.dropStudent();
                registeredCourses.remove(course);
                return true;
            }
        }
        return false;
    }

    public void displayRegisteredCourses() {
        System.out.println(name + "'s Registered Courses:");
        for (Course course : registeredCourses) {
            System.out.println(course.code + " - " + course.title);
        }
    }
}

public class ProjectStudentCourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        // Sample Courses
        courses.add(new Course("CSE101", "Data Structures", 3));
        courses.add(new Course("CSE102", "Algorithms", 2));

        while (true) {
            System.out.println("\n1. View Courses\n2. Register Student\n3. Register for Course\n4. Drop Course\n5. View Registered Courses\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                for (Course course : courses) course.displayCourse();
            } else if (choice == 2) {
                System.out.print("Enter Student ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter Student Name: ");
                String name = scanner.nextLine();
                students.add(new Student(id, name));
                System.out.println("Student registered successfully!");
            } else if (choice == 3) {
                System.out.print("Enter Student ID: ");
                String id = scanner.nextLine();
                Student student = findStudent(students, id);
                if (student != null) {
                    System.out.print("Enter Course Code: ");
                    String code = scanner.nextLine();
                    Course course = findCourse(courses, code);
                    if (course != null && student.registerCourse(course)) {
                        System.out.println("Course registered successfully!");
                    } else {
                        System.out.println("Course is full or does not exist.");
                    }
                } else {
                    System.out.println("Student not found.");
                }
            } else if (choice == 4) {
                System.out.print("Enter Student ID: ");
                String id = scanner.nextLine();
                Student student = findStudent(students, id);
                if (student != null) {
                    System.out.print("Enter Course Code to Drop: ");
                    String code = scanner.nextLine();
                    if (student.dropCourse(code)) {
                        System.out.println("Course dropped successfully!");
                    } else {
                        System.out.println("You are not registered in this course.");
                    }
                } else {
                    System.out.println("Student not found.");
                }
            } else if (choice == 5) {
                System.out.print("Enter Student ID: ");
                String id = scanner.nextLine();
                Student student = findStudent(students, id);
                if (student != null) student.displayRegisteredCourses();
                else System.out.println("Student not found.");
            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
        scanner.close();
    }

    public static Student findStudent(ArrayList<Student> students, String id) {
        for (Student student : students) {
            if (student.id.equals(id)) return student;
        }
        return null;
    }

    public static Course findCourse(ArrayList<Course> courses, String code) {
        for (Course course : courses) {
            if (course.code.equals(code)) return course;
        }
        return null;
    }
}
