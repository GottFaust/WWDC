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
	public String name;
	public String chargeTime;
	public String burstCount;
	public String meleeType;
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
	
	public String damageType;
	public String damageType2;
	public String damage;
	public String damage2;
	public String impact;
	public String puncture;
	public String slash;
	
	public String explosiveType1;
	public String explosiveType2;
	public String explosiveDamage;
	public String explosiveDamage2;
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
		if (split.length > 28) { // multi-element weapons
			damageType2 = split[28];
			damage2 = split[29];
			explosiveType1 = split[30];
			explosiveType2 = split[31];
			explosiveDamage2 = split[32];
		}
		
		if(damageType2 == null || damageType2.equals("")) {
			damageType2 = Constants.PHYSICAL_WEAPON_DAMAGE;
		}
		if(explosiveType1 == null || explosiveType1.equals("")) {
			explosiveType1 = Constants.PHYSICAL_WEAPON_DAMAGE;
		}
		if(explosiveType2 == null || explosiveType2.equals("")) {
			explosiveType2 = Constants.PHYSICAL_WEAPON_DAMAGE;
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
		
		weaponString += "," + damageType2;
		weaponString += "," + damage2;
		weaponString += "," + explosiveType1;
		weaponString += "," + explosiveType2;
		weaponString += "," + explosiveDamage2;

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
