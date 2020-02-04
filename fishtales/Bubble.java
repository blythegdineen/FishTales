import java.awt.*;
public class Bubble extends Pellet{

	Bubble(FishTank tank){
		super(tank);
		this.skinColor = StdDraw.CYAN;
		this.outlineColor = StdDraw.YELLOW;
		this.yPos = StdRandom.uniform((int)tank.getWidth());
	}
	public boolean isDead (){
		if (this.yPos == tank.getWidth()){
			this.tank.remove(this);
			return true;
		} else {
			return false;
		}
	}

}