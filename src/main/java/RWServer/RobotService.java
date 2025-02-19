package RWServer;

import RWServer.Entities.Robot;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rw")
public class RobotService {
    public RobotService() throws IOException {
        robots.pushFront(new Robot("1", "UwU", 1, 1, 1, 1));
        //robots.pushFront(new Robot("Kuca", 2, 2, 2, 2));
        //robots.pushFront(CreateRobot.createRobot());
    }

    UwU<Robot> robots = new UwU<>();


    @GetMapping("/createRobot")
    public void createRobot() throws IOException {
        CreateRobot.createRobot();


    }

    @PostMapping("/addNewRobot")
    public void addNewRobot(@RequestBody Robot robot) throws IOException {
        Session session = Connection.getSession().openSession();
        session.beginTransaction();

        session.save(robot);
        session.getTransaction().commit();

        Connection.closeSession(session);

        this.robots.pushFront(robot);
    }

    @GetMapping("/pop")
    public Robot removeFirstItem(@RequestParam(name = "front", defaultValue = "true") boolean fromFront) {
        if (fromFront) {
            return robots.popFront();
        } else {
            System.out.println("UwU");
            return robots.popLast();
        }
    }

    @GetMapping("/seek")
    public Robot getFirstItem() {
        return robots.get(0);
    }

    @GetMapping("/robots")
    public List<Robot> seeAllRobots() {
        Session session = Connection.getSession().openSession();
        return session.createQuery("from Robot ", Robot.class).getResultList();
    }

    @GetMapping("/robots/robot/{id}/")
    public Robot seeSpecificRobot(@PathVariable(value = "id") int id) {
        return robots.get(id);
    }

    @GetMapping
    public String sayUwU() {
        return "UwU";
    }
}

