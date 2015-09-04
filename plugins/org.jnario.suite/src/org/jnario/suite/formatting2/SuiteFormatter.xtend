/*
 * generated by Xtext
 */
package org.jnario.suite.formatting2;

import com.google.inject.Inject;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.xbase.annotations.formatting2.XbaseWithAnnotationsFormatter;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.jnario.JnarioTypeDeclaration;
import org.jnario.suite.services.SuiteGrammarAccess;
import org.jnario.suite.suite.Reference;
import org.jnario.suite.suite.Suite;
import org.jnario.suite.suite.SuiteFile;

class SuiteFormatter extends XbaseWithAnnotationsFormatter {
	
	@Inject extension SuiteGrammarAccess

	def dispatch void format(SuiteFile suitefile, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		format(suitefile.getImportSection(), document);
		for (JnarioTypeDeclaration xtendTypes : suitefile.getXtendTypes()) {
			format(xtendTypes, document);
		}
	}

	def dispatch void format(Suite suite, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (XAnnotation annotations : suite.getAnnotations()) {
			format(annotations, document);
		}
		for (Reference elements : suite.getElements()) {
			format(elements, document);
		}
	}
}