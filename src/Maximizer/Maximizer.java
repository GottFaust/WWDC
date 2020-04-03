package Maximizer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Vector;

import main.Main;
import mods.Mod;
import ttk.TTKTarget;

public class Maximizer {

	protected boolean done = false;
	protected int completedIterations;
	protected int totalIterations;
	protected int modCount;
	int emptyMods;
	protected Vector<Integer> modsToChange = new Vector<Integer>();
	protected int targets = 0;
	protected File maximizerResults;
	protected Vector<TTKresult> results = new Vector<TTKresult>();
	public double bestTTK = 9999999;

	public static Vector<Mod> simulatedMods = new Vector<Mod>();
	protected static Vector<Mod> possibleMods = new Vector<Mod>();
	public static Vector<Integer> simulatedRanks = new Vector<Integer>();

	/**
	 * Calculate and add result to an array
	 */
	public void calculateAndStore() {

		Main.calculateDPS();

		if (Double.isNaN(Main.raw.perSecond)) {
			Main.stop = true;
			return;
		}
		double currentMaxTTK = 0.0;
		Vector TTKs = new Vector<String>();
		double total = 0;
		Vector<Double> times = new Vector<Double>();

		String build1 = "[" + simulatedMods.get(0).name + "][" + simulatedMods.get(1).name + "][" + simulatedMods.get(2).name + "][" + simulatedMods.get(3).name + "]";
		String build2 = "[" + simulatedMods.get(4).name + "][" + simulatedMods.get(5).name + "][" + simulatedMods.get(6).name + "][" + simulatedMods.get(7).name + "]";
		String build3;
		try {
			build3 = "[" + simulatedMods.get(8).name + "]";
		} catch (Exception ex) {
			build3 = "[No Exilus]";
		}

		double DPS = Main.raw.perSecond;
		for (TTKTarget target : Main.groupTargets) {
			TTKs.add(target.name + " [" + target.currentLevel + "]");
			TTKs.add(target.TTK);
			total += target.TTK;
			times.add(target.TTK);
			if (target.TTK > currentMaxTTK) {
				currentMaxTTK = target.TTK;
			}
		}
		targets = Main.groupTargets.size();
		double average = total / targets;
		double minmax = Collections.max(times);
		results.add(new TTKresult(build1, build2, build3, DPS, average, minmax, TTKs));

		if (currentMaxTTK < bestTTK) {
			bestTTK = currentMaxTTK;
		}

		completedIterations++;
		Main.progressBar.setValue((completedIterations * 100) / totalIterations);
	}

	/**
	 * Test every combination of mods in empty mod slots
	 */
	public void thatThang(int modSlot) {
		if (Main.stop) {
			return;
		} else if (modSlot == 0) {
			updateRanks();
			calculateAndStore();
		} else {
			for (int i = 0; i < modCount - (emptyMods - modSlot); i++) {
				
				for (int j = modSlot; j > 0; j--) {
					simulatedMods.set(modsToChange.get(j - 1), null);
				}
				
				updateMods(modsToChange.get(modSlot - 1));
				
				try {
					simulatedMods.set(modsToChange.get(modSlot - 1), possibleMods.get(i));
					thatThang(modSlot - 1);
				} catch (Exception ex) {
					break;
				}
				
			}
		}
	}

	public void updateMods(int slot) {
		possibleMods = new Vector<Mod>();
		for (Mod mod : Main.selectedWeapon.modInit.mods) {
			if (!simulatedMods.contains(mod)) {
				if (mod.type.equals(Main.selectedWeapon.weaponType)) {
					if (mod.weaponLock.equals(Main.selectedWeapon.weaponName) || mod.weaponLock.equals("None")) {
						if (slot != 8) {
							possibleMods.add(mod);
						} else if (mod.exilus) {
							possibleMods.add(mod);
						}
					}
				}
			}
		}
	}

	public void updateRanks() {
		simulatedRanks = new Vector<Integer>();
		for (Mod mod : simulatedMods) {
			simulatedRanks.add(mod.ranks);
		}
	}

	public void Maximize() {
		DecimalFormat f = new DecimalFormat("#.###");
		emptyMods = 0;
		Main.stop = false;
		completedIterations = 0;
		bestTTK = Double.POSITIVE_INFINITY;
		results.clear();
		modsToChange.clear();
		simulatedMods.clear();
		simulatedRanks.clear();

		// Identify empty mod slots and count them
		for (int i = 0; i < 8; i++) {
			if (Main.selectedWeapon.selectedMods.get(i).equals("--")) {
				emptyMods++;
				modsToChange.add(i);
			}
		}

		/*
		 * modCount = Main.selectedWeapon.countMods() - 1; totalIterations = 1; for (int
		 * g = modCount; g > (modCount - emptyMods); g--) { totalIterations *= g; }
		 */

		// Initial mod list
		simulatedMods.add(Main.selectedWeapon.getModByName(Main.selectedWeapon.modOnePanel.getSelectedMod()));
		simulatedMods.add(Main.selectedWeapon.getModByName(Main.selectedWeapon.modTwoPanel.getSelectedMod()));
		simulatedMods.add(Main.selectedWeapon.getModByName(Main.selectedWeapon.modThreePanel.getSelectedMod()));
		simulatedMods.add(Main.selectedWeapon.getModByName(Main.selectedWeapon.modFourPanel.getSelectedMod()));
		simulatedMods.add(Main.selectedWeapon.getModByName(Main.selectedWeapon.modFivePanel.getSelectedMod()));
		simulatedMods.add(Main.selectedWeapon.getModByName(Main.selectedWeapon.modSixPanel.getSelectedMod()));
		simulatedMods.add(Main.selectedWeapon.getModByName(Main.selectedWeapon.modSevenPanel.getSelectedMod()));
		simulatedMods.add(Main.selectedWeapon.getModByName(Main.selectedWeapon.modEightPanel.getSelectedMod()));
		simulatedMods.add(Main.selectedWeapon.getModByName(Main.selectedWeapon.modNinePanel.getSelectedMod()));

		updateMods(100);
		modCount = possibleMods.size();
		int hasExilus = 0;
		
		totalIterations = 1;		
		if (Main.selectedWeapon.selectedMods.get(8).equals("--") && Main.selectedWeapon.showExilus.isSelected()) {
			updateMods(8);
			if(possibleMods.size() > 0) {
				modsToChange.add(8);
				totalIterations *= possibleMods.size();
				hasExilus = 1;
				emptyMods++;
			} else {
				simulatedMods.remove(8);
			}
		}

		for (int g = modCount - hasExilus; g > ((modCount - hasExilus) - (emptyMods- hasExilus)); g--) {
			totalIterations *= g;
		}

		// Do
		thatThang(emptyMods);

		if (Main.stop == true) {
			Main.output.append("Maximizer stopped\n");
			return;
		}

		// For each target: find its fastest kill time, DPS, etc

		if (!Main.smartMax.isSelected()) { // These results will be incorrect if smartmax is enabled.

			// Find fasted kill time for each target
			for (int k = 0; k < targets; k++) {
				for (int p = results.size() - 1; p > 0; p--) {
					if (results.get(p).TTKs.get(1 + 2 * k) < results.get(p - 1).TTKs.get(1 + 2 * k)) {
						Collections.swap(results, p, p - 1);
					}
				}
				Main.output.append("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + "\n");
				Main.output.append("Build with the fasted kill time on " + results.get(0).TTKs.get(2 * k) + "\n");
				Main.output.append(results.get(0).build1 + "\n");
				Main.output.append(results.get(0).build2 + "\n");
				Main.output.append(results.get(0).build3 + "\n");
				Main.output.append("DPS: " + f.format(results.get(0).DPS) + "\n");
				Main.output.append("Time: " + f.format(results.get(0).TTKs.get(1 + 2 * k)) + " seconds" + "\n");
			}

			// Find build with highest DPS
			for (int p = results.size() - 1; p > 0; p--) {
				if (results.get(p).DPS > results.get(p - 1).DPS) {
					Collections.swap(results, p, p - 1);
				}
			}
			Main.output.append("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + "\n");
			Main.output.append("Build with the highest DPS" + "\n");
			Main.output.append(results.get(0).build1 + "\n");
			Main.output.append(results.get(0).build2 + "\n");
			Main.output.append(results.get(0).build3 + "\n");
			Main.output.append("DPS: " + f.format(results.get(0).DPS) + "\n");

			// Find build with lowest average kill time
			for (int p = results.size() - 1; p > 0; p--) {
				if (results.get(p).average < results.get(p - 1).average) {
					Collections.swap(results, p, p - 1);
				}
			}
			Main.output.append("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + "\n");
			Main.output.append("Build with the Lowest average kill time on selected targets" + "\n");
			Main.output.append(results.get(0).build1 + "\n");
			Main.output.append(results.get(0).build2 + "\n");
			Main.output.append(results.get(0).build3 + "\n");
			Main.output.append("Average time to kill: " + f.format(results.get(0).average) + "\n");
			Main.output.append("--------------------------Individual TTKs----------------------------" + "\n");
			for (int k = 0; k < targets; k++) {
				Main.output.append(results.get(0).TTKs.get(2 * k) + ": " + f.format(results.get(0).TTKs.get(1 + 2 * k)) + " seconds" + "\n");
			}
		}

		// Find build with the lowest maximum kill time
		for (int p = results.size() - 1; p > 0; p--) {
			if (results.get(p).minmax < results.get(p - 1).minmax) {
				Collections.swap(results, p, p - 1);
			}
		}
		Main.output.append("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + "\n");
		Main.output.append("Build with the Lowest maximum kill time on selected targets:" + "\n");
		Main.output.append(results.get(0).build1 + "\n");
		Main.output.append(results.get(0).build2 + "\n");
		Main.output.append(results.get(0).build3 + "\n");
		Main.output.append("Maximum kill time: " + f.format(results.get(0).minmax) + "\n");
		Main.output.append("--------------------------Individual TTKs----------------------------" + "\n");
		for (int k = 0; k < targets; k++) {
			Main.output.append(results.get(0).TTKs.get(2 * k) + ": " + f.format(results.get(0).TTKs.get(1 + 2 * k)) + " seconds" + "\n");
		}

		Main.output.append("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + "\n");

		// Make CSV File
		if (!Main.smartMax.isSelected()) {
			maximizerResults = new File("MaximizerResults.csv");
			try {
				if (!maximizerResults.exists()) {
					maximizerResults.createNewFile();
				}
				BufferedWriter writer = new BufferedWriter(new FileWriter(maximizerResults));
				// Create column titles
				String Spacing = "";
				for (int i = 0; i < targets * 2; i++) {
					Spacing += ",";
				}
				String columnTitles = "Build,DPS,TTKs" + Spacing + "Average TTK" + "," + "Maximum TTK";
				writer.write(columnTitles + "\n");
				// Fill Rows
				for (int i = 0; i < results.size(); i++) {
					String lineToWrite = results.get(i).build1 + results.get(i).build2 + "," + results.get(i).DPS + "," + results.get(i).TTKs + "," + results.get(i).average + "," + results.get(i).minmax;
					writer.write(lineToWrite + "\n");
				}
				writer.flush();
				writer.close();
				Main.output.append("Full results stored in MaximizerResults.csv in the install folder\n");
			} catch (Exception e) {
				Main.output.append("Could not create MaximizerResults.csv\n");
			}
		}
	}

	class TTKresult {
		public String build1 = "";
		public String build2 = "";
		public String build3 = "";
		public double DPS = 0;
		public Vector<Double> TTKs;
		public double average = 0;
		public double minmax = 0;

		public TTKresult(String build1, String build2, String build3, double DPS, double average, double minmax, Vector TTKs) {
			this.build1 = build1;
			this.build2 = build2;
			this.build3 = build3;
			this.DPS = DPS;
			this.TTKs = TTKs;
			this.average = average;
			this.minmax = minmax;
		}
	}
}
