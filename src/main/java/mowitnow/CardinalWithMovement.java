package mowitnow;

import java.util.Map;

import org.springframework.stereotype.Component;

import mowitnow.enums.CardinalMovement;
import mowitnow.enums.Movement;

/**
 * CardinalWithMovement - Map associant un point cardinal ({@link CardinalMovement}) avec une map associant {@link Movement}:{@link CardinalMovement}<br/>
 * Permet de donner à la tondeuse la bonne orientation. Par exemple si la tondeuse est orienté vers le nord, tourner à gauche signifie que son orientation devient ouest.
 * <br/>. Est si la tondeuse était orienté vers le Sud. ...
 *
 * @author ihommani
 * @version $Id: File Header.java 143213 09/08/13 21:05
 */
@Component
public class CardinalWithMovement {

    private Map<CardinalMovement, Map<Movement, CardinalMovement>> map;

    public void setMap(Map<CardinalMovement, Map<Movement, CardinalMovement>> map) {
        this.map = map;
    }

    public Map<CardinalMovement, Map<Movement, CardinalMovement>> getMap() {
        return this.map;
    }
}
