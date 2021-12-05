package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;
import frog.FrogInf;

import java.util.ArrayList;

public class Environment implements IEnvironment {
    protected ArrayList<Lane> lesvoies = new ArrayList<>();
    protected Game game;
    protected FrogInf frog;

    public Environment(Game game,FrogInf frog) {
        this.game = game;
        this.frog = frog;
        lesvoies.add(new Lane(game,0,0));
        lesvoies.add(new Lane(game, game.height,0));
        for (int i = 1; i < game.height -1  ;i++){
            Lane l = new Lane(game,i);
            lesvoies.add(l);
        }

    }

    @Override
    public boolean isSafe(Case c) {
        for (Lane l : lesvoies){
            if (!(l.isSafe(c))){
                return false;
            }
        }return true;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        if (c.ord == game.height) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void update() {
        for (Lane laligne : lesvoies) {
            laligne.update();

        }

    }
    public Game getGame() {
        return this.game;
    }
}
