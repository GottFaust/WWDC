package weapons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Vector;

import etc.Constants;


public class WeaponInitializer {
  
  /**
   * ____________________________________________________________
   * GLOBAL VARIABLES
   * ____________________________________________________________
   */
  
  /** Singleton instance */
  private static WeaponInitializer instance;
  
  /** Weapons */
  public Vector<Weapon> weapons = new Vector<Weapon>();
  
  /** Weapons file */
  protected File weaponsDB;
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  private WeaponInitializer(){
    initialize();
  }
  
  /**
   * Gets the singleton Instance
   * @return instance
   */
  public static WeaponInitializer getInstance(){
    if(instance == null){
      instance = new WeaponInitializer();
    }
    return instance;
  }
  
  /**
   * Initializes the weapon data
   */
  private void initialize(){
    try{
      weaponsDB = new File("weapons.db");
      if(weaponsDB.exists()){
        weapons.clear();
        BufferedReader reader = new BufferedReader(new FileReader(weaponsDB));
        String line = reader.readLine();
        while(line != null){
          Weapon weapon = new Weapon(line);
          weapons.addElement(weapon);
          line = reader.readLine();
        }
        reader.close();
        
      }else{
        weaponsDB.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(weaponsDB));
        for(String weaponStr : Constants.baseWeapons){
          writer.write(weaponStr + "\n");
          Weapon weapon = new Weapon(weaponStr);
          weapons.addElement(weapon);
        }
        writer.close();
      }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    Collections.sort(weapons);
  }
  
  public void saveWeaponDB(){
    try {
      if(weaponsDB.exists()){
        weaponsDB.delete();
      }
      weaponsDB.createNewFile();
      BufferedWriter writer = new BufferedWriter(new FileWriter(weaponsDB));
      for(Weapon weapon : weapons){
        writer.write(weapon.writeOut() + "\n");
      }
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
