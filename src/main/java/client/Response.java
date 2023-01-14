package client;

public class Response {

    public String json;
    public SudokuTemplate sudokuTemplate;

    public Response() {
    }

    public Response(SudokuTemplate sudokuTemplate) {
        this.sudokuTemplate = sudokuTemplate;
    }

    public Response(String string){
        json = string;
    }

}
