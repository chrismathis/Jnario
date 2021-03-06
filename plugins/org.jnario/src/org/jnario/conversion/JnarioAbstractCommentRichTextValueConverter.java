/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.conversion;

import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JnarioAbstractCommentRichTextValueConverter extends AbstractLexerBasedConverter<String> {

	// TODO NO_XTEND
//	@Override
//	protected String getLeadingTerminal() {
//		return "\u00AB\u00AB";
//	}
	
	@Override
	protected String toEscapedString(String value) {
		// TODO: Is this the correct line separator? 
		return super.toEscapedString("\n" + value);
	}
	
	// TODO NO_XTEND
//	@Override
//	protected String getWithoutLeadingTerminal(String string) {
//		int lineBreak = Math.max(string.indexOf('\n'), string.indexOf('\r'));
//		if (lineBreak == -1 || lineBreak == string.length() - 1)
//			return "";
//		return string.substring(lineBreak + 1);
//	}

}

