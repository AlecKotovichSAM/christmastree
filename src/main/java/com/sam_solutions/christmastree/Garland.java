package com.sam_solutions.christmastree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * User: Yahor Kastsialei
 * Date: 12/4/14
 * Time: 11:07 AM
 */
public class Garland  {
  private List<ISymbol> sqc;
  private boolean isFiring = false;
  private boolean isLightning = false;
  public void initiate() {
    if(sqc == null) {
      sqc = new ArrayList<ISymbol>();
      sqc.add(Symbols.APOSTROPHE);
      sqc.add(Symbols.TILDE);
      sqc.add(Symbols.DOT);
      sqc.add(Symbols.DOT);
      sqc.add(Symbols.TILDE);
      sqc.add(Symbols.APOSTROPHE);
      sqc.add(Symbols.O_SYMBOL);
    }
  }

  public void startFiring() {
    isFiring = true;
  }

  public Iterator<ISymbol> iterator() {
    if(sqc == null) {
      throw new IllegalStateException("Garland is not initiated");
    }
    Iterator<ISymbol> iterator = new Iterator<ISymbol>() {
      Iterator<ISymbol> internalIterator;
      @Override
      public boolean hasNext() {
        if(internalIterator == null || !internalIterator.hasNext()) {
          internalIterator = sqc.iterator();
        }
        return internalIterator.hasNext();
      }

      @Override
      public ISymbol next() {
        if(!hasNext()) {
          throw new NoSuchElementException();
        }
        ISymbol symbol = internalIterator.next();
        if(isLightning && Symbols.O_SYMBOL.equals(symbol)) {
          return Symbols.X_SYMBOL;
        }
        return symbol;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
    isLightning = isFiring && !isLightning;
    return iterator;
  }
}
