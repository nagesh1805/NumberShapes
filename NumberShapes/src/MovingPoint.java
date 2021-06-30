import acm.graphics.*;
import acm.program.*;
public class MovingPoint extends GPoint{
	
	public MovingPoint(double x, double y) {
		super(x,y);
	}
	
	
	 public void rotate(double theta) {
		 double x0=this.getX();
		 double y0=this.getY();
		 double r = GMath.distance(x0,y0);
		 x0=x0+GMath.cosDegrees(GMath.toDegrees(theta));
		 y0=y0+GMath.sinDegrees(GMath.toDegrees(theta));
		 this.setLocation(x0, y0);
		 
	 }
	
	

	


}

