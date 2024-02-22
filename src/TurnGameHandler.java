import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;

public class TurnGameHandler implements ActionListener {

    TurnBasedGame tbg;

    File attackSound = new File("C:\\Users\\Rod\\Desktop\\Code Resourses\\Sounds\\sword1.wav");
    File enemyAttackSound = new File("C:\\Users\\Rod\\Desktop\\Code Resourses\\Sounds\\smallswordhit.wav");
    File healSound = new File("C:\\Users\\Rod\\Desktop\\Code Resourses\\Sounds\\healsound.wav");
    File smiteSound = new File("C:\\Users\\Rod\\Desktop\\Code Resourses\\Sounds\\largeswordattack1.wav");
    File powerSound = new File("C:\\Users\\Rod\\Desktop\\Code Resourses\\Sounds\\hitimpactsword.wav");
    File backgroundMusic = new File("C:\\Users\\Rod\\Desktop\\Code Resourses\\Sounds\\littleapprentice.wav");
    File backgroundMusic2 = new File("C:\\Users\\Rod\\Desktop\\Code Resourses\\Sounds\\themountains.wav");
    File backgroundMusic3 = new File("C:\\Users\\Rod\\Desktop\\Code Resourses\\Sounds\\takecover.wav");
    File finalMusic = new File("C:\\Users\\Rod\\Desktop\\Code Resourses\\Sounds\\jigg.wav");


    AudioInputStream audioStream = AudioSystem.getAudioInputStream(attackSound);
    AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(enemyAttackSound);
    AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(healSound);
    AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(smiteSound);
    AudioInputStream audioStream5 = AudioSystem.getAudioInputStream(powerSound);
    AudioInputStream audioStream7 = AudioSystem.getAudioInputStream(backgroundMusic);
    AudioInputStream audioStream8 = AudioSystem.getAudioInputStream(backgroundMusic2);
    AudioInputStream audioStream9 = AudioSystem.getAudioInputStream(backgroundMusic3);
    AudioInputStream audioStream10 = AudioSystem.getAudioInputStream(finalMusic);

    Clip clip = AudioSystem.getClip();
    Clip clip2 = AudioSystem.getClip();
    Clip clip3 = AudioSystem.getClip();
    Clip clip4 = AudioSystem.getClip();
    Clip clip5 = AudioSystem.getClip();
    Clip musicClip = AudioSystem.getClip();
    Clip musicClip2 = AudioSystem.getClip();
    Clip musicClip3 = AudioSystem.getClip();
    Clip finalClip = AudioSystem.getClip();


    Timer enemyAttackTimer = new Timer(1200, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(tbg.turnUI.V.enemyHealth > 0) {
                tbg.turnUI.V.heroHealth -= tbg.turnUI.V.enemyDamage;
                tbg.turnUI.V.heroHP.setText(String.valueOf(tbg.turnUI.V.heroHealth));
                tbg.turnUI.V.messegeText.setText("Enemy attacks you and you receive " + tbg.turnUI.V.enemyDamage + " damage.");

                clip2.setMicrosecondPosition(0);
                clip2.start();
            }

            else if(tbg.turnUI.V.heroHealth <= 0){
                tbg.turnUI.V.messegeText.setText("Game Over");
                tbg.turnUI.V.attackButton.setVisible(false);
                tbg.turnUI.V.smiteButton.setVisible(false);
                tbg.turnUI.V.powerButton.setVisible(false);
                tbg.turnUI.V.healButton.setVisible(false);
            }
            else if (tbg.turnUI.V.bossTrig ==true && tbg.turnUI.V.enemyHealth <= 0){
                tbg.turnUI.V.messegeText.setText("You Win!");
                tbg.turnUI.V.attackButton.setVisible(false);
                tbg.turnUI.V.smiteButton.setVisible(false);
                tbg.turnUI.V.powerButton.setVisible(false);
                tbg.turnUI.V.healButton.setVisible(false);
                tbg.turnUI.V.nextButton.setVisible(false);

                musicClip3.stop();

                FloatControl gainControl =
                        (FloatControl) finalClip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-20.0f);
                finalClip.start();
                tbg.turnUI.V.enemyLabel.setIcon(tbg.turnUI.V.jiggIcon);
                tbg.turnUI.V.enemyHP.setText("♭♭♭");
            }
            heroTurn();
            enemyAttackTimer.stop();
        }
    });

    public TurnGameHandler(TurnBasedGame tbg) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.tbg = tbg;
    }
    public void goNext(){
        tbg.turnUI.V.messegeText.setText("Enemy is dead, Go next.");
    }
    public void noMana(){
        tbg.turnUI.V.messegeText.setText("Not enough mana!");
    }
    public void enemyturn(){
        tbg.turnUI.V.attackButton.setEnabled(false);
        tbg.turnUI.V.smiteButton.setEnabled(false);
        tbg.turnUI.V.powerButton.setEnabled(false);

    }
    public void heroTurn(){
        tbg.turnUI.V.attackButton.setEnabled(true);
        tbg.turnUI.V.smiteButton.setEnabled(true);
        tbg.turnUI.V.powerButton.setEnabled(true);
    }



    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==tbg.turnUI.V.attackButton){
            if (tbg.turnUI.V.enemyHealth > 0){

                tbg.turnUI.V.messegeText.setText("You attack for 25 damage.");
                tbg.turnUI.V.enemyHealth -= tbg.turnUI.V.playerDamage;
                tbg.turnUI.V.enemyHP.setText(String.valueOf(tbg.turnUI.V.enemyHealth));

                clip.setMicrosecondPosition(0);
                clip.start();

                enemyturn();
                enemyAttackTimer.start();
            }
            else{
                goNext();
            }
        }
        if(e.getSource()==tbg.turnUI.V.healButton){
            if (tbg.turnUI.V.heroHealth < 200 && tbg.turnUI.V.heroMana >= tbg.turnUI.V.healManaCost){
                tbg.turnUI.V.messegeText.setText("You heal for 100 health.");
                tbg.turnUI.V.heroMana -= tbg.turnUI.V.healManaCost;
                tbg.turnUI.V.heroMP.setText(String.valueOf(tbg.turnUI.V.heroMana));
                tbg.turnUI.V.heroHealth += tbg.turnUI.V.healAmount;
                tbg.turnUI.V.heroHP.setText(String.valueOf(tbg.turnUI.V.heroHealth));

                FloatControl gainControl =
                        (FloatControl) clip3.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-20.0f);
                clip3.setMicrosecondPosition(0);
                clip3.start();
            }
            else if(tbg.turnUI.V.heroMana < tbg.turnUI.V.healManaCost){
                noMana();
            }
            else if (tbg.turnUI.V.heroHealth >= 200){
                tbg.turnUI.V.messegeText.setText("You are already at full health.");
            }
        }
        if(e.getSource()==tbg.turnUI.V.smiteButton){
            if (tbg.turnUI.V.heroMana >= tbg.turnUI.V.smiteCost && tbg.turnUI.V.enemyHealth > 0) {
                tbg.turnUI.V.messegeText.setText("You smite for 50 damage!");
                tbg.turnUI.V.enemyHealth -= tbg.turnUI.V.smiteDamage;
                tbg.turnUI.V.enemyHP.setText(String.valueOf(tbg.turnUI.V.enemyHealth));
                tbg.turnUI.V.heroMana -= tbg.turnUI.V.smiteCost;
                tbg.turnUI.V.heroMP.setText(String.valueOf(tbg.turnUI.V.heroMana));

                clip4.setMicrosecondPosition(0);
                clip4.start();

                enemyturn();
                enemyAttackTimer.start();
            }
            else if (tbg.turnUI.V.enemyHealth <=0){
                goNext();
            }
            else if (tbg.turnUI.V.heroMana < tbg.turnUI.V.smiteCost){
                noMana();
            }

        }
        if(e.getSource()==tbg.turnUI.V.powerButton){
            if(tbg.turnUI.V.heroMana >= tbg.turnUI.V.powerCost && tbg.turnUI.V.enemyHealth > 0) {
                tbg.turnUI.V.messegeText.setText("You unleash all of your holy power and deal 100 damage!");
                tbg.turnUI.V.enemyHealth -= tbg.turnUI.V.powerDamage;
                tbg.turnUI.V.enemyHP.setText(String.valueOf(tbg.turnUI.V.enemyHealth));
                tbg.turnUI.V.heroMana -= tbg.turnUI.V.powerCost;
                tbg.turnUI.V.heroMP.setText(String.valueOf(tbg.turnUI.V.heroMana));

                clip5.setMicrosecondPosition(0);
                clip5.start();

                enemyturn();
                enemyAttackTimer.start();
            }
            else if (tbg.turnUI.V.enemyHealth <=0){
                goNext();
            }
            else if(tbg.turnUI.V.heroMana <= tbg.turnUI.V.powerCost) {
                noMana();
            }
        }
        if (e.getSource() == tbg.turnUI.V.nextButton) {
            if (tbg.turnUI.V.lootGot==false){
                tbg.turnUI.V.messegeText.setText("Dont forget your loot!");

            }
            else if(tbg.turnUI.V.enemy2Dead==true){
                tbg.turnUI.V.enemyLabel.setIcon(tbg.turnUI.V.badguyIcon3);
                tbg.turnUI.V.enemyHealth = 500;
                tbg.turnUI.V.enemyHP.setText(String.valueOf(tbg.turnUI.V.enemyHealth));
                tbg.turnUI.V.enemyDamage = 50;
                tbg.turnUI.V.bossTrig = true;

                musicClip2.stop();
                FloatControl gainControl =
                        (FloatControl) musicClip3.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-20.0f);
                musicClip3.start();


            }
            else if(tbg.turnUI.V.enemyHealth <= 0){
                tbg.turnUI.V.messegeText.setText("A new enemy appears!");
                tbg.turnUI.V.enemyLabel.setIcon(tbg.turnUI.V.badguyIcon2);
                tbg.turnUI.V.enemyHealth = 300;
                tbg.turnUI.V.enemyHP.setText(String.valueOf(tbg.turnUI.V.enemyHealth));
                tbg.turnUI.V.enemyDamage = 25;
                tbg.turnUI.V.enemy2Dead = true;
                tbg.turnUI.V.lootGot = false;

                musicClip.stop();
                FloatControl gainControl =
                        (FloatControl) musicClip2.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-20.0f);
                musicClip2.start();
            }
            else{
                tbg.turnUI.V.messegeText.setText("Current enemy is not dead yet.");
            }
        }
        if(e.getSource()==tbg.turnUI.V.shopButton){
            if(tbg.turnUI.V.enemyHealth <= 0 && tbg.turnUI.V.lootGot==false && tbg.turnUI.V.enemy2Dead==true){
                tbg.turnUI.V.iconInventoryPanel.add(tbg.turnUI.V.largePotionLabel);
                tbg.turnUI.V.iconInventoryPanel.add(tbg.turnUI.V.largeManaPotionLabel);
                tbg.turnUI.V.iconInventoryPanel.revalidate();
                tbg.turnUI.V.iconInventoryPanel.repaint();
                tbg.turnUI.V.lootGot = true;
            }
            else if(tbg.turnUI.V.enemyHealth <= 0 && tbg.turnUI.V.lootGot==false && tbg.turnUI.V.gotloot1==false){

                tbg.turnUI.V.messegeText.setText("You receive loot!");
                tbg.turnUI.V.iconInventoryPanel.add(tbg.turnUI.V.potionLabel);
                tbg.turnUI.V.iconInventoryPanel.add(tbg.turnUI.V.manaPotionLabel);
                tbg.turnUI.V.iconInventoryPanel.revalidate();
                tbg.turnUI.V.iconInventoryPanel.repaint();
                tbg.turnUI.V.lootGot = true;
                tbg.turnUI.V.gotloot1 = true;
            }
            else {
                tbg.turnUI.V.messegeText.setText("There is no loot, deafeat enemys to gain loot.");
            }

        }
        if(e.getSource()==tbg.turnUI.V.exitButton){
            System.exit(0);
        }


    }
}


