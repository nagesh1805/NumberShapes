import acm.graphics.GLine;
import acm.graphics.GPoint;

public class MovingLine extends GLine {
	
	public MovingLine(MovingPoint p1, MovingPoint p2) {
		super(p1.getX(),p1.getY(),p2.getX(),p2.getY());
		ipoint =p1;
		tpoint =p2;
	}
	
	public void setEndPoint(MovingPoint p) {
		setEndPoint(p.getX(),p.getY());
	}
	
	public void setStartPoint(MovingPoint p) {
		setStartPoint(p.getX(),p.getY());
	}
	
	private MovingPoint ipoint,tpoint;

}
