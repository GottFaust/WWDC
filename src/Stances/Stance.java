package Stances;

import java.util.Vector;

public class Stance {
	public String stanceName;
	public String weaponType;
	public Vector<Combo> combos = new Vector<Combo>();

	public Stance(String stanceStr) { // stance
		String[] split = stanceStr.split(";");
		stanceName = split[0];
		weaponType = split[1];
		for (int i = 2; i < split.length; i++) { // combos
			String[] comboSplit = split[i].split(":");
			String comboName = comboSplit[0];
			Vector<Hit> hits = new Vector<Hit>();					
			for (int j = 1; j < comboSplit.length; j++) { // hits
				String[] hitSplit = comboSplit[j].split(",");
				double delay = Double.parseDouble(hitSplit[0]);
				double multiplier = Double.parseDouble(hitSplit[1]);
				String[] procs = hitSplit[2].split("");
				double combs = Double.parseDouble(hitSplit[3]);
				hits.add(new Hit(delay, multiplier, procs, combs));
			}			
			combos.add(new Combo(comboName, hits));
		}
	}
	
	public String writeOut() {
		String stanceString = stanceName + ";";
		stanceString += weaponType + ";";
		for(Combo combo : combos) {
			stanceString += combo.comboName + ":";
			for(Hit hit : combo.hits) {
				stanceString += hit.delay + ",";
				stanceString += hit.multiplier + ",";
				for(String proc : hit.procs) {
					stanceString += proc;
				}
				stanceString += "," + hit.comboIncrease;
				stanceString += ":";
			}
			stanceString += ";";
		}		
		return stanceString;
	}

	public static class Combo {
		public String comboName;
		public Vector<Hit> hits;

		public Combo(String name, Vector<Hit> hits) {
			this.comboName = name;
			this.hits = hits;
		}
	}

	public static class Hit {
		public double delay;
		public double multiplier;
		public String[] procs;
		public double comboIncrease;

		public Hit(double delay, double muliplier, String[] procs, double comboIncrease) {
			this.delay = delay;
			this.multiplier = muliplier;
			this.procs = procs;
			this.comboIncrease = comboIncrease;
		}
	}
}