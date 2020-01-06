package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gui.DispatchedView;
import gui.PlayerView;

public class GameInstance {

	private static final GameInstance INSTANCE = new GameInstance();
	private Player aPlayer1 = new Player();
	private Player aPlayer2 = new Player();
	private Battlefield aBattlefield = new Battlefield();
	
	
	private GameInstance(){}
	
	public static GameInstance instance()
	{
		return INSTANCE;
	}
	
	public void restartGame()
	{
		aBattlefield.clear();
		aPlayer1.reset();
		aPlayer2.reset();
	}
	
	public void play()
	{
		CardType card1 = aPlayer1.deal();
		CardType card2 = aPlayer2.deal();
		
		aBattlefield.deploy(card1, card2);
		
	}
	
	public void updateState()
	{
		Optional<Player> winner = aBattlefield.findWinner(aPlayer1, aPlayer2);
		
		if (winner.isEmpty())
		{
			
			return;
		}
		else 
		{
			winner.get().won(aBattlefield);
			aBattlefield.clear();
		}
		
	}
	
	public CardType peekDispatched1()
	{
		return aBattlefield.peekDispatched1();
	}
	
	public CardType peekDispatched2()
	{
		return aBattlefield.peekDispatched2();
	}
	
	public void addDispatchedViews(DispatchedView pDV1, DispatchedView pDV2)
	{
		aBattlefield.addDispatchedViews(pDV1, pDV2);
	}
	
	
	public void addPlayer1View(PlayerView pPV)
	{
		aPlayer1.addPlayerView(pPV); 
	}
	
	public void addPlayer2View(PlayerView pPV)
	{
		aPlayer2.addPlayerView(pPV);
	}
	
	public Optional<ArrayList<Player>> getWinner() 
	{
		ArrayList<Player> players = new ArrayList<Player>(); 
		if(!aPlayer1.stillHasCards() && !aPlayer2.stillHasCards())
		{
			players.add(aPlayer1);
			players.add(aPlayer2);
			return Optional.of(players);
		}
		
		else if (!aPlayer1.stillHasCards())
		{
			players.add(aPlayer2);
			return Optional.of(players);
		}
		else if (!aPlayer2.stillHasCards())
		{
			players.add(aPlayer1);
			return Optional.of(players);
		}
		else
		{
			return Optional.empty();
		}
	}
	
	
	
	
	
}
