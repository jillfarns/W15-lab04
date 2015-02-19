package edu.ucsb.cs56.w15.drawings.pmsosa.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a face that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Pedro M. Sosa 
   @version for CS56, Winter 15, UCSB
   
*/
public class Face extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
     */
    public Face(double x, double y, double width, double height)
    {

        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.

        //Head, Eyes and Mouth
        Rectangle2D.Double head = new Rectangle2D.Double(x,y,width,height);
        Rectangle2D.Double lf_eye = new Rectangle2D.Double((x+(0.125)*width),(y+(0.125)*height),((0.25)*width),((0.5)*height));
        Rectangle2D.Double rt_eye = new Rectangle2D.Double((x+(0.625)*width),(y+(0.125)*height),((0.25)*width),((0.5)*height));
        Rectangle2D.Double mouth = new Rectangle2D.Double((x+(0.125)*width),(y+(0.725)*height),((0.75)*width),((0.15)*height));




        GeneralPath face = this.get();
        face.append(head,false);
        face.append(lf_eye,false);
        face.append(rt_eye,false);
        face.append(mouth,false);
        
    }

}
