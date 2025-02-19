package RWServer.Entities;

import jakarta.persistence.*;

@Entity(name = "MovementType")
@Table(name = "MovementType")
public enum MovementType {
    @Column(name = "ATTACK")
    ATTACK("ATTACK"),
    @Column(name = "MOVE")
    MOVE("MOVE"),
    @Column(name = "ALIGN")
    ALIGN("ALIGN"),
    @Column(name = "END")
    END("END");

    private final String value;

    MovementType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /*public static MovementType fromValue(String input) {
        for (MovementType b : MovementType.values()) {
            if (b.value.equals(input)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public MovementType read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return MovementType.fromValue((String) (value));
    }*/
}

