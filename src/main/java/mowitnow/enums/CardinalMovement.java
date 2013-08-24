package mowitnow.enums;

import mowitnow.Coordinate;
import mowitnow.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public enum CardinalMovement {

	N {
		@Override
		public void move(Coordinate coordinate) {
			if (field.isWithinBoundaries(coordinate.x, coordinate.y + 1)) {
				coordinate.y++;
				LOGGER.debug("Moving to north");
			}
		}
	},
	E {
		@Override
		public void move(Coordinate coordinate) {
			if (field.isWithinBoundaries(coordinate.x + 1, coordinate.y)) {
				coordinate.x++;
				LOGGER.debug("Moving to east");
			}
		}
	},
	W {
		@Override
		public void move(Coordinate coordinate) {
			if (field.isWithinBoundaries(coordinate.x - 1, coordinate.y)) {
				coordinate.x--;
				LOGGER.debug("Moving to west");
			}
		}
	},
	S {
		@Override
		public void move(Coordinate coordinate) {
			if (field.isWithinBoundaries(coordinate.x, coordinate.y - 1)) {
				coordinate.y--;
				LOGGER.debug("Moving to south");
			}
		}
	};

	/**
	 * Permet de bouger un objet ayant pour coordonnées cartésiennes (x, y)
	 * 
	 * @param x
	 * @param y
	 */
	public abstract void move(Coordinate coordinate);
	
	/**
	 * Renvoie la direction/orientation d'un objet
	 */
	//public abstract CardinalMovement determineDirection();

	Field field;

	public void setField(Field field) {
		this.field = field;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(CardinalMovement.class);
}
