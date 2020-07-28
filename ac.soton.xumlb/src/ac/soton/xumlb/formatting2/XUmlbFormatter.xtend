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
package ac.soton.xumlb.formatting2

import ac.soton.eventb.emf.diagrams.UMLB
import ac.soton.eventb.statemachines.Statemachine
import ac.soton.eventb.statemachines.Transition
import ac.soton.xumlb.services.XUmlbGrammarAccess
import com.google.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import ac.soton.eventb.emf.core.^extension.coreextension.TypedParameter
import org.eventb.emf.core.machine.Guard
import org.eventb.emf.core.machine.Witness
import org.eventb.emf.core.machine.Action
import ac.soton.eventb.statemachines.State
import org.eventb.emf.core.machine.Invariant
/**
 * <p>
 * XUmlbFormatter contains custom formatting details for
 * UMLB diagram
 * Statemachine
 * Classdiagram
 * </p>
 *
 * @author dd4g12
 * @since 1.0
 */

class XUmlbFormatter extends AbstractFormatter2 {
	
	@Inject extension XUmlbGrammarAccess

	def dispatch void format(UMLB uMLB, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (diagram : uMLB.diagrams) {
			diagram.format
		}
	}

	def dispatch void format(Statemachine statemachine, extension IFormattableDocument document) {
		// format HiddenRegions around keywords, attributes, cross references, etc. 
		// add new lines before and after some statemachine keywords
		statemachine.regionFor.keyword("annotates").prepend[newLine];
		statemachine.regionFor.keyword("refines").prepend[newLine]; // This might be removed depending on how we implement statemachine refinement
		statemachine.regionFor.keyword("instances").prepend[newLine]; // I didn't add for self name, it is related to instances
		
		// add new line after multi line comment
		statemachine.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
		
		for (abstractNode : statemachine.nodes) {
			abstractNode.format.prepend[newLine];
			
			// add new line after multi line comment
			statemachine.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
		}
		for (transition : statemachine.transitions) {
			// add new line before transition
			//transition.format.append[newLines=2];
			transition.format.prepend[newLine];
			
			// add new line after multi line comment
			statemachine.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
		}
	}
	
	def dispatch void format(Transition transition, extension IFormattableDocument document) {
		
		// add new lines before and after "transition" keyword
		transition.regionFor.keyword("transition").prepend[newLine].append[newLine];
		
		// add new lines before some transition keywords
        transition.regionFor.keyword("elaborates").prepend[newLine];
        transition.regionFor.keyword("extended").prepend[newLine];
        transition.regionFor.keyword("source").prepend[newLine];
        transition.regionFor.keyword("target").prepend[newLine];
        transition.regionFor.keyword("any").prepend[newLine];
        transition.regionFor.keyword("where").prepend[newLine];
        transition.regionFor.keyword("then").prepend[newLine];
        transition.regionFor.keyword("with").prepend[newLine];
        transition.regionFor.keyword("end").prepend[newLine];
        
        for (TypedParameter parameter : transition.parameters) {
			parameter.format.prepend[newLine]
			
			// add new line after multi line comment
			parameter.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
		}
				
		for (Guard guard : transition.guards) {
			guard.format.prepend[newLine]
			
			// add new line after multi line comment
			guard.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
		}
		
		for (Witness witness : transition.witnesses) {
			witness.format.prepend[newLine];
			
			// add new line after multi line comment
			witness.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
		}
		for (Action action : transition.actions) {
			action.format.prepend[newLine];
			
			// add new line after multi line comment
			action.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
		}
		
		//indent contents of transition
		val first = transition.regionFor.keyword("transition")
		val last = transition.regionFor.keyword("end")
		set(first.nextHiddenRegion, last.previousHiddenRegion) [indent]
		
	
		// indent the parameters
		if (!transition.parameters.empty){
			val firstPar= transition.parameters.head
			val lastPar= transition.parameters.last
			set(firstPar.regionForEObject.previousHiddenRegion, lastPar.regionForEObject.nextHiddenRegion) [indent]
		
		}
		
		// indent the guards
		if (!transition.guards.empty){
			val firstGrd= transition.guards.head
			val lastGrd= transition.guards.last
			set(firstGrd.regionForEObject.previousHiddenRegion, lastGrd.regionForEObject.nextHiddenRegion) [indent]
			
		}
		
		// indent the witnesses
		if (!transition.witnesses.empty){
			val firstWit= transition.witnesses.head
			val lastWit= transition.witnesses.last
			set(firstWit.regionForEObject.previousHiddenRegion, lastWit.regionForEObject.nextHiddenRegion) [indent]
		
		}
				
				
		// indent the actions
		if (!transition.actions.empty){
			val firstAct= transition.actions.head
			val lastAct= transition.actions.last.append[newLine]
			set(firstAct.regionForEObject.previousHiddenRegion, lastAct.regionForEObject.nextHiddenRegion) [indent]
		}
        
        // add new line after multi line comment
		transition.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
	}
	
	// Format State
	def dispatch void format(State state, extension IFormattableDocument document) {
		// add new lines before and after "State" keyword
		state.regionFor.keyword("State").prepend[newLine];
		
		// add new lines before some state keywords
        state.regionFor.keyword("refines").prepend[newLine]; // This depends if we keep refinement
//        state.regionFor.keyword("statemachines").prepend[newLine];
        state.regionFor.keyword("invariants").prepend[newLine];
        state.regionFor.keyword("entryActions").prepend[newLine];
        state.regionFor.keyword("exitActions").prepend[newLine];
        
        // add a line between the nested statemachines within a state
        for (Statemachine sm : state.statemachines) {
			sm.format.prepend[newLine]
			
			// add new line after multi line comment
			sm.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
		}
        
         // add a line between the invariants in the state
        for (Invariant inv : state.invariants) {
			inv.format.prepend[newLine]
			
			// add new line after multi line comment
			inv.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
		}
        
         // add a line between the entry actions in the state
        for (Action entry : state.entryActions) {
			entry.format.prepend[newLine]
			
			// add new line after multi line comment
			entry.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
		}
        
         // add a line between the exit actions in the state
        for (Action exit : state.exitActions) {
			exit.format.prepend[newLine]
			
			// add new line after multi line comment
			exit.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
		}
		
		// indent statemachines
		if (!state.statemachines.empty){
			val firstSm= state.statemachines.head
			val lastSm= state.statemachines.last
			set(firstSm.regionForEObject.previousHiddenRegion, lastSm.regionForEObject.nextHiddenRegion) [indent]	
		}
		
		// indent entry actions
		if (!state.entryActions.empty){
			val firstEntry= state.statemachines.head
			val lastEntry= state.statemachines.last
			set(firstEntry.regionForEObject.previousHiddenRegion, lastEntry.regionForEObject.nextHiddenRegion) [indent]	
		}
        
       // indent exit actions
		if (!state.exitActions.empty){
			val firstExit = state.statemachines.head
			val lastExit = state.statemachines.last
			set(firstExit.regionForEObject.previousHiddenRegion, lastExit.regionForEObject.nextHiddenRegion) [indent]	
		}
        
             // indent state invariants
		if (!state.invariants.empty){
			val first = state.invariants.head
			val last = state.invariants.last
			set(first.regionForEObject.previousHiddenRegion, last.regionForEObject.nextHiddenRegion) [indent]	
		}
        
        // add new line after multi line comment
		state.allRegionsFor.ruleCallTo(ML_COMMENTRule).append[newLine]
      
	}
	// TODO: implement for Classdiagram and its sub elements
}
