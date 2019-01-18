package pong;

import javafx.scene.shape.Rectangle;
import pong.PongConstants.PaddleConstants;
import pong.PongConstants.PaddleConstants.PlayerOnePaddleConstants;
import pong.PongConstants.PaddleConstants.PlayerTwoPaddleConstants;
public class Paddle {
	
	private Rectangle paddle;
	
	public Paddle(int playerNumber) {
		paddle = new Rectangle();
		paddle.setHeight(PaddleConstants.getHeight());
		paddle.setWidth(PaddleConstants.getWidth());
		paddle.setFill(PaddleConstants.getColor());
		
		if (playerNumber == 1) {
			paddle.setX(PlayerOnePaddleConstants.getPaddlePlayerOneOffsetX());
		}
		
		else if (playerNumber == 2) {
			paddle.setX(PlayerTwoPaddleConstants.getPaddlePlayerTwoOffsetX());
		}
		paddle.setY(PaddleConstants.getPaddleOffsetY());
	}
	
	public Rectangle getPaddle() {
		return paddle;
	}
}