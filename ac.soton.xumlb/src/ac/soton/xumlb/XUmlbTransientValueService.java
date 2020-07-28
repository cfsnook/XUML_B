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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Witness;

import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;
import ac.soton.eventb.statemachines.Any;
import ac.soton.eventb.statemachines.Final;
import ac.soton.eventb.statemachines.Fork;
import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.Junction;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.emf.diagrams.DiagramsPackage;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassMethod;

/**
 * <p>
 * An implementation of transient value service in order to filter out
 * unsupported elements during serilisation of UMLB, Statemachine and Class diagram 
 * from their corresponding EMF.
 * </p>
 *
 * @author dd4g12
 * @version 0.1
 * @see
 * @since 0.0.1
 */
public class XUmlbTransientValueService extends DefaultTransientValueService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see DefaultTransientValueService#isTransient(EObject,
	 * EStructuralFeature, int)
	 */
	@Override
	public boolean isTransient(EObject owner, EStructuralFeature feature,
			int index) {
		// Ignore generated elements
		if (owner instanceof EventBElement
				&& ((EventBElement) owner).isGenerated()) {
			return true;
		}
		
		/********************************************
		 * UMLB Transient Values
		 ********************************************/
		if (owner instanceof Statemachine) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			if (feature.equals(DiagramsPackage.Literals.UMLB__ELABORATES))
				return false;
			if (feature.equals(DiagramsPackage.Literals.UMLB__REFINES))
				return false;
			if (feature.equals(DiagramsPackage.Literals.DIAGRAM_OWNER__DIAGRAMS))
				return false;
			return true;
			
		}
		/********************************************
		 * Statemachine Transient Values
		 ********************************************/
		// For statemachine, serialise only "name", "machine refinement",
		// "context seeing", "variables", "invariants", "variant" and "events"
		
		if (owner instanceof Statemachine) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
//			if (feature.equals(CorePackage.Literals.EVENT_BCOMMENTED__COMMENT))
//				return true;//return false; 
			if (feature.equals(StatemachinesPackage.Literals.STATEMACHINE__TRANSLATION))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.STATEMACHINE__REFINES))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.STATEMACHINE__INSTANCES))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.STATEMACHINE__SELF_NAME))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.STATEMACHINE__NODES))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.STATEMACHINE__TRANSITIONS))
				return false;
			
			return true;
		}
		
		// For invariant, serialise only "name"
		if (owner instanceof Initial) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
//			if (feature.equals(CorePackage.Literals.EVENT_BCOMMENTED__COMMENT))
//				return true;//return false;
			return true;
		}

		
		// For final, serialise only "name"
		if (owner instanceof Final) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			return true;
		}
		
		// For any, serialise only "name"
		if (owner instanceof Any) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			return true;
		}
		
		// For junction, serialise only "name"
		if (owner instanceof Junction) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			return true;
		}
		
		// For fork, serialise only "name"
		if (owner instanceof Fork) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			return true;
		}

		// For state, serialise only "name", "refines",
		// "invariants", "entry actions", "exit actions" and
		// "statemachine owner"
		//Dana: Updated to include Event Synchronisation
		if (owner instanceof State) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
//			if (feature.equals(CorePackage.Literals.EVENT_BCOMMENTED__COMMENT))
//				return true;//return false;
			if (feature.equals(StatemachinesPackage.Literals.STATE__REFINES))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.STATE__INVARIANTS))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.STATE__ENTRY_ACTIONS))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.STATE__EXIT_ACTIONS))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.STATEMACHINE_OWNER__STATEMACHINES))
				return false;
		
			return true;
		}
		
		// For transition, serialise only "name", "operations", "source", "target
		// "extended", "elaborate event", "refines", "parameters", "guards", "witnesses" and
		// "actions"
		//Dana: Updated to include Event Synchronisation
		if (owner instanceof Transition) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.TRANSITION__OPERATIONS))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.TRANSITION__TARGET))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.TRANSITION__SOURCE))
				return false;

			if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__EXTENDED))
				return false;
			if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ELABORATES))
				return false;
			if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ACTIONS))
			return false; 
			if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__GUARDS))
				return false;
			if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__PARAMETERS))
				return false;
			if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__REFINES))
				return false;
			if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__WITNESSES))
				return false;

			return true;
		}
		// For invariant, serialise only "name", "predicate",  and
		// "theorem".
		if (owner instanceof Invariant) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			if (feature
					.equals(CorePackage.Literals.EVENT_BPREDICATE__PREDICATE))
				return false;
			if (feature.equals(CorePackage.Literals.EVENT_BDERIVED__THEOREM))
				return false;
			return true;
		}
	
		// For Typed parameter, serialise only "name" and "type"
		if (owner instanceof TypedParameter) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			if (feature.equals(CoreextensionPackage.Literals.TYPE__TYPE))
				return false;//return false;
			return true;
		}
		

		// For guard, serialise only "name",  "predicate" and
		// "theorem".
		if (owner instanceof Guard) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			if (feature
					.equals(CorePackage.Literals.EVENT_BPREDICATE__PREDICATE))
				return false;
			if (feature.equals(CorePackage.Literals.EVENT_BDERIVED__THEOREM))
				return false;
			return true;
		}

		// For witness, serialise only "name" and "predicate" 
		if (owner instanceof Witness) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			if (feature
					.equals(CorePackage.Literals.EVENT_BPREDICATE__PREDICATE))
				return false;

			return true;
		}
		
		// For action, serialise only "name", "action" and "comment".
		if (owner instanceof Action) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			if (feature.equals(CorePackage.Literals.EVENT_BACTION__ACTION))
				return false;
			
			return true;
		}
		
		/********************************************
		 * Classdiagram Transient Values
		 ********************************************/
		if(owner instanceof Classdiagram) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			
			if (feature.equals(ClassdiagramsPackage.Literals.CLASSDIAGRAM__REFINES))
				return false;
			if (feature.equals(ClassdiagramsPackage.Literals.CLASSDIAGRAM__CLASSES))
				return false;
			if (feature.equals(ClassdiagramsPackage.Literals.CLASSDIAGRAM__ASSOCIATIONS))
				return false;
			return true;
		}
		
		// Class
		if(owner instanceof Class) {
			if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
				return false;
			if (feature.equals(CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__DATA_KIND))
				return false;
			if (feature.equals(CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES))
				return false;
			if (feature.equals(ClassdiagramsPackage.Literals.CLASS__SELF_NAME))
				return false;
			if (feature.equals(ClassdiagramsPackage.Literals.CLASS__INSTANCES))
				return false;
			if (feature.equals(ClassdiagramsPackage.Literals.CLASS__SUPERTYPES))
				return false;
			if (feature.equals(ClassdiagramsPackage.Literals.CLASS__REFINES))
				return false;
			if (feature.equals(StatemachinesPackage.Literals.STATEMACHINE_OWNER__STATEMACHINES))
				return false;
			if (feature.equals(ClassdiagramsPackage.Literals.CLASS__CLASS_ATTRIBUTES))
				return false;
			if (feature.equals(ClassdiagramsPackage.Literals.CLASS__CONSTRAINTS))
				return false;
			if (feature.equals(ClassdiagramsPackage.Literals.CLASS__METHODS))
				return false;
			if (feature.equals(ClassdiagramsPackage.Literals.CLASS__SUBTYPE_GROUPS))
				return false;		
			
			return true;
		}
		// Association
				if(owner instanceof Association) {
					if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__DATA_KIND))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BRELATION_KIND__FUNCTIONAL))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BRELATION_KIND__TOTAL))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BRELATION_KIND__SURJECTIVE))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BRELATION_KIND__INJECTIVE))
						return false;
					if (feature.equals(ClassdiagramsPackage.Literals.EVENT_BINITIALISABLE__INITIAL_VALUE))
						return false;
					if (feature.equals(ClassdiagramsPackage.Literals.ASSOCIATION__SOURCE))
						return false;
					if (feature.equals(ClassdiagramsPackage.Literals.ASSOCIATION__TARGET))
						return false;
						
					return true;
				}
				// Subtype group
				if(owner instanceof Association) {
					if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
						return false;
					if (feature.equals(ClassdiagramsPackage.Literals.SUBTYPE_GROUP__COVER))
						return false;
					if (feature.equals(ClassdiagramsPackage.Literals.SUBTYPE_GROUP__DISJOINT))
						return false;
					
//					// ToDo once updates
//					if (feature.equals(ClassdiagramsPackage.Literals.SUBTYPE_GROUP__SUBTYPES))
//						return false;
//						
					return true;
				}
				
				// Attribute
				if(owner instanceof ClassAttribute) {
					if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__DATA_KIND))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BRELATION_KIND__FUNCTIONAL))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BRELATION_KIND__TOTAL))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BRELATION_KIND__SURJECTIVE))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BRELATION_KIND__INJECTIVE))
						return false;
					if (feature.equals(ClassdiagramsPackage.Literals.EVENT_BINITIALISABLE__INITIAL_VALUE))
						return false;
					if (feature.equals(ClassdiagramsPackage.Literals.CLASS_ATTRIBUTE__TARGET))
						return false;
						
					return true;
				}
				// Attribute
				if(owner instanceof ClassConstraint) {
					if (feature.equals(CorePackage.Literals.EVENT_BNAMED__NAME))
						return false;
					if (feature.equals(CorePackage.Literals.EVENT_BPREDICATE__PREDICATE))
						return false;
					if (feature.equals(CorePackage.Literals.EVENT_BDERIVED__THEOREM))
						return false;
			
					if (feature.equals(ClassdiagramsPackage.Literals.CLASS_CONSTRAINT__COMPONENT))
						return false;
						
					return true;
				}
				//Class Method
				if(owner instanceof ClassMethod) {
					if (feature.equals(ClassdiagramsPackage.Literals.CLASS_METHOD__KIND))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__EXTENDED))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ELABORATES))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ACTIONS))
					return false; 
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__GUARDS))
						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__PARAMETERS))
						return false;
//					if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__REFINES))
//						return false;
					if (feature.equals(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__WITNESSES))
						return false;
						
					return true;
				}
				
		// Ignore other objects and features.
		return true;
	}
	
}
