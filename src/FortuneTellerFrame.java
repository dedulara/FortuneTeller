import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPanel;
    JPanel topPanel;
    JPanel fortunePanel;
    JPanel buttonPanel;

    JTextArea fortuneTextArea;
    JScrollPane scrollPaneVariable;

    JLabel titleLable;
    ImageIcon iconVariable;

    JButton fortuneButton;
    JButton quitButton;

    Color topPanelBackground = Color.decode("#462B3F");
    Color titleLableBackground = Color.decode("#462B3F");
    Color titleLabelForeground = Color.decode("#C58BA4");
    Color fortuneTextAreaBackground = Color.decode("#FFFBA2");
    Color fortuneTextAreaForeground = Color.decode("#000000");
    Color fortunePanelBackground = Color.decode("#FFFDD0");
    Color buttonBackground = Color.decode("#DFB9C9");

    Random randomFortune = new Random();

    int fortuneNumber = 0;
    int lastFortuneNumber = fortuneNumber;

    public FortuneTellerFrame()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        createTopPanel();
        mainPanel.add(topPanel, BorderLayout.NORTH);
        createFortunePanel();
        mainPanel.add(fortunePanel, BorderLayout.CENTER);
        createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTopPanel()
    {
        topPanel = new JPanel();
        iconVariable = new ImageIcon("src/FortuneCookiesSmaller.jpg");
        titleLable = new JLabel("FORTUNE TELLER", iconVariable, JLabel.CENTER);
        titleLable.setFont(new Font("Algerian", Font.BOLD, 48));
        titleLable.setVerticalTextPosition(JLabel.BOTTOM);
        titleLable.setHorizontalTextPosition(JLabel.CENTER);
        topPanel.add(titleLable);

        topPanel.setBackground(topPanelBackground);
        titleLable.setBackground(titleLableBackground);
        titleLable.setOpaque(true);
        titleLable.setForeground(titleLabelForeground);
    }

    public void createFortunePanel()
    {
        fortunePanel = new JPanel();
        fortuneTextArea = new JTextArea(10, 48);
        fortuneTextArea.setEditable(false);
        scrollPaneVariable = new JScrollPane(fortuneTextArea);
        fortunePanel.add(scrollPaneVariable);
        fortuneTextArea.setFont(new Font("Times New Roman", Font.ITALIC, 18));

        fortuneTextArea.setForeground(fortuneTextAreaForeground);
        fortuneTextArea.setBackground(fortuneTextAreaBackground);
        fortunePanel.setBackground(fortunePanelBackground);
    }

    public void createButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        fortuneButton = new JButton("Read My Fortune");
        quitButton = new JButton("Quit");
        buttonPanel.add(fortuneButton);
        buttonPanel.add(quitButton);
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));

        Font buttonFont = new Font("Lucida Handwriting", Font.PLAIN, 18);
        fortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        ArrayList<String> fortunes = new ArrayList<String>();
        fortunes.add("Big journeys begin with a single step.");
        fortunes.add("Enjoy yourself while you can.");
        fortunes.add("You are about to finish reading your fortune.");
        fortunes.add("Practice makes perfect.");
        fortunes.add("Plan to be spontaneous tomorrow.");
        fortunes.add("Those who laugh at themselves never run out of things to laugh at.");
        fortunes.add("There is no angry way to say bubbles.");
        fortunes.add("Whatever you do, always give 100%.  Unless you're donating blood.");
        fortunes.add("Smile today, tomorrow could be worse.");
        fortunes.add("A day without sunshine is like, night.");
        fortunes.add("Dove chocolates taste way better than their soap.");
        fortunes.add("Take the high road.");

        fortuneButton.addActionListener((ActionEvent ae) ->
        {
            while(fortuneNumber == lastFortuneNumber) {fortuneNumber = randomFortune.nextInt(12);}
            lastFortuneNumber = fortuneNumber;
            fortuneTextArea.append(fortunes.get(fortuneNumber) + "\n");
        });

        quitButton.setBackground(buttonBackground);
        fortuneButton.setBackground(buttonBackground);
    }
}