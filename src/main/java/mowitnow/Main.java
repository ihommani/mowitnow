package mowitnow;

import mowitnow.enums.CardinalPoint;
import mowitnow.enums.Movement;

public class Main {

    public static void main(String [] args) {
        Tondeuse tondeuse1 = new Tondeuse(1, 2, CardinalPoint.N);
        Tondeuse tondeuse2 = new Tondeuse(3, 3, CardinalPoint.E);

        tondeuse1.move(Movement.G);
        tondeuse1.move(Movement.A);
        tondeuse1.move(Movement.G);
        tondeuse1.move(Movement.A);
        tondeuse1.move(Movement.G);
        tondeuse1.move(Movement.A);
        tondeuse1.move(Movement.G);
        tondeuse1.move(Movement.A);
        tondeuse1.move(Movement.A);

        tondeuse1.finalPosition();



    }

}
