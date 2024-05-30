package tsp;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa Path reprezintă o cale între orașe în problema TSP.
 * Aceasta stochează orașele vizitate, costul total și costul estimat (pentru A*).
 */
public class Path {
    private List<City> cities;
    private double cost;
    private double estimatedTotalCost;

    public Path() {
        this.cities = new ArrayList<>();
        this.cost = 0;
        this.estimatedTotalCost = 0;
    }

    public Path(Path other) {
        this.cities = new ArrayList<>(other.cities);
        this.cost = other.cost;
        this.estimatedTotalCost = other.estimatedTotalCost;
    }

    // Adaugă un oraș la cale și actualizează costul
    public void addCity(City city, double cost) {
        this.cities.add(city);
        this.cost = cost;
    }

    // Adaugă un oraș la cale și actualizează costul și costul estimat
    public void addCity(City city, double cost, double estimatedTotalCost) {
        this.cities.add(city);
        this.cost = cost;
        this.estimatedTotalCost = estimatedTotalCost;
    }

    public City getLastCity() {
        if (cities.isEmpty()) return null;
        return cities.get(cities.size() - 1);
    }

    public boolean contains(City city) {
        return cities.contains(city);
    }

    public List<City> getCities() {
        return cities;
    }

    public double getCost() {
        return cost;
    }

    public double getEstimatedTotalCost() {
        return estimatedTotalCost;
    }

    public int size() {
        return cities.size();
    }
}
