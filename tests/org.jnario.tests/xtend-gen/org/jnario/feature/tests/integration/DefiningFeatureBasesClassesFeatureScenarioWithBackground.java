package org.jnario.feature.tests.integration;

import org.jnario.feature.tests.integration.DefiningFeatureBasesClassesFeature;
import org.jnario.jnario.test.util.FeatureExecutor;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.StepArguments;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Named("Scenario: Scenario with Background")
@Ignore
@SuppressWarnings("all")
public class DefiningFeatureBasesClassesFeatureScenarioWithBackground extends DefiningFeatureBasesClassesFeature {
  CharSequence jnarioFile;
  
  @Test
  @Order(0)
  @Named("Given a scenario")
  public void _givenAScenario() {
    final StepArguments args = new StepArguments("import org.jnario.runner.Extends\nimport junit.framework.TestCase\n\n@Extends(typeof(TestCase)) \nFeature: Extend Annotation\n\tBackground:\n\t\tGiven some background\n\tScenario: My Scenario\n\t\tThen my feature class extends test case\n\t\t\ttypeof(ExtendAnnotationFeature).superclass => typeof(TestCase)\n\t\tAnd my scenario class extends my background class\n\t\t\ttypeof(ExtendAnnotationFeatureMyScenario).superclass => typeof(ExtendAnnotationFeatureBackground)\n\t\tAnd my background class extends my feature class\n\t\t\ttypeof(ExtendAnnotationFeatureBackground).superclass => typeof(ExtendAnnotationFeature)\n");
    String _first = JnarioIterableExtensions.<String>first(args);
    this.jnarioFile = _first;
  }
  
  @Test
  @Order(1)
  @Named("Then it should execute successfully")
  public void _thenItShouldExecuteSuccessfully() {
    FeatureExecutor.isSuccessful(this.jnarioFile);
  }
}
