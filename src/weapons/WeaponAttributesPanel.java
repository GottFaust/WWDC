package weapons;

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
  protected JPanel damagePanel = new JPanel();
  protected JPanel impactPanel = new JPanel();
  protected JPanel puncturePanel = new JPanel();
  protected JPanel slashPanel = new JPanel();
  protected JPanel fireRatePanel = new JPanel();
  protected JPanel magSizePanel = new JPanel();
  protected JPanel ammoPanel = new JPanel();
  protected JPanel reloadPanel = new JPanel();
  protected JPanel critChancePanel = new JPanel();
  protected JPanel critMultPanel = new JPanel();
  protected JPanel weaponModePanel = new JPanel();
  protected JPanel damageTypePanel = new JPanel();
  protected JPanel chargeTimePanel = new JPanel();
  protected JPanel burstCountPanel = new JPanel();
  protected JPanel burstFireRatePanel = new JPanel();
  protected JPanel projectilePanel = new JPanel();
  protected JPanel statusPanel = new JPanel();
  
  /** JComboBoxes **/
  protected JComboBox<String> damageTypeBox = new JComboBox<String>();
  protected JComboBox<String> weaponModeBox = new JComboBox<String>();
  protected JComboBox<String> weaponBox = new JComboBox<String>();
  
  /** JLabels **/
  protected JLabel nameLabel = new JLabel("Name - ");
  protected JLabel weaponModeLabel = new JLabel("Mode of Operation - ");
  protected JLabel damageTypeLabel = new JLabel("Base Damage Type - ");
  protected JLabel chargeTimeLabel = new JLabel("Charge Time - ");
  protected JLabel burstCountLabel = new JLabel("Burst Count - ");
  protected JLabel burstFireRateLabel = new JLabel("Burst Fire Rate - ");
  protected JLabel damageLabel = new JLabel("Base Damage - ");
  protected JLabel impactLabel = new JLabel("Impact Damage - ");
  protected JLabel punctureLabel = new JLabel("Puncture Damage - ");
  protected JLabel slashLabel = new JLabel("Slash Damage - ");
  protected JLabel fireRateLabel = new JLabel("Rate of Fire - ");
  protected JLabel magSizeLabel = new JLabel("Magazine Capacity - ");
  protected JLabel totalAmmoLabel = new JLabel("Total Ammo - ");
  protected JLabel reloadTimeLabel = new JLabel("Reload Time - ");
  protected JLabel critChanceLabel = new JLabel("Crit Chance - ");
  protected JLabel critMultiplierLabel = new JLabel("Crit Multiplier - ");
  protected JLabel projectileLabel = new JLabel("Projectile Count - ");
  protected JLabel statusLabel = new JLabel("Status Chance - ");
  
  /** JTextFields **/
  protected JTextField chargeTimeField = new JTextField(10);
  protected JTextField burstCountField = new JTextField(10);
  protected JTextField burstFireRateField = new JTextField(10);
  protected JTextField nameField = new JTextField(10);
  protected JTextField damageField = new JTextField(10);
  protected JTextField impactField = new JTextField(10);
  protected JTextField punctureField = new JTextField(10);
  protected JTextField slashField = new JTextField(10);
  protected JTextField fireRateField = new JTextField(10);
  protected JTextField magSizeField = new JTextField(10);
  protected JTextField ammoField = new JTextField(10);
  protected JTextField reloadField = new JTextField(10);
  protected JTextField critField = new JTextField(10);
  protected JTextField multiplierField = new JTextField(10);
  protected JTextField projectileField = new JTextField(10);
  protected JTextField statusField = new JTextField(10);
  
  
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
    
    UIBuilder.labelInit(nameLabel);
    UIBuilder.labelInit(damageLabel);
    UIBuilder.labelInit(impactLabel);
    UIBuilder.labelInit(punctureLabel);
    UIBuilder.labelInit(slashLabel);
    UIBuilder.labelInit(fireRateLabel);
    UIBuilder.labelInit(magSizeLabel);
    UIBuilder.labelInit(totalAmmoLabel);
    UIBuilder.labelInit(reloadTimeLabel);
    UIBuilder.labelInit(critChanceLabel);
    UIBuilder.labelInit(critMultiplierLabel);
    UIBuilder.labelInit(weaponModeLabel);
    UIBuilder.labelInit(damageTypeLabel);
    UIBuilder.labelInit(chargeTimeLabel);
    UIBuilder.labelInit(burstCountLabel);
    UIBuilder.labelInit(burstFireRateLabel);
    UIBuilder.labelInit(projectileLabel);
    UIBuilder.labelInit(statusLabel);
    
    UIBuilder.textFieldInit(nameField);
    
    UIBuilder.numberFieldInit(damageField);
    UIBuilder.numberFieldInit(impactField);
    UIBuilder.numberFieldInit(punctureField);
    UIBuilder.numberFieldInit(slashField);
    UIBuilder.numberFieldInit(fireRateField);
    UIBuilder.numberFieldInit(magSizeField);
    UIBuilder.numberFieldInit(ammoField);
    UIBuilder.numberFieldInit(reloadField);
    UIBuilder.numberFieldInit(critField);
    UIBuilder.numberFieldInit(multiplierField);
    UIBuilder.numberFieldInit(chargeTimeField);
    UIBuilder.numberFieldInit(burstCountField);
    UIBuilder.numberFieldInit(burstFireRateField);
    UIBuilder.numberFieldInit(projectileField);
    UIBuilder.numberFieldInit(statusField);
    
    UIBuilder.createSepparationBorder(namePanel);
    UIBuilder.createSepparationBorder(damagePanel);
    UIBuilder.createSepparationBorder(impactPanel);
    UIBuilder.createSepparationBorder(puncturePanel);
    UIBuilder.createSepparationBorder(slashPanel);
    UIBuilder.createSepparationBorder(fireRatePanel);
    UIBuilder.createSepparationBorder(magSizePanel);
    UIBuilder.createSepparationBorder(ammoPanel);
    UIBuilder.createSepparationBorder(reloadPanel);
    UIBuilder.createSepparationBorder(critChancePanel);
    UIBuilder.createSepparationBorder(critMultPanel);
    UIBuilder.createSepparationBorder(weaponModePanel);
    UIBuilder.createSepparationBorder(damageTypePanel);
    UIBuilder.createSepparationBorder(chargeTimePanel);
    UIBuilder.createSepparationBorder(burstCountPanel);
    UIBuilder.createSepparationBorder(burstFireRatePanel);
    UIBuilder.createSepparationBorder(projectilePanel);
    UIBuilder.createSepparationBorder(statusPanel);
    
    UIBuilder.panelInit(this);
    UIBuilder.panelInit(namePanel);
    UIBuilder.panelInit(damagePanel);
    UIBuilder.panelInit(impactPanel);
    UIBuilder.panelInit(puncturePanel);
    UIBuilder.panelInit(slashPanel);
    UIBuilder.panelInit(fireRatePanel);
    UIBuilder.panelInit(magSizePanel);
    UIBuilder.panelInit(ammoPanel);
    UIBuilder.panelInit(reloadPanel);
    UIBuilder.panelInit(critChancePanel);
    UIBuilder.panelInit(critMultPanel);
    UIBuilder.panelInit(weaponModePanel);
    UIBuilder.panelInit(damageTypePanel);
    UIBuilder.panelInit(chargeTimePanel);
    UIBuilder.panelInit(burstCountPanel);
    UIBuilder.panelInit(burstFireRatePanel);
    UIBuilder.panelInit(projectilePanel);
    UIBuilder.panelInit(statusPanel);
    
    nameLabel.setToolTipText(Constants.NAME_TOOL_TIP);
    damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
    impactLabel.setToolTipText(Constants.IMPACT_TOOL_TIP);
    punctureLabel.setToolTipText(Constants.PUNCTURE_TOOL_TIP);
    slashLabel.setToolTipText(Constants.SLASH_TOOL_TIP);
    fireRateLabel.setToolTipText(Constants.FIRE_RATE_TOOL_TIP);
    magSizeLabel.setToolTipText(Constants.MAG_SIZE_TOOL_TIP);
    totalAmmoLabel.setToolTipText(Constants.TOTAL_AMMO_TOOL_TIP);
    reloadTimeLabel.setToolTipText(Constants.RELOAD_TIME_TOOL_TIP);
    critChanceLabel.setToolTipText(Constants.CRIT_CHANCE_TOOL_TIP);
    critMultiplierLabel.setToolTipText(Constants.CRIT_MULT_TOOL_TIP);
    weaponModeLabel.setToolTipText(Constants.WEAPON_MODE_TOOL_TIP);
    damageTypeLabel.setToolTipText(Constants.DAMAGE_TYPE_TOOL_TIP);
    chargeTimeLabel.setToolTipText(Constants.CHARGE_TIME_TOOL_TIP);
    burstCountLabel.setToolTipText(Constants.BURST_COUNT_TOOL_TIP);
    burstFireRateLabel.setToolTipText(Constants.BURST_FIRE_RATE_TOOL_TIP);
    projectileLabel.setToolTipText(Constants.POJECTILE_TOOL_TIP);
    statusLabel.setToolTipText(Constants.STATUS_TOOL_TIP);
    
    nameField.setToolTipText(Constants.NAME_TOOL_TIP);
    damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
    impactField.setToolTipText(Constants.IMPACT_TOOL_TIP);
    punctureField.setToolTipText(Constants.PUNCTURE_TOOL_TIP);
    slashField.setToolTipText(Constants.SLASH_TOOL_TIP);
    fireRateField.setToolTipText(Constants.FIRE_RATE_TOOL_TIP);
    magSizeField.setToolTipText(Constants.MAG_SIZE_TOOL_TIP);
    ammoField.setToolTipText(Constants.TOTAL_AMMO_TOOL_TIP);
    reloadField.setToolTipText(Constants.RELOAD_TIME_TOOL_TIP);
    critField.setToolTipText(Constants.CRIT_CHANCE_TOOL_TIP);
    multiplierField.setToolTipText(Constants.CRIT_MULT_TOOL_TIP);
    weaponModeBox.setToolTipText(Constants.WEAPON_MODE_TOOL_TIP);
    damageTypeBox.setToolTipText(Constants.DAMAGE_TYPE_TOOL_TIP);
    chargeTimeField.setToolTipText(Constants.CHARGE_TIME_TOOL_TIP);
    burstCountField.setToolTipText(Constants.BURST_COUNT_TOOL_TIP);
    burstFireRateField.setToolTipText(Constants.BURST_FIRE_RATE_TOOL_TIP);
    projectileField.setToolTipText(Constants.POJECTILE_TOOL_TIP);
    statusField.setToolTipText(Constants.STATUS_TOOL_TIP);
    
    weaponModeBox.addItem(Constants.BURST);
    weaponModeBox.addItem(Constants.CHARGE);
    weaponModeBox.addItem(Constants.CONTINUOUS);
    weaponModeBox.addItem(Constants.FULL_AUTO);
    weaponModeBox.addItem(Constants.FULL_AUTO_RAMP_UP);
    weaponModeBox.addItem(Constants.FULL_AUTO_BULLET_RAMP);
    weaponModeBox.addItem(Constants.SEMI_AUTO);
    
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
    
    this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    namePanel.setLayout(new GridLayout(1,2,0,0));
    damagePanel.setLayout(new GridLayout(1,2,0,0));
    impactPanel.setLayout(new GridLayout(1,2,0,0));
    puncturePanel.setLayout(new GridLayout(1,2,0,0));
    slashPanel.setLayout(new GridLayout(1,2,0,0));
    fireRatePanel.setLayout(new GridLayout(1,2,0,0));
    magSizePanel.setLayout(new GridLayout(1,2,0,0));
    ammoPanel.setLayout(new GridLayout(1,2,0,0));
    reloadPanel.setLayout(new GridLayout(1,2,0,0));
    critChancePanel.setLayout(new GridLayout(1,2,0,0));
    critMultPanel.setLayout(new GridLayout(1,2,0,0));
    weaponModePanel.setLayout(new GridLayout(1,2,0,0));
    damageTypePanel.setLayout(new GridLayout(1,2,0,0));
    projectilePanel.setLayout(new GridLayout(1,2,0,0));
    statusPanel.setLayout(new GridLayout(1,2,0,0));
    chargeTimePanel.setLayout(new GridLayout(1,2,0,0));
    burstCountPanel.setLayout(new GridLayout(1,2,0,0));
    burstFireRatePanel.setLayout(new GridLayout(1,2,0,0));
    
    namePanel.add(nameLabel);
    namePanel.add(nameField);
    damagePanel.add(damageLabel);
    damagePanel.add(damageField);
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
    ammoPanel.add(totalAmmoLabel);
    ammoPanel.add(ammoField);
    reloadPanel.add(reloadTimeLabel);
    reloadPanel.add(reloadField);
    critChancePanel.add(critChanceLabel);
    critChancePanel.add(critField);
    critMultPanel.add(critMultiplierLabel);
    critMultPanel.add(multiplierField);
    weaponModePanel.add(weaponModeLabel);
    weaponModePanel.add(weaponModeBox);
    damageTypePanel.add(damageTypeLabel);
    damageTypePanel.add(damageTypeBox);
    chargeTimePanel.add(chargeTimeLabel);
    chargeTimePanel.add(chargeTimeField);
    burstCountPanel.add(burstCountLabel);
    burstCountPanel.add(burstCountField);
    burstFireRatePanel.add(burstFireRateLabel);
    burstFireRatePanel.add(burstFireRateField);
    projectilePanel.add(projectileLabel);
    projectilePanel.add(projectileField);
    statusPanel.add(statusLabel);
    statusPanel.add(statusField);
    
    this.setBorder(null);
    
    this.add(namePanel);
    this.add(weaponModePanel);
    this.add(damageTypePanel);
    this.add(damagePanel);
    this.add(impactPanel);
    this.add(puncturePanel);
    this.add(slashPanel);
    this.add(chargeTimePanel);
    this.add(burstCountPanel);
    this.add(burstFireRatePanel);
    this.add(projectilePanel);
    this.add(statusPanel);
    this.add(fireRatePanel);
    this.add(magSizePanel);
    this.add(ammoPanel);
    this.add(reloadPanel);
    this.add(critChancePanel);
    this.add(critMultPanel);
    
    weaponModeBox.setSelectedItem(Constants.SEMI_AUTO);
    damageTypeBox.setSelectedItem(Constants.PHYSICAL_WEAPON_DAMAGE);
  }
  
  /**
   * Clears the UI settings back to default
   */
  public void clear(){
    weaponModeBox.setSelectedItem(Constants.SEMI_AUTO);
    damageTypeBox.setSelectedItem(Constants.PHYSICAL_WEAPON_DAMAGE);
    nameField.setText("");
    chargeTimeField.setText("");
    burstCountField.setText("");
    burstFireRateField.setText("");
    nameField.setText("");
    damageField.setText("");
    impactField.setText("");
    punctureField.setText("");
    slashField.setText("");
    fireRateField.setText("");
    magSizeField.setText("");
    ammoField.setText("");
    reloadField.setText("");
    critField.setText("");
    multiplierField.setText("");
    projectileField.setText("");
    statusField.setText("");
  }
  
  /**
   * Sets the UI state to allow custom weapons
   */
  public void setCustom(){
    weaponModeBox.setSelectedItem(Constants.SEMI_AUTO);
    damageTypeBox.setSelectedItem(Constants.PHYSICAL_WEAPON_DAMAGE);
    nameField.setText("");
    chargeTimeField.setText("");
    burstCountField.setText("");
    burstFireRateField.setText("");
    nameField.setText("");
    damageField.setText("");
    impactField.setText("");
    punctureField.setText("");
    slashField.setText("");
    fireRateField.setText("");
    magSizeField.setText("");
    ammoField.setText("");
    reloadField.setText("");
    critField.setText("");
    multiplierField.setText("");
    projectileField.setText("");
    statusField.setText("");
  }

}
