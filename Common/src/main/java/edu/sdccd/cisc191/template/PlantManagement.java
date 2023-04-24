package edu.sdccd.cisc191.template;

import java.util.ArrayList;

/**
 * The PlantManagement Class manages or holds the elements in the ArrayList of plants
 */
public class PlantManagement {

    /**
     * An object of data type Arraylist of Plant named plants
     */
    private ArrayList<Plant> plants;

    /**
     * The constructor method for PlantManagement
     */
    public PlantManagement() {
        plants = new ArrayList<>();
    }

    /**
     * The method addPlant adds plants to the ArrayList
     * @param plant the plant to add
     */
    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    /**
     * The method deletePlant deletes plant from the ArrayList
     * @param name the name of the plant to delete
     */
    public void deletePlant(String name) {
        for (Plant plantLoop : plants) {
            if (plantLoop.getName().equalsIgnoreCase(name)) {
                plants.remove(plantLoop);
                break;
            }
        }
    }

    /**
     * Gets the ArrayList of plants
     * @return the plants in the ArrayList
     */
    public ArrayList<Plant> getPlants() {
        return plants;
    }
}
