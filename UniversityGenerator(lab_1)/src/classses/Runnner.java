package classses;

import java.io.IOException;

public class Runnner {
    public static void main(String[] args) throws IOException {
        FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();
        fakeDataGenerator.genrateUniversityData();
        Menu menu = new Menu(fakeDataGenerator.getUniversity());
        menu.startMenu();
    }
}
