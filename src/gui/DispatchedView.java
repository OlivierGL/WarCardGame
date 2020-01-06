package gui;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.CardType;
import model.FacingCard;

public class DispatchedView extends VBox{

	private static final String BUTTON_STYLE_NORMAL = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
	private final Button dispatched = new Button();
	
	DispatchedView()
	{
		dispatched.setVisible(true);
		dispatched.setStyle(BUTTON_STYLE_NORMAL);
		getChildren().add(dispatched);
	}
	
	public void newCard(FacingCard pCard)
	{
		if (pCard.facingUp())
		{
			dispatched.setVisible(true);
			dispatched.setGraphic(new ImageView(CardImages.getCard(pCard)));
		}
		else 
		{
			dispatched.setVisible(true);
			dispatched.setGraphic(new ImageView(CardImages.getBack()));
		}
		
	}
	
	public void clear()
	{
		dispatched.setVisible(false);
		dispatched.setGraphic(new ImageView());
	}
	
}
