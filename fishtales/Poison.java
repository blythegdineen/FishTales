import java.awt.*;
public class Poison extends Pellet{

	Poison(FishTank tank){
		super(tank);
		this.skinColor = StdDraw.RED;
		this.outlineColor = StdDraw.BLACK;
	}
	public boolean isDead (){
		if (age >= maxAge&& this.yPos == 0){
			return true;
		} else {
			return false;
		}
	}
}