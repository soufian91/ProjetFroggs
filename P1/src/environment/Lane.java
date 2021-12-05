package environment;

import gameCommons.Game;
import util.Case;

import java.util.ArrayList;

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
		this.speed = setvitesseAlea();
		this.leftToRight = setRandomBoolean();
		this.density = density;
		this.cars = new ArrayList<>();
		for (int i = 1; i < game.height-1; i++) {
			mayAddCar();
			for(Car voiture : cars){
				voiture.deplaceVoiture();
			}
		}
	}
	public Lane (Game game ,  int ord ){
		this(game,ord, game.defaultDensity);

	}
	public ArrayList<Car> getCars() {
		return this.cars;
	}

	public void update() {
		tic++;
		if (tic >= speed) {
			for (Car voiture : cars) {
				voiture.deplaceVoiture();

				
			}
			mayAddCar();
			tic = 0;
		}
		for (Car voiture : cars) {
			voiture.addToGraphics();

			}
		}

		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

 public int setvitesseAlea(){
	 return game.randomGen.nextInt(2)+1;
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
	public boolean isSafe(Case lacase) {
		for (Car voiture : cars) {
			if (voiture.casevoiutreegalcasefrog(lacase)) {
				return false;
			}
		}
		return true;
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
	public void orderUp() {
		this.ord = ord +1;
	}

	public void orderDown() {
		this.ord = ord -1;
	}

	public int getOrd() {
		return this.ord;
	}

	public void changeOrd() {
		this.ord = 0;
	}


}
