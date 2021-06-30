import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;
public class NumShapeComponent extends GCompound{
	
	public NumShapeComponent(int n) {
	
		//background = new GRect(WIDTH,HEIGHT);
		//shapebackground =new ShapeBackGround(2*CIRCLE_RADIUS,2*CIRCLE_RADIUS,1000);
		shapebackground =new ShapeBackGround[n];
		fraclist = new GLabel[n];

		//background.setFilled(true);
		//background.setColor(Color.BLACK);
		//shapebackground.setColor(Color.BLACK);
		numCircle = new GOval(N_OFFSET,N_OFFSET,2*CIRCLE_RADIUS,2*CIRCLE_RADIUS);
		denCircle = new GOval(D_OFFSET,D_OFFSET,2*CIRCLE_RADIUS,2*CIRCLE_RADIUS);
		numCircle.setColor(Color.WHITE);
		denCircle.setColor(Color.WHITE);
		c1=new MovingPoint(nccx,nccy);
		c2=new MovingPoint(dccx,dccy);
		movingPoint1 = new MovingPoint(nccx+CIRCLE_RADIUS,nccy);
		movingPoint2 = new MovingPoint(dccx+CIRCLE_RADIUS,dccy);
		dancingPoint = new MovingPoint(movingPoint2.getX(),movingPoint1.getY());
		movingRadiusLine1 = new MovingLine(c1,movingPoint1);
		movingRadiusLine1.setColor(Color.WHITE);
		movingRadiusLine2 = new MovingLine(c2,movingPoint2);
		movingRadiusLine2.setColor(Color.WHITE);
		dancingLine1 = new MovingLine(movingPoint1,dancingPoint);
		dancingLine2 = new MovingLine(movingPoint2,dancingPoint);
		dancingLine1.setColor(Color.WHITE);
		dancingLine2.setColor(Color.WHITE);
		
	/*	flbl=new GLabel("");
		flbl.setColor(Color.WHITE);
		flbl.setFont("Serif-italic-50");
		flbl.setLocation(N_OFFSET-200, D_OFFSET-200);*/
		
		
		oc1=new GOval(c1.getX()-2,c1.getY()-2,4,4);
		oc2=new GOval(c2.getX()-2,c2.getY()-2,4,4);
		oc1.setColor(Color.WHITE);
		oc2.setColor(Color.WHITE);
		
		mp1=new GOval(movingPoint1.getX()-2,movingPoint1.getY()-2,4,4);
		mp2=new GOval(movingPoint2.getX()-2,movingPoint2.getY()-2,4,4);
		
		ddot=new GOval(dancingPoint.getX()-3,dancingPoint.getY()-3,6,6);
		ddot.setFilled(true);
		oc1.setFilled(true);
		oc2.setFilled(true);
		mp1.setFilled(true);
		mp2.setFilled(true);
		oc1.setColor(Color.BLUE);
		oc2.setColor(Color.BLUE);
		ddot.setColor(Color.RED);
		mp1.setColor(Color.orange);
		mp2.setColor(Color.ORANGE);
	//	add(background);
	//	add(shapebackground,D_OFFSET,N_OFFSET);
		add(numCircle);
		add(denCircle);
		add(movingRadiusLine1);
		add(movingRadiusLine2);
		add(dancingLine1);
		add(dancingLine2);
		add(oc1);
		add(oc2);
		add(ddot);
		add(mp1);
		add(mp2);
		//add(flbl);


	}
	
	public MovingPoint[] PointList(MovingPoint c,double r, int n, int s) {
		double x=c.getX();
		double y=c.getY();
		MovingPoint[] plist= new MovingPoint[n];
		for (int i=0;i<n;i++) {
			plist[i]=new MovingPoint(x+r*GMath.cosDegrees(GMath.toDegrees(s*2*PI*i/n)),y+r*GMath.sinDegrees(GMath.toDegrees(s*2*PI*i/n)));
		}
		return plist ;
	}
	



	public void drawNumberShape(int num, int den, int n, int k) {
		
		pause(200);
		MovingPoint[] plist1,plist2;
		double x,y;
		int fsize=80;
		plist1=this.PointList(c1,CIRCLE_RADIUS, n,num);
		plist2=this.PointList(c2,CIRCLE_RADIUS, n,den);
		shapebackground[k]=new ShapeBackGround(2*CIRCLE_RADIUS,2*CIRCLE_RADIUS,n);
		fraclist[k]=new GLabel(num+"/"+den);
		fraclist[k].setColor(Color.WHITE);
		fraclist[k].setFont("Serif-italic-"+fsize);
		fraclist[k].setLocation(LX_OFFSET, LY_OFFSET);
		
		add(shapebackground[k],D_OFFSET,N_OFFSET);
		add(fraclist[k]);
		
		for(int i=0;i<n;i++) {
			
			x=plist2[i].getX();
			y=plist1[i].getY();
			
			movingRadiusLine1.setEndPoint(plist1[i]);
			movingRadiusLine2.setEndPoint(plist2[i]);
			
			dancingPoint.setLocation(x,y);
			
			dancingLine1.setStartPoint(plist1[i]);
			dancingLine1.setEndPoint(x,y);
			
			dancingLine2.setEndPoint(x,y);
			dancingLine2.setStartPoint(plist2[i]);

			

			dancingLine1.sendToFront();
			dancingLine2.sendToFront();
			shapebackground[k].ddotlist.get(i).setLocation(dancingPoint.getX()-D_OFFSET,dancingPoint.getY()-N_OFFSET);
			shapebackground[k].ddotlist.get(i).setVisible(true);
			ddot.setLocation(dancingPoint.getX()-3, dancingPoint.getY()-3);
			ddot.sendToFront();
			mp1.setLocation(plist1[i].getX()-2,plist1[i].getY()-2);
			mp2.setLocation(plist2[i].getX()-2,plist2[i].getY()-2);
			pause(1);
		}

		pause(500);
		shapebackground[k].changeotListColor(Color.CYAN);
		pause(500);
		for(int i=1;i<=10;i++) {
			shapebackground[k].scale(0.9);
			shapebackground[k].setLocation(D_OFFSET,N_OFFSET-(i-1)*15);
			//shapebackground[k].move(0,-15);
		    pause(30);
		    
		}
		double dim=shapebackground[k].getHeight();
		double loc_x=shapebackground[k].getX();
		double loc_y=shapebackground[k].getY();
		int i=1;
		if (loc_x > k*(dim)+(k+1)*10) {
			while (loc_x-i*10 >k*(dim)+(k+1)*10) {
				shapebackground[k].setLocation(loc_x-i*10,loc_y);
				//shapebackground[k].move(-10,0);
			    pause(30);
			    i=i+1;
			}
		}
		else {
			while (loc_x+i*10 <k*(dim)+(k+1)*10) {
				shapebackground[k].setLocation(loc_x+i*10,loc_y);
				//shapebackground[k].move(10,0);
			    pause(30);
			    i=i+1;
		    }
		}
		pause(30);
		for (int j=1;j<=5;j++) {
			shapebackground[k].setLocation(k*(dim)+(k+1)*10,loc_y-(dim+25)*(j/5.0));
			//shapebackground[k].move(0,-dim*(1/5.0));
			pause(30);
		}
		
		pause(500);
		fraclist[k].setColor(Color.ORANGE);
		pause(500);
		
		for(int l=1;l<=10;l++) {
			fraclist[k].setFont("Serif-italic-"+(50-(3*l)));
			fraclist[k].setLocation(LX_OFFSET,LY_OFFSET-(l+1)*10);
			//fraclist[k].move(0,-10);
		    pause(30);
		  
		}
		
		double floc_x=fraclist[k].getX();
		double floc_y=fraclist[k].getY();
		int l=1;
		if (floc_x > k*(dim)+(k+1)*10) {
			while (floc_x-l*10 >k*(dim)+(k+1)*10) {
				fraclist[k].setLocation(floc_x-l*10,floc_y-dim-10);
				//fraclist[k].move(-10,0);
			    pause(30);
			    l=l+1;
			}
		}
		else {
			while (floc_x+l*10 <k*(dim)+(k+1)*10) {
				fraclist[k].setLocation(floc_x+l*10,floc_y-dim-10);
				//fraclist[k].move(10,0);
			    pause(30);
			    l=l+1;
		    }
		}
		pause(30);
		for (int j=1;j<=5;j++) {
			fraclist[k].setLocation(k*(dim)+(k+1)*10,floc_y-dim*(j/5.0)-2*dim);
			//fraclist[k].move(0,floc_y-dim*(1/5.0));
			pause(30);
		}
		pause(30);
		
		
		
		
		
		

		
		
	}
	
	public void setFlbl(String f,int k) {
		fraclist[k].setLabel(f);
	}
		
	
		

	private GOval numCircle, denCircle,ddot,oc1,oc2,mp1,mp2,dot;
	private MovingPoint c1,c2,dancingPoint,movingPoint1,movingPoint2;
	private MovingLine movingRadiusLine1, movingRadiusLine2, dancingLine1,dancingLine2;
//	private GRect background;
	private ShapeBackGround[] shapebackground;
	private GLabel[] fraclist;
	
	private static final int N_OFFSET=250;
	private static final int D_OFFSET=500;
	
	private static final int LX_OFFSET=10;
	private static final int LY_OFFSET=300;
	
	private static final int CIRCLE_RADIUS=75;
	private static final int nccx=N_OFFSET+CIRCLE_RADIUS;
	private static final int nccy=N_OFFSET+CIRCLE_RADIUS;
	private static final int dccx=D_OFFSET+CIRCLE_RADIUS;
	private static final int dccy=D_OFFSET+CIRCLE_RADIUS;
 	public static final int WIDTH=1280;
 	public static final int HEIGHT=800;
	private static final double PI=3.141592;
	private RandomGenerator gen=RandomGenerator.getInstance();

}
