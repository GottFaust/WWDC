package mods;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import etc.Constants;
import etc.UIBuilder;


import weapons.WeaponPanel;

public class ModManagerPanel extends JPanel implements ActionListener, ListSelectionListener {
  
  /**
   * ____________________________________________________________
   * CLASS VARIABLES
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
  protected JPanel effectCountPanel = new JPanel();
  protected JPanel effectOnePanel = new JPanel();
  protected JPanel effectTwoPanel = new JPanel();
  protected JPanel effectOneTypePanel = new JPanel();
  protected JPanel effectOnePowerPanel = new JPanel();
  protected JPanel effectTwoTypePanel = new JPanel();
  protected JPanel effectTwoPowerPanel = new JPanel();
  protected JPanel buttonPanel = new JPanel();
  
  /** JButtons **/
  protected JButton addUpdateButton = new JButton("Add or Update");
  protected JButton deleteButton = new JButton("Delete");
  protected JButton saveButton = new JButton("Save");
  
  /** JComboBoxes **/
  protected JComboBox<String> modTypeBox = new JComboBox<String>();
  protected JComboBox<String> modPolarityBox = new JComboBox<String>();
  protected JComboBox<String> modEffectCountBox = new JComboBox<String>();
  protected JComboBox<String> modEffectOneBox = new JComboBox<String>();
  protected JComboBox<String> modEffectTwoBox = new JComboBox<String>();
  
  /** JLabels **/
  protected JLabel nameLabel = new JLabel("Name - ");
  protected JLabel typeLabel = new JLabel("Type - ");
  protected JLabel polarityLabel = new JLabel("Polarity - ");
  protected JLabel ranksLabel = new JLabel("Ranks - ");
  protected JLabel costLabel = new JLabel("Base Point cost - ");
  protected JLabel effectCountLabel = new JLabel("Effect Count - ");
  protected JLabel modEffectOneLabel = new JLabel("Effect Type - ");
  protected JLabel modPowerOneLabel = new JLabel("Base Effect Power - ");
  protected JLabel modEffectTwoLabel = new JLabel("Effect Type - ");
  protected JLabel modPowerTwoLabel = new JLabel("Base Effect Power - ");
  
  /** JTextFields **/
  protected JTextField nameField = new JTextField(10);
  protected JTextField ranksField = new JTextField(10);
  protected JTextField costField = new JTextField(10);
  protected JTextField modPowerOneField = new JTextField(10);
  protected JTextField modPowerTwoField = new JTextField(10);
  
  /** JLists **/
  protected DefaultListModel modListModel = new DefaultListModel();
  protected JList modList = new JList(modListModel);
  
  /** JScrollPanes **/
  protected JScrollPane modScroll = new JScrollPane(modList);
  
  /** Data **/
  protected Vector<Mod> mods = new Vector<Mod>();
  protected Vector<String> modEffects = new Vector<String>();
  protected File modsDB;
  protected Mod selectedMod = null;
  protected WeaponPanel rifle;
  protected WeaponPanel shotgun;
  protected WeaponPanel pistol;
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public ModManagerPanel(WeaponPanel riflePanel, WeaponPanel shotgunPanel, WeaponPanel pistolPanel){
    rifle = riflePanel;
    shotgun = shotgunPanel;
    pistol = pistolPanel;
    Init();
    buildUI();
  }
  
  /**
   * Initializes the Data
   */
  public void Init(){
    
    //Initialize The Mod Data
    modsDB = new File("mods.db");
    try {
      if(modsDB.exists()){
        mods.clear();
        BufferedReader reader = new BufferedReader(new FileReader(modsDB));
        String line = reader.readLine();
        while(line != null){
          Mod mod = new Mod(line);
          mods.add(mod);
          line = reader.readLine();
        }
        reader.close();
        updateModList();
      }else{
        mods.clear();
        modsDB.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(modsDB));
        for(int i = 0; i < Constants.baseModDB.length; i++){
          writer.write(Constants.baseModDB[i]+"\n");
          Mod mod = new Mod(Constants.baseModDB[i]);
          mods.add(mod);
        }
        writer.close();
        updateModList();
        rifle.Init();
        rifle.updateDropDownContents();
        shotgun.Init();
        shotgun.updateDropDownContents();
        pistol.Init();
        pistol.updateDropDownContents();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
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
    modEffects.add(Constants.MOD_TYPE_INFESTED_DAMAGE);
    modEffects.add(Constants.MOD_TYPE_CRIT_CHANCE);
    modEffects.add(Constants.MOD_TYPE_CRIT_MULTIPLIER);
    modEffects.add(Constants.MOD_TYPE_STATUS_CHANCE);
    modEffects.add(Constants.MOD_TYPE_STATUS_DURATION);
    modEffects.add(Constants.MOD_TYPE_FIRST_SHOT_DAMAGE);
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
    Collections.sort(modEffects);
    
    modEffectOneBox.removeAllItems();
    modEffectTwoBox.removeAllItems();
    
    for(int i = 0; i < modEffects.size(); i++){
      modEffectOneBox.addItem(modEffects.get(i));
      modEffectTwoBox.addItem(modEffects.get(i));
    }
  }
  
  protected void buildUI(){
    
    UIBuilder.panelInit(this);
    UIBuilder.panelInit(leftPanel);
    UIBuilder.panelInit(rightPanel);
    UIBuilder.panelInit(namePanel);
    UIBuilder.panelInit(typePanel);
    UIBuilder.panelInit(polarityPanel);
    UIBuilder.panelInit(costPanel);
    UIBuilder.panelInit(ranksPanel);
    UIBuilder.panelInit(effectCountPanel);
    UIBuilder.panelInit(effectOnePanel);
    UIBuilder.panelInit(effectTwoPanel);
    UIBuilder.panelInit(effectOneTypePanel);
    UIBuilder.panelInit(effectOnePowerPanel);
    UIBuilder.panelInit(effectTwoTypePanel);
    UIBuilder.panelInit(effectTwoPowerPanel);
    UIBuilder.panelInit(buttonPanel);
    
    UIBuilder.labelInit(nameLabel);
    UIBuilder.labelInit(typeLabel);
    UIBuilder.labelInit(polarityLabel);
    UIBuilder.labelInit(costLabel);
    UIBuilder.labelInit(ranksLabel);
    UIBuilder.labelInit(effectCountLabel);
    UIBuilder.labelInit(modEffectOneLabel);
    UIBuilder.labelInit(modPowerOneLabel);
    UIBuilder.labelInit(modEffectTwoLabel);
    UIBuilder.labelInit(modPowerTwoLabel);
    
    UIBuilder.listInit(modList);
    
    UIBuilder.scrollPaneInit(modScroll);
    
    UIBuilder.comboBoxInit(modTypeBox);
    UIBuilder.comboBoxInit(modPolarityBox);
    UIBuilder.comboBoxInit(modEffectCountBox);
    UIBuilder.comboBoxInit(modEffectOneBox);
    UIBuilder.comboBoxInit(modEffectTwoBox);
    
    UIBuilder.textFieldInit(nameField);
    UIBuilder.numberFieldInit(ranksField);
    UIBuilder.numberFieldInit(costField);
    UIBuilder.numberFieldInit(modPowerOneField);
    UIBuilder.numberFieldInit(modPowerTwoField);
    
    UIBuilder.buttonInit(addUpdateButton);
    UIBuilder.buttonInit(deleteButton);
    UIBuilder.buttonInit(saveButton);
    
    modTypeBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
    modPolarityBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
    modEffectCountBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
    modEffectOneBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
    modEffectTwoBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
    
    modTypeBox.addItem(Constants.PISTOL);
    modTypeBox.addItem(Constants.RIFLE);
    modTypeBox.addItem(Constants.SHOTGUN);
    
    modPolarityBox.addItem(Constants.NONE);
    modPolarityBox.addItem(Constants.DASH);
    modPolarityBox.addItem(Constants.D);
    modPolarityBox.addItem(Constants.V);
    
    modEffectCountBox.addItem(Constants.SINGLE);
    modEffectCountBox.addItem(Constants.DOUBLE);
    
    leftPanel.setLayout(new GridLayout(1,2,0,0));
    rightPanel.setLayout(new GridLayout(1,2,0,0));
    namePanel.setLayout(new GridLayout(1,2,0,0));
    typePanel.setLayout(new GridLayout(1,2,0,0));
    polarityPanel.setLayout(new GridLayout(1,2,0,0));
    costPanel.setLayout(new GridLayout(1,2,0,0));
    ranksPanel.setLayout(new GridLayout(1,2,0,0));
    effectCountPanel.setLayout(new GridLayout(1,2,0,0));
    effectOnePanel.setLayout(new BoxLayout(effectOnePanel,BoxLayout.Y_AXIS));
    effectTwoPanel.setLayout(new BoxLayout(effectTwoPanel,BoxLayout.Y_AXIS));
    effectOneTypePanel.setLayout(new GridLayout(1,2,0,0));
    effectOnePowerPanel.setLayout(new GridLayout(1,2,0,0));
    effectTwoTypePanel.setLayout(new GridLayout(1,2,0,0));
    effectTwoPowerPanel.setLayout(new GridLayout(1,2,0,0));
    buttonPanel.setLayout(new GridLayout(1,3,0,0));
    rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
    this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
    
    modList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    modList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
    modList.setVisibleRowCount(-1);
    modScroll.setPreferredSize(new Dimension(150, 230));

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
    effectCountPanel.add(effectCountLabel);
    effectCountPanel.add(modEffectCountBox);
    effectOneTypePanel.add(modEffectOneLabel);
    effectOneTypePanel.add(modEffectOneBox);
    effectOnePowerPanel.add(modPowerOneLabel);
    effectOnePowerPanel.add(modPowerOneField);
    effectTwoTypePanel.add(modEffectTwoLabel);
    effectTwoTypePanel.add(modEffectTwoBox);
    effectTwoPowerPanel.add(modPowerTwoLabel);
    effectTwoPowerPanel.add(modPowerTwoField);
    
    effectOnePanel.add(effectOneTypePanel);
    effectOnePanel.add(effectOnePowerPanel);
    effectTwoPanel.add(effectTwoTypePanel);
    effectTwoPanel.add(effectTwoPowerPanel);
    
    buttonPanel.add(addUpdateButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(saveButton);
    
    rightPanel.add(namePanel);
    rightPanel.add(typePanel);
    rightPanel.add(polarityPanel);
    rightPanel.add(costPanel);
    rightPanel.add(ranksPanel);
    rightPanel.add(effectCountPanel);
    rightPanel.add(effectOnePanel);
    rightPanel.add(effectTwoPanel);
    rightPanel.add(buttonPanel);
    
    this.add(leftPanel);
    this.add(rightPanel);
    
    addUpdateButton.addActionListener(this);
    deleteButton.addActionListener(this);
    saveButton.addActionListener(this);
    modEffectCountBox.addActionListener(this);
    
    modList.getSelectionModel().addListSelectionListener(this);
    
    //Initialize the values
    clearValues();
    
  }

  /**
   * Action Listener Callback
   */
  public void actionPerformed(ActionEvent e) {
    
    if(e.getSource().equals(addUpdateButton)){
      
      String newModString = getCurrentModString();
      Mod newMod = new Mod(newModString);
      
      //Check to see if it already exists
      Mod foundMod = getModByName(newMod.name);
      
      //if it exists: up date it. Otherwise: add it.
      if(foundMod != null){
        mods.set(mods.indexOf(foundMod), newMod);
      }else{
        mods.add(newMod);
      }
      
      updateModList();
      
    }else if(e.getSource().equals(deleteButton)){
      
      if(mods.contains(selectedMod)){
        mods.removeElement(selectedMod);
      }
      updateModList();
      
    }else if(e.getSource().equals(saveButton)){
      
      saveModDB();
      
    }else if(e.getSource().equals(modEffectCountBox)){
      if(modEffectCountBox.getSelectedItem().equals(Constants.DOUBLE)){
        effectTwoPanel.setVisible(true);
      }else{
        effectTwoPanel.setVisible(false);
      }
    }
  }

  /**
   * List Selection Listener
   */
  public void valueChanged(ListSelectionEvent e) {
    try{
      String modName = (String)modListModel.get(modList.getSelectedIndex());
      selectedMod = getModByName(modName);
      updateSelectedValues();
    }catch(Exception ex){
      clearValues();
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
  
  /**
   * Rebuilds the list of mods based on the stored mods vector
   */
  public void updateModList(){
    Collections.sort(mods);
    modListModel.clear();
    for(int i = 0; i < mods.size(); i++){
      modListModel.addElement(mods.get(i).name);
    }
  }
  
  /**
   * Clears the data values
   */
  public void clearValues(){

    modTypeBox.setSelectedItem(Constants.RIFLE);
    modPolarityBox.setSelectedItem(Constants.NONE);
    modEffectCountBox.setSelectedItem(Constants.SINGLE);
    nameField.setText("");
    ranksField.setText("0");
    costField.setText("0");
    modPowerOneField.setText("0");
    modEffectOneBox.setSelectedIndex(0);
    modPowerTwoField.setText("0");
    modEffectTwoBox.setSelectedIndex(0);
  }
  /**
   * Updates the values on the right side to those of the mod selected on the left side
   */
  public void updateSelectedValues(){

    //Clear the previous values
    clearValues();
    
    //Update the new values
    modTypeBox.setSelectedItem(selectedMod.type);
    modPolarityBox.setSelectedItem(selectedMod.polarity);
    
    if(selectedMod.effectTypes.size() > 1){
      modEffectCountBox.setSelectedItem(Constants.DOUBLE);
    }else{
      modEffectCountBox.setSelectedItem(Constants.SINGLE);
    }
    
    nameField.setText(selectedMod.name);
    ranksField.setText(""+selectedMod.ranks);
    costField.setText(""+selectedMod.baseCost);
    
    if(modEffectCountBox.getSelectedItem().equals(Constants.DOUBLE)){
      modPowerOneField.setText(""+(selectedMod.effectStrengths.get(0)*100.0));
      modEffectOneBox.setSelectedItem(selectedMod.effectTypes.get(0));
      modPowerTwoField.setText(""+(selectedMod.effectStrengths.get(1)*100.0));
      modEffectTwoBox.setSelectedItem(selectedMod.effectTypes.get(1));
    }else{
      modPowerOneField.setText(""+(selectedMod.effectStrengths.get(0)*100.0));
      modEffectOneBox.setSelectedItem(selectedMod.effectTypes.get(0));
    }
  }
  
  /**
   * Builds a mod string from the current data values
   * @return the mod string
   */
  public String getCurrentModString(){
    
    //Get Values
    String newName = nameField.getText();
    String newType = (String)modTypeBox.getSelectedItem();
    String newRanks = ranksField.getText();
    String newModEffectOne = (String)modEffectOneBox.getSelectedItem();
    String newModPowerOne = modPowerOneField.getText();
    String newModEffectTwo = (String)modEffectTwoBox.getSelectedItem();
    String newModPowerTwo = modPowerTwoField.getText();
    String newPolarity = (String)modPolarityBox.getSelectedItem();
    String newCost = costField.getText();
    
    //Check Values
    if(newName.equals("")){
      newName = "Unnamed Mod";
    }
    try{
      int newRanksInt = Integer.parseInt(newRanks);
    }catch(Exception ex){
      newRanks = "0";
    }
    try{
      double newModPowerOneDbl = Double.parseDouble(newModPowerOne);
      newModPowerOne = ""+(newModPowerOneDbl/100.0);
    }catch(Exception ex){
      newModPowerOne = "0.0";
    }
    try{
      double newModPowerTwoDbl = Double.parseDouble(newModPowerTwo);
      newModPowerTwo = ""+(newModPowerTwoDbl/100.0);
    }catch(Exception ex){
      newModPowerTwo = "0.0";
    }
    try{
      int newCostInt = Integer.parseInt(newCost);
    }catch(Exception ex){
      newCost = "0";
    }
    
    //Build the String
    String newModString = newName+","+newType+","+newRanks;
    if(modEffectCountBox.getSelectedItem().equals(Constants.DOUBLE)){
      newModString += ",2,"+newModEffectOne+","+newModEffectTwo+","+newModPowerOne+","+newModPowerTwo;
    }else{
      newModString += ",1,"+newModEffectOne+","+newModPowerOne;
    }
    newModString += ","+newPolarity+","+newCost;
    
    return newModString;
  }
  
  public void saveModDB(){
    try {
      if(modsDB.exists()){
        modsDB.delete();
      }
      modsDB.createNewFile();
      BufferedWriter writer = new BufferedWriter(new FileWriter(modsDB));
      for(int i = 0; i < mods.size(); i++){
        writer.write(mods.get(i).writeOut()+"\n");
      }
      writer.close();
      rifle.Init();
      rifle.updateDropDownContents();
      shotgun.Init();
      shotgun.updateDropDownContents();
      pistol.Init();
      pistol.updateDropDownContents();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
