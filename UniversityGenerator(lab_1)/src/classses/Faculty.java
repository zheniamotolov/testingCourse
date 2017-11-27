package classses;

import sun.jvm.hotspot.oops.Array;

import java.util.ArrayList;


public class Faculty extends AbstractEntity {
    private ArrayList<Group> groups;
    private int facultyId;

    public String getFacultyName() {
        return facultyName;
    }

    private String facultyName;

    public int getFacultyId() {
        return facultyId;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void addNewGroup(Group newGroup) {
        groups.add(newGroup);
    }

    public Faculty(int facultyId, String facultyName) {
        this.facultyName = facultyName;
        this.facultyId = facultyId;
        groups = new ArrayList<>();
    }
    @Override
    public void showInnerData() {
        System.out.println("    Faculty with id" + facultyId);
        for (Group group : groups) {
            group.showInnerData();
        }
    }
    @Override
    public float countAverageScore() {
        int i = 0;
        float sum = 0;
        for (Group group : groups) {
            i++;
            sum += group.countAverageScore();
        }
        return sum/i;
    }
}
