package org.jnario.ui.tests.feature.contentassist;

import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.jnario.ui.tests.feature.contentassist.FeatureProposalProviderSpec;
import org.jnario.ui.tests.util.AbstractContentAssistProcessorTest2;
import org.junit.Test;
import org.junit.runner.RunWith;

@Named("same file")
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class FeatureProposalProviderSameFileSpec extends FeatureProposalProviderSpec {
  @Test
  @Named("proposes implemented steps")
  @Order(1)
  public void _proposesImplementedSteps() throws Exception {
    AbstractContentAssistProcessorTest2.ContentAssistProcessorTestBuilder2 _newBuilder = this.newBuilder();
    final AbstractContentAssistProcessorTest2.ContentAssistProcessorTestBuilder2 builder = _newBuilder.append("Feature: My Feature\r\n\tScenario: My Scenario\r\n\tGiven an implemented step\r\n\t\t1 + 1 => 2\r\n\t\r\n");
    builder.assertProposal("features.And an implemented step");
    builder.assertProposal("features.But an implemented step");
  }
  
  @Test
  @Named("proposes unimplemented steps")
  @Order(2)
  public void _proposesUnimplementedSteps() throws Exception {
    AbstractContentAssistProcessorTest2.ContentAssistProcessorTestBuilder2 _newBuilder = this.newBuilder();
    final AbstractContentAssistProcessorTest2.ContentAssistProcessorTestBuilder2 builder = _newBuilder.append("Feature: My Feature\r\n\tScenario: My Scenario\r\n\tGiven a pending step\r\n\t\r\n");
    builder.assertProposal("features.And a pending step");
    builder.assertProposal("features.But a pending step");
  }
  
  @Test
  @Named("does not provide given for then")
  @Order(3)
  public void _doesNotProvideGivenForThen() throws Exception {
    AbstractContentAssistProcessorTest2.ContentAssistProcessorTestBuilder2 _newBuilder = this.newBuilder();
    final AbstractContentAssistProcessorTest2.ContentAssistProcessorTestBuilder2 builder = _newBuilder.append("Feature: My Feature\r\n\tScenario: My Scenario\r\n\tGiven a step\r\n\tThen another step\r\n\t\r\n");
    builder.assertProposalsContainNot("And a step");
    builder.assertProposal("features.And another step");
    builder.assertProposal("features.But another step");
  }
}
