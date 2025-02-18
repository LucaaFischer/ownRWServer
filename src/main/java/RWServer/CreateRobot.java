package RWServer;

import RWServer.Entities.Robot;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CreateRobot {
    public static Robot createRobot() throws IOException {
        Session session = Connection.openSession();
        session.beginTransaction();

        Robot newBot = getStatsForRobot();
        session.save(newBot);
        session.getTransaction().commit();

        Connection.closeSession(session);

        //Serialize the RobotEntitiy object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(newBot);


        URL url = new URL("http://localhost:8080/rw/addNewRobot");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        // Write the JSON data to the request body
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = json.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Get the response from the server
        int statusCode = connection.getResponseCode();
        System.out.println("Response Code: " + statusCode);
        return newBot;
    }


    public static Robot getStatsForRobot() {
        Scanner input = new Scanner(System.in);
        Robot newRobot = new Robot();

        System.out.println("Name: ");
        newRobot.setName(input.nextLine());
        System.out.println("AD: ");
        newRobot.setDamage(input.nextInt());
        System.out.println("HP: ");
        newRobot.setHp(input.nextInt());
        System.out.println("MovementRate: ");
        newRobot.setMovement(input.nextInt());
        System.out.println("Range: ");
        newRobot.setRange(input.nextInt());

        return newRobot;
    }
}
