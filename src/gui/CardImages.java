package gui;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import model.CardType;

public class CardImages {

	private static final Map<String, Image> IMAGES = new HashMap<>();
	private static final String[] RANK_CODES = {"a","2","3","4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private static final String[] SUIT_CODES = {"c", "h", "s", "d"};
	private static final String PREFIX_LOCATION = "";
	private static final String SUFFIX_TYPE = ".gif";
	
	
	public static Image getCard(String pCode)
	{
		assert pCode != null;
		return IMAGES.computeIfAbsent(pCode, code -> new Image(CardImages.class.getClassLoader().getResourceAsStream(PREFIX_LOCATION + code + SUFFIX_TYPE)));
	}

	public static Image getBack()
	{
		return getCard("b");
	}
	
	public static String getCode(CardType pCard)
	{
		assert pCard != null;
		return RANK_CODES[pCard.getRank().ordinal()] + SUIT_CODES[pCard.getSuit().ordinal()];
	}
	
	public static Image getCard(CardType pCard)
	{
		assert pCard != null;
		return getCard(getCode(pCard));
	}
	
	public static void main(String[] args)
	{
		Image img = getCard("as");
	}
}
	
