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
import main.Main;


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
  
  /** Temporary Scope Variables **/
  String scope1 = "0";
  String scope2 = "0";
  String scope3 = "0";
  int currentScope = 0;
  
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
    weaponTypeBox.addItem(Constants.ARCHGUN);
    
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
    
    attributesPanel.damageTypeBox.addActionListener(this);
    weaponTypeBox.addActionListener(this);
    attributesPanel.weaponModeBox.addActionListener(this);
    addUpdateButton.addActionListener(this);
    deleteButton.addActionListener(this);
    saveButton.addActionListener(this);
    attributesPanel.scopeStrengthBox.addActionListener(this);
    
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
    attributesPanel.meleeTypeBox.setSelectedItem(selectedWeapon.meleeType);
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
    attributesPanel.scopeBox.setSelectedItem(selectedWeapon.scopeBonus);
    attributesPanel.scopeStrengthBox.setSelectedIndex(0);
    attributesPanel.scopeStrengthField.setText("0");
    scope1 = selectedWeapon.scope1;
    scope2 = selectedWeapon.scope2;
    scope3 = selectedWeapon.scope3;
    
    attributesPanel.explosiveDamageField.setText(selectedWeapon.explosiveDamage);
    attributesPanel.explosiveImpactField.setText(selectedWeapon.explosiveImpact);
    attributesPanel.explosivePunctureField.setText(selectedWeapon.explosivePuncture);
    attributesPanel.explosiveSlashField.setText(selectedWeapon.explosiveSlash);
  }
  
	protected void updateWeaponModeOptions() {
		if (attributesPanel.weaponModeBox.getSelectedItem().equals(Constants.BURST)) {
			attributesPanel.chargeTimePanel.setVisible(false);
			attributesPanel.burstCountPanel.setVisible(true);
			attributesPanel.drainPanel.setVisible(false);
			attributesPanel.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			attributesPanel.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			attributesPanel.comboPanel.setVisible(false);
			attributesPanel.scopePanel.setVisible(false);
		} else if (attributesPanel.weaponModeBox.getSelectedItem().equals(Constants.CHARGE) || attributesPanel.weaponModeBox.getSelectedItem().equals(Constants.CHARGEBOW)) {
			attributesPanel.chargeTimePanel.setVisible(true);
			attributesPanel.burstCountPanel.setVisible(false);
			attributesPanel.drainPanel.setVisible(false);
			attributesPanel.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			attributesPanel.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			attributesPanel.comboPanel.setVisible(false);
			attributesPanel.scopePanel.setVisible(false);
		} else if (attributesPanel.weaponModeBox.getSelectedItem().equals(Constants.CONTINUOUS)) {
			attributesPanel.chargeTimePanel.setVisible(false);
			attributesPanel.burstCountPanel.setVisible(false);
			attributesPanel.drainPanel.setVisible(true);
			attributesPanel.damageLabel.setToolTipText(Constants.CONTINUOUS_DAMAGE_TOOL_TIP);
			attributesPanel.damageField.setToolTipText(Constants.CONTINUOUS_DAMAGE_TOOL_TIP);
			attributesPanel.comboPanel.setVisible(false);
			attributesPanel.scopePanel.setVisible(false);
		} else if (attributesPanel.weaponModeBox.getSelectedItem().equals(Constants.SNIPER)) {
			attributesPanel.chargeTimePanel.setVisible(false);
			attributesPanel.burstCountPanel.setVisible(false);
			attributesPanel.drainPanel.setVisible(false);
			attributesPanel.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			attributesPanel.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			attributesPanel.comboPanel.setVisible(true);
			attributesPanel.scopePanel.setVisible(true);
		} else if (attributesPanel.weaponModeBox.getSelectedItem().equals(Constants.LANKA)) {
			attributesPanel.chargeTimePanel.setVisible(true);
			attributesPanel.burstCountPanel.setVisible(false);
			attributesPanel.drainPanel.setVisible(false);
			attributesPanel.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			attributesPanel.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			attributesPanel.comboPanel.setVisible(true);
			attributesPanel.scopePanel.setVisible(true);
		} else {
			attributesPanel.chargeTimePanel.setVisible(false);
			attributesPanel.burstCountPanel.setVisible(false);
			attributesPanel.drainPanel.setVisible(false);
			attributesPanel.damageLabel.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			attributesPanel.damageField.setToolTipText(Constants.DAMAGE_TOOL_TIP);
			attributesPanel.comboPanel.setVisible(false);
			attributesPanel.scopePanel.setVisible(false);
		}

		if (weaponTypeBox.getSelectedItem().equals(Constants.MELEE)) {
			attributesPanel.meleeTypePanel.setVisible(true);
			attributesPanel.weaponModePanel.setVisible(false);
			attributesPanel.projectilePanel.setVisible(false);
			attributesPanel.fireRateLabel.setText("Attack Speed");
			attributesPanel.magSizePanel.setVisible(false);
			attributesPanel.reloadPanel.setVisible(false);
			attributesPanel.weaponModeBox.setSelectedIndex(6);
		} else {
			attributesPanel.fireRateLabel.setText("Fire Rate");
			attributesPanel.meleeTypePanel.setVisible(false);
			attributesPanel.stanceComboPanel.setVisible(false);
			attributesPanel.stancePanel.setVisible(false);
			attributesPanel.weaponModePanel.setVisible(true);
			attributesPanel.projectilePanel.setVisible(true);
			attributesPanel.magSizePanel.setVisible(true);
			attributesPanel.reloadPanel.setVisible(true);
		}
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
    String meleeType = (String)attributesPanel.meleeTypeBox.getSelectedItem();
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
    String scopeBonus = (String)attributesPanel.scopeBox.getSelectedItem();
    
	if(attributesPanel.scopeStrengthBox.getSelectedIndex() ==  1) {
		scope1 = attributesPanel.scopeStrengthField.getText();
	} else if (attributesPanel.scopeStrengthBox.getSelectedIndex() ==  2) {
		scope2 = attributesPanel.scopeStrengthField.getText();
	} else if (attributesPanel.scopeStrengthBox.getSelectedIndex() == 3) {
		scope3 = attributesPanel.scopeStrengthField.getText();
	}

	String explosiveDamage = attributesPanel.explosiveDamageField.getText();
	String explosiveImpact = attributesPanel.explosiveImpactField.getText();
	String explosivePuncture = attributesPanel.explosivePunctureField.getText();
	String explosiveSlash = attributesPanel.explosiveSlashField.getText();
    
    if(name.equals("")){
      name = "Unnamed Weapon";
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
    
    try{
        double testDouble = Double.parseDouble(explosiveDamage);
      }catch(Exception ex){
    	  explosiveDamage = "0";
      }
    try{
        double testDouble = Double.parseDouble(explosiveImpact);
      }catch(Exception ex){
    	  explosiveImpact = "0";
      }
    try{
        double testDouble = Double.parseDouble(explosivePuncture);
      }catch(Exception ex){
    	  explosivePuncture = "0";
      }
    try{
        double testDouble = Double.parseDouble(explosiveSlash);
      }catch(Exception ex){
    	  explosiveSlash = "0";
      }
    
    String weaponString = type;
    weaponString += ","+mode;
    weaponString += ","+damageType;
    weaponString += ","+name;
    weaponString += ","+chargeTime;
    weaponString += ","+burstCount;
    weaponString += ","+meleeType;
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
    weaponString += ","+scopeBonus;
    weaponString += ","+scope1;
    weaponString += ","+scope2;
    weaponString += ","+scope3;
    weaponString += ","+explosiveDamage;
    weaponString += ","+explosiveImpact;
    weaponString += ","+explosivePuncture;
    weaponString += ","+explosiveSlash;
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
    }else if(e.getSource().equals(attributesPanel.scopeStrengthBox)) {
    	// Remember the scope's entered strength
    	if(currentScope == 1) {
    		scope1 = attributesPanel.scopeStrengthField.getText();
    	} else if (currentScope == 2) {
    		scope2 = attributesPanel.scopeStrengthField.getText();
    	} else if (currentScope == 3) {
    		scope3 = attributesPanel.scopeStrengthField.getText();
    	}
    	// Show scope's strength
    	if(attributesPanel.scopeStrengthBox.getSelectedIndex() ==  1) {
    		attributesPanel.scopeStrengthField.setText(scope1);
    	} else if (attributesPanel.scopeStrengthBox.getSelectedIndex() ==  2) {
    		attributesPanel.scopeStrengthField.setText(scope2);
    	} else if (attributesPanel.scopeStrengthBox.getSelectedIndex() == 3) {
    		attributesPanel.scopeStrengthField.setText(scope3);
    	} else {
    		attributesPanel.scopeStrengthField.setText("0");
    	}
    	currentScope = attributesPanel.scopeStrengthBox.getSelectedIndex();
    } else if (e.getSource().equals(attributesPanel.weaponModeBox) || e.getSource().equals(weaponTypeBox)){
    	updateWeaponModeOptions();
    	Main.weaponManagerFrame.pack();
    } else if (e.getSource().equals(attributesPanel.damageTypeBox)) {
		if (attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.PHYSICAL_WEAPON_DAMAGE) || attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_PHYSICAL_WEAPON_DAMAGE)) {
			attributesPanel.damagePanel.setVisible(false);
		} else {
			attributesPanel.damagePanel.setVisible(true);
		}
	
		if( //this can't be the way i should do this
		   attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_FIRE_WEAPON_DAMAGE) ||
		   attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_ICE_WEAPON_DAMAGE) ||
		   attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_ELECTRIC_WEAPON_DAMAGE) ||
		   attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_TOXIN_WEAPON_DAMAGE) ||
		   attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_BLAST_WEAPON_DAMAGE) ||
		   attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_MAGNETIC_WEAPON_DAMAGE) ||
		   attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_GAS_WEAPON_DAMAGE) ||
		   attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_RADIATION_WEAPON_DAMAGE) ||
		   attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_CORROSIVE_WEAPON_DAMAGE) ||
		   attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_VIRAL_WEAPON_DAMAGE)) {
			
			attributesPanel.explosiveDamagePanel.setVisible(true);
		}else {
			attributesPanel.explosiveDamagePanel.setVisible(false);
		}
		
		if(attributesPanel.damageTypeBox.getSelectedItem().equals(Constants.EX_PHYSICAL_WEAPON_DAMAGE)){
			attributesPanel.explosiveImpactPanel.setVisible(true);
			attributesPanel.explosivePuncturePanel.setVisible(true);
			attributesPanel.explosiveSlashPanel.setVisible(true);
		}else {
			attributesPanel.explosiveImpactPanel.setVisible(false);
			attributesPanel.explosivePuncturePanel.setVisible(false);
			attributesPanel.explosiveSlashPanel.setVisible(false);
		}
		
    	Main.weaponManagerFrame.pack();
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
