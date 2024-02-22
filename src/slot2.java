import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class slot2 implements ActionListener, MouseListener {
    JFrame window;
    JLabel label, num1, num2, num3, num4,testies;
    JPanel numberPanel, buttonPanel;
    JButton button, closeButton;
    Random random = new Random();


    void createGame(){
        createWindow();
        createnumberPanel();
        createButton();
    }
    void createWindow(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setLocationRelativeTo(null);

    }
    void createnumberPanel(){
        numberPanel = new JPanel();
        numberPanel.setBounds(50,50,675,200);
        numberPanel.setBackground(Color.blue );
        numberPanel.setForeground(Color.black);
        numberPanel.setLayout(null);
        numberPanel.setVisible(true);
        window.add(numberPanel);

        num1 = new JLabel();
        num1.setBounds(25,25,125,150);
        num1.setBackground(Color.white);
        num1.setForeground(Color.black);
        num1.setFont(new Font("Book Antiqua",Font.PLAIN,132));
        num1.setHorizontalAlignment(JLabel.CENTER);
        num1.setLayout(new GridLayout(1,1));
        num1.setOpaque(true);
        num1.setVisible(true);
        numberPanel.add(num1);

        num2 = new JLabel();
        num2.setBounds(175,25,125,150);
        num2.setBackground(Color.white);
        num2.setForeground(Color.black);
        num2.setFont(new Font("Book Antiqua",Font.PLAIN,132));
        num2.setHorizontalAlignment(JLabel.CENTER);
        num2.setLayout(new GridLayout(1,1));
        num2.setOpaque(true);
        num2.setVisible(true);
        numberPanel.add(num2);

        num3 = new JLabel();
        num3.setBounds(325,25,125,150);
        num3.setBackground(Color.white);
        num3.setForeground(Color.black);
        num3.setFont(new Font("Book Antiqua",Font.PLAIN,132));
        num3.setHorizontalAlignment(JLabel.CENTER);
        num3.setLayout(new GridLayout(1,1));
        num3.setOpaque(true);
        num3.setVisible(true);
        numberPanel.add(num3);

        num4 = new JLabel();
        num4.setBounds(475,25,125,150);
        num4.setBackground(Color.white);
        num4.setForeground(Color.black);
        num4.setFont(new Font("Book Antiqua",Font.PLAIN,132));
        num4.setHorizontalAlignment(JLabel.CENTER);
        num4.setLayout(new GridLayout(1,1));
        num4.setOpaque(true);
        num4.setVisible(true);
        numberPanel.add(num4);
    }
    void createButton(){
        buttonPanel = new JPanel();
        buttonPanel.setBounds(50,300,675,200);
        buttonPanel.setBackground(Color.green);
        buttonPanel.setVisible(true);
        buttonPanel.setLayout(null);

        window.add(buttonPanel);

        ImageIcon appleIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\redButton.png");
        button = new JButton();
        button.setIcon(appleIcon);
        button.setContentAreaFilled(false);
        button.setBorder(null);

        button.setText("PULL");
        button.setFont(new Font("New Times Roman",Font.PLAIN,24));
        button.setHorizontalTextPosition(JButton.CENTER);

        button.setVisible(true);
        button.setBounds(25,25,190,45);
        button.setFocusable(false);
        button.addActionListener(this);
        button.addMouseListener(this);
        buttonPanel.add(button);

        closeButton = new JButton("Exit");
        closeButton.setVisible(true);
        closeButton.setBounds(300,25,150,150);
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        ImageIcon bananaIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\banana.png");
        ImageIcon appleIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\apple.png");
        ImageIcon bunchIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\bananaBunch.png");
        ImageIcon cherryIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\cherry.png");
        ImageIcon batIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\bat.png");
        ImageIcon deerIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\deer.png");
        ImageIcon pigIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\pig.png");
        ImageIcon vultureIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\vulture.png");

        int x = random.nextInt(100)+1;
        int y = random.nextInt(100)+1;
        int z = random.nextInt(100)+1;
        int zz = random.nextInt(100)+1;

        if (e.getSource()==button){

            if ( x <= 30  ){
                num1.setIcon(vultureIcon);
            }
            else if (x <=40){
                num1.setIcon(bananaIcon);
            }
            else if ( x <= 50){
                num1.setIcon(appleIcon);
            }
            else if ( x <= 60){
                num1.setIcon(batIcon);
            }
            else if ( x <= 70){
                num1.setIcon(deerIcon);
            }
            else if ( x <= 80){
                num1.setIcon(pigIcon);
            }
            else if ( x <= 90){
                num1.setIcon(bunchIcon);
            }
            else if ( x <= 100){
                num1.setIcon(cherryIcon);
            }


            if ( y <= 30  ){
                num2.setIcon(vultureIcon);
            }
            else if (y <=40){
                num2.setIcon(bananaIcon);
            }
            else if ( y <= 50){
                num2.setIcon(appleIcon);
            }
            else if ( y <= 60){
                num2.setIcon(batIcon);
            }
            else if ( y <= 70){
                num2.setIcon(deerIcon);
            }
            else if ( y <= 80){
                num2.setIcon(pigIcon);
            }
            else if ( y <= 90){
                num2.setIcon(bunchIcon);
            }
            else if ( y <= 100){
                num2.setIcon(cherryIcon);
            }

            if ( z <= 30  ){
                num3.setIcon(vultureIcon);
            }
            else if (z <=40){
                num3.setIcon(bananaIcon);
            }
            else if ( z <= 50){
                num3.setIcon(appleIcon);
            }
            else if ( z <= 60){
                num3.setIcon(batIcon);
            }
            else if ( z <= 70){
                num3.setIcon(deerIcon);
            }
            else if ( z <= 80){
                num3.setIcon(pigIcon);
            }
            else if ( z <= 90){
                num3.setIcon(bunchIcon);
            }
            else if ( z <= 100){
                num3.setIcon(cherryIcon);
            }

            if ( zz <= 30  ){
                num4.setIcon(vultureIcon);
            }
            else if (zz <=40){
                num4.setIcon(bananaIcon);
            }
            else if ( zz <= 50){
                num4.setIcon(appleIcon);
            }
            else if ( zz <= 60){
                num4.setIcon(batIcon);
            }
            else if ( zz <= 70){
                num4.setIcon(deerIcon);
            }
            else if ( zz <= 80){
                num4.setIcon(pigIcon);
            }
            else if ( zz <= 90){
                num4.setIcon(bunchIcon);
            }
            else if ( zz <= 100){
                num4.setIcon(cherryIcon);
            }
        }
        if (e.getSource()==closeButton){
            System.exit(0);

        }
    }

    public void mouseClicked(MouseEvent e) {



    }

    @Override
    public void mousePressed(MouseEvent e) {
        ImageIcon redButtonPressed = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\redButtonHoverPressed.png");
        if (e.getSource()==button){
            button.setIcon(redButtonPressed);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ImageIcon appleIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\redButtonHover.png");
        if (e.getSource()==button){
            button.setIcon(appleIcon);

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ImageIcon redButtonHover = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\redButtonHover.png");
        if (e.getSource()==button){
            button.setIcon(redButtonHover);

        }

    }
    @Override
    public void mouseExited(MouseEvent e) {
        ImageIcon redButton = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\redbutton.png");
        if (e.getSource()==button){
            button.setIcon(redButton);

        }

    }
}
