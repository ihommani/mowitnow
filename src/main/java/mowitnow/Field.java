package mowitnow;

import org.springframework.stereotype.Component;

@Component
public class Field {
	
	
	public Field(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int x;
	private int y;
	
	public boolean isWithinBoundaries(int x, int y){
		return x > -1 && x < this.x + 1 && y > -1  && y < this.y + 1;
		
	}

}
