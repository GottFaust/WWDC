package Maximizer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Vector;

import main.Main;
import ttk.TTKTarget;
import java.io.BufferedReader;
import java.io.FileReader;

public class Maximizer {

	protected int modCount;
	protected Vector<Integer> modsToChange = new Vector<Integer>();
	protected int targets = 0;
	protected File maximizerResults;
	protected Vector<TTKresult> results = new Vector<TTKresult>();

	/**
	 * Calculate and add result to an array
	 */
	public void calculateAndStore() {

		Main.calculateDPS();

		Vector TTKs = new Vector<String>();
		double total = 0;
		Vector<Double> times = new Vector<Double>();

		String build1 = Main.selectedWeapon.flatModsOutput().split(",")[0];
		String build2 = Main.selectedWeapon.flatModsOutput().split(",")[1];
		double DPS = Main.raw.perSecond;
		Vector<TTKTarget> groupTargets = new Vector<TTKTarget>();
		for (TTKTarget target : Main.theTTKManager.targets) {
			if (target.group == Integer.parseInt((String) Main.targetGroupBox.getSelectedItem())) {
				groupTargets.add(target);
			}
		}
		for (TTKTarget target : groupTargets) {
			TTKs.add(target.simpleTTK().split(",")[0]); // name
			TTKs.add(target.simpleTTK().split(",")[1]); // time
			total += Double.parseDouble(target.simpleTTK().split(",")[1]);
			times.add(Double.parseDouble(target.simpleTTK().split(",")[1]));
		}
		targets = groupTargets.size();
		double average = total / targets;
		double minmax = Collections.max(times);
		results.add(new TTKresult(build1, build2, DPS, average, minmax, TTKs));
	}

	/**
	 * Test every combination of mods in empty mod slots
	 */
	public void thatThang(int modSlot) {
		if (modSlot == 0) {
			calculateAndStore();
		} else {
			for (int i = 1; i < modCount; i++) {
				Main.selectedWeapon.setMod(modsToChange.get(modSlot - 1), i);
				thatThang(modSlot - 1);
			}
		}
	}

	public void Maximizer() {
		int emptyMods = 0;
		modsToChange.clear();
		results.clear();
		
		// Identify empty mod slots and count them	
		for(int i = 0; i < 8; i++) {
			if(Main.selectedWeapon.selectedMods.get(i).equals("--")) {
				emptyMods++;
				modsToChange.add(i);
			}
		}
		modCount = Main.selectedWeapon.countMods() - (emptyMods - 1);

		// Do
		thatThang(emptyMods);

		// For each target: find its fastest kill time, DPS, etc
		// Find fasted kill time for each target
		for (int k = 0; k < targets; k++) {
			for (int p = results.size() - 1; p > 0; p--) {
				if (Double.parseDouble(results.get(p).TTKs.get(1 + 2 * k)) < Double.parseDouble(results.get(p - 1).TTKs.get(1 + 2 * k))) {
					Collections.swap(results, p, p - 1);
				}
			}
			Main.output.append("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + "\n");
			Main.output.append("Build with the fasted kill time on " + results.get(0).TTKs.get(2 * k) + "\n");
			Main.output.append(results.get(0).build1 + "\n");
			Main.output.append(results.get(0).build2 + "\n");
			Main.output.append("DPS: " + results.get(0).DPS + "\n");
			Main.output.append("Time: " + results.get(0).TTKs.get(1 + 2 * k) + " seconds" + "\n");
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
		Main.output.append("DPS: " + results.get(0).DPS + "\n");

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
		Main.output.append("Average time to kill: " + results.get(0).average + "\n");
		Main.output.append("--------------------------Individual TTKs----------------------------" + "\n");
		for (int k = 0; k < targets; k++) {
			Main.output.append(results.get(0).TTKs.get(2 * k) + ": " + results.get(0).TTKs.get(1 + 2 * k) + " seconds" + "\n");
		}

		// Find build with the lowest maximum kill time
		for (int p = results.size() - 1; p > 0; p--) {
			if (results.get(p).minmax < results.get(p - 1).minmax) {
				Collections.swap(results, p, p - 1);
			}
		}
		Main.output.append("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + "\n");
		Main.output.append("Build with the Lowest maximum kill time on selected targets" + "\n");
		Main.output.append(results.get(0).build1 + "\n");
		Main.output.append(results.get(0).build2 + "\n");
		Main.output.append("Maximum kill time: " + results.get(0).minmax + "\n");
		Main.output.append("--------------------------Individual TTKs----------------------------" + "\n");
		for (int k = 0; k < targets; k++) {
			Main.output.append(results.get(0).TTKs.get(2 * k) + ": " + results.get(0).TTKs.get(1 + 2 * k) + " seconds" + "\n");
		}

		Main.output.append("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + "\n");
		Main.output.append("Want to see the raw data? Look at MaximizerResults.csv in the install folder" + "\n");

		// Make CSV File
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Clean things out
		for (int i = 0; i < emptyMods; i++) {
			Main.selectedWeapon.setMod(modsToChange.get(i), 0);
		}
		System.gc();
	}

	public static class TTKresult {
		public String build1 = "";
		public String build2 = "";
		public double DPS = 0;
		public Vector<String> TTKs;
		public double average = 0;
		public double minmax = 0;

		public TTKresult(String build1, String build2, double DPS, double average, double minmax, Vector TTKs) {
			this.build1 = build1;
			this.build2 = build2;
			this.DPS = DPS;
			this.TTKs = TTKs;
			this.average = average;
			this.minmax = minmax;
		}
	}

}
