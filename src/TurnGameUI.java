import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class TurnGameUI {
    TurnBasedGame tbg;
    File potionSound = new File("C:\\Users\\Rod\\Desktop\\Code Resourses\\Sounds\\drink.wav");

    AudioInputStream audioStream6 = AudioSystem.getAudioInputStream(potionSound);

    Clip clip6 = AudioSystem.getClip();


    Variables V = new Variables(tbg);

    public TurnGameUI(TurnBasedGame tbg) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.tbg = tbg;
        createui();
    }

        void createui (){
        //Window
        JFrame window = new JFrame();
        window.setSize(1000,900);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(Color.black);

        //Panels
        V.playerPanel = new JPanel();
        V.playerPanel.setBackground(Color.green);
        V.playerPanel.setOpaque(false);
        V.playerPanel.setBounds(50,200,300,225);
        V.playerPanel.setVisible(true);
        window.add(V.playerPanel);

        V.enemyPanel = new JPanel();
        V.enemyPanel.setBackground(Color.red);
        V.enemyPanel.setOpaque(false);
        V.enemyPanel.setBounds(650,200,300,225);
        V.enemyPanel.setVisible(true);
        window.add(V.enemyPanel);

        V.iconInventoryPanel = new JPanel();
        V.iconInventoryPanel.setBackground(null);
        V.iconInventoryPanel.setOpaque(false);
        V.iconInventoryPanel.setBounds(80,637,500,200);
        V.iconInventoryPanel.setLayout(new GridLayout(5,6));
        V.iconInventoryPanel.setVisible(true);
        window.add(V.iconInventoryPanel);

        V.inventoryPanel = new JPanel();
        V.inventoryPanel.setBackground(null);
        V.inventoryPanel.setBounds(50,630,500,205);
        V.inventoryPanel.setVisible(true);
        window.add(V.inventoryPanel);

        V.menuPanel = new JPanel();
        V.menuPanel.setBackground(Color.pink);
        V.menuPanel.setBounds(575,600,150,200);
        V.menuPanel.setOpaque(false);
        window.add(V.menuPanel);

        V.optionsPanel = new JPanel();
        V.optionsPanel.setBackground(Color.darkGray);
        V.optionsPanel.setBounds(750,600,150,200);
        V.optionsPanel.setVisible(true);
        V.optionsPanel.setOpaque(false);
        window.add(V.optionsPanel);

        V.skillPanel = new JPanel();
        V.skillPanel.setBackground(Color.orange);
        V.skillPanel.setOpaque(false);
        V.skillPanel.setBounds(375,200,250,300);
        V.skillPanel.setVisible(true);
        V.skillPanel.setLayout(null);
//        skillPanel.setLayout(new GridLayout(4,1));
        window.add(V.skillPanel);

        V.textPanel = new JPanel();
        V.textPanel.setBackground(Color.white);
        V.textPanel.setBounds(50,525,900,50);
        V.textPanel.setVisible(true);
        window.add(V.textPanel);

        V.titlePanel = new JPanel();
        V.titlePanel.setBackground(Color.darkGray);
        V.titlePanel.setBounds(50,50,900,127);
        V.titlePanel.setVisible(true);
        V.titlePanel.setOpaque(false);
        window.add(V.titlePanel);

        V.inventoryTextPanel = new JPanel();
        V.inventoryTextPanel.setBackground(Color.YELLOW);
        V.inventoryTextPanel.setVisible(true);
        V.inventoryTextPanel.setBounds(50,585,500,49);
        V.inventoryTextPanel.setOpaque(false);
        window.add(V.inventoryTextPanel);

        V.heroStatPanel = new JPanel();
        V.heroStatPanel.setBounds(50,430,300,75);
        V.heroStatPanel.setVisible(true);
        V.heroStatPanel.setBackground(Color.lightGray);
//        V.heroStatPanel.setOpaque(false);
        V.heroStatPanel.setLayout(new GridLayout(2,2));
        window.add(V.heroStatPanel);

//        V.heroStatImagePanel = new JPanel();
//        V.heroStatImagePanel.setBounds(40,410,320,95);
//        V.heroStatImagePanel.setVisible(true);
//        window.add(V.heroStatImagePanel);


        V.enemyStatPanel = new JPanel();
        V.enemyStatPanel.setBounds(650,430,300,75);
        V.enemyStatPanel.setVisible(true);
        V.enemyStatPanel.setBackground(Color.lightGray);
        window.add(V.enemyStatPanel);

        V.backgroundPanel = new JPanel();
        V.backgroundPanel.setBounds(0,0,1000,900);
        V.backgroundPanel.setVisible(true);
        V.backgroundPanel.setBackground(Color.gray);
        window.add(V.backgroundPanel);

        //Labels
        V.heroLabel = new JLabel();
        V.heroLabel.setIcon(V.heroIcon);
        V.playerPanel.add(V.heroLabel);

        V.enemyLabel = new JLabel();
        V.enemyLabel.setIcon(V.badguyIcon);
        V.enemyPanel.add(V.enemyLabel);




        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem menuItem[] = new JMenuItem[3];
        menuItem[1] = new JMenuItem("Drink");
        menuItem[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                V.messegeText.setText("You drink a Health Potion and gain 200 health!");
                V.iconInventoryPanel.remove(V.potionLabel);
                V.iconInventoryPanel.revalidate();
                V.iconInventoryPanel.repaint();
                V.heroHealth += 200;
                V.heroHP.setText(String.valueOf(V.heroHealth));
                clip6.setMicrosecondPosition(0);
                clip6.start();
            }
        });
        popMenu.add(menuItem[1]);

        V.potionLabel = new JLabel();
        V.potionLabel.setIcon(V.potionIcon);
        V.potionLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                popMenu.show(V.potionLabel, e.getX(), e.getY());
            }
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });


        JPopupMenu popMenu2 = new JPopupMenu();
        JMenuItem menuItem2[] = new JMenuItem[3];
        menuItem2[1] = new JMenuItem("Drink");
        menuItem2[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                V.messegeText.setText("You drink a Mana Potion and gain 200 Mana!");
                V.iconInventoryPanel.remove(V.manaPotionLabel);
                V.iconInventoryPanel.revalidate();
                V.iconInventoryPanel.repaint();
                V.heroMana += 200;
                V.heroMP.setText(String.valueOf(V.heroMana));
                clip6.setMicrosecondPosition(0);
                clip6.start();
            }
        });
        popMenu2.add(menuItem2[1]);

        V.manaPotionLabel = new JLabel();
        V.manaPotionLabel.setIcon(V.manaPotionIcon);
        V.manaPotionLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                popMenu2.show(V.manaPotionLabel, e.getX(),e.getY());
            }
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

            JPopupMenu popMenu3 = new JPopupMenu();
            JMenuItem menuItem3[] = new JMenuItem[3];
            menuItem3[1] = new JMenuItem("Chug");
            menuItem3[1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    V.messegeText.setText("You drink a Large Health Potion and gain 300 Health!");
                    V.iconInventoryPanel.remove(V.largePotionLabel);
                    V.iconInventoryPanel.revalidate();
                    V.iconInventoryPanel.repaint();
                    V.heroHealth += 300;
                    V.heroHP.setText(String.valueOf(V.heroHealth));

                    clip6.setMicrosecondPosition(0);
                    clip6.start();
                }
            });
            popMenu3.add(menuItem3[1]);

            V.largePotionLabel = new JLabel();
            V.largePotionLabel.setIcon(V.largePotionIcon);
            V.largePotionLabel.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {}
                public void mousePressed(MouseEvent e) {
                    popMenu3.show(V.largePotionLabel, e.getX(),e.getY());
                }
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
            });




            JPopupMenu popMenu4 = new JPopupMenu();
            JMenuItem menuItem4[] = new JMenuItem[3];
            menuItem4[1] = new JMenuItem("Chug");
            menuItem4[1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    V.messegeText.setText("You drink a Lage Mana Potion and gain 300 Mana!");
                    V.iconInventoryPanel.remove(V.largeManaPotionLabel);
                    V.iconInventoryPanel.revalidate();
                    V.iconInventoryPanel.repaint();
                    V.heroMana += 300;
                    V.heroMP.setText(String.valueOf(V.heroMana));
                    clip6.setMicrosecondPosition(0);
                    clip6.start();
                }
            });
            popMenu4.add(menuItem4[1]);

            V.largeManaPotionLabel = new JLabel();
            V.largeManaPotionLabel.setIcon(V.largeManaPotionIcon);
            V.largeManaPotionLabel.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {}
                public void mousePressed(MouseEvent e) {
                    popMenu4.show(V.largeManaPotionLabel, e.getX(),e.getY());
                }
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
            });









        V.inventoryLabel = new JLabel();
        V.inventoryLabel.setIcon(V.inventoryIcon);
        V.inventoryPanel.add(V.inventoryLabel);

        V.backgroundLabel = new JLabel();
        V.backgroundLabel.setIcon(V.backgroundIcon);
        V.backgroundPanel.add(V.backgroundLabel);

//        V.boxLabel = new JLabel();
//        V.boxLabel.setIcon(V.boxIcon);
//        V.heroStatImagePanel.add(V.boxLabel);

        //Text Areas
        V.titleText = new JTextArea();
        V.titleText.setText("Hero Fighters");
        V.titleText.setBackground(null);
        V.titleText.setEditable(false);
        V.titleText.setFont(new Font("Book Antiqua",Font.PLAIN,100));
        V.titleText.setForeground(Color.black);
        V.titleText.setOpaque(false);
        V.titlePanel.add(V.titleText);

        V.inventoryText = new JTextArea();
        V.inventoryText.setText("Inventory:");
        V.inventoryText.setBackground(null);
        V.inventoryText.setEditable(false);
        V.inventoryText.setFont(new Font("Book Antiqua",Font.PLAIN,35));
        V.inventoryText.setForeground(Color.BLACK);
        V.inventoryText.setOpaque(false);
        V.inventoryTextPanel.add(V.inventoryText);

        V.skillText = new JTextArea();
        V.skillText.setText("Skills:");
        V.skillText.setBackground(null);
        V.skillText.setOpaque(false);
        V.skillText.setEditable(false);
        V.skillText.setFont(new Font("Book Antiqua",Font.PLAIN,38));
        V.skillText.setForeground(Color.black);
        V.skillText.setBounds(75,0,100,45);
        V.skillPanel.add(V.skillText);

        V.heroHPText = new JTextArea();
        V.heroHPText.setText("Health: ");
        V.heroHPText.setBackground(null);
        V.heroHPText.setEditable(false);
        V.heroHPText.setFont(new Font("Book Antiqua",Font.PLAIN,24));
        V.heroHPText.setForeground(Color.black);
        V.heroHPText.setOpaque(false);
        V.heroStatPanel.add(V.heroHPText);

        V.heroHP = new JTextArea(String.valueOf(V.heroHealth));
        V.heroHP.setEditable(false);
        V.heroHP.setBackground(null);
        V.heroHP.setFont(new Font("Book Antiqua",Font.PLAIN,24));
        V.heroHP.setForeground(Color.black);
        V.heroHP.setOpaque(false);
        V.heroStatPanel.add(V.heroHP);

        V.heroMPText = new JTextArea();
        V.heroMPText.setText("Mana:");
        V.heroMPText.setBackground(null);
        V.heroMPText.setEditable(false);
        V.heroMPText.setFont(new Font("Book Antiqua",Font.PLAIN,24));
        V.heroMPText.setForeground(Color.black);
        V.heroMPText.setOpaque(false);
        V.heroStatPanel.add(V.heroMPText);

        V.heroMP = new JTextArea(String.valueOf(V.heroMana));
        V.heroMP.setEditable(false);
        V.heroMP.setBackground(null);
        V.heroMP.setFont(new Font("Book Antiqua",Font.PLAIN,24));
        V.heroMP.setForeground(Color.black);
        V.heroMP.setOpaque(false);
        V.heroStatPanel.add(V.heroMP);

        V.enemyHPText = new JTextArea();
        V.enemyHPText.setText("Health: ");
        V.enemyHPText.setBackground(null);
        V.enemyHPText.setEditable(false);
        V.enemyHPText.setFont(new Font("Book Antiqua",Font.PLAIN,24));
        V.enemyHPText.setForeground(Color.black);
        V.enemyStatPanel.add(V.enemyHPText);

        V.enemyHP = new JTextArea(String.valueOf(V.enemyHealth));
        V.enemyHP.setEditable(false);
        V.enemyHP.setBackground(null);
        V.enemyHP.setFont(new Font("Book Antiqua",Font.PLAIN,24));
        V.enemyHP.setForeground(Color.black);
        V.enemyStatPanel.add(V.enemyHP);

        V.messegeText = new JTextArea("This is sample text");
        V.messegeText.setEditable(false);
        V.messegeText.setBackground(null);
        V.messegeText.setForeground(Color.black);
        V.messegeText.setFont(new Font("Book Antiqua",Font.PLAIN,24));
        V.textPanel.add(V.messegeText);


        //Buttons
        V.attackButton = new JButton("Attack");
        V.attackButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));;
        V.attackButton.setFocusable(false);
        V.attackButton.addActionListener(tbg.aHandler);
//        tgh.attackButton.addActionListener(this);
        V.attackButton.setIcon(V.redbuttonIcon);
        V.attackButton.setContentAreaFilled(false);
        V.attackButton.setHorizontalTextPosition(JButton.CENTER);
        V.attackButton.setBounds(45,50,150,50);
        V.attackButton.setBorder(null);
        V.skillPanel.add(V.attackButton);

        V.healButton = new JButton("Heal");
        V.healButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));;
        V.healButton.setFocusable(false);
        V.healButton.addActionListener(tbg.aHandler);
        V.healButton.setHorizontalTextPosition(JButton.CENTER);
        V.healButton.setBounds(45,100,150,50);
        V.healButton.setIcon(V.greenIcon);
        V.healButton.setContentAreaFilled(false);
        V.healButton.setBorder(null);
        V.skillPanel.add(V.healButton);

        V.smiteButton = new JButton("Smite");
        V.smiteButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));;
        V.smiteButton.setFocusable(false);
        V.smiteButton.addActionListener(tbg.aHandler);
        V.smiteButton.setHorizontalTextPosition(JButton.CENTER);
        V.smiteButton.setBounds(45,150,150,50);
        V.smiteButton.setContentAreaFilled(false);
        V.smiteButton.setIcon(V.purpleIcon);
        V.smiteButton.setBorder(null);
        V.skillPanel.add(V.smiteButton);

        V.powerButton = new JButton("Power");
        V.powerButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));;
        V.powerButton.setFocusable(false);
        V.powerButton.addActionListener(tbg.aHandler);
        V.powerButton.setHorizontalTextPosition(JButton.CENTER);
        V.powerButton.setBounds(20,200,200,65);
        V.powerButton.setContentAreaFilled(false);
        V.powerButton.setIcon(V.fancyblueIcon);
        V.powerButton.setBorder(null);
        V.skillPanel.add(V.powerButton);

        V.nextButton = new JButton("Next");
        V.nextButton.setFont(new Font("Book Antiqua",Font.PLAIN,44));;
        V.nextButton.setFocusable(false);
        V.nextButton.addActionListener(tbg.aHandler);
        V.nextButton.setHorizontalTextPosition(JButton.CENTER);
        V.nextButton.setContentAreaFilled(false);
        V.nextButton.setIcon(V.nextIcon);
        V.nextButton.setBorder(null);
        V.menuPanel.add(V.nextButton);

        V.shopButton = new JButton("Loot");
        V.shopButton.setFont(new Font("Book Antiqua",Font.PLAIN,44));;
        V.shopButton.setFocusable(false);
        V.shopButton.addActionListener(tbg.aHandler);
        V.shopButton.setHorizontalTextPosition(JButton.CENTER);
        V.shopButton.setContentAreaFilled(false);
        V.shopButton.setIcon(V.shopIcon);
        V.shopButton.setBorder(null);
        V.menuPanel.add(V.shopButton);

        V.optionsButton = new JButton("Optons");
        V.optionsButton.setFont(new Font("Book Antiqua",Font.PLAIN,34));;
        V.optionsButton.setFocusable(false);
        V.optionsButton.setHorizontalTextPosition(JButton.CENTER);
        V.optionsButton.setContentAreaFilled(false);
        V.optionsButton.setIcon(V.greyIcon);
        V.optionsButton.setBorder(null);
        V.optionsPanel.add(V.optionsButton);

        V.exitButton = new JButton("Exit");
        V.exitButton.setFont(new Font("Book Antiqua",Font.PLAIN,34));;
        V.exitButton.setFocusable(false);
        V.exitButton.setHorizontalTextPosition(JButton.CENTER);
        V.exitButton.addActionListener(tbg.aHandler);
        V.exitButton.setContentAreaFilled(false);
        V.exitButton.setIcon(V.greyIcon);
        V.exitButton.setBorder(null);
        V.optionsPanel.add(V.exitButton);


        window.setVisible(true);
    }

}
