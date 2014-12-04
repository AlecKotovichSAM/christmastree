package com.sam_solutions.christmastree;

/**
 * User: Yahor Kastsialei
 * Date: 12/4/14
 * Time: 10:52 AM
 */
public enum Symbols implements ISymbol {
  STAR {
    @Override
    public String getPresentation() {
      return "*";
    }
  },
  TILDE {
    @Override
    public String getPresentation() {
      return "~";
    }
  },
  APOSTROPHE {
    @Override
    public String getPresentation() {
      return "'";
    }
  },
  DOT {
    @Override
    public String getPresentation() {
      return ".";
    }
  },
  O_SYMBOL {
    @Override
    public String getPresentation() {
      return "O";
    }
  },
  X_SYMBOL {
    @Override
    public String getPresentation() {
      return "X";
    }
  }

}
