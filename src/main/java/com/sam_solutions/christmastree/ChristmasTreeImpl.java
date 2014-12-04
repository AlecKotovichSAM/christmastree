package com.sam_solutions.christmastree;

import java.util.Iterator;

/**
 * User: Yahor Kastsialei
 * Date: 12/4/14
 * Time: 10:56 AM
 */
public class ChristmasTreeImpl implements IChristmasTree {
  public static int TREE_HEIGHT = 52;
//  private static List<> SQC = ".~'O'~.";
  private String newLine = System.getProperty("line.separator");
  private Garland garland;
  private int height;

  public ChristmasTreeImpl(final Garland garland) {
    this.garland = garland;
  }

  @Override
  public void build(int height) {
    this.height = height;

    garland.initiate();
  }

  @Override
  public void fire() {
    garland.startFiring();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    appendSpaces(builder, height);
    builder.append(Symbols.STAR.getPresentation());
    appendSpaces(builder, height);
    builder.append(newLine);

    StringBuilder garlandBuilder = new StringBuilder();
    Iterator<ISymbol> garlandIterator = garland.iterator();
    for(int i = height; i > 0 ; i--) {
      garlandBuilder.append(newLine);
      appendSpaces(garlandBuilder, height-i);
      for(int j = height-i; j <= i+height;j++) {
//        System.out.println("j="+j+"; i="+i + "; space="+(TREE_HEIGHT-i));
        if(!garlandIterator.hasNext()) {
          throw new RuntimeException("Tree is broken!");
        }
        garlandBuilder.append(garlandIterator.next().getPresentation());
      }
      appendSpaces(garlandBuilder, height-i);
    }
    builder.append(garlandBuilder.reverse());
    appendSpaces(builder, height - 1);
    builder.append("|~|");
    appendSpaces(builder, height - 1);
    return builder.toString();
  }

  private void appendSpaces(final StringBuilder garlandBuilder, final int space) {
    if(space == 0) {
      return;
    }
    garlandBuilder.append(" ");
    appendSpaces(garlandBuilder, space-1);
  }

}
