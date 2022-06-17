import java.io.*;
import java.nio.file.Paths;
import java.util.*;

class Main {

    private static BufferedWriter writer;

    public static void main(String args[]) {
        Calculator calc = new Calculator();
        try {
           File test = new File("input.txt");
           Scanner input = new Scanner(test);
           File output = new File("output.txt");
           output.createNewFile();
           writer = new BufferedWriter(new FileWriter(output));
           while (input.hasNextLine()) {
               writer.append(calc.calculate(input.nextLine()));
               writer.newLine();
           }
           writer.flush();
           writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File was not found");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

