package environment;

import java.awt.Color;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	public Car(Game game, Case beforeFirstCase, boolean leftToRight) {
		this.game = game;
		this.leftPosition = beforeFirstCase;
		this.leftToRight = leftToRight;
		this.length = Taillevoiturealeatoire(1,2);
	}



	public Case getLeftPosition() {
		return leftPosition;
	}

	//TODO Constructeur(s)
	public void DeplaceVoiture(){
		if (leftToRight){
			leftPosition = new Case (getLeftPosition().absc+1,getLeftPosition().ord);
			this.addToGraphics();
		}else {
			leftPosition = new Case (getLeftPosition().absc-1,getLeftPosition().ord);
			this.addToGraphics();
		}
	}
	public void DeplacepasVoiture(){

		this.addToGraphics();
		}

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
	private void addToGraphics() {
		for (int i = 0; i < length-1; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
