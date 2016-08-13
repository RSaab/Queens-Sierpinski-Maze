/* Rashad saab, rms78, 201301697 */

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Sierpinski extends JPanel {
	Graphics g;

	@Override
	public void paintComponent(Graphics g) {
		this.g = g;
		long start=System.currentTimeMillis();
		f(4);
		long end=System.currentTimeMillis();
		System.out.println("Runtime: " + (end - start));
	}

	public static void main(String args[]) {
		//create a new frame (Window)
		JFrame jf = new JFrame();
		//create a new panel and add the panel to the frame
		Sierpinski s = new Sierpinski();
		jf.setSize(500, 500); //set the width and height of the frame/window
		jf.setVisible(true); 
		jf.add(s);		
	}

	public void f(int levels) {
		Polygon p = new Polygon();
		p.addPoint(10, 410);
		p.addPoint(410, 410);
		p.addPoint(210, 10);
		g.drawPolygon(p);
		drawTriangle(levels, p);
	}
	
	
	public void drawTriangle(int level, Polygon p){
		if(level>=0){
			int[] xCoor=p.xpoints;
			int[] yCoor=p.ypoints;
			
			Polygon newP=new Polygon();
			
			newP.addPoint((xCoor[0]+xCoor[1])/2, (yCoor[0]+yCoor[1])/2);
			newP.addPoint((xCoor[0]+xCoor[2])/2, (yCoor[0]+yCoor[2])/2);
			newP.addPoint((xCoor[1]+xCoor[2])/2, (yCoor[1]+yCoor[2])/2);
			
			g.fillPolygon(newP);
			
			//call recursively on the other 3 triangles
			drawTriangle(level-1, createPolygon(xCoor[0], yCoor[0],(xCoor[0]+xCoor[1])/2, (yCoor[0]+yCoor[1])/2, (xCoor[0]+xCoor[2])/2, (yCoor[0]+yCoor[2])/2));
			drawTriangle(level-1, createPolygon(xCoor[1], yCoor[1],(xCoor[0]+xCoor[1])/2, (yCoor[0]+yCoor[1])/2, (xCoor[1]+xCoor[2])/2, (yCoor[1]+yCoor[2])/2));
			drawTriangle(level-1, createPolygon(xCoor[2], yCoor[2],(xCoor[0]+xCoor[2])/2, (yCoor[0]+yCoor[2])/2, (xCoor[1]+xCoor[2])/2, (yCoor[1]+yCoor[2])/2));
		}
	}

	private Polygon createPolygon(int x, int y, int x1, int y1, int x2, int y2){
		Polygon p=new Polygon();
		p.addPoint(x, y);
		p.addPoint(x1, y1);
		p.addPoint(x2,  y2);
		return p;
	}
}
