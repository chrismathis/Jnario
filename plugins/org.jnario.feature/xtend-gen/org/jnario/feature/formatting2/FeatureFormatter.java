/**
 * generated by Xtext
 */
package org.jnario.feature.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.annotations.formatting2.XbaseWithAnnotationsFormatter;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.jnario.Assertion;
import org.jnario.JnarioField;
import org.jnario.JnarioFunction;
import org.jnario.JnarioMember;
import org.jnario.JnarioParameter;
import org.jnario.JnarioTypeDeclaration;
import org.jnario.Should;
import org.jnario.ShouldThrow;
import org.jnario.feature.feature.And;
import org.jnario.feature.feature.Background;
import org.jnario.feature.feature.But;
import org.jnario.feature.feature.Feature;
import org.jnario.feature.feature.FeatureFile;
import org.jnario.feature.feature.Given;
import org.jnario.feature.feature.Scenario;
import org.jnario.feature.feature.Then;
import org.jnario.feature.feature.When;
import org.jnario.feature.services.FeatureGrammarAccess;

@SuppressWarnings("all")
public class FeatureFormatter extends XbaseWithAnnotationsFormatter {
  @Inject
  @Extension
  private FeatureGrammarAccess _featureGrammarAccess;
  
  protected void _format(final FeatureFile featurefile, @Extension final IFormattableDocument document) {
    this.format(featurefile.getImportSection(), document);
    EList<JnarioTypeDeclaration> _xtendTypes = featurefile.getXtendTypes();
    for (final JnarioTypeDeclaration xtendTypes : _xtendTypes) {
      this.format(xtendTypes, document);
    }
  }
  
  protected void _format(final Feature feature, @Extension final IFormattableDocument document) {
    EList<XAnnotation> _annotations = feature.getAnnotations();
    for (final XAnnotation annotations : _annotations) {
      this.format(annotations, document);
    }
    EList<JnarioMember> _members = feature.getMembers();
    for (final JnarioMember members : _members) {
      this.format(members, document);
    }
  }
  
  protected void _format(final Background background, @Extension final IFormattableDocument document) {
    EList<JnarioMember> _members = background.getMembers();
    for (final JnarioMember members : _members) {
      this.format(members, document);
    }
  }
  
  protected void _format(final Scenario scenario, @Extension final IFormattableDocument document) {
    EList<JnarioMember> _members = scenario.getMembers();
    for (final JnarioMember members : _members) {
      this.format(members, document);
    }
  }
  
  protected void _format(final JnarioMember jnariomember, @Extension final IFormattableDocument document) {
    EList<XAnnotation> _annotations = jnariomember.getAnnotations();
    for (final XAnnotation annotations : _annotations) {
      this.format(annotations, document);
    }
  }
  
  protected void _format(final JnarioField jnariofield, @Extension final IFormattableDocument document) {
    this.format(jnariofield.getType(), document);
    this.format(jnariofield.getInitialValue(), document);
    this.format(jnariofield.getAnnotationInfo(), document);
  }
  
  protected void _format(final Given given, @Extension final IFormattableDocument document) {
    this.format(given.getExpression(), document);
  }
  
  protected void _format(final When when, @Extension final IFormattableDocument document) {
    this.format(when.getExpression(), document);
  }
  
  protected void _format(final Then then, @Extension final IFormattableDocument document) {
    this.format(then.getExpression(), document);
  }
  
  protected void _format(final And and, @Extension final IFormattableDocument document) {
    this.format(and.getExpression(), document);
  }
  
  protected void _format(final But but, @Extension final IFormattableDocument document) {
    this.format(but.getExpression(), document);
  }
  
  @Override
  protected void _format(final XBlockExpression xblockexpression, @Extension final IFormattableDocument document) {
    EList<XExpression> _expressions = xblockexpression.getExpressions();
    for (final XExpression expressions : _expressions) {
      this.format(expressions, document);
    }
  }
  
  protected void _format(final Should should, @Extension final IFormattableDocument document) {
    this.format(should.getRightOperand(), document);
    this.format(should.getLeftOperand(), document);
  }
  
  protected void _format(final ShouldThrow shouldthrow, @Extension final IFormattableDocument document) {
    this.format(shouldthrow.getType(), document);
    this.format(shouldthrow.getExpression(), document);
  }
  
  @Override
  protected void _format(final XInstanceOfExpression xinstanceofexpression, @Extension final IFormattableDocument document) {
    this.format(xinstanceofexpression.getType(), document);
    this.format(xinstanceofexpression.getExpression(), document);
  }
  
  @Override
  protected void _format(final XBinaryOperation xbinaryoperation, @Extension final IFormattableDocument document) {
    this.format(xbinaryoperation.getRightOperand(), document);
    this.format(xbinaryoperation.getLeftOperand(), document);
  }
  
  protected void _format(final Assertion assertion, @Extension final IFormattableDocument document) {
    this.format(assertion.getExpression(), document);
  }
  
  protected void _format(final JnarioFunction jnariofunction, @Extension final IFormattableDocument document) {
    EList<JvmTypeParameter> _typeParameters = jnariofunction.getTypeParameters();
    for (final JvmTypeParameter typeParameters : _typeParameters) {
      this.format(typeParameters, document);
    }
    this.format(jnariofunction.getReturnType(), document);
    EList<JnarioParameter> _parameters = jnariofunction.getParameters();
    for (final JnarioParameter parameters : _parameters) {
      this.format(parameters, document);
    }
    EList<JvmTypeReference> _exceptions = jnariofunction.getExceptions();
    for (final JvmTypeReference exceptions : _exceptions) {
      this.format(exceptions, document);
    }
    this.format(jnariofunction.getExpression(), document);
    this.format(jnariofunction.getAnnotationInfo(), document);
  }
  
  protected void _format(final JnarioParameter jnarioparameter, @Extension final IFormattableDocument document) {
    EList<XAnnotation> _annotations = jnarioparameter.getAnnotations();
    for (final XAnnotation annotations : _annotations) {
      this.format(annotations, document);
    }
    this.format(jnarioparameter.getParameterType(), document);
  }
  
  @Override
  public void format(final Object and, final IFormattableDocument document) {
    if (and instanceof And) {
      _format((And)and, document);
      return;
    } else if (and instanceof Background) {
      _format((Background)and, document);
      return;
    } else if (and instanceof But) {
      _format((But)and, document);
      return;
    } else if (and instanceof Feature) {
      _format((Feature)and, document);
      return;
    } else if (and instanceof Given) {
      _format((Given)and, document);
      return;
    } else if (and instanceof Then) {
      _format((Then)and, document);
      return;
    } else if (and instanceof When) {
      _format((When)and, document);
      return;
    } else if (and instanceof Scenario) {
      _format((Scenario)and, document);
      return;
    } else if (and instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)and, document);
      return;
    } else if (and instanceof Should) {
      _format((Should)and, document);
      return;
    } else if (and instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)and, document);
      return;
    } else if (and instanceof XtextResource) {
      _format((XtextResource)and, document);
      return;
    } else if (and instanceof XAssignment) {
      _format((XAssignment)and, document);
      return;
    } else if (and instanceof XBinaryOperation) {
      _format((XBinaryOperation)and, document);
      return;
    } else if (and instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)and, document);
      return;
    } else if (and instanceof XFeatureCall) {
      _format((XFeatureCall)and, document);
      return;
    } else if (and instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)and, document);
      return;
    } else if (and instanceof XPostfixOperation) {
      _format((XPostfixOperation)and, document);
      return;
    } else if (and instanceof XWhileExpression) {
      _format((XWhileExpression)and, document);
      return;
    } else if (and instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)and, document);
      return;
    } else if (and instanceof JnarioField) {
      _format((JnarioField)and, document);
      return;
    } else if (and instanceof JnarioFunction) {
      _format((JnarioFunction)and, document);
      return;
    } else if (and instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)and, document);
      return;
    } else if (and instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)and, document);
      return;
    } else if (and instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)and, document);
      return;
    } else if (and instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)and, document);
      return;
    } else if (and instanceof XBlockExpression) {
      _format((XBlockExpression)and, document);
      return;
    } else if (and instanceof XCastedExpression) {
      _format((XCastedExpression)and, document);
      return;
    } else if (and instanceof XClosure) {
      _format((XClosure)and, document);
      return;
    } else if (and instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)and, document);
      return;
    } else if (and instanceof XConstructorCall) {
      _format((XConstructorCall)and, document);
      return;
    } else if (and instanceof XForLoopExpression) {
      _format((XForLoopExpression)and, document);
      return;
    } else if (and instanceof XIfExpression) {
      _format((XIfExpression)and, document);
      return;
    } else if (and instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)and, document);
      return;
    } else if (and instanceof XReturnExpression) {
      _format((XReturnExpression)and, document);
      return;
    } else if (and instanceof XSwitchExpression) {
      _format((XSwitchExpression)and, document);
      return;
    } else if (and instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)and, document);
      return;
    } else if (and instanceof XThrowExpression) {
      _format((XThrowExpression)and, document);
      return;
    } else if (and instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)and, document);
      return;
    } else if (and instanceof XTypeLiteral) {
      _format((XTypeLiteral)and, document);
      return;
    } else if (and instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)and, document);
      return;
    } else if (and instanceof XAnnotation) {
      _format((XAnnotation)and, document);
      return;
    } else if (and instanceof Assertion) {
      _format((Assertion)and, document);
      return;
    } else if (and instanceof JnarioMember) {
      _format((JnarioMember)and, document);
      return;
    } else if (and instanceof JnarioParameter) {
      _format((JnarioParameter)and, document);
      return;
    } else if (and instanceof ShouldThrow) {
      _format((ShouldThrow)and, document);
      return;
    } else if (and instanceof FeatureFile) {
      _format((FeatureFile)and, document);
      return;
    } else if (and instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)and, document);
      return;
    } else if (and instanceof XExpression) {
      _format((XExpression)and, document);
      return;
    } else if (and instanceof XImportDeclaration) {
      _format((XImportDeclaration)and, document);
      return;
    } else if (and instanceof XImportSection) {
      _format((XImportSection)and, document);
      return;
    } else if (and instanceof EObject) {
      _format((EObject)and, document);
      return;
    } else if (and == null) {
      _format((Void)null, document);
      return;
    } else if (and != null) {
      _format(and, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(and, document).toString());
    }
  }
}
