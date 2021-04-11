package compulsory.tspGame;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Token {
    private int index;
    private int value;

    /**
     * Constructor
     * @param index
     * @param value
     */
    public Token(int index, int value) {
        this.index = index;
        this.value = value;
    }
}