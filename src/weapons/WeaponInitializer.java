package weapons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import etc.Constants;


public class WeaponInitializer {
  
  private static WeaponInitializer instance;
  
  public Vector<Weapon> weapons = new Vector<Weapon>();
  
  private WeaponInitializer(){
    initialize();
  }
  
  public static WeaponInitializer getInstance(){
    if(instance == null){
      instance = new WeaponInitializer();
    }
    return instance;
  }
  
  private void initialize(){
    try{
      File weaponsFile = new File("weapons.db");
      if(weaponsFile.exists()){
        weapons.clear();
        BufferedReader reader = new BufferedReader(new FileReader(weaponsFile));
        String line = reader.readLine();
        while(line != null){
          Weapon weapon = new Weapon(line);
          weapons.addElement(weapon);
          line = reader.readLine();
        }
        reader.close();
        
      }else{
        weaponsFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(weaponsFile));
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
  }
}
