package pong;

import javafx.scene.paint.Color;

public class PongConstants {

	public static class AppWindowConstants {

		private static final double APP_HEIGHT = 1000;

		public static double getHeight() {
			return APP_HEIGHT;
		}

		private static final double APP_WIDTH = 1000;

		public static final double getWidth() {
			return APP_WIDTH;
		}

		private static final String APP_TITLE = "Pong";

		public static String getTitle() {
			return APP_TITLE;
		}

		private static final String WINDOW_COLOR = "-fx-background-color: #000000";

		public static String getColor() {
			return WINDOW_COLOR;
		}
	}

	public static class BallConstants {

		private static final double RADIUS = 20;

		public static double getRadius() {
			return RADIUS;
		}

		private static final Color BALL_COLOR = Color.WHITE;

		public static Color getColorWhite() {
			return BALL_COLOR;
		}

		private static final Color INVISIBLE_BALL_COLOR = Color.BLACK;

		public static Color getColorBlack() {
			return INVISIBLE_BALL_COLOR;
		}

		private static final double BALL_CENTRE_X = AppWindowConstants.getWidth() / 2;

		public static double getCentreX() {
			return BALL_CENTRE_X;
		}

		private static final double BALL_CENTRE_Y = AppWindowConstants.getHeight() / 2;

		public static double getCentreY() {
			return BALL_CENTRE_Y;
		}

		private static final int INITIAL_VELOCITY_X = 4;

		public static int getInitialVelocityX() {
			return INITIAL_VELOCITY_X;
		}

		private static final int INITIAL_VELOCITY_Y = 2;

		public static int getInitialVelocityY() {
			return INITIAL_VELOCITY_Y;
		}

		private static final double VELOCITY_INCREASE_FACTOR = 1.15;

		public static double getVelocityIncreaseFactor() {
			return VELOCITY_INCREASE_FACTOR;
		}

		public static final double INVISIBLE_BALL_VELOCITY_SCALE_FACTOR = 1.25;

		public static double getInvisibleBallVelocityScaleFactor() {
			return INVISIBLE_BALL_VELOCITY_SCALE_FACTOR;
		}
	}

	public static class PaddleConstants {
		private static final double PADDLE_HEIGHT = 250;

		public static double getHeight() {
			return PADDLE_HEIGHT;
		}

		private static final double PADDLE_WIDTH = 20;

		public static double getWidth() {
			return PADDLE_WIDTH;
		}

		private static final Color PADDLE_COLOR = Color.WHITE;

		public static Color getColor() {
			return PADDLE_COLOR;
		}

		private static final double PADDLE_Y_OFFSET = (AppWindowConstants.getHeight() - PaddleConstants.getHeight())
				/ 2;

		public static double getPaddleOffsetY() {
			return PADDLE_Y_OFFSET;

		}

		public static class PlayerOnePaddleConstants {

			private static final int PLAYER_ONE_ID = 1;

			public static int getPlayerOneID() {
				return PLAYER_ONE_ID;
			}

			public static final double PADDLE_PLAYER_ONE_OFFSET_X = 40;

			public static double getPaddlePlayerOneOffsetX() {
				return PADDLE_PLAYER_ONE_OFFSET_X;
			}
		}

		public static class PlayerTwoPaddleConstants {

			private static final int PLAYER_TWO_ID = 2;

			public static int getPlayerTwoID() {
				return PLAYER_TWO_ID;
			}

			private static final double PADDLE_PLAYER_TWO_OFFSET_X = AppWindowConstants.getWidth()
					- PlayerOnePaddleConstants.getPaddlePlayerOneOffsetX() - PaddleConstants.getWidth();

			public static double getPaddlePlayerTwoOffsetX() {
				return PADDLE_PLAYER_TWO_OFFSET_X;
			}

		}
	}

	public static class ScoreCounterConstants {
		private static final int SCORE_NEEDED = 10;

		public static int getScoreNeeded() {
			return SCORE_NEEDED;
		}

		private static final int INITIAL_SCORE = 0;

		public static int getInitialScore() {
			return INITIAL_SCORE;
		}

		private static final int FONT_SIZE = 50;

		public static int getFontSize() {
			return FONT_SIZE;
		}

		private static final int PREF_SIZE = 200;

		public static int getPrefSize() {
			return PREF_SIZE;
		}

		private static final String FONT_STYLE = "Arial";

		public static String getFontStyle() {
			return FONT_STYLE;
		}

		private static final Color TEXT_COLOR = Color.WHITE;

		public static Color getColor() {
			return TEXT_COLOR;
		}

		public static class PlayerOneScoreConstants {
			private static final double POSITION_X = AppWindowConstants.getWidth() / 4;

			public static double getPositionX() {
				return POSITION_X;
			}
		}

		public static class PlayerTwoScoreConstants {
			private static final double POSITION_X = 3 * AppWindowConstants.getWidth() / 4;

			public static double getPositionX() {
				return POSITION_X;
			}
		}
	}

}