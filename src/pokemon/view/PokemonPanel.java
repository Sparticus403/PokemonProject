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
		this.numberField = new JTextField(5);
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
		
		pokemonLabel.setVerticalTextPosition(JLabel.BOTTOM);
		pokemonLabel.setHorizontalTextPosition(textPosition);
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
		this.add(numberField);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, pokedexSelector, -4, SpringLayout.NORTH, pokemonLabel);
		baseLayout.putConstraint(SpringLayout.WEST, pokedexSelector, 36, SpringLayout.EAST, pokemonLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, pokemonLabel, 75, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, pokemonLabel, 28, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, healthLabel, 0, SpringLayout.EAST, combatLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, combatLabel, 17, SpringLayout.SOUTH, nameLabel);
		baseLayout.putConstraint(SpringLayout.WEST, speedLabel, 0, SpringLayout.WEST, nameLabel);
		baseLayout.putConstraint(SpringLayout.EAST, nameLabel, 0, SpringLayout.EAST, combatLabel);
		baseLayout.putConstraint(SpringLayout.EAST, numberLabel, 0, SpringLayout.EAST, healthLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, numberLabel, -12, SpringLayout.NORTH, advancedLabel);
		baseLayout.putConstraint(SpringLayout.WEST, advancedLabel, 0, SpringLayout.WEST, updateButton);
		baseLayout.putConstraint(SpringLayout.NORTH, healthLabel, 6, SpringLayout.NORTH, healthField);
		baseLayout.putConstraint(SpringLayout.NORTH, healthField, 6, SpringLayout.SOUTH, combatField);
		baseLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, combatField);
		baseLayout.putConstraint(SpringLayout.EAST, combatLabel, -6, SpringLayout.WEST, combatField);
		baseLayout.putConstraint(SpringLayout.NORTH, speedLabel, 6, SpringLayout.NORTH, speedField);
		baseLayout.putConstraint(SpringLayout.NORTH, speedField, 6, SpringLayout.SOUTH, healthField);
		baseLayout.putConstraint(SpringLayout.WEST, speedField, 0, SpringLayout.WEST, healthField);
		baseLayout.putConstraint(SpringLayout.NORTH, combatField, 5, SpringLayout.SOUTH, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 6, SpringLayout.NORTH, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, combatField, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, nameField, 36, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, nameField, -135, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, advancedArea, 228, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, advancedLabel, -6, SpringLayout.NORTH, advancedArea);
		baseLayout.putConstraint(SpringLayout.NORTH, updateButton, 22, SpringLayout.SOUTH, advancedArea);
		baseLayout.putConstraint(SpringLayout.WEST, updateButton, 0, SpringLayout.WEST, advancedArea);
		baseLayout.putConstraint(SpringLayout.EAST, advancedArea, -69, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, numberField, -6, SpringLayout.NORTH, numberLabel);
		baseLayout.putConstraint(SpringLayout.EAST, numberField, 0, SpringLayout.EAST, healthField);
	}
	
	private void setupListeners()
	{
		pokedexSelector.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int selected = pokedexSelector.getSelectedIndex();
				nameField.setText(baseController.getPokedex().get(selected).getName());
				numberField.setText(baseController.getPokedex().get(selected).getNumber() + "");
				combatField.setText(baseController.getPokedex().get(selected).getAttackPoints() + "");
				speedField.setText(baseController.getPokedex().get(selected).getSpeed() + "");
				healthField.setText(baseController.getPokedex().get(selected).getHealthPoints() + "");
				advancedArea.setText(baseController.getPokedex().get(selected).getPokemonInformation()
						+ "\n" + baseController.getPokedex().get(selected).getPokemonTypes());
				changeColorBasedOnData(baseController.getPokedex().get(selected).getPokemonTypes());
			}
		});
	}
	private void changeColorBasedOnData(String data)
	{
		if(data.contains("Psychic"))
		{
			this.setBackground(Color.YELLOW);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images";
		String defaultName = "Pokeball";
		String extension = ".svg";
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		catch(NullPointerException missingFile)
		{
			
		}
		pokemonLabel.setIcon(pokemonIcon);
		repaint();
	}
	
	private boolean isValidName(String name)
	{
		boolean isValid = false;
		if(name != null && name.trim().length() > 2)
		{
			isValid = true;
		}
		else
		{
			JOptionPane.showMessageDialog("Insert a valid name");
		}
	}
}
