package DijkstrasAlgorithm;

import java.util.*;

public class Dijkstra {

    public Optional<Float> calculate(Graph graph, Vertex from, Vertex to) {

        Set<Vertex> vertices = new HashSet<>(graph.getVertices());

        vertices.stream().filter(v -> v != from).forEach(v -> v.setCalculatedDistance(Float.MAX_VALUE));
        from.setCalculatedDistance(0);

        Queue<Vertex> queue = new PriorityQueue<>(vertices);

        while (!queue.isEmpty()) {
            Vertex current = queue.remove();
            for (Edge e : current.getEdges()) {
                Vertex next = e.otherVertex(current);
                float distance = current.getCalculatedDistance() + e.getLength();
                if (distance < next.getCalculatedDistance()) {
                    next.setCalculatedDistance(distance);
                    queue.remove(next);
                    queue.add(next);
                }
            }

        }

        if (to.getCalculatedDistance() == Float.MAX_VALUE) {
            return Optional.empty();
        }
        else {
            return Optional.of(to.getCalculatedDistance());
        }
    }

}
