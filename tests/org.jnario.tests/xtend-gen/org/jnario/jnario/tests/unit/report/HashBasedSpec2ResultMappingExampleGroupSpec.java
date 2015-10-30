package org.jnario.jnario.tests.unit.report;

import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.jnario.jnario.tests.unit.report.HashBasedSpec2ResultMappingSpec;
import org.jnario.lib.Assert;
import org.jnario.lib.Should;
import org.jnario.report.Failed;
import org.jnario.report.NotRun;
import org.jnario.report.Passed;
import org.jnario.report.Pending;
import org.jnario.report.SpecExecution;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.jnario.spec.spec.ExampleGroup;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@Named("ExampleGroup")
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class HashBasedSpec2ResultMappingExampleGroupSpec extends HashBasedSpec2ResultMappingSpec {
  static String CLASSNAME = "RootSpec";
  
  @Test
  @Named("returns Pending if children are not executed and have no implementation")
  @Order(1)
  public void _returnsPendingIfChildrenAreNotExecutedAndHaveNoImplementation() throws Exception {
    this.m.parseSpec("describe \"Root\"{\r\n\tfact \"fact 1\"\r\n\tfact \"fact 2\"\r\n}\r\n");
    ExampleGroup _exampleGroup = this.m.exampleGroup("Root");
    SpecExecution _result = this.result(_exampleGroup);
    Assert.assertTrue("\nExpected m.exampleGroup(\"Root\").result => typeof(Pending) but"
     + "\n     m.exampleGroup(\"Root\").result is " + new org.hamcrest.StringDescription().appendValue(_result).toString()
     + "\n     m.exampleGroup(\"Root\") is " + new org.hamcrest.StringDescription().appendValue(_exampleGroup).toString()
     + "\n     m is " + new org.hamcrest.StringDescription().appendValue(this.m).toString() + "\n", Should.operator_doubleArrow(_result, Pending.class));
    
  }
  
  @Test
  @Named("returns NotRun if children are not executed but have an implementation")
  @Order(2)
  public void _returnsNotRunIfChildrenAreNotExecutedButHaveAnImplementation() throws Exception {
    this.m.parseSpec("describe \"Root\"{\r\n\tfact \"fact 1\"{ \"with implementation\" }\r\n\tfact \"fact 2\"{ \"with implementation\" }\r\n}\r\n");
    ExampleGroup _exampleGroup = this.m.exampleGroup("Root");
    SpecExecution _result = this.result(_exampleGroup);
    Assert.assertTrue("\nExpected m.exampleGroup(\"Root\").result => typeof(NotRun) but"
     + "\n     m.exampleGroup(\"Root\").result is " + new org.hamcrest.StringDescription().appendValue(_result).toString()
     + "\n     m.exampleGroup(\"Root\") is " + new org.hamcrest.StringDescription().appendValue(_exampleGroup).toString()
     + "\n     m is " + new org.hamcrest.StringDescription().appendValue(this.m).toString() + "\n", Should.operator_doubleArrow(_result, NotRun.class));
    
  }
  
  @Test
  @Named("passes if all children pass")
  @Order(3)
  public void _passesIfAllChildrenPass() throws Exception {
    this.m.parseSpec("describe \"Root\"{\r\n\tfact \"Example 1\"{ \"with implementation\" }\r\n\tfact \"Example 2\"{ \"with implementation\" }\r\n}\r\n");
    this.passes("Example 1", "Example 2");
    ExampleGroup _exampleGroup = this.m.exampleGroup("Root");
    SpecExecution _result = this.result(_exampleGroup);
    Assert.assertTrue("\nExpected m.exampleGroup(\"Root\").result => typeof(Passed) but"
     + "\n     m.exampleGroup(\"Root\").result is " + new org.hamcrest.StringDescription().appendValue(_result).toString()
     + "\n     m.exampleGroup(\"Root\") is " + new org.hamcrest.StringDescription().appendValue(_exampleGroup).toString()
     + "\n     m is " + new org.hamcrest.StringDescription().appendValue(this.m).toString() + "\n", Should.operator_doubleArrow(_result, Passed.class));
    
  }
  
  @Test
  @Named("fails if one child has failed")
  @Order(4)
  public void _failsIfOneChildHasFailed() throws Exception {
    this.m.parseSpec("describe \"Root\"{\r\n\tfact \"Example 1\"{ \"with implementation\" }\r\n\tfact \"Example 2\"{ \"with implementation\" }\r\n}\r\n");
    this.passes("Example 1");
    this.fails("Example 2");
    ExampleGroup _exampleGroup = this.m.exampleGroup("Root");
    SpecExecution _result = this.result(_exampleGroup);
    Assert.assertTrue("\nExpected m.exampleGroup(\"Root\").result => typeof(Failed) but"
     + "\n     m.exampleGroup(\"Root\").result is " + new org.hamcrest.StringDescription().appendValue(_result).toString()
     + "\n     m.exampleGroup(\"Root\") is " + new org.hamcrest.StringDescription().appendValue(_exampleGroup).toString()
     + "\n     m is " + new org.hamcrest.StringDescription().appendValue(this.m).toString() + "\n", Should.operator_doubleArrow(_result, Failed.class));
    
  }
  
  @Test
  @Named("execution time is sum of all child examples")
  @Order(5)
  public void _executionTimeIsSumOfAllChildExamples() throws Exception {
    this.m.parseSpec("describe \"Root\"{\r\n\tfact \"Example 1\"{ \"with implementation\" }\r\n\tfact \"Example 2\"{ \"with implementation\" }\r\n}\r\n");
    this.exampleExecutedIn("Example 1", 1.0);
    this.exampleExecutedIn("Example 2", 2.0);
    ExampleGroup _exampleGroup = this.m.exampleGroup("Root");
    SpecExecution _result = this.result(_exampleGroup);
    double _executionTimeInSeconds = _result.getExecutionTimeInSeconds();
    Assert.assertTrue("\nExpected m.exampleGroup(\"Root\").result.executionTimeInSeconds => 3.0 but"
     + "\n     m.exampleGroup(\"Root\").result.executionTimeInSeconds is " + new org.hamcrest.StringDescription().appendValue(Double.valueOf(_executionTimeInSeconds)).toString()
     + "\n     m.exampleGroup(\"Root\").result is " + new org.hamcrest.StringDescription().appendValue(_result).toString()
     + "\n     m.exampleGroup(\"Root\") is " + new org.hamcrest.StringDescription().appendValue(_exampleGroup).toString()
     + "\n     m is " + new org.hamcrest.StringDescription().appendValue(this.m).toString() + "\n", Should.<Double>operator_doubleArrow(Double.valueOf(_executionTimeInSeconds), Double.valueOf(3.0)));
    
  }
  
  @Test
  @Named("class name is from spec")
  @Order(6)
  public void _classNameIsFromSpec() throws Exception {
    this.m.parseSpec("describe \"Root\"{\r\n\tfact \"Example 1\"{ \"with implementation\" }\r\n\tfact \"Example 2\"{ \"with implementation\" }\r\n}\r\n");
    this.passes("Example 1");
    ExampleGroup _exampleGroup = this.m.exampleGroup("Root");
    SpecExecution _result = this.result(_exampleGroup);
    String _className = _result.getClassName();
    Assert.assertTrue("\nExpected m.exampleGroup(\"Root\").result.className => \"RootSpec\" but"
     + "\n     m.exampleGroup(\"Root\").result.className is " + new org.hamcrest.StringDescription().appendValue(_className).toString()
     + "\n     m.exampleGroup(\"Root\").result is " + new org.hamcrest.StringDescription().appendValue(_result).toString()
     + "\n     m.exampleGroup(\"Root\") is " + new org.hamcrest.StringDescription().appendValue(_exampleGroup).toString()
     + "\n     m is " + new org.hamcrest.StringDescription().appendValue(this.m).toString() + "\n", Should.<String>operator_doubleArrow(_className, "RootSpec"));
    
  }
  
  @Test
  @Named("name is from spec")
  @Order(7)
  public void _nameIsFromSpec() throws Exception {
    this.m.parseSpec("describe \"Root\"{\r\n\tfact \"Example 1\"\r\n\tfact \"Example 2\"\r\n}\r\n");
    this.passes("Example 1");
    ExampleGroup _exampleGroup = this.m.exampleGroup("Root");
    SpecExecution _result = this.result(_exampleGroup);
    String _name = _result.getName();
    Assert.assertTrue("\nExpected m.exampleGroup(\"Root\").result.name => \"Root\" but"
     + "\n     m.exampleGroup(\"Root\").result.name is " + new org.hamcrest.StringDescription().appendValue(_name).toString()
     + "\n     m.exampleGroup(\"Root\").result is " + new org.hamcrest.StringDescription().appendValue(_result).toString()
     + "\n     m.exampleGroup(\"Root\") is " + new org.hamcrest.StringDescription().appendValue(_exampleGroup).toString()
     + "\n     m is " + new org.hamcrest.StringDescription().appendValue(this.m).toString() + "\n", Should.<String>operator_doubleArrow(_name, "Root"));
    
  }
  
  @Test
  @Named("caches calculated results")
  @Order(8)
  public void _cachesCalculatedResults() throws Exception {
    this.m.parseSpec("describe \"Root\"{\r\n\tfact \"Example 1\"\r\n\tfact \"Example 2\"\r\n}\r\n");
    this.passes("Example 1");
    final ExampleGroup exampleGroup = this.m.exampleGroup("Root");
    final SpecExecution first = this.result(exampleGroup);
    final SpecExecution second = this.result(exampleGroup);
    Matcher<SpecExecution> _sameInstance = CoreMatchers.<SpecExecution>sameInstance(second);
    Assert.assertTrue("\nExpected first => sameInstance(second) but"
     + "\n     first is " + new org.hamcrest.StringDescription().appendValue(first).toString()
     + "\n     sameInstance(second) is " + new org.hamcrest.StringDescription().appendValue(_sameInstance).toString()
     + "\n     second is " + new org.hamcrest.StringDescription().appendValue(second).toString() + "\n", Should.<SpecExecution>operator_doubleArrow(first, _sameInstance));
    
  }
  
  @Test
  @Named("supports nested specs")
  @Order(9)
  public void _supportsNestedSpecs() throws Exception {
    this.m.parseSpec("describe \"Root\"{\r\n\tdescribe \"Child\"{\r\n\t\tfact \"Example 1\"{1 + 1 => 2}\r\n\t}\t\r\n}\r\n");
    HashBasedSpec2ResultMappingExampleGroupSpec.CLASSNAME = "RootChildSpec";
    this.passes("Example 1");
    ExampleGroup _exampleGroup = this.m.exampleGroup("Root");
    SpecExecution _result = this.result(_exampleGroup);
    Assert.assertTrue("\nExpected m.exampleGroup(\"Root\").result => typeof(Passed) but"
     + "\n     m.exampleGroup(\"Root\").result is " + new org.hamcrest.StringDescription().appendValue(_result).toString()
     + "\n     m.exampleGroup(\"Root\") is " + new org.hamcrest.StringDescription().appendValue(_exampleGroup).toString()
     + "\n     m is " + new org.hamcrest.StringDescription().appendValue(this.m).toString() + "\n", Should.operator_doubleArrow(_result, Passed.class));
    
  }
  
  @Test
  @Ignore
  @Named("supports nested specs referencing methods [PENDING]")
  @Order(10)
  public void _supportsNestedSpecsReferencingMethods() throws Exception {
    this.m.parseSpec("describe String{\r\n\tdescribe charAt{\r\n\t\tfact \"Example 1\"{1 + 1 => 2}\r\n\t}\t\r\n}\r\n");
    HashBasedSpec2ResultMappingExampleGroupSpec.CLASSNAME = "RootCharAtSpec";
    this.passes("Example 1");
    ExampleGroup _exampleGroup = this.m.exampleGroup("String");
    SpecExecution _result = this.result(_exampleGroup);
    Assert.assertTrue("\nExpected m.exampleGroup(\"String\").result => typeof(Passed) but"
     + "\n     m.exampleGroup(\"String\").result is " + new org.hamcrest.StringDescription().appendValue(_result).toString()
     + "\n     m.exampleGroup(\"String\") is " + new org.hamcrest.StringDescription().appendValue(_exampleGroup).toString()
     + "\n     m is " + new org.hamcrest.StringDescription().appendValue(this.m).toString() + "\n", Should.operator_doubleArrow(_result, Passed.class));
    
  }
  
  public void exampleExecutedIn(@Extension final String name, @Extension final double time) {
    Passed _passingSpec = Passed.passingSpec(HashBasedSpec2ResultMappingExampleGroupSpec.CLASSNAME, name, time);
    this.subject.accept(_passingSpec);
  }
  
  public void fails(@Extension final String name) {
    Failed _failingSpec = Failed.failingSpec(HashBasedSpec2ResultMappingExampleGroupSpec.CLASSNAME, name, HashBasedSpec2ResultMappingSpec.anyExecutionTime, this.anyFailure);
    this.subject.accept(_failingSpec);
  }
  
  public void passes(@Extension final String... names) {
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Passed _passingSpec = Passed.passingSpec(HashBasedSpec2ResultMappingExampleGroupSpec.CLASSNAME, it, HashBasedSpec2ResultMappingSpec.anyExecutionTime);
        HashBasedSpec2ResultMappingExampleGroupSpec.this.subject.accept(_passingSpec);
      }
    };
    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(names)), _function);
  }
}
