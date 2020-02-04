import java.awt.*;
public abstract class Pellet implements Tankable{

	protected FishTank tank;
	protected double size;
	protected Color skinColor; 
	protected Color outlineColor; 
	protected double age; 
	protected double maxAge; 
	protected double xPos; 
	protected double yPos; 
	protected double xVel; 
	protected double yVel; 

	Pellet(FishTank tank) {
		this.tank = tank;
		this.age = 0;
		this.maxAge = 1000;
		this.size = StdRandom.gaussian(5,.2*5);
		
		this.xVel = 0;
		this.yVel = 1;

		this.xPos = StdRandom.uniform((int)tank.getLength());
		this.yPos = tank.getWidth();


	}
	public void update(){
		show();
		move();
		age++;
	}
	private void show(){
		StdDraw.setPenColor(this.skinColor);
		StdDraw.filledCircle(this.xPos,this.yPos,this.size);
	}

	private void move() {
		if (this instanceof Bubble) {
			this.yPos+= this.yVel;
		} else {
			if (this.yPos <= 0) {
				this.yPos = 0;
			} else {
				this.yPos -= this.yVel;
			}
		}
	}


	public void changeDirection(){
		
	}
	public boolean hasCollision(Tankable t){
		double xDis = Math.pow(this.xPos - t.getX(),2);
		double yDis = Math.pow(this.yPos - t.getY(),2);
		double magn = Math.sqrt(yDis+xDis);
		//StdOut.println(magn);
		if (magn < (this.size+this.getSize())/2){
			return true;
		} else {
			return false;
			
		}
	}
	public double getX(){
		return this.xPos;

	}
	public double getY(){
		return this.yPos;
	}
	public double getSize(){
		return this.size;
	}

	abstract public boolean isDead();

}