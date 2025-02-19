package RWServer.Entities;

import jakarta.persistence.*;

@Entity(name = "MapItem")
@Table(name = "map_item")
public class MapItem {
    @Column(name = "map_item_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "type")
    private MapItemType type;
    @Column(name = "index")
    private int index;
    @ManyToOne
    @JoinColumn(name="map_id", nullable=false)
    private RWMap map;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MapItemType getType() {
        return type;
    }

    public void setType(MapItemType type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public RWMap getMap() {
        return map;
    }

    public void setMap(RWMap map) {
        this.map = map;
    }
}