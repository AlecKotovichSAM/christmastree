package com.sam_solutions.christmastree;

import org.assertj.core.api.Assertions;

public class ChristmasTreeImplTest {
  private String newLine = System.getProperty("line.separator");

  @org.junit.Test
  public void shouldToString() throws Exception {
    IChristmasTree tree = new ChristmasTreeImpl(new Garland());
    tree.build(6);
//    tree.fire();
    StringBuilder builder = new StringBuilder();
    builder.append("      *      ").append(newLine);
    builder.append("     '~.     ").append(newLine);
    builder.append("    .~'O'    ").append(newLine);
    builder.append("   ~..~'O'   ").append(newLine);
    builder.append("  ~..~'O'~.  ").append(newLine);
    builder.append(" .~'O'~..~'O ").append(newLine);
    builder.append("'~..~'O'~..~'").append(newLine);
    builder.append("     |~|     ");
    Assertions.assertThat(tree.toString()).isEqualTo(builder.toString());
  }

  @org.junit.Test
  public void shouldToStringLightning() throws Exception {
    IChristmasTree tree = new ChristmasTreeImpl(new Garland());
    tree.build(6);
    tree.fire();
    StringBuilder builder = new StringBuilder();
    builder.append("      *      ").append(newLine);
    builder.append("     '~.     ").append(newLine);
    builder.append("    .~'O'    ").append(newLine);
    builder.append("   ~..~'O'   ").append(newLine);
    builder.append("  ~..~'O'~.  ").append(newLine);
    builder.append(" .~'O'~..~'O ").append(newLine);
    builder.append("'~..~'O'~..~'").append(newLine);
    builder.append("     |~|     ");

    StringBuilder builderX = new StringBuilder();
    builderX.append("      *      ").append(newLine);
    builderX.append("     '~.     ").append(newLine);
    builderX.append("    .~'X'    ").append(newLine);
    builderX.append("   ~..~'X'   ").append(newLine);
    builderX.append("  ~..~'X'~.  ").append(newLine);
    builderX.append(" .~'X'~..~'X ").append(newLine);
    builderX.append("'~..~'X'~..~'").append(newLine);
    builderX.append("     |~|     ");
    Assertions.assertThat(tree.toString()).isEqualTo(builderX.toString());
    Assertions.assertThat(tree.toString()).isEqualTo(builder.toString());
  }
}