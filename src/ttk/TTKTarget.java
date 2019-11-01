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
	public Vector<Integer> groups = new Vector<Integer>();
	protected int baseLevel = 0;
	public int currentLevel = 0;
	public int defaultLevel = 0;
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
	public double TTK = 0.0;
	protected double minTTK = 0.0;
	public double maxTTK = 0.0;
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
	protected double explosiveDoTBase = 0.0;
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
	protected double impactProc;
	protected double punctureProc;
	protected double iceProc;
	protected double blastProc;
	protected double radiationProc;

	protected double corrosiveProjectionMult = 0.0;
	protected double shieldDisruptionMult = 0.0;
	protected double shieldDamage = 0;
	protected double healthDamage = 0;
	protected double armorDamage = 0;
	protected double averageArmorMult = 0;
	protected double explosiveShieldDamage = 0;
	protected double explosiveHealthDamage = 0;
	protected double explosiveArmorDamage = 0;
	protected double explosiveAverageArmorMult = 0;
	protected int spliterations;
	int bursts;

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
		defaultLevel = Integer.parseInt(split[2]);
		baseArmor = Integer.parseInt(split[3]);
		baseHealth = Integer.parseInt(split[4]);
		baseShields = Integer.parseInt(split[5]);
		surfaceType = split[6];
		armorType = split[7];
		shieldType = split[8];
		factionType = split[9];
		try {
			String[] groupString = split[10].split(";");
			for (String gru : groupString) {
				if (gru != null)
					groups.add(Integer.parseInt(gru));
			}
			// group = Integer.parseInt(split[10]);
		} catch (Exception ex) {
			// Legacy, default to group 0
		}
	}

	/**
	 * Builds a string to save this TTK target by
	 * 
	 * @return save string
	 */
	public String buildSaveString() {
		String groupStr = "";
		for (int gru : groups) {
			groupStr += gru + ";";
		}
		return name + "," + baseLevel + "," + currentLevel + "," + baseArmor + "," + baseHealth + "," + baseShields + "," + surfaceType + "," + armorType + "," + shieldType + "," + factionType + "," + groupStr;
	}

	/**
	 * Runs an advanced TTK calculation
	 */
	public void runAdvancedTTK() {

		// Target Base values
		if (!Main.targetLevelField.getText().equals("") && !Main.targetLevelField.getText().equals("0")) {
			currentLevel = Integer.parseInt(Main.targetLevelField.getText());
		} else {
			currentLevel = defaultLevel;
		}
		maxArmor = (int) ((Math.pow((currentLevel - baseLevel), 1.75) * 0.005 * baseArmor) + baseArmor);
		maxShields = (int) ((Math.pow((currentLevel - baseLevel), 2.0) * 0.0075 * baseShields) + baseShields);
		maxHealth = (int) ((Math.pow((currentLevel - baseLevel), 2.0) * 0.015 * baseHealth) + baseHealth);

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
		case Constants.ENEMY_TYPE_CORRUPTED:
			typeMult = Main.finalCorruptedMult;
			break;
		}

		// Simulation Data
		millisceondsPerShot = (int) (10000.0 / Main.finalFireRate);
		reloadTimeMilliseconds = (int) (Main.finalReloadTime * 10000);

		// Proc chances
		slashProc = Main.slashProcRate;
		fireProc = Main.fireProcRate;
		electricProc = Main.electricProcRate;
		toxinProc = Main.toxinProcRate;
		corrosiveProc = Main.corrosiveProcRate;
		gasProc = Main.gasProcRate;
		magneticProc = Main.magneticProcRate;
		viralProc = Main.viralProcRate;
		impactProc = Main.impactProcRate;
		punctureProc = Main.punctureProcRate;
		iceProc = Main.iceProcRate;
		blastProc = Main.blastProcRate;
		radiationProc = Main.radiationProcRate;

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

		// And for the explosion
		explosiveShieldDamage = 0;
		explosiveShieldDamage += Main.explosiveImpact.finalBase * shieldImpactMult;
		explosiveShieldDamage += Main.explosivePuncture.finalBase * shieldPunctureMult;
		explosiveShieldDamage += Main.explosiveSlash.finalBase * shieldSlashMult;
		explosiveShieldDamage += Main.explosiveFire.finalBase * shieldFireMult;
		explosiveShieldDamage += Main.explosiveIce.finalBase * shieldIceMult;
		explosiveShieldDamage += Main.explosiveElectric.finalBase * shieldElectricMult;
		explosiveShieldDamage += Main.explosiveToxin.finalBase * shieldToxinMult;
		explosiveShieldDamage += Main.explosiveBlast.finalBase * shieldBlastMult;
		explosiveShieldDamage += Main.explosiveCorrosive.finalBase * shieldCorrosiveMult;
		explosiveShieldDamage += Main.explosiveGas.finalBase * shieldGasMult;
		explosiveShieldDamage += Main.explosiveMagnetic.finalBase * shieldMagneticMult;
		explosiveShieldDamage += Main.explosiveRadiation.finalBase * shieldRadiationMult;
		explosiveShieldDamage += Main.explosiveViral.finalBase * shieldViralMult;

		explosiveHealthDamage = 0;
		explosiveHealthDamage += Main.explosiveImpact.finalBase * impactMult;
		explosiveHealthDamage += Main.explosivePuncture.finalBase * punctureMult;
		explosiveHealthDamage += Main.explosiveSlash.finalBase * slashMult;
		explosiveHealthDamage += Main.explosiveFire.finalBase * fireMult;
		explosiveHealthDamage += Main.explosiveIce.finalBase * iceMult;
		explosiveHealthDamage += Main.explosiveElectric.finalBase * electricMult;
		explosiveHealthDamage += Main.explosiveToxin.finalBase * toxinMult;
		explosiveHealthDamage += Main.explosiveBlast.finalBase * blastMult;
		explosiveHealthDamage += Main.explosiveCorrosive.finalBase * corrosiveMult;
		explosiveHealthDamage += Main.explosiveGas.finalBase * gasMult;
		explosiveHealthDamage += Main.explosiveMagnetic.finalBase * magneticMult;
		explosiveHealthDamage += Main.explosiveRadiation.finalBase * radiationMult;
		explosiveHealthDamage += Main.explosiveViral.finalBase * viralMult;

		explosiveArmorDamage = 0;
		explosiveArmorDamage += Main.explosiveImpact.finalBase * impactMult * armorImpactMult;
		explosiveArmorDamage += Main.explosivePuncture.finalBase * punctureMult * armorPunctureMult;
		explosiveArmorDamage += Main.explosiveSlash.finalBase * slashMult * armorSlashMult;
		explosiveArmorDamage += Main.explosiveFire.finalBase * fireMult * armorFireMult;
		explosiveArmorDamage += Main.explosiveIce.finalBase * iceMult * armorIceMult;
		explosiveArmorDamage += Main.explosiveElectric.finalBase * electricMult * armorElectricMult;
		explosiveArmorDamage += Main.explosiveToxin.finalBase * toxinMult * armorToxinMult;
		explosiveArmorDamage += Main.explosiveBlast.finalBase * blastMult * armorBlastMult;
		explosiveArmorDamage += Main.explosiveCorrosive.finalBase * corrosiveMult * armorCorrosiveMult;
		explosiveArmorDamage += Main.explosiveGas.finalBase * gasMult * armorGasMult;
		explosiveArmorDamage += Main.explosiveMagnetic.finalBase * magneticMult * armorMagneticMult;
		explosiveArmorDamage += Main.explosiveRadiation.finalBase * radiationMult * armorRadiationMult;
		explosiveArmorDamage += Main.explosiveViral.finalBase * viralMult * armorViralMult;

		explosiveAverageArmorMult = 0;
		explosiveAverageArmorMult += Main.explosiveImpact.finalBase * (1 / ((2 - armorImpactMult) / 300));
		explosiveAverageArmorMult += Main.explosivePuncture.finalBase * (1 / ((2 - armorPunctureMult) / 300));
		explosiveAverageArmorMult += Main.explosiveSlash.finalBase * (1 / ((2 - armorSlashMult) / 300));
		explosiveAverageArmorMult += Main.explosiveFire.finalBase * (1 / ((2 - armorFireMult) / 300));
		explosiveAverageArmorMult += Main.explosiveIce.finalBase * (1 / ((2 - armorIceMult) / 300));
		explosiveAverageArmorMult += Main.explosiveElectric.finalBase * (1 / ((2 - armorElectricMult) / 300));
		explosiveAverageArmorMult += Main.explosiveToxin.finalBase * (1 / ((2 - armorToxinMult) / 300));
		explosiveAverageArmorMult += Main.explosiveBlast.finalBase * (1 / ((2 - armorBlastMult) / 300));
		explosiveAverageArmorMult += Main.explosiveCorrosive.finalBase * (1 / ((2 - armorCorrosiveMult) / 300));
		explosiveAverageArmorMult += Main.explosiveGas.finalBase * (1 / ((2 - armorGasMult) / 300));
		explosiveAverageArmorMult += Main.explosiveMagnetic.finalBase * (1 / ((2 - armorMagneticMult) / 300));
		explosiveAverageArmorMult += Main.explosiveRadiation.finalBase * (1 / ((2 - armorRadiationMult) / 300));
		explosiveAverageArmorMult += Main.explosiveViral.finalBase * (1 / ((2 - armorViralMult) / 300));
		explosiveAverageArmorMult /= Main.explosiveRaw.finalBase;
		explosiveAverageArmorMult = 1 / explosiveAverageArmorMult;

		bursts = 1;
		if (Main.weaponMode.equals(Constants.BURST)) {
			bursts = Main.burstCount;
		}

		corrosiveProjectionMult = Main.getCorrosiveProjectionMult();
		shieldDisruptionMult = Main.getShieldDisruptionMult();
		DoTBase = (Main.raw.base * Main.finalDamageMult) * Main.finalDeadAimMult;
		explosiveDoTBase = (Main.explosiveRaw.base * Main.finalDamageMult) * Main.finalDeadAimMult;

		int cores = Runtime.getRuntime().availableProcessors();
		spliterations = (Main.complexTTKIterations / cores);
		clearValues();

		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < cores; i++) {
			es.execute(new Runnable() {
				public void run() {
					for (int i = 0; i < spliterations; i++) {
						double time = calculateRandomizedTimeToKill();
						TTKVec.add(time);
						TTK += time;

						// Check if we're wasting time
						if (Main.smartMax.isSelected() && Main.maxxing && TTKVec.size() == 10) {
							double localAverageTTK = TTK / TTKVec.size();
							if (localAverageTTK > (Main.theMaximizer.bestTTK * 1.2)) {
								TTK = Double.POSITIVE_INFINITY;
								break;
							}
						}

					}
				}
			});
		}
		es.shutdown();
		try {
			while (!es.awaitTermination(1, TimeUnit.MINUTES))
				;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		TTK /= TTKVec.size();
		Collections.sort(TTKVec);
		minTTK = TTKVec.get(0);
		maxTTK = TTKVec.get(TTKVec.size() - 1);
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

		double targetCurrentShields = maxShields;
		targetCurrentShields *= shieldDisruptionMult;
		double targetCurrentHealth = maxHealth;
		int targetAdjustedMaxArmor = maxArmor;
		targetAdjustedMaxArmor *= corrosiveProjectionMult;
		double localProjectileCount = 1.0;
		int shotTimer = 0;
		int statusTimer = 1000;
		int nextEvent = 0;
		int iterations = 0;
		int timeToKill = 0;
		double viralHealth = 0;
		double magneticShields = 0;
		Vector<DoTPair> statusStacks = new Vector<DoTPair>();
		// slash, fire, electric, toxin, gas, magnetic, viral, corrosive, impact,
		// puncture, ice, blast, knockdown, radiation
		int statusEffects[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int rampMult = 0;
		int millisecondMult = 5;
		statusStacks.add(new DoTPair(0, 0, 0, fireMult, armorFireMult, shieldFireMult, false)); // Dedicated fire stack
		Random rng = new Random();
		double coldProcMult = 1;
		double heatProcMult = 1;
		double meleeHitMult = 1;
		double meleeHitDelay = 1;
		int shatteringImpacts = 0;
		double shatteringImpactMult = 1;
		double localStatus = Main.finalStatusChance;

		// Find initial starting combo
		double comboCount = 0;
		if (Main.weaponMode.equals(Constants.SNIPER) || Main.weaponMode.equals(Constants.LANKA)) {
			comboCount = Main.combo * Math.pow(3, ((Main.selectedWeapon.getStartingCombo() - 1) / 0.5) - 1);
		} else if (Main.selectedWeapon.weaponType.equals(Constants.MELEE)) {
			comboCount = Main.selectedWeapon.getStartingCombo() * 20;
		}
		if (Main.selectedWeapon.getStartingCombo() == 1) {
			comboCount = 0;
		}

		// Start charging charge weapons
		if (Main.weaponMode.equals(Constants.CHARGE) || Main.weaponMode.equals(Constants.CHARGEBOW) || Main.weaponMode.equals(Constants.LANKA)) {
			shotTimer = 0;
			if (Main.fireRate > 0) {
				shotTimer += (1 / (Main.fireRate * (1 + Main.fireRateModPower))) * 10000;
			}
		}
		if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
			millisecondMult = 1;
		}

		// Run a X second simulation to calculate the time to kill
		for (timeToKill = 0; timeToKill < Main.maxTTKTime;) {

			// is it time to shoot?
			if (shotTimer <= 0) {

				millisecondMult = Math.min(millisecondMult += 1, 5);

				// Kohm Pellets
				localProjectileCount = Main.finalProjectileCount;
				if (Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
					localProjectileCount *= Math.min(1, ((iterations + 1) / Main.projectileCount));

					// Recalculate status chance
					localStatus = 1 - Math.pow(1 - Main.finalStatusChance, Main.projectileCount);
					localStatus = 1 - Math.pow(1 - localStatus, Math.min(Main.projectileCount, 1 / ((double) iterations + 1)));
				}

				for (int b = 0; b < bursts; b++) {

					// Find multishot
					int multishot = (int) localProjectileCount;
					if (rng.nextDouble() < (localProjectileCount - multishot)) {
						multishot++;
					}

					// Beam weapon ramp-up damage 20% to 100% in 0.6 seconds
					double beamMult = 1;
					if (Main.weaponMode.equals(Constants.CONTINUOUS)) {
						beamMult = Math.min(1, 0.2 + (rampMult / 6000) * 0.8);
						beamMult *= multishot;
						multishot = 1;
					}

					// Combo multipliers
					double comboMult = 1;
					if (Main.weaponMode.equals(Constants.SNIPER) || Main.weaponMode.equals(Constants.LANKA)) {
						comboCount += multishot;
						comboMult = Math.max(1, 0.5 * (int) (Math.log((27 * comboCount) / Main.combo) / (Math.log(3))));
					}

					// Melee Combo Stuff
					double comboCritMult = 0;
					double comboStatusMult = 1;
					if (Main.selectedWeapon.weaponType.equals(Constants.MELEE)) {
						comboCount = Math.min(comboCount += Main.stanceCombo.hits.get(iterations).comboIncrease, 220);
						int meleeComboMult = (int) (comboCount / 20);

						if (meleeComboMult >= 2) {
							localStatus = Main.statusChance;
							comboCritMult = Main.comboCrit * meleeComboMult;
							comboStatusMult = (Main.comboStatus * meleeComboMult) + (Main.finalStatusChance / Main.statusChance);
						}
					}

					// Condition Overload
					double COMult = 0;
					if (Main.conditionOverload > 0) {
						for (int status : statusEffects) {
							if (status > 0) {
								COMult += (1 + Main.conditionOverload);
							}
						}
					}

					// Shattering Impact
					shatteringImpactMult = Math.max(0, ((double) baseArmor - shatteringImpacts * Main.shatteringImpact)) / baseArmor;

					// Melee hit stuff
					if (Main.selectedWeapon.weaponType.equals(Constants.MELEE) && Main.stanceCombo != null) {
						meleeHitMult = Main.stanceCombo.hits.get(iterations).multiplier;
						if (iterations != Main.finalMag - 1) {
							meleeHitDelay = Main.stanceCombo.hits.get(iterations + 1).delay;
						} else {
							meleeHitDelay = Main.stanceCombo.hits.get(0).delay;
						}
						for (int i = 0; i < 13; i++) {
							if (Main.stanceCombo.hits.get(iterations).procs[i].equals("1")) { // Forced procs
								statusEffects[i] = (int) (60000 * Main.finalStatusDuration);
							}
						}
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
						int crit = (int) ((comboCritMult + Main.finalCritMult) * Main.critChance);
						if (rng.nextDouble() < ((comboCritMult + Main.finalCritMult) * Main.critChance) - crit) {
							crit++;
						}
						double localCritMult = 1 + crit * (Main.finalCritMult - 1);

						// Vigilante Proc?
						if (Main.vigilante > rng.nextDouble()) {
							localCritMult += (Main.finalCritMult - 1);
						}

						// Headshot damage multiplier
						double headShotMult = 1;
						if (Main.headShot) {
							headShotMult = 2;
							if (crit > 0) {
								headShotMult = 4;
							}
							headShotMult *= Main.headShotBonus;
						}

						// Total multiplier
						double totalMult = ((comboMult * beamMult * headShotMult * localCritMult * typeMult * firstShotMult * lastShotMult * meleeHitMult) / Main.finalDamageMult) * (COMult + Main.finalDamageMult);

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
							if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
								targetCurrentHealth -= armorDamage / (1 + (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * averageArmorMult)) * totalMult * shieldDifference;
							} else {
								targetCurrentHealth -= healthDamage * totalMult * shieldDifference;
							}
						}

						// Status effects

						// Forced procs
						// Forced slash proc?
						boolean forcedSlashProc = false;
						if (rng.nextDouble() < Main.hunterMunitions || (Main.stanceCombo != null && Main.stanceCombo.hits.get(iterations).procs[0].equals("1"))) {
							double bleedDamage = DoTBase * totalMult * typeMult * 0.35;
							int slashDuration = (int) (6 * Main.finalStatusDuration * 10000);
							statusStacks.add(new DoTPair(bleedDamage, slashDuration, 10000, 1, 1, 1, true));
							targetCurrentHealth -= bleedDamage;
							statusEffects[0] = slashDuration;
							forcedSlashProc = true;
						}
						// Forced poison proc?
						if (Main.weaponName.equals("Hystrix (Poison)") || Main.weaponName.equals("Acrid")) {
							double localToxinMult = toxinMult;
							if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
								localToxinMult = (toxinMult * armorToxinMult) / (1 + ((shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300));
							}
							double poisonDamage = (DoTBase * (1 + Main.globalToxin) * typeMult) * totalMult * 0.5;
							int toxinDuration = (int) (8 * Main.finalStatusDuration * 10000);
							statusStacks.add(new DoTPair(poisonDamage, toxinDuration, 10000, toxinMult, armorToxinMult, shieldToxinMult, false));
							targetCurrentHealth -= poisonDamage * localToxinMult;
						}

						// Do we get a random status proc?
						if (rng.nextDouble() <= (localStatus * comboStatusMult)) {

							// Which Proc?
							double proc = rng.nextDouble();

							// Slash Proc
							if ((proc -= slashProc) < 0 && forcedSlashProc == false) {
								double bleedDamage = DoTBase * totalMult * typeMult * 0.35;
								int slashDuration = (int) (6 * Main.finalStatusDuration * 10000);
								statusStacks.add(new DoTPair(bleedDamage, slashDuration, 10000, 1, 1, 1, true));
								targetCurrentHealth -= bleedDamage;
								statusEffects[0] = slashDuration;

								// Fire Proc
							} else if ((proc -= fireProc) < 0) {

								double localFireMult = fireMult;
								if (targetCurrentShields > 0.0) {
									localFireMult = shieldFireMult;
								} else if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
									localFireMult = (fireMult * armorFireMult) / (1 + ((shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * (2 - armorFireMult)) / 300));
								}
								double heatDamage = DoTBase * (1 + Main.globalFire) * totalMult * typeMult * 0.5;
								int heatDuration = (int) (6 * Main.finalStatusDuration * 10000);
								if (statusStacks.get(0).duration <= 0) { // if we need a new stack, set timer
									statusStacks.get(0).timer = 10000;
								}
								statusStacks.get(0).damage += heatDamage;
								statusStacks.get(0).duration = heatDuration;

								if (targetCurrentShields > 0) {
									targetCurrentShields -= heatDamage * localFireMult;
								} else {
									targetCurrentHealth -= heatDamage * localFireMult;
								}
								statusEffects[1] = heatDuration;

								// Electric Proc
							} else if ((proc -= electricProc) < 0) {
								double localElectricMult = electricMult;
								if (targetCurrentShields > 0.0) {
									localElectricMult = shieldElectricMult;
								} else if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
									localElectricMult = (electricMult * armorElectricMult) / (1 + ((shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * (2 - armorElectricMult)) / 300));
								}
								double electricProcDamage = DoTBase * (1 + Main.globalElectric) * localElectricMult * totalMult * 0.5;
								if (targetCurrentShields > 0) {
									targetCurrentShields -= electricProcDamage;
								} else {
									targetCurrentHealth -= electricProcDamage;
								}
								statusEffects[2] = (int) (6 * Main.finalStatusDuration * 10000);

								// Toxin Proc
							} else if ((proc -= toxinProc) < 0) {
								double localToxinMult = toxinMult;
								if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
									localToxinMult = ((toxinMult * armorToxinMult) / (1 + ((shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)));
								}
								double poisonDamage = DoTBase * (1 + Main.globalToxin) * typeMult * totalMult * 0.5;
								int toxinDuration = (int) (8 * Main.finalStatusDuration * 10000);
								statusStacks.add(new DoTPair(poisonDamage, toxinDuration, 10000, toxinMult, armorToxinMult, shieldToxinMult, false));
								targetCurrentHealth -= poisonDamage * localToxinMult;
								statusEffects[3] = toxinDuration;

								// Gas Proc
							} else if ((proc -= gasProc) < 0) {
								double localGasMult = toxinMult;
								if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
									localGasMult = ((toxinMult * armorToxinMult) / (1 + ((shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)));
								}
								double gasHeadMult = 1;
								if (headShotMult > 1) {
									gasHeadMult = 2 * Main.headShotBonus;
								}
								double cloudDamage = DoTBase * (1 + Main.globalToxin) * typeMult * totalMult * 0.5 * gasHeadMult;
								double poisonDamage = DoTBase * (1 + Main.globalToxin) * (1 + Main.globalToxin) * typeMult * typeMult * totalMult * 0.25 * gasHeadMult;
								int gasDuration = (int) (8 * Main.finalStatusDuration * 10000);
								statusStacks.add(new DoTPair(poisonDamage, gasDuration, 10000, toxinMult, armorToxinMult, shieldToxinMult, false));
								targetCurrentHealth -= ((cloudDamage + poisonDamage) * localGasMult);
								statusEffects[4] = gasDuration;

								// Magnetic Proc
							} else if ((proc -= magneticProc) < 0) {
								if (magneticShields == 0) {
									magneticShields = targetCurrentShields * 0.75;
									targetCurrentShields *= 0.25;
								}
								statusEffects[5] = (int) (40000 * Main.finalStatusDuration);

								// Viral Proc
							} else if ((proc -= viralProc) < 0) {
								if (viralHealth == 0) {
									viralHealth = targetCurrentHealth *= 0.5;
								}
								statusEffects[6] = (int) (60000 * Main.finalStatusDuration);

								// Corrosive Proc
							} else if ((proc -= corrosiveProc) < 0) {
								targetAdjustedMaxArmor *= 0.75;
								statusEffects[7] = (int) (60000 * Main.finalStatusDuration);
							} else if ((proc -= impactProc) < 0) {
								statusEffects[8] = (int) (60000 * Main.finalStatusDuration);
							} else if ((proc -= punctureProc) < 0) {
								statusEffects[9] = (int) (60000 * Main.finalStatusDuration);
							} else if ((proc -= iceProc) < 0) {
								coldProcMult = 1.25;
								statusEffects[10] = (int) (60000 * Main.finalStatusDuration);
							} else if ((proc -= blastProc) < 0) {
								statusEffects[11] = (int) (60000 * Main.finalStatusDuration);
								statusEffects[12] = (int) (60000 * Main.finalStatusDuration);
							} else if ((proc -= radiationProc) < 0) {
								statusEffects[13] = (int) (60000 * Main.finalStatusDuration);
							}
						}

						if (Main.shatteringImpact > 0 && Main.impact.finalBase > 0) {
							shatteringImpacts += 1;
						}

						// Explosive part of the shot
						// This CANNOT be how I should do this but I'm too stupid to do it in a
						// different way without breaking multithreading.
						if (Main.explosiveRaw.finalBase > 0) {
							// Find Crit
							crit = (int) (comboCritMult * Main.finalCritChance);
							if (rng.nextDouble() < (comboCritMult * Main.finalCritChance) - crit) {
								crit++;
							}
							localCritMult = 1 + crit * (Main.finalCritMult - 1);

							// Vigilante Proc?
							if (Main.vigilante > rng.nextDouble()) {
								localCritMult += (Main.finalCritMult - 1);
							}

							// Headshot damage multiplier
							headShotMult = 1;
							if (Main.headShot) {
								headShotMult = 2;
								if (crit > 0) {
									headShotMult = 4;
								}
								headShotMult *= Main.headShotBonus;
							}

							// Total multiplier
							//totalMult = ((comboMult * beamMult * headShotMult * localCritMult * typeMult * firstShotMult * lastShotMult * meleeHitMult) / Main.finalDamageMult) * (COMult + Main.finalDamageMult);

							// Deal Damage
							if (targetCurrentShields > 0.0) {
								targetCurrentShields -= explosiveShieldDamage * totalMult;
							}
							if (targetCurrentShields <= 0.0) {
								double shieldDifference = 1.0;
								if (targetCurrentShields < 0.0) {
									double unabsorbed = Math.abs(targetCurrentShields);
									double raw = Main.explosiveRaw.finalBase * totalMult;
									shieldDifference = 1.0 - (unabsorbed / raw);
									targetCurrentShields = 0.0;
								}
								if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
									targetCurrentHealth -= explosiveArmorDamage / (1 + (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * explosiveAverageArmorMult)) * totalMult * shieldDifference;
								} else {
									targetCurrentHealth -= explosiveHealthDamage * totalMult * shieldDifference;
								}
							}

							// Status effects

							// Forced procs
							// Forced slash proc?
							forcedSlashProc = false;
							if (rng.nextDouble() < Main.hunterMunitions || (Main.stanceCombo != null && Main.stanceCombo.hits.get(iterations).procs[0].equals("1"))) {
								double bleedDamage = explosiveDoTBase * totalMult * typeMult * 0.35;
								int slashDuration = (int) (6 * Main.finalStatusDuration * 10000);
								statusStacks.add(new DoTPair(bleedDamage, slashDuration, 10000, 1, 1, 1, true));
								targetCurrentHealth -= bleedDamage;
								statusEffects[0] = slashDuration;
								forcedSlashProc = true;
							}
							// Forced poison proc?
							if (Main.weaponName.equals("Hystrix (Poison)") || Main.weaponName.equals("Acrid")) {
								double localToxinMult = toxinMult;
								if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
									localToxinMult = (toxinMult * armorToxinMult) / (1 + ((shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300));
								}
								double poisonDamage = (explosiveDoTBase * (1 + Main.globalToxin) * typeMult) * totalMult * 0.5;
								int toxinDuration = (int) (8 * Main.finalStatusDuration * 10000);
								statusStacks.add(new DoTPair(poisonDamage, toxinDuration, 10000, toxinMult, armorToxinMult, shieldToxinMult, false));
								targetCurrentHealth -= poisonDamage * localToxinMult;
							}

							// Do we get a random status proc?
							if (rng.nextDouble() <= (localStatus * comboStatusMult)) {

								// Which Proc?
								double proc = rng.nextDouble();

								// Slash Proc
								if ((proc -= Main.explosiveSlashProcRate) < 0 && forcedSlashProc == false) {
									double bleedDamage = explosiveDoTBase * totalMult * typeMult * 0.35;
									int slashDuration = (int) (6 * Main.finalStatusDuration * 10000);
									statusStacks.add(new DoTPair(bleedDamage, slashDuration, 10000, 1, 1, 1, true));
									targetCurrentHealth -= bleedDamage;
									statusEffects[0] = slashDuration;

									// Fire Proc
								} else if ((proc -= Main.explosiveFireProcRate) < 0) {
									double localFireMult = fireMult;
									if (targetCurrentShields > 0.0) {
										localFireMult = shieldFireMult;
									} else if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
										localFireMult = (fireMult * armorFireMult) / (1 + ((shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * (2 - armorFireMult)) / 300));
									}
									double heatDamage = explosiveDoTBase * (1 + Main.globalFire) * totalMult * typeMult * 0.5;
									int heatDuration = (int) (6 * Main.finalStatusDuration * 10000);
									if (statusStacks.get(0).duration <= 0) { // if we need a new stack, set timer
										statusStacks.get(0).timer = 10000;
									}
									statusStacks.get(0).damage += heatDamage;
									statusStacks.get(0).duration = heatDuration;

									if (targetCurrentShields > 0) {
										targetCurrentShields -= heatDamage * localFireMult;
									} else {
										targetCurrentHealth -= heatDamage * localFireMult;
									}
									statusEffects[1] = heatDuration;

									// Electric Proc
								} else if ((proc -= Main.explosiveElectricProcRate) < 0) {
									double localElectricMult = electricMult;
									if (targetCurrentShields > 0.0) {
										localElectricMult = shieldElectricMult;
									} else if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
										localElectricMult = (electricMult * armorElectricMult) / (1 + ((shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * (2 - armorElectricMult)) / 300));
									}
									double electricProcDamage = explosiveDoTBase * (1 + Main.globalElectric) * localElectricMult * totalMult * 0.5;
									if (targetCurrentShields > 0) {
										targetCurrentShields -= electricProcDamage;
									} else {
										targetCurrentHealth -= electricProcDamage;
									}
									statusEffects[2] = (int) (6 * Main.finalStatusDuration * 10000);

									// Toxin Proc
								} else if ((proc -= Main.explosiveToxinProcRate) < 0) {
									double localToxinMult = toxinMult;
									if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
										localToxinMult = ((toxinMult * armorToxinMult) / (1 + ((shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)));
									}
									double poisonDamage = explosiveDoTBase * (1 + Main.globalToxin) * typeMult * totalMult * 0.5;
									int toxinDuration = (int) (8 * Main.finalStatusDuration * 10000);
									statusStacks.add(new DoTPair(poisonDamage, toxinDuration, 10000, toxinMult, armorToxinMult, shieldToxinMult, false));
									targetCurrentHealth -= poisonDamage * localToxinMult;
									statusEffects[3] = toxinDuration;

									// Gas Proc
								} else if ((proc -= Main.explosiveGasProcRate) < 0) {
									double localGasMult = toxinMult;
									if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
										localGasMult = ((toxinMult * armorToxinMult) / (1 + ((shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * (2 - armorToxinMult)) / 300)));
									}
									double gasHeadMult = 1;
									if (headShotMult > 1) {
										gasHeadMult = 2 * Main.headShotBonus;
									}
									double cloudDamage = explosiveDoTBase * (1 + Main.globalToxin) * typeMult * totalMult * 0.5 * gasHeadMult;
									double poisonDamage = explosiveDoTBase * (1 + Main.globalToxin) * (1 + Main.globalToxin) * typeMult * typeMult * totalMult * 0.25 * gasHeadMult;
									int gasDuration = (int) (8 * Main.finalStatusDuration * 10000);
									statusStacks.add(new DoTPair(poisonDamage, gasDuration, 10000, toxinMult, armorToxinMult, shieldToxinMult, false));
									targetCurrentHealth -= ((cloudDamage + poisonDamage) * localGasMult);
									statusEffects[4] = gasDuration;

									// Magnetic Proc
								} else if ((proc -= Main.explosiveMagneticProcRate) < 0) {
									if (magneticShields == 0) {
										magneticShields = targetCurrentShields * 0.75;
										targetCurrentShields *= 0.25;
									}
									statusEffects[5] = (int) (40000 * Main.finalStatusDuration);

									// Viral Proc
								} else if ((proc -= Main.explosiveViralProcRate) < 0) {
									if (viralHealth == 0) {
										viralHealth = targetCurrentHealth *= 0.5;
									}
									statusEffects[6] = (int) (60000 * Main.finalStatusDuration);

									// Corrosive Proc
								} else if ((proc -= Main.explosiveCorrosiveProcRate) < 0) {
									targetAdjustedMaxArmor *= 0.75;
									statusEffects[7] = (int) (60000 * Main.finalStatusDuration);
								} else if ((proc -= Main.explosiveImpactProcRate) < 0) {
									statusEffects[8] = (int) (60000 * Main.finalStatusDuration);
								} else if ((proc -= Main.explosivePunctureProcRate) < 0) {
									statusEffects[9] = (int) (60000 * Main.finalStatusDuration);
								} else if ((proc -= Main.explosiveIceProcRate) < 0) {
									coldProcMult = 1.25;
									statusEffects[10] = (int) (60000 * Main.finalStatusDuration);
								} else if ((proc -= Main.explosiveBlastProcRate) < 0) {
									statusEffects[11] = (int) (60000 * Main.finalStatusDuration);
									statusEffects[12] = (int) (60000 * Main.finalStatusDuration);
								} else if ((proc -= Main.explosiveRadiationProcRate) < 0) {
									statusEffects[13] = (int) (60000 * Main.finalStatusDuration);
								}
							}

							if (Main.shatteringImpact > 0 && Main.impact.finalBase > 0) {
								shatteringImpacts += 1;
							}
						}

					}

					// Done Shooting
					iterations++;

					// Find next shot time
					shotTimer = millisceondsPerShot * (5 / millisecondMult) + 1;
					if (Main.selectedWeapon.weaponType.equals(Constants.MELEE)) {
						shotTimer = (int) (10000 * meleeHitDelay / Main.finalFireRate);
					}

					// Have we unloaded the whole mag and need to reload?
					if (iterations >= Main.finalMag) {
						iterations = 0;
						if (Main.weaponMode.equals(Constants.FULL_AUTO_RAMP_UP) || Main.weaponMode.equals(Constants.FULL_AUTO_BULLET_RAMP)) {
							millisecondMult = 1;
						}
						rampMult = -(reloadTimeMilliseconds + (millisceondsPerShot * (5 / millisecondMult)));
						if (!Main.selectedWeapon.weaponType.equals(Constants.MELEE)) {
							shotTimer += reloadTimeMilliseconds;
						}
					}
				}
			}

			// Check status stacks every 0.1 seconds
			if (timeToKill % 1000 == 0) {

				// Heat proc stuff
				if (statusEffects[1] > 0 && statusStacks.get(0).timer == 0) {
					heatProcMult = Math.max(heatProcMult - 0.1, 0.5);
				} else {
					statusStacks.get(0).damage = 0;
				}

				// DoTs
				for (int j = 0; j < statusStacks.size(); j++) {
					statusStacks.get(j).duration -= (1000 / coldProcMult);
					statusStacks.get(j).timer -= 1000;
					if (statusStacks.get(j).timer == 0 && statusStacks.get(j).duration >= 0) {
						double mult = statusStacks.get(j).healthMult;
						if (targetCurrentShields > 0.0) {
							mult = statusStacks.get(j).shieldMult;
						} else if (shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor > 0.0) {
							mult = ((statusStacks.get(j).healthMult * statusStacks.get(j).armorMult) / (1 + ((shatteringImpactMult * heatProcMult * targetAdjustedMaxArmor * (2 - statusStacks.get(j).armorMult)) / 300)));
						}
						targetCurrentHealth -= statusStacks.get(j).damage * (statusStacks.get(j).slash ? 1 : mult);
						statusStacks.get(j).timer = 10000;
					}
				}

				// Remove Expired DoTs
				Vector<DoTPair> tempStacks = (Vector<DoTPair>) statusStacks.clone();
				int p = 0;
				for (int i = 1; i < tempStacks.size(); i++) {
					if (tempStacks.get(i).duration <= 0) { // && i > 0
						statusStacks.remove(i - p);
						p++;
					}
				}

				// Others
				for (int j = 0; j < 14; j++) {
					statusEffects[j] -= (1000 / coldProcMult);
				}
				// If viral proc is expired
				if (statusEffects[6] <= 0) {
					targetCurrentHealth += viralHealth;
					viralHealth = 0;
				}
				// If Magnetic proc is expired
				if (statusEffects[5] <= 0) {
					targetCurrentShields += magneticShields;
					magneticShields = 0;
				}
				// If cold proc is expired
				if (statusEffects[10] <= 0) {
					coldProcMult = 1;
				}
			}

			// Check for Death
			if (targetCurrentHealth < 0.0) {
				return timeToKill / 10000.0;
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
		return timeToKill / 10000.0;
	}
}
