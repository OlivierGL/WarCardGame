package model;

public class FacingCard implements CardType{

	private CardType aCard;
	private boolean aFacingUp;
	
	public FacingCard(CardType pCard, boolean pFacingUp)
	{
		aCard = pCard;
		aFacingUp = pFacingUp;
	}
	
	public boolean facingUp()
	{
		return aFacingUp;
	}
	
	public Rank getRank()
	{
		return aCard.getRank();
	}
	
	public Suit getSuit()
	{
		return aCard.getSuit();
	}
	
	public CardType toCardType()
	{
		return aCard;
	}
	
	
	
	
	
}
