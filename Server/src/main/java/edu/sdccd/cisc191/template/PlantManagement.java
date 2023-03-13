package edu.sdccd.cisc191.template;

// Adapted from Inventory Management System by 1BestCsharp blog (https://www.youtube.com/watch?v=VpwLw42vrwU&t=1244s)
// The original author created a product inventory system using arrayList, java swing and mysql for database
// I took the concept of management system and transformed it into a plant management system using javafx and arrays


/**
 * Plant Management class manages all the plants
 */
public class PlantManagement {

    /**
     * Initial Size is the initial size of the plant array
     */
    private static final int INITIAL_SIZE = 10;

    /**
     * The Plant array
     */
    protected Plant[] plants;

    /**
     * the number of plants in the array
     */
    private int numberPlants;

    /**
     * Initializes the Plant array
     */
    public PlantManagement() {
        plants = new Plant[INITIAL_SIZE];
    }

    /**
     * Adds a plant to the plant array
     * @param plants the plant to be added
     */
    public void addPlant(Plant plants) {
        if(numberPlants == this.plants.length) {
            resize();
        }
        this.plants[numberPlants++] = plants;
    }

    /**
     * Resizes the size of the Plant array when full
     * It adds 5 more elements when the array is full, and copies the previous elements from the previous array
     */
    private void resize() {
        Plant[] temporary = new Plant[plants.length + 5];
        System.arraycopy(plants, 0, temporary, 0, plants.length);
        plants = temporary;
    }

    /**
     * Deletes a plant from the plant array
     * @param name the name of the plant to delete
     * @return true if the plant was deleted else it returns false
     */
    public boolean deletePlant(String name) {
        Plant temporary;
        for(int i = 0; i < numberPlants; i++) {
            temporary = plants[i];

            if (temporary.getName().equalsIgnoreCase(name)) {
                for (int j = i; j < numberPlants -1; j++) {
                    plants[j] = plants[j + 1];
                }
                numberPlants --;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an array of all the plants in the plant manager
     * @return an array of all the plants in the plant manager
     */
    public Plant[] getListOfPlants() {
        Plant[] temporary = new Plant[numberPlants];
        for (int i = 0; i < numberPlants; i++) {
            temporary[i] = plants[i];
        }
        return temporary;
    }

}
