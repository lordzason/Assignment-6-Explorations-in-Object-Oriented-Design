package edu.grinnell.csc207.chenzhi17.layout;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.2 of September 2014
 */
public class TBExpt
{
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args)
    throws Exception
  {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Hello");
    // Print out the block
    TBUtils.print(pen, block);
    
    TextBlock block1 = new TextLine("Goodbye.");
    TBUtils.print(pen,block1);
    
    VComposition vTextBlock = new VComposition(new BoxedBlock(block), new BoxedBlock(block1));
    TBUtils.print(pen,vTextBlock);
    
    HComposition hTextBlock = new HComposition(new BoxedBlock(block), block1);
    TBUtils.print(pen,hTextBlock);
    
    HComposition hTextBlock1 = new HComposition(block1,new BoxedBlock(block));
    TBUtils.print(pen,hTextBlock1);
    
    TextBlock block2 = new Grid(1, 1, 'a');
    TBUtils.print(pen,block2);
    
    //Doesn't work:
    //TextBlock block3 = new TruncatedBlock(block1, 3);
    //TBUtils.print(pen,block3);
    
        // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
