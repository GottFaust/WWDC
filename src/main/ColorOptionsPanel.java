package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorOptionsPanel extends JPanel implements ActionListener, ChangeListener {
  
  /**
   * ____________________________________________________________
   * CLASS VARIABLES
   * ____________________________________________________________
   */
  
  /** Color Boxes **/
  protected JCheckBox containerColorBox = new JCheckBox(Constants.CONTAINER_BACKGROUND_COLOR_NAME);
  protected JCheckBox textBackgroundColorBox = new JCheckBox(Constants.TEXT_AREA_BACKGROUND_COLOR_NAME);
  protected JCheckBox buttonBackgroundColorBox = new JCheckBox(Constants.BUTTON_BACKGROUND_COLOR_NAME);
  protected JCheckBox graphDemarcationColorBox = new JCheckBox(Constants.GRAPH_DEMARCATION_COLOR_NAME);
  protected JCheckBox textColorBox = new JCheckBox(Constants.TEXT_FOREGROUND_COLOR_NAME);
  protected JCheckBox buttonTextColorBox = new JCheckBox(Constants.BUTTON_FOREGROUND_COLOR_NAME);
  protected JCheckBox labelTextColorBox = new JCheckBox(Constants.LABEL_FOREGROUND_COLOR_NAME);
  protected JCheckBox borderColorBox = new JCheckBox(Constants.BORDER_COLOR_NAME);
  protected JCheckBox modBorderColorBox = new JCheckBox(Constants.LIGHER_BORDER_COLOR_NAME);
  protected JCheckBox currentGraphColorBox = new JCheckBox(Constants.CURRENT_GRAPH_COLOR_NAME);
  protected JCheckBox previousGraphColorBox = new JCheckBox(Constants.PREVIOUS_GRAPH_COLOR_NAME);
  
  /** Color Display Buttons **/
  protected JButton containerColorButton = new JButton("");
  protected JButton textBackgroundColorButton = new JButton("");
  protected JButton buttonBackgroundColorButton = new JButton("");
  protected JButton graphDemarcationColorButton = new JButton("");
  protected JButton textColorButton = new JButton("");
  protected JButton buttonTextColorButton = new JButton("");
  protected JButton labelTextColorButton = new JButton("");
  protected JButton borderColorButton = new JButton("");
  protected JButton modBorderColorButton = new JButton("");
  protected JButton currentGraphColorButton = new JButton("");
  protected JButton previousGraphColorButton = new JButton("");
  
  /** Action Buttons **/
  protected JButton saveButton = new JButton("Save");
  protected JButton clearButton = new JButton("Clear");
  
  /** JPanels **/
  protected JPanel containerColorPanel = new JPanel();
  protected JPanel textBackgroundColorPanel = new JPanel();
  protected JPanel buttonBackgroundColorPanel = new JPanel();
  protected JPanel graphDemarcationColorPanel = new JPanel();
  protected JPanel textColorPanel = new JPanel();
  protected JPanel buttonTextColorPanel = new JPanel();
  protected JPanel labelTextColorPanel = new JPanel();
  protected JPanel borderColorPanel = new JPanel();
  protected JPanel modBorderColorPanel = new JPanel();
  protected JPanel currentGraphColorPanel = new JPanel();
  protected JPanel previousGraphColorPanel = new JPanel();
  protected JPanel buttonControlPanel = new JPanel();
  protected JPanel colorChooserPanel = new JPanel();
  
  /** Color Chooser **/
  protected JColorChooser chooser = new JColorChooser();
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public ColorOptionsPanel(){
    buildUI();
    defaultColors();
  }
  
  /**
   * builds the UI
   */
  public void buildUI(){
    
    containerColorPanel.setLayout(new BoxLayout(containerColorPanel, BoxLayout.X_AXIS));
    textBackgroundColorPanel.setLayout(new BoxLayout(textBackgroundColorPanel, BoxLayout.X_AXIS));
    buttonBackgroundColorPanel.setLayout(new BoxLayout(buttonBackgroundColorPanel, BoxLayout.X_AXIS));
    graphDemarcationColorPanel.setLayout(new BoxLayout(graphDemarcationColorPanel, BoxLayout.X_AXIS));
    textColorPanel.setLayout(new BoxLayout(textColorPanel, BoxLayout.X_AXIS));
    buttonTextColorPanel.setLayout(new BoxLayout(buttonTextColorPanel, BoxLayout.X_AXIS));
    labelTextColorPanel.setLayout(new BoxLayout(labelTextColorPanel, BoxLayout.X_AXIS));
    borderColorPanel.setLayout(new BoxLayout(borderColorPanel, BoxLayout.X_AXIS));
    currentGraphColorPanel.setLayout(new BoxLayout(currentGraphColorPanel, BoxLayout.X_AXIS));
    previousGraphColorPanel.setLayout(new BoxLayout(previousGraphColorPanel, BoxLayout.X_AXIS));
    buttonControlPanel.setLayout(new BoxLayout(buttonControlPanel, BoxLayout.X_AXIS));
    colorChooserPanel.setLayout(new BoxLayout(colorChooserPanel, BoxLayout.X_AXIS));
    modBorderColorPanel.setLayout(new BoxLayout(modBorderColorPanel, BoxLayout.X_AXIS));
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    //chooser.setBackground(UIBuilder.CONTAINER_BACKGROUND);
    chooser.setPreviewPanel(new JPanel());
    chooser.getSelectionModel().addChangeListener(this);
    
    saveButton.addActionListener(this);
    clearButton.addActionListener(this);
    
    JPanel line1 = new JPanel();
    UIBuilder.panelInit(line1);
    line1.setLayout(new BoxLayout(line1, BoxLayout.X_AXIS));
    
    JPanel line2 = new JPanel();
    UIBuilder.panelInit(line2);
    line2.setLayout(new BoxLayout(line2, BoxLayout.X_AXIS));
    
    JPanel line3 = new JPanel();
    UIBuilder.panelInit(line3);
    line3.setLayout(new BoxLayout(line3, BoxLayout.X_AXIS));
    
    containerColorPanel.add(containerColorBox);
    containerColorPanel.add(containerColorButton);
    
    textBackgroundColorPanel.add(textBackgroundColorBox);
    textBackgroundColorPanel.add(textBackgroundColorButton);
    
    buttonBackgroundColorPanel.add(buttonBackgroundColorBox);
    buttonBackgroundColorPanel.add(buttonBackgroundColorButton);
    
    graphDemarcationColorPanel.add(graphDemarcationColorBox);
    graphDemarcationColorPanel.add(graphDemarcationColorButton);
    
    textColorPanel.add(textColorBox);
    textColorPanel.add(textColorButton);
    
    buttonTextColorPanel.add(buttonTextColorBox);
    buttonTextColorPanel.add(buttonTextColorButton);
    
    labelTextColorPanel.add(labelTextColorBox);
    labelTextColorPanel.add(labelTextColorButton);
    
    borderColorPanel.add(borderColorBox);
    borderColorPanel.add(borderColorButton);
    
    modBorderColorPanel.add(modBorderColorBox);
    modBorderColorPanel.add(modBorderColorButton);
    
    currentGraphColorPanel.add(currentGraphColorBox);
    currentGraphColorPanel.add(currentGraphColorButton);
    
    previousGraphColorPanel.add(previousGraphColorBox);
    previousGraphColorPanel.add(previousGraphColorButton);
    
    buttonControlPanel.add(clearButton);
    buttonControlPanel.add(saveButton);
    
    colorChooserPanel.add(chooser);
    
    line1.add(containerColorPanel);
    line1.add(textBackgroundColorPanel);
    line1.add(buttonBackgroundColorPanel);
    line2.add(graphDemarcationColorPanel);
    line2.add(textColorPanel);
    line2.add(buttonTextColorPanel);
    line2.add(labelTextColorPanel);
    line3.add(borderColorPanel);
    line3.add(modBorderColorPanel);
    line3.add(currentGraphColorPanel);
    line3.add(previousGraphColorPanel);
    
    this.add(line1);
    this.add(line2);
    this.add(line3);
    this.add(colorChooserPanel);
    this.add(buttonControlPanel);
  }
  
  /**
   * Defaults the colors to the loaded set
   */
  public void defaultColors(){
    containerColorButton.setBackground(UIBuilder.CONTAINER_BACKGROUND);
    textBackgroundColorButton.setBackground(UIBuilder.TEXT_AREA_BACKGROUND);
    buttonBackgroundColorButton.setBackground(UIBuilder.BUTTON_BACKGROUND);
    graphDemarcationColorButton.setBackground(UIBuilder.GRAPH_DEMARCATION_COLOR);
    textColorButton.setBackground(UIBuilder.TEXT_FOREGROUND);
    buttonTextColorButton.setBackground(UIBuilder.BUTTON_FOREGROUND);
    labelTextColorButton.setBackground(UIBuilder.LABEL_FOREGROUND);
    borderColorButton.setBackground(UIBuilder.BORDER_COLOR);
    modBorderColorButton.setBackground(UIBuilder.LIGHER_BORDER_COLOR);
    currentGraphColorButton.setBackground(UIBuilder.CURRENT_GRAPH_COLOR);
    previousGraphColorButton.setBackground(UIBuilder.PREVIOUS_GRAPH_COLOR);
  }
  
  /**
   * Updates the selected colors
   */
  public void updateColors(){
    if(containerColorBox.isSelected()){
      containerColorButton.setBackground(chooser.getColor());
    }
    if(textBackgroundColorBox.isSelected()){
      textBackgroundColorButton.setBackground(chooser.getColor());
    }
    if(buttonBackgroundColorBox.isSelected()){
      buttonBackgroundColorButton.setBackground(chooser.getColor());
    }
    if(graphDemarcationColorBox.isSelected()){
      graphDemarcationColorButton.setBackground(chooser.getColor());
    }
    if(textColorBox.isSelected()){
      textColorButton.setBackground(chooser.getColor());
    }
    if(buttonTextColorBox.isSelected()){
      buttonTextColorButton.setBackground(chooser.getColor());
    }
    if(labelTextColorBox.isSelected()){
      labelTextColorButton.setBackground(chooser.getColor());
    }
    if(borderColorBox.isSelected()){
      borderColorButton.setBackground(chooser.getColor());
    }
    if(modBorderColorBox.isSelected()){
      modBorderColorButton.setBackground(chooser.getColor());
    }
    if(currentGraphColorBox.isSelected()){
      currentGraphColorButton.setBackground(chooser.getColor());
    }
    if(previousGraphColorBox.isSelected()){
      previousGraphColorButton.setBackground(chooser.getColor());
    }
  }
  
  /**
   * Saves the selected colors to the file to be loaded next time
   */
  public void saveColors(){
    try {
      File colorOptions = new File("Colors.options");
      if(colorOptions.exists()){
        colorOptions.delete();
      }
      colorOptions.createNewFile();
      BufferedWriter writer = new BufferedWriter(new FileWriter(colorOptions));
      writer.write( Constants.CONTAINER_BACKGROUND_COLOR_NAME+";"+
                    containerColorButton.getBackground().getRed()+","+
                    containerColorButton.getBackground().getGreen()+","+
                    containerColorButton.getBackground().getBlue()+"\n");
      writer.write( Constants.TEXT_AREA_BACKGROUND_COLOR_NAME+";"+
                    textBackgroundColorButton.getBackground().getRed()+","+
                    textBackgroundColorButton.getBackground().getGreen()+","+
                    textBackgroundColorButton.getBackground().getBlue()+"\n");
      writer.write( Constants.BUTTON_BACKGROUND_COLOR_NAME+";"+
                    buttonBackgroundColorButton.getBackground().getRed()+","+
                    buttonBackgroundColorButton.getBackground().getGreen()+","+
                    buttonBackgroundColorButton.getBackground().getBlue()+"\n");
      writer.write( Constants.GRAPH_DEMARCATION_COLOR_NAME+";"+
                    graphDemarcationColorButton.getBackground().getRed()+","+
                    graphDemarcationColorButton.getBackground().getGreen()+","+
                    graphDemarcationColorButton.getBackground().getBlue()+"\n");
      writer.write( Constants.TEXT_FOREGROUND_COLOR_NAME+";"+
                    textColorButton.getBackground().getRed()+","+
                    textColorButton.getBackground().getGreen()+","+
                    textColorButton.getBackground().getBlue()+"\n");
      writer.write( Constants.BUTTON_FOREGROUND_COLOR_NAME+";"+
                    buttonTextColorButton.getBackground().getRed()+","+
                    buttonTextColorButton.getBackground().getGreen()+","+
                    buttonTextColorButton.getBackground().getBlue()+"\n");
      writer.write( Constants.LABEL_FOREGROUND_COLOR_NAME+";"+
                    labelTextColorButton.getBackground().getRed()+","+
                    labelTextColorButton.getBackground().getGreen()+","+
                    labelTextColorButton.getBackground().getBlue()+"\n");
      writer.write( Constants.BORDER_COLOR_NAME+";"+
                    borderColorButton.getBackground().getRed()+","+
                    borderColorButton.getBackground().getGreen()+","+
                    borderColorButton.getBackground().getBlue()+"\n");
      writer.write( Constants.LIGHER_BORDER_COLOR_NAME+";"+
                    modBorderColorButton.getBackground().getRed()+","+
                    modBorderColorButton.getBackground().getGreen()+","+
                    modBorderColorButton.getBackground().getBlue()+"\n");
      writer.write( Constants.CURRENT_GRAPH_COLOR_NAME+";"+
                    currentGraphColorButton.getBackground().getRed()+","+
                    currentGraphColorButton.getBackground().getGreen()+","+
                    currentGraphColorButton.getBackground().getBlue()+"\n");
      writer.write( Constants.PREVIOUS_GRAPH_COLOR_NAME+";"+
                    previousGraphColorButton.getBackground().getRed()+","+
                    previousGraphColorButton.getBackground().getGreen()+","+
                    previousGraphColorButton.getBackground().getBlue()+"\n");
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(clearButton)){
      defaultColors();
    }else if(e.getSource().equals(saveButton)){
      saveColors();
    }
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    updateColors();
  }
}
