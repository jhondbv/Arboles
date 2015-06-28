/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.Clases;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author jhon
 */
public class DrawBinaryTree extends JPanel {

    public DrawBinaryTree() {
        /* this.setPreferredSize(new Dimension(491,454));*/
        setBackground(Color.white);
        setLocation(10, 10);
        JScrollPane scroll = new JScrollPane(this);
    }

    public void paintRectangle(Graphics g) {

        g.setColor(Color.red);
        g.drawOval(220, 20, 30, 30);// x,y, ancho,largo
        g.drawString("A", 230, 40);
        
        g.drawOval(180, 80, 30, 30);
        g.drawString("B", 190, 100);
        g.drawLine(235, 50, 195, 80);//linea al padre es x(padre)+15 y(padre)+30, linea a si mismo x(actual)+15 y(actual)
        
        g.drawOval(260, 80, 30, 30);
        g.drawString("C", 270, 100);
        g.drawLine(235, 50, 275, 80);

    }

}
