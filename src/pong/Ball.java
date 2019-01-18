package pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pong.PongConstants.BallConstants;

public class Ball {
	private static Circle ball; 
	private static double velocityY;
	private static double velocityX;
	
	private static Circle invisibleBall;
	private static double invisibleVelocityY;
	private static double invisibleVelocityX;
	
	public static Circle getBall() {
		if (ball == null) {
			createBall();
		}
		return ball;
	}
	
	public static Circle getInvisibleBall() {
		if (invisibleBall == null) {
			createInvisibleBall();
		}
		return invisibleBall;
	}
	
	public static Circle createBall() {
		if (ball == null) {
			ball = new Circle();
			ball.setRadius(BallConstants.getRadius());
			ball.setFill(BallConstants.getColorWhite());
			ball.setCenterX(BallConstants.getCentreX());
			ball.setCenterY(BallConstants.getCentreY());
			velocityY = BallConstants.getInitialVelocityY();
			velocityX = BallConstants.getInitialVelocityX();
		}
		return ball;
	}
	
	public static Circle createInvisibleBall() {
		if (invisibleBall == null) {
			invisibleBall = new Circle();
			invisibleBall.setRadius(BallConstants.getRadius());
			invisibleBall.setFill(Color.TRANSPARENT);
			invisibleBall.setCenterX(BallConstants.getCentreX());
			invisibleBall.setCenterY(BallConstants.getCentreY());
			invisibleVelocityY = BallConstants.getInvisibleBallVelocityScaleFactor()*BallConstants.getInitialVelocityY();
			invisibleVelocityX = BallConstants.getInvisibleBallVelocityScaleFactor()*BallConstants.getInitialVelocityX();
		}
		return invisibleBall;
	}
	
	public static void resetVelocityX(double initialVelocityX, double initialVelocityY) {
		velocityX = initialVelocityX;
		velocityY = initialVelocityY;
		invisibleVelocityX = BallConstants.getInvisibleBallVelocityScaleFactor()*initialVelocityX; // TODO: Change to constants later, just a scale factor
		invisibleVelocityY = BallConstants.getInvisibleBallVelocityScaleFactor()*initialVelocityY;
	}

	
	public static void resetBall() {
		ball.relocate(BallConstants.getCentreX(), BallConstants.getCentreY());
		invisibleBall.relocate(BallConstants.getCentreX(), BallConstants.getCentreY());
	}
	
	public static double getVelocityX() {
		return velocityX;
	}
	
	public static double getVelocityY() {
		return velocityY;
	}
	
	public static void setVelocityX(double velocityX) {
		Ball.velocityX = velocityX; 
	}
	
	public static void setVelocityY(double velocityY) {
		Ball.velocityY = velocityY;
	}
	
	public static double getInvisibleBallVelocityX() {
		return invisibleVelocityX;
	}
	
	public static double getInvisibleBallVelocityY() {
		return invisibleVelocityY;
	}
	
	public static void setInvisibleBallVelocity() {
		invisibleVelocityX = BallConstants.getInvisibleBallVelocityScaleFactor()*velocityX;
		invisibleVelocityY = BallConstants.getInvisibleBallVelocityScaleFactor()*velocityY;
	}
}