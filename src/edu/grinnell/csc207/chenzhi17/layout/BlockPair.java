package edu.grinnell.csc207.chenzhi17.layout;

public class BlockPair
    implements TextBlock
{
  /*Fields*/
  int textWidth;
  int height;
  TextBlock block;

  /*Constructor*/
  public BlockPair(TextBlock tb)
  {
    this.textWidth = tb.width() * 2;
    this.height = tb.height();
    block = tb;
  }

  /*Methods*/
  @Override
  public String row(int i)
    throws Exception
  {
    if (i < 0 || i > this.height)
      {
        throw new Exception("The row is out of bounds.");
      }

    String newText = this.block.row(i).toString().replaceAll(" ", "");
    newText = newText.concat(newText);
    int difference = this.textWidth - newText.length();
    String buffer = "";
    for (int j = 0; j < difference; j++)
      {
        buffer = buffer.concat(" ");
      }
    
    return newText + buffer;
  }

  @Override
  public int height()
  {
    return this.height;
  }

  @Override
  public int width()
  {
    return this.textWidth;
  }
}
