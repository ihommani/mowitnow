package mowitnow;

import org.springframework.stereotype.Component;

/**
 * Classe représentant un terrain à tondre
 */
@Component
public final class Field {
    /**
     * Absice du coin supérieur droit du terrain
     */
    private final int x;

    /**
     * Ordonné du coin supérieur droit du terrain
     */
    private final int y;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Méthode indiquant si le point de coordonnée (x, y) est à l'intérieur du terrain
     *
     * @param x
     * @param y
     *
     * @return boolean
     */
    public boolean isWithinBoundaries(int x, int y) {
        return x > -1 && x < this.x + 1 && y > -1 && y < this.y + 1;
    }
}
