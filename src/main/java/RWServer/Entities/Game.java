package RWServer.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Game")
@Table(name="Game")
public class Game {
    @Column(name = "gameId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String gameId;
    @ManyToOne
    @JoinColumn(name = "mapId", nullable = false)
    private RWMap map;
    @Column(name = "moves")
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Moves> moves = new ArrayList<Moves>();

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public RWMap getMap() {
        return map;
    }

    public void setMap(RWMap map) {
        this.map = map;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void addMove(Moves move) {
        this.moves.add(move);
        move.setGame(this);
    }
}
