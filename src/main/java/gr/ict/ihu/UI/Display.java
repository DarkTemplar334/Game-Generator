package gr.ict.ihu.UI;

public class Display {

    public void showCustomMessage(String message){
        System.out.println(message);
    }


    public void showGameChoices(){
        System.out.println("======================");
        System.out.println("roll\texit\tsave");
        System.out.println("======================");
    }

    public void showAvailableGames(){
        System.out.println("=============");
        System.out.println(" Snake\tLudo");
        System.out.println("=============");
    }
}
