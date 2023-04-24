package myProject;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Margarita Grisales Tonuzco, correo: margarita.grisales@correounivalle.edu.co COD 2183460
 * @version v.1.0.0 23/04/2023
 */
public class GUIPresentation extends JFrame {
    //atributos
    //metodo
    private JButton myPhoto, myHobby, myExpectation;
    private Title title;
    private JPanel containerButtons, containerImage;
    private Listener Listener;
    private JLabel imageLabel;
    private JTextArea expectativesText;

    public GUIPresentation() {
        initGUI();
        this.setTitle("my presentation");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        title = new Title("This is My Project", Color.white);
        myPhoto = new JButton("this is me");
        myHobby = new JButton("this is my hobby");
        myExpectation = new JButton("expectation");
        containerButtons = new JPanel();
        containerImage = new JPanel();
        Listener = new Listener();
        imageLabel = new JLabel();

        expectativesText = new JTextArea(10,5 );
        expectativesText.setFont(new Font("Gigi",Font.PLAIN,24));
        expectativesText.setForeground(Color.BLACK);
        expectativesText.setOpaque(false);
        expectativesText.setEditable(false);

        containerImage.setBorder(BorderFactory.createTitledBorder(null, "About me", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION,
                new Font("Broadway", Font.PLAIN, 20), Color.WHITE));


        containerImage.add(imageLabel);
        containerImage.setBackground(Color.PINK);
        containerImage.addMouseListener(Listener);
        containerImage.addKeyListener(Listener);
        containerImage.setFocusable(true);

        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);
        containerButtons.add(myExpectation);


        myPhoto.addActionListener(Listener);
        myHobby.addActionListener(Listener);
        myExpectation.addActionListener(Listener);

        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIPresentation myGui = new GUIPresentation();
            }
        });
    }

    private class Listener implements ActionListener,MouseListener, KeyListener{
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            imageLabel.setIcon(null);
            containerImage.remove(expectativesText);
            if (e.getSource() == myPhoto) {
                this.image = new ImageIcon(getClass().getResource("/recourses/itsme.jpg"));
                ImageIcon imagenDimensionada =new ImageIcon(image.getImage().getScaledInstance
                        (containerImage.getWidth(),containerImage.getHeight(),Image.SCALE_SMOOTH));
                imageLabel.setIcon(imagenDimensionada);
            }
            else if (e.getSource() == myHobby) {
                this.image = new ImageIcon(getClass().getResource("/recourses/hobby.jpg"));
                ImageIcon imagenDimensionada =new ImageIcon(image.getImage().getScaledInstance
                        (containerImage.getWidth(),containerImage.getHeight(),Image.SCALE_SMOOTH));
                imageLabel.setIcon(imagenDimensionada);
            }

            else if (e.getSource() == myExpectation){
                expectativesText.setText("\n" +
                        "Mis expectativas para esta clase es aprender los conceptos"+
                        "\nnecesarios para concluir la asignatura de la mejor manera");
                containerImage.add(expectativesText);
            }
            containerImage.requestFocusInWindow();
            revalidate();
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            imageLabel.setIcon(null);
            containerImage.remove(expectativesText);
            if(e.getKeyCode() ==  KeyEvent.VK_M) {
                expectativesText.setText("\n" +
                        "Mis expectativas para esta clase es aprender los conceptos"+
                        "\nnecesarios para concluir la asignatura de la mejor manera");
                containerImage.add(expectativesText);
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            imageLabel.setIcon(null);
            containerImage.remove(expectativesText);
            if(e.getClickCount() ==1){
                this.image = new ImageIcon(getClass().getResource("/recourses/itsme.jpg"));
                ImageIcon imagenDimensionada =new ImageIcon(image.getImage().getScaledInstance
                        (containerImage.getWidth(),containerImage.getHeight(),Image.SCALE_SMOOTH));
                imageLabel.setIcon(imagenDimensionada);
            }
            if(e.getClickCount() ==2){
                this.image = new ImageIcon(getClass().getResource("/recourses/hobby.jpg"));
                ImageIcon imagenDimensionada =new ImageIcon(image.getImage().getScaledInstance
                        (containerImage.getWidth(),containerImage.getHeight(),Image.SCALE_SMOOTH));
                imageLabel.setIcon(imagenDimensionada);
            }
            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}


