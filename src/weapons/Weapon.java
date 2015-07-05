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
    name = split[7];
    damage = split[8];
    impact = split[9];
    puncture = split[10];
    slash = split[11];
    fireRate = split[12];
    magSize = split[13];
    ammo = split[14];
    reload = split[15];
    crit = split[16];
    critMult = split[17];
    status = split[18];
    projeciles = split[19];
  }
}
