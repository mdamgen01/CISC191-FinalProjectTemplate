package edu.sdccd.cisc191.template;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * VegetableGUI Class gathers the vegetable information necessary for the Table View to display the details
 * of the vegetable
 */
public class VegetableGUI {

    /**
     * TextField input for the name of the vegetable
     */
    private TextField nameTextField;

    /**
     * TextField input for the quantity of the vegetable
     */
    private TextField quantityTextField;

    /**
     * TextField input for the variety of the vegetable
     */
    private TextField varietyTextField;

    /**
     * An object of dataType ViewPlantManagement that represents the main user interface for managing the plants
     */
    private Client viewPlantManagementUI;

    /**
     * Constructor for the VegetableUI Class
     * @param viewPlantManagementUI main user interface for managing the plants
     */
    public VegetableGUI(Client viewPlantManagementUI) {
        this.viewPlantManagementUI = viewPlantManagementUI;
        GridPane addVegetableGrid = new GridPane();
        addVegetableGrid.setPadding(new Insets(10));
        addVegetableGrid.setHgap(10);
        addVegetableGrid.setVgap(10);

        nameTextField = new TextField();
        nameTextField.setPromptText("Name");

        quantityTextField = new TextField();
        quantityTextField.setPromptText("Quantity");

        varietyTextField = new TextField();
        varietyTextField.setPromptText("Variety");

        Button addButton = new Button("Add");
        addButton.setPrefWidth(150);
        addButton.setOnAction(e -> {
            addVegetable();
        });

        addVegetableGrid.add(new Label("Name: "), 0, 0);
        addVegetableGrid.add(nameTextField, 1, 0);

        addVegetableGrid.add(new Label("Quantity: "), 0, 1);
        addVegetableGrid.add(quantityTextField, 1, 1);

        addVegetableGrid.add(new Label("Variety: "), 0, 2);
        addVegetableGrid.add(varietyTextField, 1, 2);

        addVegetableGrid.add(addButton, 1, 3);

        Stage stage = new Stage();
        stage.setTitle("Add Plant");
        stage.setScene(new Scene(addVegetableGrid));
        stage.show();
    }

    /**
     * Clears the text input fields for variety, name, and quantity of a vegetable.
     * It is called after a vegetable has been added to reset the text fields for new input
     */
    public void clearTextFields() {
        varietyTextField.clear();
        nameTextField.clear();
        quantityTextField.clear();
    }

    /**
     * Adds Vegetable to the ArrayList of plants
     * @throws NumberFormatException if the quantity input is not numeric
     */
    private void addVegetable() throws NumberFormatException{
        String name = nameTextField.getText();
        String quantityString = quantityTextField.getText();
        String variety = varietyTextField.getText();

        if (name.equals("") || quantityString.equals("") || variety.equals("")) {
            displayMessage(AlertType.ERROR, "Please make sure all fields are filled");
        } else {
            try {
                int availableQuantity = Integer.parseInt(quantityString);

                if (availableQuantity <= 0) {
                    displayMessage(AlertType.ERROR, "Quantity must be greater than 0!");
                }

                VegetableRequest newVegetableRequest = new VegetableRequest(name, availableQuantity, variety);
                viewPlantManagementUI.getManager().addPlant(newVegetableRequest);
                viewPlantManagementUI.listAllPlants();

                clearTextFields();

            } catch (NumberFormatException e) {
                displayMessage(AlertType.ERROR, "Quantity should be numeric value!");
                System.out.println(e);
            }
        }
    }

    /**
     * Displays pop-up alert message to the users
     * @param type the alert type
     * @param message the alert message
     */
    public static void displayMessage(AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}
