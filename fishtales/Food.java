import java.awt.*;
public class Food extends Pellet{

	Food(FishTank tank){
		super(tank);
		this.skinColor = StdDraw.GREEN;
		this.outlineColor = StdDraw.YELLOW;
	}
	public boolean isDead (){
		if (age >= maxAge && this.yPos == 0){
			return true;
		} else {
			return false;
		}
	}
}