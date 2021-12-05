package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	protected Game game;
	protected Case position;
	protected Direction direction;

	public  Frog (Game lapartie){
		game = lapartie;
		position = new Case(game.width/2, 0);
		direction = Direction.up;
	}


	@Override
	public Case getPosition() {

		return position;
	}

	@Override
	public Direction getDirection() {

		return direction;
	}

	@Override
	public void move(Direction key) {
		switch (key){
			case up:
				position = new Case(getPosition().absc, getPosition().ord + 1 ); // mise a jour de case
				direction = key;
				break;

			case down:
				position = new Case(getPosition().absc, getPosition().ord - 1 ); // mise a jour de case
				direction = key;
				break;

			case right:
				position = new Case(getPosition().absc +1, getPosition().ord);
				direction = key;
				break;

			case left:
				position =  new Case(getPosition().absc -1, getPosition().ord);
				direction = key;
				break;

		}

	}
}
