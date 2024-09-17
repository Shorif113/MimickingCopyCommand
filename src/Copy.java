import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Copy {
    public static void main(String[] args) {
        String inputFileName;
        String outputFileName;
        if (args.length != 2){
            inputFileName = "input.txt";
            outputFileName = "output.txt";
        }else {
            inputFileName = args[0];
            outputFileName = args[1];
        }


        File inputFile = new File(inputFileName);

        try (Scanner in = new Scanner(inputFile);
             PrintWriter out = new PrintWriter(outputFileName)) {

            while (in.hasNext()) {
                if (in.hasNextLine()) {
                    String value = in.nextLine();

                    out.println( value );
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
