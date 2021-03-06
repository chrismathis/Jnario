/**
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jnario.spec.tests.integration;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.jnario.jnario.test.util.BehaviorExecutor;
import org.jnario.jnario.test.util.SpecTestCreator;
import org.jnario.runner.CreateWith;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * JUnit rules work exactly as in JUnit. Just declare a public field with the rule annotation.
 */
@CreateWith(SpecTestCreator.class)
@Named("Using JUnit Rules in Specs")
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class UsingJUnitRulesInSpecsSpec {
  @Extension
  @org.jnario.runner.Extension
  @Inject
  public BehaviorExecutor _behaviorExecutor;
  
  /**
   * @filter('''|.executesSuccessfully)
   */
  @Test
  @Named("Example Specification:")
  @Order(1)
  public void _exampleSpecification() throws Exception {
    this._behaviorExecutor.executesSuccessfully("package test\r\n\t\t\r\nimport org.junit.Rule\r\nimport org.junit.rules.TemporaryFolder\r\n\r\ndescribe Rule{\r\n  @Rule public val folder = new TemporaryFolder\t\r\n\r\n  fact folder.root should not be null\r\n}\t\t\r\n");
  }
}
