import sun.font.TrueTypeFont;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Frame;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.Random;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class PixelChecker {

    public Robot robot = new Robot();
    public Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    private int redBuyable = 217;
    private int blueBuyable = 52;

    private final int[] rig = {860, 600};
    private final int[] bank = {860, 500};
    private final int[] lemon = {460, 200};
    private final int[] news = {460, 300};
    private final int[] car = {460, 400};
    private final int[] pizza = {460, 500};
    private final int[] doughnut = {456, 589};
    private final int[] shrimp = {860, 200};
    private final int[] hockey = {860, 300};
    private final int[] movie = {860, 400};

    public int[][] stuff = {rig, bank, lemon, news, car, pizza, doughnut, shrimp, hockey, movie};
    public String[] stuff_str = {"rig", "bank", "lemon", "news", "car", "pizza", "doughnut", "shrimp", "hockey", "movie"};

    
    public static void main(String args[]) throws AWTException, InterruptedException, IOException {

        System.out.println("Loading Assets...");
        Thread.sleep(2000);
        new PixelChecker();

    }

    public PixelChecker() throws AWTException, InterruptedException, IOException {

        int time = 0;

        while (true) {

            Thread.sleep(1000);
            time += 1;
            checkForStuff();


            if (time % 60 == 0) {

                randClick();

            }
            if (time % (3600 * 3) == 0) {

                String fileName = "ScreenShot." + Integer.toString(time) + ".jpg";
                Rectangle captureRect = new Rectangle(0, 0, 800, 600);
                BufferedImage screenCap = robot.createScreenCapture(captureRect);
                ImageIO.write(screenCap, ".jpg", new File(fileName));

            }

        }
    }

    public void checkForStuff() {

       
        for (int i = 0; i < stuff.length; i++) {

            Color checkColor = robot.getPixelColor(stuff[i][0], stuff[i][1]);

            if (checkColor.getRed() == redBuyable && checkColor.getBlue() == blueBuyable) {

                robot.mouseMove(stuff[i][0], stuff[i][1]);
                robot.delay(20);
                leftClick();
                robot.delay(20);
                leftClick();

                System.out.println("CLICKED ON: " + stuff_str[i].toUpperCase());
            }

        }

    }

    private void leftClick() {

        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(100);
    }

    private void randClick() {

        Random x_rand = new Random();
        Random y_rand = new Random();

        int Cx = x_rand.nextInt(Integer.parseInt(String.valueOf(screen.getHeight()))) + 1;
        int Cy = y_rand.nextInt(Integer.parseInt(String.valueOf(screen.getWidth()))) + 1;

        robot.mouseMove(Cx, Cy);

    }
    public void click(int j){
        
        Color checkColor = robot.getPixelColor(stuff[j][0], stuff[j][1]);
        
        if (checkColor.getRed() == redBuyable && checkColor.getBlue() == blueBuyable) {

                robot.mouseMove(stuff[j][0], stuff[j][1]);
                robot.delay(20);
                leftClick();
                robot.delay(20);
                leftClick();

                System.out.println("CLICKED ON: " + stuff_str[j].toUpperCase());
        }
        
    }
}







