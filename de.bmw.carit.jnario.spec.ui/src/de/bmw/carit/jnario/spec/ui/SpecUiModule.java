/*
 * generated by Xtext
 */
package de.bmw.carit.jnario.spec.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;

import de.bmw.carit.jnario.spec.ui.contentassist.ImportingTypesProposalProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class SpecUiModule extends de.bmw.carit.jnario.spec.ui.AbstractSpecUiModule {
	public SpecUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	

	@Override
	public Class<? extends ITypesProposalProvider> bindITypesProposalProvider() {
		return ImportingTypesProposalProvider.class;
	}
}
