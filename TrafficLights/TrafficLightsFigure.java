import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;

public class TrafficLightsFigure extends JComponent {

    private Color color;
    private int type;
    int k; // cover, visor, side triangles (visors) size
    int t; // side triangles (visors) & cover rounding value

    public TrafficLightsFigure(Color color, int type) {
        this.color = color;
        this.type = type;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        switch (type) {
            /* Main rectangle - traffic lights body */
            case 0: g.fillRoundRect(0,0, 120,315,30,30); break;
            /* Lights */
            case 1: g.fillOval(0,0,76,76); break;
            /* Small rectangle - traffic lights base */
            case 2: g.fillRoundRect(0,0,50,60,10,10); break;
            /* Right side triangles - side visors */
            case 3:
                g2.setColor(color);
                Path2D path1 = new Path2D.Double();
                k = 70;
                t = 10;
                path1.moveTo(0, t);
                path1.lineTo(0, k - t * 2);
                path1.quadTo(0,k,t * 2,k - t * 2);
                path1.lineTo(k - t, t);
                path1.quadTo(k, 0, k - t * 2, 0);
                path1.lineTo(t,0);
                path1.quadTo(0, 0, 0, t);
                path1.closePath();
                g2.fill(path1);
                break;
            /* Left side triangles - side visors*/
            case 4:
                g2.setColor(color);
                Path2D path2 = new Path2D.Double();
                k = 70;
                t = 10;
                path2.moveTo(k, t);
                path2.lineTo(k, k - t * 2);
                path2.quadTo(k,k,k - t * 2,k - t * 2);
                path2.lineTo(t, t);
                path2.quadTo(0, 0, t * 2, 0);
                path2.lineTo(k - t,0);
                path2.quadTo(k, 0, k, t);
                path2.closePath();
                g2.fill(path2);
                break;
            /* visor */
           case 5:
               g2.setColor(color);
               k = 100;
               Path2D path3 = new Path2D.Double();
               path3.moveTo(0, 70);
               path3.curveTo(0,0,k,0,k,70);
               path3.curveTo(k - 20,15,20,15,0,70);
               path3.closePath();
               g2.fill(path3);
               break;
           /* Upper cover */
           case 6:
               g2.setColor(color);
               Path2D path4 = new Path2D.Double();
               t = 10;
               k = 100;
               path4.moveTo(t * 2, 30);
               path4.lineTo(k - t * 2, 30);
               path4.quadTo(k,30,k - t,30 - t);
               path4.quadTo(k / 2.0, 0, t, 30 - t);
               path4.quadTo(0, 30, t * 2, 30);
               path4.closePath();
               g2.fill(path4);
               break;
        }
    }
}