package edu.ucsb.cs56.w15.drawings.jillfarnsworth.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle; 
import java.awt.geom.GeneralPath; 
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke; 
import java.awt.BasicStroke;
import java.awt.geom.AffineTransform; 
import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;

/**
   A component that draws an animated picture by Jill Farnsworth
   
   @author Jill Farnsworth
   @version CS56, Winter 2015, UCSB
   
*/

public class AnimatedPictureComponent extends JComponent {
    private Shape fish;
    private double startingWidth;
    private double startingHeight;
    private double currentWidth;
    private double currentHeight;
    private double speed;
    private double startingX;
    private double startingY;
    private double currentX;
    private double currentY;
    private double travel = 0;
    private double amplitude = 4;
    private double swimSpeed;
    private double t;

    /** Construcs an AnimatedPictureComponent that depicts a fish swimming
	across the screen 
	@param startingX starting x position of fish
	@param startingY starting y postition of fish
	@param speed speed at which fish moves across screen
	@param swimSpeed speed at which fish ocsillated to create swimming motion
	@param startingWidth starting width of fish
	@param startingHeight starting height of fish
    */
    public AnimatedPictureComponent(double startingX, double startingY, double speed, double swimSpeed, double startingWidth, double startingHeight) {
	this.startingX = startingX;
	this.startingY = startingY;
	this.currentX = startingX;
	this.currentY = startingY;
	this.speed = speed;
	this.swimSpeed = swimSpeed;
	this.startingWidth = startingWidth;
	this.startingHeight = startingHeight;
	this.currentWidth = startingWidth;
	this.currentHeight = startingHeight;

	fish = new FishWithFins(this.currentX, this.currentY, this.startingWidth, this.startingHeight);
    }

 /** The paintComponent method is orverriden to display
	the animation. Each time this method is called, the
	position of the fish is updated
     */
    public void paintComponent(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	if (currentY<=0) {
	    currentX = startingX;
	    currentY = startingY;
	    currentWidth = startingWidth;
	    currentHeight = startingHeight;
	    travel = 0;
	    return;
	}
	else {
	g2.setColor(Color.cyan);
	g2.fillRect(0, 0, this.getWidth(), this.getHeight());
	g2.setColor(Color.ORANGE);
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	g2.setStroke(thick);
	fish = ShapeTransforms.rotatedCopyOf(fish, Math.PI/4);
	g2.draw(fish);
	}
	t += swimSpeed;
	travel += speed;
	double swim = amplitude*(1/swimSpeed)*Math.sin(t) + amplitude*0.8*(1/swimSpeed)*Math.sin(0.8*t+1.5);
	currentX += swim;
	currentX = startingX - travel;
	currentY = startingY - travel;
	currentWidth *= 0.995;
	currentHeight *= 0.995;
	fish = ShapeTransforms.rotatedCopyOf(new FishWithFins(currentX, currentY, currentWidth, currentHeight), 0.02*swim);
    }
}