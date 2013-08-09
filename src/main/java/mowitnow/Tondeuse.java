package mowitnow;

import mowitnow.CardinalPoint;

public class Tondeuse {
	
	Field field;
	
	public Tondeuse(int x, int y, CardinalPoint direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	private int x;
	private int y;
	private CardinalPoint direction;
	
	
	public void move(CardinalPoint direction){
		switch(direction){
		case N:
			if(field.isWithinBoundaries(this.x, this.y + 1)){
				this.y++;	
			}
			break;
		case E:
			if(field.isWithinBoundaries(this.x + 1, this.y)){
				this.x++;
			}
			break;
		case W:
			if(field.isWithinBoundaries(this.x - 1, this.y)){
			}
			this.x--;
			break;
		case S:
			if(field.isWithinBoundaries(this.x, this.y - 1)){
				this.y--;
			}
			break;
		default:
			;
		}
	}
	
	public void finalPosition(){
		System.out.println("");
	}
	
	
	
		
	

}
