package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import etc.Constants;
import etc.DPSGraphPanel;
import etc.TTKGraphPanel;
import etc.TTKNamePair;
import damage.Damage;
import damage.SurfaceDamage;
import etc.UIBuilder;
import mods.Mod;
import mods.ModManagerPanel;
import ttk.TTKManagerPanel;
import ttk.TTKTarget;
import weapons.ArcGunPanel;
import weapons.PistolPanel;
import weapons.RiflePanel;
import weapons.ShotgunPanel;
import weapons.WeaponManagerPanel;
import weapons.WeaponPanel;
import options.ColorOptionsPanel;

public class Main {
  
  /**
   * ____________________________________________________________
   * GLOBAL VARIABLES
   * ____________________________________________________________
   */
  
  /** JFrames **/
  protected static JFrame mainFrame = new JFrame();
  protected static JFrame modManagerFrame = new JFrame();
  protected static JFrame targetManagerFrame = new JFrame();
  protected static JFrame weaponManagerFrame = new JFrame();
  protected static JFrame colorOptionsFrame = new JFrame();
  
  /** JButtons **/
  protected static JButton calculateButton = new JButton("Calculate");
  protected static JButton clearButton = new JButton("Clear");
  protected static JButton clearOutputButton = new JButton("Clear Output");
  
  /** JTextAreas **/
  public static JTextArea output = new JTextArea();
  
  /** JTabbedPanes **/
  protected static JTabbedPane weaponPane = new JTabbedPane();
  protected static JTabbedPane graphPane = new JTabbedPane();
  
  /** JScrollPanes **/
  protected static JScrollPane outputScroll = new JScrollPane(output);
  
  /** JPanels **/
  protected static JPanel mainPanel = new JPanel();
  protected static JPanel topPanel = new JPanel();
  protected static JPanel bottomPanel = new JPanel();
  protected static RiflePanel riflePanel;
  protected static ShotgunPanel shotgunPanel;
  protected static PistolPanel pistolPanel;
  protected static ArcGunPanel arcGunPanel;
  protected static ModManagerPanel theModManager = null;
  protected static TTKManagerPanel theTTKManager = null;
  protected static WeaponManagerPanel theWeaponManager = null;
  protected static ColorOptionsPanel theColorPanel = null;
  protected static DPSGraphPanel dpsGraph = new DPSGraphPanel();
  protected static TTKGraphPanel ttkGraph = new TTKGraphPanel();
  
  /** JMenuBar **/
  protected static JMenuBar mainMenuBar = new JMenuBar();
  
  /** JMenuItems **/
  protected static JMenu fileMenu = new JMenu("File");
  protected static JMenuItem modMenu = new JMenuItem("Mod Manager");
  protected static JMenuItem TTKMenu = new JMenuItem("Target Manager");
  protected static JMenuItem weaponMenu = new JMenuItem("Weapon Manager");
  protected static JMenuItem saveItem = new JMenuItem("Save");
  protected static JMenuItem loadItem = new JMenuItem("Load");
  protected static JMenuItem colorOptionsItem = new JMenuItem("Color Options");
  
  /** JFileChoosers **/
  protected static JFileChooser chooser = new JFileChooser();
  
  /** Misc UI Components **/
  protected static MainActionListener action = new MainActionListener();
  protected static MainWindowListener window = new MainWindowListener();
  protected static Boolean modManagerInit = false;
  protected static Boolean targetManagerInit = false;
  protected static Boolean weaponManagerInit = false;
  protected static Boolean colorOptionsInit = false;
  protected static JCheckBox TTKBox = new JCheckBox("TTK");
  protected static JCheckBox lightWeightTTKBox = new JCheckBox("Lightweight TTK");
  protected static JLabel targetGroupLabel = new JLabel("Group:");
  protected static JComboBox targetGroupBox = new JComboBox();
  protected static JLabel corrosiveProjectionLabel = new JLabel("CP Count:");
  protected static JComboBox corrosiveProjectionBox = new JComboBox();
  
  /** Data **/
  
  /** Selected WeaponPanel **/
  protected static WeaponPanel selectedWeapon = null;
  
  /** Mod Vectors **/
  protected static Vector<Mod> activeMods = new Vector<Mod>();
  protected static Vector<Double> modRanks = new Vector<Double>();
  
  /** Base Values **/
  protected static boolean useComplexTTK = true;
  public static int complexTTKIterations = 10000;
  public static int complexTTKCompletions = 0;
  public static String longestTTKName = "";
  protected static int maxTTKTime = 300000;
  
  protected static double CONTINUOUS_MULT = 4.0;
  
  protected static String weaponName = "";
  public static String weaponMode = "";
  protected static String damageType = "";
  protected static double chargeTime = 0.0;
  protected static double fireRate = 0.0;
  protected static double reloadTime = 0.0;
  protected static double critChance = 0.0;
  protected static double critMult = 0.0;
  protected static double projectileCount = 0.0;
  protected static double firstShotDamageMult = 1.0;
  protected static double statusChance = 0.0;
  protected static double statusDuration = 1.0;
  protected static double damageMult = 1.0;
  protected static double deadAimMult = 1.0;
  protected static double flatDamageBonus = 0.0;
  protected static int mag = 0;
  protected static int ammoCap = 0;
  protected static int burstCount = 0;
  
  
  /** Calculated Values **/
  public static int finalMag = 0;
  protected static int finalAmmo = 0;
  protected static double finalIterationTime = 0.0;
  protected static double finalIterationsPerMinute = 0.0;
  protected static double finalCritShots = 0.0;
  protected static double finalNormalShots = 0.0;
  public static double finalCritChance = 0.0;
  public static double finalCritMult = 0.0;
  public static double finalFireRate = 0.0;
  public static double finalReloadTime = 0.0;
  public static double finalProjectileCount = 0.0;
  protected static double finalFirstShotDamageMult = 1.0;
  public static double finalStatusChance = 0.0;
  public static double finalStatusDuration = 1.0;
  public static double finalDamageMult = 1.0;
  public static double finalDeadAimMult = 1.0;
  protected static double finalFlatDamageBonus = 0.0;
  public static double finalCorpusMult = 1.0;
  public static double finalGrineerMult = 1.0;
  public static double finalInfestedMult = 1.0;
  protected static double continuousDrainRate = 0.0;
  
  /** Damage/DPS Values **/
  //Misc Values
  protected static double procsPerSecond = 0.0;
  protected static double burstProcsPerSecond = 0.0;
  protected static int slashStacks = 0;
  protected static int fireStacks = 0;
  protected static int toxinStacks = 0;
  protected static int gasStacks = 0;
  
  public static Damage raw = new Damage();
  public static Damage impact = new Damage();
  public static Damage puncture = new Damage();
  public static Damage slash = new Damage();
  public static Damage fire = new Damage();
  public static Damage ice = new Damage();
  public static Damage electric = new Damage();
  public static Damage toxin = new Damage();
  public static Damage blast = new Damage();
  public static Damage magnetic = new Damage();
  public static Damage gas = new Damage();
  public static Damage radiation = new Damage();
  public static Damage corrosive = new Damage();
  public static Damage viral = new Damage();
  public static SurfaceDamage corpus = new SurfaceDamage();
  public static SurfaceDamage grineer = new SurfaceDamage();
  public static SurfaceDamage infested = new SurfaceDamage();
  public static SurfaceDamage cloneFlesh = new SurfaceDamage();
  public static SurfaceDamage ferrite = new SurfaceDamage();
  public static SurfaceDamage alloy = new SurfaceDamage();
  public static SurfaceDamage mechanical = new SurfaceDamage();
  public static SurfaceDamage corpusFlesh = new SurfaceDamage();
  public static SurfaceDamage shield = new SurfaceDamage();
  public static SurfaceDamage protoShield = new SurfaceDamage();
  public static SurfaceDamage robotic = new SurfaceDamage();
  public static SurfaceDamage infestedFlesh = new SurfaceDamage();
  public static SurfaceDamage fossilized = new SurfaceDamage();
  public static SurfaceDamage sinew = new SurfaceDamage();

  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */

  /**
   * Main Method
   * @param args
   */
  public static void main(String[] args) {
    UIBuilder.UIInit();
    riflePanel = new RiflePanel();
    shotgunPanel = new ShotgunPanel();
    pistolPanel = new PistolPanel();
    arcGunPanel = new ArcGunPanel();
    theModManager = new ModManagerPanel(riflePanel, shotgunPanel, pistolPanel, arcGunPanel);
    theTTKManager = new TTKManagerPanel();
    theWeaponManager = new WeaponManagerPanel(riflePanel, shotgunPanel, pistolPanel, arcGunPanel);
    theColorPanel = new ColorOptionsPanel();
    buildUI();
    mainFrame.setVisible(true);
  }
  
  /**
   * Builds the frame UI
   */
  public static void buildUI(){
    UIBuilder.panelInit(mainPanel);
    UIBuilder.panelInit(topPanel);
    UIBuilder.panelInit(bottomPanel);
    UIBuilder.panelInit(riflePanel);
    UIBuilder.panelInit(shotgunPanel);
    UIBuilder.panelInit(pistolPanel);
    UIBuilder.panelInit(arcGunPanel);
    UIBuilder.buttonInit(calculateButton);
    UIBuilder.buttonInit(clearButton);
    UIBuilder.buttonInit(clearOutputButton);
    UIBuilder.textAreaInit(output);
    UIBuilder.scrollPaneInit(outputScroll);
    UIBuilder.tabbedPaneInit(weaponPane);
    UIBuilder.tabbedPaneInit(graphPane);
    UIBuilder.menuBarInit(mainMenuBar);
    UIBuilder.menuInit(fileMenu);
    UIBuilder.menuItemInit(modMenu);
    UIBuilder.menuItemInit(TTKMenu);
    UIBuilder.menuItemInit(weaponMenu);
    UIBuilder.menuItemInit(saveItem);
    UIBuilder.menuItemInit(loadItem);
    UIBuilder.menuItemInit(colorOptionsItem);
    UIBuilder.fileChooserInit(chooser);
    UIBuilder.checkBoxInit(TTKBox);
    UIBuilder.checkBoxInit(lightWeightTTKBox);
    UIBuilder.labelInit(corrosiveProjectionLabel);
    UIBuilder.labelInit(targetGroupLabel);
    UIBuilder.comboBoxInit(corrosiveProjectionBox);
    UIBuilder.comboBoxInit(targetGroupBox);
    
    corrosiveProjectionBox.setPrototypeDisplayValue("XX");
    targetGroupBox.setPrototypeDisplayValue("XX");
    
    for(int i = 0; i < 10; i++){
      targetGroupBox.addItem(""+i);
    }
    
    for(int i = 0; i < 9; i++){
      corrosiveProjectionBox.addItem(""+i);
    }
    
    try{
      File currentDirectory = new File(".");
      chooser.setCurrentDirectory(currentDirectory);
    }catch(Exception ex){
      ex.printStackTrace();
    }
    
    calculateButton.addActionListener(action);
    TTKBox.addActionListener(action);
    lightWeightTTKBox.addActionListener(action);
    clearButton.addActionListener(action);
    clearOutputButton.addActionListener(action);
    saveItem.addActionListener(action);
    loadItem.addActionListener(action);
    modMenu.addActionListener(action);
    TTKMenu.addActionListener(action);
    weaponMenu.addActionListener(action);
    colorOptionsItem.addActionListener(action);
    targetGroupBox.addActionListener(action);
    
    mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
    bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.Y_AXIS));
    
    weaponPane.add(riflePanel, Constants.RIFLE);
    weaponPane.add(shotgunPanel, Constants.SHOTGUN);
    weaponPane.add(pistolPanel, Constants.PISTOL);
    weaponPane.add(arcGunPanel, Constants.ARCGUN);
    
    graphPane.add(dpsGraph, "DPS");
    graphPane.add(ttkGraph, "TTK");
    
    JPanel buttonPanel = new JPanel();
    UIBuilder.panelInit(buttonPanel);
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(corrosiveProjectionLabel);
    buttonPanel.add(corrosiveProjectionBox);
    buttonPanel.add(targetGroupLabel);
    buttonPanel.add(targetGroupBox);
    buttonPanel.add(TTKBox);
    buttonPanel.add(lightWeightTTKBox);
    buttonPanel.add(calculateButton);
    buttonPanel.add(clearButton);
    buttonPanel.add(clearOutputButton);
    
    corrosiveProjectionLabel.setToolTipText("Number of Corrosive Projection auras active.");
    corrosiveProjectionBox.setToolTipText("Number of Corrosive Projection auras active.");
    targetGroupLabel.setToolTipText("Target group to run calculations against.");
    targetGroupBox.setToolTipText("Target group to run calculations against.");
    TTKBox.setToolTipText("Warning: This will cause a significantly performance hit compared to not running TTK.");
    lightWeightTTKBox.setToolTipText("This will have about 10% of the performance impact of normal TTK, but will be less accurate.");
    TTKBox.setSelected(useComplexTTK);
    lightWeightTTKBox.setSelected(!TTKBox.isSelected());
    
    JPanel dataPanel = new JPanel();
    UIBuilder.panelInit(dataPanel);
    dataPanel.setLayout(new GridLayout(1,2,0,0));
    dataPanel.add(graphPane);
    dataPanel.add(outputScroll);
    
    outputScroll.getViewport().setPreferredSize(new Dimension(400,250));
    buttonPanel.setSize(new Dimension(200, 30));
    
    topPanel.add(weaponPane);
    bottomPanel.add(dataPanel);
    bottomPanel.add(buttonPanel);
    mainPanel.add(topPanel);
    mainPanel.add(bottomPanel);
    
    fileMenu.add(colorOptionsItem);
    fileMenu.add(saveItem);
    fileMenu.add(loadItem);
    mainMenuBar.add(fileMenu);
    
    mainMenuBar.add(modMenu);
    mainMenuBar.add(TTKMenu);
    mainMenuBar.add(weaponMenu);
    
    mainFrame.setJMenuBar(mainMenuBar);
    mainFrame.add(mainPanel);
    mainFrame.pack();
    mainFrame.addWindowListener(window);
    mainFrame.setTitle(Constants.APP_TITLE+" "+Constants.APP_VERSION);
    mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }
  
  /**
   * Calculates and Displays the DPS
   */
  public static void calculateDPS(){
    //Clear all the previous values
    clearValues();
    
    //Get the Selected Weapon Type and Active Mods
    selectedWeapon = (WeaponPanel)weaponPane.getSelectedComponent();
    selectedWeapon.parseActiveMods();
    
    //Get the base values from the selected weapon
    getBaseValues();
    
    //Calculate the final values based on weapon parameters and Active Mods
    calculateFinals();
    
    //Calculate miscellaneous values
    calculateMiscValues();
    
    //Calculate damage per shot
    calculateDamagePerShot();
    
    //Calculate the damage per magazine
    calculateDamagePerIteration();
    
    //Calculate the damage per minute
    calculateDamagePerMinute();
    
    //Calculate the damage per second
    calculateDamagePerSecond();
    
    //Calculate the burst damage per second
    calculateBurstDamagePerSecond();
    
    //Calculate Time To Kill Values
    int targetGroup = Integer.parseInt((String)targetGroupBox.getSelectedItem());
    Vector<TTKTarget> groupTargets = new Vector<TTKTarget>();
    for(TTKTarget target: theTTKManager.targets){
      if(target.group == targetGroup){
        groupTargets.add(target);
      }
    }
    if(useComplexTTK && (raw.rawPerSecond > 100.0)){
      complexTTKCompletions = 0;
      for(TTKTarget target : groupTargets){
        target.runAdvancedTTK();
        String name = target.name+"["+target.currentLevel+"]";
        if(name.length() > longestTTKName.length()){
          longestTTKName = name;
        }
      }
      int ttkCount = groupTargets.size();
      maxTTKTime = ttkCount * 60000;
      int ttkTimeout = 0;
      while(complexTTKCompletions < ttkCount && ttkTimeout < maxTTKTime){
        try{
          ttkTimeout += 100;
          Thread.sleep(100);
        }catch(Exception ex){
          ex.printStackTrace();
        }
      }
      System.out.println("Advanced TTK Completed in "+(ttkTimeout/1000.0)+" seconds.");
    }
    
    //Print the data to the text area and render the graph
    updateOutput();
  }
  
  /**
   * Clears all values
   */
  protected static void clearValues(){
    selectedWeapon = null;
    activeMods = new Vector<Mod>();
    modRanks = new Vector<Double>();
    weaponName = "";
    weaponMode = "";
    damageType = "";
    chargeTime = 0.0;
    raw.clear();
    impact.clear();
    puncture.clear();
    slash.clear();
    fire.clear();
    ice.clear();
    electric.clear();
    toxin.clear();
    blast.clear();
    magnetic.clear();
    gas.clear();
    radiation.clear();
    corrosive.clear();
    viral.clear();
    corpus.clear();
    grineer.clear();
    infested.clear();
    cloneFlesh.clear();
    ferrite.clear();
    alloy.clear();
    mechanical.clear();
    corpusFlesh.clear();
    shield.clear();
    protoShield.clear();
    robotic.clear();
    infestedFlesh.clear();
    fossilized.clear();
    sinew.clear();
    fireRate = 0.0;
    reloadTime = 0.0;
    critChance = 0.0;
    critMult = 0.0;
    projectileCount = 0.0;
    firstShotDamageMult = 1.0;
    statusChance = 0.0;
    statusDuration = 1.0;
    damageMult = 1.0;
    deadAimMult = 1.0;
    flatDamageBonus = 0.0;
    mag = 0;
    ammoCap = 0;
    burstCount = 0;
    finalMag = 0;
    finalAmmo = 0;
    finalIterationTime = 0.0;
    finalIterationsPerMinute = 0.0;
    finalCritShots = 0.0;
    finalNormalShots = 0.0;
    finalCritChance = 0.0;
    finalCritMult = 0.0;
    finalFireRate = 0.0;
    finalReloadTime = 0.0;
    finalProjectileCount = 0.0;
    finalFirstShotDamageMult = 1.0;
    finalStatusChance = 0.0;
    finalStatusDuration = 0.0;
    finalDamageMult = 1.0;
    finalDeadAimMult = 1.0;
    finalFlatDamageBonus = 0.0;
    finalCorpusMult = 1.0;
    finalGrineerMult = 1.0;
    finalInfestedMult = 1.0;
    procsPerSecond = 0.0;
    burstProcsPerSecond = 0.0;
    slashStacks = 0;
    fireStacks = 0;
    toxinStacks = 0;
    gasStacks = 0;
    continuousDrainRate = 0.0;
    complexTTKCompletions = 0;
  }
  
  /**
   * Gets the base values from the selected weapon
   */
  protected static void getBaseValues(){
    //Base Values
    weaponName = selectedWeapon.getName();
    weaponMode = selectedWeapon.getWeaponMode();
    damageType = selectedWeapon.getDamageType();
    chargeTime = selectedWeapon.getChargeTime();
    fireRate = selectedWeapon.getFireRate();
    reloadTime = selectedWeapon.getReloadTime();
    critChance = selectedWeapon.getCritChance();
    critMult = selectedWeapon.getCritMultiplier();
    projectileCount = selectedWeapon.getProjectiles();
    firstShotDamageMult = 1.0;
    statusChance = selectedWeapon.getStatusChance();
    mag = selectedWeapon.getMagSize();
    ammoCap = selectedWeapon.getTotalAmmo();
    burstCount = selectedWeapon.getBurstCount();
    
    if(damageType.equals(Constants.PHYSICAL_WEAPON_DAMAGE)){
      impact.base = selectedWeapon.getImpactDamage();
      puncture.base = selectedWeapon.getPunctureDamage();
      slash.base = selectedWeapon.getSlashDamage();
    }else if(damageType.equals(Constants.FIRE_WEAPON_DAMAGE)){
      fire.base = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.ICE_WEAPON_DAMAGE)){
      ice.base = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.ELECTRIC_WEAPON_DAMAGE)){
      electric.base = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.TOXIN_WEAPON_DAMAGE)){
      toxin.base = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.BLAST_WEAPON_DAMAGE)){
      blast.base = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.MAGNETIC_WEAPON_DAMAGE)){
      magnetic.base = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.GAS_WEAPON_DAMAGE)){
      gas.base = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.RADIATION_WEAPON_DAMAGE)){
      radiation.base = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.CORROSIVE_WEAPON_DAMAGE)){
      corrosive.base = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.VIRAL_WEAPON_DAMAGE)){
      viral.base = selectedWeapon.getBaseDamage();
    }
    
    raw.base = impact.base +
                puncture.base +
                slash.base +
                fire.base +
                ice.base +
                electric.base +
                toxin.base +
                blast.base +
                magnetic.base +
                gas.base +
                radiation.base +
                corrosive.base +
                viral.base;
    
    //Factor for multiple projectiles per shot
    if(projectileCount > 1.0){
      raw.base /= projectileCount;
      statusChance /= projectileCount;
      impact.base /= projectileCount;
      puncture.base /= projectileCount;
      slash.base /= projectileCount;
      fire.base /= projectileCount;
      ice.base /= projectileCount;
      electric.base /= projectileCount;
      toxin.base /= projectileCount;
      blast.base/= projectileCount;
      magnetic.base /= projectileCount;
      gas.base /= projectileCount;
      radiation.base /= projectileCount;
      corrosive.base /= projectileCount;
      viral.base /= projectileCount;
    }
    
    //Calculations based on weapon type
    if(weaponMode.equals(Constants.CONTINUOUS)){
      continuousDrainRate = fireRate;
      fireRate = CONTINUOUS_MULT;
      damageMult *= continuousDrainRate;
      statusChance /= CONTINUOUS_MULT;
    }else if(weaponMode.equals(Constants.CHARGE)){
      double fireRateAddition = 60.0 / chargeTime / 60.0;
      fireRate += fireRateAddition;
    }else if(weaponMode.equals(Constants.BURST)){
      projectileCount *= burstCount;
    }
    
    //Mod Vectors
    activeMods = selectedWeapon.getActiveMods();
    modRanks = selectedWeapon.getActiveModRanks();
  }
  
  /**
   * Calculates the final modded values
   */
  protected static void calculateFinals(){
    //Initialize mod vectors
    Vector<Mod> combinedMods = new Vector<Mod>();
    Vector<Double> magMods = new Vector<Double>();
    Vector<Double> ammoMods = new Vector<Double>();
    Vector<Double> critChanceMods = new Vector<Double>();
    Vector<Double> critMultMods = new Vector<Double>();
    Vector<Double> fireRateMods = new Vector<Double>();
    Vector<Double> reloadTimeMods = new Vector<Double>();
    Vector<Double> damageMultMods = new Vector<Double>();
    Vector<Double> impactDamageMods = new Vector<Double>();
    Vector<Double> punctureDamageMods = new Vector<Double>();
    Vector<Double> slashDamageMods = new Vector<Double>();
    Vector<Double> fireDamageMods = new Vector<Double>();
    Vector<Double> iceDamageMods = new Vector<Double>();
    Vector<Double> electricDamageMods = new Vector<Double>();
    Vector<Double> toxinDamageMods = new Vector<Double>();
    Vector<Double> blastDamageMods = new Vector<Double>();
    Vector<Double> magneticDamageMods = new Vector<Double>();
    Vector<Double> gasDamageMods = new Vector<Double>();
    Vector<Double> radiationDamageMods = new Vector<Double>();
    Vector<Double> corrosiveDamageMods = new Vector<Double>();
    Vector<Double> viralDamageMods = new Vector<Double>();
    Vector<Double> projectileCountMods = new Vector<Double>();
    Vector<Double> firstShotDamageMods = new Vector<Double>();
    Vector<Double> statusChanceMods = new Vector<Double>();
    Vector<Double> statusDurationMods = new Vector<Double>();
    Vector<Double> corpusMods = new Vector<Double>();
    Vector<Double> grineerMods = new Vector<Double>();
    Vector<Double> infestedMods = new Vector<Double>();
    Vector<Double> flatDamageMods = new Vector<Double>();
    Vector<Double> deadAimMods = new Vector<Double>();
    Vector<Double> flatStatusMods = new Vector<Double>();
    Vector<Double> flatMagMods = new Vector<Double>();
    
    //Check for combined elements
    Mod primeMod = null;
    double primeModRanks = 0;
    String primeModType = "";
    for(int i = 0; i < activeMods.size(); i++){
      Mod tempMod = activeMods.get(i);
      if(primeMod == null){
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_FIRE_DAMAGE)){
          double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FIRE_DAMAGE))*(1.0+modRanks.get(i));
          if(blastDamageMods.size() > 0){
            blastDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else if(radiationDamageMods.size() > 0){
            radiationDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else if(gasDamageMods.size() > 0){
            gasDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else{
            primeMod = tempMod;
            primeModRanks = modRanks.get(i);
            primeModType = Constants.MOD_TYPE_FIRE_DAMAGE;
          }
        }
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_ICE_DAMAGE)){
          double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_ICE_DAMAGE))*(1.0+modRanks.get(i));
          if(blastDamageMods.size() > 0){
            blastDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else if(magneticDamageMods.size() > 0){
            magneticDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else if(viralDamageMods.size() > 0){
            viralDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else{
            primeMod = tempMod;
            primeModRanks = modRanks.get(i);
            primeModType = Constants.MOD_TYPE_ICE_DAMAGE;
          }
        }
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
          double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_LIGHTNING_DAMAGE))*(1.0+modRanks.get(i));
          if(corrosiveDamageMods.size() > 0){
            corrosiveDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else if(magneticDamageMods.size() > 0){
            magneticDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else if(radiationDamageMods.size() > 0){
            radiationDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else{
            primeMod = tempMod;
            primeModRanks = modRanks.get(i);
            primeModType = Constants.MOD_TYPE_LIGHTNING_DAMAGE;
          }
        }
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_TOXIN_DAMAGE)){
          double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_TOXIN_DAMAGE))*(1.0+modRanks.get(i));
          if(corrosiveDamageMods.size() > 0){
            corrosiveDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else if(viralDamageMods.size() > 0){
            viralDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else if(gasDamageMods.size() > 0){
            gasDamageMods.add(modPower);
            combinedMods.add(tempMod);
          }else{
            primeMod = tempMod;
            primeModRanks = modRanks.get(i);
            primeModType = Constants.MOD_TYPE_TOXIN_DAMAGE;
          }
        }
      }else{
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_FIRE_DAMAGE)){
          if(primeModType.equals(Constants.MOD_TYPE_FIRE_DAMAGE)){
            //Don't Combine
          }else if(primeModType.equals(Constants.MOD_TYPE_ICE_DAMAGE)){
            if(magneticDamageMods.size() > 0){
              //Don't Combine
            }else if(viralDamageMods.size() > 0){
              //Don't Combine
            }else if(gasDamageMods.size() > 0){
              //Don't Combine
            }else if(radiationDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FIRE_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              blastDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
            if(corrosiveDamageMods.size() > 0){
              //Don't Combine
            }else if(magneticDamageMods.size() > 0){
              //Don't Combine
            }else if(blastDamageMods.size() > 0){
              //Don't Combine
            }else if(gasDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FIRE_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              radiationDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
            if(corrosiveDamageMods.size() > 0){
              //Don't Combine
            }else if(viralDamageMods.size() > 0){
              //Don't Combine
            }else if(blastDamageMods.size() > 0){
              //Don't Combine
            }else if(radiationDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FIRE_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              gasDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }
        }else if(tempMod.effectTypes.contains(Constants.MOD_TYPE_ICE_DAMAGE)){
          if(primeModType.equals(Constants.MOD_TYPE_FIRE_DAMAGE)){
            if(gasDamageMods.size() > 0){
              //Don't Combine
            }else if(radiationDamageMods.size() > 0){
              //Don't Combine
            }else if(magneticDamageMods.size() > 0){
              //Don't Combine
            }else if(viralDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_ICE_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              blastDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }else if(primeModType.equals(Constants.MOD_TYPE_ICE_DAMAGE)){
            //Don't Combine
          }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
            if(corrosiveDamageMods.size() > 0){
              //Don't Combine
            }else if(radiationDamageMods.size() > 0){
              //Don't Combine
            }else if(blastDamageMods.size() > 0){
              //Don't Combine
            }else if(viralDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_ICE_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              magneticDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
            if(corrosiveDamageMods.size() > 0){
              //Don't Combine
            }else if(gasDamageMods.size() > 0){
              //Don't Combine
            }else if(blastDamageMods.size() > 0){
              //Don't Combine
            }else if(magneticDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_ICE_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              viralDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }
        }else if(tempMod.effectTypes.contains(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
          if(primeModType.equals(Constants.MOD_TYPE_FIRE_DAMAGE)){
            if(gasDamageMods.size() > 0){
              //Don't Combine
            }else if(blastDamageMods.size() > 0){
              //Don't Combine
            }else if(corrosiveDamageMods.size() > 0){
              //Don't Combine
            }else if(magneticDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_LIGHTNING_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              radiationDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }else if(primeModType.equals(Constants.MOD_TYPE_ICE_DAMAGE)){
            if(blastDamageMods.size() > 0){
              //Don't Combine
            }else if(viralDamageMods.size() > 0){
              //Don't Combine
            }else if(corrosiveDamageMods.size() > 0){
              //Don't Combine
            }else if(radiationDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_LIGHTNING_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              magneticDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
            //Don't Combine
          }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
            if(viralDamageMods.size() > 0){
              //Don't Combine
            }else if(gasDamageMods.size() > 0){
              //Don't Combine
            }else if(radiationDamageMods.size() > 0){
              //Don't Combine
            }else if(magneticDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_LIGHTNING_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              corrosiveDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }
        }else if(tempMod.effectTypes.contains(Constants.MOD_TYPE_TOXIN_DAMAGE)){
          if(primeModType.equals(Constants.MOD_TYPE_FIRE_DAMAGE)){
            if(blastDamageMods.size() > 0){
              //Don't Combine
            }else if(radiationDamageMods.size() > 0){
              //Don't Combine
            }else if(corrosiveDamageMods.size() > 0){
              //Don't Combine
            }else if(viralDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_TOXIN_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              gasDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }else if(primeModType.equals(Constants.MOD_TYPE_ICE_DAMAGE)){
            if(blastDamageMods.size() > 0){
              //Don't Combine
            }else if(magneticDamageMods.size() > 0){
              //Don't Combine
            }else if(corrosiveDamageMods.size() > 0){
              //Don't Combine
            }else if(gasDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_TOXIN_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              viralDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
            if(magneticDamageMods.size() > 0){
              //Don't Combine
            }else if(radiationDamageMods.size() > 0){
              //Don't Combine
            }else if(gasDamageMods.size() > 0){
              //Don't Combine
            }else if(viralDamageMods.size() > 0){
              //Don't Combine
            }else{
              combinedMods.add(primeMod);
              combinedMods.add(tempMod);
              double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
              double secondEffectPower = (tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_TOXIN_DAMAGE)))*(1.0+modRanks.get(i));
              double jointPower = primeEffectPower + secondEffectPower;
              corrosiveDamageMods.add(jointPower);
              primeMod = null;
              primeModRanks = 0;
              primeModType = "";
            }
          }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
            //Don't Combine
          }
        }
      }
    }
    //Combine the base
    boolean baseCombined = false;
    if(primeMod != null && !damageType.equals(Constants.PHYSICAL_WEAPON_DAMAGE)){
      if( damageType.equals(Constants.FIRE_WEAPON_DAMAGE)
          &&(blastDamageMods.size() == 0)
          &&(radiationDamageMods.size() == 0)
          &&(gasDamageMods.size() == 0)){
        if(primeModType.equals(Constants.MOD_TYPE_FIRE_DAMAGE)){
          //Don't Combine
        }else if(primeModType.equals(Constants.MOD_TYPE_ICE_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          blastDamageMods.add(jointPower);
          blast.base = fire.base;
          fire.base = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          radiationDamageMods.add(jointPower);
          radiation.base = fire.base;
          fire.base = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          gasDamageMods.add(jointPower);
          gas.base = fire.base;
          fire.base = 0.0;
          baseCombined = true;
        }
      }else if( damageType.equals(Constants.ICE_WEAPON_DAMAGE)
                &&(blastDamageMods.size() == 0)
                &&(magneticDamageMods.size() == 0)
                &&(viralDamageMods.size() == 0)){
        if(primeModType.equals(Constants.MOD_TYPE_FIRE_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          blastDamageMods.add(jointPower);
          blast.base = ice.base;
          ice.base = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_ICE_DAMAGE)){
          //Don't Combine
        }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          magneticDamageMods.add(jointPower);
          magnetic.base = ice.base;
          ice.base = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          viralDamageMods.add(jointPower);
          viral.base = ice.base;
          ice.base = 0.0;
          baseCombined = true;
        }
      }else if( damageType.equals(Constants.ELECTRIC_WEAPON_DAMAGE)
                &&(radiationDamageMods.size() == 0)
                &&(magneticDamageMods.size() == 0)
                &&(corrosiveDamageMods.size() == 0)){
        if(primeModType.equals(Constants.MOD_TYPE_FIRE_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          radiationDamageMods.add(jointPower);
          radiation.base = electric.base;
          electric.base = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_ICE_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          magneticDamageMods.add(jointPower);
          magnetic.base = electric.base;
          electric.base = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
          //Don't Combine
        }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          corrosiveDamageMods.add(jointPower);
          corrosive.base = electric.base;
          electric.base = 0.0;
          baseCombined = true;
        }
      }else if  (damageType.equals(Constants.TOXIN_WEAPON_DAMAGE)
                &&(gasDamageMods.size() == 0)
                &&(viralDamageMods.size() == 0)
                &&(corrosiveDamageMods.size() == 0)){
        if(primeModType.equals(Constants.MOD_TYPE_FIRE_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          gasDamageMods.add(jointPower);
          gas.base = toxin.base;
          toxin.base = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_ICE_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          viralDamageMods.add(jointPower);
          viral.base = toxin.base;
          toxin.base = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          corrosiveDamageMods.add(jointPower);
          corrosive.base = toxin.base;
          toxin.base = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
          //Don't Combine
        }
      }
    }
    if(!baseCombined){
      if(damageType.equals(Constants.FIRE_WEAPON_DAMAGE)){
        if(blastDamageMods.size() > 0){
          blast.base = fire.base;
          fire.base = 0.0;
        }else if(radiationDamageMods.size() > 0){
          radiation.base = fire.base;
          fire.base = 0.0;
        }else if(gasDamageMods.size() > 0){
          gas.base = fire.base;
          fire.base = 0.0;
        }
      }else if(damageType.equals(Constants.ICE_WEAPON_DAMAGE)){
        if(blastDamageMods.size() > 0){
          blast.base = ice.base;
          ice.base = 0.0;
        }else if(magneticDamageMods.size() > 0){
          magnetic.base = ice.base;
          ice.base = 0.0;
        }else if(viralDamageMods.size() > 0){
          viral.base = ice.base;
          ice.base = 0.0;
        }
      }else if(damageType.equals(Constants.ELECTRIC_WEAPON_DAMAGE)){
        if(radiationDamageMods.size() > 0){
          radiation.base = electric.base;
          electric.base = 0.0;
        }else if(magneticDamageMods.size() > 0){
          magnetic.base = electric.base;
          electric.base = 0.0;
        }else if(corrosiveDamageMods.size() > 0){
          corrosive.base = electric.base;
          electric.base = 0.0;
        }
      }else if(damageType.equals(Constants.TOXIN_WEAPON_DAMAGE)){
        if(gasDamageMods.size() > 0){
          gas.base = toxin.base;
          toxin.base = 0.0;
        }else if(viralDamageMods.size() > 0){
          viral.base = toxin.base;
          toxin.base = 0.0;
        }else if(corrosiveDamageMods.size() > 0){
          corrosive.base = toxin.base;
          toxin.base = 0.0;
        }
      }
    }
    
    //Populate non-combined-element mod vectors
    for(int i = 0; i < activeMods.size(); i++){
      Mod tempMod = activeMods.get(i);
      if(!combinedMods.contains(tempMod)){
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_FIRE_DAMAGE)){
          double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FIRE_DAMAGE))*(1.0+modRanks.get(i));
          if(blastDamageMods.size() > 0){
            blastDamageMods.add(modPower);
          }else if(radiationDamageMods.size() > 0){
            radiationDamageMods.add(modPower);
          }else if(gasDamageMods.size() > 0){
            gasDamageMods.add(modPower);
          }else{
            fireDamageMods.add(modPower);
          }
        }
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_ICE_DAMAGE)){
          double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_ICE_DAMAGE))*(1.0+modRanks.get(i));
          if(blastDamageMods.size() > 0){
            blastDamageMods.add(modPower);
          }else if(magneticDamageMods.size() > 0){
            magneticDamageMods.add(modPower);
          }else if(viralDamageMods.size() > 0){
            viralDamageMods.add(modPower);
          }else{
            iceDamageMods.add(modPower);
          }
        }
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
          double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_LIGHTNING_DAMAGE))*(1.0+modRanks.get(i));
          if(corrosiveDamageMods.size() > 0){
            corrosiveDamageMods.add(modPower);
          }else if(magneticDamageMods.size() > 0){
            magneticDamageMods.add(modPower);
          }else if(radiationDamageMods.size() > 0){
            radiationDamageMods.add(modPower);
          }else{
            electricDamageMods.add(modPower);
          }
        }
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_TOXIN_DAMAGE)){
          double modPower = tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_TOXIN_DAMAGE))*(1.0+modRanks.get(i));
          if(corrosiveDamageMods.size() > 0){
            corrosiveDamageMods.add(modPower);
          }else if(viralDamageMods.size() > 0){
            viralDamageMods.add(modPower);
          }else if(gasDamageMods.size() > 0){
            gasDamageMods.add(modPower);
          }else{
            toxinDamageMods.add(modPower);
          }
        }
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_IMPACT_DAMAGE)){
          impactDamageMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_IMPACT_DAMAGE)))*(1.0+modRanks.get(i)));
        }
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_PUNCTURE_DAMAGE)){
          punctureDamageMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_PUNCTURE_DAMAGE)))*(1.0+modRanks.get(i)));
        }
        if(tempMod.effectTypes.contains(Constants.MOD_TYPE_SLASH_DAMAGE)){
          slashDamageMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_SLASH_DAMAGE)))*(1.0+modRanks.get(i)));
        }
      }
    }
    
    //Populate non-elemental mod vectors
    for(int i = 0; i < activeMods.size(); i++){
      Mod tempMod = activeMods.get(i);
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_MAG_CAP)){
        magMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_MAG_CAP)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_AMMO_CAP)){
        ammoMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_AMMO_CAP)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_CRIT_CHANCE)){
        critChanceMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_CRIT_CHANCE)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_CRIT_MULTIPLIER)){
        critMultMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_CRIT_MULTIPLIER)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_FIRE_RATE)){
        fireRateMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FIRE_RATE)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_RELOAD_SPEED)){
        reloadTimeMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_RELOAD_SPEED)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_DAMAGE_BONUS)){
        damageMultMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_DAMAGE_BONUS)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_MULTISHOT)){
        projectileCountMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_MULTISHOT)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_FIRST_SHOT_DAMAGE)){
        firstShotDamageMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FIRST_SHOT_DAMAGE)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_STATUS_CHANCE)){
        statusChanceMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_STATUS_CHANCE)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_STATUS_DURATION)){
        statusDurationMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_STATUS_DURATION)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_CORPUS_DAMAGE)){
        corpusMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_CORPUS_DAMAGE)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_GRINEER_DAMAGE)){
        grineerMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_GRINEER_DAMAGE)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_INFESTED_DAMAGE)){
        infestedMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_INFESTED_DAMAGE)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_FLAT_DAMAGE)){
        flatDamageMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FLAT_DAMAGE)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_FLAT_STATUS)){
        flatStatusMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FLAT_STATUS)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_FLAT_MAG)){
        flatMagMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_FLAT_MAG)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_DEAD_AIM)){
        deadAimMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_DEAD_AIM)))*(1.0+modRanks.get(i)));
      }
    }
    
    //Calculate finals
    finalMag = mag;
    for(int i = 0; i < magMods.size(); i++){
      finalMag += mag*magMods.get(i);
    }
    for(int i = 0; i < flatMagMods.size(); i++){
      finalMag += flatMagMods.get(i);
    }
    
    finalAmmo = ammoCap;
    for(int i = 0; i < ammoMods.size(); i++){
      finalAmmo += ammoCap*ammoMods.get(i);
    }
    
    finalCritChance = critChance;
    for(int i = 0; i < critChanceMods.size(); i++){
      finalCritChance += critChance*critChanceMods.get(i);
    }
    
    finalCritMult = critMult;
    for(int i = 0; i < critMultMods.size(); i++){
      finalCritMult += critMult*critMultMods.get(i);
    }
    
    finalFlatDamageBonus = flatDamageBonus;
    for(int i = 0; i < flatDamageMods.size(); i++){
      finalFlatDamageBonus += flatDamageMods.get(i);
    }
    
    finalDeadAimMult = deadAimMult;
    for(int i = 0; i < deadAimMods.size(); i++){
      finalDeadAimMult += deadAimMult*deadAimMods.get(i);
    }
    
    finalDamageMult = damageMult;
    for(int i = 0; i < damageMultMods.size(); i++){
      finalDamageMult += damageMult*damageMultMods.get(i);
    }
    
    if(weaponMode.equals(Constants.CONTINUOUS)){
      finalFireRate = fireRate;
      double localContinuousDrainRate = continuousDrainRate;
      for(int i = 0; i < fireRateMods.size(); i++){
        finalDamageMult += damageMult*fireRateMods.get(i);
        continuousDrainRate += localContinuousDrainRate*fireRateMods.get(i);
      }
    }else{
      finalFireRate = fireRate;
      for(int i = 0; i < fireRateMods.size(); i++){
        finalFireRate += fireRate*fireRateMods.get(i);
      }
    }
    
    //This is completely retarded, but also the current case
    if(weaponMode.equals(Constants.SEMI_AUTO)){
      if(finalFireRate > 10.0){
        finalFireRate = 10.0;
      }
    }
    
    finalReloadTime = reloadTime;
    double reloadSpeedMult = 1.0;
    for(int i = 0; i < reloadTimeMods.size(); i++){
      //finalReloadTime -= reloadTime*reloadTimeMods.get(i);
      reloadSpeedMult += reloadTimeMods.get(i);
    }
    finalReloadTime /= reloadSpeedMult;
    
    finalProjectileCount = projectileCount;
    for(int i = 0; i < projectileCountMods.size(); i++){
      finalProjectileCount += projectileCount*projectileCountMods.get(i);
    }
    
    finalFirstShotDamageMult = firstShotDamageMult;
    for(int i = 0; i < firstShotDamageMods.size(); i++){
      finalFirstShotDamageMult += firstShotDamageMult*firstShotDamageMods.get(i);
    }
    
    finalStatusChance = statusChance;
    for(int i = 0; i < statusChanceMods.size(); i++){
      finalStatusChance += statusChance*statusChanceMods.get(i);
    }
    for(int i = 0; i < flatStatusMods.size(); i++){
      double localStatus = flatStatusMods.get(i);
      if(projectileCount > 1.0){
        localStatus /= projectileCount;
      }
      finalStatusChance += localStatus;
    }
    
    finalStatusDuration = statusDuration;
    for(int i = 0; i < statusDurationMods.size(); i++){
      finalStatusDuration += statusDuration * statusDurationMods.get(i);
    }
    
    if(damageType.equals(Constants.PHYSICAL_WEAPON_DAMAGE)){
      
      impact.finalBase = impact.base;
      for(int i = 0; i < impactDamageMods.size(); i++){
        impact.finalBase += impact.base*impactDamageMods.size();
      }
      impact.finalBase *= finalDamageMult;
      
      puncture.finalBase = puncture.base;
      for(int i = 0; i < punctureDamageMods.size(); i++){
        puncture.finalBase += puncture.base*punctureDamageMods.size();
      }
      puncture.finalBase *= finalDamageMult;
      
      slash.finalBase = slash.base;
      for(int i = 0; i < slashDamageMods.size(); i++){
        slash.finalBase += slash.base*slashDamageMods.size();
      }
      slash.finalBase *= finalDamageMult;
    }
    
    fire.finalBase = fire.base;
    for(int i = 0; i < fireDamageMods.size(); i++){
      fire.finalBase += raw.base*fireDamageMods.get(i);
    }
    fire.finalBase *= finalDamageMult;
    
    ice.finalBase = ice.base;
    for(int i = 0; i < iceDamageMods.size(); i++){
      ice.finalBase += raw.base*iceDamageMods.get(i);
    }
    ice.finalBase *= finalDamageMult;
    
    electric.finalBase = electric.base;
    for(int i = 0; i < electricDamageMods.size(); i++){
      electric.finalBase += raw.base*electricDamageMods.get(i);
    }
    electric.finalBase *= finalDamageMult;
    
    toxin.finalBase = toxin.base;
    for(int i = 0; i < toxinDamageMods.size(); i++){
      toxin.finalBase += raw.base*toxinDamageMods.get(i);
    }
    toxin.finalBase *= finalDamageMult;
    
    blast.finalBase = blast.base;
    for(int i = 0; i < blastDamageMods.size(); i++){
      blast.finalBase += raw.base*blastDamageMods.get(i);
    }
    blast.finalBase *= finalDamageMult;
    
    magnetic.finalBase = magnetic.base;
    for(int i = 0; i < magneticDamageMods.size(); i++){
      magnetic.finalBase += raw.base*magneticDamageMods.get(i);
    }
    magnetic.finalBase *= finalDamageMult;
    
    gas.finalBase = gas.base;
    for(int i = 0; i < gasDamageMods.size(); i++){
      gas.finalBase += raw.base*gasDamageMods.get(i);
    }
    gas.finalBase *= finalDamageMult;
    
    radiation.finalBase = radiation.base;
    for(int i = 0; i < radiationDamageMods.size(); i++){
      radiation.finalBase += raw.base*radiationDamageMods.get(i);
    }
    radiation.finalBase *= finalDamageMult;
    
    corrosive.finalBase = corrosive.base;
    for(int i = 0; i < corrosiveDamageMods.size(); i++){
      corrosive.finalBase += raw.base*corrosiveDamageMods.get(i);
    }
    corrosive.finalBase *= finalDamageMult;
    
    viral.finalBase = viral.base;
    for(int i = 0; i < viralDamageMods.size(); i++){
      viral.finalBase += raw.base*viralDamageMods.get(i);
    }
    viral.finalBase *= finalDamageMult;
    
    raw.finalBase =  impact.finalBase +
                      puncture.finalBase +
                      slash.finalBase +
                      slash.finalBase +
                      ice.finalBase +
                      electric.finalBase +
                      toxin.finalBase +
                      blast.finalBase +
                      magnetic.finalBase +
                      gas.finalBase +
                      radiation.finalBase +
                      corrosive.finalBase +
                      viral.finalBase;
    
    finalCorpusMult = 1.0;
    for(int i = 0; i < corpusMods.size(); i++){
      finalCorpusMult += corpusMods.get(i);
    }
    
    finalGrineerMult = 1.0;
    for(int i = 0; i < grineerMods.size(); i++){
      finalGrineerMult += grineerMods.get(i);
    }
    
    finalInfestedMult = 1.0;
    for(int i = 0; i < infestedMods.size(); i++){
      finalInfestedMult += infestedMods.get(i);
    }
    
    if(weaponMode.equals(Constants.BURST)){
      finalCritShots = (finalMag / burstCount) * finalCritChance;
      if(finalCritShots > finalMag){
        finalCritShots = finalMag;
      }
      
      finalNormalShots = (finalMag / burstCount) - finalCritShots;
      if(finalNormalShots < 0.0){
        finalNormalShots = 0.0;
      }
    }else{
      finalCritShots = finalMag * finalCritChance;
      finalNormalShots = finalMag - finalCritShots;
      if(finalNormalShots < 0.0){
        finalNormalShots = 0.0;
      }
    }
    
    if(weaponMode.equals(Constants.CONTINUOUS)){
      //finalStatusChance = (finalStatusChance * continuousDrainRate) / CONTINUOUS_MULT;
      finalNormalShots = (finalNormalShots / continuousDrainRate) * CONTINUOUS_MULT;
      finalCritShots = (finalCritShots / continuousDrainRate) * CONTINUOUS_MULT;
      finalIterationTime = (finalMag / continuousDrainRate) + finalReloadTime;
    }else if(weaponMode.equals(Constants.BURST)){
      if(selectedWeapon.isRefireCanceled()){
        finalFireRate += fireRate;
      }
      double burstDelay = 0.05;
      double burstMS = (60.0/finalFireRate)/60.0;
      double burstIterationMS = (burstMS*burstCount)+burstDelay;
      finalFireRate = (60.0/burstIterationMS)/60.0;
      if(finalFireRate > 10.0){
        finalFireRate = 10.0;
      }
      double numBursts = finalMag/burstCount;
      double rawFireTime = numBursts/finalFireRate;
      finalIterationTime = rawFireTime+finalReloadTime;
    }else if(weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || weaponMode.equals(Constants.FULL_AUTO_RAMP_UP)){
      double baseFireDelay = 60.0 / finalFireRate / 60.0;
      double firstFireDelay = baseFireDelay * 5;
      double secondFireDelay = baseFireDelay * 4;
      double thirdFireDelay = baseFireDelay * 3;
      double fourthFireDelay = baseFireDelay * 2;
      finalIterationTime = (firstFireDelay + secondFireDelay + thirdFireDelay + fourthFireDelay + ((finalMag - 4) * baseFireDelay)) + finalReloadTime;
    }else{
      finalIterationTime = (finalMag / finalFireRate) + finalReloadTime;
    }
    
    finalIterationsPerMinute = 60.0 / finalIterationTime;
  }
  
  /**
   * Calculates miscellaneous values 
   */
  protected static void calculateMiscValues(){
    if(weaponMode.equals(Constants.CONTINUOUS)){
      procsPerSecond = ((CONTINUOUS_MULT * ((finalProjectileCount * finalMag) / continuousDrainRate)) * finalStatusChance) * (60 / finalIterationTime / 60);
      burstProcsPerSecond = (CONTINUOUS_MULT * (finalProjectileCount * finalStatusChance));
    }else{
      procsPerSecond = ((finalProjectileCount * finalMag) * finalStatusChance) * (60 / finalIterationTime / 60);
      burstProcsPerSecond = ((finalProjectileCount * finalMag) * finalStatusChance) * (60 / (finalMag / finalFireRate) / 60);
    }
    if(slash.finalBase > 0.0){
      slashStacks = calculateAverageStacks(finalStatusChance, 6.0);
    }
    if(fire.finalBase > 0.0){
      fireStacks = calculateAverageStacks(finalStatusChance, 6.0);
    }
    if(toxin.finalBase > 0.0){
      toxinStacks = calculateAverageStacks(finalStatusChance, 8.0);
    }
    if(gas.finalBase > 0.0){
      gasStacks = calculateAverageStacks(finalStatusChance, 8.0);
    }
  }
  
  /**
   * Calculates the damage per shot values
   */
  protected static void calculateDamagePerShot(){
    
    //Calculate base damage per shot values
    impact.perShot = (impact.finalBase * finalProjectileCount) * finalDeadAimMult;
    puncture.perShot = (puncture.finalBase * finalProjectileCount) * finalDeadAimMult;
    slash.perShot = (slash.finalBase * finalProjectileCount) * finalDeadAimMult;
    fire.perShot = (fire.finalBase * finalProjectileCount) * finalDeadAimMult;
    ice.perShot = (ice.finalBase * finalProjectileCount) * finalDeadAimMult;
    electric.perShot = (electric.finalBase * finalProjectileCount) * finalDeadAimMult;
    toxin.perShot = (toxin.finalBase * finalProjectileCount) * finalDeadAimMult;
    blast.perShot = (blast.finalBase * finalProjectileCount) * finalDeadAimMult;
    magnetic.perShot = (magnetic.finalBase * finalProjectileCount) * finalDeadAimMult;
    gas.perShot = (gas.finalBase * finalProjectileCount) * finalDeadAimMult;
    radiation.perShot = (radiation.finalBase * finalProjectileCount) * finalDeadAimMult;
    corrosive.perShot = (corrosive.finalBase * finalProjectileCount) * finalDeadAimMult;
    viral.perShot = (viral.finalBase * finalProjectileCount) * finalDeadAimMult;
    raw.perShot =  impact.perShot +
                        puncture.perShot +
                        slash.perShot +
                        fire.perShot +
                        ice.perShot +
                        electric.perShot +
                        toxin.perShot +
                        blast.perShot +
                        magnetic.perShot +
                        gas.perShot +
                        radiation.perShot +
                        corrosive.perShot +
                        viral.perShot;
    
    //Surface-specific
    corpus.perShot = raw.perShot * finalCorpusMult;
    grineer.perShot = raw.perShot * finalGrineerMult;
    
    infested.perShot += impact.perShot;
    infested.perShot += puncture.perShot;
    infested.perShot += slash.perShot * 1.25;
    infested.perShot += fire.perShot * 1.25;
    infested.perShot += ice.perShot;
    infested.perShot += electric.perShot;
    infested.perShot += toxin.perShot;
    infested.perShot += blast.perShot;
    infested.perShot += magnetic.perShot;
    infested.perShot += gas.perShot * 1.75;
    infested.perShot += radiation.perShot * 0.5;
    infested.perShot += corrosive.perShot;
    infested.perShot += viral.perShot * 0.5;
    infested.perShot *= finalInfestedMult;
    
    cloneFlesh.perShot += impact.perShot * 0.75;
    cloneFlesh.perShot += puncture.perShot;
    cloneFlesh.perShot += slash.perShot * 1.25;
    cloneFlesh.perShot += fire.perShot * 1.25;
    cloneFlesh.perShot += ice.perShot;
    cloneFlesh.perShot += electric.perShot;
    cloneFlesh.perShot += toxin.perShot;
    cloneFlesh.perShot += blast.perShot;
    cloneFlesh.perShot += magnetic.perShot;
    cloneFlesh.perShot += gas.perShot * 0.5;
    cloneFlesh.perShot += radiation.perShot;
    cloneFlesh.perShot += corrosive.perShot;
    cloneFlesh.perShot += viral.perShot * 1.75;

    ferrite.perShot += impact.perShot;
    ferrite.perShot += puncture.perShot * 1.5;
    ferrite.perShot += slash.perShot * 0.85;
    ferrite.perShot += fire.perShot;
    ferrite.perShot += ice.perShot;
    ferrite.perShot += electric.perShot;
    ferrite.perShot += toxin.perShot * 1.25;
    ferrite.perShot += blast.perShot * 0.75;
    ferrite.perShot += magnetic.perShot;
    ferrite.perShot += gas.perShot;
    ferrite.perShot += radiation.perShot;
    ferrite.perShot += corrosive.perShot * 1.75;
    ferrite.perShot += viral.perShot;
    
    alloy.perShot += impact.perShot;
    alloy.perShot += puncture.perShot * 1.15;
    alloy.perShot += slash.perShot * 0.5;
    alloy.perShot += fire.perShot;
    alloy.perShot += ice.perShot * 1.25;
    alloy.perShot += electric.perShot * 0.5;
    alloy.perShot += toxin.perShot;
    alloy.perShot += blast.perShot;
    alloy.perShot += magnetic.perShot * 0.5;
    alloy.perShot += gas.perShot;
    alloy.perShot += radiation.perShot * 1.75;
    alloy.perShot += corrosive.perShot;
    alloy.perShot += viral.perShot;
    
    mechanical.perShot += impact.perShot * 1.25;
    mechanical.perShot += puncture.perShot;
    mechanical.perShot += slash.perShot;
    mechanical.perShot += fire.perShot;
    mechanical.perShot += ice.perShot;
    mechanical.perShot += electric.perShot * 1.5;
    mechanical.perShot += toxin.perShot * 0.75;
    mechanical.perShot += blast.perShot * 1.75;
    mechanical.perShot += magnetic.perShot;
    mechanical.perShot += gas.perShot;
    mechanical.perShot += radiation.perShot;
    mechanical.perShot += corrosive.perShot;
    mechanical.perShot += viral.perShot * 0.75;
    
    corpusFlesh.perShot += impact.perShot * 0.75;
    corpusFlesh.perShot += puncture.perShot;
    corpusFlesh.perShot += slash.perShot * 1.25;
    corpusFlesh.perShot += fire.perShot;
    corpusFlesh.perShot += ice.perShot;
    corpusFlesh.perShot += electric.perShot;
    corpusFlesh.perShot += toxin.perShot * 1.5;
    corpusFlesh.perShot += blast.perShot;
    corpusFlesh.perShot += magnetic.perShot;
    corpusFlesh.perShot += gas.perShot * 0.75;
    corpusFlesh.perShot += radiation.perShot;
    corpusFlesh.perShot += corrosive.perShot;
    corpusFlesh.perShot += viral.perShot * 1.5;
    
    shield.perShot += impact.perShot * 1.5;
    shield.perShot += puncture.perShot * 0.85;
    shield.perShot += slash.perShot;
    shield.perShot += fire.perShot;
    shield.perShot += ice.perShot * 1.5;
    shield.perShot += electric.perShot;
    shield.perShot += toxin.perShot;
    shield.perShot += blast.perShot;
    shield.perShot += magnetic.perShot * 1.75;
    shield.perShot += gas.perShot;
    shield.perShot += radiation.perShot * 0.75;
    shield.perShot += corrosive.perShot;
    shield.perShot += viral.perShot;
    
    protoShield.perShot += impact.perShot * 1.15;
    protoShield.perShot += puncture.perShot * 0.5;
    protoShield.perShot += slash.perShot;
    protoShield.perShot += fire.perShot * 0.5;
    protoShield.perShot += ice.perShot;
    protoShield.perShot += electric.perShot;
    protoShield.perShot += toxin.perShot * 1.25;
    protoShield.perShot += blast.perShot;
    protoShield.perShot += magnetic.perShot * 1.75;
    protoShield.perShot += gas.perShot;
    protoShield.perShot += radiation.perShot;
    protoShield.perShot += corrosive.perShot * 0.5;
    protoShield.perShot += viral.perShot;
    
    robotic.perShot += impact.perShot;
    robotic.perShot += puncture.perShot * 1.25;
    robotic.perShot += slash.perShot * 0.75;
    robotic.perShot += fire.perShot;
    robotic.perShot += ice.perShot;
    robotic.perShot += electric.perShot * 1.5;
    robotic.perShot += toxin.perShot * 0.75;
    robotic.perShot += blast.perShot;
    robotic.perShot += magnetic.perShot;
    robotic.perShot += gas.perShot;
    robotic.perShot += radiation.perShot * 1.25;
    robotic.perShot += corrosive.perShot;
    robotic.perShot += viral.perShot;
    
    infestedFlesh.perShot += impact.perShot;
    infestedFlesh.perShot += puncture.perShot;
    infestedFlesh.perShot += slash.perShot * 1.5;
    infestedFlesh.perShot += fire.perShot * 1.5;
    infestedFlesh.perShot += ice.perShot * 0.5;
    infestedFlesh.perShot += electric.perShot;
    infestedFlesh.perShot += toxin.perShot;
    infestedFlesh.perShot += blast.perShot;
    infestedFlesh.perShot += magnetic.perShot;
    infestedFlesh.perShot += gas.perShot * 1.5;
    infestedFlesh.perShot += radiation.perShot;
    infestedFlesh.perShot += corrosive.perShot;
    infestedFlesh.perShot += viral.perShot;
    
    fossilized.perShot += impact.perShot;
    fossilized.perShot += puncture.perShot;
    fossilized.perShot += slash.perShot * 1.15;
    fossilized.perShot += fire.perShot;
    fossilized.perShot += ice.perShot * 0.75;
    fossilized.perShot += electric.perShot;
    fossilized.perShot += toxin.perShot * 0.5;
    fossilized.perShot += blast.perShot * 1.5;
    fossilized.perShot += magnetic.perShot;
    fossilized.perShot += gas.perShot;
    fossilized.perShot += radiation.perShot * 0.25;
    fossilized.perShot += corrosive.perShot * 1.75;
    fossilized.perShot += viral.perShot;
    
    sinew.perShot += impact.perShot;
    sinew.perShot += puncture.perShot * 1.25;
    sinew.perShot += slash.perShot;
    sinew.perShot += fire.perShot;
    sinew.perShot += ice.perShot * 1.25;
    sinew.perShot += electric.perShot;
    sinew.perShot += toxin.perShot;
    sinew.perShot += blast.perShot * 0.5;
    sinew.perShot += magnetic.perShot;
    sinew.perShot += gas.perShot;
    sinew.perShot += radiation.perShot * 1.5;
    sinew.perShot += corrosive.perShot;
    sinew.perShot += viral.perShot;
    
    //Calculate crit damage per shot values
    raw.critPerShot = raw.perShot * finalCritMult;
    impact.critPerShot = impact.perShot * finalCritMult;
    puncture.critPerShot = puncture.perShot * finalCritMult;
    slash.critPerShot = slash.perShot * finalCritMult;
    fire.critPerShot = fire.perShot * finalCritMult;
    ice.critPerShot = ice.perShot * finalCritMult;
    electric.critPerShot = electric.perShot * finalCritMult;
    toxin.critPerShot = toxin.perShot * finalCritMult;
    blast.critPerShot = blast.perShot * finalCritMult;
    magnetic.critPerShot = magnetic.perShot * finalCritMult;
    gas.critPerShot = gas.perShot * finalCritMult;
    radiation.critPerShot = radiation.perShot * finalCritMult;
    corrosive.critPerShot = corrosive.perShot * finalCritMult;
    viral.critPerShot = viral.perShot * finalCritMult;
    corpus.critPerShot = corpus.perShot * finalCritMult;
    grineer.critPerShot = grineer.perShot * finalCritMult;
    infested.critPerShot = infested.perShot * finalCritMult;
    cloneFlesh.critPerShot = cloneFlesh.perShot * finalCritMult;
    ferrite.critPerShot = ferrite.perShot * finalCritMult;
    alloy.critPerShot = alloy.perShot * finalCritMult;
    mechanical.critPerShot = mechanical.perShot * finalCritMult;
    corpusFlesh.critPerShot = corpusFlesh.perShot * finalCritMult;
    shield.critPerShot = shield.perShot * finalCritMult;
    protoShield.critPerShot = protoShield.perShot * finalCritMult;
    robotic.critPerShot = robotic.perShot * finalCritMult;
    infestedFlesh.critPerShot = infestedFlesh.perShot * finalCritMult;
    fossilized.critPerShot = fossilized.perShot * finalCritMult;
    sinew.critPerShot = sinew.perShot * finalCritMult;

    
    //Calculate first-shot damage
    raw.firstShot = raw.critPerShot * finalFirstShotDamageMult;
    impact.firstShot = impact.critPerShot * finalFirstShotDamageMult;
    puncture.firstShot = puncture.critPerShot * finalFirstShotDamageMult;
    slash.firstShot = slash.critPerShot * finalFirstShotDamageMult;
    fire.firstShot = fire.critPerShot * finalFirstShotDamageMult;
    ice.firstShot = ice.critPerShot * finalFirstShotDamageMult;
    electric.firstShot = electric.critPerShot * finalFirstShotDamageMult;
    toxin.firstShot = toxin.critPerShot * finalFirstShotDamageMult;
    blast.firstShot = blast.critPerShot * finalFirstShotDamageMult;
    magnetic.firstShot = magnetic.critPerShot * finalFirstShotDamageMult;
    gas.firstShot = gas.critPerShot * finalFirstShotDamageMult;
    radiation.firstShot = radiation.critPerShot * finalFirstShotDamageMult;
    corrosive.firstShot = corrosive.critPerShot * finalFirstShotDamageMult;
    viral.firstShot = viral.critPerShot * finalFirstShotDamageMult;
    corpus.firstShot = corpus.critPerShot * finalFirstShotDamageMult;
    grineer.firstShot = grineer.critPerShot * finalFirstShotDamageMult;
    infested.firstShot = infested.critPerShot * finalFirstShotDamageMult;
    cloneFlesh.firstShot = cloneFlesh.critPerShot * finalFirstShotDamageMult;
    ferrite.firstShot = ferrite.critPerShot * finalFirstShotDamageMult;
    alloy.firstShot = alloy.critPerShot * finalFirstShotDamageMult;
    mechanical.firstShot = mechanical.critPerShot * finalFirstShotDamageMult;
    corpusFlesh.firstShot = corpusFlesh.critPerShot * finalFirstShotDamageMult;
    shield.firstShot = shield.critPerShot * finalFirstShotDamageMult;
    protoShield.firstShot = protoShield.critPerShot * finalFirstShotDamageMult;
    robotic.firstShot = robotic.critPerShot * finalFirstShotDamageMult;
    infestedFlesh.firstShot = infestedFlesh.critPerShot * finalFirstShotDamageMult;
    fossilized.firstShot = fossilized.critPerShot * finalFirstShotDamageMult;
    sinew.firstShot = sinew.critPerShot * finalFirstShotDamageMult;
    
  }
  
  /**
   * Calculates the total damage done over an entire magazine
   */
  protected static void calculateDamagePerIteration(){
    raw.perIteration = (raw.perShot * finalNormalShots) + (raw.critPerShot * finalCritShots) + raw.firstShot;
    impact.perIteration = (impact.perShot * finalNormalShots) + (impact.critPerShot * finalCritShots) + impact.firstShot;
    puncture.perIteration = (puncture.perShot * finalNormalShots) + (puncture.critPerShot * finalCritShots) + puncture.firstShot;
    slash.perIteration = (slash.perShot * finalNormalShots) + (slash.critPerShot * finalCritShots) + slash.firstShot;
    fire.perIteration = (fire.perShot * finalNormalShots) + (fire.critPerShot * finalCritShots) + fire.firstShot;
    ice.perIteration = (ice.perShot * finalNormalShots) + (ice.critPerShot * finalCritShots) + ice.firstShot;
    electric.perIteration = (electric.perShot * finalNormalShots) + (electric.critPerShot * finalCritShots) + electric.firstShot;
    toxin.perIteration = (toxin.perShot * finalNormalShots) + (toxin.critPerShot * finalCritShots) + toxin.firstShot;
    blast.perIteration = (blast.perShot * finalNormalShots) + (blast.critPerShot * finalCritShots) + blast.firstShot;
    magnetic.perIteration = (magnetic.perShot * finalNormalShots) + (magnetic.critPerShot * finalCritShots) + magnetic.firstShot;
    gas.perIteration = (gas.perShot * finalNormalShots) + (gas.critPerShot * finalCritShots) + gas.firstShot;
    radiation.perIteration = (radiation.perShot * finalNormalShots) + (radiation.critPerShot * finalCritShots) + radiation.firstShot;
    corrosive.perIteration = (corrosive.perShot * finalNormalShots) + (corrosive.critPerShot * finalCritShots) + corrosive.firstShot;
    viral.perIteration = (viral.perShot * finalNormalShots) + (viral.critPerShot * finalCritShots) + viral.firstShot;
    corpus.perIteration = (corpus.perShot * finalNormalShots) + (corpus.critPerShot * finalCritShots) + corpus.firstShot;
    grineer.perIteration = (grineer.perShot * finalNormalShots) + (grineer.critPerShot * finalCritShots) + grineer.firstShot;
    infested.perIteration = (infested.perShot * finalNormalShots) + (infested.critPerShot * finalCritShots) + infested.firstShot;
    cloneFlesh.perIteration = (cloneFlesh.perShot * finalNormalShots) + (cloneFlesh.critPerShot * finalCritShots) + cloneFlesh.firstShot;
    ferrite.perIteration = (ferrite.perShot * finalNormalShots) + (ferrite.critPerShot * finalCritShots) + ferrite.firstShot;
    alloy.perIteration = (alloy.perShot * finalNormalShots) + (alloy.critPerShot * finalCritShots) + alloy.firstShot;
    mechanical.perIteration = (mechanical.perShot * finalNormalShots) + (mechanical.critPerShot * finalCritShots) + mechanical.firstShot;
    corpusFlesh.perIteration = (corpusFlesh.perShot * finalNormalShots) + (corpusFlesh.critPerShot * finalCritShots) + corpusFlesh.firstShot;
    shield.perIteration = (shield.perShot * finalNormalShots) + (shield.critPerShot * finalCritShots) + shield.firstShot;
    protoShield.perIteration = (protoShield.perShot * finalNormalShots) + (protoShield.critPerShot * finalCritShots) + protoShield.firstShot;
    robotic.perIteration = (robotic.perShot * finalNormalShots) + (robotic.critPerShot * finalCritShots) + robotic.firstShot;
    infestedFlesh.perIteration = (infestedFlesh.perShot * finalNormalShots) + (infestedFlesh.critPerShot * finalCritShots) + infestedFlesh.firstShot;
    fossilized.perIteration = (fossilized.perShot * finalNormalShots) + (fossilized.critPerShot * finalCritShots) + fossilized.firstShot;
    sinew.perIteration = (sinew.perShot * finalNormalShots) + (sinew.critPerShot * finalCritShots) + sinew.firstShot;
    
  }
  
  /** 
   * Calculates the total damage dealt over a given minute.
   */
  protected static void calculateDamagePerMinute(){
    raw.perMinute = raw.perIteration * finalIterationsPerMinute;
    impact.perMinute = impact.perIteration * finalIterationsPerMinute;
    puncture.perMinute = puncture.perIteration * finalIterationsPerMinute;
    slash.perMinute = slash.perIteration * finalIterationsPerMinute;
    fire.perMinute = fire.perIteration * finalIterationsPerMinute;
    ice.perMinute = ice.perIteration * finalIterationsPerMinute;
    electric.perMinute = electric.perIteration * finalIterationsPerMinute;
    toxin.perMinute = toxin.perIteration * finalIterationsPerMinute;
    blast.perMinute = blast.perIteration * finalIterationsPerMinute;
    magnetic.perMinute = magnetic.perIteration * finalIterationsPerMinute;
    gas.perMinute = gas.perIteration * finalIterationsPerMinute;
    radiation.perMinute = radiation.perIteration * finalIterationsPerMinute;
    corrosive.perMinute = corrosive.perIteration * finalIterationsPerMinute;
    viral.perMinute = viral.perIteration * finalIterationsPerMinute;
    corpus.perMinute = corpus.perIteration * finalIterationsPerMinute;
    grineer.perMinute = grineer.perIteration * finalIterationsPerMinute;
    infested.perMinute = infested.perIteration * finalIterationsPerMinute;
    cloneFlesh.perMinute = cloneFlesh.perIteration * finalIterationsPerMinute;
    ferrite.perMinute = ferrite.perIteration * finalIterationsPerMinute;
    alloy.perMinute = alloy.perIteration * finalIterationsPerMinute;
    mechanical.perMinute = mechanical.perIteration * finalIterationsPerMinute;
    corpus.perMinute = corpusFlesh.perIteration * finalIterationsPerMinute;
    shield.perMinute = shield.perIteration * finalIterationsPerMinute;
    protoShield.perMinute = protoShield.perIteration * finalIterationsPerMinute;
    robotic.perMinute = robotic.perIteration * finalIterationsPerMinute;
    infestedFlesh.perMinute = infestedFlesh.perIteration * finalIterationsPerMinute;
    fossilized.perMinute = fossilized.perIteration * finalIterationsPerMinute;
    sinew.perMinute = sinew.perIteration * finalIterationsPerMinute;
  }
  
  protected static void calculateDamagePerSecond(){
    //Calculate base DPS values
    raw.perSecond = raw.perMinute / 60.0;
    impact.perSecond = impact.perMinute / 60.0;
    puncture.perSecond = puncture.perMinute / 60.0;
    slash.perSecond = slash.perMinute / 60.0;
    fire.perSecond = fire.perMinute / 60.0;
    ice.perSecond = ice.perMinute / 60.0;
    electric.perSecond = electric.perMinute / 60.0;
    toxin.perSecond = toxin.perMinute / 60.0;
    blast.perSecond = blast.perMinute / 60.0;
    magnetic.perSecond = magnetic.perMinute / 60.0;
    gas.perSecond = gas.perMinute / 60.0;
    radiation.perSecond = radiation.perMinute / 60.0;
    corrosive.perSecond = corrosive.perMinute / 60.0;
    viral.perSecond = viral.perMinute / 60.0;
    corpus.perSecond = corpus.perMinute / 60.0;
    grineer.perSecond = grineer.perMinute / 60.0;
    infested.perSecond = infested.perMinute / 60.0;
    cloneFlesh.perSecond = cloneFlesh.perMinute / 60.0;
    ferrite.perSecond = ferrite.perMinute / 60.0;
    alloy.perSecond = alloy.perMinute / 60.0;
    mechanical.perSecond = mechanical.perMinute / 60.0;
    corpusFlesh.perSecond = corpus.perMinute / 60.0;
    shield.perSecond = shield.perMinute / 60.0;
    protoShield.perSecond = protoShield.perMinute / 60.0;
    robotic.perSecond = robotic.perMinute / 60.0;
    infestedFlesh.perSecond = infestedFlesh.perMinute / 60.0;
    fossilized.perSecond = fossilized.perMinute / 60.0;
    sinew.perSecond = sinew.perMinute / 60.0;
    
    //Add in DoTs
    double rawBase = ((raw.base * finalDamageMult) * finalProjectileCount) * finalDeadAimMult;
    double critBase = rawBase * finalCritMult;
    double DoTBase = (((rawBase * finalNormalShots) + (critBase * finalCritShots) + raw.firstShot) / finalMag);
    double bleedDamage =  DoTBase * 0.35;
    double poisonDamage = DoTBase * 0.5;
    if(poisonDamage < 10.0){
      poisonDamage = 10.0;
    }
    double heatDamage = DoTBase * 0.5;
    double cloudDamage = DoTBase * 0.5;
    if(cloudDamage < 10.0){
      cloudDamage = 10.0;
    }
    double bleedDoTDPS = slashStacks * bleedDamage;
    double poisonDoTDPS = toxinStacks * poisonDamage;
    double heatDoTDPS = fireStacks * heatDamage;
    double cloudDoTDPS = gasStacks * cloudDamage;
    double electricProcDPS = procsPerSecond * DoTBase;
    double DotTotal = bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS;
    raw.perSecond += DotTotal;
    corpus.perSecond += DotTotal;
    grineer.perSecond += DotTotal;
    infested.perSecond += DotTotal;
    cloneFlesh.perSecond += DotTotal;
    ferrite.perSecond += DotTotal;
    alloy.perSecond += DotTotal;
    mechanical.perSecond += DotTotal;
    corpusFlesh.perSecond += DotTotal;
    shield.perSecond += DotTotal;
    protoShield.perSecond += DotTotal;
    robotic.perSecond += DotTotal;
    infestedFlesh.perSecond += DotTotal;
    fossilized.perSecond += DotTotal;
    sinew.perSecond += DotTotal;
  }
  
  protected static void calculateBurstDamagePerSecond(){
    //Calculate base Burst DPS values
    double burstTime = (60.0 / (finalIterationTime - finalReloadTime)) / 60.0;
    raw.rawPerSecond = raw.perIteration * burstTime;
    impact.rawPerSecond = impact.perIteration * burstTime;
    puncture.rawPerSecond = puncture.perIteration * burstTime;
    slash.rawPerSecond = slash.perIteration * burstTime;
    fire.rawPerSecond = fire.perIteration * burstTime;
    ice.rawPerSecond = ice.perIteration * burstTime;
    electric.rawPerSecond = electric.perIteration * burstTime;
    toxin.rawPerSecond = toxin.perIteration * burstTime;
    blast.rawPerSecond = blast.perIteration * burstTime;
    magnetic.rawPerSecond = magnetic.perIteration * burstTime;
    gas.rawPerSecond = gas.perIteration * burstTime;
    radiation.rawPerSecond = radiation.perIteration * burstTime;
    corrosive.rawPerSecond = corrosive.perIteration * burstTime;
    viral.rawPerSecond = viral.perIteration * burstTime;
    corpus.rawPerSecond = corpus.perIteration * burstTime;
    grineer.rawPerSecond = grineer.perIteration * burstTime;
    cloneFlesh.rawPerSecond = cloneFlesh.perIteration * burstTime;
    infested.rawPerSecond = infested.perIteration * burstTime;
    ferrite.rawPerSecond = ferrite.perIteration * burstTime;
    alloy.rawPerSecond = alloy.perIteration * burstTime;
    mechanical.rawPerSecond = mechanical.perIteration * burstTime;
    corpusFlesh.rawPerSecond = corpusFlesh.perIteration * burstTime;
    shield.rawPerSecond = shield.perIteration * burstTime;
    protoShield.rawPerSecond = protoShield.perIteration * burstTime;
    robotic.rawPerSecond = robotic.perIteration * burstTime;
    infestedFlesh.rawPerSecond = infestedFlesh.perIteration * burstTime;
    fossilized.rawPerSecond = fossilized.perIteration * burstTime;
    sinew.rawPerSecond = sinew.perIteration * burstTime;
    
    //Add in DoTs
    double rawBase = ((raw.base * finalDamageMult) * finalProjectileCount) * finalDeadAimMult;
    double critBase = rawBase * finalCritMult;
    double DoTBase = (((rawBase * finalNormalShots) + (critBase * finalCritShots) + raw.firstShot) / finalMag);
    double bleedDamage =  DoTBase * 0.35;
    double poisonDamage = DoTBase * 0.5;
    if(poisonDamage < 10.0){
      poisonDamage = 10.0;
    }
    double heatDamage = DoTBase * 0.5;
    double cloudDamage = DoTBase * 0.5;
    if(cloudDamage < 10.0){
      cloudDamage = 10.0;
    }
    double bleedDoTDPS = slashStacks * bleedDamage;
    double poisonDoTDPS = toxinStacks * poisonDamage;
    double heatDoTDPS = fireStacks * heatDamage;
    double cloudDoTDPS = gasStacks * cloudDamage;
    double electricProcDPS = procsPerSecond * DoTBase;
    double DotTotal = bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS;
    raw.rawPerSecond += DotTotal;
    corpus.rawPerSecond += DotTotal;
    grineer.rawPerSecond += DotTotal;
    infested.rawPerSecond += DotTotal;
    cloneFlesh.rawPerSecond += DotTotal;
    ferrite.rawPerSecond += DotTotal;
    alloy.rawPerSecond += DotTotal;
    mechanical.rawPerSecond += DotTotal;
    corpusFlesh.rawPerSecond += DotTotal;
    shield.rawPerSecond += DotTotal;
    protoShield.rawPerSecond += DotTotal;
    robotic.rawPerSecond += DotTotal;
    infestedFlesh.rawPerSecond += DotTotal;
    fossilized.rawPerSecond += DotTotal;
    sinew.rawPerSecond += DotTotal;
  }
  
  /**
   * Calculates the average number of stacks of a given effect
   */
  protected static int calculateAverageStacks(double procRate, double duration){
    
    double millisceondsPerShot = 1000.0 / finalFireRate;
    double stacksPerShot = 1.0 * procRate;
    double reloadTimeMilliseconds = finalReloadTime * 1000.0;
    double stackTotal = 0.0;
    double moddedDuration = duration * finalStatusDuration;
    int averageStacks = 0;
    int reloadTimeCounter = 0;
    int shotCounter = 0;
    int iterations = 0;
    boolean reloading = false;
    Vector<Double> stackVec = new Vector<Double>();
    Vector<Integer> stackCountVec = new Vector<Integer>();
    
    //Run a 60 second simulation to calculate the average number of stacks
    for(int i=0; i < 60000; i++){
      //Add new stack
      if(!reloading){
        shotCounter++;
        //is it time to fire a new projectile?
        if(shotCounter >= millisceondsPerShot){
          //Add stacks
          for(int p = 0; p < finalProjectileCount; p++){
            stackTotal += stacksPerShot;
            if(stackTotal > 1.0){
              stackVec.add(moddedDuration);
              stackTotal--;
            }
          }
          shotCounter = 0;
          //Have we unloaded the whole mag and need to reload?
          iterations++;
          if(iterations >= finalMag){
            reloading = true;
            iterations = 0;
          }
        }
      }else{
        //Are we still reloading?
        reloadTimeCounter++;
        if(reloadTimeCounter >= reloadTimeMilliseconds){
          reloading = false;
          reloadTimeCounter = 0;
        }
      }
      //Is this a whole second?
      if(i % 1000 == 0){
        //Decrement stack timers
        for(int j=0;j<stackVec.size();j++){
          double temp = stackVec.get(j);
          temp--;
          stackVec.set(j, temp);
        }
        //Remove stacks that have expired
        for(int k=0;k<stackVec.size();k++){
          if(stackVec.get(k) <= 0){
            stackVec.remove(k);
          }
        }
        //Add a new count to the stack counting vector
        stackCountVec.add(stackVec.size());
      }
    }
    
    for(int i = 0; i < stackCountVec.size(); i++){
      averageStacks += stackCountVec.get(i);
    }
    averageStacks /= stackCountVec.size();
    return averageStacks;
  }
  
  
  
  /**
   * Appends the weapon information to the output text area
   */
  protected static void updateOutput(){
    //Append to Output
    DecimalFormat f = new DecimalFormat("#.###");
    output.append("\n");
    output.append("\n_____________________________________________________________");
    output.append("\nName :: "+weaponName);
    output.append("\nMagazine Size :: "+finalMag);
    output.append("\nTotal Ammo :: "+(finalMag+finalAmmo));
    output.append("\nCrit Chance :: "+f.format(finalCritChance*100.0)+"%");
    output.append("\nCrit Damage Multiplier :: "+f.format(finalCritMult*100.0)+"%");
    String delimiter = "rounds";
    String mode = selectedWeapon.getWeaponMode();
    if(mode.equals(Constants.BURST)){
      delimiter = "bursts";
    }else if(mode.equals(Constants.CONTINUOUS)){
      delimiter = "ammo drain";
    }
    output.append("\nFire Rate :: "+f.format(finalFireRate)+" "+delimiter+" per second");
    output.append("\nReload Time :: "+f.format(finalReloadTime)+" seconds");
    output.append("\nStatus Chance :: "+f.format(finalStatusChance*100.0)+"%");
    output.append("\nProjectiles Per Shot :: "+f.format(finalProjectileCount));
    output.append("\nStatus Procs Per Second :: "+f.format(procsPerSecond));
    output.append("\nBurst Status Procs Per Second :: "+f.format(burstProcsPerSecond));
    output.append("\nTime to Empty magazine :: "+f.format(finalIterationTime-finalReloadTime)+" seconds");
    if(slashStacks > 0){
      output.append("\nAverage Bleed Stacks :: "+slashStacks);
    }
    if(toxinStacks > 0){
      output.append("\nAverage Poison Stacks :: "+toxinStacks);
    }
    if(gasStacks > 0){
      output.append("\nAverage Poison Cloud Stacks :: "+gasStacks);
    }
    if(fireStacks > 0){
      output.append("\nAverage Burning Stacks :: "+fireStacks);
    }
    output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    output.append("\nRaw Damage Per Shot :: "+f.format(raw.perShot));
    if(impact.perShot > 0.0){
      output.append("\nImpact Damage Per Shot :: "+f.format(impact.perShot));
    }
    if(puncture.perShot > 0.0){
      output.append("\nPuncture Damage Per Shot :: "+f.format(puncture.perShot));
    }
    if(slash.perShot > 0.0){
      output.append("\nSlash Damage Per Shot :: "+f.format(slash.perShot));
    }
    if(fire.perShot > 0.0){
      output.append("\nFire Damage Per Shot :: "+f.format(fire.perShot));
    }
    if(ice.perShot > 0.0){
      output.append("\nIce Damage Per Shot :: "+f.format(ice.perShot));
    }
    if(electric.perShot > 0.0){
      output.append("\nElectric Damage Per Shot :: "+f.format(electric.perShot));
    }
    if(toxin.perShot > 0.0){
      output.append("\nToxin Damage Per Shot :: "+f.format(toxin.perShot));
    }
    if(blast.perShot > 0.0){
      output.append("\nBlast Damage Per Shot :: "+f.format(blast.perShot));
    }
    if(magnetic.perShot > 0.0){
      output.append("\nMagnetic Damage Per Shot :: "+f.format(magnetic.perShot));
    }
    if(gas.perShot > 0.0){
      output.append("\nGas Damage Per Shot :: "+f.format(gas.perShot));
    }
    if(radiation.perShot > 0.0){
      output.append("\nRadiation Damage Per Shot :: "+f.format(radiation.perShot));
    }
    if(corrosive.perShot > 0.0){
      output.append("\nCorrosive Damage Per Shot :: "+f.format(corrosive.perShot));
    }
    if(viral.perShot > 0.0){
      output.append("\nViral Damage Per Shot :: "+f.format(viral.perShot));
    }
    output.append("\nDamage Per Shot to Clone Flesh :: "+f.format(cloneFlesh.perShot));
    output.append("\nDamage Per Shot to Ferrite Armor :: "+f.format(ferrite.perShot));
    output.append("\nDamage Per Shot to Alloy Armor :: "+f.format(alloy.perShot));
    output.append("\nDamage Per Shot to Mechanical :: "+f.format(mechanical.perShot));
    output.append("\nDamage Per Shot to Corpus Flesh :: "+f.format(corpusFlesh.perShot));
    output.append("\nDamage Per Shot to Shield :: "+f.format(shield.perShot));
    output.append("\nDamage Per Shot to Proto Shield :: "+f.format(protoShield.perShot));
    output.append("\nDamage Per Shot to Robotic :: "+f.format(robotic.perShot));
    output.append("\nDamage Per Shot to Infested Flesh :: "+f.format(infestedFlesh.perShot));
    output.append("\nDamage Per Shot to Fossilized :: "+f.format(fossilized.perShot));
    output.append("\nDamage Per Shot to Sinew :: "+f.format(sinew.perShot));
    output.append("\nDamage Per Shot to Corpus :: "+f.format(corpus.perShot));
    output.append("\nDamage Per Shot to Grineer :: "+f.format(grineer.perShot));
    output.append("\nDamage Per Shot to Infested :: "+f.format(infested.perShot));
    output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    output.append("\nRaw Crit Damage Per Shot :: "+f.format(raw.critPerShot));
    if(impact.critPerShot > 0.0){
      output.append("\nImpact Crit Damage Per Shot :: "+f.format(impact.critPerShot));
    }
    if(puncture.critPerShot > 0.0){
      output.append("\nPuncture Crit Damage Per Shot :: "+f.format(puncture.critPerShot));
    }
    if(slash.critPerShot > 0.0){
      output.append("\nSlash Crit Damage Per Shot :: "+f.format(slash.critPerShot));
    }
    if(fire.critPerShot > 0.0){
      output.append("\nFire Crit Damage Per Shot :: "+f.format(fire.critPerShot));
    }
    if(ice.critPerShot > 0.0){
      output.append("\nIce Crit Damage Per Shot :: "+f.format(ice.critPerShot));
    }
    if(electric.critPerShot > 0.0){
      output.append("\nElectric Crit Damage Per Shot :: "+f.format(electric.critPerShot));
    }
    if(toxin.critPerShot > 0.0){
      output.append("\nToxin Crit Damage Per Shot :: "+f.format(toxin.critPerShot));
    }
    if(blast.critPerShot > 0.0){
      output.append("\nBlast Crit Damage Per Shot :: "+f.format(blast.critPerShot));
    }
    if(magnetic.critPerShot > 0.0){
      output.append("\nMagnetic Crit Damage Per Shot :: "+f.format(magnetic.critPerShot));
    }
    if(gas.critPerShot > 0.0){
      output.append("\nGas Crit Damage Per Shot :: "+f.format(gas.critPerShot));
    }
    if(radiation.critPerShot > 0.0){
      output.append("\nRadiation Crit Damage Per Shot :: "+f.format(radiation.critPerShot));
    }
    if(corrosive.critPerShot > 0.0){
      output.append("\nCorrosive Crit Damage Per Shot :: "+f.format(corrosive.critPerShot));
    }
    if(viral.critPerShot > 0.0){
      output.append("\nViral Crit Damage Per Shot :: "+f.format(viral.critPerShot));
    }
    output.append("\nCrit Damage Per Shot to Clone Flesh :: "+f.format(cloneFlesh.critPerShot));
    output.append("\nCrit Damage Per Shot to Ferrite Armor :: "+f.format(ferrite.critPerShot));
    output.append("\nCrit Damage Per Shot to Alloy Armor :: "+f.format(alloy.critPerShot));
    output.append("\nCrit Damage Per Shot to Mechanical :: "+f.format(mechanical.critPerShot));
    output.append("\nCrit Damage Per Shot to Corpus Flesh :: "+f.format(corpusFlesh.critPerShot));
    output.append("\nCrit Damage Per Shot to Shield :: "+f.format(shield.critPerShot));
    output.append("\nCrit Damage Per Shot to Proto Shield :: "+f.format(protoShield.critPerShot));
    output.append("\nCrit Damage Per Shot to Robotic :: "+f.format(robotic.critPerShot));
    output.append("\nCrit Damage Per Shot to Infested Flesh :: "+f.format(infestedFlesh.critPerShot));
    output.append("\nCrit Damage Per Shot to Fossilized :: "+f.format(fossilized.critPerShot));
    output.append("\nCrit Damage Per Shot to Sinew :: "+f.format(sinew.critPerShot));
    output.append("\nCrit Damage Per Shot to Corpus :: "+f.format(corpus.critPerShot));
    output.append("\nCrit Damage Per Shot to Grineer :: "+f.format(grineer.critPerShot));
    output.append("\nCrit Damage Per Shot to Infested :: "+f.format(infested.critPerShot));
    if(finalFirstShotDamageMult > 1.0){
      output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
      output.append("\nRaw First Shot Damage :: "+f.format(raw.firstShot));
      if(impact.firstShot > 0.0){
        output.append("\nImpact First Shot Damage :: "+f.format(impact.firstShot));
      }
      if(puncture.firstShot > 0.0){
        output.append("\nPuncture First Shot Damage :: "+f.format(puncture.firstShot));
      }
      if(slash.firstShot > 0.0){
        output.append("\nSlash First Shot Damage :: "+f.format(slash.firstShot));
      }
      if(fire.firstShot > 0.0){
        output.append("\nFire First Shot Damage :: "+f.format(fire.firstShot));
      }
      if(ice.firstShot > 0.0){
        output.append("\nIce First Shot Damage :: "+f.format(ice.firstShot));
      }
      if(electric.firstShot > 0.0){
        output.append("\nElectric First Shot Damage :: "+f.format(electric.firstShot));
      }
      if(toxin.firstShot > 0.0){
        output.append("\nToxin First Shot Damage :: "+f.format(toxin.firstShot));
      }
      if(blast.firstShot > 0.0){
        output.append("\nBlast First Shot Damage :: "+f.format(blast.firstShot));
      }
      if(magnetic.firstShot > 0.0){
        output.append("\nMagnetic First Shot Damage :: "+f.format(magnetic.firstShot));
      }
      if(gas.firstShot > 0.0){
        output.append("\nGas First Shot Damage :: "+f.format(gas.firstShot));
      }
      if(radiation.firstShot > 0.0){
        output.append("\nRadiation First Shot Damage :: "+f.format(radiation.firstShot));
      }
      if(corrosive.firstShot > 0.0){
        output.append("\nCorrosive First Shot Damage :: "+f.format(corrosive.firstShot));
      }
      if(viral.firstShot > 0.0){
        output.append("\nViral First Shot Damage :: "+f.format(viral.firstShot));
      }
      output.append("\nFirst Shot Damage to Clone Flesh :: "+f.format(cloneFlesh.firstShot));
      output.append("\nFirst Shot Damage to Ferrite Armor :: "+f.format(ferrite.firstShot));
      output.append("\nFirst Shot Damage to Alloy Armor :: "+f.format(alloy.firstShot));
      output.append("\nFirst Shot Damage to Mechanical :: "+f.format(mechanical.firstShot));
      output.append("\nFirst Shot Damage to Corpus Flesh :: "+f.format(corpusFlesh.firstShot));
      output.append("\nFirst Shot Damage to Shield :: "+f.format(shield.firstShot));
      output.append("\nFirst Shot Damage to Proto Shield :: "+f.format(protoShield.firstShot));
      output.append("\nFirst Shot Damage to Robotic :: "+f.format(robotic.firstShot));
      output.append("\nFirst Shot Damage to Infested Flesh :: "+f.format(infestedFlesh.firstShot));
      output.append("\nFirst Shot Damage to Fossilized :: "+f.format(fossilized.firstShot));
      output.append("\nFirst Shot Damage to Sinew :: "+f.format(sinew.firstShot));
      output.append("\nFirst Shot Damage to Corpus :: "+f.format(corpus.firstShot));
      output.append("\nFirst Shot Damage to Grineer :: "+f.format(grineer.firstShot));
      output.append("\nFirst Shot Damage to Infested :: "+f.format(infested.firstShot));
    }
    output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    output.append("\nRaw Damage Per Second :: "+f.format(raw.perSecond));
    output.append("\nDamage Per Second to Clone Flesh :: "+f.format(cloneFlesh.perSecond));
    output.append("\nDamage Per Second to Ferrite Armor :: "+f.format(ferrite.perSecond));
    output.append("\nDamage Per Second to Alloy Armor :: "+f.format(alloy.perSecond));
    output.append("\nDamage Per Second to Mechanical :: "+f.format(mechanical.perSecond));
    output.append("\nDamage Per Second to Corpus Flesh :: "+f.format(corpusFlesh.perSecond));
    output.append("\nDamage Per Second to Shield :: "+f.format(shield.perSecond));
    output.append("\nDamage Per Second to Proto Shield :: "+f.format(protoShield.perSecond));
    output.append("\nDamage Per Second to Robotic :: "+f.format(robotic.perSecond));
    output.append("\nDamage Per Second to Infested Flesh :: "+f.format(infestedFlesh.perSecond));
    output.append("\nDamage Per Second to Fossilized :: "+f.format(fossilized.perSecond));
    output.append("\nDamage Per Second to Sinew :: "+f.format(sinew.perSecond));
    output.append("\nDamage Per Second to Corpus :: "+f.format(corpus.perSecond));
    output.append("\nDamage Per Second to Grineer :: "+f.format(grineer.perSecond));
    output.append("\nDamage Per Second to Infested :: "+f.format(infested.perSecond));
    output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    output.append("\nRaw Burst Damage Per Second :: "+f.format(raw.rawPerSecond));
    output.append("\nBurst Damage Per Second to Clone Flesh :: "+f.format(cloneFlesh.rawPerSecond));
    output.append("\nBurst Damage Per Second to Ferrite Armor :: "+f.format(ferrite.rawPerSecond));
    output.append("\nBurst Damage Per Second to Alloy Armor :: "+f.format(alloy.rawPerSecond));
    output.append("\nBurst Damage Per Second to Mechanical :: "+f.format(mechanical.rawPerSecond));
    output.append("\nBurst Damage Per Second to Corpus Flesh :: "+f.format(corpusFlesh.rawPerSecond));
    output.append("\nBurst Damage Per Second to Shield :: "+f.format(shield.rawPerSecond));
    output.append("\nBurst Damage Per Second to Proto Shield :: "+f.format(protoShield.rawPerSecond));
    output.append("\nBurst Damage Per Second to Robotic :: "+f.format(robotic.rawPerSecond));
    output.append("\nBurst Damage Per Second to Infested Flesh :: "+f.format(infestedFlesh.rawPerSecond));
    output.append("\nBurst Damage Per Second to Fossilized :: "+f.format(fossilized.rawPerSecond));
    output.append("\nBurst Damage Per Second to Sinew :: "+f.format(sinew.rawPerSecond));
    output.append("\nBurst Damage Per Second to Corpus :: "+f.format(corpus.rawPerSecond));
    output.append("\nBurst Damage Per Second to Grineer :: "+f.format(grineer.rawPerSecond));
    output.append("\nBurst Damage Per Second to Infested :: "+f.format(infested.rawPerSecond));
    
    output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    output.append(selectedWeapon.getModsOutput());
    output.append("\nCorrosive Projections: "+corrosiveProjectionBox.getSelectedItem());
    if(useComplexTTK){
      output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
      String ttkTableHeader = "\nTarget Name";
      Font font = Main.output.getFont();
      FontMetrics metric = Main.output.getFontMetrics(font);
      int spaceWidth = metric.stringWidth(".");
      int nameFieldWidth = metric.stringWidth(longestTTKName);
      double nameDiff = (nameFieldWidth - metric.stringWidth("Target Name"))/spaceWidth;
      nameDiff = Math.ceil(nameDiff);
      nameDiff += 2;
      for(int i = 0; i < nameDiff; i++){
        ttkTableHeader += ".";
      }
      ttkTableHeader += "|........TTK.......|....MinTTK.....|....MaxTTK";
      output.append(ttkTableHeader);
      String ttkTableSep = "\n";
      spaceWidth = metric.stringWidth("-");
      int headerWidth = metric.stringWidth(ttkTableHeader);
      int headerLength = headerWidth/spaceWidth;
      for(int i = 0; i < headerLength; i++){
        ttkTableSep += "-";
      }
      output.append(ttkTableSep);
      int targetGroup = Integer.parseInt((String)targetGroupBox.getSelectedItem());
      Vector<TTKTarget> groupTargets = new Vector<TTKTarget>();
      for(TTKTarget target: theTTKManager.targets){
        if(target.group == targetGroup){
          groupTargets.add(target);
        }
      }
      Vector<TTKNamePair> TTKGraphVec = new Vector<TTKNamePair>();
      for(TTKTarget target : groupTargets){
        output.append(target.printAdvancedData());
        TTKGraphVec.add(target.getTTKNamePair());
      }
      //Update the TTK Graph
      ttkGraph.updateGraph(TTKGraphVec);
    }
    
    //Update the DPS Graph
    dpsGraph.updateDPS( raw.perSecond, 
                        cloneFlesh.perSecond, 
                        ferrite.perSecond, 
                        alloy.perSecond, 
                        mechanical.perSecond, 
                        corpusFlesh.perSecond, 
                        shield.perSecond, 
                        protoShield.perSecond, 
                        robotic.perSecond, 
                        infestedFlesh.perSecond, 
                        fossilized.perSecond, 
                        sinew.perSecond, 
                        infested.perSecond, 
                        grineer.perSecond, 
                        corpus.perSecond);
  }
  
  /**
   * Method to display the mod manager
   */
  protected static void displayModManager(){
    
    if(!modManagerInit){
      modManagerInit = true;
      theModManager.Init();
      modManagerFrame.add(theModManager);
      modManagerFrame.pack();
      modManagerFrame.addWindowListener(new ModWindowListener());
      modManagerFrame.setTitle("Mod Manager");
      modManagerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    modManagerFrame.setVisible(true);
  }
  
  /**
   * Method to display the weapon manager
   */
  protected static void displayWeaponManager(){
    
    if(!weaponManagerInit){
      weaponManagerInit = true;
      weaponManagerFrame.add(theWeaponManager);
      weaponManagerFrame.pack();
      weaponManagerFrame.addWindowListener(new WeaponWindowListener());
      weaponManagerFrame.setTitle("Weapon Manager");
      weaponManagerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    weaponManagerFrame.setVisible(true);
  }
  
  /**
   * Method to display the target manager
   */
  protected static void displayTargetManager(){
    if(!targetManagerInit){
      targetManagerInit = true;
      targetManagerFrame.add(theTTKManager);
      targetManagerFrame.pack();
      targetManagerFrame.addWindowListener(new TTKWindowListener());
      targetManagerFrame.setTitle("Target Manager");
      targetManagerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    targetManagerFrame.setVisible(true);
  }
  
  /**
   * Method to display the color options manager
   */
  protected static void displayColorOptions(){
    if(!colorOptionsInit){
      colorOptionsInit = true;
      colorOptionsFrame.add(theColorPanel);
      colorOptionsFrame.pack();
      colorOptionsFrame.setTitle("Color Options");
      colorOptionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    colorOptionsFrame.setVisible(true);
  }
  
  /**
   * Method to toggle the enabled state of the mod manager menu item
   */
  protected static void updateModMenuState(boolean enabled){
    modMenu.setEnabled(enabled);
  }
  
  /**
   * Method to toggle the enabled state of the target manager menu item
   */
  protected static void updateTTKMenuState(boolean enabled){
    TTKMenu.setEnabled(enabled);
  }
  
  /**
   * Method to toggle the enabled state of the weapon manager menu item
   */
  protected static void updateWeaponMenuState(boolean enabled){
    weaponMenu.setEnabled(enabled);
  }
  
  /**
   * ____________________________________________________________
   * INTERNAL CLASSES
   * ____________________________________________________________
   */
  
  /**
   * Action Listener Local Class
   * @author GottFuast
   *
   */
  protected static class MainActionListener implements ActionListener{
    /**
     * Default CTOR
     */
    public MainActionListener(){
      //Do Nothing
    }
    
    /**
     * Action Listener Callback
     */
    public void actionPerformed(ActionEvent e) {
      if(e.getSource().equals(calculateButton)){
        calculateDPS();
      }else if(e.getSource().equals(TTKBox) || e.getSource().equals(lightWeightTTKBox)){
        useComplexTTK = (TTKBox.isSelected() || lightWeightTTKBox.isSelected());
        if(e.getSource().equals(TTKBox)){
          if(lightWeightTTKBox.isSelected()){
            lightWeightTTKBox.setSelected(false);
          }
        }else{
          if(TTKBox.isSelected()){
            TTKBox.setSelected(false);
          }
          
        }
        if(useComplexTTK){
          if(e.getSource().equals(TTKBox)){
            complexTTKIterations = 10000;
          }else{
            complexTTKIterations = 1000;
          }
        }
      }else if(e.getSource().equals(targetGroupBox)){
        ttkGraph.clear();
      }else if(e.getSource().equals(clearButton)){
        riflePanel.clear();
        shotgunPanel.clear();
        pistolPanel.clear();
        output.setText("");
        dpsGraph.clear();
        ttkGraph.clear();
      }else if(e.getSource().equals(clearOutputButton)){
        output.setText("");
        dpsGraph.clear();
        ttkGraph.clear();
      }else if(e.getSource().equals(loadItem)){
        int returnVal = chooser.showOpenDialog(mainPanel);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
          riflePanel.clear();
          shotgunPanel.clear();
          pistolPanel.clear();
          //output.setText("");
          //graph.clear();
          clearValues();
          File file = chooser.getSelectedFile();
          try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String header = reader.readLine();
            reader.close();
            if(header.equals(Constants.RIFLE)){
              weaponPane.setSelectedIndex(weaponPane.indexOfTab(Constants.RIFLE));
              riflePanel.loadFromFile(file);
            }else if(header.equals(Constants.PISTOL)){
              weaponPane.setSelectedIndex(weaponPane.indexOfTab(Constants.PISTOL));
              pistolPanel.loadFromFile(file);
            }else if(header.equals(Constants.SHOTGUN)){
              weaponPane.setSelectedIndex(weaponPane.indexOfTab(Constants.SHOTGUN));
              shotgunPanel.loadFromFile(file);
            }else if(header.equals(Constants.ARCGUN)){
              weaponPane.setSelectedIndex(weaponPane.indexOfTab(Constants.ARCGUN));
              arcGunPanel.loadFromFile(file);
            }
          } catch (Exception ex) {
            //Do Nothing
          }
        } else {
          //Do Nothing
        }
      }else if(e.getSource().equals(saveItem)){
        int returnVal = chooser.showSaveDialog(mainPanel);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
          File file = chooser.getSelectedFile();
          if(!file.getAbsolutePath().endsWith(".wdc")){
            file = new File(file.getAbsolutePath()+".wdc");
          }
          WeaponPanel selected = (WeaponPanel)weaponPane.getSelectedComponent();
          selected.saveToFile(file);
        } else {
          //Do Nothing
        }
      }else if(e.getSource().equals(modMenu)){
        displayModManager();
        updateModMenuState(false);
      }else if(e.getSource().equals(TTKMenu)){
        displayTargetManager();
        updateTTKMenuState(false);
      }else if(e.getSource().equals(weaponMenu)){
        displayWeaponManager();
        updateWeaponMenuState(false);
      }else if(e.getSource().equals(colorOptionsItem)){
        displayColorOptions();
      }
    }
  }
  
  public static double getCorrosiveProjectionMult(){
    double mult = 1.0 - (0.3 * Double.parseDouble((String)corrosiveProjectionBox.getSelectedItem()));
    if(mult < 0.0){
      mult = 0.0;
    }
    return mult;
  }
  
  /**
   * Window Listener Local Class
   * @author GottFuast
   *
   */
  protected static class MainWindowListener implements WindowListener{
    
    /**
     * Default CTOR
     */
    public MainWindowListener(){
      //Do Nothing
    }
    
    /**
     * Event to indicate that the window has closed
     */
    public void windowClosed(WindowEvent e) {
      System.exit(0);
    }
    
    /**
     * Event to indicate taht the window is closing
     */
    public void windowClosing(WindowEvent e) {
      System.exit(0);
    }

    /**
     * Unused
     */
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
  }
  
  /**
   * Window Listener Local Class
   * @author GottFaust
   *
   */
  protected static class ModWindowListener implements WindowListener{
    
    /**
     * Default CTOR
     */
    public ModWindowListener(){
      //Do Nothing
    }
    
    /**
     * Event to indicate that the window has closed
     */
    public void windowClosed(WindowEvent e) {
      updateModMenuState(true);
    }
    

    /**
     * Unused
     */
    public void windowActivated(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
  }
  
  /**
   * Window Listener Local Class
   * @author GottFaust
   *
   */
  protected static class TTKWindowListener implements WindowListener{
    
    /**
     * Default CTOR
     */
    public TTKWindowListener(){
      //Do Nothing
    }
    
    /**
     * Event to indicate that the window has closed
     */
    public void windowClosed(WindowEvent e) {
      updateTTKMenuState(true);
    }
    

    /**
     * Unused
     */
    public void windowActivated(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
  }
  
  /**
   * Window Listener Local Class
   * @author GottFaust
   *
   */
  protected static class WeaponWindowListener implements WindowListener{
    
    /**
     * Default CTOR
     */
    public WeaponWindowListener(){
      //Do Nothing
    }
    
    /**
     * Event to indicate that the window has closed
     */
    public void windowClosed(WindowEvent e) {
      updateWeaponMenuState(true);
    }
    

    /**
     * Unused
     */
    public void windowActivated(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
  }
  
  public static class DoTPair{
    public double damage = 0.0;
    public int duration = 0;
    public DoTPair(double damage, int duration){
      this.damage = damage;
      this.duration = duration;
    }
  }
}
