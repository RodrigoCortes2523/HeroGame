public class Slot {
    slot2 s2 = new slot2();
    public static void main(String[] args){

        new Slot();

    }

    public Slot(){
        s2.createGame();
        s2.window.setVisible(true);
    }
}
