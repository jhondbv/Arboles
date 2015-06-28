/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import arboles.View.Default;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author jhon
 */
public class Arboles extends JFrame {

    JPanel jp;

    public Arboles() {
        super("Simple Drawing");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jp = new JPanel();

        add(jp);
        jp = new GPanel();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Arboles g1 = new Arboles();
        g1.setVisible(true);

    }

}

class GPanel extends JPanel {

    public GPanel() {
        setPreferredSize(new Dimension(300, 300));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //rectangle originated at 10,10 and end at 240,240
        g.drawRect(10, 10, 240, 240);
        //filled Rectangle with rounded corners.    
        g.fillRoundRect(50, 50, 100, 100, 80, 80);
    }
}
