package damage;


public class Damage {
  
  /**
   * ____________________________________________________________
   * CLASS VARIABLES
   * ____________________________________________________________
   */
  
  public double base;
  public double finalBase;
  public double finalCrit;
  public double perShot;
  public double critPerShot;
  public double firstShot;
  public double lastShot;
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
  public Damage(){
    clear();
  }
  
  /**
   * Clears the values back to their defaults
   */
  public void clear(){
    this.base = 0.0;
    this.finalBase = 0.0;
    this.finalCrit = 0.0;
    this.perShot = 0.0;
    this.critPerShot = 0.0;
    this.firstShot = 0.0;
    this.lastShot = 0.0;
    this.perIteration = 0.0;
    this.perMinute = 0.0;
    this.perSecond = 0.0;
    this.rawPerSecond = 0.0;
  }

}
