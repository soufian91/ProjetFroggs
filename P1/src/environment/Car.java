package environment;

import java.awt.Color;

import gameCommons.Case;
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
	}


	public Case getLeftPosition() {
		return leftPosition;
	}

	//TODO Constructeur(s)
	public void DeplaceVoiture(){
		if (leftToRight){
			Case pos = new Case (getLeftPosition().absc+1,getLeftPosition().ord);
		}else {
			Case pos = new Case (getLeftPosition().absc-1,getLeftPosition().ord);
		}
	}
	//TODO : ajout de methodes

	
	
	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
