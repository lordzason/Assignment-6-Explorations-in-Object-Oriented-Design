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
    TBUtils.print(pen, block1);

    VComposition vTextBlock =
        new VComposition(new BoxedBlock(block), new BoxedBlock(block1));
    TBUtils.print(pen, vTextBlock);

    HComposition hTextBlock = new HComposition(new BoxedBlock(block), block1);
    TBUtils.print(pen, hTextBlock);

    HComposition hTextBlock1 = new HComposition(block1, new BoxedBlock(block));
    TBUtils.print(pen, hTextBlock1);

    //Grid test
    TBUtils.print(pen, new BoxedBlock(new Grid(7, 3, '*')));

    //TruncatedBlock test
    TextBlock truncatedBlock =
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock truncatedBlock2 = new TruncatedBlock(truncatedBlock, 3);
    TBUtils.print(pen, truncatedBlock);
    TBUtils.print(pen, truncatedBlock2);

    //CenteredBlock test 1
    TextBlock centeredBlock =
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock centeredBlock2 =
        new BoxedBlock(new CenteredBlock(centeredBlock, 11));
    TBUtils.print(pen, centeredBlock2);

    //CenteredBlock test 2
    TextBlock top = new CenteredBlock(new TextLine("Hello"), 11);
    TextBlock bottom = new CenteredBlock(new TextLine("Goodbye"), 11);
    TextBlock centeredBlock3 = new BoxedBlock(new VComposition(top, bottom));
    TBUtils.print(pen, centeredBlock3);

    //RightJustified test 1
    TextBlock rJ1 = new RightJustified(new TextLine("Hello"), 11);
    TextBlock rJ2 = new RightJustified(new TextLine("Goodbye"), 11);
    TextBlock rightJustified1 = new BoxedBlock(new VComposition(rJ1, rJ2));
    TBUtils.print(pen, rightJustified1);

    //RightJustified test 2
    TextBlock top1 = new CenteredBlock(new TextLine("Hello"), 11);
    TextBlock bottom1 = new CenteredBlock(new TextLine("Goodbye"), 11);
    TextBlock vTogether1 = new VComposition(top1, bottom1);
    TextBlock rightJustified2 =
        new BoxedBlock(new RightJustified(vTogether1, 11));
    TBUtils.print(pen, rightJustified2);

    //BlockPair test
    TextBlock blockPair =
        new BoxedBlock(new BlockPair(vTogether1));
    TBUtils.print(pen, blockPair);
    
    // Clean up after ourselves.
    pen.close();
  } // main(String[])
} // class TBExpt
