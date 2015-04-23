package main;

public class ShotgunPanel extends WeaponPanel {
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public ShotgunPanel(){
    weaponType = Constants.SHOTGUN;
    Init();
    buildUI();
  }
}
