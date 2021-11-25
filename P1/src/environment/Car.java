package environment;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

import java.awt.*;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	public Car(Game game, Case pos, boolean leftToRight) {
		this.game = game;
		this.leftToRight = leftToRight;
		this.length = Taillevoiturealeatoire(1,2);
		if (leftToRight) {
			this.leftPosition = new Case(pos.absc - this.length, pos.ord);
		} else {
			this.leftPosition = new Case(pos.absc, pos.ord);
		}
	}



	public Case getLeftPosition() {
		return leftPosition;
	}

	//TODO Constructeur(s)


	//TODO : ajout de methodes

	public int Taillevoiturealeatoire(int Min , int Max){
		int x = (int) (Min + (Math.random() * (Max - Min)));
	 return x;
		
	}

	/*public void removeToGraphics(){
		if(leftToRight){
		if(getLeftPosition().absc >game.width ){
			this.remove();
		}
	}else{
		if(getLeftPosition().absc < 0){
			this.remove();
		}
	  }
	}
	*/
	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	public void addToGraphics() {
		for (int i = 0; i < length-1; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}
	public void deplaceVoiture(){
		if (this.leftToRight ){
			this.leftPosition = new Case (this.leftPosition.absc+1 , this.leftPosition.ord);
			this.addToGraphics();
		}else {
			this.leftPosition = new Case (this.leftPosition.absc-1 , this.leftPosition.ord);
			this.addToGraphics();
		}
	}
	public void deplacepasVoiture(){

		this.addToGraphics();
	}

}
