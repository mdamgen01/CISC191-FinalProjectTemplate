package edu.sdccd.cisc191.template;

// Adapted from Inventory Management System by 1BestCsharp blog (https://www.youtube.com/watch?v=VpwLw42vrwU&t=1244s)
// The original author created a product inventory system using arrayList, java swing and mysql for database
// I took the concept of management system and transformed it into a plant management system using javafx and arrays

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * ViewPlantManagement Class displays all the plants in the plant management
 * It also provides functions to add, delete, and display facts to the plant
 */
public class ViewPlantManagement extends Application {

    /**
     * Table view to display the plants
     */
    private TableView<Plant> plantsTable = new TableView<>();

    /**
     * PlantManagement object
     */
    private PlantManagement manager;

    /**
     * Constructor for the ViewPlantManagement Class
     */
    public ViewPlantManagement() {
        manager = new PlantManagement();
    }

    /**
     * Gets the PlantManagement object
     * @return the PlantManagement object
     */
    public PlantManagement getManager() {
        return manager;
    }

    /**
     * Overrides tha start method of the Application class to display user interface
     *
     * @param stage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     * @throws Exception if an error occurs during initialization
     */
    @Override
    public void start(Stage stage) throws Exception{

        TableColumn<Plant, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Plant, String>("name"));

        TableColumn<Plant, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setPrefWidth(150);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Plant, Integer>("Quantity"));

        TableColumn<Plant, Integer> varietyColumn = new TableColumn<>("Variety");
        varietyColumn.setPrefWidth(150);
        varietyColumn.setCellValueFactory(new PropertyValueFactory<Plant, Integer>("variety"));

        plantsTable.getColumns().addAll( nameColumn, quantityColumn, varietyColumn);

        Button addButton = new Button("Add Plant");
        addButton.setOnAction(e -> {
            new VegetableGUI(this);
        });

        Button deleteButton = new Button("Delete Plant");
        deleteButton.setOnAction(e -> {
            deletePlant();
        });

        Text infoText = new Text();
        infoText.setTextAlignment(TextAlignment.CENTER);

        Button leafyVegetableFacts = new Button("Vegetable Info");
        leafyVegetableFacts.setOnAction(event -> {
            LeafyVegetable info = new LeafyVegetable("BokChoy", 5, "Heirloom");
            infoText.setText(info.VegetableFacts());
        });

        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(10, 10, 10, 10));
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);
        buttonBox.getChildren().addAll(addButton, deleteButton, leafyVegetableFacts);

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().addAll(buttonBox, infoText);

        VBox root = new VBox();
        root.getChildren().addAll(plantsTable, buttonBox, stackPane);

        stage.setScene(new Scene(root, 350, 300));
        stage.setTitle("Garden Vault");
        stage.show();

        listAllPlants();
    }

    /**
     * Displays all the plants in the table
     */
    public void listAllPlants() {
        plantsTable.getItems().clear();

        for (Plant plant : manager.getListOfPlants()) {
            plantsTable.getItems().add(plant);
        }
        plantsTable.refresh();
    }

    /**
     * Deletes the selected plant from the table
     */
    private void deletePlant() {
        int selectedIndex = plantsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex > -1) {
            String name = plantsTable.getSelectionModel().getSelectedItem().getName();

            if (manager.deletePlant(name)) {
                listAllPlants();
            }
        }
    }

    /**
     * The start of the application
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
