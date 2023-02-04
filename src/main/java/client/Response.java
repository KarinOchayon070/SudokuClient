package client;

public class Response {

    public boolean success = true;
    public String message;
    public SudokuTemplate sudokuTemplate;

    public Response(){}

    public Response(SudokuTemplate sudokuTemplate){
        this.sudokuTemplate = sudokuTemplate;
    }

    public Response(String string, boolean isSuccess){
        this.message = string;
        this.success = isSuccess;
    }
}
