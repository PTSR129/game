package snakegame;

public class SnakeElement extends BoardComponent {
	 
    public SnakeElement(char symbol, int xStartingLocation, int yStartingLocation) {
        setIcon(symbol);
        setArrX(xStartingLocation);
        setArrY(yStartingLocation);
    }
     
    public void moveLeft(Board screen, SnakeElement snake, int appleCount) {
    	snake.setArrY(getArrY());
        snake.setArrX(getArrX() - 1);
        if(appleCount == 0)screen.ClearScreenLocation(snake.getArrX() + 1, snake.getArrY());
        else {
        	screen.printObjectOnLocation('~', snake.getArrX() + 1, snake.getArrY());
        	screen.ClearScreenLocation(snake.getLastX(appleCount), snake.getLastY(appleCount));
        }
        screen.setObjectOnLocation(snake, snake.getArrX(), snake.getArrY());
    }
     
    public void moveRight(Board screen, SnakeElement snake, int appleCount) {
    	snake.setArrY(getArrY());
    	snake.setArrX(getArrX() + 1);
    	if(appleCount == 0)screen.ClearScreenLocation(snake.getArrX() - 1, snake.getArrY());
    	else {
        	screen.printObjectOnLocation('~', snake.getArrX() - 1, snake.getArrY());
        	screen.ClearScreenLocation(snake.getLastX(appleCount), snake.getLastY(appleCount));
        }
    	screen.setObjectOnLocation(snake, snake.getArrX(), snake.getArrY());
    }
     
    public void moveUp(Board screen, SnakeElement snake, int appleCount) {
    	snake.setArrX(getArrX());
    	snake.setArrY(getArrY() - 1);
    	if(appleCount == 0)screen.ClearScreenLocation(snake.getArrX(), snake.getArrY() + 1);
    	else {
        	screen.printObjectOnLocation('~', snake.getArrX(), snake.getArrY() + 1);
        	screen.ClearScreenLocation(snake.getLastX(appleCount), snake.getLastY(appleCount));
        }
    	screen.setObjectOnLocation(snake, snake.getArrX(), snake.getArrY());
    }
     
    public void moveDown(Board screen, SnakeElement snake, int appleCount) {
    	snake.setArrX(getArrX());
    	snake.setArrY(getArrY() + 1);
    	if(appleCount == 0)screen.ClearScreenLocation(snake.getArrX(), snake.getArrY() - 1);
    	else {
        	screen.printObjectOnLocation('~', snake.getArrX(), snake.getArrY() - 1);
        	screen.ClearScreenLocation(snake.getLastX(appleCount), snake.getLastY(appleCount));
        }
    	screen.setObjectOnLocation(snake, snake.getArrX(), snake.getArrY());
    }
}