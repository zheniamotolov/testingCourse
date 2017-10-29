package classses;

import java.util.HashMap;
import java.util.Map;

public class Student extends AbstractEntity {
    private int studentId;
    private Map<String, Integer> studentSubjectsAndMarks;

    public Map<String, Integer> getStudentSubjectAndMark() {
        return studentSubjectsAndMarks;
    }

    public void addNewStudentSubjectAndMark(String subject, int mark) {
        studentSubjectsAndMarks.put(subject, mark);
    }

    //private int groupId;
    public int getStudentId() {
        return studentId;
    }

    Student(int studentId) {
        this.studentId = studentId;
        studentSubjectsAndMarks = new HashMap<>();
        // this.groupId = groupId;
        //this.studentsSubjects = studentsSubjects;
    }
//    public int getFacultyGroupId() {
//        return groupId;
//    }
//
//    public void setFacultyGroupId(int groupId) {
//        this.groupId = groupId;
//    }

    @Override
    public void showInnerData() {
        System.out.println("            Student with id " + studentId);
        for (Map.Entry entry : studentSubjectsAndMarks.entrySet()) {
            System.out.println("            "+entry.getKey() + ", " + entry.getValue());
        }
    }

    @Override
    public float countAverageScore() {
        int i = 0;
        int sum = 0;
        for (Map.Entry pair : studentSubjectsAndMarks.entrySet()) {
            i++;
            sum += (Integer) pair.getValue();
        }
        return sum/i;
    }


}
