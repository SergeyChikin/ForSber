import model.City;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Path pathToFile = Paths.get("resource/cities.csv");

        List<City> cities = new ArrayList<>();

        try (Scanner scanFile = new Scanner(pathToFile)) {
            scanFile.useDelimiter(System.getProperty("line.separator"));
            while (scanFile.hasNext()) {
                cities.add(parseFileString(scanFile.next()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (City city : cities) {
            System.out.println(city);
            System.out.println();
        }
    }

    static City parseFileString(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(";");
        String id = scanner.next();
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        String population = scanner.next();
        String foundation = scanner.nextLine();
        String foundationCorrect = foundation.substring(1, foundation.length());

        return new City(name, region, district, population, foundationCorrect);
    }
}