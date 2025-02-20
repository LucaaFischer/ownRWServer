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
    }

    @GetMapping("/robots")
    public List<Robot> seeAllRobots() {
        Session session = Connection.getSession().openSession();
        return session.createQuery("from Robot ", Robot.class).getResultList();
    }

    @GetMapping("/robots/robot/{id}")
    public Robot seeSpecificRobot(@PathVariable(value = "id") String uid) {
        Session session = Connection.getSession().openSession();
        System.out.println(uid);
        return session.createQuery("from Robot r where r.id = :id", Robot.class).setParameter("id", uid).getSingleResult();
    }
}

