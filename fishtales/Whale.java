import java.awt.*;
public class Whale extends Fish{

	Whale(FishTank tank, String name){
		super(tank, name);
		this.maxSpeed = 1;
		this.maxAge = 30000;
		this.maxSize = StdRandom.gaussian(100,.2*100);;
		
		this.size = StdRandom.gaussian(30,1);
		this.xVel = StdRandom.gaussian(.5,.1);
		this.yVel = StdRandom.gaussian(.5,.1);
		int col = StdRandom.uniform(50)+100;
		this.skinColor = new Color (col,col,col);

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
				} else if (t instanceof Bubble) {
					this.tank.remove(t);
					return true;
				} else if (t instanceof Piranha) {
					this.tank.remove(t);
					this.size +=t.getSize()*0.05;
					return true;
				} else if (t instanceof Whale) {
					this.changeDirection();
					t.changeDirection();
					this.tank.add(new Bubble(this.tank));
					this.xPos += this.xVel;
					this.yPos += this.yVel;
					return false;
				} else if (t instanceof Goldfish || t instanceof ToroidalFin) {
						this.size += t.getSize()*0.05;
						this.tank.remove(t);
						return true;
				} else {return false;}
		} else {return false;}
	}

	void bounce(){
			if (xPos+size> tank.getLength() || xPos-size < 0) {
				xVel *= -(StdRandom.uniform(0.5,.1));
			} else if (yPos+size> tank.getWidth() || yPos-size < 0) {
				yVel *= -(StdRandom.uniform(0.5,.1));;
			}	
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
			this.bounce();
			
		}
		this.xPos+=this.xVel;
		this.yPos+=this.yVel;
	}
}