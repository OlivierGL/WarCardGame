package model;

public class Card implements CardType{

	private Rank aRank;
	private Suit aSuit;
	
	public Card(Rank pRank, Suit pSuit)
	{
		aRank = pRank;
		aSuit = pSuit;
	}
	
	public Rank getRank()
	{
		return aRank;
	}
	
	public Suit getSuit()
	{
		return aSuit;
	}
	
	
}
