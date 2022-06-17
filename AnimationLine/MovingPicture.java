import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class MovingPicture extends JComponent implements ActionListener {
    private final Timer timer;
    public int x = 0;
    public int y = 20;
    private BufferedImage image;

    public MovingPicture(int delay) {
        loadImage();
        timer = new Timer(delay, this);
    }

    public void start() {
        timer.start();
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File("./src/res/plane2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (x > 480) {
            x = -100;
            y = -80;
        } else {
            x++;
            y++;
        }
        g2d.drawImage(image, x, y, null);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Moving Plane");
            final MovingPicture movingPlane = new MovingPicture(20);
            frame.add(movingPlane);
            movingPlane.start();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(480, 500);
            frame.getContentPane().setBackground(Color.WHITE);
            frame.setVisible(true);
        });
    }
}
