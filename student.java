import java.util.ArrayList;
import java.util.Scanner;

// Define the Student class
class Student {
    int rollNumber;
    String name;
    String course;
    double gpa;

    // Constructor
    public Student(int rollNumber, String name, String course, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
    }

    // Method to neatly display student details
    @Override
    public String toString() {
        return "Roll No: " + rollNumber + " | Name: " + name + " | Course: " + course + " | GPA: " + String.format("%.2f", gpa);
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Check if input is a valid integer to prevent crashes
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear the invalid input from the scanner
                continue;
            }
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the leftover newline

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();

                    students.add(new Student(rollNumber, name, course, gpa));
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\n--- Student Records ---");
                        for (Student std : students) {
                            System.out.println(std.toString());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    int searchId = scanner.nextInt();
                    boolean foundForSearch = false;

                    for (Student std : students) {
                        if (std.rollNumber == searchId) {
                            System.out.println("\n--- Student Found ---");
                            System.out.println(std.toString());
                            foundForSearch = true;
                            break;
                        }
                    }

                    if (!foundForSearch) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume the leftover newline
                    boolean foundForUpdate = false;

                    for (Student std : students) {
                        if (std.rollNumber == updateId) {
                            System.out.print("Enter New Name: ");
                            std.name = scanner.nextLine();

                            System.out.print("Enter New Course: ");
                            std.course = scanner.nextLine();

                            System.out.print("Enter New GPA: ");
                            std.gpa = scanner.nextDouble();

                            System.out.println("Student Updated Successfully!");
                            foundForUpdate = true;
                            break;
                        }
                    }

                    if (!foundForUpdate) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Roll Number to Delete: ");
                    int deleteId = scanner.nextInt();
                    boolean foundForDelete = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).rollNumber == deleteId) {
                            students.remove(i); 
                            System.out.println("Student Deleted Successfully!");
                            foundForDelete = true;
                            break;
                        }
                    }

                    if (!foundForDelete) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 6:
                    System.out.println("Thank You! Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Choice! Please enter a number between 1 and 6.");
            }
        }
    }
}