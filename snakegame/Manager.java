package snakegame;
import java.util.Scanner;

public class Manager {
	public static void main(String[] args) {
		while(true) {
			run_game();
			if(!checkTryAgain())break;
		}
	}
 
	public static void run_game() {
 
        final int BOARD_WIDTH = 20; 
        final int BOARD_HEIGHT = 10; 
        final int START_X = BOARD_WIDTH / 2;
        final int START_Y = BOARD_HEIGHT / 2;
 
        Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        board.initBoard();
 
        RoomWall wall = new RoomWall('бр');
        wall.addRoomWallRow(board, wall, 0); 
        wall.addRoomWallRow(board, wall, board.getBoardHeight() - 1); 
        wall.addRoomWallColumn(board, wall, 0); 
        wall.addRoomWallColumn(board, wall, board.getBoardWidth() - 1); 
 
        SnakeElement snake = new SnakeElement('o', START_X, START_Y);
        board.setObjectOnLocation(snake, snake.getArrX(), snake.getArrY());
 
        AppleElement apple = new AppleElement('a');
        apple.addRandomApple(board, apple);
         
 
        Scanner scanner = new Scanner(System.in);
        char input;
        int appleCount = 0;
 
 
        boolean isRunning = true;
 
        while (isRunning) {
            board.printBoard(appleCount);
            
            switch (input = scanner.nextLine().charAt(0)) {
            case 'a':
                snake.moveLeft(board, snake, appleCount);
                break;
            case 'd':
                snake.moveRight(board, snake, appleCount);
                break;
            case 'w':
                snake.moveUp(board, snake, appleCount);
                break;
            case 's':
                snake.moveDown(board, snake, appleCount);
                break;
            }
        
            if(checkApple(snake, apple)) {
            	appleCount++;
            	apple.addRandomApple(board, apple);
            }else if (checkCrash(snake, board)) {
            		gameOverMsg();
            		return;
            }
        }
    }
	
	public static boolean checkTryAgain() {
		Scanner scanner = new Scanner(System.in);
		char input = scanner.nextLine().charAt(0); 
		return(input == 'y');
	}
    public static boolean checkApple(SnakeElement snake, AppleElement apple) {
    	return (snake.getArrX() == apple.getX() && snake.getArrY() == apple.getY());
    }
    
    public static boolean checkCrash(SnakeElement snake, Board board) {
    	return(snake.getArrX() == board.getBoardWidth() - 1 || snake.getArrX() == 0 ||
            	snake.getArrY() == board.getBoardHeight() - 1 || snake.getArrY() == 0);
    }
    
    public static void gameOverMsg() {
    	System.out.println("!!GameOver!!\nPress y to try again...");
    }
}