package DijkstrasAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        List<String> data = fileReader.readFromFile();
        List<Vertex> citiesList = new ArrayList<>();

        data.stream().forEach(s->{
            String[] line = s.split(",");
            Vertex v1 = new Vertex(line[0]);
            Vertex v2 = new Vertex(line[1]);
            v1.link(v2,Float.parseFloat(line[2]));
            if (!citiesList.contains(v1)) {
                citiesList.add(v1);
            }
            if (!citiesList.contains(v2)) {
                citiesList.add(v2);
            }
        });

        Graph cities = new Graph(citiesList);
        Dijkstra dijkstra = new Dijkstra();

        System.out.println(dijkstra.calculate(cities,citiesList.get(2),citiesList.get(3)));






    }
}
