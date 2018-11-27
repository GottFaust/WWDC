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

	protected boolean touchModOne;
	protected boolean touchModTwo;
	protected boolean touchModThree;
	protected boolean touchModFour;
	protected boolean touchModFive;
	protected boolean touchModSix;
	protected boolean touchModSeven;
	protected boolean touchModEight;

	protected int q;
	protected int w;
	protected int e;
	protected int r;
	protected int t;
	protected int y;
	protected int u;
	protected int i;
	
	protected int count;

	public static int targets = 0;

	public static File maximizerResults;
	

	public void Maximizer() {

		maximizerResults = new File("MaximizerResults.csv");

		modCount = Main.selectedWeapon.countMods();

		int emptyMods = 0;

		touchModOne = false;
		touchModTwo = false;
		touchModThree = false;
		touchModFour = false;
		touchModFive = false;
		touchModSix = false;
		touchModSeven = false;
		touchModEight = false;

		q = modCount;
		w = modCount;
		e = modCount;
		r = modCount;
		t = modCount;
		y = modCount;
		u = modCount;
		i = modCount;
		
		count = 0;

		if (Main.selectedWeapon.modOne.equals("--")) {
			q = 1;
			touchModOne = true;
			emptyMods++;
		}
		if (Main.selectedWeapon.modTwo.equals("--")) {
			w = 1;
			touchModTwo = true;
			emptyMods++;
		}
		if (Main.selectedWeapon.modThree.equals("--")) {
			e = 1;
			touchModThree = true;
			emptyMods++;
		}
		if (Main.selectedWeapon.modFour.equals("--")) {
			r = 1;
			touchModFour = true;
			emptyMods++;
		}
		if (Main.selectedWeapon.modFive.equals("--")) {
			t = 1;
			touchModFive = true;
			emptyMods++;
		}
		if (Main.selectedWeapon.modSix.equals("--")) {
			y = 1;
			touchModSix = true;
			emptyMods++;
		}
		if (Main.selectedWeapon.modSeven.equals("--")) {
			u = 1;
			touchModSeven = true;
			emptyMods++;
		}
		if (Main.selectedWeapon.modEight.equals("--")) {
			i = 1;
			touchModEight = true;
			emptyMods++;
		}

		q -= emptyMods;
		w -= emptyMods;
		e -= emptyMods;
		r -= emptyMods;
		t -= emptyMods;
		y -= emptyMods;
		u -= emptyMods;
		i -= emptyMods;

		q = Math.max(1, q);
		w = Math.max(1, w);
		e = Math.max(1, e);
		r = Math.max(1, r);
		t = Math.max(1, t);
		y = Math.max(1, y);
		u = Math.max(1, u);
		i = Math.max(1, i);

		modCount -= (emptyMods - 1);
		
		try {
			if (!maximizerResults.exists()) {
				maximizerResults.createNewFile();
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(maximizerResults));
			for (int a = q; a < modCount; a++) {
				if (touchModOne)
					Main.selectedWeapon.setModOne(a);

				for (int s = w; s < modCount; s++) {
					if (touchModTwo)
						Main.selectedWeapon.setModTwo(s);

					for (int d = e; d < modCount; d++) {
						if (touchModThree)
							Main.selectedWeapon.setModThree(d);

						for (int f = r; f < modCount; f++) {
							if (touchModFour)
								Main.selectedWeapon.setModFour(f);

							for (int g = t; g < modCount; g++) {
								if (touchModFive)
									Main.selectedWeapon.setModFive(g);

								for (int h = y; h < modCount; h++) {
									if (touchModSix)
										Main.selectedWeapon.setModSix(h);

									for (int j = u; j < modCount; j++) {
										if (touchModSeven)
											Main.selectedWeapon.setModSeven(j);

										for (int k = i; k < modCount; k++) {
											if (touchModEight) {
												Main.selectedWeapon.setModEight(k);
											}
											//Main.selectedWeapon.maxMods();
											Main.calculateDPS();

											// Store results in a csv file
											String result = Main.selectedWeapon.flatModsOutput() + "," + Main.raw.perSecond;
											String TTKresult = "";
											int targetGroup = Integer.parseInt((String) Main.targetGroupBox.getSelectedItem());
											Vector<TTKTarget> groupTargets = new Vector<TTKTarget>();
											for (TTKTarget target : Main.theTTKManager.targets) {
												if (target.group == targetGroup) {
													groupTargets.add(target);
												}
											}
											for (TTKTarget target : groupTargets) {
												TTKresult += "," + target.simpleTTK();
											}
											targets = groupTargets.size();
											writer.write(result + TTKresult + "\n");											
											
											count++;
											if(count == 200) {
												System.gc(); //Why java won't do this on its own, I don't know	
												count = 0;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		// for each target: find its fastest kill time, DPS, etc
		System.gc();
		BufferedReader br = null;
		String line = "";
		String build1 = "";
		String build2 = "";
		double DPS = 0;
		Vector TTKs = null;
		Vector<TTKresult> results = new Vector<TTKresult>();
		double total = 0;
		Vector<Double> times = new Vector<Double>();
		double average = 0;
		double minmax = 0;

		// Read results from the csv
		try {
			br = new BufferedReader(new FileReader(maximizerResults));
			while ((line = br.readLine()) != null) {
				String[] result = line.split(",");
				build1 = result[0];
				build2 = result[1];
				DPS = Double.parseDouble(result[2]);
				TTKs = new Vector<String>();
				total = 0;
				times.removeAllElements();
				for (int l = 0; l < targets; l++) {
					TTKs.add(result[3 + 2 * l]); // name
					TTKs.add(result[4 + 2 * l]); // time
					total += Double.parseDouble(result[4 + 2 * l]);
					times.add(Double.parseDouble(result[4 + 2 * l]));
				}
				average = total / targets;
				minmax = Collections.max(times);
				results.add(new TTKresult(build1, build2, DPS, average, minmax, TTKs));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

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

		// Clean out the mods
		if (touchModOne)
			Main.selectedWeapon.setModOne(0);
		if (touchModTwo)
			Main.selectedWeapon.setModTwo(0);
		if (touchModThree)
			Main.selectedWeapon.setModThree(0);
		if (touchModFour)
			Main.selectedWeapon.setModFour(0);
		if (touchModFive)
			Main.selectedWeapon.setModFive(0);
		if (touchModSix)
			Main.selectedWeapon.setModSix(0);
		if (touchModSeven)
			Main.selectedWeapon.setModSeven(0);
		if (touchModEight)
			Main.selectedWeapon.setModEight(0);
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
