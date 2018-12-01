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

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import etc.Constants;
import etc.UIBuilder;
import mods.Mod;
import mods.ModInitializer;
import mods.WeaponModPanel;

import main.Main;

public class WeaponPanel extends JPanel implements ActionListener {
  
  /**
   * ____________________________________________________________
   * GLOBAL VARIABLES
   * ____________________________________________________________
   */
  
  /** JPanels **/
  protected JPanel attributesPanel = new JPanel();
  protected JPanel modsPanel = new JPanel();
  protected WeaponAttributesPanel wap = new WeaponAttributesPanel();
  protected WeaponModPanel modOnePanel = new WeaponModPanel("1",this);
  protected WeaponModPanel modTwoPanel = new WeaponModPanel("2",this);
  protected WeaponModPanel modThreePanel = new WeaponModPanel("3",this);
  protected WeaponModPanel modFourPanel = new WeaponModPanel("4",this);
  protected WeaponModPanel modFivePanel = new WeaponModPanel("5",this);
  protected WeaponModPanel modSixPanel = new WeaponModPanel("6",this);
  protected WeaponModPanel modSevenPanel = new WeaponModPanel("7",this);
  protected WeaponModPanel modEightPanel = new WeaponModPanel("8",this);
  protected JPanel savedWeaponPanel = new JPanel();
  protected JPanel refireCancelPanel = new JPanel();
  protected JPanel additiveEffects = new JPanel();
  protected JPanel addCC = new JPanel();
  protected JPanel addCD = new JPanel();
  protected JPanel addSC = new JPanel();
  protected JPanel addDam = new JPanel();
  protected JPanel addFR = new JPanel();
  protected JPanel nums = new JPanel();
  
  /** JComboBoxes **/
  protected JComboBox<String> weaponBox = new JComboBox<String>();
  
  /** JCheckBoxes **/
  protected JCheckBox refireCancel = new JCheckBox();
  protected JCheckBox potato = new JCheckBox("Catalyst Installed");
  
  /** JLabels **/
  protected JLabel weaponLabel = new JLabel("Weapon - ");
  protected JLabel refireCancelLabel = new JLabel("Refire Cancel - ");
  protected JLabel totalModCostLabel = new JLabel("Mod Capacity");
  protected JLabel addCClabel = new JLabel("Additive Crit Chance - ");
  protected JLabel addCDlabel = new JLabel("Additive Crit Damage - ");
  protected JLabel addSClabel = new JLabel("Additive Status Chance - ");
  protected JLabel addDamlabel = new JLabel("Additive Damage - ");
  protected JLabel addFRlabel = new JLabel("Additive Fire Rate - ");
  
  /** JTextFields **/
  protected JTextField totalModCostField = new JTextField(10);
  protected JTextField addCCField = new JTextField(10);
  protected JTextField addCDField = new JTextField(10);
  protected JTextField addSCField = new JTextField(10);
  protected JTextField addDamField = new JTextField(10);
  protected JTextField addFRField = new JTextField(10);
  
  /** JButtons **/
  protected JButton hideAdd = new JButton("Hide/Show Additive Effects");
  
  /** Data **/
  protected Vector<String> selectedMods = new Vector<String>();
  protected Vector<Mod> activeMods = new Vector<Mod>();
  protected Vector<Double> modLevels = new Vector<Double>();
  
  protected ModInitializer modInit;
  protected WeaponInitializer weapInit;
  
  public String modOne = "--";
  public String modTwo = "--";
  public String modThree = "--";
  public String modFour = "--";
  public String modFive = "--";
  public String modSix = "--";
  public String modSeven = "--";
  public String modEight = "--";
  
  protected String weaponType = "";
  
  protected boolean updatingDropDowns = false;
  
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
    
    //Initialize The Data
    modInit = ModInitializer.getInstance();
    weapInit = WeaponInitializer.getInstance();
    updateWeaponBox();
  }
  
  public void InitMods(String file){
    modInit.initialize(file);
  }
  
  /**
   * Builds the UI
   */
  public void buildUI(){
    UIBuilder.comboBoxInit(weaponBox);
    
    UIBuilder.labelInit(totalModCostLabel);
    UIBuilder.labelInit(weaponLabel);
    UIBuilder.labelInit(refireCancelLabel);
    UIBuilder.labelInit(addCClabel);
    UIBuilder.labelInit(addCDlabel);
    UIBuilder.labelInit(addSClabel);
    UIBuilder.labelInit(addDamlabel);
    UIBuilder.labelInit(addFRlabel);
    
    UIBuilder.checkBoxInit(refireCancel);
    UIBuilder.checkBoxInit(potato);
   
    UIBuilder.textFieldInit(totalModCostField);
    
    UIBuilder.numberFieldInit(addCCField);
    UIBuilder.numberFieldInit(addCDField);
    UIBuilder.numberFieldInit(addSCField);
    UIBuilder.numberFieldInit(addDamField);
    UIBuilder.numberFieldInit(addFRField);
    
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
    UIBuilder.panelInit(refireCancelPanel);
    UIBuilder.panelInit(savedWeaponPanel);
    UIBuilder.panelInit(addCC);
    UIBuilder.panelInit(addCD);
    UIBuilder.panelInit(addSC);
    UIBuilder.panelInit(addDam);
    UIBuilder.panelInit(addFR);
    UIBuilder.panelInit(additiveEffects);
    UIBuilder.panelInit(nums);
    
    UIBuilder.createSepparationBorder(addCC);
    UIBuilder.createSepparationBorder(addCD);
    UIBuilder.createSepparationBorder(addSC);
    UIBuilder.createSepparationBorder(addDam);
    UIBuilder.createSepparationBorder(addFR);
    
    UIBuilder.createTitledLineBorder(additiveEffects, "ADDITIVE EFFECTS");
    
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
    additiveEffects.setLayout(new BoxLayout(additiveEffects,BoxLayout.Y_AXIS));
    nums.setLayout(new BoxLayout(nums,BoxLayout.Y_AXIS));
    
    savedWeaponPanel.setLayout(new GridLayout(1,2,0,0));
    refireCancelPanel.setLayout(new GridLayout(1,2,0,0));
    addCC.setLayout(new GridLayout(1,2,0,0));
    addCD.setLayout(new GridLayout(1,2,0,0));
    addSC.setLayout(new GridLayout(1,2,0,0));
    addDam.setLayout(new GridLayout(1,2,0,0)); 
    addFR.setLayout(new GridLayout(1,2,0,0)); 
    
    totalModCostField.setEditable(false);
    
    savedWeaponPanel.add(weaponLabel);
    savedWeaponPanel.add(weaponBox);
    
    refireCancelPanel.add(refireCancelLabel);
    refireCancelPanel.add(refireCancel);   
    
    attributesPanel.add(savedWeaponPanel);
    attributesPanel.add(wap);
    attributesPanel.add(refireCancelPanel);
    
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
    additiveEffects.add(addCC);
    additiveEffects.add(addCD);
    additiveEffects.add(addSC);
    additiveEffects.add(addDam);
    additiveEffects.add(addFR);
    nums.add(attributesPanel);
    nums.add(hideAdd);
    nums.add(additiveEffects);
    
    additiveEffects.setVisible(false);
    
    additiveEffects.setToolTipText("Optinal attributes that are added after normal calculation. IE: Knell, Arcanes, sniper scope buffs, etc.");
    addCCField.setToolTipText("Additive crit chance as a percent.");
    addCDField.setToolTipText("Additive crit damage as a number (IE: 1.5 for knell)");
    addSCField.setToolTipText("Additive status chance as a percent");
    addDamField.setToolTipText("Additive damage as a percent");
    addFRField.setToolTipText("Additive fire rate as a percent (Toxocyst's is multiplicative)");
    hideAdd.setToolTipText("Optinal attributes that are added after normal calculation. IE: Knell, Arcanes, sniper scope buffs, etc.");
  
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
    totalModCostPanel.add(Box.createRigidArea(new Dimension(5,0)));
    totalModCostPanel.add(potato);

    
    modsPanel.add(modsTopPanel);
    modsPanel.add(modsBottomPanel);
    modsPanel.add(totalModCostPanel);
    
    UIBuilder.panelInit(this);
    this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
    this.add(nums);
    this.add(modsPanel);
    
    wap.weaponModeBox.addActionListener(this);
    wap.damageTypeBox.addActionListener(this);
    weaponBox.addActionListener(this);
    potato.addActionListener(this);
    hideAdd.addActionListener(this);
    
    updateDropDownContents();
    
    weaponBox.setSelectedItem(Constants.CUSTOM_WEAPON);
    totalModCostField.setText("60");
    potato.setSelected(true);
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
  
  public String flatModsOutput(){
	    return  modOne+"["+modOnePanel.getModRank()+"] "+
	            modTwo+"["+modTwoPanel.getModRank()+"] "+
	            modThree+"["+modThreePanel.getModRank()+"] "+
	            modFour+"["+modFourPanel.getModRank()+"] "+ "," +
	            modFive+"["+modFivePanel.getModRank()+"] "+
	            modSix+"["+modSixPanel.getModRank()+"] "+
	            modSeven+"["+modSevenPanel.getModRank()+"] "+
	            modEight+"["+modEightPanel.getModRank()+"] ";
	  }
  
  /**
   * Counts the number of mods
   */
  public int countMods(){
	  updateDropDownContents();
	  int count = modEightPanel.modBox.getItemCount();
	  return count;
  }
  
  /**
   *  Sets Mods for the Maximizer
   */
  public void setModOne (int set){
	  modOnePanel.modBox.setSelectedIndex(set);
	  updateDropDownContents();
  }
  public void setModTwo (int set){
	  modTwoPanel.modBox.setSelectedIndex(set);
	  updateDropDownContents();
  }
  public void setModThree (int set){
	  modThreePanel.modBox.setSelectedIndex(set);
	  updateDropDownContents();
  }
  public void setModFour (int set){
	  modFourPanel.modBox.setSelectedIndex(set);
	  updateDropDownContents();
  }
  public void setModFive (int set){
	  modFivePanel.modBox.setSelectedIndex(set);
	  updateDropDownContents();
  }
  public void setModSix (int set){
	  modSixPanel.modBox.setSelectedIndex(set);
	  updateDropDownContents();
  }
  public void setModSeven (int set){
	  modSevenPanel.modBox.setSelectedIndex(set);
	  updateDropDownContents();
  }
  public void setModEight (int set){
	  modEightPanel.modBox.setSelectedIndex(set);
	  updateDropDownContents();
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
    String mode = (String)wap.weaponModeBox.getSelectedItem();
    return mode;
  }
  
  /**
   * Gets the weapon's base damage type
   * @return type
   */
  public String getDamageType(){
    String type = (String)wap.damageTypeBox.getSelectedItem();
    return type;
  }
  
  
  /**
   * Gets the weapon's charge time
   * @return chargeTime
   */
  public double getChargeTime(){
    String chargeTimeStr = wap.chargeTimeField.getText();
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
   * Gets the weapon's ammo drain
   * @return drain
   */
  public double getDrain(){
	    String drainStr = wap.drainField.getText();
	    if(drainStr == null || drainStr.equals("")){
	      drainStr = "0";
	    }
	    double drain = Double.parseDouble(drainStr);
	    if(drain < 0){
	      drain = 0;
	    }
	    return(drain);
	  }
  
  /**
   * Gets the additive crit chance
   * @return drain
   */
  public double getAddCC(){
	    String CCstr = addCCField.getText();
	    if(CCstr == null || CCstr.equals("")){
	      CCstr = "0";
	    }
	    double CC = Double.parseDouble(CCstr);
	    CC /= 100.0;
	    if(CC < 0){
	      CC = 0;
	    }
	    return(CC);
	  }
  
  /**
   * Gets the additive crit damage
   * @return drain
   */
  public double getAddCD(){
	    String CDstr = addCDField.getText();
	    if(CDstr == null || CDstr.equals("")){
	      CDstr = "0";
	    }
	    double CD = Double.parseDouble(CDstr);
	    if(CD < 0){
	      CD = 0;
	    }
	    return(CD);
	  }
  
  /**
   * Gets the additive status chance
   * @return drain
   */
  public double getAddSC(){
	    String SCstr = addSCField.getText();
	    if(SCstr == null || SCstr.equals("")){
	      SCstr = "0";
	    }
	    double SC = Double.parseDouble(SCstr);
	    SC /= 100.0;
	    if(SC < 0){
	      SC = 0;
	    }
	    return(SC);
	  }
  
  /**
   * Gets the additive damage
   * @return drain
   */
  public double getAddDam(){
	    String Damstr = addDamField.getText();
	    if(Damstr == null || Damstr.equals("")){
	    	Damstr = "0";
	    }
	    double Dam = Double.parseDouble(Damstr);
	    Dam /= 100.0;
	    if(Dam < 0){
	    	Dam = 0;
	    }
	    return(Dam);
	  }
  
  /**
   * Gets the additive fire rate
   * @return drain
   */
  public double getAddFR(){
	    String FRstr = addFRField.getText();
	    if(FRstr == null || FRstr.equals("")){
	    	FRstr = "0";
	    }
	    double FR = Double.parseDouble(FRstr);
	    FR /= 100.0;
	    if(FR < 0){
	    	FR = 0;
	    }
	    return(FR);
	  }
  
  /**
   * Gets the weapon's burst count
   * @return burstCount
   */
  public int getBurstCount(){
    String burstCountStr = wap.burstCountField.getText();
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
    String name = wap.nameField.getText();
    if(name == null || name.equals("")){
      name = "UNKNOWN";
    }
    return name;
  }
  
  /**
   * Gets the number of projectiles
   * @return projectiles
   */
  public double getProjectiles(){
    String projectileStr = wap.projectileField.getText();
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
    String statusStr = wap.statusField.getText();
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
    String damageStr = wap.damageField.getText();
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
    String damageStr = wap.impactField.getText();
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
    String damageStr = wap.punctureField.getText();
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
    String damageStr = wap.slashField.getText();
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
    String fireRateStr = wap.fireRateField.getText();
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
    String magSizeStr = wap.magSizeField.getText();
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
   * Gets the sniper minimum combo
   * @return minCombo
   */
  public int getCombo(){
    String ComboStr = wap.comboField.getText();
    if(ComboStr == null || ComboStr.equals("")){
      ComboStr = "0";
    }
    Integer Combo = Integer.parseInt(ComboStr);
    if(Combo < 1){
      Combo = 1;
    }
    return(Combo);
  }
  
  /**
   * Gets the sniper starting
   * @return startingCombo
   */
  public double getStartingCombo(){
    String StartingComboStr = wap.startingComboField.getText();
    if(StartingComboStr == null || StartingComboStr.equals("")){
      StartingComboStr = "0";
    }
    double StartingCombo = Double.parseDouble(StartingComboStr);
    if(StartingCombo < 0){
      StartingCombo = 0;
    }
    return(StartingCombo);
  }
  
  /**
   * Gets the reload timer
   * @return reloadTime
   */
  public double getReloadTime(){
    String reloadTimeStr = wap.reloadField.getText();
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
    String critChanceStr = wap.critField.getText();
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
    String critMultStr = wap.multiplierField.getText();
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
  }
  
  /**
   * Clears everything except mods
   */
  public void setCustom(){
    wap.setCustom();
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
        reader.readLine(); //DEPRECIATED
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
      writer.write(wap.weaponModeBox.getSelectedItem()+"\n");
      writer.write(wap.damageTypeBox.getSelectedItem()+"\n");
      writer.write(wap.nameField.getText()+"\n");
      writer.write(wap.chargeTimeField.getText()+"\n");
      writer.write(wap.burstCountField.getText()+"\n");
      writer.write("DEPRECIATED\n");
      writer.write(wap.nameField.getText()+"\n");
      writer.write(wap.damageField.getText()+"\n");
      writer.write(wap.impactField.getText()+"\n");
      writer.write(wap.punctureField.getText()+"\n");
      writer.write(wap.slashField.getText()+"\n");
      writer.write(wap.fireRateField.getText()+"\n");
      writer.write(wap.magSizeField.getText()+"\n");
      writer.write(wap.comboField.getText()+"\n");
      writer.write(wap.reloadField.getText()+"\n");
      writer.write(wap.critField.getText()+"\n");
      writer.write(wap.multiplierField.getText()+"\n");
      writer.write(wap.statusField.getText()+"\n");
      writer.write(wap.projectileField.getText()+"\n");
      writer.write(wap.drainField.getText()+"\n");
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
      int capacity = 60;
      if(!potato.isSelected()) capacity = 30;
      int modCapacityRemaining = capacity - totalModCost;
      totalModCostField.setText(""+modCapacityRemaining); 
      if(modCapacityRemaining < 0) {
    	    	totalModCostField.setForeground(Color.RED);
    	    }else {
    	    	totalModCostField.setForeground(Color.GREEN);
    	    }   
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
    
    modOnePanel.updateDropDowns(selectedMods, modInit.mods, weaponType);
    modTwoPanel.updateDropDowns(selectedMods, modInit.mods, weaponType);
    modThreePanel.updateDropDowns(selectedMods, modInit.mods, weaponType);
    modFourPanel.updateDropDowns(selectedMods, modInit.mods, weaponType);
    modFivePanel.updateDropDowns(selectedMods, modInit.mods, weaponType);
    modSixPanel.updateDropDowns(selectedMods, modInit.mods, weaponType);
    modSevenPanel.updateDropDowns(selectedMods, modInit.mods, weaponType);
    modEightPanel.updateDropDowns(selectedMods, modInit.mods, weaponType);
  }
  
  /**
   * Updates the UI state to reflect the currently selected weapon mode of operation
   * @param mode
   */
  protected void updateWeaponModeOptions(String mode){
    if(mode.equals(Constants.BURST)){
      wap.chargeTimePanel.setVisible(false);
      wap.burstCountPanel.setVisible(true);
      wap.drainPanel.setVisible(false);
      wap.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      refireCancelPanel.setVisible(true);
      wap.comboPanel.setVisible(false);
      wap.startingComboPanel.setVisible(false);
    }else if(mode.equals(Constants.CHARGE) || mode.equals(Constants.CHARGEBOW)){
      wap.chargeTimePanel.setVisible(true);
      wap.burstCountPanel.setVisible(false);
      wap.drainPanel.setVisible(false);
      wap.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      refireCancelPanel.setVisible(false);
      wap.comboPanel.setVisible(false);
      wap.startingComboPanel.setVisible(false);
    }else if(mode.equals(Constants.CONTINUOUS)){
      wap.chargeTimePanel.setVisible(false);
      wap.burstCountPanel.setVisible(false);
      wap.drainPanel.setVisible(true);
      wap.damageLabel.setToolTipText(Constants.CONTINUOUS_DAMAGE_TOOL_TIP);
      wap.damageField.setToolTipText(Constants.CONTINUOUS_DAMAGE_TOOL_TIP);
      refireCancelPanel.setVisible(false);
      wap.comboPanel.setVisible(false);
      wap.startingComboPanel.setVisible(false);
    }else if(mode.equals(Constants.SNIPER)){
      wap.chargeTimePanel.setVisible(false);
      wap.burstCountPanel.setVisible(false);
      wap.drainPanel.setVisible(false);
      wap.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      wap.comboPanel.setVisible(true);
      wap.startingComboPanel.setVisible(true);
      refireCancelPanel.setVisible(false);
    }else if(mode.equals(Constants.LANKA)){
      wap.chargeTimePanel.setVisible(true);
      wap.burstCountPanel.setVisible(false);
      wap.drainPanel.setVisible(false);
      wap.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      wap.comboPanel.setVisible(true);
      wap.startingComboPanel.setVisible(true);
      refireCancelPanel.setVisible(false);
    }else{
      wap.chargeTimePanel.setVisible(false);
      wap.burstCountPanel.setVisible(false);
      wap.drainPanel.setVisible(false);
      wap.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      refireCancelPanel.setVisible(false);
      wap.comboPanel.setVisible(false);
      wap.startingComboPanel.setVisible(false);
    }
  }
  
  /**
   * Updates the UI state to reflect the currently selected damage type
   * @param type
   */
  protected void updateWeaponDamageOptions(String type){
    if(type.equals(Constants.PHYSICAL_WEAPON_DAMAGE)){
      wap.damagePanel.setVisible(false);
//      wap.impactPanel.setVisible(true);
//      wap.puncturePanel.setVisible(true);
//      wap.slashPanel.setVisible(true);
    }else{
      wap.damagePanel.setVisible(true);
//      wap.impactPanel.setVisible(false);
//      wap.puncturePanel.setVisible(false);
//      wap.slashPanel.setVisible(false);
    }
  }
  
  /**
   * Gets the mod with the supplied name
   * @param name
   * @return the mod
   */
  public Mod getModByName(String name){
    Mod localMod = null;
    for(int i = 0; i < modInit.mods.size(); i++){
      if(modInit.mods.get(i).name.equals(name)){
        localMod = modInit.mods.get(i);
      }
    }
    
    return localMod;
  }
  
  /**
   * Maxes all selected mods
   */
  /*
  public void maxMods(){
    
    modOnePanel.maxMod();
    modTwoPanel.maxMod();
    modThreePanel.maxMod();
    modFourPanel.maxMod();
    modFivePanel.maxMod();
    modSixPanel.maxMod();
    modSevenPanel.maxMod();
    modEightPanel.maxMod();
  }
  */
  /**
   * Updates the mod panels
   * @param panel
   */
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
   * Updates the weapon box
   */
  public void updateWeaponBox(){
    updatingDropDowns = true;
    weaponBox.removeAllItems();
    weaponBox.addItem(Constants.CUSTOM_WEAPON);
    for(Weapon weapon : weapInit.weapons){
      if(weapon.type.equals(weaponType)){
        weaponBox.addItem(weapon.name);
      }
    }
    updatingDropDowns = false;
  }
  
  /**
   * Updates the fields with the selected weapon's stats
   * @param selected weapon
   */
  public void updateFields(String selected){
    Weapon selectedWeapon = null;
    if(selected.equals(Constants.CUSTOM_WEAPON)){
      setCustom();
    }else{
      for(Weapon weapon : weapInit.weapons){
        if(weapon.name.equals(selected)){
          selectedWeapon = weapon;
        }
      }
    }
    if(selectedWeapon != null){
      wap.weaponModeBox.setSelectedItem(selectedWeapon.mode);
      wap.damageTypeBox.setSelectedItem(selectedWeapon.damageType);
      wap.nameField.setText(selectedWeapon.name);
      wap.chargeTimeField.setText(selectedWeapon.chargeTime);
      wap.burstCountField.setText(selectedWeapon.burstCount);
      wap.damageField.setText(selectedWeapon.damage);
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
    }
  }
  
  /**
   * Action Listener Callback
   * @param e
   */
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(wap.weaponModeBox)){
      updateWeaponModeOptions((String)wap.weaponModeBox.getSelectedItem());
    }else if(e.getSource().equals(wap.damageTypeBox)){
      updateWeaponDamageOptions((String)wap.damageTypeBox.getSelectedItem());
    }else if(e.getSource().equals(weaponBox)){
      if(!updatingDropDowns){
        updateFields((String)weaponBox.getSelectedItem());
      }
    }else if(e.getSource().equals(potato)){
        calculateModCosts();
    }
    else if(e.getSource().equals(hideAdd)){
    	if(additiveEffects.isVisible()) {
      additiveEffects.setVisible(false);
      Main.repack();
    	}else {
    		 additiveEffects.setVisible(true);
    		 Main.repack();
    	}
    }
  }

  /**
   * Returns whether this weapon is refire canceled or not
   * @return canceled?
   */
  public boolean isRefireCanceled() {
    return refireCancel.isSelected();
  }
}