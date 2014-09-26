package edu.grinnell.csc207.chenzhi17.layout;

public class Grid
    implements TextBlock
{
  /*Fields*/
  int width;
  int height;
  char charInput;

  /*Constructor*/
  public Grid(int width, int height, char ch)
  {
    this.width = width;
    this.height = height;
    this.charInput = ch;
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

  @Override
  public String row(int i)
    throws Exception
  {
    return Character.toString(charInput);
  }

}
