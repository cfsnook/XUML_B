/*******************************************************************************
* Copyright (c) 2020 University of Southampton.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* University of Southampton - initial API and implementation
*******************************************************************************/
package ac.soton.xumlb.ui.contentassist;
import ac.soton.xeventb.common.RodinSymbolsProposalProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
/**
 * * @author dd4g12
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
public class XUmlbProposalProvider extends AbstractXUmlbProposalProvider {
	@Override
	public void complete_ML_COMMENT(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
	RodinSymbolsProposalProvider.completeRodinSymbol(this, context, acceptor);
}

	@Override 
	public void complete_SL_COMMENT(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
	RodinSymbolsProposalProvider.completeRodinSymbol(this, context, acceptor);
}
	@Override 
	public void complete_XFormula(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
	RodinSymbolsProposalProvider.completeRodinSymbol(this, context, acceptor);
}
}
