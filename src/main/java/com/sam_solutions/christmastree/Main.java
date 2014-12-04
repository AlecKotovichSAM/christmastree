package com.sam_solutions.christmastree;

import java.io.*;

public class Main {

  public static final char ESC = 27;

  public static void main(String[] args)
      throws Exception {
    Console c = System.console();
    if (c == null) {
      System.err.println("no console");
      System.exit(1);
    }

    PrintWriter writer = c.writer();
    writer.print(ESC + "[2J");
    writer.flush();
    Thread.sleep(200);


    IChristmasTree tree = new ChristmasTreeImpl(new Garland());

    tree.build(args.length > 0 ? Integer.parseInt(args[0]) : ChristmasTreeImpl.TREE_HEIGHT);
    tree.fire();

    while (true) {
      writer.print(ESC + "[1;1H");
      writer.flush();
      writer.print(tree);
      writer.flush();
      Thread.sleep(500);
    }
  }

}