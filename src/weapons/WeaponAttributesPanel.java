package weapons;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import etc.Constants;
import etc.UIBuilder;


public class WeaponAttributesPanel extends JPanel {
  
  /**
   * ____________________________________________________________
   * GLOBAL VARIABLES
   * ____________________________________________________________
   */
  
  /** JPanels **/
  protected JPanel namePanel = new JPanel();
  protected JPanel impactPanel = new JPanel();
  protected JPanel puncturePanel = new JPanel();
  protected JPanel slashPanel = new JPanel();
  protected JPanel fireRatePanel = new JPanel();
  protected JPanel magSizePanel = new JPanel();
  protected JPanel comboPanel = new JPanel();
  protected JPanel startingComboPanel = new JPanel();
  protected JPanel reloadPanel = new JPanel();
  protected JPanel critChancePanel = new JPanel();
  protected JPanel critMultPanel = new JPanel();
  protected JPanel weaponModePanel = new JPanel();
  protected JPanel damageTypePanel = new JPanel();
  protected JPanel chargeTimePanel = new JPanel();
  protected JPanel burstCountPanel = new JPanel();
  protected JPanel projectilePanel = new JPanel();
  protected JPanel statusPanel = new JPanel();
  protected JPanel drainPanel = new JPanel();
  protected JPanel scopePanel = new JPanel();
  protected JPanel meleeTypePanel = new JPanel();
  protected JPanel stancePanel = new JPanel();
  protected JPanel stanceComboPanel = new JPanel();
  protected JPanel explosiveImpactPanel = new JPanel();
  protected JPanel explosivePuncturePanel = new JPanel();
  protected JPanel explosiveSlashPanel = new JPanel();
  protected JPanel damageType2Panel = new JPanel();
  protected JPanel explosiveDamageType1Panel = new JPanel();
  protected JPanel explosiveDamageType2Panel = new JPanel();
  protected JPanel ele1SubPanel = new JPanel();
  protected JPanel ele2SubPanel = new JPanel();
  protected JPanel exEle1SubPanel = new JPanel();
  protected JPanel exEle2SubPanel = new JPanel();
  
  /** JComboBoxes **/
  protected JComboBox<String> damageTypeBox = new JComboBox<String>();
  public JComboBox<String> weaponModeBox = new JComboBox<String>();
  protected JComboBox<String> weaponBox = new JComboBox<String>();
  protected JComboBox<String> scopeBox = new JComboBox<String>();
  protected JComboBox<String> scopeStrengthBox = new JComboBox<String>(); 
  protected JComboBox<String> meleeTypeBox = new JComboBox<String>();
  protected JComboBox<String> stanceBox = new JComboBox<String>();
  protected JComboBox<String> stanceComboBox = new JComboBox<String>();
  protected JComboBox<String> damageType2Box = new JComboBox<String>();
  protected JComboBox<String> explosiveDamageType1Box = new JComboBox<String>();
  protected JComboBox<String> explosiveDamageType2Box = new JComboBox<String>();
  
  /** JLabels **/
  protected JLabel nameLabel = new JLabel("Name - ");
  protected JLabel weaponModeLabel = new JLabel("Mode of Operation - ");
  protected JLabel damageTypeLabel = new JLabel("Elemental Type 1 - ");
  protected JLabel chargeTimeLabel = new JLabel("Charge Time - ");
  protected JLabel burstCountLabel = new JLabel("Burst Count - ");
  protected JLabel impactLabel = new JLabel("Impact Damage - ");
  protected JLabel punctureLabel = new JLabel("Puncture Damage - ");
  protected JLabel slashLabel = new JLabel("Slash Damage - ");
  protected JLabel fireRateLabel = new JLabel("Rate of Fire - ");
  protected JLabel magSizeLabel = new JLabel("Magazine Capacity - ");
  protected JLabel comboLabel = new JLabel("Mimimum Combo - ");
  protected JLabel startingComboLabel = new JLabel("Starting Combo - ");
  protected JLabel reloadTimeLabel = new JLabel("Reload Time - ");
  protected JLabel critChanceLabel = new JLabel("Crit Chance - ");
  protected JLabel critMultiplierLabel = new JLabel("Crit Multiplier - ");
  protected JLabel projectileLabel = new JLabel("Projectile Count - ");
  protected JLabel statusLabel = new JLabel("Status Chance - ");
  protected JLabel drainLabel = new JLabel("Ammo Drain - ");
  protected JLabel meleeTypeLabel = new JLabel("Melee Type - ");
  protected JLabel stanceLabel = new JLabel("Stance - ");
  protected JLabel stanceComboLabel = new JLabel("Combo - ");
  protected JLabel explosiveDamageLabel = new JLabel("Explosion Ele 1 Dmg - ");
  protected JLabel explosiveImpactLabel = new JLabel("Explosion Impact - ");
  protected JLabel explosivePunctureLabel = new JLabel("Explosion Puncture - ");
  protected JLabel explosiveSlashLabel = new JLabel("Explosion Slash - ");
  protected JLabel damageType2Label = new JLabel("Elemental Type 2 - ");
  protected JLabel explosiveDamageType1Label = new JLabel("Ex Element Type 1 - ");
  protected JLabel explosiveDamageType2Label = new JLabel("Ex Element Type 2 - ");
  
  /** JTextFields **/
  protected JTextField chargeTimeField = new JTextField(8);
  protected JTextField burstCountField = new JTextField(8);
  protected JTextField nameField = new JTextField(8);
  protected JTextField damageField = new JTextField(8);
  protected JTextField impactField = new JTextField(8);
  protected JTextField punctureField = new JTextField(8);
  protected JTextField slashField = new JTextField(8);
  protected JTextField fireRateField = new JTextField(8);
  protected JTextField magSizeField = new JTextField(8);
  protected JTextField comboField = new JTextField(8);
  protected JTextField startingComboField = new JTextField(8);
  protected JTextField reloadField = new JTextField(8);
  protected JTextField critField = new JTextField(8);
  protected JTextField multiplierField = new JTextField(8);
  protected JTextField projectileField = new JTextField(8);
  protected JTextField statusField = new JTextField(8);
  protected JTextField drainField = new JTextField(8);
  protected JTextField scopeStrengthField = new JTextField(4);
  protected JTextField explosiveDamage1Field = new JTextField(8);
  protected JTextField explosiveImpactField = new JTextField(8);
  protected JTextField explosivePunctureField = new JTextField(8);
  protected JTextField explosiveSlashField = new JTextField(8);
  
  protected JTextField damage2Field = new JTextField(8);
  protected JTextField explosiveDamage2Field = new JTextField(8);
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public WeaponAttributesPanel(){
    buildUI();
  }
  
  /**
   * Builds the UI
   */
  public void buildUI(){
    UIBuilder.comboBoxInit(weaponModeBox);
    UIBuilder.comboBoxInit(damageTypeBox);
    UIBuilder.comboBoxInit(scopeBox);
    UIBuilder.comboBoxInit(scopeStrengthBox);
    UIBuilder.comboBoxInit(meleeTypeBox);
    UIBuilder.comboBoxInit(stanceBox);
    UIBuilder.comboBoxInit(stanceComboBox);
    UIBuilder.comboBoxInit(damageType2Box);
    UIBuilder.comboBoxInit(explosiveDamageType1Box);
    UIBuilder.comboBoxInit(explosiveDamageType2Box);
    
    UIBuilder.labelInit(nameLabel);
    UIBuilder.labelInit(impactLabel);
    UIBuilder.labelInit(punctureLabel);
    UIBuilder.labelInit(slashLabel);
    UIBuilder.labelInit(fireRateLabel);
    UIBuilder.labelInit(magSizeLabel);
    UIBuilder.labelInit(comboLabel);
    UIBuilder.labelInit(startingComboLabel);
    UIBuilder.labelInit(reloadTimeLabel);
    UIBuilder.labelInit(critChanceLabel);
    UIBuilder.labelInit(critMultiplierLabel);
    UIBuilder.labelInit(weaponModeLabel);
    UIBuilder.labelInit(damageTypeLabel);
    UIBuilder.labelInit(chargeTimeLabel);
    UIBuilder.labelInit(burstCountLabel);
    UIBuilder.labelInit(projectileLabel);
    UIBuilder.labelInit(statusLabel);
    UIBuilder.labelInit(drainLabel);
    UIBuilder.labelInit(meleeTypeLabel);
    UIBuilder.labelInit(stanceLabel);
    UIBuilder.labelInit(stanceComboLabel);
    UIBuilder.labelInit(explosiveDamageLabel);
    UIBuilder.labelInit(explosiveImpactLabel);
    UIBuilder.labelInit(explosivePunctureLabel);
    UIBuilder.labelInit(explosiveSlashLabel);
    UIBuilder.labelInit(damageType2Label);
    UIBuilder.labelInit(explosiveDamageType1Label);
    UIBuilder.labelInit(explosiveDamageType2Label);
    
    UIBuilder.textFieldInit(nameField);
    
    UIBuilder.numberFieldInit(damageField);
    UIBuilder.numberFieldInit(impactField);
    UIBuilder.numberFieldInit(punctureField);
    UIBuilder.numberFieldInit(slashField);
    UIBuilder.numberFieldInit(fireRateField);
    UIBuilder.numberFieldInit(magSizeField);
    UIBuilder.numberFieldInit(comboField);
    UIBuilder.numberFieldInit(startingComboField);
    UIBuilder.numberFieldInit(reloadField);
    UIBuilder.numberFieldInit(critField);
    UIBuilder.numberFieldInit(multiplierField);
    UIBuilder.numberFieldInit(chargeTimeField);
    UIBuilder.numberFieldInit(burstCountField);
    UIBuilder.numberFieldInit(projectileField);
    UIBuilder.numberFieldInit(statusField);
    UIBuilder.numberFieldInit(drainField);
    UIBuilder.numberFieldInit(scopeStrengthField);
    UIBuilder.numberFieldInit(explosiveDamage1Field);
    UIBuilder.numberFieldInit(explosiveImpactField);
    UIBuilder.numberFieldInit(explosivePunctureField);
    UIBuilder.numberFieldInit(explosiveSlashField);
    UIBuilder.numberFieldInit(damage2Field);
    UIBuilder.numberFieldInit(explosiveDamage2Field);
    
    UIBuilder.createSepparationBorder(namePanel);
    UIBuilder.createSepparationBorder(impactPanel);
    UIBuilder.createSepparationBorder(puncturePanel);
    UIBuilder.createSepparationBorder(slashPanel);
    UIBuilder.createSepparationBorder(fireRatePanel);
    UIBuilder.createSepparationBorder(magSizePanel);
    UIBuilder.createSepparationBorder(comboPanel);
    UIBuilder.createSepparationBorder(startingComboPanel);
    UIBuilder.createSepparationBorder(reloadPanel);
    UIBuilder.createSepparationBorder(critChancePanel);
    UIBuilder.createSepparationBorder(critMultPanel);
    UIBuilder.createSepparationBorder(weaponModePanel);
    UIBuilder.createSepparationBorder(damageTypePanel);
    UIBuilder.createSepparationBorder(chargeTimePanel);
    UIBuilder.createSepparationBorder(burstCountPanel);
    UIBuilder.createSepparationBorder(projectilePanel);
    UIBuilder.createSepparationBorder(statusPanel);
    UIBuilder.createSepparationBorder(drainPanel);
    UIBuilder.createSepparationBorder(scopePanel);
    UIBuilder.createSepparationBorder(meleeTypePanel);
    UIBuilder.createSepparationBorder(stancePanel);
    UIBuilder.createSepparationBorder(stanceComboPanel);
    UIBuilder.createSepparationBorder(explosiveImpactPanel);
    UIBuilder.createSepparationBorder(explosivePuncturePanel);
    UIBuilder.createSepparationBorder(explosiveSlashPanel);
    UIBuilder.createSepparationBorder(damageType2Panel);
    UIBuilder.createSepparationBorder(explosiveDamageType1Panel);
    UIBuilder.createSepparationBorder(explosiveDamageType2Panel);
    
    UIBuilder.panelInit(this);
    UIBuilder.panelInit(namePanel);
    UIBuilder.panelInit(impactPanel);
    UIBuilder.panelInit(puncturePanel);
    UIBuilder.panelInit(slashPanel);
    UIBuilder.panelInit(fireRatePanel);
    UIBuilder.panelInit(magSizePanel);
    UIBuilder.panelInit(comboPanel);
    UIBuilder.panelInit(startingComboPanel);
    UIBuilder.panelInit(reloadPanel);
    UIBuilder.panelInit(critChancePanel);
    UIBuilder.panelInit(critMultPanel);
    UIBuilder.panelInit(weaponModePanel);
    UIBuilder.panelInit(damageTypePanel);
    UIBuilder.panelInit(chargeTimePanel);
    UIBuilder.panelInit(burstCountPanel);
    UIBuilder.panelInit(projectilePanel);
    UIBuilder.panelInit(statusPanel);
    UIBuilder.panelInit(drainPanel);
    UIBuilder.panelInit(scopePanel);
    UIBuilder.panelInit(meleeTypePanel);
    UIBuilder.panelInit(stancePanel);
    UIBuilder.panelInit(stanceComboPanel);
    UIBuilder.panelInit(explosiveImpactPanel);
    UIBuilder.panelInit(explosivePuncturePanel);
    UIBuilder.panelInit(explosiveSlashPanel);
    UIBuilder.panelInit(damageType2Panel);
    UIBuilder.panelInit(explosiveDamageType1Panel);
    UIBuilder.panelInit(explosiveDamageType2Panel);
    UIBuilder.panelInit(ele1SubPanel);
    UIBuilder.panelInit(ele2SubPanel);
    UIBuilder.panelInit(exEle1SubPanel);
    UIBuilder.panelInit(exEle2SubPanel);
    
    nameLabel.setToolTipText(Constants.NAME_TOOL_TIP);
    impactLabel.setToolTipText(Constants.IMPACT_TOOL_TIP);
    punctureLabel.setToolTipText(Constants.PUNCTURE_TOOL_TIP);
    slashLabel.setToolTipText(Constants.SLASH_TOOL_TIP);
    fireRateLabel.setToolTipText(Constants.FIRE_RATE_TOOL_TIP);
    magSizeLabel.setToolTipText(Constants.MAG_SIZE_TOOL_TIP);
    comboLabel.setToolTipText(Constants.COMBO_TOOL_TIP);
    startingComboLabel.setToolTipText("Optional combo to start with: 1.5, 2.0, etc. Leave blank or = 0 if starting from 0 combo");
    reloadTimeLabel.setToolTipText(Constants.RELOAD_TIME_TOOL_TIP);
    critChanceLabel.setToolTipText(Constants.CRIT_CHANCE_TOOL_TIP);
    critMultiplierLabel.setToolTipText(Constants.CRIT_MULT_TOOL_TIP);
    weaponModeLabel.setToolTipText(Constants.WEAPON_MODE_TOOL_TIP);
    damageTypeLabel.setToolTipText(Constants.DAMAGE_TYPE_TOOL_TIP);
    chargeTimeLabel.setToolTipText(Constants.CHARGE_TIME_TOOL_TIP);
    burstCountLabel.setToolTipText(Constants.BURST_COUNT_TOOL_TIP);
    projectileLabel.setToolTipText(Constants.POJECTILE_TOOL_TIP);
    statusLabel.setToolTipText(Constants.STATUS_TOOL_TIP);
    drainLabel.setToolTipText("Ammo drained per tick for beam weapons. 0.5 for most");
    
    nameField.setToolTipText(Constants.NAME_TOOL_TIP);
    damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
    impactField.setToolTipText(Constants.IMPACT_TOOL_TIP);
    punctureField.setToolTipText(Constants.PUNCTURE_TOOL_TIP);
    slashField.setToolTipText(Constants.SLASH_TOOL_TIP);
    fireRateField.setToolTipText(Constants.FIRE_RATE_TOOL_TIP);
    magSizeField.setToolTipText(Constants.MAG_SIZE_TOOL_TIP);
    comboField.setToolTipText(Constants.COMBO_TOOL_TIP);
    startingComboField.setToolTipText("Optional combo to start with: 1.5, 2.0, etc. Leave blank or = 0 if starting from 0 combo");
    reloadField.setToolTipText(Constants.RELOAD_TIME_TOOL_TIP);
    critField.setToolTipText(Constants.CRIT_CHANCE_TOOL_TIP);
    multiplierField.setToolTipText(Constants.CRIT_MULT_TOOL_TIP);
    weaponModeBox.setToolTipText(Constants.WEAPON_MODE_TOOL_TIP);
    damageTypeBox.setToolTipText(Constants.DAMAGE_TYPE_TOOL_TIP);
    chargeTimeField.setToolTipText(Constants.CHARGE_TIME_TOOL_TIP);
    burstCountField.setToolTipText(Constants.BURST_COUNT_TOOL_TIP);
    projectileField.setToolTipText(Constants.POJECTILE_TOOL_TIP);
    statusField.setToolTipText(Constants.STATUS_TOOL_TIP);
    drainField.setToolTipText("Ammo drained per tick for beam weapons. 0.5 for most");
    
    explosiveDamage1Field.setToolTipText("The type of elemental damage that the explosion does");
    explosiveDamage2Field.setToolTipText("The second type of elemental damage that the explosion does");

    for(String mode : Constants.gunModes) {
    	weaponModeBox.addItem(mode);
    }
    for(String mode : Constants.meleeTypes) {
    	meleeTypeBox.addItem(mode);
    }
    
    damageTypeBox.addItem(Constants.PHYSICAL_WEAPON_DAMAGE);
    damageTypeBox.addItem(Constants.ELECTRIC_WEAPON_DAMAGE);
    damageTypeBox.addItem(Constants.FIRE_WEAPON_DAMAGE);
    damageTypeBox.addItem(Constants.ICE_WEAPON_DAMAGE);
    damageTypeBox.addItem(Constants.TOXIN_WEAPON_DAMAGE);
    damageTypeBox.addItem(Constants.BLAST_WEAPON_DAMAGE);
    damageTypeBox.addItem(Constants.CORROSIVE_WEAPON_DAMAGE);
    damageTypeBox.addItem(Constants.GAS_WEAPON_DAMAGE);
    damageTypeBox.addItem(Constants.MAGNETIC_WEAPON_DAMAGE);
    damageTypeBox.addItem(Constants.RADIATION_WEAPON_DAMAGE);
    damageTypeBox.addItem(Constants.VIRAL_WEAPON_DAMAGE);
    
    for (int i = 0; i < damageTypeBox.getItemCount(); i++){
    damageType2Box.addItem(damageTypeBox.getItemAt(i));
    explosiveDamageType2Box.addItem(damageTypeBox.getItemAt(i));
    explosiveDamageType1Box.addItem(damageTypeBox.getItemAt(i));
    }
    
    scopeBox.addItem(Constants.ADDITIVE_CRIT_CHANCE);
    scopeBox.addItem(Constants.ADDITIVE_CRIT_DAMAGE);
    scopeBox.addItem(Constants.HEADSHOT_BONUS);
    
    scopeStrengthBox.addItem("Unscoped");
    scopeStrengthBox.addItem("Level 1");
    scopeStrengthBox.addItem("Level 2");
    scopeStrengthBox.addItem("Level 3");
    
    
	ele1SubPanel.setLayout(new GridBagLayout());
	ele2SubPanel.setLayout(new GridBagLayout());
	exEle1SubPanel.setLayout(new GridBagLayout());
	exEle2SubPanel.setLayout(new GridBagLayout());
    
    this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    namePanel.setLayout(new GridLayout(1,2,0,0));
    impactPanel.setLayout(new GridLayout(1,2,0,0));
    puncturePanel.setLayout(new GridLayout(1,2,0,0));
    slashPanel.setLayout(new GridLayout(1,2,0,0));
    fireRatePanel.setLayout(new GridLayout(1,2,0,0));
    magSizePanel.setLayout(new GridLayout(1,2,0,0));
    drainPanel.setLayout(new GridLayout(1,2,0,0));
    comboPanel.setLayout(new GridLayout(1,2,0,0));
    startingComboPanel.setLayout(new GridLayout(1,2,0,0));
    reloadPanel.setLayout(new GridLayout(1,2,0,0));
    critChancePanel.setLayout(new GridLayout(1,2,0,0));
    critMultPanel.setLayout(new GridLayout(1,2,0,0));
    weaponModePanel.setLayout(new GridLayout(1,2,0,0));
    damageTypePanel.setLayout(new GridLayout(1,2,0,0));
    projectilePanel.setLayout(new GridLayout(1,2,0,0));
    statusPanel.setLayout(new GridLayout(1,2,0,0));
    chargeTimePanel.setLayout(new GridLayout(1,2,0,0));
    burstCountPanel.setLayout(new GridLayout(1,2,0,0));
    scopePanel.setLayout(new GridLayout(1,3,0,0));
    meleeTypePanel.setLayout(new GridLayout(1,2,0,0));
    stancePanel.setLayout(new GridLayout(1,2,0,0));
    stanceComboPanel.setLayout(new GridLayout(1,2,0,0));
    explosiveImpactPanel.setLayout(new GridLayout(1,2,0,0));
    explosivePuncturePanel.setLayout(new GridLayout(1,2,0,0));
    explosiveSlashPanel.setLayout(new GridLayout(1,2,0,0));
    damageType2Panel.setLayout(new GridLayout(1,2,0,0));
    explosiveDamageType1Panel.setLayout(new GridLayout(1,2,0,0));
    explosiveDamageType2Panel.setLayout(new GridLayout(1,2,0,0));
    
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.fill = GridBagConstraints.BOTH;
	gbc.weightx = 1;
	gbc.weighty = 1;
    
    namePanel.add(nameLabel);
    namePanel.add(nameField);
    impactPanel.add(impactLabel);
    impactPanel.add(impactField);
    puncturePanel.add(punctureLabel);
    puncturePanel.add(punctureField);
    slashPanel.add(slashLabel);
    slashPanel.add(slashField);
    fireRatePanel.add(fireRateLabel);
    fireRatePanel.add(fireRateField);
    magSizePanel.add(magSizeLabel);
    magSizePanel.add(magSizeField);
    drainPanel.add(drainLabel);
    drainPanel.add(drainField);
    comboPanel.add(comboLabel);
    comboPanel.add(comboField);
    startingComboPanel.add(startingComboLabel);
    startingComboPanel.add(startingComboField);
    reloadPanel.add(reloadTimeLabel);
    reloadPanel.add(reloadField);
    critChancePanel.add(critChanceLabel);
    critChancePanel.add(critField);
    critMultPanel.add(critMultiplierLabel);
    critMultPanel.add(multiplierField);
    weaponModePanel.add(weaponModeLabel);
    weaponModePanel.add(weaponModeBox);
    
    ele1SubPanel.add(damageTypeBox, gbc);
    ele1SubPanel.add(damageField, gbc);
    damageTypePanel.add(damageTypeLabel);
    damageTypePanel.add(ele1SubPanel);
    
    chargeTimePanel.add(chargeTimeLabel);
    chargeTimePanel.add(chargeTimeField);
    burstCountPanel.add(burstCountLabel);
    burstCountPanel.add(burstCountField);
    projectilePanel.add(projectileLabel);
    projectilePanel.add(projectileField);
    statusPanel.add(statusLabel);
    statusPanel.add(statusField);
    scopePanel.add(scopeBox);
    scopePanel.add(scopeStrengthBox);
    scopePanel.add(scopeStrengthField);
    meleeTypePanel.add(meleeTypeLabel);
    meleeTypePanel.add(meleeTypeBox);
    stancePanel.add(stanceLabel);
    stancePanel.add(stanceBox);
    stanceComboPanel.add(stanceComboLabel);
    stanceComboPanel.add(stanceComboBox);
    explosiveImpactPanel.add(explosiveImpactLabel);
    explosiveImpactPanel.add(explosiveImpactField);
    explosivePuncturePanel.add(explosivePunctureLabel);
    explosivePuncturePanel.add(explosivePunctureField);
    explosiveSlashPanel.add(explosiveSlashLabel);
    explosiveSlashPanel.add(explosiveSlashField);
    
    ele2SubPanel.add(damageType2Box, gbc);
    ele2SubPanel.add(damage2Field, gbc);
    damageType2Panel.add(damageType2Label);
    damageType2Panel.add(ele2SubPanel);
    
    exEle1SubPanel.add(explosiveDamageType1Box, gbc);
    exEle1SubPanel.add(explosiveDamage1Field, gbc);
    explosiveDamageType1Panel.add(explosiveDamageType1Label);
    explosiveDamageType1Panel.add(exEle1SubPanel);
    
    exEle2SubPanel.add(explosiveDamageType2Box, gbc);
    exEle2SubPanel.add(explosiveDamage2Field, gbc);
    explosiveDamageType2Panel.add(explosiveDamageType2Label);
    explosiveDamageType2Panel.add(exEle2SubPanel);
    
    this.setBorder(null);
    
    this.add(namePanel);
    this.add(meleeTypePanel);
    this.add(stancePanel);
    this.add(stanceComboPanel);
    this.add(weaponModePanel);
    this.add(damageTypePanel);
    this.add(damageType2Panel);
    this.add(impactPanel);
    this.add(puncturePanel);
    this.add(slashPanel);
    this.add(explosiveDamageType1Panel);
    this.add(explosiveDamageType2Panel);
    this.add(explosiveImpactPanel);
    this.add(explosivePuncturePanel);
    this.add(explosiveSlashPanel);
    this.add(chargeTimePanel);
    this.add(burstCountPanel);
    this.add(projectilePanel);
    this.add(statusPanel);
    this.add(fireRatePanel);
    this.add(magSizePanel);
    this.add(drainPanel);
    this.add(reloadPanel);
    this.add(critChancePanel);
    this.add(critMultPanel);
    this.add(comboPanel);
    this.add(startingComboPanel);
    this.add(scopePanel);
    
    weaponModeBox.setSelectedItem(Constants.SEMI_AUTO);
    damageTypeBox.setSelectedItem(Constants.PHYSICAL_WEAPON_DAMAGE);
  }
  
  /**
   * Clears the UI settings back to default
   */
  public void clear(){
    weaponModeBox.setSelectedItem(Constants.SEMI_AUTO);
    damageTypeBox.setSelectedItem(Constants.PHYSICAL_WEAPON_DAMAGE);
    meleeTypeBox.setSelectedItem(Constants.BLADEWHIP);
    nameField.setText("");
    chargeTimeField.setText("");
    burstCountField.setText("");
    nameField.setText("");
    damageField.setText("");
    impactField.setText("");
    punctureField.setText("");
    slashField.setText("");
    fireRateField.setText("");
    magSizeField.setText("");
    drainField.setText("");
    comboField.setText("");
    startingComboField.setText("");
    reloadField.setText("");
    critField.setText("");
    multiplierField.setText("");
    projectileField.setText("");
    statusField.setText("");
    scopeStrengthField.setText("");
    scopeStrengthBox.setSelectedIndex(0);
    explosiveImpactField.setText("");
    explosivePunctureField.setText("");
    explosiveSlashField.setText("");
    damage2Field.setText("");
    explosiveDamage2Field.setText("");
    damageType2Box.setSelectedItem(Constants.PHYSICAL_WEAPON_DAMAGE);
    explosiveDamageType1Box.setSelectedItem(Constants.PHYSICAL_WEAPON_DAMAGE);
    explosiveDamageType2Box.setSelectedItem(Constants.PHYSICAL_WEAPON_DAMAGE);
  }
  
  /**
   * Sets the UI state to allow custom weapons
   */
  /*
  public void setCustom(){
    weaponModeBox.setSelectedItem(Constants.SEMI_AUTO);
    damageTypeBox.setSelectedItem(Constants.PHYSICAL_WEAPON_DAMAGE);
    meleeTypeBox.setSelectedItem(Constants.BLADEWHIP);
    nameField.setText("");
    chargeTimeField.setText("");
    burstCountField.setText("");
    nameField.setText("");
    damageField.setText("");
    impactField.setText("");
    punctureField.setText("");
    slashField.setText("");
    fireRateField.setText("");
    magSizeField.setText("");
    drainField.setText("");
    comboField.setText("");
    startingComboField.setText("");
    reloadField.setText("");
    critField.setText("");
    multiplierField.setText("");
    projectileField.setText("");
    statusField.setText("");
    scopeStrengthField.setText("");
    scopeStrengthBox.setSelectedIndex(0);
  }
  */

}
