package weapons;

import etc.Constants;

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
