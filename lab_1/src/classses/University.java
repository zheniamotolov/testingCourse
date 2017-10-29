package classses;

import java.util.ArrayList;

public class University extends AbstractEntity {
    // private int universityId;

    private ArrayList<Faculty> faculties;

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void addNewFaculty(Faculty newFaculty) {
        faculties.add(newFaculty);
    }


//    public void


//    public int getUniversityId() {
//        return universityId;
//    }

    public University() {
        faculties = new ArrayList<>();
//        this.faculties = faculties;
//        this.universityId = universityId;
    }

    @Override
    public void showInnerData() {
        System.out.println("University");
        for (Faculty faculty : faculties) {
            faculty.showInnerData();
        }
    }

    @Override
    public float countAverageScore() {
        int i = 0;
        float sum = 0;
        for (Faculty faculty : faculties) {
            i++;
            sum += faculty.countAverageScore();
        }
        return sum/i;
    }
}
// adding and removing faculties cannot be implementing without  data storage communication