import java.util.Scanner;

public class Player {

    private String name;
    private int points;
    private Scanner sc = new Scanner(System.in);

    public Player(){
        System.out.println("Please enter a player name: ");
        this.name = sc.nextLine();
        points = 0;
    }

    public Player(String name){
        this.name = name;
        points = 0;
    }
public String getName(){
    return name;
}
public int getPoints(){
    return points;
}
public void addPoint(){
    points = points + 1;
}
}
