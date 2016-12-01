package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokemonController;
import java.awt.Dimension;

public class PokemonPanel extends JPanel
{
	private PokemonController baseController;
	private SpringLayout baseLayout;
	private JButton updateButton;
	private JComboBox pokedexSelector;
	private JLabel pokemonLabel;
	private JLabel healthLabel;
	private JLabel combatLabel;
	private JLabel speedLabel;
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel advancedLabel;
	private JTextField healthField;
	private JTextField combatField;
	private JTextField speedField;
	private JTextField nameField;
	private JTextField numberField;
	private JTextArea advancedArea;
	
	public PokemonPanel(PokemonController baseController)
	{
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		this.updateButton = new JButton("Update the stats!");
		this.pokedexSelector = new JComboBox(new String [] {"egg","geodude","pika","rattat"});
		this.pokemonLabel = new JLabel("The current pokemon");
		this.healthLabel = new JLabel("Health Points: ");
		this.combatLabel = new JLabel("Combat Points: ");
		this.speedLabel = new JLabel("speed rate: ");
		this.nameLabel = new JLabel("My name is: ");
		this.numberLabel = new JLabel("Pokemon number: ");
		this.advancedLabel = new JLabel("Advanced Information");
		this.healthField = new JTextField(5);
		this.combatField = new JTextField(5);
		this.speedField = new JTextField(5);
		this.nameField = new JTextField(5);
		this.advancedArea = new JTextArea(10,25);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		setPreferredSize(new Dimension(900,600));
		numberField.setEditable(false);
		this.add(updateButton);
		this.add(pokedexSelector);
		this.add(pokemonLabel);
		this.add(healthLabel);
		this.add(combatLabel);
		this.add(speedLabel);
		this.add(nameLabel);
		this.add(numberLabel);
		this.add(advancedLabel);
		this.add(healthField);
		this.add(combatField);
		this.add(speedField);
		this.add(nameField);
		this.add(advancedArea);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
