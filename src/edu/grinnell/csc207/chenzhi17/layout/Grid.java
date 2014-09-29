/**
 * Consulted http://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string-in-java
 * on how to turn a character into a string
 * 
 */

package edu.grinnell.csc207.chenzhi17.layout;

public class Grid
    implements TextBlock
{
  /*Fields*/
  int width;
  int height;
  String charString;

  /*Constructor*/
  public Grid(int width, int height, char ch) throws Exception
  {
    try
      {
        this.width = width;
        this.height = height;
        this.charString = Character.toString(ch);
      }
    catch (Exception e)
      {
        System.out.println("Invalid input(s).");
      }

  }

  /*Methods*/
  public int height()
  {
    return this.height;
  }

  public int width()
  {
    return this.width;
  }

  //Consulted code from Sam Rebelsky
  public String row(int i)
    throws Exception
  {
    while (charString.length() < this.width)
      {
        charString = charString.concat(charString);
      }
    return charString.substring(0,this.width);
  }

}
