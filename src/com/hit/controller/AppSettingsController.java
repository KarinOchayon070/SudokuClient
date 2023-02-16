package com.hit.controller;

import com.hit.client.SudokuTemplate;
import com.hit.model.SudokuTemplatesModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AppSettingsController implements Initializable {
    @FXML
    private Pane pane;
    private Stage stage;
    private Scene scene;
    private SudokuTemplatesModel sudokuTemplatesModel = new SudokuTemplatesModel();
    private List<SudokuTemplate> sudokuTemplates;

    public AppSettingsController() {
    }

    public void handleDeleteTemplate(String id, HBox templateBox, VBox containerBox){
        try {
            sudokuTemplatesModel.deleteByID(id);
            containerBox.getChildren().remove(templateBox);

        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            this.sudokuTemplates = sudokuTemplatesModel.getAllTemplates();

            VBox containerBox = new VBox();
            containerBox.setSpacing(30);


            for (SudokuTemplate sudokuTemplate: sudokuTemplates) {

                    int[][] grid = sudokuTemplate.getGrid();

                    GridPane uiGrid = new GridPane();
                    uiGrid.setId("grid");
                    uiGrid.setAlignment(Pos.CENTER);
                    uiGrid.getStyleClass().add("grid-pane");


                    for (int i = 0; i < grid.length; i++) {
                        for (int j = 0; j < grid[i].length; j++) {
                            TextField textField = new TextField();

                            textField.setAlignment(Pos.CENTER);
                            textField.setPrefSize(50, 50);
                            textField.setDisable(true);
                            if (grid[i][j] != 0) {
                                textField.setText(String.valueOf(grid[i][j]));
                            }

                            boolean shouldVertical = (i + 1) % 3 == 0 && i != 8;
                            boolean shouldHorizontal = (j) % 3 == 0 && j != 0;
                            boolean shouldBoth = shouldVertical && shouldHorizontal;

                            if (shouldBoth) {
                                textField.getStyleClass().add("border-both");
                            } else if (shouldVertical) {
                                textField.getStyleClass().add("border-bottom");
                            } else if (shouldHorizontal) {
                                textField.getStyleClass().add("border-right");
                            }

                            uiGrid.add(textField, j, i);
                        }
                    }
                HBox templateBox = new HBox();
                templateBox.setSpacing(30);

                VBox infoBox = new VBox();
                infoBox.setSpacing(30);

                Text idText = new Text("ID: "+sudokuTemplate.getId());
                Text difficultyText = new Text("Difficulty: "+sudokuTemplate.getDifficulty());
                Button deleteButton = new Button();
                deleteButton.setText("Delete template");
                deleteButton.getStyleClass().add("button");
                deleteButton.setOnAction((arg)->{
                    this.handleDeleteTemplate(sudokuTemplate.getId(),templateBox,containerBox);
                });

                infoBox.getChildren().addAll(idText,difficultyText,deleteButton);


                templateBox.getChildren().addAll(uiGrid, infoBox);
                containerBox.getChildren().add(templateBox);
                }

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setPrefSize(888,500);
                scrollPane.setLayoutY(170);
                scrollPane.setLayoutX(80);
                scrollPane.setStyle("-fx-background: rgb(255,255,255);\n -fx-background-color: rgb(255,255,255)");
                scrollPane.setContent(containerBox);
                pane.getChildren().add(scrollPane);

        }
        catch(IOException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    public void handleGoBack(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/com/hit/view/on-boarding.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
