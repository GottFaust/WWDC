package etc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JPanel;

public class DPSGraphPanel extends JPanel implements ComponentListener {
  
  /**
   * ____________________________________________________________
   * CLASS VARIABLES
   * ____________________________________________________________
   */
  
  /** Data **/
  private double rawDPS = 0.0;
  private double cloneFleshDPS = 0.0;
  private double ferriteDPS = 0.0;
  private double alloyDPS = 0.0;
  private double mechanicalDPS = 0.0;
  private double corpusFleshDPS = 0.0;
  private double shieldDPS = 0.0;
  private double protoShieldDPS = 0.0;
  private double roboticDPS = 0.0;
  private double infestedFleshDPS = 0.0;
  private double fossilizedDPS = 0.0;
  private double sinewDPS = 0.0;
  private double infestedDPS = 0.0;
  private double grineerDPS = 0.0;
  private double corpusDPS = 0.0;
  private double maxDPS = 35000.0;
  private double minDPS = 0.0;
  
  /** Labels **/
  private String rawLabel = "Raw";
  private String cloneLabel = "ClnFlsh";
  private String ferriteLabel = "Ferrite";
  private String alloyLabel = "Alloy";
  private String mechLabel = "Mech";
  private String corpusFleshLabel = "CrpFlsh";
  private String shieldLabel = "Sheild";
  private String protoShieldLabel = "ProtShld";
  private String roboticLabel = "Robotic";
  private String infestedFleshLabel = "InfsFlsh";
  private String fossilizedLabel = "Fossil";
  private String sinewLabel = "Sinew";
  private String infestedLabel = "Infested";
  private String grineerLabel = "Grineer";
  private String corpusLabel = "Corpus";
  
  /** Rendering Data **/
  protected double xStart;
  protected double xStop;
  protected double yStart;
  protected double yStop;
  protected int widthSlack = 30;
  protected int heightSlack = 10;
  protected FontMetrics metrics;
  protected Hashtable yMarkers = new Hashtable();
  protected Vector<Line2D.Double> xMarkers = new Vector<Line2D.Double>();
  protected transient Stroke stroke = new BasicStroke (1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10.0f, new float [] {2.0f,2.0f}, 0.0f);
  protected Vector<OutputPoint> currentPoints = new Vector<OutputPoint>();
  protected Vector<OutputPoint> previousPoints = new Vector<OutputPoint>();
  protected Vector<String> labels = new Vector<String>();
  
  /** Instance for use in sub-classes **/
  JPanel thisPanel = this;
  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public DPSGraphPanel(){
    
    labels.add(rawLabel);
    labels.add(cloneLabel);
    labels.add(ferriteLabel);
    labels.add(alloyLabel);
    labels.add(mechLabel);
    labels.add(corpusFleshLabel);
    labels.add(shieldLabel);
    labels.add(protoShieldLabel);
    labels.add(roboticLabel);
    labels.add(infestedFleshLabel);
    labels.add(fossilizedLabel);
    labels.add(sinewLabel);
    labels.add(infestedLabel);
    labels.add(grineerLabel);
    labels.add(corpusLabel);
    
    this.addComponentListener(this);
    setup();
  }
  
  //Clears this graph
  public void clear(){
    currentPoints = new Vector<OutputPoint>();
    previousPoints = new Vector<OutputPoint>();
    rawDPS = 0.0;
    cloneFleshDPS = 0.0;
    ferriteDPS = 0.0;
    alloyDPS = 0.0;
    mechanicalDPS = 0.0;
    corpusFleshDPS = 0.0;
    shieldDPS = 0.0;
    protoShieldDPS = 0.0;
    roboticDPS = 0.0;
    infestedFleshDPS = 0.0;
    fossilizedDPS = 0.0;
    sinewDPS = 0.0;
    infestedDPS = 0.0;
    grineerDPS = 0.0;
    corpusDPS = 0.0;
    maxDPS = 35000.0;
    this.setup();
    this.repaint();
  }
  
  /**
   * Updates the DPS values and then renders the graph
   * @param raw
   * @param armor
   * @param sheild
   * @param flesh
   * @param robotic
   * @param infested
   * @param grineer
   * @param corpus
   */
  public void updateDPS(double raw, 
                        double cloneFlesh, 
                        double ferrite,
                        double alloy,
                        double mechanical,
                        double corpusFlesh,
                        double shield,
                        double protoShield,
                        double robotic,
                        double infestedFlesh,
                        double fossilized,
                        double sinew,
                        double infested, 
                        double grineer, 
                        double corpus){
    
    previousPoints.clear();
    for(int i = 0; i < currentPoints.size(); i ++){
      previousPoints.add(currentPoints.get(i));
    }
    
    this.rawDPS = raw;
    this.cloneFleshDPS = cloneFlesh;
    this.ferriteDPS = ferrite;
    this.alloyDPS = alloy;
    this.mechanicalDPS = mechanical;
    this.corpusFleshDPS = corpusFlesh;
    this.shieldDPS = shield;
    this.protoShieldDPS = protoShield;
    this.roboticDPS = robotic;
    this.infestedFleshDPS = infestedFlesh;
    this.fossilizedDPS = fossilized;
    this.sinewDPS = sinew;
    this.infestedDPS = infested;
    this.grineerDPS = grineer;
    this.corpusDPS = corpus;
    
    if(rawDPS > maxDPS){
      maxDPS = rawDPS;
    }
    if(cloneFleshDPS > maxDPS){
      maxDPS = cloneFleshDPS;
    }
    if(ferriteDPS > maxDPS){
      maxDPS = ferriteDPS;
    }
    if(alloyDPS > maxDPS){
      maxDPS = alloyDPS;
    }
    if(mechanicalDPS > maxDPS){
      maxDPS = mechanicalDPS;
    }
    if(corpusFleshDPS > maxDPS){
      maxDPS = corpusFleshDPS;
    }
    if(shieldDPS > maxDPS){
      maxDPS = shieldDPS;
    }
    if(protoShieldDPS > maxDPS){
      maxDPS = protoShieldDPS;
    }
    if(roboticDPS > maxDPS){
      maxDPS = roboticDPS;
    }
    if(infestedFleshDPS > maxDPS){
      maxDPS = infestedFleshDPS;
    }
    if(fossilizedDPS > maxDPS){
      maxDPS = fossilizedDPS;
    }
    if(sinewDPS > maxDPS){
      maxDPS = sinewDPS;
    }
    if(infestedDPS > maxDPS){
      maxDPS = infestedDPS;
    }
    if(grineerDPS > maxDPS){
      maxDPS = grineerDPS;
    }
    if(corpusDPS > maxDPS){
      maxDPS = corpusDPS;
    }
    
    currentPoints.clear();
    
    int numberOfMarkers = labels.size();
    int totalWidth = thisPanel.getWidth() - widthSlack;
    double step = totalWidth / (double)numberOfMarkers;
    currentPoints.add(new OutputPoint((int)((step * 0) + xStart),this.rawDPS));
    currentPoints.add(new OutputPoint((int)((step * 1) + xStart),this.cloneFleshDPS));
    currentPoints.add(new OutputPoint((int)((step * 2) + xStart),this.ferriteDPS));
    currentPoints.add(new OutputPoint((int)((step * 3) + xStart),this.alloyDPS));
    currentPoints.add(new OutputPoint((int)((step * 4) + xStart),this.mechanicalDPS));
    currentPoints.add(new OutputPoint((int)((step * 5) + xStart),this.corpusFleshDPS));
    currentPoints.add(new OutputPoint((int)((step * 6) + xStart),this.shieldDPS));
    currentPoints.add(new OutputPoint((int)((step * 7) + xStart),this.protoShieldDPS));
    currentPoints.add(new OutputPoint((int)((step * 8) + xStart),this.roboticDPS));
    currentPoints.add(new OutputPoint((int)((step * 9) + xStart),this.infestedFleshDPS));
    currentPoints.add(new OutputPoint((int)((step * 10) + xStart),this.fossilizedDPS));
    currentPoints.add(new OutputPoint((int)((step * 11) + xStart),this.sinewDPS));
    currentPoints.add(new OutputPoint((int)((step * 12) + xStart),this.infestedDPS));
    currentPoints.add(new OutputPoint((int)((step * 13) + xStart),this.grineerDPS));
    currentPoints.add(new OutputPoint((int)((step * 14) + xStart),this.corpusDPS));
    
    this.setup();
    this.repaint();
  }
  
  /**
   * Converts a value to the Java2D equivalent coordinate.
   * @param value double
   * @param minValue double
   * @param maxValue double
   * @param min2D double
   * @param max2D double
   * @return double
   */
  private double valueToJava2D(double value, double minValue, double maxValue, double min2D, double max2D) {

    double axisMin = minValue;
    double axisMax = maxValue;

    double min = min2D;
    double max = max2D;

    return (min + ((value - axisMin) / (axisMax - axisMin)) * (max - min));   
  }
  
  /**
   * Computes the x and y axis markers so they can be painted on the graph.  The
   * calculations are done here so the paint method does not waste performance.
   */
  public void setup() {

    if (metrics == null) {

      return;

    }
    
    yStart = 0;
    yStop = maxDPS;
    xStart = 0;
    xStop = thisPanel.getWidth();

    xMarkers.clear();
    yMarkers.clear();

    for (int i = 1; i < 9; i++) {

      int value = (int)((yStop - yStart) * (0.125 * i) + yStart);
      value -= (value % 5);
      double y2D = valueToJava2D( value, 
          yStart, 
          yStop, 
          thisPanel.getHeight() - heightSlack, 
          0);
      double x22D = valueToJava2D( xStop, 
          xStart, 
          xStop, 
          widthSlack, 
          thisPanel.getWidth());

      Line2D.Double line = new Line2D.Double( widthSlack, 
          y2D, 
          x22D, 
          y2D);
      DecimalFormat f = new DecimalFormat("#");
      yMarkers.put( "" + value, line);
      //yMarkers.put( "" + f.format((maxDPS*(0.125*i))), line);

    }

    //find the longest string to base x markers calculations on
    int width = 0;
    width = metrics.stringWidth( "" + (int)xStart);

    if (metrics.stringWidth( "" + (int)xStop) > width) {

      width = metrics.stringWidth( "" + xStop);

    }

    //compute how many markers can fit on the x axis
    int markerWidth = thisPanel.getWidth();// - widthSlack;
    int numberOfMarkers = labels.size();
    double step = markerWidth / (double)numberOfMarkers;

    //step through x range and compute marker values and 2D coordinates
    for (int i = 0; i < numberOfMarkers; i++) {

      int value = (int)((step * i) + xStart);

      //create the 2D line
      double x2D = valueToJava2D( value, 
          xStart, 
          xStop, 
          widthSlack, 
          thisPanel.getWidth());
      double y12D = valueToJava2D( yStart, 
          yStart, 
          yStop, 
          thisPanel.getHeight() - heightSlack, 
          0);
      double y22D = valueToJava2D( yStop, 
          yStart, 
          yStop, 
          thisPanel.getHeight() - heightSlack, 
          0);
      Line2D.Double line = new Line2D.Double( x2D, y12D, x2D, y22D);
      xMarkers.add(line);
    }
    
    for(int i = 0; i < previousPoints.size(); i++){
      previousPoints.get(i).calculate((int)((step * i) + xStart));
    }
    for(int i = 0; i < currentPoints.size(); i++){
      currentPoints.get(i).calculate((int)((step * i) + xStart));
    }

    thisPanel.repaint();     
  }
  
  /**
   * Paints the different components that comprise the output graph.
   * @param g Graphics
   */
  public void paint(Graphics g) {

    super.paint( g);
    
    g.setFont( UIBuilder.GRAPH_NUMBER_FONT);
    if (metrics == null) {
      metrics = g.getFontMetrics( g.getFont());
      setup();
    }

    try {
      g.clearRect( 0, 0, thisPanel.getWidth(), thisPanel.getHeight());

      g.setColor( UIBuilder.TEXT_AREA_BACKGROUND);
      g.fillRect( widthSlack, 
          0, 
          thisPanel.getWidth(), 
          thisPanel.getHeight() - heightSlack);

      g.setColor( UIBuilder.TEXT_AREA_BACKGROUND);
      g.fillRect( 0, 
          thisPanel.getHeight() - heightSlack, 
          thisPanel.getWidth(), 
          thisPanel.getHeight());
      g.fillRect( 0, 0, widthSlack, thisPanel.getHeight() - heightSlack);

      Stroke prevStroke = ((Graphics2D)g).getStroke();
      ((Graphics2D)g).setStroke( stroke);

      Enumeration enum1 = yMarkers.keys();

      while (enum1.hasMoreElements()) {
        String key = (String)enum1.nextElement();
        Line2D.Double line = (Line2D.Double)yMarkers.get( key);

        g.setColor( UIBuilder.GRAPH_DEMARCATION_COLOR);
        ((Graphics2D)g).draw( line);

        //draw y axis marker
        g.setColor( UIBuilder.TEXT_FOREGROUND);
        int height = metrics.getHeight();
        ((Graphics2D)g).drawString( key, 0, (int)line.y1 + height - 2);
      }

      g.setFont( UIBuilder.GRAPH_LABEL_FONT);
      OutputPoint lastOldPoint = null;
      OutputPoint lastCurrentPoint = null;
      
      for(int i = 0; i < xMarkers.size(); i++){
        Line2D.Double line = xMarkers.get(i);

        g.setColor( UIBuilder.GRAPH_DEMARCATION_COLOR);
        ((Graphics2D)g).draw( line);
        
        //center and draw x axis markers
        g.setColor( UIBuilder.TEXT_FOREGROUND);
        ((Graphics2D)g).drawString( labels.get(i), (int)line.x1, thisPanel.getHeight());
        
        ((Graphics2D)g).setStroke( prevStroke);
        g.setColor( UIBuilder.PREVIOUS_GRAPH_COLOR);
        try{
          //previous data set
          OutputPoint point = previousPoints.get( i);
          ((Graphics2D)g).draw( point.square);
          if(lastOldPoint != null){
            Line2D.Double oldLine = new Line2D.Double( lastOldPoint.x2D, lastOldPoint.y2D, point.x2D, point.y2D);
            ((Graphics2D)g).draw( oldLine);
          }
          lastOldPoint = point;
        }catch(Exception ex){
          //ex.printStackTrace();
        }

        g.setColor(UIBuilder.CURRENT_GRAPH_COLOR);
        try{
          //current data set
          OutputPoint point = currentPoints.get( i);
          ((Graphics2D)g).draw( point.square);
          if(lastCurrentPoint != null){
            Line2D.Double currentLine = new Line2D.Double( lastCurrentPoint.x2D, lastCurrentPoint.y2D, point.x2D, point.y2D);
            ((Graphics2D)g).draw( currentLine);
          }
          lastCurrentPoint = point;
        }catch(Exception ex){
          //ex.printStackTrace();
        }
        ((Graphics2D)g).setStroke( stroke);
      }
      g.setColor( UIBuilder.TEXT_FOREGROUND);
    } catch (Exception exc) {
      //Do Nothing
    }     
  }
  
  /**
   * Resize callback 
   */
  public void componentResized(ComponentEvent e) {
    setup();
  }

  /**
   * Unused
   */
  public void componentShown(ComponentEvent e) {}
  public void componentHidden(ComponentEvent e) {}
  public void componentMoved(ComponentEvent e) {}
  
  /**
   * ____________________________________________________________
   * INTERNAL CLASSES
   * ____________________________________________________________
   */
  
  /**
   * A class representing a point on the graph.  Each output point consists of an x
   * value, y value, x2D coordinate value, y2D coordinate value, a line, and a
   * square.
   */
  protected class OutputPoint {
    public double x;
    public double y;
    public double x2D;
    public double y2D;
    public transient java.awt.geom.Rectangle2D.Double square;
    
    /**
     * CTOR.
     */
    public OutputPoint(double x, double y) {

      this.y = y;
      this.calculate(x);
    }
    
    /**
     * Updates the x/y coordinates of this data point
     * @param x
     */
    public void calculate(double x){
      this.x = x;
      //calculate the 2d coordinates for the line and square
      this.x2D = valueToJava2D( x, 
          xStart, 
          xStop, 
          widthSlack, 
          thisPanel.getWidth());
      double y02D = valueToJava2D( yStart, 
          yStart, 
          yStop, 
          thisPanel.getHeight() - heightSlack, 
          0);
      this.y2D = valueToJava2D( y, 
          yStart, 
          yStop, 
          thisPanel.getHeight() - heightSlack, 
          0);

      //the square will by 6x6 pixels
      square = new Rectangle2D.Double( x2D - 3, y2D - 3, 6, 6);     
    }
  }
}
