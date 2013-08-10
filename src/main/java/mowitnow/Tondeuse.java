package mowitnow;

import java.util.Map;

import javax.annotation.Resource;

import mowitnow.enums.CardinalPoint;
import mowitnow.enums.Movement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe représentant une tondeuse
 */
@Component
public class Tondeuse {


    @Resource
    private Field field;

    @Resource
    private CardinalWithMovement cardinalWithMovement;

    public Tondeuse(int x, int y, CardinalPoint direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * abscise de la tondeuse sur le terrain
     */
    private int x;

    /**
     * ordonnée de la tondeuse sur le terrain
     */
    private int y;
    private CardinalPoint direction;

    /**
     * Permet de mettre à jour la position de la tondeuse
     *
     * @param direction {@link CardinalPoint}
     */
    public void updatePosition(CardinalPoint direction) {
        if (direction == null) {
            return;
        }

        switch (direction) {
            case N:
                if (field.isWithinBoundaries(this.x, this.y + 1)) {
                    this.y++;
                }
                break;
            case E:
                if (field.isWithinBoundaries(this.x + 1, this.y)) {
                    this.x++;
                }
                break;
            case W:
                if (field.isWithinBoundaries(this.x - 1, this.y)) {
                    this.x--;
                }
                break;
            case S:
                if (field.isWithinBoundaries(this.x, this.y - 1)) {
                    this.y--;
                }
                break;
            default:
                ;
        }
    }

    public void updateDirection(CardinalPoint direction) {
        if (direction == null) {
            return;
        }

        switch (direction) {
            case N:
                if (field.isWithinBoundaries(this.x, this.y + 1)) {
                    this.y++;
                }
                break;
            case E:
                if (field.isWithinBoundaries(this.x + 1, this.y)) {
                    this.x++;
                }
                break;
            case W:
                if (field.isWithinBoundaries(this.x - 1, this.y)) {
                    this.x--;
                }
                break;
            case S:
                if (field.isWithinBoundaries(this.x, this.y - 1)) {
                    this.y--;
                }
                break;
            default:
                ;
        }
    }

    public void move(Movement movement) {

        if (movement == null) {
            return;
        }

        Map<CardinalPoint, Map<Movement, CardinalPoint>> map = cardinalWithMovement.getMap();
        switch (movement) {
            case A:
                this.updatePosition(map.get(this.direction).get(Movement.A));
                break;
            case D:
                this.updateDirection(map.get(this.direction).get(Movement.D));
                break;
            case G:
                this.updateDirection(map.get(this.direction).get(Movement.G));
                break;
        }
    }

    /**
     * Affiche la position actuelle de la tondeuse
     */
    public void finalPosition() {
        System.out.println(this.x);
        System.out.println(this.y);
        System.out.println(this.direction);
    }


    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CardinalPoint getDirection() {
        return direction;
    }

    public void setDirection(CardinalPoint direction) {
        this.direction = direction;
    }

    public void setCardinalWithMovement(CardinalWithMovement cardinalWithMovement) {
        this.cardinalWithMovement = cardinalWithMovement;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tondeuse{");
        sb.append("field=").append(field);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", direction=").append(direction);
        sb.append('}');
        return sb.toString();
    }
}
