package Stances;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
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

import Stances.Stance.Combo;
import Stances.Stance.Hit;
import etc.Constants;
import etc.UIBuilder;
import main.Main;
import ttk.TTKTarget;

public class StanceManagerPanel extends JPanel implements ActionListener, ListSelectionListener {

	// slash, fire, electric, toxin, gas, magnetic, viral, corrosive, impact,
	// puncture, ice, blast, knockdown, radiation

	protected JPanel leftPanel = new JPanel();
	protected JPanel rightPanel = new JPanel();
	protected JPanel namePanel = new JPanel();
	protected JPanel typePanel = new JPanel();
	protected JPanel comboPanel = new JPanel();
	protected JPanel hitLabelsPanel = new JPanel();
	protected JPanel hitButtonsPanel = new JPanel();
	protected JPanel hitsPanel = new JPanel();
	protected Vector<JPanel> hitsPanels = new Vector<JPanel>();

	protected JTextField nameField = new JTextField(10);

	protected JLabel nameLabel = new JLabel("Stance - ");
	protected JLabel typeLabel = new JLabel("Type - ");
	protected JLabel comboLabel = new JLabel("Combo - ");
	protected JLabel delayLabel = new JLabel("Delay");
	protected JLabel multiLabel = new JLabel("Multiplier");
	protected JLabel procLabel = new JLabel("Status Procs");

	protected JComboBox<String> typeBox = new JComboBox<String>();
	protected JComboBox<String> comboBox = new JComboBox<String>();

	protected JButton addUpdateButton = new JButton("A/U Stance");
	protected JButton deleteButton = new JButton("Delete Stance");
	protected JButton addUpdateComboButton = new JButton("Update Combo");
	protected JButton deleteComboButton = new JButton("Delete Combo");
	protected JButton addHitButton = new JButton("Add Hit");
	protected JButton delHitButton = new JButton("Delete Hit");
	protected JButton saveButton = new JButton("Save");

	/** List Variables **/
	protected DefaultListModel stanceListModel = new DefaultListModel();
	protected JList stanceList = new JList(stanceListModel);
	protected JScrollPane listScroll = new JScrollPane(stanceList);

	protected Stance selectedStance = new Stance(";Blade and Whip;UnnamedCombo");
	protected Combo selectedCombo;
	protected StanceInitializer initializer;

	public StanceManagerPanel() {
		buildUI();
		init();
	}

	public void buildUI() {
		comboBox.setEditable(true);

		UIBuilder.panelInit(this);
		UIBuilder.panelInit(leftPanel);
		UIBuilder.panelInit(rightPanel);
		UIBuilder.panelInit(namePanel);
		UIBuilder.panelInit(typePanel);
		UIBuilder.panelInit(comboPanel);
		UIBuilder.panelInit(hitLabelsPanel);
		UIBuilder.panelInit(hitButtonsPanel);
		UIBuilder.panelInit(hitsPanel);

		UIBuilder.labelInit(nameLabel);
		UIBuilder.labelInit(typeLabel);
		UIBuilder.labelInit(comboLabel);
		UIBuilder.labelInit(delayLabel);
		UIBuilder.labelInit(multiLabel);
		UIBuilder.labelInit(procLabel);

		UIBuilder.listInit(stanceList);
		UIBuilder.scrollPaneInit(listScroll);

		UIBuilder.textFieldInit(nameField);

		UIBuilder.comboBoxInit(typeBox);
		UIBuilder.comboBoxInit(comboBox);
		typeBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");
		comboBox.setPrototypeDisplayValue("XXXXXXXXXXXXXX");

		UIBuilder.buttonInit(addUpdateButton);
		UIBuilder.buttonInit(deleteButton);
		UIBuilder.buttonInit(addUpdateComboButton);
		UIBuilder.buttonInit(deleteComboButton);
		UIBuilder.buttonInit(saveButton);
		UIBuilder.buttonInit(addHitButton);
		UIBuilder.buttonInit(delHitButton);

		leftPanel.setLayout(new GridLayout(1, 2, 0, 0));
		namePanel.setLayout(new GridLayout(1, 4, 0, 0));
		typePanel.setLayout(new GridLayout(1, 4, 0, 0));
		comboPanel.setLayout(new GridLayout(1, 4, 0, 0));
		hitLabelsPanel.setLayout(new GridLayout(1, 6, 0, 0));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		hitsPanel.setLayout(new BoxLayout(hitsPanel, BoxLayout.Y_AXIS));

		stanceList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		stanceList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		stanceList.setVisibleRowCount(-1);
		listScroll.setPreferredSize(new Dimension(150, 250));

		leftPanel.add(listScroll);

		namePanel.add(nameLabel);
		namePanel.add(nameField);
		namePanel.add(addUpdateButton);
		namePanel.add(deleteButton);

		typePanel.add(typeLabel);
		typePanel.add(typeBox);

		comboPanel.add(comboBox);
		comboPanel.add(addUpdateComboButton);
		comboPanel.add(deleteComboButton);

		hitLabelsPanel.add(delayLabel);
		hitLabelsPanel.add(multiLabel);
		hitLabelsPanel.add(procLabel);

		hitButtonsPanel.add(addHitButton);
		hitButtonsPanel.add(delHitButton);
		hitButtonsPanel.add(saveButton);

		hitsPanel.add(hitLabelsPanel);

		rightPanel.add(namePanel);
		rightPanel.add(typePanel);
		rightPanel.add(comboPanel);
		rightPanel.add(hitsPanel);
		rightPanel.add(hitButtonsPanel);

		this.add(leftPanel);
		this.add(rightPanel);

		addUpdateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		addUpdateComboButton.addActionListener(this);
		deleteComboButton.addActionListener(this);
		comboBox.addActionListener(this);
		saveButton.addActionListener(this);
		addHitButton.addActionListener(this);
		delHitButton.addActionListener(this);
		stanceList.getSelectionModel().addListSelectionListener(this);

		UIBuilder.createTitledLineBorder(hitsPanel, "HITS IN COMBO");
	}

	public void init() {
		initializer = StanceInitializer.getInstance();
		for (String mode : Constants.meleeTypes) {
			typeBox.addItem(mode);
		}
		for (Stance s : initializer.stances) {
			stanceListModel.addElement(s.stanceName);
		}
		clearValues();
	}

	public void clearValues() {
		nameField.setText("Unnamed Stance");
		comboBox.removeAllItems();
		comboBox.addItem("Unnamed Combo");
		typeBox.setSelectedIndex(0);
	}

	public void updateCombo() {
		boolean foundCombo = false;
		Vector<Hit> hits = new Vector<Hit>();
		for (JPanel p : hitsPanels) {
			double delay = checkNumber(((JTextField) p.getComponent(0)).getText());
			double multi = checkNumber(((JTextField) p.getComponent(1)).getText());
			// slash, fire, electric, toxin, gas, magnetic, viral, corrosive, impact, puncture, ice, blast, knockdown, radiation
			String[] procs = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
			int[] selectedProcs = ((JList) p.getComponent(2)).getSelectedIndices();
			for (int i : selectedProcs) {
				if (i == 0) {
					procs[8] = "1";
				} else if (i == 1) {
					procs[9] = "1";
				} else if (i == 2) {
					procs[0] = "1";
				} else if (i == 3) {
					procs[12] = "1";
				}
			}
			hits.add(new Hit(delay, multi, procs));
		}
		Combo c = new Combo((String) comboBox.getSelectedItem(), hits);

		for (int i = 0; i < selectedStance.combos.size(); i++) {
			if (selectedStance.combos.get(i).comboName.equals(c.comboName)) {
				selectedStance.combos.set(i, c);
				foundCombo = true;
			}
		}
		if (!foundCombo) {
			selectedStance.combos.add(c);
			comboBox.addItem(c.comboName);
		}
	}

	public JPanel hitPanel(Hit h) {
		JPanel hitPanel = new JPanel();
		JTextField delay = new JTextField();
		JTextField multi = new JTextField();
		DefaultListModel procsModel = new DefaultListModel();
		JList procs = new JList(procsModel);

		UIBuilder.panelInit(hitPanel);
		UIBuilder.numberFieldInit(delay);
		UIBuilder.numberFieldInit(multi);
		UIBuilder.listInit(procs);

		procs.setSelectionModel(new DefaultListSelectionModel() {
			@Override
			public void setSelectionInterval(int index0, int index1) {
				if (super.isSelectedIndex(index0)) {
					super.removeSelectionInterval(index0, index1);
				} else {
					super.addSelectionInterval(index0, index1);
				}
			}
		});
	
		procsModel.addElement(new ImageIcon(StanceManagerPanel.class.getResource("/0.png")));
		procsModel.addElement(new ImageIcon(StanceManagerPanel.class.getResource("/1.png")));
		procsModel.addElement(new ImageIcon(StanceManagerPanel.class.getResource("/2.png")));
		procsModel.addElement(new ImageIcon(StanceManagerPanel.class.getResource("/3.png")));
		
		procs.setLayoutOrientation(JList.VERTICAL_WRAP);
		procs.setVisibleRowCount(1);

		hitPanel.setLayout(new GridLayout(1, 4, 0, 0));
		hitPanel.add(delay);
		hitPanel.add(multi);
		hitPanel.add(procs);

		delay.setText(Double.toString(h.delay));
		multi.setText(Double.toString(h.multiplier));

		int size = 0;
		for (int i = 0; i < 14; i++) {
			if (h.procs[i].equals("1")) {
				size++;
			}
		}
		int[] procy = new int[size];

		// slash, fire, electric, toxin, gas, magnetic, viral, corrosive, impact,
		// puncture, ice, blast, knockdown, radiation

		int k = 0;
		for (int i = 0; i < 14; i++) {
			if (h.procs[i].equals("1")) {
				if (i == 0) {
					procy[k] = 2;
				} else if (i == 8) {
					procy[k] = 0;
				} else if (i == 9) {
					procy[k] = 1;
				} else {
					procy[k] = 3;
				}
				k++;
			}
		}
		procs.setSelectedIndices(procy);

		return hitPanel;
	}

	Double checkNumber(String d) {
		try {
			return Double.parseDouble(d);
		} catch (Exception ex) {
			return 0.0;
		}
	}

	/**
	 * List selection callback
	 */
	public void valueChanged(ListSelectionEvent e) {
		comboBox.removeAllItems();
		for (Stance s : initializer.stances) {
			if (s.stanceName.equals(stanceList.getSelectedValue())) {
				nameField.setText(s.stanceName);
				typeBox.setSelectedItem(s.weaponType);
				selectedStance = s;
				for (Combo c : s.combos) {
					comboBox.addItem(c.comboName);
				}
			}
		}
	}

	/**
	 * ActionListener callback
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addUpdateButton)) {
			if(!selectedStance.stanceName.equals(nameField.getText())) {
				Stance s = new Stance(selectedStance.writeOut());
				s.stanceName = nameField.getText();
				s.weaponType = (String)typeBox.getSelectedItem();
				initializer.stances.add(s);
				stanceListModel.addElement(s.stanceName);
				selectedStance = s;
				stanceList.setSelectedIndex(stanceListModel.size()-1);
			}else {
				updateCombo();
				selectedStance.weaponType = (String)typeBox.getSelectedItem();
			}
		} else if (e.getSource().equals(deleteButton)) {
			if (initializer.stances.contains(selectedStance)) {
				initializer.stances.remove(selectedStance);
			}
			stanceListModel.removeAllElements();
			for (Stance s : initializer.stances) {
				stanceListModel.addElement(s.stanceName);
			}
			clearValues();
		} else if (e.getSource().equals(addUpdateComboButton)) {
			updateCombo();
		} else if (e.getSource().equals(deleteComboButton)) {
			if (selectedStance.combos.contains(selectedCombo)) {
				selectedStance.combos.remove(selectedCombo);
			}
			comboBox.removeAllItems();
			for (Combo c : selectedStance.combos) {
				comboBox.addItem(c.comboName);
			}
		} else if (e.getSource().equals(saveButton)) {
			initializer.saveStanceDB();
		} else if (e.getSource().equals(comboBox) && selectedStance != null) {
			for (JPanel p : hitsPanels) {
				hitsPanel.remove(p);
			}
			hitsPanels.removeAllElements();		
			for (Combo c : selectedStance.combos) {
				if (c.comboName.equals(comboBox.getSelectedItem())) {
					selectedCombo = c;
					for (Hit h : selectedCombo.hits) {
						JPanel p = hitPanel(h);
						UIBuilder.createSepparationBorder(p);
						hitsPanels.add(p);
					}
				}
			}
			for (JPanel p : hitsPanels) {
				hitsPanel.add(p);
			}
		} else if (e.getSource().equals(addHitButton)) {
			String[] s = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
			Hit h = new Stance.Hit(0, 0, s);
			JPanel p = hitPanel(h);
			UIBuilder.createSepparationBorder(p);
			hitsPanels.add(p);
			hitsPanel.add(p);
		} else if (e.getSource().equals(delHitButton)) {
			hitsPanel.remove(hitsPanels.get(hitsPanels.size() - 1));
			hitsPanels.remove(hitsPanels.get(hitsPanels.size() - 1));
		}
		revalidate();
		Main.stanceManagerFrame.pack();
	}
}
