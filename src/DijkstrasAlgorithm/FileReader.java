package DijkstrasAlgorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private String path = "/media/magda/518BF9B75CAB5A45/KursJava/Zajecia27/Cities/cities";

    public List<String> readFromFile() {

        List<String> data = new ArrayList<>();

        try {
             data = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
