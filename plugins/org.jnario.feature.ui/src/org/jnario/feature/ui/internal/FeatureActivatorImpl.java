/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.feature.ui.internal;

import org.eclipse.xtext.util.Modules2;
import org.jnario.feature.ui.FeatureUiModule;
import org.jnario.ui.JnarioSharedState;

import com.google.inject.Module;

public class FeatureActivatorImpl extends FeatureActivator {
	
	@Override
	protected Module getUiModule(String grammar) {
		return Modules2.mixin(new FeatureUiModule(this), new JnarioSharedState());
	}
	
}
