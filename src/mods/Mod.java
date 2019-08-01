package mods;

import java.util.StringTokenizer;
import java.util.Vector;

import etc.Constants;


public class Mod implements Comparable {
  
  /**
   * ____________________________________________________________
   * CLASS VARIABLES
   * ____________________________________________________________
   */
  
  public String name = "";
  public int ranks = 0;
  public String type = "";
  public String polarity = "";
  public int baseCost = 0;
  public String weaponLock = "";
  public Vector<String> effectTypes = new Vector<String>();
  public Vector<Double> effectStrengths = new Vector<Double>();
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public Mod(String modString){
    
    StringTokenizer tok = new StringTokenizer(modString, ",");
    name = tok.nextToken();
    type = tok.nextToken();
    String tempRanks = tok.nextToken();
    try{
      int tempRanksInt = Integer.parseInt(tempRanks);
    }catch(Exception ex){
      tempRanks = "0";
    }
    ranks = Integer.parseInt(tempRanks);
    int effectCount = Integer.parseInt(tok.nextToken());
    for(int i = 0; i < effectCount; i++){
      effectTypes.add(tok.nextToken());
    }
    for(int i = 0; i < effectCount; i++){
      effectStrengths.add(Double.parseDouble(tok.nextToken()));
    }
    String tempPolarity = tok.nextToken();
    if(!(tempPolarity.equals(Constants.D) ||
        tempPolarity.equals(Constants.V) ||
        tempPolarity.equals(Constants.DASH) ||
        tempPolarity.equals(Constants.EQUALS))){
      tempPolarity = Constants.NONE;
    }
    String tempCost = tok.nextToken();
    try{
      int tempCostInt = Integer.parseInt(tempCost);
    }catch(Exception ex){
      tempCost = "0";
    }
    polarity = tempPolarity;
    baseCost = Integer.parseInt(tempCost);
    
    try {
    	weaponLock = tok.nextToken();
    }catch(Exception ex){
    	weaponLock = "None";
    }
  }

  /**
   * Creates a string representation of this mod
   * @return the aforementioned string
   */
  public String writeOut(){
    
    String out =  name + ","+ type + ","+ ranks + "," + effectTypes.size();
    
    for(int i = 0; i < effectTypes.size(); i++){
      out += (","+effectTypes.get(i));
    }
    
    for(int i = 0; i < effectStrengths.size(); i++){
      out += (","+effectStrengths.get(i));
    }
    
    out += ","+polarity+","+baseCost;
    
    out += ","+weaponLock;
    
    return out;
  }

  /**
   * Compares this to other mods
   */
  public int compareTo(Object o) {
    if(o instanceof Mod){
        return this.name.compareTo(((Mod)o).name);
    }else{
      return 0;
    }
  }
}
