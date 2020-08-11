
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainFrame extends javax.swing.JFrame {

    JPanel contentPane;
    JLabel imageLabel = new JLabel();
    JLabel headerLabel = new JLabel();
    AnimatedPanel panel;
    AnalysisMainPage panel2 = new AnalysisMainPage();
    TestSelectionPage panel3 = new TestSelectionPage();
    ArrayList<JCheckBox> samples = new ArrayList<>();
    ArrayList<JComboBox> p1 = new ArrayList<>();

    public MainFrame() {
        initComponents();
        panel2.getjButton4().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                remove(panel2);
                add(panel);
                SwingUtilities.updateComponentTreeUI(contentPane);
            }
        });

        panel2.getjButton5().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                remove(panel2);
                add(panel3);
                SwingUtilities.updateComponentTreeUI(contentPane);
            }
        });

        panel3.getjButton1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                remove(panel3);
                add(panel2);
                SwingUtilities.updateComponentTreeUI(contentPane);
            }
        });

        panel2.getjButton5().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                remove(panel2);
                add(panel3);
                SwingUtilities.updateComponentTreeUI(contentPane);

                Runnable r1 = new Runnable() {
                    public void run() {
                        panel3.getjPanel4().removeAll();
                        
                        ArrayList<File> inputfiles = panel2.getInputfiles();

                        samples = new ArrayList<>();

                        int pbc = 0;
                        
                        p1 = new ArrayList<>();
                        
                        for (File f : inputfiles) {
                            panel3.getjLabel1().setText("Extracting samples from " + f.getName());
                            ArrayList<String> mysamp;
                            try {
                                mysamp = getSamples(f);
                                for (String s : mysamp) {
                                    samples.add(new JCheckBox(s));
                                }
                            } catch (Exception e) {

                            }
                            
                            panel3.getjProgressBar1().setValue(100 * (++pbc) / inputfiles.size());
                            
                        }
                        
                        String[] packs = new String[]{"Package 1","Package 2","Package 3","Package 4","Package 5","Package 6","Package 7"};
                        
                        if(samples.size()<23){
                            panel3.getjPanel4().setLayout(new GridLayout(23,2,10,10));
                            
                        }else{
                            panel3.getjPanel4().setLayout(new GridLayout(0,2,10,10));
                        }
                        
                        for(JCheckBox x:samples){
                            panel3.getjPanel4().add(x);
                            p1.add(new JComboBox(packs));
                            panel3.getjPanel4().add(p1.get(p1.size()-1));
                        }
                        if(samples.size()<23){
                            for(int i=samples.size();i<23;i++){
                                panel3.getjPanel4().add(new JLabel(""));
                                panel3.getjPanel4().add(new JLabel(""));
                            }
                        }
                        panel3.getjProgressBar1().setValue(0);
                        panel3.getjLabel1().setText("Sample extraction finished.");
                    }
                };
                Thread t1 = new Thread(r1);
                t1.start();

            }
        });

        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setTitle("DNAFect - Process Your Future...");

            panel = new AnimatedPanel();
            panel.setLayout(new GridLayout(3, 3));
            Login login = new Login();
            login.getjButton1().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    remove(panel);
                    add(panel2);
                    SwingUtilities.updateComponentTreeUI(panel2);
                }
            });

            JPanel jp1 = new JPanel();
            jp1.setOpaque(false);
            JPanel jp2 = new JPanel();
            jp2.setOpaque(false);
            JPanel jp3 = new JPanel();
            jp3.setOpaque(false);
            JPanel jp4 = new JPanel();
            jp4.setOpaque(false);
            JPanel jp5 = new JPanel();
            jp5.setOpaque(false);
            JPanel jp6 = new JPanel();
            jp6.setOpaque(false);
            JPanel jp7 = new JPanel();
            jp7.setOpaque(false);
            JPanel jp8 = new JPanel();
            jp8.setOpaque(false);

            JLabel logo = new JLabel("");

            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("Logo/F Logo 3.11.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimg = img.getScaledInstance(400, 100, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            logo.setIcon(imageIcon);

            jp2.setLayout(new BorderLayout());
            JPanel pan00 = new JPanel();
            pan00.setOpaque(false);
            pan00.setLayout(new BoxLayout(pan00, 1));
            pan00.add(new JLabel(" "));
            pan00.add(new JLabel(" "));

            jp2.add(pan00, BorderLayout.NORTH);
            JPanel pan0 = new JPanel();
            pan0.add(logo);
            pan0.setOpaque(false);
            jp2.add(pan0, BorderLayout.CENTER);

            panel.add(jp1);
            panel.add(jp2);
            panel.add(jp3);
            panel.add(login);
            panel.add(jp4);
            panel.add(jp5);
            panel.add(jp6);
            panel.add(jp7);
            panel.add(jp8);

            add(panel, BorderLayout.CENTER);

            this.setLocationRelativeTo(null);
            this.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1938, 1048));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Log out");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1938, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1022, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
    private static Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public static ArrayList<String> getSamples(File f) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(f));
        String s = "";

        while (!(s = br.readLine()).equals("[Data]")) {
        }

        s = br.readLine();
        String[] headers = s.split("\t");

        ArrayList<Integer> psamp = which(headers, "Sample Name");
        ArrayList<String> usam = new ArrayList<>();

        while ((s = br.readLine()) != null) {
            String[] row = s.split("\t");
            String sam = row[psamp.get(0)];

            if (which2(usam, sam).isEmpty()) {
                usam.add(sam);
            }
        }

        return (usam);
    }

    public static ArrayList<Integer> which(String[] v, String s) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < v.length; i++) {
            if (v[i].equals(s)) {
                res.add(i);
            }
        }

        return (res);
    }

    public static ArrayList<Integer> which2(ArrayList<String> v, String s) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).equals(s)) {
                res.add(i);
            }
        }

        return (res);
    }
}
