import java.awt.*;
public class ToroidalFin extends Fish{

	ToroidalFin(FishTank tank, String name){
		super(tank, name);
		this.maxSpeed = 3;
		this.maxAge = 20000;
		this.maxSize = StdRandom.gaussian(30,.2*30);
		
		this.size = StdRandom.gaussian(10,1);
		this.xVel = StdRandom.gaussian(1.5,.2*1.5);
		this.yVel = StdRandom.gaussian(1.5,.2*1.5);
		this.skinColor = new Color (StdRandom.uniform(50)+200, StdRandom.uniform(100)+150, StdRandom.uniform(20));
		this.outlineColor = StdDraw.YELLOW;

	}

	boolean tryToEat (Tankable t){
		if(isDead() == false){
			if (t instanceof Food) {
				this.size += t.getSize()*0.05;
				this.tank.remove(t);
				return true;
			} else if (t instanceof Poison) {
				this.size -= t.getSize()*0.05;
				this.tank.remove(t);
				return true;
			} else if (t instanceof Bubble){
				this.tank.remove(t);
				return true;
			} else if (t instanceof Goldfish || t instanceof ToroidalFin) {
				this.changeDirection();
				t.changeDirection();
				this.xPos += this.xVel;
				this.yPos += this.yVel;
				return false;
			} else {
				return false;
			}
		} else {return false;}
	}


	void move(){
		if(isDead() == true){
			this.xVel = 0;
			if(yPos<tank.getWidth()-5){
				this.yVel = 2;
			} else {
				this.yVel = 0; 
			}
			
		} else {
			if(xPos>tank.getLength()){
				xPos = 0;
			} else if(yPos>tank.getWidth() ){
				yPos = 0;
			}
		}

		this.xPos+=this.xVel;
		this.yPos+=this.yVel;
	}
}