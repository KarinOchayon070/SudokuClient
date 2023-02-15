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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class GridController implements Initializable {

    @FXML
    private Pane pane;
    private Stage stage;
    private Scene scene;
    private SudokuTemplate sudokuTemplate = new SudokuTemplate();
    private SudokuTemplatesModel sudokuTemplatesModel = new SudokuTemplatesModel();

    private ComboBox<String> difficultyComboBox;


    @FXML
    void onActionReset(ActionEvent event){
        this.generateGrid();
        this.render();
    }
    
    void generateGrid(){
        int[][] tempGridData = new int[9][9];

        for (int i = 0; i < tempGridData.length; i++) {
            for (int j = 0; j < tempGridData[i].length; j++) {
                tempGridData[i][j] = 0;
            }
        }

        this.sudokuTemplate.setGrid(tempGridData);
    }


    @FXML
    void getByDifficulty(ActionEvent event){
        String difficulty = difficultyComboBox.getValue();
        try {
            this.sudokuTemplate = this.sudokuTemplatesModel.getTemplateByDifficulty(difficulty);
            this.render();
        } catch(IOException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void handleSolveSudoku(ActionEvent event){
        try{
            this.sudokuTemplate = sudokuTemplatesModel.handleSolveSudoku(this.sudokuTemplate);
            this.render();
        } catch(IOException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }



    void render(){
        GridPane uiGrid = (GridPane) pane.lookup("#grid");

        int[][] grid = sudokuTemplate.getGrid();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // get the node at the current grid cell
                TextField textfield = (TextField) uiGrid.getChildren().get(i * grid[i].length + j);
                if(grid[i][j] == 0){
                    textfield.setText("");
                }
                else{
                    textfield.setText(String.valueOf(grid[i][j]));
                }
            }
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.generateGrid();

        difficultyComboBox = new ComboBox<String>();
        difficultyComboBox.setId("difficultyComboBox");

        difficultyComboBox.setPromptText("Choose Difficulty");
        ObservableList<String> options = FXCollections.observableArrayList("Hard", "Medium", "Easy");
        difficultyComboBox.setItems(options);
        difficultyComboBox.getStyleClass().add("button");


        difficultyComboBox.setStyle("-fx-background-color: #F4C6EE;");
       

        int[][] grid = sudokuTemplate.getGrid();

        GridPane uiGrid = new GridPane();
        uiGrid.setId("grid");
        uiGrid.setAlignment(Pos.CENTER);
        uiGrid.getStyleClass().add("grid-pane");


        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                TextField textField = new TextField();
                int finalI = i;
                int finalJ = j;

                textField.setAlignment(Pos.CENTER);
                textField.setPrefSize(50,50);
                textField.getStyleClass().add("grid-cell");

                boolean shouldVertical = (i + 1) % 3 == 0 && i != 8;
                boolean shouldHorizontal = (j) % 3 == 0 && j != 0;
                boolean shouldBoth = shouldVertical && shouldHorizontal;

                if(shouldBoth){
                    textField.getStyleClass().add("border-both");
                }

                else if(shouldVertical){
                    textField.getStyleClass().add("border-bottom");
                }

                else if(shouldHorizontal){
                    textField.getStyleClass().add("border-right");
                }


                textField.textProperty().addListener((obs, oldValue, newValue)->{
                    if ((newValue.matches("\\d*") || newValue == "") && newValue.length() <= 1) {
                        int finalValue = newValue.equals("") ? 0 : Integer.parseInt(newValue);

                        this.sudokuTemplate.setGridPoint(finalI,finalJ,finalValue);
                    }

                    this.render();

                });
                uiGrid.add(textField, j, i);

            }
        }

        uiGrid.setLayoutX(50);
        uiGrid.setLayoutY(170);
        difficultyComboBox.setLayoutX(525);
        difficultyComboBox.setLayoutY(430);


        pane.getChildren().add(uiGrid);
        pane.getChildren().add(difficultyComboBox);
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
