package pong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pong.PongConstants.AppWindowConstants;
//TODO: IMPLEMENT IN C AND TRANSFER TO GBA EVENTUALLY 
public class Main extends Application {
	
	@Override
	public void start(Stage window) throws Exception {	
		
		window.setHeight(AppWindowConstants.getHeight());
		window.setWidth(AppWindowConstants.getWidth());
		window.setTitle(AppWindowConstants.getTitle());
		window.setResizable(false);
		
		Pong pong = new Pong();
		
		Scene scene = new Scene(pong.getRootNode());
		window.setScene(scene);
		
		pong.playPong();

		window.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}