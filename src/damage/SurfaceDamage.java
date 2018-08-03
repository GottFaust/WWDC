package damage;


public class SurfaceDamage {

  /**
   * ____________________________________________________________
   * CLASS VARIABLES
   * ____________________________________________________________
   */
  
  public double perShot;
  public double critPerShot;
  public double firstShot;
  public double perIteration;
  public double perMinute;
  public double perSecond;
  public double rawPerSecond;

  
  /**
   * ____________________________________________________________
   * METHODS
   * ____________________________________________________________
   */
  
  /**
   * CTOR
   */
  public SurfaceDamage(){
    clear();
  }
  
  /**
   * Clears the values back to their defaults
   */
  public void clear(){

    perShot = 0.0;
    critPerShot = 0.0;
    firstShot = 0.0;
    perIteration = 0.0;
    perMinute = 0.0;
    perSecond = 0.0;
    rawPerSecond = 0.0;
  }

}
