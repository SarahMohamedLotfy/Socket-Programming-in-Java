
import java.util.Random;
import java.util.Random;
import java.lang.*;
import java.io.Serializable;
import java.lang.Math; 

    public class Triangle implements Serializable
    {
	/** Vertexes of the triangle */
         private Point vertex1;
         private Point vertex2;
         private Point vertex3;

         /** Constructor of a triangle with their vertexes */
        public Triangle(Point vertex1, Point vertex2, Point vertex3) {
             this.vertex1 = vertex1;
             this.vertex2 = vertex2;
             this.vertex3 = vertex3;
        }

        public String triangleType() 
        {
            double aa =Math.sqrt (Math.pow((vertex1.x - vertex2.x), 2)+
            Math.pow((vertex1.y - vertex2.y), 2));
             double bb =Math.sqrt (Math.pow((vertex2.x - vertex3.x), 2)+
            Math.pow((vertex2.y - vertex3.y), 2));
             double cc =Math.sqrt (Math.pow((vertex1.x - vertex3.x), 2)+
            Math.pow((vertex1.y - vertex3.y), 2));
           long a = Math.round(aa);
           long b = Math.round(bb);
           long c = Math.round(cc);
           System.out.println(a + "  "+b+"  "+c );
            if (a == b && b == c) return "Equilateral";
            if (b==c || a==b || c==a) return "Isocelles";
            return "Scalen";
        }
    }