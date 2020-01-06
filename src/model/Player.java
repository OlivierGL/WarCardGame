package model;

import java.util.Collection;

import gui.PlayerView;

public class Player {

	
	private PlayerView aPView;
	private Deck aDeck = new Deck();
	
	public CardType deal()
	{
		if (aDeck.size() == 1)
		{
			aPView.deckEmptied();
		}
		CardType drawn = aDeck.draw();
		aPView.newCardNumber(aDeck.size());
		return drawn;
	}
	
	
	public void won(Battlefield pBattlefield)
	{
		aDeck.addAll(pBattlefield.retrieve());
		aPView.newCardNumber(aDeck.size());
		aPView.cardsAdded();

	}
	
	public void reset()
	{
		aDeck = new Deck();
		aPView.newCardNumber(aDeck.size());
	}
	
	public void addPlayerView(PlayerView pPView)
	{
		aPView = pPView;
		aPView.newCardNumber(aDeck.size());
	}
	
	public boolean stillHasCards()
	{
		return aDeck.size() > 0;
	}
	
	public String getName()
	{
		return aPView.getName();
	}
	
	
	
}
