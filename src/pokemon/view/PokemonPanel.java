package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokemonController;

import java.awt.Color;
import java.awt.Dimension;

public class PokemonPanel extends JPanel
{
	private PokemonController baseController;
	private SpringLayout baseLayout;
	private JButton updateButton;
	private ImageIcon pokemonIcon;
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
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/Pokeball.svg"));
		this.pokedexSelector = new JComboBox(new String [] {"egg","geodude","pika","rattat"});
		this.pokemonLabel = new JLabel("The current pokemon", pokemonIcon, SwingConstants.CENTER);
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
		advancedArea.setEditable(false);
		advancedArea.setWrapStyleWord(true);
		advancedArea.setLineWrap(true);
		this.setBackground(Color.lightGray);
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
		baseLayout.putConstraint(SpringLayout.NORTH, pokemonLabel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, pokemonLabel, 320, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, pokemonLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, combatLabel, -461, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, healthLabel, 28, SpringLayout.SOUTH, combatLabel);
		baseLayout.putConstraint(SpringLayout.WEST, combatLabel, 0, SpringLayout.WEST, pokemonLabel);
		baseLayout.putConstraint(SpringLayout.WEST, speedLabel, 0, SpringLayout.WEST, pokemonLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, speedLabel, -371, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 16, SpringLayout.SOUTH, pokemonLabel);
		baseLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, pokemonLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, numberLabel, 4, SpringLayout.NORTH, pokedexSelector);
		baseLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, updateButton);
		baseLayout.putConstraint(SpringLayout.NORTH, advancedLabel, 82, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, pokedexSelector, 17, SpringLayout.EAST, advancedLabel);
		baseLayout.putConstraint(SpringLayout.WEST, advancedLabel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, healthField, -6, SpringLayout.NORTH, healthLabel);
		baseLayout.putConstraint(SpringLayout.WEST, healthField, 22, SpringLayout.EAST, healthLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, combatField, -6, SpringLayout.NORTH, combatLabel);
		baseLayout.putConstraint(SpringLayout.EAST, combatField, 0, SpringLayout.EAST, healthField);
		baseLayout.putConstraint(SpringLayout.NORTH, updateButton, 24, SpringLayout.SOUTH, speedField);
		baseLayout.putConstraint(SpringLayout.NORTH, speedField, 207, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, speedField, 0, SpringLayout.EAST, healthField);
		baseLayout.putConstraint(SpringLayout.NORTH, nameField, 6, SpringLayout.SOUTH, pokemonLabel);
		baseLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, healthField);
		baseLayout.putConstraint(SpringLayout.SOUTH, pokedexSelector, -6, SpringLayout.NORTH, advancedArea);
		baseLayout.putConstraint(SpringLayout.WEST, updateButton, 8, SpringLayout.EAST, advancedArea);
		baseLayout.putConstraint(SpringLayout.NORTH, advancedArea, 6, SpringLayout.SOUTH, advancedLabel);
		baseLayout.putConstraint(SpringLayout.WEST, advancedArea, 10, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		
	}
}
