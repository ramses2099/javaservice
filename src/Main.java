import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;;
/**
 * Main
 */
public class Main extends JFrame {

    public Main(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Worker - Java as a Windows Service & System Trail");
        setSize(300,300);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(e.getWindow(), "Let me close the windows");
                if(option == JOptionPane.YES_OPTION){
                    e.getWindow().setVisible(false);
                }else if(option == JOptionPane.NO_OPTION){
                    System.exit(0);
                }else{
                    /* no code */
                }
            }
                      
        });

        setVisible(true);
    }


    public static void main(String[] args) {
        //new Main();
        
        /* Implement timer task */
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                System.out.println(new Date()+" Thread: "+ Thread.currentThread().getName());                
            }
            
        };
        //
        Timer timer = new Timer("Timer");
        long delay = 5000L;
        timer.schedule(task, delay,delay);

    }
}