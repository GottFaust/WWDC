package main;

public class RiflePanel extends WeaponPanel {
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public RiflePanel(){
    weaponType = Constants.RIFLE;
    Init();
    buildUI();
  }
}
