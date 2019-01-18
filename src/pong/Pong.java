package pong;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import pong.PongConstants.AppWindowConstants;
import pong.PongConstants.BallConstants;
import pong.PongConstants.PaddleConstants;
import pong.PongConstants.PaddleConstants.PlayerOnePaddleConstants;
import pong.PongConstants.PaddleConstants.PlayerTwoPaddleConstants;

/*
 * TODO 
 * - Implement option to restart game
 */

public class Pong {
	private Pane rootNode;
	private Paddle Player1;
	private Paddle Player2;
	private ScoreCounter score;

	
	public Pong() {
		rootNode = new Pane();
		Player1 = new Paddle(PlayerOnePaddleConstants.getPlayerOneID());
		Player2 = new Paddle(PlayerTwoPaddleConstants.getPlayerTwoID());
		score = new ScoreCounter();
		rootNode.setStyle(AppWindowConstants.getColor());
		rootNode.getChildren().add(Player1.getPaddle());
		rootNode.getChildren().add(Player2.getPaddle());
		rootNode.getChildren().add(ScoreCounter.getPlayerOneScoreLabel());
		rootNode.getChildren().add(ScoreCounter.getPlayerTwoScoreLabel());

		Circle ball = Ball.getBall();
		Circle invisibleBall = Ball.getInvisibleBall();
		rootNode.getChildren().addAll(ball, invisibleBall);

	}

	public void playPong() {

		Circle ball = Ball.getBall();
		Circle invisibleBall = Ball.getInvisibleBall();
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> {
			ball.setLayoutX(ball.getLayoutX() + Ball.getVelocityX());
			ball.setLayoutY(ball.getLayoutY() + Ball.getVelocityY());
			invisibleBall.setLayoutX(invisibleBall.getLayoutX() + Ball.getInvisibleBallVelocityX());
			invisibleBall.setLayoutY(invisibleBall.getLayoutY() + Ball.getInvisibleBallVelocityY());
		    Player2.getPaddle().setLayoutY(invisibleBall.getLayoutY());

			if (ball.getBoundsInParent().intersects(Player1.getPaddle().getBoundsInParent())
					|| ball.getBoundsInParent().intersects(Player2.getPaddle().getBoundsInParent())) {
				Ball.setVelocityX(-1*BallConstants.getVelocityIncreaseFactor()*(Ball.getVelocityX()));
				Ball.setVelocityY(BallConstants.getVelocityIncreaseFactor()*(Ball.getVelocityY()));
				Ball.setInvisibleBallVelocity();
			}

			if (ball.getLayoutX() + BallConstants.getCentreX() <= ball.getRadius()) {
				ScoreCounter.incrementPlayerTwoScore();
				Ball.resetVelocityX(BallConstants.getInitialVelocityX(), BallConstants.getInitialVelocityY());
				Ball.resetBall();
			}
			
			//Multiply by 2 because looking at left most side of the ball
			if (ball.getLayoutX() + BallConstants.getCentreX() >= AppWindowConstants.getWidth() - 2*ball.getRadius()) {
				ScoreCounter.incrementPlayerOneScore();
				Ball.resetVelocityX(-BallConstants.getInitialVelocityX(), BallConstants.getInitialVelocityY());
				Ball.resetBall();
				
			}
			
			//Multiply by 2 because looking at left most side of the ball
			if (ball.getLayoutY() + BallConstants.getCentreY() <= ball.getRadius()
					|| ball.getLayoutY() + BallConstants.getCentreY() >= AppWindowConstants.getHeight() - 2*ball.getRadius()) {
				Ball.setVelocityY(-Ball.getVelocityY());
				Ball.setInvisibleBallVelocity();
			}

			if (ScoreCounter.playerOneReachedMaxScore()) {
				ScoreCounter.restartScore();
				ball.setLayoutY(ball.getLayoutY());
			}

			else if (ScoreCounter.playerTwoScoreReachedMaxScore()) {
				ScoreCounter.restartScore();
				ball.setLayoutY(ball.getLayoutY());
			}

		}));

		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

		rootNode.setOnMouseMoved(e -> {
			Player1.getPaddle().setLayoutY(e.getY() - PaddleConstants.getPaddleOffsetY());
		});

	}

	public Pane getRootNode() {
		return rootNode;
	}
}