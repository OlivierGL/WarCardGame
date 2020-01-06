package model;

import java.util.ArrayList;
import java.util.List;

public class DispatchedCards {

	private ArrayList<FacingCard> aCards = new ArrayList<>();
	
	
	public List<CardType> conquerCards()
	{
		ArrayList<CardType> cards = new ArrayList<>();
		for (FacingCard card : aCards)
		{
			cards.add(card.toCardType());
		}
		aCards.clear();
		return cards;
	}
	
	public void dispatchCard(FacingCard pCard)
	{
		aCards.add(pCard);
	}
	
	public void clear()
	{
		aCards.clear();
	}
	
	
	public FacingCard peek()
	{
		assert aCards.size()>=0;
		
		return aCards.get(aCards.size()-1);
	}
	
	public boolean facingUpNext()
	{
		return aCards.size()%2 == 0;
	}
	
	public boolean facingUp()
	{
		return !facingUpNext();
	}
	
}
