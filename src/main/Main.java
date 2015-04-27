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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import etc.Constants;
import etc.DPSGraphPanel;
import etc.UIBuilder;

import mods.Mod;
import mods.ModManagerPanel;

import ttk.TTKManagerPanel;
import ttk.TTKTarget;
import weapons.PistolPanel;
import weapons.RiflePanel;
import weapons.ShotgunPanel;
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
  protected static JFrame colorOptionsFrame = new JFrame();
  
  /** JButtons **/
  protected static JButton calculateButton = new JButton("Calculate");
  protected static JButton clearButton = new JButton("Clear");
  protected static JButton clearOutputButton = new JButton("Clear Output");
  
  /** JTextAreas **/
  public static JTextArea output = new JTextArea();
  
  /** JTabbedPanes **/
  protected static JTabbedPane weaponPane = new JTabbedPane();
  
  /** JScrollPanes **/
  protected static JScrollPane outputScroll = new JScrollPane(output);
  
  /** JPanels **/
  protected static JPanel mainPanel = new JPanel();
  protected static JPanel topPanel = new JPanel();
  protected static JPanel bottomPanel = new JPanel();
  protected static RiflePanel riflePanel;// = new RiflePanel();
  protected static ShotgunPanel shotgunPanel;// = new ShotgunPanel();
  protected static PistolPanel pistolPanel;// = new PistolPanel();
  protected static ModManagerPanel theModManager = null;
  protected static TTKManagerPanel theTTKManager = null;
  protected static ColorOptionsPanel theColorPanel = null;
  protected static DPSGraphPanel graph = new DPSGraphPanel();
  
  /** JMenuBar **/
  protected static JMenuBar mainMenuBar = new JMenuBar();
  
  /** JMenuItems **/
  protected static JMenu fileMenu = new JMenu("File");
  protected static JMenuItem modMenu = new JMenuItem("Mod Manager");
  protected static JMenuItem TTKMenu = new JMenuItem("Target Manager");
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
  protected static Boolean colorOptionsInit = false;
  protected static JCheckBox advancedTTKBox = new JCheckBox("Run TTK");
  
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
  protected static String weaponMode = "";
  protected static String damageType = "";
  protected static double chargeTime = 0.0;
  protected static double burstFireRate = 0.0;
  protected static double rawDamage = 0.0;
  protected static double impactDamage = 0.0;
  protected static double punctureDamage = 0.0;
  protected static double slashDamage = 0.0;
  protected static double fireDamage = 0.0;
  protected static double iceDamage = 0.0;
  protected static double electricDamage = 0.0;
  protected static double toxinDamage = 0.0;
  protected static double blastDamage = 0.0;
  protected static double magneticDamage = 0.0;
  protected static double gasDamage = 0.0;
  protected static double radiationDamage = 0.0;
  protected static double corrosiveDamage = 0.0;
  protected static double viralDamage = 0.0;
  protected static double fireRate = 0.0;
  protected static double reloadTime = 0.0;
  protected static double critChance = 0.0;
  protected static double critMult = 0.0;
  protected static double projectileCount = 0.0;
  protected static double firstShotDamageMult = 1.0;
  protected static double statusChance = 0.0;
  protected static double damageMult = 1.0;
  protected static int mag = 0;
  protected static int ammoCap = 0;
  protected static int burstCount = 0;
  
  /** Calculated Values **/
  protected static int finalMag = 0;
  protected static int finalAmmo = 0;
  protected static double finalIterationTime = 0.0;
  protected static double finalIterationsPerMinute = 0.0;
  protected static double finalCritShots = 0.0;
  protected static double finalNormalShots = 0.0;
  protected static double finalCritChance = 0.0;
  protected static double finalCritMult = 0.0;
  protected static double finalFireRate = 0.0;
  protected static double finalBurstFireRate = 0.0;
  protected static double finalReloadTime = 0.0;
  protected static double finalRawDamage = 0.0;
  protected static double finalImpactDamage = 0.0;
  protected static double finalPunctureDamage = 0.0;
  protected static double finalSlashDamage = 0.0;
  protected static double finalFireDamage = 0.0;
  protected static double finalIceDamage = 0.0;
  protected static double finalElectricDamage = 0.0;
  protected static double finalToxinDamage = 0.0;
  protected static double finalBlastDamage = 0.0;
  protected static double finalMagneticDamage = 0.0;
  protected static double finalGasDamage = 0.0;
  protected static double finalRadiationDamage = 0.0;
  protected static double finalCorrosiveDamage = 0.0;
  protected static double finalViralDamage = 0.0;
  protected static double finalProjectileCount = 0.0;
  protected static double finalFirstShotDamageMult = 1.0;
  protected static double finalStatusChance = 0.0;
  protected static double finalDamageMult = 1.0;
  protected static double finalCorpusMult = 1.0;
  protected static double finalGrineerMult = 1.0;
  protected static double finalInfestedMult = 1.0;
  protected static double continuousDrainRate = 0.0;
  
  /** Damage/DPS Values **/
  //Misc Values
  protected static double procsPerSecond = 0.0;
  protected static double burstProcsPerSecond = 0.0;
  protected static int slashStacks = 0;
  protected static int fireStacks = 0;
  protected static int toxinStacks = 0;
  protected static int gasStacks = 0;
  
  //Damage Per Shot Values
  protected static double rawDamagePerShot = 0.0;
  protected static double impactDamagePerShot = 0.0;
  protected static double punctureDamagePerShot = 0.0;
  protected static double slashDamagePerShot = 0.0;
  protected static double fireDamagePerShot = 0.0;
  protected static double iceDamagePerShot = 0.0;
  protected static double electricDamagePerShot = 0.0;
  protected static double toxinDamagePerShot = 0.0;
  protected static double blastDamagePerShot = 0.0;
  protected static double magneticDamagePerShot = 0.0;
  protected static double gasDamagePerShot = 0.0;
  protected static double radiationDamagePerShot = 0.0;
  protected static double corrosiveDamagePerShot = 0.0;
  protected static double viralDamagePerShot = 0.0;
  protected static double corpusDamagePerShot = 0.0;
  protected static double grineerDamagePerShot = 0.0;
  protected static double infestedDamagePerShot = 0.0;
  protected static double cloneFleshDamagePerShot = 0.0;
  protected static double ferriteDamagePerShot = 0.0;
  protected static double alloyDamagePerShot = 0.0;
  protected static double mechanicalDamagePerShot = 0.0;
  protected static double corpusFleshDamagePerShot = 0.0;
  protected static double shieldDamagePerShot = 0.0;
  protected static double protoShieldDamagePerShot = 0.0;
  protected static double roboticDamagePerShot = 0.0;
  protected static double infestedFleshDamagePerShot = 0.0;
  protected static double fossilizedDamagePerShot = 0.0;
  protected static double sinewDamagePerShot = 0.0;
  
  //Crit Damage Per Shot Values
  protected static double rawCritDamagePerShot = 0.0;
  protected static double impactCritDamagePerShot = 0.0;
  protected static double punctureCritDamagePerShot = 0.0;
  protected static double slashCritDamagePerShot = 0.0;
  protected static double fireCritDamagePerShot = 0.0;
  protected static double iceCritDamagePerShot = 0.0;
  protected static double electricCritDamagePerShot = 0.0;
  protected static double toxinCritDamagePerShot = 0.0;
  protected static double blastCritDamagePerShot = 0.0;
  protected static double magneticCritDamagePerShot = 0.0;
  protected static double gasCritDamagePerShot = 0.0;
  protected static double radiationCritDamagePerShot = 0.0;
  protected static double corrosiveCritDamagePerShot = 0.0;
  protected static double viralCritDamagePerShot = 0.0;
  protected static double corpusCritDamagePerShot = 0.0;
  protected static double grineerCritDamagePerShot = 0.0;
  protected static double infestedCritDamagePerShot = 0.0;
  protected static double cloneFleshCritDamagePerShot = 0.0;
  protected static double ferriteCritDamagePerShot = 0.0;
  protected static double alloyCritDamagePerShot = 0.0;
  protected static double mechanicalCritDamagePerShot = 0.0;
  protected static double corpusFleshCritDamagePerShot = 0.0;
  protected static double shieldCritDamagePerShot = 0.0;
  protected static double protoShieldCritDamagePerShot = 0.0;
  protected static double roboticCritDamagePerShot = 0.0;
  protected static double infestedFleshCritDamagePerShot = 0.0;
  protected static double fossilizedCritDamagePerShot = 0.0;
  protected static double sinewCritDamagePerShot = 0.0;
  
  //First Shot Damage
  protected static double rawFirstShotDamage = 0.0;
  protected static double impactFirstShotDamage = 0.0;
  protected static double punctureFirstShotDamage = 0.0;
  protected static double slashFirstShotDamage = 0.0;
  protected static double fireFirstShotDamage = 0.0;
  protected static double iceFirstShotDamage = 0.0;
  protected static double electricFirstShotDamage = 0.0;
  protected static double toxinFirstShotDamage = 0.0;
  protected static double blastFirstShotDamage = 0.0;
  protected static double magneticFirstShotDamage = 0.0;
  protected static double gasFirstShotDamage = 0.0;
  protected static double radiationFirstShotDamage = 0.0;
  protected static double corrosiveFirstShotDamage = 0.0;
  protected static double viralFirstShotDamage = 0.0;
  protected static double corpusFirstShotDamage = 0.0;
  protected static double grineerFirstShotDamage = 0.0;
  protected static double infestedFirstShotDamage = 0.0;
  protected static double cloneFleshFirstShotDamage = 0.0;
  protected static double ferriteFirstShotDamage = 0.0;
  protected static double alloyFirstShotDamage = 0.0;
  protected static double mechanicalFirstShotDamage = 0.0;
  protected static double corpusFleshFirstShotDamage = 0.0;
  protected static double shieldFirstShotDamage = 0.0;
  protected static double protoShieldFirstShotDamage = 0.0;
  protected static double roboticFirstShotDamage = 0.0;
  protected static double infestedFleshFirstShotDamage = 0.0;
  protected static double fossilizedFirstShotDamage = 0.0;
  protected static double sinewFirstShotDamage = 0.0;
  
  //Damage Per Iteration Values
  protected static double rawDamagePerIteration = 0.0;
  protected static double impactDamagePerIteration = 0.0;
  protected static double punctureDamagePerIteration = 0.0;
  protected static double slashDamagePerIteration = 0.0;
  protected static double fireDamagePerIteration = 0.0;
  protected static double iceDamagePerIteration = 0.0;
  protected static double electricDamagePerIteration = 0.0;
  protected static double toxinDamagePerIteration = 0.0;
  protected static double blastDamagePerIteration = 0.0;
  protected static double magneticDamagePerIteration = 0.0;
  protected static double gasDamagePerIteration = 0.0;
  protected static double radiationDamagePerIteration = 0.0;
  protected static double corrosiveDamagePerIteration = 0.0;
  protected static double viralDamagePerIteration = 0.0;
  protected static double corpusDamagePerIteration = 0.0;
  protected static double grineerDamagePerIteration = 0.0;
  protected static double infestedDamagePerIteration = 0.0;
  protected static double cloneFleshDamagePerIteration = 0.0;
  protected static double ferriteDamagePerIteration = 0.0;
  protected static double alloyDamagePerIteration = 0.0;
  protected static double mechanicalDamagePerIteration = 0.0;
  protected static double corpusFleshDamagePerIteration = 0.0;
  protected static double shieldDamagePerIteration = 0.0;
  protected static double protoShieldDamagePerIteration = 0.0;
  protected static double roboticDamagePerIteration = 0.0;
  protected static double infestedFleshDamagePerIteration = 0.0;
  protected static double fossilizedDamagePerIteration = 0.0;
  protected static double sinewDamagePerIteration = 0.0;
  
  //Damage Per Minute Values
  protected static double rawDamagePerMinute = 0.0;
  protected static double impactDamagePerMinute = 0.0;
  protected static double punctureDamagePerMinute = 0.0;
  protected static double slashDamagePerMinute = 0.0;
  protected static double fireDamagePerMinute = 0.0;
  protected static double iceDamagePerMinute = 0.0;
  protected static double electricDamagePerMinute = 0.0;
  protected static double toxinDamagePerMinute = 0.0;
  protected static double blastDamagePerMinute = 0.0;
  protected static double magneticDamagePerMinute = 0.0;
  protected static double gasDamagePerMinute = 0.0;
  protected static double radiationDamagePerMinute = 0.0;
  protected static double corrosiveDamagePerMinute = 0.0;
  protected static double viralDamagePerMinute = 0.0;
  protected static double corpusDamagePerMinute = 0.0;
  protected static double grineerDamagePerMinute = 0.0;
  protected static double infestedDamagePerMinute = 0.0;
  protected static double cloneFleshDamagePerMinute = 0.0;
  protected static double ferriteDamagePerMinute = 0.0;
  protected static double alloyDamagePerMinute = 0.0;
  protected static double mechanicalDamagePerMinute = 0.0;
  protected static double corpusFleshDamagePerMinute = 0.0;
  protected static double shieldDamagePerMinute = 0.0;
  protected static double protoShieldDamagePerMinute = 0.0;
  protected static double roboticDamagePerMinute = 0.0;
  protected static double infestedFleshDamagePerMinute = 0.0;
  protected static double fossilizedDamagePerMinute = 0.0;
  protected static double sinewDamagePerMinute = 0.0;
  
  //Damage Per Second Values
  protected static double rawDamagePerSecond = 0.0;
  protected static double impactDamagePerSecond = 0.0;
  protected static double punctureDamagePerSecond = 0.0;
  protected static double slashDamagePerSecond = 0.0;
  protected static double fireDamagePerSecond = 0.0;
  protected static double iceDamagePerSecond = 0.0;
  protected static double electricDamagePerSecond = 0.0;
  protected static double toxinDamagePerSecond = 0.0;
  protected static double blastDamagePerSecond = 0.0;
  protected static double magneticDamagePerSecond = 0.0;
  protected static double gasDamagePerSecond = 0.0;
  protected static double radiationDamagePerSecond = 0.0;
  protected static double corrosiveDamagePerSecond = 0.0;
  protected static double viralDamagePerSecond = 0.0;
  protected static double corpusDamagePerSecond = 0.0;
  protected static double grineerDamagePerSecond = 0.0;
  protected static double infestedDamagePerSecond = 0.0;
  protected static double cloneFleshDamagePerSecond = 0.0;
  protected static double ferriteDamagePerSecond = 0.0;
  protected static double alloyDamagePerSecond = 0.0;
  protected static double mechanicalDamagePerSecond = 0.0;
  protected static double corpusFleshDamagePerSecond = 0.0;
  protected static double shieldDamagePerSecond = 0.0;
  protected static double protoShieldDamagePerSecond = 0.0;
  protected static double roboticDamagePerSecond = 0.0;
  protected static double infestedFleshDamagePerSecond = 0.0;
  protected static double fossilizedDamagePerSecond = 0.0;
  protected static double sinewDamagePerSecond = 0.0;
  
  //Burst Damage Per Second Values
  protected static double rawBurstDamagePerSecond = 0.0;
  protected static double impactBurstDamagePerSecond = 0.0;
  protected static double punctureBurstDamagePerSecond = 0.0;
  protected static double slashBurstDamagePerSecond = 0.0;
  protected static double fireBurstDamagePerSecond = 0.0;
  protected static double iceBurstDamagePerSecond = 0.0;
  protected static double electricBurstDamagePerSecond = 0.0;
  protected static double toxinBurstDamagePerSecond = 0.0;
  protected static double blastBurstDamagePerSecond = 0.0;
  protected static double magneticBurstDamagePerSecond = 0.0;
  protected static double gasBurstDamagePerSecond = 0.0;
  protected static double radiationBurstDamagePerSecond = 0.0;
  protected static double corrosiveBurstDamagePerSecond = 0.0;
  protected static double viralBurstDamagePerSecond = 0.0;
  protected static double corpusBurstDamagePerSecond = 0.0;
  protected static double grineerBurstDamagePerSecond = 0.0;
  protected static double infestedBurstDamagePerSecond = 0.0;
  protected static double cloneFleshBurstDamagePerSecond = 0.0;
  protected static double ferriteBurstDamagePerSecond = 0.0;
  protected static double alloyBurstDamagePerSecond = 0.0;
  protected static double mechanicalBurstDamagePerSecond = 0.0;
  protected static double corpusFleshBurstDamagePerSecond = 0.0;
  protected static double shieldBurstDamagePerSecond = 0.0;
  protected static double protoShieldBurstDamagePerSecond = 0.0;
  protected static double roboticBurstDamagePerSecond = 0.0;
  protected static double infestedFleshBurstDamagePerSecond = 0.0;
  protected static double fossilizedBurstDamagePerSecond = 0.0;
  protected static double sinewBurstDamagePerSecond = 0.0;

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
    theModManager = new ModManagerPanel(riflePanel, shotgunPanel, pistolPanel);
    theTTKManager = new TTKManagerPanel();
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
    UIBuilder.buttonInit(calculateButton);
    UIBuilder.buttonInit(clearButton);
    UIBuilder.buttonInit(clearOutputButton);
    UIBuilder.textAreaInit(output);
    UIBuilder.scrollPaneInit(outputScroll);
    UIBuilder.tabbedPaneInit(weaponPane);
    UIBuilder.menuBarInit(mainMenuBar);
    UIBuilder.menuInit(fileMenu);
    UIBuilder.menuItemInit(modMenu);
    UIBuilder.menuItemInit(TTKMenu);
    UIBuilder.menuItemInit(saveItem);
    UIBuilder.menuItemInit(loadItem);
    UIBuilder.menuItemInit(colorOptionsItem);
    UIBuilder.fileChooserInit(chooser);
    UIBuilder.checkBoxInit(advancedTTKBox);
    
    try{
      File currentDirectory = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
      chooser.setCurrentDirectory(currentDirectory);
    }catch(Exception ex){
      ex.printStackTrace();
    }
    
    calculateButton.addActionListener(action);
    advancedTTKBox.addActionListener(action);
    clearButton.addActionListener(action);
    clearOutputButton.addActionListener(action);
    saveItem.addActionListener(action);
    loadItem.addActionListener(action);
    modMenu.addActionListener(action);
    TTKMenu.addActionListener(action);
    colorOptionsItem.addActionListener(action);
    
    mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
    bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.Y_AXIS));
    
    weaponPane.add(riflePanel, Constants.RIFLE);
    weaponPane.add(shotgunPanel, Constants.SHOTGUN);
    weaponPane.add(pistolPanel, Constants.PISTOL);
    
    JPanel buttonPanel = new JPanel();
    UIBuilder.panelInit(buttonPanel);
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(calculateButton);
    buttonPanel.add(clearButton);
    buttonPanel.add(clearOutputButton);
    buttonPanel.add(advancedTTKBox);
    
    advancedTTKBox.setToolTipText("Warning: This will cause a significantly performance hit compared to not running TTK.");
    advancedTTKBox.setSelected(useComplexTTK);
    
    JPanel graphPanel = new JPanel();
    graphPanel.setLayout(new GridLayout(1,1,0,0));
    UIBuilder.panelInit(graphPanel);
    UIBuilder.createTitledLineBorder(graphPanel, "DPS Graph");
    graphPanel.add(graph);
    
    JPanel dataPanel = new JPanel();
    UIBuilder.panelInit(dataPanel);
    dataPanel.setLayout(new GridLayout(1,2,0,0));
    dataPanel.add(graphPanel);
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
    if(useComplexTTK){
      complexTTKCompletions = 0;
      for(TTKTarget target : theTTKManager.targets){
        target.runAdvancedTTK();
        String name = target.name+"["+target.currentLevel+"]";
        if(name.length() > longestTTKName.length()){
          longestTTKName = name;
        }
      }
      int ttkCount = theTTKManager.targets.size();
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
    burstFireRate = 0.0;
    rawDamage = 0.0;
    impactDamage = 0.0;
    punctureDamage = 0.0;
    slashDamage = 0.0;
    fireDamage = 0.0;
    iceDamage = 0.0;
    electricDamage = 0.0;
    toxinDamage = 0.0;
    blastDamage = 0.0;
    magneticDamage = 0.0;
    gasDamage = 0.0;
    radiationDamage = 0.0;
    corrosiveDamage = 0.0;
    viralDamage = 0.0;
    fireRate = 0.0;
    reloadTime = 0.0;
    critChance = 0.0;
    critMult = 0.0;
    projectileCount = 0.0;
    firstShotDamageMult = 1.0;
    statusChance = 0.0;
    damageMult = 1.0;
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
    finalBurstFireRate = 0.0;
    finalReloadTime = 0.0;
    finalRawDamage = 0.0;
    finalImpactDamage = 0.0;
    finalPunctureDamage = 0.0;
    finalSlashDamage = 0.0;
    finalFireDamage = 0.0;
    finalIceDamage = 0.0;
    finalElectricDamage = 0.0;
    finalToxinDamage = 0.0;
    finalBlastDamage = 0.0;
    finalMagneticDamage = 0.0;
    finalGasDamage = 0.0;
    finalRadiationDamage = 0.0;
    finalCorrosiveDamage = 0.0;
    finalViralDamage = 0.0;
    finalProjectileCount = 0.0;
    finalFirstShotDamageMult = 1.0;
    finalStatusChance = 0.0;
    finalDamageMult = 1.0;
    finalCorpusMult = 1.0;
    finalGrineerMult = 1.0;
    finalInfestedMult = 1.0;
    procsPerSecond = 0.0;
    burstProcsPerSecond = 0.0;
    slashStacks = 0;
    fireStacks = 0;
    toxinStacks = 0;
    gasStacks = 0;
    rawDamagePerShot = 0.0;
    impactDamagePerShot = 0.0;
    punctureDamagePerShot = 0.0;
    slashDamagePerShot = 0.0;
    fireDamagePerShot = 0.0;
    iceDamagePerShot = 0.0;
    electricDamagePerShot = 0.0;
    toxinDamagePerShot = 0.0;
    blastDamagePerShot = 0.0;
    magneticDamagePerShot = 0.0;
    gasDamagePerShot = 0.0;
    radiationDamagePerShot = 0.0;
    corrosiveDamagePerShot = 0.0;
    viralDamagePerShot = 0.0;
    corpusDamagePerShot = 0.0;
    grineerDamagePerShot = 0.0;
    infestedDamagePerShot = 0.0;
    cloneFleshDamagePerShot = 0.0;
    ferriteDamagePerShot = 0.0;
    alloyDamagePerShot = 0.0;
    mechanicalDamagePerShot = 0.0;
    corpusFleshDamagePerShot = 0.0;
    shieldDamagePerShot = 0.0;
    protoShieldDamagePerShot = 0.0;
    roboticDamagePerShot = 0.0;
    infestedFleshDamagePerShot = 0.0;
    fossilizedDamagePerShot = 0.0;
    sinewDamagePerShot = 0.0;
    rawCritDamagePerShot = 0.0;
    impactCritDamagePerShot = 0.0;
    punctureCritDamagePerShot = 0.0;
    slashCritDamagePerShot = 0.0;
    fireCritDamagePerShot = 0.0;
    iceCritDamagePerShot = 0.0;
    electricCritDamagePerShot = 0.0;
    toxinCritDamagePerShot = 0.0;
    blastCritDamagePerShot = 0.0;
    magneticCritDamagePerShot = 0.0;
    gasCritDamagePerShot = 0.0;
    radiationCritDamagePerShot = 0.0;
    corrosiveCritDamagePerShot = 0.0;
    viralCritDamagePerShot = 0.0;
    corpusCritDamagePerShot = 0.0;
    grineerCritDamagePerShot = 0.0;
    infestedCritDamagePerShot = 0.0;
    cloneFleshCritDamagePerShot = 0.0;
    ferriteCritDamagePerShot = 0.0;
    alloyCritDamagePerShot = 0.0;
    mechanicalCritDamagePerShot = 0.0;
    corpusFleshCritDamagePerShot = 0.0;
    shieldCritDamagePerShot = 0.0;
    protoShieldCritDamagePerShot = 0.0;
    roboticCritDamagePerShot = 0.0;
    infestedFleshCritDamagePerShot = 0.0;
    fossilizedCritDamagePerShot = 0.0;
    sinewCritDamagePerShot = 0.0;
    rawFirstShotDamage = 0.0;
    impactFirstShotDamage = 0.0;
    punctureFirstShotDamage = 0.0;
    slashFirstShotDamage = 0.0;
    fireFirstShotDamage = 0.0;
    iceFirstShotDamage = 0.0;
    electricFirstShotDamage = 0.0;
    toxinFirstShotDamage = 0.0;
    blastFirstShotDamage = 0.0;
    magneticFirstShotDamage = 0.0;
    gasFirstShotDamage = 0.0;
    radiationFirstShotDamage = 0.0;
    corrosiveFirstShotDamage = 0.0;
    viralFirstShotDamage = 0.0;
    corpusFirstShotDamage = 0.0;
    grineerFirstShotDamage = 0.0;
    infestedFirstShotDamage = 0.0;
    cloneFleshFirstShotDamage = 0.0;
    ferriteFirstShotDamage = 0.0;
    alloyFirstShotDamage = 0.0;
    mechanicalFirstShotDamage = 0.0;
    corpusFleshFirstShotDamage = 0.0;
    shieldFirstShotDamage = 0.0;
    protoShieldFirstShotDamage = 0.0;
    roboticFirstShotDamage = 0.0;
    infestedFleshFirstShotDamage = 0.0;
    fossilizedFirstShotDamage = 0.0;
    sinewFirstShotDamage = 0.0;
    rawDamagePerIteration = 0.0;
    impactDamagePerIteration = 0.0;
    punctureDamagePerIteration = 0.0;
    slashDamagePerIteration = 0.0;
    fireDamagePerIteration = 0.0;
    iceDamagePerIteration = 0.0;
    electricDamagePerIteration = 0.0;
    toxinDamagePerIteration = 0.0;
    blastDamagePerIteration = 0.0;
    magneticDamagePerIteration = 0.0;
    gasDamagePerIteration = 0.0;
    radiationDamagePerIteration = 0.0;
    corrosiveDamagePerIteration = 0.0;
    viralDamagePerIteration = 0.0;
    corpusDamagePerIteration = 0.0;
    grineerDamagePerIteration = 0.0;
    infestedDamagePerIteration = 0.0;
    cloneFleshDamagePerIteration = 0.0;
    ferriteDamagePerIteration = 0.0;
    alloyDamagePerIteration = 0.0;
    mechanicalDamagePerIteration = 0.0;
    corpusFleshDamagePerIteration = 0.0;
    shieldDamagePerIteration = 0.0;
    protoShieldDamagePerIteration = 0.0;
    roboticDamagePerIteration = 0.0;
    infestedFleshDamagePerIteration = 0.0;
    fossilizedDamagePerIteration = 0.0;
    sinewDamagePerIteration = 0.0;
    rawDamagePerMinute = 0.0;
    impactDamagePerMinute = 0.0;
    punctureDamagePerMinute = 0.0;
    slashDamagePerMinute = 0.0;
    fireDamagePerMinute = 0.0;
    iceDamagePerMinute = 0.0;
    electricDamagePerMinute = 0.0;
    toxinDamagePerMinute = 0.0;
    blastDamagePerMinute = 0.0;
    magneticDamagePerMinute = 0.0;
    gasDamagePerMinute = 0.0;
    radiationDamagePerMinute = 0.0;
    corrosiveDamagePerMinute = 0.0;
    viralDamagePerMinute = 0.0;
    corpusDamagePerMinute = 0.0;
    grineerDamagePerMinute = 0.0;
    infestedDamagePerMinute = 0.0;
    cloneFleshDamagePerMinute = 0.0;
    ferriteDamagePerMinute = 0.0;
    alloyDamagePerMinute = 0.0;
    mechanicalDamagePerMinute = 0.0;
    corpusFleshDamagePerMinute = 0.0;
    shieldDamagePerMinute = 0.0;
    protoShieldDamagePerMinute = 0.0;
    roboticDamagePerMinute = 0.0;
    infestedFleshDamagePerMinute = 0.0;
    fossilizedDamagePerMinute = 0.0;
    sinewDamagePerMinute = 0.0;
    rawDamagePerSecond = 0.0;
    impactDamagePerSecond = 0.0;
    punctureDamagePerSecond = 0.0;
    slashDamagePerSecond = 0.0;
    fireDamagePerSecond = 0.0;
    iceDamagePerSecond = 0.0;
    electricDamagePerSecond = 0.0;
    toxinDamagePerSecond = 0.0;
    blastDamagePerSecond = 0.0;
    magneticDamagePerSecond = 0.0;
    gasDamagePerSecond = 0.0;
    radiationDamagePerSecond = 0.0;
    corrosiveDamagePerSecond = 0.0;
    viralDamagePerSecond = 0.0;
    corpusDamagePerSecond = 0.0;
    grineerDamagePerSecond = 0.0;
    infestedDamagePerSecond = 0.0;
    cloneFleshDamagePerSecond = 0.0;
    ferriteDamagePerSecond = 0.0;
    alloyDamagePerSecond = 0.0;
    mechanicalDamagePerSecond = 0.0;
    corpusFleshDamagePerSecond = 0.0;
    shieldDamagePerSecond = 0.0;
    protoShieldDamagePerSecond = 0.0;
    roboticDamagePerSecond = 0.0;
    infestedFleshDamagePerSecond = 0.0;
    fossilizedDamagePerSecond = 0.0;
    sinewDamagePerSecond = 0.0;
    rawBurstDamagePerSecond = 0.0;
    impactBurstDamagePerSecond = 0.0;
    punctureBurstDamagePerSecond = 0.0;
    slashBurstDamagePerSecond = 0.0;
    fireBurstDamagePerSecond = 0.0;
    iceBurstDamagePerSecond = 0.0;
    electricBurstDamagePerSecond = 0.0;
    toxinBurstDamagePerSecond = 0.0;
    blastBurstDamagePerSecond = 0.0;
    magneticBurstDamagePerSecond = 0.0;
    gasBurstDamagePerSecond = 0.0;
    radiationBurstDamagePerSecond = 0.0;
    corrosiveBurstDamagePerSecond = 0.0;
    viralBurstDamagePerSecond = 0.0;
    corpusBurstDamagePerSecond = 0.0;
    grineerBurstDamagePerSecond = 0.0;
    infestedBurstDamagePerSecond = 0.0;
    cloneFleshBurstDamagePerSecond = 0.0;
    ferriteBurstDamagePerSecond = 0.0;
    alloyBurstDamagePerSecond = 0.0;
    mechanicalBurstDamagePerSecond = 0.0;
    corpusFleshBurstDamagePerSecond = 0.0;
    shieldBurstDamagePerSecond = 0.0;
    protoShieldBurstDamagePerSecond = 0.0;
    roboticBurstDamagePerSecond = 0.0;
    infestedFleshBurstDamagePerSecond = 0.0;
    fossilizedBurstDamagePerSecond = 0.0;
    sinewBurstDamagePerSecond = 0.0;
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
    burstFireRate = selectedWeapon.getBurstFireRate();
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
      impactDamage = selectedWeapon.getImpactDamage();
      punctureDamage = selectedWeapon.getPunctureDamage();
      slashDamage = selectedWeapon.getSlashDamage();
    }else if(damageType.equals(Constants.FIRE_WEAPON_DAMAGE)){
      fireDamage = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.ICE_WEAPON_DAMAGE)){
      iceDamage = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.ELECTRIC_WEAPON_DAMAGE)){
      electricDamage = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.TOXIN_WEAPON_DAMAGE)){
      toxinDamage = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.BLAST_WEAPON_DAMAGE)){
      blastDamage = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.MAGNETIC_WEAPON_DAMAGE)){
      magneticDamage = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.GAS_WEAPON_DAMAGE)){
      gasDamage = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.RADIATION_WEAPON_DAMAGE)){
      radiationDamage = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.CORROSIVE_WEAPON_DAMAGE)){
      corrosiveDamage = selectedWeapon.getBaseDamage();
    }else if(damageType.equals(Constants.VIRAL_WEAPON_DAMAGE)){
      viralDamage = selectedWeapon.getBaseDamage();
    }
    
    rawDamage = impactDamage +
                punctureDamage +
                slashDamage +
                fireDamage +
                iceDamage +
                electricDamage +
                toxinDamage +
                blastDamage +
                magneticDamage +
                gasDamage +
                radiationDamage +
                corrosiveDamage +
                viralDamage;
    
    //Calculations based on weapon type
    if(weaponMode.equals(Constants.CONTINUOUS)){
      continuousDrainRate = fireRate;
      fireRate = CONTINUOUS_MULT;
      damageMult *= continuousDrainRate;
    }else if(weaponMode.equals(Constants.CHARGE)){
      double fireRateAddition = 60.0 / chargeTime / 60.0;
      fireRate += fireRateAddition;
    }else if(weaponMode.equals(Constants.BURST)){
      projectileCount *= burstCount;
    }
    
    if(projectileCount > 1.0 && !weaponMode.equals(Constants.BURST)){
      rawDamage /= projectileCount;
      statusChance /= projectileCount;
      impactDamage /= projectileCount;
      punctureDamage /= projectileCount;
      slashDamage /= projectileCount;
      fireDamage /= projectileCount;
      iceDamage /= projectileCount;
      electricDamage /= projectileCount;
      toxinDamage /= projectileCount;
      blastDamage /= projectileCount;
      magneticDamage /= projectileCount;
      gasDamage /= projectileCount;
      radiationDamage /= projectileCount;
      corrosiveDamage /= projectileCount;
      viralDamage /= projectileCount;
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
    Vector<Double> corpusMods = new Vector<Double>();
    Vector<Double> grineerMods = new Vector<Double>();
    Vector<Double> infestedMods = new Vector<Double>();
    
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
          blastDamage = fireDamage;
          fireDamage = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          radiationDamageMods.add(jointPower);
          radiationDamage = fireDamage;
          fireDamage = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          gasDamageMods.add(jointPower);
          gasDamage = fireDamage;
          fireDamage = 0.0;
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
          blastDamage = iceDamage;
          iceDamage = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_ICE_DAMAGE)){
          //Don't Combine
        }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          magneticDamageMods.add(jointPower);
          magneticDamage = iceDamage;
          iceDamage = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          viralDamageMods.add(jointPower);
          viralDamage = iceDamage;
          iceDamage = 0.0;
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
          radiationDamage = electricDamage;
          electricDamage = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_ICE_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          magneticDamageMods.add(jointPower);
          magneticDamage = electricDamage;
          electricDamage = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
          //Don't Combine
        }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          corrosiveDamageMods.add(jointPower);
          corrosiveDamage = electricDamage;
          electricDamage = 0.0;
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
          gasDamage = toxinDamage;
          toxinDamage = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_ICE_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          viralDamageMods.add(jointPower);
          viralDamage = toxinDamage;
          toxinDamage = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_LIGHTNING_DAMAGE)){
          combinedMods.add(primeMod);
          double primeEffectPower = (primeMod.effectStrengths.get(primeMod.effectTypes.indexOf(primeModType)))*(1.0+primeModRanks);
          double jointPower = primeEffectPower;
          corrosiveDamageMods.add(jointPower);
          corrosiveDamage = toxinDamage;
          toxinDamage = 0.0;
          baseCombined = true;
        }else if(primeModType.equals(Constants.MOD_TYPE_TOXIN_DAMAGE)){
          //Don't Combine
        }
      }
    }
    if(!baseCombined){
      if(damageType.equals(Constants.FIRE_WEAPON_DAMAGE)){
        if(blastDamageMods.size() > 0){
          blastDamage = fireDamage;
          fireDamage = 0.0;
        }else if(radiationDamageMods.size() > 0){
          radiationDamage = fireDamage;
          fireDamage = 0.0;
        }else if(gasDamageMods.size() > 0){
          gasDamage = fireDamage;
          fireDamage = 0.0;
        }
      }else if(damageType.equals(Constants.ICE_WEAPON_DAMAGE)){
        if(blastDamageMods.size() > 0){
          blastDamage = iceDamage;
          iceDamage = 0.0;
        }else if(magneticDamageMods.size() > 0){
          magneticDamage = iceDamage;
          iceDamage = 0.0;
        }else if(viralDamageMods.size() > 0){
          viralDamage = iceDamage;
          iceDamage = 0.0;
        }
      }else if(damageType.equals(Constants.ELECTRIC_WEAPON_DAMAGE)){
        if(radiationDamageMods.size() > 0){
          radiationDamage = electricDamage;
          electricDamage = 0.0;
        }else if(magneticDamageMods.size() > 0){
          magneticDamage = electricDamage;
          electricDamage = 0.0;
        }else if(corrosiveDamageMods.size() > 0){
          corrosiveDamage = electricDamage;
          electricDamage = 0.0;
        }
      }else if(damageType.equals(Constants.TOXIN_WEAPON_DAMAGE)){
        if(gasDamageMods.size() > 0){
          gasDamage = toxinDamage;
          toxinDamage = 0.0;
        }else if(viralDamageMods.size() > 0){
          viralDamage = toxinDamage;
          toxinDamage = 0.0;
        }else if(corrosiveDamageMods.size() > 0){
          corrosiveDamage = toxinDamage;
          toxinDamage = 0.0;
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
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_CORPUS_DAMAGE)){
        corpusMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_CORPUS_DAMAGE)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_GRINEER_DAMAGE)){
        grineerMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_GRINEER_DAMAGE)))*(1.0+modRanks.get(i)));
      }
      if(tempMod.effectTypes.contains(Constants.MOD_TYPE_INFESTED_DAMAGE)){
        infestedMods.add((tempMod.effectStrengths.get(tempMod.effectTypes.indexOf(Constants.MOD_TYPE_INFESTED_DAMAGE)))*(1.0+modRanks.get(i)));
      }
    }
    
    //Calculate finals
    finalMag = mag;
    for(int i = 0; i < magMods.size(); i++){
      finalMag += mag*magMods.get(i);
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
    }else if(weaponMode.equals(Constants.BURST)){
      finalFireRate = fireRate;
      finalBurstFireRate = burstFireRate;
      for(int i = 0; i < fireRateMods.size(); i++){
        finalBurstFireRate += burstFireRate*fireRateMods.get(i);
      }
      for(int i = 0; i < fireRateMods.size(); i++){
        finalFireRate += fireRate*fireRateMods.get(i);
      }
    }else{
      finalFireRate = fireRate;
      for(int i = 0; i < fireRateMods.size(); i++){
        finalFireRate += fireRate*fireRateMods.get(i);
      }
    }
    
    //This is completely retarded, but also the current case
    if(weaponMode.equals(Constants.SEMI_AUTO) || weaponMode.equals(Constants.BURST)){
      if(finalFireRate > 10.0){
        finalFireRate = 10.0;
      }
    }
    
    finalReloadTime = reloadTime;
    for(int i = 0; i < reloadTimeMods.size(); i++){
      finalReloadTime -= reloadTime*reloadTimeMods.get(i);
    }
    
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
    
    if(damageType.equals(Constants.PHYSICAL_WEAPON_DAMAGE)){
      
      finalImpactDamage = impactDamage;
      for(int i = 0; i < impactDamageMods.size(); i++){
        finalImpactDamage += impactDamage*impactDamageMods.size();
      }
      finalImpactDamage *= finalDamageMult;
      
      finalPunctureDamage = punctureDamage;
      for(int i = 0; i < punctureDamageMods.size(); i++){
        finalPunctureDamage += punctureDamage*punctureDamageMods.size();
      }
      finalPunctureDamage *= finalDamageMult;
      
      finalSlashDamage = slashDamage;
      for(int i = 0; i < slashDamageMods.size(); i++){
        finalSlashDamage += slashDamage*slashDamageMods.size();
      }
      finalSlashDamage *= finalDamageMult;
    }
    
    finalFireDamage = fireDamage;
    for(int i = 0; i < fireDamageMods.size(); i++){
      finalFireDamage += rawDamage*fireDamageMods.get(i);
    }
    finalFireDamage *= finalDamageMult;
    
    finalIceDamage = iceDamage;
    for(int i = 0; i < iceDamageMods.size(); i++){
      finalIceDamage += rawDamage*iceDamageMods.get(i);
    }
    finalIceDamage *= finalDamageMult;
    
    finalElectricDamage = electricDamage;
    for(int i = 0; i < electricDamageMods.size(); i++){
      finalElectricDamage += rawDamage*electricDamageMods.get(i);
    }
    finalElectricDamage *= finalDamageMult;
    
    finalToxinDamage = toxinDamage;
    for(int i = 0; i < toxinDamageMods.size(); i++){
      finalToxinDamage += rawDamage*toxinDamageMods.get(i);
    }
    finalToxinDamage *= finalDamageMult;
    
    finalBlastDamage = blastDamage;
    for(int i = 0; i < blastDamageMods.size(); i++){
      finalBlastDamage += rawDamage*blastDamageMods.get(i);
    }
    finalBlastDamage *= finalDamageMult;
    
    finalMagneticDamage = magneticDamage;
    for(int i = 0; i < magneticDamageMods.size(); i++){
      finalMagneticDamage += rawDamage*magneticDamageMods.get(i);
    }
    finalMagneticDamage *= finalDamageMult;
    
    finalGasDamage = gasDamage;
    for(int i = 0; i < gasDamageMods.size(); i++){
      finalGasDamage += rawDamage*gasDamageMods.get(i);
    }
    finalGasDamage *= finalDamageMult;
    
    finalRadiationDamage = radiationDamage;
    for(int i = 0; i < radiationDamageMods.size(); i++){
      finalRadiationDamage += rawDamage*radiationDamageMods.get(i);
    }
    finalRadiationDamage *= finalDamageMult;
    
    finalCorrosiveDamage = corrosiveDamage;
    for(int i = 0; i < corrosiveDamageMods.size(); i++){
      finalCorrosiveDamage += rawDamage*corrosiveDamageMods.get(i);
    }
    finalCorrosiveDamage *= finalDamageMult;
    
    finalViralDamage = viralDamage;
    for(int i = 0; i < viralDamageMods.size(); i++){
      finalViralDamage += rawDamage*viralDamageMods.get(i);
    }
    finalViralDamage *= finalDamageMult;
    
    finalRawDamage =  finalImpactDamage +
                      finalPunctureDamage +
                      finalSlashDamage +
                      finalFireDamage +
                      finalIceDamage +
                      finalElectricDamage +
                      finalToxinDamage +
                      finalBlastDamage +
                      finalMagneticDamage +
                      finalGasDamage +
                      finalRadiationDamage +
                      finalCorrosiveDamage +
                      finalViralDamage;
    
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
      finalNormalShots = (finalNormalShots / continuousDrainRate) * CONTINUOUS_MULT;
      finalCritShots = (finalCritShots / continuousDrainRate) * CONTINUOUS_MULT;
    }
    
    if(weaponMode.equals(Constants.CONTINUOUS)){
      finalIterationTime = (finalMag / continuousDrainRate) + finalReloadTime;
    }else if(weaponMode.equals(Constants.BURST)){
      double numBursts = finalMag / burstCount;
      double rawFireTime = numBursts / finalFireRate;
      double rawBurstTime = burstCount / finalBurstFireRate;
      finalIterationTime = (rawBurstTime * numBursts) + rawFireTime + finalReloadTime;
    }else if(weaponMode.equals(Constants.FULL_AUTO_RAMP_UP)){
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
    if(finalSlashDamage > 0.0){
      slashStacks = calculateAverageStacks(finalStatusChance, 6.0);
    }
    if(finalFireDamage > 0.0){
      fireStacks = calculateAverageStacks(finalStatusChance, 6.0);
    }
    if(finalToxinDamage > 0.0){
      toxinStacks = calculateAverageStacks(finalStatusChance, 8.0);
    }
    if(finalGasDamage > 0.0){
      gasStacks = calculateAverageStacks(finalStatusChance, 8.0);
    }
  }
  
  /**
   * Calculates the damage per shot values
   */
  protected static void calculateDamagePerShot(){
    
    //Calculate base damage per shot values
    impactDamagePerShot = (finalImpactDamage * finalProjectileCount);
    punctureDamagePerShot = (finalPunctureDamage * finalProjectileCount);
    slashDamagePerShot = (finalSlashDamage * finalProjectileCount);
    fireDamagePerShot = (finalFireDamage * finalProjectileCount);
    iceDamagePerShot = (finalIceDamage * finalProjectileCount);
    electricDamagePerShot = (finalElectricDamage * finalProjectileCount);
    toxinDamagePerShot = (finalToxinDamage * finalProjectileCount);
    blastDamagePerShot = (finalBlastDamage * finalProjectileCount);
    magneticDamagePerShot = (finalMagneticDamage * finalProjectileCount);
    gasDamagePerShot = (finalGasDamage * finalProjectileCount);
    radiationDamagePerShot = (finalRadiationDamage * finalProjectileCount);
    corrosiveDamagePerShot = (finalCorrosiveDamage * finalProjectileCount);
    viralDamagePerShot = (finalViralDamage * finalProjectileCount);
    rawDamagePerShot =  impactDamagePerShot +
                        punctureDamagePerShot +
                        slashDamagePerShot +
                        fireDamagePerShot +
                        iceDamagePerShot +
                        electricDamagePerShot +
                        toxinDamagePerShot +
                        blastDamagePerShot +
                        magneticDamagePerShot +
                        gasDamagePerShot +
                        radiationDamagePerShot +
                        corrosiveDamagePerShot +
                        viralDamagePerShot;
    
    //Surface-specific
    corpusDamagePerShot = rawDamagePerShot * finalCorpusMult;
    grineerDamagePerShot = rawDamagePerShot * finalGrineerMult;
    
    infestedDamagePerShot += impactDamagePerShot;
    infestedDamagePerShot += punctureDamagePerShot;
    infestedDamagePerShot += slashDamagePerShot * 1.25;
    infestedDamagePerShot += fireDamagePerShot * 1.25;
    infestedDamagePerShot += iceDamagePerShot;
    infestedDamagePerShot += electricDamagePerShot;
    infestedDamagePerShot += toxinDamagePerShot;
    infestedDamagePerShot += blastDamagePerShot;
    infestedDamagePerShot += magneticDamagePerShot;
    infestedDamagePerShot += gasDamagePerShot * 1.75;
    infestedDamagePerShot += radiationDamagePerShot * 0.5;
    infestedDamagePerShot += corrosiveDamagePerShot;
    infestedDamagePerShot += viralDamagePerShot * 0.5;
    infestedDamagePerShot *= finalInfestedMult;
    
    cloneFleshDamagePerShot += impactDamagePerShot * 0.75;
    cloneFleshDamagePerShot += punctureDamagePerShot;
    cloneFleshDamagePerShot += slashDamagePerShot * 1.25;
    cloneFleshDamagePerShot += fireDamagePerShot * 1.25;
    cloneFleshDamagePerShot += iceDamagePerShot;
    cloneFleshDamagePerShot += electricDamagePerShot;
    cloneFleshDamagePerShot += toxinDamagePerShot;
    cloneFleshDamagePerShot += blastDamagePerShot;
    cloneFleshDamagePerShot += magneticDamagePerShot;
    cloneFleshDamagePerShot += gasDamagePerShot * 0.5;
    cloneFleshDamagePerShot += radiationDamagePerShot;
    cloneFleshDamagePerShot += corrosiveDamagePerShot;
    cloneFleshDamagePerShot += viralDamagePerShot * 1.75;

    ferriteDamagePerShot += impactDamagePerShot;
    ferriteDamagePerShot += punctureDamagePerShot * 1.5;
    ferriteDamagePerShot += slashDamagePerShot * 0.85;
    ferriteDamagePerShot += fireDamagePerShot;
    ferriteDamagePerShot += iceDamagePerShot;
    ferriteDamagePerShot += electricDamagePerShot;
    ferriteDamagePerShot += toxinDamagePerShot * 1.25;
    ferriteDamagePerShot += blastDamagePerShot * 0.75;
    ferriteDamagePerShot += magneticDamagePerShot;
    ferriteDamagePerShot += gasDamagePerShot;
    ferriteDamagePerShot += radiationDamagePerShot;
    ferriteDamagePerShot += corrosiveDamagePerShot * 1.75;
    ferriteDamagePerShot += viralDamagePerShot;
    
    alloyDamagePerShot += impactDamagePerShot;
    alloyDamagePerShot += punctureDamagePerShot * 1.15;
    alloyDamagePerShot += slashDamagePerShot * 0.5;
    alloyDamagePerShot += fireDamagePerShot;
    alloyDamagePerShot += iceDamagePerShot * 1.25;
    alloyDamagePerShot += electricDamagePerShot * 0.5;
    alloyDamagePerShot += toxinDamagePerShot;
    alloyDamagePerShot += blastDamagePerShot;
    alloyDamagePerShot += magneticDamagePerShot * 0.5;
    alloyDamagePerShot += gasDamagePerShot;
    alloyDamagePerShot += radiationDamagePerShot * 1.75;
    alloyDamagePerShot += corrosiveDamagePerShot;
    alloyDamagePerShot += viralDamagePerShot;
    
    mechanicalDamagePerShot += impactDamagePerShot * 1.25;
    mechanicalDamagePerShot += punctureDamagePerShot;
    mechanicalDamagePerShot += slashDamagePerShot;
    mechanicalDamagePerShot += fireDamagePerShot;
    mechanicalDamagePerShot += iceDamagePerShot;
    mechanicalDamagePerShot += electricDamagePerShot * 1.5;
    mechanicalDamagePerShot += toxinDamagePerShot * 0.75;
    mechanicalDamagePerShot += blastDamagePerShot * 1.75;
    mechanicalDamagePerShot += magneticDamagePerShot;
    mechanicalDamagePerShot += gasDamagePerShot;
    mechanicalDamagePerShot += radiationDamagePerShot;
    mechanicalDamagePerShot += corrosiveDamagePerShot;
    mechanicalDamagePerShot += viralDamagePerShot * 0.75;
    
    corpusFleshDamagePerShot += impactDamagePerShot * 0.75;
    corpusFleshDamagePerShot += punctureDamagePerShot;
    corpusFleshDamagePerShot += slashDamagePerShot * 1.25;
    corpusFleshDamagePerShot += fireDamagePerShot;
    corpusFleshDamagePerShot += iceDamagePerShot;
    corpusFleshDamagePerShot += electricDamagePerShot;
    corpusFleshDamagePerShot += toxinDamagePerShot * 1.5;
    corpusFleshDamagePerShot += blastDamagePerShot;
    corpusFleshDamagePerShot += magneticDamagePerShot;
    corpusFleshDamagePerShot += gasDamagePerShot * 0.75;
    corpusFleshDamagePerShot += radiationDamagePerShot;
    corpusFleshDamagePerShot += corrosiveDamagePerShot;
    corpusFleshDamagePerShot += viralDamagePerShot * 1.5;
    
    shieldDamagePerShot += impactDamagePerShot * 1.5;
    shieldDamagePerShot += punctureDamagePerShot * 0.85;
    shieldDamagePerShot += slashDamagePerShot;
    shieldDamagePerShot += fireDamagePerShot;
    shieldDamagePerShot += iceDamagePerShot * 1.5;
    shieldDamagePerShot += electricDamagePerShot;
    shieldDamagePerShot += toxinDamagePerShot;
    shieldDamagePerShot += blastDamagePerShot;
    shieldDamagePerShot += magneticDamagePerShot * 1.75;
    shieldDamagePerShot += gasDamagePerShot;
    shieldDamagePerShot += radiationDamagePerShot * 0.75;
    shieldDamagePerShot += corrosiveDamagePerShot;
    shieldDamagePerShot += viralDamagePerShot;
    
    protoShieldDamagePerShot += impactDamagePerShot * 1.15;
    protoShieldDamagePerShot += punctureDamagePerShot * 0.5;
    protoShieldDamagePerShot += slashDamagePerShot;
    protoShieldDamagePerShot += fireDamagePerShot * 0.5;
    protoShieldDamagePerShot += iceDamagePerShot;
    protoShieldDamagePerShot += electricDamagePerShot;
    protoShieldDamagePerShot += toxinDamagePerShot * 1.25;
    protoShieldDamagePerShot += blastDamagePerShot;
    protoShieldDamagePerShot += magneticDamagePerShot * 1.75;
    protoShieldDamagePerShot += gasDamagePerShot;
    protoShieldDamagePerShot += radiationDamagePerShot;
    protoShieldDamagePerShot += corrosiveDamagePerShot * 0.5;
    protoShieldDamagePerShot += viralDamagePerShot;
    
    roboticDamagePerShot += impactDamagePerShot;
    roboticDamagePerShot += punctureDamagePerShot * 1.25;
    roboticDamagePerShot += slashDamagePerShot * 0.75;
    roboticDamagePerShot += fireDamagePerShot;
    roboticDamagePerShot += iceDamagePerShot;
    roboticDamagePerShot += electricDamagePerShot * 1.5;
    roboticDamagePerShot += toxinDamagePerShot * 0.75;
    roboticDamagePerShot += blastDamagePerShot;
    roboticDamagePerShot += magneticDamagePerShot;
    roboticDamagePerShot += gasDamagePerShot;
    roboticDamagePerShot += radiationDamagePerShot * 1.25;
    roboticDamagePerShot += corrosiveDamagePerShot;
    roboticDamagePerShot += viralDamagePerShot;
    
    infestedFleshDamagePerShot += impactDamagePerShot;
    infestedFleshDamagePerShot += punctureDamagePerShot;
    infestedFleshDamagePerShot += slashDamagePerShot * 1.5;
    infestedFleshDamagePerShot += fireDamagePerShot * 1.5;
    infestedFleshDamagePerShot += iceDamagePerShot * 0.5;
    infestedFleshDamagePerShot += electricDamagePerShot;
    infestedFleshDamagePerShot += toxinDamagePerShot;
    infestedFleshDamagePerShot += blastDamagePerShot;
    infestedFleshDamagePerShot += magneticDamagePerShot;
    infestedFleshDamagePerShot += gasDamagePerShot * 1.5;
    infestedFleshDamagePerShot += radiationDamagePerShot;
    infestedFleshDamagePerShot += corrosiveDamagePerShot;
    infestedFleshDamagePerShot += viralDamagePerShot;
    
    fossilizedDamagePerShot += impactDamagePerShot;
    fossilizedDamagePerShot += punctureDamagePerShot;
    fossilizedDamagePerShot += slashDamagePerShot * 1.15;
    fossilizedDamagePerShot += fireDamagePerShot;
    fossilizedDamagePerShot += iceDamagePerShot * 0.75;
    fossilizedDamagePerShot += electricDamagePerShot;
    fossilizedDamagePerShot += toxinDamagePerShot * 0.5;
    fossilizedDamagePerShot += blastDamagePerShot * 1.5;
    fossilizedDamagePerShot += magneticDamagePerShot;
    fossilizedDamagePerShot += gasDamagePerShot;
    fossilizedDamagePerShot += radiationDamagePerShot * 0.25;
    fossilizedDamagePerShot += corrosiveDamagePerShot * 1.75;
    fossilizedDamagePerShot += viralDamagePerShot;
    
    sinewDamagePerShot += impactDamagePerShot;
    sinewDamagePerShot += punctureDamagePerShot * 1.25;
    sinewDamagePerShot += slashDamagePerShot;
    sinewDamagePerShot += fireDamagePerShot;
    sinewDamagePerShot += iceDamagePerShot * 1.25;
    sinewDamagePerShot += electricDamagePerShot;
    sinewDamagePerShot += toxinDamagePerShot;
    sinewDamagePerShot += blastDamagePerShot * 0.5;
    sinewDamagePerShot += magneticDamagePerShot;
    sinewDamagePerShot += gasDamagePerShot;
    sinewDamagePerShot += radiationDamagePerShot * 1.5;
    sinewDamagePerShot += corrosiveDamagePerShot;
    sinewDamagePerShot += viralDamagePerShot;
    
    //Calculate crit damage per shot values
    rawCritDamagePerShot = rawDamagePerShot * finalCritMult;
    impactCritDamagePerShot = impactDamagePerShot * finalCritMult;
    punctureCritDamagePerShot = punctureDamagePerShot * finalCritMult;
    slashCritDamagePerShot = slashDamagePerShot * finalCritMult;
    fireCritDamagePerShot = fireDamagePerShot * finalCritMult;
    iceCritDamagePerShot = iceDamagePerShot * finalCritMult;
    electricCritDamagePerShot = electricDamagePerShot * finalCritMult;
    toxinCritDamagePerShot = toxinDamagePerShot * finalCritMult;
    blastCritDamagePerShot = blastDamagePerShot * finalCritMult;
    magneticCritDamagePerShot = magneticDamagePerShot * finalCritMult;
    gasCritDamagePerShot = gasDamagePerShot * finalCritMult;
    radiationCritDamagePerShot = radiationDamagePerShot * finalCritMult;
    corrosiveCritDamagePerShot = corrosiveDamagePerShot * finalCritMult;
    viralCritDamagePerShot = viralDamagePerShot * finalCritMult;
    corpusCritDamagePerShot = corpusDamagePerShot * finalCritMult;
    grineerCritDamagePerShot = grineerDamagePerShot * finalCritMult;
    infestedCritDamagePerShot = infestedDamagePerShot * finalCritMult;
    cloneFleshCritDamagePerShot = cloneFleshDamagePerShot * finalCritMult;
    ferriteCritDamagePerShot = ferriteDamagePerShot * finalCritMult;
    alloyCritDamagePerShot = alloyDamagePerShot * finalCritMult;
    mechanicalCritDamagePerShot = mechanicalDamagePerShot * finalCritMult;
    corpusFleshCritDamagePerShot = corpusFleshDamagePerShot * finalCritMult;
    shieldCritDamagePerShot = shieldDamagePerShot * finalCritMult;
    protoShieldCritDamagePerShot = protoShieldDamagePerShot * finalCritMult;
    roboticCritDamagePerShot = roboticDamagePerShot * finalCritMult;
    infestedFleshCritDamagePerShot = infestedFleshDamagePerShot * finalCritMult;
    fossilizedCritDamagePerShot = fossilizedDamagePerShot * finalCritMult;
    sinewCritDamagePerShot = sinewDamagePerShot * finalCritMult;

    
    //Calculate first-shot damage
    rawFirstShotDamage = rawCritDamagePerShot * finalFirstShotDamageMult;
    impactFirstShotDamage = impactCritDamagePerShot * finalFirstShotDamageMult;
    punctureFirstShotDamage = punctureCritDamagePerShot * finalFirstShotDamageMult;
    slashFirstShotDamage = slashCritDamagePerShot * finalFirstShotDamageMult;
    fireFirstShotDamage = fireCritDamagePerShot * finalFirstShotDamageMult;
    iceFirstShotDamage = iceCritDamagePerShot * finalFirstShotDamageMult;
    electricFirstShotDamage = electricCritDamagePerShot * finalFirstShotDamageMult;
    toxinFirstShotDamage = toxinCritDamagePerShot * finalFirstShotDamageMult;
    blastFirstShotDamage = blastCritDamagePerShot * finalFirstShotDamageMult;
    magneticFirstShotDamage = magneticCritDamagePerShot * finalFirstShotDamageMult;
    gasFirstShotDamage = gasCritDamagePerShot * finalFirstShotDamageMult;
    radiationFirstShotDamage = radiationCritDamagePerShot * finalFirstShotDamageMult;
    corrosiveFirstShotDamage = corrosiveCritDamagePerShot * finalFirstShotDamageMult;
    viralFirstShotDamage = viralCritDamagePerShot * finalFirstShotDamageMult;
    corpusFirstShotDamage = corpusCritDamagePerShot * finalFirstShotDamageMult;
    grineerFirstShotDamage = grineerCritDamagePerShot * finalFirstShotDamageMult;
    infestedFirstShotDamage = infestedCritDamagePerShot * finalFirstShotDamageMult;
    cloneFleshFirstShotDamage = cloneFleshCritDamagePerShot * finalFirstShotDamageMult;
    ferriteFirstShotDamage = ferriteCritDamagePerShot * finalFirstShotDamageMult;
    alloyFirstShotDamage = alloyCritDamagePerShot * finalFirstShotDamageMult;
    mechanicalFirstShotDamage = mechanicalCritDamagePerShot * finalFirstShotDamageMult;
    corpusFleshFirstShotDamage = corpusFleshCritDamagePerShot * finalFirstShotDamageMult;
    shieldFirstShotDamage = shieldCritDamagePerShot * finalFirstShotDamageMult;
    protoShieldFirstShotDamage = protoShieldCritDamagePerShot * finalFirstShotDamageMult;
    roboticFirstShotDamage = roboticCritDamagePerShot * finalFirstShotDamageMult;
    infestedFleshFirstShotDamage = infestedFleshCritDamagePerShot * finalFirstShotDamageMult;
    fossilizedFirstShotDamage = fossilizedCritDamagePerShot * finalFirstShotDamageMult;
    sinewFirstShotDamage = sinewCritDamagePerShot * finalFirstShotDamageMult;
    
  }
  
  /**
   * Calculates the total damage done over an entire magazine
   */
  protected static void calculateDamagePerIteration(){
    rawDamagePerIteration = (rawDamagePerShot * finalNormalShots) + (rawCritDamagePerShot * finalCritShots) + rawFirstShotDamage;
    impactDamagePerIteration = (impactDamagePerShot * finalNormalShots) + (impactCritDamagePerShot * finalCritShots) + impactFirstShotDamage;
    punctureDamagePerIteration = (punctureDamagePerShot * finalNormalShots) + (punctureCritDamagePerShot * finalCritShots) + punctureFirstShotDamage;
    slashDamagePerIteration = (slashDamagePerShot * finalNormalShots) + (slashCritDamagePerShot * finalCritShots) + slashFirstShotDamage;
    fireDamagePerIteration = (fireDamagePerShot * finalNormalShots) + (fireCritDamagePerShot * finalCritShots) + fireFirstShotDamage;
    iceDamagePerIteration = (iceDamagePerShot * finalNormalShots) + (iceCritDamagePerShot * finalCritShots) + iceFirstShotDamage;
    electricDamagePerIteration = (electricDamagePerShot * finalNormalShots) + (electricCritDamagePerShot * finalCritShots) + electricFirstShotDamage;
    toxinDamagePerIteration = (toxinDamagePerShot * finalNormalShots) + (toxinCritDamagePerShot * finalCritShots) + toxinFirstShotDamage;
    blastDamagePerIteration = (blastDamagePerShot * finalNormalShots) + (blastCritDamagePerShot * finalCritShots) + blastFirstShotDamage;
    magneticDamagePerIteration = (magneticDamagePerShot * finalNormalShots) + (magneticCritDamagePerShot * finalCritShots) + magneticFirstShotDamage;
    gasDamagePerIteration = (gasDamagePerShot * finalNormalShots) + (gasCritDamagePerShot * finalCritShots) + gasFirstShotDamage;
    radiationDamagePerIteration = (radiationDamagePerShot * finalNormalShots) + (radiationCritDamagePerShot * finalCritShots) + radiationFirstShotDamage;
    corrosiveDamagePerIteration = (corrosiveDamagePerShot * finalNormalShots) + (corrosiveCritDamagePerShot * finalCritShots) + corrosiveFirstShotDamage;
    viralDamagePerIteration = (viralDamagePerShot * finalNormalShots) + (viralCritDamagePerShot * finalCritShots) + viralFirstShotDamage;
    corpusDamagePerIteration = (corpusDamagePerShot * finalNormalShots) + (corpusCritDamagePerShot * finalCritShots) + corpusFirstShotDamage;
    grineerDamagePerIteration = (grineerDamagePerShot * finalNormalShots) + (grineerCritDamagePerShot * finalCritShots) + grineerFirstShotDamage;
    infestedDamagePerIteration = (infestedDamagePerShot * finalNormalShots) + (infestedCritDamagePerShot * finalCritShots) + infestedFirstShotDamage;
    cloneFleshDamagePerIteration = (cloneFleshDamagePerShot * finalNormalShots) + (cloneFleshCritDamagePerShot * finalCritShots) + cloneFleshFirstShotDamage;
    ferriteDamagePerIteration = (ferriteDamagePerShot * finalNormalShots) + (ferriteCritDamagePerShot * finalCritShots) + ferriteFirstShotDamage;
    alloyDamagePerIteration = (alloyDamagePerShot * finalNormalShots) + (alloyCritDamagePerShot * finalCritShots) + alloyFirstShotDamage;
    mechanicalDamagePerIteration = (mechanicalDamagePerShot * finalNormalShots) + (mechanicalCritDamagePerShot * finalCritShots) + mechanicalFirstShotDamage;
    corpusFleshDamagePerIteration = (corpusFleshDamagePerShot * finalNormalShots) + (corpusFleshCritDamagePerShot * finalCritShots) + corpusFleshFirstShotDamage;
    shieldDamagePerIteration = (shieldDamagePerShot * finalNormalShots) + (shieldCritDamagePerShot * finalCritShots) + shieldFirstShotDamage;
    protoShieldDamagePerIteration = (protoShieldDamagePerShot * finalNormalShots) + (protoShieldCritDamagePerShot * finalCritShots) + protoShieldFirstShotDamage;
    roboticDamagePerIteration = (roboticDamagePerShot * finalNormalShots) + (roboticCritDamagePerShot * finalCritShots) + roboticFirstShotDamage;
    infestedFleshDamagePerIteration = (infestedFleshDamagePerShot * finalNormalShots) + (infestedFleshCritDamagePerShot * finalCritShots) + infestedFleshFirstShotDamage;
    fossilizedDamagePerIteration = (fossilizedDamagePerShot * finalNormalShots) + (fossilizedCritDamagePerShot * finalCritShots) + fossilizedFirstShotDamage;
    sinewDamagePerIteration = (sinewDamagePerShot * finalNormalShots) + (sinewCritDamagePerShot * finalCritShots) + sinewFirstShotDamage;
    
  }
  
  /** 
   * Calculates the total damage dealt over a given minute.
   */
  protected static void calculateDamagePerMinute(){
    rawDamagePerMinute = rawDamagePerIteration * finalIterationsPerMinute;
    impactDamagePerMinute = impactDamagePerIteration * finalIterationsPerMinute;
    punctureDamagePerMinute = punctureDamagePerIteration * finalIterationsPerMinute;
    slashDamagePerMinute = slashDamagePerIteration * finalIterationsPerMinute;
    fireDamagePerMinute = fireDamagePerIteration * finalIterationsPerMinute;
    iceDamagePerMinute = iceDamagePerIteration * finalIterationsPerMinute;
    electricDamagePerMinute = electricDamagePerIteration * finalIterationsPerMinute;
    toxinDamagePerMinute = toxinDamagePerIteration * finalIterationsPerMinute;
    blastDamagePerMinute = blastDamagePerIteration * finalIterationsPerMinute;
    magneticDamagePerMinute = magneticDamagePerIteration * finalIterationsPerMinute;
    gasDamagePerMinute = gasDamagePerIteration * finalIterationsPerMinute;
    radiationDamagePerMinute = radiationDamagePerIteration * finalIterationsPerMinute;
    corrosiveDamagePerMinute = corrosiveDamagePerIteration * finalIterationsPerMinute;
    viralDamagePerMinute = viralDamagePerIteration * finalIterationsPerMinute;
    corpusDamagePerMinute = corpusDamagePerIteration * finalIterationsPerMinute;
    grineerDamagePerMinute = grineerDamagePerIteration * finalIterationsPerMinute;
    infestedDamagePerMinute = infestedDamagePerIteration * finalIterationsPerMinute;
    cloneFleshDamagePerMinute = cloneFleshDamagePerIteration * finalIterationsPerMinute;
    ferriteDamagePerMinute = ferriteDamagePerIteration * finalIterationsPerMinute;
    alloyDamagePerMinute = alloyDamagePerIteration * finalIterationsPerMinute;
    mechanicalDamagePerMinute = mechanicalDamagePerIteration * finalIterationsPerMinute;
    corpusFleshDamagePerMinute = corpusFleshDamagePerIteration * finalIterationsPerMinute;
    shieldDamagePerMinute = shieldDamagePerIteration * finalIterationsPerMinute;
    protoShieldDamagePerMinute = protoShieldDamagePerIteration * finalIterationsPerMinute;
    roboticDamagePerMinute = roboticDamagePerIteration * finalIterationsPerMinute;
    infestedFleshDamagePerMinute = infestedFleshDamagePerIteration * finalIterationsPerMinute;
    fossilizedDamagePerMinute = fossilizedDamagePerIteration * finalIterationsPerMinute;
    sinewDamagePerMinute = sinewDamagePerIteration * finalIterationsPerMinute;
  }
  
  protected static void calculateDamagePerSecond(){
    //Calculate base DPS values
    rawDamagePerSecond = rawDamagePerMinute / 60.0;
    impactDamagePerSecond = impactDamagePerMinute / 60.0;
    punctureDamagePerSecond = punctureDamagePerMinute / 60.0;
    slashDamagePerSecond = slashDamagePerMinute / 60.0;
    fireDamagePerSecond = fireDamagePerMinute / 60.0;
    iceDamagePerSecond = iceDamagePerMinute / 60.0;
    electricDamagePerSecond = electricDamagePerMinute / 60.0;
    toxinDamagePerSecond = toxinDamagePerMinute / 60.0;
    blastDamagePerSecond = blastDamagePerMinute / 60.0;
    magneticDamagePerSecond = magneticDamagePerMinute / 60.0;
    gasDamagePerSecond = gasDamagePerMinute / 60.0;
    radiationDamagePerSecond = radiationDamagePerMinute / 60.0;
    corrosiveDamagePerSecond = corrosiveDamagePerMinute / 60.0;
    viralDamagePerSecond = viralDamagePerMinute / 60.0;
    corpusDamagePerSecond = corpusDamagePerMinute / 60.0;
    grineerDamagePerSecond = grineerDamagePerMinute / 60.0;
    infestedDamagePerSecond = infestedDamagePerMinute / 60.0;
    cloneFleshDamagePerSecond = cloneFleshDamagePerMinute / 60.0;
    ferriteDamagePerSecond = ferriteDamagePerMinute / 60.0;
    alloyDamagePerSecond = alloyDamagePerMinute / 60.0;
    mechanicalDamagePerSecond = mechanicalDamagePerMinute / 60.0;
    corpusFleshDamagePerSecond = corpusFleshDamagePerMinute / 60.0;
    shieldDamagePerSecond = shieldDamagePerMinute / 60.0;
    protoShieldDamagePerSecond = protoShieldDamagePerMinute / 60.0;
    roboticDamagePerSecond = roboticDamagePerMinute / 60.0;
    infestedFleshDamagePerSecond = infestedFleshDamagePerMinute / 60.0;
    fossilizedDamagePerSecond = fossilizedDamagePerMinute / 60.0;
    sinewDamagePerSecond = sinewDamagePerMinute / 60.0;
    
    //Add in DoTs
    double rawBase = (rawDamage * finalDamageMult) * finalProjectileCount;
    double critBase = rawBase * finalCritMult;
    double DoTBase = (((rawBase * finalNormalShots) + (critBase * finalCritShots) + rawFirstShotDamage) / finalMag);// / finalProjectileCount;
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
    rawDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    corpusDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    grineerDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    infestedDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    cloneFleshDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    ferriteDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    alloyDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    mechanicalDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    corpusFleshDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    shieldDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    protoShieldDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    roboticDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    infestedFleshDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    fossilizedDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    sinewDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
  }
  
  protected static void calculateBurstDamagePerSecond(){
    //Calculate base Burst DPS values
    double burstTime = (60.0 / (finalIterationTime - finalReloadTime)) / 60.0;
    rawBurstDamagePerSecond = rawDamagePerIteration * burstTime;
    impactBurstDamagePerSecond = impactDamagePerIteration * burstTime;
    punctureBurstDamagePerSecond = punctureDamagePerIteration * burstTime;
    slashBurstDamagePerSecond = slashDamagePerIteration * burstTime;
    fireBurstDamagePerSecond = fireDamagePerIteration * burstTime;
    iceBurstDamagePerSecond = iceDamagePerIteration * burstTime;
    electricBurstDamagePerSecond = electricDamagePerIteration * burstTime;
    toxinBurstDamagePerSecond = toxinDamagePerIteration * burstTime;
    blastBurstDamagePerSecond = blastDamagePerIteration * burstTime;
    magneticBurstDamagePerSecond = magneticDamagePerIteration * burstTime;
    gasBurstDamagePerSecond = gasDamagePerIteration * burstTime;
    radiationBurstDamagePerSecond = radiationDamagePerIteration * burstTime;
    corrosiveBurstDamagePerSecond = corrosiveDamagePerIteration * burstTime;
    viralBurstDamagePerSecond = viralDamagePerIteration * burstTime;
    corpusBurstDamagePerSecond = corpusDamagePerIteration * burstTime;
    grineerBurstDamagePerSecond = grineerDamagePerIteration * burstTime;
    cloneFleshBurstDamagePerSecond = cloneFleshDamagePerIteration * burstTime;
    infestedBurstDamagePerSecond = infestedDamagePerIteration * burstTime;
    ferriteBurstDamagePerSecond = ferriteDamagePerIteration * burstTime;
    alloyBurstDamagePerSecond = alloyDamagePerIteration * burstTime;
    mechanicalBurstDamagePerSecond = mechanicalDamagePerIteration * burstTime;
    corpusFleshBurstDamagePerSecond = corpusFleshDamagePerIteration * burstTime;
    shieldBurstDamagePerSecond = shieldDamagePerIteration * burstTime;
    protoShieldBurstDamagePerSecond = protoShieldDamagePerIteration * burstTime;
    roboticBurstDamagePerSecond = roboticDamagePerIteration * burstTime;
    infestedFleshBurstDamagePerSecond = infestedFleshDamagePerIteration * burstTime;
    fossilizedBurstDamagePerSecond = fossilizedDamagePerIteration * burstTime;
    sinewBurstDamagePerSecond = sinewDamagePerIteration * burstTime;
    
    //Add in DoTs
    double rawBase = (rawDamage * finalDamageMult) * finalProjectileCount;
    double critBase = rawBase * finalCritMult;
    double DoTBase = (((rawBase * finalNormalShots) + (critBase * finalCritShots) + rawFirstShotDamage) / finalMag);// / finalProjectileCount;
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
    rawBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    corpusBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    grineerBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    infestedBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    cloneFleshBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    ferriteBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    alloyBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    mechanicalBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    corpusFleshBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    shieldBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    protoShieldDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    roboticBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    infestedFleshBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    fossilizedBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
    sinewBurstDamagePerSecond += (bleedDoTDPS + poisonDoTDPS + heatDoTDPS + cloudDoTDPS + electricProcDPS);
  }
  
  /**
   * Calculates the average number of stacks of a given effect
   */
  protected static int calculateAverageStacks(double procRate, double duration){
    
    double millisceondsPerShot = 1000.0 / finalFireRate;
    double stacksPerShot = 1.0 * procRate;
    double reloadTimeMilliseconds = finalReloadTime * 1000.0;
    double stackTotal = 0.0;
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
              stackVec.add(duration);
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
   * Calculates the average time to kill a target with the supplied stats
   */
  public static double calculateTimeToKill(int shields, int health, int armor, String surface, String armorType, String shieldType, String type){
    
  //Target Data
    double targetMaxShields = shields;
    double targetAdjustedMaxShields = targetMaxShields;
    double targetCurrentShields = targetMaxShields;
    double targetMaxHealth = health;
    double targetAdjustedMaxHealth = health;
    double targetCurrentHealth = health;
    double targetMaxArmor = armor;
    double targetAdjustedMaxArmor = armor;
    String targetSurface = surface;
    String armorSurface = armorType;
    String targetType = type;
    double impactMult = 1.0;
    double punctureMult = 1.0;
    double slashMult = 1.0;
    double fireMult = 1.0;
    double iceMult = 1.0;
    double electricMult = 1.0;
    double toxinMult = 1.0;
    double blastMult = 1.0;
    double radiationMult = 1.0;
    double gasMult = 1.0;
    double corrosiveMult = 1.0;
    double viralMult = 1.0;
    double magneticMult = 1.0;
    double armorImpactMult = 1.0;
    double armorPunctureMult = 1.0;
    double armorSlashMult = 1.0;
    double armorFireMult = 1.0;
    double armorIceMult = 1.0;
    double armorElectricMult = 1.0;
    double armorToxinMult = 1.0;
    double armorBlastMult = 1.0;
    double armorRadiationMult = 1.0;
    double armorGasMult = 1.0;
    double armorCorrosiveMult = 1.0;
    double armorViralMult = 1.0;
    double armorMagneticMult = 1.0;
    double shieldImpactMult = 1.0;
    double shieldPunctureMult = 1.0;
    double shieldSlashMult = 1.0;
    double shieldFireMult = 1.0;
    double shieldIceMult = 1.0;
    double shieldElectricMult = 1.0;
    double shieldToxinMult = 1.0;
    double shieldBlastMult = 1.0;
    double shieldRadiationMult = 1.0;
    double shieldGasMult = 1.0;
    double shieldCorrosiveMult = 1.0;
    double shieldViralMult = 1.0;
    double shieldMagneticMult = 1.0;
    double typeMult = 1.0;
    double rawBase = (rawDamage * finalDamageMult) * finalProjectileCount;
    double critBase = rawBase * finalCritMult;
    double DoTBase = (((rawBase * finalNormalShots) + (critBase * finalCritShots) + rawFirstShotDamage) / finalMag);// / finalProjectileCount;
    
    //Health Mults
    if(targetSurface.equals(Constants.ENEMY_SURFACE_CLONE_FLESH)){
      impactMult = 0.75;
      punctureMult = 1.0;
      slashMult = 1.25;
      fireMult = 1.25;
      iceMult = 1.0;
      electricMult = 1.0;
      toxinMult = 1.0;
      blastMult = 1.0;
      radiationMult = 1.0;
      gasMult = 0.5;
      corrosiveMult = 1.0;
      viralMult = 1.75;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_MECHANICAL)){
      impactMult = 1.25;
      punctureMult = 1.0;
      slashMult = 1.0;
      fireMult = 1.0;
      iceMult = 1.0;
      electricMult = 1.5;
      toxinMult = 0.75;
      blastMult = 1.75;
      radiationMult = 1.0;
      gasMult = 1.0;
      corrosiveMult = 1.0;
      viralMult = 0.75;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_CORPUS_FLESH)){
      impactMult = 0.75;
      punctureMult = 1.0;
      slashMult = 1.25;
      fireMult = 1.0;
      iceMult = 1.0;
      electricMult = 1.0;
      toxinMult = 1.5;
      blastMult = 1.0;
      radiationMult = 1.0;
      gasMult = 0.75;
      corrosiveMult = 1.0;
      viralMult = 1.5;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_INFESTED_FLESH)){
      impactMult = 1.0;
      punctureMult = 1.0;
      slashMult = 1.5;
      fireMult = 1.5;
      iceMult = 0.5;
      electricMult = 1.0;
      toxinMult = 1.0;
      blastMult = 1.0;
      radiationMult = 1.0;
      gasMult = 1.5;
      corrosiveMult = 1.0;
      viralMult = 1.0;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_FOSSILIZED)){
      impactMult = 1.0;
      punctureMult = 1.0;
      slashMult = 1.15;
      fireMult = 1.0;
      iceMult = 0.75;
      electricMult = 1.0;
      toxinMult = 0.5;
      blastMult = 1.5;
      radiationMult = 0.25;
      gasMult = 1.0;
      corrosiveMult = 1.75;
      viralMult = 1.0;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_SINEW)){
      impactMult = 1.0;
      punctureMult = 1.25;
      slashMult = 1.0;
      fireMult = 1.0;
      iceMult = 1.25;
      electricMult = 1.0;
      toxinMult = 1.0;
      blastMult = 0.5;
      radiationMult = 1.5;
      gasMult = 1.0;
      corrosiveMult = 1.0;
      viralMult = 1.0;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_ROBOTIC)){
      impactMult = 1.0;
      punctureMult = 1.25;
      slashMult = 0.75;
      fireMult = 1.0;
      iceMult = 1.0;
      electricMult = 1.5;
      toxinMult = 0.75;
      blastMult = 1.0;
      radiationMult = 1.25;
      gasMult = 1.0;
      corrosiveMult = 1.0;
      viralMult = 1.0;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_INFESTED)){
      impactMult = 1.0;
      punctureMult = 1.0;
      slashMult = 1.25;
      fireMult = 1.25;
      iceMult = 1.0;
      electricMult = 1.0;
      toxinMult = 1.0;
      blastMult = 1.0;
      radiationMult = 0.5;
      gasMult = 1.75;
      corrosiveMult = 1.0;
      viralMult = 0.5;
      magneticMult = 1.0;
    }
    
    //Armor Mults
    if(targetSurface.equals(Constants.ENEMY_SURFACE_FERRITE_ARMOR)){
      armorImpactMult = 1.0;
      armorPunctureMult = 1.5;
      armorSlashMult = 0.85;
      armorFireMult = 1.0;
      armorIceMult = 1.0;
      armorElectricMult = 1.0;
      armorToxinMult = 1.25;
      armorBlastMult = 0.75;
      armorRadiationMult = 1.0;
      armorGasMult = 1.0;
      armorCorrosiveMult = 1.75;
      armorViralMult = 1.0;
      armorMagneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_ALLOY_ARMOR)){
      armorImpactMult = 1.0;
      armorPunctureMult = 1.15;
      armorSlashMult = 0.5;
      armorFireMult = 1.0;
      armorIceMult = 1.25;
      armorElectricMult = 0.5;
      armorToxinMult = 1.0;
      armorBlastMult = 1.0;
      armorRadiationMult = 1.75;
      armorGasMult = 1.0;
      armorCorrosiveMult = 1.0;
      armorViralMult = 1.0;
      armorMagneticMult = 0.5;
    }
    
    //Shield Mults
    if(targetSurface.equals(Constants.ENEMY_SURFACE_SHIELDS)){
      shieldImpactMult = 1.5;
      shieldPunctureMult = 0.85;
      shieldSlashMult = 1.0;
      shieldFireMult = 1.0;
      shieldIceMult = 1.0;
      shieldElectricMult = 1.0;
      shieldToxinMult = 1.0;
      shieldBlastMult = 1.0;
      shieldRadiationMult = 0.75;
      shieldGasMult = 1.0;
      shieldCorrosiveMult = 1.0;
      shieldViralMult = 1.0;
      shieldMagneticMult = 1.75;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_PROTO_SHIELD)){
      shieldImpactMult = 1.15;
      shieldPunctureMult = 0.5;
      shieldSlashMult = 1.0;
      shieldFireMult = 0.5;
      shieldIceMult = 1.0;
      shieldElectricMult = 1.0;
      shieldToxinMult = 1.25;
      shieldBlastMult = 1.0;
      shieldRadiationMult = 1.0;
      shieldGasMult = 1.0;
      shieldCorrosiveMult = 0.5;
      shieldViralMult = 1.0;
      shieldMagneticMult = 1.75;
    }
    
    if(targetType.equals(Constants.ENEMY_TYPE_INFESTED)){
      typeMult = finalInfestedMult;
    }else if(targetType.equals(Constants.ENEMY_TYPE_GRINEER)){
      typeMult = finalGrineerMult;
      System.out.println("GRINEER_FOUND::"+typeMult);
    }else if(targetType.equals(Constants.ENEMY_TYPE_CORPUS)){
      typeMult = finalCorpusMult;
    }
    
    //Simulation Data
    double millisceondsPerShot = 1000.0 / finalFireRate;
    double millisecondMult = 1.0;
    double procsPerShot = 1.0 * finalStatusChance;
    double reloadTimeMilliseconds = finalReloadTime * 1000.0;
    double stackTotal = 0.0;
    int reloadTimeCounter = 0;
    int shotCounter = 2147483000;
    int iterations = 0;
    int timeToKill = 0;
    boolean reloading = false;
    Vector<Integer> impactStacks = new Vector<Integer>();
    Vector<Integer> punctureStacks = new Vector<Integer>();
    Vector<DoTPair> slashStacks = new Vector<DoTPair>();
    Vector<DoTPair> fireStacks = new Vector<DoTPair>();
    Vector<Integer> iceStacks = new Vector<Integer>();
    Vector<Integer> electricStacks = new Vector<Integer>();
    Vector<DoTPair> toxinStacks = new Vector<DoTPair>();
    Vector<Integer> blastStacks = new Vector<Integer>();
    Vector<Integer> radiationStacks = new Vector<Integer>();
    Vector<DoTPair> gasStacks = new Vector<DoTPair>();
    Vector<Integer> corrosiveStacks = new Vector<Integer>();
    Vector<Integer> viralStacks = new Vector<Integer>();
    Vector<Integer> magneticStacks = new Vector<Integer>();
    
    double averageImpactDamage = impactDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averagePunctureDamage = punctureDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averageSlashDamage = slashDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averageFireDamage = fireDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averageIceDamage = iceDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averageElectricDamage = electricDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averageToxinDamage = toxinDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averageBlastDamage = blastDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averageCorrosiveDamage = corrosiveDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averageGasDamage = gasDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averageMagneticDamage = magneticDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averageRadiationDamage = radiationDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    double averageViralDamage = viralDamagePerShot * (1.0 + finalCritChance * (finalCritMult - 1.0));
    
    if(weaponMode.equals(Constants.FULL_AUTO_RAMP_UP)){
      millisecondMult = 5.0;
    }
    
    //Run a 600 second simulation to calculate the time to kill
    for(timeToKill=0; timeToKill < 6000000; timeToKill++){
      //Add new stack
      if(!reloading){
        shotCounter++;
        //is it time to fire a new projectile?
        if(shotCounter >= (millisceondsPerShot*millisecondMult)){
          if(weaponMode.equals(Constants.FULL_AUTO_RAMP_UP)){
            millisecondMult--;
            if(millisecondMult < 1.0){
              millisecondMult = 1.0;
            }
          }
          
          //Adjust Max Stats
          //Shields
          targetAdjustedMaxShields = targetMaxShields;
          if(magneticStacks.size() > 0){
            targetAdjustedMaxShields *= 0.25;
          }
          if(targetAdjustedMaxShields < targetCurrentShields){
            targetCurrentShields = targetAdjustedMaxShields;
          }
          //Health
          targetAdjustedMaxHealth = targetMaxHealth;
          if(viralStacks.size() > 0){
            targetAdjustedMaxHealth *= 0.5;
          }
          if(targetAdjustedMaxHealth < targetCurrentHealth){
            targetCurrentHealth = targetAdjustedMaxHealth;
          }
          //Armor
          targetAdjustedMaxArmor = targetMaxArmor;
          if(corrosiveStacks.size() > 0){
            for(int i = 0; i < corrosiveStacks.size(); i++){
              targetAdjustedMaxArmor *= 0.75;
            }
          }
          
          //Calculate Armor Reduction
          double armorReduction = 1.0 - ((targetAdjustedMaxArmor * (1.0/300.0)) / (1.0 + (targetAdjustedMaxArmor * (1.0/300.0))));
          
          //Deal Damage
          if(targetCurrentShields > 0.0){
            targetCurrentShields -= ((averageImpactDamage * typeMult) * shieldImpactMult) * armorReduction;
            targetCurrentShields -= ((averagePunctureDamage * typeMult) * shieldPunctureMult) * armorReduction;
            targetCurrentShields -= ((averageSlashDamage * typeMult) * shieldSlashMult) * armorReduction;
            targetCurrentShields -= ((averageFireDamage * typeMult) * shieldFireMult) * armorReduction;
            targetCurrentShields -= ((averageIceDamage * typeMult) * shieldIceMult) * armorReduction;
            targetCurrentShields -= ((averageElectricDamage * typeMult) * shieldElectricMult) * armorReduction;
            targetCurrentShields -= ((averageToxinDamage * typeMult) * shieldToxinMult) * armorReduction;
            targetCurrentShields -= ((averageBlastDamage * typeMult) * shieldBlastMult) * armorReduction;
            targetCurrentShields -= ((averageCorrosiveDamage * typeMult) * shieldCorrosiveMult) * armorReduction;
            targetCurrentShields -= ((averageGasDamage * typeMult) * shieldGasMult) * armorReduction;
            targetCurrentShields -= ((averageMagneticDamage * typeMult) * shieldMagneticMult) * armorReduction;
            targetCurrentShields -= ((averageRadiationDamage * typeMult) * shieldRadiationMult) * armorReduction;
            targetCurrentShields -= ((averageViralDamage * typeMult) * shieldViralMult) * armorReduction;
          }
          if(targetCurrentShields <= 0.0){
            double shieldDifference = 1.0;
            if(targetCurrentShields < 0.0){
              double unabsorbed = Math.abs(targetCurrentShields);
              double raw = rawDamagePerShot * typeMult;
              shieldDifference = 1.0 - (unabsorbed / raw);
              targetCurrentShields = 0.0;
            }
            
            if(targetAdjustedMaxArmor > 0.0){
              double impactArmorReduciton = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorImpactMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorImpactMult - 1.0))) * (1.0/300.0))));
              double punctureArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorPunctureMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorPunctureMult - 1.0))) * (1.0/300.0))));
              double slashArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorSlashMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorSlashMult - 1.0))) * (1.0/300.0))));
              double fireArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorFireMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorFireMult - 1.0))) * (1.0/300.0))));
              double iceArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorIceMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorIceMult - 1.0))) * (1.0/300.0))));
              double electricArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorElectricMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorElectricMult - 1.0))) * (1.0/300.0))));
              double toxinArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorToxinMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorToxinMult - 1.0))) * (1.0/300.0))));
              double blastArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorBlastMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorBlastMult - 1.0))) * (1.0/300.0))));
              double corrosiveArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorCorrosiveMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorCorrosiveMult - 1.0))) * (1.0/300.0))));
              double gasArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorGasMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorGasMult - 1.0))) * (1.0/300.0))));
              double magneticArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorMagneticMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorMagneticMult - 1.0))) * (1.0/300.0))));
              double radiationArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorRadiationMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorRadiationMult - 1.0))) * (1.0/300.0))));
              double viralArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorViralMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorViralMult - 1.0))) * (1.0/300.0))));
              targetCurrentHealth -= (((averageImpactDamage * typeMult) * armorImpactMult) * impactArmorReduciton) * shieldDifference;
              targetCurrentHealth -= (((averagePunctureDamage * typeMult) * armorPunctureMult) * punctureArmorReduction) * shieldDifference;
              targetCurrentHealth -= (((averageSlashDamage * typeMult) * armorSlashMult) * slashArmorReduction) * shieldDifference;
              targetCurrentHealth -= (((averageFireDamage * typeMult) * armorFireMult) * fireArmorReduction) * shieldDifference;
              targetCurrentHealth -= (((averageIceDamage * typeMult) * armorIceMult) * iceArmorReduction) * shieldDifference;
              targetCurrentHealth -= (((averageElectricDamage * typeMult) * armorElectricMult) * electricArmorReduction) * shieldDifference;
              targetCurrentHealth -= (((averageToxinDamage * typeMult) * armorToxinMult) * toxinArmorReduction) * shieldDifference;
              targetCurrentHealth -= (((averageBlastDamage * typeMult) * armorBlastMult) * blastArmorReduction) * shieldDifference;
              targetCurrentHealth -= (((averageCorrosiveDamage * typeMult) * armorCorrosiveMult) * corrosiveArmorReduction) * shieldDifference;
              targetCurrentHealth -= (((averageGasDamage * typeMult) * armorGasMult) * gasArmorReduction) * shieldDifference;
              targetCurrentHealth -= (((averageMagneticDamage * typeMult) * armorMagneticMult) * magneticArmorReduction) * shieldDifference;
              targetCurrentHealth -= (((averageRadiationDamage * typeMult) * armorRadiationMult) * radiationArmorReduction) * shieldDifference;
              targetCurrentHealth -= (((averageViralDamage * typeMult) * armorViralMult) * viralArmorReduction) * shieldDifference;
            }else{
              targetCurrentHealth -= (averageImpactDamage * typeMult) * impactMult * shieldDifference;
              targetCurrentHealth -= (averagePunctureDamage * typeMult) * punctureMult * shieldDifference;
              targetCurrentHealth -= (averageSlashDamage * typeMult) * slashMult * shieldDifference;
              targetCurrentHealth -= (averageFireDamage * typeMult) * fireMult * shieldDifference;
              targetCurrentHealth -= (averageIceDamage * typeMult) * iceMult * shieldDifference;
              targetCurrentHealth -= (averageElectricDamage * typeMult) * electricMult * shieldDifference;
              targetCurrentHealth -= (averageToxinDamage * typeMult) * toxinMult * shieldDifference;
              targetCurrentHealth -= (averageBlastDamage * typeMult) * blastMult * shieldDifference;
              targetCurrentHealth -= (averageCorrosiveDamage * typeMult) * corrosiveMult * shieldDifference;
              targetCurrentHealth -= (averageGasDamage * typeMult) * gasMult * shieldDifference;
              targetCurrentHealth -= (averageMagneticDamage * typeMult) * magneticMult * shieldDifference;
              targetCurrentHealth -= (averageRadiationDamage * typeMult) * radiationMult * shieldDifference;
              targetCurrentHealth -= (averageViralDamage * typeMult) * viralMult * shieldDifference;
            }
          }
          
          //Add stacks
          for(int p = 0; p < finalProjectileCount; p++){
            stackTotal += procsPerShot;
            if(stackTotal > 1.0){
              if(impactDamagePerShot > 0.0){
                impactStacks.add(1);
              }
              if(punctureDamagePerShot > 0.0){
                punctureStacks.add(6);
              }
              if(slashDamagePerShot > 0.0){
                double bleedDamage = (((DoTBase * typeMult) * slashMult)/finalProjectileCount)*0.35;
                slashStacks.add(new DoTPair(bleedDamage,5));
                targetCurrentHealth -= bleedDamage * slashMult;
              }
              if(fireDamagePerShot > 0.0){
                Double heatDamage = ((((DoTBase * typeMult) * fireMult) * armorReduction)/finalProjectileCount)*0.5;
                fireStacks.add(new DoTPair(heatDamage,5));
                if(targetCurrentShields > 0.0){
                  targetCurrentShields -= heatDamage * shieldFireMult;
                }else{
                  targetCurrentHealth -= heatDamage * fireMult;
                }
              }
              if(iceDamagePerShot > 0.0){
                iceStacks.add(6);
              }
              if(electricDamagePerShot > 0.0){
                //electricStacks.add(1);
                Double electricDamage = ((((averageElectricDamage * typeMult) * electricMult) * armorReduction)/finalProjectileCount);
                if(targetCurrentShields > 0.0){
                  targetCurrentShields -= electricDamage * shieldElectricMult;
                }else{
                  targetCurrentHealth -= electricDamage * electricMult;
                }
              }
              if(toxinDamagePerShot > 0.0){
                double poisonDamage = ((((DoTBase * typeMult) * toxinMult) * armorReduction)/finalProjectileCount)*0.5;
                toxinStacks.add(new DoTPair(poisonDamage,7));
                if(poisonDamage < 10.0){
                  poisonDamage = 10.0;
                }
                targetCurrentHealth -= poisonDamage * toxinMult;
              }
              if(blastDamagePerShot > 0.0){
                blastStacks.add(1);
              }
              if(radiationDamagePerShot > 0.0){
                radiationStacks.add(12);
              }
              if(gasDamagePerShot > 0.0){
                double poisonDamage = ((((DoTBase * typeMult) * gasMult) * armorReduction)/finalProjectileCount)*0.5;
                gasStacks.add(new DoTPair(poisonDamage,7));
                if(poisonDamage < 10.0){
                  poisonDamage = 10.0;
                }
                targetCurrentHealth -= poisonDamage * gasMult;
              }
              if(magneticDamagePerShot > 0.0){
                magneticStacks.add(6);
              }
              if(viralDamagePerShot > 0.0){
                viralStacks.add(6);
              }
              if(corrosiveDamagePerShot > 0.0){
                corrosiveStacks.add(6);
              }
              stackTotal--;
            }
          }
          
          //Check for Death
          if(targetCurrentHealth < 0.0){
            return timeToKill / 1000.0;
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
          if(weaponMode.equals(Constants.FULL_AUTO_RAMP_UP)){
            millisecondMult = 5.0;
          }
        }
      }
      //Is this a whole second?
      if(timeToKill % 1000 == 0){
        //Deal DoT Damage
        if(slashStacks.size() > 0){
          for(int i = 0; i < slashStacks.size(); i++){
            double bleedDamage = slashStacks.get(i).damage;
            targetCurrentHealth -= bleedDamage * slashMult;
          }
        }
        if(fireStacks.size() > 0){
          for(int i = 0; i < fireStacks.size(); i++){
            double heatDamage = fireStacks.get(i).damage;
            if(targetCurrentShields > 0.0){
              targetCurrentShields -= heatDamage * shieldFireMult;
            }else{
              targetCurrentHealth -= heatDamage * fireMult;
            }
          }
        }
        if(toxinStacks.size() > 0){
          for(int i = 0; i < toxinStacks.size(); i++){
            double poisonDamage = toxinStacks.get(i).damage;
            if(poisonDamage < 10.0){
              poisonDamage = 10.0;
            }
            targetCurrentHealth -= poisonDamage * toxinMult;
          }
        }
        if(gasStacks.size() > 0){
          for(int i = 0; i < gasStacks.size(); i++){
            double poisonDamage = gasStacks.get(i).damage;
            if(poisonDamage < 10.0){
              poisonDamage = 10.0;
            }
            targetCurrentHealth -= poisonDamage * gasMult;
          }
        }
        //Decrement stack timers
        for(int j=0;j<impactStacks.size();j++){
          int temp = impactStacks.get(j);
          temp--;
          impactStacks.set(j, temp);
        }
        for(int j=0;j<punctureStacks.size();j++){
          int temp = punctureStacks.get(j);
          temp--;
          punctureStacks.set(j, temp);
        }
        for(int j=0;j<slashStacks.size();j++){
          slashStacks.get(j).duration--;
        }
        for(int j=0;j<fireStacks.size();j++){
          fireStacks.get(j).duration--;
        }
        for(int j=0;j<iceStacks.size();j++){
          int temp = iceStacks.get(j);
          temp--;
          iceStacks.set(j, temp);
        }
        for(int j=0;j<electricStacks.size();j++){
          int temp = electricStacks.get(j);
          temp--;
          electricStacks.set(j, temp);
        }
        for(int j=0;j<toxinStacks.size();j++){
          toxinStacks.get(j).duration--;
        }
        for(int j=0;j<blastStacks.size();j++){
          int temp = blastStacks.get(j);
          temp--;
          blastStacks.set(j, temp);
        }
        for(int j=0;j<radiationStacks.size();j++){
          int temp = radiationStacks.get(j);
          temp--;
          radiationStacks.set(j, temp);
        }
        for(int j=0;j<gasStacks.size();j++){
          gasStacks.get(j).duration--;
        }
        for(int j=0;j<corrosiveStacks.size();j++){
          int temp = corrosiveStacks.get(j);
          temp--;
          corrosiveStacks.set(j, temp);
        }
        for(int j=0;j<viralStacks.size();j++){
          int temp = viralStacks.get(j);
          temp--;
          viralStacks.set(j, temp);
        }
        for(int j=0;j<magneticStacks.size();j++){
          int temp = magneticStacks.get(j);
          temp--;
          magneticStacks.set(j, temp);
        }
        //Remove stacks that have expired
        for(int k=0;k<impactStacks.size();k++){
          if(impactStacks.get(k) <= 0){
            impactStacks.remove(k);
          }
        }
        for(int k=0;k<punctureStacks.size();k++){
          if(punctureStacks.get(k) <= 0){
            punctureStacks.remove(k);
          }
        }
        for(int k=0;k<slashStacks.size();k++){
          if(slashStacks.get(k).duration <= 0){
            slashStacks.remove(k);
          }
        }
        for(int k=0;k<fireStacks.size();k++){
          if(fireStacks.get(k).duration <= 0){
            fireStacks.remove(k);
          }
        }
        for(int k=0;k<iceStacks.size();k++){
          if(iceStacks.get(k) <= 0){
            iceStacks.remove(k);
          }
        }
        for(int k=0;k<electricStacks.size();k++){
          if(electricStacks.get(k) <= 0){
            electricStacks.remove(k);
          }
        }
        for(int k=0;k<toxinStacks.size();k++){
          if(toxinStacks.get(k).duration <= 0){
            toxinStacks.remove(k);
          }
        }
        for(int k=0;k<blastStacks.size();k++){
          if(blastStacks.get(k) <= 0){
            blastStacks.remove(k);
          }
        }
        for(int k=0;k<radiationStacks.size();k++){
          if(radiationStacks.get(k) <= 0){
            radiationStacks.remove(k);
          }
        }
        for(int k=0;k<gasStacks.size();k++){
          if(gasStacks.get(k).duration <= 0){
            gasStacks.remove(k);
          }
        }
        for(int k=0;k<corrosiveStacks.size();k++){
          if(corrosiveStacks.get(k) <= 0){
            corrosiveStacks.remove(k);
          }
        }
        for(int k=0;k<viralStacks.size();k++){
          if(viralStacks.get(k) <= 0){
            viralStacks.remove(k);
          }
        }
        for(int k=0;k<magneticStacks.size();k++){
          if(magneticStacks.get(k) <= 0){
            magneticStacks.remove(k);
          }
        }
      }
    }
    
    return timeToKill / 1000.0;
  }
  
  /**
   * Calculates a random time to kill a target with the supplied stats
   */
  public static double calculateRandomizedTimeToKill(int shields, int health, int armor, String surface, String armorType, String shieldType, String type){
    
    //Target Data
    double targetMaxShields = shields;
    double targetAdjustedMaxShields = targetMaxShields;
    double targetCurrentShields = targetMaxShields;
    double targetMaxHealth = health;
    double targetAdjustedMaxHealth = health;
    double targetCurrentHealth = health;
    double targetMaxArmor = armor;
    double targetAdjustedMaxArmor = armor;
    String targetSurface = surface;
    String armorSurface = armorType;
    String targetType = type;
    double impactMult = 1.0;
    double punctureMult = 1.0;
    double slashMult = 1.0;
    double fireMult = 1.0;
    double iceMult = 1.0;
    double electricMult = 1.0;
    double toxinMult = 1.0;
    double blastMult = 1.0;
    double radiationMult = 1.0;
    double gasMult = 1.0;
    double corrosiveMult = 1.0;
    double viralMult = 1.0;
    double magneticMult = 1.0;
    double armorImpactMult = 1.0;
    double armorPunctureMult = 1.0;
    double armorSlashMult = 1.0;
    double armorFireMult = 1.0;
    double armorIceMult = 1.0;
    double armorElectricMult = 1.0;
    double armorToxinMult = 1.0;
    double armorBlastMult = 1.0;
    double armorRadiationMult = 1.0;
    double armorGasMult = 1.0;
    double armorCorrosiveMult = 1.0;
    double armorViralMult = 1.0;
    double armorMagneticMult = 1.0;
    double shieldImpactMult = 1.0;
    double shieldPunctureMult = 1.0;
    double shieldSlashMult = 1.0;
    double shieldFireMult = 1.0;
    double shieldIceMult = 1.0;
    double shieldElectricMult = 1.0;
    double shieldToxinMult = 1.0;
    double shieldBlastMult = 1.0;
    double shieldRadiationMult = 1.0;
    double shieldGasMult = 1.0;
    double shieldCorrosiveMult = 1.0;
    double shieldViralMult = 1.0;
    double shieldMagneticMult = 1.0;
    double typeMult = 1.0;
    double DoTBase = (rawDamage * finalDamageMult);
    
    //Health Mults
    if(targetSurface.equals(Constants.ENEMY_SURFACE_CLONE_FLESH)){
      impactMult = 0.75;
      punctureMult = 1.0;
      slashMult = 1.25;
      fireMult = 1.25;
      iceMult = 1.0;
      electricMult = 1.0;
      toxinMult = 1.0;
      blastMult = 1.0;
      radiationMult = 1.0;
      gasMult = 0.5;
      corrosiveMult = 1.0;
      viralMult = 1.75;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_MECHANICAL)){
      impactMult = 1.25;
      punctureMult = 1.0;
      slashMult = 1.0;
      fireMult = 1.0;
      iceMult = 1.0;
      electricMult = 1.5;
      toxinMult = 0.75;
      blastMult = 1.75;
      radiationMult = 1.0;
      gasMult = 1.0;
      corrosiveMult = 1.0;
      viralMult = 0.75;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_CORPUS_FLESH)){
      impactMult = 0.75;
      punctureMult = 1.0;
      slashMult = 1.25;
      fireMult = 1.0;
      iceMult = 1.0;
      electricMult = 1.0;
      toxinMult = 1.5;
      blastMult = 1.0;
      radiationMult = 1.0;
      gasMult = 0.75;
      corrosiveMult = 1.0;
      viralMult = 1.5;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_INFESTED_FLESH)){
      impactMult = 1.0;
      punctureMult = 1.0;
      slashMult = 1.5;
      fireMult = 1.5;
      iceMult = 0.5;
      electricMult = 1.0;
      toxinMult = 1.0;
      blastMult = 1.0;
      radiationMult = 1.0;
      gasMult = 1.5;
      corrosiveMult = 1.0;
      viralMult = 1.0;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_FOSSILIZED)){
      impactMult = 1.0;
      punctureMult = 1.0;
      slashMult = 1.15;
      fireMult = 1.0;
      iceMult = 0.75;
      electricMult = 1.0;
      toxinMult = 0.5;
      blastMult = 1.5;
      radiationMult = 0.25;
      gasMult = 1.0;
      corrosiveMult = 1.75;
      viralMult = 1.0;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_SINEW)){
      impactMult = 1.0;
      punctureMult = 1.25;
      slashMult = 1.0;
      fireMult = 1.0;
      iceMult = 1.25;
      electricMult = 1.0;
      toxinMult = 1.0;
      blastMult = 0.5;
      radiationMult = 1.5;
      gasMult = 1.0;
      corrosiveMult = 1.0;
      viralMult = 1.0;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_ROBOTIC)){
      impactMult = 1.0;
      punctureMult = 1.25;
      slashMult = 0.75;
      fireMult = 1.0;
      iceMult = 1.0;
      electricMult = 1.5;
      toxinMult = 0.75;
      blastMult = 1.0;
      radiationMult = 1.25;
      gasMult = 1.0;
      corrosiveMult = 1.0;
      viralMult = 1.0;
      magneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_INFESTED)){
      impactMult = 1.0;
      punctureMult = 1.0;
      slashMult = 1.25;
      fireMult = 1.25;
      iceMult = 1.0;
      electricMult = 1.0;
      toxinMult = 1.0;
      blastMult = 1.0;
      radiationMult = 0.5;
      gasMult = 1.75;
      corrosiveMult = 1.0;
      viralMult = 0.5;
      magneticMult = 1.0;
    }
    
    //Armor Mults
    if(targetSurface.equals(Constants.ENEMY_SURFACE_FERRITE_ARMOR)){
      armorImpactMult = 1.0;
      armorPunctureMult = 1.5;
      armorSlashMult = 0.85;
      armorFireMult = 1.0;
      armorIceMult = 1.0;
      armorElectricMult = 1.0;
      armorToxinMult = 1.25;
      armorBlastMult = 0.75;
      armorRadiationMult = 1.0;
      armorGasMult = 1.0;
      armorCorrosiveMult = 1.75;
      armorViralMult = 1.0;
      armorMagneticMult = 1.0;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_ALLOY_ARMOR)){
      armorImpactMult = 1.0;
      armorPunctureMult = 1.15;
      armorSlashMult = 0.5;
      armorFireMult = 1.0;
      armorIceMult = 1.25;
      armorElectricMult = 0.5;
      armorToxinMult = 1.0;
      armorBlastMult = 1.0;
      armorRadiationMult = 1.75;
      armorGasMult = 1.0;
      armorCorrosiveMult = 1.0;
      armorViralMult = 1.0;
      armorMagneticMult = 0.5;
    }
    
    //Shield Mults
    if(targetSurface.equals(Constants.ENEMY_SURFACE_SHIELDS)){
      shieldImpactMult = 1.5;
      shieldPunctureMult = 0.85;
      shieldSlashMult = 1.0;
      shieldFireMult = 1.0;
      shieldIceMult = 1.0;
      shieldElectricMult = 1.0;
      shieldToxinMult = 1.0;
      shieldBlastMult = 1.0;
      shieldRadiationMult = 0.75;
      shieldGasMult = 1.0;
      shieldCorrosiveMult = 1.0;
      shieldViralMult = 1.0;
      shieldMagneticMult = 1.75;
    }else if(targetSurface.equals(Constants.ENEMY_SURFACE_PROTO_SHIELD)){
      shieldImpactMult = 1.15;
      shieldPunctureMult = 0.5;
      shieldSlashMult = 1.0;
      shieldFireMult = 0.5;
      shieldIceMult = 1.0;
      shieldElectricMult = 1.0;
      shieldToxinMult = 1.25;
      shieldBlastMult = 1.0;
      shieldRadiationMult = 1.0;
      shieldGasMult = 1.0;
      shieldCorrosiveMult = 0.5;
      shieldViralMult = 1.0;
      shieldMagneticMult = 1.75;
    }
    
    if(targetType.equals(Constants.ENEMY_TYPE_INFESTED)){
      typeMult = finalInfestedMult;
    }else if(targetType.equals(Constants.ENEMY_TYPE_GRINEER)){
      typeMult = finalGrineerMult;
    }else if(targetType.equals(Constants.ENEMY_TYPE_CORPUS)){
      typeMult = finalCorpusMult;
    }
    
    //Simulation Data
    double millisceondsPerShot = 1000.0 / finalFireRate;
    double millisecondMult = 1.0;
    //double procsPerShot = 1.0 * finalStatusChance;
    double reloadTimeMilliseconds = finalReloadTime * 1000.0;
    double stackTotal = 0.0;
    int reloadTimeCounter = 0;
    int shotCounter = 2147483000;
    int iterations = 0;
    int timeToKill = 0;
    boolean reloading = false;
    Vector<Integer> impactStacks = new Vector<Integer>();
    Vector<Integer> punctureStacks = new Vector<Integer>();
    Vector<DoTPair> slashStacks = new Vector<DoTPair>();
    Vector<DoTPair> fireStacks = new Vector<DoTPair>();
    Vector<Integer> iceStacks = new Vector<Integer>();
    Vector<Integer> electricStacks = new Vector<Integer>();
    Vector<DoTPair> toxinStacks = new Vector<DoTPair>();
    Vector<Integer> blastStacks = new Vector<Integer>();
    Vector<Integer> radiationStacks = new Vector<Integer>();
    Vector<DoTPair> gasStacks = new Vector<DoTPair>();
    Vector<Integer> corrosiveStacks = new Vector<Integer>();
    Vector<Integer> viralStacks = new Vector<Integer>();
    Vector<Integer> magneticStacks = new Vector<Integer>();
    
    double baseImpactDamage = finalImpactDamage;
    double basePunctureDamage = finalPunctureDamage;
    double baseSlashDamage = finalSlashDamage;
    double baseFireDamage = finalFireDamage;
    double baseIceDamage = finalIceDamage;
    double baseElectricDamage = finalElectricDamage;
    double baseToxinDamage = finalToxinDamage;
    double baseBlastDamage = finalBlastDamage;
    double baseCorrosiveDamage = finalCorrosiveDamage;
    double baseGasDamage = finalGasDamage;
    double baseMagneticDamage = finalMagneticDamage;
    double baseRadiationDamage = finalRadiationDamage;
    double baseViralDamage = finalViralDamage;
    
    if(weaponMode.equals(Constants.FULL_AUTO_RAMP_UP)){
      millisecondMult = 5.0;
    }
    Random rng = new Random();
    
    //Run a 600 second simulation to calculate the time to kill
    for(timeToKill=0; timeToKill < 6000000; timeToKill++){
      //Add new stack
      if(!reloading){
        shotCounter++;
        //is it time to fire a new projectile?
        if(shotCounter >= (millisceondsPerShot*millisecondMult)){
          if(weaponMode.equals(Constants.FULL_AUTO_RAMP_UP)){
            millisecondMult--;
            if(millisecondMult < 1.0){
              millisecondMult = 1.0;
            }
          }
          
          for(int p = 0; p < finalProjectileCount; p++){
            double localCritMult = 1.0;
            //Is this a crit?
            double crit = rng.nextDouble();
            if(crit <= finalCritChance){
              localCritMult = finalCritMult;
              //Is this a red crit?
              double redCritChance = finalCritChance - 1.0;
              if(redCritChance > 0.0){
                double redCrit = rng.nextDouble();
                if(redCrit <= redCritChance){
                  localCritMult *= 2.0;
                }
              }
            }
            
            //Adjust Max Stats
            //Shields
            targetAdjustedMaxShields = targetMaxShields;
            if(magneticStacks.size() > 0){
              targetAdjustedMaxShields *= 0.25;
            }
            if(targetAdjustedMaxShields < targetCurrentShields){
              targetCurrentShields = targetAdjustedMaxShields;
            }
            //Health
            targetAdjustedMaxHealth = targetMaxHealth;
            if(viralStacks.size() > 0){
              targetAdjustedMaxHealth *= 0.5;
            }
            if(targetAdjustedMaxHealth < targetCurrentHealth){
              targetCurrentHealth = targetAdjustedMaxHealth;
            }
            //Armor
            targetAdjustedMaxArmor = targetMaxArmor;
            if(corrosiveStacks.size() > 0){
              for(int i = 0; i < corrosiveStacks.size(); i++){
                targetAdjustedMaxArmor *= 0.75;
              }
            }
            
            //Calculate Armor Reduction
            double armorReduction = 1.0 - ((targetAdjustedMaxArmor * (1.0/300.0)) / (1.0 + (targetAdjustedMaxArmor * (1.0/300.0))));
            double impactArmorReduciton = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorImpactMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorImpactMult - 1.0))) * (1.0/300.0))));
            double punctureArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorPunctureMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorPunctureMult - 1.0))) * (1.0/300.0))));
            double slashArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorSlashMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorSlashMult - 1.0))) * (1.0/300.0))));
            double fireArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorFireMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorFireMult - 1.0))) * (1.0/300.0))));
            double iceArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorIceMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorIceMult - 1.0))) * (1.0/300.0))));
            double electricArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorElectricMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorElectricMult - 1.0))) * (1.0/300.0))));
            double toxinArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorToxinMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorToxinMult - 1.0))) * (1.0/300.0))));
            double blastArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorBlastMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorBlastMult - 1.0))) * (1.0/300.0))));
            double corrosiveArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorCorrosiveMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorCorrosiveMult - 1.0))) * (1.0/300.0))));
            double gasArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorGasMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorGasMult - 1.0))) * (1.0/300.0))));
            double magneticArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorMagneticMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorMagneticMult - 1.0))) * (1.0/300.0))));
            double radiationArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorRadiationMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorRadiationMult - 1.0))) * (1.0/300.0))));
            double viralArmorReduction = 1.0 - (((targetAdjustedMaxArmor * (1.0 - (armorViralMult - 1.0))) * (1.0/300.0)) / (1.0 + ((targetAdjustedMaxArmor * (1.0 - (armorViralMult - 1.0))) * (1.0/300.0))));
            
            //Deal Damage
            if(targetCurrentShields > 0.0){
              targetCurrentShields -= (((baseImpactDamage * localCritMult) * typeMult) * shieldImpactMult) * impactArmorReduciton;
              targetCurrentShields -= (((basePunctureDamage * localCritMult) * typeMult) * shieldPunctureMult) * punctureArmorReduction;
              targetCurrentShields -= (((baseSlashDamage * localCritMult) * typeMult) * shieldSlashMult) * slashArmorReduction;
              targetCurrentShields -= (((baseFireDamage * localCritMult) * typeMult) * shieldFireMult) * fireArmorReduction;
              targetCurrentShields -= (((baseIceDamage * localCritMult) * typeMult) * shieldIceMult) * iceArmorReduction;
              targetCurrentShields -= (((baseElectricDamage * localCritMult) * typeMult) * shieldElectricMult) * electricArmorReduction;
              targetCurrentShields -= (((baseToxinDamage * localCritMult) * typeMult) * shieldToxinMult) * toxinArmorReduction;
              targetCurrentShields -= (((baseBlastDamage * localCritMult) * typeMult) * shieldBlastMult) * blastArmorReduction;
              targetCurrentShields -= (((baseCorrosiveDamage * localCritMult) * typeMult) * shieldCorrosiveMult) * corrosiveArmorReduction;
              targetCurrentShields -= (((baseGasDamage * localCritMult) * typeMult) * shieldGasMult) * gasArmorReduction;
              targetCurrentShields -= (((baseMagneticDamage * localCritMult) * typeMult) * shieldMagneticMult) * magneticArmorReduction;
              targetCurrentShields -= (((baseRadiationDamage * localCritMult) * typeMult) * shieldRadiationMult) * radiationArmorReduction;
              targetCurrentShields -= (((baseViralDamage * localCritMult) * typeMult) * shieldViralMult) * viralArmorReduction;
            }
            if(targetCurrentShields <= 0.0){
              double shieldDifference = 1.0;
              if(targetCurrentShields < 0.0){
                double unabsorbed = Math.abs(targetCurrentShields);
                double raw = ((finalRawDamage * localCritMult) * typeMult) * armorReduction;
                shieldDifference = 1.0 - (unabsorbed / raw);
                targetCurrentShields = 0.0;
              }
              
              if(targetAdjustedMaxArmor > 0.0){
                targetCurrentHealth -= ((((baseImpactDamage * localCritMult) * typeMult) * armorImpactMult) * impactArmorReduciton) * shieldDifference;
                targetCurrentHealth -= ((((basePunctureDamage * localCritMult) * typeMult) * armorPunctureMult) * punctureArmorReduction) * shieldDifference;
                targetCurrentHealth -= ((((baseSlashDamage * localCritMult) * typeMult) * armorSlashMult) * slashArmorReduction) * shieldDifference;
                targetCurrentHealth -= ((((baseFireDamage * localCritMult) * typeMult) * armorFireMult) * fireArmorReduction) * shieldDifference;
                targetCurrentHealth -= ((((baseIceDamage * localCritMult) * typeMult) * armorIceMult) * iceArmorReduction) * shieldDifference;
                targetCurrentHealth -= ((((baseElectricDamage * localCritMult) * typeMult) * armorElectricMult) * electricArmorReduction) * shieldDifference;
                targetCurrentHealth -= ((((baseToxinDamage * localCritMult) * typeMult) * armorToxinMult) * toxinArmorReduction) * shieldDifference;
                targetCurrentHealth -= ((((baseBlastDamage * localCritMult) * typeMult) * armorBlastMult) * blastArmorReduction) * shieldDifference;
                targetCurrentHealth -= ((((baseCorrosiveDamage * localCritMult) * typeMult) * armorCorrosiveMult) * corrosiveArmorReduction) * shieldDifference;
                targetCurrentHealth -= ((((baseGasDamage * localCritMult) * typeMult) * armorGasMult) * gasArmorReduction) * shieldDifference;
                targetCurrentHealth -= ((((baseMagneticDamage * localCritMult) * typeMult) * armorMagneticMult) * magneticArmorReduction) * shieldDifference;
                targetCurrentHealth -= ((((baseRadiationDamage * localCritMult) * typeMult) * armorRadiationMult) * radiationArmorReduction) * shieldDifference;
                targetCurrentHealth -= ((((baseViralDamage * localCritMult) * typeMult) * armorViralMult) * viralArmorReduction) * shieldDifference;
              }else{
                targetCurrentHealth -= ((baseImpactDamage * localCritMult) * typeMult) * impactMult * shieldDifference;
                targetCurrentHealth -= ((basePunctureDamage * localCritMult) * typeMult) * punctureMult * shieldDifference;
                targetCurrentHealth -= ((baseSlashDamage * localCritMult) * typeMult) * slashMult * shieldDifference;
                targetCurrentHealth -= ((baseFireDamage * localCritMult) * typeMult) * fireMult * shieldDifference;
                targetCurrentHealth -= ((baseIceDamage * localCritMult) * typeMult) * iceMult * shieldDifference;
                targetCurrentHealth -= ((baseElectricDamage * localCritMult) * typeMult) * electricMult * shieldDifference;
                targetCurrentHealth -= ((baseToxinDamage * localCritMult) * typeMult) * toxinMult * shieldDifference;
                targetCurrentHealth -= ((baseBlastDamage * localCritMult) * typeMult) * blastMult * shieldDifference;
                targetCurrentHealth -= ((baseCorrosiveDamage * localCritMult) * typeMult) * corrosiveMult * shieldDifference;
                targetCurrentHealth -= ((baseGasDamage * localCritMult) * typeMult) * gasMult * shieldDifference;
                targetCurrentHealth -= ((baseMagneticDamage * localCritMult) * typeMult) * magneticMult * shieldDifference;
                targetCurrentHealth -= ((baseRadiationDamage * localCritMult) * typeMult) * radiationMult * shieldDifference;
                targetCurrentHealth -= ((baseViralDamage * localCritMult) * typeMult) * viralMult * shieldDifference;
              }
            }
            
            //Do Procs
            Vector<String> potentialProcs = new Vector<String>();
            double totalPhysical = impactDamage + punctureDamage + slashDamage;
            double localImpactProcMult = impactDamage / totalPhysical;
            double localPunctureProcMult = punctureDamage / totalPhysical;
            double localSlashProcMult = slashDamage / totalPhysical;
            double localElementalProcChance = finalStatusChance;
            double localImpactProcChance = finalStatusChance * localImpactProcMult;
            double localPunctureProcChance = finalStatusChance * localPunctureProcMult;
            double localSlashProcChance = finalStatusChance * localSlashProcMult;
            if(impactDamagePerShot > 0.0){
              potentialProcs.add(Constants.IMPACT_WEAPON_DAMAGE);
            }
            if(punctureDamagePerShot > 0.0){
              potentialProcs.add(Constants.PUNCTURE_WEAPON_DAMAGE);
            }
            if(slashDamagePerShot > 0.0){
              potentialProcs.add(Constants.SLASH_WEAPON_DAMAGE);
            }
            if(fireDamagePerShot > 0.0){
              potentialProcs.add(Constants.FIRE_WEAPON_DAMAGE);
            }
            if(iceDamagePerShot > 0.0){
              potentialProcs.add(Constants.ICE_WEAPON_DAMAGE);
            }
            if(electricDamagePerShot > 0.0){
              potentialProcs.add(Constants.ELECTRIC_WEAPON_DAMAGE);
            }
            if(toxinDamagePerShot > 0.0){
              potentialProcs.add(Constants.TOXIN_WEAPON_DAMAGE);
            }
            if(blastDamagePerShot > 0.0){
              potentialProcs.add(Constants.BLAST_WEAPON_DAMAGE);
            }
            if(radiationDamagePerShot > 0.0){
              potentialProcs.add(Constants.RADIATION_WEAPON_DAMAGE);
            }
            if(gasDamagePerShot > 0.0){
              potentialProcs.add(Constants.GAS_WEAPON_DAMAGE);
            }
            if(magneticDamagePerShot > 0.0){
              potentialProcs.add(Constants.MAGNETIC_WEAPON_DAMAGE);
            }
            if(viralDamagePerShot > 0.0){
              potentialProcs.add(Constants.VIRAL_WEAPON_DAMAGE);
            }
            if(corrosiveDamagePerShot > 0.0){
              potentialProcs.add(Constants.CORROSIVE_WEAPON_DAMAGE);
            }
            Collections.shuffle(potentialProcs);
            for(String proc : potentialProcs){
              if(proc.equals(Constants.IMPACT_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localImpactProcChance){
                  impactStacks.add(1);
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.PUNCTURE_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localPunctureProcChance){
                  punctureStacks.add(6);
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.SLASH_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localSlashProcChance){
                  double localSlashMult = slashMult;
                  if(targetAdjustedMaxArmor > 0.0){
                    localSlashMult = armorSlashMult;
                  }
                  double bleedDamage = (((DoTBase * localCritMult) * typeMult) * localSlashMult) * 0.35;
                  slashStacks.add(new DoTPair(bleedDamage,5));
                  targetCurrentHealth -= bleedDamage;
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.FIRE_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localElementalProcChance){
                  double localFireMult = fireMult;
                  double localFireArmorReduciton = 1.0;
                  if(targetAdjustedMaxArmor > 0.0){
                    localFireMult = armorFireMult;
                    if(targetCurrentShields > 0.0){
                      localFireMult = shieldFireMult;
                    }
                    localFireArmorReduciton = fireArmorReduction;
                  }
                  Double heatDamage = ((((DoTBase * localCritMult) * typeMult) * localFireMult) * localFireArmorReduciton) * 0.5;
                  fireStacks.add(new DoTPair(heatDamage,5));
                  targetCurrentHealth -= heatDamage;
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.ICE_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localElementalProcChance){
                  iceStacks.add(6);
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.ELECTRIC_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localElementalProcChance){
                  //electricStacks.add(1);
                  double localElectricMult = electricMult;
                  double localElectricArmorReduction = 1.0;
                  if(targetAdjustedMaxArmor > 0.0){
                    localElectricMult = armorElectricMult;
                    if(targetCurrentShields > 0.0){
                      localElectricMult = shieldElectricMult;
                    }
                    localElectricArmorReduction = electricArmorReduction;
                  }
                  Double electricProcDamage = ((((DoTBase * localCritMult) * typeMult) * localElectricMult) * localElectricArmorReduction);
                  targetCurrentHealth -= electricProcDamage;
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.TOXIN_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localElementalProcChance){
                  double localToxinMult = toxinMult;
                  double localToxinArmorReduction = 1.0;
                  if(targetAdjustedMaxArmor > 0.0){
                    localToxinMult = armorToxinMult;
                    localToxinArmorReduction = toxinArmorReduction;
                  }
                  double poisonDamage = ((((DoTBase * localCritMult) * typeMult) * localToxinMult) * localToxinArmorReduction) * 0.5;
                  toxinStacks.add(new DoTPair(poisonDamage,7));
                  if(poisonDamage < 10.0){
                    poisonDamage = 10.0;
                  }
                  targetCurrentHealth -= poisonDamage;
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.BLAST_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localElementalProcChance){
                  blastStacks.add(1);
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.RADIATION_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localElementalProcChance){
                  radiationStacks.add(12);
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.GAS_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localElementalProcChance){
                  double localGasMult = gasMult;
                  double localGasArmorReduction = 1.0;
                  if(targetAdjustedMaxArmor > 0.0){
                    localGasMult = armorGasMult;
                    localGasArmorReduction = gasArmorReduction;
                  }
                  double poisonDamage = ((((DoTBase * localCritMult) * typeMult) * localGasMult) * localGasArmorReduction) * 0.5;
                  gasStacks.add(new DoTPair(poisonDamage,7));
                  if(poisonDamage < 10.0){
                    poisonDamage = 10.0;
                  }
                  targetCurrentHealth -= poisonDamage * gasMult;
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.MAGNETIC_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localElementalProcChance){
                  magneticStacks.add(6);
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.VIRAL_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localElementalProcChance){
                  viralStacks.add(6);
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }else if(proc.equals(Constants.CORROSIVE_WEAPON_DAMAGE)){
                if(rng.nextDouble() <= localElementalProcChance){
                  corrosiveStacks.add(6);
                  //Decrement proc chances
                  localImpactProcChance *= 0.5;
                  localPunctureProcChance *= 0.5;
                  localSlashProcChance *= 0.5;
                  localElementalProcChance *= 0.5;
                }
              }
            }
          }
          
          //Check for Death
          if(targetCurrentHealth < 0.0){
            return timeToKill / 1000.0;
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
          if(weaponMode.equals(Constants.FULL_AUTO_RAMP_UP)){
            millisecondMult = 5.0;
          }
        }
      }
      //Is this a whole second?
      if(timeToKill % 1000 == 0){
        //Deal DoT Damage
        if(slashStacks.size() > 0){
          for(int i = 0; i < slashStacks.size(); i++){
            double bleedDamage = slashStacks.get(i).damage;
            targetCurrentHealth -= bleedDamage;
          }
        }
        if(fireStacks.size() > 0){
          for(int i = 0; i < fireStacks.size(); i++){
            double heatDamage = fireStacks.get(i).damage;
            targetCurrentHealth -= heatDamage;
          }
        }
        if(toxinStacks.size() > 0){
          for(int i = 0; i < toxinStacks.size(); i++){
            double poisonDamage = toxinStacks.get(i).damage;
            if(poisonDamage < 10.0){
              poisonDamage = 10.0;
            }
            targetCurrentHealth -= poisonDamage;
          }
        }
        if(gasStacks.size() > 0){
          for(int i = 0; i < gasStacks.size(); i++){
            double poisonDamage = gasStacks.get(i).damage;
            if(poisonDamage < 10.0){
              poisonDamage = 10.0;
            }
            targetCurrentHealth -= poisonDamage;
          }
        }
        //Decrement stack timers
        for(int j=0;j<impactStacks.size();j++){
          int temp = impactStacks.get(j);
          temp--;
          impactStacks.set(j, temp);
        }
        for(int j=0;j<punctureStacks.size();j++){
          int temp = punctureStacks.get(j);
          temp--;
          punctureStacks.set(j, temp);
        }
        for(int j=0;j<slashStacks.size();j++){
          slashStacks.get(j).duration--;
        }
        for(int j=0;j<fireStacks.size();j++){
          fireStacks.get(j).duration--;
        }
        for(int j=0;j<iceStacks.size();j++){
          int temp = iceStacks.get(j);
          temp--;
          iceStacks.set(j, temp);
        }
        for(int j=0;j<electricStacks.size();j++){
          int temp = electricStacks.get(j);
          temp--;
          electricStacks.set(j, temp);
        }
        for(int j=0;j<toxinStacks.size();j++){
          toxinStacks.get(j).duration--;
        }
        for(int j=0;j<blastStacks.size();j++){
          int temp = blastStacks.get(j);
          temp--;
          blastStacks.set(j, temp);
        }
        for(int j=0;j<radiationStacks.size();j++){
          int temp = radiationStacks.get(j);
          temp--;
          radiationStacks.set(j, temp);
        }
        for(int j=0;j<gasStacks.size();j++){
          gasStacks.get(j).duration--;
        }
        for(int j=0;j<corrosiveStacks.size();j++){
          int temp = corrosiveStacks.get(j);
          temp--;
          corrosiveStacks.set(j, temp);
        }
        for(int j=0;j<viralStacks.size();j++){
          int temp = viralStacks.get(j);
          temp--;
          viralStacks.set(j, temp);
        }
        for(int j=0;j<magneticStacks.size();j++){
          int temp = magneticStacks.get(j);
          temp--;
          magneticStacks.set(j, temp);
        }
        //Remove stacks that have expired
        for(int k=0;k<impactStacks.size();k++){
          if(impactStacks.get(k) <= 0){
            impactStacks.remove(k);
          }
        }
        for(int k=0;k<punctureStacks.size();k++){
          if(punctureStacks.get(k) <= 0){
            punctureStacks.remove(k);
          }
        }
        for(int k=0;k<slashStacks.size();k++){
          if(slashStacks.get(k).duration <= 0){
            slashStacks.remove(k);
          }
        }
        for(int k=0;k<fireStacks.size();k++){
          if(fireStacks.get(k).duration <= 0){
            fireStacks.remove(k);
          }
        }
        for(int k=0;k<iceStacks.size();k++){
          if(iceStacks.get(k) <= 0){
            iceStacks.remove(k);
          }
        }
        for(int k=0;k<electricStacks.size();k++){
          if(electricStacks.get(k) <= 0){
            electricStacks.remove(k);
          }
        }
        for(int k=0;k<toxinStacks.size();k++){
          if(toxinStacks.get(k).duration <= 0){
            toxinStacks.remove(k);
          }
        }
        for(int k=0;k<blastStacks.size();k++){
          if(blastStacks.get(k) <= 0){
            blastStacks.remove(k);
          }
        }
        for(int k=0;k<radiationStacks.size();k++){
          if(radiationStacks.get(k) <= 0){
            radiationStacks.remove(k);
          }
        }
        for(int k=0;k<gasStacks.size();k++){
          if(gasStacks.get(k).duration <= 0){
            gasStacks.remove(k);
          }
        }
        for(int k=0;k<corrosiveStacks.size();k++){
          if(corrosiveStacks.get(k) <= 0){
            corrosiveStacks.remove(k);
          }
        }
        for(int k=0;k<viralStacks.size();k++){
          if(viralStacks.get(k) <= 0){
            viralStacks.remove(k);
          }
        }
        for(int k=0;k<magneticStacks.size();k++){
          if(magneticStacks.get(k) <= 0){
            magneticStacks.remove(k);
          }
        }
      }
    }
    
    return timeToKill / 1000.0;
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
    output.append("\nFire Rate :: "+f.format(finalFireRate)+" rounds per second");
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
    output.append("\nRaw Damage Per Shot :: "+f.format(rawDamagePerShot));
    if(impactDamagePerShot > 0.0){
      output.append("\nImpact Damage Per Shot :: "+f.format(impactDamagePerShot));
    }
    if(punctureDamagePerShot > 0.0){
      output.append("\nPuncture Damage Per Shot :: "+f.format(punctureDamagePerShot));
    }
    if(slashDamagePerShot > 0.0){
      output.append("\nSlash Damage Per Shot :: "+f.format(slashDamagePerShot));
    }
    if(fireDamagePerShot > 0.0){
      output.append("\nFire Damage Per Shot :: "+f.format(fireDamagePerShot));
    }
    if(iceDamagePerShot > 0.0){
      output.append("\nIce Damage Per Shot :: "+f.format(iceDamagePerShot));
    }
    if(electricDamagePerShot > 0.0){
      output.append("\nElectric Damage Per Shot :: "+f.format(electricDamagePerShot));
    }
    if(toxinDamagePerShot > 0.0){
      output.append("\nToxin Damage Per Shot :: "+f.format(toxinDamagePerShot));
    }
    if(blastDamagePerShot > 0.0){
      output.append("\nBlast Damage Per Shot :: "+f.format(blastDamagePerShot));
    }
    if(magneticDamagePerShot > 0.0){
      output.append("\nMagnetic Damage Per Shot :: "+f.format(magneticDamagePerShot));
    }
    if(gasDamagePerShot > 0.0){
      output.append("\nGas Damage Per Shot :: "+f.format(gasDamagePerShot));
    }
    if(radiationDamagePerShot > 0.0){
      output.append("\nRadiation Damage Per Shot :: "+f.format(radiationDamagePerShot));
    }
    if(corrosiveDamagePerShot > 0.0){
      output.append("\nCorrosive Damage Per Shot :: "+f.format(corrosiveDamagePerShot));
    }
    if(viralDamagePerShot > 0.0){
      output.append("\nViral Damage Per Shot :: "+f.format(viralDamagePerShot));
    }
    output.append("\nDamage Per Shot to Clone Flesh :: "+f.format(cloneFleshDamagePerShot));
    output.append("\nDamage Per Shot to Ferrite Armor :: "+f.format(ferriteDamagePerShot));
    output.append("\nDamage Per Shot to Alloy Armor :: "+f.format(alloyDamagePerShot));
    output.append("\nDamage Per Shot to Mechanical :: "+f.format(mechanicalDamagePerShot));
    output.append("\nDamage Per Shot to Corpus Flesh :: "+f.format(corpusFleshDamagePerShot));
    output.append("\nDamage Per Shot to Shield :: "+f.format(shieldDamagePerShot));
    output.append("\nDamage Per Shot to Proto Shield :: "+f.format(protoShieldDamagePerShot));
    output.append("\nDamage Per Shot to Robotic :: "+f.format(roboticDamagePerShot));
    output.append("\nDamage Per Shot to Infested Flesh :: "+f.format(infestedFleshDamagePerShot));
    output.append("\nDamage Per Shot to Fossilized :: "+f.format(fossilizedDamagePerShot));
    output.append("\nDamage Per Shot to Sinew :: "+f.format(sinewDamagePerShot));
    output.append("\nDamage Per Shot to Corpus :: "+f.format(corpusDamagePerShot));
    output.append("\nDamage Per Shot to Grineer :: "+f.format(grineerDamagePerShot));
    output.append("\nDamage Per Shot to Infested :: "+f.format(infestedDamagePerShot));
    output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    output.append("\nRaw Crit Damage Per Shot :: "+f.format(rawCritDamagePerShot));
    if(impactCritDamagePerShot > 0.0){
      output.append("\nImpact Crit Damage Per Shot :: "+f.format(impactCritDamagePerShot));
    }
    if(punctureCritDamagePerShot > 0.0){
      output.append("\nPuncture Crit Damage Per Shot :: "+f.format(punctureCritDamagePerShot));
    }
    if(slashCritDamagePerShot > 0.0){
      output.append("\nSlash Crit Damage Per Shot :: "+f.format(slashCritDamagePerShot));
    }
    if(fireCritDamagePerShot > 0.0){
      output.append("\nFire Crit Damage Per Shot :: "+f.format(fireCritDamagePerShot));
    }
    if(iceCritDamagePerShot > 0.0){
      output.append("\nIce Crit Damage Per Shot :: "+f.format(iceCritDamagePerShot));
    }
    if(electricCritDamagePerShot > 0.0){
      output.append("\nElectric Crit Damage Per Shot :: "+f.format(electricCritDamagePerShot));
    }
    if(toxinCritDamagePerShot > 0.0){
      output.append("\nToxin Crit Damage Per Shot :: "+f.format(toxinCritDamagePerShot));
    }
    if(blastCritDamagePerShot > 0.0){
      output.append("\nBlast Crit Damage Per Shot :: "+f.format(blastCritDamagePerShot));
    }
    if(magneticCritDamagePerShot > 0.0){
      output.append("\nMagnetic Crit Damage Per Shot :: "+f.format(magneticCritDamagePerShot));
    }
    if(gasCritDamagePerShot > 0.0){
      output.append("\nGas Crit Damage Per Shot :: "+f.format(gasCritDamagePerShot));
    }
    if(radiationCritDamagePerShot > 0.0){
      output.append("\nRadiation Crit Damage Per Shot :: "+f.format(radiationCritDamagePerShot));
    }
    if(corrosiveCritDamagePerShot > 0.0){
      output.append("\nCorrosive Crit Damage Per Shot :: "+f.format(corrosiveCritDamagePerShot));
    }
    if(viralCritDamagePerShot > 0.0){
      output.append("\nViral Crit Damage Per Shot :: "+f.format(viralCritDamagePerShot));
    }
    output.append("\nCrit Damage Per Shot to Clone Flesh :: "+f.format(cloneFleshCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Ferrite Armor :: "+f.format(ferriteCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Alloy Armor :: "+f.format(alloyCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Mechanical :: "+f.format(mechanicalCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Corpus Flesh :: "+f.format(corpusFleshCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Shield :: "+f.format(shieldCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Proto Shield :: "+f.format(protoShieldCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Robotic :: "+f.format(roboticCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Infested Flesh :: "+f.format(infestedFleshCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Fossilized :: "+f.format(fossilizedCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Sinew :: "+f.format(sinewCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Corpus :: "+f.format(corpusCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Grineer :: "+f.format(grineerCritDamagePerShot));
    output.append("\nCrit Damage Per Shot to Infested :: "+f.format(infestedCritDamagePerShot));
    if(finalFirstShotDamageMult > 1.0){
      output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
      output.append("\nRaw First Shot Damage :: "+f.format(rawFirstShotDamage));
      if(impactFirstShotDamage > 0.0){
        output.append("\nImpact First Shot Damage :: "+f.format(impactFirstShotDamage));
      }
      if(punctureFirstShotDamage > 0.0){
        output.append("\nPuncture First Shot Damage :: "+f.format(punctureFirstShotDamage));
      }
      if(slashFirstShotDamage > 0.0){
        output.append("\nSlash First Shot Damage :: "+f.format(slashFirstShotDamage));
      }
      if(fireFirstShotDamage > 0.0){
        output.append("\nFire First Shot Damage :: "+f.format(fireFirstShotDamage));
      }
      if(iceFirstShotDamage > 0.0){
        output.append("\nIce First Shot Damage :: "+f.format(iceFirstShotDamage));
      }
      if(electricFirstShotDamage > 0.0){
        output.append("\nElectric First Shot Damage :: "+f.format(electricFirstShotDamage));
      }
      if(toxinFirstShotDamage > 0.0){
        output.append("\nToxin First Shot Damage :: "+f.format(toxinFirstShotDamage));
      }
      if(blastFirstShotDamage > 0.0){
        output.append("\nBlast First Shot Damage :: "+f.format(blastFirstShotDamage));
      }
      if(magneticFirstShotDamage > 0.0){
        output.append("\nMagnetic First Shot Damage :: "+f.format(magneticFirstShotDamage));
      }
      if(gasFirstShotDamage > 0.0){
        output.append("\nGas First Shot Damage :: "+f.format(gasFirstShotDamage));
      }
      if(radiationFirstShotDamage > 0.0){
        output.append("\nRadiation First Shot Damage :: "+f.format(radiationFirstShotDamage));
      }
      if(corrosiveFirstShotDamage > 0.0){
        output.append("\nCorrosive First Shot Damage :: "+f.format(corrosiveFirstShotDamage));
      }
      if(viralFirstShotDamage > 0.0){
        output.append("\nViral First Shot Damage :: "+f.format(viralFirstShotDamage));
      }
      output.append("\nFirst Shot Damage to Clone Flesh :: "+f.format(cloneFleshFirstShotDamage));
      output.append("\nFirst Shot Damage to Ferrite Armor :: "+f.format(ferriteFirstShotDamage));
      output.append("\nFirst Shot Damage to Alloy Armor :: "+f.format(alloyFirstShotDamage));
      output.append("\nFirst Shot Damage to Mechanical :: "+f.format(mechanicalFirstShotDamage));
      output.append("\nFirst Shot Damage to Corpus Flesh :: "+f.format(corpusFleshFirstShotDamage));
      output.append("\nFirst Shot Damage to Shield :: "+f.format(shieldFirstShotDamage));
      output.append("\nFirst Shot Damage to Proto Shield :: "+f.format(protoShieldFirstShotDamage));
      output.append("\nFirst Shot Damage to Robotic :: "+f.format(roboticFirstShotDamage));
      output.append("\nFirst Shot Damage to Infested Flesh :: "+f.format(infestedFleshFirstShotDamage));
      output.append("\nFirst Shot Damage to Fossilized :: "+f.format(fossilizedFirstShotDamage));
      output.append("\nFirst Shot Damage to Sinew :: "+f.format(sinewFirstShotDamage));
      output.append("\nFirst Shot Damage to Corpus :: "+f.format(corpusFirstShotDamage));
      output.append("\nFirst Shot Damage to Grineer :: "+f.format(grineerFirstShotDamage));
      output.append("\nFirst Shot Damage to Infested :: "+f.format(infestedFirstShotDamage));
    }
    output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    output.append("\nRaw Damage Per Second :: "+f.format(rawDamagePerSecond));
    output.append("\nDamage Per Second to Clone Flesh :: "+f.format(cloneFleshDamagePerSecond));
    output.append("\nDamage Per Second to Ferrite Armor :: "+f.format(ferriteDamagePerSecond));
    output.append("\nDamage Per Second to Alloy Armor :: "+f.format(alloyDamagePerSecond));
    output.append("\nDamage Per Second to Mechanical :: "+f.format(mechanicalDamagePerSecond));
    output.append("\nDamage Per Second to Corpus Flesh :: "+f.format(corpusFleshDamagePerSecond));
    output.append("\nDamage Per Second to Shield :: "+f.format(shieldDamagePerSecond));
    output.append("\nDamage Per Second to Proto Shield :: "+f.format(protoShieldDamagePerSecond));
    output.append("\nDamage Per Second to Robotic :: "+f.format(roboticDamagePerSecond));
    output.append("\nDamage Per Second to Infested Flesh :: "+f.format(infestedFleshDamagePerSecond));
    output.append("\nDamage Per Second to Fossilized :: "+f.format(fossilizedDamagePerSecond));
    output.append("\nDamage Per Second to Sinew :: "+f.format(sinewDamagePerSecond));
    output.append("\nDamage Per Second to Corpus :: "+f.format(corpusDamagePerSecond));
    output.append("\nDamage Per Second to Grineer :: "+f.format(grineerDamagePerSecond));
    output.append("\nDamage Per Second to Infested :: "+f.format(infestedDamagePerSecond));
    output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    output.append("\nRaw Burst Damage Per Second :: "+f.format(rawBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Clone Flesh :: "+f.format(cloneFleshBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Ferrite Armor :: "+f.format(ferriteBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Alloy Armor :: "+f.format(alloyBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Mechanical :: "+f.format(mechanicalBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Corpus Flesh :: "+f.format(corpusFleshBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Shield :: "+f.format(shieldBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Proto Shield :: "+f.format(protoShieldBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Robotic :: "+f.format(roboticBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Infested Flesh :: "+f.format(infestedFleshBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Fossilized :: "+f.format(fossilizedBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Sinew :: "+f.format(sinewBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Corpus :: "+f.format(corpusBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Grineer :: "+f.format(grineerBurstDamagePerSecond));
    output.append("\nBurst Damage Per Second to Infested :: "+f.format(infestedBurstDamagePerSecond));
    
    output.append("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    output.append(selectedWeapon.getModsOutput());
    
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
      for(TTKTarget target : theTTKManager.targets){
        output.append(target.printAdvancedData());
      }
    }
    
    //Update the Graph
    graph.updateDPS(rawDamagePerSecond, 
                    cloneFleshDamagePerSecond, 
                    ferriteDamagePerSecond, 
                    alloyDamagePerSecond, 
                    mechanicalDamagePerSecond, 
                    corpusFleshDamagePerSecond, 
                    shieldDamagePerSecond, 
                    protoShieldDamagePerSecond, 
                    roboticDamagePerSecond, 
                    infestedFleshDamagePerSecond, 
                    fossilizedDamagePerSecond, 
                    sinewDamagePerSecond, 
                    infestedDamagePerSecond, 
                    grineerDamagePerSecond, 
                    corpusDamagePerSecond);
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
      //theColorPanel.Init();
      colorOptionsFrame.add(theColorPanel);
      colorOptionsFrame.pack();
      //colorOptionsFrame.addWindowListener(new ModWindowListener());
      colorOptionsFrame.setTitle("Color Options");
      colorOptionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    colorOptionsFrame.setVisible(true);
  }
  
  /**
   * Method to toggle the enabled state of the mod manager menu item
   */
  protected static void updateModMenuSate(boolean enabled){
    modMenu.setEnabled(enabled);
  }
  
  /**
   * Method to toggle the enabled state of the mod manager menu item
   */
  protected static void updateTTKMenuState(boolean enabled){
    TTKMenu.setEnabled(enabled);
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
      }else if(e.getSource().equals(advancedTTKBox)){
        
        useComplexTTK = advancedTTKBox.isSelected();
          
      }else if(e.getSource().equals(clearButton)){
        riflePanel.clear();
        shotgunPanel.clear();
        pistolPanel.clear();
        output.setText("");
        graph.clear();
      }else if(e.getSource().equals(clearOutputButton)){
        output.setText("");
        graph.clear();
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
        updateModMenuSate(false);
      }else if(e.getSource().equals(TTKMenu)){
        displayTargetManager();
        updateTTKMenuState(false);
      }else if(e.getSource().equals(colorOptionsItem)){
        displayColorOptions();
      }
    }
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
      updateModMenuSate(true);
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
  
  public static class DoTPair{
    public double damage = 0.0;
    public int duration = 0;
    public DoTPair(double damage, int duration){
      this.damage = damage;
      this.duration = duration;
    }
  }
}
