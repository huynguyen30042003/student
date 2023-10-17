
package Controller;

import java.util.ArrayList;
import java.util.Collections;
import Model.Student;
import Views.Validation;

import static Views.Validation.checkInputFloat;
import static Views.Validation.checkInputString;
import static Views.Validation.checkInputYN;

public class Display {
    private static void addStudent(ArrayList<Student> lt) {
        System.out.println("Please input student information ");
        System.out.print("Name: ");
        String name = Validation.checkInputString();
        System.out.print("Classes: ");
        String classes = Validation.checkInputString();
        System.out.print("Mark: ");
        float mark = Validation.checkInputFloat();
        lt.add(new Student(name, mark, classes));
    }

    private static void print(ArrayList<Student> lt) {
        if (lt.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        Collections.sort(lt);
        for (int i = 0; i < lt.size(); i++) {
            System.out.println("--------Student " + i + 1 + "--------");
            System.out.println("Name: " + lt.get(i).getName());
            System.out.println("Classes: " + lt.get(i).getClasses());
            System.out.println("Mark: " + lt.get(i).getMark());
        }
    }

    public static void display() {
        ArrayList<Student> lt = new ArrayList<>();
        addStudent(lt);
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (checkInputYN()) {
                addStudent(lt);
            } else {
                break;
            }
        }
        print(lt);
    }
}
