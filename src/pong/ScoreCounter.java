package pong;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import pong.PongConstants.ScoreCounterConstants;
import pong.PongConstants.ScoreCounterConstants.PlayerOneScoreConstants;
import pong.PongConstants.ScoreCounterConstants.PlayerTwoScoreConstants;


public class ScoreCounter {
	private static int playerOneScore = ScoreCounterConstants.getInitialScore();
	private static int playerTwoScore = ScoreCounterConstants.getInitialScore();
	private static Label playerOneScoreLabel;
	private static Label playerTwoScoreLabel;
	
	public ScoreCounter() {
		playerOneScoreLabel = new Label(""+playerOneScore);
		playerTwoScoreLabel = new Label(""+playerTwoScore);
		
		playerOneScoreLabel.setFont(new Font(ScoreCounterConstants.getFontStyle(),
				ScoreCounterConstants.getFontSize()));
		playerTwoScoreLabel.setFont(new Font(ScoreCounterConstants.getFontStyle(), 
				ScoreCounterConstants.getFontSize()));
		
		playerOneScoreLabel.setLayoutX(PlayerOneScoreConstants.getPositionX());
		playerTwoScoreLabel.setLayoutX(PlayerTwoScoreConstants.getPositionX());
		
		playerOneScoreLabel.setPrefHeight(ScoreCounterConstants.getPrefSize());
		playerOneScoreLabel.setPrefWidth(ScoreCounterConstants.getPrefSize());
		
		playerTwoScoreLabel.setPrefHeight(ScoreCounterConstants.getPrefSize());
		playerTwoScoreLabel.setPrefHeight(ScoreCounterConstants.getPrefSize());
		
		playerOneScoreLabel.setTextFill(ScoreCounterConstants.getColor());
		playerTwoScoreLabel.setTextFill(ScoreCounterConstants.getColor());

	}
	
	public static void incrementPlayerOneScore() {
		playerOneScore += 1;
		playerOneScoreLabel.setText("" + playerOneScore);
	}
	
	public static Label getPlayerOneScoreLabel() {
		return playerOneScoreLabel;
	}
	
	public static int getPlayerOneScore() {
		return playerOneScore;
	}
	
	public static void incrementPlayerTwoScore() {
		playerTwoScore += 1;
		playerTwoScoreLabel.setText("" + playerTwoScore);
	}
	
	public static Label getPlayerTwoScoreLabel() {
		return playerTwoScoreLabel;
	}
	
	public static int getPlayerTwoScore() {
		return playerTwoScore;
	}
	
	public static void restartScore() {
		playerOneScore = ScoreCounterConstants.getInitialScore();
		playerTwoScore = ScoreCounterConstants.getInitialScore();
		playerOneScoreLabel.setText("" + playerOneScore);
		playerTwoScoreLabel.setText("" + playerTwoScore);
	}
	
	public static boolean playerOneReachedMaxScore() {
		if (ScoreCounter.getPlayerOneScore() == ScoreCounterConstants.getScoreNeeded()) {
			return true;
		}
		return false;
	}
	
	public static boolean playerTwoScoreReachedMaxScore() {
		if (ScoreCounter.getPlayerTwoScore() == ScoreCounterConstants.getScoreNeeded()) {
			return true;
		}
		return false;
	}
}