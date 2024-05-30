package tsp;

/**
 * Clasa Edge reprezintă o muchie între două orașe în problema TSP.
 * Fiecare muchie are două orașe și un cost asociat.
 */
public class Edge {
    private City city1;
    private City city2;
    private double cost;

    public Edge(City city1, City city2, double cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }

    public City getCity1() {
        return city1;
    }

    public City getCity2() {
        return city2;
    }

    public double getCost() {
        return cost;
    }
}
