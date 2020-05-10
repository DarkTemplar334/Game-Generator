package gr.ict.ihu.Input;

import java.util.Scanner;

public class UserInput {

    public String getUserInputAsString(){
        Scanner obj = new Scanner(System.in);
        String input = obj.nextLine();
        return input;
    }

    public int getUserInputAsInteger(){
        Scanner obj = new Scanner(System.in);
        int input= Integer.parseInt(obj.nextLine());
        return input;
    }
}
