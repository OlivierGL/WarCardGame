package gui;



import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.GameInstance;
import model.Player;

public class War extends Application{

	private final int MARGIN_OUTER = 15;
	
	
	public static void main(String[] pArgs)
	{ 
		launch(pArgs);
	}
	
	public void start(Stage pPrimaryStage)
	{
		
		pPrimaryStage.setTitle("War Card Game");
		GameInstance game = GameInstance.instance();
		
		GridPane root = new GridPane();
        root.setStyle("-fx-background-color: green;");
		root.setHgap(MARGIN_OUTER);
		root.setVgap(MARGIN_OUTER);
        root.setPadding(new Insets(MARGIN_OUTER));
        
        Text winnerText = new Text();
		winnerText.setFill(Color.ORANGE);
		winnerText.setFont(Font.font ("Verdana", 25));
        
		Button draw = new Button("Draw");
		
		draw.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent pEvent)
			{
				if (draw.getText().equals("Draw")) 
				{
					game.play();
					draw.setText("Update");
				}
				else 
				{
					game.updateState();
					draw.setText("Draw");
					
					Optional<ArrayList<Player>> winner = game.getWinner();
					Optional<ArrayList<Player>> empty = Optional.empty();
					if (winner != empty )
					{
						ArrayList<Player> player = winner.get();
						if (player.size()>1)
						{
							winnerText.setText("The Players Have Tied!");
							winnerText.setVisible(true);
							draw.setVisible(false);
						}
						else
						{
							winnerText.setText(player.get(0).getName() + " Has Won!");
							winnerText.setVisible(true);
							draw.setVisible(false);
						}
					}

				}

			}
			
		});
		
		PlayerView player1V = new PlayerView(1);
		
		PlayerView player2V = new PlayerView(2);
		
		Button restart = new Button("Restart");
		restart.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent pEvent)
			{
				game.restartGame();
				draw.setText("Draw");
				draw.setVisible(true);
				player1V.cardsAdded();
				player2V.cardsAdded();
				winnerText.setVisible(false);
				
			}
			
		});
		

		DispatchedView dispatched1V = new DispatchedView();
		
		DispatchedView dispatched2V = new DispatchedView();
		
		game.addDispatchedViews(dispatched1V, dispatched2V);
		game.addPlayer1View(player1V);
		game.addPlayer2View(player2V);
		
		
		root.add(player1V , 0, 0);
		root.add(player2V, 1, 0);
		
		root.add(draw, 2, 0);
		root.add(restart, 3, 0);
		
		root.add(dispatched1V, 0, 2);
		root.add(dispatched2V, 1, 2);
		
		root.add(winnerText, 0,3,3,1);
	
		
		pPrimaryStage.setWidth(500);
	    pPrimaryStage.setHeight(450);
	    
		Scene scene = new Scene(root);
		pPrimaryStage.setScene(scene);
		pPrimaryStage.show();
	
		
	}
	
}
