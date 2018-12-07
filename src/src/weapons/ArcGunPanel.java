package weapons;

import etc.Constants;

public class ArcGunPanel extends WeaponPanel {
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public ArcGunPanel(){
    weaponType = Constants.ARCGUN;
    Init();
    buildUI();
  }
}
