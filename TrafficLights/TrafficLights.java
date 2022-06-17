import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TrafficLights extends JFrame {
    public TrafficLights() {
        super();
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Светофор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 620;
        int height = 655;
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        Color b = new Color(217, 217, 217);
        frame.getContentPane().setBackground(b);

        TrafficLightsFigure redLight = new TrafficLightsFigure(Color.RED,1);
        redLight.setBounds(272, 155, width, height);
        frame.add(redLight);

        TrafficLightsFigure yellowLight = new TrafficLightsFigure(Color.YELLOW,1);
        yellowLight.setBounds(272, 251, width, height);
        frame.add(yellowLight);

        TrafficLightsFigure greenLight = new TrafficLightsFigure(Color.GREEN,1);
        greenLight.setBounds(272, 351, width, height);
        frame.add(greenLight);

        TrafficLightsFigure cover = new TrafficLightsFigure(Color.DARK_GRAY, 6);
        cover.setBounds(260,95, width, height);
        frame.add(cover);

        TrafficLightsFigure redLightVisor = new TrafficLightsFigure(Color.WHITE, 5);
        redLightVisor.setBounds(260,120, width, height);
        frame.add(redLightVisor);

        TrafficLightsFigure yellowLightVisor = new TrafficLightsFigure(Color.WHITE, 5);
        yellowLightVisor.setBounds(260,216, width, height);
        frame.add(yellowLightVisor);

        TrafficLightsFigure greenLightVisor = new TrafficLightsFigure(Color.WHITE, 5);
        greenLightVisor.setBounds(260,316, width, height);
        frame.add(greenLightVisor);

        TrafficLightsFigure mainRect = new TrafficLightsFigure(Color.DARK_GRAY, 0);
        mainRect.setBounds(250,130, width, height);
        frame.add(mainRect);

        TrafficLightsFigure smallRect = new TrafficLightsFigure(Color.DARK_GRAY, 2);
        smallRect.setBounds(285,451, width, height);
        frame.add(smallRect);

        TrafficLightsFigure triangle_11 = new TrafficLightsFigure(Color.DARK_GRAY, 3);
        triangle_11.setBounds(377,155, width, height);
        frame.add(triangle_11);

        TrafficLightsFigure triangle_12 = new TrafficLightsFigure(Color.DARK_GRAY, 3);
        triangle_12.setBounds(377,251, width, height);
        frame.add(triangle_12);

        TrafficLightsFigure triangle_13 = new TrafficLightsFigure(Color.DARK_GRAY, 3);
        triangle_13.setBounds(377,351, width, height);
        frame.add(triangle_13);

        TrafficLightsFigure triangle_21 = new TrafficLightsFigure(Color.DARK_GRAY, 4);
        triangle_21.setBounds(173,155, width, height);
        frame.add(triangle_21);

        TrafficLightsFigure triangle_22 = new TrafficLightsFigure(Color.DARK_GRAY, 4);
        triangle_22.setBounds(173,251, width, height);
        frame.add(triangle_22);

        TrafficLightsFigure triangle_23 = new TrafficLightsFigure(Color.DARK_GRAY, 4);
        triangle_23.setBounds(173,351, width, height);
        frame.add(triangle_23);

        frame.pack();
        frame.setVisible(true);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        frame.paint(graphics2D);
        try {
            ImageIO.write(image,"jpeg", new File("output.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
