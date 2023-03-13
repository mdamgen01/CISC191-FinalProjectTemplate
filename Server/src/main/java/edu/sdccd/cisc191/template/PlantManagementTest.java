package edu.sdccd.cisc191.template;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import org.junit.Test;
import static org.junit.Assert.*;
public class PlantManagementTest {

    /**
     * This method tests if the abstract class Plant returns the expected value
     */
    @Test
    public void testPlant() {
        Plant plant = new Vegetable("Bean", 5, "Heirloom");
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
        Vegetable okra = new Vegetable("Okra", 4, "Heirloom");
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
     * This method tests the addPlant method in the PlantManagement class which check is the array is successfully
     * able to add object Vegetable in the Plant array
     *
     */
    @Test
    public void testAddPlant() {
        PlantManagement management = new PlantManagement();
        Vegetable vegetable = new Vegetable("Okra", 5, "Heirloom");
        management.addPlant(vegetable);
        assertEquals(1, management.getListOfPlants().length);
        assertEquals(vegetable, management.getListOfPlants()[0]);
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
