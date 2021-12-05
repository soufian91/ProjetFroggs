package gameCommons;
import environment.Car;
import environment.Environment;
import environment.Lane;
import frog.FrogInf;

import java.util.ArrayList;

public class EnvInf extends Environment{
    private ArrayList<Lane>oldLane;

    public EnvInf(Game game, FrogInf frog) {
        super(game, frog);
        this.oldLane = new ArrayList<Lane>();
    }
    public void moveUp() {
        for( Lane l : lesvoies ) {
            l.orderDown();
            for( Car voiture : l.getCars() ) {
                voiture.orderDown();
            }
        }
        oldLane.add(lesvoies.get(0));
        lesvoies.remove(0);

        lesvoies.add(new Lane(this.getGame(), lesvoies.size(), 0));
    }

    public void upDateOldLane() {
        for( Lane l : oldLane ) {
            l.changeOrd();
            for( Car voiture : l.getCars() ) {
                voiture.changeOrd();
            }
        }
    }
    public void moveDown() {
        ArrayList<Lane> res  = new ArrayList<Lane>();
        upDateOldLane();
        //System.out.println( oldLane.get(oldLane.size()-1).getOrd() );
        res.add(oldLane.get(oldLane.size()-1));
        oldLane.remove(oldLane.get(oldLane.size()-1));
        for( Lane l : lesvoies ) {
            l.orderUp();
            for( Car voiture : l.getCars() ) {
                voiture.orderUp();
            }
            if( l.getOrd() < 20 ) {
                res.add(l);
            }
        }
        this.lesvoies = res;
    }

}
