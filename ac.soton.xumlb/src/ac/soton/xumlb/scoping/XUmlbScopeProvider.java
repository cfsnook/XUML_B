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
package ac.soton.xumlb.scoping;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eventb.core.IContextRoot;
import org.eventb.core.IMachineRoot;
import org.eventb.core.IEventBProject;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.EventBNamedCommentedElement;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EMFRodinDB;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinDBException;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.diagrams.Diagram;
import ac.soton.eventb.emf.diagrams.DiagramsPackage;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.EventBSuperType;

import org.eclipse.xtext.EcoreUtil2;
import ac.soton.eventb.emf.diagrams.UMLB;
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;
import ac.soton.eventb.statemachines.Transition;
import ch.ethz.eventb.utils.EventBUtils;
import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.classdiagrams.Classdiagram;

import java.util.List;
/**
 * <p>
 * xumlb scope provider, in particular the scope for:
 * UMLB target 
 * statemachine instances, transition events,
 * ....
 * </p>
 *
 * @author DanaDghaym (dd4g12)
 * @version 0.1
 * @see EMFRodinDB
 * @since 0.0.1
 */

public class XUmlbScopeProvider extends AbstractXUmlbScopeProvider {

	@Override
	public IScope getScope(EObject context, EReference reference) {
		
		/********************************************
		 * UMLB Scoping
		 ********************************************/
		if(context instanceof UMLB && reference== DiagramsPackage.Literals.UMLB__ELABORATES) {
 			UMLB umlb = (UMLB) context;
			EMFRodinDB emfRodinDB = new EMFRodinDB();
			String prjName = emfRodinDB.getProjectName(umlb);
		    IEventBProject eBPrj = EventBUtils.getEventBProject(prjName);
		    IRodinProject rdPrj = eBPrj.getRodinProject();
		    IContextRoot[] ctxRoots;
		    IMachineRoot[] mchRoots;
			try {
				ctxRoots = rdPrj.<IContextRoot>getRootElementsOfType(IContextRoot.ELEMENT_TYPE);
				mchRoots = rdPrj.<IMachineRoot>getRootElementsOfType(IMachineRoot.ELEMENT_TYPE);
				ArrayList<EventBElement> ctxs = new ArrayList<EventBElement>();
		    
		        for (IMachineRoot mchRoot : mchRoots) {
		        	EventBElement mch = emfRodinDB.loadEventBComponent(mchRoot);
			        ctxs.add(mch);
			    }
		        for (IContextRoot ctxRoot : ctxRoots) {
		            EventBElement ctx = emfRodinDB.loadEventBComponent(ctxRoot);
		            ctxs.add(ctx);
		        }
		        return Scopes.scopeFor(ctxs);
			} catch (RodinDBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 
		    
		}
		/********************************************
		 * Statemachine scoping
		 ********************************************/
		// scoping for transition elaborates-- not sure if I need the statemachine as before
 		 if (context instanceof Transition && reference == CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ELABORATES) {
			EObject rootCont =   EcoreUtil2.getRootContainer(context, true);
			if (rootCont instanceof UMLB) {
				 EventBNamedCommentedComponentElement comp = ((UMLB) rootCont).getElaborates();
				 if(comp instanceof Machine) {
					 EList<Event> evts = ((Machine) comp).getEvents();
					 return Scopes.scopeFor(evts);
				 }
			}  
		} 
 		//scope for source & target abstract nodes
 		if (context instanceof Transition && (reference == StatemachinesPackage.Literals.TRANSITION__SOURCE || reference == StatemachinesPackage.Literals.TRANSITION__TARGET)) {
 			Transition tr = (Transition) context;
 			EObject eContainer = tr.eContainer();
 			if(eContainer instanceof Statemachine) {
 				Statemachine sm = (Statemachine) eContainer;
 				ArrayList<AbstractNode> nodes = new ArrayList<AbstractNode>();
// 				nodes.addAll(EcoreUtil2.getAllContentsOfType(sm, AbstractNode.class));
// 				nodes.addAll((Collection<? extends AbstractNode>) EcoreUtil2.getContainerOfType(sm, AbstractNode.class));
 			      nodes.addAll(EcoreUtil2.<AbstractNode>getAllContentsOfType(sm, AbstractNode.class));
 			      CollectionExtensions.<AbstractNode>addAll(nodes, EcoreUtil2.<AbstractNode>getContainerOfType(sm, AbstractNode.class));
 				return Scopes.scopeFor(nodes);
 			}
        }
 		
 		//scope for statemachine instances
		 if (context instanceof Statemachine && reference == StatemachinesPackage.Literals.STATEMACHINE__INSTANCES ) {
			 EObject rootCont =   EcoreUtil2.getRootContainer(context, true);
				if (rootCont instanceof UMLB) {
					 EventBNamedCommentedComponentElement comp = ((UMLB) rootCont).getElaborates();
					 List<EventBNamedCommentedComponentElement> list = getComponentsInScope(comp);
					 List<EventBNamedCommentedElement> instances =  new ArrayList<EventBNamedCommentedElement>();
					 for(EventBNamedCommentedComponentElement elem : list) {
						 if(elem instanceof Context) {
							 Context ctxt = (Context) elem;
							 instances.addAll(ctxt.getSets());
							 instances.addAll(ctxt.getConstants());
						 }
					 }
					 return Scopes.scopeFor(instances);
				}			
			}
		 
	 		// scoping for statemachine refines
 		 if (context instanceof Statemachine && reference == StatemachinesPackage.Literals.STATEMACHINE__REFINES) {
			EObject rootCont =   EcoreUtil2.getRootContainer(context, true);
			if (rootCont instanceof UMLB) {
				 UMLB umlbRefines = ((UMLB) rootCont).getRefines();
				 if(umlbRefines != null) {
					   EList<Diagram> diagrams = umlbRefines.getDiagrams();
					   List <Statemachine> smDiagrams = new ArrayList <Statemachine>();
					   for(Diagram d : diagrams) {
						   if (d instanceof Statemachine)
							   smDiagrams.add((Statemachine) d);
					   }
					   return Scopes.scopeFor(smDiagrams);
				 }
			}  
		} 
 		 
   		// scoping for State refines
  		 if (context instanceof State && reference ==StatemachinesPackage.Literals.STATE__REFINES) {
  			 EObject eContainer = context.eContainer();
  			 if (eContainer instanceof Statemachine) {
 				 Statemachine smRefines = ((Statemachine) eContainer).getRefines();
 				 if(smRefines != null) {
 					   List<State> states = EcoreUtil2.<State>getAllContentsOfType((EObject)smRefines, State.class);
 					   return Scopes.scopeFor(states);
 				 }
 			}  
 		} 
 		/********************************************
 		 * Classdiagram scoping
 		 ********************************************/
 		// scoping for Class elaborates
 		 if (context instanceof Class && reference == CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES) {
 			 Class cs = (Class) context;
 			 DataKind dataKind = cs.getDataKind();
 			 EObject rootCont =   EcoreUtil2.getRootContainer(context, true);
 			 if (rootCont instanceof UMLB) {
 				 EventBNamedCommentedComponentElement comp = ((UMLB) rootCont).getElaborates();
 				 return Scopes.scopeFor(getElemementsOfDatakind(comp, dataKind)); 
 			 } 
		} // end of class elaborate
 		 
  		// scoping for Assosiation elaborates
 		 if (context instanceof Association && reference == CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES) {
 			 Association assoc = (Association) context;
 			 DataKind dataKind = assoc.getDataKind();
 			 EObject rootCont =   EcoreUtil2.getRootContainer(context, true);
 			 if (rootCont instanceof UMLB) {
 				 EventBNamedCommentedComponentElement comp = ((UMLB) rootCont).getElaborates();
 				 return Scopes.scopeFor(getElemementsOfDatakind(comp, dataKind)); 
 			 } 
		}
 		// scoping for Attribute elaborates
 		 if (context instanceof ClassAttribute && reference == CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES) {
 			ClassAttribute att = (ClassAttribute) context;
 			 DataKind dataKind = att.getDataKind();
 			 EObject rootCont =   EcoreUtil2.getRootContainer(context, true);
 			 if (rootCont instanceof UMLB) {
 				 EventBNamedCommentedComponentElement comp = ((UMLB) rootCont).getElaborates();
 				 return Scopes.scopeFor(getElemementsOfDatakind(comp, dataKind)); 
 			 } 
		}
 		 //scoping for class constraint component
 		 if (context instanceof ClassConstraint && reference == ClassdiagramsPackage.Literals.CLASS_CONSTRAINT__COMPONENT) {
 			 EObject rootCont =   EcoreUtil2.getRootContainer(context, true);
 			 if (rootCont instanceof UMLB) {
 				 EventBNamedCommentedComponentElement target = ((UMLB) rootCont).getElaborates();
 				return Scopes.scopeFor(getComponentsInScope(target));
 			 }
 		 }
 		 
 		 //scoping for supertype in class
 		 if (context instanceof Class && reference == ClassdiagramsPackage.Literals.CLASS__SUPERTYPES) {
 			 Class cs = (Class) context;
 			 EObject eContainer = cs.eContainer();
 			 if (eContainer instanceof Classdiagram) {
 				Classdiagram cd = (Classdiagram) eContainer;
 			    EList<Class> classes = cd.getClasses();
 			    List <EventBSuperType> superTypes = new ArrayList<EventBSuperType>() ;
 			    superTypes.addAll(classes);
 			    for(Class c : classes) {
 			    	 superTypes.addAll(c.getSubtypeGroups());
 			    }
 				return Scopes.scopeFor(superTypes);
 			 }
 		 }
 		 
 		 //scoping for association source and target
 		 if (context instanceof Association && (reference == ClassdiagramsPackage.Literals.ASSOCIATION__SOURCE || reference == ClassdiagramsPackage.Literals.ASSOCIATION__TARGET)) {
 			Association assoc = (Association) context;
 			 EObject eContainer = assoc.eContainer();
 			 if (eContainer instanceof Classdiagram) {
 				Classdiagram cd = (Classdiagram) eContainer;
 				return Scopes.scopeFor(cd.getClasses());
 			 }
 		 }
 		// scoping for Method elaborates-- not sure if I need the statemachine as before
 		 if (context instanceof ClassMethod && reference == CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__ELABORATES) {
			EObject rootCont =   EcoreUtil2.getRootContainer(context, true);
			if (rootCont instanceof UMLB) {
				 EventBNamedCommentedComponentElement comp = ((UMLB) rootCont).getElaborates();
				 if(comp instanceof Machine) {
					 EList<Event> evts = ((Machine) comp).getEvents();
					 return Scopes.scopeFor(evts);
				 }
			}  
		} 
 		// scoping for classdiagram refines
 		 if (context instanceof Classdiagram && reference == ClassdiagramsPackage.Literals.CLASSDIAGRAM__REFINES) {
			EObject rootCont =   EcoreUtil2.getRootContainer(context, true);
			if (rootCont instanceof UMLB) {
				 UMLB umlbRefines = ((UMLB) rootCont).getRefines();
				 if(umlbRefines != null) {
					   EList<Diagram> diagrams = umlbRefines.getDiagrams();
//					   List<Classdiagram> classdiagrams = EcoreUtil2.<Classdiagram>getAllContentsOfType((EObject)diagrams, Classdiagram.class);
					   List <Classdiagram> classdiagrams = new ArrayList <Classdiagram>();
					   for(Diagram d : diagrams) {
						   if (d instanceof Classdiagram)
							   classdiagrams.add((Classdiagram) d);
					   }
					   return Scopes.scopeFor(classdiagrams);
				 }
			}  
		} 
 		 
  		// scoping for Class refines
 		 if (context instanceof Class && reference == ClassdiagramsPackage.Literals.CLASS__REFINES) {
 			 EObject eContainer = context.eContainer();
 			 if (eContainer instanceof Classdiagram) {
				 Classdiagram cdRefines = ((Classdiagram) eContainer).getRefines();
				 if(cdRefines != null) {
//					   EList<Diagram> diagrams = umlbRefines.getDiagrams();
					   List<Class> classes = EcoreUtil2.<Class>getAllContentsOfType((EObject)cdRefines, Class.class);
//					   List <Classdiagram> classdiagrams = new ArrayList <Classdiagram>();
//					   for(Diagram d : diagrams) {
//						   if (d instanceof Classdiagram)
//							   classdiagrams.add((Classdiagram) d);
//					   }
					   return Scopes.scopeFor(classes);
				 }
			}  
		} 
 		 
 		return super.getScope(context, reference);
	}
	
	/********************************************
	 * Methods that supports scoping
	 ********************************************/
	
	/**
	 * This gets all Event-B components that are in scope of the one passed as input
	 * i.e. the input itself as well as the closure of all seen or extended contexts 
	 * 
	 * @see ac.soton.eventb.emf.diagrams.sheet.AbstractIumlbPropertySection
	 */
	private List<EventBNamedCommentedComponentElement> getComponentsInScope(EventBObject eventBObject) {
		List<EventBNamedCommentedComponentElement> list =  new ArrayList<EventBNamedCommentedComponentElement>() ;
		if (eventBObject instanceof Machine){
			Machine m = ((Machine)eventBObject);
			list.add(m);
			for (Context c : m.getSees()){
				list.addAll(getComponentsInScope(c));
			}			
		}else if (eventBObject instanceof Context){
			Context c = ((Context)eventBObject);
			list.add(c);
			for (Context x : c.getExtends()){
				list.addAll(getComponentsInScope(x));
			}
		}
		return list;
	}
	
	// This gets the Event-B elements according to the datakind
	private List<EventBNamedCommentedElement> getElemementsOfDatakind(EventBNamedCommentedComponentElement comp, DataKind dataKind){
		List<EventBNamedCommentedElement> list =  new ArrayList<EventBNamedCommentedElement>() ;
			if(dataKind == DataKind.VARIABLE) {
				if (comp instanceof Machine) {
					list.addAll( ((Machine) comp).getVariables());	
				}
			} // end variable
			else {
				List<EventBNamedCommentedComponentElement> ctxts = getComponentsInScope(comp);
				if(dataKind == DataKind.SET) {
					for (EventBNamedCommentedComponentElement elem : ctxts) {
						if(elem instanceof Context) {
							Context ctxt = (Context) elem;
							list.addAll(ctxt.getSets());
						}
					}
				}// end of sets
				else if(dataKind == DataKind.CONSTANT) {
					for (EventBNamedCommentedComponentElement elem : ctxts) {
						if(elem instanceof Context) {
							Context ctxt = (Context) elem;
							list.addAll(ctxt.getConstants());
						}
					}				
				}// end of constants
			 }
		return list;
	}
}
