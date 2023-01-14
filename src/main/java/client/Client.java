package client;

import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class Client {
    public Gson gson = new GsonBuilder().create();
    ;
    public PrintWriter writer;
    public Response response;
    public Request request;
    public Scanner reader;
    public Socket toServer;
    public int port = 6000;

    public Response sendRequest(Map<String, String> headers, Map<String, String> body) {
        try {
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
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Response("Error");

    }
}
