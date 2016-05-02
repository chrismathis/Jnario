package org.jnario.spec.tests.unit.formatting;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.jnario.jnario.test.util.AbstractXbaseFormatterTest;
import org.jnario.spec.SpecInjectorProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(SpecInjectorProvider.class)
@SuppressWarnings("all")
public class TableFormatterTest extends AbstractXbaseFormatterTest {
  @Test
  @Ignore
  public void testFormatWithAnnotations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings");
    _builder.newLine();
    _builder.append("describe \"Test\" {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@SuppressWarnings");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def tab {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| a | b | c |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 1 | 2 | 3 |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 4 | 5 | 6 |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 7 | 8 | 9 |");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings\t\t\t\t");
    _builder_1.newLine();
    _builder_1.append("describe \"Test\" {@SuppressWarnings def tab {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| a| b | c |");
    _builder_1.newLine();
    _builder_1.append("\t \t\t");
    _builder_1.append("|  1 | 2 | 3 | ");
    _builder_1.newLine();
    _builder_1.append("\t \t\t");
    _builder_1.append("| 4 | 5 | 6 |");
    _builder_1.newLine();
    _builder_1.append("\t \t\t ");
    _builder_1.append("| 7 | 8 | 9 |");
    _builder_1.newLine();
    _builder_1.append("}}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  @Ignore
  public void testFormatLinebreaks() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings");
    _builder.newLine();
    _builder.append("describe \"Test\" {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@SuppressWarnings");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def tab {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| a | b | c |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 1 | 2 | 3 |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 4 | 5 | 6 |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 7 | 8 | 9 |");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("describe \"Test\" {def tab {| a| b | c | \t\t| 1 | 2 | 3 | | 4 | 5 | 6 | | 7 | 8 | 9 |}}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  @Ignore
  public void testFormatColumnWidth() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("describe \"Test\" {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def tab {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| int a | b    | ccc |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 1+  1 | 2    | 3   |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 1 + 1 | 1234 | 7   |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 3  +1 | 4    | 5   |");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("describe \"Test\" {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def tab {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|int a| b         | ccc |");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|   1+  1 | 2    | 3   |");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|      1 + 1 | 1234 | 7   |");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|    3  +1|    4      |5|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  @Ignore
  public void testFormatMultilineCells() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("describe \"Test\" {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def tab {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| int  a    | b    | ccc |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 1+  1     | 2    | 3   |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| Math.max(");
    _builder.newLine();
    _builder.append("\t\t     ");
    _builder.append("1,2)      | 1234 | 7   |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 3+1       | 4    | 5   |");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("describe \"Test\" {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def tab {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("| int  a| b|ccc |");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("| 1+  1|2 |3|");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|                Math.max(");
    _builder_1.newLine();
    _builder_1.append("\t\t     ");
    _builder_1.append("1,2)                     | 1234 |7  |");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|3+1| 4| 5|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  @Ignore
  public void testFormatMultilineCells2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("describe \"Test\" {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def tab {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| int  a    | b    | ccc |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 1+  1     | 2    | 3   |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| Math.max(");
    _builder.newLine();
    _builder.append("\t\t          ");
    _builder.append("1,2)      | 1234 | 7   |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| 3+1       | 4    | 5   |");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("describe \"Test\" {");
    _builder_1.newLine();
    _builder_1.append("\t                     ");
    _builder_1.append("def tab {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("| int  a| b|ccc |");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("| 1+  1|2 |3|");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|                Math.max(");
    _builder_1.newLine();
    _builder_1.append("\t\t          ");
    _builder_1.append("1,2)                     | 1234 |7  |");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|3+1| 4| 5|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  @Ignore
  public void testFormatMultilineWithClosures() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("describe \"Test\" {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def myExampleWithClosures{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| input | operation        | result |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| \"a\"   | [String s | ");
    _builder.newLine();
    _builder.append("\t\t          ");
    _builder.append("s.toUpperCase]   | \"A\"    |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("| \"B\"   | [String s ");
    _builder.newLine();
    _builder.append("\t\t          ");
    _builder.append("| s.toLowerCase] | \"b\"    |");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("describe \"Test\" {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def myExampleWithClosures{");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("| input | operation | result |");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("| \"a\"   | [String s | ");
    _builder_1.newLine();
    _builder_1.append("\t\t          ");
    _builder_1.append("s.toUpperCase] |                \"A\"    |");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("| \"B\"   | [String s ");
    _builder_1.newLine();
    _builder_1.append("\t\t          ");
    _builder_1.append("| s.toLowerCase] | \"b\"            |");
    _builder_1.newLine();
    _builder_1.append("\t\t  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  @Ignore
  public void testFormatNoTables() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("describe \"Test\" {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fact true => true");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fact \"Test\" {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("describe \"Test\" {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("fact true => true");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("fact \"Test\" {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
}
