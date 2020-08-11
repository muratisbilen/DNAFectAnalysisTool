import java.awt.*;
import java.io.File;
import javax.swing.ImageIcon;

public class AnimatedPanel extends javax.swing.JPanel {

    public AnimatedPanel() {
        initComponents();
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        try{
            //ImageIcon ii = new ImageIcon(new File("C:/Users/murat/Desktop/DNAFect/Web Sitesi/GIFs/dna.gif").toURI().toURL());
            ImageIcon ii = new ImageIcon(new File("Logo/mygif2.gif").toURI().toURL());
            //g.drawImage(ii.getImage(), 0, 0, this);
            g.drawImage(ii.getImage(), 0, 0,1920,1080, this);
        }catch(Exception e){
            
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1938, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1048, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
