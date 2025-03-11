import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class rpsGUI extends JFrame implements ActionListener{
    JButton rockButton, paperButton, sicssorButton;

    JLabel computerChoice;

    JLabel computerScoreLabel, playerScoreLabel;

    // display computer choice

    JLabel computerChoices;

    rspBackend rpsb;

    rpsGUI(){
        super("Rock Paper Scissor Game");

        //set height and width to the frame

        setSize(600, 600);

        //set null to the layout management, so we can use absolute positioning for the frame
        //(i.e setting x,y coordinates and width/height values);

        setLayout(null);

        //terminate gui  frame when i click on close button of the panel

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //load gui center of the application 

        setLocationRelativeTo(null);

        // false resizeble

        setResizable(false);

        //add gui components

        addGUIComponents();

        rpsb = new rspBackend();
    }
    private void addGUIComponents(){
        //create score label
        computerScoreLabel = new JLabel("Computer Score 0 ");

        //set x,y coordinates and height and width

        computerScoreLabel.setBounds(50, 43, 500, 30);

        //set the font to the font family of the dialog, font-width bold and a font size 26

        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));

        //place conputer score board in the center

        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add gui

        add(computerScoreLabel);

        computerChoices = new JLabel("?");
        computerChoices.setBounds(195, 118, 208, 61);
        computerChoices.setFont(new Font("Dailog", Font.PLAIN, 18));
        computerChoices.setHorizontalAlignment(SwingConstants.CENTER);

        //black border

        computerChoices.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoices);

        playerScoreLabel = new JLabel("Player : 0");
        playerScoreLabel.setBounds(70, 317, 450, 30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        // player buttons 

        // rock button 

        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 19));
        rockButton.addActionListener(this);
        add(rockButton);

        // paper button

        paperButton = new JButton("Paper");
        paperButton.setBounds(250, 387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 19));
        paperButton.addActionListener(this);
        add(paperButton);

        // sicssor button

        sicssorButton = new JButton("Sicssor");
        sicssorButton.setBounds(450, 387, 105, 81);
        sicssorButton.setFont(new Font("Dialog", Font.PLAIN, 19));
        sicssorButton.addActionListener(this);
        add(sicssorButton);
    }

    // display a dialog which will show winner and try again message

    private void showDialog(String message){
        JDialog resultDialog = new JDialog(this, "Result ", true);
        resultDialog.setSize(230, 200);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        // message

        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        JButton tryagiButton = new JButton("Try Again!");
        tryagiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // reset computer choices

                computerChoices.setText("?");

                // close dialog box

                resultDialog.dispose();
            }
        });
        resultDialog.add(tryagiButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // get player choice

        String playerChoice = e.getActionCommand().toString();

        // store rock paper and scissor result value into string

        String result = rpsb.playRockPaperScissor(playerChoice);

        // load computer choice

        computerChoices.setText("Computer Choice : " + rpsb.getComputerScore());

        computerScoreLabel.setText("Computer : "+ rpsb.getComputerScore());

        playerScoreLabel.setText("Player : "+ rpsb.getPlayerScore());

        showDialog(result);
    }
}
