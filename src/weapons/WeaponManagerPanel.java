package weapons;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import etc.Constants;
import etc.UIBuilder;


public class WeaponManagerPanel extends JPanel implements ActionListener, ListSelectionListener {

  /**
   * ____________________________________________________________
   * CLASS VARIABLES
   * ____________________________________________________________
   */
  /** Panels **/
  protected JPanel leftPanel = new JPanel();
  protected JPanel rightPanel = new JPanel();
  protected JPanel buttonPanel = new JPanel();
  protected JPanel weaponTypePanel = new JPanel();
  protected WeaponAttributesPanel attributesPanel = new WeaponAttributesPanel();
  
  /** JComboBoxes **/
  protected JComboBox weaponTypeBox = new JComboBox();
  
  /** JLabels **/
  protected JLabel weaponTypeLabel = new JLabel("Type - ");
  
  /** Buttons **/
  protected JButton addUpdateButton = new JButton("Add or Update");
  protected JButton deleteButton = new JButton("Delete");
  protected JButton saveButton = new JButton("Save");
  
  /** List Variables **/
  protected DefaultListModel weaponListModel = new DefaultListModel();
  protected JList weaponList = new JList(weaponListModel);
  protected JScrollPane weaponScroll = new JScrollPane(weaponList);
  
  /** Stored Values **/
  protected Weapon selectedWeapon;
  
  /** Weapon Initializer Instance **/
  protected WeaponInitializer initializer;
  
  /** Weapon Panels **/
  protected WeaponPanel rifle;
  protected WeaponPanel shotgun;
  protected WeaponPanel pistol;
  protected WeaponPanel melee;
  protected WeaponPanel arcGun;
  
  /**
   * CTOR
   * @param arcGunPanel 
   * @param pistolPanel 
   * @param shotgunPanel 
   * @param riflePanel 
   */
  public WeaponManagerPanel(RiflePanel riflePanel, ShotgunPanel shotgunPanel, PistolPanel pistolPanel, MeleePanel meleePanel, ArcGunPanel arcGunPanel){
    this.rifle = riflePanel;
    this.shotgun = shotgunPanel;
    this.pistol = pistolPanel;
    this.melee = meleePanel;
    this.arcGun = arcGunPanel;
    init();
    buildUI();
  }
  
  /**
   * Builds the UI
   */
  public void buildUI(){
    
    UIBuilder.panelInit(this);
    UIBuilder.panelInit(leftPanel);
    UIBuilder.panelInit(rightPanel);
    UIBuilder.panelInit(buttonPanel);
    UIBuilder.panelInit(attributesPanel);
    UIBuilder.panelInit(weaponTypePanel);
    
    UIBuilder.buttonInit(addUpdateButton);
    UIBuilder.buttonInit(deleteButton);
    UIBuilder.buttonInit(saveButton);
    
    UIBuilder.listInit(weaponList);
    
    UIBuilder.labelInit(weaponTypeLabel);
    
    UIBuilder.comboBoxInit(weaponTypeBox);
    
    UIBuilder.scrollPaneInit(weaponScroll);
    
    UIBuilder.createSepparationBorder(weaponTypePanel);
    
    leftPanel.setLayout(new GridLayout(1,2,0,0));
    buttonPanel.setLayout(new GridLayout(1,3,0,0));
    rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
    weaponTypePanel.setLayout(new GridLayout(1,2,0,0));
    this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
    
    weaponList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    weaponList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
    weaponList.setVisibleRowCount(-1);
    weaponScroll.setPreferredSize(new Dimension(150, 230));
    attributesPanel.startingComboPanel.setVisible(false);
    
    leftPanel.add(weaponScroll);
    
    weaponTypeBox.addItem(Constants.RIFLE);
    weaponTypeBox.addItem(Constants.SHOTGUN);
    weaponTypeBox.addItem(Constants.PISTOL);
    weaponTypeBox.addItem(Constants.MELEE);
    weaponTypeBox.addItem(Constants.ARCGUN);
    
    weaponTypePanel.add(weaponTypeLabel);
    weaponTypePanel.add(weaponTypeBox);
    
    buttonPanel.add(addUpdateButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(saveButton);
    
    rightPanel.add(weaponTypePanel);
    rightPanel.add(attributesPanel);
    rightPanel.add(buttonPanel);
    
    this.add(leftPanel);
    this.add(rightPanel);
    
    addUpdateButton.addActionListener(this);
    deleteButton.addActionListener(this);
    saveButton.addActionListener(this);
    
    weaponList.getSelectionModel().addListSelectionListener(this);
    
    clearValues();
  }
  
  /**
   * Initializes the weapons
   */
  public void init(){
    initializer = WeaponInitializer.getInstance();
    updateWeaponsList();
  }

  /**
   * List selection callback
   */
  public void valueChanged(ListSelectionEvent e) {
    try{
      String targetName = (String)weaponListModel.get(weaponList.getSelectedIndex());
      selectedWeapon = getWeaponByName(targetName);
      updateSelectedValues();
    }catch(Exception ex){
      clearValues();
    }
  }
  
  /**
   * Resets the weapon values
   */
  public void clearValues(){
    attributesPanel.clear();
  }
  
  /**
   * Updates the values on the right side to those of the weapon selected on the left side
   */
  public void updateSelectedValues(){

    //Clear the previous values
    clearValues();
    
    //Update the boxes
    weaponTypeBox.setSelectedItem(selectedWeapon.type);
    attributesPanel.weaponModeBox.setSelectedItem(selectedWeapon.mode);
    attributesPanel.damageTypeBox.setSelectedItem(selectedWeapon.damageType);
    attributesPanel.nameField.setText(selectedWeapon.name);
    attributesPanel.chargeTimeField.setText(selectedWeapon.chargeTime);
    attributesPanel.burstCountField.setText(selectedWeapon.burstCount);
    attributesPanel.damageField.setText(selectedWeapon.damage);
    attributesPanel.impactField.setText(selectedWeapon.impact);
    attributesPanel.punctureField.setText(selectedWeapon.puncture);
    attributesPanel.slashField.setText(selectedWeapon.slash);
    attributesPanel.fireRateField.setText(selectedWeapon.fireRate);
    attributesPanel.magSizeField.setText(selectedWeapon.magSize);
    attributesPanel.drainField.setText(selectedWeapon.drain);
    attributesPanel.comboField.setText(selectedWeapon.combo);
    attributesPanel.reloadField.setText(selectedWeapon.reload);
    attributesPanel.critField.setText(selectedWeapon.crit);
    attributesPanel.multiplierField.setText(selectedWeapon.critMult);
    attributesPanel.statusField.setText(selectedWeapon.status);
    attributesPanel.projectileField.setText(selectedWeapon.projeciles);
  }
  

  /**
   * Gets the weapon with the supplied name
   * @param name
   * @return weapon
   */
  public Weapon getWeaponByName(String name){
    Weapon localWeapon = null;
    for(Weapon weapon : initializer.weapons){
      if(weapon.name.equals(name)){
        localWeapon = weapon;
      }
    }
    return localWeapon;
  }
  
  /**
   * Builds a weapon string from the currently selected weapon
   * @return weapon string
   */
  public String getCurrentWeaponString(){
    
    String type = (String)weaponTypeBox.getSelectedItem();
    String mode = (String)attributesPanel.weaponModeBox.getSelectedItem();
    String damageType = (String)attributesPanel.damageTypeBox.getSelectedItem();
    String name = attributesPanel.nameField.getText();
    String chargeTime = attributesPanel.chargeTimeField.getText();
    String burstCount = attributesPanel.burstCountField.getText();
    String burstFireRate = "DEPRECIATED";
    String damage = attributesPanel.damageField.getText();
    String impact = attributesPanel.impactField.getText();
    String puncture = attributesPanel.punctureField.getText();
    String slash = attributesPanel.slashField.getText();
    String fireRate = attributesPanel.fireRateField.getText();
    String magSize = attributesPanel.magSizeField.getText();
    String drain = attributesPanel.drainField.getText();
    String combo = attributesPanel.comboField.getText();
    String reload = attributesPanel.reloadField.getText();
    String crit = attributesPanel.critField.getText();
    String critMult = attributesPanel.multiplierField.getText();
    String status = attributesPanel.statusField.getText();
    String projeciles = attributesPanel.projectileField.getText();
    
    if(name.equals("")){
      name = "Unnamed Target";
    }
    try{
      double testDouble = Double.parseDouble(chargeTime);
    }catch(Exception ex){
      chargeTime = "0.0";
    }
    try{
      double testDouble = Double.parseDouble(damage);
    }catch(Exception ex){
      damage = "0.0";
    }
    try{
      double testDouble = Double.parseDouble(impact);
    }catch(Exception ex){
      impact = "0.0";
    }
    try{
      double testDouble = Double.parseDouble(puncture);
    }catch(Exception ex){
      puncture = "0.0";
    }
    try{
      double testDouble = Double.parseDouble(slash);
    }catch(Exception ex){
      slash = "0.0";
    }
    try{
      double testDouble = Double.parseDouble(fireRate);
    }catch(Exception ex){
      fireRate = "0.0";
    }
    try{
      double testDouble = Double.parseDouble(reload);
    }catch(Exception ex){
      reload = "0.0";
    }
    try{
      double testDouble = Double.parseDouble(crit);
    }catch(Exception ex){
      crit = "0.0";
    }
    try{
      double testDouble = Double.parseDouble(critMult);
    }catch(Exception ex){
      critMult = "0.0";
    }
    try{
      double testDouble = Double.parseDouble(status);
    }catch(Exception ex){
      status = "0.0";
    }
    
    try{
      int testInt = Integer.parseInt(burstCount);
    }catch(Exception ex){
      burstCount = "0";
    }
    try{
      int testInt = Integer.parseInt(magSize);
    }catch(Exception ex){
      magSize = "0";
    }
    try{
        double testDouble = Double.parseDouble(drain);
      }catch(Exception ex){
        drain = "0";
      }
    try{
      int testInt = Integer.parseInt(combo);
    }catch(Exception ex){
      combo = "0";
    }
    try{
      int testInt = Integer.parseInt(projeciles);
    }catch(Exception ex){
      projeciles = "0";
    }
    
    String weaponString = type;
    weaponString += ","+mode;
    weaponString += ","+damageType;
    weaponString += ","+name;
    weaponString += ","+chargeTime;
    weaponString += ","+burstCount;
    weaponString += ","+burstFireRate;
    weaponString += ","+damage;
    weaponString += ","+impact;
    weaponString += ","+puncture;
    weaponString += ","+slash;
    weaponString += ","+fireRate;
    weaponString += ","+magSize;
    weaponString += ","+combo;
    weaponString += ","+reload;
    weaponString += ","+crit;
    weaponString += ","+critMult;
    weaponString += ","+status;
    weaponString += ","+projeciles;
    weaponString += ","+drain;
    return weaponString;
  }

  /**
   * ActionListener callback
   */
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(addUpdateButton)){
      
      String newWeaponString = getCurrentWeaponString();
      Weapon newWeapon = new Weapon(newWeaponString);
      
      //Check to see if it already exists
      Weapon foundWeapon = getWeaponByName(newWeapon.name);
      
      //if it exists: up date it. Otherwise: add it.
      if(foundWeapon != null){
        initializer.weapons.set(initializer.weapons.indexOf(foundWeapon), newWeapon);
      }else{
        initializer.weapons.add(newWeapon);
      }
      
      updateWeaponsList();
      
    }else if(e.getSource().equals(deleteButton)){
      
      if(initializer.weapons.contains(selectedWeapon)){
        initializer.weapons.removeElement(selectedWeapon);
      }
      updateWeaponsList();
      
    }else if(e.getSource().equals(saveButton)){
      
      initializer.saveWeaponDB();
      rifle.updateWeaponBox();
      shotgun.updateWeaponBox();
      pistol.updateWeaponBox();
      melee.updateWeaponBox();
      arcGun.updateWeaponBox();
    }
  }
  
  /**
   * Updates the weapon list from the weapons vector
   */
  public void updateWeaponsList(){
    Collections.sort(initializer.weapons);
    weaponListModel.clear();
    for(Weapon weapon : initializer.weapons){
      weaponListModel.addElement(weapon.name);
    }
  }
}
