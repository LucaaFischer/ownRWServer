package RWServer;

public class Robot {
    private String id;
    private String name;
    private int range;
    private int movement;
    private int hp;
    private int damage;

    public Robot() {
    }

    public Robot(String id, String name, int range, int movement, int hp, int damage) {
        this.id = id;
        this.name = name;
        this.range = range;
        this.movement = movement;
        this.hp = hp;
        this.damage = damage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
