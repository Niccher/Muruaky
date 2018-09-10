/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v3;

/**
 *
 * @author nicch
 */
/*public class WindowTest {
    
}*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class WindowTest extends JFrame{

WindowTest(){
    setTitle("Window Test");
    setSize(600, 600);
    setLocationRelativeTo(null);
    setUndecorated(true);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            final WindowTest wt = new WindowTest();
            wt.setVisible(true);

            Timer t = new Timer(3000,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            wt.toFront();
                            wt.repaint();
                        }
                    });             
                }   
            });

            t.setRepeats(false);
            t.start();

            wt.addKeyListener(new KeyListener(){
                @Override
                public void keyPressed(KeyEvent arg0) {
                    if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE){
                        wt.dispose();
                        System.exit(0);
                        return;
                    }
                }

                @Override
                public void keyReleased(KeyEvent arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void keyTyped(KeyEvent arg0) {
                    // TODO Auto-generated method stub

                }   
            });
        }
    });

}

 }