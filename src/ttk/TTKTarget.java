package ttk;

import java.awt.Font;
import java.awt.FontMetrics;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
	protected int baseLevel = 0;
	public int currentLevel = 0;
	protected int baseArmor = 0;
	protected int baseHealth = 0;
	protected int baseShields = 0;
	protected int maxArmor = 0;
	protected int maxShields = 0;
	protected int maxHealth = 0;
	protected String surfaceType = "";
	protected String armorType = "";
	protected String shieldType = "";
	protected String factionType = "";
	public String name = "";
	protected double TTK = 0.0;
	protected double minTTK = 0.0;
	protected double maxTTK = 0.0;
	protected Vector<Double> TTKVec = new Vector<Double>();

	// TTKSim Stats
	protected double impactMult = 1.0;
	protected double punctureMult = 1.0;
	protected double slashMult = 1.0;
	protected double fireMult = 1.0;
	protected double iceMult = 1.0;
	protected double electricMult = 1.0;
	protected double toxinMult = 1.0;
	protected double blastMult = 1.0;
	protected double radiationMult = 1.0;
	protected double gasMult = 1.0;
	protected double corrosiveMult = 1.0;
	protected double viralMult = 1.0;
	protected double magneticMult = 1.0;
	protected double armorImpactMult = 1.0;
	protected double armorPunctureMult = 1.0;
	protected double armorSlashMult = 1.0;
	protected double armorFireMult = 1.0;
	protected double armorIceMult = 1.0;
	protected double armorElectricMult = 1.0;
	protected double armorToxinMult = 1.0;
	protected double armorBlastMult = 1.0;
	protected double armorRadiationMult = 1.0;
	protected double armorGasMult = 1.0;
	protected double armorCorrosiveMult = 1.0;
	protected double armorViralMult = 1.0;
	protected double armorMagneticMult = 1.0;
	protected double shieldImpactMult = 1.0;
	protected double shieldPunctureMult = 1.0;
	protected double shieldSlashMult = 1.0;
	protected double shieldFireMult = 1.0;
	protected double shieldIceMult = 1.0;
	protected double shieldElectricMult = 1.0;
	protected double shieldToxinMult = 1.0;
	protected double shieldBlastMult = 1.0;
	protected double shieldRadiationMult = 1.0;
	protected double shieldGasMult = 1.0;
	protected double shieldCorrosiveMult = 1.0;
	protected double shieldViralMult = 1.0;
	protected double shieldMagneticMult = 1.0;
	protected double typeMult = 1.0;
	
	protected double DoTBase = 0.0;
	protected int millisceondsPerShot = 0;
	protected int reloadTimeMilliseconds = 0;
	protected double slashProc;
	protected double fireProc;
	protected double electricProc;
	protected double toxinProc;
	protected double corrosiveProc;
	protected double gasProc;
	protected double magneticProc;
	protected double viralProc;
	protected double corrosiveProjectionMult = 0.0;
	protected double shieldDamage = 0;
	protected double healthDamage = 0;
	protected double armorDamage = 0;
	protected double averageArmorMult = 0;
	protected int spliterations;

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
		switch (surfaceType) {
		case Constants.ENEMY_SURFACE_CLONE_FLESH:
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
			break;
		case Constants.ENEMY_SURFACE_MECHANICAL:
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
			break;
		case Constants.ENEMY_SURFACE_CORPUS_FLESH:
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
			break;
		case Constants.ENEMY_SURFACE_INFESTED_FLESH:
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
			break;
		case Constants.ENEMY_SURFACE_FOSSILIZED:
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
			break;
		case Constants.ENEMY_SURFACE_SINEW:
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
			break;
		case Constants.ENEMY_SURFACE_ROBOTIC:
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
			break;
		case Constants.ENEMY_SURFACE_INFESTED:
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
			break;
		}

		// Armor Mults
		switch (armorType) {
		case Constants.ENEMY_SURFACE_FERRITE_ARMOR:
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
			break;
		case Constants.ENEMY_SURFACE_ALLOY_ARMOR:
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
			break;
		}

		// Shield Mults
		switch (shieldType) {
		case Constants.ENEMY_SURFACE_SHIELDS:
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
			break;
		case Constants.ENEMY_SURFACE_PROTO_SHIELD:
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
			break;
		}

		switch (factionType) {
		case Constants.ENEMY_TYPE_INFESTED:
			typeMult = Main.finalInfestedMult;
			break;
		case Constants.ENEMY_TYPE_GRINEER:
			typeMult = Main.finalGrineerMult;
			break;
		case Constants.ENEMY_TYPE_CORPUS:
			typeMult = Main.finalCorpusMult;
			break;
		}

		// Simulation Data
		millisceondsPerShot = (int) (1000.0 / Main.finalFireRate);
		reloadTimeMilliseconds = (int) (Main.finalReloadTime * 1000);

		// Proc chances
		slashProc = Main.slashProcRate;
		fireProc = Main.fireProcRate;
		electricProc = Main.electricProcRate;
		toxinProc = Main.toxinProcRate;
		corrosiveProc = Main.corrosiveProcRate;
		gasProc = Main.gasProcRate;
		magneticProc = Main.magneticProcRate;
		viralProc = Main.viralProcRate;

		// Pre-calculate damage
		shieldDamage = 0;
		shieldDamage += Main.impact.finalBase * shieldImpactMult;
		shieldDamage += Main.puncture.finalBase * shieldPunctureMult;
		shieldDamage += Main.slash.finalBase * shieldSlashMult;
		shieldDamage += Main.fire.finalBase * shieldFireMult;
		shieldDamage += Main.ice.finalBase * shieldIceMult;
		shieldDamage += Main.electric.finalBase * shieldElectricMult;
		shieldDamage += Main.toxin.finalBase * shieldToxinMult;
		shieldDamage += Main.blast.finalBase * shieldBlastMult;
		shieldDamage += Main.corrosive.finalBase * shieldCorrosiveMult;
		shieldDamage += Main.gas.finalBase * shieldGasMult;
		shieldDamage += Main.magnetic.finalBase * shieldMagneticMult;
		shieldDamage += Main.radiation.finalBase * shieldRadiationMult;
		shieldDamage += Main.viral.finalBase * shieldViralMult;

		healthDamage = 0;
		healthDamage += Main.impact.finalBase * impactMult;
		healthDamage += Main.puncture.finalBase * punctureMult;
		healthDamage += Main.slash.finalBase * slashMult;
		healthDamage += Main.fire.finalBase * fireMult;
		healthDamage += Main.ice.finalBase * iceMult;
		healthDamage += Main.electric.finalBase * electricMult;
		healthDamage += Main.toxin.finalBase * toxinMult;
		healthDamage += Main.blast.finalBase * blastMult;
		healthDamage += Main.corrosive.finalBase * corrosiveMult;
		healthDamage += Main.gas.finalBase * gasMult;
		healthDamage += Main.magnetic.finalBase * magneticMult;
		healthDamage += Main.radiation.finalBase * radiationMult;
		healthDamage += Main.viral.finalBase * viralMult;

		armorDamage = 0;
		armorDamage += Main.impact.finalBase * impactMult * armorImpactMult;
		armorDamage += Main.puncture.finalBase * punctureMult * armorPunctureMult;
		armorDamage += Main.slash.finalBase * slashMult * armorSlashMult;
		armorDamage += Main.fire.finalBase * fireMult * armorFireMult;
		armorDamage += Main.ice.finalBase * iceMult * armorIceMult;
		armorDamage += Main.electric.finalBase * electricMult * armorElectricMult;
		armorDamage += Main.toxin.finalBase * toxinMult * armorToxinMult;
		armorDamage += Main.blast.finalBase * blastMult * armorBlastMult;
		armorDamage += Main.corrosive.finalBase * corrosiveMult * armorCorrosiveMult;
		armorDamage += Main.gas.finalBase * gasMult * armorGasMult;
		armorDamage += Main.magnetic.finalBase * magneticMult * armorMagneticMult;
		armorDamage += Main.radiation.finalBase * radiationMult * armorRadiationMult;
		armorDamage += Main.viral.finalBase * viralMult * armorViralMult;

		averageArmorMult = 0;
		averageArmorMult += Main.impact.finalBase * (1 / ((2 - armorImpactMult) / 300));
		averageArmorMult += Main.puncture.finalBase * (1 / ((2 - armorPunctureMult) / 300));
		averageArmorMult += Main.slash.finalBase * (1 / ((2 - armorSlashMult) / 300));
		averageArmorMult += Main.fire.finalBase * (1 / ((2 - armorFireMult) / 300));
		averageArmorMult += Main.ice.finalBase * (1 / ((2 - armorIceMult) / 300));
		averageArmorMult += Main.electric.finalBase * (1 / ((2 - armorElectricMult) / 300));
		averageArmorMult += Main.toxin.finalBase * (1 / ((2 - armorToxinMult) / 300));
		averageArmorMult += Main.blast.finalBase * (1 / ((2 - armorBlastMult) / 300));
		averageArmorMult += Main.corrosive.finalBase * (1 / ((2 - armorCorrosiveMult) / 300));
		averageArmorMult += Main.gas.finalBase * (1 / ((2 - armorGasMult) / 300));
		averageArmorMult += Main.magnetic.finalBase * (1 / ((2 - armorMagneticMult) / 300));
		averageArmorMult += Main.radiation.finalBase * (1 / ((2 - armorRadiationMult) / 300));
		averageArmorMult += Main.viral.finalBase * (1 / ((2 - armorViralMult) / 300));
		averageArmorMult /= Main.raw.finalBase;
		averageArmorMult = 1 / averageArmorMult;

		corrosiveProjectionMult = Main.getCorrosiveProjectionMult();
		DoTBase = (Main.raw.base * Main.finalDamageMult) * Main.finalDeadAimMult;
		
		int cores = Runtime.getRuntime().availableProcessors();
		spliterations = (Main.complexTTKIterations / cores);
		clearValues();
		if (Main.complexTTKIterations > 1) {
			ExecutorService es = Executors.newCachedThreadPool();
			for (int i = 0; i < cores; i++) {
				es.execute(new Runnable() {
					public void run() {
						for (int i = 0; i < spliterations; i++) {
							TTKVec.add(calculateRandomizedTimeToKill());
						}
					}
				});
			}
			es.shutdown();
			try {
				while (!es.awaitTermination(1, TimeUnit.MINUTES));
			} catch (InterruptedException e) {
				e.printStackTrace();
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
		double localProjectileCount = 1.0;
		int shotTimer = 0;
		int statusTimer = 100;
		int nextEvent = 0;
		int iterations = 0;
		int timeToKill = 0;
		double viralHealth = 0;
		int corrosiveStacks = 0;
		int viralStacks = 0;
		int magneticStacks = 0;
		Vector<DoTPair> statusStacks = new Vector<DoTPair>();
		int rampMult = 0;
		int millisecondMult = 5;
		statusStacks.add(new DoTPair(0, 0)); // Dedicated fire stack
		Random rng = new Random();

		// Find initial starting combo
		double comboCount = Main.combo * Math.pow(3, ((Main.startingCombo - 1) / 0.5) - 1);
		if (Main.startingCombo == 1) {
			comboCount = 0;
		}
		// Start charging charge weapons
		if (Main.weaponMode.equals(Constants.CHARGE) || Main.weaponMode.equals(Constants.CHARGEBOW) || Main.weaponMode.equals(Constants.LANKA)) {
			shotTimer = 0;
			if (Main.fireRate > 0) {
				shotTimer += (1 / (Main.fireRate * (1 + Main.fireRateModPower))) * 1000;
			}
		}
		if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
			millisecondMult = 1;
		}

		// Run a 600 second simulation to calculate the time to kill
		for (timeToKill = 0; timeToKill < 600000;) {
			// Add new stack

			// is it time to fire a new projectile?
			if (shotTimer <= 0) {

				if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
					millisecondMult++;
					if (millisecondMult > 5) {
						millisecondMult = 5;
					}
				}
				// Kohm Pellets
				localProjectileCount = Main.finalProjectileCount;
				if (Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
					double rampBulletMult = ((iterations + 1) / Main.projectileCount);
					if (rampBulletMult > 1)
						rampBulletMult = 1;
					localProjectileCount *= rampBulletMult;
				}
				// Burst
				int bursts = 1;
				if (Main.weaponMode.equals(Constants.BURST)) {
					bursts = Main.burstCount;
				}
				for (int b = 0; b < bursts; b++) {

					// Adjust Max Stats
					// Shields
					targetAdjustedMaxShields = maxShields;
					if (magneticStacks > 0) {
						targetAdjustedMaxShields *= 0.25;
					}
					if (targetAdjustedMaxShields < targetCurrentShields) {
						targetCurrentShields = targetAdjustedMaxShields;
					}
					// Health
					if (viralStacks > 0) {
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
					targetAdjustedMaxArmor *= corrosiveProjectionMult;
					if (corrosiveStacks > 0) {
						for (int i = 0; i < corrosiveStacks; i++) {
							targetAdjustedMaxArmor *= 0.75;
						}
					}
					if (targetAdjustedMaxArmor < 1) {
						targetAdjustedMaxArmor = 0;
					}

					// Find shot-unique multipliers
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
					// Primed Chamber
					double firstShotMult = 1;
					if (Main.finalFirstShotDamageMult > 0 && iterations == 0) {
						firstShotMult = 1 + Main.finalFirstShotDamageMult;
					}
					// Synth Charge
					double lastShotMult = 1;
					if (Main.finalLastShotDamageMult > 0 && iterations == (Main.finalMag - 1)) {
						lastShotMult = 1 + Main.finalLastShotDamageMult;
					}

					// Shoot 1 projectile
					for (int p = 0; p < multishot; p++) {

						// Find Crit
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

						// Vigilante Proc?
						if (Main.vigilante > 0 && Main.vigilante > rng.nextDouble()) {
							localCritMult += Main.finalCritMult;
						}

						// Headshot damage multiplier
						int headShotMult = 1;
						if (Main.headShot) {
							headShotMult = 2;
							if (crit > 0) {
								headShotMult = 4;
							}
						}

						// Total multiplier
						double totalMult = comboMult * beamMult * headShotMult * localCritMult * typeMult * firstShotMult * lastShotMult;

						// Deal Damage
						if (targetCurrentShields > 0.0) {
							targetCurrentShields -= shieldDamage * totalMult;
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
								targetCurrentHealth -= armorDamage / (1 + (targetAdjustedMaxArmor * averageArmorMult)) * totalMult * shieldDifference;
							} else {
								targetCurrentHealth -= healthDamage * totalMult * shieldDifference;
							}
						}

						// Status effects
						// Hunter Munitions proc?
						if (Main.hunterMunitions > 0 && crit > 0 && rng.nextDouble() <= Main.hunterMunitions) {
							double bleedDamage = DoTBase * totalMult * 0.35;
							int slashDuration = (int) (6 * Main.finalStatusDuration) * 1000;
							statusStacks.add(new DoTPair(bleedDamage, slashDuration));
							targetCurrentHealth -= bleedDamage;
						}
						// Forced poison proc?
						if (Main.weaponName.equals("Hystrix (Poison)") || Main.weaponName.equals("Acrid")) {
							double localToxinMult = toxinMult;
							if (targetAdjustedMaxArmor > 0.0) {
								localToxinMult = (toxinMult * armorToxinMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300));
							}
							double poisonDamage = (DoTBase * (1 + Main.globalToxin) * typeMult) * localToxinMult * totalMult * 0.5;
							int toxinDuration = (int) (8 * Main.finalStatusDuration) * 1000;
							statusStacks.add(new DoTPair(poisonDamage, toxinDuration));
							targetCurrentHealth -= poisonDamage;
						}
						// Do we get a random status proc?
						if (rng.nextDouble() <= Main.finalStatusChance) {

							// Which Proc?
							double proc = rng.nextDouble();
							// Slash Proc
							if ((proc -= slashProc) < 0) {
								double bleedDamage = DoTBase * totalMult * 0.35;
								int slashDuration = (int) (6 * Main.finalStatusDuration) * 1000;
								statusStacks.add(new DoTPair(bleedDamage, slashDuration));
								targetCurrentHealth -= bleedDamage;
								// Fire Proc
							} else if ((proc -= fireProc) < 0) {
								double localFireMult = fireMult;
								if (targetCurrentShields > 0.0) {
									localFireMult = shieldFireMult;
								} else if (targetAdjustedMaxArmor > 0.0) {
									localFireMult = (fireMult * armorFireMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorFireMult)) / 300));
								}
								double heatDamage = DoTBase * (1 + Main.globalFire) * localFireMult * totalMult * 0.5;
								int heatDuration = (int) (6 * Main.finalStatusDuration) * 1000;
								statusStacks.get(0).duration = heatDuration;
								if (statusStacks.get(0).damage == 0) {
									statusStacks.get(0).damage = heatDamage;
								}
								if (targetCurrentShields > 0) {
									targetCurrentShields -= heatDamage;
								} else {
									targetCurrentHealth -= heatDamage;
								}
								// Electric Pric
							} else if ((proc -= electricProc) < 0) {
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
								// Toxin Proc
							} else if ((proc -= toxinProc) < 0) {
								double localToxinMult = toxinMult;
								if (targetAdjustedMaxArmor > 0.0) {
									localToxinMult = ((toxinMult * armorToxinMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)));
								}
								double poisonDamage = DoTBase * (1 + Main.globalToxin) * typeMult * localToxinMult * totalMult * 0.5;
								int toxinDuration = (int) (8 * Main.finalStatusDuration) * 1000;
								statusStacks.add(new DoTPair(poisonDamage, toxinDuration));
								targetCurrentHealth -= poisonDamage;
								// Gas Proc
							} else if ((proc -= gasProc) < 0) {
								double localGasMult = toxinMult;
								if (targetAdjustedMaxArmor > 0.0) {
									localGasMult = ((toxinMult * armorToxinMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)));
								}
								double cloudDamage = DoTBase * (1 + Main.globalToxin) * typeMult * localGasMult * totalMult * 0.5;
								double poisonDamage = DoTBase * (1 + Main.globalToxin) * (1 + Main.globalToxin) * typeMult * typeMult * localGasMult * totalMult * 0.25;
								int gasDuration = (int) (8 * Main.finalStatusDuration) * 1000;
								statusStacks.add(new DoTPair(poisonDamage, gasDuration));
								targetCurrentHealth -= (cloudDamage + poisonDamage);
								// Magnetic Proc
							} else if ((proc -= magneticProc) < 0) {
								magneticStacks = (int) (Math.round(6000 * Main.finalStatusDuration));
								// Viral Proc
							} else if ((proc -= viralProc) < 0) {
								viralStacks = (int) (Math.round(6000 * Main.finalStatusDuration));
								// Corrosive Proc
							} else if ((proc -= corrosiveProc) < 0) {
								corrosiveStacks++;
							}
						}
					}
					shotTimer = (millisceondsPerShot * (5 / millisecondMult)) + 1;
					iterations++;
					// Have we unloaded the whole mag and need to reload?
					if (iterations >= Main.finalMag) {
						iterations = 0;
						if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
							millisecondMult = 1;
						}
						rampMult = -(reloadTimeMilliseconds + (millisceondsPerShot * (5 / millisecondMult)));
						shotTimer += reloadTimeMilliseconds;
					}
				}
			}

			// Check on timed status stacks every 0.1 seconds
			if (timeToKill % 100 == 0) {
				// DoTs
				for (int j = 0; j < statusStacks.size(); j++) {
					statusStacks.get(j).duration -= 100;
					if (statusStacks.get(j).duration % 1000 == 0 && statusStacks.get(j).duration >= 0) {
						targetCurrentHealth -= statusStacks.get(j).damage;
					}
					if (statusStacks.get(j).duration <= 0 && j > 0) {
						statusStacks.remove(j);
					}
				}
				// Others
				viralStacks -= 100;
				magneticStacks -= 100;

				statusTimer = 100;
			}

			// Check for Death
			if (targetCurrentHealth < 0.0) {
				return timeToKill / 1000.0;
			}

			// Find next event
			if (shotTimer < statusTimer) {
				statusTimer -= shotTimer;
				nextEvent = shotTimer;
			} else {
				nextEvent = statusTimer;
			}

			// Advance time
			rampMult += nextEvent;
			shotTimer -= nextEvent;
			timeToKill += nextEvent;

		}
		return timeToKill / 1000.0;
	}

	/**
	 * Calculates the average time to kill a target with the supplied stats
	 */
	public double calculateHardTimeToKill() {

		double slashProcsPerShot = slashProc * Main.finalProjectileCount * Main.finalStatusChance;
		double fireProcsPerShot = fireProc * Main.finalProjectileCount * Main.finalStatusChance;
		double electricProcsPerShot = electricProc * Main.finalProjectileCount * Main.finalStatusChance;
		double toxinProcsPerShot = toxinProc * Main.finalProjectileCount * Main.finalStatusChance;
		double corrosiveProcsPerShot = corrosiveProc * Main.finalProjectileCount * Main.finalStatusChance;
		double gasProcsPerShot = gasProc * Main.finalProjectileCount * Main.finalStatusChance;
		double magneticProcsPerShot = magneticProc * Main.finalProjectileCount * Main.finalStatusChance;
		double viralProcsPerShot = viralProc * Main.finalProjectileCount * Main.finalStatusChance;

		double targetAdjustedMaxShields = maxShields;
		double targetCurrentShields = maxShields;
		double targetCurrentHealth = maxHealth;
		double targetAdjustedMaxArmor = maxArmor;
		double localProjectileCount = 1.0;
		int shotTimer = 0;
		int statusTimer = 0;
		int nextEvent = 0;
		int iterations = 0;
		int timeToKill = 0;

		int corrosiveStacks = 0;
		int viralStacks = 0;
		int magneticStacks = 0;
		double viralHealth = 0;
		Vector<DoTPair> statusStacks = new Vector<DoTPair>();
		int rampMult = 0;
		int millisecondMult = 5;
		statusStacks.add(new DoTPair(0, 0)); // Dedicated fire stack

		double comboCount = Main.combo * Math.pow(3, ((Main.startingCombo - 1) / 0.5) - 1);
		if (Main.startingCombo == 1) {
			comboCount = 0;
		}

		if (Main.weaponMode.equals(Constants.CHARGE) || Main.weaponMode.equals(Constants.CHARGEBOW) || Main.weaponMode.equals(Constants.LANKA)) {
			shotTimer = 0;
			if (Main.fireRate > 0) {
				shotTimer += (1 / (Main.fireRate * (1 + Main.fireRateModPower))) * 1000;
			}
		}

		if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
			millisecondMult = 1;
		}

		// Run a 60 second simulation to calculate the time to kill
		for (timeToKill = 0; timeToKill < 30000;) {
			// Add new stack
			// is it time to fire a new projectile?
			if (shotTimer <= 0) {

				if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
					millisecondMult++;
					if (millisecondMult > 5) {
						millisecondMult = 5;
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

					double firstShotMult = 1;
					if (Main.finalFirstShotDamageMult > 0 && iterations == 0) {
						firstShotMult = 1 + Main.finalFirstShotDamageMult;
					}

					double lastShotMult = 1;
					if (Main.finalLastShotDamageMult > 0 && iterations == (Main.finalMag - 1)) {
						lastShotMult = 1 + Main.finalLastShotDamageMult;
					}

					// Adjust Max Stats
					// Shields
					targetAdjustedMaxShields = maxShields;
					if (magneticStacks > 0) {
						targetAdjustedMaxShields *= 0.25;
					}
					if (targetAdjustedMaxShields < targetCurrentShields) {
						targetCurrentShields = targetAdjustedMaxShields;
					}

					// Health
					if (viralStacks > 0) {
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

					double headShotMult = 1;
					if (Main.headShot) {
						headShotMult = 2 + (2 * critty);
					}

					// Total multiplier
					double totalMult = comboMult * beamMult * headShotMult * localCritMult * typeMult * firstShotMult * lastShotMult;

					// Deal Damage
					if (targetCurrentShields > 0.0) {
						targetCurrentShields -= shieldDamage * totalMult * localProjectileCount;
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
							targetCurrentHealth -= armorDamage / (1 + (targetAdjustedMaxArmor * averageArmorMult)) * totalMult * shieldDifference * localProjectileCount;
						} else {
							targetCurrentHealth -= healthDamage * totalMult * shieldDifference * localProjectileCount;
						}
					}

					// Hunter Munitions proc!
					if (Main.hunterMunitions > 0) {
						double bleedDamage = DoTBase * totalMult * 0.35 * critty * Main.hunterMunitions * localProjectileCount;
						int slashDuration = (int) (6 * Main.finalStatusDuration) * 1000;
						statusStacks.add(new DoTPair(bleedDamage, slashDuration));
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
						statusStacks.add(new DoTPair(poisonDamage, toxinDuration));
						targetCurrentHealth -= poisonDamage;
					}

					// All the other procs!
					double bleedDamage = DoTBase * totalMult * 0.35 * slashProcsPerShot;
					int slashDuration = (int) (6 * Main.finalStatusDuration) * 1000;
					statusStacks.add(new DoTPair(bleedDamage, slashDuration));
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
					statusStacks.get(0).duration = heatDuration;
					if (statusStacks.get(0).damage == 0) {
						statusStacks.get(0).damage = heatDamage;
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
					statusStacks.add(new DoTPair(poisonDamage, toxinDuration));
					targetCurrentHealth -= poisonDamage;

					// Gas Proc!
					double localGasMult = toxinMult;
					if (targetAdjustedMaxArmor > 0.0) {
						localGasMult = ((toxinMult * armorToxinMult) / (1 + ((targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)));
					}
					double cloudDamage = DoTBase * (1 + Main.globalToxin) * typeMult * localGasMult * totalMult * 0.5 * gasProcsPerShot;
					double gasDamage = DoTBase * (1 + Main.globalToxin) * (1 + Main.globalToxin) * typeMult * typeMult * localGasMult * totalMult * 0.25 * gasProcsPerShot;
					int gasDuration = (int) (8 * Main.finalStatusDuration) * 1000;
					statusStacks.add(new DoTPair(gasDamage, gasDuration));
					targetCurrentHealth -= (cloudDamage + gasDamage);

					// Viral Proc!
					viralStacks += viralProcsPerShot * (int) (Math.round(6000 * Main.finalStatusDuration));
					// Magnetic Proc!
					magneticStacks += magneticProcsPerShot * (int) (Math.round(6000 * Main.finalStatusDuration));
					// Corrosive Proc!
					corrosiveStacks++;

					shotTimer = (millisceondsPerShot * (5 / millisecondMult)) + 1;
					iterations++;
					// Have we unloaded the whole mag and need to reload?
					if (iterations >= Main.finalMag) {
						iterations = 0;
						rampMult = 0;
						if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
							millisecondMult = 1;
						}
						rampMult -= reloadTimeMilliseconds + (millisceondsPerShot * (5 / millisecondMult));
						shotTimer = reloadTimeMilliseconds + (millisceondsPerShot * (5 / millisecondMult));
					}
				}
			}

			// Check on timed status stacks every 0.1 seconds
			if (timeToKill % 100 == 0) {
				// DoTs
				for (int j = 0; j < statusStacks.size(); j++) {
					statusStacks.get(j).duration -= 100;
					if (statusStacks.get(j).duration % 1000 == 0 && statusStacks.get(j).duration >= 0) {
						targetCurrentHealth -= statusStacks.get(j).damage;
					}
					if (statusStacks.get(j).duration <= 0 && j > 0) {
						statusStacks.remove(j);
					}
				}
				// Others
				viralStacks -= 100;
				magneticStacks -= 100;

				statusTimer = 100;
			}

			// Check for Death
			if (targetCurrentHealth < 0.0) {
				return timeToKill / 1000.0;
			}

			// Find next event
			if (shotTimer < statusTimer) {
				statusTimer -= shotTimer;
				nextEvent = shotTimer;
			} else {
				nextEvent = statusTimer;
			}

			// Advance time
			rampMult += nextEvent;
			shotTimer -= nextEvent;
			timeToKill += nextEvent;

		}
		return timeToKill / 1000;
	}
}