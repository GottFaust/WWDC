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
  protected JPanel headShotsPanel = new JPanel();
  
  /** JComboBoxes **/
  protected JComboBox<String> weaponBox = new JComboBox<String>();
  
  /** JCheckBoxes **/
  protected JCheckBox refireCancel = new JCheckBox();
  protected JCheckBox headShots = new JCheckBox();
  
  /** JLabels **/
  protected JLabel weaponLabel = new JLabel("Weapon - ");
  protected JLabel refireCancelLabel = new JLabel("Refire Cancel - ");
  protected JLabel headShotsLabel = new JLabel("Headshot TTK - ");
  protected JLabel totalModCostLabel = new JLabel("Total mod cost:");
  
  /** JTextFields **/
  protected JTextField totalModCostField = new JTextField(10);
  
  /** JButtons **/
  protected JButton maxModsButton = new JButton("Max Mods");
  
  /** Data **/
  protected Vector<String> selectedMods = new Vector<String>();
  protected Vector<Mod> activeMods = new Vector<Mod>();
  protected Vector<Double> modLevels = new Vector<Double>();
  
  protected ModInitializer modInit;
  protected WeaponInitializer weapInit;
  
  protected String modOne = "--";
  protected String modTwo = "--";
  protected String modThree = "--";
  protected String modFour = "--";
  protected String modFive = "--";
  protected String modSix = "--";
  protected String modSeven = "--";
  protected String modEight = "--";
  
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
  
  public void InitMods(){
    modInit.initialize();
  }
  
  /**
   * Builds the UI
   */
  public void buildUI(){
    UIBuilder.comboBoxInit(weaponBox);
    
    UIBuilder.labelInit(totalModCostLabel);
    UIBuilder.labelInit(weaponLabel);
    UIBuilder.labelInit(refireCancelLabel);
    UIBuilder.labelInit(headShotsLabel);
    
    UIBuilder.checkBoxInit(refireCancel);
    UIBuilder.checkBoxInit(headShots);
   
    UIBuilder.textFieldInit(totalModCostField);
    
    UIBuilder.buttonInit(maxModsButton);
    
    UIBuilder.createTitledLineBorder(attributesPanel, "ATTRIBUTES");
    UIBuilder.createTitledLineBorder(modsPanel, "MODS");
    
    UIBuilder.createSepparationBorder(savedWeaponPanel);
    UIBuilder.createSepparationBorder(refireCancelPanel);
    UIBuilder.createSepparationBorder(headShotsPanel);
    
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
    UIBuilder.panelInit(headShotsPanel);
    UIBuilder.panelInit(savedWeaponPanel);
    
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
    
    savedWeaponPanel.setLayout(new GridLayout(1,2,0,0));
    refireCancelPanel.setLayout(new GridLayout(1,2,0,0));
    headShotsPanel.setLayout(new GridLayout(1,2,0,0));
    
    totalModCostField.setEditable(false);
    
    savedWeaponPanel.add(weaponLabel);
    savedWeaponPanel.add(weaponBox);
    
    refireCancelPanel.add(refireCancelLabel);
    refireCancelPanel.add(refireCancel);
    
    headShotsPanel.add(headShotsLabel);
    headShotsPanel.add(headShots);
    
    attributesPanel.add(savedWeaponPanel);
    attributesPanel.add(wap);
    attributesPanel.add(refireCancelPanel);
    attributesPanel.add(headShotsPanel);
    
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
    totalModCostPanel.add(maxModsButton);
    
    modsPanel.add(modsTopPanel);
    modsPanel.add(modsBottomPanel);
    modsPanel.add(totalModCostPanel);
    
    UIBuilder.panelInit(this);
    this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
    this.add(attributesPanel);
    this.add(modsPanel);
    
    wap.weaponModeBox.addActionListener(this);
    wap.damageTypeBox.addActionListener(this);
    weaponBox.addActionListener(this);
    maxModsButton.addActionListener(this);
    
    updateDropDownContents();
    
    weaponBox.setSelectedItem(Constants.CUSTOM_WEAPON);
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
   * @return projectiels
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
   * Gets the total ammo
   * @return totalAmmo
   */
  public int getTotalAmmo(){
    String totalAmmoStr = wap.ammoField.getText();
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
        wap.ammoField.setText(reader.readLine());
        wap.reloadField.setText(reader.readLine());
        wap.critField.setText(reader.readLine());
        wap.multiplierField.setText(reader.readLine());
        wap.statusField.setText(reader.readLine());
        wap.projectileField.setText(reader.readLine());
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
      writer.write(wap.ammoField.getText()+"\n");
      writer.write(wap.reloadField.getText()+"\n");
      writer.write(wap.critField.getText()+"\n");
      writer.write(wap.multiplierField.getText()+"\n");
      writer.write(wap.statusField.getText()+"\n");
      writer.write(wap.projectileField.getText()+"\n");
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
      wap.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      refireCancelPanel.setVisible(true);
    }else if(mode.equals(Constants.CHARGE)){
      wap.chargeTimePanel.setVisible(true);
      wap.burstCountPanel.setVisible(false);
      wap.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      refireCancelPanel.setVisible(false);
    }else if(mode.equals(Constants.CONTINUOUS)){
      wap.chargeTimePanel.setVisible(false);
      wap.burstCountPanel.setVisible(false);
      wap.damageLabel.setToolTipText(Constants.CONTINUOUS_DAMAGE_TOOL_TIP);
      wap.damageField.setToolTipText(Constants.CONTINUOUS_DAMAGE_TOOL_TIP);
      refireCancelPanel.setVisible(false);
    }else{
      wap.chargeTimePanel.setVisible(false);
      wap.burstCountPanel.setVisible(false);
      wap.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      wap.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
      refireCancelPanel.setVisible(false);
    }
  }
  
  /**
   * Updates the UI state to reflect the currently selected damage type
   * @param type
   */
  protected void updateWeaponDamageOptions(String type){
    if(type.equals(Constants.PHYSICAL_WEAPON_DAMAGE)){
      wap.damagePanel.setVisible(false);
      wap.impactPanel.setVisible(true);
      wap.puncturePanel.setVisible(true);
      wap.slashPanel.setVisible(true);
    }else{
      wap.damagePanel.setVisible(true);
      wap.impactPanel.setVisible(false);
      wap.puncturePanel.setVisible(false);
      wap.slashPanel.setVisible(false);
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
      wap.ammoField.setText(selectedWeapon.ammo);
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
    }else if(e.getSource().equals(maxModsButton)){
      maxMods();
    }
  }

  /**
   * Returns whether this weapon is refire canceled or not
   * @return canceled?
   */
  public boolean isRefireCanceled() {
    return refireCancel.isSelected();
  }
  
  public boolean isHeadShots() {
	    return headShots.isSelected();
	  }
}