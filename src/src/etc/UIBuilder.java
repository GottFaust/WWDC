package etc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * UIBuilder class to store UI Init Methods
 * @author GottFuast
 *
 */
public class UIBuilder {
  
  /**
   * ____________________________________________________________
   * GLOBAL VARIABLES
   * ____________________________________________________________
   */
  /** Background Colors **/
  public static Color CONTAINER_BACKGROUND = new Color(44,44,44);
  public static Color TEXT_AREA_BACKGROUND = new Color(0,0,0);
  public static Color BUTTON_BACKGROUND = new Color(0,0,0);
  public static Color GRAPH_DEMARCATION_COLOR = Color.GRAY;
  
  /** Foreground Colors **/
  public static Color TEXT_FOREGROUND = new Color(0,255,0);
  public static Color BUTTON_FOREGROUND = new Color(0,255,0);
  public static Color LABEL_FOREGROUND = new Color(0,204,0);
  
  /** Misc Colors **/
  public static Color BORDER_COLOR = Color.ORANGE;
  public static Color LIGHER_BORDER_COLOR = Color.GREEN;
  public static Color CURRENT_GRAPH_COLOR = Color.YELLOW;
  public static Color PREVIOUS_GRAPH_COLOR = Color.GRAY;
  
  /** Fonts **/
  public static final Font FIELD_FONT = new Font ("Verdana", Font.PLAIN, 9);
  //public static final Font GRAPH_FONT = new Font ("Verdana", Font.PLAIN, 9);
  public static final Font GRAPH_LABEL_FONT = new Font ("Microsoft Himalaya", Font.PLAIN, 13);
  public static final Font GRAPH_NUMBER_FONT = new Font ("Microsoft Himalaya", Font.PLAIN, 16);
  
  /** Options File **/
  public static File colorOptions;
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * Initialize the global UI components
   */
  public static void UIInit(){
    try{
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      //Initialize the color Options
      colorOptions = new File("Colors.options");
      if(colorOptions.exists()){
        BufferedReader reader = new BufferedReader(new FileReader(colorOptions));
        String line = reader.readLine();
        while(line != null){
          String[] lineSplit = line.split(";");
          String[] rgbSplit = lineSplit[1].split(",");
          Color lineColor = new Color(Integer.parseInt(rgbSplit[0]),
                                      Integer.parseInt(rgbSplit[1]),
                                      Integer.parseInt(rgbSplit[2]));
          if(lineSplit[0].equals(Constants.CONTAINER_BACKGROUND_COLOR_NAME)){
            CONTAINER_BACKGROUND = lineColor;
          }else if(lineSplit[0].equals(Constants.TEXT_AREA_BACKGROUND_COLOR_NAME)){
            TEXT_AREA_BACKGROUND = lineColor;
          }else if(lineSplit[0].equals(Constants.BUTTON_BACKGROUND_COLOR_NAME)){
            BUTTON_BACKGROUND = lineColor;
          }else if(lineSplit[0].equals(Constants.GRAPH_DEMARCATION_COLOR_NAME)){
            GRAPH_DEMARCATION_COLOR = lineColor;
          }else if(lineSplit[0].equals(Constants.TEXT_FOREGROUND_COLOR_NAME)){
            TEXT_FOREGROUND = lineColor;
          }else if(lineSplit[0].equals(Constants.BUTTON_FOREGROUND_COLOR_NAME)){
            BUTTON_FOREGROUND = lineColor;
          }else if(lineSplit[0].equals(Constants.LABEL_FOREGROUND_COLOR_NAME)){
            LABEL_FOREGROUND = lineColor;
          }else if(lineSplit[0].equals(Constants.BORDER_COLOR_NAME)){
            BORDER_COLOR = lineColor;
          }else if(lineSplit[0].equals(Constants.LIGHER_BORDER_COLOR_NAME)){
            LIGHER_BORDER_COLOR = lineColor;
          }else if(lineSplit[0].equals(Constants.CURRENT_GRAPH_COLOR_NAME)){
            CURRENT_GRAPH_COLOR = lineColor;
          }else if(lineSplit[0].equals(Constants.PREVIOUS_GRAPH_COLOR_NAME)){
            PREVIOUS_GRAPH_COLOR = lineColor;
          }
          line = reader.readLine();
        }
        reader.close();
      }else{
        colorOptions.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(colorOptions));
        for(int i = 0; i < Constants.baseColorOptions.length; i++){
          writer.write(Constants.baseColorOptions[i]+"\n");
        }
        writer.close();
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public static void fileChooserInit(JFileChooser chooser){
    chooser.setFileFilter(new wdcFilter());
  }
  
  /**
   * Default Menu Item Init
   * @param item
   */
  public static void menuItemInit(JMenuItem item){
    item.setBackground(TEXT_AREA_BACKGROUND);
    item.setForeground(TEXT_FOREGROUND);
    item.setBorder(null);
  }
  
   /**
   * Default Menu Init
   * @param item
   */
  public static void menuInit(JMenu menu){
    menu.setBackground(TEXT_AREA_BACKGROUND);
    menu.setForeground(TEXT_FOREGROUND);
    menu.getPopupMenu().setBorder(null);
  }
  
  
  /**
   * Default Menu Bar Init
   * @param bar
   */
  public static void menuBarInit(JMenuBar bar){
    bar.setBackground(TEXT_AREA_BACKGROUND);
    bar.setForeground(TEXT_FOREGROUND);
    bar.setBorder(null);
  }
  
  /**
   * Default JList Init
   * @param item
   */
  public static void listInit(JList list){
    list.setBackground(TEXT_AREA_BACKGROUND);
    list.setForeground(TEXT_FOREGROUND);
  }
  
  /**
   * Default Button Init
   * @param button
   */
  public static void buttonInit(JButton button){
    button.setBackground(BUTTON_BACKGROUND);
    button.setForeground(BUTTON_FOREGROUND);
  }
  
  /**
   * Default ComboBox Init
   * @param box
   */
  public static void comboBoxInit(JComboBox box){
    box.setBackground(TEXT_AREA_BACKGROUND);
    box.setForeground(TEXT_FOREGROUND);
  }
  
  /**
   * Default Frame Init
   * @param frame
   */
  public static void frameInit(JFrame frame){
    frame.setBackground(CONTAINER_BACKGROUND);
  }
  
  /**
   * Default Label Init
   * @param label
   */
  public static void labelInit(JLabel label){
    label.setForeground(LABEL_FOREGROUND);
  }
  
  /**
   * Default Text Field Init
   * @param field
   */
  public static void textFieldInit(JTextField field){
    field.setBackground(TEXT_AREA_BACKGROUND);
    field.setForeground(TEXT_FOREGROUND);
    field.setBorder(null);
  }
  
  /**
   * Default Numbers-Only Text Field Init
   * @param field
   */
  public static void numberFieldInit(JTextField field){
    field.setBackground(TEXT_AREA_BACKGROUND);
    field.setForeground(TEXT_FOREGROUND);
    field.setDocument(new NumbersOnlyDocument());
    field.setBorder(null);
  }
  
  /**
   * Default Panel Init
   * @param panel
   */
  public static void panelInit(JPanel panel){
    panel.setBackground(CONTAINER_BACKGROUND);
  }
  
  /**
   * Default Text Area Init
   * @param area
   */
  public static void textAreaInit(JTextArea area){
    Font f = new Font("Arial", Font.PLAIN, 13);
    area.setFont(f);
    area.setBackground(TEXT_AREA_BACKGROUND);
    area.setForeground(TEXT_FOREGROUND);
  }
  
  /**
   * Default Uneditable Text Area Init
   * @param area
   */
  public static void uneditableTextAreaInit(JTextArea area){
    area.setBackground(TEXT_AREA_BACKGROUND);
    area.setForeground(TEXT_FOREGROUND);
    area.setEditable(false);
  }
  
  
  /**
   * Default Tabbed Pane Init
   * @param pane
   */
  public static void tabbedPaneInit(JTabbedPane pane){
    pane.setBackground(CONTAINER_BACKGROUND);
    pane.setForeground(LABEL_FOREGROUND);
    UIManager.put("TabbedPane.selected", CONTAINER_BACKGROUND);
    SwingUtilities.updateComponentTreeUI(pane);
    pane.setUI(new BasicTabbedPaneUI() {
      private final Insets borderInsets = new Insets(1, 1, 1, 1);
      @Override
      protected Insets getContentBorderInsets(int tabPlacement) {
          return borderInsets;
      }
    });
  }
  
  /**
   * Default Scroll Pane Init
   * @param pane
   */
  public static void scrollPaneInit(JScrollPane pane){
    pane.setBackground(CONTAINER_BACKGROUND);
    pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  }
  
  /**
   * Default Check Box Init
   * @param box
   */
  public static void checkBoxInit(JCheckBox box){
    box.setBackground(CONTAINER_BACKGROUND);
    box.setForeground(LABEL_FOREGROUND);
    box.setOpaque(true);
  }
  
  /**
   * Creates a default 1-pixel empty border for component separation
   * @param comp
   */
  public static void createSepparationBorder(JComponent comp){
    comp.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
  }
  
  /**
   * Creates a titled border using a single line type
   * @param comp
   * @param title
   */
  public static void createTitledLineBorder(JComponent comp, String title){
    LineBorder line = new LineBorder(BORDER_COLOR, 1);
    TitledBorder titledBorder = new TitledBorder(line,title,TitledBorder.CENTER,TitledBorder.TOP);
    titledBorder.setTitleColor(BORDER_COLOR);
    comp.setBorder(titledBorder);
  }
  
  /**
   * Creates a green titled border using a single line type
   * @param comp
   * @param title
   */
   public static void createTextTitledLineBorder(JComponent comp, String title){
      LineBorder line = new LineBorder(LIGHER_BORDER_COLOR, 1);
      TitledBorder titledBorder = new TitledBorder(line,title,TitledBorder.CENTER,TitledBorder.TOP);
      titledBorder.setTitleColor(LIGHER_BORDER_COLOR);
      comp.setBorder(titledBorder);
    }
  
  /**
   * ____________________________________________________________
   * INTERNAL CLASSES
   * ____________________________________________________________
   */
  
  /**
   * Document that accepts only numbers
   * @author GottFuast
   *
   */
  protected static class NumbersOnlyDocument extends PlainDocument {

    @Override
    public void insertString(int offs,String str,AttributeSet a) throws BadLocationException {

      if (str == null) {
        return;
      }
      char[] chars = str.toCharArray();
      String string = String.valueOf(chars);
      string = string.replaceAll("[^\\d.-]","");
      super.insertString(offs,string,a);
    }
  }
  
  /**
   * FileFilter that accepts only ".WDC" files
   * @author GottFuast
   *
   */
  public static class wdcFilter extends FileFilter {
    //Accept all directories and all WDC files.
    public boolean accept(File f) {
      if(f.isDirectory()){
        return true;
      }
      String ext = null;
      String s = f.getName();
      int i = s.lastIndexOf('.');
      if(i > 0 &&  i < s.length() - 1){
        ext = s.substring(i+1).toLowerCase();
      }
      if(ext != null){
        if(ext.equals("wdc")){
          return true;
        } else {
          return false;
        }
      }
      return false;
    }
    //The description of this filter
    public String getDescription(){
      return "only .WDC files";
    }
  }
}
