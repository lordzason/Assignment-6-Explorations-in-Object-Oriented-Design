/**
 * Consulted Eileen Fordham
 */

package edu.grinnell.csc207.chenzhi17.layout;

public class RightJustified
    implements TextBlock
{
  /*Fields*/
  TextBlock block;
  int height;
  int desiredWidth;
  int textWidth;

  /*Constructor*/
  public RightJustified(TextBlock textBlock, int desiredWidth) throws Exception
  {
    if (desiredWidth < textBlock.width())
      {
        throw new Exception(
                            "Invalid width entered: Cannot be less than width of underlying text block.");
      }
    this.block = textBlock;
    this.height = textBlock.height();
    this.desiredWidth = desiredWidth;
    this.textWidth = textBlock.width();
  }

  /*Methods*/
  @Override
  public String row(int i)
    throws Exception
  {
    if (i < 0 || i > this.height)
      {
        throw new Exception("Cannot get row outside of bounds.");
      }

    String text = this.block.row(i).toString();
    int diff = this.desiredWidth - this.textWidth;
    String buffer = "";
    for (int j = 0; j < diff; j++)
      {
        buffer = buffer.concat(" ");
      }
    return text + buffer;

  }

  @Override
  public int height()
  {
    return this.height;
  }

  @Override
  public int width()
  {
    return this.desiredWidth;
  }

}
