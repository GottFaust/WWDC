package main;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Vector;


public class TTKTarget implements Comparable{
  
  /**
   * ____________________________________________________________
   * CLASS VARIABLES
   * ____________________________________________________________
   */
  public int baseLevel = 0;
  public int currentLevel = 0;
  public int baseArmor = 0;
  public int baseHealth = 0;
  public int baseShields = 0;
  public int maxArmor = 0;
  public int maxShields = 0;
  public int maxHealth = 0;
  public String surfaceType = "";
  public String armorType = "";
  public String shieldType = "";
  public String factionType = "";
  public String name = "";
  public double TTK = 0.0;
  public double minTTK = 0.0;
  public double maxTTK = 0.0;
  public Vector<Double> TTKVec = new Vector<Double>();
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR from a saved string
   * @param saveStr
   */
  public TTKTarget(String saveStr){
    String[] split = saveStr.split(",");
    name = split[0];
    baseLevel = Integer.parseInt(split[1]);
    currentLevel =  Integer.parseInt(split[2]);
    baseArmor =  Integer.parseInt(split[3]);
    baseHealth =  Integer.parseInt(split[4]);
    baseShields =  Integer.parseInt(split[5]);
    surfaceType = split[6];
    armorType = split[7];
    shieldType = split[8];
    factionType = split[9];
    
    maxArmor = (int)((Math.pow((currentLevel - baseLevel),1.75) * 0.005 * baseArmor) + baseArmor);
    maxShields = (int)((Math.pow((currentLevel - baseLevel),2.0) * 0.0075 * baseShields) + baseShields);
    maxHealth = (int)((Math.pow((currentLevel - baseLevel),2.0) * 0.015 * baseHealth) + baseHealth);
  }
  
  /**
   * Builds a string to save this TTK target by
   * @return save string
   */
  public String buildSaveString(){
    return name+","+baseLevel+","+currentLevel+","+baseArmor+","+baseHealth+","+baseShields+","+surfaceType+","+armorType+","+shieldType+","+factionType;
  }
  
  /**
   * Runs a simple TTK calculation
   */
  public void runSimpleTTK(){
    clearValues();
    TTK = Main.calculateTimeToKill(maxShields, maxHealth, maxArmor, surfaceType, armorType, shieldType, factionType);
  }
  
  /**
   * Runs an advanced TTK calculation
   */
  public void runAdvancedTTK(){
    Runnable advancedTTKRun = new Runnable(){
      public void run() {
        clearValues();
        for(int i = 0; i < Main.complexTTKIterations; i++){
          TTKVec.add(Main.calculateRandomizedTimeToKill(maxShields, maxHealth, maxArmor, surfaceType, armorType, shieldType, factionType));
        }
        for(Double d : TTKVec){
          TTK += d;
        }
        TTK /= TTKVec.size();
        Collections.sort(TTKVec);
        minTTK = TTKVec.get(0);
        maxTTK = TTKVec.get(TTKVec.size()-1);
        Main.complexTTKCompletions += 1;
      }
    };
    Thread advancedTTKThread = new Thread(advancedTTKRun);
    advancedTTKThread.start();
  }
  
  /**
   * builds the simple TTK output
   * @return simple TTK
   */
  public String printSimpleData(){
    DecimalFormat f = new DecimalFormat("#.###");
    String returnStr = "";
    if(TTK > 3600.0){
      returnStr = "\nTime to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(TTK/36000.0)+" hours";
    }else if(TTK > 60.0){
      returnStr = "\nTime to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(TTK/60.0)+" minutes";
    }else{
      returnStr = "\nTime to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(TTK)+" seconds";
    }
    return returnStr;
  }
  
  /**
   * builds the advanced TTK output
   * @return advanced TTK
   */
  public String printAdvancedData(){
    DecimalFormat f = new DecimalFormat("#.###");
    String returnStr = "";
    if(TTK > 3600.0){
      returnStr = "\nTime to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(TTK/36000.0)+" hours";
    }else if(TTK > 60.0){
      returnStr = "\nTime to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(TTK/60.0)+" minutes";
    }else{
      returnStr = "\nTime to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(TTK)+" seconds";
    }
    
    if(minTTK > 3600.0){
      returnStr += "\nMinimum Time to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(minTTK/36000.0)+" hours";
    }else if(minTTK > 60.0){
      returnStr += "\nMinimum Time to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(minTTK/60.0)+" minutes";
    }else{
      returnStr += "\nMinimum Time to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(minTTK)+" seconds";
    }
    
    if(maxTTK > 3600.0){
      returnStr += "\nMaximum Time to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(maxTTK/36000.0)+" hours";
    }else if(maxTTK > 60.0){
      returnStr += "\nMaximum Time to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(maxTTK/60.0)+" minutes";
    }else{
      returnStr += "\nMaximum Time to Kill a lvl "+currentLevel+" " + name + " :: "+f.format(maxTTK)+" seconds";
    }
    return returnStr;
  }
  
  /**
   * clears the TTK values
   */
  public void clearValues(){
    TTK = 0.0;
    minTTK = 0.0;
    maxTTK = 0.0;
    TTKVec = new Vector<Double>();
  }
  
  /**
   * Compares this to other targets
   */
  public int compareTo(Object o) {
    if(o instanceof Mod){
        return this.name.compareTo(((Mod)o).name);
    }else{
      return 0;
    }
  }
}
