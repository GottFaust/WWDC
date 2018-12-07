package ttk;

import java.awt.Font;
import java.awt.FontMetrics;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import etc.Constants;
import etc.TTKNamePair;
import main.Main;
import main.Main.DoTPair;
import mods.Mod;

public class TTKTarget implements Comparable {

	/**
	 * ____________________________________________________________ CLASS VARIABLES
	 * ____________________________________________________________
	 */
	// Target Stats
	public int group = 0;
	public int baseLevel = 0;
	public int currentLevel = 0;
	public int baseArmor = 0;
	public int baseHealth = 0;
	public int baseShields = 0;
	public int maxArmor = 0;
	public int maxShields = 0;
	public int maxHealth = 0;
	public String surfaceType = "";
	public String armorType = "";
	public String shieldType = "";
	public String factionType = "";
	public String name = "";
	public double TTK = 0.0;
	public double minTTK = 0.0;
	public double maxTTK = 0.0;
	public Vector<Double> TTKVec = new Vector<Double>();

	// TTKSim Stats
	public double impactMult = 1.0;
	public double punctureMult = 1.0;
	public double slashMult = 1.0;
	public double fireMult = 1.0;
	public double iceMult = 1.0;
	public double electricMult = 1.0;
	public double toxinMult = 1.0;
	public double blastMult = 1.0;
	public double radiationMult = 1.0;
	public double gasMult = 1.0;
	public double corrosiveMult = 1.0;
	public double viralMult = 1.0;
	public double magneticMult = 1.0;
	public double armorImpactMult = 1.0;
	public double armorPunctureMult = 1.0;
	public double armorSlashMult = 1.0;
	public double armorFireMult = 1.0;
	public double armorIceMult = 1.0;
	public double armorElectricMult = 1.0;
	public double armorToxinMult = 1.0;
	public double armorBlastMult = 1.0;
	public double armorRadiationMult = 1.0;
	public double armorGasMult = 1.0;
	public double armorCorrosiveMult = 1.0;
	public double armorViralMult = 1.0;
	public double armorMagneticMult = 1.0;
	public double shieldImpactMult = 1.0;
	public double shieldPunctureMult = 1.0;
	public double shieldSlashMult = 1.0;
	public double shieldFireMult = 1.0;
	public double shieldIceMult = 1.0;
	public double shieldElectricMult = 1.0;
	public double shieldToxinMult = 1.0;
	public double shieldBlastMult = 1.0;
	public double shieldRadiationMult = 1.0;
	public double shieldGasMult = 1.0;
	public double shieldCorrosiveMult = 1.0;
	public double shieldViralMult = 1.0;
	public double shieldMagneticMult = 1.0;
	public double typeMult = 1.0;
	public double DoTBase = 0.0;
	public double localProjectileCount = 1.0;
	public double millisceondsPerShot = 0.0;
	public double millisecondMult = 5.0;
	public double rampMult = -1;
	public double comboCount = 0;
	public double reloadTimeMilliseconds = 0.0;
	public double baseImpactDamage = 0.0;
	public double basePunctureDamage = 0.0;
	public double baseSlashDamage = 0.0;
	public double baseFireDamage = 0.0;
	public double baseIceDamage = 0.0;
	public double baseElectricDamage = 0.0;
	public double baseToxinDamage = 0.0;
	public double baseBlastDamage = 0.0;
	public double baseCorrosiveDamage = 0.0;
	public double baseGasDamage = 0.0;
	public double baseMagneticDamage = 0.0;
	public double baseRadiationDamage = 0.0;
	public double baseViralDamage = 0.0;
	public double corrosiveProjectionMult = 0.0;
	public int corrosiveStacks = 0;
	public Vector<Integer> impactStacks = new Vector<Integer>();
	public Vector<Integer> punctureStacks = new Vector<Integer>();
	public Vector<DoTPair> slashStacks = new Vector<DoTPair>();
	public Vector<DoTPair> fireStacks = new Vector<DoTPair>();
	public Vector<Integer> iceStacks = new Vector<Integer>();
	public Vector<Integer> electricStacks = new Vector<Integer>();
	public Vector<DoTPair> toxinStacks = new Vector<DoTPair>();
	public Vector<Integer> blastStacks = new Vector<Integer>();
	public Vector<Integer> radiationStacks = new Vector<Integer>();
	public Vector<DoTPair> gasStacks = new Vector<DoTPair>();

	public Vector<Integer> viralStacks = new Vector<Integer>();
	public Vector<Integer> magneticStacks = new Vector<Integer>();
	public Random rng = new Random();
	public Vector<String> potentialProcs = new Vector<String>(); // Weighted vector -o
	public double headShotMult = 1;
	public double viralHealth = 0;
	protected double firstShotMult;
	protected double lastShotMult;

	/**
	 * ____________________________________________________________ METHODS
	 * ____________________________________________________________
	 */

	/**
	 * CTOR from a saved string
	 * 
	 * @param saveStr
	 */
	public TTKTarget(String saveStr) {
		String[] split = saveStr.split(",");
		name = split[0];
		baseLevel = Integer.parseInt(split[1]);
		currentLevel = Integer.parseInt(split[2]);
		baseArmor = Integer.parseInt(split[3]);
		baseHealth = Integer.parseInt(split[4]);
		baseShields = Integer.parseInt(split[5]);
		surfaceType = split[6];
		armorType = split[7];
		shieldType = split[8];
		factionType = split[9];
		try {
			group = Integer.parseInt(split[10]);
		} catch (Exception ex) {
			// Legacy, default to group 0
		}

		maxArmor = (int) ((Math.pow((currentLevel - baseLevel), 1.75) * 0.005 * baseArmor) + baseArmor);
		maxShields = (int) ((Math.pow((currentLevel - baseLevel), 2.0) * 0.0075 * baseShields) + baseShields);
		maxHealth = (int) ((Math.pow((currentLevel - baseLevel), 2.0) * 0.015 * baseHealth) + baseHealth);

		System.out.println(name + "," + currentLevel + "," + maxArmor + "," + maxHealth + "," + maxShields);
	}

	/**
	 * Builds a string to save this TTK target by
	 * 
	 * @return save string
	 */
	public String buildSaveString() {
		return name + "," + baseLevel + "," + currentLevel + "," + baseArmor + "," + baseHealth + "," + baseShields + "," + surfaceType + "," + armorType + "," + shieldType + "," + factionType + "," + group;
	}

	/**
	 * Runs an advanced TTK calculation
	 */
	public void runAdvancedTTK() {

		// Health Mults
		if (surfaceType.equals(Constants.ENEMY_SURFACE_CLONE_FLESH)) {
			impactMult = 0.75;
			punctureMult = 1.0;
			slashMult = 1.25;
			fireMult = 1.25;
			iceMult = 1.0;
			electricMult = 1.0;
			toxinMult = 1.0;
			blastMult = 1.0;
			radiationMult = 1.0;
			gasMult = 0.5;
			corrosiveMult = 1.0;
			viralMult = 1.75;
			magneticMult = 1.0;
		} else if (surfaceType.equals(Constants.ENEMY_SURFACE_MECHANICAL)) {
			impactMult = 1.25;
			punctureMult = 1.0;
			slashMult = 1.0;
			fireMult = 1.0;
			iceMult = 1.0;
			electricMult = 1.5;
			toxinMult = 0.75;
			blastMult = 1.75;
			radiationMult = 1.0;
			gasMult = 1.0;
			corrosiveMult = 1.0;
			viralMult = 0.75;
			magneticMult = 1.0;
		} else if (surfaceType.equals(Constants.ENEMY_SURFACE_CORPUS_FLESH)) {
			impactMult = 0.75;
			punctureMult = 1.0;
			slashMult = 1.25;
			fireMult = 1.0;
			iceMult = 1.0;
			electricMult = 1.0;
			toxinMult = 1.5;
			blastMult = 1.0;
			radiationMult = 1.0;
			gasMult = 0.75;
			corrosiveMult = 1.0;
			viralMult = 1.5;
			magneticMult = 1.0;
		} else if (surfaceType.equals(Constants.ENEMY_SURFACE_INFESTED_FLESH)) {
			impactMult = 1.0;
			punctureMult = 1.0;
			slashMult = 1.5;
			fireMult = 1.5;
			iceMult = 0.5;
			electricMult = 1.0;
			toxinMult = 1.0;
			blastMult = 1.0;
			radiationMult = 1.0;
			gasMult = 1.5;
			corrosiveMult = 1.0;
			viralMult = 1.0;
			magneticMult = 1.0;
		} else if (surfaceType.equals(Constants.ENEMY_SURFACE_FOSSILIZED)) {
			impactMult = 1.0;
			punctureMult = 1.0;
			slashMult = 1.15;
			fireMult = 1.0;
			iceMult = 0.75;
			electricMult = 1.0;
			toxinMult = 0.5;
			blastMult = 1.5;
			radiationMult = 0.25;
			gasMult = 1.0;
			corrosiveMult = 1.75;
			viralMult = 1.0;
			magneticMult = 1.0;
		} else if (surfaceType.equals(Constants.ENEMY_SURFACE_SINEW)) {
			impactMult = 1.0;
			punctureMult = 1.25;
			slashMult = 1.0;
			fireMult = 1.0;
			iceMult = 1.25;
			electricMult = 1.0;
			toxinMult = 1.0;
			blastMult = 0.5;
			radiationMult = 1.5;
			gasMult = 1.0;
			corrosiveMult = 1.0;
			viralMult = 1.0;
			magneticMult = 1.0;
		} else if (surfaceType.equals(Constants.ENEMY_SURFACE_ROBOTIC)) {
			impactMult = 1.0;
			punctureMult = 1.25;
			slashMult = 0.75;
			fireMult = 1.0;
			iceMult = 1.0;
			electricMult = 1.5;
			toxinMult = 0.75;
			blastMult = 1.0;
			radiationMult = 1.25;
			gasMult = 1.0;
			corrosiveMult = 1.0;
			viralMult = 1.0;
			magneticMult = 1.0;
		} else if (surfaceType.equals(Constants.ENEMY_SURFACE_INFESTED)) {
			impactMult = 1.0;
			punctureMult = 1.0;
			slashMult = 1.25;
			fireMult = 1.25;
			iceMult = 1.0;
			electricMult = 1.0;
			toxinMult = 1.0;
			blastMult = 1.0;
			radiationMult = 0.5;
			gasMult = 1.75;
			corrosiveMult = 1.0;
			viralMult = 0.5;
			magneticMult = 1.0;
		}

		// Armor Mults
		if (armorType.equals(Constants.ENEMY_SURFACE_FERRITE_ARMOR)) {
			armorImpactMult = 1.0;
			armorPunctureMult = 1.5;
			armorSlashMult = 0.85;
			armorFireMult = 1.0;
			armorIceMult = 1.0;
			armorElectricMult = 1.0;
			armorToxinMult = 1.25;
			armorBlastMult = 0.75;
			armorRadiationMult = 1.0;
			armorGasMult = 1.0;
			armorCorrosiveMult = 1.75;
			armorViralMult = 1.0;
			armorMagneticMult = 1.0;
		} else if (armorType.equals(Constants.ENEMY_SURFACE_ALLOY_ARMOR)) {
			armorImpactMult = 1.0;
			armorPunctureMult = 1.15;
			armorSlashMult = 0.5;
			armorFireMult = 1.0;
			armorIceMult = 1.25;
			armorElectricMult = 0.5;
			armorToxinMult = 1.0;
			armorBlastMult = 1.0;
			armorRadiationMult = 1.75;
			armorGasMult = 1.0;
			armorCorrosiveMult = 1.0;
			armorViralMult = 1.0;
			armorMagneticMult = 0.5;
		}

		// Shield Mults
		if (shieldType.equals(Constants.ENEMY_SURFACE_SHIELDS)) {
			shieldImpactMult = 1.5;
			shieldPunctureMult = 0.85;
			shieldSlashMult = 1.0;
			shieldFireMult = 1.0;
			shieldIceMult = 1.0;
			shieldElectricMult = 1.0;
			shieldToxinMult = 1.0;
			shieldBlastMult = 1.0;
			shieldRadiationMult = 0.75;
			shieldGasMult = 1.0;
			shieldCorrosiveMult = 1.0;
			shieldViralMult = 1.0;
			shieldMagneticMult = 1.75;
		} else if (shieldType.equals(Constants.ENEMY_SURFACE_PROTO_SHIELD)) {
			shieldImpactMult = 1.15;
			shieldPunctureMult = 0.5;
			shieldSlashMult = 1.0;
			shieldFireMult = 0.5;
			shieldIceMult = 1.0;
			shieldElectricMult = 1.0;
			shieldToxinMult = 1.25;
			shieldBlastMult = 1.0;
			shieldRadiationMult = 1.0;
			shieldGasMult = 1.0;
			shieldCorrosiveMult = 0.5;
			shieldViralMult = 1.0;
			shieldMagneticMult = 1.75;
		}

		if (factionType.equals(Constants.ENEMY_TYPE_INFESTED)) {
			typeMult = Main.finalInfestedMult;
		} else if (factionType.equals(Constants.ENEMY_TYPE_GRINEER)) {
			typeMult = Main.finalGrineerMult;
		} else if (factionType.equals(Constants.ENEMY_TYPE_CORPUS)) {
			typeMult = Main.finalCorpusMult;
		}

		// Simulation Data
		millisceondsPerShot = 1000.0 / Main.finalFireRate;
		millisecondMult = 5.0;
		reloadTimeMilliseconds = Main.finalReloadTime * 1000.0;

		baseImpactDamage = Main.impact.finalBase;
		basePunctureDamage = Main.puncture.finalBase;
		baseSlashDamage = Main.slash.finalBase;
		baseFireDamage = Main.fire.finalBase;
		baseIceDamage = Main.ice.finalBase;
		baseElectricDamage = Main.electric.finalBase;
		baseToxinDamage = Main.toxin.finalBase;
		baseBlastDamage = Main.blast.finalBase;
		baseCorrosiveDamage = Main.corrosive.finalBase;
		baseGasDamage = Main.gas.finalBase;
		baseMagneticDamage = Main.magnetic.finalBase;
		baseRadiationDamage = Main.radiation.finalBase;
		baseViralDamage = Main.viral.finalBase;

		corrosiveProjectionMult = Main.getCorrosiveProjectionMult();
		DoTBase = (Main.raw.base * Main.finalDamageMult) * Main.finalDeadAimMult;

		potentialProcs.removeAllElements();

		// Creating the weighted proc table to draw from -o
		// Proc Mults
		double totalPhysical = Main.impact.finalBase + Main.puncture.finalBase + Main.slash.finalBase;
		double totalElemental = Main.raw.finalBase - totalPhysical;
		double localImpactProcMult = (4 * Main.impact.finalBase) / ((4 * totalPhysical) + totalElemental);
		double localPunctureProcMult = (4 * Main.puncture.finalBase) / ((4 * totalPhysical) + totalElemental);
		double localSlashProcMult = (4 * Main.slash.finalBase) / ((4 * totalPhysical) + totalElemental);
		double localFireProcMult = (Main.fire.finalBase / ((4 * totalPhysical) + totalElemental));
		double localIceProcMult = (Main.ice.finalBase / ((4 * totalPhysical) + totalElemental));
		double localElectricProcMult = (Main.electric.finalBase / ((4 * totalPhysical) + totalElemental));
		double localToxinProcMult = (Main.toxin.finalBase / ((4 * totalPhysical) + totalElemental));
		double localBlastProcMult = (Main.blast.finalBase / ((4 * totalPhysical) + totalElemental));
		double localCorrosiveProcMult = (Main.corrosive.finalBase / ((4 * totalPhysical) + totalElemental));
		double localGasProcMult = (Main.gas.finalBase / ((4 * totalPhysical) + totalElemental));
		double localMagneticProcMult = (Main.magnetic.finalBase / ((4 * totalPhysical) + totalElemental));
		double localRadiationProcMult = (Main.radiation.finalBase / ((4 * totalPhysical) + totalElemental));
		double localViralProcMult = (Main.viral.finalBase / ((4 * totalPhysical) + totalElemental));
		// Integer proc weights for vector
		int localImpactProcWeight = (int) Math.round(localImpactProcMult * 1000);
		int localPunctureProcWeight = (int) Math.round(localPunctureProcMult * 1000);
		int localSlashProcWeight = (int) Math.round(localSlashProcMult * 1000);
		int localFireProcWeight = (int) Math.round(localFireProcMult * 1000);
		int localIceProcWeight = (int) Math.round(localIceProcMult * 1000);
		int localElectricProcWeight = (int) Math.round(localElectricProcMult * 1000);
		int localToxinProcWeight = (int) Math.round(localToxinProcMult * 1000);
		int localBlastProcWeight = (int) Math.round(localBlastProcMult * 1000);
		int localCorrosiveProcWeight = (int) Math.round(localCorrosiveProcMult * 1000);
		int localGasProcWeight = (int) Math.round(localGasProcMult * 1000);
		int localMagneticProcWeight = (int) Math.round(localMagneticProcMult * 1000);
		int localRadiationProcWeight = (int) Math.round(localRadiationProcMult * 1000);
		int localViralProcWeight = (int) Math.round(localViralProcMult * 1000);
		// Populate vector
		if (Main.impact.finalBase > 0.0) {
			for (int i = 0; i < localImpactProcWeight; i++) {
				potentialProcs.add(Constants.IMPACT_WEAPON_DAMAGE);
			}
		}
		if (Main.puncture.finalBase > 0.0) {
			for (int i = 0; i < localPunctureProcWeight; i++) {
				potentialProcs.add(Constants.PUNCTURE_WEAPON_DAMAGE);
			}
		}
		if (Main.slash.finalBase > 0.0) {
			for (int i = 0; i < localSlashProcWeight; i++) {
				potentialProcs.add(Constants.SLASH_WEAPON_DAMAGE);
			}
		}
		if (Main.fire.finalBase > 0.0) {
			for (int i = 0; i < localFireProcWeight; i++) {
				potentialProcs.add(Constants.FIRE_WEAPON_DAMAGE);
			}
		}
		if (Main.ice.finalBase > 0.0) {
			for (int i = 0; i < localIceProcWeight; i++) {
				potentialProcs.add(Constants.ICE_WEAPON_DAMAGE);
			}
		}
		if (Main.electric.finalBase > 0.0) {
			for (int i = 0; i < localElectricProcWeight; i++) {
				potentialProcs.add(Constants.ELECTRIC_WEAPON_DAMAGE);
			}
		}
		if (Main.toxin.finalBase > 0.0) {
			for (int i = 0; i < localToxinProcWeight; i++) {
				potentialProcs.add(Constants.TOXIN_WEAPON_DAMAGE);
			}
		}
		if (Main.blast.finalBase > 0.0) {
			for (int i = 0; i < localBlastProcWeight; i++) {
				potentialProcs.add(Constants.BLAST_WEAPON_DAMAGE);
			}
		}
		if (Main.radiation.finalBase > 0.0) {
			for (int i = 0; i < localRadiationProcWeight; i++) {
				potentialProcs.add(Constants.RADIATION_WEAPON_DAMAGE);
			}
		}
		if (Main.gas.finalBase > 0.0) {
			for (int i = 0; i < localGasProcWeight; i++) {
				potentialProcs.add(Constants.GAS_WEAPON_DAMAGE);
			}
		}
		if (Main.magnetic.finalBase > 0.0) {
			for (int i = 0; i < localMagneticProcWeight; i++) {
				potentialProcs.add(Constants.MAGNETIC_WEAPON_DAMAGE);
			}
		}
		if (Main.viral.finalBase > 0.0) {
			for (int i = 0; i < localViralProcWeight; i++) {
				potentialProcs.add(Constants.VIRAL_WEAPON_DAMAGE);
			}
		}
		if (Main.corrosive.finalBase > 0.0) {
			for (int i = 0; i < localCorrosiveProcWeight; i++) {
				potentialProcs.add(Constants.CORROSIVE_WEAPON_DAMAGE);
			}
		}

		Runnable advancedTTKRun = new Runnable() {
			public void run() {
				clearValues();

				if (Main.complexTTKIterations > 1) {
					for (int i = 0; i < Main.complexTTKIterations; i++) {
						TTKVec.add(calculateRandomizedTimeToKill());
					}
				} else if (Main.complexTTKIterations == 1) {
					TTKVec.add(calculateHardTimeToKill());
				}

				for (Double d : TTKVec) {
					TTK += d;
				}
				TTK /= TTKVec.size();
				Collections.sort(TTKVec);
				minTTK = TTKVec.get(0);
				maxTTK = TTKVec.get(TTKVec.size() - 1);
				Main.complexTTKCompletions += 1;
			}
		};

		Thread advancedTTKThread = new Thread(advancedTTKRun);
		advancedTTKThread.start();
		try {
			advancedTTKThread.join();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * builds the simple TTK output
	 * 
	 * @return simple TTK
	 */
	public String printSimpleData() {
		DecimalFormat f = new DecimalFormat("#.###");
		String returnStr = "";
		if (TTK > 3600.0) {
			returnStr = "\nTime to Kill a lvl " + currentLevel + " " + name + " :: " + f.format(TTK / 36000.0) + " hours";
		} else if (TTK > 60.0) {
			returnStr = "\nTime to Kill a lvl " + currentLevel + " " + name + " :: " + f.format(TTK / 60.0) + " minutes";
		} else {
			returnStr = "\nTime to Kill a lvl " + currentLevel + " " + name + " :: " + f.format(TTK) + " seconds";
		}
		return returnStr;
	}

	public TTKNamePair getTTKNamePair() {
		String nam = "";
		for (char c : name.toCharArray()) {
			if (Character.isUpperCase(c)) {
				try {
					int charIndex = name.indexOf(c);
					if (!Character.isUpperCase(name.charAt(charIndex + 1))) {
						nam += name.substring(charIndex, charIndex + 2);
					} else {
						nam += c;
					}
				} catch (Exception ex) {
					nam += c;
				}
			}
		}
		return new TTKNamePair(nam, TTK);
	}

	/**
	 * Gives the TTK target and time
	 */
	public String simpleTTK() {
		DecimalFormat f = new DecimalFormat("00.0000");
		String displayName = name + "[" + currentLevel + "]";
		String result = f.format(TTK);
		return displayName + "," + result;
	}

	/**
	 * builds the advanced TTK output
	 * 
	 * @return advanced TTK
	 */
	public String printAdvancedData() {
		DecimalFormat f = new DecimalFormat("00.00");
		Font font = Main.output.getFont();
		FontMetrics metric = Main.output.getFontMetrics(font);
		String displayName = name + "[" + currentLevel + "]";
		String returnStr = "\n" + displayName;
		String TTKStr = "";
		String minTTKStr = "";
		String maxTTKStr = "";
		if (TTK > 3600.0) {
			TTKStr += f.format(TTK / 36000.0) + " hrs";
		} else if (TTK > 60.0) {
			TTKStr += f.format(TTK / 60.0) + " min";
		} else {
			TTKStr += f.format(TTK) + " sec";
		}

		if (minTTK > 3600.0) {
			minTTKStr += f.format(minTTK / 36000.0) + " hrs";
		} else if (minTTK > 60.0) {
			minTTKStr += f.format(minTTK / 60.0) + " min";
		} else {
			minTTKStr += f.format(minTTK) + " sec";
		}

		if (maxTTK > 3600.0) {
			maxTTKStr += f.format(maxTTK / 36000.0) + " hrs";
		} else if (maxTTK > 60.0) {
			maxTTKStr += f.format(maxTTK / 60.0) + " min";
		} else {
			maxTTKStr += f.format(maxTTK) + " sec";
		}
		int spaceWidth = metric.stringWidth(".");
		int nameFieldWidth = metric.stringWidth(Main.longestTTKName);
		int ttkFieldWidth = metric.stringWidth("XXXXXXXXXXX");
		double nameDiff = (nameFieldWidth - metric.stringWidth(displayName)) / spaceWidth;
		nameDiff = Math.ceil(nameDiff);
		nameDiff += 2;
		for (int i = 0; i < nameDiff; i++) {
			returnStr += ".";
		}
		returnStr += "|";
		double ttkDiff = (ttkFieldWidth - metric.stringWidth(TTKStr)) / spaceWidth;
		ttkDiff /= 2.0;
		ttkDiff = Math.ceil(ttkDiff);
		for (int i = 0; i < (ttkDiff); i++) {
			returnStr += ".";
		}
		returnStr += TTKStr;
		for (int i = 0; i < (ttkDiff); i++) {
			returnStr += ".";
		}
		returnStr += "|";
		double minTTkDiff = (ttkFieldWidth - metric.stringWidth(minTTKStr)) / spaceWidth;
		minTTkDiff /= 2.0;
		minTTkDiff = Math.ceil(minTTkDiff);
		for (int i = 0; i < (minTTkDiff); i++) {
			returnStr += ".";
		}
		returnStr += minTTKStr;
		for (int i = 0; i < (minTTkDiff); i++) {
			returnStr += ".";
		}
		returnStr += "|";
		double maxTTKDiff = (ttkFieldWidth - metric.stringWidth(maxTTKStr)) / spaceWidth;
		maxTTKDiff /= 2.0;
		maxTTKDiff = Math.ceil(maxTTKDiff);
		for (int i = 0; i < (maxTTKDiff); i++) {
			returnStr += ".";
		}
		returnStr += maxTTKStr;
		return returnStr;
	}

	/**
	 * clears the TTK values
	 */
	public void clearValues() {
		TTK = 0.0;
		minTTK = 0.0;
		maxTTK = 0.0;
		TTKVec = new Vector<Double>();
	}

	/**
	 * Compares this to other targets
	 */
	public int compareTo(Object o) {
		if (o instanceof Mod) {
			return this.name.compareTo(((Mod) o).name);
		} else {
			return 0;
		}
	}

	/**
	 * Calculates a random time to kill a target with the supplied stats
	 */
	public double calculateRandomizedTimeToKill() {

		double targetAdjustedMaxShields = maxShields;
		double targetCurrentShields = maxShields;
		double targetCurrentHealth = maxHealth;
		double targetAdjustedMaxArmor = maxArmor;
		int reloadTimeCounter = 0;
		int shotCounter = 2147482999;
		int iterations = 0;
		int timeToKill = 0;
		boolean reloading = false;
		impactStacks = new Vector<Integer>();
		punctureStacks = new Vector<Integer>();
		slashStacks = new Vector<DoTPair>();
		fireStacks = new Vector<DoTPair>();
		iceStacks = new Vector<Integer>();
		electricStacks = new Vector<Integer>();
		toxinStacks = new Vector<DoTPair>();
		blastStacks = new Vector<Integer>();
		radiationStacks = new Vector<Integer>();
		gasStacks = new Vector<DoTPair>();
		corrosiveStacks = 0;
		viralStacks = new Vector<Integer>();
		magneticStacks = new Vector<Integer>();
		viralHealth = 0;

		comboCount = Main.combo * Math.pow(3, ((Main.startingCombo - 1) / 0.5) - 1);
		if (Main.startingCombo == 1) {
			comboCount = 0;
		}

		if (Main.weaponMode.equals(Constants.CHARGE) || Main.weaponMode.equals(Constants.CHARGEBOW) || Main.weaponMode.equals(Constants.LANKA)) {
			shotCounter = 0;
			if (Main.fireRate > 0) {
				shotCounter += (1 / (Main.fireRate * (1 + Main.fireRateModPower))) * 1000;
			}
		}

		if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
			millisecondMult = 1.0;
		}

		// Run a 600 second simulation to calculate the time to kill
		for (timeToKill = 0; timeToKill < 600000; timeToKill++) {
			// Add new stack
			if (!reloading) {
				shotCounter++;
				rampMult++;
				// is it time to fire a new projectile?
				if (shotCounter >= (millisceondsPerShot * (5 / millisecondMult))) {

					if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
						millisecondMult++;
						if (millisecondMult > 5.0) {
							millisecondMult = 5.0;
						}
					}

					localProjectileCount = Main.finalProjectileCount;
					if (Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
						double rampBulletMult = ((iterations + 1) / Main.projectileCount);
						if (rampBulletMult > 1)
							rampBulletMult = 1;
						localProjectileCount *= rampBulletMult;
					}

					int bursts = 1;
					if (Main.weaponMode.equals(Constants.BURST)) {
						bursts = Main.burstCount;
					}
					for (int b = 0; b < bursts; b++) { // trying to handle burst semi-correctly

						firstShotMult = 1;
						if (Main.finalFirstShotDamageMult > 0 && iterations == 0) {
							firstShotMult = 1 + Main.finalFirstShotDamageMult;
						}

						lastShotMult = 1;
						if (Main.finalLastShotDamageMult > 0 && iterations == (Main.finalMag - 1)) {
							lastShotMult = 1 + Main.finalLastShotDamageMult;
						}

						// Adjust Max Stats
						// Shields
						targetAdjustedMaxShields = maxShields;
						if (magneticStacks.size() > 0) {
							targetAdjustedMaxShields *= 0.25;
						}
						if (targetAdjustedMaxShields < targetCurrentShields) {
							targetCurrentShields = targetAdjustedMaxShields;
						}
						// Health
						if (viralStacks.size() > 0) {
							if (viralHealth == 0) {
								viralHealth = targetCurrentHealth * 0.5;
								targetCurrentHealth *= 0.5;
							}
						} else {
							targetCurrentHealth += viralHealth;
							viralHealth = 0;
						}
						// Armor
						targetAdjustedMaxArmor = maxArmor;
						// Adjust armor based on corrosive projection stacks
						targetAdjustedMaxArmor *= corrosiveProjectionMult;
						if (corrosiveStacks > 0) {
							for (int i = 0; i < corrosiveStacks; i++) {
								targetAdjustedMaxArmor *= 0.75;
							}
						}
						if (targetAdjustedMaxArmor < 1) {
							targetAdjustedMaxArmor = 0;
						}

						// Find shot-unique values
						// Find multishot
						double tempMultishots = localProjectileCount + 1;
						int multishot = 0;
						for (int p = 0; p < localProjectileCount; p++) {
							tempMultishots--;
							if (rng.nextDouble() < tempMultishots) {
								multishot++;
							}
						}
						// Beam weapon ramp-up damage 20% to 100% in 0.6 seconds
						double beamMult = 1;
						if (Main.weaponMode.equals(Constants.CONTINUOUS)) {
							beamMult = 0.2 + (rampMult / 600) * 0.8;
							if (beamMult > 1) {
								beamMult = 1;
							}
						}
						// Sniper Combo multiplier
						double comboMult = 1;
						if (Main.weaponMode.equals(Constants.SNIPER) || Main.weaponMode.equals(Constants.LANKA)) {
							comboCount += multishot;
							comboMult = 0.5 * (int) (Math.log((27 * comboCount) / Main.combo) / (Math.log(3)) + 0.00001); // +0.00001 to fix some rounding errors
							comboMult /= Main.startingCombo; // Adjusting for starting combo affecting the base values
						}

						// Shoot 1 projectile
						for (int p = 0; p < multishot; p++) {

							// Is this a crit?
							double localCritMult = 1.0;
							double tempCrit = Main.finalCritChance + 1;
							int crit = 0;
							for (int a = 0; a < Main.finalCritChance; a++) {
								tempCrit--;
								if (rng.nextDouble() < tempCrit) {
									crit++;
								}
							}
							if (crit > 0) {
								localCritMult = crit * Main.finalCritMult;
							}

							//Vigilante Proc?
							if(Main.vigilante > 0 && Main.vigilante > rng.nextDouble()) {
								localCritMult += Main.finalCritMult;
							}
							
							// Headshot damage multiplier
							headShotMult = 1;
							if (Main.headShot) {
								headShotMult = 2;
								if (localCritMult > 1) {
									headShotMult = 4;
								}
							}

							// Total multiplier
							double totalMult = comboMult * beamMult * headShotMult * localCritMult * typeMult * firstShotMult * lastShotMult;

							// Deal Damage
							if (targetCurrentShields > 0.0) {
								targetCurrentShields -= baseImpactDamage * shieldImpactMult * totalMult;
								targetCurrentShields -= basePunctureDamage * shieldPunctureMult * totalMult;
								targetCurrentShields -= baseSlashDamage * shieldSlashMult * totalMult;
								targetCurrentShields -= baseFireDamage * shieldFireMult * totalMult;
								targetCurrentShields -= baseIceDamage * shieldIceMult * totalMult;
								targetCurrentShields -= baseElectricDamage * shieldElectricMult * totalMult;
								targetCurrentShields -= baseToxinDamage * shieldToxinMult * totalMult;
								targetCurrentShields -= baseBlastDamage * shieldBlastMult * totalMult;
								targetCurrentShields -= baseCorrosiveDamage * shieldCorrosiveMult * totalMult;
								targetCurrentShields -= baseGasDamage * shieldGasMult * totalMult;
								targetCurrentShields -= baseMagneticDamage * shieldMagneticMult * totalMult;
								targetCurrentShields -= baseRadiationDamage * shieldRadiationMult * totalMult;
								targetCurrentShields -= baseViralDamage * shieldViralMult * totalMult;
							}
							if (targetCurrentShields <= 0.0) {
								double shieldDifference = 1.0;
								if (targetCurrentShields < 0.0) {
									double unabsorbed = Math.abs(targetCurrentShields);
									double raw = Main.raw.finalBase * totalMult;
									shieldDifference = 1.0 - (unabsorbed / raw);
									targetCurrentShields = 0.0;
								}

								if (targetAdjustedMaxArmor > 0.0) {
									targetCurrentHealth -= baseImpactDamage * impactMult * armorImpactMult / (1 + ((targetAdjustedMaxArmor * (2 - armorImpactMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= basePunctureDamage * punctureMult * armorPunctureMult / (1 + ((targetAdjustedMaxArmor * (2 - armorPunctureMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= baseSlashDamage * slashMult * armorSlashMult / (1 + ((targetAdjustedMaxArmor * (2 - armorSlashMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= baseFireDamage * fireMult * armorFireMult / (1 + ((targetAdjustedMaxArmor * (2 - armorFireMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= baseIceDamage * iceMult * armorIceMult / (1 + ((targetAdjustedMaxArmor * (2 - armorIceMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= baseElectricDamage * electricMult * armorElectricMult / (1 + ((targetAdjustedMaxArmor * (2 - armorElectricMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= baseToxinDamage * toxinMult * armorToxinMult / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= baseBlastDamage * blastMult * armorBlastMult / (1 + ((targetAdjustedMaxArmor * (2 - armorBlastMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= baseCorrosiveDamage * corrosiveMult * armorCorrosiveMult / (1 + ((targetAdjustedMaxArmor * (2 - armorCorrosiveMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= baseGasDamage * gasMult * armorGasMult / (1 + ((targetAdjustedMaxArmor * (2 - armorGasMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= baseMagneticDamage * magneticMult * armorMagneticMult / (1 + ((targetAdjustedMaxArmor * (2 - armorMagneticMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= baseRadiationDamage * radiationMult * armorRadiationMult / (1 + ((targetAdjustedMaxArmor * (2 - armorRadiationMult)) / 300)) * totalMult * shieldDifference;
									targetCurrentHealth -= baseViralDamage * viralMult * armorViralMult / (1 + ((targetAdjustedMaxArmor * (2 - armorViralMult)) / 300)) * totalMult * shieldDifference;
								} else {
									targetCurrentHealth -= baseImpactDamage * impactMult * totalMult * shieldDifference;
									targetCurrentHealth -= basePunctureDamage * punctureMult * totalMult * shieldDifference;
									targetCurrentHealth -= baseSlashDamage * slashMult * totalMult * shieldDifference;
									targetCurrentHealth -= baseFireDamage * fireMult * totalMult * shieldDifference;
									targetCurrentHealth -= baseIceDamage * iceMult * totalMult * shieldDifference;
									targetCurrentHealth -= baseElectricDamage * electricMult * totalMult * shieldDifference;
									targetCurrentHealth -= baseToxinDamage * toxinMult * totalMult * shieldDifference;
									targetCurrentHealth -= baseBlastDamage * blastMult * totalMult * shieldDifference;
									targetCurrentHealth -= baseCorrosiveDamage * corrosiveMult * totalMult * shieldDifference;
									targetCurrentHealth -= baseGasDamage * gasMult * totalMult * shieldDifference;
									targetCurrentHealth -= baseMagneticDamage * magneticMult * totalMult * shieldDifference;
									targetCurrentHealth -= baseRadiationDamage * radiationMult * totalMult * shieldDifference;
									targetCurrentHealth -= baseViralDamage * viralMult * totalMult * shieldDifference;
								}
							}

							// Hunter Munitions proc?
							if (Main.hunterMunitions > 0) {
								if (localCritMult > 1) { // this could mess up if crits hit for less than 1x
									if (rng.nextDouble() <= Main.hunterMunitions) {
										double bleedDamage = DoTBase * totalMult * 0.35;
										int slashDuration = (int) (6 * Main.finalStatusDuration) * 1000;
										slashStacks.add(new DoTPair(bleedDamage, slashDuration));
										targetCurrentHealth -= bleedDamage;
									}
								}
							}

							// Forced poison proc?
							if (Main.weaponName.equals("Hystrix (Poison)") || Main.weaponName.equals("Acrid")) {
								double localToxinMult = toxinMult;
								if (targetAdjustedMaxArmor > 0.0) {
									localToxinMult = (toxinMult * armorToxinMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300));
								}
								double poisonDamage = (DoTBase * (1 + Main.globalToxin) * typeMult) * localToxinMult * totalMult * 0.5;
								int toxinDuration = (int) (8 * Main.finalStatusDuration) * 1000;
								toxinStacks.add(new DoTPair(poisonDamage, toxinDuration));
								targetCurrentHealth -= poisonDamage;
							}

							// Do we get a random status proc?
							if (rng.nextDouble() <= Main.finalStatusChance) {
								// Which Proc?
								String proc = potentialProcs.get(rng.nextInt(potentialProcs.size()));
								// Do it
								if (proc.equals(Constants.SLASH_WEAPON_DAMAGE)) {
									double bleedDamage = DoTBase * totalMult * 0.35;
									int slashDuration = (int) (6 * Main.finalStatusDuration) * 1000;
									slashStacks.add(new DoTPair(bleedDamage, slashDuration));
									targetCurrentHealth -= bleedDamage;

								} else if (proc.equals(Constants.FIRE_WEAPON_DAMAGE)) {
									double localFireMult = fireMult;
									if (targetCurrentShields > 0.0) {
										localFireMult = shieldFireMult;
									} else if (targetAdjustedMaxArmor > 0.0) {
										localFireMult = (fireMult * armorFireMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorFireMult)) / 300));
									}
									double heatDamage = DoTBase * (1 + Main.globalFire) * localFireMult * totalMult * 0.5;
									int heatDuration = (int) (6 * Main.finalStatusDuration) * 1000;
									if (fireStacks.size() > 0) {
										fireStacks.get(0).duration = heatDuration;
									} else {
										fireStacks.add(new DoTPair(heatDamage, heatDuration));
									}
									if (targetCurrentShields > 0) {
										targetCurrentShields -= heatDamage;
									} else {
										targetCurrentHealth -= heatDamage;
									}

								} else if (proc.equals(Constants.ELECTRIC_WEAPON_DAMAGE)) {
									double localElectricMult = electricMult;
									if (targetCurrentShields > 0.0) {
										localElectricMult = shieldElectricMult;
									} else if (targetAdjustedMaxArmor > 0.0) {
										localElectricMult = (electricMult * armorElectricMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorElectricMult)) / 300));
									}
									double electricProcDamage = DoTBase * (1 + Main.globalElectric) * localElectricMult * totalMult * 0.5;
									if (targetCurrentShields > 0) {
										targetCurrentShields -= electricProcDamage;
									} else {
										targetCurrentHealth -= electricProcDamage;
									}

								} else if (proc.equals(Constants.TOXIN_WEAPON_DAMAGE)) {
									double localToxinMult = toxinMult;
									if (targetAdjustedMaxArmor > 0.0) {
										localToxinMult = ((toxinMult * armorToxinMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)));
									}
									double poisonDamage = DoTBase * (1 + Main.globalToxin) * typeMult * localToxinMult * totalMult * 0.5;
									int toxinDuration = (int) (8 * Main.finalStatusDuration) * 1000;
									toxinStacks.add(new DoTPair(poisonDamage, toxinDuration));
									targetCurrentHealth -= poisonDamage;

								} else if (proc.equals(Constants.GAS_WEAPON_DAMAGE)) {
									double localGasMult = toxinMult;
									if (targetAdjustedMaxArmor > 0.0) {
										localGasMult = ((toxinMult * armorToxinMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)));
									}
									double cloudDamage = DoTBase * (1 + Main.globalToxin) * typeMult * localGasMult * totalMult * 0.5;
									double poisonDamage = DoTBase * (1 + Main.globalToxin) * (1 + Main.globalToxin) * typeMult * typeMult * localGasMult * totalMult * 0.25;
									int gasDuration = (int) (8 * Main.finalStatusDuration) * 1000;
									gasStacks.add(new DoTPair(poisonDamage, gasDuration));
									targetCurrentHealth -= (cloudDamage + poisonDamage);

								} else if (proc.equals(Constants.MAGNETIC_WEAPON_DAMAGE)) {
									magneticStacks.add((int) (Math.round(6000 * Main.finalStatusDuration)));

								} else if (proc.equals(Constants.VIRAL_WEAPON_DAMAGE)) {
									viralStacks.add((int) (Math.round(6000 * Main.finalStatusDuration)));

								} else if (proc.equals(Constants.CORROSIVE_WEAPON_DAMAGE)) {
									corrosiveStacks++;
								}
							}
						}

						shotCounter = 0;
						// Have we unloaded the whole mag and need to reload?
						iterations++;
						if (iterations >= Main.finalMag) {
							reloading = true;
							iterations = 0;
						}
					}
				}
			} else {
				// Are we still reloading?
				reloadTimeCounter++;
				if (Main.weaponMode.equals(Constants.CONTINUOUS)) {
					if (reloadTimeCounter >= 800) {
						rampMult = -1; // Drops the continuous weapon ramp if not shooting for 0.8 seconds -o
					}
				}
				if (reloadTimeCounter >= reloadTimeMilliseconds) {
					reloading = false;
					reloadTimeCounter = 0;
					if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
						millisecondMult = 1.0;
					}
				}
			}

			// Check on status stacks every 0.1 seconds. Any faster and simulation becomes
			// very slow -o
			if (timeToKill % 100 == 0) {

				// Decrement stack timers and deal procs
				for (int j = 0; j < slashStacks.size(); j++) {
					slashStacks.get(j).duration -= 100;
					if (slashStacks.get(j).duration % 1000 == 0) {
						double bleedDamage = slashStacks.get(j).damage;
						targetCurrentHealth -= bleedDamage;
					}
				}

				for (int j = 0; j < fireStacks.size(); j++) {
					fireStacks.get(j).duration -= 100;
					if (fireStacks.get(j).duration % 1000 == 0) {
						double damage = fireStacks.get(j).damage;
						targetCurrentHealth -= damage;
					}
				}

				for (int j = 0; j < toxinStacks.size(); j++) {
					toxinStacks.get(j).duration -= 100;
					if (toxinStacks.get(j).duration % 1000 == 0) {
						double damage = toxinStacks.get(j).damage;
						targetCurrentHealth -= damage;
					}
				}

				for (int j = 0; j < gasStacks.size(); j++) {
					gasStacks.get(j).duration -= 100;
					if (gasStacks.get(j).duration % 1000 == 0) {
						double damage = gasStacks.get(j).damage;
						targetCurrentHealth -= damage;
					}
				}

				for (int j = 0; j < viralStacks.size(); j++) {
					int temp = viralStacks.get(j);
					temp -= 100;
					viralStacks.set(j, temp);
				}

				for (int j = 0; j < magneticStacks.size(); j++) {
					int temp = magneticStacks.get(j);
					temp -= 100;
					magneticStacks.set(j, temp);
				}

				// Remove stacks that have expired
				for (int k = 0; k < slashStacks.size(); k++) {
					if (slashStacks.get(k).duration <= 0) {
						slashStacks.remove(k);
					}
				}
				for (int k = 0; k < fireStacks.size(); k++) {
					if (fireStacks.get(k).duration <= 0) {
						fireStacks.remove(k);
					}
				}
				for (int k = 0; k < toxinStacks.size(); k++) {
					if (toxinStacks.get(k).duration <= 0) {
						toxinStacks.remove(k);
					}
				}
				for (int k = 0; k < gasStacks.size(); k++) {
					if (gasStacks.get(k).duration <= 0) {
						gasStacks.remove(k);
					}
				}
				for (int k = 0; k < viralStacks.size(); k++) {
					if (viralStacks.get(k) <= 0) {
						viralStacks.remove(k);
					}
				}
				for (int k = 0; k < magneticStacks.size(); k++) {
					if (magneticStacks.get(k) <= 0) {
						magneticStacks.remove(k);
					}
				}
			}

			// Check for Death
			if (targetCurrentHealth < 0.0) {
				rampMult = -1;
				comboCount = 0;
				return timeToKill / 1000.0;
			}
		}

		return timeToKill / 1000.0;
	}

	// Quick Mafs
	public double calculateHardTimeToKill() {

		double totalPhysical = Main.impact.finalBase + Main.puncture.finalBase + Main.slash.finalBase;
		double totalElemental = Main.raw.finalBase - totalPhysical;
		double localSlashProcMult = (4 * Main.slash.finalBase) / ((4 * totalPhysical) + totalElemental);
		double localFireProcMult = (Main.fire.finalBase / ((4 * totalPhysical) + totalElemental));
		double localElectricProcMult = (Main.electric.finalBase / ((4 * totalPhysical) + totalElemental));
		double localToxinProcMult = (Main.toxin.finalBase / ((4 * totalPhysical) + totalElemental));
		double localCorrosiveProcMult = (Main.corrosive.finalBase / ((4 * totalPhysical) + totalElemental));
		double localGasProcMult = (Main.gas.finalBase / ((4 * totalPhysical) + totalElemental));
		double localMagneticProcMult = (Main.magnetic.finalBase / ((4 * totalPhysical) + totalElemental));
		double localViralProcMult = (Main.viral.finalBase / ((4 * totalPhysical) + totalElemental));

		double slashProcsPerShot = localSlashProcMult * Main.finalProjectileCount * Main.finalStatusChance;
		double fireProcsPerShot = localFireProcMult * Main.finalProjectileCount * Main.finalStatusChance;
		double electricProcsPerShot = localElectricProcMult * Main.finalProjectileCount * Main.finalStatusChance;
		double toxinProcsPerShot = localToxinProcMult * Main.finalProjectileCount * Main.finalStatusChance;
		double corrosiveProcsPerShot = localCorrosiveProcMult * Main.finalProjectileCount * Main.finalStatusChance;
		double gasProcsPerShot = localGasProcMult * Main.finalProjectileCount * Main.finalStatusChance;
		double magneticProcsPerShot = localMagneticProcMult * Main.finalProjectileCount * Main.finalStatusChance;
		double viralProcsPerShot = localViralProcMult * Main.finalProjectileCount * Main.finalStatusChance;

		double targetAdjustedMaxShields = maxShields;
		double targetCurrentShields = maxShields;
		double targetCurrentHealth = maxHealth;
		double targetAdjustedMaxArmor = maxArmor;
		int reloadTimeCounter = 0;
		int shotCounter = 2147483000;
		int iterations = 0;
		int timeToKill = 0;
		boolean reloading = false;
		double cumulativeViral = 0;
		double cumulativeMagnetic = 0;

		slashStacks = new Vector<DoTPair>();
		fireStacks = new Vector<DoTPair>();
		electricStacks = new Vector<Integer>();
		toxinStacks = new Vector<DoTPair>();
		gasStacks = new Vector<DoTPair>();
		corrosiveStacks = 0;
		viralStacks = new Vector<Integer>();
		magneticStacks = new Vector<Integer>();
		viralHealth = 0;

		comboCount = Main.combo * Math.pow(3, ((Main.startingCombo - 1) / 0.5) - 1);
		if (Main.startingCombo == 1) {
			comboCount = 0;
		}

		if (Main.weaponMode.equals(Constants.CHARGE) || Main.weaponMode.equals(Constants.CHARGEBOW) || Main.weaponMode.equals(Constants.LANKA)) {
			shotCounter = 0;
			if (Main.fireRate > 0) {
				shotCounter += (1 / (Main.fireRate * (1 + Main.fireRateModPower))) * 1000;
			}
		}

		if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
			millisecondMult = 1.0;
		}
		// Run a 60 second simulation to calculate the time to kill
		for (timeToKill = 0; timeToKill < 60000; timeToKill++) {
			// Add new stack
			if (!reloading) {
				shotCounter++;
				rampMult++;
				// is it time to fire a new projectile?
				if (shotCounter >= (millisceondsPerShot * (5 / millisecondMult))) {

					// Beam weapons ramp-up damage 20% to 100% in 0.6 seconds -o

					if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
						millisecondMult++;
						if (millisecondMult > 5.0) {
							millisecondMult = 5.0;
						}
					}

					localProjectileCount = Main.finalProjectileCount;
					if (Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
						double rampBulletMult = ((iterations + 1) / Main.projectileCount);
						if (rampBulletMult > 1)
							rampBulletMult = 1;
						localProjectileCount *= rampBulletMult;
					}

					int bursts = 1;
					if (Main.weaponMode.equals(Constants.BURST))
						bursts = Main.burstCount;
					for (int b = 0; b < bursts; b++) {

						firstShotMult = 1;
						if (Main.finalFirstShotDamageMult > 0 && iterations == 0) {
							firstShotMult = 1 + Main.finalFirstShotDamageMult;
						}

						lastShotMult = 1;
						if (Main.finalLastShotDamageMult > 0 && iterations == (Main.finalMag - 1)) {
							lastShotMult = 1 + Main.finalLastShotDamageMult;
						}

						// Adjust Max Stats
						// Shields
						targetAdjustedMaxShields = maxShields;
						if (magneticStacks.size() > 0) {
							targetAdjustedMaxShields *= 0.25;
						}
						if (targetAdjustedMaxShields < targetCurrentShields) {
							targetCurrentShields = targetAdjustedMaxShields;
						}

						// Health
						if (viralStacks.size() > 0) {
							if (viralHealth == 0) {
								viralHealth = targetCurrentHealth * 0.5;
								targetCurrentHealth *= 0.5;
							}
						} else {
							targetCurrentHealth += viralHealth;
							viralHealth = 0;
						}

						// Armor
						targetAdjustedMaxArmor = maxArmor;
						// Adjust armor based on corrosive projection stacks
						targetAdjustedMaxArmor *= corrosiveProjectionMult;
						// Average armor removal at time
						targetAdjustedMaxArmor *= Math.pow(0.75, corrosiveProcsPerShot * corrosiveStacks);
						// to account for complete armor removal -o
						if (targetAdjustedMaxArmor < 1) {
							targetAdjustedMaxArmor = 0;
						}

						// Beam weapon ramp-up damage 20% to 100% in 0.6 seconds
						double beamMult = 1;
						if (Main.weaponMode.equals(Constants.CONTINUOUS)) {
							beamMult = 0.2 + (rampMult / 600) * 0.8;
							if (beamMult > 1) {
								beamMult = 1;
							}

						}
						// Sniper Combo multiplier
						double comboMult = 1;
						if (Main.weaponMode.equals(Constants.SNIPER) || Main.weaponMode.equals(Constants.LANKA)) {
							comboCount += localProjectileCount;
							comboMult = 0.5 * (int) (Math.log((27 * comboCount) / Main.combo) / (Math.log(3)) + 0.00001); // +0.00001 to fix some rounding errors
							comboMult /= Main.startingCombo; // Adjusting for starting combo affecting the base values
						}

						double critty = Main.finalCritChance + Main.vigilante;
						if (critty > 1)
							critty = 1;

						// average crit mult
						double localCritMult = (1 - critty) + ((Main.finalCritChance + Main.vigilante) * Main.finalCritMult);

						headShotMult = 1;
						if (Main.headShot) {
							headShotMult = 2 + (2 * critty);
						}

						// Total multiplier
						double totalMult = comboMult * beamMult * headShotMult * localCritMult * typeMult * firstShotMult * lastShotMult;

						// Deal Damage
						if (targetCurrentShields > 0.0) {
							targetCurrentShields -= baseImpactDamage * shieldImpactMult * totalMult * localProjectileCount;
							targetCurrentShields -= basePunctureDamage * shieldPunctureMult * totalMult * localProjectileCount;
							targetCurrentShields -= baseSlashDamage * shieldSlashMult * totalMult * localProjectileCount;
							targetCurrentShields -= baseFireDamage * shieldFireMult * totalMult * localProjectileCount;
							targetCurrentShields -= baseIceDamage * shieldIceMult * totalMult * localProjectileCount;
							targetCurrentShields -= baseElectricDamage * shieldElectricMult * totalMult * localProjectileCount;
							targetCurrentShields -= baseToxinDamage * shieldToxinMult * totalMult * localProjectileCount;
							targetCurrentShields -= baseBlastDamage * shieldBlastMult * totalMult * localProjectileCount;
							targetCurrentShields -= baseCorrosiveDamage * shieldCorrosiveMult * totalMult * localProjectileCount;
							targetCurrentShields -= baseGasDamage * shieldGasMult * totalMult * localProjectileCount;
							targetCurrentShields -= baseMagneticDamage * shieldMagneticMult * totalMult * localProjectileCount;
							targetCurrentShields -= baseRadiationDamage * shieldRadiationMult * totalMult * localProjectileCount;
							targetCurrentShields -= baseViralDamage * shieldViralMult * totalMult * localProjectileCount;
						}
						if (targetCurrentShields <= 0.0) {
							double shieldDifference = 1.0;
							if (targetCurrentShields < 0.0) {
								double unabsorbed = Math.abs(targetCurrentShields);
								double raw = Main.raw.finalBase * totalMult * localProjectileCount;
								shieldDifference = 1.0 - (unabsorbed / raw);
								targetCurrentShields = 0.0;
							}

							if (targetAdjustedMaxArmor > 0.0) {
								targetCurrentHealth -= baseImpactDamage * impactMult * armorImpactMult / (1 + ((targetAdjustedMaxArmor * (2 - armorImpactMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= basePunctureDamage * punctureMult * armorPunctureMult / (1 + ((targetAdjustedMaxArmor * (2 - armorPunctureMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseSlashDamage * slashMult * armorSlashMult / (1 + ((targetAdjustedMaxArmor * (2 - armorSlashMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseFireDamage * fireMult * armorFireMult / (1 + ((targetAdjustedMaxArmor * (2 - armorFireMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseIceDamage * iceMult * armorIceMult / (1 + ((targetAdjustedMaxArmor * (2 - armorIceMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseElectricDamage * electricMult * armorElectricMult / (1 + ((targetAdjustedMaxArmor * (2 - armorElectricMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseToxinDamage * toxinMult * armorToxinMult / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseBlastDamage * blastMult * armorBlastMult / (1 + ((targetAdjustedMaxArmor * (2 - armorBlastMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseCorrosiveDamage * corrosiveMult * armorCorrosiveMult / (1 + ((targetAdjustedMaxArmor * (2 - armorCorrosiveMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseGasDamage * gasMult * armorGasMult / (1 + ((targetAdjustedMaxArmor * (2 - armorGasMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseMagneticDamage * magneticMult * armorMagneticMult / (1 + ((targetAdjustedMaxArmor * (2 - armorMagneticMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseRadiationDamage * radiationMult * armorRadiationMult / (1 + ((targetAdjustedMaxArmor * (2 - armorRadiationMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseViralDamage * viralMult * armorViralMult / (1 + ((targetAdjustedMaxArmor * (2 - armorViralMult)) / 300)) * totalMult * shieldDifference * localProjectileCount;
							} else {
								targetCurrentHealth -= baseImpactDamage * impactMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= basePunctureDamage * punctureMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseSlashDamage * slashMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseFireDamage * fireMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseIceDamage * iceMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseElectricDamage * electricMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseToxinDamage * toxinMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseBlastDamage * blastMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseCorrosiveDamage * corrosiveMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseGasDamage * gasMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseMagneticDamage * magneticMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseRadiationDamage * radiationMult * totalMult * shieldDifference * localProjectileCount;
								targetCurrentHealth -= baseViralDamage * viralMult * totalMult * shieldDifference * localProjectileCount;
							}
						}

						// Hunter Munitions proc!
						if (Main.hunterMunitions > 0) {
							double bleedDamage = DoTBase * totalMult * 0.35 * critty * Main.hunterMunitions * localProjectileCount;
							int slashDuration = (int) (6 * Main.finalStatusDuration) * 1000;
							slashStacks.add(new DoTPair(bleedDamage, slashDuration));
							targetCurrentHealth -= bleedDamage;
						}

						// Forced poison proc!
						if (Main.weaponName.equals("Hystrix (Poison)") || Main.weaponName.equals("Acrid")) {
							double localToxinMult = toxinMult;
							if (targetAdjustedMaxArmor > 0.0) {
								localToxinMult = (toxinMult * armorToxinMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300));
							}
							double poisonDamage = DoTBase * (1 + Main.globalToxin) * typeMult * localToxinMult * totalMult * 0.5 * localProjectileCount;
							int toxinDuration = (int) (8 * Main.finalStatusDuration) * 1000;
							toxinStacks.add(new DoTPair(poisonDamage, toxinDuration));
							targetCurrentHealth -= poisonDamage;
						}

						// All the other procs!
						double bleedDamage = DoTBase * totalMult * 0.35 * slashProcsPerShot;
						int slashDuration = (int) (6 * Main.finalStatusDuration) * 1000;
						slashStacks.add(new DoTPair(bleedDamage, slashDuration));
						targetCurrentHealth -= bleedDamage;

						// Fire proc!
						double localFireMult = fireMult;
						if (targetCurrentShields > 0.0) {
							localFireMult = shieldFireMult;
						} else if (targetAdjustedMaxArmor > 0.0) {
							localFireMult = (fireMult * armorFireMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorFireMult)) / 300));
						}
						double heatDamage = DoTBase * (1 + Main.globalFire) * localFireMult * totalMult * 0.5 * fireProcsPerShot;
						int heatDuration = (int) (6 * Main.finalStatusDuration) * 1000;
						if (fireStacks.size() > 0) {
							fireStacks.get(0).duration = heatDuration;
						} else {
							fireStacks.add(new DoTPair(heatDamage, heatDuration));
						}
						if (targetCurrentShields > 0) {
							targetCurrentShields -= heatDamage;
						} else {
							targetCurrentHealth -= heatDamage;
						}

						// Electric Proc!
						double localElectricMult = electricMult;
						if (targetCurrentShields > 0.0) {
							localElectricMult = shieldElectricMult;
						} else if (targetAdjustedMaxArmor > 0.0) {
							localElectricMult = (electricMult * armorElectricMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorElectricMult)) / 300));
						}
						double electricProcDamage = DoTBase * (1 + Main.globalElectric) * localElectricMult * totalMult * 0.5 * electricProcsPerShot;
						if (targetCurrentShields > 0) {
							targetCurrentShields -= electricProcDamage;
						} else {
							targetCurrentHealth -= electricProcDamage;
						}

						// Toxin Proc!
						double localToxinMult = toxinMult;
						if (targetAdjustedMaxArmor > 0.0) {
							localToxinMult = ((toxinMult * armorToxinMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)));
						}
						double poisonDamage = DoTBase * (1 + Main.globalToxin) * typeMult * localToxinMult * totalMult * 0.5 * toxinProcsPerShot;
						int toxinDuration = (int) (8 * Main.finalStatusDuration) * 1000;
						toxinStacks.add(new DoTPair(poisonDamage, toxinDuration));
						targetCurrentHealth -= poisonDamage;

						// Gas Proc!
						double localGasMult = toxinMult;
						if (targetAdjustedMaxArmor > 0.0) {
							localGasMult = ((toxinMult * armorToxinMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)));
						}
						double cloudDamage = DoTBase * (1 + Main.globalToxin) * typeMult * localGasMult * totalMult * 0.5 * gasProcsPerShot;
						double gasDamage = DoTBase * (1 + Main.globalToxin) * (1 + Main.globalToxin) * typeMult * typeMult * localGasMult * totalMult * 0.25 * gasProcsPerShot;
						int gasDuration = (int) (8 * Main.finalStatusDuration) * 1000;
						gasStacks.add(new DoTPair(gasDamage, gasDuration));
						targetCurrentHealth -= (cloudDamage + gasDamage);

						// Terrible Viral Proc!
						cumulativeViral += viralProcsPerShot;
						if (cumulativeViral > 1) {
							cumulativeViral = 0;
							viralStacks.add((int) (Math.round(6000 * Main.finalStatusDuration)));
						}

						// Terrible Magnetic Proc!
						cumulativeMagnetic += magneticProcsPerShot;
						if (cumulativeMagnetic > 1) {
							cumulativeMagnetic = 0;
							magneticStacks.add((int) (Math.round(6000 * Main.finalStatusDuration)));
						}

						corrosiveStacks++;

						shotCounter = 0;
						// Have we unloaded the whole mag and need to reload?
						iterations++;
						if (iterations >= Main.finalMag) {
							reloading = true;
							iterations = 0;
						}
					}
				}
			} else {
				// Are we still reloading?
				reloadTimeCounter++;
				if (Main.weaponMode.equals(Constants.CONTINUOUS)) {
					if (reloadTimeCounter >= 800) {
						rampMult = -1; // Drops the continuous weapon ramp if not shooting for 0.8 seconds -o
					}
				}
				if (reloadTimeCounter >= reloadTimeMilliseconds) {
					reloading = false;
					reloadTimeCounter = 0;
					if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
						millisecondMult = 1.0;
					}
				}
			}

			// Check on status stacks every 0.1 seconds. Any faster and simulation gets very
			// slow -o
			if (timeToKill % 100 == 0) {

				// Decrement stack timers and deal procs
				for (int j = 0; j < slashStacks.size(); j++) {
					slashStacks.get(j).duration -= 100;
					if (slashStacks.get(j).duration % 1000 == 0) {
						double bleedDamage = slashStacks.get(j).damage;
						targetCurrentHealth -= bleedDamage;
					}
				}

				for (int j = 0; j < fireStacks.size(); j++) {
					fireStacks.get(j).duration -= 100;
					if (fireStacks.get(j).duration % 1000 == 0) {
						double damage = fireStacks.get(j).damage;
						targetCurrentHealth -= damage;
					}
				}

				for (int j = 0; j < toxinStacks.size(); j++) {
					toxinStacks.get(j).duration -= 100;
					if (toxinStacks.get(j).duration % 1000 == 0) {
						double damage = toxinStacks.get(j).damage;
						targetCurrentHealth -= damage;
					}
				}

				for (int j = 0; j < gasStacks.size(); j++) {
					gasStacks.get(j).duration -= 100;
					if (gasStacks.get(j).duration % 1000 == 0) {
						double damage = gasStacks.get(j).damage;
						targetCurrentHealth -= damage;
					}
				}

				for (int j = 0; j < viralStacks.size(); j++) {
					int temp = viralStacks.get(j);
					temp--;
					viralStacks.set(j, temp);
				}

				for (int j = 0; j < magneticStacks.size(); j++) {
					int temp = magneticStacks.get(j);
					temp--;
					magneticStacks.set(j, temp);
				}

				// Remove stacks that have expired
				for (int k = 0; k < slashStacks.size(); k++) {
					if (slashStacks.get(k).duration <= 0) {
						slashStacks.remove(k);
					}
				}
				for (int k = 0; k < fireStacks.size(); k++) {
					if (fireStacks.get(k).duration <= 0) {
						fireStacks.remove(k);
					}
				}
				for (int k = 0; k < toxinStacks.size(); k++) {
					if (toxinStacks.get(k).duration <= 0) {
						toxinStacks.remove(k);
					}
				}
				for (int k = 0; k < gasStacks.size(); k++) {
					if (gasStacks.get(k).duration <= 0) {
						gasStacks.remove(k);
					}
				}
				for (int k = 0; k < viralStacks.size(); k++) {
					if (viralStacks.get(k) <= 0) {
						viralStacks.remove(k);
					}
				}
				for (int k = 0; k < magneticStacks.size(); k++) {
					if (magneticStacks.get(k) <= 0) {
						magneticStacks.remove(k);
					}
				}
			}

			// Check for Death
			if (targetCurrentHealth < 0.0) {
				rampMult = -1;
				return timeToKill / 1000.0;
			}
		}
		return timeToKill / 1000;
	}
}