package ttk;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import etc.Constants;
import etc.UIBuilder;
import main.Main;

public class TTKManagerPanel extends JPanel implements ActionListener, ListSelectionListener {

	/**
	 * ____________________________________________________________ CLASS VARIABLES
	 * ____________________________________________________________
	 */
	/** Panels **/
	protected JPanel leftPanel = new JPanel();
	protected JPanel rightPanel = new JPanel();
	protected JPanel namePanel = new JPanel();
	protected JPanel baseLevelPanel = new JPanel();
	protected JPanel currentLevelPanel = new JPanel();
	protected JPanel baseArmorPanel = new JPanel();
	protected JPanel baseHealthPanel = new JPanel();
	protected JPanel baseShieldsPanel = new JPanel();
	protected JPanel factionTypePanel = new JPanel();
	public JPanel targetGroupPanel = new JPanel();
	protected JPanel buttonPanel = new JPanel();

	/** Text Fields **/
	protected JTextField nameField = new JTextField(10);
	protected JTextField baseLevelField = new JTextField(10);
	protected JTextField currentLevelField = new JTextField(10);
	protected JTextField baseArmorField = new JTextField(10);
	protected JTextField baseHealthField = new JTextField(10);
	protected JTextField baseShieldsField = new JTextField(10);

	/** Labels **/
	protected JLabel nameLabel = new JLabel("Name - ");
	protected JLabel baseLevelLabel = new JLabel("Base Level - ");
	protected JLabel currentLevelLabel = new JLabel("Current Level - ");
	protected JLabel baseArmorLabel = new JLabel("Base Armor - ");
	protected JLabel baseHealthLabel = new JLabel("Base Health - ");
	protected JLabel baseShieldsLabel = new JLabel("Base Shields - ");
	protected JLabel factionTypeLabel = new JLabel("Facton Type - ");
	protected JLabel targetGroupLabel = new JLabel("Target Groups - ");

	/** Combo Boxes **/
	protected JComboBox<String> surfaceTypeBox = new JComboBox<String>();
	protected JComboBox<String> armorTypeBox = new JComboBox<String>();
	protected JComboBox<String> shieldTypeBox = new JComboBox<String>();
	protected JComboBox<String> factionTypeBox = new JComboBox<String>();
	// protected JComboBox<String> targetGroupBox = new JComboBox<String>();

	/** Buttons **/
	protected JButton addUpdateButton = new JButton("Add or Update");
	public JButton deleteButton = new JButton("Delete");
	public JButton saveButton = new JButton("Save");

	/** List Variables **/
	protected DefaultListModel targetListModel = new DefaultListModel();
	protected JList targetList = new JList(targetListModel);
	protected JScrollPane targetScroll = new JScrollPane(targetList);

	// Groups list
	protected DefaultListModel targetGroupsModel = new DefaultListModel();
	protected JList targetGroups = new JList(targetGroupsModel);

	/** Stored Values **/
	protected File ttkDB;
	protected TTKTarget selectedTarget;
	public static Vector<TTKTarget> targets = new Vector<TTKTarget>();
	protected Vector<String> surfaceTypes = new Vector<String>();
	protected Vector<String> armorTypes = new Vector<String>();
	protected Vector<String> shieldTypes = new Vector<String>();
	protected Vector<String> factionTypes = new Vector<String>();

	/**
	 * CTOR
	 */
	public TTKManagerPanel() {
		init();
		buildUI();
	}

	/**
	 * Builds the UI
	 */
	public void buildUI() {

		UIBuilder.panelInit(this);
		UIBuilder.panelInit(leftPanel);
		UIBuilder.panelInit(rightPanel);
		UIBuilder.panelInit(namePanel);
		UIBuilder.panelInit(baseLevelPanel);
		UIBuilder.panelInit(currentLevelPanel);
		UIBuilder.panelInit(baseArmorPanel);
		UIBuilder.panelInit(baseHealthPanel);
		UIBuilder.panelInit(baseShieldsPanel);
		UIBuilder.panelInit(factionTypePanel);
		UIBuilder.panelInit(targetGroupPanel);
		UIBuilder.panelInit(buttonPanel);

		UIBuilder.labelInit(nameLabel);
		UIBuilder.labelInit(baseLevelLabel);
		UIBuilder.labelInit(currentLevelLabel);
		UIBuilder.labelInit(baseArmorLabel);
		UIBuilder.labelInit(baseHealthLabel);
		UIBuilder.labelInit(baseShieldsLabel);
		UIBuilder.labelInit(factionTypeLabel);
		UIBuilder.labelInit(targetGroupLabel);

		UIBuilder.listInit(targetList);
		UIBuilder.listInit(targetGroups);

		UIBuilder.scrollPaneInit(targetScroll);

		UIBuilder.comboBoxInit(surfaceTypeBox);
		UIBuilder.comboBoxInit(factionTypeBox);
		UIBuilder.comboBoxInit(armorTypeBox);
		UIBuilder.comboBoxInit(shieldTypeBox);
		// UIBuilder.comboBoxInit(targetGroupBox);

		UIBuilder.textFieldInit(nameField);
		UIBuilder.numberFieldInit(baseLevelField);
		UIBuilder.numberFieldInit(currentLevelField);
		UIBuilder.numberFieldInit(baseArmorField);
		UIBuilder.numberFieldInit(baseHealthField);
		UIBuilder.numberFieldInit(baseShieldsField);

		UIBuilder.buttonInit(addUpdateButton);
		UIBuilder.buttonInit(deleteButton);
		UIBuilder.buttonInit(saveButton);

		surfaceTypeBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
		armorTypeBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
		shieldTypeBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
		factionTypeBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
		// targetGroupBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");

		leftPanel.setLayout(new GridLayout(1, 2, 0, 0));
		rightPanel.setLayout(new GridLayout(9, 1, 0, 0));
		namePanel.setLayout(new GridLayout(1, 2, 0, 0));
		baseLevelPanel.setLayout(new GridLayout(1, 2, 0, 0));
		currentLevelPanel.setLayout(new GridLayout(1, 2, 0, 0));
		baseArmorPanel.setLayout(new GridLayout(1, 2, 0, 0));
		baseHealthPanel.setLayout(new GridLayout(1, 2, 0, 0));
		baseShieldsPanel.setLayout(new GridLayout(1, 2, 0, 0));
		factionTypePanel.setLayout(new GridLayout(1, 2, 0, 0));
		targetGroupPanel.setLayout(new GridLayout(1, 2, 0, 0));
		buttonPanel.setLayout(new GridLayout(1, 3, 0, 0));
		//rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));


		targetList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		targetList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		targetList.setVisibleRowCount(-1);
		targetScroll.setPreferredSize(new Dimension(150, 250));

		targetGroups.setSelectionModel(new DefaultListSelectionModel() {
			@Override
			public void setSelectionInterval(int index0, int index1) {
				if (super.isSelectedIndex(index0)) {
					super.removeSelectionInterval(index0, index1);
				} else {
					super.addSelectionInterval(index0, index1);
				}
			}
		});
		targetGroups.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		targetGroups.setVisibleRowCount(-1);
		targetGroups.setPreferredSize(new Dimension(0, 17));
		targetGroups.setFixedCellWidth(15);

		leftPanel.add(targetScroll);

		namePanel.add(nameLabel);
		namePanel.add(nameField);

		baseLevelPanel.add(baseLevelLabel);
		baseLevelPanel.add(baseLevelField);

		currentLevelPanel.add(currentLevelLabel);
		currentLevelPanel.add(currentLevelField);
		
		//baseArmorPanel.add(baseArmorLabel);
		baseArmorPanel.add(armorTypeBox);
		baseArmorPanel.add(baseArmorField);

		//baseHealthPanel.add(baseHealthLabel);
		baseHealthPanel.add(surfaceTypeBox);
		baseHealthPanel.add(baseHealthField);

		//baseShieldsPanel.add(baseShieldsLabel);
		baseShieldsPanel.add(shieldTypeBox);
		baseShieldsPanel.add(baseShieldsField);

		factionTypePanel.add(factionTypeLabel);
		factionTypePanel.add(factionTypeBox);

		targetGroupPanel.add(targetGroupLabel);
		// targetGroupPanel.add(targetGroupBox);
		targetGroupPanel.add(targetGroups);

		buttonPanel.add(addUpdateButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(saveButton);

		rightPanel.add(namePanel);
		rightPanel.add(baseLevelPanel);
		rightPanel.add(currentLevelPanel);
		rightPanel.add(baseHealthPanel);
		rightPanel.add(baseArmorPanel);
		rightPanel.add(baseShieldsPanel);
		rightPanel.add(factionTypePanel);
		rightPanel.add(targetGroupPanel);
		rightPanel.add(buttonPanel);

		this.add(leftPanel);
		this.add(rightPanel);

		addUpdateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		saveButton.addActionListener(this);

		targetList.getSelectionModel().addListSelectionListener(this);

		clearValues();
	}

	/**
	 * Initializes the targets DB and dropdowns
	 */
	public void init() {
		ttkDB = new File("ttkTargets.db");
		try {
			if (ttkDB.exists()) {
				targets.clear();
				BufferedReader reader = new BufferedReader(new FileReader(ttkDB));
				String line = reader.readLine();
				while (line != null) {
					TTKTarget target = new TTKTarget(line);
					targets.add(target);
					line = reader.readLine();
				}
				reader.close();
			} else {
				targets.clear();
				ttkDB.createNewFile();
				BufferedWriter writer = new BufferedWriter(new FileWriter(ttkDB));
				for (String targetStr : Constants.baseTTKTargets) {
					writer.write(targetStr + "\n");
					TTKTarget target = new TTKTarget(targetStr);
					targets.add(target);
				}
				writer.close();
			}
			updateTargetList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		surfaceTypes.clear();
		surfaceTypes.add(Constants.ENEMY_SURFACE_CLONE_FLESH);
		surfaceTypes.add(Constants.ENEMY_SURFACE_MECHANICAL);
		surfaceTypes.add(Constants.ENEMY_SURFACE_CORPUS_FLESH);
		surfaceTypes.add(Constants.ENEMY_SURFACE_INFESTED_FLESH);
		surfaceTypes.add(Constants.ENEMY_SURFACE_FOSSILIZED);
		surfaceTypes.add(Constants.ENEMY_SURFACE_SINEW);
		surfaceTypes.add(Constants.ENEMY_SURFACE_ROBOTIC);
		surfaceTypes.add(Constants.ENEMY_SURFACE_INFESTED);
		Collections.sort(surfaceTypes);

		armorTypes.clear();
		armorTypes.add(Constants.ENEMY_SURFACE_FERRITE_ARMOR);
		armorTypes.add(Constants.ENEMY_SURFACE_ALLOY_ARMOR);
		Collections.sort(armorTypes);

		shieldTypes.clear();
		shieldTypes.add(Constants.ENEMY_SURFACE_PROTO_SHIELD);
		shieldTypes.add(Constants.ENEMY_SURFACE_SHIELDS);
		Collections.sort(shieldTypes);

		surfaceTypeBox.removeAllItems();
		for (int i = 0; i < surfaceTypes.size(); i++) {
			surfaceTypeBox.addItem(surfaceTypes.get(i));
		}

		armorTypeBox.removeAllItems();
		for (int i = 0; i < armorTypes.size(); i++) {
			armorTypeBox.addItem(armorTypes.get(i));
		}

		shieldTypeBox.removeAllItems();
		for (int i = 0; i < shieldTypes.size(); i++) {
			shieldTypeBox.addItem(shieldTypes.get(i));
		}

		factionTypes.clear();
		factionTypes.add(Constants.ENEMY_TYPE_INFESTED);
		factionTypes.add(Constants.ENEMY_TYPE_CORPUS);
		factionTypes.add(Constants.ENEMY_TYPE_GRINEER);
		factionTypes.add(Constants.ENEMY_TYPE_CORRUPTED);
		Collections.sort(factionTypes);

		factionTypeBox.removeAllItems();
		for (int i = 0; i < factionTypes.size(); i++) {
			factionTypeBox.addItem(factionTypes.get(i));
		}

		for (int i = 0; i < 10; i++) {
			targetGroupsModel.addElement("" + i);
		}
	}

	/**
	 * List selection callback
	 */
	public void valueChanged(ListSelectionEvent e) {
		try {
			String targetName = (String) targetListModel.get(targetList.getSelectedIndex());
			selectedTarget = getTargetByName(targetName);
			updateSelectedValues();
		} catch (Exception ex) {
			clearValues();
		}
	}

	/**
	 * Resets the target values
	 */
	public void clearValues() {
		nameField.setText("Unnamed Target");
		baseLevelField.setText("0");
		currentLevelField.setText("0");
		baseArmorField.setText("0");
		baseHealthField.setText("0");
		baseShieldsField.setText("0");
		surfaceTypeBox.setSelectedIndex(0);
		factionTypeBox.setSelectedIndex(0);
		armorTypeBox.setSelectedIndex(0);
		shieldTypeBox.setSelectedIndex(0);
	}

	/**
	 * Updates the values on the right side to those of the target selected on the
	 * left side
	 */
	public void updateSelectedValues() {

		// Clear the previous values
		clearValues();

		// Update the boxes
		nameField.setText(selectedTarget.name);
		baseLevelField.setText("" + selectedTarget.baseLevel);
		currentLevelField.setText("" + selectedTarget.currentLevel);
		baseArmorField.setText("" + selectedTarget.baseArmor);
		baseHealthField.setText("" + selectedTarget.baseHealth);
		baseShieldsField.setText("" + selectedTarget.baseShields);
		surfaceTypeBox.setSelectedItem(selectedTarget.surfaceType);
		factionTypeBox.setSelectedItem(selectedTarget.factionType);
		armorTypeBox.setSelectedItem(selectedTarget.armorType);
		shieldTypeBox.setSelectedItem(selectedTarget.shieldType);
		// targetGroupBox.setSelectedItem(""+selectedTarget.groups);
		
		int[] grou = new int[selectedTarget.groups.size()];
		for(int i = 0 ; i < grou.length ; i++) {
			grou[i] = selectedTarget.groups.get(i);
		}	
		targetGroups.setSelectedIndices(grou);
	}

	/**
	 * Gets the target with the supplied name
	 * 
	 * @param name
	 * @return target
	 */
	public TTKTarget getTargetByName(String name) {
		TTKTarget localTarget = null;
		for (int i = 0; i < targets.size(); i++) {
			if (targets.get(i).name.equals(name)) {
				localTarget = targets.get(i);
			}
		}
		return localTarget;
	}

	/**
	 * Builds a target string from the currently selected target
	 * 
	 * @return target string
	 */
	public String getCurrentTargetString() {

		String targetName = nameField.getText();
		String targetBaseLevel = baseLevelField.getText();
		String targetCurrentLevel = currentLevelField.getText();
		String targetBaseArmor = baseArmorField.getText();
		String targetBaseHealth = baseHealthField.getText();
		String targetBaseShields = baseShieldsField.getText();
		String targetSurfaceType = (String) surfaceTypeBox.getSelectedItem();
		String targetArmorType = (String) armorTypeBox.getSelectedItem();
		String targetShieldType = (String) shieldTypeBox.getSelectedItem();
		String targetFactionType = (String) factionTypeBox.getSelectedItem();

		String targetGroup = "";

		for (int gru : targetGroups.getSelectedIndices()) {
			targetGroup += gru + ";";
		}
		if (Main.quickGroup == true) {
			targetGroup += (String) Main.targetGroupBox.getSelectedItem() + ";";
		}

		if (targetName.equals("")) {
			targetName = "Unnamed Target";
		}
		try {
			int testInt = Integer.parseInt(targetBaseLevel);
		} catch (Exception ex) {
			targetBaseLevel = "0";
		}
		try {
			int testInt = Integer.parseInt(targetCurrentLevel);
		} catch (Exception ex) {
			targetCurrentLevel = "0";
		}
		try {
			int testInt = Integer.parseInt(targetBaseHealth);
		} catch (Exception ex) {
			targetBaseHealth = "0";
		}
		try {
			int testInt = Integer.parseInt(targetBaseShields);
		} catch (Exception ex) {
			targetBaseShields = "0";
		}
		try {
			int testInt = Integer.parseInt(targetBaseArmor);
		} catch (Exception ex) {
			targetBaseArmor = "0";
		}

		return targetName + "," + targetBaseLevel + "," + targetCurrentLevel + "," + targetBaseArmor + "," + targetBaseHealth + "," + targetBaseShields + "," + targetSurfaceType + "," + targetArmorType + "," + targetShieldType + "," + targetFactionType + "," + targetGroup;
	}

	/**
	 * ActionListener callback
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addUpdateButton)) {

			String newTargetString = getCurrentTargetString();
			TTKTarget newTarget = new TTKTarget(newTargetString);

			// Check to see if it already exists
			TTKTarget foundTarget = getTargetByName(newTarget.name);

			// if it exists: update it. Otherwise: add it.
			if (foundTarget != null) {
				targets.set(targets.indexOf(foundTarget), newTarget);
			} else {
				targets.add(newTarget);
			}

			updateTargetList();
			Main.updateTargetList();

		} else if (e.getSource().equals(deleteButton)) {

			if (targets.contains(selectedTarget)) {
				targets.removeElement(selectedTarget);
			}
			updateTargetList();
			Main.updateTargetList();

		} else if (e.getSource().equals(saveButton)) {

			saveTargetDB();

		}
	}

	/**
	 * Updates the target list from the tarets vector
	 */
	public void updateTargetList() {
		Collections.sort(targets);
		targetListModel.clear();
		for (int i = 0; i < targets.size(); i++) {
			targetListModel.addElement(targets.get(i).name);
		}
	}

	/**
	 * Saves the current targets vector to the targets database file
	 */
	public void saveTargetDB() {
		try {
			if (ttkDB.exists()) {
				ttkDB.delete();
			}
			ttkDB.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(ttkDB));
			for (TTKTarget target : targets) {
				writer.write(target.buildSaveString() + "\n");
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
