import javax.swing.*;
import java.awt.*;

public class FortuneTellerViewer
{
    public static void main(String[] args)
    {
        JFrame framej = new FortuneTellerFrame();

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        framej.setSize(screenWidth * 3/4, screenHeight * 3/4);
        framej.setLocation(screenWidth / 8 , screenHeight / 8);

        framej.setTitle("Fortune Cookies");
        framej.setVisible(true);
    }


}
