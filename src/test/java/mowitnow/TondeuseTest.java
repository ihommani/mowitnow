package mowitnow;

import mowitnow.enums.CardinalMovement;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Test;

public class TondeuseTest {

	private final int X_POSITION = 0;
	private final int Y_POSITION = 0;

	@Mock
	CardinalWithMovement cardinalWithMovement;

	@InjectMocks
	Tondeuse tondeuse = new Tondeuse(X_POSITION, Y_POSITION, CardinalMovement.N);

	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shoud_move(){
		//tondeuse.move(Movement.A);
	}

}
