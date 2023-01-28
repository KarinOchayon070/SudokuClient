package com.example.demo;
import client.Client;
import client.SudokuTemplate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
public class GridController implements Initializable {

    @FXML
    private Pane pane;
    private int[][] gridData;
    private SudokuTemplate sudokuTemplate = new SudokuTemplate();
    private Client client = new Client();


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
    void onActionCheckBoard(ActionEvent event){
        for (int i = 0; i < this.gridData.length; i++) {
            for (int j = 0; j < this.gridData[i].length; j++) {
                System.out.print(this.gridData[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }


    @FXML
    void getByDifficulty(ActionEvent event){
        this.sudokuTemplate = this.client.getTemplateByDifficulty("Easy");
        this.render();
    }

    @FXML
    void handleSolveSudoku(ActionEvent event){
        this.sudokuTemplate = client.handleSolveSudoku(this.sudokuTemplate);
        this.render();
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
        pane.getChildren().add(uiGrid);
    }




}
