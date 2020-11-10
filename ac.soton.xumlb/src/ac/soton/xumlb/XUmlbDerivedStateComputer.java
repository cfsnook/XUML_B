/*******************************************************************************
 * Copyright (c) 2020 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     University of Southampton - initial API and implementation
 *******************************************************************************/
package ac.soton.xumlb;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.emf.diagrams.Diagram;
import ac.soton.eventb.emf.diagrams.UMLB;
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.impl.TransitionImpl;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.impl.AssociationImpl;
/**
 * <p>
 * Use this class to add some additional state to the AST model
 * </p>
 *
 * @author dd4g12
 * @version 0.1
 * @see 
 * @since 0.0.1
 */

public class XUmlbDerivedStateComputer implements IDerivedStateComputer {
	/* The derived states: are the EOpposite "incoming" & "outgoing"
	 * for abstract nodes which are derived from the source and 
	 * target of transitions.
	*/

	@Override
	public void installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
		if (!resource.getContents().isEmpty() ) {//&& preLinkingPhase
			UMLB umlb = (UMLB) resource.getContents().get(0);
			EList<Diagram> diagrams = umlb.getDiagrams();
			for(Diagram d : diagrams) {
				if(d instanceof Statemachine) {
					// set transition incoming and outgoing eopposite attributes
					setTransInOut((Statemachine) d);
					
				}
				else if (d instanceof Classdiagram) {
					//set eOpposite incoming outgoing attributes for assosciations
					setAssocInOut((Classdiagram) d);
				}
				
			}			
		}
			
	}

	@Override
	public void discardDerivedState(DerivedStateAwareResource resource) {
		// TODO Auto-generated method stub
		
	}
	
	
	private void setTransInOut(Statemachine sm) {
		//allTransitions include all transitions even in the sub-statemachines, however it includes some null values.
		 EList<EObject> allTransitions = sm.getAllContained(StatemachinesPackage.Literals.TRANSITION, true);
		for(EObject o: allTransitions) {
			
			if(o != null) {
				TransitionImpl trans = (TransitionImpl) o;
				final EObject proxy = EcoreUtil.create(StatemachinesPackage.Literals.TRANSITION);
				((InternalEObject) proxy).eSetProxyURI(EcoreUtil.getURI(trans));
				AbstractNode source = trans.getSource();
				if(source != null) 
					source.getOutgoing().add((Transition) proxy);
				
					
				AbstractNode target = trans.getTarget();
				if(target != null) 
					target.getIncoming().add((Transition) proxy);
			
			}
				
		}
		
	}
	
	private void setAssocInOut(Classdiagram cd) {
		//allAssoc include all associations  however it includes some null values.
		 EList<EObject> allAssoc = cd.getAllContained(ClassdiagramsPackage.Literals.ASSOCIATION, true);
		for(EObject o: allAssoc) {
			
			if(o != null) {
				AssociationImpl assoc = (AssociationImpl) o;
				final EObject proxy = EcoreUtil.create(ClassdiagramsPackage.Literals.ASSOCIATION);
				((InternalEObject) proxy).eSetProxyURI(EcoreUtil.getURI(assoc));
				
				Class source = assoc.getSource();
				if(source != null) 
					source.getOutgoing().add((Association) proxy);
				
					
				Class target = assoc.getTarget();
				if(target != null) 
					target.getIncoming().add((Association) proxy);
			
			}
				
		}
		
	}
	
}
