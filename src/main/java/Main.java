import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File diploma = new File("C:\\Users\\user\\Desktop\\School\\Java2\\Assignment_2\\diploma.csv");

        List<DiplomaData> diplomaLanjutan = new ArrayList<>();
        List<DiplomaData> kursusPengkhususan = new ArrayList<>();

        // Task 1: File Existence Check
        if (diploma.exists()) {
            System.out.println("File exists");
            System.out.println("The file is at " + diploma.getAbsolutePath());
        } else {
            System.out.println("File doesn't exist");
            return;
        }
        // Task 2: File Readability Check
        if (!diploma.canRead()) {
            System.out.println("File is unreadable");
            return;
        }

        // Task 3: Using try-with-resources
        try (Scanner reader = new Scanner(diploma)) {
            if (reader.hasNextLine()) {
                reader.nextLine();
            }

            // Read data from CSV and create DiplomaData objects
            while (reader.hasNext()) {
                String line = reader.nextLine();
                String[] items = line.split(",");

                // Extract data from CSV and remove extra spaces and commas
                String bil = items[0].trim();
                String category = items[1].trim();
                String name = items[2].trim();
                String year2014 = items[3].trim().replace(",", "");
                String year2015 = items[4].trim().replace(",", "");
                String year2016 = items[5].trim().replace(",", "");
                String year2017 = items[6].trim().replace(",", "");
                String year2018 = items[7].trim().replace(",", "");
                String year2019 = items[8].trim().replace(",", "");

                // Task 5: Create and populate the ArrayList with DiplomaData objects
                DiplomaData data = new DiplomaData(bil, category, name, year2014, year2015, year2016, year2017, year2018, year2019);

                // Task 6: Categorize data
                if ("Diploma Lanjutan".equals(category)) {
                    diplomaLanjutan.add(data);
                } else if ("Kursus Pengkhususan".equals(category)) {
                    kursusPengkhususan.add(data);
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Error reading the file: " + exception.getMessage());
            return;
        }

        // Task 7: Write matching data to separate text files
        try (PrintWriter writer = new PrintWriter(new File("Diploma Lanjutan.txt"))) {
            for (DiplomaData row : diplomaLanjutan) {
                writer.println(row);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Error writing to Diploma Lanjutan file: " + exception.getMessage());
        }

        try (PrintWriter writer = new PrintWriter(new File("Kursus Pengkhususan.txt"))) {
            for (DiplomaData row : kursusPengkhususan) {
                writer.println(row);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Error writing to Kursus Pengkhususan file: " + exception.getMessage());
        }
    }
}
