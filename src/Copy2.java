import java.io.IOException;
import java.nio.file.*;

public class Copy2 {

    public static void main(String[] args) {

        String inputfolderName;
        String outputFolderName;
        if (args.length != 2){
            inputfolderName = "/user/java/input ";
            outputFolderName = "/user/java/output";
        }else {
            inputfolderName = args[0];
            outputFolderName = args[1];
        }
        Path sourceDir = Paths.get(inputfolderName);
        Path targetDir = Paths.get(outputFolderName);

        try {
            Files.walk(sourceDir).forEach(source -> {
                Path destination = targetDir.resolve(sourceDir.relativize(source));
                try {
                    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println("Failed to copy " + source + ": " + e.getMessage());
                }
            });
            System.out.println("Folder copied successfully!");
        } catch (IOException e) {
            System.err.println("Error while copying folder: " + e.getMessage());
        }
    }
}