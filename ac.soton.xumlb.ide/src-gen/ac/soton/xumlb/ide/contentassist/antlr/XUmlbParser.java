/*
 * generated by Xtext 2.22.0
 */
package ac.soton.xumlb.ide.contentassist.antlr;

import ac.soton.xumlb.ide.contentassist.antlr.internal.InternalXUmlbParser;
import ac.soton.xumlb.services.XUmlbGrammarAccess;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class XUmlbParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(XUmlbGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, XUmlbGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getXDiagramAccess().getAlternatives(), "rule__XDiagram__Alternatives");
			builder.put(grammarAccess.getAbstractNodeAccess().getAlternatives(), "rule__AbstractNode__Alternatives");
			builder.put(grammarAccess.getXComplexTypeAccess().getAlternatives(), "rule__XComplexType__Alternatives");
			builder.put(grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getAlternatives(), "rule__EVENT_B_BUILDIN_TYPE__Alternatives");
			builder.put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
			builder.put(grammarAccess.getXFormulaAccess().getAlternatives(), "rule__XFormula__Alternatives");
			builder.put(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getAlternatives(), "rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives");
			builder.put(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAlternatives(), "rule__EVENTB_PREDICATE_SYMBOLS__Alternatives");
			builder.put(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAlternatives(), "rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives");
			builder.put(grammarAccess.getTranslationKindAccess().getAlternatives(), "rule__TranslationKind__Alternatives");
			builder.put(grammarAccess.getMethodKindAccess().getAlternatives(), "rule__MethodKind__Alternatives");
			builder.put(grammarAccess.getDataKindAccess().getAlternatives(), "rule__DataKind__Alternatives");
			builder.put(grammarAccess.getXUMLBAccess().getGroup(), "rule__XUMLB__Group__0");
			builder.put(grammarAccess.getXUMLBAccess().getGroup_2(), "rule__XUMLB__Group_2__0");
			builder.put(grammarAccess.getXUMLBAccess().getGroup_3(), "rule__XUMLB__Group_3__0");
			builder.put(grammarAccess.getStatemachineAccess().getGroup(), "rule__Statemachine__Group__0");
			builder.put(grammarAccess.getStatemachineAccess().getGroup_6(), "rule__Statemachine__Group_6__0");
			builder.put(grammarAccess.getStatemachineAccess().getGroup_7(), "rule__Statemachine__Group_7__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup(), "rule__Transition__Group__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_2(), "rule__Transition__Group_2__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_8(), "rule__Transition__Group_8__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_8_2(), "rule__Transition__Group_8_2__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_9(), "rule__Transition__Group_9__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_10(), "rule__Transition__Group_10__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup_11(), "rule__Transition__Group_11__0");
			builder.put(grammarAccess.getTypedParameterAccess().getGroup(), "rule__TypedParameter__Group__0");
			builder.put(grammarAccess.getXTypeAccess().getGroup(), "rule__XType__Group__0");
			builder.put(grammarAccess.getXTypeAccess().getGroup_1(), "rule__XType__Group_1__0");
			builder.put(grammarAccess.getXComplexTypeAccess().getGroup_0(), "rule__XComplexType__Group_0__0");
			builder.put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
			builder.put(grammarAccess.getStateAccess().getGroup_3(), "rule__State__Group_3__0");
			builder.put(grammarAccess.getStateAccess().getGroup_4(), "rule__State__Group_4__0");
			builder.put(grammarAccess.getStateAccess().getGroup_5(), "rule__State__Group_5__0");
			builder.put(grammarAccess.getStateAccess().getGroup_6(), "rule__State__Group_6__0");
			builder.put(grammarAccess.getStateAccess().getGroup_7(), "rule__State__Group_7__0");
			builder.put(grammarAccess.getInitialAccess().getGroup(), "rule__Initial__Group__0");
			builder.put(grammarAccess.getFinalAccess().getGroup(), "rule__Final__Group__0");
			builder.put(grammarAccess.getAnyAccess().getGroup(), "rule__Any__Group__0");
			builder.put(grammarAccess.getJunctionAccess().getGroup(), "rule__Junction__Group__0");
			builder.put(grammarAccess.getForkAccess().getGroup(), "rule__Fork__Group__0");
			builder.put(grammarAccess.getClassdiagramAccess().getGroup(), "rule__Classdiagram__Group__0");
			builder.put(grammarAccess.getClassdiagramAccess().getGroup_3(), "rule__Classdiagram__Group_3__0");
			builder.put(grammarAccess.getClassAccess().getGroup(), "rule__Class__Group__0");
			builder.put(grammarAccess.getClassAccess().getGroup_6(), "rule__Class__Group_6__0");
			builder.put(grammarAccess.getClassAccess().getGroup_7(), "rule__Class__Group_7__0");
			builder.put(grammarAccess.getClassAccess().getGroup_8(), "rule__Class__Group_8__0");
			builder.put(grammarAccess.getClassAccess().getGroup_9(), "rule__Class__Group_9__0");
			builder.put(grammarAccess.getClassAccess().getGroup_10(), "rule__Class__Group_10__0");
			builder.put(grammarAccess.getClassAccess().getGroup_11(), "rule__Class__Group_11__0");
			builder.put(grammarAccess.getClassAccess().getGroup_15(), "rule__Class__Group_15__0");
			builder.put(grammarAccess.getAssociationAccess().getGroup(), "rule__Association__Group__0");
			builder.put(grammarAccess.getAssociationAccess().getGroup_6(), "rule__Association__Group_6__0");
			builder.put(grammarAccess.getAssociationAccess().getGroup_11(), "rule__Association__Group_11__0");
			builder.put(grammarAccess.getSubtypeGroupAccess().getGroup(), "rule__SubtypeGroup__Group__0");
			builder.put(grammarAccess.getClassAttributeAccess().getGroup(), "rule__ClassAttribute__Group__0");
			builder.put(grammarAccess.getClassAttributeAccess().getGroup_6(), "rule__ClassAttribute__Group_6__0");
			builder.put(grammarAccess.getClassAttributeAccess().getGroup_11(), "rule__ClassAttribute__Group_11__0");
			builder.put(grammarAccess.getClassConstraintAccess().getGroup(), "rule__ClassConstraint__Group__0");
			builder.put(grammarAccess.getClassMethodAccess().getGroup(), "rule__ClassMethod__Group__0");
			builder.put(grammarAccess.getClassMethodAccess().getGroup_4(), "rule__ClassMethod__Group_4__0");
			builder.put(grammarAccess.getClassMethodAccess().getGroup_6(), "rule__ClassMethod__Group_6__0");
			builder.put(grammarAccess.getClassMethodAccess().getGroup_6_2(), "rule__ClassMethod__Group_6_2__0");
			builder.put(grammarAccess.getClassMethodAccess().getGroup_7(), "rule__ClassMethod__Group_7__0");
			builder.put(grammarAccess.getClassMethodAccess().getGroup_8(), "rule__ClassMethod__Group_8__0");
			builder.put(grammarAccess.getClassMethodAccess().getGroup_9(), "rule__ClassMethod__Group_9__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGroup_32(), "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0");
			builder.put(grammarAccess.getInvariantAccess().getGroup(), "rule__Invariant__Group__0");
			builder.put(grammarAccess.getGuardAccess().getGroup(), "rule__Guard__Group__0");
			builder.put(grammarAccess.getActionAccess().getGroup(), "rule__Action__Group__0");
			builder.put(grammarAccess.getWitnessAccess().getGroup(), "rule__Witness__Group__0");
			builder.put(grammarAccess.getXUMLBAccess().getNameAssignment_1(), "rule__XUMLB__NameAssignment_1");
			builder.put(grammarAccess.getXUMLBAccess().getElaboratesAssignment_2_1(), "rule__XUMLB__ElaboratesAssignment_2_1");
			builder.put(grammarAccess.getXUMLBAccess().getRefinesAssignment_3_1(), "rule__XUMLB__RefinesAssignment_3_1");
			builder.put(grammarAccess.getXUMLBAccess().getDiagramsAssignment_4(), "rule__XUMLB__DiagramsAssignment_4");
			builder.put(grammarAccess.getStatemachineAccess().getNameAssignment_2(), "rule__Statemachine__NameAssignment_2");
			builder.put(grammarAccess.getStatemachineAccess().getTranslationAssignment_4(), "rule__Statemachine__TranslationAssignment_4");
			builder.put(grammarAccess.getStatemachineAccess().getRefinesAssignment_6_1(), "rule__Statemachine__RefinesAssignment_6_1");
			builder.put(grammarAccess.getStatemachineAccess().getInstancesAssignment_7_1(), "rule__Statemachine__InstancesAssignment_7_1");
			builder.put(grammarAccess.getStatemachineAccess().getSelfNameAssignment_7_3(), "rule__Statemachine__SelfNameAssignment_7_3");
			builder.put(grammarAccess.getStatemachineAccess().getNodesAssignment_8(), "rule__Statemachine__NodesAssignment_8");
			builder.put(grammarAccess.getStatemachineAccess().getTransitionsAssignment_9(), "rule__Statemachine__TransitionsAssignment_9");
			builder.put(grammarAccess.getTransitionAccess().getElaboratesAssignment_2_1(), "rule__Transition__ElaboratesAssignment_2_1");
			builder.put(grammarAccess.getTransitionAccess().getExtendedAssignment_3(), "rule__Transition__ExtendedAssignment_3");
			builder.put(grammarAccess.getTransitionAccess().getSourceAssignment_5(), "rule__Transition__SourceAssignment_5");
			builder.put(grammarAccess.getTransitionAccess().getTargetAssignment_7(), "rule__Transition__TargetAssignment_7");
			builder.put(grammarAccess.getTransitionAccess().getParametersAssignment_8_1(), "rule__Transition__ParametersAssignment_8_1");
			builder.put(grammarAccess.getTransitionAccess().getParametersAssignment_8_2_1(), "rule__Transition__ParametersAssignment_8_2_1");
			builder.put(grammarAccess.getTransitionAccess().getGuardsAssignment_9_1(), "rule__Transition__GuardsAssignment_9_1");
			builder.put(grammarAccess.getTransitionAccess().getActionsAssignment_10_1(), "rule__Transition__ActionsAssignment_10_1");
			builder.put(grammarAccess.getTransitionAccess().getWitnessesAssignment_11_1(), "rule__Transition__WitnessesAssignment_11_1");
			builder.put(grammarAccess.getTypedParameterAccess().getNameAssignment_0(), "rule__TypedParameter__NameAssignment_0");
			builder.put(grammarAccess.getTypedParameterAccess().getTypeAssignment_2(), "rule__TypedParameter__TypeAssignment_2");
			builder.put(grammarAccess.getStateAccess().getNameAssignment_2(), "rule__State__NameAssignment_2");
			builder.put(grammarAccess.getStateAccess().getRefinesAssignment_3_1(), "rule__State__RefinesAssignment_3_1");
			builder.put(grammarAccess.getStateAccess().getStatemachinesAssignment_4_2(), "rule__State__StatemachinesAssignment_4_2");
			builder.put(grammarAccess.getStateAccess().getStatemachinesAssignment_4_3(), "rule__State__StatemachinesAssignment_4_3");
			builder.put(grammarAccess.getStateAccess().getInvariantsAssignment_5_1(), "rule__State__InvariantsAssignment_5_1");
			builder.put(grammarAccess.getStateAccess().getEntryActionsAssignment_6_1(), "rule__State__EntryActionsAssignment_6_1");
			builder.put(grammarAccess.getStateAccess().getExitActionsAssignment_7_1(), "rule__State__ExitActionsAssignment_7_1");
			builder.put(grammarAccess.getInitialAccess().getNameAssignment_1(), "rule__Initial__NameAssignment_1");
			builder.put(grammarAccess.getFinalAccess().getNameAssignment_1(), "rule__Final__NameAssignment_1");
			builder.put(grammarAccess.getAnyAccess().getNameAssignment_1(), "rule__Any__NameAssignment_1");
			builder.put(grammarAccess.getJunctionAccess().getNameAssignment_1(), "rule__Junction__NameAssignment_1");
			builder.put(grammarAccess.getForkAccess().getNameAssignment_1(), "rule__Fork__NameAssignment_1");
			builder.put(grammarAccess.getClassdiagramAccess().getNameAssignment_2(), "rule__Classdiagram__NameAssignment_2");
			builder.put(grammarAccess.getClassdiagramAccess().getRefinesAssignment_3_1(), "rule__Classdiagram__RefinesAssignment_3_1");
			builder.put(grammarAccess.getClassdiagramAccess().getClassesAssignment_4(), "rule__Classdiagram__ClassesAssignment_4");
			builder.put(grammarAccess.getClassdiagramAccess().getAssociationsAssignment_5(), "rule__Classdiagram__AssociationsAssignment_5");
			builder.put(grammarAccess.getClassAccess().getNameAssignment_2(), "rule__Class__NameAssignment_2");
			builder.put(grammarAccess.getClassAccess().getDataKindAssignment_4(), "rule__Class__DataKindAssignment_4");
			builder.put(grammarAccess.getClassAccess().getElaboratesAssignment_6_1(), "rule__Class__ElaboratesAssignment_6_1");
			builder.put(grammarAccess.getClassAccess().getSelfNameAssignment_7_1(), "rule__Class__SelfNameAssignment_7_1");
			builder.put(grammarAccess.getClassAccess().getInstancesAssignment_8_1(), "rule__Class__InstancesAssignment_8_1");
			builder.put(grammarAccess.getClassAccess().getSupertypesAssignment_9_1(), "rule__Class__SupertypesAssignment_9_1");
			builder.put(grammarAccess.getClassAccess().getRefinesAssignment_10_1(), "rule__Class__RefinesAssignment_10_1");
			builder.put(grammarAccess.getClassAccess().getStatemachinesAssignment_11_2(), "rule__Class__StatemachinesAssignment_11_2");
			builder.put(grammarAccess.getClassAccess().getClassAttributesAssignment_12(), "rule__Class__ClassAttributesAssignment_12");
			builder.put(grammarAccess.getClassAccess().getConstraintsAssignment_13(), "rule__Class__ConstraintsAssignment_13");
			builder.put(grammarAccess.getClassAccess().getMethodsAssignment_14(), "rule__Class__MethodsAssignment_14");
			builder.put(grammarAccess.getClassAccess().getSubtypeGroupsAssignment_15_1(), "rule__Class__SubtypeGroupsAssignment_15_1");
			builder.put(grammarAccess.getAssociationAccess().getNameAssignment_2(), "rule__Association__NameAssignment_2");
			builder.put(grammarAccess.getAssociationAccess().getDataKindAssignment_4(), "rule__Association__DataKindAssignment_4");
			builder.put(grammarAccess.getAssociationAccess().getElaboratesAssignment_6_1(), "rule__Association__ElaboratesAssignment_6_1");
			builder.put(grammarAccess.getAssociationAccess().getFunctionalAssignment_7(), "rule__Association__FunctionalAssignment_7");
			builder.put(grammarAccess.getAssociationAccess().getTotalAssignment_8(), "rule__Association__TotalAssignment_8");
			builder.put(grammarAccess.getAssociationAccess().getSurjectiveAssignment_9(), "rule__Association__SurjectiveAssignment_9");
			builder.put(grammarAccess.getAssociationAccess().getInjectiveAssignment_10(), "rule__Association__InjectiveAssignment_10");
			builder.put(grammarAccess.getAssociationAccess().getInitialValueAssignment_11_1(), "rule__Association__InitialValueAssignment_11_1");
			builder.put(grammarAccess.getAssociationAccess().getSourceAssignment_13(), "rule__Association__SourceAssignment_13");
			builder.put(grammarAccess.getAssociationAccess().getTargetAssignment_15(), "rule__Association__TargetAssignment_15");
			builder.put(grammarAccess.getSubtypeGroupAccess().getNameAssignment_2(), "rule__SubtypeGroup__NameAssignment_2");
			builder.put(grammarAccess.getSubtypeGroupAccess().getCoverAssignment_3(), "rule__SubtypeGroup__CoverAssignment_3");
			builder.put(grammarAccess.getSubtypeGroupAccess().getDisjointAssignment_4(), "rule__SubtypeGroup__DisjointAssignment_4");
			builder.put(grammarAccess.getClassAttributeAccess().getNameAssignment_2(), "rule__ClassAttribute__NameAssignment_2");
			builder.put(grammarAccess.getClassAttributeAccess().getDataKindAssignment_4(), "rule__ClassAttribute__DataKindAssignment_4");
			builder.put(grammarAccess.getClassAttributeAccess().getElaboratesAssignment_6_1(), "rule__ClassAttribute__ElaboratesAssignment_6_1");
			builder.put(grammarAccess.getClassAttributeAccess().getFunctionalAssignment_7(), "rule__ClassAttribute__FunctionalAssignment_7");
			builder.put(grammarAccess.getClassAttributeAccess().getTotalAssignment_8(), "rule__ClassAttribute__TotalAssignment_8");
			builder.put(grammarAccess.getClassAttributeAccess().getSurjectiveAssignment_9(), "rule__ClassAttribute__SurjectiveAssignment_9");
			builder.put(grammarAccess.getClassAttributeAccess().getInjectiveAssignment_10(), "rule__ClassAttribute__InjectiveAssignment_10");
			builder.put(grammarAccess.getClassAttributeAccess().getInitialValueAssignment_11_1(), "rule__ClassAttribute__InitialValueAssignment_11_1");
			builder.put(grammarAccess.getClassAttributeAccess().getTargetAssignment_13(), "rule__ClassAttribute__TargetAssignment_13");
			builder.put(grammarAccess.getClassConstraintAccess().getTheoremAssignment_2(), "rule__ClassConstraint__TheoremAssignment_2");
			builder.put(grammarAccess.getClassConstraintAccess().getNameAssignment_3(), "rule__ClassConstraint__NameAssignment_3");
			builder.put(grammarAccess.getClassConstraintAccess().getPredicateAssignment_4(), "rule__ClassConstraint__PredicateAssignment_4");
			builder.put(grammarAccess.getClassConstraintAccess().getComponentAssignment_6(), "rule__ClassConstraint__ComponentAssignment_6");
			builder.put(grammarAccess.getClassMethodAccess().getKindAssignment_3(), "rule__ClassMethod__KindAssignment_3");
			builder.put(grammarAccess.getClassMethodAccess().getElaboratesAssignment_4_1(), "rule__ClassMethod__ElaboratesAssignment_4_1");
			builder.put(grammarAccess.getClassMethodAccess().getExtendedAssignment_5(), "rule__ClassMethod__ExtendedAssignment_5");
			builder.put(grammarAccess.getClassMethodAccess().getParametersAssignment_6_1(), "rule__ClassMethod__ParametersAssignment_6_1");
			builder.put(grammarAccess.getClassMethodAccess().getParametersAssignment_6_2_1(), "rule__ClassMethod__ParametersAssignment_6_2_1");
			builder.put(grammarAccess.getClassMethodAccess().getGuardsAssignment_7_1(), "rule__ClassMethod__GuardsAssignment_7_1");
			builder.put(grammarAccess.getClassMethodAccess().getActionsAssignment_8_1(), "rule__ClassMethod__ActionsAssignment_8_1");
			builder.put(grammarAccess.getClassMethodAccess().getWitnessesAssignment_9_1(), "rule__ClassMethod__WitnessesAssignment_9_1");
			builder.put(grammarAccess.getInvariantAccess().getTheoremAssignment_0(), "rule__Invariant__TheoremAssignment_0");
			builder.put(grammarAccess.getInvariantAccess().getNameAssignment_1(), "rule__Invariant__NameAssignment_1");
			builder.put(grammarAccess.getInvariantAccess().getPredicateAssignment_2(), "rule__Invariant__PredicateAssignment_2");
			builder.put(grammarAccess.getGuardAccess().getTheoremAssignment_0(), "rule__Guard__TheoremAssignment_0");
			builder.put(grammarAccess.getGuardAccess().getNameAssignment_1(), "rule__Guard__NameAssignment_1");
			builder.put(grammarAccess.getGuardAccess().getPredicateAssignment_2(), "rule__Guard__PredicateAssignment_2");
			builder.put(grammarAccess.getActionAccess().getNameAssignment_0(), "rule__Action__NameAssignment_0");
			builder.put(grammarAccess.getActionAccess().getActionAssignment_1(), "rule__Action__ActionAssignment_1");
			builder.put(grammarAccess.getWitnessAccess().getNameAssignment_0(), "rule__Witness__NameAssignment_0");
			builder.put(grammarAccess.getWitnessAccess().getPredicateAssignment_1(), "rule__Witness__PredicateAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private XUmlbGrammarAccess grammarAccess;

	@Override
	protected InternalXUmlbParser createParser() {
		InternalXUmlbParser result = new InternalXUmlbParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public XUmlbGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(XUmlbGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
