package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class Client {
    public Gson gson = new GsonBuilder().create();

    public PrintWriter writer;
    public Response response;
    public Request request;
    public Scanner reader;
    public Socket toServer;
    public int port = 6000;

    public Client(){}

    public Response sendRequest(Map<String, String> headers, Map<String, Object> body) throws IOException {
            toServer = new Socket("localhost", port);
            writer = new PrintWriter(toServer.getOutputStream());
            reader = new Scanner(toServer.getInputStream());
            request = new Request(headers, body);
            System.out.println(gson.toJson(request));
            writer.println(gson.toJson(request));
            writer.flush();
            Type type = new TypeToken<Response>() {
            }.getType();
            response = gson.fromJson(reader.nextLine(), type);
            writer.close();
            reader.close();
            toServer.close();

            if(response.success == false){
                throw new IOException(response.message);
            }

            return response;
    }

    public SudokuTemplate getTemplateByDifficulty(String difficulty) throws IOException {
        String command = "templateByDifficulty";

        Map<String, String> headers = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("difficulty", difficulty);
        headers.put("action", command);

        response = sendRequest(headers, body);

        return response.sudokuTemplate;
    }

    public SudokuTemplate handleSolveSudoku(SudokuTemplate sudokuTemplate) throws IOException {
        String command = "solveSudoku";

        Map<String, String> headers = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("grid", sudokuTemplate.getGrid());
        body.put("difficulty", "null");
        body.put("id", "null");
        headers.put("action", command);

        response = sendRequest(headers, body);

        return response.sudokuTemplate;
    }


}
