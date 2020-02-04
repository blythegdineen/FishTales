public interface Tankable{

	public void update();
	public boolean hasCollision(Tankable t);
	public void changeDirection();
	public boolean isDead();
	public double getX();
	public double getY();
	public double getSize();

}