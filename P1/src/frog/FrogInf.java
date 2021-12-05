package frog;
import util.Case;
import util.Direction;
import gameCommons.EnvInf;
import gameCommons.Game;

public class FrogInf extends Frog {
    private EnvInf environment;
    private int score;

    public FrogInf(Game game) {
        super(game);
        this.score = 0;

    }

    public int getScore() {
        return this.score;
    }
    public void move(Direction key) {
        if( key == Direction.up ) {
            this.score++;
            game.environmentUp();
        } else if( key == Direction.down ) {
            if( this.score > 0 ) {
                this.score--;
                game.environmentDown();
            }
        } else if ( key == Direction.left ) {
            if(this.position.absc-1 >= 0) {
                this.position = new Case( this.position.absc-1, this.position.ord );
            }
        } else if( key == Direction.right ) {
            if( this.position.absc+1 < game.width ) {
                this.position = new Case( this.position.absc+1, this.position.ord );
            }
        }
        this.direction = key;
    }
}
