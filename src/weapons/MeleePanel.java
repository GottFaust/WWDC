package weapons;

import etc.Constants;

public class MeleePanel extends WeaponPanel {
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public MeleePanel(){
    weaponType = Constants.MELEE;
    Init();
    buildUI();
  }
}
