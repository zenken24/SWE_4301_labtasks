package client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class SoapClient {

    private static final String SERVICE_URL = "http://localhost:8080/userService";

    private static String sendRequest(String soapAction, String xml) throws Exception {
        URL url = new URL(SERVICE_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        conn.setRequestProperty("SOAPAction", soapAction);

        OutputStream os = conn.getOutputStream();
        os.write(xml.getBytes());
        os.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            response.append(line);
        }

        br.close();
        return response.toString();
    }

    // CREATE
    public static void createUser(String username, int id, String password) throws Exception {
        String xml = "<?xml version=\"1.0\"?>"
                + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "xmlns:web=\"http://webservice/\">"
                + "<soapenv:Body>"
                + "<web:createUser>"
                + "<arg0>" + username + "</arg0>"
                + "<arg1>" + id + "</arg1>"
                + "<arg2>" + password + "</arg2>"
                + "</web:createUser>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";

        System.out.println(sendRequest("createUser", xml));
    }

    // RETRIEVE
    public static void getUser(int id) throws Exception {
        String xml = "<?xml version=\"1.0\"?>"
                + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "xmlns:web=\"http://webservice/\">"
                + "<soapenv:Body>"
                + "<web:getUser>"
                + "<arg0>" + id + "</arg0>"
                + "</web:getUser>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";

        System.out.println(sendRequest("getUser", xml));
    }

    // UPDATE
    public static void updateUser(int id, String username, String password) throws Exception {
        String xml = "<?xml version=\"1.0\"?>"
                + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "xmlns:web=\"http://webservice/\">"
                + "<soapenv:Body>"
                + "<web:updateUser>"
                + "<arg0>" + id + "</arg0>"
                + "<arg1>" + username + "</arg1>"
                + "<arg2>" + password + "</arg2>"
                + "</web:updateUser>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";

        System.out.println(sendRequest("updateUser", xml));
    }

    // DELETE
    public static void deleteUser(int id) throws Exception {
        String xml = "<?xml version=\"1.0\"?>"
                + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "xmlns:web=\"http://webservice/\">"
                + "<soapenv:Body>"
                + "<web:deleteUser>"
                + "<arg0>" + id + "</arg0>"
                + "</web:deleteUser>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";

        System.out.println(sendRequest("deleteUser", xml));
    }

    public static void main(String[] args) throws Exception {
        createUser("Zen", 1, "1234");
        getUser(1);
        updateUser(1, "ZenUpdated", "9999");
        deleteUser(1);
    }
}
