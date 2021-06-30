import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import acm.graphics.*;
import acm.gui.IntField;
import acm.io.IODialog;
import acm.program.*;
import acm.util.RandomGenerator;
public class NumberShape extends GraphicsProgram {
	
	public void init() {
		setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
		setBackground(Color.BLACK);
	//	 soundClip.loop();
		addKeyListeners();
		addActionListeners();
		
	}

	
	private static int gcd(int a, int b) {
		int k=1;
		int m=(a<b)?a:b;
		for (int i=2; i<=m;i++) {
			if ((a%i==0)&&(b%i==0)) {
				k=i;
			}
		}
		return k;
	}
     public void run(){
    	 //soundClip = getAudioClip(getDocumentBase(),"titanic_theme.wav");
    	 
 		soundClipURL= getClass().getResource("titanic_theme.wav");
 		soundClip=Applet.newAudioClip(soundClipURL);
    	 soundClip.loop();
    	 double[] fl=new double[100];
		 comp = new NumShapeComponent(SIZE);
		 add(comp);
		 pause(1000);
    	 for(int k=0;k<SIZE;k++) {
    		 
    		 int g,numrtr,dnmntr;

    		 do {
        	 numrtr=gen.nextInt(1,30);
        	 dnmntr=gen.nextInt(1,30);
        	 g=gcd(numrtr,dnmntr);
        	 numrtr=numrtr/g;
        	 dnmntr=dnmntr/g;
    		 }while(containf(fl,numrtr*(1.0)/dnmntr));
        	// comp.setFlbl(numrtr+"/"+dnmntr,k);
        	 comp.drawNumberShape(numrtr,dnmntr,1000,k);
    		
    		
    		 
    		
        	 fl[k]=numrtr/dnmntr;
        	 
        	 pause(50);
     
    
    	 }
    	 soundClip.stop();
    	 


    }
     



	private boolean containf(double[] l,double d) {
    	for (int k=0;k<l.length;k++) {
    		if (l[k]==d) {
    			return true;
    		}
    	}
    	return false;
    }
    
 	private NumShapeComponent comp;
 	private static final int APPLICATION_WIDTH=1280;
 	private static final int APPLICATION_HEIGHT=800;
 	private static final double PI=3.141592;
 	private AudioClip soundClip;
 	private URL soundClipURL;
 	private RandomGenerator gen=RandomGenerator.getInstance();
 	public static final int SIZE=20;
    

}

