package weapons;

import etc.Constants;

public class Weapon implements Comparable {

	/**
	 * ____________________________________________________________ CLASS VARIABLES
	 * ____________________________________________________________
	 */

	/** Weapon parameters */
	public String mode;
	public String type;
	public String damageType;
	public String name;
	public String chargeTime;
	public String burstCount;
	public String meleeType;
	public String damage;
	public String impact;
	public String puncture;
	public String slash;
	public String fireRate;
	public String magSize;
	public String combo;
	public String reload;
	public String crit;
	public String critMult;
	public String status;
	public String projeciles;
	public String drain;
	public String scopeBonus;
	public String scope1;
	public String scope2;
	public String scope3;
	
	public String explosiveDamage;
	public String explosiveImpact;
	public String explosivePuncture;
	public String explosiveSlash;

	/**
	 * ____________________________________________________________ METHODS
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
		meleeType = split[6];
		damage = split[7];
		impact = split[8];
		puncture = split[9];
		slash = split[10];
		fireRate = split[11];
		magSize = split[12];
		combo = split[13];
		reload = split[14];
		crit = split[15];
		critMult = split[16];
		status = split[17];
		projeciles = split[18];
		drain = split[19];
		if (mode.equals(Constants.SNIPER) || mode.equals(Constants.LANKA)) {
			scopeBonus = split[20];
			scope1 = split[21];
			scope2 = split[22];
			try {
				scope3 = split[23];
			} catch (Exception ex) {
				scope3 = null;
			}
		}
		if (split.length > 24) { // explosions
			explosiveDamage = split[24];
			explosiveImpact = split[25];
			explosivePuncture = split[26];
			explosiveSlash = split[27];
		}
	}

	/**
	 * Creates a string representation of this weapon
	 * 
	 * @return the aforementioned string
	 */
	public String writeOut() {
		String weaponString = type + ",";
		weaponString += mode + ",";
		weaponString += damageType + ",";
		weaponString += name + ",";
		weaponString += chargeTime + ",";
		weaponString += burstCount + ",";
		weaponString += meleeType + ",";
		weaponString += damage + ",";
		weaponString += impact + ",";
		weaponString += puncture + ",";
		weaponString += slash + ",";
		weaponString += fireRate + ",";
		weaponString += magSize + ",";
		weaponString += combo + ",";
		weaponString += reload + ",";
		weaponString += crit + ",";
		weaponString += critMult + ",";
		weaponString += status + ",";
		weaponString += projeciles + ",";
		weaponString += drain;
		
		weaponString += "," + scopeBonus;
		weaponString += "," + scope1;
		weaponString += "," + scope2;
		weaponString += "," + scope3;
		
		weaponString += "," + explosiveDamage;
		weaponString += "," + explosiveImpact;
		weaponString += "," + explosivePuncture;
		weaponString += "," + explosiveSlash;

		return weaponString;
	}
	/**
	 * Compares this to other weapons
	 */
	public int compareTo(Object o) {
		if (o instanceof Weapon) {
			return this.name.compareTo(((Weapon) o).name);
		} else {
			return 0;
		}
	}
}
