import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override

            public void run(){
                //initialize the rockpaperscissor class obj
                rpsGUI rockpaperscissor = new rpsGUI();

                //display gui fram

                rockpaperscissor.setVisible(true);
            }
        });
    }
}
