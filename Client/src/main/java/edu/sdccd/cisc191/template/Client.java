package edu.sdccd.cisc191.template;

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * The client class contains the main method to initiate a connection with the server.
 * It will also launch the graphical user interface once connected to the server.
 */
public class Client extends Application {

    /**
     * Table view to display the plants
     */
    TableView<Plant> plantsTable;

    /**
     * PlantManagement object
     */
    private final PlantManagement manager;

    /**
     * Constructor for the Client Class
     */
    public Client() {
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
     * Overrides the start method of the Application class to display user interface
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
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Plant, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setPrefWidth(150);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        TableColumn<Plant, Integer> varietyColumn = new TableColumn<>("Variety");
        varietyColumn.setPrefWidth(150);
        varietyColumn.setCellValueFactory(new PropertyValueFactory<>("variety"));

        plantsTable = new TableView<>();
        plantsTable.getColumns().addAll( nameColumn, quantityColumn, varietyColumn);

        Button addButton = new Button("Add Plant");
        addButton.setOnAction(e -> new VegetableGUI(this));

        Button deleteButton = new Button("Delete Plant");
        deleteButton.setOnAction(e -> deletePlant());

        Button exportButton  = new Button ("Export Table");
        exportButton.setOnAction(e -> {
            ExportList export = new ExportList();
            export.convertedPlants();

        });

        Text sortedPlantText = new Text();
        sortedPlantText.setTextAlignment(TextAlignment.CENTER);

        Button sortedPlantIdeasButton = new Button("Plant Ideas");
        sortedPlantIdeasButton.setOnAction(e -> {
            BinaryAddTree plantTree = new BinaryAddTree();
            plantTree.addPlantIdea("Asparagus");
            plantTree.addPlantIdea("Okra");
            plantTree.addPlantIdea("Cucumber");
            plantTree.addPlantIdea("Basil");
            sortedPlantText.setText(plantTree.plantInOrder());
        });

        Text infoText = new Text();
        infoText.setTextAlignment(TextAlignment.CENTER);

        Button leafyVegetableFacts = new Button("Vegetable Info");
        leafyVegetableFacts.setOnAction(e -> {
            LeafyVegetable info = new LeafyVegetable("BokChoy", 5, "Shanghai");
            infoText.setText(info.VegetableFacts());
        });

        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(10, 10, 10, 10));
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);
        buttonBox.getChildren().addAll(addButton, deleteButton, leafyVegetableFacts, exportButton, sortedPlantIdeasButton);

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().addAll(buttonBox, infoText);

        StackPane stackPanePlant = new StackPane();
        stackPanePlant.setAlignment(Pos.TOP_LEFT);
        stackPanePlant.getChildren().add(sortedPlantText);

        VBox root = new VBox();
        root.getChildren().addAll(plantsTable, buttonBox, stackPane, stackPanePlant);

        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("Garden Vault");
        stage.show();

        listAllPlants();
    }

    /**
     * Displays all the plants in the table
     */
    public void listAllPlants() {
        plantsTable.getItems().clear();

        ArrayList<Plant> vegetables = manager.getPlants();

        for (Plant plant : vegetables) {
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

            manager.deletePlant(name);
        }
        listAllPlants();
    }

    /**
     * The main method creates a socket and connects to the server.
     * It sends a serialized VegetableRequest Object to the server
     * and receives a serialized VegetableResponse object from the server.
     * Then it will deserialize the received VegetableResponse object and
     * print it into the console.
     * @param args the command line argument
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", Server.LISTENING_PORT);

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            VegetableRequest clientRequest = new VegetableRequest("Cucumber", 5, "Lemon");
            output.writeObject(clientRequest);

            VegetableResponse serverResponse = (VegetableResponse) input.readObject();
            System.out.println(serverResponse);

            launch(args);

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}