package model;

import java.util.ArrayList; 
import java.util.Collection;
import java.util.Collections;

public class Deck {

	private ArrayList<CardType> aCards = new ArrayList<>();
	

	public Deck() 
	{
		
		for (Rank rank : Rank.values())
		{
			for (Suit suit : Suit.values())
			{
				aCards.add(new Card (rank, suit));
			}
		}

		Collections.shuffle(aCards);
	}

	
	
	public void add(CardType pCard)
	{
		aCards.add(pCard);
	}
	
	public void addAll(Collection<CardType> pCards)
	{
		aCards.addAll(pCards);
	}
	
	public CardType draw()
	{
		return aCards.remove(0);
	}
	
	public int size()
	{
		return aCards.size();
	}
	
	
	
}
