import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class TurnBasedGame{

    TurnGameHandler aHandler = new TurnGameHandler(this);
    Variables vari = new Variables(this);
    TurnGameUI turnUI = new TurnGameUI(this);

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        new TurnBasedGame();

    }

    public TurnBasedGame() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        aHandler.clip.open(aHandler.audioStream);
        aHandler.clip2.open(aHandler.audioStream2);
        aHandler.clip3.open(aHandler.audioStream3);
        aHandler.clip4.open(aHandler.audioStream4);
        aHandler.clip5.open(aHandler.audioStream5);
        turnUI.clip6.open(turnUI.audioStream6);
        aHandler.musicClip.open(aHandler.audioStream7);
        aHandler.musicClip2.open(aHandler.audioStream8);
        aHandler.musicClip3.open(aHandler.audioStream9);
        aHandler.finalClip.open(aHandler.audioStream10);

        FloatControl gainControl =
                (FloatControl) aHandler.musicClip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-20.0f);
        aHandler.musicClip.start();
    }

}
