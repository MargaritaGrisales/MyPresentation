package myProject;

import javax.swing.*;
import java.awt.*;
public class Title extends JLabel {
    public  Title(String title,Color backgroundColor){
        this.setText(title);
        this.setBackground(backgroundColor);
        this.setForeground(Color.pink);
        this.setFont(new Font("Broadway",Font.BOLD+Font.PLAIN,30));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}
