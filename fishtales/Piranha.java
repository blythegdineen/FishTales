public class Piranha extends Fish{

	Piranha(FishTank tank, String name){
		super(tank, name);
		this.maxSpeed = 2;
		this.maxAge = 10000;
		this.maxSize = StdRandom.gaussian(50,.2*50);;
		
		this.size = StdRandom.gaussian(20,1);
		this.xVel = StdRandom.gaussian(1,.2);
		this.yVel = StdRandom.gaussian(1,.2);
		int col = StdRandom.uniform(3);
		if(col == 0){
			this.skinColor = StdDraw.MAGENTA;
		} else if(col ==1){
			this.skinColor = StdDraw.GREEN;
		} else if(col ==2 ){
			this.skinColor = StdDraw.ORANGE;
		}else {
			this.skinColor = StdDraw.PINK;
		}

	}
	boolean tryToEat (Tankable t){
		if(isDead() == false){
			if(t.isDead() == false && (t instanceof Food || t instanceof Poison || t instanceof Bubble)){
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
					} else {return false;}
			} else if (t instanceof Piranha || t instanceof Whale || t instanceof Goldfish || t instanceof ToroidalFin){
						 if (t instanceof Piranha) {
							if(t.getSize()<this.size){
								this.tank.remove(t);
								this.size +=t.getSize()*0.05;
							}
							return true;
						} else if (t instanceof Whale) {
							if(t.getSize()<this.size){
								this.tank.remove(t);
								this.size +=t.getSize()*0.05;
							}
							return true;
						} else if (t instanceof Goldfish || t instanceof ToroidalFin) {
							this.size += t.getSize()*0.05;
							this.tank.remove(t);
							return true;
						} else {
							return false;
						}
			} else {return false;}
		} else {return false;}
	}

	void chaseGoldfish (){
		double dist = Double.POSITIVE_INFINITY;
		int index = 0;
		for (int i = 0; i<tank.getSize(); i++){
			if(tank.getItem(i) instanceof Goldfish){
				double xDis = Math.pow(this.xPos - tank.getItem(i).getX(),2);
				double yDis = Math.pow(this.yPos - tank.getItem(i).getY(),2);
				double magn = Math.sqrt(yDis+xDis);
				if(magn < dist){
					dist = magn;
					index = i;
				}
			}
		}
		if (index == 0 && (this.tank.getItem(0) instanceof Goldfish) == false) {} 
		else {
			double run = tank.getItem(index).getX() - this.xPos;
			double rise = tank.getItem(index).getY() - this.yPos;
			this.xVel = run/(dist/2);
			this.yVel = rise/(dist/2);
		}
	}

	void bounce(){
			if (xPos+size> tank.getLength() || xPos-size < 0) {
				xVel *= -(StdRandom.uniform(1,.2));
			} else if (yPos+size> tank.getWidth() || yPos-size < 0) {
				yVel *= -(StdRandom.uniform(1,.2));;
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
			this.chaseGoldfish();
			
		}
		this.xPos+=this.xVel;
		this.yPos+=this.yVel;
	}
}