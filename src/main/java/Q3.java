import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q3 {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\user\\Desktop\\School\\Question3\\src\\main\\resources\\data.txt"; // Replace with the actual file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int sum = 0;


            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    sum += number;
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid number format in the file.");
                }
            }
            System.out.println("Sum of numbers: " + sum);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
