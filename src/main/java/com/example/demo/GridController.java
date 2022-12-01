package com.example.demo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

public class GridController implements Initializable {

    @FXML
    private TextField btn00;
    @FXML
    private TextField btn01;
    @FXML
    private TextField btn02;
    @FXML
    private TextField btn03;
    @FXML
    private TextField btn04;
    @FXML
    private TextField btn05;
    @FXML
    private TextField btn06;
    @FXML
    private TextField btn07;
    @FXML
    private TextField btn08;
    @FXML
    private TextField btn10;
    @FXML
    private TextField btn11;
    @FXML
    private TextField btn12;
    @FXML
    private TextField btn13;
    @FXML
    private TextField btn14;
    @FXML
    private TextField btn15;
    @FXML
    private TextField btn16;
    @FXML
    private TextField btn17;
    @FXML
    private TextField btn18;
    @FXML
    private TextField btn20;
    @FXML
    private TextField btn21;
    @FXML
    private TextField btn22;
    @FXML
    private TextField btn23;
    @FXML
    private TextField btn24;
    @FXML
    private TextField btn25;
    @FXML
    private TextField btn26;
    @FXML
    private TextField btn27;
    @FXML
    private TextField btn28;
    @FXML
    private TextField btn30;
    @FXML
    private TextField btn31;
    @FXML
    private TextField btn32;
    @FXML
    private TextField btn33;
    @FXML
    private TextField btn34;
    @FXML
    private TextField btn35;
    @FXML
    private TextField btn36;
    @FXML
    private TextField btn37;
    @FXML
    private TextField btn38;
    @FXML
    private TextField btn40;
    @FXML
    private TextField btn41;
    @FXML
    private TextField btn42;
    @FXML
    private TextField btn43;
    @FXML
    private TextField btn44;
    @FXML
    private TextField btn45;
    @FXML
    private TextField btn46;
    @FXML
    private TextField btn47;
    @FXML
    private TextField btn48;
    @FXML
    private TextField btn50;
    @FXML
    private TextField btn51;
    @FXML
    private TextField btn52;
    @FXML
    private TextField btn53;
    @FXML
    private TextField btn54;
    @FXML
    private TextField btn55;
    @FXML
    private TextField btn56;
    @FXML
    private TextField btn57;
    @FXML
    private TextField btn58;
    @FXML
    private TextField btn60;
    @FXML
    private TextField btn61;
    @FXML
    private TextField btn62;
    @FXML
    private TextField btn63;
    @FXML
    private TextField btn64;
    @FXML
    private TextField btn65;
    @FXML
    private TextField btn66;
    @FXML
    private TextField btn67;
    @FXML
    private TextField btn68;
    @FXML
    private TextField btn70;
    @FXML
    private TextField btn71;
    @FXML
    private TextField btn72;
    @FXML
    private TextField btn73;
    @FXML
    private TextField btn74;
    @FXML
    private TextField btn75;
    @FXML
    private TextField btn76;
    @FXML
    private TextField btn77;
    @FXML
    private TextField btn78;
    @FXML
    private TextField btn80;
    @FXML
    private TextField btn81;
    @FXML
    private TextField btn82;
    @FXML
    private TextField btn83;
    @FXML
    private TextField btn84;
    @FXML
    private TextField btn85;
    @FXML
    private TextField btn86;
    @FXML
    private TextField btn87;
    @FXML
    private TextField btn88;


    public boolean checkBoard(char[][] board){

        HashSet<String>seen = new HashSet<>();
         for(int i=0; i<9; i++){
             for(int j=0; j<9; j++){
                 char current_val = board[i][j];
                 if(current_val != '.'){
                     if(!seen.add(current_val + "found in row " + i) || !seen.add(current_val + "found in column " + j) || !seen.add(current_val + "found in submatrix " + i/3 + j/3)){
                         return false;
                     }
                 }
             }
         }
        return true;
    }

    @FXML
    void onActionReset(ActionEvent event){


        TextField[][] myTextFields = {
                {btn00, btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08},
                {btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18},
                {btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28},
                {btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38},
                {btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48},
                {btn50, btn51, btn52, btn53, btn54, btn55, btn56, btn57, btn58},
                {btn60, btn61, btn62, btn63, btn64, btn65, btn66, btn67, btn68},
                {btn70, btn71, btn72, btn73, btn74, btn75, btn76, btn77, btn78},
                {btn80, btn81, btn82, btn83, btn84, btn85, btn86, btn87, btn88},
        };

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                myTextFields[i][j].setText("0");
            }
        }
    }

    @FXML
    void onActionCheckBoard(ActionEvent event){

        TextField[][] myTextFields = {
                {btn00, btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08},
                {btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18},
                {btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28},
                {btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38},
                {btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48},
                {btn50, btn51, btn52, btn53, btn54, btn55, btn56, btn57, btn58},
                {btn60, btn61, btn62, btn63, btn64, btn65, btn66, btn67, btn68},
                {btn70, btn71, btn72, btn73, btn74, btn75, btn76, btn77, btn78},
                {btn80, btn81, btn82, btn83, btn84, btn85, btn86, btn87, btn88},
        };

        char[][] matrix = new char[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char current_val = myTextFields[i][j].getText().charAt(0);
                matrix[i][j] = current_val;
            }
        }
        if(checkBoard(matrix)){
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("WON");
            error.setContentText("YOU WON!");
            error.showAndWait();
        }
        else{
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("LOST");
            error.setContentText("Incorrect!");
            error.showAndWait();
        }
    }

    @FXML
    void onActionSolve(ActionEvent event){

        TextField[][] myTextFields = {
                {btn00, btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08},
                {btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18},
                {btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28},
                {btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38},
                {btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48},
                {btn50, btn51, btn52, btn53, btn54, btn55, btn56, btn57, btn58},
                {btn60, btn61, btn62, btn63, btn64, btn65, btn66, btn67, btn68},
                {btn70, btn71, btn72, btn73, btn74, btn75, btn76, btn77, btn78},
                {btn80, btn81, btn82, btn83, btn84, btn85, btn86, btn87, btn88},
        };

        int[][] matrix = new int[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                int current_val = Integer.valueOf(myTextFields[i][j].getText());
                matrix[i][j] = current_val;
            }
        }
        if(SolveSudoku(matrix, 9)){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.println(matrix[i][j]);
                    myTextFields[i][j].setText(Integer.toString(matrix[i][j]));
                }
                System.out.println();
            }
        }
    }

    public static boolean SolveSudoku(int[][] matrix, int n){
        int rowIndex = -1;
        int columnIndex = -1;
        int i = 0;
        int j =0;

        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                if(matrix[i][j]==0){
                    rowIndex = i;
                    columnIndex = j;
                    break;
                }
            }
            if(rowIndex != -1){
                break;
            }
        }
        if(i==n && j==n){
            return true;
        }
        else{
            for(int value=1; value<10; value++){
                if(IsSafe(matrix, value, rowIndex, columnIndex, n)){
                    matrix[rowIndex][columnIndex] = value;
                    if(!SolveSudoku(matrix,n)){
                        matrix[rowIndex][columnIndex] = 0;
                    }
                    else{
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean IsSafe(int[][] matrix, int value, int rowIndex, int columIndex, int n){

        //Check Row
        for(int j=0; j<9; j++){
            if(matrix[rowIndex][j] == value){
                return false;
            }
        }

        //Check Coulmn
        for(int i=0; i<9; i++){
            if(matrix[i][columIndex] == value){
                return false;
            }
        }

        //Check Submatrix
        int baseRowIndex = rowIndex - (rowIndex % 3);
        int baseColumnIndex = columIndex - (columIndex % 3);
        for(int i = baseRowIndex; i< baseRowIndex+3; i++){
            for(int j = baseColumnIndex; j<baseColumnIndex+3; j++){
                if(matrix[i][j]== value){
                    return false;
                }
            }
        }
        return true;
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

//    @FXML
//    public void onStartButtonClick(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("grid.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setTitle("Easy");
//        stage.setScene(scene);
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.show();
//    }


}
