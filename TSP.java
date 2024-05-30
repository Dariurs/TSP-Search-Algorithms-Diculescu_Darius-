package tsp;

import java.util.*;

/**
 * Clasa principală care rulează algoritmii TSP folosind date predefinite și generate automat.
 * Aceasta clase creează seturile de date, rulează algoritmii de căutare și afișează rezultatele.
 */
public class TSP {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Max memory: " + (maxMemory / 1024 / 1024) + " MB");

        // Set de date predefinit cu 15 orașe
        City[] cities = new City[]{
                new City("A", 0, 0),
                new City("B", 1, 0),
                new City("C", 2, 0),
                new City("D", 3, 0),
                new City("E", 4, 0),
                new City("F", 5, 0),
                new City("G", 6, 0),
                new City("H", 7, 0),
                new City("I", 8, 0),
                new City("J", 9, 0),
                new City("K", 0, 1),
                new City("L", 1, 1),
                new City("M", 2, 1),
                new City("N", 3, 1),
                new City("O", 4, 1)
        };

        // Crearea muchiilor între orașe cu costurile respective
        Edge[] edges = new Edge[]{
                new Edge(cities[0], cities[1], 1),
                new Edge(cities[1], cities[2], 1),
                new Edge(cities[2], cities[3], 1),
                new Edge(cities[3], cities[4], 1),
                new Edge(cities[4], cities[5], 1),
                new Edge(cities[5], cities[6], 1),
                new Edge(cities[6], cities[7], 1),
                new Edge(cities[7], cities[8], 1),
                new Edge(cities[8], cities[9], 1),
                new Edge(cities[0], cities[10], 1),
                new Edge(cities[1], cities[11], 1),
                new Edge(cities[2], cities[12], 1),
                new Edge(cities[3], cities[13], 1),
                new Edge(cities[4], cities[14], 1),
                new Edge(cities[5], cities[10], 1),
                new Edge(cities[6], cities[11], 1),
                new Edge(cities[7], cities[12], 1),
                new Edge(cities[8], cities[13], 1),
                new Edge(cities[9], cities[14], 1),
                new Edge(cities[10], cities[11], 1),
                new Edge(cities[11], cities[12], 1),
                new Edge(cities[12], cities[13], 1),
                new Edge(cities[13], cities[14], 1),
                new Edge(cities[14], cities[0], 1),
        };

        System.out.println("Running algorithms on manually defined graph:");
        runAlgorithms(cities, edges);

        // Generare aleatorie a 10 orașe
        int numberOfCities = 10;
        City[] randomCities = generateRandomCities(numberOfCities);
        Edge[] randomEdges = generateCompleteRandomEdges(randomCities);

        System.out.println("\nRunning algorithms on randomly generated graph:");
        runAlgorithms(randomCities, randomEdges);
    }

    // Metodă pentru rularea algoritmilor de căutare și afișarea rezultatelor
    private static void runAlgorithms(City[] cities, Edge[] edges) {
        BreadthFirstSearch bfs = new BreadthFirstSearch(cities, edges);
        List<City> bfsPath = bfs.search();
        System.out.println("BFS Path: " + bfsPath);
        System.out.println("Total Cost: " + calculatePathCost(bfsPath, edges));

        UniformCostSearch ucs = new UniformCostSearch(cities, edges);
        List<City> ucsPath = ucs.search();
        System.out.println("UCS Path: " + ucsPath);
        System.out.println("Total Cost: " + calculatePathCost(ucsPath, edges));

        Heuristic heuristic = new Heuristic();
        AStarSearch aStar = new AStarSearch(cities, edges, heuristic);
        List<City> aStarPath = aStar.search();
        System.out.println("A* Path: " + aStarPath);
        System.out.println("Total Cost: " + calculatePathCost(aStarPath, edges));
    }

    // Generarea unui set de orașe cu poziții random
    private static City[] generateRandomCities(int numberOfCities) {
        City[] cities = new City[numberOfCities];
        Random random = new Random();

        for (int i = 0; i < numberOfCities; i++) {
            cities[i] = new City("City" + (i + 1), random.nextDouble() * 100, random.nextDouble() * 100);
        }

        return cities;
    }

    // Generarea muchiilor între orașele generate random
    private static Edge[] generateCompleteRandomEdges(City[] cities) {
        List<Edge> edges = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cities.length; i++) {
            for (int j = i + 1; j < cities.length; j++) {
                double cost = random.nextDouble() * 10 + 1; // Costuri între 1 și 10
                edges.add(new Edge(cities[i], cities[j], cost));
            }
        }

        return edges.toArray(new Edge[0]);
    }

    // Calcularea costului total al unei căi date
    private static double calculatePathCost(List<City> path, Edge[] edges) {
        if (path == null || path.size() < 2) {
            return 0;
        }

        double totalCost = 0;

        for (int i = 0; i < path.size() - 1; i++) {
            City city1 = path.get(i);
            City city2 = path.get(i + 1);
            totalCost += getEdgeCost(city1, city2, edges);
        }

        return totalCost;
    }

    // Obținerea costului unei muchii între două orașe
    private static double getEdgeCost(City city1, City city2, Edge[] edges) {
        for (Edge edge : edges) {
            if ((edge.getCity1().equals(city1) && edge.getCity2().equals(city2)) ||
                    (edge.getCity1().equals(city2) && edge.getCity2().equals(city1))) {
                return edge.getCost();
            }
        }
        return Double.MAX_VALUE;
    }
}
