package mowitnow;

import mowitnow.enums.CardinalMovement;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CardinalMovementTest {

	private final Field field = new Field(5, 5);

	@Test(dataProvider = "coordonates")
	public void should_update_coordonates(CardinalMovement cardinalMovement, Coordinates coordinates) {
		cardinalMovement.setField(field);
		cardinalMovement.move(coordinates.coordinate);
		Assertions.assertThat(coordinates.coordinate.x).isEqualTo(coordinates.updated_x);
		Assertions.assertThat(coordinates.coordinate.y).isEqualTo(coordinates.updated_y);
	}

	@DataProvider
	public Object[][] coordonates() {
		return new Object[][] { 
				{ CardinalMovement.N, new Coordinates(1, 1, 1, 2) },
				{ CardinalMovement.E, new Coordinates(1, 1, 2, 1) },
				{ CardinalMovement.W, new Coordinates(1, 1, 0, 1) },
				{ CardinalMovement.S, new Coordinates(1, 1, 1, 0) },
				};
	}

	private class Coordinates {

		final Coordinate coordinate;
		int updated_x;
		int updated_y;

		public Coordinates(int x, int y, int updated_x, int updated_y) {
			this.coordinate = new Coordinate(x, y);
			this.updated_x = updated_x;
			this.updated_y = updated_y;
		}
	}

}
