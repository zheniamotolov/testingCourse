package classses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Group extends AbstractEntity {

    private int groupId;
    private int facultyId;
    private ArrayList<String> studentsSubjects;
    private ArrayList<Student> students;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addNewStudent(Student student) {
        students.add(student);

    }

    public int getFacultyId() {
        return facultyId;
    }

    public int getGroupId() {
        return groupId;
    }

    public ArrayList<String> getStudentsSubjects() {
        return studentsSubjects;
    }

    public void addNewSubject(String newSubjectName) {
        studentsSubjects.add(newSubjectName);
    }

    Group(int groupId, int facultyId) {
        studentsSubjects = new ArrayList<>();
        students = new ArrayList<>();
        this.groupId = groupId;
        this.facultyId = facultyId;
        //   this.students = students;

    }

    @Override
    public void showInnerData() {
        System.out.println("        Group with id " + groupId);
        for (Student student : students) {
            student.showInnerData();
        }
    }

    @Override
    public float countAverageScore() {
        int i = 0;
        float sum = 0;
        for (Student student : students) {
            i++;
            sum += student.countAverageScore();
        }
        return sum/i;
    }
}
