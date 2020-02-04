import java.util.*;
import java.awt.Color;

public class FishTank{
	private double width;
	private double length;
	private double ammoniaCount;
	private int maxItems;
	private ArrayList <Tankable> myStuff;

	FishTank(double length, double width){
		this.length = length;
		this.width = width;
		this.ammoniaCount = 0;
		myStuff = new <Tankable> ArrayList();

		StdDraw.setCanvasSize((int)this.length,(int)this.width);
		StdDraw.setXscale(0,(int)this.length);
		StdDraw.setYscale(0,(int)this.width);
	}

	public void update(){
		show();
		getAmmonia();

		boolean result = false;
		for(int x = 0; x<myStuff.size(); x++){
			myStuff.get(x).update();
			for(int y = x+1; y<myStuff.size(); y++){
				if (myStuff.size()>1 && y!=x){
					result = myStuff.get(x).hasCollision(myStuff.get(y));
				}

				if(result == true){
					x=0;y=0;
					result=false;
				}
			}
			
			
		}
	}

	public void show(){

		StdDraw.setPenColor(0,0+(int)this.ammoniaCount,250-(int)this.ammoniaCount);
		StdDraw.filledRectangle(this.length/2,this.width/2,this.length/2,this.width/2);
	}
	public void add(Tankable t){
		this.myStuff.add(t);
	}
	public void remove(Tankable t){
		this.myStuff.remove(t);
	}

	public void cleanTheTank(){
		for(int i = myStuff.size()-1; i>=0; i--){
			if(myStuff.get(i).isDead() == true ){
				myStuff.remove(i);
			}
		}

	}
	public void tapTheTank(){
		for(int i = 0; i<myStuff.size();i++){
			myStuff.get(i).changeDirection();
		}
	}

	public Tankable getItem(int i){
		return this.myStuff.get(i);
	}

	public int getSize(){
		return this.myStuff.size();
	}

	public double getWidth(){
		return width;

	}
	public double getLength(){
		return length;
	}
	public double getAmmonia(){
		ammoniaCount = 0;
		while(ammoniaCount<250){
			for(int i = 0; i<myStuff.size();i++){

				if(myStuff.get(i).isDead() == false && myStuff.get(i) instanceof Fish){
					ammoniaCount++;
				} else if (myStuff.get(i).isDead() == true && myStuff.get(i) instanceof Pellet){
					ammoniaCount++;
				}
			}
		}

		return ammoniaCount;
	}
}