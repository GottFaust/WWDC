package weapons;

import etc.Constants;

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
