package Stances;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import etc.Constants;
import main.Main;


public class StanceInitializer {
  
  /**
   * ____________________________________________________________
   * GLOBAL VARIABLES
   * ____________________________________________________________
   */
  
  /** Singleton instance */
  private static StanceInitializer instance;
  
  /** Stances */
  public Vector<Stance> stances = new Vector<Stance>();
  
  /** Stances file */
  protected File stancesDB;
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  private StanceInitializer(){
    initialize();
  }
  
  /**
   * Gets the singleton Instance
   * @return instance
   */
  public static StanceInitializer getInstance(){
    if(instance == null){
      instance = new StanceInitializer();
    }
    return instance;
  }
  
  /**
   * Initializes the stance data
   */
  private void initialize(){
    try{
      stancesDB = new File("stances.db");
      if(stancesDB.exists()){
        stances.clear();
        BufferedReader reader = new BufferedReader(new FileReader(stancesDB));
        String line = reader.readLine();
        while(line != null){
          Stance stance = new Stance(line);
          stances.addElement(stance);
          line = reader.readLine();
        }
        reader.close();
      }else{
        stancesDB.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(stancesDB));
        for(String stanceStr : Constants.stances){
          writer.write(stanceStr + "\n");
          Stance stance = new Stance(stanceStr);
          stances.addElement(stance);
        }
        writer.close();
      }
    }catch(Exception ex){
    	Main.output.append("Could not access stances.db");
    	ex.printStackTrace();
    }
  }
  
  public void saveStanceDB(){
    try {
      if(stancesDB.exists()){
        stancesDB.delete();
      }
      stancesDB.createNewFile();
      BufferedWriter writer = new BufferedWriter(new FileWriter(stancesDB));
      for(Stance stance : stances){
        writer.write(stance.writeOut() + "\n");
      }
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
