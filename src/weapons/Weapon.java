package weapons;

public class Weapon {

  /**
   * ____________________________________________________________
   * CLASS VARIABLES
   * ____________________________________________________________
   */
  public String mode;
  public String type;
  public String damageType;
  public String name;
  public String chargeTime;
  public String burstCount;
  public String burstFireRate;
  public String damage;
  public String impact;
  public String puncture;
  public String slash;
  public String fireRate;
  public String magSize;
  public String ammo;
  public String reload;
  public String crit;
  public String critMult;
  public String status;
  public String projeciles;

  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public Weapon(String weaponStr) {
    String[] split = weaponStr.split(",");
    type = split[0];
    mode = split[1];
    damageType = split[2];
    name = split[3];
    chargeTime = split[4];
    burstCount = split[5];
    burstFireRate = split[6];
    damage = split[7];
    impact = split[8];
    puncture = split[9];
    slash = split[10];
    fireRate = split[11];
    magSize = split[12];
    ammo = split[13];
    reload = split[14];
    crit = split[15];
    critMult = split[16];
    status = split[17];
    projeciles = split[18];
  }
}
