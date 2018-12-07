package etc;

import java.awt.BasicStroke;
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

import etc.DPSGraphPanel.OutputPoint;

public class TTKGraphPanel extends JPanel implements ComponentListener {
  
  protected double maxTTK = 20.0;
  
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
  protected Vector<TTKNamePair> dataPoints = new Vector<TTKNamePair>();
  
  /** Instance for use in sub-classes **/
  JPanel thisPanel = this;
  
  public TTKGraphPanel(){
    
    this.addComponentListener(this);
    setup();
  }
  
  public void updateGraph(Vector<TTKNamePair> data){
    
    dataPoints = data;
    previousPoints.clear();
    for(int i = 0; i < currentPoints.size(); i ++){
      previousPoints.add(currentPoints.get(i));
    }
    currentPoints.clear();
    
    int numberOfMarkers = dataPoints.size();
    int totalWidth = thisPanel.getWidth() - widthSlack;
    double step = totalWidth / (double)numberOfMarkers;
    for(int i = 0; i < numberOfMarkers; i++){
      double currentTTK = dataPoints.get(i).TTK;
      currentPoints.add(new OutputPoint((int)((step * i) + xStart),currentTTK));
      if(currentTTK > maxTTK){
        maxTTK = currentTTK;
      }
    }
    
    this.setup();
    this.repaint();
  }
  
  public void clear(){
    currentPoints.clear();
    previousPoints.clear();
    dataPoints.clear();
    maxTTK = 20.0;
    this.setup();
    this.repaint();
  }
  
  /**
   * Converts a value to the Java2D equivalent coordinate.
   * @param value
   * @param minValue
   * @param maxValue
   * @param min2D
   * @param max2D
   * @return
   */
  private double valueToJava2D(double value, double minValue, double maxValue, double min2D, double max2D) {

    double axisMin = minValue;
    double axisMax = maxValue;

    double min = min2D;
    double max = max2D;

    return (min + ((value - axisMin) / (axisMax - axisMin)) * (max - min));   
  }
  
  public void setup(){
    if (metrics == null) {

      return;

    }
    
    yStart = maxTTK;
    yStop = 0;
    xStart = 0;
    xStop = thisPanel.getWidth();

    xMarkers.clear();
    yMarkers.clear();

    for (int i = 1; i < 9; i++) {

      double value = (yStop - yStart) * (0.125 * i) + yStart;
      //value -= (value % 5);
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
      DecimalFormat f = new DecimalFormat("0.0");
      yMarkers.put( "" + f.format(value), line);
      
    }

    //find the longest string to base x markers calculations on
    int width = 0;
    width = metrics.stringWidth( "" + (int)xStart);

    if (metrics.stringWidth( "" + (int)xStop) > width) {

      width = metrics.stringWidth( "" + xStop);

    }

    //compute how many markers can fit on the x axis
    int markerWidth = thisPanel.getWidth();// - widthSlack;
    int numberOfMarkers = dataPoints.size();
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
        ((Graphics2D)g).drawString( dataPoints.get(i).name, (int)line.x1, thisPanel.getHeight());
        
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
  
  public void componentResized(ComponentEvent arg0) {
    setup();
  }
  
  public void componentShown(ComponentEvent arg0) {}
  public void componentHidden(ComponentEvent arg0) {}
  public void componentMoved(ComponentEvent arg0) {}
  
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
