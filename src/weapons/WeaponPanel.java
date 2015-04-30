package weapons;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import etc.Constants;
import etc.UIBuilder;

import mods.Mod;
import mods.WeaponModPanel;

public class WeaponPanel extends JPanel implements ActionListener {
  
  /**
   * ____________________________________________________________
   * GLOBAL VARIABLES
   * ____________________________________________________________
   */
  
  /** JPanels **/
  protected JPanel attributesPanel = new JPanel();
  protected JPanel modsPanel = new JPanel();
  protected WeaponModPanel modOnePanel = new WeaponModPanel("1",this);
  protected WeaponModPanel modTwoPanel = new WeaponModPanel("2",this);
  protected WeaponModPanel modThreePanel = new WeaponModPanel("3",this);
  protected WeaponModPanel modFourPanel = new WeaponModPanel("4",this);
  protected WeaponModPanel modFivePanel = new WeaponModPanel("5",this);
  protected WeaponModPanel modSixPanel = new WeaponModPanel("6",this);
  protected WeaponModPanel modSevenPanel = new WeaponModPanel("7",this);
  protected WeaponModPanel modEightPanel = new WeaponModPanel("8",this);
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
  protected JLabel totalModCostLabel = new JLabel("Total mod point cost associated with this build:");
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
  protected JTextField totalModCostField = new JTextField(10);
  protected JTextField projectileField = new JTextField(10);
  protected JTextField statusField = new JTextField(10);
  
  /** Data **/
  protected Vector<String> selectedMods = new Vector<String>();
  protected Vector<Mod> activeMods = new Vector<Mod>();
  protected Vector<Double> modLevels = new Vector<Double>();
  
  protected Vector<Mod> mods = new Vector<Mod>();
  
  protected String modOne = "--";
  protected String modTwo = "--";
  protected String modThree = "--";
  protected String modFour = "--";
  protected String modFive = "--";
  protected String modSix = "--";
  protected String modSeven = "--";
  protected String modEight = "--";
  
  protected String weaponType = "";
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public WeaponPanel(){
  
  }
  
  /**
   * Initializes the Data
   */
  public void Init(){
    
    //Initialize The Mod Data
    File modDB = new File("mods.db");
    try {
      if(modDB.exists()){
        mods.clear();
        BufferedReader reader = new BufferedReader(new FileReader(modDB));
        String line = reader.readLine();
        while(line != null){
          Mod mod = new Mod(line);
          if(mod.type.equals(weaponType)){
            mods.add(mod);
          }
          line = reader.readLine();
        }
        reader.close();
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
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
    UIBuilder.labelInit(totalModCostLabel);
    UIBuilder.labelInit(weaponModeLabel);
    UIBuilder.labelInit(damageTypeLabel);
    UIBuilder.labelInit(chargeTimeLabel);
    UIBuilder.labelInit(burstCountLabel);
    UIBuilder.labelInit(burstFireRateLabel);
    UIBuilder.labelInit(projectileLabel);
    UIBuilder.labelInit(statusLabel);
    
    UIBuilder.textFieldInit(nameField);
    UIBuilder.textFieldInit(totalModCostField);
    
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
    
    UIBuilder.createTitledLineBorder(attributesPanel, "ATTRIBUTES");
    UIBuilder.createTitledLineBorder(modsPanel, "MODS");
    
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
    
    attributesPanel.setLayout(new BoxLayout(attributesPanel,BoxLayout.Y_AXIS));
    modsPanel.setLayout(new BoxLayout(modsPanel,BoxLayout.Y_AXIS));
    modOnePanel.setLayout(new BoxLayout(modOnePanel,BoxLayout.Y_AXIS));
    modTwoPanel.setLayout(new BoxLayout(modTwoPanel,BoxLayout.Y_AXIS));
    modThreePanel.setLayout(new BoxLayout(modThreePanel,BoxLayout.Y_AXIS));
    modFourPanel.setLayout(new BoxLayout(modFourPanel,BoxLayout.Y_AXIS));
    modFivePanel.setLayout(new BoxLayout(modFivePanel,BoxLayout.Y_AXIS));
    modSixPanel.setLayout(new BoxLayout(modSixPanel,BoxLayout.Y_AXIS));
    modSevenPanel.setLayout(new BoxLayout(modSevenPanel,BoxLayout.Y_AXIS));
    modEightPanel.setLayout(new BoxLayout(modEightPanel,BoxLayout.Y_AXIS));
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
    
    totalModCostField.setEditable(false);
    
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
  
    attributesPanel.add(namePanel);
    attributesPanel.add(weaponModePanel);
    attributesPanel.add(damageTypePanel);
    attributesPanel.add(damagePanel);
    attributesPanel.add(impactPanel);
    attributesPanel.add(puncturePanel);
    attributesPanel.add(slashPanel);
    attributesPanel.add(chargeTimePanel);
    attributesPanel.add(burstCountPanel);
    attributesPanel.add(burstFireRatePanel);
    attributesPanel.add(projectilePanel);
    attributesPanel.add(statusPanel);
    attributesPanel.add(fireRatePanel);
    attributesPanel.add(magSizePanel);
    attributesPanel.add(ammoPanel);
    attributesPanel.add(reloadPanel);
    attributesPanel.add(critChancePanel);
    attributesPanel.add(critMultPanel);
    
    JPanel modsTopPanel = new JPanel();
    UIBuilder.panelInit(modsTopPanel);
    modsTopPanel.setLayout(new BoxLayout(modsTopPanel,BoxLayout.X_AXIS));
    
    JPanel modsBottomPanel = new JPanel();
    UIBuilder.panelInit(modsBottomPanel);
    modsBottomPanel.setLayout(new BoxLayout(modsBottomPanel,BoxLayout.X_AXIS));
    
    JPanel totalModCostPanel = new JPanel();
    UIBuilder.panelInit(totalModCostPanel);
    totalModCostPanel.setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
    
    modsTopPanel.add(modOnePanel);
    modsTopPanel.add(modTwoPanel);
    modsTopPanel.add(modThreePanel);
    modsTopPanel.add(modFourPanel);
    modsBottomPanel.add(modFivePanel);
    modsBottomPanel.add(modSixPanel);
    modsBottomPanel.add(modSevenPanel);
    modsBottomPanel.add(modEightPanel);
    
    totalModCostPanel.add(totalModCostLabel);
    totalModCostPanel.add(totalModCostField);
    
    modsPanel.add(modsTopPanel);
    modsPanel.add(modsBottomPanel);
    modsPanel.add(totalModCostPanel);
    
    UIBuilder.panelInit(this);
    this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
    this.add(attributesPanel);
    this.add(modsPanel);
    
    weaponModeBox.addActionListener(this);
    damageTypeBox.addActionListener(this);
    
    updateDropDownContents();
    
    weaponModeBox.setSelectedItem(Constants.SEMI_AUTO);
    damageTypeBox.setSelectedItem(Constants.PHYSICAL_WEAPON_DAMAGE);
    totalModCostField.setText("0");
  }
  
  /**
   * Returns the active mods in a formatted string
   */
  public String getModsOutput(){
    return  "\n"+modOne+"["+modOnePanel.getModRank()+"], "+
            modTwo+"["+modTwoPanel.getModRank()+"], "+
            modThree+"["+modThreePanel.getModRank()+"], "+
            modFour+"["+modFourPanel.getModRank()+"]\n"+
            modFive+"["+modFivePanel.getModRank()+"], "+
            modSix+"["+modSixPanel.getModRank()+"], "+
            modSeven+"["+modSevenPanel.getModRank()+"], "+
            modEight+"["+modEightPanel.getModRank()+"]";
  }
  
  /**
   * Calculates the active mods
   */
  public void parseActiveMods(){
    activeMods.clear();
    modLevels.clear();
    if(!modOne.equals("--")){
      activeMods.add(getModByName(modOne));
      modLevels.add(Double.parseDouble(modOnePanel.getModRank()));
    }
    if(!modTwo.equals("--")){
      activeMods.add(getModByName(modTwo));
      modLevels.add(Double.parseDouble(modTwoPanel.getModRank()));
    }
    if(!modThree.equals("--")){
      activeMods.add(getModByName(modThree));
      modLevels.add(Double.parseDouble(modThreePanel.getModRank()));
    }
    if(!modFour.equals("--")){
      activeMods.add(getModByName(modFour));
      modLevels.add(Double.parseDouble(modFourPanel.getModRank()));
    }
    if(!modFive.equals("--")){
      activeMods.add(getModByName(modFive));
      modLevels.add(Double.parseDouble(modFivePanel.getModRank()));
    }
    if(!modSix.equals("--")){
      activeMods.add(getModByName(modSix));
      modLevels.add(Double.parseDouble(modSixPanel.getModRank()));
    }
    if(!modSeven.equals("--")){
      activeMods.add(getModByName(modSeven));
      modLevels.add(Double.parseDouble(modSevenPanel.getModRank()));
    }
    if(!modEight.equals("--")){
      activeMods.add(getModByName(modEight));
      modLevels.add(Double.parseDouble(modEightPanel.getModRank()));
    }
  }
  
  /**
   * Gets the weapon's active mods
   * @return
   */
  public Vector<Mod> getActiveMods(){
    parseActiveMods();
    return activeMods;
  }
  
  /**
   * Gets the active mod ranks
   * @return
   */
  public Vector<Double> getActiveModRanks(){
    return modLevels;
  }
  
  /**
   * Gets the weapon's mode of operation
   * @return mode
   */
  public String getWeaponMode(){
    String mode = (String)weaponModeBox.getSelectedItem();
    return mode;
  }
  
  /**
   * Gets the weapon's base damage type
   * @return type
   */
  public String getDamageType(){
    String type = (String)damageTypeBox.getSelectedItem();
    return type;
  }
  
  
  /**
   * Gets the weapon's charge time
   * @return chargeTime
   */
  public double getChargeTime(){
    String chargeTimeStr = chargeTimeField.getText();
    if(chargeTimeStr == null || chargeTimeStr.equals("")){
      chargeTimeStr = "0";
    }
    double chargeTime = Double.parseDouble(chargeTimeStr);
    if(chargeTime < 0.0){
      chargeTime = 0.0;
    }
    return(chargeTime);
  }
  
  /**
   * Gets the weapon's burst fire rate
   * @return burstFireRate
   */
  public double getBurstFireRate(){
    String burstFireRateStr = burstFireRateField.getText();
    if(burstFireRateStr == null || burstFireRateStr.equals("")){
      burstFireRateStr = "0";
    }
    double burstFireRate = Double.parseDouble(burstFireRateStr);
    if(burstFireRate < 0.0){
      burstFireRate = 0.0;
    }
    return(burstFireRate);
  }
  
  /**
   * Gets the weapon's burst count
   * @return burstCount
   */
  public int getBurstCount(){
    String burstCountStr = burstCountField.getText();
    if(burstCountStr == null || burstCountStr.equals("")){
      burstCountStr = "0";
    }
    int burstCount = Integer.parseInt(burstCountStr);
    if(burstCount < 0){
      burstCount = 0;
    }
    return(burstCount);
  }
  
  /**
   * Gets the name
   * @return name
   */
  public String getName(){
    String name = nameField.getText();
    if(name == null || name.equals("")){
      name = "UNKNOWN";
    }
    return name;
  }
  
  /**
   * Gets the number of projectiles
   * @return projectiels
   */
  public double getProjectiles(){
    String projectileStr = projectileField.getText();
    if(projectileStr == null || projectileStr.equals("")){
      projectileStr = "0";
    }
    double projectile = Double.parseDouble(projectileStr);
    if(projectile < 0.0){
      projectile = 0.0;
    }
    return(projectile);
  }
  
  /**
   * Gets the status chance
   * @return status
   */
  public double getStatusChance(){
    String statusStr = statusField.getText();
    if(statusStr == null || statusStr.equals("")){
      statusStr = "0";
    }
    double status = Double.parseDouble(statusStr);
    status /= 100.0;
    if(status < 0.0){
      status = 0.0;
    }
    return(status);
  }
  
  /**
   * Gets the base damage
   * @return damage
   */
  public double getBaseDamage(){
    String damageStr = damageField.getText();
    if(damageStr == null || damageStr.equals("")){
      damageStr = "0";
    }
    double damage = Double.parseDouble(damageStr);
    if(damage < 0.0){
      damage = 0.0;
    }
    return(damage);
  }
  
  /**
   * Gets the impact damage
   * @return damage
   */
  public double getImpactDamage(){
    String damageStr = impactField.getText();
    if(damageStr == null || damageStr.equals("")){
      damageStr = "0";
    }
    double damage = Double.parseDouble(damageStr);
    if(damage < 0.0){
      damage = 0.0;
    }
    return(damage);
  }
  
  /**
   * Gets the puncture damage
   * @return damage
   */
  public double getPunctureDamage(){
    String damageStr = punctureField.getText();
    if(damageStr == null || damageStr.equals("")){
      damageStr = "0";
    }
    double damage = Double.parseDouble(damageStr);
    if(damage < 0.0){
      damage = 0.0;
    }
    return(damage);
  }
  /**
   * Gets the slash damage
   * @return damage
   */
  public double getSlashDamage(){
    String damageStr = slashField.getText();
    if(damageStr == null || damageStr.equals("")){
      damageStr = "0";
    }
    double damage = Double.parseDouble(damageStr);
    if(damage < 0.0){
      damage = 0.0;
    }
    return(damage);
  }
  
  /**
   * Gets the fire rate
   * @return fireRate
   */
  public double getFireRate(){
    String fireRateStr = fireRateField.getText();
    if(fireRateStr == null || fireRateStr.equals("")){
      fireRateStr = "0";
    }
    double fireRate = Double.parseDouble(fireRateStr);
    if(fireRate < 0.0){
      fireRate = 0.0;
    }
    return(fireRate);
  }
  
  /**
   * Gets the mag size
   * @return magSize
   */
  public int getMagSize(){
    String magSizeStr = magSizeField.getText();
    if(magSizeStr == null || magSizeStr.equals("")){
      magSizeStr = "0";
    }
    int magSize = Integer.parseInt(magSizeStr);
    if(magSize < 0){
      magSize = 0;
    }
    return(magSize);
  }
  
  /**
   * Gets the total ammo
   * @return totalAmmo
   */
  public int getTotalAmmo(){
    String totalAmmoStr = ammoField.getText();
    if(totalAmmoStr == null || totalAmmoStr.equals("")){
      totalAmmoStr = "0";
    }
    Integer totalAmmo = Integer.parseInt(totalAmmoStr);
    if(totalAmmo < 0){
      totalAmmo = 0;
    }
    return(totalAmmo);
  }
  
  /**
   * Gets the reload timer
   * @return reloadTime
   */
  public double getReloadTime(){
    String reloadTimeStr = reloadField.getText();
    if(reloadTimeStr == null || reloadTimeStr.equals("")){
      reloadTimeStr = "0";
    }
    Double reloadTime = Double.parseDouble(reloadTimeStr);
    if(reloadTime < 0.0){
      reloadTime = 0.0;
    }
    return(reloadTime);
  }
  
  /**
   * Gets the crit chance
   * @return critChance
   */
  public double getCritChance(){
    String critChanceStr = critField.getText();
    if(critChanceStr == null || critChanceStr.equals("")){
      critChanceStr = "0";
    }
    Double critChance = Double.parseDouble(critChanceStr);
    critChance /= 100.0;
    if(critChance < 0.0){
      critChance = 0.0;
    }
    return(critChance);
  }
  
  /**
   * Gets the crit multiplier
   * @return critMult
   */
  public double getCritMultiplier(){
    String critMultStr = multiplierField.getText();
    if(critMultStr == null || critMultStr.equals("")){
      critMultStr = "0";
    }
    Double critMult = Double.parseDouble(critMultStr);
    //critMult /= 100.0;
    if(critMult < 0.0){
      critMult = 0.0;
    }
    return(critMult);
  }
  
  /**
   * Clears all selections and text
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
    modOnePanel.clear();
    modTwoPanel.clear();
    modThreePanel.clear();
    modFourPanel.clear();
    modFivePanel.clear();
    modSixPanel.clear();
    modSevenPanel.clear();
    modEightPanel.clear();
  }
  
  /**
   * Loads saved weapon data from the provided file
   * @param file
   */
  public void loadFromFile(File file){
    try {
      if(file.exists()){
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String header = reader.readLine();
        modOnePanel.readIn(reader.readLine());
        modTwoPanel.readIn(reader.readLine());
        modThreePanel.readIn(reader.readLine());
        modFourPanel.readIn(reader.readLine());
        modFivePanel.readIn(reader.readLine());
        modSixPanel.readIn(reader.readLine());
        modSevenPanel.readIn(reader.readLine());
        modEightPanel.readIn(reader.readLine());
        weaponModeBox.setSelectedItem(reader.readLine());
        damageTypeBox.setSelectedItem(reader.readLine());
        nameField.setText(reader.readLine());
        chargeTimeField.setText(reader.readLine());
        burstCountField.setText(reader.readLine());
        burstFireRateField.setText(reader.readLine());
        nameField.setText(reader.readLine());
        damageField.setText(reader.readLine());
        impactField.setText(reader.readLine());
        punctureField.setText(reader.readLine());
        slashField.setText(reader.readLine());
        fireRateField.setText(reader.readLine());
        magSizeField.setText(reader.readLine());
        ammoField.setText(reader.readLine());
        reloadField.setText(reader.readLine());
        critField.setText(reader.readLine());
        multiplierField.setText(reader.readLine());
        statusField.setText(reader.readLine());
        projectileField.setText(reader.readLine());
        reader.close();
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  /**
   * Saves weapon data to the provided file
   * @param file
   */
  public void saveToFile(File file){
    try {
      if(file.exists()){
        file.delete();
      }
      file.createNewFile();
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      writer.write(weaponType+"\n");
      writer.write(modOnePanel.writeOut()+"\n");
      writer.write(modTwoPanel.writeOut()+"\n");
      writer.write(modThreePanel.writeOut()+"\n");
      writer.write(modFourPanel.writeOut()+"\n");
      writer.write(modFivePanel.writeOut()+"\n");
      writer.write(modSixPanel.writeOut()+"\n");
      writer.write(modSevenPanel.writeOut()+"\n");
      writer.write(modEightPanel.writeOut()+"\n");
      writer.write(weaponModeBox.getSelectedItem()+"\n");
      writer.write(damageTypeBox.getSelectedItem()+"\n");
      writer.write(nameField.getText()+"\n");
      writer.write(chargeTimeField.getText()+"\n");
      writer.write(burstCountField.getText()+"\n");
      writer.write(burstFireRateField.getText()+"\n");
      writer.write(nameField.getText()+"\n");
      writer.write(damageField.getText()+"\n");
      writer.write(impactField.getText()+"\n");
      writer.write(punctureField.getText()+"\n");
      writer.write(slashField.getText()+"\n");
      writer.write(fireRateField.getText()+"\n");
      writer.write(magSizeField.getText()+"\n");
      writer.write(ammoField.getText()+"\n");
      writer.write(reloadField.getText()+"\n");
      writer.write(critField.getText()+"\n");
      writer.write(multiplierField.getText()+"\n");
      writer.write(statusField.getText()+"\n");
      writer.write(projectileField.getText()+"\n");
      writer.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  /**
   * updates the mod costs
   */
  public void calculateModCosts(){
    try{
      int totalModCost = 0;
      totalModCost += modOnePanel.getModCost();
      totalModCost += modTwoPanel.getModCost();
      totalModCost += modThreePanel.getModCost();
      totalModCost += modFourPanel.getModCost();
      totalModCost += modFivePanel.getModCost();
      totalModCost += modSixPanel.getModCost();
      totalModCost += modSevenPanel.getModCost();
      totalModCost += modEightPanel.getModCost();
      totalModCostField.setText(""+totalModCost);
    }catch(Exception ex){
      totalModCostField.setText("0");
    }
  }
  
  /**
   * Updates the Mod Drop Down Options
   */
  public void updateDropDownContents(){
    
    selectedMods.clear();
    selectedMods.add(modOne);
    selectedMods.add(modTwo);
    selectedMods.add(modThree);
    selectedMods.add(modFour);
    selectedMods.add(modFive);
    selectedMods.add(modSix);
    selectedMods.add(modSeven);
    selectedMods.add(modEight);
    
    modOnePanel.updateDropDowns(selectedMods, mods);
    modTwoPanel.updateDropDowns(selectedMods, mods);
    modThreePanel.updateDropDowns(selectedMods, mods);
    modFourPanel.updateDropDowns(selectedMods, mods);
    modFivePanel.updateDropDowns(selectedMods, mods);
    modSixPanel.updateDropDowns(selectedMods, mods);
    modSevenPanel.updateDropDowns(selectedMods, mods);
    modEightPanel.updateDropDowns(selectedMods, mods);
  }
  
  /**
   * Updates the UI state to reflect the currently selected weapon mode of operation
   * @param mode
   */
  protected void updateWeaponModeOptions(String mode){
    if(mode.equals(Constants.BURST)){
      chargeTimePanel.setVisible(false);
      burstCountPanel.setVisible(true);
      burstFireRatePanel.setVisible(true);
      damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
    }else if(mode.equals(Constants.CHARGE)){
      chargeTimePanel.setVisible(true);
      burstCountPanel.setVisible(false);
      burstFireRatePanel.setVisible(false);
      damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
    }else if(mode.equals(Constants.CONTINUOUS)){
      chargeTimePanel.setVisible(false);
      burstCountPanel.setVisible(false);
      burstFireRatePanel.setVisible(false);
      damageLabel.setToolTipText(Constants.CONTINUOUS_DAMAGE_TOOL_TIP);
      damageField.setToolTipText(Constants.CONTINUOUS_DAMAGE_TOOL_TIP);
    }else{
      chargeTimePanel.setVisible(false);
      burstCountPanel.setVisible(false);
      burstFireRatePanel.setVisible(false);
      damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
    }
  }
  
  /**
   * Updates the UI state to reflect the currently selected damage type
   * @param type
   */
  protected void updateWeaponDamageOptions(String type){
    if(type.equals(Constants.PHYSICAL_WEAPON_DAMAGE)){
      damagePanel.setVisible(false);
      impactPanel.setVisible(true);
      puncturePanel.setVisible(true);
      slashPanel.setVisible(true);
    }else{
      damagePanel.setVisible(true);
      impactPanel.setVisible(false);
      puncturePanel.setVisible(false);
      slashPanel.setVisible(false);
    }
  }
  
  /**
   * Gets the mod with the supplied name
   * @param name
   * @return the mod
   */
  public Mod getModByName(String name){
    Mod localMod = null;
    for(int i = 0; i < mods.size(); i++){
      if(mods.get(i).name.equals(name)){
        localMod = mods.get(i);
      }
    }
    
    return localMod;
  }
  
  public void updateModPanel(WeaponModPanel panel){
    Mod selectedMod = null;
    if(panel.equals(modOnePanel)){
      modOne = modOnePanel.getSelectedMod();
      selectedMod = getModByName(modOne);
      modOnePanel.setSelectedMod(selectedMod);
    }else if(panel.equals(modTwoPanel)){
      modTwo = modTwoPanel.getSelectedMod();
      selectedMod = getModByName(modTwo);
      modTwoPanel.setSelectedMod(selectedMod);
    }else if(panel.equals(modThreePanel)){
      modThree = modThreePanel.getSelectedMod();
      selectedMod = getModByName(modThree);
      modThreePanel.setSelectedMod(selectedMod);
    }else if(panel.equals(modFourPanel)){
      modFour = modFourPanel.getSelectedMod();
      selectedMod = getModByName(modFour);
      modFourPanel.setSelectedMod(selectedMod);
    }else if(panel.equals(modFivePanel)){
      modFive = modFivePanel.getSelectedMod();
      selectedMod = getModByName(modFive);
      modFivePanel.setSelectedMod(selectedMod);
    }else if(panel.equals(modSixPanel)){
      modSix = modSixPanel.getSelectedMod();
      selectedMod = getModByName(modSix);
      modSixPanel.setSelectedMod(selectedMod);
    }else if(panel.equals(modSevenPanel)){
      modSeven = modSevenPanel.getSelectedMod();
      selectedMod = getModByName(modSeven);
      modSevenPanel.setSelectedMod(selectedMod);
    }else if(panel.equals(modEightPanel)){
      modEight = modEightPanel.getSelectedMod();
      selectedMod = getModByName(modEight);
      modEightPanel.setSelectedMod(selectedMod);
    }
    updateDropDownContents(); 
    calculateModCosts();
  }
  
  /**
   * Action Listener Callback
   * @param e
   */
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(weaponModeBox)){
      updateWeaponModeOptions((String)weaponModeBox.getSelectedItem());
    }else if(e.getSource().equals(damageTypeBox)){
      updateWeaponDamageOptions((String)damageTypeBox.getSelectedItem());
    }
  }
}