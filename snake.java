import java.util.Random;
import java.util.Scanner;
public class snake
{
    static String[][] board = new String[10][10];
    static int[] snakeX = new int[100];
    static int[] snakeY = new int[100];
    static int length = 1;
    static int foodX, foodY;
    static char move;
    static void board()
    {
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                board[i][j] = ". ";
            }
        }
        snakeX[0] = 5;
        snakeY[0] = 5;
        food();
    }
    public static void displayboard() 
    {
        System.out.print('\u000C');
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                if (i == foodY && j == foodX) 
                {
                    System.out.print("o ");
                } 
                else 
                {
                    boolean flag = false;
                    for (int k = 0; k < length; k++) 
                    {
                        if (snakeX[k] == j && snakeY[k] == i) 
                        {
                            System.out.print("* ");
                            flag = true;
                        }
                    }
                    if (flag == false) 
                    {
                        System.out.print(board[i][j]);
                    }
                }
            }
            System.out.println();
        }
    }
    public static void input() 
    {
        Scanner sc = new Scanner(System.in);
        move = sc.next().charAt(0);
    }
    public static void move() 
    {
        for (int i = length - 1; i > 0; i--) 
        {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        if(move == 'w')
        {
            snakeY[0] = snakeY[0] - 1;
        }
        if(move == 'a')
        {
            snakeX[0] = snakeX[0] - 1;
        }
        if(move == 's')
        {
            snakeY[0] = snakeY[0] + 1;
        }
        if(move == 'd')
        {
            snakeX[0] = snakeX[0] + 1;
        }
    }
    public static void boundary() 
    {
        if (snakeX[0] < 0 || snakeX[0] >= 10 || snakeY[0] < 0 || snakeY[0] >= 10) 
        {
            System.out.println("Game Over.");
            System.exit(0);
        }
        for (int i = 1; i < length; i++) 
        {
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) 
            {
                System.out.println("Game Over.");
                System.exit(0);
            }
        }
    }
    public static void foodcheck()
    {
        if (snakeX[0] == foodX && snakeY[0] == foodY) 
        {
            length++;
            food();
        }
    }
    public static void food() 
    {
        Random random = new Random();
        foodX = random.nextInt(10);
        foodY = random.nextInt(10);
    }
    public static void main() 
    {
        board();
        for(;;) 
        {
            displayboard();
            input();
            move();
            boundary();
            foodcheck();
        }
    }
}
