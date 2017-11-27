package classses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Menu {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int choise;
    private University university;

    Menu(University university) {
        this.university = university;
    }

    void startMenu() throws IOException {
        while (true) {
            System.out.println("--------------------------");
            showMenuItems();
            try {
                try {
                    choise = readFromConsole("Number of item");
                } catch (NumberFormatException e) {
                    System.err.println("wrong input use int value instead");
                    startMenu();
                }
                if (choise < 1) {
                    throw new Exception();

                }
                if (choise == 6) {
                    return;
                }

            } catch (Exception e) {
                System.err.println("недопустимое значение");

            }
            executeChosenAction(choise);
        }
    }

    private void showMenuItems() {
        System.out.println("enter 1 to show in console data from university ");
        System.out.println("enter 2 to show average score of univesity");
        System.out.println("enter 3 to show average score of faculty");
        System.out.println("enter 4 to show average score of group");
        System.out.println("enter 5 to show average score of student");
//        System.out.println("enter 6 to show data from faculty");
//        System.out.println("enter 7 to show data from group");
//        System.out.println("enter 8 to show data from student");
        System.out.println("enter 6 to exit");
    }

    private void executeChosenAction(int i) throws IOException {
        int a, b;
        switch (i) {
            case 1:
                university.showInnerData();
                break;
            case 2:
                showAverageScore("Average score of intaire university ", university);
                break;
            case 3:
                showAverageScore("Average score of intaire faculty ", getFacultyObject());
                break;
            case 4:
                showAverageScore("Average score of intaire group ", getGroupObject());
                break;
            case 5:
                showAverageScore("Average score of intaire student ", getStudentObject());
                break;
//            case 6:
//                findDeviceByname(readFromConsole());
//                break;
//            case 7:
//                findDeviceByname(readFromConsole());
//                break;
//            case 8:
//                findDeviceByname(readFromConsole());
//                break;

            default:

                break;
        }
    }

    public void showAverageScore(String str, AbstractEntity abstractEntity) {


        try {
            System.out.print(str + abstractEntity.countAverageScore());
        } catch (Exception e) {
            System.out.println("error with called object method");
        }

    }

    private Student getStudentObject() throws IOException {
        Group group = getGroupObject();
        if (group == null) {
            return null;


        } else {
            ArrayList<Student> students = new ArrayList<>();
            int studentId = readFromConsole("id of student");
            students = group.getStudents();
            for (Student student : students) {
                if (student.getStudentId() == studentId) {
                    return student;
                }
            }
            System.out.println("such student id not founded");
        }

        return null;
    }

    private Group getGroupObject() throws IOException {
        Faculty faculty = getFacultyObject();
        if (faculty == null) {
            System.out.println("such faculty id not founded");
            return null;

        } else {
            ArrayList<Group> groups = faculty.getGroups();
            int groupId = readFromConsole("id of group");
            for (Group group : groups) {
                if (group.getGroupId() == groupId) {
                    return group;
                }
            }
            System.out.println("such group id not founded");


        }
        return null;

    }

    private Faculty getFacultyObject() throws IOException {
        ArrayList<Faculty> faculties = university.getFaculties();
        int facultyId = readFromConsole("id of faculty");
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyId() == facultyId) {
                return faculty;
            }
        }
        return null;

    }

    private int readFromConsole(String message) throws IOException {
        System.out.println("Enter" + message);
        String inputStr = "";
        int number = 0;
        try {

            inputStr = reader.readLine();
            number = Integer.parseInt(inputStr);
            if (number < 0) {
                throw new Exception();
            }

        } catch (Exception e) {
            System.err.println("Invalid of format of input data");
        }

        return number;
    }


}
