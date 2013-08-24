package mowitnow;

import java.util.Map;

import mowitnow.enums.CardinalMovement;
import mowitnow.enums.Movement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe représentant une tondeuse
 *
 * @author ihommani
 */
@Component
public class Tondeuse {

    public Tondeuse() {
		super();
	}

	private static Logger LOGGER = LoggerFactory.getLogger(Tondeuse.class);

    @Autowired
    private Field field;

    @Autowired
    private CardinalWithMovement cardinalWithMovement;

    public Tondeuse(int x, int y, CardinalMovement direction) {
        this.coordinate = new Coordinate(x, y);
        this.direction = direction;
    }
    
    private Coordinate coordinate;

    private CardinalMovement direction;


    /**
     * Permet de 'bouger' la tondeuse. <br/>
     * 'Bouger' signifie, faire une rotation ou avancer selon le mouvement que l'on donne en entrée.
     *
     * @param movement {@link Movement}
     */
    public void move(Movement movement) {

        if (movement == null) {
            return;
        }

        Map<CardinalMovement, Map<Movement, CardinalMovement>> map = cardinalWithMovement.getMap();
        switch (movement) {
            case A: // Seul le mouvement avancer provoque une mise à jour des coordonées de la tondeuse
                this.updatePosition(map.get(this.direction).get(movement));
                break;
            case D:
            case G: // Gauche ou droite provoque une mise à jour de l'orientation/direction de la tondeuse
                this.updateDirection(map.get(this.direction).get(movement));
                break;
           default:
        	   break;
        }
    }

    /**
     * Permet de mettre à jour la position de la tondeuse
     *
     * @param direction {@link CardinalMovement}
     */
    private void updatePosition(CardinalMovement direction) {
    	if (direction == null) {
    		return;
    	}
    	direction.setField(field);
    	direction.move(this.coordinate);
    }
    
    /**
     * Permet de mettre à jour la direction de la tondeuse
     *
     * @param direction
     */
    private void updateDirection(CardinalMovement direction) {
    	if (direction == null) {
    		return;
    	}
    	this.direction = direction;
    }
    
    /**
     * Affiche la position actuelle de la tondeuse
     */
    public void finalPosition() {
        System.out.println(this.coordinate.x);
        System.out.println(this.coordinate.y);
        System.out.println(this.direction);
    }

    public void setField(Field field) {
        this.field = field;
    }

    public int getX() {
        return coordinate.x;
    }

    public int getY() {
        return coordinate.y;
    }

    public CardinalMovement getDirection() {
        return direction;
    }

    public void setDirection(CardinalMovement direction) {
        this.direction = direction;
    }

    public void setCardinalWithMovement(CardinalWithMovement cardinalWithMovement) {
        this.cardinalWithMovement = cardinalWithMovement;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tondeuse{");
        sb.append("field=").append(field);
        sb.append(", x=").append(coordinate.x);
        sb.append(", y=").append(coordinate.y);
        sb.append(", direction=").append(direction);
        sb.append('}');
        return sb.toString();
    }
}
