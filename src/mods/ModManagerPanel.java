package mods;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import etc.Constants;
import etc.UIBuilder;
import main.Main;
import weapons.WeaponPanel;

public class ModManagerPanel extends JPanel implements ActionListener, ListSelectionListener {

	/**
	 * ____________________________________________________________ CLASS VARIABLES
	 * ____________________________________________________________
	 */

	/** JPanels **/
	protected JPanel leftPanel = new JPanel();
	protected JPanel rightPanel = new JPanel();
	protected JPanel namePanel = new JPanel();
	protected JPanel typePanel = new JPanel();
	protected JPanel polarityPanel = new JPanel();
	protected JPanel costPanel = new JPanel();
	protected JPanel ranksPanel = new JPanel();
	protected JPanel effectOnePanel = new JPanel();
	protected JPanel effectTwoPanel = new JPanel();
	protected JPanel effectThreePanel = new JPanel();
	protected JPanel effectFourPanel = new JPanel();
	protected JPanel effectOneSubPanel = new JPanel();
	protected JPanel effectTwoSubPanel = new JPanel();
	protected JPanel effectThreeSubPanel = new JPanel();
	protected JPanel effectFourSubPanel = new JPanel();
	protected JPanel buttonPanel = new JPanel();
	protected JPanel filePanel = new JPanel();
	protected JPanel gradeButtonPanel = new JPanel();

	/** JButtons **/
	protected JButton addUpdateButton = new JButton("Add or Update");
	protected JButton deleteButton = new JButton("Delete");
	protected JButton saveButton = new JButton("Save");
	protected JButton gradeButton = new JButton("Grade Riven");

	/** JComboBoxes **/
	protected JComboBox<String> modTypeBox = new JComboBox<String>();
	protected JComboBox<String> modPolarityBox = new JComboBox<String>();
	protected JComboBox<String> modEffectOneBox = new JComboBox<String>();
	protected JComboBox<String> modEffectTwoBox = new JComboBox<String>();
	protected JComboBox<String> modEffectThreeBox = new JComboBox<String>();
	protected JComboBox<String> modEffectFourBox = new JComboBox<String>();

	/** JLabels **/
	protected JLabel nameLabel = new JLabel("Name - ");
	protected JLabel typeLabel = new JLabel("Type - ");
	protected JLabel polarityLabel = new JLabel("Polarity - ");
	protected JLabel ranksLabel = new JLabel("Ranks - ");
	protected JLabel costLabel = new JLabel("Base Point cost - ");

	/** JTextFields **/
	protected JTextField nameField = new JTextField(10);
	protected JTextField ranksField = new JTextField(10);
	protected JTextField costField = new JTextField(10);
	protected JTextField modPowerOneField = new JTextField(7);
	protected JTextField modPowerTwoField = new JTextField(7);
	protected JTextField modPowerThreeField = new JTextField(7);
	protected JTextField modPowerFourField = new JTextField(7);

	protected JTextField modPowerOneGrade = new JTextField(7);
	protected JTextField modPowerTwoGrade = new JTextField(7);
	protected JTextField modPowerThreeGrade = new JTextField(7);
	protected JTextField modPowerFourGrade = new JTextField(7);

	/** JLists **/
	protected DefaultListModel modListModel = new DefaultListModel();
	protected JList modList = new JList(modListModel);

	/** JScrollPanes **/
	protected JScrollPane modScroll = new JScrollPane(modList);

	/** Data **/
	protected ModInitializer initializer;
	protected Vector<String> modEffects = new Vector<String>();
	protected Mod selectedMod = null;
	public WeaponPanel rifle;
	public WeaponPanel shotgun;
	public WeaponPanel pistol;
	public WeaponPanel melee;
	public WeaponPanel ARCHGUN;

	protected static JRadioButton regularMods = new JRadioButton("Regular Mods");
	protected static JRadioButton maximizerMods = new JRadioButton("Maximizer Mods");
	protected ButtonGroup moddy = new ButtonGroup();
	protected JButton resetButton = new JButton("Reset Mods");
	protected static String modFile = "mods.db";

	// Riven helper Stuff
	protected JPanel dispoPanel = new JPanel();
	protected JPanel dispoLabelsPanel = new JPanel();
	protected JPanel dispoPositivesPanel = new JPanel();
	protected JPanel dispoNegativesPanel = new JPanel();
	protected JPanel dispoStatsPanel = new JPanel();
	protected JPanel dispoWeaponPanel = new JPanel();
	protected JPanel dispoRivenPanel = new JPanel();

	protected JLabel dispoMultishotLabel = new JLabel("Multishot - ");
	protected JLabel dispoDamageLabel = new JLabel("Damage - ");
	protected JLabel dispoPhysicalLabel = new JLabel("Physical Damage - ");
	protected JLabel dispoCCLabel = new JLabel("Critical Chance - ");
	protected JLabel dispoCDLabel = new JLabel("Critical Damage - ");
	protected JLabel dispoElementalLabel = new JLabel("Elemental Damage - ");
	protected JLabel dispoSCLabel = new JLabel("Status Chance - ");
	protected JLabel dispoSDLabel = new JLabel("Status Duration - ");
	protected JLabel dispoFactionLabel = new JLabel("Faction Damage - ");
	protected JLabel dispoFRLabel = new JLabel("Fire Rate - ");
	protected JLabel dispoMagLabel = new JLabel("Magazine Capacity - ");
	protected JLabel dispoAmmoLabel = new JLabel("Ammo Maximum - ");
	protected JLabel dispoPFSLabel = new JLabel("Flight Speed - ");
	protected JLabel dispoReloadLabel = new JLabel("Reload Speed - ");
	protected JLabel dispoRecoilLabel = new JLabel("Weapon Recoil - ");
	protected JLabel dispoZoomLabel = new JLabel("Zoom - ");
	protected JLabel dispoPTLabel = new JLabel("Punch Through - ");
	
	protected JTextField dispoMultishotPositiveField = new JTextField();
	protected JTextField dispoDamagePositiveField = new JTextField();
	protected JTextField dispoPhysicalPositiveField = new JTextField();
	protected JTextField dispoCCPositiveField = new JTextField();
	protected JTextField dispoCDPositiveField = new JTextField();
	protected JTextField dispoElementalPositiveField = new JTextField();
	protected JTextField dispoSCPositiveField = new JTextField();
	protected JTextField dispoSDPositiveField = new JTextField();
	protected JTextField dispoFactionPositiveField = new JTextField();
	protected JTextField dispoFRPositiveField = new JTextField();
	protected JTextField dispoMagPositiveField = new JTextField();
	protected JTextField dispoAmmoPositiveField = new JTextField();
	protected JTextField dispoPFSPositiveField = new JTextField();
	protected JTextField dispoReloadPositiveField = new JTextField();
	protected JTextField dispoRecoilPositiveField = new JTextField();
	protected JTextField dispoZoomPositiveField = new JTextField();
	protected JTextField dispoPTPositiveField = new JTextField();

	protected JTextField dispoMultishotNegativeField = new JTextField();
	protected JTextField dispoDamageNegativeField = new JTextField();
	protected JTextField dispoPhysicalNegativeField = new JTextField();
	protected JTextField dispoCCNegativeField = new JTextField();
	protected JTextField dispoCDNegativeField = new JTextField();
	protected JTextField dispoElementalNegativeField = new JTextField();
	protected JTextField dispoSCNegativeField = new JTextField();
	protected JTextField dispoSDNegativeField = new JTextField();
	protected JTextField dispoFactionNegativeField = new JTextField();
	protected JTextField dispoFRNegativeField = new JTextField();
	protected JTextField dispoMagNegativeField = new JTextField();
	protected JTextField dispoAmmoNegativeField = new JTextField();
	protected JTextField dispoPFSNegativeField = new JTextField();
	protected JTextField dispoReloadNegativeField = new JTextField();
	protected JTextField dispoRecoilNegativeField = new JTextField();
	protected JTextField dispoZoomNegativeField = new JTextField();
	protected JTextField dispoPTNegativeField = new JTextField();

	protected JComboBox<String> dispoWeapon = new JComboBox<String>();
	protected JComboBox<String> dispoWeaponType = new JComboBox<String>();
	protected JTextField dispoDisposition = new JTextField(3);

	protected JComboBox<String> dispoRank = new JComboBox<String>();
	protected JCheckBox hasNegative = new JCheckBox("Has Negative");
	protected JRadioButton twoBuffs = new JRadioButton("2 Buffs");
	protected JRadioButton threeBuffs = new JRadioButton("3 Buffs");
	protected ButtonGroup buffs = new ButtonGroup();

	protected boolean updating = false;

	double baseMultsihot;
	double baseDamage;
	double basePhysical;
	double baseCC;
	double baseCD;
	double baseElement;
	double baseSC;
	double baseSD;
	double baseFaction;
	double baseFR;
	double baseMag;
	double baseAmmo;
	double basePFS;
	double baseReload;
	double baseRecoil;
	double baseZoom;
	double basePT;
	double posMult;
	double negMult;

	/**
	 * ____________________________________________________________ METHODS
	 * ____________________________________________________________
	 */

	/**
	 * CTOR
	 */
	public ModManagerPanel(WeaponPanel riflePanel, WeaponPanel shotgunPanel, WeaponPanel pistolPanel, WeaponPanel meleePanel, WeaponPanel ARCHGUNPanel) {
		rifle = riflePanel;
		shotgun = shotgunPanel;
		pistol = pistolPanel;
		melee = meleePanel;
		ARCHGUN = ARCHGUNPanel;
		Init();
		buildUI();
	}
	
	/**
	 * Initializes the Data
	 */
	public void easyInit() {
		initializer = ModInitializer.getInstance();
		rifle.InitMods(modFile);
		rifle.updateDropDownContents();
		shotgun.InitMods(modFile);
		shotgun.updateDropDownContents();
		pistol.InitMods(modFile);
		pistol.updateDropDownContents();
		melee.InitMods(modFile);
		melee.updateDropDownContents();
		ARCHGUN.InitMods(modFile);
		ARCHGUN.updateDropDownContents();
		updateModList();
	}

	/**
	 * Initializes the Data
	 */
	public void Init() {

		// Initialize The Mod Data
		initializer = ModInitializer.getInstance();
		rifle.InitMods(modFile);
		rifle.updateDropDownContents();
		shotgun.InitMods(modFile);
		shotgun.updateDropDownContents();
		pistol.InitMods(modFile);
		pistol.updateDropDownContents();
		melee.InitMods(modFile);
		melee.updateDropDownContents();
		ARCHGUN.InitMods(modFile);
		ARCHGUN.updateDropDownContents();

		modEffects.clear();
		modEffects.add(Constants.MOD_TYPE_DAMAGE_BONUS);
		modEffects.add(Constants.MOD_TYPE_FIRE_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_LIGHTNING_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_ICE_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_PUNCTURE_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_TOXIN_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_MISC_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_MULTISHOT);
		modEffects.add(Constants.MOD_TYPE_FIRE_RATE);
		modEffects.add(Constants.MOD_TYPE_RELOAD_SPEED);
		modEffects.add(Constants.MOD_TYPE_MAG_CAP);
		modEffects.add(Constants.MOD_TYPE_AMMO_CAP);
		modEffects.add(Constants.MOD_TYPE_CORPUS_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_GRINEER_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_CORRUPTED_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_INFESTED_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_CRIT_CHANCE);
		modEffects.add(Constants.MOD_TYPE_CRIT_MULTIPLIER);
		modEffects.add(Constants.MOD_TYPE_STATUS_CHANCE);
		modEffects.add(Constants.MOD_TYPE_STATUS_DURATION);
		modEffects.add(Constants.MOD_TYPE_FIRST_SHOT_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_LAST_SHOT_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_ZOOM);
		modEffects.add(Constants.MOD_TYPE_OBJECT_PIERCE);
		modEffects.add(Constants.MOD_TYPE_AMMO_MUTATOR);
		modEffects.add(Constants.MOD_TYPE_ACCURACY);
		modEffects.add(Constants.MOD_TYPE_RECOIL);
		modEffects.add(Constants.MOD_TYPE_SPREAD);
		modEffects.add(Constants.MOD_TYPE_IMPACT_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_SLASH_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_SILENCE);
		modEffects.add(Constants.MOD_TYPE_FLAT_DAMAGE);
		modEffects.add(Constants.MOD_TYPE_DEAD_AIM);
		modEffects.add(Constants.MOD_TYPE_FLAT_STATUS);
		modEffects.add(Constants.MOD_TYPE_FLAT_MAG);
		modEffects.add(Constants.MOD_TYPE_MUNITIONS);
		modEffects.add(Constants.MOD_TYPE_VIGILANTE);
		modEffects.add(Constants.MOD_TYPE_VIGILANTE);
		modEffects.add(Constants.MOD_TYPE_VIGILANTE);
		modEffects.add(Constants.MOD_TYPE_VIGILANTE);
		modEffects.add(Constants.MOD_TYPE_VIGILANTE);
		modEffects.add(Constants.MOD_TYPE_COMBO_DURATION);
		modEffects.add(Constants.MOD_TYPE_COMBO_CRIT);
		modEffects.add(Constants.MOD_TYPE_COMBO_STATUS);
		modEffects.add(Constants.MOD_TYPE_CONDITION_OVERLOAD);
		modEffects.add(Constants.HEADSHOT_BONUS);
		modEffects.add(Constants.MOD_TYPE_ADDITIVE_CC);
		modEffects.add(Constants.MOD_TYPE_SHATTERING_IMPACT);
		modEffects.add("FlightSpeed");
		modEffects.add("--");

		Collections.sort(modEffects);

		modEffectOneBox.removeAllItems();
		modEffectTwoBox.removeAllItems();
		modEffectThreeBox.removeAllItems();
		modEffectFourBox.removeAllItems();

		for (int i = 0; i < modEffects.size(); i++) {
			modEffectOneBox.addItem(modEffects.get(i));
			modEffectTwoBox.addItem(modEffects.get(i));
			modEffectThreeBox.addItem(modEffects.get(i));
			modEffectFourBox.addItem(modEffects.get(i));
		}
		updateModList();
	}

	protected void buildUI() {

		UIBuilder.panelInit(this);
		UIBuilder.panelInit(leftPanel);
		UIBuilder.panelInit(rightPanel);
		UIBuilder.panelInit(namePanel);
		UIBuilder.panelInit(typePanel);
		UIBuilder.panelInit(polarityPanel);
		UIBuilder.panelInit(costPanel);
		UIBuilder.panelInit(ranksPanel);
		UIBuilder.panelInit(effectOnePanel);
		UIBuilder.panelInit(effectTwoPanel);
		UIBuilder.panelInit(effectThreePanel);
		UIBuilder.panelInit(effectFourPanel);
		UIBuilder.panelInit(effectOneSubPanel);
		UIBuilder.panelInit(effectTwoSubPanel);
		UIBuilder.panelInit(effectThreeSubPanel);
		UIBuilder.panelInit(effectFourSubPanel);
		UIBuilder.panelInit(buttonPanel);
		UIBuilder.panelInit(filePanel);
		UIBuilder.panelInit(dispoPanel);
		UIBuilder.panelInit(dispoLabelsPanel);
		UIBuilder.panelInit(dispoPositivesPanel);
		UIBuilder.panelInit(dispoNegativesPanel);
		UIBuilder.panelInit(dispoStatsPanel);
		UIBuilder.panelInit(dispoWeaponPanel);
		UIBuilder.panelInit(dispoRivenPanel);

		UIBuilder.labelInit(nameLabel);
		UIBuilder.labelInit(typeLabel);
		UIBuilder.labelInit(polarityLabel);
		UIBuilder.labelInit(costLabel);
		UIBuilder.labelInit(ranksLabel);
		UIBuilder.labelInit(dispoMultishotLabel);
		UIBuilder.labelInit(dispoDamageLabel);
		UIBuilder.labelInit(dispoPhysicalLabel);
		UIBuilder.labelInit(dispoCCLabel);
		UIBuilder.labelInit(dispoCDLabel);
		UIBuilder.labelInit(dispoElementalLabel);
		UIBuilder.labelInit(dispoSCLabel);
		UIBuilder.labelInit(dispoSDLabel);
		UIBuilder.labelInit(dispoFactionLabel);
		UIBuilder.labelInit(dispoFRLabel);
		UIBuilder.labelInit(dispoMagLabel);
		UIBuilder.labelInit(dispoAmmoLabel);
		UIBuilder.labelInit(dispoPFSLabel);
		UIBuilder.labelInit(dispoReloadLabel);
		UIBuilder.labelInit(dispoRecoilLabel);
		UIBuilder.labelInit(dispoZoomLabel);
		UIBuilder.labelInit(dispoPTLabel);

		UIBuilder.listInit(modList);

		UIBuilder.scrollPaneInit(modScroll);

		UIBuilder.comboBoxInit(modTypeBox);
		UIBuilder.comboBoxInit(modPolarityBox);
		UIBuilder.comboBoxInit(modEffectOneBox);
		UIBuilder.comboBoxInit(modEffectTwoBox);
		UIBuilder.comboBoxInit(modEffectThreeBox);
		UIBuilder.comboBoxInit(modEffectFourBox);
		UIBuilder.comboBoxInit(dispoWeapon);
		UIBuilder.comboBoxInit(dispoWeaponType);
		UIBuilder.comboBoxInit(dispoRank);

		UIBuilder.textFieldInit(nameField);
		UIBuilder.numberFieldInit(ranksField);
		UIBuilder.numberFieldInit(costField);
		UIBuilder.numberFieldInit(modPowerOneField);
		UIBuilder.numberFieldInit(modPowerTwoField);
		UIBuilder.numberFieldInit(modPowerThreeField);
		UIBuilder.numberFieldInit(modPowerFourField);
		UIBuilder.textFieldInit(modPowerOneGrade);
		UIBuilder.textFieldInit(modPowerTwoGrade);
		UIBuilder.textFieldInit(modPowerThreeGrade);
		UIBuilder.textFieldInit(modPowerFourGrade);
		UIBuilder.numberFieldInit(dispoDisposition);
		UIBuilder.textFieldInit(dispoMultishotPositiveField);
		UIBuilder.textFieldInit(dispoDamagePositiveField);
		UIBuilder.textFieldInit(dispoPhysicalPositiveField);
		UIBuilder.textFieldInit(dispoCCPositiveField);
		UIBuilder.textFieldInit(dispoCDPositiveField);
		UIBuilder.textFieldInit(dispoElementalPositiveField);
		UIBuilder.textFieldInit(dispoSCPositiveField);
		UIBuilder.textFieldInit(dispoSDPositiveField);
		UIBuilder.textFieldInit(dispoFactionPositiveField);
		UIBuilder.textFieldInit(dispoFRPositiveField);
		UIBuilder.textFieldInit(dispoMagPositiveField);
		UIBuilder.textFieldInit(dispoAmmoPositiveField);
		UIBuilder.textFieldInit(dispoPFSPositiveField);
		UIBuilder.textFieldInit(dispoReloadPositiveField);
		UIBuilder.textFieldInit(dispoRecoilPositiveField);
		UIBuilder.textFieldInit(dispoZoomPositiveField);
		UIBuilder.textFieldInit(dispoPTPositiveField);
		UIBuilder.textFieldInit(dispoMultishotNegativeField);
		UIBuilder.textFieldInit(dispoDamageNegativeField);
		UIBuilder.textFieldInit(dispoPhysicalNegativeField);
		UIBuilder.textFieldInit(dispoCCNegativeField);
		UIBuilder.textFieldInit(dispoCDNegativeField);
		UIBuilder.textFieldInit(dispoElementalNegativeField);
		UIBuilder.textFieldInit(dispoSCNegativeField);
		UIBuilder.textFieldInit(dispoSDNegativeField);
		UIBuilder.textFieldInit(dispoFactionNegativeField);
		UIBuilder.textFieldInit(dispoFRNegativeField);
		UIBuilder.textFieldInit(dispoMagNegativeField);
		UIBuilder.textFieldInit(dispoAmmoNegativeField);
		UIBuilder.textFieldInit(dispoPFSNegativeField);
		UIBuilder.textFieldInit(dispoReloadNegativeField);
		UIBuilder.textFieldInit(dispoRecoilNegativeField);
		UIBuilder.textFieldInit(dispoZoomNegativeField);
		UIBuilder.textFieldInit(dispoPTNegativeField);

		UIBuilder.buttonInit(addUpdateButton);
		UIBuilder.buttonInit(deleteButton);
		UIBuilder.buttonInit(saveButton);
		UIBuilder.buttonInit(resetButton);
		UIBuilder.buttonInit(gradeButton);

		UIBuilder.radioButtonInit(regularMods);
		UIBuilder.radioButtonInit(maximizerMods);
		UIBuilder.checkBoxInit(hasNegative);
		UIBuilder.radioButtonInit(twoBuffs);
		UIBuilder.radioButtonInit(threeBuffs);

		UIBuilder.createTitledLineBorder(dispoLabelsPanel, "Effects");
		UIBuilder.createTitledLineBorder(dispoPositivesPanel, "Positive");
		UIBuilder.createTitledLineBorder(dispoNegativesPanel, "Negative");
		UIBuilder.createTitledLineBorder(dispoPanel, "Riven Helper");

		modTypeBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
		modPolarityBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
		modEffectOneBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
		modEffectTwoBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
		modEffectThreeBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
		modEffectFourBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");

		modTypeBox.addItem(Constants.PISTOL);
		modTypeBox.addItem(Constants.RIFLE);
		modTypeBox.addItem(Constants.SHOTGUN);
		modTypeBox.addItem(Constants.MELEE);
		modTypeBox.addItem(Constants.ARCHGUN);

		modPolarityBox.addItem(Constants.NONE);
		modPolarityBox.addItem(Constants.DASH);
		modPolarityBox.addItem(Constants.D);
		modPolarityBox.addItem(Constants.V);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;

		effectOneSubPanel.setLayout(new GridBagLayout());
		effectTwoSubPanel.setLayout(new GridBagLayout());
		effectThreeSubPanel.setLayout(new GridBagLayout());
		effectFourSubPanel.setLayout(new GridBagLayout());
		gradeButtonPanel.setLayout(new GridBagLayout());
		leftPanel.setLayout(new GridLayout(1, 2, 0, 0));
		rightPanel.setLayout(new GridLayout(1, 2, 0, 0));
		namePanel.setLayout(new GridLayout(1, 2, 0, 0));
		typePanel.setLayout(new GridLayout(1, 2, 0, 0));
		polarityPanel.setLayout(new GridLayout(1, 2, 0, 0));
		costPanel.setLayout(new GridLayout(1, 2, 0, 0));
		ranksPanel.setLayout(new GridLayout(1, 2, 0, 0));
		effectOnePanel.setLayout(new GridLayout(1, 2, 0, 0));
		effectTwoPanel.setLayout(new GridLayout(1, 2, 0, 0));
		effectThreePanel.setLayout(new GridLayout(1, 2, 0, 0));
		effectFourPanel.setLayout(new GridLayout(1, 2, 0, 0));
		buttonPanel.setLayout(new GridLayout(1, 3, 0, 0));
		filePanel.setLayout(new GridLayout(1, 3, 0, 0));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		dispoPanel.setLayout(new BoxLayout(dispoPanel, BoxLayout.Y_AXIS));
		dispoLabelsPanel.setLayout(new GridLayout(17, 1, 0, 0));
		dispoPositivesPanel.setLayout(new GridLayout(17, 1, 0, 0));
		dispoNegativesPanel.setLayout(new GridLayout(17, 1, 0, 0));
		dispoStatsPanel.setLayout(new GridLayout(1, 3, 0, 0));

		modList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		modList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		modList.setVisibleRowCount(-1);
		modScroll.setPreferredSize(new Dimension(150, 380));

		leftPanel.add(modScroll);

		namePanel.add(nameLabel);
		namePanel.add(nameField);
		typePanel.add(typeLabel);
		typePanel.add(modTypeBox);
		polarityPanel.add(polarityLabel);
		polarityPanel.add(modPolarityBox);
		costPanel.add(costLabel);
		costPanel.add(costField);
		ranksPanel.add(ranksLabel);
		ranksPanel.add(ranksField);
		effectOneSubPanel.add(modPowerOneField, gbc);
		effectOneSubPanel.add(modPowerOneGrade, gbc);
		effectTwoSubPanel.add(modPowerTwoField, gbc);
		effectTwoSubPanel.add(modPowerTwoGrade, gbc);
		effectThreeSubPanel.add(modPowerThreeField, gbc);
		effectThreeSubPanel.add(modPowerThreeGrade, gbc);
		effectFourSubPanel.add(modPowerFourField, gbc);
		effectFourSubPanel.add(modPowerFourGrade, gbc);

		effectOnePanel.add(modEffectOneBox);
		effectOnePanel.add(effectOneSubPanel);
		effectTwoPanel.add(modEffectTwoBox);
		effectTwoPanel.add(effectTwoSubPanel);
		effectThreePanel.add(modEffectThreeBox);
		effectThreePanel.add(effectThreeSubPanel);
		effectFourPanel.add(modEffectFourBox);
		effectFourPanel.add(effectFourSubPanel);

		buttonPanel.add(addUpdateButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(saveButton);

		filePanel.add(regularMods);
		filePanel.add(maximizerMods);
		filePanel.add(resetButton);
		moddy.add(regularMods);
		moddy.add(maximizerMods);

		rightPanel.add(filePanel);
		rightPanel.add(namePanel);
		rightPanel.add(typePanel);
		rightPanel.add(polarityPanel);
		rightPanel.add(costPanel);
		rightPanel.add(ranksPanel);
		rightPanel.add(effectOnePanel);
		rightPanel.add(effectTwoPanel);
		rightPanel.add(effectThreePanel);
		rightPanel.add(effectFourPanel);
		rightPanel.add(buttonPanel);

		dispoLabelsPanel.add(dispoMultishotLabel);
		dispoLabelsPanel.add(dispoDamageLabel);
		dispoLabelsPanel.add(dispoPhysicalLabel);
		dispoLabelsPanel.add(dispoCCLabel);
		dispoLabelsPanel.add(dispoCDLabel);
		dispoLabelsPanel.add(dispoElementalLabel);
		dispoLabelsPanel.add(dispoSCLabel);
		dispoLabelsPanel.add(dispoSDLabel);
		dispoLabelsPanel.add(dispoFactionLabel);
		dispoLabelsPanel.add(dispoFRLabel);
		dispoLabelsPanel.add(dispoMagLabel);
		dispoLabelsPanel.add(dispoAmmoLabel);
		dispoLabelsPanel.add(dispoPFSLabel);
		dispoLabelsPanel.add(dispoReloadLabel);
		dispoLabelsPanel.add(dispoRecoilLabel);
		dispoLabelsPanel.add(dispoZoomLabel);
		dispoLabelsPanel.add(dispoPTLabel);

		dispoPositivesPanel.add(dispoMultishotPositiveField);
		dispoPositivesPanel.add(dispoDamagePositiveField);
		dispoPositivesPanel.add(dispoPhysicalPositiveField);
		dispoPositivesPanel.add(dispoCCPositiveField);
		dispoPositivesPanel.add(dispoCDPositiveField);
		dispoPositivesPanel.add(dispoElementalPositiveField);
		dispoPositivesPanel.add(dispoSCPositiveField);
		dispoPositivesPanel.add(dispoSDPositiveField);
		dispoPositivesPanel.add(dispoFactionPositiveField);
		dispoPositivesPanel.add(dispoFRPositiveField);
		dispoPositivesPanel.add(dispoMagPositiveField);
		dispoPositivesPanel.add(dispoAmmoPositiveField);
		dispoPositivesPanel.add(dispoPFSPositiveField);
		dispoPositivesPanel.add(dispoReloadPositiveField);
		dispoPositivesPanel.add(dispoRecoilPositiveField);
		dispoPositivesPanel.add(dispoZoomPositiveField);
		dispoPositivesPanel.add(dispoPTPositiveField);

		dispoNegativesPanel.add(dispoMultishotNegativeField);
		dispoNegativesPanel.add(dispoDamageNegativeField);
		dispoNegativesPanel.add(dispoPhysicalNegativeField);
		dispoNegativesPanel.add(dispoCCNegativeField);
		dispoNegativesPanel.add(dispoCDNegativeField);
		dispoNegativesPanel.add(dispoElementalNegativeField);
		dispoNegativesPanel.add(dispoSCNegativeField);
		dispoNegativesPanel.add(dispoSDNegativeField);
		dispoNegativesPanel.add(dispoFactionNegativeField);
		dispoNegativesPanel.add(dispoFRNegativeField);
		dispoNegativesPanel.add(dispoMagNegativeField);
		dispoNegativesPanel.add(dispoAmmoNegativeField);
		dispoNegativesPanel.add(dispoPFSNegativeField);
		dispoNegativesPanel.add(dispoReloadNegativeField);
		dispoNegativesPanel.add(dispoRecoilNegativeField);
		dispoNegativesPanel.add(dispoZoomNegativeField);
		dispoNegativesPanel.add(dispoPTNegativeField);

		dispoStatsPanel.add(dispoLabelsPanel);
		dispoStatsPanel.add(dispoPositivesPanel);
		dispoStatsPanel.add(dispoNegativesPanel);

		dispoWeaponPanel.add(dispoWeaponType);
		dispoWeaponPanel.add(dispoWeapon);
		dispoWeaponPanel.add(dispoDisposition);

		buffs.add(twoBuffs);
		buffs.add(threeBuffs);
		dispoRivenPanel.add(twoBuffs);
		dispoRivenPanel.add(threeBuffs);
		dispoRivenPanel.add(hasNegative);
		dispoRivenPanel.add(dispoRank);
		gradeButtonPanel.add(gradeButton, gbc);
		dispoPanel.add(dispoWeaponPanel);
		dispoPanel.add(dispoRivenPanel);
		dispoPanel.add(dispoStatsPanel);
		dispoPanel.add(gradeButtonPanel);

		dispoWeaponType.addItem(Constants.RIFLE);
		dispoWeaponType.addItem(Constants.PISTOL);
		dispoWeaponType.addItem(Constants.SHOTGUN);
		dispoWeaponType.addItem(Constants.ARCHGUN);

		dispoMultishotPositiveField.setEditable(false);
		dispoDamagePositiveField.setEditable(false);
		dispoPhysicalPositiveField.setEditable(false);
		dispoCCPositiveField.setEditable(false);
		dispoCDPositiveField.setEditable(false);
		dispoElementalPositiveField.setEditable(false);
		dispoSCPositiveField.setEditable(false);
		dispoSDPositiveField.setEditable(false);
		dispoFactionPositiveField.setEditable(false);
		dispoFRPositiveField.setEditable(false);
		dispoMagPositiveField.setEditable(false);
		dispoAmmoPositiveField.setEditable(false);
		dispoPFSPositiveField.setEditable(false);
		dispoReloadPositiveField.setEditable(false);
		dispoRecoilPositiveField.setEditable(false);
		dispoZoomPositiveField.setEditable(false);
		dispoPTPositiveField.setEditable(false);
		dispoMultishotNegativeField.setEditable(false);
		dispoDamageNegativeField.setEditable(false);
		dispoPhysicalNegativeField.setEditable(false);
		dispoCCNegativeField.setEditable(false);
		dispoCDNegativeField.setEditable(false);
		dispoElementalNegativeField.setEditable(false);
		dispoSCNegativeField.setEditable(false);
		dispoSDNegativeField.setEditable(false);
		dispoFactionNegativeField.setEditable(false);
		dispoFRNegativeField.setEditable(false);
		dispoMagNegativeField.setEditable(false);
		dispoAmmoNegativeField.setEditable(false);
		dispoPFSNegativeField.setEditable(false);
		dispoReloadNegativeField.setEditable(false);
		dispoRecoilNegativeField.setEditable(false);
		dispoZoomNegativeField.setEditable(false);
		dispoPTNegativeField.setEditable(false);
		modPowerOneGrade.setEditable(false);
		modPowerTwoGrade.setEditable(false);
		modPowerThreeGrade.setEditable(false);
		modPowerFourGrade.setEditable(false);

		dispoPTNegativeField.setEnabled(false);
		dispoElementalNegativeField.setEnabled(false);

		modPowerOneGrade.setVisible(false);
		modPowerTwoGrade.setVisible(false);
		modPowerThreeGrade.setVisible(false);
		modPowerFourGrade.setVisible(false);

		threeBuffs.setSelected(true);
		hasNegative.setSelected(true);

		updateDispoList();
		
		dispoRank.addItem("Rank 8");
		dispoRank.addItem("Rank 7");
		dispoRank.addItem("Rank 6");
		dispoRank.addItem("Rank 5");
		dispoRank.addItem("Rank 4");
		dispoRank.addItem("Rank 3");
		dispoRank.addItem("Rank 2");
		dispoRank.addItem("Rank 1");
		dispoRank.addItem("Rank 0");
		dispoRank.setMaximumRowCount(dispoRank.getModel().getSize());

		this.add(leftPanel);
		this.add(rightPanel);
		this.add(dispoPanel);

		addUpdateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		saveButton.addActionListener(this);
		gradeButton.addActionListener(this);

		regularMods.addActionListener(this);
		maximizerMods.addActionListener(this);
		resetButton.addActionListener(this);

		dispoWeapon.addActionListener(this);
		dispoWeaponType.addActionListener(this);
		dispoDisposition.addActionListener(this);
		dispoRank.addActionListener(this);
		hasNegative.addActionListener(this);
		twoBuffs.addActionListener(this);
		threeBuffs.addActionListener(this);

		modList.getSelectionModel().addListSelectionListener(this);

		regularMods.setSelected(true);

		resetButton.setToolTipText("Resets the currently selected mod list to its default");
		regularMods.setToolTipText("Use mods from the standard list");
		maximizerMods.setToolTipText("Use mods from the reduced list");

		// Initialize the values
		clearValues();

		calculateRivenStats();
	}
	

	void calculateRivenStats() {

		// Math stolen from Semlar!
		int rank = 9 - dispoRank.getSelectedIndex();
		posMult = Double.parseDouble(dispoDisposition.getText()) * 1.5 * rank / 9;
		if (hasNegative.isSelected()) {
			posMult *= 1.25;
		}
		if (twoBuffs.isSelected()) {
			posMult *= 0.66;
		} else {
			posMult *= 0.5;
		}

		negMult = -1 * Double.parseDouble(dispoDisposition.getText()) * 1.5 * rank / 9;
		if (!hasNegative.isSelected()) {
			negMult *= 0;
		}
		if (twoBuffs.isSelected()) {
			negMult *= 0.33;
		} else {
			negMult *= 0.5;
		}

		switch ((String) dispoWeaponType.getSelectedItem()) {
		case Constants.RIFLE:
			baseMultsihot = 90;
			baseDamage = 165;
			basePhysical = 120;
			baseCC = 150;
			baseCD = 120;
			baseElement = 90;
			baseSC = 90;
			baseSD = 100;
			baseFaction = 45;
			baseFR = 60;
			baseMag = 50;
			baseAmmo = 50;
			basePFS = 90;
			baseReload = 50;
			baseRecoil = -90;
			baseZoom = 60;
			basePT = 2.7;
			break;
		case Constants.PISTOL:
			baseMultsihot = 120;
			baseDamage = 220;
			basePhysical = 120;
			baseCC = 150;
			baseCD = 90;
			baseElement = 90;
			baseSC = 90;
			baseSD = 100;
			baseFaction = 45;
			baseFR = 75;
			baseMag = 50;
			baseAmmo = 90;
			basePFS = 90;
			baseReload = 50;
			baseRecoil = -90;
			baseZoom = 80;
			basePT = 2.7;
			break;
		case Constants.SHOTGUN:
			baseMultsihot = 120;
			baseDamage = 165;
			basePhysical = 120;
			baseCC = 90;
			baseCD = 90;
			baseElement = 90;
			baseSC = 90;
			baseSD = 100;
			baseFaction = 45;
			baseFR = 90;
			baseMag = 50;
			baseAmmo = 90;
			basePFS = 90;
			baseReload = 50;
			baseRecoil = -90;
			baseZoom = 0;
			basePT = 2.7;
			break;
		case Constants.ARCHGUN:
			baseMultsihot = 60;
			baseDamage = 100;
			basePhysical = 90;
			baseCC = 100;
			baseCD = 80;
			baseElement = 120;
			baseSC = 60;
			baseSD = 100;
			baseFaction = 45;
			baseFR = 60;
			baseMag = 60;
			baseAmmo = 100;
			basePFS = 0;
			baseReload = 100;
			baseRecoil = -100;
			baseZoom = 60;
			basePT = 2.7;
			break;
		}

		DecimalFormat f = new DecimalFormat("#.#");
		dispoMultishotPositiveField.setText(f.format(baseMultsihot * 0.9 * posMult) + "  to  " + f.format(baseMultsihot * 1.1 * posMult));
		dispoDamagePositiveField.setText(f.format(baseDamage * 0.9 * posMult) + "  to  " + f.format(baseDamage * 1.1 * posMult));
		dispoPhysicalPositiveField.setText(f.format(basePhysical * 0.9 * posMult) + "  to  " + f.format(basePhysical * 1.1 * posMult));
		dispoCCPositiveField.setText(f.format(baseCC * 0.9 * posMult) + "  to  " + f.format(baseCC * 1.1 * posMult));
		dispoCDPositiveField.setText(f.format(baseCD * 0.9 * posMult) + "  to  " + f.format(baseCD * 1.1 * posMult));
		dispoElementalPositiveField.setText(f.format(baseElement * 0.9 * posMult) + "  to  " + f.format(baseElement * 1.1 * posMult));
		dispoSCPositiveField.setText(f.format(baseSC * 0.9 * posMult) + "  to  " + f.format(baseSC * 1.1 * posMult));
		dispoSDPositiveField.setText(f.format(baseSD * 0.9 * posMult) + "  to  " + f.format(baseSD * 1.1 * posMult));
		dispoFactionPositiveField.setText(f.format(baseFaction * 0.9 * posMult) + "  to  " + f.format(baseFaction * 1.1 * posMult));
		dispoFRPositiveField.setText(f.format(baseFR * 0.9 * posMult) + "  to  " + f.format(baseFR * 1.1 * posMult));
		dispoMagPositiveField.setText(f.format(baseMag * 0.9 * posMult) + "  to  " + f.format(baseMag * 1.1 * posMult));
		dispoAmmoPositiveField.setText(f.format(baseAmmo * 0.9 * posMult) + "  to  " + f.format(baseAmmo * 1.1 * posMult));
		dispoPFSPositiveField.setText(f.format(basePFS * 0.9 * posMult) + "  to  " + f.format(basePFS * 1.1 * posMult));
		dispoReloadPositiveField.setText(f.format(baseReload * 0.9 * posMult) + "  to  " + f.format(baseReload * 1.1 * posMult));
		dispoRecoilPositiveField.setText(f.format(baseRecoil * 0.9 * posMult) + "  to  " + f.format(baseRecoil * 1.1 * posMult));
		dispoZoomPositiveField.setText(f.format(baseZoom * 0.9 * posMult) + "  to  " + f.format(baseZoom * 1.1 * posMult));
		dispoPTPositiveField.setText(f.format(basePT * 0.9 * posMult) + "  to  " + f.format(basePT * 1.1 * posMult));

		dispoMultishotNegativeField.setText(f.format(baseMultsihot * 0.9 * negMult) + "  to  " + f.format(baseMultsihot * 1.1 * negMult));
		dispoDamageNegativeField.setText(f.format(baseDamage * 0.9 * negMult) + "  to  " + f.format(baseDamage * 1.1 * negMult));
		dispoPhysicalNegativeField.setText(f.format(basePhysical * 0.9 * negMult) + "  to  " + f.format(basePhysical * 1.1 * negMult));
		dispoCCNegativeField.setText(f.format(baseCC * 0.9 * negMult) + "  to  " + f.format(baseCC * 1.1 * negMult));
		dispoCDNegativeField.setText(f.format(baseCD * 0.9 * negMult) + "  to  " + f.format(baseCD * 1.1 * negMult));
		dispoSCNegativeField.setText(f.format(baseSC * 0.9 * negMult) + "  to  " + f.format(baseSC * 1.1 * negMult));
		dispoSDNegativeField.setText(f.format(baseSD * 0.9 * negMult) + "  to  " + f.format(baseSD * 1.1 * negMult));
		dispoFactionNegativeField.setText(f.format(baseFaction * 0.9 * negMult) + "  to  " + f.format(baseFaction * 1.1 * negMult));
		dispoFRNegativeField.setText(f.format(baseFR * 0.9 * negMult) + "  to  " + f.format(baseFR * 1.1 * negMult));
		dispoMagNegativeField.setText(f.format(baseMag * 0.9 * negMult) + "  to  " + f.format(baseMag * 1.1 * negMult));
		dispoAmmoNegativeField.setText(f.format(baseAmmo * 0.9 * negMult) + "  to  " + f.format(baseAmmo * 1.1 * negMult));
		dispoPFSNegativeField.setText(f.format(basePFS * 0.9 * negMult) + "  to  " + f.format(basePFS * 1.1 * negMult));
		dispoReloadNegativeField.setText(f.format(baseReload * 0.9 * negMult) + "  to  " + f.format(baseReload * 1.1 * negMult));
		dispoRecoilNegativeField.setText(f.format(baseRecoil * 0.9 * negMult) + "  to  " + f.format(baseRecoil * 1.1 * negMult));
		dispoZoomNegativeField.setText(f.format(baseZoom * 0.9 * negMult) + "  to  " + f.format(baseZoom * 1.1 * negMult));
	}

	/**
	 * Action Listener Callback
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(addUpdateButton)) {

			String newModString = getCurrentModString();
			Mod newMod = new Mod(newModString);

			// Check to see if it already exists
			Mod foundMod = getModByName(newMod.name);

			// if it exists: up date it. Otherwise: add it.
			if (foundMod != null) {
				initializer.mods.set(initializer.mods.indexOf(foundMod), newMod);
			} else {
				initializer.mods.add(newMod);
			}

			updateModList();

		} else if (e.getSource().equals(deleteButton)) {

			if (initializer.mods.contains(selectedMod)) {
				initializer.mods.removeElement(selectedMod);
			}
			updateModList();

		} else if (e.getSource().equals(saveButton)) {

			saveModDB();

		} else if (e.getSource().equals(regularMods)) { // Switching between mod files (maximizer uses a tuned set of mods)
			modFile = "mods.db";
			easyInit();
		} else if (e.getSource().equals(maximizerMods)) {
			modFile = "maximizerMods.db";
			easyInit();
		} else if (e.getSource().equals(resetButton)) {
			initializer.deleteMods();
			Init();
		} else if (e.getSource().equals(dispoWeapon)) {
			if (updating == false) {
				String weapon = (String) dispoWeapon.getSelectedItem();
				if (weapon != "--") {
					dispoDisposition.setText(weapon.split(",")[1]);
					calculateRivenStats();
				} else {
					dispoDisposition.setText("1.00");
				}
			}
		} else if (e.getSource().equals(dispoWeaponType)) {
			updating = true;
			updateDispoList();
			calculateRivenStats();
			updating = false;
		} else if (e.getSource().equals(gradeButton)) {
			gradeRiven();
		} else {
			calculateRivenStats();
		}
	}

	/**
	 * Updates the weapons in the dispo list
	 */
	public void updateDispoList() {
		String[] list = Constants.rifleDispositions;
		String file = "RifleDispos.db";	
		Vector<String> weaponDispos = new Vector<String>();
		dispoWeapon.removeAllItems();
		dispoDisposition.setText("1.00");
		
		if (dispoWeaponType.getSelectedItem().equals(Constants.PISTOL)) {
			file = "PistolDispos.db";
			list = Constants.pistolDispositions;
		} else if (dispoWeaponType.getSelectedItem().equals(Constants.SHOTGUN)){
			file = "ShotgunDispos.db";
			list = Constants.shotgunDispositions;
		} else if (dispoWeaponType.getSelectedItem().equals(Constants.ARCHGUN)){
			file = "ArchgunDispos.db";
			list = Constants.ArchGunDispositions;
		}
		
		File dispoFile = new File(file);
		try {
			if (dispoFile.exists()) {
				weaponDispos.clear();
				BufferedReader reader = new BufferedReader(new FileReader(dispoFile));
				String line = reader.readLine();
				while (line != null) {
					weaponDispos.add(line.split(", ")[1] + ", " + line.split(",")[0]);
					line = reader.readLine();
				}
				reader.close();
			} else {
				weaponDispos.clear();
				dispoFile.createNewFile();
				BufferedWriter writer = new BufferedWriter(new FileWriter(dispoFile));
				for (String weapon : list) {
					writer.write(weapon + "\n");
					weaponDispos.add(weapon.split(", ")[1] + ", " + weapon.split(",")[0]);
				}
				writer.close();

			}
		} catch (Exception e) {
			Main.output.append("Could not access mods.db");
		}
		weaponDispos.add("--");
		Collections.sort(weaponDispos);
		dispoWeapon.setModel(new DefaultComboBoxModel(weaponDispos));
	}
	
	/**
	 * List Selection Listener
	 */
	public void valueChanged(ListSelectionEvent e) {
		try {
			String modName = (String) modListModel.get(modList.getSelectedIndex());
			selectedMod = getModByName(modName);
			updateSelectedValues();
		} catch (Exception ex) {
			//clearValues();
		}
	}

	/**
	 * Gets the mod with the supplied name
	 * 
	 * @param name
	 * @return the mod
	 */
	public Mod getModByName(String name) {
		Mod localMod = null;
		for (int i = 0; i < initializer.mods.size(); i++) {
			if (initializer.mods.get(i).name.equals(name)) {
				localMod = initializer.mods.get(i);
			}
		}

		return localMod;
	}

	/**
	 * Rebuilds the list of mods based on the stored mods vector
	 */
	public void updateModList() {
		// Sort by name
		Collections.sort(initializer.mods);

		// Sort by type
		Vector<Mod> sortedMods = new Vector<Mod>();
		String types[] = { "Rifle", "Shotgun", "Pistol", "Melee", "ArchGun" };
		for (String type : types) {
			for (int i = 0; i < initializer.mods.size(); i++) {
				if (initializer.mods.get(i).type.equals(type)) {
					sortedMods.add(initializer.mods.get(i));
				}
			}
		}

		modListModel.clear();
		for (int i = 0; i < sortedMods.size(); i++) {
			modListModel.addElement(sortedMods.get(i).name);
		}
	}

	/**
	 * Grades the current mod as if it were a riven
	 */
	void gradeRiven() {
		modPowerOneGrade.setVisible(false);
		modPowerTwoGrade.setVisible(false);
		modPowerThreeGrade.setVisible(false);
		modPowerFourGrade.setVisible(false);
		if (modEffectOneBox.getSelectedIndex() > 0) {
			gradeStat(1, (String) modEffectOneBox.getSelectedItem(), Double.parseDouble(modPowerOneField.getText()));
			modPowerOneGrade.setVisible(true);
		}
		if (modEffectTwoBox.getSelectedIndex() > 0) {
			gradeStat(2, (String) modEffectTwoBox.getSelectedItem(), Double.parseDouble(modPowerTwoField.getText()));
			modPowerTwoGrade.setVisible(true);
		}
		if (modEffectThreeBox.getSelectedIndex() > 0) {
			gradeStat(3, (String) modEffectThreeBox.getSelectedItem(), Double.parseDouble(modPowerThreeField.getText()));
			modPowerThreeGrade.setVisible(true);
		}
		if (modEffectFourBox.getSelectedIndex() > 0) {
			gradeStat(4, (String) modEffectFourBox.getSelectedItem(), Double.parseDouble(modPowerFourField.getText()));
			modPowerFourGrade.setVisible(true);
		}
		this.revalidate();
	}

	/**
	 * Grades the stat
	 */
	void gradeStat(int whichEffect, String effect, double power) {
		double compareTo = 0;

		switch (effect) {
		case "Multishot":
			if (power > 0) {
				compareTo = baseMultsihot * posMult;
			} else {
				compareTo = baseMultsihot * negMult;
			}
			break;
		case "Damage":
			if (power > 0) {
				compareTo = baseDamage * posMult;
			} else {
				compareTo = baseDamage * negMult;
			}
			break;
		case "ImpactDamage":
		case "PunctureDamage":
		case "SlashDamage":
			if (power > 0) {
				compareTo = basePhysical * posMult;
			} else {
				compareTo = basePhysical * negMult;
			}
			break;
		case "CritChance":
			if (power > 0) {
				compareTo = baseCC * posMult;
			} else {
				compareTo = baseCC * negMult;
			}
			break;
		case "CritMultiplier":
			if (power > 0) {
				compareTo = baseCD * posMult;
			} else {
				compareTo = baseCD * negMult;
			}
			break;
		case "ElectricDamage":
		case "FireDamage":
		case "ToxinDamage":
		case "IceDamage":
			if (power > 0) {
				compareTo = baseElement * posMult;
			} else {
				compareTo = baseElement * negMult;
			}
			break;
		case "StatusChance":
			if (power > 0) {
				compareTo = baseSC * posMult;
			} else {
				compareTo = baseSC * negMult;
			}
			break;
		case "StatusDuration":
			if (power > 0) {
				compareTo = baseSD * posMult;
			} else {
				compareTo = baseSD * negMult;
			}
			break;
		case "GrineerDamage":
		case "InfestedDamage":
		case "CorpusDamage":
		case "CorruptedDamage":
			if (power > 0) {
				compareTo = baseFaction * posMult;
			} else {
				compareTo = baseFaction * negMult;
			}
			break;
		case "FireRate":
			if (power > 0) {
				compareTo = baseFR * posMult;
			} else {
				compareTo = baseFR * negMult;
			}
			break;
		case "MagCap":
			if (power > 0) {
				compareTo = baseMag * posMult;
			} else {
				compareTo = baseMag * negMult;
			}
			break;
		case "AmmoCap":
			if (power > 0) {
				compareTo = baseAmmo * posMult;
			} else {
				compareTo = baseAmmo * negMult;
			}
			break;
		case "FlightSpeed":
			if (power > 0) {
				compareTo = basePFS * posMult;
			} else {
				compareTo = basePFS * negMult;
			}
			break;
		case "ReloadSpeed":
			if (power > 0) {
				compareTo = baseReload * posMult;
			} else {
				compareTo = baseReload * negMult;
			}
			break;
		case "RecoilBonus":
			if (power < 0) {
				compareTo = baseRecoil * posMult;
			} else {
				compareTo = baseRecoil * negMult;
			}
			break;
		case "Zoom":
			if (power > 0) {
				compareTo = baseZoom * posMult;
			} else {
				compareTo = baseZoom * negMult;
			}
			break;
		case "PunchThrough":
			if (power > 0) {
				compareTo = basePT * posMult;
			} else {
				compareTo = basePT * negMult;
			}
		}

		DecimalFormat f = new DecimalFormat("#.###");
		double grade;
		if (power > 0) {
			grade = 100 * ((power / compareTo) - 1);
		} else {
			grade = 100 * (1 - (power / compareTo));
		}

		// Find color
		int R = (255 - (int) (((grade * 5) + 50) * 2.55)) * 2;
		if (R > 255)
			R = 255;
		if (R < 0)
			R = 0;
		int G = ((int) (((grade * 5) + 50) * 2.55)) * 2;
		if (G > 255)
			G = 255;
		if (G < 0)
			G = 0;
		Color gradeColor = new Color(R, G, 00);

		// Find letter
		String gradeLetter = "";
		if (grade > 10.01) {
			gradeLetter = "ERR";
		} else if (grade >= 9.5) {
			gradeLetter = "S";
		} else if (grade >= 7.5) {
			gradeLetter = "A+";
		} else if (grade >= 5.5) {
			gradeLetter = "A";
		} else if (grade >= 3.5) {
			gradeLetter = "A-";
		} else if (grade >= 1.5) {
			gradeLetter = "B+";
		} else if (grade >= -1.5) {
			gradeLetter = "B";
		} else if (grade >= -3.5) {
			gradeLetter = "B-";
		} else if (grade >= -5.5) {
			gradeLetter = "C+";
		} else if (grade >= -7.5) {
			gradeLetter = "C";
		} else if (grade >= -9.5) {
			gradeLetter = "C-";
		} else if (grade >= -10) {
			gradeLetter = "F";
		} else {
			gradeLetter = "ERR";
		}

		String gradeStr = "";
		if (grade > 0) {
			gradeStr += gradeLetter + " (+" + f.format(grade) + "%)";
		} else {
			gradeStr += gradeLetter + " (" + f.format(grade) + "%)";
		}

		if (whichEffect == 1) {
			modPowerOneGrade.setText(gradeStr);
			modPowerOneGrade.setForeground(gradeColor);
		} else if (whichEffect == 2) {
			modPowerTwoGrade.setText(gradeStr);
			modPowerTwoGrade.setForeground(gradeColor);
		} else if (whichEffect == 3) {
			modPowerThreeGrade.setText(gradeStr);
			modPowerThreeGrade.setForeground(gradeColor);
		} else {
			modPowerFourGrade.setText(gradeStr);
			modPowerFourGrade.setForeground(gradeColor);
		}
	}

	/**
	 * Clears the data values
	 */
	public void clearValues() {
		modPowerOneGrade.setVisible(false);
		modPowerTwoGrade.setVisible(false);
		modPowerThreeGrade.setVisible(false);
		modPowerFourGrade.setVisible(false);
		modTypeBox.setSelectedItem(Constants.RIFLE);
		modPolarityBox.setSelectedItem(Constants.NONE);
		nameField.setText("");
		ranksField.setText("0");
		costField.setText("0");
		modPowerOneField.setText("0");
		modEffectOneBox.setSelectedIndex(0);
		modPowerTwoField.setText("0");
		modEffectTwoBox.setSelectedIndex(0);
		modPowerThreeField.setText("0");
		modEffectThreeBox.setSelectedIndex(0);
		modPowerFourField.setText("0");
		modEffectFourBox.setSelectedIndex(0);
		this.revalidate();
	}

	/**
	 * Updates the values on the right side to those of the mod selected on the left
	 * side
	 */
	public void updateSelectedValues() {

		// Clear the previous values
		clearValues();

		// Update the new values
		modTypeBox.setSelectedItem(selectedMod.type);
		modPolarityBox.setSelectedItem(selectedMod.polarity);

		nameField.setText(selectedMod.name);
		ranksField.setText("" + selectedMod.ranks);
		costField.setText("" + selectedMod.baseCost);

		if (selectedMod.effectTypes.size() == 1) {
			modPowerOneField.setText("" + (selectedMod.effectStrengths.get(0) * 100.0));
			modEffectOneBox.setSelectedItem(selectedMod.effectTypes.get(0));
		} else if (selectedMod.effectTypes.size() == 2) {
			modPowerOneField.setText("" + (selectedMod.effectStrengths.get(0) * 100.0));
			modEffectOneBox.setSelectedItem(selectedMod.effectTypes.get(0));
			modPowerTwoField.setText("" + (selectedMod.effectStrengths.get(1) * 100.0));
			modEffectTwoBox.setSelectedItem(selectedMod.effectTypes.get(1));
		} else if (selectedMod.effectTypes.size() == 3) {
			modPowerOneField.setText("" + (selectedMod.effectStrengths.get(0) * 100.0));
			modEffectOneBox.setSelectedItem(selectedMod.effectTypes.get(0));
			modPowerTwoField.setText("" + (selectedMod.effectStrengths.get(1) * 100.0));
			modEffectTwoBox.setSelectedItem(selectedMod.effectTypes.get(1));
			modPowerThreeField.setText("" + (selectedMod.effectStrengths.get(2) * 100.0));
			modEffectThreeBox.setSelectedItem(selectedMod.effectTypes.get(2));
		} else {
			modPowerOneField.setText("" + (selectedMod.effectStrengths.get(0) * 100.0));
			modEffectOneBox.setSelectedItem(selectedMod.effectTypes.get(0));
			modPowerTwoField.setText("" + (selectedMod.effectStrengths.get(1) * 100.0));
			modEffectTwoBox.setSelectedItem(selectedMod.effectTypes.get(1));
			modPowerThreeField.setText("" + (selectedMod.effectStrengths.get(2) * 100.0));
			modEffectThreeBox.setSelectedItem(selectedMod.effectTypes.get(2));
			modPowerFourField.setText("" + (selectedMod.effectStrengths.get(3) * 100.0));
			modEffectFourBox.setSelectedItem(selectedMod.effectTypes.get(3));
		}
	}

	/**
	 * Builds a mod string from the current data values
	 * 
	 * @return the mod string
	 */
	public String getCurrentModString() {

		// Get Values
		String newName = nameField.getText();
		String newType = (String) modTypeBox.getSelectedItem();
		String newRanks = ranksField.getText();
		String newModEffectOne = (String) modEffectOneBox.getSelectedItem();
		String newModPowerOne = modPowerOneField.getText();
		String newModEffectTwo = (String) modEffectTwoBox.getSelectedItem();
		String newModPowerTwo = modPowerTwoField.getText();
		String newModEffectThree = (String) modEffectThreeBox.getSelectedItem();
		String newModPowerThree = modPowerThreeField.getText();
		String newModEffectFour = (String) modEffectFourBox.getSelectedItem();
		String newModPowerFour = modPowerFourField.getText();
		String newPolarity = (String) modPolarityBox.getSelectedItem();
		String newCost = costField.getText();

		// Check Values
		if (newName.equals("")) {
			newName = "Unnamed Mod";
		}
		try {
			Integer.parseInt(newRanks);
		} catch (Exception ex) {
			newRanks = "0";
		}
		try {
			double newModPowerOneDbl = Double.parseDouble(newModPowerOne);
			newModPowerOne = "" + (newModPowerOneDbl / 100.0);
		} catch (Exception ex) {
			newModPowerOne = "0.0";
		}
		try {
			double newModPowerTwoDbl = Double.parseDouble(newModPowerTwo);
			newModPowerTwo = "" + (newModPowerTwoDbl / 100.0);
		} catch (Exception ex) {
			newModPowerTwo = "0.0";
		}
		try {
			double newModPowerThreeDbl = Double.parseDouble(newModPowerThree);
			newModPowerThree = "" + (newModPowerThreeDbl / 100.0);
		} catch (Exception ex) {
			newModPowerThree = "0.0";
		}
		try {
			double newModPowerFourDbl = Double.parseDouble(newModPowerFour);
			newModPowerFour = "" + (newModPowerFourDbl / 100.0);
		} catch (Exception ex) {
			newModPowerFour = "0.0";
		}
		try {
			Integer.parseInt(newCost);
		} catch (Exception ex) {
			newCost = "0";
		}

		// Count effects
		int effects = 0;
		if (modEffectOneBox.getSelectedIndex() > 0) {
			effects++;
		}
		if (modEffectTwoBox.getSelectedIndex() > 0) {
			effects++;
		}
		if (modEffectThreeBox.getSelectedIndex() > 0) {
			effects++;
		}
		if (modEffectFourBox.getSelectedIndex() > 0) {
			effects++;
		}

		// Build the String
		String newModString = newName + "," + newType + "," + newRanks + "," + effects + ",";

		// Add effects to the string. (I know this is terrible, but it's staying this
		// way until i feel like rewriting all the mods in the database)
		if (modEffectOneBox.getSelectedIndex() > 0) {
			newModString += newModEffectOne + ",";
		}
		if (modEffectTwoBox.getSelectedIndex() > 0) {
			newModString += newModEffectTwo + ",";
		}
		if (modEffectThreeBox.getSelectedIndex() > 0) {
			newModString += newModEffectThree + ",";
		}
		if (modEffectFourBox.getSelectedIndex() > 0) {
			newModString += newModEffectFour + ",";
		}
		if (modEffectOneBox.getSelectedIndex() > 0) {
			newModString += newModPowerOne + ",";
		}
		if (modEffectTwoBox.getSelectedIndex() > 0) {
			newModString += newModPowerTwo + ",";
		}
		if (modEffectThreeBox.getSelectedIndex() > 0) {
			newModString += newModPowerThree + ",";
		}
		if (modEffectFourBox.getSelectedIndex() > 0) {
			newModString += newModPowerFour + ",";
		}

		newModString += newPolarity + "," + newCost;

		return newModString;
	}

	public void saveModDB() {
		try {
			initializer.saveModDB();
			rifle.InitMods(modFile);
			rifle.updateDropDownContents();
			shotgun.InitMods(modFile);
			shotgun.updateDropDownContents();
			pistol.InitMods(modFile);
			pistol.updateDropDownContents();
			melee.InitMods(modFile);
			melee.updateDropDownContents();
			ARCHGUN.InitMods(modFile);
			ARCHGUN.updateDropDownContents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
