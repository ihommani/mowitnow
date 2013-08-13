package mowitnow;

import java.util.Map;

import org.springframework.stereotype.Component;

import mowitnow.enums.CardinalPoint;
import mowitnow.enums.Movement;

/**
 * CardinalWithMovement - Map associant un point cardinal ({@link CardinalPoint}) avec une map associant {@link Movement}:{@link CardinalPoint}<br/>
 * Permet de donner à la tondeuse la bonne orientation. Par exemple si la tondeuse est orienté vers le nord, tourner à gauche signifie que son orientation devient ouest.
 * <br/>. Est si la tondeuse était orienté vers le Sud. ...
 *
 * @author ihommani
 * @version $Id: File Header.java 143213 09/08/13 21:05
 */
@Component
public class CardinalWithMovement {

    private Map<CardinalPoint, Map<Movement, CardinalPoint>> map;

    public void setMap(Map<CardinalPoint, Map<Movement, CardinalPoint>> map) {
        this.map = map;
    }

    public Map<CardinalPoint, Map<Movement, CardinalPoint>> getMap() {
        return this.map;
    }
}
