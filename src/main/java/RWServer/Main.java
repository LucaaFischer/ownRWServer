package RWServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("RWServer.Entities.")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
