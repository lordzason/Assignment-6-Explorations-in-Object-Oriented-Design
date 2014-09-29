package edu.grinnell.csc207.chenzhi17.layout;

public class TruncatedBlock
    implements TextBlock
{
  /*Fields*/
  int width;
  int height;
  String input;

  /**
   * Create a new truncated block of the specified width.
   */
  public TruncatedBlock(TextBlock tb, int width)
  {
    //new TextBlock truncatedBlock = tb;
    this.width = width
    
  } // TruncatedBlock(TextBlock, int)

  /**
   * Get the ith row of the block.
   */
  public String row(int i)
    throws Exception
  {
    if (i < 0)
      {
        throw new Exception("Invalid row " + i);
      } // if the row is invalid
    return this.row(i).substring(0, this.width);
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height()
  {
    return this.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width()
  {
    return this.width;
  } // width()
} // class TruncatedBlock
