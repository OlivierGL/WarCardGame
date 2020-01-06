package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import gui.DispatchedView;

public class Battlefield {

	private final DispatchedCards aDispatched1 = new DispatchedCards();
	private final DispatchedCards aDispatched2 = new DispatchedCards();
	
	private DispatchedView aD1V;
	private DispatchedView aD2V;
	
	
	//pCard1 is the one played by player 1, pCard2 is the card played by player 2
	public void deploy(CardType pCard1, CardType pCard2)
	{
		FacingCard card1 = new FacingCard(pCard1, aDispatched1.facingUpNext());
		FacingCard card2 = new FacingCard(pCard2, aDispatched2.facingUpNext());
		
		aDispatched1.dispatchCard(card1);
		aD1V.newCard(card1);
		
		aDispatched2.dispatchCard(card2);
		aD2V.newCard(card2);
	}
	
	//returns all the cards on the battlefield
	public List<CardType> retrieve()
	{
		ArrayList<CardType> allTroops = new ArrayList<>(aDispatched1.conquerCards());
		allTroops.addAll(aDispatched2.conquerCards());
		
		return allTroops;
	}
	
	//clears the battlefield
	public void clear()
	{
		aDispatched1.clear();
		aD1V.clear();
		aDispatched2.clear();
		aD2V.clear();
		
	}
	
	
	public Optional<Player> findWinner(Player pPlayer1, Player pPlayer2)
	{
		if (!(aDispatched1.facingUp()))
		{
			return Optional.empty();
		}
		
		Comparator<FacingCard> comparator= Comparator.comparing(FacingCard::getRank);
		int comparison = comparator.compare(aDispatched1.peek(),aDispatched2.peek());
		 
		if (comparison == 0)
			return Optional.empty();
		else if (comparison < 0)
			return Optional.of(pPlayer2);
		else 
			return Optional.of(pPlayer1);
	}
	
	public CardType peekDispatched1()
	{
		return aDispatched1.peek();
	}
	
	public CardType peekDispatched2()
	{
		return aDispatched2.peek();
	}
	
	public void addDispatchedViews(DispatchedView pD1V, DispatchedView pD2V )
	{
		aD1V = pD1V;
		aD2V = pD2V;
	}
}
