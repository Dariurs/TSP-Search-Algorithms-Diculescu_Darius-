package tsp;

/**
 * Clasa Heuristic definește funcția euristică folosită de algoritmul A* pentru estimarea costului.
 */
public class Heuristic {
    public double estimate(City city1, City city2) {
        return Math.sqrt(Math.pow(city1.getX() - city2.getX(), 2) + Math.pow(city1.getY() - city2.getY(), 2));
    }
}
