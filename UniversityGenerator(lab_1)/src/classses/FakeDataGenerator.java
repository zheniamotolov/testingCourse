package classses;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
public class FakeDataGenerator {
    private University university;
    private String facultyNamesArray[];
    private FileTextReader fileTextReader;
    private String pathToFacultyNamesStorage;
    private String pathToFpmiSubjects;
    private String pathToGeoFacSubjects;
    private String pathToGiustSubjects;
    private String pathToHimFacSubjects;
    private String pathToMmfSubjects;
    private final int[] possibleNumberOfGroups = {7, 11};
    private final int[] possibleNumberOfStudents = {20, 25};
    private final int[] possibleNumberOfSubjects = {5, 10};
    private final int[] possibleStudentMark = {4, 10};
    private final int[] possibleAmountOfGroupSubject = {0, 10};

    private Random random;

    public University getUniversity() {
        return university;
    }

    FakeDataGenerator() {
        random = new Random();
        university = new University();
        fileTextReader = new FileTextReader();
        pathToFacultyNamesStorage = "src/data/faculties/facultiesNames.txt";
        pathToFpmiSubjects = "src/data/subjects/FpmiSubjects.txt";
        pathToGeoFacSubjects = "src/data/subjects/GeoFacSubjects.txt";
        pathToGiustSubjects = "src/data/subjects/GiustSubjects.txt";
        pathToHimFacSubjects = "src/data/subjects/HimFacSubjects.txt";
        pathToMmfSubjects = "src/data/subjects/MmfSubjects.txt";

    }

    public void genrateUniversityData() {
        facultyNamesArray = fileTextReader.readFromFile(pathToFacultyNamesStorage);
        for (int i = 0; i < facultyNamesArray.length; i++) {
            university.addNewFaculty(generateFacultyData(i, facultyNamesArray[i]));
        }
//        System.out.println(Arrays.toString(facultyNamesArray));
    }

    private Faculty generateFacultyData(int id, String facultyName) {

        Faculty faculty = new Faculty(id, facultyName);
      //  System.out.println(facultyName);
        int numberOfGroups = random.getRandomNumber(possibleNumberOfGroups[0], possibleNumberOfGroups[1]);
        for (int i = 0; i < numberOfGroups; i++) {
            faculty.addNewGroup(generateGroupData(i, id, facultyName));
        }
        return faculty;
    }

    private Group generateGroupData(int groupId, int facultyId, String facultyName) {
        Group group = new Group(groupId, facultyId);
      //  System.out.println("Group number "+groupId);
        int numberOfSubjects = random.getRandomNumber(possibleNumberOfSubjects[0], possibleNumberOfSubjects[1]);
        int numberOfStudents = random.getRandomNumber(possibleNumberOfStudents[0], possibleNumberOfStudents[1]);
        setGroupSubjects(group, getFacultySubjects(facultyName), numberOfSubjects);
        for (int i = 0; i < numberOfStudents; i++) {
            group.addNewStudent(generateStudentsData(group.getStudentsSubjects(), i));
        }
        return group;
    }

    private Student generateStudentsData(ArrayList<String> groupSubjects, int studentId) {
        Student student = new Student(studentId);
        for (int i = 0; i < groupSubjects.size(); i++) {
            student.addNewStudentSubjectAndMark(groupSubjects.get(i), random.getRandomNumber(possibleStudentMark[0], possibleStudentMark[1]));
        }
    //    System.out.println("Student number " + studentId);
        for (Map.Entry entry : student.getStudentSubjectAndMark().entrySet()) {
           // System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        return student;
    }

    private void setGroupSubjects(Group group, String groupSubjects[], int numberOfSubjects) {
        int randomSubject;
        for (int i = 0; i < numberOfSubjects; i++) {
            randomSubject = random.getRandomNumber(possibleAmountOfGroupSubject[0], possibleAmountOfGroupSubject[1]);
            if (!group.getStudentsSubjects().contains(groupSubjects[randomSubject])) { ///Warning !!!
                group.addNewSubject(groupSubjects[randomSubject]);
            } else {
                i -= 1;
            }

        }
    }

    private String[] getFacultySubjects(String faclultyName) {
        String arrayOfSubjects[] = {};
        switch (faclultyName) {
            case "ГеоФак":
                arrayOfSubjects = fileTextReader.readFromFile(pathToGeoFacSubjects);
                break;
            case "ФПМИ":
                arrayOfSubjects = fileTextReader.readFromFile(pathToFpmiSubjects);
                break;
            case "ГИУСТ":
                arrayOfSubjects = fileTextReader.readFromFile(pathToGiustSubjects);
                break;
            case "ХимФак":
                arrayOfSubjects = fileTextReader.readFromFile(pathToHimFacSubjects);
                break;
            case "ММФ":
                arrayOfSubjects = fileTextReader.readFromFile(pathToMmfSubjects);
                break;
            default:
                System.err.println("not such faulty name");
                break;

        }
        return arrayOfSubjects;
    }
    //switch
}
