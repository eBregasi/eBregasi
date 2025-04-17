import java.io.*;

public class FileConverter {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        // Provimi për të kontrolluar nëse skedari input.txt ekziston
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            try {
                inputFile.createNewFile();
                System.out.println("Skedari 'input.txt' nuk u gjet. U krijua automatikisht si bosh.");
            } catch (IOException e) {
                System.out.println("Gabim gjatë krijimit të skedarit 'input.txt': " + e.getMessage());
                return;
            }
        }

        // Try-with-resources për të lexuar dhe shkruar skedarët
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Konverto tekstin në shkronja të mëdha
                String upperCaseLine = line.toUpperCase();
                // Shkruaj në skedarin output
                writer.write(upperCaseLine);
                writer.newLine();
            }
            System.out.println("Konvertimi përfundoi me sukses.");

        } catch (IOException e) {
            System.out.println("Gabim gjatë leximit ose shkrimit në skedar: " + e.getMessage());
        }
    }
}