package edu.sdccd.cisc191.template;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;
public class PlantManagementTest {

    /**
     * This method tests the addPlant method in the PlantManagement class which check if the ArrayList is successfully
     * able to add object Plant in the ArrayList of Plants
     *
     */
    @Test
    public void testAddPlant() {
        PlantManagement management = new PlantManagement();
        Plant plantToAdd = new Plant("Okra", 1);
        management.addPlant(plantToAdd);
        ArrayList<Plant> plantList = management.getPlants();
        assertTrue(plantList.contains(plantToAdd));
    }

    /**
     * This method test the testAddPlantIdea method in BinaryAddTree Class
     * It tests if it is able to successfull add the plant idea and if it returns it in sorted order
     */
    @Test
    public void testAddPlantIdea() {
        BinaryAddTree binaryAddTree = new BinaryAddTree();
        binaryAddTree.addPlantIdea("Okra");
        binaryAddTree.addPlantIdea("Basil");
        assertEquals("Basil, Okra, ", binaryAddTree.plantInOrder());
    }

    /**
     * This method test checks if the testToString method is working properly for the VegetableResponse Class
     * used in client and server
     */
    @Test
    public void testToString(){
        VegetableRequest request = new VegetableRequest("cucumber", 5, "lemon");
        VegetableResponse response = new VegetableResponse(request, "transplant");

        String expected = "Don't forget to harden off cucumber before transplant";
        String actual = response.toString();

        assertEquals(expected, actual);
    }

    /**
     * This method tests if the plant ideas are being added successfully
     */
    @Test
    public void testAddPlantIdeaRecur() {
        BinaryAddTree plantTree = new BinaryAddTree();
        plantTree.addPlantIdea(("Okra"));
        plantTree.addPlantIdea("Basil");

        String testResult = plantTree.plantInOrder();
        assertEquals("Basil, Okra, ", testResult);
    }

    /**
     * This method tests if the abstract class Plant returns the expected value
     */
    @Test
    public void testPlant() {
        Plant plant = new VegetableRequest("Bean", 5, "Heirloom");
        assertEquals("Bean", plant.getName());
        assertEquals(5, plant.getQuantity());
    }

    /**
     * This method test if the concrete class LeafyVegetable that inherits class Vegetable returns the expected value
     */
    @Test
    public void testLeafyVegetable() {
        LeafyVegetable bokchoy = new LeafyVegetable("Bokchoy", 3, "Heirloom");
        assertEquals("Bokchoy", bokchoy.getName());
        assertEquals(3, bokchoy.getQuantity());
        assertEquals("Heirloom", bokchoy.getVariety());
    }

    /**
     * This method test if the concrete class Vegetable that inherits class Plant returns the expected value
     */
    @Test
    public void testVegetable() {
        VegetableRequest okra = new VegetableRequest("Okra", 4, "Heirloom");
        assertEquals("Okra", okra.getName());
        assertEquals(4, okra.getQuantity());
        assertEquals("Heirloom", okra.getVariety());
    }

    /**
     * This method test if the interface VegetableFacts return the expected value
     */
    @Test
    public void testVegetableFacts() {
        VegetableFacts vegFacts = () -> "You can grow tomatoes in Potatoes!";
        assertEquals("You can grow tomatoes in Potatoes!", vegFacts.VegetableFacts());
    }

    /**
     * This method test if the StackPane sets its alignment property to center
     */
    @Test
    public void testStackPane() {
        StackPane stackPaneTest = new StackPane();
        stackPaneTest.setAlignment(Pos.CENTER);
        assertEquals(Pos.CENTER, stackPaneTest.getAlignment());
    }
}
