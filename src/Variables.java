import javax.swing.*;

public class Variables {
    TurnBasedGame tbg;

    JFrame window = new JFrame();
    JButton attackButton, healButton, smiteButton, powerButton,nextButton,shopButton,optionsButton,exitButton = new JButton();
    JPanel playerPanel,enemyPanel,inventoryPanel,menuPanel,textPanel,titlePanel,inventoryTextPanel,heroStatPanel,enemyStatPanel,backgroundPanel,skillPanel, optionsPanel, iconInventoryPanel, heroStatImagePanel = new JPanel();
    JTextArea titleText,inventoryText,skillText,heroHPText,heroMPText,enemyHPText,enemyHP, messegeText, heroHP, heroMP = new JTextArea();
    JLabel heroLabel,enemyLabel,inventoryLabel,backgroundLabel,potionLabel,manaPotionLabel,boxLabel,largePotionLabel,largeManaPotionLabel;

    ImageIcon heroIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\Characters\\blueHeroRight.png");
    ImageIcon badguyIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\Characters\\badGuy1.png");
    ImageIcon badguyIcon2 = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\Characters\\badGuy2.png");
    ImageIcon badguyIcon3 = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\Characters\\enemy4.png");
    ImageIcon jiggIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\Characters\\jigglypuff.png");

    ImageIcon potionIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\Items\\Potion\\Red Potion.png");
    ImageIcon manaPotionIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\Items\\Potion\\Blue Potion.png");
    ImageIcon largePotionIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\Items\\Potion\\Red Potion 3.png");
    ImageIcon largeManaPotionIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\Items\\Potion\\Blue Potion 3.png");

    ImageIcon redbuttonIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\redButton.png");
    ImageIcon greenIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\greeButton.png");
    ImageIcon blueIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\blueButton.png");
    ImageIcon orangeIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\orangeButton.png");
    ImageIcon purpleIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\purpleButton.png");
    ImageIcon fancyblueIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\fancyBlueButton2.png");
    ImageIcon nextIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\redMButton.png");
    ImageIcon shopIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\yellowMButton.png");
    ImageIcon greyIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\greyButton.png");
    ImageIcon inventoryIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\inventory200x500.png");

    ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\hill.png");
    ImageIcon boxIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\grayBox2.png");


    boolean bossDead = false;
    boolean bossTrig = false;
    boolean yourturn = true;
    boolean lootGot = false;
    boolean gotloot1 = false;
    boolean enemy2Dead = false;
    boolean enemy3Dead = false;
    int heroHealth = 200;
    int heroMana = 100;
    int enemyHealth = 100;
    int enemyDamage = 10;
    int playerDamage = 25;
    int healAmount = 100;
    int healManaCost = 25;
    int smiteDamage = 50;
    int smiteCost = 25;
    int powerDamage = 100;
    int powerCost = 50;


    public Variables(TurnBasedGame tbg){
        this.tbg = tbg;
    }

}
