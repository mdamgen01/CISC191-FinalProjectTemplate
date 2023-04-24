package edu.sdccd.cisc191.template;

import java.io.*;
import java.util.ArrayList;

/**
 * The ExportList class will export or convert the ArrayList of plant into a csv file
 */
public class ExportList {

    /**
     * The method convertedPlant will convert the ArrayList of plants from PlantManagement class
     * to a csv file and will save them in a file name called convertedPlants.csv
     */
    public void convertedPlants() {
        PlantManagement plantManagement = new PlantManagement();
        ArrayList<Plant> plantConvert = plantManagement.getPlants();
        csvConverter("convertedPlants.csv", plantConvert);
    }

    /**
     * The method csvConverter creates the csv data from the ArrayList
     * @param fileName the name of the file to write the csv
     * @param plantList the list of plant to convert to csv
     */
    public void csvConverter(String fileName, ArrayList<Plant> plantList) {
        try(BufferedWriter plantWriter = new BufferedWriter(new FileWriter(fileName))) {
            plantWriter.write("Name, Quantity, Variety");
            plantWriter.newLine();

            plantWriter.write("Okra, 1, Emerald Green");
            plantWriter.newLine();

            for(Plant plants: plantList) {
                plantWriter.write(plants.getName() + ",");
                plantWriter.write(plants.getQuantity() + ",");
                if (plants instanceof VegetableRequest) {
                    plantWriter.write(((VegetableRequest) plants). getVariety());
                } else {
                    plantWriter.write("");
                }
                plantWriter.newLine();
            }
            plantWriter.flush();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
