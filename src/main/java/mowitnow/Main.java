package mowitnow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mowitnow.enums.CardinalPoint;
import mowitnow.enums.Movement;

public class Main {
    public static void main(String [] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

	    Tondeuse tondeuse1 = (Tondeuse) context.getBean("tondeuse1");
        Tondeuse tondeuse2 = (Tondeuse) context.getBean("tondeuse2");

        tondeuse1.move(Movement.G);
        tondeuse1.move(Movement.A);
        tondeuse1.move(Movement.G);
        tondeuse1.move(Movement.A);
        tondeuse1.move(Movement.G);
        tondeuse1.move(Movement.A);
        tondeuse1.move(Movement.G);
        tondeuse1.move(Movement.A);
        tondeuse1.move(Movement.A);
        
        tondeuse2.move(Movement.A);
        tondeuse2.move(Movement.A);
        tondeuse2.move(Movement.D);
        tondeuse2.move(Movement.A);
        tondeuse2.move(Movement.A);
        tondeuse2.move(Movement.D);
        tondeuse2.move(Movement.A);
        tondeuse2.move(Movement.D);
        tondeuse2.move(Movement.D);
        tondeuse2.move(Movement.A);

        tondeuse1.finalPosition();
        tondeuse2.finalPosition();
    }

}
