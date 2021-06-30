import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.graphics.GRect;

public class ShapeBackGround extends GCompound{
	
	public ShapeBackGround(double w,double h,int list_len) {
		background =new GRect(w,h);
		ddotlist = new ArrayList<GOval>();
		add(background);
		for(int i=0;i<list_len;i++) {
			GOval a=new GOval(1,1);
			a.setColor(Color.GREEN);
			a.setFilled(true);
			a.setVisible(false);
			ddotlist.add(a);
		}
		for(GOval a: ddotlist) {
			add(a);
		}
		background.setFilled(true);
		background.setColor(Color.BLACK);
		
		
	}
	
	public void changeotListColor(Color clr) {
		for(GOval dt : ddotlist) {
			dt.setColor(clr);
		}
	}
	
	public GRect background;
	public ArrayList<GOval> ddotlist;


}
