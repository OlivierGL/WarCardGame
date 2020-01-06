package gui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerView extends VBox{

	private static final String BUTTON_STYLE_NORMAL = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
	private final Button deck = new Button();
	private final Text aNumberOfCards = new Text();
	private TextField aName = new TextField();
	
	PlayerView(int numPlayer)
	{
		aName.setText("Player " + numPlayer);
		deck.setStyle(BUTTON_STYLE_NORMAL);
		deck.setGraphic(new ImageView(CardImages.getBack()));
		aNumberOfCards.setFill(Color.ORANGE);
		aNumberOfCards.setFont(Font.font ("Verdana", 13));
		getChildren().add(aName);
		getChildren().add(deck);
		getChildren().add(aNumberOfCards);
	}
	
	public void newCardNumber(int pSize)
	{
		aNumberOfCards.setText(pSize + " Cards left");
	}
	
	public void deckEmptied()
	{
		deck.setVisible(false);
	}
	
	public void cardsAdded()
	{
		deck.setVisible(true);
	}
	
	public String getName()
	{
		return aName.getText();
	}
}
