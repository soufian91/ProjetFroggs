package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class Environment implements IEnvironment {
    private ArrayList<Lane> lesvoies = new ArrayList<>();
    private Game mapartie;

    public Environment(Game game) {
        this.mapartie = game;
    }

    @Override
    public boolean isSafe(Case c) {
        return false;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return false;
    }

    @Override
    public void update() {
        for (Lane laligne : lesvoies) {
            laligne.update();

        }
    }
}
