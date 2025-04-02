package RWServer.Services;

import RWServer.Entities.RWMap;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rw")
public class MapService {
    @GetMapping("/maps")
    public List<RWMap> seeAllMaps() {
        Session session = Connection.getSession().openSession();
        return session.createQuery("from Maps ", RWMap.class).getResultList();
    }

    @GetMapping("/maps/map/{id}")
    public RWMap seeSpecificMap(@PathVariable(value = "id") String mapId) {
        Session session = Connection.getSession().openSession();
        System.out.println(mapId);
        return session.createQuery("from Maps m where m.id = :id", RWMap.class).setParameter("id", mapId).getSingleResult();
    }
}
