package RWServer.Entities;

import jakarta.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Move")
@Table(name = "move")
public class Moves {
    @Column(name = "move_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;
    @Enumerated(EnumType.STRING)
    private MovementType moveType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public MovementType getMoveType() {
        return moveType;
    }

    public void setMoveType(MovementType moveType) {
        this.moveType = moveType;
    }
}
