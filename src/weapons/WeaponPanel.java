package weapons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Stances.Stance;
import Stances.Stance.Combo;
import Stances.Stance.Hit;
import Stances.StanceInitializer;
import etc.Constants;
import etc.UIBuilder;
import mods.Mod;
import mods.ModInitializer;
import mods.WeaponModPanel;

import main.Main;

public class WeaponPanel extends JPanel implements ActionListener, ChangeListener {

	/**
	 * ____________________________________________________________ GLOBAL VARIABLES
	 * ____________________________________________________________
	 */

	/** JPanels **/
	protected JPanel attributesPanel = new JPanel();
	protected JPanel modsPanel = new JPanel();
	protected WeaponAttributesPanel wap = new WeaponAttributesPanel();
	public WeaponModPanel modOnePanel = new WeaponModPanel("1", this);
	public WeaponModPanel modTwoPanel = new WeaponModPanel("2", this);
	public WeaponModPanel modThreePanel = new WeaponModPanel("3", this);
	public WeaponModPanel modFourPanel = new WeaponModPanel("4", this);
	public WeaponModPanel modFivePanel = new WeaponModPanel("5", this);
	public WeaponModPanel modSixPanel = new WeaponModPanel("6", this);
	public WeaponModPanel modSevenPanel = new WeaponModPanel("7", this);
	public WeaponModPanel modEightPanel = new WeaponModPanel("8", this);
	public WeaponModPanel modNinePanel = new WeaponModPanel("Exilus", this);
	protected JPanel savedWeaponPanel = new JPanel();
	protected JPanel refireCancelPanel = new JPanel();
	protected JPanel additiveEffects = new JPanel();
	protected JPanel addCC = new JPanel();
	protected JPanel addCD = new JPanel();
	protected JPanel addSC = new JPanel();
	protected JPanel addDam = new JPanel();
	protected JPanel addFR = new JPanel();
	protected JPanel vigiEffects = new JPanel();
	protected JPanel mQuantaBubbles = new JPanel();
	protected JPanel mQuantaOptions = new JPanel();
	protected JPanel nums = new JPanel();

	/** JComboBoxes **/
	protected JComboBox<String> weaponBox = new JComboBox<String>();

	/** JCheckBoxes **/
	protected JCheckBox refireCancel = new JCheckBox();
	protected JCheckBox potato = new JCheckBox("Catalyst Installed");
	public JCheckBox mQCombineElement = new JCheckBox("Hitscan");
	
	protected JCheckBox showExilus = new JCheckBox("Show Exilus Slot");

	/** JLabels **/
	protected JLabel weaponLabel = new JLabel("Weapon - ");
	protected JLabel refireCancelLabel = new JLabel("Refire Cancel - ");
	protected JLabel totalModCostLabel = new JLabel("Mod Capacity");
	protected JLabel addCClabel = new JLabel("Additive Crit Chance - ");
	protected JLabel addCDlabel = new JLabel("Additive Crit Damage - ");
	protected JLabel addSClabel = new JLabel("Additive Status Chance - ");
	protected JLabel addDamlabel = new JLabel("Additive Damage - ");
	protected JLabel addFRlabel = new JLabel("Additive Fire Rate - ");
	protected JLabel vigiLabel = new JLabel("Additional Vigilante Mods - ");
	protected JLabel mQuantaLabel = new JLabel("Mutalist Quanta Bubbles - ");
	protected JLabel mQ1Label = new JLabel(" 1: ");
	protected JLabel mQ2Label = new JLabel(" 2: ");
	protected JLabel mQ3Label = new JLabel(" 3: ");

	/** JTextFields **/
	protected JTextField totalModCostField = new JTextField(8);
	protected JTextField addCCField = new JTextField(8);
	protected JTextField addCDField = new JTextField(8);
	protected JTextField addSCField = new JTextField(8);
	protected JTextField addDamField = new JTextField(8);
	protected JTextField addFRField = new JTextField(8);
	public JTextField mQ1Field = new JTextField(2);
	public JTextField mQ2Field = new JTextField(2);
	public JTextField mQ3Field = new JTextField(2);

	/** JButtons **/
	protected JButton hideAdd = new JButton("Hide/Show Extra Effects");

	/** Data **/
	public Vector<String> selectedMods = new Vector<String>();
	protected Vector<Mod> activeMods = new Vector<Mod>();
	protected Vector<Integer> modLevels = new Vector<Integer>();
	public JSlider vigiSlider = new JSlider(JSlider.HORIZONTAL, 0, 6, 0);

	public ModInitializer modInit;
	protected WeaponInitializer weapInit;
	protected StanceInitializer stanceInit;

	public String modOne = "--";
	public String modTwo = "--";
	public String modThree = "--";
	public String modFour = "--";
	public String modFive = "--";
	public String modSix = "--";
	public String modSeven = "--";
	public String modEight = "--";
	public String modNine = "--";

	public String weaponType = "";
	public String weaponName = "";
	
	public Combo stanceCombo;

	protected boolean updatingDropDowns = false;
	public boolean setting = false;

	/**
	 * ____________________________________________________________ METHODS
	 * ____________________________________________________________
	 */

	/**
	 * CTOR
	 */
	public WeaponPanel() {

	}

	/**
	 * Initializes the Data
	 */
	public void Init() {

		// Initialize The Data
		modInit = ModInitializer.getInstance();
		weapInit = WeaponInitializer.getInstance();
		stanceInit = StanceInitializer.getInstance();
		updateWeaponBox();
	}

	public void InitMods(String file) {
		modInit.initialize(file);
	}

	/**
	 * Builds the UI
	 */
	public void buildUI() {
		UIBuilder.comboBoxInit(weaponBox);

		UIBuilder.labelInit(totalModCostLabel);
		UIBuilder.labelInit(weaponLabel);
		UIBuilder.labelInit(refireCancelLabel);
		UIBuilder.labelInit(addCClabel);
		UIBuilder.labelInit(addCDlabel);
		UIBuilder.labelInit(addSClabel);
		UIBuilder.labelInit(addDamlabel);
		UIBuilder.labelInit(addFRlabel);
		UIBuilder.labelInit(vigiLabel);
		UIBuilder.labelInit(mQuantaLabel);
		UIBuilder.labelInit(mQ1Label);
		UIBuilder.labelInit(mQ2Label);
		UIBuilder.labelInit(mQ3Label);

		UIBuilder.checkBoxInit(refireCancel);
		UIBuilder.checkBoxInit(potato);
		UIBuilder.checkBoxInit(showExilus);
		UIBuilder.checkBoxInit(mQCombineElement);

		UIBuilder.textFieldInit(totalModCostField);

		UIBuilder.numberFieldInit(addCCField);
		UIBuilder.numberFieldInit(addCDField);
		UIBuilder.numberFieldInit(addSCField);
		UIBuilder.numberFieldInit(addDamField);
		UIBuilder.numberFieldInit(addFRField);
		UIBuilder.numberFieldInit(mQ1Field);
		UIBuilder.numberFieldInit(mQ2Field);
		UIBuilder.numberFieldInit(mQ3Field);

		UIBuilder.buttonInit(hideAdd);

		UIBuilder.createTitledLineBorder(attributesPanel, "ATTRIBUTES");
		UIBuilder.createTitledLineBorder(modsPanel, "MODS");

		UIBuilder.createSepparationBorder(savedWeaponPanel);
		UIBuilder.createSepparationBorder(refireCancelPanel);

		UIBuilder.panelInit(attributesPanel);
		UIBuilder.panelInit(modsPanel);
		UIBuilder.panelInit(modOnePanel);
		UIBuilder.panelInit(modTwoPanel);
		UIBuilder.panelInit(modThreePanel);
		UIBuilder.panelInit(modFourPanel);
		UIBuilder.panelInit(modFivePanel);
		UIBuilder.panelInit(modSixPanel);
		UIBuilder.panelInit(modSevenPanel);
		UIBuilder.panelInit(modEightPanel);
		UIBuilder.panelInit(modNinePanel);
		UIBuilder.panelInit(refireCancelPanel);
		UIBuilder.panelInit(savedWeaponPanel);
		UIBuilder.panelInit(addCC);
		UIBuilder.panelInit(addCD);
		UIBuilder.panelInit(addSC);
		UIBuilder.panelInit(addDam);
		UIBuilder.panelInit(addFR);
		UIBuilder.panelInit(additiveEffects);
		UIBuilder.panelInit(nums);
		UIBuilder.panelInit(vigiEffects);
		UIBuilder.panelInit(mQuantaBubbles);
		UIBuilder.panelInit(mQuantaOptions);

		UIBuilder.createSepparationBorder(addCC);
		UIBuilder.createSepparationBorder(addCD);
		UIBuilder.createSepparationBorder(addSC);
		UIBuilder.createSepparationBorder(addDam);
		UIBuilder.createSepparationBorder(addFR);
		UIBuilder.createSepparationBorder(vigiEffects);
		UIBuilder.createSepparationBorder(mQuantaBubbles);

		vigiSlider.setMajorTickSpacing(1);
		vigiSlider.setPaintLabels(true);
		vigiSlider.setBackground(Color.BLACK);
		vigiSlider.setForeground(Color.GREEN);

		UIBuilder.createTitledLineBorder(additiveEffects, "EXTRA EFFECTS");

		attributesPanel.setLayout(new BoxLayout(attributesPanel, BoxLayout.Y_AXIS));
		modsPanel.setLayout(new BoxLayout(modsPanel, BoxLayout.Y_AXIS));
		modOnePanel.setLayout(new BoxLayout(modOnePanel, BoxLayout.Y_AXIS));
		modTwoPanel.setLayout(new BoxLayout(modTwoPanel, BoxLayout.Y_AXIS));
		modThreePanel.setLayout(new BoxLayout(modThreePanel, BoxLayout.Y_AXIS));
		modFourPanel.setLayout(new BoxLayout(modFourPanel, BoxLayout.Y_AXIS));
		modFivePanel.setLayout(new BoxLayout(modFivePanel, BoxLayout.Y_AXIS));
		modSixPanel.setLayout(new BoxLayout(modSixPanel, BoxLayout.Y_AXIS));
		modSevenPanel.setLayout(new BoxLayout(modSevenPanel, BoxLayout.Y_AXIS));
		modEightPanel.setLayout(new BoxLayout(modEightPanel, BoxLayout.Y_AXIS));
		modNinePanel.setLayout(new BoxLayout(modNinePanel, BoxLayout.Y_AXIS));
		additiveEffects.setLayout(new BoxLayout(additiveEffects, BoxLayout.Y_AXIS));
		nums.setLayout(new BoxLayout(nums, BoxLayout.Y_AXIS));

		savedWeaponPanel.setLayout(new GridLayout(1, 2, 0, 0));
		refireCancelPanel.setLayout(new GridLayout(1, 2, 0, 0));
		addCC.setLayout(new GridLayout(1, 2, 0, 0));
		addCD.setLayout(new GridLayout(1, 2, 0, 0));
		addSC.setLayout(new GridLayout(1, 2, 0, 0));
		addDam.setLayout(new GridLayout(1, 2, 0, 0));
		addFR.setLayout(new GridLayout(1, 2, 0, 0));
		vigiEffects.setLayout(new GridLayout(1, 2, 0, 0));
		mQuantaBubbles.setLayout(new GridLayout(1, 2, 0, 0));
		mQuantaOptions.setLayout(new BoxLayout(mQuantaOptions, BoxLayout.X_AXIS));

		totalModCostField.setEditable(false);

		savedWeaponPanel.add(weaponLabel);
		savedWeaponPanel.add(weaponBox);

		refireCancelPanel.add(refireCancelLabel);
		refireCancelPanel.add(refireCancel);

		attributesPanel.add(savedWeaponPanel);
		attributesPanel.add(wap);
		attributesPanel.add(refireCancelPanel);
		
		hideAdd.setAlignmentX(CENTER_ALIGNMENT);
		
		addCC.add(addCClabel);
		addCC.add(addCCField);
		addCD.add(addCDlabel);
		addCD.add(addCDField);
		addSC.add(addSClabel);
		addSC.add(addSCField);
		addDam.add(addDamlabel);
		addDam.add(addDamField);
		addFR.add(addFRlabel);
		addFR.add(addFRField);
		vigiEffects.add(vigiLabel);
		vigiEffects.add(vigiSlider);
		mQuantaBubbles.add(mQuantaLabel);
		mQuantaOptions.add(mQ1Label);
		mQuantaOptions.add(mQ1Field);
		mQuantaOptions.add(mQ2Label);
		mQuantaOptions.add(mQ2Field);
		mQuantaOptions.add(mQ3Label);
		mQuantaOptions.add(mQ3Field);
		mQuantaOptions.add(mQCombineElement);
		mQuantaBubbles.add(mQuantaOptions);
		additiveEffects.add(addCC);
		additiveEffects.add(addCD);
		additiveEffects.add(addSC);
		additiveEffects.add(addDam);
		additiveEffects.add(addFR);
		additiveEffects.add(vigiEffects);
		additiveEffects.add(mQuantaBubbles);
		nums.add(attributesPanel);
		nums.add(hideAdd);
		nums.add(additiveEffects);

		additiveEffects.setVisible(false);

		additiveEffects.setToolTipText("Optinal attributes that are added after normal calculation. IE: Knell, Arcanes, sniper scope buffs, etc");
		addCCField.setToolTipText("Additive crit chance as a percent");
		addCDField.setToolTipText("Additive crit damage as a number (IE: 1.5 for knell)");
		addSCField.setToolTipText("Additive status chance as a percent");
		addDamField.setToolTipText("Additive damage as a percent (Chroma)");
		addFRField.setToolTipText("Additive fire rate as a percent (Toxocyst's is multiplicative)");
		vigiSlider.setToolTipText("Vigilante mods attached to your Warframe and/or sentinel weapon");
		hideAdd.setToolTipText("Optinal attributes that are added after normal calculation. IE: Knell, Arcanes, Warframe buffs, etc");
		mQuantaBubbles.setToolTipText("Mutalist Quanta bubbles you are shooting through and how many of each stack level. ie if shooting through one bubble that has been stacked 3 times, but 1 into the 3: textbox.");
		mQ1Field.setToolTipText("The number of unstacked bubbles");
		mQ1Label.setToolTipText("The number of unstacked bubbles");
		mQ2Field.setToolTipText("The number of twice-stacked bubbles");
		mQ2Label.setToolTipText("The number of twice-stacked bubbles");
		mQ3Field.setToolTipText("The number of thrice-stacked bubbles");
		mQ3Label.setToolTipText("The number of thrice-stacked bubbles");
		mQCombineElement.setToolTipText("Whether the weapon is projectile-based or hitscan. Hitscan weapons do not combine the additional electric damage with other elements.");
		
		JPanel modsAllPanel = new JPanel();
		UIBuilder.panelInit(modsAllPanel);
		modsAllPanel.setLayout(new BoxLayout(modsAllPanel, BoxLayout.X_AXIS));
		
		JPanel modsBothRowsPanel = new JPanel();
		UIBuilder.panelInit(modsBothRowsPanel);
		modsBothRowsPanel.setLayout(new BoxLayout(modsBothRowsPanel, BoxLayout.Y_AXIS));
		
		JPanel modsTopPanel = new JPanel();
		UIBuilder.panelInit(modsTopPanel);
		modsTopPanel.setLayout(new BoxLayout(modsTopPanel, BoxLayout.X_AXIS));

		JPanel modsBottomPanel = new JPanel();
		UIBuilder.panelInit(modsBottomPanel);
		modsBottomPanel.setLayout(new BoxLayout(modsBottomPanel, BoxLayout.X_AXIS));

		JPanel totalModCostPanel = new JPanel();
		UIBuilder.panelInit(totalModCostPanel);
		totalModCostPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));

		modsTopPanel.add(modOnePanel);
		modsTopPanel.add(modTwoPanel);
		modsTopPanel.add(modThreePanel);
		modsTopPanel.add(modFourPanel);
		modsBottomPanel.add(modFivePanel);
		modsBottomPanel.add(modSixPanel);
		modsBottomPanel.add(modSevenPanel);
		modsBottomPanel.add(modEightPanel);
		
		modsBothRowsPanel.add(modsTopPanel);
		modsBothRowsPanel.add(modsBottomPanel);
		modsAllPanel.add(modsBothRowsPanel);
		modsAllPanel.add(modNinePanel);

		totalModCostPanel.add(totalModCostLabel);
		totalModCostPanel.add(totalModCostField);
		totalModCostPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		totalModCostPanel.add(potato);
		totalModCostPanel.add(showExilus);

		//modsPanel.add(modsTopPanel);
		//modsPanel.add(modsBottomPanel);
		modsPanel.add(modsAllPanel);
		modsPanel.add(totalModCostPanel);

		modNinePanel.setMaximumSize(new Dimension(200, 140));
		
		UIBuilder.panelInit(this);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(nums);
		this.add(modsPanel);

		wap.weaponModeBox.addActionListener(this);
		wap.damageTypeBox.addActionListener(this);
		weaponBox.addActionListener(this);
		potato.addActionListener(this);
		showExilus.addActionListener(this);
		hideAdd.addActionListener(this);
		vigiSlider.addChangeListener(this);

		wap.chargeTimeField.addActionListener(this);
		wap.burstCountField.addActionListener(this);
		wap.damageField.addActionListener(this);
		wap.impactField.addActionListener(this);
		wap.punctureField.addActionListener(this);
		wap.slashField.addActionListener(this);
		wap.fireRateField.addActionListener(this);
		wap.magSizeField.addActionListener(this);
		wap.startingComboField.addActionListener(this);
		wap.reloadField.addActionListener(this);
		wap.critField.addActionListener(this);
		wap.multiplierField.addActionListener(this);
		wap.projectileField.addActionListener(this);
		wap.statusField.addActionListener(this);
		wap.drainField.addActionListener(this);
		wap.scopeStrengthField.addActionListener(this);
		wap.scopeBox.addActionListener(this);
		wap.scopeStrengthBox.addActionListener(this);
		wap.meleeTypeBox.addActionListener(this);
		wap.stanceBox.addActionListener(this);
		wap.stanceComboBox.addActionListener(this);

		totalModCostField.addActionListener(this);
		addCCField.addActionListener(this);
		addCDField.addActionListener(this);
		addSCField.addActionListener(this);
		addDamField.addActionListener(this);
		addFRField.addActionListener(this);
		mQ1Field.addActionListener(this);
		mQ2Field.addActionListener(this);
		mQ3Field.addActionListener(this);
		mQCombineElement.addActionListener(this);

		updateDropDownContents();

		weaponBox.setSelectedItem(Constants.CUSTOM_WEAPON);
		totalModCostField.setText("60");
		potato.setSelected(true);
		showExilus.setSelected(false);
		
		mQ1Field.setText("0");
		mQ2Field.setText("0");
		mQ3Field.setText("0");
		
		modNinePanel.setVisible(false);
	}

	/**
	 * Returns the active mods in a formatted string
	 */
	public String getModsOutput() {
		return "\n" + modOne + "[" + modOnePanel.getModRank() + "], " + modTwo + "[" + modTwoPanel.getModRank() + "], " + modThree + "[" + modThreePanel.getModRank() + "], " + modFour + "[" + modFourPanel.getModRank() + "]\n" + modFive + "[" + modFivePanel.getModRank() + "], " + modSix + "["
				+ modSixPanel.getModRank() + "], " + modSeven + "[" + modSevenPanel.getModRank() + "], " + modEight + "[" + modEightPanel.getModRank() + "]\n" + modNine + "[" + modNinePanel.getModRank() + "]";
	}

	/**
	 * Counts the number of mods
	 */
	public int countMods() {
		int count = 0;
		updateDropDownContents();
		if (modEight.equals("--"))
			count = modEightPanel.modBox.getItemCount();
		else if (modSeven.equals("--"))
			count = modSevenPanel.modBox.getItemCount();
		else if (modSix.equals("--"))
			count = modSixPanel.modBox.getItemCount();
		else if (modFive.equals("--"))
			count = modFivePanel.modBox.getItemCount();
		else if (modFour.equals("--"))
			count = modFourPanel.modBox.getItemCount();
		else if (modThree.equals("--"))
			count = modThreePanel.modBox.getItemCount();
		else if (modTwo.equals("--"))
			count = modTwoPanel.modBox.getItemCount();
		else if (modOne.equals("--"))
			count = modOnePanel.modBox.getItemCount();
		return count;
	}

	/**
	 * Calculates the active mods
	 */
	public void parseActiveMods() {
		activeMods.clear();
		modLevels.clear();
		if (!modOne.equals("--")) {
			activeMods.add(getModByName(modOne));
			modLevels.add(Integer.parseInt(modOnePanel.getModRank()));
		}
		if (!modTwo.equals("--")) {
			activeMods.add(getModByName(modTwo));
			modLevels.add(Integer.parseInt(modTwoPanel.getModRank()));
		}
		if (!modThree.equals("--")) {
			activeMods.add(getModByName(modThree));
			modLevels.add(Integer.parseInt(modThreePanel.getModRank()));
		}
		if (!modFour.equals("--")) {
			activeMods.add(getModByName(modFour));
			modLevels.add(Integer.parseInt(modFourPanel.getModRank()));
		}
		if (!modFive.equals("--")) {
			activeMods.add(getModByName(modFive));
			modLevels.add(Integer.parseInt(modFivePanel.getModRank()));
		}
		if (!modSix.equals("--")) {
			activeMods.add(getModByName(modSix));
			modLevels.add(Integer.parseInt(modSixPanel.getModRank()));
		}
		if (!modSeven.equals("--")) {
			activeMods.add(getModByName(modSeven));
			modLevels.add(Integer.parseInt(modSevenPanel.getModRank()));
		}
		if (!modEight.equals("--")) {
			activeMods.add(getModByName(modEight));
			modLevels.add(Integer.parseInt(modEightPanel.getModRank()));
		}
		if (!modNine.equals("--")) {
			activeMods.add(getModByName(modNine));
			modLevels.add(Integer.parseInt(modNinePanel.getModRank()));
		}
	}

	/**
	 * Gets the weapon's active mods
	 * 
	 * @return
	 */
	public Vector<Mod> getActiveMods() {
		parseActiveMods();
		return activeMods;
	}

	/**
	 * Gets the active mod ranks
	 * 
	 * @return
	 */
	public Vector<Integer> getActiveModRanks() {
		return modLevels;
	}

	/**
	 * Gets the weapon's mode of operation
	 * 
	 * @return mode
	 */
	public String getWeaponMode() {
		String mode = (String) wap.weaponModeBox.getSelectedItem();
		return mode;
	}

	/**
	 * Gets the weapon's base damage type
	 * 
	 * @return type
	 */
	public String getDamageType() {
		String type = (String) wap.damageTypeBox.getSelectedItem();
		return type;
	}
	public String getDamage2Type() {
		String type = (String) wap.damageType2Box.getSelectedItem();
		if (type == null || type.equals("")) {
			type = "No Element";
		}
		return type;
	}
	public String getExplosiveDamage1Type() {
		String type = (String) wap.explosiveDamageType1Box.getSelectedItem();
		if (type == null || type.equals("")) {
			type = "No Element";
		}
		return type;
	}
	public String getExplosiveDamage2Type() {
		String type = (String) wap.explosiveDamageType2Box.getSelectedItem();
		if (type == null || type.equals("")) {
			type = "No Element";
		}
		return type;
	}

	/**
	 * Gets the weapon's charge time
	 * 
	 * @return chargeTime
	 */
	public double getChargeTime() {
		String chargeTimeStr = wap.chargeTimeField.getText();
		if (chargeTimeStr == null || chargeTimeStr.equals("")) {
			chargeTimeStr = "0";
		}
		double chargeTime = Double.parseDouble(chargeTimeStr);
		if (chargeTime < 0.0) {
			chargeTime = 0.0;
		}
		return (chargeTime);
	}

	/**
	 * Gets the weapon's ammo drain
	 * 
	 * @return drain
	 */
	public double getDrain() {
		String drainStr = wap.drainField.getText();
		if (drainStr == null || drainStr.equals("")) {
			drainStr = "0";
		}
		double drain = Double.parseDouble(drainStr);
		if (drain < 0) {
			drain = 0;
		}
		return (drain);
	}

	/**
	 * Gets the additive crit chance
	 * 
	 * @return drain
	 */
	public double getAddCC() {
		String CCstr = addCCField.getText();
		if (CCstr == null || CCstr.equals("")) {
			CCstr = "0";
		}
		double CC = Double.parseDouble(CCstr);
		CC /= 100.0;
		if (CC < 0) {
			CC = 0;
		}
		return (CC);
	}

	/**
	 * Gets the additive crit damage
	 * 
	 * @return drain
	 */
	public double getAddCD() {
		String CDstr = addCDField.getText();
		if (CDstr == null || CDstr.equals("")) {
			CDstr = "0";
		}
		double CD = Double.parseDouble(CDstr);
		if (CD < 0) {
			CD = 0;
		}
		return (CD);
	}

	/**
	 * Gets the additive status chance
	 * 
	 * @return drain
	 */
	public double getAddSC() {
		String SCstr = addSCField.getText();
		if (SCstr == null || SCstr.equals("")) {
			SCstr = "0";
		}
		double SC = Double.parseDouble(SCstr);
		SC /= 100.0;
		if (SC < 0) {
			SC = 0;
		}
		return (SC);
	}

	/**
	 * Gets the additive damage
	 * 
	 * @return drain
	 */
	public double getAddDam() {
		String Damstr = addDamField.getText();
		if (Damstr == null || Damstr.equals("")) {
			Damstr = "0";
		}
		double Dam = Double.parseDouble(Damstr);
		Dam /= 100.0;
		if (Dam < 0) {
			Dam = 0;
		}
		return (Dam);
	}

	/**
	 * Gets the additive fire rate
	 * 
	 * @return drain
	 */
	public double getAddFR() {
		String FRstr = addFRField.getText();
		if (FRstr == null || FRstr.equals("")) {
			FRstr = "0";
		}
		double FR = Double.parseDouble(FRstr);
		FR /= 100.0;

		return (FR);
	}

	/**
	 * Gets the weapon's burst count
	 * 
	 * @return burstCount
	 */
	public int getBurstCount() {
		String burstCountStr = wap.burstCountField.getText();
		if (burstCountStr == null || burstCountStr.equals("")) {
			burstCountStr = "0";
		}
		int burstCount = Integer.parseInt(burstCountStr);
		if (burstCount < 0) {
			burstCount = 0;
		}
		return (burstCount);
	}

	/**
	 * Gets the name
	 * 
	 * @return name
	 */
	public String getName() {
		String name = wap.nameField.getText();
		if (name == null || name.equals("")) {
			name = "UNKNOWN";
		}
		return name;
	}

	/**
	 * Gets the number of projectiles
	 * 
	 * @return projectiles
	 */
	public double getProjectiles() {
		String projectileStr = wap.projectileField.getText();
		if (projectileStr == null || projectileStr.equals("")) {
			projectileStr = "1";
		}
		double projectile = Double.parseDouble(projectileStr);
		if (projectile < 1) {
			projectile = 1;
		}
		return (projectile);
	}

	/**
	 * Gets the status chance
	 * 
	 * @return status
	 */
	public double getStatusChance() {
		String statusStr = wap.statusField.getText();
		if (statusStr == null || statusStr.equals("")) {
			statusStr = "0";
		}
		double status = Double.parseDouble(statusStr);
		status /= 100.0;
		if (status < 0.0) {
			status = 0.0;
		}
		return (status);
	}

	/**
	 * Gets the base damage
	 * 
	 * @return damage
	 */
	public double getBaseDamage() {
		String damageStr = wap.damageField.getText();
		if (damageStr == null || damageStr.equals("")) {
			damageStr = "0";
		}
		double damage = Double.parseDouble(damageStr);
		if (damage < 0.0) {
			damage = 0.0;
		}
		return (damage);
	}
	public double getBaseDamage2() {
		String damageStr = wap.damage2Field.getText();
		if (damageStr == null || damageStr.equals("")) {
			damageStr = "0";
		}
		double damage = Double.parseDouble(damageStr);
		if (damage < 0.0) {
			damage = 0.0;
		}
		return (damage);
	}

	/**
	 * Gets the impact damage
	 * 
	 * @return damage
	 */
	public double getImpactDamage() {
		String damageStr = wap.impactField.getText();
		if (damageStr == null || damageStr.equals("")) {
			damageStr = "0";
		}
		double damage = Double.parseDouble(damageStr);
		if (damage < 0.0) {
			damage = 0.0;
		}
		return (damage);
	}

	/**
	 * Gets the puncture damage
	 * 
	 * @return damage
	 */
	public double getPunctureDamage() {
		String damageStr = wap.punctureField.getText();
		if (damageStr == null || damageStr.equals("")) {
			damageStr = "0";
		}
		double damage = Double.parseDouble(damageStr);
		if (damage < 0.0) {
			damage = 0.0;
		}
		return (damage);
	}

	/**
	 * Gets the slash damage
	 * 
	 * @return damage
	 */
	public double getSlashDamage() {
		String damageStr = wap.slashField.getText();
		if (damageStr == null || damageStr.equals("")) {
			damageStr = "0";
		}
		double damage = Double.parseDouble(damageStr);
		if (damage < 0.0) {
			damage = 0.0;
		}
		return (damage);
	}
	
	/**
	 * Gets the explosion's base damage
	 * 
	 * @return damage
	 */
	public double getExplosiveBaseDamage() {
		String damageStr = wap.explosiveDamage1Field.getText();
		if (damageStr == null || damageStr.equals("")) {
			damageStr = "0";
		}
		double damage = Double.parseDouble(damageStr);
		if (damage < 0.0) {
			damage = 0.0;
		}
		return (damage);
	}
	public double getExplosiveBaseDamage2() {
		String damageStr = wap.explosiveDamage2Field.getText();
		if (damageStr == null || damageStr.equals("")) {
			damageStr = "0";
		}
		double damage = Double.parseDouble(damageStr);
		if (damage < 0.0) {
			damage = 0.0;
		}
		return (damage);
	}

	/**
	 * Gets the impact damage
	 * 
	 * @return damage
	 */
	public double getExplosiveImpactDamage() {
		String damageStr = wap.explosiveImpactField.getText();
		if (damageStr == null || damageStr.equals("")) {
			damageStr = "0";
		}
		double damage = Double.parseDouble(damageStr);
		if (damage < 0.0) {
			damage = 0.0;
		}
		return (damage);
	}

	/**
	 * Gets the puncture damage
	 * 
	 * @return damage
	 */
	public double getExplosivePunctureDamage() {
		String damageStr = wap.explosivePunctureField.getText();
		if (damageStr == null || damageStr.equals("")) {
			damageStr = "0";
		}
		double damage = Double.parseDouble(damageStr);
		if (damage < 0.0) {
			damage = 0.0;
		}
		return (damage);
	}

	/**
	 * Gets the slash damage
	 * 
	 * @return damage
	 */
	public double getExplosiveSlashDamage() {
		String damageStr = wap.explosiveSlashField.getText();
		if (damageStr == null || damageStr.equals("")) {
			damageStr = "0";
		}
		double damage = Double.parseDouble(damageStr);
		if (damage < 0.0) {
			damage = 0.0;
		}
		return (damage);
	}

	/**
	 * Gets the fire rate
	 * 
	 * @return fireRate
	 */
	public double getFireRate() {
		String fireRateStr = wap.fireRateField.getText();
		if (fireRateStr == null || fireRateStr.equals("")) {
			fireRateStr = "0";
		}
		double fireRate = Double.parseDouble(fireRateStr);
		if (fireRate < 0.0) {
			fireRate = 0.0;
		}
		return (fireRate);
	}

	/**
	 * Gets the mag size
	 * 
	 * @return magSize
	 */
	public int getMagSize() {
		String magSizeStr = wap.magSizeField.getText();
		if (magSizeStr == null || magSizeStr.equals("")) {
			magSizeStr = "0";
		}
		int magSize = Integer.parseInt(magSizeStr);
		if (magSize < 0) {
			magSize = 0;
		}
		return (magSize);
	}

	/**
	 * Gets the sniper minimum combo
	 * 
	 * @return minCombo
	 */
	public int getCombo() {
		String ComboStr = wap.comboField.getText();
		if (ComboStr == null || ComboStr.equals("")) {
			ComboStr = "0";
		}
		Integer Combo = Integer.parseInt(ComboStr);
		if (Combo < 1) {
			Combo = 1;
		}
		return (Combo);
	}

	/**
	 * Gets the sniper starting combo
	 * 
	 * @return startingCombo
	 */
	public double getStartingCombo() {
		String StartingComboStr = wap.startingComboField.getText();
		if (StartingComboStr == null || StartingComboStr.equals("")) {
			StartingComboStr = "0";
		}
		double StartingCombo = Double.parseDouble(StartingComboStr);
		if (StartingCombo < 0) {
			StartingCombo = 0;
		}
		return (StartingCombo);
	}

	/**
	 * Gets the sniper scope effect
	 * 
	 * @return scopeEffect
	 */
	public String getScopeEffect() {
		String scopeEffectStr = (String) wap.scopeBox.getSelectedItem();
		return (scopeEffectStr);
	}

	/**
	 * Gets the sniper scope strength
	 * 
	 * @return startingCombo
	 */
	public double getScopeStrength() {
		String scopeStrengthStr = wap.scopeStrengthField.getText();
		if (scopeStrengthStr == null || scopeStrengthStr.equals("")) {
			scopeStrengthStr = "0";
		}
		double scopeStrength = Double.parseDouble(scopeStrengthStr);
		scopeStrength /= 100;
		if (scopeStrength < 0) {
			scopeStrength = 0;
		}
		return (scopeStrength);
	}

	/**
	 * Gets the reload timer
	 * 
	 * @return reloadTime
	 */
	public double getReloadTime() {
		String reloadTimeStr = wap.reloadField.getText();
		if (reloadTimeStr == null || reloadTimeStr.equals("")) {
			reloadTimeStr = "0";
		}
		Double reloadTime = Double.parseDouble(reloadTimeStr);
		if (reloadTime < 0.0) {
			reloadTime = 0.0;
		}
		return (reloadTime);
	}

	/**
	 * Gets the crit chance
	 * 
	 * @return critChance
	 */
	public double getCritChance() {
		String critChanceStr = wap.critField.getText();
		if (critChanceStr == null || critChanceStr.equals("")) {
			critChanceStr = "0";
		}
		Double critChance = Double.parseDouble(critChanceStr);
		critChance /= 100.0;
		if (critChance < 0.0) {
			critChance = 0.0;
		}
		return (critChance);
	}

	/**
	 * Gets the crit multiplier
	 * 
	 * @return critMult
	 */
	public double getCritMultiplier() {
		String critMultStr = wap.multiplierField.getText();
		if (critMultStr == null || critMultStr.equals("")) {
			critMultStr = "0";
		}
		Double critMult = Double.parseDouble(critMultStr);
		// critMult /= 100.0;
		if (critMult < 0.0) {
			critMult = 0.0;
		}
		return (critMult);
	}

	/**
	 * Gets the melee stance combo
	 * 
	 * @return stanceCombo
	 */
	public Combo getStanceCombo() {
		Combo stanceCombo = new Combo("BalnkCombo", new Vector<Hit>());
		for (Stance s : stanceInit.stances) {
			if (s.stanceName.equals(wap.stanceBox.getSelectedItem())) {
				for (Combo c : s.combos) {
					if (c.comboName.equals(wap.stanceComboBox.getSelectedItem())) {
						stanceCombo = c;
					}
				}
			}
		}
		return stanceCombo;
	}
	
	/**
	 * Clears all selections and text
	 */

	public void clear() {
		weaponBox.setSelectedItem(Constants.CUSTOM_WEAPON);
		wap.clear();
		addCCField.setText(null);
		addCDField.setText(null);
		addSCField.setText(null);
		addDamField.setText(null);
		addFRField.setText(null);
		modOnePanel.clear();
		modTwoPanel.clear();
		modThreePanel.clear();
		modFourPanel.clear();
		modFivePanel.clear();
		modSixPanel.clear();
		modSevenPanel.clear();
		modEightPanel.clear();
		modNinePanel.clear();
	}

	/**
	 * Clears everything except mods
	 */
	public void setCustom() {
		wap.clear();
	}

	/**
	 * Loads saved weapon data from the provided file
	 * 
	 * @param file
	 */
	public void loadFromFile(File file) {
		try {
			if (file.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String header = reader.readLine();
				weaponBox.setSelectedItem(Constants.CUSTOM_WEAPON);
				modOnePanel.readIn(reader.readLine());
				modTwoPanel.readIn(reader.readLine());
				modThreePanel.readIn(reader.readLine());
				modFourPanel.readIn(reader.readLine());
				modFivePanel.readIn(reader.readLine());
				modSixPanel.readIn(reader.readLine());
				modSevenPanel.readIn(reader.readLine());
				modEightPanel.readIn(reader.readLine());
				wap.weaponModeBox.setSelectedItem(reader.readLine());
				wap.damageTypeBox.setSelectedItem(reader.readLine());
				wap.nameField.setText(reader.readLine());
				wap.chargeTimeField.setText(reader.readLine());
				wap.burstCountField.setText(reader.readLine());
				wap.meleeTypeBox.setSelectedItem(reader.readLine());
				wap.nameField.setText(reader.readLine());
				wap.damageField.setText(reader.readLine());
				wap.impactField.setText(reader.readLine());
				wap.punctureField.setText(reader.readLine());
				wap.slashField.setText(reader.readLine());
				wap.fireRateField.setText(reader.readLine());
				wap.magSizeField.setText(reader.readLine());
				wap.comboField.setText(reader.readLine());
				wap.reloadField.setText(reader.readLine());
				wap.critField.setText(reader.readLine());
				wap.multiplierField.setText(reader.readLine());
				wap.statusField.setText(reader.readLine());
				wap.projectileField.setText(reader.readLine());
				wap.drainField.setText(reader.readLine());
				reader.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Saves weapon data to the provided file
	 * 
	 * @param file
	 */
	public void saveToFile(File file) {
		try {
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(weaponType + "\n");
			writer.write(modOnePanel.writeOut() + "\n");
			writer.write(modTwoPanel.writeOut() + "\n");
			writer.write(modThreePanel.writeOut() + "\n");
			writer.write(modFourPanel.writeOut() + "\n");
			writer.write(modFivePanel.writeOut() + "\n");
			writer.write(modSixPanel.writeOut() + "\n");
			writer.write(modSevenPanel.writeOut() + "\n");
			writer.write(modEightPanel.writeOut() + "\n");
			writer.write(wap.weaponModeBox.getSelectedItem() + "\n");
			writer.write(wap.damageTypeBox.getSelectedItem() + "\n");
			writer.write(wap.nameField.getText() + "\n");
			writer.write(wap.chargeTimeField.getText() + "\n");
			writer.write(wap.burstCountField.getText() + "\n");
			writer.write("DEPRECIATED\n");
			writer.write(wap.nameField.getText() + "\n");
			writer.write(wap.damageField.getText() + "\n");
			writer.write(wap.impactField.getText() + "\n");
			writer.write(wap.punctureField.getText() + "\n");
			writer.write(wap.slashField.getText() + "\n");
			writer.write(wap.fireRateField.getText() + "\n");
			writer.write(wap.magSizeField.getText() + "\n");
			writer.write(wap.comboField.getText() + "\n");
			writer.write(wap.reloadField.getText() + "\n");
			writer.write(wap.critField.getText() + "\n");
			writer.write(wap.multiplierField.getText() + "\n");
			writer.write(wap.statusField.getText() + "\n");
			writer.write(wap.projectileField.getText() + "\n");
			writer.write(wap.drainField.getText() + "\n");
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * updates the mod costs
	 */
	public void calculateModCosts() {
		try {
			int totalModCost = 0;
			totalModCost += modOnePanel.getModCost();
			totalModCost += modTwoPanel.getModCost();
			totalModCost += modThreePanel.getModCost();
			totalModCost += modFourPanel.getModCost();
			totalModCost += modFivePanel.getModCost();
			totalModCost += modSixPanel.getModCost();
			totalModCost += modSevenPanel.getModCost();
			totalModCost += modEightPanel.getModCost();
			totalModCost += modNinePanel.getModCost();
			int capacity = 60;
			if (!potato.isSelected())
				capacity = 30;
			int modCapacityRemaining = capacity - totalModCost;
			totalModCostField.setText("" + modCapacityRemaining);
			if (modCapacityRemaining < 0) {
				totalModCostField.setForeground(Color.RED);
			} else {
				totalModCostField.setForeground(Color.GREEN);
			}
			if (!setting)
				Main.updateStats();
		} catch (Exception ex) {
			totalModCostField.setText("0");
		}
	}

	/**
	 * Updates the Mod Drop Down Options
	 */
	public void updateDropDownContents() {
		selectedMods.clear();
		selectedMods.add(modOne);
		selectedMods.add(modTwo);
		selectedMods.add(modThree);
		selectedMods.add(modFour);
		selectedMods.add(modFive);
		selectedMods.add(modSix);
		selectedMods.add(modSeven);
		selectedMods.add(modEight);
		selectedMods.add(modNine);
		
		weaponName = wap.nameField.getText();

		modOnePanel.updateDropDowns(selectedMods, modInit.mods, weaponType, weaponName);
		modTwoPanel.updateDropDowns(selectedMods, modInit.mods, weaponType, weaponName);
		modThreePanel.updateDropDowns(selectedMods, modInit.mods, weaponType, weaponName);
		modFourPanel.updateDropDowns(selectedMods, modInit.mods, weaponType, weaponName);
		modFivePanel.updateDropDowns(selectedMods, modInit.mods, weaponType, weaponName);
		modSixPanel.updateDropDowns(selectedMods, modInit.mods, weaponType, weaponName);
		modSevenPanel.updateDropDowns(selectedMods, modInit.mods, weaponType, weaponName);
		modEightPanel.updateDropDowns(selectedMods, modInit.mods, weaponType, weaponName);
		modNinePanel.updateDropDowns(selectedMods, modInit.mods, weaponType, weaponName);
	}

	/**
	 * Updates the UI state to reflect the currently selected weapon mode of
	 * operation
	 * 
	 * @param mode
	 */
	protected void updateWeaponModeOptions(String mode) {
		if (mode.equals(Constants.BURST)) {
			wap.chargeTimePanel.setVisible(false);
			wap.burstCountPanel.setVisible(true);
			wap.drainPanel.setVisible(false);
			wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			refireCancelPanel.setVisible(true);
			wap.comboPanel.setVisible(false);
			wap.startingComboPanel.setVisible(false);
			wap.scopePanel.setVisible(false);
		} else if (mode.equals(Constants.CHARGE) || mode.equals(Constants.CHARGEBOW)) {
			wap.chargeTimePanel.setVisible(true);
			wap.burstCountPanel.setVisible(false);
			wap.drainPanel.setVisible(false);
			wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			refireCancelPanel.setVisible(false);
			wap.comboPanel.setVisible(false);
			wap.startingComboPanel.setVisible(false);
			wap.scopePanel.setVisible(false);
		} else if (mode.equals(Constants.CONTINUOUS)) {
			wap.chargeTimePanel.setVisible(false);
			wap.burstCountPanel.setVisible(false);
			wap.drainPanel.setVisible(true);
			wap.damageField.setToolTipText(Constants.CONTINUOUS_DAMAGE_TOOL_TIP);
			refireCancelPanel.setVisible(false);
			wap.comboPanel.setVisible(false);
			wap.startingComboPanel.setVisible(false);
			wap.scopePanel.setVisible(false);
		} else if (mode.equals(Constants.SNIPER)) {
			wap.chargeTimePanel.setVisible(false);
			wap.burstCountPanel.setVisible(false);
			wap.drainPanel.setVisible(false);
			wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			wap.comboPanel.setVisible(true);
			wap.startingComboPanel.setVisible(true);
			refireCancelPanel.setVisible(false);
			wap.scopePanel.setVisible(true);
		} else if (mode.equals(Constants.LANKA)) {
			wap.chargeTimePanel.setVisible(true);
			wap.burstCountPanel.setVisible(false);
			wap.drainPanel.setVisible(false);
			wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			wap.comboPanel.setVisible(true);
			wap.startingComboPanel.setVisible(true);
			refireCancelPanel.setVisible(false);
			wap.scopePanel.setVisible(true);
		} else {
			wap.chargeTimePanel.setVisible(false);
			wap.burstCountPanel.setVisible(false);
			wap.drainPanel.setVisible(false);
			wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			refireCancelPanel.setVisible(false);
			wap.comboPanel.setVisible(false);
			wap.startingComboPanel.setVisible(false);
			wap.scopePanel.setVisible(false);
		}

		if (weaponType.equals(Constants.MELEE)) {
			wap.meleeTypePanel.setVisible(true);
			wap.stanceComboPanel.setVisible(true);
			wap.stancePanel.setVisible(true);
			wap.weaponModePanel.setVisible(false);
			wap.projectilePanel.setVisible(false);
			wap.fireRateLabel.setText("Attack Speed");
			wap.magSizePanel.setVisible(false);
			wap.reloadPanel.setVisible(false);
			wap.startingComboPanel.setVisible(true);
			wap.weaponModeBox.setSelectedIndex(6);
			wap.scopePanel.setVisible(false);
		} else {
			wap.meleeTypePanel.setVisible(false);
			wap.stanceComboPanel.setVisible(false);
			wap.stancePanel.setVisible(false);
		}
		Main.repack();
	}

	/**
	 * Updates the UI state to reflect the currently selected damage type
	 * 
	 * @param type
	 */
	/*
	protected void updateWeaponDamageOptions(String type) {
		if (type.equals(Constants.PHYSICAL_WEAPON_DAMAGE) || type.equals(Constants.EX_PHYSICAL_WEAPON_DAMAGE)) {
			wap.damagePanel.setVisible(false);
		} else {
			wap.damagePanel.setVisible(true);
		}
		
		if( //this can't be the way i should do this
				type.equals(Constants.EX_FIRE_WEAPON_DAMAGE) ||
				   type.equals(Constants.EX_ICE_WEAPON_DAMAGE) ||
				   type.equals(Constants.EX_ELECTRIC_WEAPON_DAMAGE) ||
				   type.equals(Constants.EX_TOXIN_WEAPON_DAMAGE) ||
				   type.equals(Constants.EX_BLAST_WEAPON_DAMAGE) ||
				   type.equals(Constants.EX_MAGNETIC_WEAPON_DAMAGE) ||
				   type.equals(Constants.EX_GAS_WEAPON_DAMAGE) ||
				   type.equals(Constants.EX_RADIATION_WEAPON_DAMAGE) ||
				   type.equals(Constants.EX_CORROSIVE_WEAPON_DAMAGE) ||
				   type.equals(Constants.EX_VIRAL_WEAPON_DAMAGE)) {
					
					wap.explosiveDamagePanel.setVisible(true);
				}else {
					wap.explosiveDamagePanel.setVisible(false);
				}
				
				if(type.equals(Constants.EX_PHYSICAL_WEAPON_DAMAGE)){
					wap.explosiveImpactPanel.setVisible(true);
					wap.explosivePuncturePanel.setVisible(true);
					wap.explosiveSlashPanel.setVisible(true);
				}else {
					wap.explosiveImpactPanel.setVisible(false);
					wap.explosivePuncturePanel.setVisible(false);
					wap.explosiveSlashPanel.setVisible(false);
				}
	}
	*/
	/**
	 * Gets the mod with the supplied name
	 * 
	 * @param name
	 * @return the mod
	 */
	public Mod getModByName(String name) {
		Mod localMod = null;
		for (int i = 0; i < modInit.mods.size(); i++) {
			if (modInit.mods.get(i).name.equals(name)) {
				localMod = modInit.mods.get(i);
			}
		}

		return localMod;
	}

	/**
	 * Updates the mod panels
	 * 
	 * @param panel
	 */
	public void updateModPanel(WeaponModPanel panel) {
		Mod selectedMod = null;
		if (panel.equals(modOnePanel)) {
			modOne = modOnePanel.getSelectedMod();
			selectedMod = getModByName(modOne);
			modOnePanel.setSelectedMod(selectedMod);
		} else if (panel.equals(modTwoPanel)) {
			modTwo = modTwoPanel.getSelectedMod();
			selectedMod = getModByName(modTwo);
			modTwoPanel.setSelectedMod(selectedMod);
		} else if (panel.equals(modThreePanel)) {
			modThree = modThreePanel.getSelectedMod();
			selectedMod = getModByName(modThree);
			modThreePanel.setSelectedMod(selectedMod);
		} else if (panel.equals(modFourPanel)) {
			modFour = modFourPanel.getSelectedMod();
			selectedMod = getModByName(modFour);
			modFourPanel.setSelectedMod(selectedMod);
		} else if (panel.equals(modFivePanel)) {
			modFive = modFivePanel.getSelectedMod();
			selectedMod = getModByName(modFive);
			modFivePanel.setSelectedMod(selectedMod);
		} else if (panel.equals(modSixPanel)) {
			modSix = modSixPanel.getSelectedMod();
			selectedMod = getModByName(modSix);
			modSixPanel.setSelectedMod(selectedMod);
		} else if (panel.equals(modSevenPanel)) {
			modSeven = modSevenPanel.getSelectedMod();
			selectedMod = getModByName(modSeven);
			modSevenPanel.setSelectedMod(selectedMod);
		} else if (panel.equals(modEightPanel)) {
			modEight = modEightPanel.getSelectedMod();
			selectedMod = getModByName(modEight);
			modEightPanel.setSelectedMod(selectedMod);
		} else if (panel.equals(modNinePanel)) {
			modNine = modNinePanel.getSelectedMod();
			selectedMod = getModByName(modNine);
			modNinePanel.setSelectedMod(selectedMod);
		}
		updateDropDownContents();
		calculateModCosts();
	}

	/**
	 * Updates the weapon box
	 */
	public void updateWeaponBox() {
		updatingDropDowns = true;
		weaponBox.removeAllItems();
		weaponBox.addItem(Constants.CUSTOM_WEAPON);
		for (Weapon weapon : weapInit.weapons) {
			if (weapon.type.equals(weaponType)) {
				weaponBox.addItem(weapon.name);
			}
		}
		updatingDropDowns = false;
	}

	/**
	 * Updates the fields with the selected weapon's stats
	 * 
	 * @param selected weapon
	 */
	public void updateFields(String selected) {
		Weapon selectedWeapon = null;
		if (selected.equals(Constants.CUSTOM_WEAPON)) {
			setCustom();
		} else {
			for (Weapon weapon : weapInit.weapons) {
				if (weapon.name.equals(selected)) {
					selectedWeapon = weapon;
				}
			}
		}
		if (selectedWeapon != null) {
			wap.weaponModeBox.setSelectedItem(selectedWeapon.mode);
			wap.damageTypeBox.setSelectedItem(selectedWeapon.damageType);
			wap.damageType2Box.setSelectedItem(selectedWeapon.damageType2);
			wap.meleeTypeBox.setSelectedItem(selectedWeapon.meleeType);
			wap.nameField.setText(selectedWeapon.name);
			wap.chargeTimeField.setText(selectedWeapon.chargeTime);
			wap.burstCountField.setText(selectedWeapon.burstCount);
			wap.damageField.setText(selectedWeapon.damage);
			wap.damage2Field.setText(selectedWeapon.damage2);
			wap.impactField.setText(selectedWeapon.impact);
			wap.punctureField.setText(selectedWeapon.puncture);
			wap.slashField.setText(selectedWeapon.slash);
			wap.fireRateField.setText(selectedWeapon.fireRate);
			wap.magSizeField.setText(selectedWeapon.magSize);
			wap.drainField.setText(selectedWeapon.drain);
			wap.comboField.setText(selectedWeapon.combo);
			wap.reloadField.setText(selectedWeapon.reload);
			wap.critField.setText(selectedWeapon.crit);
			wap.multiplierField.setText(selectedWeapon.critMult);
			wap.statusField.setText(selectedWeapon.status);
			wap.projectileField.setText(selectedWeapon.projeciles);
			wap.scopeBox.setSelectedItem(selectedWeapon.scopeBonus);
			wap.scopeStrengthBox.setSelectedIndex(0);
			wap.scopeStrengthField.setText("0");
			wap.explosiveDamage1Field.setText(selectedWeapon.explosiveDamage);
			wap.explosiveDamage2Field.setText(selectedWeapon.explosiveDamage2);
			wap.explosiveImpactField.setText(selectedWeapon.explosiveImpact);
			wap.explosivePunctureField.setText(selectedWeapon.explosivePuncture);
			wap.explosiveSlashField.setText(selectedWeapon.explosiveSlash);
			wap.damageType2Box.setSelectedItem(selectedWeapon.damageType2);
			wap.explosiveDamageType1Box.setSelectedItem(selectedWeapon.explosiveType1);
			wap.explosiveDamageType2Box.setSelectedItem(selectedWeapon.explosiveType2);
		}
	}

	/**
	 * Action Listener Callback
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(wap.weaponModeBox)) {
			updateWeaponModeOptions((String) wap.weaponModeBox.getSelectedItem());
		} else if (e.getSource().equals(wap.damageTypeBox)) {
			//updateWeaponDamageOptions((String) wap.damageTypeBox.getSelectedItem());
		} else if (e.getSource().equals(weaponBox)) {
			if (!updatingDropDowns) {
				setting = true;
				updateFields((String) weaponBox.getSelectedItem());
				addCCField.setText(null);
				addCDField.setText(null);
				addSCField.setText(null);
				addDamField.setText(null);
				addFRField.setText(null);
				setting = false;
				Main.repack();
			}
			updateDropDownContents();
		} else if (e.getSource().equals(potato)) {
			calculateModCosts();
		}
		  else if (e.getSource().equals(showExilus)) {
			  modNinePanel.setVisible(showExilus.isSelected());
		} else if (e.getSource().equals(hideAdd)) {
			if (additiveEffects.isVisible()) {
				additiveEffects.setVisible(false);
				Main.repack();
			} else {
				additiveEffects.setVisible(true);
				Main.repack();
			}
		} else if (e.getSource().equals(wap.scopeStrengthBox)) {
			Weapon selectedWeapon = null;
			String selected = (String) weaponBox.getSelectedItem();
			for (Weapon weapon : weapInit.weapons) {
				if (weapon.name.equals(selected)) {
					selectedWeapon = weapon;
				}
			}
			int scopeLevel = wap.scopeStrengthBox.getSelectedIndex();
			switch (scopeLevel) {
			case 0:
				wap.scopeStrengthField.setText("0");
				break;
			case 1:
				try {
				wap.scopeStrengthField.setText(selectedWeapon.scope1);
				} catch (Exception ex) {
					wap.scopeStrengthField.setText("0");
				}
				break;
			case 2:
				try {
				wap.scopeStrengthField.setText(selectedWeapon.scope2);
				} catch (Exception ex){
					wap.scopeStrengthField.setText("0");
				}
				break;
			case 3:
				try {
				wap.scopeStrengthField.setText(selectedWeapon.scope3);
				} catch (Exception ex){
					wap.scopeStrengthField.setText("0");
				}
				break;
			}

		} else if (e.getSource().equals(wap.meleeTypeBox)) {
			wap.stanceBox.removeAllItems();
			for (Stance s : stanceInit.stances) {
				if (s.weaponType.equals(wap.meleeTypeBox.getSelectedItem())) {
					wap.stanceBox.addItem(s.stanceName);
				}
			}
		} else if (e.getSource().equals(wap.stanceBox)) {
			wap.stanceComboBox.removeAllItems();
			for (Stance s : stanceInit.stances) {			
				if (s.stanceName.equals(wap.stanceBox.getSelectedItem())) {				
					for (Combo c : s.combos) {
						wap.stanceComboBox.addItem(c.comboName);
					}
					break;
				}
			}
		}
		if (!Main.setup && !setting) {
			Main.updateStats();
		}
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource().equals(vigiSlider)) {
			Main.updateStats();
		}
	}

	/**
	 * Returns whether this weapon is refire canceled or not
	 * 
	 * @return canceled?
	 */
	public boolean isRefireCanceled() {
		return refireCancel.isSelected();
	}
}