import java.util.*;
import java.awt.Color;

public class FishTales2{
	public static void main(String[] args){
		FishTank myTank = new FishTank(900,700);
		StdDraw.enableDoubleBuffering();
		while(true){


			myTank.show();

			if(StdDraw.isKeyPressed(71)){ //'G'
				while(StdDraw.isKeyPressed(71)){
					
				}
				System.out.println("New Goldfish");
				myTank.add(new Goldfish(myTank, "Dory"));
			} else if(StdDraw.isKeyPressed(80)){ //'P'	
				while(StdDraw.isKeyPressed(80)){
					
				}
				System.out.println("New Piranha");
				myTank.add(new Piranha(myTank, "Phirhanha"));

			} else if(StdDraw.isKeyPressed(87)){ //'W'
				while(StdDraw.isKeyPressed(87)){
					
				}
				System.out.println("New Whale");
				myTank.add(new Whale(myTank, "Ichmael"));
			} else if(StdDraw.isKeyPressed(84)){ //'T'
				while(StdDraw.isKeyPressed(84)){
					
				}
				System.out.println("New Toroidal");
				myTank.add(new ToroidalFin(myTank, "Donut"));
			} else if(StdDraw.isKeyPressed(70)){ //'F'
				while(StdDraw.isKeyPressed(70)){
					
				}
				for (int i = 0; i < 8; i ++) {
					myTank.add(new Food(myTank));
					if (i%3 == 0) {
						myTank.add(new Poison(myTank));
					}
				}
				System.out.println("New Food");
			} else if(StdDraw.isKeyPressed(67)){ //'C'
				while(StdDraw.isKeyPressed(67)){
					
				}
				System.out.println("Clean the Tank");
				myTank.cleanTheTank();
			} else if(StdDraw.mousePressed()){
				myTank.tapTheTank();
				System.out.println("Tap the Tank");
			}

			myTank.update();
			StdDraw.show();
			StdDraw.pause(1000/30);
		}
		
	}
}