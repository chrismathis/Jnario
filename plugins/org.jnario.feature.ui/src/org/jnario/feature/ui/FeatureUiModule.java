/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/*
 * generated by Xtext
 */
package org.jnario.feature.ui;

import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.EclipseSourceFolderProvider;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.JDTAwareSourceFolderProvider;
import org.eclipse.xtext.builder.trace.TraceForStorageProvider;
import org.eclipse.xtext.common.types.ui.navigation.IDerivedMemberAwareEditorOpener;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalPriorities;
import org.eclipse.xtext.ui.editor.contentassist.IContextInformationProvider;
import org.eclipse.xtext.ui.editor.copyqualifiedname.CopyQualifiedNameService;
import org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingStructureProvider;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.resource.IResourceUIServiceProvider;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.imports.ConflictResolver;
import org.eclipse.xtext.xbase.imports.ImportOrganizer;
import org.eclipse.xtext.xbase.ui.contentassist.ImportingTypesProposalProvider;
import org.eclipse.xtext.xbase.ui.contentassist.ParameterContextInformationProvider;
import org.eclipse.xtext.xbase.ui.contentassist.XbaseContentProposalPriorities;
import org.eclipse.xtext.xbase.ui.editor.XbaseResourceForEditorInputFactory;
import org.eclipse.xtext.xbase.ui.file.EclipseFileSystemSupportImpl;
import org.eclipse.xtext.xbase.ui.file.EclipseWorkspaceConfigProvider;
import org.eclipse.xtext.xbase.ui.hover.XbaseDeclarativeHoverSignatureProvider;
import org.eclipse.xtext.xbase.ui.jvmmodel.navigation.DerivedMemberAwareEditorOpener;
import org.eclipse.xtext.xbase.ui.launching.JavaElementDelegate;
import org.eclipse.xtext.xbase.ui.validation.XbaseIssueSeveritiesProvider;
import org.jnario.feature.linking.FeatureLazyLinker;
import org.jnario.feature.ui.autoedit.FeatureAutoEditStrategyProvider;
import org.jnario.feature.ui.autoedit.FeatureIndentLineAutoEditStrategy;
import org.jnario.feature.ui.editor.FeatureDoubleClickStrategyProvider;
import org.jnario.feature.ui.editor.FeatureEditor;
import org.jnario.feature.ui.editor.FeatureFoldingRegionProvider;
import org.jnario.feature.ui.editor.FeatureFoldingStructureProvider;
import org.jnario.feature.ui.editor.FeatureTokenTypeToPartitionTypeMapper;
import org.jnario.feature.ui.generator.FeatureGenerator;
import org.jnario.feature.ui.highlighting.FeatureHighlightingConfiguration;
import org.jnario.feature.ui.highlighting.FeatureSemanticHighlightingCalculator;
import org.jnario.feature.ui.highlighting.FeatureTokenHighlighting;
import org.jnario.feature.ui.hover.FeatureHoverProvider;
import org.jnario.feature.ui.hover.FeatureHoverSignatureProvider;
import org.jnario.feature.ui.imports.FeatureConflictResolver;
import org.jnario.feature.ui.imports.FeatureImportOrganizer;
import org.jnario.feature.ui.labeling.FeatureLabelProvider;
import org.jnario.feature.ui.launching.FeatureJavaElementDelegate;
import org.jnario.feature.ui.parser.CustomFeatureLexer;
import org.jnario.feature.ui.validator.FeatureUIValidator;
import org.jnario.ide.JnarioResourceUiServiceProvider;
import org.jnario.ui.builder.JnarioBuilderParticipant;
import org.jnario.ui.builder.JnarioSourceRelativeFileSystemAccess;
import org.jnario.ui.editor.XtendCopyQualifiedNameService;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * @author Birgit Engelmann - Initial contribution and API
 * @author Sebastian Benz 
 */
public class FeatureUiModule extends org.jnario.feature.ui.AbstractFeatureUiModule {
	public FeatureUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
// TODO NO_XTEND
//	@Override
//	public Class<? extends IOccurrenceComputer> bindIOccurrenceComputer() {
//		return OccurrenceComputer.class;
//	}

// TODO NO_XTEND
//	
//	@Override
//	public void configureIPreferenceStoreInitializer(Binder binder) {
//		binder.bind(IPreferenceStoreInitializer.class)
//			.annotatedWith(Names.named("RefactoringPreferences"))
//			.to(XtendRefactoringPreferences.Initializer.class);
//	}
//
//	@Override
//	public Class<? extends IRenameContextFactory> bindIRenameContextFactory() {
//		return XtendRenameContextFactory.class;
//	}
//
//	public Class<? extends RenameElementProcessor> bindRenameElementProcessor() {
//		return XtendRenameElementProcessor.class;
//	}
//
//	@Override
//	public Class<? extends IRenameStrategy> bindIRenameStrategy() {
//		return XtendRenameStrategy.class;
//	}
//
//	@Override
//	public java.lang.Class<? extends IDependentElementsCalculator> bindIDependentElementsCalculator() {
//		return XtendDependentElementsCalculator.class;
//	}
//	
//	@Override
//	public void configureJvmMemberRenameStrategy$Provider$Delegate(Binder binder) {
//		binder.bind(IRenameStrategy.Provider.class)
//			.annotatedWith(JvmMemberRenameStrategy.Provider.Delegate.class)
//			.to(XtendRenameStrategyProvider.class);
//	}
//		
//	public Class<? extends JdtRenameRefactoringParticipantProcessor> bindJdtRenameRefactoringParticipantProcessor() {
//		return XtendJdtRenameParticipantProcessor.class;
//	}

	public Class<? extends XbaseDeclarativeHoverSignatureProvider> bindXbaseDeclarativeHoverSignatureProvider(){
		return FeatureHoverSignatureProvider.class;
	}
	
// TODO NO_XTEND
//	@Override
//	public Class<? extends IEObjectHoverDocumentationProvider> bindIEObjectHoverDocumentationProvider(){
//		return XtendHoverDocumentationProvider.class;
//	}
//
//	
//	@Override
//	public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
//		return TemplateProposalProvider.class;
//	}
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(EclipseSourceFolderProvider.class).to(JDTAwareSourceFolderProvider.class);
		binder.bind(DefaultIndentLineAutoEditStrategy.class).to(FeatureIndentLineAutoEditStrategy.class);
// TODO NO_XTEND
//		binder.bind(CreateXtendTypeQuickfixes.class).to(CreateJnarioTypeQuickfixes.class);
//		binder.bind(CreateMemberQuickfixes.class).to(FeatureCreateMemberQuickfixes.class);
//		binder.bind(CodeBuilderFactory.class).to(JnarioCodeBuilderFactory.class);
		binder.bind(ImportOrganizer.class).to(FeatureImportOrganizer.class);
		binder.bind(ConflictResolver.class).to(FeatureConflictResolver.class);
	}

	public void configureDebugMode(Binder binder) {
		if (Boolean.getBoolean("org.eclipse.xtext.xtend.debug")) {
			binder.bindConstant().annotatedWith(Names.named(AbstractEditStrategy.DEBUG)).to(true);
		}
		// matches ID of org.eclipse.ui.contexts extension registered in plugin.xml
		binder.bindConstant().annotatedWith(Names.named(XtextEditor.KEY_BINDING_SCOPE)).to("org.jnario.feature.ui.FeatureEditorScope");
	}
	
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return FeatureHighlightingConfiguration.class;
	}
	
// TODO NO_XTEND
//	public void configureOverrideIndicatorSupport(Binder binder) {
//		binder.bind(IXtextEditorCallback.class).annotatedWith(Names.named("OverrideIndicatorModelListener")) //$NON-NLS-1$
//				.to(OverrideIndicatorModelListener.class);
//		binder.bind(IActionContributor.class).annotatedWith(Names.named("OverrideIndicatorRulerAction")).to( //$NON-NLS-1$
//				OverrideIndicatorRulerAction.class);
//	}
	
	@Override
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return FeatureSemanticHighlightingCalculator.class;
	}
	
	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return FeatureTokenHighlighting.class;
	}

// TODO NO_XTEND
//	@Override
//	public Class<? extends ITokenScanner> bindITokenScanner() {
//		return RichStringAwareTokenScanner.class;
//	}

//	public void configureIShowWhitespaceCharactersActionContributor(Binder binder) {
//		binder.bind(IActionContributor.class).annotatedWith(Names.named("Show Whitespace"))
//				.to(ShowWhitespaceCharactersActionContributor.class);
//	}
	
	public Class<? extends ITokenTypeToPartitionTypeMapper> bindITokenTypeToPartitionTypeMapper() {
		return FeatureTokenTypeToPartitionTypeMapper.class;
	}

	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return FeatureAutoEditStrategyProvider.class;
	}

	public Class<? extends DoubleClickStrategyProvider> bindDoubleClickStrategyProvider() {
		return FeatureDoubleClickStrategyProvider.class;
	}
	
// TODO NO_XTEND
//	@Override
//	public Class<? extends IComparator> bindOutlineFilterAndSorter$IComparator() {
//		return XtendOutlineNodeComparator.class;
//	}
//
//	public Class<? extends QuickOutlineFilterAndSorter> bindQuickOutlineFilterAndSorter() {
//		return XtendQuickOutlineFilterAndSorter.class;
//	}

	public Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider() {
		return FeatureFoldingRegionProvider.class;
	}

	@Override
	public Class<? extends ITypesProposalProvider> bindITypesProposalProvider() {
		return ImportingTypesProposalProvider.class;
	}

// TODO NO_XTEND
//	@Override
//	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
//		return XtendOutlinePage.class;
//	}
//
//	@Override
//	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
//		return XtendHyperlinkHelper.class;
//	}

	public Class<? extends EclipseResourceFileSystemAccess2> bindEclipseResourceFileSystemAccess2() {
		return JnarioSourceRelativeFileSystemAccess.class;
	}
	
	@Override
	public Class<? extends IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return JnarioBuilderParticipant.class;
	}
	
// TODO NO_XTEND
//	@Override
//	public Class<? extends ISingleLineCommentHelper> bindISingleLineCommentHelper() {
//		return SingleLineCommentHelper.class;
//	}
	
	
	public Class<? extends IFoldingStructureProvider> bindIFoldingStructureProvider(){
		return FeatureFoldingStructureProvider.class;
	}
	
	@Override
	public Class<? extends IContentFormatterFactory> bindIContentFormatterFactory() {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=361385
		return null;
	}
	
	
// TODO NO_XTEND
//	@Override
//	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
//		return XtendNatureAddingEditorCallback.class;
//	}
//	
//	public Class<? extends IResourceUIServiceProvider> bindIResourceUIServiceProvider() {
//		return XtendResourceUiServiceProvider.class;
//	}
	
	@Override
	public void configureLanguageSpecificURIEditorOpener(Binder binder) {
		if (PlatformUI.isWorkbenchRunning()) {
			binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class)
					.to(DerivedMemberAwareEditorOpener.class);
			binder.bind(IDerivedMemberAwareEditorOpener.class).to(DerivedMemberAwareEditorOpener.class);
		}
	}
	
	@Override
	public ICharacterPairMatcher bindICharacterPairMatcher() {
		return new DefaultCharacterPairMatcher(new char[] { '(', ')', '{', '}', '[', ']', '«', '»' });
	}

// TODO NO_XTEND
//	public Class<? extends XtextSourceViewer.Factory> bindSourceViewerFactory() {
//		return RichStringAwareSourceViewer.Factory.class;
//	}
//	
//	public Class<? extends ToggleSLCommentAction.Factory> bindToggleCommentFactory() {
//		return RichStringAwareToggleCommentAction.Factory.class;
//	}
	
	public Class<? extends org.eclipse.xtext.ui.editor.XtextEditor> bindXtextEditor() {
		return FeatureEditor.class;
	}
	
	
	public Class<? extends JavaElementDelegate> bindJavaElementDelegate(){
		return FeatureJavaElementDelegate.class;
	}
	
	public Class<? extends ITraceForStorageProvider> bindTraceInformation() {
		return TraceForStorageProvider.class;
	}
	
	public Class<? extends IGenerator> bindIGenerator() {
		return FeatureGenerator.class;
	}
	
	@Override
	public void configureContentAssistLexer(Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST)).to(CustomFeatureLexer.class);
	}
	
	@Override
	public void configureContentAssistLexerProvider(Binder binder) {
		binder.bind(org.jnario.feature.ui.contentassist.antlr.internal.InternalFeatureLexer.class).toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(CustomFeatureLexer.class));
	}
	
	@Override
	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return FeatureHoverProvider.class;
	}
	
// TODO NO_XTEND
//	@Override
//	public Class<? extends IContentAssistantFactory> bindIContentAssistantFactory() {
//		return XtendContentAssistFactory.class;
//	}
	
	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return XbaseResourceForEditorInputFactory.class;
	}
	
	public Class<? extends IContextInformationProvider> bindIContextInformationProvider() {
		return ParameterContextInformationProvider.class;
	}
	
// TODO NO_XTEND
//	public Class<? extends PrefixMatcher.CamelCase> bindCamelCasePrefixMatcher() {
//		return EscapeSequenceAwarePrefixMatcher.class;
//	}
//	
//	public Class<? extends IFormattingPreferenceValuesProvider> bindIFormattingPreferenceValuesProvider() {
//		return FormatterPreferenceValuesProvider.class;
//	}
	
	

// TODO NO_XTEND
//	@Override
//	public Class<? extends IAnnotationHover> bindIAnnotationHover() {
//		return XtendAnnotationHover.class;
//	}
//
//	public Class<? extends TerminalsTokenTypeToPartitionMapper> bindTerminalsTokenTypeToPartitionMapper() {
//		return TokenTypeToPartitionMapper.class;
//	}
//
//	public void configureIShowWhitespaceCharactersActionContributor(Binder binder) {
//		binder.bind(IActionContributor.class).annotatedWith(Names.named("Show Whitespace"))
//				.to(ShowWhitespaceCharactersActionContributor.class);
//	}
//
//
//	public Class<? extends IEditedResourceProvider> bindIEditedResourceProvider() {
//		return FormatterResourceProvider.class;
//	}
//
//	public void configureFilterSyntheticMembersContribution(Binder binder) {
//		binder.bind(IOutlineContribution.class).annotatedWith(Names.named("FilterSyntheticsContribution"))
//				.to(ShowSyntheticMembersContribution.class);
//	}

	@Override
	@org.eclipse.xtext.service.SingletonBinding(eager = true)
	public Class<? extends org.eclipse.xtext.xbase.ui.validation.XbaseUIValidator> bindXbaseUIValidator() {
		return FeatureUIValidator.class;
	}
	
// TODO NO_XTEND
//	@SingletonBinding(eager = true)
//	public Class<? extends JavaProjectPreferencesInitializer> bindJavaProjectPreferencesInitializer() {
//		return JavaProjectPreferencesInitializer.class;
//	}
//
//	@Override
//	public void configureSmartCaretPreferenceInitializer(Binder binder) {
//		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(Names.named("smartCaretPreferenceInitializer")) //$NON-NLS-1$
//				.to(XtendPreferenceStoreInitializer.class);
//	}
	
	public Class<? extends IssueSeveritiesProvider> bindIssueSeverityServiceProvider() {
		return XbaseIssueSeveritiesProvider.class;
	}
	
	// TODO NO_XTEND
//	public Class<? extends XtextSourceViewerConfiguration> bindSourceViewerConfiguration(){
//		return XtendSourceViewerConfiguration.class;
//	}

	@Override
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return FeatureLabelProvider.class;
	}

// TODO NO_XTEND
//	public Class<? extends ResourceDescriptionsProvider> bindResourceDescriptionsProvider() {
//		return XtendResourceDescriptionsProvider.class;
//	}
	
	public Class<? extends IReferenceFinder> bindIReferenceFinder() {
		return org.jnario.ui.findrefs.XtendReferenceFinder.class;
	}
	
	
// TODO NO_XTEND
//	public Class<? extends JavaTypeQuickfixes> bindJavaTypeQuickfixes() {
//		return TypeLiteralAwareJavaTypeQuickfixes.class;
//	}
//	
//	public Class<? extends ICompletionProposalComparator> bindICompletionProposalComparator() {
//		return OperatorAwareComparator.class;
//	}
	
	public Class<? extends MutableFileSystemSupport> bindFileSystemSupport() {
		return AbstractFileSystemSupport.class;
	}
	
	public Class<? extends AbstractFileSystemSupport> bindAbstractFileSystemSupport() {
		return EclipseFileSystemSupportImpl.class;
	}
	
	public void configureWorkspaceConfigContribution(Binder binder) {
		binder.bind(WorkspaceConfig.class).toProvider(EclipseWorkspaceConfigProvider.class);
	}
	
	@Override
	public Class<? extends CopyQualifiedNameService> bindCopyQualifiedNameService() {
		return XtendCopyQualifiedNameService.class;
	}

	public Class<? extends IContentProposalPriorities> bindIContentProposalPriorities() {
		return XbaseContentProposalPriorities.class;
	}
	
// TODO NO_XTEND
//	public Class<? extends ExpressionUtil> bindExpressionUtil() {
//		return XtendExpressionUtil.class;
//	}
	
	public Class<? extends ILinker> bindILinker() {
		return FeatureLazyLinker.class;
	}
	
// TODO NO_XTEND
//	public Class<? extends OutlineWithEditorLinker> bindOutlineWithEditorLinker() {
//		return XtendOutlineWithEditorLinker.class;
//	}
//	
//	public Class<? extends IOutlineTreeProvider.ModeAware> bindIOutlineTreeProvider_ModeAware() {
//		return org.eclipse.xtend.ide.outline.XtendOutlineModes.class;
//	}
//
//	public Class<? extends OutlineNodeFactory> bindOutlineNodeFactory() {
//		return XtendOutlineNodeFactory.class;
//	}

	
	public Class<? extends IResourceUIServiceProvider> bindIResourceUIServiceProvider() {
		return JnarioResourceUiServiceProvider.class;
	}

}