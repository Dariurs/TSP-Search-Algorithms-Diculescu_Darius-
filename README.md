# Tema de Casă pentru Inteligență Artificială

## Descriere
Această aplicație implementează algoritmii de căutare pentru problema Traveling Salesman (TSP).

## Algoritmi Implementați
- Căutare în lățime (Breadth-First Search)
- Căutare cu cost uniform (Uniform Cost Search)
- Căutare A* (A* Search)

## Cerințe
- Java JDK 8 sau mai nou
- Un IDE compatibil cu Java (de exemplu, IntelliJ IDEA)

## Structura Proiectului
- `src/tsp/` - Directorul care conține fișierele sursă Java
   - `TSP.java` - Clasa principală care rulează algoritmii TSP pe un set de date predefinit și pe un set de date generat automat.
   - `TSPTest.java` - Clasa pentru testarea algoritmilor, afișând și timpul de execuție pentru fiecare algoritm.
   - `City.java` - Clasa care reprezintă un oraș.
   - `Edge.java` - Clasa care reprezintă o muchie între două orașe.
   - `Path.java` - Clasa care reprezintă o cale între orașe.
   - `BreadthFirstSearch.java` - Implementarea algoritmului de căutare în lățime.
   - `UniformCostSearch.java` - Implementarea algoritmului de căutare cu cost uniform.
   - `AStarSearch.java` - Implementarea algoritmului de căutare A*.
   - `Heuristic.java` - Clasa care definește funcția euristică pentru algoritmul A*.

## Instrucțiuni de Compilare și Rulare
1. Clonați repository-ul:
    ```sh
    git clone https://github.com/Dariurs/TSP-Search-Algorithms-Diculescu_Darius-.git
    ```
2. Navigați în directorul proiectului și compilați codul:
    ```sh
    javac -d out/production/TSP src/tsp/*.java
    ```
3. Rulați aplicația cu setarea memoriei heap-ului JVM pentru a evita problemele de memorie:
    ```sh
    java -Xmx2048m -cp out/production/TSP tsp.TSP
    ```

## Rularea Testelor
Pentru a rula clasa de testare și a afișa timpul de execuție pentru fiecare algoritm:
```sh
java -Xmx2048m -cp out/production/TSP tsp.TSPTest
```

## Autori
- Diculescu Darius Robert

## Contact
Pentru întrebări sau probleme, vă rog să mă contactați la adresa de email: [diculescu800@gmail.com](mailto:email@example.com)
