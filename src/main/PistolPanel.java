package main;

public class PistolPanel extends WeaponPanel {
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public PistolPanel(){
    weaponType = Constants.PISTOL;
    Init();
    buildUI();
  }
}
