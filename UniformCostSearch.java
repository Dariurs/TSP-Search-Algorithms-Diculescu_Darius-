package tsp;

import java.util.*;

/**
 * Clasa UniformCostSearch implementează algoritmul UCS pentru problema TSP.
 * Acesta explorează toate căile posibile folosind o coadă de prioritate pentru a găsi calea cu costul cel mai mic care vizitează toate orașele.
 */
public class UniformCostSearch {
    private City[] cities;
    private Edge[] edges;

    public UniformCostSearch(City[] cities, Edge[] edges) {
        this.cities = cities;
        this.edges = edges;
    }

    public List<City> search() {
        if (cities == null || cities.length == 0) {
            System.out.println("No cities provided for the search.");
            return Collections.emptyList();
        }

        City startCity = cities[0];
        Comparator<Path> pathComparator = Comparator.comparingDouble(Path::getCost);
        PriorityQueue<Path> queue = new PriorityQueue<>(pathComparator);
        Map<City, Double> costSoFar = new HashMap<>();
        Path initialPath = new Path();
        initialPath.addCity(startCity, 0.0);
        queue.add(initialPath);
        costSoFar.put(startCity, 0.0);

        while (!queue.isEmpty()) {
            Path path = queue.poll();
            City lastCity = path.getLastCity();

            // Dacă am vizitat toate orașele și ne-am întors la orașul de start
            if (path.size() == cities.length + 1 && lastCity.equals(startCity)) {
                System.out.println("Uniform Cost Search Path: " + path.getCities());
                System.out.println("Total Cost: " + path.getCost());
                return path.getCities();
            }

            // Explorăm vecinii orașului curent
            for (City neighbor : getNeighbors(lastCity)) {
                double newCost = path.getCost() + getEdgeCost(lastCity, neighbor);

                if (!path.contains(neighbor) || (neighbor.equals(startCity) && path.size() == cities.length)) {
                    Path newPath = new Path(path);
                    newPath.addCity(neighbor, newCost);
                    queue.add(newPath);
                    costSoFar.put(neighbor, newCost);
                }
            }
        }

        System.out.println("No valid path found.");
        return Collections.emptyList();
    }

    // Obține vecinii unui oraș
    private List<City> getNeighbors(City city) {
        List<City> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getCity1().equals(city)) {
                neighbors.add(edge.getCity2());
            } else if (edge.getCity2().equals(city)) {
                neighbors.add(edge.getCity1());
            }
        }
        return neighbors;
    }

    // Obține costul unei muchii între două orașe
    private double getEdgeCost(City city1, City city2) {
        for (Edge edge : edges) {
            if ((edge.getCity1().equals(city1) && edge.getCity2().equals(city2)) ||
                    (edge.getCity1().equals(city2) && edge.getCity2().equals(city1))) {
                return edge.getCost();
            }
        }
        return Double.MAX_VALUE;
    }
}
