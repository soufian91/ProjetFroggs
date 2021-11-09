package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Case lacase;
	private Direction ladirection;

	public  Frog (Game lapartie){
		lacase = new Case(game.width/2, 0);
		ladirection = Direction.up;
	}


	@Override
	public Case getPosition() {
		return lacase;
	}

	@Override
	public Direction getDirection() {
		return ladirection;
	}

	@Override
	public void move(Direction key) {
		switch (key){
			case up:
				lacase = new Case(getPosition().absc, getPosition().ord + 1 ); // mise a jour de case
				ladirection = key;
				break;

			case down:
				lacase = new Case(getPosition().absc, getPosition().ord - 1 ); // mise a jour de case
				ladirection = key;
				break;

			case right:
				lacase = new Case(getPosition().absc +1, getPosition().ord);
				ladirection = key;
				break;

			case left:
				lacase =  new Case(getPosition().absc -1, getPosition().ord);
				ladirection = key;
				break;

		}

	}
}
