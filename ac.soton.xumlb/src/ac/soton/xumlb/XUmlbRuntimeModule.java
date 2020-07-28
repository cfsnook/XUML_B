/**
 * Copyright (c) 2020 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     University of Southampton - initial API and implementation
 */
package ac.soton.xumlb;

import org.eclipse.xtext.scoping.IScopeProvider;
import ac.soton.xumlb.scoping.XUmlbScopeProvider;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import ac.soton.xeventb.common.EventBValueConverter;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
/**
 * <p>
 * Use this class to register components for XUMLB to be used at runtime /
 * without the Equinox extension registry.
 * </p>
 * 
 * @author dd4g12
 * @version 0.1
 * @see
 * @since 0.0.1
 */
public class XUmlbRuntimeModule extends AbstractXUmlbRuntimeModule {
	/**
	 * Bind the scope provider, use for references for context seeing, machine
	 * refinement, event refinement, etc.
	 * 
	 * @see XUmlbScopeProvider
	 */
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return XUmlbScopeProvider.class;
	}
	
	/**
	 * Bind the derived state computer for XStatemachine
	 * The derived state: are the EOpposite: incoming and outgoing 
	 * for abstract nodes which are derived from the source and 
	 * target of transitions.
	 * 
	 * Also requires bindIResourceDescription$Manager & bindXtextResource
	 * 
	 * @see XUmlbDerivedStateComputer
	 */
	
	public Class<? extends IDerivedStateComputer> bindIDerivedStateComputer() {
		return XUmlbDerivedStateComputer.class;
	}
	
	public Class<? extends Manager> bindIResourceDescription$Manager() {
		return DerivedStateAwareResourceDescriptionManager.class;
	}
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return DerivedStateAwareResource.class;
	}
	
	/**
	 * Bind the value converter service for Event-B values, e.g., converting comments,
	 * labels, etc.
	 * 
	 * @see EventBValueConverter
	 */
	 @Override 
	 public Class<? extends IValueConverterService> bindIValueConverterService() {
		return EventBValueConverter.class;
	}
	 /**
	 * Bind the transient value service for XStatemachine, use for serialisation of
	 * EMF Event-B to XText.
	 * 
	 * @see XStatemachineTransientValueService
	 */
	 @Override 
	 public Class<? extends ITransientValueService> bindITransientValueService() {
		return XUmlbTransientValueService.class;
	}
}
