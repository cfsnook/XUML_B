package ac.soton.xumlb.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ac.soton.xumlb.services.XUmlbGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXUmlbParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_XLABEL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'UMLB'", "'elaborates'", "'refines'", "'statemachine'", "'('", "')'", "'instances'", "'selfName'", "'end'", "'transition'", "'extended'", "'source'", "'target'", "'any'", "','", "'where'", "'then'", "'with'", "':'", "'\\u00D7'", "'\\u2119'", "'BOOL'", "'\\u2124'", "'state'", "'statemachines'", "'begin'", "'invariants'", "'entryActions'", "'exitActions'", "'initial'", "'final'", "'junction'", "'fork'", "'classdiagram'", "'class'", "'supertypes'", "'subtypeGroups'", "'association'", "'functional'", "'total'", "'surjective'", "'injective'", "'initialValue'", "'SubtypeGroup'", "'cover'", "'disjoint'", "'attribute'", "'constraint'", "'theorem'", "'component'", "'method'", "'kind'", "'.'", "'FALSE'", "'TRUE'", "'bool'", "'card'", "'dom'", "'finite'", "'id'", "'inter'", "'max'", "'min'", "'mod'", "'pred'", "'prj1'", "'prj2'", "'ran'", "'succ'", "'union'", "'\\u21151'", "'\\u2115'", "'\\u21191'", "'\\u21D4'", "'\\u21D2'", "'\\u2227'", "'&'", "'\\u2228'", "'\\u00AC'", "'\\u22A4'", "'\\u22A5'", "'\\u2200'", "'!'", "'\\u2203'", "'#'", "'\\u00B7'", "'='", "'\\u2260'", "'\\u2264'", "'<'", "'\\u2265'", "'>'", "'\\u2208'", "'\\u2209'", "'\\u2282'", "'\\u2284'", "'\\u2286'", "'\\u2288'", "'partition'", "'\\u2194'", "'\\uE100'", "'\\uE101'", "'\\uE102'", "'\\u21F8'", "'\\u2192'", "'\\u2914'", "'\\u21A3'", "'\\u2900'", "'\\u21A0'", "'\\u2916'", "'{'", "'}'", "'\\u21A6'", "'\\u2205'", "'\\u2229'", "'\\u222A'", "'\\u2216'", "'['", "']'", "'\\uE103'", "'\\u2218'", "';'", "'\\u2297'", "'\\u2225'", "'\\u223C'", "'\\u25C1'", "'\\u2A64'", "'\\u25B7'", "'\\u2A65'", "'\\u03BB'", "'%'", "'\\u22C2'", "'\\u22C3'", "'\\u2223'", "'\\u2025'", "'+'", "'\\u2212'", "'-'", "'\\u2217'", "'*'", "'\\u00F7'", "'/'", "'^'", "'\\\\'", "'variables'", "'enumeration'", "'REFINEDVAR'", "'normal'", "'constructor'", "'destructor'", "'set'", "'constant'", "'variable'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__162=162;
    public static final int T__161=161;
    public static final int T__164=164;
    public static final int T__163=163;
    public static final int T__160=160;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__159=159;
    public static final int T__30=30;
    public static final int T__158=158;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__155=155;
    public static final int T__154=154;
    public static final int T__157=157;
    public static final int T__156=156;
    public static final int T__151=151;
    public static final int T__150=150;
    public static final int T__153=153;
    public static final int T__152=152;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__148=148;
    public static final int T__41=41;
    public static final int T__147=147;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__149=149;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int RULE_XLABEL=7;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalXUmlbParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXUmlbParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXUmlbParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXUmlb.g"; }



     	private XUmlbGrammarAccess grammarAccess;

        public InternalXUmlbParser(TokenStream input, XUmlbGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "XUMLB";
       	}

       	@Override
       	protected XUmlbGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleXUMLB"
    // InternalXUmlb.g:65:1: entryRuleXUMLB returns [EObject current=null] : iv_ruleXUMLB= ruleXUMLB EOF ;
    public final EObject entryRuleXUMLB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUMLB = null;


        try {
            // InternalXUmlb.g:65:46: (iv_ruleXUMLB= ruleXUMLB EOF )
            // InternalXUmlb.g:66:2: iv_ruleXUMLB= ruleXUMLB EOF
            {
             newCompositeNode(grammarAccess.getXUMLBRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXUMLB=ruleXUMLB();

            state._fsp--;

             current =iv_ruleXUMLB; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXUMLB"


    // $ANTLR start "ruleXUMLB"
    // InternalXUmlb.g:72:1: ruleXUMLB returns [EObject current=null] : (otherlv_0= 'UMLB' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'refines' ( ( ruleQualifiedName ) ) )? ( (lv_diagrams_6_0= ruleXDiagram ) )* ) ;
    public final EObject ruleXUMLB() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_diagrams_6_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:78:2: ( (otherlv_0= 'UMLB' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'refines' ( ( ruleQualifiedName ) ) )? ( (lv_diagrams_6_0= ruleXDiagram ) )* ) )
            // InternalXUmlb.g:79:2: (otherlv_0= 'UMLB' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'refines' ( ( ruleQualifiedName ) ) )? ( (lv_diagrams_6_0= ruleXDiagram ) )* )
            {
            // InternalXUmlb.g:79:2: (otherlv_0= 'UMLB' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'refines' ( ( ruleQualifiedName ) ) )? ( (lv_diagrams_6_0= ruleXDiagram ) )* )
            // InternalXUmlb.g:80:3: otherlv_0= 'UMLB' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'refines' ( ( ruleQualifiedName ) ) )? ( (lv_diagrams_6_0= ruleXDiagram ) )*
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getXUMLBAccess().getUMLBKeyword_0());
            		
            // InternalXUmlb.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalXUmlb.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalXUmlb.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalXUmlb.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getXUMLBAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXUMLBRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.XUmlb.ID");
            				

            }


            }

            // InternalXUmlb.g:102:3: (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalXUmlb.g:103:4: otherlv_2= 'elaborates' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getXUMLBAccess().getElaboratesKeyword_2_0());
                    			
                    // InternalXUmlb.g:107:4: ( ( ruleQualifiedName ) )
                    // InternalXUmlb.g:108:5: ( ruleQualifiedName )
                    {
                    // InternalXUmlb.g:108:5: ( ruleQualifiedName )
                    // InternalXUmlb.g:109:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getXUMLBRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getXUMLBAccess().getElaboratesEventBNamedCommentedComponentElementCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:124:3: (otherlv_4= 'refines' ( ( ruleQualifiedName ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalXUmlb.g:125:4: otherlv_4= 'refines' ( ( ruleQualifiedName ) )
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getXUMLBAccess().getRefinesKeyword_3_0());
                    			
                    // InternalXUmlb.g:129:4: ( ( ruleQualifiedName ) )
                    // InternalXUmlb.g:130:5: ( ruleQualifiedName )
                    {
                    // InternalXUmlb.g:130:5: ( ruleQualifiedName )
                    // InternalXUmlb.g:131:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getXUMLBRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getXUMLBAccess().getRefinesUMLBCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:146:3: ( (lv_diagrams_6_0= ruleXDiagram ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15||LA3_0==45) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalXUmlb.g:147:4: (lv_diagrams_6_0= ruleXDiagram )
            	    {
            	    // InternalXUmlb.g:147:4: (lv_diagrams_6_0= ruleXDiagram )
            	    // InternalXUmlb.g:148:5: lv_diagrams_6_0= ruleXDiagram
            	    {

            	    					newCompositeNode(grammarAccess.getXUMLBAccess().getDiagramsXDiagramParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_diagrams_6_0=ruleXDiagram();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getXUMLBRule());
            	    					}
            	    					add(
            	    						current,
            	    						"diagrams",
            	    						lv_diagrams_6_0,
            	    						"ac.soton.xumlb.XUmlb.XDiagram");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXUMLB"


    // $ANTLR start "entryRuleXDiagram"
    // InternalXUmlb.g:169:1: entryRuleXDiagram returns [EObject current=null] : iv_ruleXDiagram= ruleXDiagram EOF ;
    public final EObject entryRuleXDiagram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDiagram = null;


        try {
            // InternalXUmlb.g:169:49: (iv_ruleXDiagram= ruleXDiagram EOF )
            // InternalXUmlb.g:170:2: iv_ruleXDiagram= ruleXDiagram EOF
            {
             newCompositeNode(grammarAccess.getXDiagramRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXDiagram=ruleXDiagram();

            state._fsp--;

             current =iv_ruleXDiagram; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXDiagram"


    // $ANTLR start "ruleXDiagram"
    // InternalXUmlb.g:176:1: ruleXDiagram returns [EObject current=null] : (this_Statemachine_0= ruleStatemachine | this_Classdiagram_1= ruleClassdiagram ) ;
    public final EObject ruleXDiagram() throws RecognitionException {
        EObject current = null;

        EObject this_Statemachine_0 = null;

        EObject this_Classdiagram_1 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:182:2: ( (this_Statemachine_0= ruleStatemachine | this_Classdiagram_1= ruleClassdiagram ) )
            // InternalXUmlb.g:183:2: (this_Statemachine_0= ruleStatemachine | this_Classdiagram_1= ruleClassdiagram )
            {
            // InternalXUmlb.g:183:2: (this_Statemachine_0= ruleStatemachine | this_Classdiagram_1= ruleClassdiagram )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==45) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalXUmlb.g:184:3: this_Statemachine_0= ruleStatemachine
                    {

                    			newCompositeNode(grammarAccess.getXDiagramAccess().getStatemachineParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Statemachine_0=ruleStatemachine();

                    state._fsp--;


                    			current = this_Statemachine_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:193:3: this_Classdiagram_1= ruleClassdiagram
                    {

                    			newCompositeNode(grammarAccess.getXDiagramAccess().getClassdiagramParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Classdiagram_1=ruleClassdiagram();

                    state._fsp--;


                    			current = this_Classdiagram_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXDiagram"


    // $ANTLR start "entryRuleStatemachine"
    // InternalXUmlb.g:205:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // InternalXUmlb.g:205:53: (iv_ruleStatemachine= ruleStatemachine EOF )
            // InternalXUmlb.g:206:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             newCompositeNode(grammarAccess.getStatemachineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatemachine=ruleStatemachine();

            state._fsp--;

             current =iv_ruleStatemachine; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // InternalXUmlb.g:212:1: ruleStatemachine returns [EObject current=null] : ( () otherlv_1= 'statemachine' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_translation_4_0= ruleTranslationKind ) ) otherlv_5= ')' (otherlv_6= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'instances' ( ( ruleQualifiedName ) ) otherlv_10= 'selfName' ( (lv_selfName_11_0= ruleEString ) ) )? ( (lv_nodes_12_0= ruleAbstractNode ) )* ( (lv_transitions_13_0= ruleTransition ) )* otherlv_14= 'end' ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_14=null;
        Enumerator lv_translation_4_0 = null;

        AntlrDatatypeRuleToken lv_selfName_11_0 = null;

        EObject lv_nodes_12_0 = null;

        EObject lv_transitions_13_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:218:2: ( ( () otherlv_1= 'statemachine' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_translation_4_0= ruleTranslationKind ) ) otherlv_5= ')' (otherlv_6= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'instances' ( ( ruleQualifiedName ) ) otherlv_10= 'selfName' ( (lv_selfName_11_0= ruleEString ) ) )? ( (lv_nodes_12_0= ruleAbstractNode ) )* ( (lv_transitions_13_0= ruleTransition ) )* otherlv_14= 'end' ) )
            // InternalXUmlb.g:219:2: ( () otherlv_1= 'statemachine' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_translation_4_0= ruleTranslationKind ) ) otherlv_5= ')' (otherlv_6= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'instances' ( ( ruleQualifiedName ) ) otherlv_10= 'selfName' ( (lv_selfName_11_0= ruleEString ) ) )? ( (lv_nodes_12_0= ruleAbstractNode ) )* ( (lv_transitions_13_0= ruleTransition ) )* otherlv_14= 'end' )
            {
            // InternalXUmlb.g:219:2: ( () otherlv_1= 'statemachine' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_translation_4_0= ruleTranslationKind ) ) otherlv_5= ')' (otherlv_6= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'instances' ( ( ruleQualifiedName ) ) otherlv_10= 'selfName' ( (lv_selfName_11_0= ruleEString ) ) )? ( (lv_nodes_12_0= ruleAbstractNode ) )* ( (lv_transitions_13_0= ruleTransition ) )* otherlv_14= 'end' )
            // InternalXUmlb.g:220:3: () otherlv_1= 'statemachine' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_translation_4_0= ruleTranslationKind ) ) otherlv_5= ')' (otherlv_6= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'instances' ( ( ruleQualifiedName ) ) otherlv_10= 'selfName' ( (lv_selfName_11_0= ruleEString ) ) )? ( (lv_nodes_12_0= ruleAbstractNode ) )* ( (lv_transitions_13_0= ruleTransition ) )* otherlv_14= 'end'
            {
            // InternalXUmlb.g:220:3: ()
            // InternalXUmlb.g:221:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStatemachineAccess().getStatemachineAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getStatemachineAccess().getStatemachineKeyword_1());
            		
            // InternalXUmlb.g:231:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXUmlb.g:232:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXUmlb.g:232:4: (lv_name_2_0= RULE_ID )
            // InternalXUmlb.g:233:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_2_0, grammarAccess.getStatemachineAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStatemachineRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xumlb.XUmlb.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getStatemachineAccess().getLeftParenthesisKeyword_3());
            		
            // InternalXUmlb.g:253:3: ( (lv_translation_4_0= ruleTranslationKind ) )
            // InternalXUmlb.g:254:4: (lv_translation_4_0= ruleTranslationKind )
            {
            // InternalXUmlb.g:254:4: (lv_translation_4_0= ruleTranslationKind )
            // InternalXUmlb.g:255:5: lv_translation_4_0= ruleTranslationKind
            {

            					newCompositeNode(grammarAccess.getStatemachineAccess().getTranslationTranslationKindEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_9);
            lv_translation_4_0=ruleTranslationKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStatemachineRule());
            					}
            					set(
            						current,
            						"translation",
            						lv_translation_4_0,
            						"ac.soton.xumlb.XUmlb.TranslationKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getStatemachineAccess().getRightParenthesisKeyword_5());
            		
            // InternalXUmlb.g:276:3: (otherlv_6= 'refines' ( ( ruleQualifiedName ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalXUmlb.g:277:4: otherlv_6= 'refines' ( ( ruleQualifiedName ) )
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getStatemachineAccess().getRefinesKeyword_6_0());
                    			
                    // InternalXUmlb.g:281:4: ( ( ruleQualifiedName ) )
                    // InternalXUmlb.g:282:5: ( ruleQualifiedName )
                    {
                    // InternalXUmlb.g:282:5: ( ruleQualifiedName )
                    // InternalXUmlb.g:283:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStatemachineRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStatemachineAccess().getRefinesStatemachineCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:298:3: (otherlv_8= 'instances' ( ( ruleQualifiedName ) ) otherlv_10= 'selfName' ( (lv_selfName_11_0= ruleEString ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalXUmlb.g:299:4: otherlv_8= 'instances' ( ( ruleQualifiedName ) ) otherlv_10= 'selfName' ( (lv_selfName_11_0= ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_8, grammarAccess.getStatemachineAccess().getInstancesKeyword_7_0());
                    			
                    // InternalXUmlb.g:303:4: ( ( ruleQualifiedName ) )
                    // InternalXUmlb.g:304:5: ( ruleQualifiedName )
                    {
                    // InternalXUmlb.g:304:5: ( ruleQualifiedName )
                    // InternalXUmlb.g:305:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStatemachineRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStatemachineAccess().getInstancesEventBNamedCommentedElementCrossReference_7_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_10, grammarAccess.getStatemachineAccess().getSelfNameKeyword_7_2());
                    			
                    // InternalXUmlb.g:323:4: ( (lv_selfName_11_0= ruleEString ) )
                    // InternalXUmlb.g:324:5: (lv_selfName_11_0= ruleEString )
                    {
                    // InternalXUmlb.g:324:5: (lv_selfName_11_0= ruleEString )
                    // InternalXUmlb.g:325:6: lv_selfName_11_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getStatemachineAccess().getSelfNameEStringParserRuleCall_7_3_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_selfName_11_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStatemachineRule());
                    						}
                    						set(
                    							current,
                    							"selfName",
                    							lv_selfName_11_0,
                    							"ac.soton.xumlb.XUmlb.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:343:3: ( (lv_nodes_12_0= ruleAbstractNode ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25||LA7_0==35||(LA7_0>=41 && LA7_0<=44)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXUmlb.g:344:4: (lv_nodes_12_0= ruleAbstractNode )
            	    {
            	    // InternalXUmlb.g:344:4: (lv_nodes_12_0= ruleAbstractNode )
            	    // InternalXUmlb.g:345:5: lv_nodes_12_0= ruleAbstractNode
            	    {

            	    					newCompositeNode(grammarAccess.getStatemachineAccess().getNodesAbstractNodeParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_nodes_12_0=ruleAbstractNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_12_0,
            	    						"ac.soton.xumlb.XUmlb.AbstractNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalXUmlb.g:362:3: ( (lv_transitions_13_0= ruleTransition ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalXUmlb.g:363:4: (lv_transitions_13_0= ruleTransition )
            	    {
            	    // InternalXUmlb.g:363:4: (lv_transitions_13_0= ruleTransition )
            	    // InternalXUmlb.g:364:5: lv_transitions_13_0= ruleTransition
            	    {

            	    					newCompositeNode(grammarAccess.getStatemachineAccess().getTransitionsTransitionParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_transitions_13_0=ruleTransition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"transitions",
            	    						lv_transitions_13_0,
            	    						"ac.soton.xumlb.XUmlb.Transition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_14=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getStatemachineAccess().getEndKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleAbstractNode"
    // InternalXUmlb.g:389:1: entryRuleAbstractNode returns [EObject current=null] : iv_ruleAbstractNode= ruleAbstractNode EOF ;
    public final EObject entryRuleAbstractNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNode = null;


        try {
            // InternalXUmlb.g:389:53: (iv_ruleAbstractNode= ruleAbstractNode EOF )
            // InternalXUmlb.g:390:2: iv_ruleAbstractNode= ruleAbstractNode EOF
            {
             newCompositeNode(grammarAccess.getAbstractNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractNode=ruleAbstractNode();

            state._fsp--;

             current =iv_ruleAbstractNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractNode"


    // $ANTLR start "ruleAbstractNode"
    // InternalXUmlb.g:396:1: ruleAbstractNode returns [EObject current=null] : (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork ) ;
    public final EObject ruleAbstractNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_Initial_1 = null;

        EObject this_Final_2 = null;

        EObject this_Any_3 = null;

        EObject this_Junction_4 = null;

        EObject this_Fork_5 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:402:2: ( (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork ) )
            // InternalXUmlb.g:403:2: (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork )
            {
            // InternalXUmlb.g:403:2: (this_State_0= ruleState | this_Initial_1= ruleInitial | this_Final_2= ruleFinal | this_Any_3= ruleAny | this_Junction_4= ruleJunction | this_Fork_5= ruleFork )
            int alt9=6;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt9=1;
                }
                break;
            case 41:
                {
                alt9=2;
                }
                break;
            case 42:
                {
                alt9=3;
                }
                break;
            case 25:
                {
                alt9=4;
                }
                break;
            case 43:
                {
                alt9=5;
                }
                break;
            case 44:
                {
                alt9=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalXUmlb.g:404:3: this_State_0= ruleState
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getStateParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_State_0=ruleState();

                    state._fsp--;


                    			current = this_State_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:413:3: this_Initial_1= ruleInitial
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getInitialParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Initial_1=ruleInitial();

                    state._fsp--;


                    			current = this_Initial_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:422:3: this_Final_2= ruleFinal
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getFinalParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Final_2=ruleFinal();

                    state._fsp--;


                    			current = this_Final_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalXUmlb.g:431:3: this_Any_3= ruleAny
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getAnyParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Any_3=ruleAny();

                    state._fsp--;


                    			current = this_Any_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalXUmlb.g:440:3: this_Junction_4= ruleJunction
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getJunctionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Junction_4=ruleJunction();

                    state._fsp--;


                    			current = this_Junction_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalXUmlb.g:449:3: this_Fork_5= ruleFork
                    {

                    			newCompositeNode(grammarAccess.getAbstractNodeAccess().getForkParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Fork_5=ruleFork();

                    state._fsp--;


                    			current = this_Fork_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractNode"


    // $ANTLR start "entryRuleTransition"
    // InternalXUmlb.g:461:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalXUmlb.g:461:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalXUmlb.g:462:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalXUmlb.g:468:1: ruleTransition returns [EObject current=null] : ( () otherlv_1= 'transition' (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) )+ )? ( (lv_extended_4_0= 'extended' ) )? otherlv_5= 'source' ( ( ruleQualifiedName ) ) otherlv_7= 'target' ( ( ruleQualifiedName ) ) (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )? (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )? (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )? (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )? otherlv_19= 'end' ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_extended_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_parameters_10_0 = null;

        EObject lv_parameters_12_0 = null;

        EObject lv_guards_14_0 = null;

        EObject lv_actions_16_0 = null;

        EObject lv_witnesses_18_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:474:2: ( ( () otherlv_1= 'transition' (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) )+ )? ( (lv_extended_4_0= 'extended' ) )? otherlv_5= 'source' ( ( ruleQualifiedName ) ) otherlv_7= 'target' ( ( ruleQualifiedName ) ) (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )? (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )? (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )? (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )? otherlv_19= 'end' ) )
            // InternalXUmlb.g:475:2: ( () otherlv_1= 'transition' (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) )+ )? ( (lv_extended_4_0= 'extended' ) )? otherlv_5= 'source' ( ( ruleQualifiedName ) ) otherlv_7= 'target' ( ( ruleQualifiedName ) ) (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )? (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )? (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )? (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )? otherlv_19= 'end' )
            {
            // InternalXUmlb.g:475:2: ( () otherlv_1= 'transition' (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) )+ )? ( (lv_extended_4_0= 'extended' ) )? otherlv_5= 'source' ( ( ruleQualifiedName ) ) otherlv_7= 'target' ( ( ruleQualifiedName ) ) (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )? (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )? (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )? (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )? otherlv_19= 'end' )
            // InternalXUmlb.g:476:3: () otherlv_1= 'transition' (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) )+ )? ( (lv_extended_4_0= 'extended' ) )? otherlv_5= 'source' ( ( ruleQualifiedName ) ) otherlv_7= 'target' ( ( ruleQualifiedName ) ) (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )? (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )? (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )? (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )? otherlv_19= 'end'
            {
            // InternalXUmlb.g:476:3: ()
            // InternalXUmlb.g:477:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTransitionAccess().getTransitionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getTransitionKeyword_1());
            		
            // InternalXUmlb.g:487:3: (otherlv_2= 'elaborates' ( ( ruleQualifiedName ) )+ )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==13) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalXUmlb.g:488:4: otherlv_2= 'elaborates' ( ( ruleQualifiedName ) )+
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getElaboratesKeyword_2_0());
                    			
                    // InternalXUmlb.g:492:4: ( ( ruleQualifiedName ) )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalXUmlb.g:493:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalXUmlb.g:493:5: ( ruleQualifiedName )
                    	    // InternalXUmlb.g:494:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getTransitionRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getElaboratesEventCrossReference_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_17);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


                    }
                    break;

            }

            // InternalXUmlb.g:509:3: ( (lv_extended_4_0= 'extended' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXUmlb.g:510:4: (lv_extended_4_0= 'extended' )
                    {
                    // InternalXUmlb.g:510:4: (lv_extended_4_0= 'extended' )
                    // InternalXUmlb.g:511:5: lv_extended_4_0= 'extended'
                    {
                    lv_extended_4_0=(Token)match(input,22,FOLLOW_18); 

                    					newLeafNode(lv_extended_4_0, grammarAccess.getTransitionAccess().getExtendedExtendedKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTransitionRule());
                    					}
                    					setWithLastConsumed(current, "extended", lv_extended_4_0 != null, "extended");
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getTransitionAccess().getSourceKeyword_4());
            		
            // InternalXUmlb.g:527:3: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:528:4: ( ruleQualifiedName )
            {
            // InternalXUmlb.g:528:4: ( ruleQualifiedName )
            // InternalXUmlb.g:529:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getSourceAbstractNodeCrossReference_5_0());
            				
            pushFollow(FOLLOW_19);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getTransitionAccess().getTargetKeyword_6());
            		
            // InternalXUmlb.g:547:3: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:548:4: ( ruleQualifiedName )
            {
            // InternalXUmlb.g:548:4: ( ruleQualifiedName )
            // InternalXUmlb.g:549:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getTargetAbstractNodeCrossReference_7_0());
            				
            pushFollow(FOLLOW_20);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXUmlb.g:563:3: (otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalXUmlb.g:564:4: otherlv_9= 'any' ( (lv_parameters_10_0= ruleTypedParameter ) ) (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )*
                    {
                    otherlv_9=(Token)match(input,25,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getTransitionAccess().getAnyKeyword_8_0());
                    			
                    // InternalXUmlb.g:568:4: ( (lv_parameters_10_0= ruleTypedParameter ) )
                    // InternalXUmlb.g:569:5: (lv_parameters_10_0= ruleTypedParameter )
                    {
                    // InternalXUmlb.g:569:5: (lv_parameters_10_0= ruleTypedParameter )
                    // InternalXUmlb.g:570:6: lv_parameters_10_0= ruleTypedParameter
                    {

                    						newCompositeNode(grammarAccess.getTransitionAccess().getParametersTypedParameterParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_parameters_10_0=ruleTypedParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_10_0,
                    							"ac.soton.xumlb.XUmlb.TypedParameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalXUmlb.g:587:4: (otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==26) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalXUmlb.g:588:5: otherlv_11= ',' ( (lv_parameters_12_0= ruleTypedParameter ) )
                    	    {
                    	    otherlv_11=(Token)match(input,26,FOLLOW_3); 

                    	    					newLeafNode(otherlv_11, grammarAccess.getTransitionAccess().getCommaKeyword_8_2_0());
                    	    				
                    	    // InternalXUmlb.g:592:5: ( (lv_parameters_12_0= ruleTypedParameter ) )
                    	    // InternalXUmlb.g:593:6: (lv_parameters_12_0= ruleTypedParameter )
                    	    {
                    	    // InternalXUmlb.g:593:6: (lv_parameters_12_0= ruleTypedParameter )
                    	    // InternalXUmlb.g:594:7: lv_parameters_12_0= ruleTypedParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getTransitionAccess().getParametersTypedParameterParserRuleCall_8_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_parameters_12_0=ruleTypedParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_12_0,
                    	    								"ac.soton.xumlb.XUmlb.TypedParameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalXUmlb.g:613:3: (otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+ )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalXUmlb.g:614:4: otherlv_13= 'where' ( (lv_guards_14_0= ruleGuard ) )+
                    {
                    otherlv_13=(Token)match(input,27,FOLLOW_22); 

                    				newLeafNode(otherlv_13, grammarAccess.getTransitionAccess().getWhereKeyword_9_0());
                    			
                    // InternalXUmlb.g:618:4: ( (lv_guards_14_0= ruleGuard ) )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==RULE_XLABEL||LA15_0==60) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalXUmlb.g:619:5: (lv_guards_14_0= ruleGuard )
                    	    {
                    	    // InternalXUmlb.g:619:5: (lv_guards_14_0= ruleGuard )
                    	    // InternalXUmlb.g:620:6: lv_guards_14_0= ruleGuard
                    	    {

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getGuardsGuardParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_23);
                    	    lv_guards_14_0=ruleGuard();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"guards",
                    	    							lv_guards_14_0,
                    	    							"ac.soton.xumlb.XUmlb.Guard");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);


                    }
                    break;

            }

            // InternalXUmlb.g:638:3: (otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+ )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalXUmlb.g:639:4: otherlv_15= 'then' ( (lv_actions_16_0= ruleAction ) )+
                    {
                    otherlv_15=(Token)match(input,28,FOLLOW_24); 

                    				newLeafNode(otherlv_15, grammarAccess.getTransitionAccess().getThenKeyword_10_0());
                    			
                    // InternalXUmlb.g:643:4: ( (lv_actions_16_0= ruleAction ) )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_XLABEL) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalXUmlb.g:644:5: (lv_actions_16_0= ruleAction )
                    	    {
                    	    // InternalXUmlb.g:644:5: (lv_actions_16_0= ruleAction )
                    	    // InternalXUmlb.g:645:6: lv_actions_16_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getActionsActionParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_25);
                    	    lv_actions_16_0=ruleAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"actions",
                    	    							lv_actions_16_0,
                    	    							"ac.soton.xumlb.XUmlb.Action");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);


                    }
                    break;

            }

            // InternalXUmlb.g:663:3: (otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+ )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalXUmlb.g:664:4: otherlv_17= 'with' ( (lv_witnesses_18_0= ruleWitness ) )+
                    {
                    otherlv_17=(Token)match(input,29,FOLLOW_24); 

                    				newLeafNode(otherlv_17, grammarAccess.getTransitionAccess().getWithKeyword_11_0());
                    			
                    // InternalXUmlb.g:668:4: ( (lv_witnesses_18_0= ruleWitness ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_XLABEL) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalXUmlb.g:669:5: (lv_witnesses_18_0= ruleWitness )
                    	    {
                    	    // InternalXUmlb.g:669:5: (lv_witnesses_18_0= ruleWitness )
                    	    // InternalXUmlb.g:670:6: lv_witnesses_18_0= ruleWitness
                    	    {

                    	    						newCompositeNode(grammarAccess.getTransitionAccess().getWitnessesWitnessParserRuleCall_11_1_0());
                    	    					
                    	    pushFollow(FOLLOW_26);
                    	    lv_witnesses_18_0=ruleWitness();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"witnesses",
                    	    							lv_witnesses_18_0,
                    	    							"ac.soton.xumlb.XUmlb.Witness");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


                    }
                    break;

            }

            otherlv_19=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_19, grammarAccess.getTransitionAccess().getEndKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleTypedParameter"
    // InternalXUmlb.g:696:1: entryRuleTypedParameter returns [EObject current=null] : iv_ruleTypedParameter= ruleTypedParameter EOF ;
    public final EObject entryRuleTypedParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedParameter = null;


        try {
            // InternalXUmlb.g:696:55: (iv_ruleTypedParameter= ruleTypedParameter EOF )
            // InternalXUmlb.g:697:2: iv_ruleTypedParameter= ruleTypedParameter EOF
            {
             newCompositeNode(grammarAccess.getTypedParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypedParameter=ruleTypedParameter();

            state._fsp--;

             current =iv_ruleTypedParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedParameter"


    // $ANTLR start "ruleTypedParameter"
    // InternalXUmlb.g:703:1: ruleTypedParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) ) ;
    public final EObject ruleTypedParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:709:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) ) )
            // InternalXUmlb.g:710:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) )
            {
            // InternalXUmlb.g:710:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) ) )
            // InternalXUmlb.g:711:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleXType ) )
            {
            // InternalXUmlb.g:711:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalXUmlb.g:712:4: (lv_name_0_0= RULE_ID )
            {
            // InternalXUmlb.g:712:4: (lv_name_0_0= RULE_ID )
            // InternalXUmlb.g:713:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTypedParameterAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTypedParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"ac.soton.xumlb.XUmlb.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getTypedParameterAccess().getColonKeyword_1());
            		
            // InternalXUmlb.g:733:3: ( (lv_type_2_0= ruleXType ) )
            // InternalXUmlb.g:734:4: (lv_type_2_0= ruleXType )
            {
            // InternalXUmlb.g:734:4: (lv_type_2_0= ruleXType )
            // InternalXUmlb.g:735:5: lv_type_2_0= ruleXType
            {

            					newCompositeNode(grammarAccess.getTypedParameterAccess().getTypeXTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleXType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTypedParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"ac.soton.xumlb.XUmlb.XType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedParameter"


    // $ANTLR start "entryRuleXType"
    // InternalXUmlb.g:756:1: entryRuleXType returns [String current=null] : iv_ruleXType= ruleXType EOF ;
    public final String entryRuleXType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXType = null;


        try {
            // InternalXUmlb.g:756:45: (iv_ruleXType= ruleXType EOF )
            // InternalXUmlb.g:757:2: iv_ruleXType= ruleXType EOF
            {
             newCompositeNode(grammarAccess.getXTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXType=ruleXType();

            state._fsp--;

             current =iv_ruleXType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXType"


    // $ANTLR start "ruleXType"
    // InternalXUmlb.g:763:1: ruleXType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XComplexType_2= ruleXComplexType )* ) ;
    public final AntlrDatatypeRuleToken ruleXType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_XComplexType_0 = null;

        AntlrDatatypeRuleToken this_XComplexType_2 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:769:2: ( (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XComplexType_2= ruleXComplexType )* ) )
            // InternalXUmlb.g:770:2: (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XComplexType_2= ruleXComplexType )* )
            {
            // InternalXUmlb.g:770:2: (this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XComplexType_2= ruleXComplexType )* )
            // InternalXUmlb.g:771:3: this_XComplexType_0= ruleXComplexType (kw= '\\u00D7' this_XComplexType_2= ruleXComplexType )*
            {

            			newCompositeNode(grammarAccess.getXTypeAccess().getXComplexTypeParserRuleCall_0());
            		
            pushFollow(FOLLOW_29);
            this_XComplexType_0=ruleXComplexType();

            state._fsp--;


            			current.merge(this_XComplexType_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalXUmlb.g:781:3: (kw= '\\u00D7' this_XComplexType_2= ruleXComplexType )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==31) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalXUmlb.g:782:4: kw= '\\u00D7' this_XComplexType_2= ruleXComplexType
            	    {
            	    kw=(Token)match(input,31,FOLLOW_28); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getXTypeAccess().getMultiplicationSignKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getXTypeAccess().getXComplexTypeParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_29);
            	    this_XComplexType_2=ruleXComplexType();

            	    state._fsp--;


            	    				current.merge(this_XComplexType_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXType"


    // $ANTLR start "entryRuleXComplexType"
    // InternalXUmlb.g:802:1: entryRuleXComplexType returns [String current=null] : iv_ruleXComplexType= ruleXComplexType EOF ;
    public final String entryRuleXComplexType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXComplexType = null;


        try {
            // InternalXUmlb.g:802:52: (iv_ruleXComplexType= ruleXComplexType EOF )
            // InternalXUmlb.g:803:2: iv_ruleXComplexType= ruleXComplexType EOF
            {
             newCompositeNode(grammarAccess.getXComplexTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXComplexType=ruleXComplexType();

            state._fsp--;

             current =iv_ruleXComplexType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXComplexType"


    // $ANTLR start "ruleXComplexType"
    // InternalXUmlb.g:809:1: ruleXComplexType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleXComplexType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_5=null;
        AntlrDatatypeRuleToken this_XType_2 = null;

        AntlrDatatypeRuleToken this_EVENT_B_BUILDIN_TYPE_4 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:815:2: ( ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID ) )
            // InternalXUmlb.g:816:2: ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID )
            {
            // InternalXUmlb.g:816:2: ( (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' ) | this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE | this_ID_5= RULE_ID )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt22=1;
                }
                break;
            case 33:
            case 34:
                {
                alt22=2;
                }
                break;
            case RULE_ID:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalXUmlb.g:817:3: (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' )
                    {
                    // InternalXUmlb.g:817:3: (kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')' )
                    // InternalXUmlb.g:818:4: kw= '\\u2119' kw= '(' this_XType_2= ruleXType kw= ')'
                    {
                    kw=(Token)match(input,32,FOLLOW_7); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXComplexTypeAccess().getDoubleStruckCapitalPKeyword_0_0());
                    			
                    kw=(Token)match(input,16,FOLLOW_28); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXComplexTypeAccess().getLeftParenthesisKeyword_0_1());
                    			

                    				newCompositeNode(grammarAccess.getXComplexTypeAccess().getXTypeParserRuleCall_0_2());
                    			
                    pushFollow(FOLLOW_9);
                    this_XType_2=ruleXType();

                    state._fsp--;


                    				current.merge(this_XType_2);
                    			

                    				afterParserOrEnumRuleCall();
                    			
                    kw=(Token)match(input,17,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXComplexTypeAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:845:3: this_EVENT_B_BUILDIN_TYPE_4= ruleEVENT_B_BUILDIN_TYPE
                    {

                    			newCompositeNode(grammarAccess.getXComplexTypeAccess().getEVENT_B_BUILDIN_TYPEParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EVENT_B_BUILDIN_TYPE_4=ruleEVENT_B_BUILDIN_TYPE();

                    state._fsp--;


                    			current.merge(this_EVENT_B_BUILDIN_TYPE_4);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:856:3: this_ID_5= RULE_ID
                    {
                    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_5);
                    		

                    			newLeafNode(this_ID_5, grammarAccess.getXComplexTypeAccess().getIDTerminalRuleCall_2());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXComplexType"


    // $ANTLR start "entryRuleEVENT_B_BUILDIN_TYPE"
    // InternalXUmlb.g:867:1: entryRuleEVENT_B_BUILDIN_TYPE returns [String current=null] : iv_ruleEVENT_B_BUILDIN_TYPE= ruleEVENT_B_BUILDIN_TYPE EOF ;
    public final String entryRuleEVENT_B_BUILDIN_TYPE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENT_B_BUILDIN_TYPE = null;


        try {
            // InternalXUmlb.g:867:60: (iv_ruleEVENT_B_BUILDIN_TYPE= ruleEVENT_B_BUILDIN_TYPE EOF )
            // InternalXUmlb.g:868:2: iv_ruleEVENT_B_BUILDIN_TYPE= ruleEVENT_B_BUILDIN_TYPE EOF
            {
             newCompositeNode(grammarAccess.getEVENT_B_BUILDIN_TYPERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEVENT_B_BUILDIN_TYPE=ruleEVENT_B_BUILDIN_TYPE();

            state._fsp--;

             current =iv_ruleEVENT_B_BUILDIN_TYPE.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEVENT_B_BUILDIN_TYPE"


    // $ANTLR start "ruleEVENT_B_BUILDIN_TYPE"
    // InternalXUmlb.g:874:1: ruleEVENT_B_BUILDIN_TYPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'BOOL' | kw= '\\u2124' ) ;
    public final AntlrDatatypeRuleToken ruleEVENT_B_BUILDIN_TYPE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalXUmlb.g:880:2: ( (kw= 'BOOL' | kw= '\\u2124' ) )
            // InternalXUmlb.g:881:2: (kw= 'BOOL' | kw= '\\u2124' )
            {
            // InternalXUmlb.g:881:2: (kw= 'BOOL' | kw= '\\u2124' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            else if ( (LA23_0==34) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalXUmlb.g:882:3: kw= 'BOOL'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getBOOLKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:888:3: kw= '\\u2124'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getDoubleStruckCapitalZKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEVENT_B_BUILDIN_TYPE"


    // $ANTLR start "entryRuleState"
    // InternalXUmlb.g:897:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalXUmlb.g:897:46: (iv_ruleState= ruleState EOF )
            // InternalXUmlb.g:898:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalXUmlb.g:904:1: ruleState returns [EObject current=null] : ( () otherlv_1= 'state' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_5= 'statemachines' otherlv_6= 'begin' ( (lv_statemachines_7_0= ruleStatemachine ) ) ( (lv_statemachines_8_0= ruleStatemachine ) )* otherlv_9= 'end' )? (otherlv_10= 'invariants' ( (lv_invariants_11_0= ruleInvariant ) )+ )? (otherlv_12= 'entryActions' ( (lv_entryActions_13_0= ruleAction ) )+ )? (otherlv_14= 'exitActions' ( (lv_exitActions_15_0= ruleAction ) )+ )? ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_statemachines_7_0 = null;

        EObject lv_statemachines_8_0 = null;

        EObject lv_invariants_11_0 = null;

        EObject lv_entryActions_13_0 = null;

        EObject lv_exitActions_15_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:910:2: ( ( () otherlv_1= 'state' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_5= 'statemachines' otherlv_6= 'begin' ( (lv_statemachines_7_0= ruleStatemachine ) ) ( (lv_statemachines_8_0= ruleStatemachine ) )* otherlv_9= 'end' )? (otherlv_10= 'invariants' ( (lv_invariants_11_0= ruleInvariant ) )+ )? (otherlv_12= 'entryActions' ( (lv_entryActions_13_0= ruleAction ) )+ )? (otherlv_14= 'exitActions' ( (lv_exitActions_15_0= ruleAction ) )+ )? ) )
            // InternalXUmlb.g:911:2: ( () otherlv_1= 'state' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_5= 'statemachines' otherlv_6= 'begin' ( (lv_statemachines_7_0= ruleStatemachine ) ) ( (lv_statemachines_8_0= ruleStatemachine ) )* otherlv_9= 'end' )? (otherlv_10= 'invariants' ( (lv_invariants_11_0= ruleInvariant ) )+ )? (otherlv_12= 'entryActions' ( (lv_entryActions_13_0= ruleAction ) )+ )? (otherlv_14= 'exitActions' ( (lv_exitActions_15_0= ruleAction ) )+ )? )
            {
            // InternalXUmlb.g:911:2: ( () otherlv_1= 'state' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_5= 'statemachines' otherlv_6= 'begin' ( (lv_statemachines_7_0= ruleStatemachine ) ) ( (lv_statemachines_8_0= ruleStatemachine ) )* otherlv_9= 'end' )? (otherlv_10= 'invariants' ( (lv_invariants_11_0= ruleInvariant ) )+ )? (otherlv_12= 'entryActions' ( (lv_entryActions_13_0= ruleAction ) )+ )? (otherlv_14= 'exitActions' ( (lv_exitActions_15_0= ruleAction ) )+ )? )
            // InternalXUmlb.g:912:3: () otherlv_1= 'state' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_5= 'statemachines' otherlv_6= 'begin' ( (lv_statemachines_7_0= ruleStatemachine ) ) ( (lv_statemachines_8_0= ruleStatemachine ) )* otherlv_9= 'end' )? (otherlv_10= 'invariants' ( (lv_invariants_11_0= ruleInvariant ) )+ )? (otherlv_12= 'entryActions' ( (lv_entryActions_13_0= ruleAction ) )+ )? (otherlv_14= 'exitActions' ( (lv_exitActions_15_0= ruleAction ) )+ )?
            {
            // InternalXUmlb.g:912:3: ()
            // InternalXUmlb.g:913:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStateAccess().getStateAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getStateAccess().getStateKeyword_1());
            		
            // InternalXUmlb.g:923:3: ( (lv_name_2_0= ruleEString ) )
            // InternalXUmlb.g:924:4: (lv_name_2_0= ruleEString )
            {
            // InternalXUmlb.g:924:4: (lv_name_2_0= ruleEString )
            // InternalXUmlb.g:925:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getStateAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_30);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xumlb.XUmlb.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXUmlb.g:942:3: (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==14) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalXUmlb.g:943:4: otherlv_3= 'refines' ( ( ruleQualifiedName ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getStateAccess().getRefinesKeyword_3_0());
                    			
                    // InternalXUmlb.g:947:4: ( ( ruleQualifiedName ) )
                    // InternalXUmlb.g:948:5: ( ruleQualifiedName )
                    {
                    // InternalXUmlb.g:948:5: ( ruleQualifiedName )
                    // InternalXUmlb.g:949:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStateAccess().getRefinesStateCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_31);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:964:3: (otherlv_5= 'statemachines' otherlv_6= 'begin' ( (lv_statemachines_7_0= ruleStatemachine ) ) ( (lv_statemachines_8_0= ruleStatemachine ) )* otherlv_9= 'end' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==36) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalXUmlb.g:965:4: otherlv_5= 'statemachines' otherlv_6= 'begin' ( (lv_statemachines_7_0= ruleStatemachine ) ) ( (lv_statemachines_8_0= ruleStatemachine ) )* otherlv_9= 'end'
                    {
                    otherlv_5=(Token)match(input,36,FOLLOW_32); 

                    				newLeafNode(otherlv_5, grammarAccess.getStateAccess().getStatemachinesKeyword_4_0());
                    			
                    otherlv_6=(Token)match(input,37,FOLLOW_33); 

                    				newLeafNode(otherlv_6, grammarAccess.getStateAccess().getBeginKeyword_4_1());
                    			
                    // InternalXUmlb.g:973:4: ( (lv_statemachines_7_0= ruleStatemachine ) )
                    // InternalXUmlb.g:974:5: (lv_statemachines_7_0= ruleStatemachine )
                    {
                    // InternalXUmlb.g:974:5: (lv_statemachines_7_0= ruleStatemachine )
                    // InternalXUmlb.g:975:6: lv_statemachines_7_0= ruleStatemachine
                    {

                    						newCompositeNode(grammarAccess.getStateAccess().getStatemachinesStatemachineParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_statemachines_7_0=ruleStatemachine();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStateRule());
                    						}
                    						add(
                    							current,
                    							"statemachines",
                    							lv_statemachines_7_0,
                    							"ac.soton.xumlb.XUmlb.Statemachine");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalXUmlb.g:992:4: ( (lv_statemachines_8_0= ruleStatemachine ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==15) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalXUmlb.g:993:5: (lv_statemachines_8_0= ruleStatemachine )
                    	    {
                    	    // InternalXUmlb.g:993:5: (lv_statemachines_8_0= ruleStatemachine )
                    	    // InternalXUmlb.g:994:6: lv_statemachines_8_0= ruleStatemachine
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getStatemachinesStatemachineParserRuleCall_4_3_0());
                    	    					
                    	    pushFollow(FOLLOW_34);
                    	    lv_statemachines_8_0=ruleStatemachine();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStateRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"statemachines",
                    	    							lv_statemachines_8_0,
                    	    							"ac.soton.xumlb.XUmlb.Statemachine");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,20,FOLLOW_35); 

                    				newLeafNode(otherlv_9, grammarAccess.getStateAccess().getEndKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalXUmlb.g:1016:3: (otherlv_10= 'invariants' ( (lv_invariants_11_0= ruleInvariant ) )+ )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==38) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalXUmlb.g:1017:4: otherlv_10= 'invariants' ( (lv_invariants_11_0= ruleInvariant ) )+
                    {
                    otherlv_10=(Token)match(input,38,FOLLOW_22); 

                    				newLeafNode(otherlv_10, grammarAccess.getStateAccess().getInvariantsKeyword_5_0());
                    			
                    // InternalXUmlb.g:1021:4: ( (lv_invariants_11_0= ruleInvariant ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==RULE_XLABEL||LA27_0==60) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalXUmlb.g:1022:5: (lv_invariants_11_0= ruleInvariant )
                    	    {
                    	    // InternalXUmlb.g:1022:5: (lv_invariants_11_0= ruleInvariant )
                    	    // InternalXUmlb.g:1023:6: lv_invariants_11_0= ruleInvariant
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getInvariantsInvariantParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_36);
                    	    lv_invariants_11_0=ruleInvariant();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStateRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"invariants",
                    	    							lv_invariants_11_0,
                    	    							"ac.soton.xumlb.XUmlb.Invariant");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);


                    }
                    break;

            }

            // InternalXUmlb.g:1041:3: (otherlv_12= 'entryActions' ( (lv_entryActions_13_0= ruleAction ) )+ )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==39) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalXUmlb.g:1042:4: otherlv_12= 'entryActions' ( (lv_entryActions_13_0= ruleAction ) )+
                    {
                    otherlv_12=(Token)match(input,39,FOLLOW_24); 

                    				newLeafNode(otherlv_12, grammarAccess.getStateAccess().getEntryActionsKeyword_6_0());
                    			
                    // InternalXUmlb.g:1046:4: ( (lv_entryActions_13_0= ruleAction ) )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_XLABEL) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalXUmlb.g:1047:5: (lv_entryActions_13_0= ruleAction )
                    	    {
                    	    // InternalXUmlb.g:1047:5: (lv_entryActions_13_0= ruleAction )
                    	    // InternalXUmlb.g:1048:6: lv_entryActions_13_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getEntryActionsActionParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_37);
                    	    lv_entryActions_13_0=ruleAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStateRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"entryActions",
                    	    							lv_entryActions_13_0,
                    	    							"ac.soton.xumlb.XUmlb.Action");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt29 >= 1 ) break loop29;
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);


                    }
                    break;

            }

            // InternalXUmlb.g:1066:3: (otherlv_14= 'exitActions' ( (lv_exitActions_15_0= ruleAction ) )+ )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==40) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalXUmlb.g:1067:4: otherlv_14= 'exitActions' ( (lv_exitActions_15_0= ruleAction ) )+
                    {
                    otherlv_14=(Token)match(input,40,FOLLOW_24); 

                    				newLeafNode(otherlv_14, grammarAccess.getStateAccess().getExitActionsKeyword_7_0());
                    			
                    // InternalXUmlb.g:1071:4: ( (lv_exitActions_15_0= ruleAction ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==RULE_XLABEL) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalXUmlb.g:1072:5: (lv_exitActions_15_0= ruleAction )
                    	    {
                    	    // InternalXUmlb.g:1072:5: (lv_exitActions_15_0= ruleAction )
                    	    // InternalXUmlb.g:1073:6: lv_exitActions_15_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getStateAccess().getExitActionsActionParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_38);
                    	    lv_exitActions_15_0=ruleAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStateRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"exitActions",
                    	    							lv_exitActions_15_0,
                    	    							"ac.soton.xumlb.XUmlb.Action");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleInitial"
    // InternalXUmlb.g:1095:1: entryRuleInitial returns [EObject current=null] : iv_ruleInitial= ruleInitial EOF ;
    public final EObject entryRuleInitial() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitial = null;


        try {
            // InternalXUmlb.g:1095:48: (iv_ruleInitial= ruleInitial EOF )
            // InternalXUmlb.g:1096:2: iv_ruleInitial= ruleInitial EOF
            {
             newCompositeNode(grammarAccess.getInitialRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInitial=ruleInitial();

            state._fsp--;

             current =iv_ruleInitial; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitial"


    // $ANTLR start "ruleInitial"
    // InternalXUmlb.g:1102:1: ruleInitial returns [EObject current=null] : (otherlv_0= 'initial' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleInitial() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:1108:2: ( (otherlv_0= 'initial' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalXUmlb.g:1109:2: (otherlv_0= 'initial' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalXUmlb.g:1109:2: (otherlv_0= 'initial' ( (lv_name_1_0= ruleEString ) ) )
            // InternalXUmlb.g:1110:3: otherlv_0= 'initial' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getInitialAccess().getInitialKeyword_0());
            		
            // InternalXUmlb.g:1114:3: ( (lv_name_1_0= ruleEString ) )
            // InternalXUmlb.g:1115:4: (lv_name_1_0= ruleEString )
            {
            // InternalXUmlb.g:1115:4: (lv_name_1_0= ruleEString )
            // InternalXUmlb.g:1116:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getInitialAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInitialRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.XUmlb.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitial"


    // $ANTLR start "entryRuleFinal"
    // InternalXUmlb.g:1137:1: entryRuleFinal returns [EObject current=null] : iv_ruleFinal= ruleFinal EOF ;
    public final EObject entryRuleFinal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinal = null;


        try {
            // InternalXUmlb.g:1137:46: (iv_ruleFinal= ruleFinal EOF )
            // InternalXUmlb.g:1138:2: iv_ruleFinal= ruleFinal EOF
            {
             newCompositeNode(grammarAccess.getFinalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFinal=ruleFinal();

            state._fsp--;

             current =iv_ruleFinal; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFinal"


    // $ANTLR start "ruleFinal"
    // InternalXUmlb.g:1144:1: ruleFinal returns [EObject current=null] : (otherlv_0= 'final' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleFinal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:1150:2: ( (otherlv_0= 'final' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalXUmlb.g:1151:2: (otherlv_0= 'final' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalXUmlb.g:1151:2: (otherlv_0= 'final' ( (lv_name_1_0= ruleEString ) ) )
            // InternalXUmlb.g:1152:3: otherlv_0= 'final' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getFinalAccess().getFinalKeyword_0());
            		
            // InternalXUmlb.g:1156:3: ( (lv_name_1_0= ruleEString ) )
            // InternalXUmlb.g:1157:4: (lv_name_1_0= ruleEString )
            {
            // InternalXUmlb.g:1157:4: (lv_name_1_0= ruleEString )
            // InternalXUmlb.g:1158:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFinalAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFinalRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.XUmlb.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFinal"


    // $ANTLR start "entryRuleAny"
    // InternalXUmlb.g:1179:1: entryRuleAny returns [EObject current=null] : iv_ruleAny= ruleAny EOF ;
    public final EObject entryRuleAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAny = null;


        try {
            // InternalXUmlb.g:1179:44: (iv_ruleAny= ruleAny EOF )
            // InternalXUmlb.g:1180:2: iv_ruleAny= ruleAny EOF
            {
             newCompositeNode(grammarAccess.getAnyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAny=ruleAny();

            state._fsp--;

             current =iv_ruleAny; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAny"


    // $ANTLR start "ruleAny"
    // InternalXUmlb.g:1186:1: ruleAny returns [EObject current=null] : (otherlv_0= 'any' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:1192:2: ( (otherlv_0= 'any' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalXUmlb.g:1193:2: (otherlv_0= 'any' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalXUmlb.g:1193:2: (otherlv_0= 'any' ( (lv_name_1_0= ruleEString ) ) )
            // InternalXUmlb.g:1194:3: otherlv_0= 'any' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getAnyAccess().getAnyKeyword_0());
            		
            // InternalXUmlb.g:1198:3: ( (lv_name_1_0= ruleEString ) )
            // InternalXUmlb.g:1199:4: (lv_name_1_0= ruleEString )
            {
            // InternalXUmlb.g:1199:4: (lv_name_1_0= ruleEString )
            // InternalXUmlb.g:1200:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAnyAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAnyRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.XUmlb.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAny"


    // $ANTLR start "entryRuleJunction"
    // InternalXUmlb.g:1221:1: entryRuleJunction returns [EObject current=null] : iv_ruleJunction= ruleJunction EOF ;
    public final EObject entryRuleJunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJunction = null;


        try {
            // InternalXUmlb.g:1221:49: (iv_ruleJunction= ruleJunction EOF )
            // InternalXUmlb.g:1222:2: iv_ruleJunction= ruleJunction EOF
            {
             newCompositeNode(grammarAccess.getJunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJunction=ruleJunction();

            state._fsp--;

             current =iv_ruleJunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJunction"


    // $ANTLR start "ruleJunction"
    // InternalXUmlb.g:1228:1: ruleJunction returns [EObject current=null] : (otherlv_0= 'junction' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleJunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:1234:2: ( (otherlv_0= 'junction' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalXUmlb.g:1235:2: (otherlv_0= 'junction' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalXUmlb.g:1235:2: (otherlv_0= 'junction' ( (lv_name_1_0= ruleEString ) ) )
            // InternalXUmlb.g:1236:3: otherlv_0= 'junction' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getJunctionAccess().getJunctionKeyword_0());
            		
            // InternalXUmlb.g:1240:3: ( (lv_name_1_0= ruleEString ) )
            // InternalXUmlb.g:1241:4: (lv_name_1_0= ruleEString )
            {
            // InternalXUmlb.g:1241:4: (lv_name_1_0= ruleEString )
            // InternalXUmlb.g:1242:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getJunctionAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.XUmlb.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJunction"


    // $ANTLR start "entryRuleFork"
    // InternalXUmlb.g:1263:1: entryRuleFork returns [EObject current=null] : iv_ruleFork= ruleFork EOF ;
    public final EObject entryRuleFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFork = null;


        try {
            // InternalXUmlb.g:1263:45: (iv_ruleFork= ruleFork EOF )
            // InternalXUmlb.g:1264:2: iv_ruleFork= ruleFork EOF
            {
             newCompositeNode(grammarAccess.getForkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFork=ruleFork();

            state._fsp--;

             current =iv_ruleFork; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFork"


    // $ANTLR start "ruleFork"
    // InternalXUmlb.g:1270:1: ruleFork returns [EObject current=null] : (otherlv_0= 'fork' ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleFork() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:1276:2: ( (otherlv_0= 'fork' ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalXUmlb.g:1277:2: (otherlv_0= 'fork' ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalXUmlb.g:1277:2: (otherlv_0= 'fork' ( (lv_name_1_0= ruleEString ) ) )
            // InternalXUmlb.g:1278:3: otherlv_0= 'fork' ( (lv_name_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getForkAccess().getForkKeyword_0());
            		
            // InternalXUmlb.g:1282:3: ( (lv_name_1_0= ruleEString ) )
            // InternalXUmlb.g:1283:4: (lv_name_1_0= ruleEString )
            {
            // InternalXUmlb.g:1283:4: (lv_name_1_0= ruleEString )
            // InternalXUmlb.g:1284:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getForkAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForkRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.XUmlb.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFork"


    // $ANTLR start "entryRuleClassdiagram"
    // InternalXUmlb.g:1305:1: entryRuleClassdiagram returns [EObject current=null] : iv_ruleClassdiagram= ruleClassdiagram EOF ;
    public final EObject entryRuleClassdiagram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassdiagram = null;


        try {
            // InternalXUmlb.g:1305:53: (iv_ruleClassdiagram= ruleClassdiagram EOF )
            // InternalXUmlb.g:1306:2: iv_ruleClassdiagram= ruleClassdiagram EOF
            {
             newCompositeNode(grammarAccess.getClassdiagramRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClassdiagram=ruleClassdiagram();

            state._fsp--;

             current =iv_ruleClassdiagram; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassdiagram"


    // $ANTLR start "ruleClassdiagram"
    // InternalXUmlb.g:1312:1: ruleClassdiagram returns [EObject current=null] : ( () otherlv_1= 'classdiagram' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )? ( (lv_classes_5_0= ruleClass ) )* ( (lv_associations_6_0= ruleAssociation ) )* otherlv_7= 'end' ) ;
    public final EObject ruleClassdiagram() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_classes_5_0 = null;

        EObject lv_associations_6_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:1318:2: ( ( () otherlv_1= 'classdiagram' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )? ( (lv_classes_5_0= ruleClass ) )* ( (lv_associations_6_0= ruleAssociation ) )* otherlv_7= 'end' ) )
            // InternalXUmlb.g:1319:2: ( () otherlv_1= 'classdiagram' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )? ( (lv_classes_5_0= ruleClass ) )* ( (lv_associations_6_0= ruleAssociation ) )* otherlv_7= 'end' )
            {
            // InternalXUmlb.g:1319:2: ( () otherlv_1= 'classdiagram' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )? ( (lv_classes_5_0= ruleClass ) )* ( (lv_associations_6_0= ruleAssociation ) )* otherlv_7= 'end' )
            // InternalXUmlb.g:1320:3: () otherlv_1= 'classdiagram' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )? ( (lv_classes_5_0= ruleClass ) )* ( (lv_associations_6_0= ruleAssociation ) )* otherlv_7= 'end'
            {
            // InternalXUmlb.g:1320:3: ()
            // InternalXUmlb.g:1321:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClassdiagramAccess().getClassdiagramAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getClassdiagramAccess().getClassdiagramKeyword_1());
            		
            // InternalXUmlb.g:1331:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXUmlb.g:1332:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXUmlb.g:1332:4: (lv_name_2_0= RULE_ID )
            // InternalXUmlb.g:1333:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(lv_name_2_0, grammarAccess.getClassdiagramAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClassdiagramRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xumlb.XUmlb.ID");
            				

            }


            }

            // InternalXUmlb.g:1349:3: (otherlv_3= 'refines' ( ( ruleQualifiedName ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==14) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalXUmlb.g:1350:4: otherlv_3= 'refines' ( ( ruleQualifiedName ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getClassdiagramAccess().getRefinesKeyword_3_0());
                    			
                    // InternalXUmlb.g:1354:4: ( ( ruleQualifiedName ) )
                    // InternalXUmlb.g:1355:5: ( ruleQualifiedName )
                    {
                    // InternalXUmlb.g:1355:5: ( ruleQualifiedName )
                    // InternalXUmlb.g:1356:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClassdiagramRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getClassdiagramAccess().getRefinesClassdiagramCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_40);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:1371:3: ( (lv_classes_5_0= ruleClass ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==46) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalXUmlb.g:1372:4: (lv_classes_5_0= ruleClass )
            	    {
            	    // InternalXUmlb.g:1372:4: (lv_classes_5_0= ruleClass )
            	    // InternalXUmlb.g:1373:5: lv_classes_5_0= ruleClass
            	    {

            	    					newCompositeNode(grammarAccess.getClassdiagramAccess().getClassesClassParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_40);
            	    lv_classes_5_0=ruleClass();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getClassdiagramRule());
            	    					}
            	    					add(
            	    						current,
            	    						"classes",
            	    						lv_classes_5_0,
            	    						"ac.soton.xumlb.XUmlb.Class");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // InternalXUmlb.g:1390:3: ( (lv_associations_6_0= ruleAssociation ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==49) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalXUmlb.g:1391:4: (lv_associations_6_0= ruleAssociation )
            	    {
            	    // InternalXUmlb.g:1391:4: (lv_associations_6_0= ruleAssociation )
            	    // InternalXUmlb.g:1392:5: lv_associations_6_0= ruleAssociation
            	    {

            	    					newCompositeNode(grammarAccess.getClassdiagramAccess().getAssociationsAssociationParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_41);
            	    lv_associations_6_0=ruleAssociation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getClassdiagramRule());
            	    					}
            	    					add(
            	    						current,
            	    						"associations",
            	    						lv_associations_6_0,
            	    						"ac.soton.xumlb.XUmlb.Association");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_7=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getClassdiagramAccess().getEndKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassdiagram"


    // $ANTLR start "entryRuleClass"
    // InternalXUmlb.g:1417:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // InternalXUmlb.g:1417:46: (iv_ruleClass= ruleClass EOF )
            // InternalXUmlb.g:1418:2: iv_ruleClass= ruleClass EOF
            {
             newCompositeNode(grammarAccess.getClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClass=ruleClass();

            state._fsp--;

             current =iv_ruleClass; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // InternalXUmlb.g:1424:1: ruleClass returns [EObject current=null] : ( () otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'selfName' ( (lv_selfName_9_0= ruleEString ) ) )? (otherlv_10= 'instances' ( (lv_instances_11_0= ruleEString ) ) )? (otherlv_12= 'supertypes' ( ( ruleQualifiedName ) )+ )? (otherlv_14= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_16= 'statemachines' otherlv_17= 'begin' ( (lv_statemachines_18_0= ruleStatemachine ) )+ otherlv_19= 'end' )? ( (lv_classAttributes_20_0= ruleClassAttribute ) )* ( (lv_constraints_21_0= ruleClassConstraint ) )* ( (lv_methods_22_0= ruleClassMethod ) )* (otherlv_23= 'subtypeGroups' ( (lv_subtypeGroups_24_0= ruleSubtypeGroup ) )+ )? ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_23=null;
        Enumerator lv_dataKind_4_0 = null;

        AntlrDatatypeRuleToken lv_selfName_9_0 = null;

        AntlrDatatypeRuleToken lv_instances_11_0 = null;

        EObject lv_statemachines_18_0 = null;

        EObject lv_classAttributes_20_0 = null;

        EObject lv_constraints_21_0 = null;

        EObject lv_methods_22_0 = null;

        EObject lv_subtypeGroups_24_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:1430:2: ( ( () otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'selfName' ( (lv_selfName_9_0= ruleEString ) ) )? (otherlv_10= 'instances' ( (lv_instances_11_0= ruleEString ) ) )? (otherlv_12= 'supertypes' ( ( ruleQualifiedName ) )+ )? (otherlv_14= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_16= 'statemachines' otherlv_17= 'begin' ( (lv_statemachines_18_0= ruleStatemachine ) )+ otherlv_19= 'end' )? ( (lv_classAttributes_20_0= ruleClassAttribute ) )* ( (lv_constraints_21_0= ruleClassConstraint ) )* ( (lv_methods_22_0= ruleClassMethod ) )* (otherlv_23= 'subtypeGroups' ( (lv_subtypeGroups_24_0= ruleSubtypeGroup ) )+ )? ) )
            // InternalXUmlb.g:1431:2: ( () otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'selfName' ( (lv_selfName_9_0= ruleEString ) ) )? (otherlv_10= 'instances' ( (lv_instances_11_0= ruleEString ) ) )? (otherlv_12= 'supertypes' ( ( ruleQualifiedName ) )+ )? (otherlv_14= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_16= 'statemachines' otherlv_17= 'begin' ( (lv_statemachines_18_0= ruleStatemachine ) )+ otherlv_19= 'end' )? ( (lv_classAttributes_20_0= ruleClassAttribute ) )* ( (lv_constraints_21_0= ruleClassConstraint ) )* ( (lv_methods_22_0= ruleClassMethod ) )* (otherlv_23= 'subtypeGroups' ( (lv_subtypeGroups_24_0= ruleSubtypeGroup ) )+ )? )
            {
            // InternalXUmlb.g:1431:2: ( () otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'selfName' ( (lv_selfName_9_0= ruleEString ) ) )? (otherlv_10= 'instances' ( (lv_instances_11_0= ruleEString ) ) )? (otherlv_12= 'supertypes' ( ( ruleQualifiedName ) )+ )? (otherlv_14= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_16= 'statemachines' otherlv_17= 'begin' ( (lv_statemachines_18_0= ruleStatemachine ) )+ otherlv_19= 'end' )? ( (lv_classAttributes_20_0= ruleClassAttribute ) )* ( (lv_constraints_21_0= ruleClassConstraint ) )* ( (lv_methods_22_0= ruleClassMethod ) )* (otherlv_23= 'subtypeGroups' ( (lv_subtypeGroups_24_0= ruleSubtypeGroup ) )+ )? )
            // InternalXUmlb.g:1432:3: () otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'selfName' ( (lv_selfName_9_0= ruleEString ) ) )? (otherlv_10= 'instances' ( (lv_instances_11_0= ruleEString ) ) )? (otherlv_12= 'supertypes' ( ( ruleQualifiedName ) )+ )? (otherlv_14= 'refines' ( ( ruleQualifiedName ) ) )? (otherlv_16= 'statemachines' otherlv_17= 'begin' ( (lv_statemachines_18_0= ruleStatemachine ) )+ otherlv_19= 'end' )? ( (lv_classAttributes_20_0= ruleClassAttribute ) )* ( (lv_constraints_21_0= ruleClassConstraint ) )* ( (lv_methods_22_0= ruleClassMethod ) )* (otherlv_23= 'subtypeGroups' ( (lv_subtypeGroups_24_0= ruleSubtypeGroup ) )+ )?
            {
            // InternalXUmlb.g:1432:3: ()
            // InternalXUmlb.g:1433:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClassAccess().getClassAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getClassAccess().getClassKeyword_1());
            		
            // InternalXUmlb.g:1443:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXUmlb.g:1444:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXUmlb.g:1444:4: (lv_name_2_0= RULE_ID )
            // InternalXUmlb.g:1445:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_2_0, grammarAccess.getClassAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClassRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xumlb.XUmlb.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getClassAccess().getLeftParenthesisKeyword_3());
            		
            // InternalXUmlb.g:1465:3: ( (lv_dataKind_4_0= ruleDataKind ) )
            // InternalXUmlb.g:1466:4: (lv_dataKind_4_0= ruleDataKind )
            {
            // InternalXUmlb.g:1466:4: (lv_dataKind_4_0= ruleDataKind )
            // InternalXUmlb.g:1467:5: lv_dataKind_4_0= ruleDataKind
            {

            					newCompositeNode(grammarAccess.getClassAccess().getDataKindDataKindEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_9);
            lv_dataKind_4_0=ruleDataKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClassRule());
            					}
            					set(
            						current,
            						"dataKind",
            						lv_dataKind_4_0,
            						"ac.soton.xumlb.XUmlb.DataKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_43); 

            			newLeafNode(otherlv_5, grammarAccess.getClassAccess().getRightParenthesisKeyword_5());
            		
            // InternalXUmlb.g:1488:3: (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==13) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalXUmlb.g:1489:4: otherlv_6= 'elaborates' ( ( ruleQualifiedName ) )
                    {
                    otherlv_6=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getClassAccess().getElaboratesKeyword_6_0());
                    			
                    // InternalXUmlb.g:1493:4: ( ( ruleQualifiedName ) )
                    // InternalXUmlb.g:1494:5: ( ruleQualifiedName )
                    {
                    // InternalXUmlb.g:1494:5: ( ruleQualifiedName )
                    // InternalXUmlb.g:1495:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClassRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getClassAccess().getElaboratesEventBNamedCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_44);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:1510:3: (otherlv_8= 'selfName' ( (lv_selfName_9_0= ruleEString ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==19) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalXUmlb.g:1511:4: otherlv_8= 'selfName' ( (lv_selfName_9_0= ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_8, grammarAccess.getClassAccess().getSelfNameKeyword_7_0());
                    			
                    // InternalXUmlb.g:1515:4: ( (lv_selfName_9_0= ruleEString ) )
                    // InternalXUmlb.g:1516:5: (lv_selfName_9_0= ruleEString )
                    {
                    // InternalXUmlb.g:1516:5: (lv_selfName_9_0= ruleEString )
                    // InternalXUmlb.g:1517:6: lv_selfName_9_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getClassAccess().getSelfNameEStringParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_selfName_9_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClassRule());
                    						}
                    						set(
                    							current,
                    							"selfName",
                    							lv_selfName_9_0,
                    							"ac.soton.xumlb.XUmlb.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:1535:3: (otherlv_10= 'instances' ( (lv_instances_11_0= ruleEString ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==18) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalXUmlb.g:1536:4: otherlv_10= 'instances' ( (lv_instances_11_0= ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,18,FOLLOW_13); 

                    				newLeafNode(otherlv_10, grammarAccess.getClassAccess().getInstancesKeyword_8_0());
                    			
                    // InternalXUmlb.g:1540:4: ( (lv_instances_11_0= ruleEString ) )
                    // InternalXUmlb.g:1541:5: (lv_instances_11_0= ruleEString )
                    {
                    // InternalXUmlb.g:1541:5: (lv_instances_11_0= ruleEString )
                    // InternalXUmlb.g:1542:6: lv_instances_11_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getClassAccess().getInstancesEStringParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_46);
                    lv_instances_11_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClassRule());
                    						}
                    						set(
                    							current,
                    							"instances",
                    							lv_instances_11_0,
                    							"ac.soton.xumlb.XUmlb.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:1560:3: (otherlv_12= 'supertypes' ( ( ruleQualifiedName ) )+ )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==47) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalXUmlb.g:1561:4: otherlv_12= 'supertypes' ( ( ruleQualifiedName ) )+
                    {
                    otherlv_12=(Token)match(input,47,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getClassAccess().getSupertypesKeyword_9_0());
                    			
                    // InternalXUmlb.g:1565:4: ( ( ruleQualifiedName ) )+
                    int cnt39=0;
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==RULE_ID) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalXUmlb.g:1566:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalXUmlb.g:1566:5: ( ruleQualifiedName )
                    	    // InternalXUmlb.g:1567:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getClassRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getClassAccess().getSupertypesClassCrossReference_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_47);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt39 >= 1 ) break loop39;
                                EarlyExitException eee =
                                    new EarlyExitException(39, input);
                                throw eee;
                        }
                        cnt39++;
                    } while (true);


                    }
                    break;

            }

            // InternalXUmlb.g:1582:3: (otherlv_14= 'refines' ( ( ruleQualifiedName ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==14) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalXUmlb.g:1583:4: otherlv_14= 'refines' ( ( ruleQualifiedName ) )
                    {
                    otherlv_14=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getClassAccess().getRefinesKeyword_10_0());
                    			
                    // InternalXUmlb.g:1587:4: ( ( ruleQualifiedName ) )
                    // InternalXUmlb.g:1588:5: ( ruleQualifiedName )
                    {
                    // InternalXUmlb.g:1588:5: ( ruleQualifiedName )
                    // InternalXUmlb.g:1589:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClassRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getClassAccess().getRefinesClassCrossReference_10_1_0());
                    					
                    pushFollow(FOLLOW_48);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:1604:3: (otherlv_16= 'statemachines' otherlv_17= 'begin' ( (lv_statemachines_18_0= ruleStatemachine ) )+ otherlv_19= 'end' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==36) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalXUmlb.g:1605:4: otherlv_16= 'statemachines' otherlv_17= 'begin' ( (lv_statemachines_18_0= ruleStatemachine ) )+ otherlv_19= 'end'
                    {
                    otherlv_16=(Token)match(input,36,FOLLOW_32); 

                    				newLeafNode(otherlv_16, grammarAccess.getClassAccess().getStatemachinesKeyword_11_0());
                    			
                    otherlv_17=(Token)match(input,37,FOLLOW_33); 

                    				newLeafNode(otherlv_17, grammarAccess.getClassAccess().getBeginKeyword_11_1());
                    			
                    // InternalXUmlb.g:1613:4: ( (lv_statemachines_18_0= ruleStatemachine ) )+
                    int cnt42=0;
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==15) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalXUmlb.g:1614:5: (lv_statemachines_18_0= ruleStatemachine )
                    	    {
                    	    // InternalXUmlb.g:1614:5: (lv_statemachines_18_0= ruleStatemachine )
                    	    // InternalXUmlb.g:1615:6: lv_statemachines_18_0= ruleStatemachine
                    	    {

                    	    						newCompositeNode(grammarAccess.getClassAccess().getStatemachinesStatemachineParserRuleCall_11_2_0());
                    	    					
                    	    pushFollow(FOLLOW_34);
                    	    lv_statemachines_18_0=ruleStatemachine();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClassRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"statemachines",
                    	    							lv_statemachines_18_0,
                    	    							"ac.soton.xumlb.XUmlb.Statemachine");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt42 >= 1 ) break loop42;
                                EarlyExitException eee =
                                    new EarlyExitException(42, input);
                                throw eee;
                        }
                        cnt42++;
                    } while (true);

                    otherlv_19=(Token)match(input,20,FOLLOW_49); 

                    				newLeafNode(otherlv_19, grammarAccess.getClassAccess().getEndKeyword_11_3());
                    			

                    }
                    break;

            }

            // InternalXUmlb.g:1637:3: ( (lv_classAttributes_20_0= ruleClassAttribute ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==58) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalXUmlb.g:1638:4: (lv_classAttributes_20_0= ruleClassAttribute )
            	    {
            	    // InternalXUmlb.g:1638:4: (lv_classAttributes_20_0= ruleClassAttribute )
            	    // InternalXUmlb.g:1639:5: lv_classAttributes_20_0= ruleClassAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getClassAccess().getClassAttributesClassAttributeParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_49);
            	    lv_classAttributes_20_0=ruleClassAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getClassRule());
            	    					}
            	    					add(
            	    						current,
            	    						"classAttributes",
            	    						lv_classAttributes_20_0,
            	    						"ac.soton.xumlb.XUmlb.ClassAttribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            // InternalXUmlb.g:1656:3: ( (lv_constraints_21_0= ruleClassConstraint ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==59) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalXUmlb.g:1657:4: (lv_constraints_21_0= ruleClassConstraint )
            	    {
            	    // InternalXUmlb.g:1657:4: (lv_constraints_21_0= ruleClassConstraint )
            	    // InternalXUmlb.g:1658:5: lv_constraints_21_0= ruleClassConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getClassAccess().getConstraintsClassConstraintParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_50);
            	    lv_constraints_21_0=ruleClassConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getClassRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constraints",
            	    						lv_constraints_21_0,
            	    						"ac.soton.xumlb.XUmlb.ClassConstraint");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            // InternalXUmlb.g:1675:3: ( (lv_methods_22_0= ruleClassMethod ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==62) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalXUmlb.g:1676:4: (lv_methods_22_0= ruleClassMethod )
            	    {
            	    // InternalXUmlb.g:1676:4: (lv_methods_22_0= ruleClassMethod )
            	    // InternalXUmlb.g:1677:5: lv_methods_22_0= ruleClassMethod
            	    {

            	    					newCompositeNode(grammarAccess.getClassAccess().getMethodsClassMethodParserRuleCall_14_0());
            	    				
            	    pushFollow(FOLLOW_51);
            	    lv_methods_22_0=ruleClassMethod();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getClassRule());
            	    					}
            	    					add(
            	    						current,
            	    						"methods",
            	    						lv_methods_22_0,
            	    						"ac.soton.xumlb.XUmlb.ClassMethod");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            // InternalXUmlb.g:1694:3: (otherlv_23= 'subtypeGroups' ( (lv_subtypeGroups_24_0= ruleSubtypeGroup ) )+ )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==48) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalXUmlb.g:1695:4: otherlv_23= 'subtypeGroups' ( (lv_subtypeGroups_24_0= ruleSubtypeGroup ) )+
                    {
                    otherlv_23=(Token)match(input,48,FOLLOW_52); 

                    				newLeafNode(otherlv_23, grammarAccess.getClassAccess().getSubtypeGroupsKeyword_15_0());
                    			
                    // InternalXUmlb.g:1699:4: ( (lv_subtypeGroups_24_0= ruleSubtypeGroup ) )+
                    int cnt47=0;
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==55) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalXUmlb.g:1700:5: (lv_subtypeGroups_24_0= ruleSubtypeGroup )
                    	    {
                    	    // InternalXUmlb.g:1700:5: (lv_subtypeGroups_24_0= ruleSubtypeGroup )
                    	    // InternalXUmlb.g:1701:6: lv_subtypeGroups_24_0= ruleSubtypeGroup
                    	    {

                    	    						newCompositeNode(grammarAccess.getClassAccess().getSubtypeGroupsSubtypeGroupParserRuleCall_15_1_0());
                    	    					
                    	    pushFollow(FOLLOW_53);
                    	    lv_subtypeGroups_24_0=ruleSubtypeGroup();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClassRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"subtypeGroups",
                    	    							lv_subtypeGroups_24_0,
                    	    							"ac.soton.xumlb.XUmlb.SubtypeGroup");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt47 >= 1 ) break loop47;
                                EarlyExitException eee =
                                    new EarlyExitException(47, input);
                                throw eee;
                        }
                        cnt47++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleAssociation"
    // InternalXUmlb.g:1723:1: entryRuleAssociation returns [EObject current=null] : iv_ruleAssociation= ruleAssociation EOF ;
    public final EObject entryRuleAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociation = null;


        try {
            // InternalXUmlb.g:1723:52: (iv_ruleAssociation= ruleAssociation EOF )
            // InternalXUmlb.g:1724:2: iv_ruleAssociation= ruleAssociation EOF
            {
             newCompositeNode(grammarAccess.getAssociationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssociation=ruleAssociation();

            state._fsp--;

             current =iv_ruleAssociation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssociation"


    // $ANTLR start "ruleAssociation"
    // InternalXUmlb.g:1730:1: ruleAssociation returns [EObject current=null] : ( () otherlv_1= 'association' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? ( (lv_functional_8_0= 'functional' ) )? ( (lv_total_9_0= 'total' ) )? ( (lv_surjective_10_0= 'surjective' ) )? ( (lv_injective_11_0= 'injective' ) )? (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )? otherlv_14= 'source' ( ( ruleQualifiedName ) ) otherlv_16= 'target' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_functional_8_0=null;
        Token lv_total_9_0=null;
        Token lv_surjective_10_0=null;
        Token lv_injective_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Enumerator lv_dataKind_4_0 = null;

        AntlrDatatypeRuleToken lv_initialValue_13_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:1736:2: ( ( () otherlv_1= 'association' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? ( (lv_functional_8_0= 'functional' ) )? ( (lv_total_9_0= 'total' ) )? ( (lv_surjective_10_0= 'surjective' ) )? ( (lv_injective_11_0= 'injective' ) )? (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )? otherlv_14= 'source' ( ( ruleQualifiedName ) ) otherlv_16= 'target' ( ( ruleQualifiedName ) ) ) )
            // InternalXUmlb.g:1737:2: ( () otherlv_1= 'association' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? ( (lv_functional_8_0= 'functional' ) )? ( (lv_total_9_0= 'total' ) )? ( (lv_surjective_10_0= 'surjective' ) )? ( (lv_injective_11_0= 'injective' ) )? (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )? otherlv_14= 'source' ( ( ruleQualifiedName ) ) otherlv_16= 'target' ( ( ruleQualifiedName ) ) )
            {
            // InternalXUmlb.g:1737:2: ( () otherlv_1= 'association' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? ( (lv_functional_8_0= 'functional' ) )? ( (lv_total_9_0= 'total' ) )? ( (lv_surjective_10_0= 'surjective' ) )? ( (lv_injective_11_0= 'injective' ) )? (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )? otherlv_14= 'source' ( ( ruleQualifiedName ) ) otherlv_16= 'target' ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:1738:3: () otherlv_1= 'association' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? ( (lv_functional_8_0= 'functional' ) )? ( (lv_total_9_0= 'total' ) )? ( (lv_surjective_10_0= 'surjective' ) )? ( (lv_injective_11_0= 'injective' ) )? (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )? otherlv_14= 'source' ( ( ruleQualifiedName ) ) otherlv_16= 'target' ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:1738:3: ()
            // InternalXUmlb.g:1739:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAssociationAccess().getAssociationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getAssociationAccess().getAssociationKeyword_1());
            		
            // InternalXUmlb.g:1749:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXUmlb.g:1750:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXUmlb.g:1750:4: (lv_name_2_0= RULE_ID )
            // InternalXUmlb.g:1751:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_2_0, grammarAccess.getAssociationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssociationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xumlb.XUmlb.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getAssociationAccess().getLeftParenthesisKeyword_3());
            		
            // InternalXUmlb.g:1771:3: ( (lv_dataKind_4_0= ruleDataKind ) )
            // InternalXUmlb.g:1772:4: (lv_dataKind_4_0= ruleDataKind )
            {
            // InternalXUmlb.g:1772:4: (lv_dataKind_4_0= ruleDataKind )
            // InternalXUmlb.g:1773:5: lv_dataKind_4_0= ruleDataKind
            {

            					newCompositeNode(grammarAccess.getAssociationAccess().getDataKindDataKindEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_9);
            lv_dataKind_4_0=ruleDataKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssociationRule());
            					}
            					set(
            						current,
            						"dataKind",
            						lv_dataKind_4_0,
            						"ac.soton.xumlb.XUmlb.DataKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_54); 

            			newLeafNode(otherlv_5, grammarAccess.getAssociationAccess().getRightParenthesisKeyword_5());
            		
            // InternalXUmlb.g:1794:3: (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==13) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalXUmlb.g:1795:4: otherlv_6= 'elaborates' ( ( ruleQualifiedName ) )
                    {
                    otherlv_6=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getAssociationAccess().getElaboratesKeyword_6_0());
                    			
                    // InternalXUmlb.g:1799:4: ( ( ruleQualifiedName ) )
                    // InternalXUmlb.g:1800:5: ( ruleQualifiedName )
                    {
                    // InternalXUmlb.g:1800:5: ( ruleQualifiedName )
                    // InternalXUmlb.g:1801:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssociationRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAssociationAccess().getElaboratesEventBNamedCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_55);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:1816:3: ( (lv_functional_8_0= 'functional' ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==50) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalXUmlb.g:1817:4: (lv_functional_8_0= 'functional' )
                    {
                    // InternalXUmlb.g:1817:4: (lv_functional_8_0= 'functional' )
                    // InternalXUmlb.g:1818:5: lv_functional_8_0= 'functional'
                    {
                    lv_functional_8_0=(Token)match(input,50,FOLLOW_56); 

                    					newLeafNode(lv_functional_8_0, grammarAccess.getAssociationAccess().getFunctionalFunctionalKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAssociationRule());
                    					}
                    					setWithLastConsumed(current, "functional", lv_functional_8_0 != null, "functional");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:1830:3: ( (lv_total_9_0= 'total' ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==51) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalXUmlb.g:1831:4: (lv_total_9_0= 'total' )
                    {
                    // InternalXUmlb.g:1831:4: (lv_total_9_0= 'total' )
                    // InternalXUmlb.g:1832:5: lv_total_9_0= 'total'
                    {
                    lv_total_9_0=(Token)match(input,51,FOLLOW_57); 

                    					newLeafNode(lv_total_9_0, grammarAccess.getAssociationAccess().getTotalTotalKeyword_8_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAssociationRule());
                    					}
                    					setWithLastConsumed(current, "total", lv_total_9_0 != null, "total");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:1844:3: ( (lv_surjective_10_0= 'surjective' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==52) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalXUmlb.g:1845:4: (lv_surjective_10_0= 'surjective' )
                    {
                    // InternalXUmlb.g:1845:4: (lv_surjective_10_0= 'surjective' )
                    // InternalXUmlb.g:1846:5: lv_surjective_10_0= 'surjective'
                    {
                    lv_surjective_10_0=(Token)match(input,52,FOLLOW_58); 

                    					newLeafNode(lv_surjective_10_0, grammarAccess.getAssociationAccess().getSurjectiveSurjectiveKeyword_9_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAssociationRule());
                    					}
                    					setWithLastConsumed(current, "surjective", lv_surjective_10_0 != null, "surjective");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:1858:3: ( (lv_injective_11_0= 'injective' ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==53) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalXUmlb.g:1859:4: (lv_injective_11_0= 'injective' )
                    {
                    // InternalXUmlb.g:1859:4: (lv_injective_11_0= 'injective' )
                    // InternalXUmlb.g:1860:5: lv_injective_11_0= 'injective'
                    {
                    lv_injective_11_0=(Token)match(input,53,FOLLOW_59); 

                    					newLeafNode(lv_injective_11_0, grammarAccess.getAssociationAccess().getInjectiveInjectiveKeyword_10_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAssociationRule());
                    					}
                    					setWithLastConsumed(current, "injective", lv_injective_11_0 != null, "injective");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:1872:3: (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==54) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalXUmlb.g:1873:4: otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) )
                    {
                    otherlv_12=(Token)match(input,54,FOLLOW_13); 

                    				newLeafNode(otherlv_12, grammarAccess.getAssociationAccess().getInitialValueKeyword_11_0());
                    			
                    // InternalXUmlb.g:1877:4: ( (lv_initialValue_13_0= ruleEString ) )
                    // InternalXUmlb.g:1878:5: (lv_initialValue_13_0= ruleEString )
                    {
                    // InternalXUmlb.g:1878:5: (lv_initialValue_13_0= ruleEString )
                    // InternalXUmlb.g:1879:6: lv_initialValue_13_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getAssociationAccess().getInitialValueEStringParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_initialValue_13_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAssociationRule());
                    						}
                    						set(
                    							current,
                    							"initialValue",
                    							lv_initialValue_13_0,
                    							"ac.soton.xumlb.XUmlb.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_14, grammarAccess.getAssociationAccess().getSourceKeyword_12());
            		
            // InternalXUmlb.g:1901:3: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:1902:4: ( ruleQualifiedName )
            {
            // InternalXUmlb.g:1902:4: ( ruleQualifiedName )
            // InternalXUmlb.g:1903:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssociationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAssociationAccess().getSourceClassCrossReference_13_0());
            				
            pushFollow(FOLLOW_19);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_16=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_16, grammarAccess.getAssociationAccess().getTargetKeyword_14());
            		
            // InternalXUmlb.g:1921:3: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:1922:4: ( ruleQualifiedName )
            {
            // InternalXUmlb.g:1922:4: ( ruleQualifiedName )
            // InternalXUmlb.g:1923:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssociationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAssociationAccess().getTargetClassCrossReference_15_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssociation"


    // $ANTLR start "entryRuleSubtypeGroup"
    // InternalXUmlb.g:1941:1: entryRuleSubtypeGroup returns [EObject current=null] : iv_ruleSubtypeGroup= ruleSubtypeGroup EOF ;
    public final EObject entryRuleSubtypeGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubtypeGroup = null;


        try {
            // InternalXUmlb.g:1941:53: (iv_ruleSubtypeGroup= ruleSubtypeGroup EOF )
            // InternalXUmlb.g:1942:2: iv_ruleSubtypeGroup= ruleSubtypeGroup EOF
            {
             newCompositeNode(grammarAccess.getSubtypeGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubtypeGroup=ruleSubtypeGroup();

            state._fsp--;

             current =iv_ruleSubtypeGroup; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubtypeGroup"


    // $ANTLR start "ruleSubtypeGroup"
    // InternalXUmlb.g:1948:1: ruleSubtypeGroup returns [EObject current=null] : ( () otherlv_1= 'SubtypeGroup' ( (lv_name_2_0= RULE_ID ) ) ( (lv_cover_3_0= 'cover' ) )? ( (lv_disjoint_4_0= 'disjoint' ) )? ) ;
    public final EObject ruleSubtypeGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_cover_3_0=null;
        Token lv_disjoint_4_0=null;


        	enterRule();

        try {
            // InternalXUmlb.g:1954:2: ( ( () otherlv_1= 'SubtypeGroup' ( (lv_name_2_0= RULE_ID ) ) ( (lv_cover_3_0= 'cover' ) )? ( (lv_disjoint_4_0= 'disjoint' ) )? ) )
            // InternalXUmlb.g:1955:2: ( () otherlv_1= 'SubtypeGroup' ( (lv_name_2_0= RULE_ID ) ) ( (lv_cover_3_0= 'cover' ) )? ( (lv_disjoint_4_0= 'disjoint' ) )? )
            {
            // InternalXUmlb.g:1955:2: ( () otherlv_1= 'SubtypeGroup' ( (lv_name_2_0= RULE_ID ) ) ( (lv_cover_3_0= 'cover' ) )? ( (lv_disjoint_4_0= 'disjoint' ) )? )
            // InternalXUmlb.g:1956:3: () otherlv_1= 'SubtypeGroup' ( (lv_name_2_0= RULE_ID ) ) ( (lv_cover_3_0= 'cover' ) )? ( (lv_disjoint_4_0= 'disjoint' ) )?
            {
            // InternalXUmlb.g:1956:3: ()
            // InternalXUmlb.g:1957:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubtypeGroupAccess().getSubtypeGroupAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,55,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getSubtypeGroupAccess().getSubtypeGroupKeyword_1());
            		
            // InternalXUmlb.g:1967:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXUmlb.g:1968:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXUmlb.g:1968:4: (lv_name_2_0= RULE_ID )
            // InternalXUmlb.g:1969:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_60); 

            					newLeafNode(lv_name_2_0, grammarAccess.getSubtypeGroupAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubtypeGroupRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xumlb.XUmlb.ID");
            				

            }


            }

            // InternalXUmlb.g:1985:3: ( (lv_cover_3_0= 'cover' ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==56) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalXUmlb.g:1986:4: (lv_cover_3_0= 'cover' )
                    {
                    // InternalXUmlb.g:1986:4: (lv_cover_3_0= 'cover' )
                    // InternalXUmlb.g:1987:5: lv_cover_3_0= 'cover'
                    {
                    lv_cover_3_0=(Token)match(input,56,FOLLOW_61); 

                    					newLeafNode(lv_cover_3_0, grammarAccess.getSubtypeGroupAccess().getCoverCoverKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSubtypeGroupRule());
                    					}
                    					setWithLastConsumed(current, "cover", lv_cover_3_0 != null, "cover");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:1999:3: ( (lv_disjoint_4_0= 'disjoint' ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==57) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalXUmlb.g:2000:4: (lv_disjoint_4_0= 'disjoint' )
                    {
                    // InternalXUmlb.g:2000:4: (lv_disjoint_4_0= 'disjoint' )
                    // InternalXUmlb.g:2001:5: lv_disjoint_4_0= 'disjoint'
                    {
                    lv_disjoint_4_0=(Token)match(input,57,FOLLOW_2); 

                    					newLeafNode(lv_disjoint_4_0, grammarAccess.getSubtypeGroupAccess().getDisjointDisjointKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSubtypeGroupRule());
                    					}
                    					setWithLastConsumed(current, "disjoint", lv_disjoint_4_0 != null, "disjoint");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubtypeGroup"


    // $ANTLR start "entryRuleClassAttribute"
    // InternalXUmlb.g:2017:1: entryRuleClassAttribute returns [EObject current=null] : iv_ruleClassAttribute= ruleClassAttribute EOF ;
    public final EObject entryRuleClassAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassAttribute = null;


        try {
            // InternalXUmlb.g:2017:55: (iv_ruleClassAttribute= ruleClassAttribute EOF )
            // InternalXUmlb.g:2018:2: iv_ruleClassAttribute= ruleClassAttribute EOF
            {
             newCompositeNode(grammarAccess.getClassAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClassAttribute=ruleClassAttribute();

            state._fsp--;

             current =iv_ruleClassAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassAttribute"


    // $ANTLR start "ruleClassAttribute"
    // InternalXUmlb.g:2024:1: ruleClassAttribute returns [EObject current=null] : ( () otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? ( (lv_functional_8_0= 'functional' ) )? ( (lv_total_9_0= 'total' ) )? ( (lv_surjective_10_0= 'surjective' ) )? ( (lv_injective_11_0= 'injective' ) )? (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )? otherlv_14= 'target' ( (lv_target_15_0= ruleEString ) ) ) ;
    public final EObject ruleClassAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_functional_8_0=null;
        Token lv_total_9_0=null;
        Token lv_surjective_10_0=null;
        Token lv_injective_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Enumerator lv_dataKind_4_0 = null;

        AntlrDatatypeRuleToken lv_initialValue_13_0 = null;

        AntlrDatatypeRuleToken lv_target_15_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:2030:2: ( ( () otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? ( (lv_functional_8_0= 'functional' ) )? ( (lv_total_9_0= 'total' ) )? ( (lv_surjective_10_0= 'surjective' ) )? ( (lv_injective_11_0= 'injective' ) )? (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )? otherlv_14= 'target' ( (lv_target_15_0= ruleEString ) ) ) )
            // InternalXUmlb.g:2031:2: ( () otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? ( (lv_functional_8_0= 'functional' ) )? ( (lv_total_9_0= 'total' ) )? ( (lv_surjective_10_0= 'surjective' ) )? ( (lv_injective_11_0= 'injective' ) )? (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )? otherlv_14= 'target' ( (lv_target_15_0= ruleEString ) ) )
            {
            // InternalXUmlb.g:2031:2: ( () otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? ( (lv_functional_8_0= 'functional' ) )? ( (lv_total_9_0= 'total' ) )? ( (lv_surjective_10_0= 'surjective' ) )? ( (lv_injective_11_0= 'injective' ) )? (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )? otherlv_14= 'target' ( (lv_target_15_0= ruleEString ) ) )
            // InternalXUmlb.g:2032:3: () otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_dataKind_4_0= ruleDataKind ) ) otherlv_5= ')' (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )? ( (lv_functional_8_0= 'functional' ) )? ( (lv_total_9_0= 'total' ) )? ( (lv_surjective_10_0= 'surjective' ) )? ( (lv_injective_11_0= 'injective' ) )? (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )? otherlv_14= 'target' ( (lv_target_15_0= ruleEString ) )
            {
            // InternalXUmlb.g:2032:3: ()
            // InternalXUmlb.g:2033:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClassAttributeAccess().getClassAttributeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,58,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getClassAttributeAccess().getAttributeKeyword_1());
            		
            // InternalXUmlb.g:2043:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXUmlb.g:2044:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXUmlb.g:2044:4: (lv_name_2_0= RULE_ID )
            // InternalXUmlb.g:2045:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_2_0, grammarAccess.getClassAttributeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClassAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xumlb.XUmlb.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getClassAttributeAccess().getLeftParenthesisKeyword_3());
            		
            // InternalXUmlb.g:2065:3: ( (lv_dataKind_4_0= ruleDataKind ) )
            // InternalXUmlb.g:2066:4: (lv_dataKind_4_0= ruleDataKind )
            {
            // InternalXUmlb.g:2066:4: (lv_dataKind_4_0= ruleDataKind )
            // InternalXUmlb.g:2067:5: lv_dataKind_4_0= ruleDataKind
            {

            					newCompositeNode(grammarAccess.getClassAttributeAccess().getDataKindDataKindEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_9);
            lv_dataKind_4_0=ruleDataKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClassAttributeRule());
            					}
            					set(
            						current,
            						"dataKind",
            						lv_dataKind_4_0,
            						"ac.soton.xumlb.XUmlb.DataKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_62); 

            			newLeafNode(otherlv_5, grammarAccess.getClassAttributeAccess().getRightParenthesisKeyword_5());
            		
            // InternalXUmlb.g:2088:3: (otherlv_6= 'elaborates' ( ( ruleQualifiedName ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==13) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalXUmlb.g:2089:4: otherlv_6= 'elaborates' ( ( ruleQualifiedName ) )
                    {
                    otherlv_6=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getClassAttributeAccess().getElaboratesKeyword_6_0());
                    			
                    // InternalXUmlb.g:2093:4: ( ( ruleQualifiedName ) )
                    // InternalXUmlb.g:2094:5: ( ruleQualifiedName )
                    {
                    // InternalXUmlb.g:2094:5: ( ruleQualifiedName )
                    // InternalXUmlb.g:2095:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClassAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getClassAttributeAccess().getElaboratesEventBNamedCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_63);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXUmlb.g:2110:3: ( (lv_functional_8_0= 'functional' ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==50) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalXUmlb.g:2111:4: (lv_functional_8_0= 'functional' )
                    {
                    // InternalXUmlb.g:2111:4: (lv_functional_8_0= 'functional' )
                    // InternalXUmlb.g:2112:5: lv_functional_8_0= 'functional'
                    {
                    lv_functional_8_0=(Token)match(input,50,FOLLOW_64); 

                    					newLeafNode(lv_functional_8_0, grammarAccess.getClassAttributeAccess().getFunctionalFunctionalKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClassAttributeRule());
                    					}
                    					setWithLastConsumed(current, "functional", lv_functional_8_0 != null, "functional");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:2124:3: ( (lv_total_9_0= 'total' ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==51) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalXUmlb.g:2125:4: (lv_total_9_0= 'total' )
                    {
                    // InternalXUmlb.g:2125:4: (lv_total_9_0= 'total' )
                    // InternalXUmlb.g:2126:5: lv_total_9_0= 'total'
                    {
                    lv_total_9_0=(Token)match(input,51,FOLLOW_65); 

                    					newLeafNode(lv_total_9_0, grammarAccess.getClassAttributeAccess().getTotalTotalKeyword_8_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClassAttributeRule());
                    					}
                    					setWithLastConsumed(current, "total", lv_total_9_0 != null, "total");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:2138:3: ( (lv_surjective_10_0= 'surjective' ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==52) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalXUmlb.g:2139:4: (lv_surjective_10_0= 'surjective' )
                    {
                    // InternalXUmlb.g:2139:4: (lv_surjective_10_0= 'surjective' )
                    // InternalXUmlb.g:2140:5: lv_surjective_10_0= 'surjective'
                    {
                    lv_surjective_10_0=(Token)match(input,52,FOLLOW_66); 

                    					newLeafNode(lv_surjective_10_0, grammarAccess.getClassAttributeAccess().getSurjectiveSurjectiveKeyword_9_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClassAttributeRule());
                    					}
                    					setWithLastConsumed(current, "surjective", lv_surjective_10_0 != null, "surjective");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:2152:3: ( (lv_injective_11_0= 'injective' ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==53) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalXUmlb.g:2153:4: (lv_injective_11_0= 'injective' )
                    {
                    // InternalXUmlb.g:2153:4: (lv_injective_11_0= 'injective' )
                    // InternalXUmlb.g:2154:5: lv_injective_11_0= 'injective'
                    {
                    lv_injective_11_0=(Token)match(input,53,FOLLOW_67); 

                    					newLeafNode(lv_injective_11_0, grammarAccess.getClassAttributeAccess().getInjectiveInjectiveKeyword_10_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClassAttributeRule());
                    					}
                    					setWithLastConsumed(current, "injective", lv_injective_11_0 != null, "injective");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:2166:3: (otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==54) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalXUmlb.g:2167:4: otherlv_12= 'initialValue' ( (lv_initialValue_13_0= ruleEString ) )
                    {
                    otherlv_12=(Token)match(input,54,FOLLOW_13); 

                    				newLeafNode(otherlv_12, grammarAccess.getClassAttributeAccess().getInitialValueKeyword_11_0());
                    			
                    // InternalXUmlb.g:2171:4: ( (lv_initialValue_13_0= ruleEString ) )
                    // InternalXUmlb.g:2172:5: (lv_initialValue_13_0= ruleEString )
                    {
                    // InternalXUmlb.g:2172:5: (lv_initialValue_13_0= ruleEString )
                    // InternalXUmlb.g:2173:6: lv_initialValue_13_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getClassAttributeAccess().getInitialValueEStringParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_initialValue_13_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClassAttributeRule());
                    						}
                    						set(
                    							current,
                    							"initialValue",
                    							lv_initialValue_13_0,
                    							"ac.soton.xumlb.XUmlb.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,24,FOLLOW_13); 

            			newLeafNode(otherlv_14, grammarAccess.getClassAttributeAccess().getTargetKeyword_12());
            		
            // InternalXUmlb.g:2195:3: ( (lv_target_15_0= ruleEString ) )
            // InternalXUmlb.g:2196:4: (lv_target_15_0= ruleEString )
            {
            // InternalXUmlb.g:2196:4: (lv_target_15_0= ruleEString )
            // InternalXUmlb.g:2197:5: lv_target_15_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getClassAttributeAccess().getTargetEStringParserRuleCall_13_0());
            				
            pushFollow(FOLLOW_2);
            lv_target_15_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClassAttributeRule());
            					}
            					set(
            						current,
            						"target",
            						lv_target_15_0,
            						"ac.soton.xumlb.XUmlb.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassAttribute"


    // $ANTLR start "entryRuleClassConstraint"
    // InternalXUmlb.g:2218:1: entryRuleClassConstraint returns [EObject current=null] : iv_ruleClassConstraint= ruleClassConstraint EOF ;
    public final EObject entryRuleClassConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassConstraint = null;


        try {
            // InternalXUmlb.g:2218:56: (iv_ruleClassConstraint= ruleClassConstraint EOF )
            // InternalXUmlb.g:2219:2: iv_ruleClassConstraint= ruleClassConstraint EOF
            {
             newCompositeNode(grammarAccess.getClassConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClassConstraint=ruleClassConstraint();

            state._fsp--;

             current =iv_ruleClassConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassConstraint"


    // $ANTLR start "ruleClassConstraint"
    // InternalXUmlb.g:2225:1: ruleClassConstraint returns [EObject current=null] : ( () otherlv_1= 'constraint' ( (lv_theorem_2_0= 'theorem' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (lv_predicate_4_0= ruleXFormula ) ) otherlv_5= 'component' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleClassConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_theorem_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_predicate_4_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:2231:2: ( ( () otherlv_1= 'constraint' ( (lv_theorem_2_0= 'theorem' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (lv_predicate_4_0= ruleXFormula ) ) otherlv_5= 'component' ( ( ruleQualifiedName ) ) ) )
            // InternalXUmlb.g:2232:2: ( () otherlv_1= 'constraint' ( (lv_theorem_2_0= 'theorem' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (lv_predicate_4_0= ruleXFormula ) ) otherlv_5= 'component' ( ( ruleQualifiedName ) ) )
            {
            // InternalXUmlb.g:2232:2: ( () otherlv_1= 'constraint' ( (lv_theorem_2_0= 'theorem' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (lv_predicate_4_0= ruleXFormula ) ) otherlv_5= 'component' ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:2233:3: () otherlv_1= 'constraint' ( (lv_theorem_2_0= 'theorem' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (lv_predicate_4_0= ruleXFormula ) ) otherlv_5= 'component' ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:2233:3: ()
            // InternalXUmlb.g:2234:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClassConstraintAccess().getClassConstraintAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,59,FOLLOW_68); 

            			newLeafNode(otherlv_1, grammarAccess.getClassConstraintAccess().getConstraintKeyword_1());
            		
            // InternalXUmlb.g:2244:3: ( (lv_theorem_2_0= 'theorem' ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==60) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalXUmlb.g:2245:4: (lv_theorem_2_0= 'theorem' )
                    {
                    // InternalXUmlb.g:2245:4: (lv_theorem_2_0= 'theorem' )
                    // InternalXUmlb.g:2246:5: lv_theorem_2_0= 'theorem'
                    {
                    lv_theorem_2_0=(Token)match(input,60,FOLLOW_3); 

                    					newLeafNode(lv_theorem_2_0, grammarAccess.getClassConstraintAccess().getTheoremTheoremKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClassConstraintRule());
                    					}
                    					setWithLastConsumed(current, "theorem", lv_theorem_2_0 != null, "theorem");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:2258:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalXUmlb.g:2259:4: (lv_name_3_0= RULE_ID )
            {
            // InternalXUmlb.g:2259:4: (lv_name_3_0= RULE_ID )
            // InternalXUmlb.g:2260:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_69); 

            					newLeafNode(lv_name_3_0, grammarAccess.getClassConstraintAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClassConstraintRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"ac.soton.xumlb.XUmlb.ID");
            				

            }


            }

            // InternalXUmlb.g:2276:3: ( (lv_predicate_4_0= ruleXFormula ) )
            // InternalXUmlb.g:2277:4: (lv_predicate_4_0= ruleXFormula )
            {
            // InternalXUmlb.g:2277:4: (lv_predicate_4_0= ruleXFormula )
            // InternalXUmlb.g:2278:5: lv_predicate_4_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getClassConstraintAccess().getPredicateXFormulaParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_70);
            lv_predicate_4_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClassConstraintRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_4_0,
            						"ac.soton.xumlb.XUmlb.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,61,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getClassConstraintAccess().getComponentKeyword_5());
            		
            // InternalXUmlb.g:2299:3: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:2300:4: ( ruleQualifiedName )
            {
            // InternalXUmlb.g:2300:4: ( ruleQualifiedName )
            // InternalXUmlb.g:2301:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClassConstraintRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClassConstraintAccess().getComponentEventBNamedCommentedComponentElementCrossReference_6_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassConstraint"


    // $ANTLR start "entryRuleClassMethod"
    // InternalXUmlb.g:2319:1: entryRuleClassMethod returns [EObject current=null] : iv_ruleClassMethod= ruleClassMethod EOF ;
    public final EObject entryRuleClassMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassMethod = null;


        try {
            // InternalXUmlb.g:2319:52: (iv_ruleClassMethod= ruleClassMethod EOF )
            // InternalXUmlb.g:2320:2: iv_ruleClassMethod= ruleClassMethod EOF
            {
             newCompositeNode(grammarAccess.getClassMethodRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClassMethod=ruleClassMethod();

            state._fsp--;

             current =iv_ruleClassMethod; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassMethod"


    // $ANTLR start "ruleClassMethod"
    // InternalXUmlb.g:2326:1: ruleClassMethod returns [EObject current=null] : ( () otherlv_1= 'method' otherlv_2= 'kind' ( (lv_kind_3_0= ruleMethodKind ) ) (otherlv_4= 'elaborates' ( ( ruleQualifiedName ) )+ )? ( (lv_extended_6_0= 'extended' ) )? (otherlv_7= 'any' ( (lv_parameters_8_0= ruleTypedParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleTypedParameter ) ) )* )? (otherlv_11= 'where' ( (lv_guards_12_0= ruleGuard ) )+ )? (otherlv_13= 'then' ( (lv_actions_14_0= ruleAction ) )+ )? (otherlv_15= 'with' ( (lv_witnesses_16_0= ruleWitness ) )+ )? otherlv_17= 'end' ) ;
    public final EObject ruleClassMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_extended_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Enumerator lv_kind_3_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_guards_12_0 = null;

        EObject lv_actions_14_0 = null;

        EObject lv_witnesses_16_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:2332:2: ( ( () otherlv_1= 'method' otherlv_2= 'kind' ( (lv_kind_3_0= ruleMethodKind ) ) (otherlv_4= 'elaborates' ( ( ruleQualifiedName ) )+ )? ( (lv_extended_6_0= 'extended' ) )? (otherlv_7= 'any' ( (lv_parameters_8_0= ruleTypedParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleTypedParameter ) ) )* )? (otherlv_11= 'where' ( (lv_guards_12_0= ruleGuard ) )+ )? (otherlv_13= 'then' ( (lv_actions_14_0= ruleAction ) )+ )? (otherlv_15= 'with' ( (lv_witnesses_16_0= ruleWitness ) )+ )? otherlv_17= 'end' ) )
            // InternalXUmlb.g:2333:2: ( () otherlv_1= 'method' otherlv_2= 'kind' ( (lv_kind_3_0= ruleMethodKind ) ) (otherlv_4= 'elaborates' ( ( ruleQualifiedName ) )+ )? ( (lv_extended_6_0= 'extended' ) )? (otherlv_7= 'any' ( (lv_parameters_8_0= ruleTypedParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleTypedParameter ) ) )* )? (otherlv_11= 'where' ( (lv_guards_12_0= ruleGuard ) )+ )? (otherlv_13= 'then' ( (lv_actions_14_0= ruleAction ) )+ )? (otherlv_15= 'with' ( (lv_witnesses_16_0= ruleWitness ) )+ )? otherlv_17= 'end' )
            {
            // InternalXUmlb.g:2333:2: ( () otherlv_1= 'method' otherlv_2= 'kind' ( (lv_kind_3_0= ruleMethodKind ) ) (otherlv_4= 'elaborates' ( ( ruleQualifiedName ) )+ )? ( (lv_extended_6_0= 'extended' ) )? (otherlv_7= 'any' ( (lv_parameters_8_0= ruleTypedParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleTypedParameter ) ) )* )? (otherlv_11= 'where' ( (lv_guards_12_0= ruleGuard ) )+ )? (otherlv_13= 'then' ( (lv_actions_14_0= ruleAction ) )+ )? (otherlv_15= 'with' ( (lv_witnesses_16_0= ruleWitness ) )+ )? otherlv_17= 'end' )
            // InternalXUmlb.g:2334:3: () otherlv_1= 'method' otherlv_2= 'kind' ( (lv_kind_3_0= ruleMethodKind ) ) (otherlv_4= 'elaborates' ( ( ruleQualifiedName ) )+ )? ( (lv_extended_6_0= 'extended' ) )? (otherlv_7= 'any' ( (lv_parameters_8_0= ruleTypedParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleTypedParameter ) ) )* )? (otherlv_11= 'where' ( (lv_guards_12_0= ruleGuard ) )+ )? (otherlv_13= 'then' ( (lv_actions_14_0= ruleAction ) )+ )? (otherlv_15= 'with' ( (lv_witnesses_16_0= ruleWitness ) )+ )? otherlv_17= 'end'
            {
            // InternalXUmlb.g:2334:3: ()
            // InternalXUmlb.g:2335:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClassMethodAccess().getClassMethodAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,62,FOLLOW_71); 

            			newLeafNode(otherlv_1, grammarAccess.getClassMethodAccess().getMethodKeyword_1());
            		
            otherlv_2=(Token)match(input,63,FOLLOW_72); 

            			newLeafNode(otherlv_2, grammarAccess.getClassMethodAccess().getKindKeyword_2());
            		
            // InternalXUmlb.g:2349:3: ( (lv_kind_3_0= ruleMethodKind ) )
            // InternalXUmlb.g:2350:4: (lv_kind_3_0= ruleMethodKind )
            {
            // InternalXUmlb.g:2350:4: (lv_kind_3_0= ruleMethodKind )
            // InternalXUmlb.g:2351:5: lv_kind_3_0= ruleMethodKind
            {

            					newCompositeNode(grammarAccess.getClassMethodAccess().getKindMethodKindEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_73);
            lv_kind_3_0=ruleMethodKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClassMethodRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_3_0,
            						"ac.soton.xumlb.XUmlb.MethodKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXUmlb.g:2368:3: (otherlv_4= 'elaborates' ( ( ruleQualifiedName ) )+ )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==13) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalXUmlb.g:2369:4: otherlv_4= 'elaborates' ( ( ruleQualifiedName ) )+
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getClassMethodAccess().getElaboratesKeyword_4_0());
                    			
                    // InternalXUmlb.g:2373:4: ( ( ruleQualifiedName ) )+
                    int cnt64=0;
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==RULE_ID) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalXUmlb.g:2374:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalXUmlb.g:2374:5: ( ruleQualifiedName )
                    	    // InternalXUmlb.g:2375:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getClassMethodRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getClassMethodAccess().getElaboratesEventCrossReference_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_74);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt64 >= 1 ) break loop64;
                                EarlyExitException eee =
                                    new EarlyExitException(64, input);
                                throw eee;
                        }
                        cnt64++;
                    } while (true);


                    }
                    break;

            }

            // InternalXUmlb.g:2390:3: ( (lv_extended_6_0= 'extended' ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==22) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalXUmlb.g:2391:4: (lv_extended_6_0= 'extended' )
                    {
                    // InternalXUmlb.g:2391:4: (lv_extended_6_0= 'extended' )
                    // InternalXUmlb.g:2392:5: lv_extended_6_0= 'extended'
                    {
                    lv_extended_6_0=(Token)match(input,22,FOLLOW_20); 

                    					newLeafNode(lv_extended_6_0, grammarAccess.getClassMethodAccess().getExtendedExtendedKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClassMethodRule());
                    					}
                    					setWithLastConsumed(current, "extended", lv_extended_6_0 != null, "extended");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:2404:3: (otherlv_7= 'any' ( (lv_parameters_8_0= ruleTypedParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleTypedParameter ) ) )* )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==25) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalXUmlb.g:2405:4: otherlv_7= 'any' ( (lv_parameters_8_0= ruleTypedParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleTypedParameter ) ) )*
                    {
                    otherlv_7=(Token)match(input,25,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getClassMethodAccess().getAnyKeyword_6_0());
                    			
                    // InternalXUmlb.g:2409:4: ( (lv_parameters_8_0= ruleTypedParameter ) )
                    // InternalXUmlb.g:2410:5: (lv_parameters_8_0= ruleTypedParameter )
                    {
                    // InternalXUmlb.g:2410:5: (lv_parameters_8_0= ruleTypedParameter )
                    // InternalXUmlb.g:2411:6: lv_parameters_8_0= ruleTypedParameter
                    {

                    						newCompositeNode(grammarAccess.getClassMethodAccess().getParametersTypedParameterParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_parameters_8_0=ruleTypedParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClassMethodRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_8_0,
                    							"ac.soton.xumlb.XUmlb.TypedParameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalXUmlb.g:2428:4: (otherlv_9= ',' ( (lv_parameters_10_0= ruleTypedParameter ) ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==26) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalXUmlb.g:2429:5: otherlv_9= ',' ( (lv_parameters_10_0= ruleTypedParameter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,26,FOLLOW_3); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getClassMethodAccess().getCommaKeyword_6_2_0());
                    	    				
                    	    // InternalXUmlb.g:2433:5: ( (lv_parameters_10_0= ruleTypedParameter ) )
                    	    // InternalXUmlb.g:2434:6: (lv_parameters_10_0= ruleTypedParameter )
                    	    {
                    	    // InternalXUmlb.g:2434:6: (lv_parameters_10_0= ruleTypedParameter )
                    	    // InternalXUmlb.g:2435:7: lv_parameters_10_0= ruleTypedParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getClassMethodAccess().getParametersTypedParameterParserRuleCall_6_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_parameters_10_0=ruleTypedParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getClassMethodRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_10_0,
                    	    								"ac.soton.xumlb.XUmlb.TypedParameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalXUmlb.g:2454:3: (otherlv_11= 'where' ( (lv_guards_12_0= ruleGuard ) )+ )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==27) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalXUmlb.g:2455:4: otherlv_11= 'where' ( (lv_guards_12_0= ruleGuard ) )+
                    {
                    otherlv_11=(Token)match(input,27,FOLLOW_22); 

                    				newLeafNode(otherlv_11, grammarAccess.getClassMethodAccess().getWhereKeyword_7_0());
                    			
                    // InternalXUmlb.g:2459:4: ( (lv_guards_12_0= ruleGuard ) )+
                    int cnt69=0;
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==RULE_XLABEL||LA69_0==60) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // InternalXUmlb.g:2460:5: (lv_guards_12_0= ruleGuard )
                    	    {
                    	    // InternalXUmlb.g:2460:5: (lv_guards_12_0= ruleGuard )
                    	    // InternalXUmlb.g:2461:6: lv_guards_12_0= ruleGuard
                    	    {

                    	    						newCompositeNode(grammarAccess.getClassMethodAccess().getGuardsGuardParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_23);
                    	    lv_guards_12_0=ruleGuard();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClassMethodRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"guards",
                    	    							lv_guards_12_0,
                    	    							"ac.soton.xumlb.XUmlb.Guard");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt69 >= 1 ) break loop69;
                                EarlyExitException eee =
                                    new EarlyExitException(69, input);
                                throw eee;
                        }
                        cnt69++;
                    } while (true);


                    }
                    break;

            }

            // InternalXUmlb.g:2479:3: (otherlv_13= 'then' ( (lv_actions_14_0= ruleAction ) )+ )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==28) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalXUmlb.g:2480:4: otherlv_13= 'then' ( (lv_actions_14_0= ruleAction ) )+
                    {
                    otherlv_13=(Token)match(input,28,FOLLOW_24); 

                    				newLeafNode(otherlv_13, grammarAccess.getClassMethodAccess().getThenKeyword_8_0());
                    			
                    // InternalXUmlb.g:2484:4: ( (lv_actions_14_0= ruleAction ) )+
                    int cnt71=0;
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==RULE_XLABEL) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // InternalXUmlb.g:2485:5: (lv_actions_14_0= ruleAction )
                    	    {
                    	    // InternalXUmlb.g:2485:5: (lv_actions_14_0= ruleAction )
                    	    // InternalXUmlb.g:2486:6: lv_actions_14_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getClassMethodAccess().getActionsActionParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_25);
                    	    lv_actions_14_0=ruleAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClassMethodRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"actions",
                    	    							lv_actions_14_0,
                    	    							"ac.soton.xumlb.XUmlb.Action");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt71 >= 1 ) break loop71;
                                EarlyExitException eee =
                                    new EarlyExitException(71, input);
                                throw eee;
                        }
                        cnt71++;
                    } while (true);


                    }
                    break;

            }

            // InternalXUmlb.g:2504:3: (otherlv_15= 'with' ( (lv_witnesses_16_0= ruleWitness ) )+ )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==29) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalXUmlb.g:2505:4: otherlv_15= 'with' ( (lv_witnesses_16_0= ruleWitness ) )+
                    {
                    otherlv_15=(Token)match(input,29,FOLLOW_24); 

                    				newLeafNode(otherlv_15, grammarAccess.getClassMethodAccess().getWithKeyword_9_0());
                    			
                    // InternalXUmlb.g:2509:4: ( (lv_witnesses_16_0= ruleWitness ) )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==RULE_XLABEL) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalXUmlb.g:2510:5: (lv_witnesses_16_0= ruleWitness )
                    	    {
                    	    // InternalXUmlb.g:2510:5: (lv_witnesses_16_0= ruleWitness )
                    	    // InternalXUmlb.g:2511:6: lv_witnesses_16_0= ruleWitness
                    	    {

                    	    						newCompositeNode(grammarAccess.getClassMethodAccess().getWitnessesWitnessParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_26);
                    	    lv_witnesses_16_0=ruleWitness();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClassMethodRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"witnesses",
                    	    							lv_witnesses_16_0,
                    	    							"ac.soton.xumlb.XUmlb.Witness");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt73 >= 1 ) break loop73;
                                EarlyExitException eee =
                                    new EarlyExitException(73, input);
                                throw eee;
                        }
                        cnt73++;
                    } while (true);


                    }
                    break;

            }

            otherlv_17=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getClassMethodAccess().getEndKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassMethod"


    // $ANTLR start "entryRuleEString"
    // InternalXUmlb.g:2537:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalXUmlb.g:2537:47: (iv_ruleEString= ruleEString EOF )
            // InternalXUmlb.g:2538:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalXUmlb.g:2544:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalXUmlb.g:2550:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalXUmlb.g:2551:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalXUmlb.g:2551:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_STRING) ) {
                alt75=1;
            }
            else if ( (LA75_0==RULE_ID) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalXUmlb.g:2552:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:2560:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalXUmlb.g:2571:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalXUmlb.g:2571:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalXUmlb.g:2572:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalXUmlb.g:2578:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalXUmlb.g:2584:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) )
            // InternalXUmlb.g:2585:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            {
            // InternalXUmlb.g:2585:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            // InternalXUmlb.g:2586:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_75); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalXUmlb.g:2593:3: (kw= '.' this_ID_2= RULE_ID )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==64) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalXUmlb.g:2594:4: kw= '.' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,64,FOLLOW_3); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
                    			
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    				current.merge(this_ID_2);
                    			

                    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleXFormula"
    // InternalXUmlb.g:2611:1: entryRuleXFormula returns [String current=null] : iv_ruleXFormula= ruleXFormula EOF ;
    public final String entryRuleXFormula() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXFormula = null;


        try {
            // InternalXUmlb.g:2611:48: (iv_ruleXFormula= ruleXFormula EOF )
            // InternalXUmlb.g:2612:2: iv_ruleXFormula= ruleXFormula EOF
            {
             newCompositeNode(grammarAccess.getXFormulaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXFormula=ruleXFormula();

            state._fsp--;

             current =iv_ruleXFormula.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFormula"


    // $ANTLR start "ruleXFormula"
    // InternalXUmlb.g:2618:1: ruleXFormula returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+ ;
    public final AntlrDatatypeRuleToken ruleXFormula() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_3=null;
        Token this_INT_4=null;
        AntlrDatatypeRuleToken this_EVENTB_IDENTIFIER_KEYWORD_0 = null;

        AntlrDatatypeRuleToken this_EVENTB_PREDICATE_SYMBOLS_1 = null;

        AntlrDatatypeRuleToken this_EVENTB_EXPRESSION_SYMBOLS_2 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:2624:2: ( (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+ )
            // InternalXUmlb.g:2625:2: (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+
            {
            // InternalXUmlb.g:2625:2: (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT )+
            int cnt77=0;
            loop77:
            do {
                int alt77=6;
                switch ( input.LA(1) ) {
                case 32:
                case 33:
                case 34:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                    {
                    alt77=1;
                    }
                    break;
                case 16:
                case 17:
                case 26:
                case 30:
                case 64:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                    {
                    alt77=2;
                    }
                    break;
                case 31:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 144:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 153:
                case 154:
                case 155:
                    {
                    alt77=3;
                    }
                    break;
                case RULE_ID:
                    {
                    alt77=4;
                    }
                    break;
                case RULE_INT:
                    {
                    alt77=5;
                    }
                    break;

                }

                switch (alt77) {
            	case 1 :
            	    // InternalXUmlb.g:2626:3: this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_0());
            	    		
            	    pushFollow(FOLLOW_76);
            	    this_EVENTB_IDENTIFIER_KEYWORD_0=ruleEVENTB_IDENTIFIER_KEYWORD();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_IDENTIFIER_KEYWORD_0);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalXUmlb.g:2637:3: this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_PREDICATE_SYMBOLSParserRuleCall_1());
            	    		
            	    pushFollow(FOLLOW_76);
            	    this_EVENTB_PREDICATE_SYMBOLS_1=ruleEVENTB_PREDICATE_SYMBOLS();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_PREDICATE_SYMBOLS_1);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalXUmlb.g:2648:3: this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_EXPRESSION_SYMBOLSParserRuleCall_2());
            	    		
            	    pushFollow(FOLLOW_76);
            	    this_EVENTB_EXPRESSION_SYMBOLS_2=ruleEVENTB_EXPRESSION_SYMBOLS();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_EXPRESSION_SYMBOLS_2);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalXUmlb.g:2659:3: this_ID_3= RULE_ID
            	    {
            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_76); 

            	    			current.merge(this_ID_3);
            	    		

            	    			newLeafNode(this_ID_3, grammarAccess.getXFormulaAccess().getIDTerminalRuleCall_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalXUmlb.g:2667:3: this_INT_4= RULE_INT
            	    {
            	    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_76); 

            	    			current.merge(this_INT_4);
            	    		

            	    			newLeafNode(this_INT_4, grammarAccess.getXFormulaAccess().getINTTerminalRuleCall_4());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt77 >= 1 ) break loop77;
                        EarlyExitException eee =
                            new EarlyExitException(77, input);
                        throw eee;
                }
                cnt77++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXFormula"


    // $ANTLR start "entryRuleEVENTB_IDENTIFIER_KEYWORD"
    // InternalXUmlb.g:2678:1: entryRuleEVENTB_IDENTIFIER_KEYWORD returns [String current=null] : iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF ;
    public final String entryRuleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_IDENTIFIER_KEYWORD = null;


        try {
            // InternalXUmlb.g:2678:65: (iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF )
            // InternalXUmlb.g:2679:2: iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF
            {
             newCompositeNode(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEVENTB_IDENTIFIER_KEYWORD=ruleEVENTB_IDENTIFIER_KEYWORD();

            state._fsp--;

             current =iv_ruleEVENTB_IDENTIFIER_KEYWORD.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEVENTB_IDENTIFIER_KEYWORD"


    // $ANTLR start "ruleEVENTB_IDENTIFIER_KEYWORD"
    // InternalXUmlb.g:2685:1: ruleEVENTB_IDENTIFIER_KEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalXUmlb.g:2691:2: ( (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' ) )
            // InternalXUmlb.g:2692:2: (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' )
            {
            // InternalXUmlb.g:2692:2: (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' )
            int alt78=23;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt78=1;
                }
                break;
            case 65:
                {
                alt78=2;
                }
                break;
            case 66:
                {
                alt78=3;
                }
                break;
            case 67:
                {
                alt78=4;
                }
                break;
            case 68:
                {
                alt78=5;
                }
                break;
            case 69:
                {
                alt78=6;
                }
                break;
            case 70:
                {
                alt78=7;
                }
                break;
            case 71:
                {
                alt78=8;
                }
                break;
            case 72:
                {
                alt78=9;
                }
                break;
            case 73:
                {
                alt78=10;
                }
                break;
            case 74:
                {
                alt78=11;
                }
                break;
            case 75:
                {
                alt78=12;
                }
                break;
            case 76:
                {
                alt78=13;
                }
                break;
            case 77:
                {
                alt78=14;
                }
                break;
            case 78:
                {
                alt78=15;
                }
                break;
            case 79:
                {
                alt78=16;
                }
                break;
            case 80:
                {
                alt78=17;
                }
                break;
            case 81:
                {
                alt78=18;
                }
                break;
            case 82:
                {
                alt78=19;
                }
                break;
            case 83:
                {
                alt78=20;
                }
                break;
            case 84:
                {
                alt78=21;
                }
                break;
            case 32:
                {
                alt78=22;
                }
                break;
            case 34:
                {
                alt78=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // InternalXUmlb.g:2693:3: kw= 'BOOL'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBOOLKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:2699:3: kw= 'FALSE'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFALSEKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:2705:3: kw= 'TRUE'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getTRUEKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalXUmlb.g:2711:3: kw= 'bool'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBoolKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalXUmlb.g:2717:3: kw= 'card'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getCardKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalXUmlb.g:2723:3: kw= 'dom'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDomKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalXUmlb.g:2729:3: kw= 'finite'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFiniteKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalXUmlb.g:2735:3: kw= 'id'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getIdKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalXUmlb.g:2741:3: kw= 'inter'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getInterKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalXUmlb.g:2747:3: kw= 'max'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMaxKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalXUmlb.g:2753:3: kw= 'min'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMinKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalXUmlb.g:2759:3: kw= 'mod'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getModKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalXUmlb.g:2765:3: kw= 'pred'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPredKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalXUmlb.g:2771:3: kw= 'prj1'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj1Keyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalXUmlb.g:2777:3: kw= 'prj2'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj2Keyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalXUmlb.g:2783:3: kw= 'ran'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getRanKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalXUmlb.g:2789:3: kw= 'succ'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getSuccKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalXUmlb.g:2795:3: kw= 'union'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getUnionKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalXUmlb.g:2801:3: kw= '\\u21151'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNDigitOneKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalXUmlb.g:2807:3: kw= '\\u2115'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalXUmlb.g:2813:3: kw= '\\u21191'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPDigitOneKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalXUmlb.g:2819:3: kw= '\\u2119'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalXUmlb.g:2825:3: kw= '\\u2124'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalZKeyword_22());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEVENTB_IDENTIFIER_KEYWORD"


    // $ANTLR start "entryRuleEVENTB_PREDICATE_SYMBOLS"
    // InternalXUmlb.g:2834:1: entryRuleEVENTB_PREDICATE_SYMBOLS returns [String current=null] : iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF ;
    public final String entryRuleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_PREDICATE_SYMBOLS = null;


        try {
            // InternalXUmlb.g:2834:64: (iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF )
            // InternalXUmlb.g:2835:2: iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF
            {
             newCompositeNode(grammarAccess.getEVENTB_PREDICATE_SYMBOLSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEVENTB_PREDICATE_SYMBOLS=ruleEVENTB_PREDICATE_SYMBOLS();

            state._fsp--;

             current =iv_ruleEVENTB_PREDICATE_SYMBOLS.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEVENTB_PREDICATE_SYMBOLS"


    // $ANTLR start "ruleEVENTB_PREDICATE_SYMBOLS"
    // InternalXUmlb.g:2841:1: ruleEVENTB_PREDICATE_SYMBOLS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalXUmlb.g:2847:2: ( (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' ) )
            // InternalXUmlb.g:2848:2: (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' )
            {
            // InternalXUmlb.g:2848:2: (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' )
            int alt79=31;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt79=1;
                }
                break;
            case 17:
                {
                alt79=2;
                }
                break;
            case 85:
                {
                alt79=3;
                }
                break;
            case 86:
                {
                alt79=4;
                }
                break;
            case 87:
                {
                alt79=5;
                }
                break;
            case 88:
                {
                alt79=6;
                }
                break;
            case 89:
                {
                alt79=7;
                }
                break;
            case 90:
                {
                alt79=8;
                }
                break;
            case 91:
                {
                alt79=9;
                }
                break;
            case 92:
                {
                alt79=10;
                }
                break;
            case 93:
                {
                alt79=11;
                }
                break;
            case 94:
                {
                alt79=12;
                }
                break;
            case 95:
                {
                alt79=13;
                }
                break;
            case 96:
                {
                alt79=14;
                }
                break;
            case 26:
                {
                alt79=15;
                }
                break;
            case 97:
                {
                alt79=16;
                }
                break;
            case 64:
                {
                alt79=17;
                }
                break;
            case 98:
                {
                alt79=18;
                }
                break;
            case 99:
                {
                alt79=19;
                }
                break;
            case 100:
                {
                alt79=20;
                }
                break;
            case 101:
                {
                alt79=21;
                }
                break;
            case 102:
                {
                alt79=22;
                }
                break;
            case 103:
                {
                alt79=23;
                }
                break;
            case 104:
                {
                alt79=24;
                }
                break;
            case 30:
                {
                alt79=25;
                }
                break;
            case 105:
                {
                alt79=26;
                }
                break;
            case 106:
                {
                alt79=27;
                }
                break;
            case 107:
                {
                alt79=28;
                }
                break;
            case 108:
                {
                alt79=29;
                }
                break;
            case 109:
                {
                alt79=30;
                }
                break;
            case 110:
                {
                alt79=31;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // InternalXUmlb.g:2849:3: kw= '('
                    {
                    kw=(Token)match(input,16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftParenthesisKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:2855:3: kw= ')'
                    {
                    kw=(Token)match(input,17,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightParenthesisKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:2861:3: kw= '\\u21D4'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftRightDoubleArrowKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalXUmlb.g:2867:3: kw= '\\u21D2'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightwardsDoubleArrowKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalXUmlb.g:2873:3: kw= '\\u2227'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalAndKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalXUmlb.g:2879:3: kw= '&'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAmpersandKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalXUmlb.g:2885:3: kw= '\\u2228'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalOrKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalXUmlb.g:2891:3: kw= '\\u00AC'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotSignKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalXUmlb.g:2897:3: kw= '\\u22A4'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getDownTackKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalXUmlb.g:2903:3: kw= '\\u22A5'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getUpTackKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalXUmlb.g:2909:3: kw= '\\u2200'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getForAllKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalXUmlb.g:2915:3: kw= '!'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getExclamationMarkKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalXUmlb.g:2921:3: kw= '\\u2203'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getThereExistsKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalXUmlb.g:2927:3: kw= '#'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNumberSignKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalXUmlb.g:2933:3: kw= ','
                    {
                    kw=(Token)match(input,26,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getCommaKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalXUmlb.g:2939:3: kw= '\\u00B7'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getMiddleDotKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalXUmlb.g:2945:3: kw= '.'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFullStopKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalXUmlb.g:2951:3: kw= '='
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalXUmlb.g:2957:3: kw= '\\u2260'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotEqualToKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalXUmlb.g:2963:3: kw= '\\u2264'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanOrEqualToKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalXUmlb.g:2969:3: kw= '<'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalXUmlb.g:2975:3: kw= '\\u2265'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanOrEqualToKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalXUmlb.g:2981:3: kw= '>'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalXUmlb.g:2987:3: kw= '\\u2208'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getElementOfKeyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalXUmlb.g:2993:3: kw= ':'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getColonKeyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalXUmlb.g:2999:3: kw= '\\u2209'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotAnElementOfKeyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalXUmlb.g:3005:3: kw= '\\u2282'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfKeyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalXUmlb.g:3011:3: kw= '\\u2284'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotASubsetOfKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalXUmlb.g:3017:3: kw= '\\u2286'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfOrEqualToKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalXUmlb.g:3023:3: kw= '\\u2288'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNeitherASubsetOfNorEqualToKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalXUmlb.g:3029:3: kw= 'partition'
                    {
                    kw=(Token)match(input,110,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getPartitionKeyword_30());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEVENTB_PREDICATE_SYMBOLS"


    // $ANTLR start "entryRuleEVENTB_EXPRESSION_SYMBOLS"
    // InternalXUmlb.g:3038:1: entryRuleEVENTB_EXPRESSION_SYMBOLS returns [String current=null] : iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF ;
    public final String entryRuleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_EXPRESSION_SYMBOLS = null;


        try {
            // InternalXUmlb.g:3038:65: (iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF )
            // InternalXUmlb.g:3039:2: iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF
            {
             newCompositeNode(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEVENTB_EXPRESSION_SYMBOLS=ruleEVENTB_EXPRESSION_SYMBOLS();

            state._fsp--;

             current =iv_ruleEVENTB_EXPRESSION_SYMBOLS.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEVENTB_EXPRESSION_SYMBOLS"


    // $ANTLR start "ruleEVENTB_EXPRESSION_SYMBOLS"
    // InternalXUmlb.g:3045:1: ruleEVENTB_EXPRESSION_SYMBOLS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalXUmlb.g:3051:2: ( (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' ) )
            // InternalXUmlb.g:3052:2: (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' )
            {
            // InternalXUmlb.g:3052:2: (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' )
            int alt80=45;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt80=1;
                }
                break;
            case 112:
                {
                alt80=2;
                }
                break;
            case 113:
                {
                alt80=3;
                }
                break;
            case 114:
                {
                alt80=4;
                }
                break;
            case 115:
                {
                alt80=5;
                }
                break;
            case 116:
                {
                alt80=6;
                }
                break;
            case 117:
                {
                alt80=7;
                }
                break;
            case 118:
                {
                alt80=8;
                }
                break;
            case 119:
                {
                alt80=9;
                }
                break;
            case 120:
                {
                alt80=10;
                }
                break;
            case 121:
                {
                alt80=11;
                }
                break;
            case 122:
                {
                alt80=12;
                }
                break;
            case 123:
                {
                alt80=13;
                }
                break;
            case 124:
                {
                alt80=14;
                }
                break;
            case 125:
                {
                alt80=15;
                }
                break;
            case 126:
                {
                alt80=16;
                }
                break;
            case 127:
                {
                alt80=17;
                }
                break;
            case 128:
                {
                alt80=18;
                }
                break;
            case 31:
                {
                alt80=19;
                }
                break;
            case 129:
                {
                alt80=20;
                }
                break;
            case 130:
                {
                alt80=21;
                }
                break;
            case 131:
                {
                alt80=22;
                }
                break;
            case 132:
                {
                alt80=23;
                }
                break;
            case 133:
                {
                alt80=24;
                }
                break;
            case 134:
                {
                alt80=25;
                }
                break;
            case 135:
                {
                alt80=26;
                }
                break;
            case 136:
                {
                alt80=27;
                }
                break;
            case 137:
                {
                alt80=28;
                }
                break;
            case 138:
                {
                alt80=29;
                }
                break;
            case 139:
                {
                alt80=30;
                }
                break;
            case 140:
                {
                alt80=31;
                }
                break;
            case 141:
                {
                alt80=32;
                }
                break;
            case 142:
                {
                alt80=33;
                }
                break;
            case 144:
                {
                alt80=34;
                }
                break;
            case 145:
                {
                alt80=35;
                }
                break;
            case 146:
                {
                alt80=36;
                }
                break;
            case 147:
                {
                alt80=37;
                }
                break;
            case 148:
                {
                alt80=38;
                }
                break;
            case 149:
                {
                alt80=39;
                }
                break;
            case 150:
                {
                alt80=40;
                }
                break;
            case 151:
                {
                alt80=41;
                }
                break;
            case 152:
                {
                alt80=42;
                }
                break;
            case 153:
                {
                alt80=43;
                }
                break;
            case 154:
                {
                alt80=44;
                }
                break;
            case 155:
                {
                alt80=45;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // InternalXUmlb.g:3053:3: kw= '\\u2194'
                    {
                    kw=(Token)match(input,111,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftRightArrowKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:3059:3: kw= '\\uE100'
                    {
                    kw=(Token)match(input,112,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE100Keyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:3065:3: kw= '\\uE101'
                    {
                    kw=(Token)match(input,113,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE101Keyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalXUmlb.g:3071:3: kw= '\\uE102'
                    {
                    kw=(Token)match(input,114,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE102Keyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalXUmlb.g:3077:3: kw= '\\u21F8'
                    {
                    kw=(Token)match(input,115,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithVerticalStrokeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalXUmlb.g:3083:3: kw= '\\u2192'
                    {
                    kw=(Token)match(input,116,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalXUmlb.g:3089:3: kw= '\\u2914'
                    {
                    kw=(Token)match(input,117,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalXUmlb.g:3095:3: kw= '\\u21A3'
                    {
                    kw=(Token)match(input,118,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalXUmlb.g:3101:3: kw= '\\u2900'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalXUmlb.g:3107:3: kw= '\\u21A0'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalXUmlb.g:3113:3: kw= '\\u2916'
                    {
                    kw=(Token)match(input,121,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithTailKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalXUmlb.g:3119:3: kw= '{'
                    {
                    kw=(Token)match(input,122,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalXUmlb.g:3125:3: kw= '}'
                    {
                    kw=(Token)match(input,123,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightCurlyBracketKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalXUmlb.g:3131:3: kw= '\\u21A6'
                    {
                    kw=(Token)match(input,124,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowFromBarKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalXUmlb.g:3137:3: kw= '\\u2205'
                    {
                    kw=(Token)match(input,125,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getEmptySetKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalXUmlb.g:3143:3: kw= '\\u2229'
                    {
                    kw=(Token)match(input,126,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getIntersectionKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalXUmlb.g:3149:3: kw= '\\u222A'
                    {
                    kw=(Token)match(input,127,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUnionKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalXUmlb.g:3155:3: kw= '\\u2216'
                    {
                    kw=(Token)match(input,128,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSetMinusKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalXUmlb.g:3161:3: kw= '\\u00D7'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMultiplicationSignKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalXUmlb.g:3167:3: kw= '['
                    {
                    kw=(Token)match(input,129,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftSquareBracketKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalXUmlb.g:3173:3: kw= ']'
                    {
                    kw=(Token)match(input,130,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightSquareBracketKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalXUmlb.g:3179:3: kw= '\\uE103'
                    {
                    kw=(Token)match(input,131,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE103Keyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalXUmlb.g:3185:3: kw= '\\u2218'
                    {
                    kw=(Token)match(input,132,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRingOperatorKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalXUmlb.g:3191:3: kw= ';'
                    {
                    kw=(Token)match(input,133,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSemicolonKeyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalXUmlb.g:3197:3: kw= '\\u2297'
                    {
                    kw=(Token)match(input,134,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircledTimesKeyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalXUmlb.g:3203:3: kw= '\\u2225'
                    {
                    kw=(Token)match(input,135,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getParallelToKeyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalXUmlb.g:3209:3: kw= '\\u223C'
                    {
                    kw=(Token)match(input,136,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeOperatorKeyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalXUmlb.g:3215:3: kw= '\\u25C1'
                    {
                    kw=(Token)match(input,137,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteLeftPointingTriangleKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalXUmlb.g:3221:3: kw= '\\u2A64'
                    {
                    kw=(Token)match(input,138,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationDomainAntirestrictionKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalXUmlb.g:3227:3: kw= '\\u25B7'
                    {
                    kw=(Token)match(input,139,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteRightPointingTriangleKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalXUmlb.g:3233:3: kw= '\\u2A65'
                    {
                    kw=(Token)match(input,140,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationRangeAntirestrictionKeyword_30());
                    		

                    }
                    break;
                case 32 :
                    // InternalXUmlb.g:3239:3: kw= '\\u03BB'
                    {
                    kw=(Token)match(input,141,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreekSmallLetterLamdaKeyword_31());
                    		

                    }
                    break;
                case 33 :
                    // InternalXUmlb.g:3245:3: (kw= '%' kw= '\\u22C2' )
                    {
                    // InternalXUmlb.g:3245:3: (kw= '%' kw= '\\u22C2' )
                    // InternalXUmlb.g:3246:4: kw= '%' kw= '\\u22C2'
                    {
                    kw=(Token)match(input,142,FOLLOW_77); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPercentSignKeyword_32_0());
                    			
                    kw=(Token)match(input,143,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryIntersectionKeyword_32_1());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalXUmlb.g:3258:3: kw= '\\u22C3'
                    {
                    kw=(Token)match(input,144,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryUnionKeyword_33());
                    		

                    }
                    break;
                case 35 :
                    // InternalXUmlb.g:3264:3: kw= '\\u2223'
                    {
                    kw=(Token)match(input,145,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDividesKeyword_34());
                    		

                    }
                    break;
                case 36 :
                    // InternalXUmlb.g:3270:3: kw= '\\u2025'
                    {
                    kw=(Token)match(input,146,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTwoDotLeaderKeyword_35());
                    		

                    }
                    break;
                case 37 :
                    // InternalXUmlb.g:3276:3: kw= '+'
                    {
                    kw=(Token)match(input,147,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignKeyword_36());
                    		

                    }
                    break;
                case 38 :
                    // InternalXUmlb.g:3282:3: kw= '\\u2212'
                    {
                    kw=(Token)match(input,148,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMinusSignKeyword_37());
                    		

                    }
                    break;
                case 39 :
                    // InternalXUmlb.g:3288:3: kw= '-'
                    {
                    kw=(Token)match(input,149,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusKeyword_38());
                    		

                    }
                    break;
                case 40 :
                    // InternalXUmlb.g:3294:3: kw= '\\u2217'
                    {
                    kw=(Token)match(input,150,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskOperatorKeyword_39());
                    		

                    }
                    break;
                case 41 :
                    // InternalXUmlb.g:3300:3: kw= '*'
                    {
                    kw=(Token)match(input,151,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskKeyword_40());
                    		

                    }
                    break;
                case 42 :
                    // InternalXUmlb.g:3306:3: kw= '\\u00F7'
                    {
                    kw=(Token)match(input,152,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDivisionSignKeyword_41());
                    		

                    }
                    break;
                case 43 :
                    // InternalXUmlb.g:3312:3: kw= '/'
                    {
                    kw=(Token)match(input,153,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusKeyword_42());
                    		

                    }
                    break;
                case 44 :
                    // InternalXUmlb.g:3318:3: kw= '^'
                    {
                    kw=(Token)match(input,154,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircumflexAccentKeyword_43());
                    		

                    }
                    break;
                case 45 :
                    // InternalXUmlb.g:3324:3: kw= '\\\\'
                    {
                    kw=(Token)match(input,155,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getBackslashKeyword_44());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEVENTB_EXPRESSION_SYMBOLS"


    // $ANTLR start "entryRuleInvariant"
    // InternalXUmlb.g:3333:1: entryRuleInvariant returns [EObject current=null] : iv_ruleInvariant= ruleInvariant EOF ;
    public final EObject entryRuleInvariant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvariant = null;


        try {
            // InternalXUmlb.g:3333:50: (iv_ruleInvariant= ruleInvariant EOF )
            // InternalXUmlb.g:3334:2: iv_ruleInvariant= ruleInvariant EOF
            {
             newCompositeNode(grammarAccess.getInvariantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInvariant=ruleInvariant();

            state._fsp--;

             current =iv_ruleInvariant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvariant"


    // $ANTLR start "ruleInvariant"
    // InternalXUmlb.g:3340:1: ruleInvariant returns [EObject current=null] : ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) ;
    public final EObject ruleInvariant() throws RecognitionException {
        EObject current = null;

        Token lv_theorem_0_0=null;
        Token lv_name_1_0=null;
        AntlrDatatypeRuleToken lv_predicate_2_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:3346:2: ( ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) )
            // InternalXUmlb.g:3347:2: ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            {
            // InternalXUmlb.g:3347:2: ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            // InternalXUmlb.g:3348:3: ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) )
            {
            // InternalXUmlb.g:3348:3: ( (lv_theorem_0_0= 'theorem' ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==60) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalXUmlb.g:3349:4: (lv_theorem_0_0= 'theorem' )
                    {
                    // InternalXUmlb.g:3349:4: (lv_theorem_0_0= 'theorem' )
                    // InternalXUmlb.g:3350:5: lv_theorem_0_0= 'theorem'
                    {
                    lv_theorem_0_0=(Token)match(input,60,FOLLOW_24); 

                    					newLeafNode(lv_theorem_0_0, grammarAccess.getInvariantAccess().getTheoremTheoremKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInvariantRule());
                    					}
                    					setWithLastConsumed(current, "theorem", lv_theorem_0_0 != null, "theorem");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:3362:3: ( (lv_name_1_0= RULE_XLABEL ) )
            // InternalXUmlb.g:3363:4: (lv_name_1_0= RULE_XLABEL )
            {
            // InternalXUmlb.g:3363:4: (lv_name_1_0= RULE_XLABEL )
            // InternalXUmlb.g:3364:5: lv_name_1_0= RULE_XLABEL
            {
            lv_name_1_0=(Token)match(input,RULE_XLABEL,FOLLOW_69); 

            					newLeafNode(lv_name_1_0, grammarAccess.getInvariantAccess().getNameXLABELTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInvariantRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.XUmlb.XLABEL");
            				

            }


            }

            // InternalXUmlb.g:3380:3: ( (lv_predicate_2_0= ruleXFormula ) )
            // InternalXUmlb.g:3381:4: (lv_predicate_2_0= ruleXFormula )
            {
            // InternalXUmlb.g:3381:4: (lv_predicate_2_0= ruleXFormula )
            // InternalXUmlb.g:3382:5: lv_predicate_2_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getInvariantAccess().getPredicateXFormulaParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_predicate_2_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInvariantRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_2_0,
            						"ac.soton.xumlb.XUmlb.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvariant"


    // $ANTLR start "entryRuleGuard"
    // InternalXUmlb.g:3403:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // InternalXUmlb.g:3403:46: (iv_ruleGuard= ruleGuard EOF )
            // InternalXUmlb.g:3404:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // InternalXUmlb.g:3410:1: ruleGuard returns [EObject current=null] : ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token lv_theorem_0_0=null;
        Token lv_name_1_0=null;
        AntlrDatatypeRuleToken lv_predicate_2_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:3416:2: ( ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) ) )
            // InternalXUmlb.g:3417:2: ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            {
            // InternalXUmlb.g:3417:2: ( ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) ) )
            // InternalXUmlb.g:3418:3: ( (lv_theorem_0_0= 'theorem' ) )? ( (lv_name_1_0= RULE_XLABEL ) ) ( (lv_predicate_2_0= ruleXFormula ) )
            {
            // InternalXUmlb.g:3418:3: ( (lv_theorem_0_0= 'theorem' ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==60) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalXUmlb.g:3419:4: (lv_theorem_0_0= 'theorem' )
                    {
                    // InternalXUmlb.g:3419:4: (lv_theorem_0_0= 'theorem' )
                    // InternalXUmlb.g:3420:5: lv_theorem_0_0= 'theorem'
                    {
                    lv_theorem_0_0=(Token)match(input,60,FOLLOW_24); 

                    					newLeafNode(lv_theorem_0_0, grammarAccess.getGuardAccess().getTheoremTheoremKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getGuardRule());
                    					}
                    					setWithLastConsumed(current, "theorem", lv_theorem_0_0 != null, "theorem");
                    				

                    }


                    }
                    break;

            }

            // InternalXUmlb.g:3432:3: ( (lv_name_1_0= RULE_XLABEL ) )
            // InternalXUmlb.g:3433:4: (lv_name_1_0= RULE_XLABEL )
            {
            // InternalXUmlb.g:3433:4: (lv_name_1_0= RULE_XLABEL )
            // InternalXUmlb.g:3434:5: lv_name_1_0= RULE_XLABEL
            {
            lv_name_1_0=(Token)match(input,RULE_XLABEL,FOLLOW_69); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGuardAccess().getNameXLABELTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGuardRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.soton.xumlb.XUmlb.XLABEL");
            				

            }


            }

            // InternalXUmlb.g:3450:3: ( (lv_predicate_2_0= ruleXFormula ) )
            // InternalXUmlb.g:3451:4: (lv_predicate_2_0= ruleXFormula )
            {
            // InternalXUmlb.g:3451:4: (lv_predicate_2_0= ruleXFormula )
            // InternalXUmlb.g:3452:5: lv_predicate_2_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getGuardAccess().getPredicateXFormulaParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_predicate_2_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGuardRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_2_0,
            						"ac.soton.xumlb.XUmlb.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuard"


    // $ANTLR start "entryRuleAction"
    // InternalXUmlb.g:3473:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalXUmlb.g:3473:47: (iv_ruleAction= ruleAction EOF )
            // InternalXUmlb.g:3474:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalXUmlb.g:3480:1: ruleAction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        AntlrDatatypeRuleToken lv_action_1_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:3486:2: ( ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) ) )
            // InternalXUmlb.g:3487:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) )
            {
            // InternalXUmlb.g:3487:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) ) )
            // InternalXUmlb.g:3488:3: ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_action_1_0= ruleXFormula ) )
            {
            // InternalXUmlb.g:3488:3: ( (lv_name_0_0= RULE_XLABEL ) )
            // InternalXUmlb.g:3489:4: (lv_name_0_0= RULE_XLABEL )
            {
            // InternalXUmlb.g:3489:4: (lv_name_0_0= RULE_XLABEL )
            // InternalXUmlb.g:3490:5: lv_name_0_0= RULE_XLABEL
            {
            lv_name_0_0=(Token)match(input,RULE_XLABEL,FOLLOW_69); 

            					newLeafNode(lv_name_0_0, grammarAccess.getActionAccess().getNameXLABELTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"ac.soton.xumlb.XUmlb.XLABEL");
            				

            }


            }

            // InternalXUmlb.g:3506:3: ( (lv_action_1_0= ruleXFormula ) )
            // InternalXUmlb.g:3507:4: (lv_action_1_0= ruleXFormula )
            {
            // InternalXUmlb.g:3507:4: (lv_action_1_0= ruleXFormula )
            // InternalXUmlb.g:3508:5: lv_action_1_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getActionAccess().getActionXFormulaParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_action_1_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActionRule());
            					}
            					set(
            						current,
            						"action",
            						lv_action_1_0,
            						"ac.soton.xumlb.XUmlb.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleWitness"
    // InternalXUmlb.g:3529:1: entryRuleWitness returns [EObject current=null] : iv_ruleWitness= ruleWitness EOF ;
    public final EObject entryRuleWitness() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWitness = null;


        try {
            // InternalXUmlb.g:3529:48: (iv_ruleWitness= ruleWitness EOF )
            // InternalXUmlb.g:3530:2: iv_ruleWitness= ruleWitness EOF
            {
             newCompositeNode(grammarAccess.getWitnessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWitness=ruleWitness();

            state._fsp--;

             current =iv_ruleWitness; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWitness"


    // $ANTLR start "ruleWitness"
    // InternalXUmlb.g:3536:1: ruleWitness returns [EObject current=null] : ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) ) ;
    public final EObject ruleWitness() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        AntlrDatatypeRuleToken lv_predicate_1_0 = null;



        	enterRule();

        try {
            // InternalXUmlb.g:3542:2: ( ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) ) )
            // InternalXUmlb.g:3543:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) )
            {
            // InternalXUmlb.g:3543:2: ( ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) ) )
            // InternalXUmlb.g:3544:3: ( (lv_name_0_0= RULE_XLABEL ) ) ( (lv_predicate_1_0= ruleXFormula ) )
            {
            // InternalXUmlb.g:3544:3: ( (lv_name_0_0= RULE_XLABEL ) )
            // InternalXUmlb.g:3545:4: (lv_name_0_0= RULE_XLABEL )
            {
            // InternalXUmlb.g:3545:4: (lv_name_0_0= RULE_XLABEL )
            // InternalXUmlb.g:3546:5: lv_name_0_0= RULE_XLABEL
            {
            lv_name_0_0=(Token)match(input,RULE_XLABEL,FOLLOW_69); 

            					newLeafNode(lv_name_0_0, grammarAccess.getWitnessAccess().getNameXLABELTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWitnessRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"ac.soton.xumlb.XUmlb.XLABEL");
            				

            }


            }

            // InternalXUmlb.g:3562:3: ( (lv_predicate_1_0= ruleXFormula ) )
            // InternalXUmlb.g:3563:4: (lv_predicate_1_0= ruleXFormula )
            {
            // InternalXUmlb.g:3563:4: (lv_predicate_1_0= ruleXFormula )
            // InternalXUmlb.g:3564:5: lv_predicate_1_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getWitnessAccess().getPredicateXFormulaParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_predicate_1_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWitnessRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_1_0,
            						"ac.soton.xumlb.XUmlb.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWitness"


    // $ANTLR start "ruleTranslationKind"
    // InternalXUmlb.g:3585:1: ruleTranslationKind returns [Enumerator current=null] : ( (enumLiteral_0= 'variables' ) | (enumLiteral_1= 'enumeration' ) | (enumLiteral_2= 'REFINEDVAR' ) ) ;
    public final Enumerator ruleTranslationKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalXUmlb.g:3591:2: ( ( (enumLiteral_0= 'variables' ) | (enumLiteral_1= 'enumeration' ) | (enumLiteral_2= 'REFINEDVAR' ) ) )
            // InternalXUmlb.g:3592:2: ( (enumLiteral_0= 'variables' ) | (enumLiteral_1= 'enumeration' ) | (enumLiteral_2= 'REFINEDVAR' ) )
            {
            // InternalXUmlb.g:3592:2: ( (enumLiteral_0= 'variables' ) | (enumLiteral_1= 'enumeration' ) | (enumLiteral_2= 'REFINEDVAR' ) )
            int alt83=3;
            switch ( input.LA(1) ) {
            case 156:
                {
                alt83=1;
                }
                break;
            case 157:
                {
                alt83=2;
                }
                break;
            case 158:
                {
                alt83=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalXUmlb.g:3593:3: (enumLiteral_0= 'variables' )
                    {
                    // InternalXUmlb.g:3593:3: (enumLiteral_0= 'variables' )
                    // InternalXUmlb.g:3594:4: enumLiteral_0= 'variables'
                    {
                    enumLiteral_0=(Token)match(input,156,FOLLOW_2); 

                    				current = grammarAccess.getTranslationKindAccess().getMULTIVAREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTranslationKindAccess().getMULTIVAREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:3601:3: (enumLiteral_1= 'enumeration' )
                    {
                    // InternalXUmlb.g:3601:3: (enumLiteral_1= 'enumeration' )
                    // InternalXUmlb.g:3602:4: enumLiteral_1= 'enumeration'
                    {
                    enumLiteral_1=(Token)match(input,157,FOLLOW_2); 

                    				current = grammarAccess.getTranslationKindAccess().getSINGLEVAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTranslationKindAccess().getSINGLEVAREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:3609:3: (enumLiteral_2= 'REFINEDVAR' )
                    {
                    // InternalXUmlb.g:3609:3: (enumLiteral_2= 'REFINEDVAR' )
                    // InternalXUmlb.g:3610:4: enumLiteral_2= 'REFINEDVAR'
                    {
                    enumLiteral_2=(Token)match(input,158,FOLLOW_2); 

                    				current = grammarAccess.getTranslationKindAccess().getREFINEDVAREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getTranslationKindAccess().getREFINEDVAREnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTranslationKind"


    // $ANTLR start "ruleMethodKind"
    // InternalXUmlb.g:3620:1: ruleMethodKind returns [Enumerator current=null] : ( (enumLiteral_0= 'normal' ) | (enumLiteral_1= 'constructor' ) | (enumLiteral_2= 'destructor' ) ) ;
    public final Enumerator ruleMethodKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalXUmlb.g:3626:2: ( ( (enumLiteral_0= 'normal' ) | (enumLiteral_1= 'constructor' ) | (enumLiteral_2= 'destructor' ) ) )
            // InternalXUmlb.g:3627:2: ( (enumLiteral_0= 'normal' ) | (enumLiteral_1= 'constructor' ) | (enumLiteral_2= 'destructor' ) )
            {
            // InternalXUmlb.g:3627:2: ( (enumLiteral_0= 'normal' ) | (enumLiteral_1= 'constructor' ) | (enumLiteral_2= 'destructor' ) )
            int alt84=3;
            switch ( input.LA(1) ) {
            case 159:
                {
                alt84=1;
                }
                break;
            case 160:
                {
                alt84=2;
                }
                break;
            case 161:
                {
                alt84=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalXUmlb.g:3628:3: (enumLiteral_0= 'normal' )
                    {
                    // InternalXUmlb.g:3628:3: (enumLiteral_0= 'normal' )
                    // InternalXUmlb.g:3629:4: enumLiteral_0= 'normal'
                    {
                    enumLiteral_0=(Token)match(input,159,FOLLOW_2); 

                    				current = grammarAccess.getMethodKindAccess().getNormalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMethodKindAccess().getNormalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:3636:3: (enumLiteral_1= 'constructor' )
                    {
                    // InternalXUmlb.g:3636:3: (enumLiteral_1= 'constructor' )
                    // InternalXUmlb.g:3637:4: enumLiteral_1= 'constructor'
                    {
                    enumLiteral_1=(Token)match(input,160,FOLLOW_2); 

                    				current = grammarAccess.getMethodKindAccess().getConstructorEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMethodKindAccess().getConstructorEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:3644:3: (enumLiteral_2= 'destructor' )
                    {
                    // InternalXUmlb.g:3644:3: (enumLiteral_2= 'destructor' )
                    // InternalXUmlb.g:3645:4: enumLiteral_2= 'destructor'
                    {
                    enumLiteral_2=(Token)match(input,161,FOLLOW_2); 

                    				current = grammarAccess.getMethodKindAccess().getDestructorEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMethodKindAccess().getDestructorEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodKind"


    // $ANTLR start "ruleDataKind"
    // InternalXUmlb.g:3655:1: ruleDataKind returns [Enumerator current=null] : ( (enumLiteral_0= 'set' ) | (enumLiteral_1= 'constant' ) | (enumLiteral_2= 'variable' ) ) ;
    public final Enumerator ruleDataKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalXUmlb.g:3661:2: ( ( (enumLiteral_0= 'set' ) | (enumLiteral_1= 'constant' ) | (enumLiteral_2= 'variable' ) ) )
            // InternalXUmlb.g:3662:2: ( (enumLiteral_0= 'set' ) | (enumLiteral_1= 'constant' ) | (enumLiteral_2= 'variable' ) )
            {
            // InternalXUmlb.g:3662:2: ( (enumLiteral_0= 'set' ) | (enumLiteral_1= 'constant' ) | (enumLiteral_2= 'variable' ) )
            int alt85=3;
            switch ( input.LA(1) ) {
            case 162:
                {
                alt85=1;
                }
                break;
            case 163:
                {
                alt85=2;
                }
                break;
            case 164:
                {
                alt85=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalXUmlb.g:3663:3: (enumLiteral_0= 'set' )
                    {
                    // InternalXUmlb.g:3663:3: (enumLiteral_0= 'set' )
                    // InternalXUmlb.g:3664:4: enumLiteral_0= 'set'
                    {
                    enumLiteral_0=(Token)match(input,162,FOLLOW_2); 

                    				current = grammarAccess.getDataKindAccess().getSETEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataKindAccess().getSETEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:3671:3: (enumLiteral_1= 'constant' )
                    {
                    // InternalXUmlb.g:3671:3: (enumLiteral_1= 'constant' )
                    // InternalXUmlb.g:3672:4: enumLiteral_1= 'constant'
                    {
                    enumLiteral_1=(Token)match(input,163,FOLLOW_2); 

                    				current = grammarAccess.getDataKindAccess().getCONSTANTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataKindAccess().getCONSTANTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:3679:3: (enumLiteral_2= 'variable' )
                    {
                    // InternalXUmlb.g:3679:3: (enumLiteral_2= 'variable' )
                    // InternalXUmlb.g:3680:4: enumLiteral_2= 'variable'
                    {
                    enumLiteral_2=(Token)match(input,164,FOLLOW_2); 

                    				current = grammarAccess.getDataKindAccess().getVARIABLEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataKindAccess().getVARIABLEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataKind"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000020000000E002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000020000000C002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000200000008002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000070000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00001E0802344000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00001E0802340000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00001E0802300000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000C02000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000003A100000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000003C100000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x1000000000000080L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x1000000030100080L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020100080L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000100080L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000700000010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000001D000004002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000001D000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x1000018000000082L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000010000000082L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0002400000104000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0002400000100000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0002000000100000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001C00000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x4C018010000C6002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x4C018010000C4002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x4C01801000044002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x4C01801000004002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x4C01001000004012L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x4C01001000000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x4C01000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x4801000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x4001000000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x007C000000802000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x007C000000800000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0078000000800000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0070000000800000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0060000000800000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0040000000800000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x007C000001002000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x007C000001000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0078000001000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0070000001000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0060000001000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0040000001000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x1000000000000010L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x00000007C4030050L,0xFFFFFFFFFFFFFFFFL,0x000000000FFF7FFFL});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000380000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x000000003A502000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x000000003A500010L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x00000007C4030052L,0xFFFFFFFFFFFFFFFFL,0x000000000FFF7FFFL});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});

}