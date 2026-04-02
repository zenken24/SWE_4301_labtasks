package server;

import javax.xml.ws.Endpoint;
import service.UserServiceImpl;

public class Server {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/userService", new UserServiceImpl());
        System.out.println("Service running at http://localhost:8080/userService?wsdl");
    }
}