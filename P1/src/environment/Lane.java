package environment;

import java.util.ArrayList;
import java.util.Random;

import util.Case;
import gameCommons.Game;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars;
	private boolean leftToRight;
	private double density;
	private int tic = 0;

	// TODO : Constructeur(s)
	public Lane(Game game,int ord, double density) {
		this.game = game;
		this.ord = ord;
		this.speed = setvitesseAlea(0, 2);
		;
		this.leftToRight = setRandomBoolean();
		this.density = density;
		this.cars = new ArrayList<>();
		for (int i = 0; i < game.height; i++) {
			mayAddCar();
			for(Car c : cars){
				c.DeplaceVoiture();
			}
		}
	}
	public Lane (Game game ,  int ord ){
		this(game,ord, game.defaultDensity);

	}

	public void update() {
		tic++;
		if (tic == speed) {
			for (Car c : cars) {
				c.DeplaceVoiture();
			}
			tic = 0;
		} else {
			for (Car c : cars) {
				c.DeplacepasVoiture();
			}
		}
	}
		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

 public int setvitesseAlea(int Min, int Max){
	 int x = (int) (Min + (Math.random() * (Max - Min)));
	 return x;
 }
public boolean setRandomBoolean() {
	return Math.random() < 0.5;
}



	// TODO : ajout de methodes

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}
// A FAIRE //
	public boolean isSafe(Case firstCase) {
		for (Car c : cars) {
			if (firstCase != c.getLeftPosition()) {
				return true;
			}
		}
		return false;
	}





	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}
