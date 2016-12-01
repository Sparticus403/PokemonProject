package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokemonController;
import java.awt.Dimension;

public class PokemonFrame extends JFrame
{
	private PokemonController baseController;
	private PokemonPanel appPanel;
	
	public PokemonFrame(PokemonController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new PokemonPanel(baseController);
		
		setupFrame();
	}
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Pokemon");
		this.setSize(new Dimension(900,600));
		this.setResizable(false);
		this.setVisible(true);
	}

}
