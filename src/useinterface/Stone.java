package useinterface;



import java.util.Random;
import javax.swing.*;
import java.awt.*;
public class Stone extends JLabel{
      ImageIcon stone;
      // tọa độ viên đá
      private int X=0,Y=0,mul=20;
      Random r = new Random();
      
      Interface gi;
	  
      public Stone(Interface g,int pos){
        gi = g;
        gi.add(this);
        stone = new ImageIcon("src//images//stone.jpg");
        this.setIcon(stone);
        this.setSize(stone.getIconWidth(), stone.getIconHeight());
        // setText("\u2B24");
		// setForeground(Color.getHSBColor(
		// 		r.nextFloat()*255,
		// 		r.nextFloat()*255,
		// 		r.nextFloat()*255));
        // resize();
      }

	  public void resize(){
		int tempMul=mul;
		mul=20;
		X=X*mul/tempMul;
		Y=Y*mul/tempMul;
		setBounds(X,Y,15*mul,15*mul);
	  }
      public void quickMove(int pos) {
		int 
			newX=calcX(pos),
			newY=calcY(pos);
		setLocation(newX,newY);
		X=newX;
		Y=newY;
	}
	int calcX(int pos) {
		int col=calcCol(pos);
		if(pos!=5&&pos!=11&&pos>=0)	
			return (int)(29*mul+col*39*mul+r.nextInt((int)(25*mul)));
		else 
			return (int)(24*mul+col*39*mul+r.nextInt((int)(30*mul)));
	}
	int calcY(int pos) {
		int row=calcRow(pos);
		if(pos!=5&&pos!=11&&pos>=0)	
			return (int)(53*mul+row*36*mul+r.nextInt((int)(20*mul)));
		if(pos>=0) 
			return (int)(69*mul+r.nextInt((int)(20*mul)));
		if(pos==-2) 
			return (int)(9*mul+r.nextInt((int)(17*mul)));
			return (int)(134*mul+r.nextInt((int)(17*mul)));//pos==-1
	}
	int calcCol(int pos) {
		if(pos<0) 	return 3; 
		if(pos<6) 	return(pos+1);
		if(pos<11) 	return(11-pos);
			 		return 0;
	}
	int calcRow(int pos) {
		if(pos<6) 	return 1;
			else 	return 0;
	}
}
