package mods;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import etc.Constants;
import etc.UIBuilder;
import main.Main;
import weapons.WeaponPanel;

public class WeaponModPanel extends JPanel implements ActionListener {

	/**
	 * ____________________________________________________________ GLOBAL VARIABLES
	 * ____________________________________________________________
	 */

	/** JPanels **/
	protected JPanel topPanel = new JPanel();
	protected JPanel middlePanel = new JPanel();
	protected JPanel bottomPanel = new JPanel();

	/** JComboBoxes **/
	public JComboBox<String> modBox = new JComboBox<String>();
	protected JComboBox<String> modLevel = new JComboBox<String>();
	protected JComboBox<String> slotPolarityBox = new JComboBox<String>();

	/** JLabels **/
	protected JLabel modLabel = new JLabel(Constants.MOD_LABEL);
	protected JLabel levelLabel = new JLabel(Constants.RANK_LABEL);
	protected JLabel slotPolarityLabel = new JLabel(Constants.SLOT_POLARITY_LABEL);
	protected JLabel modPolarityLabel = new JLabel(Constants.MOD_POLARITY_LABEL);
	protected JLabel costLabel = new JLabel(Constants.COST_LABEL);

	/** JTextFields **/
	protected JTextField modPolarityField = new JTextField(3);
	protected JTextField costField = new JTextField(3);

	/** The mod number **/
	protected String title = "";

	/** The Owner of this Mod Panel **/
	protected WeaponPanel owner;

	/** The Selected Mod **/
	protected Mod selectedMod;
	
	protected boolean setting = true;

	/**
	 * ____________________________________________________________ METHODS
	 * ____________________________________________________________
	 */

	/**
	 * CTOR
	 */
	public WeaponModPanel(String name, WeaponPanel panel) {

		this.title = name;
		this.owner = panel;
		BuildUI();
	}

	/**
	 * Builds the UI
	 */
	public void BuildUI() {
		UIBuilder.comboBoxInit(modBox);
		UIBuilder.comboBoxInit(modLevel);
		UIBuilder.comboBoxInit(slotPolarityBox);

		UIBuilder.labelInit(modLabel);
		UIBuilder.labelInit(levelLabel);
		UIBuilder.labelInit(slotPolarityLabel);
		UIBuilder.labelInit(modPolarityLabel);
		UIBuilder.labelInit(costLabel);

		UIBuilder.textFieldInit(modPolarityField);
		UIBuilder.textFieldInit(costField);

		UIBuilder.panelInit(topPanel);
		UIBuilder.panelInit(middlePanel);
		UIBuilder.panelInit(bottomPanel);

		modBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");

		modLevel.setPrototypeDisplayValue("XX");

		slotPolarityBox.addItem(Constants.NONE);
		slotPolarityBox.addItem(Constants.D);
		slotPolarityBox.addItem(Constants.V);
		slotPolarityBox.addItem(Constants.DASH);

		modLevel.addItem("0");

		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		modPolarityField.setEditable(false);
		costField.setEditable(false);

		topPanel.add(modLabel);
		topPanel.add(modBox);
		middlePanel.add(levelLabel);
		middlePanel.add(modLevel);
		middlePanel.add(slotPolarityLabel);
		middlePanel.add(slotPolarityBox);
		bottomPanel.add(modPolarityLabel);
		bottomPanel.add(modPolarityField);
		bottomPanel.add(costLabel);
		bottomPanel.add(costField);

		this.add(topPanel);
		this.add(middlePanel);
		this.add(bottomPanel);

		UIBuilder.createTextTitledLineBorder(this, title);

		modBox.addActionListener(this);
		modLevel.addActionListener(this);
		slotPolarityBox.addActionListener(this);

		modPolarityField.setText(Constants.NONE);
		costField.setText("0");
	}

	/**
	 * Gets the selected mod's name
	 * 
	 * @return the name
	 */
	public String getSelectedMod() {

		return (String) modBox.getSelectedItem();
	}

	/**
	 * Gets the selected mod's current rank
	 * 
	 * @return the rank
	 */
	public String getModRank() {

		return (String) modLevel.getSelectedItem();
	}

	/**
	 * Maxes the selected mod out
	 */
	public void maxMod() {

		modLevel.setSelectedIndex(modLevel.getItemCount() - 1);
	}

	/**
	 * Sets the selected mod
	 * 
	 * @param mod
	 */
	public void setSelectedMod(Mod mod) {

		selectedMod = mod;
	}

	/**
	 * Updates the mod drop-down contents based on the selected mods and total mods
	 * 
	 * @param selectedMods
	 * @param mods
	 */
	public void updateDropDowns(Vector<String> selectedMods, Vector<Mod> mods, String weaponType) {
		modBox.removeActionListener(this);
		try {
			modBox.removeAllItems();
		} catch (Exception ex) {
		}
		modBox.addItem("--");
		String selectedName = "";
		try {
			selectedName = selectedMod.name;
		} catch (Exception ex) {
			selectedName = "--";
		}
		for (Mod mod : mods) {
			if (!selectedMods.contains(mod.name) || mod.name.equals(selectedName)) {
				if (mod.type.equals(weaponType)) {
					modBox.addItem(mod.name);
				}
			}
		}
		modBox.setSelectedItem(selectedName);
		modBox.addActionListener(this);
	}

	/**
	 * Gets the total cost of the selected mod
	 * 
	 * @return total cost
	 */
	public int getModCost() {
		try {
			String slotPolarity = (String) slotPolarityBox.getSelectedItem();
			String modOnePolarity = selectedMod.polarity;
			int modOneCost = selectedMod.baseCost + Integer.parseInt((String) modLevel.getSelectedItem());
			int modOneCostHalf = modOneCost / 2;
			if (slotPolarity.equals(Constants.NONE) || modOnePolarity.equals(Constants.NONE)) {
				costField.setText("" + modOneCost);
				costField.setForeground(UIBuilder.TEXT_FOREGROUND);
			} else if (slotPolarity.equals(modOnePolarity)) {
				costField.setText("" + (modOneCost - modOneCostHalf));
				costField.setForeground(UIBuilder.TEXT_FOREGROUND);
			} else {
				costField.setText("" + (modOneCost + modOneCostHalf));
				costField.setForeground(Color.RED);
			}
		} catch (Exception ex) {
			costField.setText("0");
			costField.setForeground(UIBuilder.TEXT_FOREGROUND);
		}
		return Integer.parseInt(costField.getText());
	}

	/**
	 * Creates a string for saving this configuration to a file
	 * 
	 * @return save string
	 */
	public String writeOut() {
		return modBox.getSelectedItem() + "," + modLevel.getSelectedItem() + "," + slotPolarityBox.getSelectedItem();
	}

	/**
	 * Reads in the configuration from the supplied string
	 * 
	 * @param in
	 */
	public void readIn(String in) {
		StringTokenizer inTok = new StringTokenizer(in, ",");
		modBox.setSelectedItem(inTok.nextToken());
		modLevel.setSelectedItem(inTok.nextToken());
		slotPolarityBox.setSelectedItem(inTok.nextToken());
	}

	/**
	 * Clears the configurable fields
	 */
	public void clear() {
		modBox.setSelectedItem("--");
		slotPolarityBox.setSelectedItem(Constants.NONE);
		costField.setForeground(UIBuilder.TEXT_FOREGROUND);
	}

	/**
	 * Action Listener Callback
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(modBox)) {
			owner.setting = true;
			owner.updateModPanel(this);
			modLevel.removeAllItems();
			if (modBox.getSelectedItem().equals("--")) {
				modLevel.addItem("0");
				modPolarityField.setText(Constants.NONE);
				owner.setting = false;
			} else {
				if (selectedMod != null) {
					int levels = selectedMod.ranks;
					for (int i = 0; i <= levels; i++) {
						modLevel.addItem("" + i);
					}
				}
				modPolarityField.setText(selectedMod.polarity);
				owner.setting = false;
			}
			try {
				modLevel.setSelectedIndex(selectedMod.ranks);
			} catch (Exception r) {
				modLevel.setSelectedItem("0");
			}
		} else if (e.getSource().equals(modLevel)) {
			owner.calculateModCosts();
		} else if (e.getSource().equals(slotPolarityBox)) {
			owner.setting = true;
			owner.calculateModCosts();
			owner.setting = false;
		}
	}
}
