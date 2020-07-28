package ac.soton.xumlb.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import ac.soton.xumlb.services.XUmlbGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXUmlbParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_XLABEL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'BOOL'", "'\\u2124'", "'FALSE'", "'TRUE'", "'bool'", "'card'", "'dom'", "'finite'", "'id'", "'inter'", "'max'", "'min'", "'mod'", "'pred'", "'prj1'", "'prj2'", "'ran'", "'succ'", "'union'", "'\\u21151'", "'\\u2115'", "'\\u21191'", "'\\u2119'", "'('", "')'", "'\\u21D4'", "'\\u21D2'", "'\\u2227'", "'&'", "'\\u2228'", "'\\u00AC'", "'\\u22A4'", "'\\u22A5'", "'\\u2200'", "'!'", "'\\u2203'", "'#'", "','", "'\\u00B7'", "'.'", "'='", "'\\u2260'", "'\\u2264'", "'<'", "'\\u2265'", "'>'", "'\\u2208'", "':'", "'\\u2209'", "'\\u2282'", "'\\u2284'", "'\\u2286'", "'\\u2288'", "'partition'", "'\\u2194'", "'\\uE100'", "'\\uE101'", "'\\uE102'", "'\\u21F8'", "'\\u2192'", "'\\u2914'", "'\\u21A3'", "'\\u2900'", "'\\u21A0'", "'\\u2916'", "'{'", "'}'", "'\\u21A6'", "'\\u2205'", "'\\u2229'", "'\\u222A'", "'\\u2216'", "'\\u00D7'", "'['", "']'", "'\\uE103'", "'\\u2218'", "';'", "'\\u2297'", "'\\u2225'", "'\\u223C'", "'\\u25C1'", "'\\u2A64'", "'\\u25B7'", "'\\u2A65'", "'\\u03BB'", "'\\u22C3'", "'\\u2223'", "'\\u2025'", "'+'", "'\\u2212'", "'-'", "'\\u2217'", "'*'", "'\\u00F7'", "'/'", "'^'", "'\\\\'", "'variables'", "'enumeration'", "'REFINEDVAR'", "'normal'", "'constructor'", "'destructor'", "'set'", "'constant'", "'variable'", "'UMLB'", "'elaborates'", "'refines'", "'statemachine'", "'end'", "'instances'", "'selfName'", "'transition'", "'source'", "'target'", "'any'", "'where'", "'then'", "'with'", "'state'", "'statemachines'", "'begin'", "'invariants'", "'entryActions'", "'exitActions'", "'initial'", "'final'", "'junction'", "'fork'", "'classdiagram'", "'class'", "'supertypes'", "'subtypeGroups'", "'association'", "'initialValue'", "'SubtypeGroup'", "'attribute'", "'constraint'", "'component'", "'method'", "'kind'", "'%'", "'\\u22C2'", "'extended'", "'functional'", "'total'", "'surjective'", "'injective'", "'cover'", "'disjoint'", "'theorem'"
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

    	public void setGrammarAccess(XUmlbGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleXUMLB"
    // InternalXUmlb.g:53:1: entryRuleXUMLB : ruleXUMLB EOF ;
    public final void entryRuleXUMLB() throws RecognitionException {
        try {
            // InternalXUmlb.g:54:1: ( ruleXUMLB EOF )
            // InternalXUmlb.g:55:1: ruleXUMLB EOF
            {
             before(grammarAccess.getXUMLBRule()); 
            pushFollow(FOLLOW_1);
            ruleXUMLB();

            state._fsp--;

             after(grammarAccess.getXUMLBRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXUMLB"


    // $ANTLR start "ruleXUMLB"
    // InternalXUmlb.g:62:1: ruleXUMLB : ( ( rule__XUMLB__Group__0 ) ) ;
    public final void ruleXUMLB() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:66:2: ( ( ( rule__XUMLB__Group__0 ) ) )
            // InternalXUmlb.g:67:2: ( ( rule__XUMLB__Group__0 ) )
            {
            // InternalXUmlb.g:67:2: ( ( rule__XUMLB__Group__0 ) )
            // InternalXUmlb.g:68:3: ( rule__XUMLB__Group__0 )
            {
             before(grammarAccess.getXUMLBAccess().getGroup()); 
            // InternalXUmlb.g:69:3: ( rule__XUMLB__Group__0 )
            // InternalXUmlb.g:69:4: rule__XUMLB__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XUMLB__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXUMLBAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXUMLB"


    // $ANTLR start "entryRuleXDiagram"
    // InternalXUmlb.g:78:1: entryRuleXDiagram : ruleXDiagram EOF ;
    public final void entryRuleXDiagram() throws RecognitionException {
        try {
            // InternalXUmlb.g:79:1: ( ruleXDiagram EOF )
            // InternalXUmlb.g:80:1: ruleXDiagram EOF
            {
             before(grammarAccess.getXDiagramRule()); 
            pushFollow(FOLLOW_1);
            ruleXDiagram();

            state._fsp--;

             after(grammarAccess.getXDiagramRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXDiagram"


    // $ANTLR start "ruleXDiagram"
    // InternalXUmlb.g:87:1: ruleXDiagram : ( ( rule__XDiagram__Alternatives ) ) ;
    public final void ruleXDiagram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:91:2: ( ( ( rule__XDiagram__Alternatives ) ) )
            // InternalXUmlb.g:92:2: ( ( rule__XDiagram__Alternatives ) )
            {
            // InternalXUmlb.g:92:2: ( ( rule__XDiagram__Alternatives ) )
            // InternalXUmlb.g:93:3: ( rule__XDiagram__Alternatives )
            {
             before(grammarAccess.getXDiagramAccess().getAlternatives()); 
            // InternalXUmlb.g:94:3: ( rule__XDiagram__Alternatives )
            // InternalXUmlb.g:94:4: rule__XDiagram__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__XDiagram__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getXDiagramAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXDiagram"


    // $ANTLR start "entryRuleStatemachine"
    // InternalXUmlb.g:103:1: entryRuleStatemachine : ruleStatemachine EOF ;
    public final void entryRuleStatemachine() throws RecognitionException {
        try {
            // InternalXUmlb.g:104:1: ( ruleStatemachine EOF )
            // InternalXUmlb.g:105:1: ruleStatemachine EOF
            {
             before(grammarAccess.getStatemachineRule()); 
            pushFollow(FOLLOW_1);
            ruleStatemachine();

            state._fsp--;

             after(grammarAccess.getStatemachineRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // InternalXUmlb.g:112:1: ruleStatemachine : ( ( rule__Statemachine__Group__0 ) ) ;
    public final void ruleStatemachine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:116:2: ( ( ( rule__Statemachine__Group__0 ) ) )
            // InternalXUmlb.g:117:2: ( ( rule__Statemachine__Group__0 ) )
            {
            // InternalXUmlb.g:117:2: ( ( rule__Statemachine__Group__0 ) )
            // InternalXUmlb.g:118:3: ( rule__Statemachine__Group__0 )
            {
             before(grammarAccess.getStatemachineAccess().getGroup()); 
            // InternalXUmlb.g:119:3: ( rule__Statemachine__Group__0 )
            // InternalXUmlb.g:119:4: rule__Statemachine__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleAbstractNode"
    // InternalXUmlb.g:128:1: entryRuleAbstractNode : ruleAbstractNode EOF ;
    public final void entryRuleAbstractNode() throws RecognitionException {
        try {
            // InternalXUmlb.g:129:1: ( ruleAbstractNode EOF )
            // InternalXUmlb.g:130:1: ruleAbstractNode EOF
            {
             before(grammarAccess.getAbstractNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractNode();

            state._fsp--;

             after(grammarAccess.getAbstractNodeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractNode"


    // $ANTLR start "ruleAbstractNode"
    // InternalXUmlb.g:137:1: ruleAbstractNode : ( ( rule__AbstractNode__Alternatives ) ) ;
    public final void ruleAbstractNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:141:2: ( ( ( rule__AbstractNode__Alternatives ) ) )
            // InternalXUmlb.g:142:2: ( ( rule__AbstractNode__Alternatives ) )
            {
            // InternalXUmlb.g:142:2: ( ( rule__AbstractNode__Alternatives ) )
            // InternalXUmlb.g:143:3: ( rule__AbstractNode__Alternatives )
            {
             before(grammarAccess.getAbstractNodeAccess().getAlternatives()); 
            // InternalXUmlb.g:144:3: ( rule__AbstractNode__Alternatives )
            // InternalXUmlb.g:144:4: rule__AbstractNode__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AbstractNode__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractNodeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractNode"


    // $ANTLR start "entryRuleTransition"
    // InternalXUmlb.g:153:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // InternalXUmlb.g:154:1: ( ruleTransition EOF )
            // InternalXUmlb.g:155:1: ruleTransition EOF
            {
             before(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getTransitionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalXUmlb.g:162:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:166:2: ( ( ( rule__Transition__Group__0 ) ) )
            // InternalXUmlb.g:167:2: ( ( rule__Transition__Group__0 ) )
            {
            // InternalXUmlb.g:167:2: ( ( rule__Transition__Group__0 ) )
            // InternalXUmlb.g:168:3: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // InternalXUmlb.g:169:3: ( rule__Transition__Group__0 )
            // InternalXUmlb.g:169:4: rule__Transition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleTypedParameter"
    // InternalXUmlb.g:178:1: entryRuleTypedParameter : ruleTypedParameter EOF ;
    public final void entryRuleTypedParameter() throws RecognitionException {
        try {
            // InternalXUmlb.g:179:1: ( ruleTypedParameter EOF )
            // InternalXUmlb.g:180:1: ruleTypedParameter EOF
            {
             before(grammarAccess.getTypedParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleTypedParameter();

            state._fsp--;

             after(grammarAccess.getTypedParameterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypedParameter"


    // $ANTLR start "ruleTypedParameter"
    // InternalXUmlb.g:187:1: ruleTypedParameter : ( ( rule__TypedParameter__Group__0 ) ) ;
    public final void ruleTypedParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:191:2: ( ( ( rule__TypedParameter__Group__0 ) ) )
            // InternalXUmlb.g:192:2: ( ( rule__TypedParameter__Group__0 ) )
            {
            // InternalXUmlb.g:192:2: ( ( rule__TypedParameter__Group__0 ) )
            // InternalXUmlb.g:193:3: ( rule__TypedParameter__Group__0 )
            {
             before(grammarAccess.getTypedParameterAccess().getGroup()); 
            // InternalXUmlb.g:194:3: ( rule__TypedParameter__Group__0 )
            // InternalXUmlb.g:194:4: rule__TypedParameter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypedParameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypedParameterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypedParameter"


    // $ANTLR start "entryRuleXType"
    // InternalXUmlb.g:203:1: entryRuleXType : ruleXType EOF ;
    public final void entryRuleXType() throws RecognitionException {
        try {
            // InternalXUmlb.g:204:1: ( ruleXType EOF )
            // InternalXUmlb.g:205:1: ruleXType EOF
            {
             before(grammarAccess.getXTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleXType();

            state._fsp--;

             after(grammarAccess.getXTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXType"


    // $ANTLR start "ruleXType"
    // InternalXUmlb.g:212:1: ruleXType : ( ( rule__XType__Group__0 ) ) ;
    public final void ruleXType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:216:2: ( ( ( rule__XType__Group__0 ) ) )
            // InternalXUmlb.g:217:2: ( ( rule__XType__Group__0 ) )
            {
            // InternalXUmlb.g:217:2: ( ( rule__XType__Group__0 ) )
            // InternalXUmlb.g:218:3: ( rule__XType__Group__0 )
            {
             before(grammarAccess.getXTypeAccess().getGroup()); 
            // InternalXUmlb.g:219:3: ( rule__XType__Group__0 )
            // InternalXUmlb.g:219:4: rule__XType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXType"


    // $ANTLR start "entryRuleXComplexType"
    // InternalXUmlb.g:228:1: entryRuleXComplexType : ruleXComplexType EOF ;
    public final void entryRuleXComplexType() throws RecognitionException {
        try {
            // InternalXUmlb.g:229:1: ( ruleXComplexType EOF )
            // InternalXUmlb.g:230:1: ruleXComplexType EOF
            {
             before(grammarAccess.getXComplexTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleXComplexType();

            state._fsp--;

             after(grammarAccess.getXComplexTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXComplexType"


    // $ANTLR start "ruleXComplexType"
    // InternalXUmlb.g:237:1: ruleXComplexType : ( ( rule__XComplexType__Alternatives ) ) ;
    public final void ruleXComplexType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:241:2: ( ( ( rule__XComplexType__Alternatives ) ) )
            // InternalXUmlb.g:242:2: ( ( rule__XComplexType__Alternatives ) )
            {
            // InternalXUmlb.g:242:2: ( ( rule__XComplexType__Alternatives ) )
            // InternalXUmlb.g:243:3: ( rule__XComplexType__Alternatives )
            {
             before(grammarAccess.getXComplexTypeAccess().getAlternatives()); 
            // InternalXUmlb.g:244:3: ( rule__XComplexType__Alternatives )
            // InternalXUmlb.g:244:4: rule__XComplexType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__XComplexType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getXComplexTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXComplexType"


    // $ANTLR start "entryRuleEVENT_B_BUILDIN_TYPE"
    // InternalXUmlb.g:253:1: entryRuleEVENT_B_BUILDIN_TYPE : ruleEVENT_B_BUILDIN_TYPE EOF ;
    public final void entryRuleEVENT_B_BUILDIN_TYPE() throws RecognitionException {
        try {
            // InternalXUmlb.g:254:1: ( ruleEVENT_B_BUILDIN_TYPE EOF )
            // InternalXUmlb.g:255:1: ruleEVENT_B_BUILDIN_TYPE EOF
            {
             before(grammarAccess.getEVENT_B_BUILDIN_TYPERule()); 
            pushFollow(FOLLOW_1);
            ruleEVENT_B_BUILDIN_TYPE();

            state._fsp--;

             after(grammarAccess.getEVENT_B_BUILDIN_TYPERule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEVENT_B_BUILDIN_TYPE"


    // $ANTLR start "ruleEVENT_B_BUILDIN_TYPE"
    // InternalXUmlb.g:262:1: ruleEVENT_B_BUILDIN_TYPE : ( ( rule__EVENT_B_BUILDIN_TYPE__Alternatives ) ) ;
    public final void ruleEVENT_B_BUILDIN_TYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:266:2: ( ( ( rule__EVENT_B_BUILDIN_TYPE__Alternatives ) ) )
            // InternalXUmlb.g:267:2: ( ( rule__EVENT_B_BUILDIN_TYPE__Alternatives ) )
            {
            // InternalXUmlb.g:267:2: ( ( rule__EVENT_B_BUILDIN_TYPE__Alternatives ) )
            // InternalXUmlb.g:268:3: ( rule__EVENT_B_BUILDIN_TYPE__Alternatives )
            {
             before(grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getAlternatives()); 
            // InternalXUmlb.g:269:3: ( rule__EVENT_B_BUILDIN_TYPE__Alternatives )
            // InternalXUmlb.g:269:4: rule__EVENT_B_BUILDIN_TYPE__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EVENT_B_BUILDIN_TYPE__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEVENT_B_BUILDIN_TYPE"


    // $ANTLR start "entryRuleState"
    // InternalXUmlb.g:278:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // InternalXUmlb.g:279:1: ( ruleState EOF )
            // InternalXUmlb.g:280:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            ruleState();

            state._fsp--;

             after(grammarAccess.getStateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalXUmlb.g:287:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:291:2: ( ( ( rule__State__Group__0 ) ) )
            // InternalXUmlb.g:292:2: ( ( rule__State__Group__0 ) )
            {
            // InternalXUmlb.g:292:2: ( ( rule__State__Group__0 ) )
            // InternalXUmlb.g:293:3: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // InternalXUmlb.g:294:3: ( rule__State__Group__0 )
            // InternalXUmlb.g:294:4: rule__State__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__State__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleInitial"
    // InternalXUmlb.g:303:1: entryRuleInitial : ruleInitial EOF ;
    public final void entryRuleInitial() throws RecognitionException {
        try {
            // InternalXUmlb.g:304:1: ( ruleInitial EOF )
            // InternalXUmlb.g:305:1: ruleInitial EOF
            {
             before(grammarAccess.getInitialRule()); 
            pushFollow(FOLLOW_1);
            ruleInitial();

            state._fsp--;

             after(grammarAccess.getInitialRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInitial"


    // $ANTLR start "ruleInitial"
    // InternalXUmlb.g:312:1: ruleInitial : ( ( rule__Initial__Group__0 ) ) ;
    public final void ruleInitial() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:316:2: ( ( ( rule__Initial__Group__0 ) ) )
            // InternalXUmlb.g:317:2: ( ( rule__Initial__Group__0 ) )
            {
            // InternalXUmlb.g:317:2: ( ( rule__Initial__Group__0 ) )
            // InternalXUmlb.g:318:3: ( rule__Initial__Group__0 )
            {
             before(grammarAccess.getInitialAccess().getGroup()); 
            // InternalXUmlb.g:319:3: ( rule__Initial__Group__0 )
            // InternalXUmlb.g:319:4: rule__Initial__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Initial__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInitialAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInitial"


    // $ANTLR start "entryRuleFinal"
    // InternalXUmlb.g:328:1: entryRuleFinal : ruleFinal EOF ;
    public final void entryRuleFinal() throws RecognitionException {
        try {
            // InternalXUmlb.g:329:1: ( ruleFinal EOF )
            // InternalXUmlb.g:330:1: ruleFinal EOF
            {
             before(grammarAccess.getFinalRule()); 
            pushFollow(FOLLOW_1);
            ruleFinal();

            state._fsp--;

             after(grammarAccess.getFinalRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFinal"


    // $ANTLR start "ruleFinal"
    // InternalXUmlb.g:337:1: ruleFinal : ( ( rule__Final__Group__0 ) ) ;
    public final void ruleFinal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:341:2: ( ( ( rule__Final__Group__0 ) ) )
            // InternalXUmlb.g:342:2: ( ( rule__Final__Group__0 ) )
            {
            // InternalXUmlb.g:342:2: ( ( rule__Final__Group__0 ) )
            // InternalXUmlb.g:343:3: ( rule__Final__Group__0 )
            {
             before(grammarAccess.getFinalAccess().getGroup()); 
            // InternalXUmlb.g:344:3: ( rule__Final__Group__0 )
            // InternalXUmlb.g:344:4: rule__Final__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Final__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFinalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFinal"


    // $ANTLR start "entryRuleAny"
    // InternalXUmlb.g:353:1: entryRuleAny : ruleAny EOF ;
    public final void entryRuleAny() throws RecognitionException {
        try {
            // InternalXUmlb.g:354:1: ( ruleAny EOF )
            // InternalXUmlb.g:355:1: ruleAny EOF
            {
             before(grammarAccess.getAnyRule()); 
            pushFollow(FOLLOW_1);
            ruleAny();

            state._fsp--;

             after(grammarAccess.getAnyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAny"


    // $ANTLR start "ruleAny"
    // InternalXUmlb.g:362:1: ruleAny : ( ( rule__Any__Group__0 ) ) ;
    public final void ruleAny() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:366:2: ( ( ( rule__Any__Group__0 ) ) )
            // InternalXUmlb.g:367:2: ( ( rule__Any__Group__0 ) )
            {
            // InternalXUmlb.g:367:2: ( ( rule__Any__Group__0 ) )
            // InternalXUmlb.g:368:3: ( rule__Any__Group__0 )
            {
             before(grammarAccess.getAnyAccess().getGroup()); 
            // InternalXUmlb.g:369:3: ( rule__Any__Group__0 )
            // InternalXUmlb.g:369:4: rule__Any__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Any__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAnyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAny"


    // $ANTLR start "entryRuleJunction"
    // InternalXUmlb.g:378:1: entryRuleJunction : ruleJunction EOF ;
    public final void entryRuleJunction() throws RecognitionException {
        try {
            // InternalXUmlb.g:379:1: ( ruleJunction EOF )
            // InternalXUmlb.g:380:1: ruleJunction EOF
            {
             before(grammarAccess.getJunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleJunction();

            state._fsp--;

             after(grammarAccess.getJunctionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJunction"


    // $ANTLR start "ruleJunction"
    // InternalXUmlb.g:387:1: ruleJunction : ( ( rule__Junction__Group__0 ) ) ;
    public final void ruleJunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:391:2: ( ( ( rule__Junction__Group__0 ) ) )
            // InternalXUmlb.g:392:2: ( ( rule__Junction__Group__0 ) )
            {
            // InternalXUmlb.g:392:2: ( ( rule__Junction__Group__0 ) )
            // InternalXUmlb.g:393:3: ( rule__Junction__Group__0 )
            {
             before(grammarAccess.getJunctionAccess().getGroup()); 
            // InternalXUmlb.g:394:3: ( rule__Junction__Group__0 )
            // InternalXUmlb.g:394:4: rule__Junction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Junction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJunction"


    // $ANTLR start "entryRuleFork"
    // InternalXUmlb.g:403:1: entryRuleFork : ruleFork EOF ;
    public final void entryRuleFork() throws RecognitionException {
        try {
            // InternalXUmlb.g:404:1: ( ruleFork EOF )
            // InternalXUmlb.g:405:1: ruleFork EOF
            {
             before(grammarAccess.getForkRule()); 
            pushFollow(FOLLOW_1);
            ruleFork();

            state._fsp--;

             after(grammarAccess.getForkRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFork"


    // $ANTLR start "ruleFork"
    // InternalXUmlb.g:412:1: ruleFork : ( ( rule__Fork__Group__0 ) ) ;
    public final void ruleFork() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:416:2: ( ( ( rule__Fork__Group__0 ) ) )
            // InternalXUmlb.g:417:2: ( ( rule__Fork__Group__0 ) )
            {
            // InternalXUmlb.g:417:2: ( ( rule__Fork__Group__0 ) )
            // InternalXUmlb.g:418:3: ( rule__Fork__Group__0 )
            {
             before(grammarAccess.getForkAccess().getGroup()); 
            // InternalXUmlb.g:419:3: ( rule__Fork__Group__0 )
            // InternalXUmlb.g:419:4: rule__Fork__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Fork__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getForkAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFork"


    // $ANTLR start "entryRuleClassdiagram"
    // InternalXUmlb.g:428:1: entryRuleClassdiagram : ruleClassdiagram EOF ;
    public final void entryRuleClassdiagram() throws RecognitionException {
        try {
            // InternalXUmlb.g:429:1: ( ruleClassdiagram EOF )
            // InternalXUmlb.g:430:1: ruleClassdiagram EOF
            {
             before(grammarAccess.getClassdiagramRule()); 
            pushFollow(FOLLOW_1);
            ruleClassdiagram();

            state._fsp--;

             after(grammarAccess.getClassdiagramRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassdiagram"


    // $ANTLR start "ruleClassdiagram"
    // InternalXUmlb.g:437:1: ruleClassdiagram : ( ( rule__Classdiagram__Group__0 ) ) ;
    public final void ruleClassdiagram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:441:2: ( ( ( rule__Classdiagram__Group__0 ) ) )
            // InternalXUmlb.g:442:2: ( ( rule__Classdiagram__Group__0 ) )
            {
            // InternalXUmlb.g:442:2: ( ( rule__Classdiagram__Group__0 ) )
            // InternalXUmlb.g:443:3: ( rule__Classdiagram__Group__0 )
            {
             before(grammarAccess.getClassdiagramAccess().getGroup()); 
            // InternalXUmlb.g:444:3: ( rule__Classdiagram__Group__0 )
            // InternalXUmlb.g:444:4: rule__Classdiagram__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Classdiagram__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassdiagramAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassdiagram"


    // $ANTLR start "entryRuleClass"
    // InternalXUmlb.g:453:1: entryRuleClass : ruleClass EOF ;
    public final void entryRuleClass() throws RecognitionException {
        try {
            // InternalXUmlb.g:454:1: ( ruleClass EOF )
            // InternalXUmlb.g:455:1: ruleClass EOF
            {
             before(grammarAccess.getClassRule()); 
            pushFollow(FOLLOW_1);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getClassRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // InternalXUmlb.g:462:1: ruleClass : ( ( rule__Class__Group__0 ) ) ;
    public final void ruleClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:466:2: ( ( ( rule__Class__Group__0 ) ) )
            // InternalXUmlb.g:467:2: ( ( rule__Class__Group__0 ) )
            {
            // InternalXUmlb.g:467:2: ( ( rule__Class__Group__0 ) )
            // InternalXUmlb.g:468:3: ( rule__Class__Group__0 )
            {
             before(grammarAccess.getClassAccess().getGroup()); 
            // InternalXUmlb.g:469:3: ( rule__Class__Group__0 )
            // InternalXUmlb.g:469:4: rule__Class__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleAssociation"
    // InternalXUmlb.g:478:1: entryRuleAssociation : ruleAssociation EOF ;
    public final void entryRuleAssociation() throws RecognitionException {
        try {
            // InternalXUmlb.g:479:1: ( ruleAssociation EOF )
            // InternalXUmlb.g:480:1: ruleAssociation EOF
            {
             before(grammarAccess.getAssociationRule()); 
            pushFollow(FOLLOW_1);
            ruleAssociation();

            state._fsp--;

             after(grammarAccess.getAssociationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssociation"


    // $ANTLR start "ruleAssociation"
    // InternalXUmlb.g:487:1: ruleAssociation : ( ( rule__Association__Group__0 ) ) ;
    public final void ruleAssociation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:491:2: ( ( ( rule__Association__Group__0 ) ) )
            // InternalXUmlb.g:492:2: ( ( rule__Association__Group__0 ) )
            {
            // InternalXUmlb.g:492:2: ( ( rule__Association__Group__0 ) )
            // InternalXUmlb.g:493:3: ( rule__Association__Group__0 )
            {
             before(grammarAccess.getAssociationAccess().getGroup()); 
            // InternalXUmlb.g:494:3: ( rule__Association__Group__0 )
            // InternalXUmlb.g:494:4: rule__Association__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Association__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssociationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssociation"


    // $ANTLR start "entryRuleSubtypeGroup"
    // InternalXUmlb.g:503:1: entryRuleSubtypeGroup : ruleSubtypeGroup EOF ;
    public final void entryRuleSubtypeGroup() throws RecognitionException {
        try {
            // InternalXUmlb.g:504:1: ( ruleSubtypeGroup EOF )
            // InternalXUmlb.g:505:1: ruleSubtypeGroup EOF
            {
             before(grammarAccess.getSubtypeGroupRule()); 
            pushFollow(FOLLOW_1);
            ruleSubtypeGroup();

            state._fsp--;

             after(grammarAccess.getSubtypeGroupRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSubtypeGroup"


    // $ANTLR start "ruleSubtypeGroup"
    // InternalXUmlb.g:512:1: ruleSubtypeGroup : ( ( rule__SubtypeGroup__Group__0 ) ) ;
    public final void ruleSubtypeGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:516:2: ( ( ( rule__SubtypeGroup__Group__0 ) ) )
            // InternalXUmlb.g:517:2: ( ( rule__SubtypeGroup__Group__0 ) )
            {
            // InternalXUmlb.g:517:2: ( ( rule__SubtypeGroup__Group__0 ) )
            // InternalXUmlb.g:518:3: ( rule__SubtypeGroup__Group__0 )
            {
             before(grammarAccess.getSubtypeGroupAccess().getGroup()); 
            // InternalXUmlb.g:519:3: ( rule__SubtypeGroup__Group__0 )
            // InternalXUmlb.g:519:4: rule__SubtypeGroup__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SubtypeGroup__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubtypeGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubtypeGroup"


    // $ANTLR start "entryRuleClassAttribute"
    // InternalXUmlb.g:528:1: entryRuleClassAttribute : ruleClassAttribute EOF ;
    public final void entryRuleClassAttribute() throws RecognitionException {
        try {
            // InternalXUmlb.g:529:1: ( ruleClassAttribute EOF )
            // InternalXUmlb.g:530:1: ruleClassAttribute EOF
            {
             before(grammarAccess.getClassAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleClassAttribute();

            state._fsp--;

             after(grammarAccess.getClassAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassAttribute"


    // $ANTLR start "ruleClassAttribute"
    // InternalXUmlb.g:537:1: ruleClassAttribute : ( ( rule__ClassAttribute__Group__0 ) ) ;
    public final void ruleClassAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:541:2: ( ( ( rule__ClassAttribute__Group__0 ) ) )
            // InternalXUmlb.g:542:2: ( ( rule__ClassAttribute__Group__0 ) )
            {
            // InternalXUmlb.g:542:2: ( ( rule__ClassAttribute__Group__0 ) )
            // InternalXUmlb.g:543:3: ( rule__ClassAttribute__Group__0 )
            {
             before(grammarAccess.getClassAttributeAccess().getGroup()); 
            // InternalXUmlb.g:544:3: ( rule__ClassAttribute__Group__0 )
            // InternalXUmlb.g:544:4: rule__ClassAttribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassAttribute"


    // $ANTLR start "entryRuleClassConstraint"
    // InternalXUmlb.g:553:1: entryRuleClassConstraint : ruleClassConstraint EOF ;
    public final void entryRuleClassConstraint() throws RecognitionException {
        try {
            // InternalXUmlb.g:554:1: ( ruleClassConstraint EOF )
            // InternalXUmlb.g:555:1: ruleClassConstraint EOF
            {
             before(grammarAccess.getClassConstraintRule()); 
            pushFollow(FOLLOW_1);
            ruleClassConstraint();

            state._fsp--;

             after(grammarAccess.getClassConstraintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassConstraint"


    // $ANTLR start "ruleClassConstraint"
    // InternalXUmlb.g:562:1: ruleClassConstraint : ( ( rule__ClassConstraint__Group__0 ) ) ;
    public final void ruleClassConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:566:2: ( ( ( rule__ClassConstraint__Group__0 ) ) )
            // InternalXUmlb.g:567:2: ( ( rule__ClassConstraint__Group__0 ) )
            {
            // InternalXUmlb.g:567:2: ( ( rule__ClassConstraint__Group__0 ) )
            // InternalXUmlb.g:568:3: ( rule__ClassConstraint__Group__0 )
            {
             before(grammarAccess.getClassConstraintAccess().getGroup()); 
            // InternalXUmlb.g:569:3: ( rule__ClassConstraint__Group__0 )
            // InternalXUmlb.g:569:4: rule__ClassConstraint__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ClassConstraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassConstraintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassConstraint"


    // $ANTLR start "entryRuleClassMethod"
    // InternalXUmlb.g:578:1: entryRuleClassMethod : ruleClassMethod EOF ;
    public final void entryRuleClassMethod() throws RecognitionException {
        try {
            // InternalXUmlb.g:579:1: ( ruleClassMethod EOF )
            // InternalXUmlb.g:580:1: ruleClassMethod EOF
            {
             before(grammarAccess.getClassMethodRule()); 
            pushFollow(FOLLOW_1);
            ruleClassMethod();

            state._fsp--;

             after(grammarAccess.getClassMethodRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassMethod"


    // $ANTLR start "ruleClassMethod"
    // InternalXUmlb.g:587:1: ruleClassMethod : ( ( rule__ClassMethod__Group__0 ) ) ;
    public final void ruleClassMethod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:591:2: ( ( ( rule__ClassMethod__Group__0 ) ) )
            // InternalXUmlb.g:592:2: ( ( rule__ClassMethod__Group__0 ) )
            {
            // InternalXUmlb.g:592:2: ( ( rule__ClassMethod__Group__0 ) )
            // InternalXUmlb.g:593:3: ( rule__ClassMethod__Group__0 )
            {
             before(grammarAccess.getClassMethodAccess().getGroup()); 
            // InternalXUmlb.g:594:3: ( rule__ClassMethod__Group__0 )
            // InternalXUmlb.g:594:4: rule__ClassMethod__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassMethodAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassMethod"


    // $ANTLR start "entryRuleEString"
    // InternalXUmlb.g:603:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalXUmlb.g:604:1: ( ruleEString EOF )
            // InternalXUmlb.g:605:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalXUmlb.g:612:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:616:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalXUmlb.g:617:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalXUmlb.g:617:2: ( ( rule__EString__Alternatives ) )
            // InternalXUmlb.g:618:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalXUmlb.g:619:3: ( rule__EString__Alternatives )
            // InternalXUmlb.g:619:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalXUmlb.g:628:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalXUmlb.g:629:1: ( ruleQualifiedName EOF )
            // InternalXUmlb.g:630:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalXUmlb.g:637:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:641:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalXUmlb.g:642:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalXUmlb.g:642:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalXUmlb.g:643:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalXUmlb.g:644:3: ( rule__QualifiedName__Group__0 )
            // InternalXUmlb.g:644:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleXFormula"
    // InternalXUmlb.g:653:1: entryRuleXFormula : ruleXFormula EOF ;
    public final void entryRuleXFormula() throws RecognitionException {
        try {
            // InternalXUmlb.g:654:1: ( ruleXFormula EOF )
            // InternalXUmlb.g:655:1: ruleXFormula EOF
            {
             before(grammarAccess.getXFormulaRule()); 
            pushFollow(FOLLOW_1);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getXFormulaRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXFormula"


    // $ANTLR start "ruleXFormula"
    // InternalXUmlb.g:662:1: ruleXFormula : ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) ) ;
    public final void ruleXFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:666:2: ( ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) ) )
            // InternalXUmlb.g:667:2: ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) )
            {
            // InternalXUmlb.g:667:2: ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) )
            // InternalXUmlb.g:668:3: ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* )
            {
            // InternalXUmlb.g:668:3: ( ( rule__XFormula__Alternatives ) )
            // InternalXUmlb.g:669:4: ( rule__XFormula__Alternatives )
            {
             before(grammarAccess.getXFormulaAccess().getAlternatives()); 
            // InternalXUmlb.g:670:4: ( rule__XFormula__Alternatives )
            // InternalXUmlb.g:670:5: rule__XFormula__Alternatives
            {
            pushFollow(FOLLOW_3);
            rule__XFormula__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getXFormulaAccess().getAlternatives()); 

            }

            // InternalXUmlb.g:673:3: ( ( rule__XFormula__Alternatives )* )
            // InternalXUmlb.g:674:4: ( rule__XFormula__Alternatives )*
            {
             before(grammarAccess.getXFormulaAccess().getAlternatives()); 
            // InternalXUmlb.g:675:4: ( rule__XFormula__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==RULE_INT||(LA1_0>=12 && LA1_0<=109)||LA1_0==155) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalXUmlb.g:675:5: rule__XFormula__Alternatives
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__XFormula__Alternatives();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getXFormulaAccess().getAlternatives()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXFormula"


    // $ANTLR start "entryRuleEVENTB_IDENTIFIER_KEYWORD"
    // InternalXUmlb.g:685:1: entryRuleEVENTB_IDENTIFIER_KEYWORD : ruleEVENTB_IDENTIFIER_KEYWORD EOF ;
    public final void entryRuleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {
        try {
            // InternalXUmlb.g:686:1: ( ruleEVENTB_IDENTIFIER_KEYWORD EOF )
            // InternalXUmlb.g:687:1: ruleEVENTB_IDENTIFIER_KEYWORD EOF
            {
             before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDRule()); 
            pushFollow(FOLLOW_1);
            ruleEVENTB_IDENTIFIER_KEYWORD();

            state._fsp--;

             after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEVENTB_IDENTIFIER_KEYWORD"


    // $ANTLR start "ruleEVENTB_IDENTIFIER_KEYWORD"
    // InternalXUmlb.g:694:1: ruleEVENTB_IDENTIFIER_KEYWORD : ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) ) ;
    public final void ruleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:698:2: ( ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) ) )
            // InternalXUmlb.g:699:2: ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) )
            {
            // InternalXUmlb.g:699:2: ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) )
            // InternalXUmlb.g:700:3: ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives )
            {
             before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getAlternatives()); 
            // InternalXUmlb.g:701:3: ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives )
            // InternalXUmlb.g:701:4: rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEVENTB_IDENTIFIER_KEYWORD"


    // $ANTLR start "entryRuleEVENTB_PREDICATE_SYMBOLS"
    // InternalXUmlb.g:710:1: entryRuleEVENTB_PREDICATE_SYMBOLS : ruleEVENTB_PREDICATE_SYMBOLS EOF ;
    public final void entryRuleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {
        try {
            // InternalXUmlb.g:711:1: ( ruleEVENTB_PREDICATE_SYMBOLS EOF )
            // InternalXUmlb.g:712:1: ruleEVENTB_PREDICATE_SYMBOLS EOF
            {
             before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSRule()); 
            pushFollow(FOLLOW_1);
            ruleEVENTB_PREDICATE_SYMBOLS();

            state._fsp--;

             after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEVENTB_PREDICATE_SYMBOLS"


    // $ANTLR start "ruleEVENTB_PREDICATE_SYMBOLS"
    // InternalXUmlb.g:719:1: ruleEVENTB_PREDICATE_SYMBOLS : ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) ) ;
    public final void ruleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:723:2: ( ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) ) )
            // InternalXUmlb.g:724:2: ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) )
            {
            // InternalXUmlb.g:724:2: ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) )
            // InternalXUmlb.g:725:3: ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives )
            {
             before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAlternatives()); 
            // InternalXUmlb.g:726:3: ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives )
            // InternalXUmlb.g:726:4: rule__EVENTB_PREDICATE_SYMBOLS__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EVENTB_PREDICATE_SYMBOLS__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEVENTB_PREDICATE_SYMBOLS"


    // $ANTLR start "entryRuleEVENTB_EXPRESSION_SYMBOLS"
    // InternalXUmlb.g:735:1: entryRuleEVENTB_EXPRESSION_SYMBOLS : ruleEVENTB_EXPRESSION_SYMBOLS EOF ;
    public final void entryRuleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {
        try {
            // InternalXUmlb.g:736:1: ( ruleEVENTB_EXPRESSION_SYMBOLS EOF )
            // InternalXUmlb.g:737:1: ruleEVENTB_EXPRESSION_SYMBOLS EOF
            {
             before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSRule()); 
            pushFollow(FOLLOW_1);
            ruleEVENTB_EXPRESSION_SYMBOLS();

            state._fsp--;

             after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEVENTB_EXPRESSION_SYMBOLS"


    // $ANTLR start "ruleEVENTB_EXPRESSION_SYMBOLS"
    // InternalXUmlb.g:744:1: ruleEVENTB_EXPRESSION_SYMBOLS : ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) ) ;
    public final void ruleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:748:2: ( ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) ) )
            // InternalXUmlb.g:749:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) )
            {
            // InternalXUmlb.g:749:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) )
            // InternalXUmlb.g:750:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives )
            {
             before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAlternatives()); 
            // InternalXUmlb.g:751:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives )
            // InternalXUmlb.g:751:4: rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEVENTB_EXPRESSION_SYMBOLS"


    // $ANTLR start "entryRuleInvariant"
    // InternalXUmlb.g:760:1: entryRuleInvariant : ruleInvariant EOF ;
    public final void entryRuleInvariant() throws RecognitionException {
        try {
            // InternalXUmlb.g:761:1: ( ruleInvariant EOF )
            // InternalXUmlb.g:762:1: ruleInvariant EOF
            {
             before(grammarAccess.getInvariantRule()); 
            pushFollow(FOLLOW_1);
            ruleInvariant();

            state._fsp--;

             after(grammarAccess.getInvariantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInvariant"


    // $ANTLR start "ruleInvariant"
    // InternalXUmlb.g:769:1: ruleInvariant : ( ( rule__Invariant__Group__0 ) ) ;
    public final void ruleInvariant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:773:2: ( ( ( rule__Invariant__Group__0 ) ) )
            // InternalXUmlb.g:774:2: ( ( rule__Invariant__Group__0 ) )
            {
            // InternalXUmlb.g:774:2: ( ( rule__Invariant__Group__0 ) )
            // InternalXUmlb.g:775:3: ( rule__Invariant__Group__0 )
            {
             before(grammarAccess.getInvariantAccess().getGroup()); 
            // InternalXUmlb.g:776:3: ( rule__Invariant__Group__0 )
            // InternalXUmlb.g:776:4: rule__Invariant__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Invariant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInvariantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInvariant"


    // $ANTLR start "entryRuleGuard"
    // InternalXUmlb.g:785:1: entryRuleGuard : ruleGuard EOF ;
    public final void entryRuleGuard() throws RecognitionException {
        try {
            // InternalXUmlb.g:786:1: ( ruleGuard EOF )
            // InternalXUmlb.g:787:1: ruleGuard EOF
            {
             before(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_1);
            ruleGuard();

            state._fsp--;

             after(grammarAccess.getGuardRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // InternalXUmlb.g:794:1: ruleGuard : ( ( rule__Guard__Group__0 ) ) ;
    public final void ruleGuard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:798:2: ( ( ( rule__Guard__Group__0 ) ) )
            // InternalXUmlb.g:799:2: ( ( rule__Guard__Group__0 ) )
            {
            // InternalXUmlb.g:799:2: ( ( rule__Guard__Group__0 ) )
            // InternalXUmlb.g:800:3: ( rule__Guard__Group__0 )
            {
             before(grammarAccess.getGuardAccess().getGroup()); 
            // InternalXUmlb.g:801:3: ( rule__Guard__Group__0 )
            // InternalXUmlb.g:801:4: rule__Guard__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Guard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGuardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGuard"


    // $ANTLR start "entryRuleAction"
    // InternalXUmlb.g:810:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalXUmlb.g:811:1: ( ruleAction EOF )
            // InternalXUmlb.g:812:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalXUmlb.g:819:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:823:2: ( ( ( rule__Action__Group__0 ) ) )
            // InternalXUmlb.g:824:2: ( ( rule__Action__Group__0 ) )
            {
            // InternalXUmlb.g:824:2: ( ( rule__Action__Group__0 ) )
            // InternalXUmlb.g:825:3: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // InternalXUmlb.g:826:3: ( rule__Action__Group__0 )
            // InternalXUmlb.g:826:4: rule__Action__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleWitness"
    // InternalXUmlb.g:835:1: entryRuleWitness : ruleWitness EOF ;
    public final void entryRuleWitness() throws RecognitionException {
        try {
            // InternalXUmlb.g:836:1: ( ruleWitness EOF )
            // InternalXUmlb.g:837:1: ruleWitness EOF
            {
             before(grammarAccess.getWitnessRule()); 
            pushFollow(FOLLOW_1);
            ruleWitness();

            state._fsp--;

             after(grammarAccess.getWitnessRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWitness"


    // $ANTLR start "ruleWitness"
    // InternalXUmlb.g:844:1: ruleWitness : ( ( rule__Witness__Group__0 ) ) ;
    public final void ruleWitness() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:848:2: ( ( ( rule__Witness__Group__0 ) ) )
            // InternalXUmlb.g:849:2: ( ( rule__Witness__Group__0 ) )
            {
            // InternalXUmlb.g:849:2: ( ( rule__Witness__Group__0 ) )
            // InternalXUmlb.g:850:3: ( rule__Witness__Group__0 )
            {
             before(grammarAccess.getWitnessAccess().getGroup()); 
            // InternalXUmlb.g:851:3: ( rule__Witness__Group__0 )
            // InternalXUmlb.g:851:4: rule__Witness__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Witness__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWitnessAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWitness"


    // $ANTLR start "ruleTranslationKind"
    // InternalXUmlb.g:860:1: ruleTranslationKind : ( ( rule__TranslationKind__Alternatives ) ) ;
    public final void ruleTranslationKind() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:864:1: ( ( ( rule__TranslationKind__Alternatives ) ) )
            // InternalXUmlb.g:865:2: ( ( rule__TranslationKind__Alternatives ) )
            {
            // InternalXUmlb.g:865:2: ( ( rule__TranslationKind__Alternatives ) )
            // InternalXUmlb.g:866:3: ( rule__TranslationKind__Alternatives )
            {
             before(grammarAccess.getTranslationKindAccess().getAlternatives()); 
            // InternalXUmlb.g:867:3: ( rule__TranslationKind__Alternatives )
            // InternalXUmlb.g:867:4: rule__TranslationKind__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TranslationKind__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTranslationKindAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTranslationKind"


    // $ANTLR start "ruleMethodKind"
    // InternalXUmlb.g:876:1: ruleMethodKind : ( ( rule__MethodKind__Alternatives ) ) ;
    public final void ruleMethodKind() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:880:1: ( ( ( rule__MethodKind__Alternatives ) ) )
            // InternalXUmlb.g:881:2: ( ( rule__MethodKind__Alternatives ) )
            {
            // InternalXUmlb.g:881:2: ( ( rule__MethodKind__Alternatives ) )
            // InternalXUmlb.g:882:3: ( rule__MethodKind__Alternatives )
            {
             before(grammarAccess.getMethodKindAccess().getAlternatives()); 
            // InternalXUmlb.g:883:3: ( rule__MethodKind__Alternatives )
            // InternalXUmlb.g:883:4: rule__MethodKind__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MethodKind__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMethodKindAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMethodKind"


    // $ANTLR start "ruleDataKind"
    // InternalXUmlb.g:892:1: ruleDataKind : ( ( rule__DataKind__Alternatives ) ) ;
    public final void ruleDataKind() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:896:1: ( ( ( rule__DataKind__Alternatives ) ) )
            // InternalXUmlb.g:897:2: ( ( rule__DataKind__Alternatives ) )
            {
            // InternalXUmlb.g:897:2: ( ( rule__DataKind__Alternatives ) )
            // InternalXUmlb.g:898:3: ( rule__DataKind__Alternatives )
            {
             before(grammarAccess.getDataKindAccess().getAlternatives()); 
            // InternalXUmlb.g:899:3: ( rule__DataKind__Alternatives )
            // InternalXUmlb.g:899:4: rule__DataKind__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DataKind__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDataKindAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataKind"


    // $ANTLR start "rule__XDiagram__Alternatives"
    // InternalXUmlb.g:907:1: rule__XDiagram__Alternatives : ( ( ruleStatemachine ) | ( ruleClassdiagram ) );
    public final void rule__XDiagram__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:911:1: ( ( ruleStatemachine ) | ( ruleClassdiagram ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==122) ) {
                alt2=1;
            }
            else if ( (LA2_0==143) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalXUmlb.g:912:2: ( ruleStatemachine )
                    {
                    // InternalXUmlb.g:912:2: ( ruleStatemachine )
                    // InternalXUmlb.g:913:3: ruleStatemachine
                    {
                     before(grammarAccess.getXDiagramAccess().getStatemachineParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleStatemachine();

                    state._fsp--;

                     after(grammarAccess.getXDiagramAccess().getStatemachineParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:918:2: ( ruleClassdiagram )
                    {
                    // InternalXUmlb.g:918:2: ( ruleClassdiagram )
                    // InternalXUmlb.g:919:3: ruleClassdiagram
                    {
                     before(grammarAccess.getXDiagramAccess().getClassdiagramParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleClassdiagram();

                    state._fsp--;

                     after(grammarAccess.getXDiagramAccess().getClassdiagramParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XDiagram__Alternatives"


    // $ANTLR start "rule__AbstractNode__Alternatives"
    // InternalXUmlb.g:928:1: rule__AbstractNode__Alternatives : ( ( ruleState ) | ( ruleInitial ) | ( ruleFinal ) | ( ruleAny ) | ( ruleJunction ) | ( ruleFork ) );
    public final void rule__AbstractNode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:932:1: ( ( ruleState ) | ( ruleInitial ) | ( ruleFinal ) | ( ruleAny ) | ( ruleJunction ) | ( ruleFork ) )
            int alt3=6;
            switch ( input.LA(1) ) {
            case 133:
                {
                alt3=1;
                }
                break;
            case 139:
                {
                alt3=2;
                }
                break;
            case 140:
                {
                alt3=3;
                }
                break;
            case 129:
                {
                alt3=4;
                }
                break;
            case 141:
                {
                alt3=5;
                }
                break;
            case 142:
                {
                alt3=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalXUmlb.g:933:2: ( ruleState )
                    {
                    // InternalXUmlb.g:933:2: ( ruleState )
                    // InternalXUmlb.g:934:3: ruleState
                    {
                     before(grammarAccess.getAbstractNodeAccess().getStateParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleState();

                    state._fsp--;

                     after(grammarAccess.getAbstractNodeAccess().getStateParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:939:2: ( ruleInitial )
                    {
                    // InternalXUmlb.g:939:2: ( ruleInitial )
                    // InternalXUmlb.g:940:3: ruleInitial
                    {
                     before(grammarAccess.getAbstractNodeAccess().getInitialParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleInitial();

                    state._fsp--;

                     after(grammarAccess.getAbstractNodeAccess().getInitialParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:945:2: ( ruleFinal )
                    {
                    // InternalXUmlb.g:945:2: ( ruleFinal )
                    // InternalXUmlb.g:946:3: ruleFinal
                    {
                     before(grammarAccess.getAbstractNodeAccess().getFinalParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleFinal();

                    state._fsp--;

                     after(grammarAccess.getAbstractNodeAccess().getFinalParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXUmlb.g:951:2: ( ruleAny )
                    {
                    // InternalXUmlb.g:951:2: ( ruleAny )
                    // InternalXUmlb.g:952:3: ruleAny
                    {
                     before(grammarAccess.getAbstractNodeAccess().getAnyParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleAny();

                    state._fsp--;

                     after(grammarAccess.getAbstractNodeAccess().getAnyParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXUmlb.g:957:2: ( ruleJunction )
                    {
                    // InternalXUmlb.g:957:2: ( ruleJunction )
                    // InternalXUmlb.g:958:3: ruleJunction
                    {
                     before(grammarAccess.getAbstractNodeAccess().getJunctionParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleJunction();

                    state._fsp--;

                     after(grammarAccess.getAbstractNodeAccess().getJunctionParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXUmlb.g:963:2: ( ruleFork )
                    {
                    // InternalXUmlb.g:963:2: ( ruleFork )
                    // InternalXUmlb.g:964:3: ruleFork
                    {
                     before(grammarAccess.getAbstractNodeAccess().getForkParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleFork();

                    state._fsp--;

                     after(grammarAccess.getAbstractNodeAccess().getForkParserRuleCall_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractNode__Alternatives"


    // $ANTLR start "rule__XComplexType__Alternatives"
    // InternalXUmlb.g:973:1: rule__XComplexType__Alternatives : ( ( ( rule__XComplexType__Group_0__0 ) ) | ( ruleEVENT_B_BUILDIN_TYPE ) | ( RULE_ID ) );
    public final void rule__XComplexType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:977:1: ( ( ( rule__XComplexType__Group_0__0 ) ) | ( ruleEVENT_B_BUILDIN_TYPE ) | ( RULE_ID ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt4=1;
                }
                break;
            case 12:
            case 13:
                {
                alt4=2;
                }
                break;
            case RULE_ID:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalXUmlb.g:978:2: ( ( rule__XComplexType__Group_0__0 ) )
                    {
                    // InternalXUmlb.g:978:2: ( ( rule__XComplexType__Group_0__0 ) )
                    // InternalXUmlb.g:979:3: ( rule__XComplexType__Group_0__0 )
                    {
                     before(grammarAccess.getXComplexTypeAccess().getGroup_0()); 
                    // InternalXUmlb.g:980:3: ( rule__XComplexType__Group_0__0 )
                    // InternalXUmlb.g:980:4: rule__XComplexType__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XComplexType__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXComplexTypeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:984:2: ( ruleEVENT_B_BUILDIN_TYPE )
                    {
                    // InternalXUmlb.g:984:2: ( ruleEVENT_B_BUILDIN_TYPE )
                    // InternalXUmlb.g:985:3: ruleEVENT_B_BUILDIN_TYPE
                    {
                     before(grammarAccess.getXComplexTypeAccess().getEVENT_B_BUILDIN_TYPEParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEVENT_B_BUILDIN_TYPE();

                    state._fsp--;

                     after(grammarAccess.getXComplexTypeAccess().getEVENT_B_BUILDIN_TYPEParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:990:2: ( RULE_ID )
                    {
                    // InternalXUmlb.g:990:2: ( RULE_ID )
                    // InternalXUmlb.g:991:3: RULE_ID
                    {
                     before(grammarAccess.getXComplexTypeAccess().getIDTerminalRuleCall_2()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getXComplexTypeAccess().getIDTerminalRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XComplexType__Alternatives"


    // $ANTLR start "rule__EVENT_B_BUILDIN_TYPE__Alternatives"
    // InternalXUmlb.g:1000:1: rule__EVENT_B_BUILDIN_TYPE__Alternatives : ( ( 'BOOL' ) | ( '\\u2124' ) );
    public final void rule__EVENT_B_BUILDIN_TYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1004:1: ( ( 'BOOL' ) | ( '\\u2124' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            else if ( (LA5_0==13) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalXUmlb.g:1005:2: ( 'BOOL' )
                    {
                    // InternalXUmlb.g:1005:2: ( 'BOOL' )
                    // InternalXUmlb.g:1006:3: 'BOOL'
                    {
                     before(grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getBOOLKeyword_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getBOOLKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:1011:2: ( '\\u2124' )
                    {
                    // InternalXUmlb.g:1011:2: ( '\\u2124' )
                    // InternalXUmlb.g:1012:3: '\\u2124'
                    {
                     before(grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getDoubleStruckCapitalZKeyword_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEVENT_B_BUILDIN_TYPEAccess().getDoubleStruckCapitalZKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENT_B_BUILDIN_TYPE__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalXUmlb.g:1021:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1025:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXUmlb.g:1026:2: ( RULE_STRING )
                    {
                    // InternalXUmlb.g:1026:2: ( RULE_STRING )
                    // InternalXUmlb.g:1027:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:1032:2: ( RULE_ID )
                    {
                    // InternalXUmlb.g:1032:2: ( RULE_ID )
                    // InternalXUmlb.g:1033:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__XFormula__Alternatives"
    // InternalXUmlb.g:1042:1: rule__XFormula__Alternatives : ( ( ruleEVENTB_IDENTIFIER_KEYWORD ) | ( ruleEVENTB_PREDICATE_SYMBOLS ) | ( ruleEVENTB_EXPRESSION_SYMBOLS ) | ( RULE_ID ) | ( RULE_INT ) );
    public final void rule__XFormula__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1046:1: ( ( ruleEVENTB_IDENTIFIER_KEYWORD ) | ( ruleEVENTB_PREDICATE_SYMBOLS ) | ( ruleEVENTB_EXPRESSION_SYMBOLS ) | ( RULE_ID ) | ( RULE_INT ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                {
                alt7=1;
                }
                break;
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
                {
                alt7=2;
                }
                break;
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
            case 155:
                {
                alt7=3;
                }
                break;
            case RULE_ID:
                {
                alt7=4;
                }
                break;
            case RULE_INT:
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalXUmlb.g:1047:2: ( ruleEVENTB_IDENTIFIER_KEYWORD )
                    {
                    // InternalXUmlb.g:1047:2: ( ruleEVENTB_IDENTIFIER_KEYWORD )
                    // InternalXUmlb.g:1048:3: ruleEVENTB_IDENTIFIER_KEYWORD
                    {
                     before(grammarAccess.getXFormulaAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEVENTB_IDENTIFIER_KEYWORD();

                    state._fsp--;

                     after(grammarAccess.getXFormulaAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:1053:2: ( ruleEVENTB_PREDICATE_SYMBOLS )
                    {
                    // InternalXUmlb.g:1053:2: ( ruleEVENTB_PREDICATE_SYMBOLS )
                    // InternalXUmlb.g:1054:3: ruleEVENTB_PREDICATE_SYMBOLS
                    {
                     before(grammarAccess.getXFormulaAccess().getEVENTB_PREDICATE_SYMBOLSParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEVENTB_PREDICATE_SYMBOLS();

                    state._fsp--;

                     after(grammarAccess.getXFormulaAccess().getEVENTB_PREDICATE_SYMBOLSParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:1059:2: ( ruleEVENTB_EXPRESSION_SYMBOLS )
                    {
                    // InternalXUmlb.g:1059:2: ( ruleEVENTB_EXPRESSION_SYMBOLS )
                    // InternalXUmlb.g:1060:3: ruleEVENTB_EXPRESSION_SYMBOLS
                    {
                     before(grammarAccess.getXFormulaAccess().getEVENTB_EXPRESSION_SYMBOLSParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleEVENTB_EXPRESSION_SYMBOLS();

                    state._fsp--;

                     after(grammarAccess.getXFormulaAccess().getEVENTB_EXPRESSION_SYMBOLSParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXUmlb.g:1065:2: ( RULE_ID )
                    {
                    // InternalXUmlb.g:1065:2: ( RULE_ID )
                    // InternalXUmlb.g:1066:3: RULE_ID
                    {
                     before(grammarAccess.getXFormulaAccess().getIDTerminalRuleCall_3()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getXFormulaAccess().getIDTerminalRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXUmlb.g:1071:2: ( RULE_INT )
                    {
                    // InternalXUmlb.g:1071:2: ( RULE_INT )
                    // InternalXUmlb.g:1072:3: RULE_INT
                    {
                     before(grammarAccess.getXFormulaAccess().getINTTerminalRuleCall_4()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getXFormulaAccess().getINTTerminalRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XFormula__Alternatives"


    // $ANTLR start "rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives"
    // InternalXUmlb.g:1081:1: rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives : ( ( 'BOOL' ) | ( 'FALSE' ) | ( 'TRUE' ) | ( 'bool' ) | ( 'card' ) | ( 'dom' ) | ( 'finite' ) | ( 'id' ) | ( 'inter' ) | ( 'max' ) | ( 'min' ) | ( 'mod' ) | ( 'pred' ) | ( 'prj1' ) | ( 'prj2' ) | ( 'ran' ) | ( 'succ' ) | ( 'union' ) | ( '\\u21151' ) | ( '\\u2115' ) | ( '\\u21191' ) | ( '\\u2119' ) | ( '\\u2124' ) );
    public final void rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1085:1: ( ( 'BOOL' ) | ( 'FALSE' ) | ( 'TRUE' ) | ( 'bool' ) | ( 'card' ) | ( 'dom' ) | ( 'finite' ) | ( 'id' ) | ( 'inter' ) | ( 'max' ) | ( 'min' ) | ( 'mod' ) | ( 'pred' ) | ( 'prj1' ) | ( 'prj2' ) | ( 'ran' ) | ( 'succ' ) | ( 'union' ) | ( '\\u21151' ) | ( '\\u2115' ) | ( '\\u21191' ) | ( '\\u2119' ) | ( '\\u2124' ) )
            int alt8=23;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt8=1;
                }
                break;
            case 14:
                {
                alt8=2;
                }
                break;
            case 15:
                {
                alt8=3;
                }
                break;
            case 16:
                {
                alt8=4;
                }
                break;
            case 17:
                {
                alt8=5;
                }
                break;
            case 18:
                {
                alt8=6;
                }
                break;
            case 19:
                {
                alt8=7;
                }
                break;
            case 20:
                {
                alt8=8;
                }
                break;
            case 21:
                {
                alt8=9;
                }
                break;
            case 22:
                {
                alt8=10;
                }
                break;
            case 23:
                {
                alt8=11;
                }
                break;
            case 24:
                {
                alt8=12;
                }
                break;
            case 25:
                {
                alt8=13;
                }
                break;
            case 26:
                {
                alt8=14;
                }
                break;
            case 27:
                {
                alt8=15;
                }
                break;
            case 28:
                {
                alt8=16;
                }
                break;
            case 29:
                {
                alt8=17;
                }
                break;
            case 30:
                {
                alt8=18;
                }
                break;
            case 31:
                {
                alt8=19;
                }
                break;
            case 32:
                {
                alt8=20;
                }
                break;
            case 33:
                {
                alt8=21;
                }
                break;
            case 34:
                {
                alt8=22;
                }
                break;
            case 13:
                {
                alt8=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalXUmlb.g:1086:2: ( 'BOOL' )
                    {
                    // InternalXUmlb.g:1086:2: ( 'BOOL' )
                    // InternalXUmlb.g:1087:3: 'BOOL'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBOOLKeyword_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBOOLKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:1092:2: ( 'FALSE' )
                    {
                    // InternalXUmlb.g:1092:2: ( 'FALSE' )
                    // InternalXUmlb.g:1093:3: 'FALSE'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFALSEKeyword_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFALSEKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:1098:2: ( 'TRUE' )
                    {
                    // InternalXUmlb.g:1098:2: ( 'TRUE' )
                    // InternalXUmlb.g:1099:3: 'TRUE'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getTRUEKeyword_2()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getTRUEKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXUmlb.g:1104:2: ( 'bool' )
                    {
                    // InternalXUmlb.g:1104:2: ( 'bool' )
                    // InternalXUmlb.g:1105:3: 'bool'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBoolKeyword_3()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBoolKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXUmlb.g:1110:2: ( 'card' )
                    {
                    // InternalXUmlb.g:1110:2: ( 'card' )
                    // InternalXUmlb.g:1111:3: 'card'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getCardKeyword_4()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getCardKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXUmlb.g:1116:2: ( 'dom' )
                    {
                    // InternalXUmlb.g:1116:2: ( 'dom' )
                    // InternalXUmlb.g:1117:3: 'dom'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDomKeyword_5()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDomKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalXUmlb.g:1122:2: ( 'finite' )
                    {
                    // InternalXUmlb.g:1122:2: ( 'finite' )
                    // InternalXUmlb.g:1123:3: 'finite'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFiniteKeyword_6()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFiniteKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalXUmlb.g:1128:2: ( 'id' )
                    {
                    // InternalXUmlb.g:1128:2: ( 'id' )
                    // InternalXUmlb.g:1129:3: 'id'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getIdKeyword_7()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getIdKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalXUmlb.g:1134:2: ( 'inter' )
                    {
                    // InternalXUmlb.g:1134:2: ( 'inter' )
                    // InternalXUmlb.g:1135:3: 'inter'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getInterKeyword_8()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getInterKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalXUmlb.g:1140:2: ( 'max' )
                    {
                    // InternalXUmlb.g:1140:2: ( 'max' )
                    // InternalXUmlb.g:1141:3: 'max'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMaxKeyword_9()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMaxKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalXUmlb.g:1146:2: ( 'min' )
                    {
                    // InternalXUmlb.g:1146:2: ( 'min' )
                    // InternalXUmlb.g:1147:3: 'min'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMinKeyword_10()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMinKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalXUmlb.g:1152:2: ( 'mod' )
                    {
                    // InternalXUmlb.g:1152:2: ( 'mod' )
                    // InternalXUmlb.g:1153:3: 'mod'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getModKeyword_11()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getModKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalXUmlb.g:1158:2: ( 'pred' )
                    {
                    // InternalXUmlb.g:1158:2: ( 'pred' )
                    // InternalXUmlb.g:1159:3: 'pred'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPredKeyword_12()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPredKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalXUmlb.g:1164:2: ( 'prj1' )
                    {
                    // InternalXUmlb.g:1164:2: ( 'prj1' )
                    // InternalXUmlb.g:1165:3: 'prj1'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj1Keyword_13()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj1Keyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalXUmlb.g:1170:2: ( 'prj2' )
                    {
                    // InternalXUmlb.g:1170:2: ( 'prj2' )
                    // InternalXUmlb.g:1171:3: 'prj2'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj2Keyword_14()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj2Keyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalXUmlb.g:1176:2: ( 'ran' )
                    {
                    // InternalXUmlb.g:1176:2: ( 'ran' )
                    // InternalXUmlb.g:1177:3: 'ran'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getRanKeyword_15()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getRanKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalXUmlb.g:1182:2: ( 'succ' )
                    {
                    // InternalXUmlb.g:1182:2: ( 'succ' )
                    // InternalXUmlb.g:1183:3: 'succ'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getSuccKeyword_16()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getSuccKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalXUmlb.g:1188:2: ( 'union' )
                    {
                    // InternalXUmlb.g:1188:2: ( 'union' )
                    // InternalXUmlb.g:1189:3: 'union'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getUnionKeyword_17()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getUnionKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalXUmlb.g:1194:2: ( '\\u21151' )
                    {
                    // InternalXUmlb.g:1194:2: ( '\\u21151' )
                    // InternalXUmlb.g:1195:3: '\\u21151'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNDigitOneKeyword_18()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNDigitOneKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalXUmlb.g:1200:2: ( '\\u2115' )
                    {
                    // InternalXUmlb.g:1200:2: ( '\\u2115' )
                    // InternalXUmlb.g:1201:3: '\\u2115'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNKeyword_19()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalXUmlb.g:1206:2: ( '\\u21191' )
                    {
                    // InternalXUmlb.g:1206:2: ( '\\u21191' )
                    // InternalXUmlb.g:1207:3: '\\u21191'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPDigitOneKeyword_20()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPDigitOneKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalXUmlb.g:1212:2: ( '\\u2119' )
                    {
                    // InternalXUmlb.g:1212:2: ( '\\u2119' )
                    // InternalXUmlb.g:1213:3: '\\u2119'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPKeyword_21()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalXUmlb.g:1218:2: ( '\\u2124' )
                    {
                    // InternalXUmlb.g:1218:2: ( '\\u2124' )
                    // InternalXUmlb.g:1219:3: '\\u2124'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalZKeyword_22()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalZKeyword_22()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives"


    // $ANTLR start "rule__EVENTB_PREDICATE_SYMBOLS__Alternatives"
    // InternalXUmlb.g:1228:1: rule__EVENTB_PREDICATE_SYMBOLS__Alternatives : ( ( '(' ) | ( ')' ) | ( '\\u21D4' ) | ( '\\u21D2' ) | ( '\\u2227' ) | ( '&' ) | ( '\\u2228' ) | ( '\\u00AC' ) | ( '\\u22A4' ) | ( '\\u22A5' ) | ( '\\u2200' ) | ( '!' ) | ( '\\u2203' ) | ( '#' ) | ( ',' ) | ( '\\u00B7' ) | ( '.' ) | ( '=' ) | ( '\\u2260' ) | ( '\\u2264' ) | ( '<' ) | ( '\\u2265' ) | ( '>' ) | ( '\\u2208' ) | ( ':' ) | ( '\\u2209' ) | ( '\\u2282' ) | ( '\\u2284' ) | ( '\\u2286' ) | ( '\\u2288' ) | ( 'partition' ) );
    public final void rule__EVENTB_PREDICATE_SYMBOLS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1232:1: ( ( '(' ) | ( ')' ) | ( '\\u21D4' ) | ( '\\u21D2' ) | ( '\\u2227' ) | ( '&' ) | ( '\\u2228' ) | ( '\\u00AC' ) | ( '\\u22A4' ) | ( '\\u22A5' ) | ( '\\u2200' ) | ( '!' ) | ( '\\u2203' ) | ( '#' ) | ( ',' ) | ( '\\u00B7' ) | ( '.' ) | ( '=' ) | ( '\\u2260' ) | ( '\\u2264' ) | ( '<' ) | ( '\\u2265' ) | ( '>' ) | ( '\\u2208' ) | ( ':' ) | ( '\\u2209' ) | ( '\\u2282' ) | ( '\\u2284' ) | ( '\\u2286' ) | ( '\\u2288' ) | ( 'partition' ) )
            int alt9=31;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt9=1;
                }
                break;
            case 36:
                {
                alt9=2;
                }
                break;
            case 37:
                {
                alt9=3;
                }
                break;
            case 38:
                {
                alt9=4;
                }
                break;
            case 39:
                {
                alt9=5;
                }
                break;
            case 40:
                {
                alt9=6;
                }
                break;
            case 41:
                {
                alt9=7;
                }
                break;
            case 42:
                {
                alt9=8;
                }
                break;
            case 43:
                {
                alt9=9;
                }
                break;
            case 44:
                {
                alt9=10;
                }
                break;
            case 45:
                {
                alt9=11;
                }
                break;
            case 46:
                {
                alt9=12;
                }
                break;
            case 47:
                {
                alt9=13;
                }
                break;
            case 48:
                {
                alt9=14;
                }
                break;
            case 49:
                {
                alt9=15;
                }
                break;
            case 50:
                {
                alt9=16;
                }
                break;
            case 51:
                {
                alt9=17;
                }
                break;
            case 52:
                {
                alt9=18;
                }
                break;
            case 53:
                {
                alt9=19;
                }
                break;
            case 54:
                {
                alt9=20;
                }
                break;
            case 55:
                {
                alt9=21;
                }
                break;
            case 56:
                {
                alt9=22;
                }
                break;
            case 57:
                {
                alt9=23;
                }
                break;
            case 58:
                {
                alt9=24;
                }
                break;
            case 59:
                {
                alt9=25;
                }
                break;
            case 60:
                {
                alt9=26;
                }
                break;
            case 61:
                {
                alt9=27;
                }
                break;
            case 62:
                {
                alt9=28;
                }
                break;
            case 63:
                {
                alt9=29;
                }
                break;
            case 64:
                {
                alt9=30;
                }
                break;
            case 65:
                {
                alt9=31;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalXUmlb.g:1233:2: ( '(' )
                    {
                    // InternalXUmlb.g:1233:2: ( '(' )
                    // InternalXUmlb.g:1234:3: '('
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftParenthesisKeyword_0()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftParenthesisKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:1239:2: ( ')' )
                    {
                    // InternalXUmlb.g:1239:2: ( ')' )
                    // InternalXUmlb.g:1240:3: ')'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightParenthesisKeyword_1()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightParenthesisKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:1245:2: ( '\\u21D4' )
                    {
                    // InternalXUmlb.g:1245:2: ( '\\u21D4' )
                    // InternalXUmlb.g:1246:3: '\\u21D4'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftRightDoubleArrowKeyword_2()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftRightDoubleArrowKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXUmlb.g:1251:2: ( '\\u21D2' )
                    {
                    // InternalXUmlb.g:1251:2: ( '\\u21D2' )
                    // InternalXUmlb.g:1252:3: '\\u21D2'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightwardsDoubleArrowKeyword_3()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightwardsDoubleArrowKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXUmlb.g:1257:2: ( '\\u2227' )
                    {
                    // InternalXUmlb.g:1257:2: ( '\\u2227' )
                    // InternalXUmlb.g:1258:3: '\\u2227'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalAndKeyword_4()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalAndKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXUmlb.g:1263:2: ( '&' )
                    {
                    // InternalXUmlb.g:1263:2: ( '&' )
                    // InternalXUmlb.g:1264:3: '&'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAmpersandKeyword_5()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAmpersandKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalXUmlb.g:1269:2: ( '\\u2228' )
                    {
                    // InternalXUmlb.g:1269:2: ( '\\u2228' )
                    // InternalXUmlb.g:1270:3: '\\u2228'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalOrKeyword_6()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalOrKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalXUmlb.g:1275:2: ( '\\u00AC' )
                    {
                    // InternalXUmlb.g:1275:2: ( '\\u00AC' )
                    // InternalXUmlb.g:1276:3: '\\u00AC'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotSignKeyword_7()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotSignKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalXUmlb.g:1281:2: ( '\\u22A4' )
                    {
                    // InternalXUmlb.g:1281:2: ( '\\u22A4' )
                    // InternalXUmlb.g:1282:3: '\\u22A4'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getDownTackKeyword_8()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getDownTackKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalXUmlb.g:1287:2: ( '\\u22A5' )
                    {
                    // InternalXUmlb.g:1287:2: ( '\\u22A5' )
                    // InternalXUmlb.g:1288:3: '\\u22A5'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getUpTackKeyword_9()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getUpTackKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalXUmlb.g:1293:2: ( '\\u2200' )
                    {
                    // InternalXUmlb.g:1293:2: ( '\\u2200' )
                    // InternalXUmlb.g:1294:3: '\\u2200'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getForAllKeyword_10()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getForAllKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalXUmlb.g:1299:2: ( '!' )
                    {
                    // InternalXUmlb.g:1299:2: ( '!' )
                    // InternalXUmlb.g:1300:3: '!'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getExclamationMarkKeyword_11()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getExclamationMarkKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalXUmlb.g:1305:2: ( '\\u2203' )
                    {
                    // InternalXUmlb.g:1305:2: ( '\\u2203' )
                    // InternalXUmlb.g:1306:3: '\\u2203'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getThereExistsKeyword_12()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getThereExistsKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalXUmlb.g:1311:2: ( '#' )
                    {
                    // InternalXUmlb.g:1311:2: ( '#' )
                    // InternalXUmlb.g:1312:3: '#'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNumberSignKeyword_13()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNumberSignKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalXUmlb.g:1317:2: ( ',' )
                    {
                    // InternalXUmlb.g:1317:2: ( ',' )
                    // InternalXUmlb.g:1318:3: ','
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getCommaKeyword_14()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getCommaKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalXUmlb.g:1323:2: ( '\\u00B7' )
                    {
                    // InternalXUmlb.g:1323:2: ( '\\u00B7' )
                    // InternalXUmlb.g:1324:3: '\\u00B7'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getMiddleDotKeyword_15()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getMiddleDotKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalXUmlb.g:1329:2: ( '.' )
                    {
                    // InternalXUmlb.g:1329:2: ( '.' )
                    // InternalXUmlb.g:1330:3: '.'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFullStopKeyword_16()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFullStopKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalXUmlb.g:1335:2: ( '=' )
                    {
                    // InternalXUmlb.g:1335:2: ( '=' )
                    // InternalXUmlb.g:1336:3: '='
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignKeyword_17()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalXUmlb.g:1341:2: ( '\\u2260' )
                    {
                    // InternalXUmlb.g:1341:2: ( '\\u2260' )
                    // InternalXUmlb.g:1342:3: '\\u2260'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotEqualToKeyword_18()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotEqualToKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalXUmlb.g:1347:2: ( '\\u2264' )
                    {
                    // InternalXUmlb.g:1347:2: ( '\\u2264' )
                    // InternalXUmlb.g:1348:3: '\\u2264'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanOrEqualToKeyword_19()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanOrEqualToKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalXUmlb.g:1353:2: ( '<' )
                    {
                    // InternalXUmlb.g:1353:2: ( '<' )
                    // InternalXUmlb.g:1354:3: '<'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignKeyword_20()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalXUmlb.g:1359:2: ( '\\u2265' )
                    {
                    // InternalXUmlb.g:1359:2: ( '\\u2265' )
                    // InternalXUmlb.g:1360:3: '\\u2265'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanOrEqualToKeyword_21()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanOrEqualToKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalXUmlb.g:1365:2: ( '>' )
                    {
                    // InternalXUmlb.g:1365:2: ( '>' )
                    // InternalXUmlb.g:1366:3: '>'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignKeyword_22()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalXUmlb.g:1371:2: ( '\\u2208' )
                    {
                    // InternalXUmlb.g:1371:2: ( '\\u2208' )
                    // InternalXUmlb.g:1372:3: '\\u2208'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getElementOfKeyword_23()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getElementOfKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalXUmlb.g:1377:2: ( ':' )
                    {
                    // InternalXUmlb.g:1377:2: ( ':' )
                    // InternalXUmlb.g:1378:3: ':'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getColonKeyword_24()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getColonKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalXUmlb.g:1383:2: ( '\\u2209' )
                    {
                    // InternalXUmlb.g:1383:2: ( '\\u2209' )
                    // InternalXUmlb.g:1384:3: '\\u2209'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotAnElementOfKeyword_25()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotAnElementOfKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalXUmlb.g:1389:2: ( '\\u2282' )
                    {
                    // InternalXUmlb.g:1389:2: ( '\\u2282' )
                    // InternalXUmlb.g:1390:3: '\\u2282'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfKeyword_26()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalXUmlb.g:1395:2: ( '\\u2284' )
                    {
                    // InternalXUmlb.g:1395:2: ( '\\u2284' )
                    // InternalXUmlb.g:1396:3: '\\u2284'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotASubsetOfKeyword_27()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotASubsetOfKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalXUmlb.g:1401:2: ( '\\u2286' )
                    {
                    // InternalXUmlb.g:1401:2: ( '\\u2286' )
                    // InternalXUmlb.g:1402:3: '\\u2286'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfOrEqualToKeyword_28()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfOrEqualToKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalXUmlb.g:1407:2: ( '\\u2288' )
                    {
                    // InternalXUmlb.g:1407:2: ( '\\u2288' )
                    // InternalXUmlb.g:1408:3: '\\u2288'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNeitherASubsetOfNorEqualToKeyword_29()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNeitherASubsetOfNorEqualToKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalXUmlb.g:1413:2: ( 'partition' )
                    {
                    // InternalXUmlb.g:1413:2: ( 'partition' )
                    // InternalXUmlb.g:1414:3: 'partition'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getPartitionKeyword_30()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getPartitionKeyword_30()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_PREDICATE_SYMBOLS__Alternatives"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives"
    // InternalXUmlb.g:1423:1: rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives : ( ( '\\u2194' ) | ( '\\uE100' ) | ( '\\uE101' ) | ( '\\uE102' ) | ( '\\u21F8' ) | ( '\\u2192' ) | ( '\\u2914' ) | ( '\\u21A3' ) | ( '\\u2900' ) | ( '\\u21A0' ) | ( '\\u2916' ) | ( '{' ) | ( '}' ) | ( '\\u21A6' ) | ( '\\u2205' ) | ( '\\u2229' ) | ( '\\u222A' ) | ( '\\u2216' ) | ( '\\u00D7' ) | ( '[' ) | ( ']' ) | ( '\\uE103' ) | ( '\\u2218' ) | ( ';' ) | ( '\\u2297' ) | ( '\\u2225' ) | ( '\\u223C' ) | ( '\\u25C1' ) | ( '\\u2A64' ) | ( '\\u25B7' ) | ( '\\u2A65' ) | ( '\\u03BB' ) | ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 ) ) | ( '\\u22C3' ) | ( '\\u2223' ) | ( '\\u2025' ) | ( '+' ) | ( '\\u2212' ) | ( '-' ) | ( '\\u2217' ) | ( '*' ) | ( '\\u00F7' ) | ( '/' ) | ( '^' ) | ( '\\\\' ) );
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1427:1: ( ( '\\u2194' ) | ( '\\uE100' ) | ( '\\uE101' ) | ( '\\uE102' ) | ( '\\u21F8' ) | ( '\\u2192' ) | ( '\\u2914' ) | ( '\\u21A3' ) | ( '\\u2900' ) | ( '\\u21A0' ) | ( '\\u2916' ) | ( '{' ) | ( '}' ) | ( '\\u21A6' ) | ( '\\u2205' ) | ( '\\u2229' ) | ( '\\u222A' ) | ( '\\u2216' ) | ( '\\u00D7' ) | ( '[' ) | ( ']' ) | ( '\\uE103' ) | ( '\\u2218' ) | ( ';' ) | ( '\\u2297' ) | ( '\\u2225' ) | ( '\\u223C' ) | ( '\\u25C1' ) | ( '\\u2A64' ) | ( '\\u25B7' ) | ( '\\u2A65' ) | ( '\\u03BB' ) | ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 ) ) | ( '\\u22C3' ) | ( '\\u2223' ) | ( '\\u2025' ) | ( '+' ) | ( '\\u2212' ) | ( '-' ) | ( '\\u2217' ) | ( '*' ) | ( '\\u00F7' ) | ( '/' ) | ( '^' ) | ( '\\\\' ) )
            int alt10=45;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt10=1;
                }
                break;
            case 67:
                {
                alt10=2;
                }
                break;
            case 68:
                {
                alt10=3;
                }
                break;
            case 69:
                {
                alt10=4;
                }
                break;
            case 70:
                {
                alt10=5;
                }
                break;
            case 71:
                {
                alt10=6;
                }
                break;
            case 72:
                {
                alt10=7;
                }
                break;
            case 73:
                {
                alt10=8;
                }
                break;
            case 74:
                {
                alt10=9;
                }
                break;
            case 75:
                {
                alt10=10;
                }
                break;
            case 76:
                {
                alt10=11;
                }
                break;
            case 77:
                {
                alt10=12;
                }
                break;
            case 78:
                {
                alt10=13;
                }
                break;
            case 79:
                {
                alt10=14;
                }
                break;
            case 80:
                {
                alt10=15;
                }
                break;
            case 81:
                {
                alt10=16;
                }
                break;
            case 82:
                {
                alt10=17;
                }
                break;
            case 83:
                {
                alt10=18;
                }
                break;
            case 84:
                {
                alt10=19;
                }
                break;
            case 85:
                {
                alt10=20;
                }
                break;
            case 86:
                {
                alt10=21;
                }
                break;
            case 87:
                {
                alt10=22;
                }
                break;
            case 88:
                {
                alt10=23;
                }
                break;
            case 89:
                {
                alt10=24;
                }
                break;
            case 90:
                {
                alt10=25;
                }
                break;
            case 91:
                {
                alt10=26;
                }
                break;
            case 92:
                {
                alt10=27;
                }
                break;
            case 93:
                {
                alt10=28;
                }
                break;
            case 94:
                {
                alt10=29;
                }
                break;
            case 95:
                {
                alt10=30;
                }
                break;
            case 96:
                {
                alt10=31;
                }
                break;
            case 97:
                {
                alt10=32;
                }
                break;
            case 155:
                {
                alt10=33;
                }
                break;
            case 98:
                {
                alt10=34;
                }
                break;
            case 99:
                {
                alt10=35;
                }
                break;
            case 100:
                {
                alt10=36;
                }
                break;
            case 101:
                {
                alt10=37;
                }
                break;
            case 102:
                {
                alt10=38;
                }
                break;
            case 103:
                {
                alt10=39;
                }
                break;
            case 104:
                {
                alt10=40;
                }
                break;
            case 105:
                {
                alt10=41;
                }
                break;
            case 106:
                {
                alt10=42;
                }
                break;
            case 107:
                {
                alt10=43;
                }
                break;
            case 108:
                {
                alt10=44;
                }
                break;
            case 109:
                {
                alt10=45;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalXUmlb.g:1428:2: ( '\\u2194' )
                    {
                    // InternalXUmlb.g:1428:2: ( '\\u2194' )
                    // InternalXUmlb.g:1429:3: '\\u2194'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftRightArrowKeyword_0()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftRightArrowKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:1434:2: ( '\\uE100' )
                    {
                    // InternalXUmlb.g:1434:2: ( '\\uE100' )
                    // InternalXUmlb.g:1435:3: '\\uE100'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE100Keyword_1()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE100Keyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:1440:2: ( '\\uE101' )
                    {
                    // InternalXUmlb.g:1440:2: ( '\\uE101' )
                    // InternalXUmlb.g:1441:3: '\\uE101'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE101Keyword_2()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE101Keyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXUmlb.g:1446:2: ( '\\uE102' )
                    {
                    // InternalXUmlb.g:1446:2: ( '\\uE102' )
                    // InternalXUmlb.g:1447:3: '\\uE102'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE102Keyword_3()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE102Keyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXUmlb.g:1452:2: ( '\\u21F8' )
                    {
                    // InternalXUmlb.g:1452:2: ( '\\u21F8' )
                    // InternalXUmlb.g:1453:3: '\\u21F8'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithVerticalStrokeKeyword_4()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithVerticalStrokeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXUmlb.g:1458:2: ( '\\u2192' )
                    {
                    // InternalXUmlb.g:1458:2: ( '\\u2192' )
                    // InternalXUmlb.g:1459:3: '\\u2192'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowKeyword_5()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalXUmlb.g:1464:2: ( '\\u2914' )
                    {
                    // InternalXUmlb.g:1464:2: ( '\\u2914' )
                    // InternalXUmlb.g:1465:3: '\\u2914'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_6()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalXUmlb.g:1470:2: ( '\\u21A3' )
                    {
                    // InternalXUmlb.g:1470:2: ( '\\u21A3' )
                    // InternalXUmlb.g:1471:3: '\\u21A3'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailKeyword_7()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalXUmlb.g:1476:2: ( '\\u2900' )
                    {
                    // InternalXUmlb.g:1476:2: ( '\\u2900' )
                    // InternalXUmlb.g:1477:3: '\\u2900'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_8()); 
                    match(input,74,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalXUmlb.g:1482:2: ( '\\u21A0' )
                    {
                    // InternalXUmlb.g:1482:2: ( '\\u21A0' )
                    // InternalXUmlb.g:1483:3: '\\u21A0'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowKeyword_9()); 
                    match(input,75,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalXUmlb.g:1488:2: ( '\\u2916' )
                    {
                    // InternalXUmlb.g:1488:2: ( '\\u2916' )
                    // InternalXUmlb.g:1489:3: '\\u2916'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithTailKeyword_10()); 
                    match(input,76,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithTailKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalXUmlb.g:1494:2: ( '{' )
                    {
                    // InternalXUmlb.g:1494:2: ( '{' )
                    // InternalXUmlb.g:1495:3: '{'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketKeyword_11()); 
                    match(input,77,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalXUmlb.g:1500:2: ( '}' )
                    {
                    // InternalXUmlb.g:1500:2: ( '}' )
                    // InternalXUmlb.g:1501:3: '}'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightCurlyBracketKeyword_12()); 
                    match(input,78,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightCurlyBracketKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalXUmlb.g:1506:2: ( '\\u21A6' )
                    {
                    // InternalXUmlb.g:1506:2: ( '\\u21A6' )
                    // InternalXUmlb.g:1507:3: '\\u21A6'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowFromBarKeyword_13()); 
                    match(input,79,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowFromBarKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalXUmlb.g:1512:2: ( '\\u2205' )
                    {
                    // InternalXUmlb.g:1512:2: ( '\\u2205' )
                    // InternalXUmlb.g:1513:3: '\\u2205'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getEmptySetKeyword_14()); 
                    match(input,80,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getEmptySetKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalXUmlb.g:1518:2: ( '\\u2229' )
                    {
                    // InternalXUmlb.g:1518:2: ( '\\u2229' )
                    // InternalXUmlb.g:1519:3: '\\u2229'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getIntersectionKeyword_15()); 
                    match(input,81,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getIntersectionKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalXUmlb.g:1524:2: ( '\\u222A' )
                    {
                    // InternalXUmlb.g:1524:2: ( '\\u222A' )
                    // InternalXUmlb.g:1525:3: '\\u222A'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUnionKeyword_16()); 
                    match(input,82,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUnionKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalXUmlb.g:1530:2: ( '\\u2216' )
                    {
                    // InternalXUmlb.g:1530:2: ( '\\u2216' )
                    // InternalXUmlb.g:1531:3: '\\u2216'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSetMinusKeyword_17()); 
                    match(input,83,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSetMinusKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalXUmlb.g:1536:2: ( '\\u00D7' )
                    {
                    // InternalXUmlb.g:1536:2: ( '\\u00D7' )
                    // InternalXUmlb.g:1537:3: '\\u00D7'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMultiplicationSignKeyword_18()); 
                    match(input,84,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMultiplicationSignKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalXUmlb.g:1542:2: ( '[' )
                    {
                    // InternalXUmlb.g:1542:2: ( '[' )
                    // InternalXUmlb.g:1543:3: '['
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftSquareBracketKeyword_19()); 
                    match(input,85,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftSquareBracketKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalXUmlb.g:1548:2: ( ']' )
                    {
                    // InternalXUmlb.g:1548:2: ( ']' )
                    // InternalXUmlb.g:1549:3: ']'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightSquareBracketKeyword_20()); 
                    match(input,86,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightSquareBracketKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalXUmlb.g:1554:2: ( '\\uE103' )
                    {
                    // InternalXUmlb.g:1554:2: ( '\\uE103' )
                    // InternalXUmlb.g:1555:3: '\\uE103'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE103Keyword_21()); 
                    match(input,87,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE103Keyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalXUmlb.g:1560:2: ( '\\u2218' )
                    {
                    // InternalXUmlb.g:1560:2: ( '\\u2218' )
                    // InternalXUmlb.g:1561:3: '\\u2218'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRingOperatorKeyword_22()); 
                    match(input,88,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRingOperatorKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalXUmlb.g:1566:2: ( ';' )
                    {
                    // InternalXUmlb.g:1566:2: ( ';' )
                    // InternalXUmlb.g:1567:3: ';'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSemicolonKeyword_23()); 
                    match(input,89,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSemicolonKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalXUmlb.g:1572:2: ( '\\u2297' )
                    {
                    // InternalXUmlb.g:1572:2: ( '\\u2297' )
                    // InternalXUmlb.g:1573:3: '\\u2297'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircledTimesKeyword_24()); 
                    match(input,90,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircledTimesKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalXUmlb.g:1578:2: ( '\\u2225' )
                    {
                    // InternalXUmlb.g:1578:2: ( '\\u2225' )
                    // InternalXUmlb.g:1579:3: '\\u2225'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getParallelToKeyword_25()); 
                    match(input,91,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getParallelToKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalXUmlb.g:1584:2: ( '\\u223C' )
                    {
                    // InternalXUmlb.g:1584:2: ( '\\u223C' )
                    // InternalXUmlb.g:1585:3: '\\u223C'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeOperatorKeyword_26()); 
                    match(input,92,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeOperatorKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalXUmlb.g:1590:2: ( '\\u25C1' )
                    {
                    // InternalXUmlb.g:1590:2: ( '\\u25C1' )
                    // InternalXUmlb.g:1591:3: '\\u25C1'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteLeftPointingTriangleKeyword_27()); 
                    match(input,93,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteLeftPointingTriangleKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalXUmlb.g:1596:2: ( '\\u2A64' )
                    {
                    // InternalXUmlb.g:1596:2: ( '\\u2A64' )
                    // InternalXUmlb.g:1597:3: '\\u2A64'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationDomainAntirestrictionKeyword_28()); 
                    match(input,94,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationDomainAntirestrictionKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalXUmlb.g:1602:2: ( '\\u25B7' )
                    {
                    // InternalXUmlb.g:1602:2: ( '\\u25B7' )
                    // InternalXUmlb.g:1603:3: '\\u25B7'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteRightPointingTriangleKeyword_29()); 
                    match(input,95,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteRightPointingTriangleKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalXUmlb.g:1608:2: ( '\\u2A65' )
                    {
                    // InternalXUmlb.g:1608:2: ( '\\u2A65' )
                    // InternalXUmlb.g:1609:3: '\\u2A65'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationRangeAntirestrictionKeyword_30()); 
                    match(input,96,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationRangeAntirestrictionKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalXUmlb.g:1614:2: ( '\\u03BB' )
                    {
                    // InternalXUmlb.g:1614:2: ( '\\u03BB' )
                    // InternalXUmlb.g:1615:3: '\\u03BB'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreekSmallLetterLamdaKeyword_31()); 
                    match(input,97,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreekSmallLetterLamdaKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalXUmlb.g:1620:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 ) )
                    {
                    // InternalXUmlb.g:1620:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 ) )
                    // InternalXUmlb.g:1621:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 )
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGroup_32()); 
                    // InternalXUmlb.g:1622:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 )
                    // InternalXUmlb.g:1622:4: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGroup_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalXUmlb.g:1626:2: ( '\\u22C3' )
                    {
                    // InternalXUmlb.g:1626:2: ( '\\u22C3' )
                    // InternalXUmlb.g:1627:3: '\\u22C3'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryUnionKeyword_33()); 
                    match(input,98,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryUnionKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalXUmlb.g:1632:2: ( '\\u2223' )
                    {
                    // InternalXUmlb.g:1632:2: ( '\\u2223' )
                    // InternalXUmlb.g:1633:3: '\\u2223'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDividesKeyword_34()); 
                    match(input,99,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDividesKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalXUmlb.g:1638:2: ( '\\u2025' )
                    {
                    // InternalXUmlb.g:1638:2: ( '\\u2025' )
                    // InternalXUmlb.g:1639:3: '\\u2025'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTwoDotLeaderKeyword_35()); 
                    match(input,100,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTwoDotLeaderKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalXUmlb.g:1644:2: ( '+' )
                    {
                    // InternalXUmlb.g:1644:2: ( '+' )
                    // InternalXUmlb.g:1645:3: '+'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignKeyword_36()); 
                    match(input,101,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalXUmlb.g:1650:2: ( '\\u2212' )
                    {
                    // InternalXUmlb.g:1650:2: ( '\\u2212' )
                    // InternalXUmlb.g:1651:3: '\\u2212'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMinusSignKeyword_37()); 
                    match(input,102,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMinusSignKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalXUmlb.g:1656:2: ( '-' )
                    {
                    // InternalXUmlb.g:1656:2: ( '-' )
                    // InternalXUmlb.g:1657:3: '-'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusKeyword_38()); 
                    match(input,103,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalXUmlb.g:1662:2: ( '\\u2217' )
                    {
                    // InternalXUmlb.g:1662:2: ( '\\u2217' )
                    // InternalXUmlb.g:1663:3: '\\u2217'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskOperatorKeyword_39()); 
                    match(input,104,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskOperatorKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalXUmlb.g:1668:2: ( '*' )
                    {
                    // InternalXUmlb.g:1668:2: ( '*' )
                    // InternalXUmlb.g:1669:3: '*'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskKeyword_40()); 
                    match(input,105,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalXUmlb.g:1674:2: ( '\\u00F7' )
                    {
                    // InternalXUmlb.g:1674:2: ( '\\u00F7' )
                    // InternalXUmlb.g:1675:3: '\\u00F7'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDivisionSignKeyword_41()); 
                    match(input,106,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDivisionSignKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalXUmlb.g:1680:2: ( '/' )
                    {
                    // InternalXUmlb.g:1680:2: ( '/' )
                    // InternalXUmlb.g:1681:3: '/'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusKeyword_42()); 
                    match(input,107,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalXUmlb.g:1686:2: ( '^' )
                    {
                    // InternalXUmlb.g:1686:2: ( '^' )
                    // InternalXUmlb.g:1687:3: '^'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircumflexAccentKeyword_43()); 
                    match(input,108,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircumflexAccentKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalXUmlb.g:1692:2: ( '\\\\' )
                    {
                    // InternalXUmlb.g:1692:2: ( '\\\\' )
                    // InternalXUmlb.g:1693:3: '\\\\'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getBackslashKeyword_44()); 
                    match(input,109,FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getBackslashKeyword_44()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives"


    // $ANTLR start "rule__TranslationKind__Alternatives"
    // InternalXUmlb.g:1702:1: rule__TranslationKind__Alternatives : ( ( ( 'variables' ) ) | ( ( 'enumeration' ) ) | ( ( 'REFINEDVAR' ) ) );
    public final void rule__TranslationKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1706:1: ( ( ( 'variables' ) ) | ( ( 'enumeration' ) ) | ( ( 'REFINEDVAR' ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 110:
                {
                alt11=1;
                }
                break;
            case 111:
                {
                alt11=2;
                }
                break;
            case 112:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalXUmlb.g:1707:2: ( ( 'variables' ) )
                    {
                    // InternalXUmlb.g:1707:2: ( ( 'variables' ) )
                    // InternalXUmlb.g:1708:3: ( 'variables' )
                    {
                     before(grammarAccess.getTranslationKindAccess().getMULTIVAREnumLiteralDeclaration_0()); 
                    // InternalXUmlb.g:1709:3: ( 'variables' )
                    // InternalXUmlb.g:1709:4: 'variables'
                    {
                    match(input,110,FOLLOW_2); 

                    }

                     after(grammarAccess.getTranslationKindAccess().getMULTIVAREnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:1713:2: ( ( 'enumeration' ) )
                    {
                    // InternalXUmlb.g:1713:2: ( ( 'enumeration' ) )
                    // InternalXUmlb.g:1714:3: ( 'enumeration' )
                    {
                     before(grammarAccess.getTranslationKindAccess().getSINGLEVAREnumLiteralDeclaration_1()); 
                    // InternalXUmlb.g:1715:3: ( 'enumeration' )
                    // InternalXUmlb.g:1715:4: 'enumeration'
                    {
                    match(input,111,FOLLOW_2); 

                    }

                     after(grammarAccess.getTranslationKindAccess().getSINGLEVAREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:1719:2: ( ( 'REFINEDVAR' ) )
                    {
                    // InternalXUmlb.g:1719:2: ( ( 'REFINEDVAR' ) )
                    // InternalXUmlb.g:1720:3: ( 'REFINEDVAR' )
                    {
                     before(grammarAccess.getTranslationKindAccess().getREFINEDVAREnumLiteralDeclaration_2()); 
                    // InternalXUmlb.g:1721:3: ( 'REFINEDVAR' )
                    // InternalXUmlb.g:1721:4: 'REFINEDVAR'
                    {
                    match(input,112,FOLLOW_2); 

                    }

                     after(grammarAccess.getTranslationKindAccess().getREFINEDVAREnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TranslationKind__Alternatives"


    // $ANTLR start "rule__MethodKind__Alternatives"
    // InternalXUmlb.g:1729:1: rule__MethodKind__Alternatives : ( ( ( 'normal' ) ) | ( ( 'constructor' ) ) | ( ( 'destructor' ) ) );
    public final void rule__MethodKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1733:1: ( ( ( 'normal' ) ) | ( ( 'constructor' ) ) | ( ( 'destructor' ) ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 113:
                {
                alt12=1;
                }
                break;
            case 114:
                {
                alt12=2;
                }
                break;
            case 115:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalXUmlb.g:1734:2: ( ( 'normal' ) )
                    {
                    // InternalXUmlb.g:1734:2: ( ( 'normal' ) )
                    // InternalXUmlb.g:1735:3: ( 'normal' )
                    {
                     before(grammarAccess.getMethodKindAccess().getNormalEnumLiteralDeclaration_0()); 
                    // InternalXUmlb.g:1736:3: ( 'normal' )
                    // InternalXUmlb.g:1736:4: 'normal'
                    {
                    match(input,113,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodKindAccess().getNormalEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:1740:2: ( ( 'constructor' ) )
                    {
                    // InternalXUmlb.g:1740:2: ( ( 'constructor' ) )
                    // InternalXUmlb.g:1741:3: ( 'constructor' )
                    {
                     before(grammarAccess.getMethodKindAccess().getConstructorEnumLiteralDeclaration_1()); 
                    // InternalXUmlb.g:1742:3: ( 'constructor' )
                    // InternalXUmlb.g:1742:4: 'constructor'
                    {
                    match(input,114,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodKindAccess().getConstructorEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:1746:2: ( ( 'destructor' ) )
                    {
                    // InternalXUmlb.g:1746:2: ( ( 'destructor' ) )
                    // InternalXUmlb.g:1747:3: ( 'destructor' )
                    {
                     before(grammarAccess.getMethodKindAccess().getDestructorEnumLiteralDeclaration_2()); 
                    // InternalXUmlb.g:1748:3: ( 'destructor' )
                    // InternalXUmlb.g:1748:4: 'destructor'
                    {
                    match(input,115,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodKindAccess().getDestructorEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodKind__Alternatives"


    // $ANTLR start "rule__DataKind__Alternatives"
    // InternalXUmlb.g:1756:1: rule__DataKind__Alternatives : ( ( ( 'set' ) ) | ( ( 'constant' ) ) | ( ( 'variable' ) ) );
    public final void rule__DataKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1760:1: ( ( ( 'set' ) ) | ( ( 'constant' ) ) | ( ( 'variable' ) ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 116:
                {
                alt13=1;
                }
                break;
            case 117:
                {
                alt13=2;
                }
                break;
            case 118:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalXUmlb.g:1761:2: ( ( 'set' ) )
                    {
                    // InternalXUmlb.g:1761:2: ( ( 'set' ) )
                    // InternalXUmlb.g:1762:3: ( 'set' )
                    {
                     before(grammarAccess.getDataKindAccess().getSETEnumLiteralDeclaration_0()); 
                    // InternalXUmlb.g:1763:3: ( 'set' )
                    // InternalXUmlb.g:1763:4: 'set'
                    {
                    match(input,116,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataKindAccess().getSETEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXUmlb.g:1767:2: ( ( 'constant' ) )
                    {
                    // InternalXUmlb.g:1767:2: ( ( 'constant' ) )
                    // InternalXUmlb.g:1768:3: ( 'constant' )
                    {
                     before(grammarAccess.getDataKindAccess().getCONSTANTEnumLiteralDeclaration_1()); 
                    // InternalXUmlb.g:1769:3: ( 'constant' )
                    // InternalXUmlb.g:1769:4: 'constant'
                    {
                    match(input,117,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataKindAccess().getCONSTANTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXUmlb.g:1773:2: ( ( 'variable' ) )
                    {
                    // InternalXUmlb.g:1773:2: ( ( 'variable' ) )
                    // InternalXUmlb.g:1774:3: ( 'variable' )
                    {
                     before(grammarAccess.getDataKindAccess().getVARIABLEEnumLiteralDeclaration_2()); 
                    // InternalXUmlb.g:1775:3: ( 'variable' )
                    // InternalXUmlb.g:1775:4: 'variable'
                    {
                    match(input,118,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataKindAccess().getVARIABLEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataKind__Alternatives"


    // $ANTLR start "rule__XUMLB__Group__0"
    // InternalXUmlb.g:1783:1: rule__XUMLB__Group__0 : rule__XUMLB__Group__0__Impl rule__XUMLB__Group__1 ;
    public final void rule__XUMLB__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1787:1: ( rule__XUMLB__Group__0__Impl rule__XUMLB__Group__1 )
            // InternalXUmlb.g:1788:2: rule__XUMLB__Group__0__Impl rule__XUMLB__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__XUMLB__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUMLB__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group__0"


    // $ANTLR start "rule__XUMLB__Group__0__Impl"
    // InternalXUmlb.g:1795:1: rule__XUMLB__Group__0__Impl : ( 'UMLB' ) ;
    public final void rule__XUMLB__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1799:1: ( ( 'UMLB' ) )
            // InternalXUmlb.g:1800:1: ( 'UMLB' )
            {
            // InternalXUmlb.g:1800:1: ( 'UMLB' )
            // InternalXUmlb.g:1801:2: 'UMLB'
            {
             before(grammarAccess.getXUMLBAccess().getUMLBKeyword_0()); 
            match(input,119,FOLLOW_2); 
             after(grammarAccess.getXUMLBAccess().getUMLBKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group__0__Impl"


    // $ANTLR start "rule__XUMLB__Group__1"
    // InternalXUmlb.g:1810:1: rule__XUMLB__Group__1 : rule__XUMLB__Group__1__Impl rule__XUMLB__Group__2 ;
    public final void rule__XUMLB__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1814:1: ( rule__XUMLB__Group__1__Impl rule__XUMLB__Group__2 )
            // InternalXUmlb.g:1815:2: rule__XUMLB__Group__1__Impl rule__XUMLB__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__XUMLB__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUMLB__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group__1"


    // $ANTLR start "rule__XUMLB__Group__1__Impl"
    // InternalXUmlb.g:1822:1: rule__XUMLB__Group__1__Impl : ( ( rule__XUMLB__NameAssignment_1 ) ) ;
    public final void rule__XUMLB__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1826:1: ( ( ( rule__XUMLB__NameAssignment_1 ) ) )
            // InternalXUmlb.g:1827:1: ( ( rule__XUMLB__NameAssignment_1 ) )
            {
            // InternalXUmlb.g:1827:1: ( ( rule__XUMLB__NameAssignment_1 ) )
            // InternalXUmlb.g:1828:2: ( rule__XUMLB__NameAssignment_1 )
            {
             before(grammarAccess.getXUMLBAccess().getNameAssignment_1()); 
            // InternalXUmlb.g:1829:2: ( rule__XUMLB__NameAssignment_1 )
            // InternalXUmlb.g:1829:3: rule__XUMLB__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__XUMLB__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getXUMLBAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group__1__Impl"


    // $ANTLR start "rule__XUMLB__Group__2"
    // InternalXUmlb.g:1837:1: rule__XUMLB__Group__2 : rule__XUMLB__Group__2__Impl rule__XUMLB__Group__3 ;
    public final void rule__XUMLB__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1841:1: ( rule__XUMLB__Group__2__Impl rule__XUMLB__Group__3 )
            // InternalXUmlb.g:1842:2: rule__XUMLB__Group__2__Impl rule__XUMLB__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__XUMLB__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUMLB__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group__2"


    // $ANTLR start "rule__XUMLB__Group__2__Impl"
    // InternalXUmlb.g:1849:1: rule__XUMLB__Group__2__Impl : ( ( rule__XUMLB__Group_2__0 )? ) ;
    public final void rule__XUMLB__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1853:1: ( ( ( rule__XUMLB__Group_2__0 )? ) )
            // InternalXUmlb.g:1854:1: ( ( rule__XUMLB__Group_2__0 )? )
            {
            // InternalXUmlb.g:1854:1: ( ( rule__XUMLB__Group_2__0 )? )
            // InternalXUmlb.g:1855:2: ( rule__XUMLB__Group_2__0 )?
            {
             before(grammarAccess.getXUMLBAccess().getGroup_2()); 
            // InternalXUmlb.g:1856:2: ( rule__XUMLB__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==120) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalXUmlb.g:1856:3: rule__XUMLB__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XUMLB__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXUMLBAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group__2__Impl"


    // $ANTLR start "rule__XUMLB__Group__3"
    // InternalXUmlb.g:1864:1: rule__XUMLB__Group__3 : rule__XUMLB__Group__3__Impl rule__XUMLB__Group__4 ;
    public final void rule__XUMLB__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1868:1: ( rule__XUMLB__Group__3__Impl rule__XUMLB__Group__4 )
            // InternalXUmlb.g:1869:2: rule__XUMLB__Group__3__Impl rule__XUMLB__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__XUMLB__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUMLB__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group__3"


    // $ANTLR start "rule__XUMLB__Group__3__Impl"
    // InternalXUmlb.g:1876:1: rule__XUMLB__Group__3__Impl : ( ( rule__XUMLB__Group_3__0 )? ) ;
    public final void rule__XUMLB__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1880:1: ( ( ( rule__XUMLB__Group_3__0 )? ) )
            // InternalXUmlb.g:1881:1: ( ( rule__XUMLB__Group_3__0 )? )
            {
            // InternalXUmlb.g:1881:1: ( ( rule__XUMLB__Group_3__0 )? )
            // InternalXUmlb.g:1882:2: ( rule__XUMLB__Group_3__0 )?
            {
             before(grammarAccess.getXUMLBAccess().getGroup_3()); 
            // InternalXUmlb.g:1883:2: ( rule__XUMLB__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==121) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalXUmlb.g:1883:3: rule__XUMLB__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XUMLB__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXUMLBAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group__3__Impl"


    // $ANTLR start "rule__XUMLB__Group__4"
    // InternalXUmlb.g:1891:1: rule__XUMLB__Group__4 : rule__XUMLB__Group__4__Impl ;
    public final void rule__XUMLB__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1895:1: ( rule__XUMLB__Group__4__Impl )
            // InternalXUmlb.g:1896:2: rule__XUMLB__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XUMLB__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group__4"


    // $ANTLR start "rule__XUMLB__Group__4__Impl"
    // InternalXUmlb.g:1902:1: rule__XUMLB__Group__4__Impl : ( ( rule__XUMLB__DiagramsAssignment_4 )* ) ;
    public final void rule__XUMLB__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1906:1: ( ( ( rule__XUMLB__DiagramsAssignment_4 )* ) )
            // InternalXUmlb.g:1907:1: ( ( rule__XUMLB__DiagramsAssignment_4 )* )
            {
            // InternalXUmlb.g:1907:1: ( ( rule__XUMLB__DiagramsAssignment_4 )* )
            // InternalXUmlb.g:1908:2: ( rule__XUMLB__DiagramsAssignment_4 )*
            {
             before(grammarAccess.getXUMLBAccess().getDiagramsAssignment_4()); 
            // InternalXUmlb.g:1909:2: ( rule__XUMLB__DiagramsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==122||LA16_0==143) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalXUmlb.g:1909:3: rule__XUMLB__DiagramsAssignment_4
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__XUMLB__DiagramsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getXUMLBAccess().getDiagramsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group__4__Impl"


    // $ANTLR start "rule__XUMLB__Group_2__0"
    // InternalXUmlb.g:1918:1: rule__XUMLB__Group_2__0 : rule__XUMLB__Group_2__0__Impl rule__XUMLB__Group_2__1 ;
    public final void rule__XUMLB__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1922:1: ( rule__XUMLB__Group_2__0__Impl rule__XUMLB__Group_2__1 )
            // InternalXUmlb.g:1923:2: rule__XUMLB__Group_2__0__Impl rule__XUMLB__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__XUMLB__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUMLB__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group_2__0"


    // $ANTLR start "rule__XUMLB__Group_2__0__Impl"
    // InternalXUmlb.g:1930:1: rule__XUMLB__Group_2__0__Impl : ( 'elaborates' ) ;
    public final void rule__XUMLB__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1934:1: ( ( 'elaborates' ) )
            // InternalXUmlb.g:1935:1: ( 'elaborates' )
            {
            // InternalXUmlb.g:1935:1: ( 'elaborates' )
            // InternalXUmlb.g:1936:2: 'elaborates'
            {
             before(grammarAccess.getXUMLBAccess().getElaboratesKeyword_2_0()); 
            match(input,120,FOLLOW_2); 
             after(grammarAccess.getXUMLBAccess().getElaboratesKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group_2__0__Impl"


    // $ANTLR start "rule__XUMLB__Group_2__1"
    // InternalXUmlb.g:1945:1: rule__XUMLB__Group_2__1 : rule__XUMLB__Group_2__1__Impl ;
    public final void rule__XUMLB__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1949:1: ( rule__XUMLB__Group_2__1__Impl )
            // InternalXUmlb.g:1950:2: rule__XUMLB__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XUMLB__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group_2__1"


    // $ANTLR start "rule__XUMLB__Group_2__1__Impl"
    // InternalXUmlb.g:1956:1: rule__XUMLB__Group_2__1__Impl : ( ( rule__XUMLB__ElaboratesAssignment_2_1 ) ) ;
    public final void rule__XUMLB__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1960:1: ( ( ( rule__XUMLB__ElaboratesAssignment_2_1 ) ) )
            // InternalXUmlb.g:1961:1: ( ( rule__XUMLB__ElaboratesAssignment_2_1 ) )
            {
            // InternalXUmlb.g:1961:1: ( ( rule__XUMLB__ElaboratesAssignment_2_1 ) )
            // InternalXUmlb.g:1962:2: ( rule__XUMLB__ElaboratesAssignment_2_1 )
            {
             before(grammarAccess.getXUMLBAccess().getElaboratesAssignment_2_1()); 
            // InternalXUmlb.g:1963:2: ( rule__XUMLB__ElaboratesAssignment_2_1 )
            // InternalXUmlb.g:1963:3: rule__XUMLB__ElaboratesAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__XUMLB__ElaboratesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getXUMLBAccess().getElaboratesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group_2__1__Impl"


    // $ANTLR start "rule__XUMLB__Group_3__0"
    // InternalXUmlb.g:1972:1: rule__XUMLB__Group_3__0 : rule__XUMLB__Group_3__0__Impl rule__XUMLB__Group_3__1 ;
    public final void rule__XUMLB__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1976:1: ( rule__XUMLB__Group_3__0__Impl rule__XUMLB__Group_3__1 )
            // InternalXUmlb.g:1977:2: rule__XUMLB__Group_3__0__Impl rule__XUMLB__Group_3__1
            {
            pushFollow(FOLLOW_4);
            rule__XUMLB__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUMLB__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group_3__0"


    // $ANTLR start "rule__XUMLB__Group_3__0__Impl"
    // InternalXUmlb.g:1984:1: rule__XUMLB__Group_3__0__Impl : ( 'refines' ) ;
    public final void rule__XUMLB__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:1988:1: ( ( 'refines' ) )
            // InternalXUmlb.g:1989:1: ( 'refines' )
            {
            // InternalXUmlb.g:1989:1: ( 'refines' )
            // InternalXUmlb.g:1990:2: 'refines'
            {
             before(grammarAccess.getXUMLBAccess().getRefinesKeyword_3_0()); 
            match(input,121,FOLLOW_2); 
             after(grammarAccess.getXUMLBAccess().getRefinesKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group_3__0__Impl"


    // $ANTLR start "rule__XUMLB__Group_3__1"
    // InternalXUmlb.g:1999:1: rule__XUMLB__Group_3__1 : rule__XUMLB__Group_3__1__Impl ;
    public final void rule__XUMLB__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2003:1: ( rule__XUMLB__Group_3__1__Impl )
            // InternalXUmlb.g:2004:2: rule__XUMLB__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XUMLB__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group_3__1"


    // $ANTLR start "rule__XUMLB__Group_3__1__Impl"
    // InternalXUmlb.g:2010:1: rule__XUMLB__Group_3__1__Impl : ( ( rule__XUMLB__RefinesAssignment_3_1 ) ) ;
    public final void rule__XUMLB__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2014:1: ( ( ( rule__XUMLB__RefinesAssignment_3_1 ) ) )
            // InternalXUmlb.g:2015:1: ( ( rule__XUMLB__RefinesAssignment_3_1 ) )
            {
            // InternalXUmlb.g:2015:1: ( ( rule__XUMLB__RefinesAssignment_3_1 ) )
            // InternalXUmlb.g:2016:2: ( rule__XUMLB__RefinesAssignment_3_1 )
            {
             before(grammarAccess.getXUMLBAccess().getRefinesAssignment_3_1()); 
            // InternalXUmlb.g:2017:2: ( rule__XUMLB__RefinesAssignment_3_1 )
            // InternalXUmlb.g:2017:3: rule__XUMLB__RefinesAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__XUMLB__RefinesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getXUMLBAccess().getRefinesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__Group_3__1__Impl"


    // $ANTLR start "rule__Statemachine__Group__0"
    // InternalXUmlb.g:2026:1: rule__Statemachine__Group__0 : rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1 ;
    public final void rule__Statemachine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2030:1: ( rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1 )
            // InternalXUmlb.g:2031:2: rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Statemachine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__0"


    // $ANTLR start "rule__Statemachine__Group__0__Impl"
    // InternalXUmlb.g:2038:1: rule__Statemachine__Group__0__Impl : ( () ) ;
    public final void rule__Statemachine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2042:1: ( ( () ) )
            // InternalXUmlb.g:2043:1: ( () )
            {
            // InternalXUmlb.g:2043:1: ( () )
            // InternalXUmlb.g:2044:2: ()
            {
             before(grammarAccess.getStatemachineAccess().getStatemachineAction_0()); 
            // InternalXUmlb.g:2045:2: ()
            // InternalXUmlb.g:2045:3: 
            {
            }

             after(grammarAccess.getStatemachineAccess().getStatemachineAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__0__Impl"


    // $ANTLR start "rule__Statemachine__Group__1"
    // InternalXUmlb.g:2053:1: rule__Statemachine__Group__1 : rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2 ;
    public final void rule__Statemachine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2057:1: ( rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2 )
            // InternalXUmlb.g:2058:2: rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Statemachine__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__1"


    // $ANTLR start "rule__Statemachine__Group__1__Impl"
    // InternalXUmlb.g:2065:1: rule__Statemachine__Group__1__Impl : ( 'statemachine' ) ;
    public final void rule__Statemachine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2069:1: ( ( 'statemachine' ) )
            // InternalXUmlb.g:2070:1: ( 'statemachine' )
            {
            // InternalXUmlb.g:2070:1: ( 'statemachine' )
            // InternalXUmlb.g:2071:2: 'statemachine'
            {
             before(grammarAccess.getStatemachineAccess().getStatemachineKeyword_1()); 
            match(input,122,FOLLOW_2); 
             after(grammarAccess.getStatemachineAccess().getStatemachineKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__1__Impl"


    // $ANTLR start "rule__Statemachine__Group__2"
    // InternalXUmlb.g:2080:1: rule__Statemachine__Group__2 : rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3 ;
    public final void rule__Statemachine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2084:1: ( rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3 )
            // InternalXUmlb.g:2085:2: rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Statemachine__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__2"


    // $ANTLR start "rule__Statemachine__Group__2__Impl"
    // InternalXUmlb.g:2092:1: rule__Statemachine__Group__2__Impl : ( ( rule__Statemachine__NameAssignment_2 ) ) ;
    public final void rule__Statemachine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2096:1: ( ( ( rule__Statemachine__NameAssignment_2 ) ) )
            // InternalXUmlb.g:2097:1: ( ( rule__Statemachine__NameAssignment_2 ) )
            {
            // InternalXUmlb.g:2097:1: ( ( rule__Statemachine__NameAssignment_2 ) )
            // InternalXUmlb.g:2098:2: ( rule__Statemachine__NameAssignment_2 )
            {
             before(grammarAccess.getStatemachineAccess().getNameAssignment_2()); 
            // InternalXUmlb.g:2099:2: ( rule__Statemachine__NameAssignment_2 )
            // InternalXUmlb.g:2099:3: rule__Statemachine__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Statemachine__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__2__Impl"


    // $ANTLR start "rule__Statemachine__Group__3"
    // InternalXUmlb.g:2107:1: rule__Statemachine__Group__3 : rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4 ;
    public final void rule__Statemachine__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2111:1: ( rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4 )
            // InternalXUmlb.g:2112:2: rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Statemachine__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__3"


    // $ANTLR start "rule__Statemachine__Group__3__Impl"
    // InternalXUmlb.g:2119:1: rule__Statemachine__Group__3__Impl : ( '(' ) ;
    public final void rule__Statemachine__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2123:1: ( ( '(' ) )
            // InternalXUmlb.g:2124:1: ( '(' )
            {
            // InternalXUmlb.g:2124:1: ( '(' )
            // InternalXUmlb.g:2125:2: '('
            {
             before(grammarAccess.getStatemachineAccess().getLeftParenthesisKeyword_3()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getStatemachineAccess().getLeftParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__3__Impl"


    // $ANTLR start "rule__Statemachine__Group__4"
    // InternalXUmlb.g:2134:1: rule__Statemachine__Group__4 : rule__Statemachine__Group__4__Impl rule__Statemachine__Group__5 ;
    public final void rule__Statemachine__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2138:1: ( rule__Statemachine__Group__4__Impl rule__Statemachine__Group__5 )
            // InternalXUmlb.g:2139:2: rule__Statemachine__Group__4__Impl rule__Statemachine__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__Statemachine__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__4"


    // $ANTLR start "rule__Statemachine__Group__4__Impl"
    // InternalXUmlb.g:2146:1: rule__Statemachine__Group__4__Impl : ( ( rule__Statemachine__TranslationAssignment_4 ) ) ;
    public final void rule__Statemachine__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2150:1: ( ( ( rule__Statemachine__TranslationAssignment_4 ) ) )
            // InternalXUmlb.g:2151:1: ( ( rule__Statemachine__TranslationAssignment_4 ) )
            {
            // InternalXUmlb.g:2151:1: ( ( rule__Statemachine__TranslationAssignment_4 ) )
            // InternalXUmlb.g:2152:2: ( rule__Statemachine__TranslationAssignment_4 )
            {
             before(grammarAccess.getStatemachineAccess().getTranslationAssignment_4()); 
            // InternalXUmlb.g:2153:2: ( rule__Statemachine__TranslationAssignment_4 )
            // InternalXUmlb.g:2153:3: rule__Statemachine__TranslationAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Statemachine__TranslationAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getTranslationAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__4__Impl"


    // $ANTLR start "rule__Statemachine__Group__5"
    // InternalXUmlb.g:2161:1: rule__Statemachine__Group__5 : rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6 ;
    public final void rule__Statemachine__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2165:1: ( rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6 )
            // InternalXUmlb.g:2166:2: rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__Statemachine__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__5"


    // $ANTLR start "rule__Statemachine__Group__5__Impl"
    // InternalXUmlb.g:2173:1: rule__Statemachine__Group__5__Impl : ( ')' ) ;
    public final void rule__Statemachine__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2177:1: ( ( ')' ) )
            // InternalXUmlb.g:2178:1: ( ')' )
            {
            // InternalXUmlb.g:2178:1: ( ')' )
            // InternalXUmlb.g:2179:2: ')'
            {
             before(grammarAccess.getStatemachineAccess().getRightParenthesisKeyword_5()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getStatemachineAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__5__Impl"


    // $ANTLR start "rule__Statemachine__Group__6"
    // InternalXUmlb.g:2188:1: rule__Statemachine__Group__6 : rule__Statemachine__Group__6__Impl rule__Statemachine__Group__7 ;
    public final void rule__Statemachine__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2192:1: ( rule__Statemachine__Group__6__Impl rule__Statemachine__Group__7 )
            // InternalXUmlb.g:2193:2: rule__Statemachine__Group__6__Impl rule__Statemachine__Group__7
            {
            pushFollow(FOLLOW_11);
            rule__Statemachine__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__6"


    // $ANTLR start "rule__Statemachine__Group__6__Impl"
    // InternalXUmlb.g:2200:1: rule__Statemachine__Group__6__Impl : ( ( rule__Statemachine__Group_6__0 )? ) ;
    public final void rule__Statemachine__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2204:1: ( ( ( rule__Statemachine__Group_6__0 )? ) )
            // InternalXUmlb.g:2205:1: ( ( rule__Statemachine__Group_6__0 )? )
            {
            // InternalXUmlb.g:2205:1: ( ( rule__Statemachine__Group_6__0 )? )
            // InternalXUmlb.g:2206:2: ( rule__Statemachine__Group_6__0 )?
            {
             before(grammarAccess.getStatemachineAccess().getGroup_6()); 
            // InternalXUmlb.g:2207:2: ( rule__Statemachine__Group_6__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==121) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalXUmlb.g:2207:3: rule__Statemachine__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Statemachine__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStatemachineAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__6__Impl"


    // $ANTLR start "rule__Statemachine__Group__7"
    // InternalXUmlb.g:2215:1: rule__Statemachine__Group__7 : rule__Statemachine__Group__7__Impl rule__Statemachine__Group__8 ;
    public final void rule__Statemachine__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2219:1: ( rule__Statemachine__Group__7__Impl rule__Statemachine__Group__8 )
            // InternalXUmlb.g:2220:2: rule__Statemachine__Group__7__Impl rule__Statemachine__Group__8
            {
            pushFollow(FOLLOW_11);
            rule__Statemachine__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__7"


    // $ANTLR start "rule__Statemachine__Group__7__Impl"
    // InternalXUmlb.g:2227:1: rule__Statemachine__Group__7__Impl : ( ( rule__Statemachine__Group_7__0 )? ) ;
    public final void rule__Statemachine__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2231:1: ( ( ( rule__Statemachine__Group_7__0 )? ) )
            // InternalXUmlb.g:2232:1: ( ( rule__Statemachine__Group_7__0 )? )
            {
            // InternalXUmlb.g:2232:1: ( ( rule__Statemachine__Group_7__0 )? )
            // InternalXUmlb.g:2233:2: ( rule__Statemachine__Group_7__0 )?
            {
             before(grammarAccess.getStatemachineAccess().getGroup_7()); 
            // InternalXUmlb.g:2234:2: ( rule__Statemachine__Group_7__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==124) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalXUmlb.g:2234:3: rule__Statemachine__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Statemachine__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStatemachineAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__7__Impl"


    // $ANTLR start "rule__Statemachine__Group__8"
    // InternalXUmlb.g:2242:1: rule__Statemachine__Group__8 : rule__Statemachine__Group__8__Impl rule__Statemachine__Group__9 ;
    public final void rule__Statemachine__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2246:1: ( rule__Statemachine__Group__8__Impl rule__Statemachine__Group__9 )
            // InternalXUmlb.g:2247:2: rule__Statemachine__Group__8__Impl rule__Statemachine__Group__9
            {
            pushFollow(FOLLOW_11);
            rule__Statemachine__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__8"


    // $ANTLR start "rule__Statemachine__Group__8__Impl"
    // InternalXUmlb.g:2254:1: rule__Statemachine__Group__8__Impl : ( ( rule__Statemachine__NodesAssignment_8 )* ) ;
    public final void rule__Statemachine__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2258:1: ( ( ( rule__Statemachine__NodesAssignment_8 )* ) )
            // InternalXUmlb.g:2259:1: ( ( rule__Statemachine__NodesAssignment_8 )* )
            {
            // InternalXUmlb.g:2259:1: ( ( rule__Statemachine__NodesAssignment_8 )* )
            // InternalXUmlb.g:2260:2: ( rule__Statemachine__NodesAssignment_8 )*
            {
             before(grammarAccess.getStatemachineAccess().getNodesAssignment_8()); 
            // InternalXUmlb.g:2261:2: ( rule__Statemachine__NodesAssignment_8 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==129||LA19_0==133||(LA19_0>=139 && LA19_0<=142)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalXUmlb.g:2261:3: rule__Statemachine__NodesAssignment_8
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Statemachine__NodesAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getNodesAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__8__Impl"


    // $ANTLR start "rule__Statemachine__Group__9"
    // InternalXUmlb.g:2269:1: rule__Statemachine__Group__9 : rule__Statemachine__Group__9__Impl rule__Statemachine__Group__10 ;
    public final void rule__Statemachine__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2273:1: ( rule__Statemachine__Group__9__Impl rule__Statemachine__Group__10 )
            // InternalXUmlb.g:2274:2: rule__Statemachine__Group__9__Impl rule__Statemachine__Group__10
            {
            pushFollow(FOLLOW_11);
            rule__Statemachine__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__9"


    // $ANTLR start "rule__Statemachine__Group__9__Impl"
    // InternalXUmlb.g:2281:1: rule__Statemachine__Group__9__Impl : ( ( rule__Statemachine__TransitionsAssignment_9 )* ) ;
    public final void rule__Statemachine__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2285:1: ( ( ( rule__Statemachine__TransitionsAssignment_9 )* ) )
            // InternalXUmlb.g:2286:1: ( ( rule__Statemachine__TransitionsAssignment_9 )* )
            {
            // InternalXUmlb.g:2286:1: ( ( rule__Statemachine__TransitionsAssignment_9 )* )
            // InternalXUmlb.g:2287:2: ( rule__Statemachine__TransitionsAssignment_9 )*
            {
             before(grammarAccess.getStatemachineAccess().getTransitionsAssignment_9()); 
            // InternalXUmlb.g:2288:2: ( rule__Statemachine__TransitionsAssignment_9 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==126) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalXUmlb.g:2288:3: rule__Statemachine__TransitionsAssignment_9
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Statemachine__TransitionsAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getTransitionsAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__9__Impl"


    // $ANTLR start "rule__Statemachine__Group__10"
    // InternalXUmlb.g:2296:1: rule__Statemachine__Group__10 : rule__Statemachine__Group__10__Impl ;
    public final void rule__Statemachine__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2300:1: ( rule__Statemachine__Group__10__Impl )
            // InternalXUmlb.g:2301:2: rule__Statemachine__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Statemachine__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__10"


    // $ANTLR start "rule__Statemachine__Group__10__Impl"
    // InternalXUmlb.g:2307:1: rule__Statemachine__Group__10__Impl : ( 'end' ) ;
    public final void rule__Statemachine__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2311:1: ( ( 'end' ) )
            // InternalXUmlb.g:2312:1: ( 'end' )
            {
            // InternalXUmlb.g:2312:1: ( 'end' )
            // InternalXUmlb.g:2313:2: 'end'
            {
             before(grammarAccess.getStatemachineAccess().getEndKeyword_10()); 
            match(input,123,FOLLOW_2); 
             after(grammarAccess.getStatemachineAccess().getEndKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__10__Impl"


    // $ANTLR start "rule__Statemachine__Group_6__0"
    // InternalXUmlb.g:2323:1: rule__Statemachine__Group_6__0 : rule__Statemachine__Group_6__0__Impl rule__Statemachine__Group_6__1 ;
    public final void rule__Statemachine__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2327:1: ( rule__Statemachine__Group_6__0__Impl rule__Statemachine__Group_6__1 )
            // InternalXUmlb.g:2328:2: rule__Statemachine__Group_6__0__Impl rule__Statemachine__Group_6__1
            {
            pushFollow(FOLLOW_4);
            rule__Statemachine__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_6__0"


    // $ANTLR start "rule__Statemachine__Group_6__0__Impl"
    // InternalXUmlb.g:2335:1: rule__Statemachine__Group_6__0__Impl : ( 'refines' ) ;
    public final void rule__Statemachine__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2339:1: ( ( 'refines' ) )
            // InternalXUmlb.g:2340:1: ( 'refines' )
            {
            // InternalXUmlb.g:2340:1: ( 'refines' )
            // InternalXUmlb.g:2341:2: 'refines'
            {
             before(grammarAccess.getStatemachineAccess().getRefinesKeyword_6_0()); 
            match(input,121,FOLLOW_2); 
             after(grammarAccess.getStatemachineAccess().getRefinesKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_6__0__Impl"


    // $ANTLR start "rule__Statemachine__Group_6__1"
    // InternalXUmlb.g:2350:1: rule__Statemachine__Group_6__1 : rule__Statemachine__Group_6__1__Impl ;
    public final void rule__Statemachine__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2354:1: ( rule__Statemachine__Group_6__1__Impl )
            // InternalXUmlb.g:2355:2: rule__Statemachine__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Statemachine__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_6__1"


    // $ANTLR start "rule__Statemachine__Group_6__1__Impl"
    // InternalXUmlb.g:2361:1: rule__Statemachine__Group_6__1__Impl : ( ( rule__Statemachine__RefinesAssignment_6_1 ) ) ;
    public final void rule__Statemachine__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2365:1: ( ( ( rule__Statemachine__RefinesAssignment_6_1 ) ) )
            // InternalXUmlb.g:2366:1: ( ( rule__Statemachine__RefinesAssignment_6_1 ) )
            {
            // InternalXUmlb.g:2366:1: ( ( rule__Statemachine__RefinesAssignment_6_1 ) )
            // InternalXUmlb.g:2367:2: ( rule__Statemachine__RefinesAssignment_6_1 )
            {
             before(grammarAccess.getStatemachineAccess().getRefinesAssignment_6_1()); 
            // InternalXUmlb.g:2368:2: ( rule__Statemachine__RefinesAssignment_6_1 )
            // InternalXUmlb.g:2368:3: rule__Statemachine__RefinesAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Statemachine__RefinesAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getRefinesAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_6__1__Impl"


    // $ANTLR start "rule__Statemachine__Group_7__0"
    // InternalXUmlb.g:2377:1: rule__Statemachine__Group_7__0 : rule__Statemachine__Group_7__0__Impl rule__Statemachine__Group_7__1 ;
    public final void rule__Statemachine__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2381:1: ( rule__Statemachine__Group_7__0__Impl rule__Statemachine__Group_7__1 )
            // InternalXUmlb.g:2382:2: rule__Statemachine__Group_7__0__Impl rule__Statemachine__Group_7__1
            {
            pushFollow(FOLLOW_4);
            rule__Statemachine__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_7__0"


    // $ANTLR start "rule__Statemachine__Group_7__0__Impl"
    // InternalXUmlb.g:2389:1: rule__Statemachine__Group_7__0__Impl : ( 'instances' ) ;
    public final void rule__Statemachine__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2393:1: ( ( 'instances' ) )
            // InternalXUmlb.g:2394:1: ( 'instances' )
            {
            // InternalXUmlb.g:2394:1: ( 'instances' )
            // InternalXUmlb.g:2395:2: 'instances'
            {
             before(grammarAccess.getStatemachineAccess().getInstancesKeyword_7_0()); 
            match(input,124,FOLLOW_2); 
             after(grammarAccess.getStatemachineAccess().getInstancesKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_7__0__Impl"


    // $ANTLR start "rule__Statemachine__Group_7__1"
    // InternalXUmlb.g:2404:1: rule__Statemachine__Group_7__1 : rule__Statemachine__Group_7__1__Impl rule__Statemachine__Group_7__2 ;
    public final void rule__Statemachine__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2408:1: ( rule__Statemachine__Group_7__1__Impl rule__Statemachine__Group_7__2 )
            // InternalXUmlb.g:2409:2: rule__Statemachine__Group_7__1__Impl rule__Statemachine__Group_7__2
            {
            pushFollow(FOLLOW_14);
            rule__Statemachine__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_7__1"


    // $ANTLR start "rule__Statemachine__Group_7__1__Impl"
    // InternalXUmlb.g:2416:1: rule__Statemachine__Group_7__1__Impl : ( ( rule__Statemachine__InstancesAssignment_7_1 ) ) ;
    public final void rule__Statemachine__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2420:1: ( ( ( rule__Statemachine__InstancesAssignment_7_1 ) ) )
            // InternalXUmlb.g:2421:1: ( ( rule__Statemachine__InstancesAssignment_7_1 ) )
            {
            // InternalXUmlb.g:2421:1: ( ( rule__Statemachine__InstancesAssignment_7_1 ) )
            // InternalXUmlb.g:2422:2: ( rule__Statemachine__InstancesAssignment_7_1 )
            {
             before(grammarAccess.getStatemachineAccess().getInstancesAssignment_7_1()); 
            // InternalXUmlb.g:2423:2: ( rule__Statemachine__InstancesAssignment_7_1 )
            // InternalXUmlb.g:2423:3: rule__Statemachine__InstancesAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Statemachine__InstancesAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getInstancesAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_7__1__Impl"


    // $ANTLR start "rule__Statemachine__Group_7__2"
    // InternalXUmlb.g:2431:1: rule__Statemachine__Group_7__2 : rule__Statemachine__Group_7__2__Impl rule__Statemachine__Group_7__3 ;
    public final void rule__Statemachine__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2435:1: ( rule__Statemachine__Group_7__2__Impl rule__Statemachine__Group_7__3 )
            // InternalXUmlb.g:2436:2: rule__Statemachine__Group_7__2__Impl rule__Statemachine__Group_7__3
            {
            pushFollow(FOLLOW_15);
            rule__Statemachine__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statemachine__Group_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_7__2"


    // $ANTLR start "rule__Statemachine__Group_7__2__Impl"
    // InternalXUmlb.g:2443:1: rule__Statemachine__Group_7__2__Impl : ( 'selfName' ) ;
    public final void rule__Statemachine__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2447:1: ( ( 'selfName' ) )
            // InternalXUmlb.g:2448:1: ( 'selfName' )
            {
            // InternalXUmlb.g:2448:1: ( 'selfName' )
            // InternalXUmlb.g:2449:2: 'selfName'
            {
             before(grammarAccess.getStatemachineAccess().getSelfNameKeyword_7_2()); 
            match(input,125,FOLLOW_2); 
             after(grammarAccess.getStatemachineAccess().getSelfNameKeyword_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_7__2__Impl"


    // $ANTLR start "rule__Statemachine__Group_7__3"
    // InternalXUmlb.g:2458:1: rule__Statemachine__Group_7__3 : rule__Statemachine__Group_7__3__Impl ;
    public final void rule__Statemachine__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2462:1: ( rule__Statemachine__Group_7__3__Impl )
            // InternalXUmlb.g:2463:2: rule__Statemachine__Group_7__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Statemachine__Group_7__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_7__3"


    // $ANTLR start "rule__Statemachine__Group_7__3__Impl"
    // InternalXUmlb.g:2469:1: rule__Statemachine__Group_7__3__Impl : ( ( rule__Statemachine__SelfNameAssignment_7_3 ) ) ;
    public final void rule__Statemachine__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2473:1: ( ( ( rule__Statemachine__SelfNameAssignment_7_3 ) ) )
            // InternalXUmlb.g:2474:1: ( ( rule__Statemachine__SelfNameAssignment_7_3 ) )
            {
            // InternalXUmlb.g:2474:1: ( ( rule__Statemachine__SelfNameAssignment_7_3 ) )
            // InternalXUmlb.g:2475:2: ( rule__Statemachine__SelfNameAssignment_7_3 )
            {
             before(grammarAccess.getStatemachineAccess().getSelfNameAssignment_7_3()); 
            // InternalXUmlb.g:2476:2: ( rule__Statemachine__SelfNameAssignment_7_3 )
            // InternalXUmlb.g:2476:3: rule__Statemachine__SelfNameAssignment_7_3
            {
            pushFollow(FOLLOW_2);
            rule__Statemachine__SelfNameAssignment_7_3();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getSelfNameAssignment_7_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group_7__3__Impl"


    // $ANTLR start "rule__Transition__Group__0"
    // InternalXUmlb.g:2485:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2489:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // InternalXUmlb.g:2490:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Transition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0"


    // $ANTLR start "rule__Transition__Group__0__Impl"
    // InternalXUmlb.g:2497:1: rule__Transition__Group__0__Impl : ( () ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2501:1: ( ( () ) )
            // InternalXUmlb.g:2502:1: ( () )
            {
            // InternalXUmlb.g:2502:1: ( () )
            // InternalXUmlb.g:2503:2: ()
            {
             before(grammarAccess.getTransitionAccess().getTransitionAction_0()); 
            // InternalXUmlb.g:2504:2: ()
            // InternalXUmlb.g:2504:3: 
            {
            }

             after(grammarAccess.getTransitionAccess().getTransitionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0__Impl"


    // $ANTLR start "rule__Transition__Group__1"
    // InternalXUmlb.g:2512:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2516:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // InternalXUmlb.g:2517:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_17);
            rule__Transition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1"


    // $ANTLR start "rule__Transition__Group__1__Impl"
    // InternalXUmlb.g:2524:1: rule__Transition__Group__1__Impl : ( 'transition' ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2528:1: ( ( 'transition' ) )
            // InternalXUmlb.g:2529:1: ( 'transition' )
            {
            // InternalXUmlb.g:2529:1: ( 'transition' )
            // InternalXUmlb.g:2530:2: 'transition'
            {
             before(grammarAccess.getTransitionAccess().getTransitionKeyword_1()); 
            match(input,126,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getTransitionKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1__Impl"


    // $ANTLR start "rule__Transition__Group__2"
    // InternalXUmlb.g:2539:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl rule__Transition__Group__3 ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2543:1: ( rule__Transition__Group__2__Impl rule__Transition__Group__3 )
            // InternalXUmlb.g:2544:2: rule__Transition__Group__2__Impl rule__Transition__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__Transition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2"


    // $ANTLR start "rule__Transition__Group__2__Impl"
    // InternalXUmlb.g:2551:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__Group_2__0 )? ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2555:1: ( ( ( rule__Transition__Group_2__0 )? ) )
            // InternalXUmlb.g:2556:1: ( ( rule__Transition__Group_2__0 )? )
            {
            // InternalXUmlb.g:2556:1: ( ( rule__Transition__Group_2__0 )? )
            // InternalXUmlb.g:2557:2: ( rule__Transition__Group_2__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_2()); 
            // InternalXUmlb.g:2558:2: ( rule__Transition__Group_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==120) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalXUmlb.g:2558:3: rule__Transition__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Transition__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2__Impl"


    // $ANTLR start "rule__Transition__Group__3"
    // InternalXUmlb.g:2566:1: rule__Transition__Group__3 : rule__Transition__Group__3__Impl rule__Transition__Group__4 ;
    public final void rule__Transition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2570:1: ( rule__Transition__Group__3__Impl rule__Transition__Group__4 )
            // InternalXUmlb.g:2571:2: rule__Transition__Group__3__Impl rule__Transition__Group__4
            {
            pushFollow(FOLLOW_17);
            rule__Transition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__3"


    // $ANTLR start "rule__Transition__Group__3__Impl"
    // InternalXUmlb.g:2578:1: rule__Transition__Group__3__Impl : ( ( rule__Transition__ExtendedAssignment_3 )? ) ;
    public final void rule__Transition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2582:1: ( ( ( rule__Transition__ExtendedAssignment_3 )? ) )
            // InternalXUmlb.g:2583:1: ( ( rule__Transition__ExtendedAssignment_3 )? )
            {
            // InternalXUmlb.g:2583:1: ( ( rule__Transition__ExtendedAssignment_3 )? )
            // InternalXUmlb.g:2584:2: ( rule__Transition__ExtendedAssignment_3 )?
            {
             before(grammarAccess.getTransitionAccess().getExtendedAssignment_3()); 
            // InternalXUmlb.g:2585:2: ( rule__Transition__ExtendedAssignment_3 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==157) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalXUmlb.g:2585:3: rule__Transition__ExtendedAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Transition__ExtendedAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getExtendedAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__3__Impl"


    // $ANTLR start "rule__Transition__Group__4"
    // InternalXUmlb.g:2593:1: rule__Transition__Group__4 : rule__Transition__Group__4__Impl rule__Transition__Group__5 ;
    public final void rule__Transition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2597:1: ( rule__Transition__Group__4__Impl rule__Transition__Group__5 )
            // InternalXUmlb.g:2598:2: rule__Transition__Group__4__Impl rule__Transition__Group__5
            {
            pushFollow(FOLLOW_4);
            rule__Transition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__4"


    // $ANTLR start "rule__Transition__Group__4__Impl"
    // InternalXUmlb.g:2605:1: rule__Transition__Group__4__Impl : ( 'source' ) ;
    public final void rule__Transition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2609:1: ( ( 'source' ) )
            // InternalXUmlb.g:2610:1: ( 'source' )
            {
            // InternalXUmlb.g:2610:1: ( 'source' )
            // InternalXUmlb.g:2611:2: 'source'
            {
             before(grammarAccess.getTransitionAccess().getSourceKeyword_4()); 
            match(input,127,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getSourceKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__4__Impl"


    // $ANTLR start "rule__Transition__Group__5"
    // InternalXUmlb.g:2620:1: rule__Transition__Group__5 : rule__Transition__Group__5__Impl rule__Transition__Group__6 ;
    public final void rule__Transition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2624:1: ( rule__Transition__Group__5__Impl rule__Transition__Group__6 )
            // InternalXUmlb.g:2625:2: rule__Transition__Group__5__Impl rule__Transition__Group__6
            {
            pushFollow(FOLLOW_18);
            rule__Transition__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__5"


    // $ANTLR start "rule__Transition__Group__5__Impl"
    // InternalXUmlb.g:2632:1: rule__Transition__Group__5__Impl : ( ( rule__Transition__SourceAssignment_5 ) ) ;
    public final void rule__Transition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2636:1: ( ( ( rule__Transition__SourceAssignment_5 ) ) )
            // InternalXUmlb.g:2637:1: ( ( rule__Transition__SourceAssignment_5 ) )
            {
            // InternalXUmlb.g:2637:1: ( ( rule__Transition__SourceAssignment_5 ) )
            // InternalXUmlb.g:2638:2: ( rule__Transition__SourceAssignment_5 )
            {
             before(grammarAccess.getTransitionAccess().getSourceAssignment_5()); 
            // InternalXUmlb.g:2639:2: ( rule__Transition__SourceAssignment_5 )
            // InternalXUmlb.g:2639:3: rule__Transition__SourceAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Transition__SourceAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getSourceAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__5__Impl"


    // $ANTLR start "rule__Transition__Group__6"
    // InternalXUmlb.g:2647:1: rule__Transition__Group__6 : rule__Transition__Group__6__Impl rule__Transition__Group__7 ;
    public final void rule__Transition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2651:1: ( rule__Transition__Group__6__Impl rule__Transition__Group__7 )
            // InternalXUmlb.g:2652:2: rule__Transition__Group__6__Impl rule__Transition__Group__7
            {
            pushFollow(FOLLOW_4);
            rule__Transition__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__6"


    // $ANTLR start "rule__Transition__Group__6__Impl"
    // InternalXUmlb.g:2659:1: rule__Transition__Group__6__Impl : ( 'target' ) ;
    public final void rule__Transition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2663:1: ( ( 'target' ) )
            // InternalXUmlb.g:2664:1: ( 'target' )
            {
            // InternalXUmlb.g:2664:1: ( 'target' )
            // InternalXUmlb.g:2665:2: 'target'
            {
             before(grammarAccess.getTransitionAccess().getTargetKeyword_6()); 
            match(input,128,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getTargetKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__6__Impl"


    // $ANTLR start "rule__Transition__Group__7"
    // InternalXUmlb.g:2674:1: rule__Transition__Group__7 : rule__Transition__Group__7__Impl rule__Transition__Group__8 ;
    public final void rule__Transition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2678:1: ( rule__Transition__Group__7__Impl rule__Transition__Group__8 )
            // InternalXUmlb.g:2679:2: rule__Transition__Group__7__Impl rule__Transition__Group__8
            {
            pushFollow(FOLLOW_19);
            rule__Transition__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__7"


    // $ANTLR start "rule__Transition__Group__7__Impl"
    // InternalXUmlb.g:2686:1: rule__Transition__Group__7__Impl : ( ( rule__Transition__TargetAssignment_7 ) ) ;
    public final void rule__Transition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2690:1: ( ( ( rule__Transition__TargetAssignment_7 ) ) )
            // InternalXUmlb.g:2691:1: ( ( rule__Transition__TargetAssignment_7 ) )
            {
            // InternalXUmlb.g:2691:1: ( ( rule__Transition__TargetAssignment_7 ) )
            // InternalXUmlb.g:2692:2: ( rule__Transition__TargetAssignment_7 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAssignment_7()); 
            // InternalXUmlb.g:2693:2: ( rule__Transition__TargetAssignment_7 )
            // InternalXUmlb.g:2693:3: rule__Transition__TargetAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Transition__TargetAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getTargetAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__7__Impl"


    // $ANTLR start "rule__Transition__Group__8"
    // InternalXUmlb.g:2701:1: rule__Transition__Group__8 : rule__Transition__Group__8__Impl rule__Transition__Group__9 ;
    public final void rule__Transition__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2705:1: ( rule__Transition__Group__8__Impl rule__Transition__Group__9 )
            // InternalXUmlb.g:2706:2: rule__Transition__Group__8__Impl rule__Transition__Group__9
            {
            pushFollow(FOLLOW_19);
            rule__Transition__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__8"


    // $ANTLR start "rule__Transition__Group__8__Impl"
    // InternalXUmlb.g:2713:1: rule__Transition__Group__8__Impl : ( ( rule__Transition__Group_8__0 )? ) ;
    public final void rule__Transition__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2717:1: ( ( ( rule__Transition__Group_8__0 )? ) )
            // InternalXUmlb.g:2718:1: ( ( rule__Transition__Group_8__0 )? )
            {
            // InternalXUmlb.g:2718:1: ( ( rule__Transition__Group_8__0 )? )
            // InternalXUmlb.g:2719:2: ( rule__Transition__Group_8__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_8()); 
            // InternalXUmlb.g:2720:2: ( rule__Transition__Group_8__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==129) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalXUmlb.g:2720:3: rule__Transition__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Transition__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__8__Impl"


    // $ANTLR start "rule__Transition__Group__9"
    // InternalXUmlb.g:2728:1: rule__Transition__Group__9 : rule__Transition__Group__9__Impl rule__Transition__Group__10 ;
    public final void rule__Transition__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2732:1: ( rule__Transition__Group__9__Impl rule__Transition__Group__10 )
            // InternalXUmlb.g:2733:2: rule__Transition__Group__9__Impl rule__Transition__Group__10
            {
            pushFollow(FOLLOW_19);
            rule__Transition__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__9"


    // $ANTLR start "rule__Transition__Group__9__Impl"
    // InternalXUmlb.g:2740:1: rule__Transition__Group__9__Impl : ( ( rule__Transition__Group_9__0 )? ) ;
    public final void rule__Transition__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2744:1: ( ( ( rule__Transition__Group_9__0 )? ) )
            // InternalXUmlb.g:2745:1: ( ( rule__Transition__Group_9__0 )? )
            {
            // InternalXUmlb.g:2745:1: ( ( rule__Transition__Group_9__0 )? )
            // InternalXUmlb.g:2746:2: ( rule__Transition__Group_9__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_9()); 
            // InternalXUmlb.g:2747:2: ( rule__Transition__Group_9__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==130) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalXUmlb.g:2747:3: rule__Transition__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Transition__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__9__Impl"


    // $ANTLR start "rule__Transition__Group__10"
    // InternalXUmlb.g:2755:1: rule__Transition__Group__10 : rule__Transition__Group__10__Impl rule__Transition__Group__11 ;
    public final void rule__Transition__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2759:1: ( rule__Transition__Group__10__Impl rule__Transition__Group__11 )
            // InternalXUmlb.g:2760:2: rule__Transition__Group__10__Impl rule__Transition__Group__11
            {
            pushFollow(FOLLOW_19);
            rule__Transition__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__10"


    // $ANTLR start "rule__Transition__Group__10__Impl"
    // InternalXUmlb.g:2767:1: rule__Transition__Group__10__Impl : ( ( rule__Transition__Group_10__0 )? ) ;
    public final void rule__Transition__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2771:1: ( ( ( rule__Transition__Group_10__0 )? ) )
            // InternalXUmlb.g:2772:1: ( ( rule__Transition__Group_10__0 )? )
            {
            // InternalXUmlb.g:2772:1: ( ( rule__Transition__Group_10__0 )? )
            // InternalXUmlb.g:2773:2: ( rule__Transition__Group_10__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_10()); 
            // InternalXUmlb.g:2774:2: ( rule__Transition__Group_10__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==131) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalXUmlb.g:2774:3: rule__Transition__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Transition__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__10__Impl"


    // $ANTLR start "rule__Transition__Group__11"
    // InternalXUmlb.g:2782:1: rule__Transition__Group__11 : rule__Transition__Group__11__Impl rule__Transition__Group__12 ;
    public final void rule__Transition__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2786:1: ( rule__Transition__Group__11__Impl rule__Transition__Group__12 )
            // InternalXUmlb.g:2787:2: rule__Transition__Group__11__Impl rule__Transition__Group__12
            {
            pushFollow(FOLLOW_19);
            rule__Transition__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__11"


    // $ANTLR start "rule__Transition__Group__11__Impl"
    // InternalXUmlb.g:2794:1: rule__Transition__Group__11__Impl : ( ( rule__Transition__Group_11__0 )? ) ;
    public final void rule__Transition__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2798:1: ( ( ( rule__Transition__Group_11__0 )? ) )
            // InternalXUmlb.g:2799:1: ( ( rule__Transition__Group_11__0 )? )
            {
            // InternalXUmlb.g:2799:1: ( ( rule__Transition__Group_11__0 )? )
            // InternalXUmlb.g:2800:2: ( rule__Transition__Group_11__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_11()); 
            // InternalXUmlb.g:2801:2: ( rule__Transition__Group_11__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==132) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalXUmlb.g:2801:3: rule__Transition__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Transition__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__11__Impl"


    // $ANTLR start "rule__Transition__Group__12"
    // InternalXUmlb.g:2809:1: rule__Transition__Group__12 : rule__Transition__Group__12__Impl ;
    public final void rule__Transition__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2813:1: ( rule__Transition__Group__12__Impl )
            // InternalXUmlb.g:2814:2: rule__Transition__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__12"


    // $ANTLR start "rule__Transition__Group__12__Impl"
    // InternalXUmlb.g:2820:1: rule__Transition__Group__12__Impl : ( 'end' ) ;
    public final void rule__Transition__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2824:1: ( ( 'end' ) )
            // InternalXUmlb.g:2825:1: ( 'end' )
            {
            // InternalXUmlb.g:2825:1: ( 'end' )
            // InternalXUmlb.g:2826:2: 'end'
            {
             before(grammarAccess.getTransitionAccess().getEndKeyword_12()); 
            match(input,123,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getEndKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__12__Impl"


    // $ANTLR start "rule__Transition__Group_2__0"
    // InternalXUmlb.g:2836:1: rule__Transition__Group_2__0 : rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 ;
    public final void rule__Transition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2840:1: ( rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 )
            // InternalXUmlb.g:2841:2: rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__Transition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__0"


    // $ANTLR start "rule__Transition__Group_2__0__Impl"
    // InternalXUmlb.g:2848:1: rule__Transition__Group_2__0__Impl : ( 'elaborates' ) ;
    public final void rule__Transition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2852:1: ( ( 'elaborates' ) )
            // InternalXUmlb.g:2853:1: ( 'elaborates' )
            {
            // InternalXUmlb.g:2853:1: ( 'elaborates' )
            // InternalXUmlb.g:2854:2: 'elaborates'
            {
             before(grammarAccess.getTransitionAccess().getElaboratesKeyword_2_0()); 
            match(input,120,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getElaboratesKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__0__Impl"


    // $ANTLR start "rule__Transition__Group_2__1"
    // InternalXUmlb.g:2863:1: rule__Transition__Group_2__1 : rule__Transition__Group_2__1__Impl ;
    public final void rule__Transition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2867:1: ( rule__Transition__Group_2__1__Impl )
            // InternalXUmlb.g:2868:2: rule__Transition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__1"


    // $ANTLR start "rule__Transition__Group_2__1__Impl"
    // InternalXUmlb.g:2874:1: rule__Transition__Group_2__1__Impl : ( ( ( rule__Transition__ElaboratesAssignment_2_1 ) ) ( ( rule__Transition__ElaboratesAssignment_2_1 )* ) ) ;
    public final void rule__Transition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2878:1: ( ( ( ( rule__Transition__ElaboratesAssignment_2_1 ) ) ( ( rule__Transition__ElaboratesAssignment_2_1 )* ) ) )
            // InternalXUmlb.g:2879:1: ( ( ( rule__Transition__ElaboratesAssignment_2_1 ) ) ( ( rule__Transition__ElaboratesAssignment_2_1 )* ) )
            {
            // InternalXUmlb.g:2879:1: ( ( ( rule__Transition__ElaboratesAssignment_2_1 ) ) ( ( rule__Transition__ElaboratesAssignment_2_1 )* ) )
            // InternalXUmlb.g:2880:2: ( ( rule__Transition__ElaboratesAssignment_2_1 ) ) ( ( rule__Transition__ElaboratesAssignment_2_1 )* )
            {
            // InternalXUmlb.g:2880:2: ( ( rule__Transition__ElaboratesAssignment_2_1 ) )
            // InternalXUmlb.g:2881:3: ( rule__Transition__ElaboratesAssignment_2_1 )
            {
             before(grammarAccess.getTransitionAccess().getElaboratesAssignment_2_1()); 
            // InternalXUmlb.g:2882:3: ( rule__Transition__ElaboratesAssignment_2_1 )
            // InternalXUmlb.g:2882:4: rule__Transition__ElaboratesAssignment_2_1
            {
            pushFollow(FOLLOW_20);
            rule__Transition__ElaboratesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getElaboratesAssignment_2_1()); 

            }

            // InternalXUmlb.g:2885:2: ( ( rule__Transition__ElaboratesAssignment_2_1 )* )
            // InternalXUmlb.g:2886:3: ( rule__Transition__ElaboratesAssignment_2_1 )*
            {
             before(grammarAccess.getTransitionAccess().getElaboratesAssignment_2_1()); 
            // InternalXUmlb.g:2887:3: ( rule__Transition__ElaboratesAssignment_2_1 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalXUmlb.g:2887:4: rule__Transition__ElaboratesAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__Transition__ElaboratesAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getTransitionAccess().getElaboratesAssignment_2_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__1__Impl"


    // $ANTLR start "rule__Transition__Group_8__0"
    // InternalXUmlb.g:2897:1: rule__Transition__Group_8__0 : rule__Transition__Group_8__0__Impl rule__Transition__Group_8__1 ;
    public final void rule__Transition__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2901:1: ( rule__Transition__Group_8__0__Impl rule__Transition__Group_8__1 )
            // InternalXUmlb.g:2902:2: rule__Transition__Group_8__0__Impl rule__Transition__Group_8__1
            {
            pushFollow(FOLLOW_4);
            rule__Transition__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_8__0"


    // $ANTLR start "rule__Transition__Group_8__0__Impl"
    // InternalXUmlb.g:2909:1: rule__Transition__Group_8__0__Impl : ( 'any' ) ;
    public final void rule__Transition__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2913:1: ( ( 'any' ) )
            // InternalXUmlb.g:2914:1: ( 'any' )
            {
            // InternalXUmlb.g:2914:1: ( 'any' )
            // InternalXUmlb.g:2915:2: 'any'
            {
             before(grammarAccess.getTransitionAccess().getAnyKeyword_8_0()); 
            match(input,129,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getAnyKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_8__0__Impl"


    // $ANTLR start "rule__Transition__Group_8__1"
    // InternalXUmlb.g:2924:1: rule__Transition__Group_8__1 : rule__Transition__Group_8__1__Impl rule__Transition__Group_8__2 ;
    public final void rule__Transition__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2928:1: ( rule__Transition__Group_8__1__Impl rule__Transition__Group_8__2 )
            // InternalXUmlb.g:2929:2: rule__Transition__Group_8__1__Impl rule__Transition__Group_8__2
            {
            pushFollow(FOLLOW_21);
            rule__Transition__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_8__1"


    // $ANTLR start "rule__Transition__Group_8__1__Impl"
    // InternalXUmlb.g:2936:1: rule__Transition__Group_8__1__Impl : ( ( rule__Transition__ParametersAssignment_8_1 ) ) ;
    public final void rule__Transition__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2940:1: ( ( ( rule__Transition__ParametersAssignment_8_1 ) ) )
            // InternalXUmlb.g:2941:1: ( ( rule__Transition__ParametersAssignment_8_1 ) )
            {
            // InternalXUmlb.g:2941:1: ( ( rule__Transition__ParametersAssignment_8_1 ) )
            // InternalXUmlb.g:2942:2: ( rule__Transition__ParametersAssignment_8_1 )
            {
             before(grammarAccess.getTransitionAccess().getParametersAssignment_8_1()); 
            // InternalXUmlb.g:2943:2: ( rule__Transition__ParametersAssignment_8_1 )
            // InternalXUmlb.g:2943:3: rule__Transition__ParametersAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__Transition__ParametersAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getParametersAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_8__1__Impl"


    // $ANTLR start "rule__Transition__Group_8__2"
    // InternalXUmlb.g:2951:1: rule__Transition__Group_8__2 : rule__Transition__Group_8__2__Impl ;
    public final void rule__Transition__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2955:1: ( rule__Transition__Group_8__2__Impl )
            // InternalXUmlb.g:2956:2: rule__Transition__Group_8__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group_8__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_8__2"


    // $ANTLR start "rule__Transition__Group_8__2__Impl"
    // InternalXUmlb.g:2962:1: rule__Transition__Group_8__2__Impl : ( ( rule__Transition__Group_8_2__0 )* ) ;
    public final void rule__Transition__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2966:1: ( ( ( rule__Transition__Group_8_2__0 )* ) )
            // InternalXUmlb.g:2967:1: ( ( rule__Transition__Group_8_2__0 )* )
            {
            // InternalXUmlb.g:2967:1: ( ( rule__Transition__Group_8_2__0 )* )
            // InternalXUmlb.g:2968:2: ( rule__Transition__Group_8_2__0 )*
            {
             before(grammarAccess.getTransitionAccess().getGroup_8_2()); 
            // InternalXUmlb.g:2969:2: ( rule__Transition__Group_8_2__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==49) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalXUmlb.g:2969:3: rule__Transition__Group_8_2__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__Transition__Group_8_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getTransitionAccess().getGroup_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_8__2__Impl"


    // $ANTLR start "rule__Transition__Group_8_2__0"
    // InternalXUmlb.g:2978:1: rule__Transition__Group_8_2__0 : rule__Transition__Group_8_2__0__Impl rule__Transition__Group_8_2__1 ;
    public final void rule__Transition__Group_8_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2982:1: ( rule__Transition__Group_8_2__0__Impl rule__Transition__Group_8_2__1 )
            // InternalXUmlb.g:2983:2: rule__Transition__Group_8_2__0__Impl rule__Transition__Group_8_2__1
            {
            pushFollow(FOLLOW_4);
            rule__Transition__Group_8_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_8_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_8_2__0"


    // $ANTLR start "rule__Transition__Group_8_2__0__Impl"
    // InternalXUmlb.g:2990:1: rule__Transition__Group_8_2__0__Impl : ( ',' ) ;
    public final void rule__Transition__Group_8_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:2994:1: ( ( ',' ) )
            // InternalXUmlb.g:2995:1: ( ',' )
            {
            // InternalXUmlb.g:2995:1: ( ',' )
            // InternalXUmlb.g:2996:2: ','
            {
             before(grammarAccess.getTransitionAccess().getCommaKeyword_8_2_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getCommaKeyword_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_8_2__0__Impl"


    // $ANTLR start "rule__Transition__Group_8_2__1"
    // InternalXUmlb.g:3005:1: rule__Transition__Group_8_2__1 : rule__Transition__Group_8_2__1__Impl ;
    public final void rule__Transition__Group_8_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3009:1: ( rule__Transition__Group_8_2__1__Impl )
            // InternalXUmlb.g:3010:2: rule__Transition__Group_8_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group_8_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_8_2__1"


    // $ANTLR start "rule__Transition__Group_8_2__1__Impl"
    // InternalXUmlb.g:3016:1: rule__Transition__Group_8_2__1__Impl : ( ( rule__Transition__ParametersAssignment_8_2_1 ) ) ;
    public final void rule__Transition__Group_8_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3020:1: ( ( ( rule__Transition__ParametersAssignment_8_2_1 ) ) )
            // InternalXUmlb.g:3021:1: ( ( rule__Transition__ParametersAssignment_8_2_1 ) )
            {
            // InternalXUmlb.g:3021:1: ( ( rule__Transition__ParametersAssignment_8_2_1 ) )
            // InternalXUmlb.g:3022:2: ( rule__Transition__ParametersAssignment_8_2_1 )
            {
             before(grammarAccess.getTransitionAccess().getParametersAssignment_8_2_1()); 
            // InternalXUmlb.g:3023:2: ( rule__Transition__ParametersAssignment_8_2_1 )
            // InternalXUmlb.g:3023:3: rule__Transition__ParametersAssignment_8_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Transition__ParametersAssignment_8_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getParametersAssignment_8_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_8_2__1__Impl"


    // $ANTLR start "rule__Transition__Group_9__0"
    // InternalXUmlb.g:3032:1: rule__Transition__Group_9__0 : rule__Transition__Group_9__0__Impl rule__Transition__Group_9__1 ;
    public final void rule__Transition__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3036:1: ( rule__Transition__Group_9__0__Impl rule__Transition__Group_9__1 )
            // InternalXUmlb.g:3037:2: rule__Transition__Group_9__0__Impl rule__Transition__Group_9__1
            {
            pushFollow(FOLLOW_23);
            rule__Transition__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_9__0"


    // $ANTLR start "rule__Transition__Group_9__0__Impl"
    // InternalXUmlb.g:3044:1: rule__Transition__Group_9__0__Impl : ( 'where' ) ;
    public final void rule__Transition__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3048:1: ( ( 'where' ) )
            // InternalXUmlb.g:3049:1: ( 'where' )
            {
            // InternalXUmlb.g:3049:1: ( 'where' )
            // InternalXUmlb.g:3050:2: 'where'
            {
             before(grammarAccess.getTransitionAccess().getWhereKeyword_9_0()); 
            match(input,130,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getWhereKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_9__0__Impl"


    // $ANTLR start "rule__Transition__Group_9__1"
    // InternalXUmlb.g:3059:1: rule__Transition__Group_9__1 : rule__Transition__Group_9__1__Impl ;
    public final void rule__Transition__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3063:1: ( rule__Transition__Group_9__1__Impl )
            // InternalXUmlb.g:3064:2: rule__Transition__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_9__1"


    // $ANTLR start "rule__Transition__Group_9__1__Impl"
    // InternalXUmlb.g:3070:1: rule__Transition__Group_9__1__Impl : ( ( ( rule__Transition__GuardsAssignment_9_1 ) ) ( ( rule__Transition__GuardsAssignment_9_1 )* ) ) ;
    public final void rule__Transition__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3074:1: ( ( ( ( rule__Transition__GuardsAssignment_9_1 ) ) ( ( rule__Transition__GuardsAssignment_9_1 )* ) ) )
            // InternalXUmlb.g:3075:1: ( ( ( rule__Transition__GuardsAssignment_9_1 ) ) ( ( rule__Transition__GuardsAssignment_9_1 )* ) )
            {
            // InternalXUmlb.g:3075:1: ( ( ( rule__Transition__GuardsAssignment_9_1 ) ) ( ( rule__Transition__GuardsAssignment_9_1 )* ) )
            // InternalXUmlb.g:3076:2: ( ( rule__Transition__GuardsAssignment_9_1 ) ) ( ( rule__Transition__GuardsAssignment_9_1 )* )
            {
            // InternalXUmlb.g:3076:2: ( ( rule__Transition__GuardsAssignment_9_1 ) )
            // InternalXUmlb.g:3077:3: ( rule__Transition__GuardsAssignment_9_1 )
            {
             before(grammarAccess.getTransitionAccess().getGuardsAssignment_9_1()); 
            // InternalXUmlb.g:3078:3: ( rule__Transition__GuardsAssignment_9_1 )
            // InternalXUmlb.g:3078:4: rule__Transition__GuardsAssignment_9_1
            {
            pushFollow(FOLLOW_24);
            rule__Transition__GuardsAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getGuardsAssignment_9_1()); 

            }

            // InternalXUmlb.g:3081:2: ( ( rule__Transition__GuardsAssignment_9_1 )* )
            // InternalXUmlb.g:3082:3: ( rule__Transition__GuardsAssignment_9_1 )*
            {
             before(grammarAccess.getTransitionAccess().getGuardsAssignment_9_1()); 
            // InternalXUmlb.g:3083:3: ( rule__Transition__GuardsAssignment_9_1 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_XLABEL||LA29_0==164) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalXUmlb.g:3083:4: rule__Transition__GuardsAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__Transition__GuardsAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getTransitionAccess().getGuardsAssignment_9_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_9__1__Impl"


    // $ANTLR start "rule__Transition__Group_10__0"
    // InternalXUmlb.g:3093:1: rule__Transition__Group_10__0 : rule__Transition__Group_10__0__Impl rule__Transition__Group_10__1 ;
    public final void rule__Transition__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3097:1: ( rule__Transition__Group_10__0__Impl rule__Transition__Group_10__1 )
            // InternalXUmlb.g:3098:2: rule__Transition__Group_10__0__Impl rule__Transition__Group_10__1
            {
            pushFollow(FOLLOW_25);
            rule__Transition__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_10__0"


    // $ANTLR start "rule__Transition__Group_10__0__Impl"
    // InternalXUmlb.g:3105:1: rule__Transition__Group_10__0__Impl : ( 'then' ) ;
    public final void rule__Transition__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3109:1: ( ( 'then' ) )
            // InternalXUmlb.g:3110:1: ( 'then' )
            {
            // InternalXUmlb.g:3110:1: ( 'then' )
            // InternalXUmlb.g:3111:2: 'then'
            {
             before(grammarAccess.getTransitionAccess().getThenKeyword_10_0()); 
            match(input,131,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getThenKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_10__0__Impl"


    // $ANTLR start "rule__Transition__Group_10__1"
    // InternalXUmlb.g:3120:1: rule__Transition__Group_10__1 : rule__Transition__Group_10__1__Impl ;
    public final void rule__Transition__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3124:1: ( rule__Transition__Group_10__1__Impl )
            // InternalXUmlb.g:3125:2: rule__Transition__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_10__1"


    // $ANTLR start "rule__Transition__Group_10__1__Impl"
    // InternalXUmlb.g:3131:1: rule__Transition__Group_10__1__Impl : ( ( ( rule__Transition__ActionsAssignment_10_1 ) ) ( ( rule__Transition__ActionsAssignment_10_1 )* ) ) ;
    public final void rule__Transition__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3135:1: ( ( ( ( rule__Transition__ActionsAssignment_10_1 ) ) ( ( rule__Transition__ActionsAssignment_10_1 )* ) ) )
            // InternalXUmlb.g:3136:1: ( ( ( rule__Transition__ActionsAssignment_10_1 ) ) ( ( rule__Transition__ActionsAssignment_10_1 )* ) )
            {
            // InternalXUmlb.g:3136:1: ( ( ( rule__Transition__ActionsAssignment_10_1 ) ) ( ( rule__Transition__ActionsAssignment_10_1 )* ) )
            // InternalXUmlb.g:3137:2: ( ( rule__Transition__ActionsAssignment_10_1 ) ) ( ( rule__Transition__ActionsAssignment_10_1 )* )
            {
            // InternalXUmlb.g:3137:2: ( ( rule__Transition__ActionsAssignment_10_1 ) )
            // InternalXUmlb.g:3138:3: ( rule__Transition__ActionsAssignment_10_1 )
            {
             before(grammarAccess.getTransitionAccess().getActionsAssignment_10_1()); 
            // InternalXUmlb.g:3139:3: ( rule__Transition__ActionsAssignment_10_1 )
            // InternalXUmlb.g:3139:4: rule__Transition__ActionsAssignment_10_1
            {
            pushFollow(FOLLOW_26);
            rule__Transition__ActionsAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getActionsAssignment_10_1()); 

            }

            // InternalXUmlb.g:3142:2: ( ( rule__Transition__ActionsAssignment_10_1 )* )
            // InternalXUmlb.g:3143:3: ( rule__Transition__ActionsAssignment_10_1 )*
            {
             before(grammarAccess.getTransitionAccess().getActionsAssignment_10_1()); 
            // InternalXUmlb.g:3144:3: ( rule__Transition__ActionsAssignment_10_1 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_XLABEL) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalXUmlb.g:3144:4: rule__Transition__ActionsAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__Transition__ActionsAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getTransitionAccess().getActionsAssignment_10_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_10__1__Impl"


    // $ANTLR start "rule__Transition__Group_11__0"
    // InternalXUmlb.g:3154:1: rule__Transition__Group_11__0 : rule__Transition__Group_11__0__Impl rule__Transition__Group_11__1 ;
    public final void rule__Transition__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3158:1: ( rule__Transition__Group_11__0__Impl rule__Transition__Group_11__1 )
            // InternalXUmlb.g:3159:2: rule__Transition__Group_11__0__Impl rule__Transition__Group_11__1
            {
            pushFollow(FOLLOW_25);
            rule__Transition__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_11__0"


    // $ANTLR start "rule__Transition__Group_11__0__Impl"
    // InternalXUmlb.g:3166:1: rule__Transition__Group_11__0__Impl : ( 'with' ) ;
    public final void rule__Transition__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3170:1: ( ( 'with' ) )
            // InternalXUmlb.g:3171:1: ( 'with' )
            {
            // InternalXUmlb.g:3171:1: ( 'with' )
            // InternalXUmlb.g:3172:2: 'with'
            {
             before(grammarAccess.getTransitionAccess().getWithKeyword_11_0()); 
            match(input,132,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getWithKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_11__0__Impl"


    // $ANTLR start "rule__Transition__Group_11__1"
    // InternalXUmlb.g:3181:1: rule__Transition__Group_11__1 : rule__Transition__Group_11__1__Impl ;
    public final void rule__Transition__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3185:1: ( rule__Transition__Group_11__1__Impl )
            // InternalXUmlb.g:3186:2: rule__Transition__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_11__1"


    // $ANTLR start "rule__Transition__Group_11__1__Impl"
    // InternalXUmlb.g:3192:1: rule__Transition__Group_11__1__Impl : ( ( ( rule__Transition__WitnessesAssignment_11_1 ) ) ( ( rule__Transition__WitnessesAssignment_11_1 )* ) ) ;
    public final void rule__Transition__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3196:1: ( ( ( ( rule__Transition__WitnessesAssignment_11_1 ) ) ( ( rule__Transition__WitnessesAssignment_11_1 )* ) ) )
            // InternalXUmlb.g:3197:1: ( ( ( rule__Transition__WitnessesAssignment_11_1 ) ) ( ( rule__Transition__WitnessesAssignment_11_1 )* ) )
            {
            // InternalXUmlb.g:3197:1: ( ( ( rule__Transition__WitnessesAssignment_11_1 ) ) ( ( rule__Transition__WitnessesAssignment_11_1 )* ) )
            // InternalXUmlb.g:3198:2: ( ( rule__Transition__WitnessesAssignment_11_1 ) ) ( ( rule__Transition__WitnessesAssignment_11_1 )* )
            {
            // InternalXUmlb.g:3198:2: ( ( rule__Transition__WitnessesAssignment_11_1 ) )
            // InternalXUmlb.g:3199:3: ( rule__Transition__WitnessesAssignment_11_1 )
            {
             before(grammarAccess.getTransitionAccess().getWitnessesAssignment_11_1()); 
            // InternalXUmlb.g:3200:3: ( rule__Transition__WitnessesAssignment_11_1 )
            // InternalXUmlb.g:3200:4: rule__Transition__WitnessesAssignment_11_1
            {
            pushFollow(FOLLOW_26);
            rule__Transition__WitnessesAssignment_11_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getWitnessesAssignment_11_1()); 

            }

            // InternalXUmlb.g:3203:2: ( ( rule__Transition__WitnessesAssignment_11_1 )* )
            // InternalXUmlb.g:3204:3: ( rule__Transition__WitnessesAssignment_11_1 )*
            {
             before(grammarAccess.getTransitionAccess().getWitnessesAssignment_11_1()); 
            // InternalXUmlb.g:3205:3: ( rule__Transition__WitnessesAssignment_11_1 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_XLABEL) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalXUmlb.g:3205:4: rule__Transition__WitnessesAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__Transition__WitnessesAssignment_11_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getTransitionAccess().getWitnessesAssignment_11_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_11__1__Impl"


    // $ANTLR start "rule__TypedParameter__Group__0"
    // InternalXUmlb.g:3215:1: rule__TypedParameter__Group__0 : rule__TypedParameter__Group__0__Impl rule__TypedParameter__Group__1 ;
    public final void rule__TypedParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3219:1: ( rule__TypedParameter__Group__0__Impl rule__TypedParameter__Group__1 )
            // InternalXUmlb.g:3220:2: rule__TypedParameter__Group__0__Impl rule__TypedParameter__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__TypedParameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypedParameter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedParameter__Group__0"


    // $ANTLR start "rule__TypedParameter__Group__0__Impl"
    // InternalXUmlb.g:3227:1: rule__TypedParameter__Group__0__Impl : ( ( rule__TypedParameter__NameAssignment_0 ) ) ;
    public final void rule__TypedParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3231:1: ( ( ( rule__TypedParameter__NameAssignment_0 ) ) )
            // InternalXUmlb.g:3232:1: ( ( rule__TypedParameter__NameAssignment_0 ) )
            {
            // InternalXUmlb.g:3232:1: ( ( rule__TypedParameter__NameAssignment_0 ) )
            // InternalXUmlb.g:3233:2: ( rule__TypedParameter__NameAssignment_0 )
            {
             before(grammarAccess.getTypedParameterAccess().getNameAssignment_0()); 
            // InternalXUmlb.g:3234:2: ( rule__TypedParameter__NameAssignment_0 )
            // InternalXUmlb.g:3234:3: rule__TypedParameter__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TypedParameter__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTypedParameterAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedParameter__Group__0__Impl"


    // $ANTLR start "rule__TypedParameter__Group__1"
    // InternalXUmlb.g:3242:1: rule__TypedParameter__Group__1 : rule__TypedParameter__Group__1__Impl rule__TypedParameter__Group__2 ;
    public final void rule__TypedParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3246:1: ( rule__TypedParameter__Group__1__Impl rule__TypedParameter__Group__2 )
            // InternalXUmlb.g:3247:2: rule__TypedParameter__Group__1__Impl rule__TypedParameter__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__TypedParameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypedParameter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedParameter__Group__1"


    // $ANTLR start "rule__TypedParameter__Group__1__Impl"
    // InternalXUmlb.g:3254:1: rule__TypedParameter__Group__1__Impl : ( ':' ) ;
    public final void rule__TypedParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3258:1: ( ( ':' ) )
            // InternalXUmlb.g:3259:1: ( ':' )
            {
            // InternalXUmlb.g:3259:1: ( ':' )
            // InternalXUmlb.g:3260:2: ':'
            {
             before(grammarAccess.getTypedParameterAccess().getColonKeyword_1()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getTypedParameterAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedParameter__Group__1__Impl"


    // $ANTLR start "rule__TypedParameter__Group__2"
    // InternalXUmlb.g:3269:1: rule__TypedParameter__Group__2 : rule__TypedParameter__Group__2__Impl ;
    public final void rule__TypedParameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3273:1: ( rule__TypedParameter__Group__2__Impl )
            // InternalXUmlb.g:3274:2: rule__TypedParameter__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypedParameter__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedParameter__Group__2"


    // $ANTLR start "rule__TypedParameter__Group__2__Impl"
    // InternalXUmlb.g:3280:1: rule__TypedParameter__Group__2__Impl : ( ( rule__TypedParameter__TypeAssignment_2 ) ) ;
    public final void rule__TypedParameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3284:1: ( ( ( rule__TypedParameter__TypeAssignment_2 ) ) )
            // InternalXUmlb.g:3285:1: ( ( rule__TypedParameter__TypeAssignment_2 ) )
            {
            // InternalXUmlb.g:3285:1: ( ( rule__TypedParameter__TypeAssignment_2 ) )
            // InternalXUmlb.g:3286:2: ( rule__TypedParameter__TypeAssignment_2 )
            {
             before(grammarAccess.getTypedParameterAccess().getTypeAssignment_2()); 
            // InternalXUmlb.g:3287:2: ( rule__TypedParameter__TypeAssignment_2 )
            // InternalXUmlb.g:3287:3: rule__TypedParameter__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TypedParameter__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTypedParameterAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedParameter__Group__2__Impl"


    // $ANTLR start "rule__XType__Group__0"
    // InternalXUmlb.g:3296:1: rule__XType__Group__0 : rule__XType__Group__0__Impl rule__XType__Group__1 ;
    public final void rule__XType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3300:1: ( rule__XType__Group__0__Impl rule__XType__Group__1 )
            // InternalXUmlb.g:3301:2: rule__XType__Group__0__Impl rule__XType__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__XType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group__0"


    // $ANTLR start "rule__XType__Group__0__Impl"
    // InternalXUmlb.g:3308:1: rule__XType__Group__0__Impl : ( ruleXComplexType ) ;
    public final void rule__XType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3312:1: ( ( ruleXComplexType ) )
            // InternalXUmlb.g:3313:1: ( ruleXComplexType )
            {
            // InternalXUmlb.g:3313:1: ( ruleXComplexType )
            // InternalXUmlb.g:3314:2: ruleXComplexType
            {
             before(grammarAccess.getXTypeAccess().getXComplexTypeParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleXComplexType();

            state._fsp--;

             after(grammarAccess.getXTypeAccess().getXComplexTypeParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group__0__Impl"


    // $ANTLR start "rule__XType__Group__1"
    // InternalXUmlb.g:3323:1: rule__XType__Group__1 : rule__XType__Group__1__Impl ;
    public final void rule__XType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3327:1: ( rule__XType__Group__1__Impl )
            // InternalXUmlb.g:3328:2: rule__XType__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XType__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group__1"


    // $ANTLR start "rule__XType__Group__1__Impl"
    // InternalXUmlb.g:3334:1: rule__XType__Group__1__Impl : ( ( rule__XType__Group_1__0 )* ) ;
    public final void rule__XType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3338:1: ( ( ( rule__XType__Group_1__0 )* ) )
            // InternalXUmlb.g:3339:1: ( ( rule__XType__Group_1__0 )* )
            {
            // InternalXUmlb.g:3339:1: ( ( rule__XType__Group_1__0 )* )
            // InternalXUmlb.g:3340:2: ( rule__XType__Group_1__0 )*
            {
             before(grammarAccess.getXTypeAccess().getGroup_1()); 
            // InternalXUmlb.g:3341:2: ( rule__XType__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==84) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalXUmlb.g:3341:3: rule__XType__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__XType__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getXTypeAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group__1__Impl"


    // $ANTLR start "rule__XType__Group_1__0"
    // InternalXUmlb.g:3350:1: rule__XType__Group_1__0 : rule__XType__Group_1__0__Impl rule__XType__Group_1__1 ;
    public final void rule__XType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3354:1: ( rule__XType__Group_1__0__Impl rule__XType__Group_1__1 )
            // InternalXUmlb.g:3355:2: rule__XType__Group_1__0__Impl rule__XType__Group_1__1
            {
            pushFollow(FOLLOW_28);
            rule__XType__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XType__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_1__0"


    // $ANTLR start "rule__XType__Group_1__0__Impl"
    // InternalXUmlb.g:3362:1: rule__XType__Group_1__0__Impl : ( '\\u00D7' ) ;
    public final void rule__XType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3366:1: ( ( '\\u00D7' ) )
            // InternalXUmlb.g:3367:1: ( '\\u00D7' )
            {
            // InternalXUmlb.g:3367:1: ( '\\u00D7' )
            // InternalXUmlb.g:3368:2: '\\u00D7'
            {
             before(grammarAccess.getXTypeAccess().getMultiplicationSignKeyword_1_0()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getXTypeAccess().getMultiplicationSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_1__0__Impl"


    // $ANTLR start "rule__XType__Group_1__1"
    // InternalXUmlb.g:3377:1: rule__XType__Group_1__1 : rule__XType__Group_1__1__Impl ;
    public final void rule__XType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3381:1: ( rule__XType__Group_1__1__Impl )
            // InternalXUmlb.g:3382:2: rule__XType__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XType__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_1__1"


    // $ANTLR start "rule__XType__Group_1__1__Impl"
    // InternalXUmlb.g:3388:1: rule__XType__Group_1__1__Impl : ( ruleXComplexType ) ;
    public final void rule__XType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3392:1: ( ( ruleXComplexType ) )
            // InternalXUmlb.g:3393:1: ( ruleXComplexType )
            {
            // InternalXUmlb.g:3393:1: ( ruleXComplexType )
            // InternalXUmlb.g:3394:2: ruleXComplexType
            {
             before(grammarAccess.getXTypeAccess().getXComplexTypeParserRuleCall_1_1()); 
            pushFollow(FOLLOW_2);
            ruleXComplexType();

            state._fsp--;

             after(grammarAccess.getXTypeAccess().getXComplexTypeParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_1__1__Impl"


    // $ANTLR start "rule__XComplexType__Group_0__0"
    // InternalXUmlb.g:3404:1: rule__XComplexType__Group_0__0 : rule__XComplexType__Group_0__0__Impl rule__XComplexType__Group_0__1 ;
    public final void rule__XComplexType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3408:1: ( rule__XComplexType__Group_0__0__Impl rule__XComplexType__Group_0__1 )
            // InternalXUmlb.g:3409:2: rule__XComplexType__Group_0__0__Impl rule__XComplexType__Group_0__1
            {
            pushFollow(FOLLOW_8);
            rule__XComplexType__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XComplexType__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XComplexType__Group_0__0"


    // $ANTLR start "rule__XComplexType__Group_0__0__Impl"
    // InternalXUmlb.g:3416:1: rule__XComplexType__Group_0__0__Impl : ( '\\u2119' ) ;
    public final void rule__XComplexType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3420:1: ( ( '\\u2119' ) )
            // InternalXUmlb.g:3421:1: ( '\\u2119' )
            {
            // InternalXUmlb.g:3421:1: ( '\\u2119' )
            // InternalXUmlb.g:3422:2: '\\u2119'
            {
             before(grammarAccess.getXComplexTypeAccess().getDoubleStruckCapitalPKeyword_0_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getXComplexTypeAccess().getDoubleStruckCapitalPKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XComplexType__Group_0__0__Impl"


    // $ANTLR start "rule__XComplexType__Group_0__1"
    // InternalXUmlb.g:3431:1: rule__XComplexType__Group_0__1 : rule__XComplexType__Group_0__1__Impl rule__XComplexType__Group_0__2 ;
    public final void rule__XComplexType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3435:1: ( rule__XComplexType__Group_0__1__Impl rule__XComplexType__Group_0__2 )
            // InternalXUmlb.g:3436:2: rule__XComplexType__Group_0__1__Impl rule__XComplexType__Group_0__2
            {
            pushFollow(FOLLOW_28);
            rule__XComplexType__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XComplexType__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XComplexType__Group_0__1"


    // $ANTLR start "rule__XComplexType__Group_0__1__Impl"
    // InternalXUmlb.g:3443:1: rule__XComplexType__Group_0__1__Impl : ( '(' ) ;
    public final void rule__XComplexType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3447:1: ( ( '(' ) )
            // InternalXUmlb.g:3448:1: ( '(' )
            {
            // InternalXUmlb.g:3448:1: ( '(' )
            // InternalXUmlb.g:3449:2: '('
            {
             before(grammarAccess.getXComplexTypeAccess().getLeftParenthesisKeyword_0_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getXComplexTypeAccess().getLeftParenthesisKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XComplexType__Group_0__1__Impl"


    // $ANTLR start "rule__XComplexType__Group_0__2"
    // InternalXUmlb.g:3458:1: rule__XComplexType__Group_0__2 : rule__XComplexType__Group_0__2__Impl rule__XComplexType__Group_0__3 ;
    public final void rule__XComplexType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3462:1: ( rule__XComplexType__Group_0__2__Impl rule__XComplexType__Group_0__3 )
            // InternalXUmlb.g:3463:2: rule__XComplexType__Group_0__2__Impl rule__XComplexType__Group_0__3
            {
            pushFollow(FOLLOW_10);
            rule__XComplexType__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XComplexType__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XComplexType__Group_0__2"


    // $ANTLR start "rule__XComplexType__Group_0__2__Impl"
    // InternalXUmlb.g:3470:1: rule__XComplexType__Group_0__2__Impl : ( ruleXType ) ;
    public final void rule__XComplexType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3474:1: ( ( ruleXType ) )
            // InternalXUmlb.g:3475:1: ( ruleXType )
            {
            // InternalXUmlb.g:3475:1: ( ruleXType )
            // InternalXUmlb.g:3476:2: ruleXType
            {
             before(grammarAccess.getXComplexTypeAccess().getXTypeParserRuleCall_0_2()); 
            pushFollow(FOLLOW_2);
            ruleXType();

            state._fsp--;

             after(grammarAccess.getXComplexTypeAccess().getXTypeParserRuleCall_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XComplexType__Group_0__2__Impl"


    // $ANTLR start "rule__XComplexType__Group_0__3"
    // InternalXUmlb.g:3485:1: rule__XComplexType__Group_0__3 : rule__XComplexType__Group_0__3__Impl ;
    public final void rule__XComplexType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3489:1: ( rule__XComplexType__Group_0__3__Impl )
            // InternalXUmlb.g:3490:2: rule__XComplexType__Group_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XComplexType__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XComplexType__Group_0__3"


    // $ANTLR start "rule__XComplexType__Group_0__3__Impl"
    // InternalXUmlb.g:3496:1: rule__XComplexType__Group_0__3__Impl : ( ')' ) ;
    public final void rule__XComplexType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3500:1: ( ( ')' ) )
            // InternalXUmlb.g:3501:1: ( ')' )
            {
            // InternalXUmlb.g:3501:1: ( ')' )
            // InternalXUmlb.g:3502:2: ')'
            {
             before(grammarAccess.getXComplexTypeAccess().getRightParenthesisKeyword_0_3()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getXComplexTypeAccess().getRightParenthesisKeyword_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XComplexType__Group_0__3__Impl"


    // $ANTLR start "rule__State__Group__0"
    // InternalXUmlb.g:3512:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3516:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // InternalXUmlb.g:3517:2: rule__State__Group__0__Impl rule__State__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__State__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0"


    // $ANTLR start "rule__State__Group__0__Impl"
    // InternalXUmlb.g:3524:1: rule__State__Group__0__Impl : ( () ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3528:1: ( ( () ) )
            // InternalXUmlb.g:3529:1: ( () )
            {
            // InternalXUmlb.g:3529:1: ( () )
            // InternalXUmlb.g:3530:2: ()
            {
             before(grammarAccess.getStateAccess().getStateAction_0()); 
            // InternalXUmlb.g:3531:2: ()
            // InternalXUmlb.g:3531:3: 
            {
            }

             after(grammarAccess.getStateAccess().getStateAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0__Impl"


    // $ANTLR start "rule__State__Group__1"
    // InternalXUmlb.g:3539:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3543:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // InternalXUmlb.g:3544:2: rule__State__Group__1__Impl rule__State__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__State__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1"


    // $ANTLR start "rule__State__Group__1__Impl"
    // InternalXUmlb.g:3551:1: rule__State__Group__1__Impl : ( 'state' ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3555:1: ( ( 'state' ) )
            // InternalXUmlb.g:3556:1: ( 'state' )
            {
            // InternalXUmlb.g:3556:1: ( 'state' )
            // InternalXUmlb.g:3557:2: 'state'
            {
             before(grammarAccess.getStateAccess().getStateKeyword_1()); 
            match(input,133,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getStateKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1__Impl"


    // $ANTLR start "rule__State__Group__2"
    // InternalXUmlb.g:3566:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3570:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // InternalXUmlb.g:3571:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__State__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2"


    // $ANTLR start "rule__State__Group__2__Impl"
    // InternalXUmlb.g:3578:1: rule__State__Group__2__Impl : ( ( rule__State__NameAssignment_2 ) ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3582:1: ( ( ( rule__State__NameAssignment_2 ) ) )
            // InternalXUmlb.g:3583:1: ( ( rule__State__NameAssignment_2 ) )
            {
            // InternalXUmlb.g:3583:1: ( ( rule__State__NameAssignment_2 ) )
            // InternalXUmlb.g:3584:2: ( rule__State__NameAssignment_2 )
            {
             before(grammarAccess.getStateAccess().getNameAssignment_2()); 
            // InternalXUmlb.g:3585:2: ( rule__State__NameAssignment_2 )
            // InternalXUmlb.g:3585:3: rule__State__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__State__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2__Impl"


    // $ANTLR start "rule__State__Group__3"
    // InternalXUmlb.g:3593:1: rule__State__Group__3 : rule__State__Group__3__Impl rule__State__Group__4 ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3597:1: ( rule__State__Group__3__Impl rule__State__Group__4 )
            // InternalXUmlb.g:3598:2: rule__State__Group__3__Impl rule__State__Group__4
            {
            pushFollow(FOLLOW_32);
            rule__State__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3"


    // $ANTLR start "rule__State__Group__3__Impl"
    // InternalXUmlb.g:3605:1: rule__State__Group__3__Impl : ( ( rule__State__Group_3__0 )? ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3609:1: ( ( ( rule__State__Group_3__0 )? ) )
            // InternalXUmlb.g:3610:1: ( ( rule__State__Group_3__0 )? )
            {
            // InternalXUmlb.g:3610:1: ( ( rule__State__Group_3__0 )? )
            // InternalXUmlb.g:3611:2: ( rule__State__Group_3__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_3()); 
            // InternalXUmlb.g:3612:2: ( rule__State__Group_3__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==121) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalXUmlb.g:3612:3: rule__State__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__State__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3__Impl"


    // $ANTLR start "rule__State__Group__4"
    // InternalXUmlb.g:3620:1: rule__State__Group__4 : rule__State__Group__4__Impl rule__State__Group__5 ;
    public final void rule__State__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3624:1: ( rule__State__Group__4__Impl rule__State__Group__5 )
            // InternalXUmlb.g:3625:2: rule__State__Group__4__Impl rule__State__Group__5
            {
            pushFollow(FOLLOW_32);
            rule__State__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__4"


    // $ANTLR start "rule__State__Group__4__Impl"
    // InternalXUmlb.g:3632:1: rule__State__Group__4__Impl : ( ( rule__State__Group_4__0 )? ) ;
    public final void rule__State__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3636:1: ( ( ( rule__State__Group_4__0 )? ) )
            // InternalXUmlb.g:3637:1: ( ( rule__State__Group_4__0 )? )
            {
            // InternalXUmlb.g:3637:1: ( ( rule__State__Group_4__0 )? )
            // InternalXUmlb.g:3638:2: ( rule__State__Group_4__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_4()); 
            // InternalXUmlb.g:3639:2: ( rule__State__Group_4__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==134) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalXUmlb.g:3639:3: rule__State__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__State__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__4__Impl"


    // $ANTLR start "rule__State__Group__5"
    // InternalXUmlb.g:3647:1: rule__State__Group__5 : rule__State__Group__5__Impl rule__State__Group__6 ;
    public final void rule__State__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3651:1: ( rule__State__Group__5__Impl rule__State__Group__6 )
            // InternalXUmlb.g:3652:2: rule__State__Group__5__Impl rule__State__Group__6
            {
            pushFollow(FOLLOW_32);
            rule__State__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__5"


    // $ANTLR start "rule__State__Group__5__Impl"
    // InternalXUmlb.g:3659:1: rule__State__Group__5__Impl : ( ( rule__State__Group_5__0 )? ) ;
    public final void rule__State__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3663:1: ( ( ( rule__State__Group_5__0 )? ) )
            // InternalXUmlb.g:3664:1: ( ( rule__State__Group_5__0 )? )
            {
            // InternalXUmlb.g:3664:1: ( ( rule__State__Group_5__0 )? )
            // InternalXUmlb.g:3665:2: ( rule__State__Group_5__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_5()); 
            // InternalXUmlb.g:3666:2: ( rule__State__Group_5__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==136) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalXUmlb.g:3666:3: rule__State__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__State__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__5__Impl"


    // $ANTLR start "rule__State__Group__6"
    // InternalXUmlb.g:3674:1: rule__State__Group__6 : rule__State__Group__6__Impl rule__State__Group__7 ;
    public final void rule__State__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3678:1: ( rule__State__Group__6__Impl rule__State__Group__7 )
            // InternalXUmlb.g:3679:2: rule__State__Group__6__Impl rule__State__Group__7
            {
            pushFollow(FOLLOW_32);
            rule__State__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__6"


    // $ANTLR start "rule__State__Group__6__Impl"
    // InternalXUmlb.g:3686:1: rule__State__Group__6__Impl : ( ( rule__State__Group_6__0 )? ) ;
    public final void rule__State__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3690:1: ( ( ( rule__State__Group_6__0 )? ) )
            // InternalXUmlb.g:3691:1: ( ( rule__State__Group_6__0 )? )
            {
            // InternalXUmlb.g:3691:1: ( ( rule__State__Group_6__0 )? )
            // InternalXUmlb.g:3692:2: ( rule__State__Group_6__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_6()); 
            // InternalXUmlb.g:3693:2: ( rule__State__Group_6__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==137) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalXUmlb.g:3693:3: rule__State__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__State__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__6__Impl"


    // $ANTLR start "rule__State__Group__7"
    // InternalXUmlb.g:3701:1: rule__State__Group__7 : rule__State__Group__7__Impl ;
    public final void rule__State__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3705:1: ( rule__State__Group__7__Impl )
            // InternalXUmlb.g:3706:2: rule__State__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__7"


    // $ANTLR start "rule__State__Group__7__Impl"
    // InternalXUmlb.g:3712:1: rule__State__Group__7__Impl : ( ( rule__State__Group_7__0 )? ) ;
    public final void rule__State__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3716:1: ( ( ( rule__State__Group_7__0 )? ) )
            // InternalXUmlb.g:3717:1: ( ( rule__State__Group_7__0 )? )
            {
            // InternalXUmlb.g:3717:1: ( ( rule__State__Group_7__0 )? )
            // InternalXUmlb.g:3718:2: ( rule__State__Group_7__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_7()); 
            // InternalXUmlb.g:3719:2: ( rule__State__Group_7__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==138) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalXUmlb.g:3719:3: rule__State__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__State__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__7__Impl"


    // $ANTLR start "rule__State__Group_3__0"
    // InternalXUmlb.g:3728:1: rule__State__Group_3__0 : rule__State__Group_3__0__Impl rule__State__Group_3__1 ;
    public final void rule__State__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3732:1: ( rule__State__Group_3__0__Impl rule__State__Group_3__1 )
            // InternalXUmlb.g:3733:2: rule__State__Group_3__0__Impl rule__State__Group_3__1
            {
            pushFollow(FOLLOW_4);
            rule__State__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__0"


    // $ANTLR start "rule__State__Group_3__0__Impl"
    // InternalXUmlb.g:3740:1: rule__State__Group_3__0__Impl : ( 'refines' ) ;
    public final void rule__State__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3744:1: ( ( 'refines' ) )
            // InternalXUmlb.g:3745:1: ( 'refines' )
            {
            // InternalXUmlb.g:3745:1: ( 'refines' )
            // InternalXUmlb.g:3746:2: 'refines'
            {
             before(grammarAccess.getStateAccess().getRefinesKeyword_3_0()); 
            match(input,121,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getRefinesKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__0__Impl"


    // $ANTLR start "rule__State__Group_3__1"
    // InternalXUmlb.g:3755:1: rule__State__Group_3__1 : rule__State__Group_3__1__Impl ;
    public final void rule__State__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3759:1: ( rule__State__Group_3__1__Impl )
            // InternalXUmlb.g:3760:2: rule__State__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__1"


    // $ANTLR start "rule__State__Group_3__1__Impl"
    // InternalXUmlb.g:3766:1: rule__State__Group_3__1__Impl : ( ( rule__State__RefinesAssignment_3_1 ) ) ;
    public final void rule__State__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3770:1: ( ( ( rule__State__RefinesAssignment_3_1 ) ) )
            // InternalXUmlb.g:3771:1: ( ( rule__State__RefinesAssignment_3_1 ) )
            {
            // InternalXUmlb.g:3771:1: ( ( rule__State__RefinesAssignment_3_1 ) )
            // InternalXUmlb.g:3772:2: ( rule__State__RefinesAssignment_3_1 )
            {
             before(grammarAccess.getStateAccess().getRefinesAssignment_3_1()); 
            // InternalXUmlb.g:3773:2: ( rule__State__RefinesAssignment_3_1 )
            // InternalXUmlb.g:3773:3: rule__State__RefinesAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__State__RefinesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getRefinesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__1__Impl"


    // $ANTLR start "rule__State__Group_4__0"
    // InternalXUmlb.g:3782:1: rule__State__Group_4__0 : rule__State__Group_4__0__Impl rule__State__Group_4__1 ;
    public final void rule__State__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3786:1: ( rule__State__Group_4__0__Impl rule__State__Group_4__1 )
            // InternalXUmlb.g:3787:2: rule__State__Group_4__0__Impl rule__State__Group_4__1
            {
            pushFollow(FOLLOW_33);
            rule__State__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_4__0"


    // $ANTLR start "rule__State__Group_4__0__Impl"
    // InternalXUmlb.g:3794:1: rule__State__Group_4__0__Impl : ( 'statemachines' ) ;
    public final void rule__State__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3798:1: ( ( 'statemachines' ) )
            // InternalXUmlb.g:3799:1: ( 'statemachines' )
            {
            // InternalXUmlb.g:3799:1: ( 'statemachines' )
            // InternalXUmlb.g:3800:2: 'statemachines'
            {
             before(grammarAccess.getStateAccess().getStatemachinesKeyword_4_0()); 
            match(input,134,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getStatemachinesKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_4__0__Impl"


    // $ANTLR start "rule__State__Group_4__1"
    // InternalXUmlb.g:3809:1: rule__State__Group_4__1 : rule__State__Group_4__1__Impl rule__State__Group_4__2 ;
    public final void rule__State__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3813:1: ( rule__State__Group_4__1__Impl rule__State__Group_4__2 )
            // InternalXUmlb.g:3814:2: rule__State__Group_4__1__Impl rule__State__Group_4__2
            {
            pushFollow(FOLLOW_7);
            rule__State__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_4__1"


    // $ANTLR start "rule__State__Group_4__1__Impl"
    // InternalXUmlb.g:3821:1: rule__State__Group_4__1__Impl : ( 'begin' ) ;
    public final void rule__State__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3825:1: ( ( 'begin' ) )
            // InternalXUmlb.g:3826:1: ( 'begin' )
            {
            // InternalXUmlb.g:3826:1: ( 'begin' )
            // InternalXUmlb.g:3827:2: 'begin'
            {
             before(grammarAccess.getStateAccess().getBeginKeyword_4_1()); 
            match(input,135,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getBeginKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_4__1__Impl"


    // $ANTLR start "rule__State__Group_4__2"
    // InternalXUmlb.g:3836:1: rule__State__Group_4__2 : rule__State__Group_4__2__Impl rule__State__Group_4__3 ;
    public final void rule__State__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3840:1: ( rule__State__Group_4__2__Impl rule__State__Group_4__3 )
            // InternalXUmlb.g:3841:2: rule__State__Group_4__2__Impl rule__State__Group_4__3
            {
            pushFollow(FOLLOW_34);
            rule__State__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_4__2"


    // $ANTLR start "rule__State__Group_4__2__Impl"
    // InternalXUmlb.g:3848:1: rule__State__Group_4__2__Impl : ( ( rule__State__StatemachinesAssignment_4_2 ) ) ;
    public final void rule__State__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3852:1: ( ( ( rule__State__StatemachinesAssignment_4_2 ) ) )
            // InternalXUmlb.g:3853:1: ( ( rule__State__StatemachinesAssignment_4_2 ) )
            {
            // InternalXUmlb.g:3853:1: ( ( rule__State__StatemachinesAssignment_4_2 ) )
            // InternalXUmlb.g:3854:2: ( rule__State__StatemachinesAssignment_4_2 )
            {
             before(grammarAccess.getStateAccess().getStatemachinesAssignment_4_2()); 
            // InternalXUmlb.g:3855:2: ( rule__State__StatemachinesAssignment_4_2 )
            // InternalXUmlb.g:3855:3: rule__State__StatemachinesAssignment_4_2
            {
            pushFollow(FOLLOW_2);
            rule__State__StatemachinesAssignment_4_2();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getStatemachinesAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_4__2__Impl"


    // $ANTLR start "rule__State__Group_4__3"
    // InternalXUmlb.g:3863:1: rule__State__Group_4__3 : rule__State__Group_4__3__Impl rule__State__Group_4__4 ;
    public final void rule__State__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3867:1: ( rule__State__Group_4__3__Impl rule__State__Group_4__4 )
            // InternalXUmlb.g:3868:2: rule__State__Group_4__3__Impl rule__State__Group_4__4
            {
            pushFollow(FOLLOW_34);
            rule__State__Group_4__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_4__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_4__3"


    // $ANTLR start "rule__State__Group_4__3__Impl"
    // InternalXUmlb.g:3875:1: rule__State__Group_4__3__Impl : ( ( rule__State__StatemachinesAssignment_4_3 )* ) ;
    public final void rule__State__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3879:1: ( ( ( rule__State__StatemachinesAssignment_4_3 )* ) )
            // InternalXUmlb.g:3880:1: ( ( rule__State__StatemachinesAssignment_4_3 )* )
            {
            // InternalXUmlb.g:3880:1: ( ( rule__State__StatemachinesAssignment_4_3 )* )
            // InternalXUmlb.g:3881:2: ( rule__State__StatemachinesAssignment_4_3 )*
            {
             before(grammarAccess.getStateAccess().getStatemachinesAssignment_4_3()); 
            // InternalXUmlb.g:3882:2: ( rule__State__StatemachinesAssignment_4_3 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==122) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalXUmlb.g:3882:3: rule__State__StatemachinesAssignment_4_3
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__State__StatemachinesAssignment_4_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getStateAccess().getStatemachinesAssignment_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_4__3__Impl"


    // $ANTLR start "rule__State__Group_4__4"
    // InternalXUmlb.g:3890:1: rule__State__Group_4__4 : rule__State__Group_4__4__Impl ;
    public final void rule__State__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3894:1: ( rule__State__Group_4__4__Impl )
            // InternalXUmlb.g:3895:2: rule__State__Group_4__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group_4__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_4__4"


    // $ANTLR start "rule__State__Group_4__4__Impl"
    // InternalXUmlb.g:3901:1: rule__State__Group_4__4__Impl : ( 'end' ) ;
    public final void rule__State__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3905:1: ( ( 'end' ) )
            // InternalXUmlb.g:3906:1: ( 'end' )
            {
            // InternalXUmlb.g:3906:1: ( 'end' )
            // InternalXUmlb.g:3907:2: 'end'
            {
             before(grammarAccess.getStateAccess().getEndKeyword_4_4()); 
            match(input,123,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getEndKeyword_4_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_4__4__Impl"


    // $ANTLR start "rule__State__Group_5__0"
    // InternalXUmlb.g:3917:1: rule__State__Group_5__0 : rule__State__Group_5__0__Impl rule__State__Group_5__1 ;
    public final void rule__State__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3921:1: ( rule__State__Group_5__0__Impl rule__State__Group_5__1 )
            // InternalXUmlb.g:3922:2: rule__State__Group_5__0__Impl rule__State__Group_5__1
            {
            pushFollow(FOLLOW_23);
            rule__State__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_5__0"


    // $ANTLR start "rule__State__Group_5__0__Impl"
    // InternalXUmlb.g:3929:1: rule__State__Group_5__0__Impl : ( 'invariants' ) ;
    public final void rule__State__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3933:1: ( ( 'invariants' ) )
            // InternalXUmlb.g:3934:1: ( 'invariants' )
            {
            // InternalXUmlb.g:3934:1: ( 'invariants' )
            // InternalXUmlb.g:3935:2: 'invariants'
            {
             before(grammarAccess.getStateAccess().getInvariantsKeyword_5_0()); 
            match(input,136,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getInvariantsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_5__0__Impl"


    // $ANTLR start "rule__State__Group_5__1"
    // InternalXUmlb.g:3944:1: rule__State__Group_5__1 : rule__State__Group_5__1__Impl ;
    public final void rule__State__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3948:1: ( rule__State__Group_5__1__Impl )
            // InternalXUmlb.g:3949:2: rule__State__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_5__1"


    // $ANTLR start "rule__State__Group_5__1__Impl"
    // InternalXUmlb.g:3955:1: rule__State__Group_5__1__Impl : ( ( ( rule__State__InvariantsAssignment_5_1 ) ) ( ( rule__State__InvariantsAssignment_5_1 )* ) ) ;
    public final void rule__State__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3959:1: ( ( ( ( rule__State__InvariantsAssignment_5_1 ) ) ( ( rule__State__InvariantsAssignment_5_1 )* ) ) )
            // InternalXUmlb.g:3960:1: ( ( ( rule__State__InvariantsAssignment_5_1 ) ) ( ( rule__State__InvariantsAssignment_5_1 )* ) )
            {
            // InternalXUmlb.g:3960:1: ( ( ( rule__State__InvariantsAssignment_5_1 ) ) ( ( rule__State__InvariantsAssignment_5_1 )* ) )
            // InternalXUmlb.g:3961:2: ( ( rule__State__InvariantsAssignment_5_1 ) ) ( ( rule__State__InvariantsAssignment_5_1 )* )
            {
            // InternalXUmlb.g:3961:2: ( ( rule__State__InvariantsAssignment_5_1 ) )
            // InternalXUmlb.g:3962:3: ( rule__State__InvariantsAssignment_5_1 )
            {
             before(grammarAccess.getStateAccess().getInvariantsAssignment_5_1()); 
            // InternalXUmlb.g:3963:3: ( rule__State__InvariantsAssignment_5_1 )
            // InternalXUmlb.g:3963:4: rule__State__InvariantsAssignment_5_1
            {
            pushFollow(FOLLOW_24);
            rule__State__InvariantsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getInvariantsAssignment_5_1()); 

            }

            // InternalXUmlb.g:3966:2: ( ( rule__State__InvariantsAssignment_5_1 )* )
            // InternalXUmlb.g:3967:3: ( rule__State__InvariantsAssignment_5_1 )*
            {
             before(grammarAccess.getStateAccess().getInvariantsAssignment_5_1()); 
            // InternalXUmlb.g:3968:3: ( rule__State__InvariantsAssignment_5_1 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_XLABEL||LA39_0==164) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalXUmlb.g:3968:4: rule__State__InvariantsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__State__InvariantsAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getStateAccess().getInvariantsAssignment_5_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_5__1__Impl"


    // $ANTLR start "rule__State__Group_6__0"
    // InternalXUmlb.g:3978:1: rule__State__Group_6__0 : rule__State__Group_6__0__Impl rule__State__Group_6__1 ;
    public final void rule__State__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3982:1: ( rule__State__Group_6__0__Impl rule__State__Group_6__1 )
            // InternalXUmlb.g:3983:2: rule__State__Group_6__0__Impl rule__State__Group_6__1
            {
            pushFollow(FOLLOW_25);
            rule__State__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_6__0"


    // $ANTLR start "rule__State__Group_6__0__Impl"
    // InternalXUmlb.g:3990:1: rule__State__Group_6__0__Impl : ( 'entryActions' ) ;
    public final void rule__State__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:3994:1: ( ( 'entryActions' ) )
            // InternalXUmlb.g:3995:1: ( 'entryActions' )
            {
            // InternalXUmlb.g:3995:1: ( 'entryActions' )
            // InternalXUmlb.g:3996:2: 'entryActions'
            {
             before(grammarAccess.getStateAccess().getEntryActionsKeyword_6_0()); 
            match(input,137,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getEntryActionsKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_6__0__Impl"


    // $ANTLR start "rule__State__Group_6__1"
    // InternalXUmlb.g:4005:1: rule__State__Group_6__1 : rule__State__Group_6__1__Impl ;
    public final void rule__State__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4009:1: ( rule__State__Group_6__1__Impl )
            // InternalXUmlb.g:4010:2: rule__State__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_6__1"


    // $ANTLR start "rule__State__Group_6__1__Impl"
    // InternalXUmlb.g:4016:1: rule__State__Group_6__1__Impl : ( ( ( rule__State__EntryActionsAssignment_6_1 ) ) ( ( rule__State__EntryActionsAssignment_6_1 )* ) ) ;
    public final void rule__State__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4020:1: ( ( ( ( rule__State__EntryActionsAssignment_6_1 ) ) ( ( rule__State__EntryActionsAssignment_6_1 )* ) ) )
            // InternalXUmlb.g:4021:1: ( ( ( rule__State__EntryActionsAssignment_6_1 ) ) ( ( rule__State__EntryActionsAssignment_6_1 )* ) )
            {
            // InternalXUmlb.g:4021:1: ( ( ( rule__State__EntryActionsAssignment_6_1 ) ) ( ( rule__State__EntryActionsAssignment_6_1 )* ) )
            // InternalXUmlb.g:4022:2: ( ( rule__State__EntryActionsAssignment_6_1 ) ) ( ( rule__State__EntryActionsAssignment_6_1 )* )
            {
            // InternalXUmlb.g:4022:2: ( ( rule__State__EntryActionsAssignment_6_1 ) )
            // InternalXUmlb.g:4023:3: ( rule__State__EntryActionsAssignment_6_1 )
            {
             before(grammarAccess.getStateAccess().getEntryActionsAssignment_6_1()); 
            // InternalXUmlb.g:4024:3: ( rule__State__EntryActionsAssignment_6_1 )
            // InternalXUmlb.g:4024:4: rule__State__EntryActionsAssignment_6_1
            {
            pushFollow(FOLLOW_26);
            rule__State__EntryActionsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getEntryActionsAssignment_6_1()); 

            }

            // InternalXUmlb.g:4027:2: ( ( rule__State__EntryActionsAssignment_6_1 )* )
            // InternalXUmlb.g:4028:3: ( rule__State__EntryActionsAssignment_6_1 )*
            {
             before(grammarAccess.getStateAccess().getEntryActionsAssignment_6_1()); 
            // InternalXUmlb.g:4029:3: ( rule__State__EntryActionsAssignment_6_1 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_XLABEL) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalXUmlb.g:4029:4: rule__State__EntryActionsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__State__EntryActionsAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getStateAccess().getEntryActionsAssignment_6_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_6__1__Impl"


    // $ANTLR start "rule__State__Group_7__0"
    // InternalXUmlb.g:4039:1: rule__State__Group_7__0 : rule__State__Group_7__0__Impl rule__State__Group_7__1 ;
    public final void rule__State__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4043:1: ( rule__State__Group_7__0__Impl rule__State__Group_7__1 )
            // InternalXUmlb.g:4044:2: rule__State__Group_7__0__Impl rule__State__Group_7__1
            {
            pushFollow(FOLLOW_25);
            rule__State__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_7__0"


    // $ANTLR start "rule__State__Group_7__0__Impl"
    // InternalXUmlb.g:4051:1: rule__State__Group_7__0__Impl : ( 'exitActions' ) ;
    public final void rule__State__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4055:1: ( ( 'exitActions' ) )
            // InternalXUmlb.g:4056:1: ( 'exitActions' )
            {
            // InternalXUmlb.g:4056:1: ( 'exitActions' )
            // InternalXUmlb.g:4057:2: 'exitActions'
            {
             before(grammarAccess.getStateAccess().getExitActionsKeyword_7_0()); 
            match(input,138,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getExitActionsKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_7__0__Impl"


    // $ANTLR start "rule__State__Group_7__1"
    // InternalXUmlb.g:4066:1: rule__State__Group_7__1 : rule__State__Group_7__1__Impl ;
    public final void rule__State__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4070:1: ( rule__State__Group_7__1__Impl )
            // InternalXUmlb.g:4071:2: rule__State__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_7__1"


    // $ANTLR start "rule__State__Group_7__1__Impl"
    // InternalXUmlb.g:4077:1: rule__State__Group_7__1__Impl : ( ( ( rule__State__ExitActionsAssignment_7_1 ) ) ( ( rule__State__ExitActionsAssignment_7_1 )* ) ) ;
    public final void rule__State__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4081:1: ( ( ( ( rule__State__ExitActionsAssignment_7_1 ) ) ( ( rule__State__ExitActionsAssignment_7_1 )* ) ) )
            // InternalXUmlb.g:4082:1: ( ( ( rule__State__ExitActionsAssignment_7_1 ) ) ( ( rule__State__ExitActionsAssignment_7_1 )* ) )
            {
            // InternalXUmlb.g:4082:1: ( ( ( rule__State__ExitActionsAssignment_7_1 ) ) ( ( rule__State__ExitActionsAssignment_7_1 )* ) )
            // InternalXUmlb.g:4083:2: ( ( rule__State__ExitActionsAssignment_7_1 ) ) ( ( rule__State__ExitActionsAssignment_7_1 )* )
            {
            // InternalXUmlb.g:4083:2: ( ( rule__State__ExitActionsAssignment_7_1 ) )
            // InternalXUmlb.g:4084:3: ( rule__State__ExitActionsAssignment_7_1 )
            {
             before(grammarAccess.getStateAccess().getExitActionsAssignment_7_1()); 
            // InternalXUmlb.g:4085:3: ( rule__State__ExitActionsAssignment_7_1 )
            // InternalXUmlb.g:4085:4: rule__State__ExitActionsAssignment_7_1
            {
            pushFollow(FOLLOW_26);
            rule__State__ExitActionsAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getExitActionsAssignment_7_1()); 

            }

            // InternalXUmlb.g:4088:2: ( ( rule__State__ExitActionsAssignment_7_1 )* )
            // InternalXUmlb.g:4089:3: ( rule__State__ExitActionsAssignment_7_1 )*
            {
             before(grammarAccess.getStateAccess().getExitActionsAssignment_7_1()); 
            // InternalXUmlb.g:4090:3: ( rule__State__ExitActionsAssignment_7_1 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_XLABEL) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalXUmlb.g:4090:4: rule__State__ExitActionsAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__State__ExitActionsAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getStateAccess().getExitActionsAssignment_7_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_7__1__Impl"


    // $ANTLR start "rule__Initial__Group__0"
    // InternalXUmlb.g:4100:1: rule__Initial__Group__0 : rule__Initial__Group__0__Impl rule__Initial__Group__1 ;
    public final void rule__Initial__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4104:1: ( rule__Initial__Group__0__Impl rule__Initial__Group__1 )
            // InternalXUmlb.g:4105:2: rule__Initial__Group__0__Impl rule__Initial__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Initial__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Initial__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Initial__Group__0"


    // $ANTLR start "rule__Initial__Group__0__Impl"
    // InternalXUmlb.g:4112:1: rule__Initial__Group__0__Impl : ( 'initial' ) ;
    public final void rule__Initial__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4116:1: ( ( 'initial' ) )
            // InternalXUmlb.g:4117:1: ( 'initial' )
            {
            // InternalXUmlb.g:4117:1: ( 'initial' )
            // InternalXUmlb.g:4118:2: 'initial'
            {
             before(grammarAccess.getInitialAccess().getInitialKeyword_0()); 
            match(input,139,FOLLOW_2); 
             after(grammarAccess.getInitialAccess().getInitialKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Initial__Group__0__Impl"


    // $ANTLR start "rule__Initial__Group__1"
    // InternalXUmlb.g:4127:1: rule__Initial__Group__1 : rule__Initial__Group__1__Impl ;
    public final void rule__Initial__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4131:1: ( rule__Initial__Group__1__Impl )
            // InternalXUmlb.g:4132:2: rule__Initial__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Initial__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Initial__Group__1"


    // $ANTLR start "rule__Initial__Group__1__Impl"
    // InternalXUmlb.g:4138:1: rule__Initial__Group__1__Impl : ( ( rule__Initial__NameAssignment_1 ) ) ;
    public final void rule__Initial__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4142:1: ( ( ( rule__Initial__NameAssignment_1 ) ) )
            // InternalXUmlb.g:4143:1: ( ( rule__Initial__NameAssignment_1 ) )
            {
            // InternalXUmlb.g:4143:1: ( ( rule__Initial__NameAssignment_1 ) )
            // InternalXUmlb.g:4144:2: ( rule__Initial__NameAssignment_1 )
            {
             before(grammarAccess.getInitialAccess().getNameAssignment_1()); 
            // InternalXUmlb.g:4145:2: ( rule__Initial__NameAssignment_1 )
            // InternalXUmlb.g:4145:3: rule__Initial__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Initial__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getInitialAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Initial__Group__1__Impl"


    // $ANTLR start "rule__Final__Group__0"
    // InternalXUmlb.g:4154:1: rule__Final__Group__0 : rule__Final__Group__0__Impl rule__Final__Group__1 ;
    public final void rule__Final__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4158:1: ( rule__Final__Group__0__Impl rule__Final__Group__1 )
            // InternalXUmlb.g:4159:2: rule__Final__Group__0__Impl rule__Final__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Final__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Final__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Final__Group__0"


    // $ANTLR start "rule__Final__Group__0__Impl"
    // InternalXUmlb.g:4166:1: rule__Final__Group__0__Impl : ( 'final' ) ;
    public final void rule__Final__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4170:1: ( ( 'final' ) )
            // InternalXUmlb.g:4171:1: ( 'final' )
            {
            // InternalXUmlb.g:4171:1: ( 'final' )
            // InternalXUmlb.g:4172:2: 'final'
            {
             before(grammarAccess.getFinalAccess().getFinalKeyword_0()); 
            match(input,140,FOLLOW_2); 
             after(grammarAccess.getFinalAccess().getFinalKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Final__Group__0__Impl"


    // $ANTLR start "rule__Final__Group__1"
    // InternalXUmlb.g:4181:1: rule__Final__Group__1 : rule__Final__Group__1__Impl ;
    public final void rule__Final__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4185:1: ( rule__Final__Group__1__Impl )
            // InternalXUmlb.g:4186:2: rule__Final__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Final__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Final__Group__1"


    // $ANTLR start "rule__Final__Group__1__Impl"
    // InternalXUmlb.g:4192:1: rule__Final__Group__1__Impl : ( ( rule__Final__NameAssignment_1 ) ) ;
    public final void rule__Final__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4196:1: ( ( ( rule__Final__NameAssignment_1 ) ) )
            // InternalXUmlb.g:4197:1: ( ( rule__Final__NameAssignment_1 ) )
            {
            // InternalXUmlb.g:4197:1: ( ( rule__Final__NameAssignment_1 ) )
            // InternalXUmlb.g:4198:2: ( rule__Final__NameAssignment_1 )
            {
             before(grammarAccess.getFinalAccess().getNameAssignment_1()); 
            // InternalXUmlb.g:4199:2: ( rule__Final__NameAssignment_1 )
            // InternalXUmlb.g:4199:3: rule__Final__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Final__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFinalAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Final__Group__1__Impl"


    // $ANTLR start "rule__Any__Group__0"
    // InternalXUmlb.g:4208:1: rule__Any__Group__0 : rule__Any__Group__0__Impl rule__Any__Group__1 ;
    public final void rule__Any__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4212:1: ( rule__Any__Group__0__Impl rule__Any__Group__1 )
            // InternalXUmlb.g:4213:2: rule__Any__Group__0__Impl rule__Any__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Any__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Any__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Any__Group__0"


    // $ANTLR start "rule__Any__Group__0__Impl"
    // InternalXUmlb.g:4220:1: rule__Any__Group__0__Impl : ( 'any' ) ;
    public final void rule__Any__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4224:1: ( ( 'any' ) )
            // InternalXUmlb.g:4225:1: ( 'any' )
            {
            // InternalXUmlb.g:4225:1: ( 'any' )
            // InternalXUmlb.g:4226:2: 'any'
            {
             before(grammarAccess.getAnyAccess().getAnyKeyword_0()); 
            match(input,129,FOLLOW_2); 
             after(grammarAccess.getAnyAccess().getAnyKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Any__Group__0__Impl"


    // $ANTLR start "rule__Any__Group__1"
    // InternalXUmlb.g:4235:1: rule__Any__Group__1 : rule__Any__Group__1__Impl ;
    public final void rule__Any__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4239:1: ( rule__Any__Group__1__Impl )
            // InternalXUmlb.g:4240:2: rule__Any__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Any__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Any__Group__1"


    // $ANTLR start "rule__Any__Group__1__Impl"
    // InternalXUmlb.g:4246:1: rule__Any__Group__1__Impl : ( ( rule__Any__NameAssignment_1 ) ) ;
    public final void rule__Any__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4250:1: ( ( ( rule__Any__NameAssignment_1 ) ) )
            // InternalXUmlb.g:4251:1: ( ( rule__Any__NameAssignment_1 ) )
            {
            // InternalXUmlb.g:4251:1: ( ( rule__Any__NameAssignment_1 ) )
            // InternalXUmlb.g:4252:2: ( rule__Any__NameAssignment_1 )
            {
             before(grammarAccess.getAnyAccess().getNameAssignment_1()); 
            // InternalXUmlb.g:4253:2: ( rule__Any__NameAssignment_1 )
            // InternalXUmlb.g:4253:3: rule__Any__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Any__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAnyAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Any__Group__1__Impl"


    // $ANTLR start "rule__Junction__Group__0"
    // InternalXUmlb.g:4262:1: rule__Junction__Group__0 : rule__Junction__Group__0__Impl rule__Junction__Group__1 ;
    public final void rule__Junction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4266:1: ( rule__Junction__Group__0__Impl rule__Junction__Group__1 )
            // InternalXUmlb.g:4267:2: rule__Junction__Group__0__Impl rule__Junction__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Junction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Junction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group__0"


    // $ANTLR start "rule__Junction__Group__0__Impl"
    // InternalXUmlb.g:4274:1: rule__Junction__Group__0__Impl : ( 'junction' ) ;
    public final void rule__Junction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4278:1: ( ( 'junction' ) )
            // InternalXUmlb.g:4279:1: ( 'junction' )
            {
            // InternalXUmlb.g:4279:1: ( 'junction' )
            // InternalXUmlb.g:4280:2: 'junction'
            {
             before(grammarAccess.getJunctionAccess().getJunctionKeyword_0()); 
            match(input,141,FOLLOW_2); 
             after(grammarAccess.getJunctionAccess().getJunctionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group__0__Impl"


    // $ANTLR start "rule__Junction__Group__1"
    // InternalXUmlb.g:4289:1: rule__Junction__Group__1 : rule__Junction__Group__1__Impl ;
    public final void rule__Junction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4293:1: ( rule__Junction__Group__1__Impl )
            // InternalXUmlb.g:4294:2: rule__Junction__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Junction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group__1"


    // $ANTLR start "rule__Junction__Group__1__Impl"
    // InternalXUmlb.g:4300:1: rule__Junction__Group__1__Impl : ( ( rule__Junction__NameAssignment_1 ) ) ;
    public final void rule__Junction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4304:1: ( ( ( rule__Junction__NameAssignment_1 ) ) )
            // InternalXUmlb.g:4305:1: ( ( rule__Junction__NameAssignment_1 ) )
            {
            // InternalXUmlb.g:4305:1: ( ( rule__Junction__NameAssignment_1 ) )
            // InternalXUmlb.g:4306:2: ( rule__Junction__NameAssignment_1 )
            {
             before(grammarAccess.getJunctionAccess().getNameAssignment_1()); 
            // InternalXUmlb.g:4307:2: ( rule__Junction__NameAssignment_1 )
            // InternalXUmlb.g:4307:3: rule__Junction__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Junction__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJunctionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group__1__Impl"


    // $ANTLR start "rule__Fork__Group__0"
    // InternalXUmlb.g:4316:1: rule__Fork__Group__0 : rule__Fork__Group__0__Impl rule__Fork__Group__1 ;
    public final void rule__Fork__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4320:1: ( rule__Fork__Group__0__Impl rule__Fork__Group__1 )
            // InternalXUmlb.g:4321:2: rule__Fork__Group__0__Impl rule__Fork__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Fork__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Fork__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fork__Group__0"


    // $ANTLR start "rule__Fork__Group__0__Impl"
    // InternalXUmlb.g:4328:1: rule__Fork__Group__0__Impl : ( 'fork' ) ;
    public final void rule__Fork__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4332:1: ( ( 'fork' ) )
            // InternalXUmlb.g:4333:1: ( 'fork' )
            {
            // InternalXUmlb.g:4333:1: ( 'fork' )
            // InternalXUmlb.g:4334:2: 'fork'
            {
             before(grammarAccess.getForkAccess().getForkKeyword_0()); 
            match(input,142,FOLLOW_2); 
             after(grammarAccess.getForkAccess().getForkKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fork__Group__0__Impl"


    // $ANTLR start "rule__Fork__Group__1"
    // InternalXUmlb.g:4343:1: rule__Fork__Group__1 : rule__Fork__Group__1__Impl ;
    public final void rule__Fork__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4347:1: ( rule__Fork__Group__1__Impl )
            // InternalXUmlb.g:4348:2: rule__Fork__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Fork__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fork__Group__1"


    // $ANTLR start "rule__Fork__Group__1__Impl"
    // InternalXUmlb.g:4354:1: rule__Fork__Group__1__Impl : ( ( rule__Fork__NameAssignment_1 ) ) ;
    public final void rule__Fork__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4358:1: ( ( ( rule__Fork__NameAssignment_1 ) ) )
            // InternalXUmlb.g:4359:1: ( ( rule__Fork__NameAssignment_1 ) )
            {
            // InternalXUmlb.g:4359:1: ( ( rule__Fork__NameAssignment_1 ) )
            // InternalXUmlb.g:4360:2: ( rule__Fork__NameAssignment_1 )
            {
             before(grammarAccess.getForkAccess().getNameAssignment_1()); 
            // InternalXUmlb.g:4361:2: ( rule__Fork__NameAssignment_1 )
            // InternalXUmlb.g:4361:3: rule__Fork__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Fork__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getForkAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fork__Group__1__Impl"


    // $ANTLR start "rule__Classdiagram__Group__0"
    // InternalXUmlb.g:4370:1: rule__Classdiagram__Group__0 : rule__Classdiagram__Group__0__Impl rule__Classdiagram__Group__1 ;
    public final void rule__Classdiagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4374:1: ( rule__Classdiagram__Group__0__Impl rule__Classdiagram__Group__1 )
            // InternalXUmlb.g:4375:2: rule__Classdiagram__Group__0__Impl rule__Classdiagram__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__Classdiagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Classdiagram__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__0"


    // $ANTLR start "rule__Classdiagram__Group__0__Impl"
    // InternalXUmlb.g:4382:1: rule__Classdiagram__Group__0__Impl : ( () ) ;
    public final void rule__Classdiagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4386:1: ( ( () ) )
            // InternalXUmlb.g:4387:1: ( () )
            {
            // InternalXUmlb.g:4387:1: ( () )
            // InternalXUmlb.g:4388:2: ()
            {
             before(grammarAccess.getClassdiagramAccess().getClassdiagramAction_0()); 
            // InternalXUmlb.g:4389:2: ()
            // InternalXUmlb.g:4389:3: 
            {
            }

             after(grammarAccess.getClassdiagramAccess().getClassdiagramAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__0__Impl"


    // $ANTLR start "rule__Classdiagram__Group__1"
    // InternalXUmlb.g:4397:1: rule__Classdiagram__Group__1 : rule__Classdiagram__Group__1__Impl rule__Classdiagram__Group__2 ;
    public final void rule__Classdiagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4401:1: ( rule__Classdiagram__Group__1__Impl rule__Classdiagram__Group__2 )
            // InternalXUmlb.g:4402:2: rule__Classdiagram__Group__1__Impl rule__Classdiagram__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Classdiagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Classdiagram__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__1"


    // $ANTLR start "rule__Classdiagram__Group__1__Impl"
    // InternalXUmlb.g:4409:1: rule__Classdiagram__Group__1__Impl : ( 'classdiagram' ) ;
    public final void rule__Classdiagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4413:1: ( ( 'classdiagram' ) )
            // InternalXUmlb.g:4414:1: ( 'classdiagram' )
            {
            // InternalXUmlb.g:4414:1: ( 'classdiagram' )
            // InternalXUmlb.g:4415:2: 'classdiagram'
            {
             before(grammarAccess.getClassdiagramAccess().getClassdiagramKeyword_1()); 
            match(input,143,FOLLOW_2); 
             after(grammarAccess.getClassdiagramAccess().getClassdiagramKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__1__Impl"


    // $ANTLR start "rule__Classdiagram__Group__2"
    // InternalXUmlb.g:4424:1: rule__Classdiagram__Group__2 : rule__Classdiagram__Group__2__Impl rule__Classdiagram__Group__3 ;
    public final void rule__Classdiagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4428:1: ( rule__Classdiagram__Group__2__Impl rule__Classdiagram__Group__3 )
            // InternalXUmlb.g:4429:2: rule__Classdiagram__Group__2__Impl rule__Classdiagram__Group__3
            {
            pushFollow(FOLLOW_37);
            rule__Classdiagram__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Classdiagram__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__2"


    // $ANTLR start "rule__Classdiagram__Group__2__Impl"
    // InternalXUmlb.g:4436:1: rule__Classdiagram__Group__2__Impl : ( ( rule__Classdiagram__NameAssignment_2 ) ) ;
    public final void rule__Classdiagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4440:1: ( ( ( rule__Classdiagram__NameAssignment_2 ) ) )
            // InternalXUmlb.g:4441:1: ( ( rule__Classdiagram__NameAssignment_2 ) )
            {
            // InternalXUmlb.g:4441:1: ( ( rule__Classdiagram__NameAssignment_2 ) )
            // InternalXUmlb.g:4442:2: ( rule__Classdiagram__NameAssignment_2 )
            {
             before(grammarAccess.getClassdiagramAccess().getNameAssignment_2()); 
            // InternalXUmlb.g:4443:2: ( rule__Classdiagram__NameAssignment_2 )
            // InternalXUmlb.g:4443:3: rule__Classdiagram__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Classdiagram__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getClassdiagramAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__2__Impl"


    // $ANTLR start "rule__Classdiagram__Group__3"
    // InternalXUmlb.g:4451:1: rule__Classdiagram__Group__3 : rule__Classdiagram__Group__3__Impl rule__Classdiagram__Group__4 ;
    public final void rule__Classdiagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4455:1: ( rule__Classdiagram__Group__3__Impl rule__Classdiagram__Group__4 )
            // InternalXUmlb.g:4456:2: rule__Classdiagram__Group__3__Impl rule__Classdiagram__Group__4
            {
            pushFollow(FOLLOW_37);
            rule__Classdiagram__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Classdiagram__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__3"


    // $ANTLR start "rule__Classdiagram__Group__3__Impl"
    // InternalXUmlb.g:4463:1: rule__Classdiagram__Group__3__Impl : ( ( rule__Classdiagram__Group_3__0 )? ) ;
    public final void rule__Classdiagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4467:1: ( ( ( rule__Classdiagram__Group_3__0 )? ) )
            // InternalXUmlb.g:4468:1: ( ( rule__Classdiagram__Group_3__0 )? )
            {
            // InternalXUmlb.g:4468:1: ( ( rule__Classdiagram__Group_3__0 )? )
            // InternalXUmlb.g:4469:2: ( rule__Classdiagram__Group_3__0 )?
            {
             before(grammarAccess.getClassdiagramAccess().getGroup_3()); 
            // InternalXUmlb.g:4470:2: ( rule__Classdiagram__Group_3__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==121) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalXUmlb.g:4470:3: rule__Classdiagram__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Classdiagram__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassdiagramAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__3__Impl"


    // $ANTLR start "rule__Classdiagram__Group__4"
    // InternalXUmlb.g:4478:1: rule__Classdiagram__Group__4 : rule__Classdiagram__Group__4__Impl rule__Classdiagram__Group__5 ;
    public final void rule__Classdiagram__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4482:1: ( rule__Classdiagram__Group__4__Impl rule__Classdiagram__Group__5 )
            // InternalXUmlb.g:4483:2: rule__Classdiagram__Group__4__Impl rule__Classdiagram__Group__5
            {
            pushFollow(FOLLOW_37);
            rule__Classdiagram__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Classdiagram__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__4"


    // $ANTLR start "rule__Classdiagram__Group__4__Impl"
    // InternalXUmlb.g:4490:1: rule__Classdiagram__Group__4__Impl : ( ( rule__Classdiagram__ClassesAssignment_4 )* ) ;
    public final void rule__Classdiagram__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4494:1: ( ( ( rule__Classdiagram__ClassesAssignment_4 )* ) )
            // InternalXUmlb.g:4495:1: ( ( rule__Classdiagram__ClassesAssignment_4 )* )
            {
            // InternalXUmlb.g:4495:1: ( ( rule__Classdiagram__ClassesAssignment_4 )* )
            // InternalXUmlb.g:4496:2: ( rule__Classdiagram__ClassesAssignment_4 )*
            {
             before(grammarAccess.getClassdiagramAccess().getClassesAssignment_4()); 
            // InternalXUmlb.g:4497:2: ( rule__Classdiagram__ClassesAssignment_4 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==144) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalXUmlb.g:4497:3: rule__Classdiagram__ClassesAssignment_4
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__Classdiagram__ClassesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getClassdiagramAccess().getClassesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__4__Impl"


    // $ANTLR start "rule__Classdiagram__Group__5"
    // InternalXUmlb.g:4505:1: rule__Classdiagram__Group__5 : rule__Classdiagram__Group__5__Impl rule__Classdiagram__Group__6 ;
    public final void rule__Classdiagram__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4509:1: ( rule__Classdiagram__Group__5__Impl rule__Classdiagram__Group__6 )
            // InternalXUmlb.g:4510:2: rule__Classdiagram__Group__5__Impl rule__Classdiagram__Group__6
            {
            pushFollow(FOLLOW_37);
            rule__Classdiagram__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Classdiagram__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__5"


    // $ANTLR start "rule__Classdiagram__Group__5__Impl"
    // InternalXUmlb.g:4517:1: rule__Classdiagram__Group__5__Impl : ( ( rule__Classdiagram__AssociationsAssignment_5 )* ) ;
    public final void rule__Classdiagram__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4521:1: ( ( ( rule__Classdiagram__AssociationsAssignment_5 )* ) )
            // InternalXUmlb.g:4522:1: ( ( rule__Classdiagram__AssociationsAssignment_5 )* )
            {
            // InternalXUmlb.g:4522:1: ( ( rule__Classdiagram__AssociationsAssignment_5 )* )
            // InternalXUmlb.g:4523:2: ( rule__Classdiagram__AssociationsAssignment_5 )*
            {
             before(grammarAccess.getClassdiagramAccess().getAssociationsAssignment_5()); 
            // InternalXUmlb.g:4524:2: ( rule__Classdiagram__AssociationsAssignment_5 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==147) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalXUmlb.g:4524:3: rule__Classdiagram__AssociationsAssignment_5
            	    {
            	    pushFollow(FOLLOW_39);
            	    rule__Classdiagram__AssociationsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getClassdiagramAccess().getAssociationsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__5__Impl"


    // $ANTLR start "rule__Classdiagram__Group__6"
    // InternalXUmlb.g:4532:1: rule__Classdiagram__Group__6 : rule__Classdiagram__Group__6__Impl ;
    public final void rule__Classdiagram__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4536:1: ( rule__Classdiagram__Group__6__Impl )
            // InternalXUmlb.g:4537:2: rule__Classdiagram__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Classdiagram__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__6"


    // $ANTLR start "rule__Classdiagram__Group__6__Impl"
    // InternalXUmlb.g:4543:1: rule__Classdiagram__Group__6__Impl : ( 'end' ) ;
    public final void rule__Classdiagram__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4547:1: ( ( 'end' ) )
            // InternalXUmlb.g:4548:1: ( 'end' )
            {
            // InternalXUmlb.g:4548:1: ( 'end' )
            // InternalXUmlb.g:4549:2: 'end'
            {
             before(grammarAccess.getClassdiagramAccess().getEndKeyword_6()); 
            match(input,123,FOLLOW_2); 
             after(grammarAccess.getClassdiagramAccess().getEndKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group__6__Impl"


    // $ANTLR start "rule__Classdiagram__Group_3__0"
    // InternalXUmlb.g:4559:1: rule__Classdiagram__Group_3__0 : rule__Classdiagram__Group_3__0__Impl rule__Classdiagram__Group_3__1 ;
    public final void rule__Classdiagram__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4563:1: ( rule__Classdiagram__Group_3__0__Impl rule__Classdiagram__Group_3__1 )
            // InternalXUmlb.g:4564:2: rule__Classdiagram__Group_3__0__Impl rule__Classdiagram__Group_3__1
            {
            pushFollow(FOLLOW_4);
            rule__Classdiagram__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Classdiagram__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group_3__0"


    // $ANTLR start "rule__Classdiagram__Group_3__0__Impl"
    // InternalXUmlb.g:4571:1: rule__Classdiagram__Group_3__0__Impl : ( 'refines' ) ;
    public final void rule__Classdiagram__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4575:1: ( ( 'refines' ) )
            // InternalXUmlb.g:4576:1: ( 'refines' )
            {
            // InternalXUmlb.g:4576:1: ( 'refines' )
            // InternalXUmlb.g:4577:2: 'refines'
            {
             before(grammarAccess.getClassdiagramAccess().getRefinesKeyword_3_0()); 
            match(input,121,FOLLOW_2); 
             after(grammarAccess.getClassdiagramAccess().getRefinesKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group_3__0__Impl"


    // $ANTLR start "rule__Classdiagram__Group_3__1"
    // InternalXUmlb.g:4586:1: rule__Classdiagram__Group_3__1 : rule__Classdiagram__Group_3__1__Impl ;
    public final void rule__Classdiagram__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4590:1: ( rule__Classdiagram__Group_3__1__Impl )
            // InternalXUmlb.g:4591:2: rule__Classdiagram__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Classdiagram__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group_3__1"


    // $ANTLR start "rule__Classdiagram__Group_3__1__Impl"
    // InternalXUmlb.g:4597:1: rule__Classdiagram__Group_3__1__Impl : ( ( rule__Classdiagram__RefinesAssignment_3_1 ) ) ;
    public final void rule__Classdiagram__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4601:1: ( ( ( rule__Classdiagram__RefinesAssignment_3_1 ) ) )
            // InternalXUmlb.g:4602:1: ( ( rule__Classdiagram__RefinesAssignment_3_1 ) )
            {
            // InternalXUmlb.g:4602:1: ( ( rule__Classdiagram__RefinesAssignment_3_1 ) )
            // InternalXUmlb.g:4603:2: ( rule__Classdiagram__RefinesAssignment_3_1 )
            {
             before(grammarAccess.getClassdiagramAccess().getRefinesAssignment_3_1()); 
            // InternalXUmlb.g:4604:2: ( rule__Classdiagram__RefinesAssignment_3_1 )
            // InternalXUmlb.g:4604:3: rule__Classdiagram__RefinesAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Classdiagram__RefinesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getClassdiagramAccess().getRefinesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__Group_3__1__Impl"


    // $ANTLR start "rule__Class__Group__0"
    // InternalXUmlb.g:4613:1: rule__Class__Group__0 : rule__Class__Group__0__Impl rule__Class__Group__1 ;
    public final void rule__Class__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4617:1: ( rule__Class__Group__0__Impl rule__Class__Group__1 )
            // InternalXUmlb.g:4618:2: rule__Class__Group__0__Impl rule__Class__Group__1
            {
            pushFollow(FOLLOW_40);
            rule__Class__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__0"


    // $ANTLR start "rule__Class__Group__0__Impl"
    // InternalXUmlb.g:4625:1: rule__Class__Group__0__Impl : ( () ) ;
    public final void rule__Class__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4629:1: ( ( () ) )
            // InternalXUmlb.g:4630:1: ( () )
            {
            // InternalXUmlb.g:4630:1: ( () )
            // InternalXUmlb.g:4631:2: ()
            {
             before(grammarAccess.getClassAccess().getClassAction_0()); 
            // InternalXUmlb.g:4632:2: ()
            // InternalXUmlb.g:4632:3: 
            {
            }

             after(grammarAccess.getClassAccess().getClassAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__0__Impl"


    // $ANTLR start "rule__Class__Group__1"
    // InternalXUmlb.g:4640:1: rule__Class__Group__1 : rule__Class__Group__1__Impl rule__Class__Group__2 ;
    public final void rule__Class__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4644:1: ( rule__Class__Group__1__Impl rule__Class__Group__2 )
            // InternalXUmlb.g:4645:2: rule__Class__Group__1__Impl rule__Class__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Class__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__1"


    // $ANTLR start "rule__Class__Group__1__Impl"
    // InternalXUmlb.g:4652:1: rule__Class__Group__1__Impl : ( 'class' ) ;
    public final void rule__Class__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4656:1: ( ( 'class' ) )
            // InternalXUmlb.g:4657:1: ( 'class' )
            {
            // InternalXUmlb.g:4657:1: ( 'class' )
            // InternalXUmlb.g:4658:2: 'class'
            {
             before(grammarAccess.getClassAccess().getClassKeyword_1()); 
            match(input,144,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__1__Impl"


    // $ANTLR start "rule__Class__Group__2"
    // InternalXUmlb.g:4667:1: rule__Class__Group__2 : rule__Class__Group__2__Impl rule__Class__Group__3 ;
    public final void rule__Class__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4671:1: ( rule__Class__Group__2__Impl rule__Class__Group__3 )
            // InternalXUmlb.g:4672:2: rule__Class__Group__2__Impl rule__Class__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Class__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__2"


    // $ANTLR start "rule__Class__Group__2__Impl"
    // InternalXUmlb.g:4679:1: rule__Class__Group__2__Impl : ( ( rule__Class__NameAssignment_2 ) ) ;
    public final void rule__Class__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4683:1: ( ( ( rule__Class__NameAssignment_2 ) ) )
            // InternalXUmlb.g:4684:1: ( ( rule__Class__NameAssignment_2 ) )
            {
            // InternalXUmlb.g:4684:1: ( ( rule__Class__NameAssignment_2 ) )
            // InternalXUmlb.g:4685:2: ( rule__Class__NameAssignment_2 )
            {
             before(grammarAccess.getClassAccess().getNameAssignment_2()); 
            // InternalXUmlb.g:4686:2: ( rule__Class__NameAssignment_2 )
            // InternalXUmlb.g:4686:3: rule__Class__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Class__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__2__Impl"


    // $ANTLR start "rule__Class__Group__3"
    // InternalXUmlb.g:4694:1: rule__Class__Group__3 : rule__Class__Group__3__Impl rule__Class__Group__4 ;
    public final void rule__Class__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4698:1: ( rule__Class__Group__3__Impl rule__Class__Group__4 )
            // InternalXUmlb.g:4699:2: rule__Class__Group__3__Impl rule__Class__Group__4
            {
            pushFollow(FOLLOW_41);
            rule__Class__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__3"


    // $ANTLR start "rule__Class__Group__3__Impl"
    // InternalXUmlb.g:4706:1: rule__Class__Group__3__Impl : ( '(' ) ;
    public final void rule__Class__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4710:1: ( ( '(' ) )
            // InternalXUmlb.g:4711:1: ( '(' )
            {
            // InternalXUmlb.g:4711:1: ( '(' )
            // InternalXUmlb.g:4712:2: '('
            {
             before(grammarAccess.getClassAccess().getLeftParenthesisKeyword_3()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getLeftParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__3__Impl"


    // $ANTLR start "rule__Class__Group__4"
    // InternalXUmlb.g:4721:1: rule__Class__Group__4 : rule__Class__Group__4__Impl rule__Class__Group__5 ;
    public final void rule__Class__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4725:1: ( rule__Class__Group__4__Impl rule__Class__Group__5 )
            // InternalXUmlb.g:4726:2: rule__Class__Group__4__Impl rule__Class__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__Class__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__4"


    // $ANTLR start "rule__Class__Group__4__Impl"
    // InternalXUmlb.g:4733:1: rule__Class__Group__4__Impl : ( ( rule__Class__DataKindAssignment_4 ) ) ;
    public final void rule__Class__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4737:1: ( ( ( rule__Class__DataKindAssignment_4 ) ) )
            // InternalXUmlb.g:4738:1: ( ( rule__Class__DataKindAssignment_4 ) )
            {
            // InternalXUmlb.g:4738:1: ( ( rule__Class__DataKindAssignment_4 ) )
            // InternalXUmlb.g:4739:2: ( rule__Class__DataKindAssignment_4 )
            {
             before(grammarAccess.getClassAccess().getDataKindAssignment_4()); 
            // InternalXUmlb.g:4740:2: ( rule__Class__DataKindAssignment_4 )
            // InternalXUmlb.g:4740:3: rule__Class__DataKindAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Class__DataKindAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getDataKindAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__4__Impl"


    // $ANTLR start "rule__Class__Group__5"
    // InternalXUmlb.g:4748:1: rule__Class__Group__5 : rule__Class__Group__5__Impl rule__Class__Group__6 ;
    public final void rule__Class__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4752:1: ( rule__Class__Group__5__Impl rule__Class__Group__6 )
            // InternalXUmlb.g:4753:2: rule__Class__Group__5__Impl rule__Class__Group__6
            {
            pushFollow(FOLLOW_42);
            rule__Class__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__5"


    // $ANTLR start "rule__Class__Group__5__Impl"
    // InternalXUmlb.g:4760:1: rule__Class__Group__5__Impl : ( ')' ) ;
    public final void rule__Class__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4764:1: ( ( ')' ) )
            // InternalXUmlb.g:4765:1: ( ')' )
            {
            // InternalXUmlb.g:4765:1: ( ')' )
            // InternalXUmlb.g:4766:2: ')'
            {
             before(grammarAccess.getClassAccess().getRightParenthesisKeyword_5()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__5__Impl"


    // $ANTLR start "rule__Class__Group__6"
    // InternalXUmlb.g:4775:1: rule__Class__Group__6 : rule__Class__Group__6__Impl rule__Class__Group__7 ;
    public final void rule__Class__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4779:1: ( rule__Class__Group__6__Impl rule__Class__Group__7 )
            // InternalXUmlb.g:4780:2: rule__Class__Group__6__Impl rule__Class__Group__7
            {
            pushFollow(FOLLOW_42);
            rule__Class__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__6"


    // $ANTLR start "rule__Class__Group__6__Impl"
    // InternalXUmlb.g:4787:1: rule__Class__Group__6__Impl : ( ( rule__Class__Group_6__0 )? ) ;
    public final void rule__Class__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4791:1: ( ( ( rule__Class__Group_6__0 )? ) )
            // InternalXUmlb.g:4792:1: ( ( rule__Class__Group_6__0 )? )
            {
            // InternalXUmlb.g:4792:1: ( ( rule__Class__Group_6__0 )? )
            // InternalXUmlb.g:4793:2: ( rule__Class__Group_6__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_6()); 
            // InternalXUmlb.g:4794:2: ( rule__Class__Group_6__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==120) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalXUmlb.g:4794:3: rule__Class__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Class__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__6__Impl"


    // $ANTLR start "rule__Class__Group__7"
    // InternalXUmlb.g:4802:1: rule__Class__Group__7 : rule__Class__Group__7__Impl rule__Class__Group__8 ;
    public final void rule__Class__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4806:1: ( rule__Class__Group__7__Impl rule__Class__Group__8 )
            // InternalXUmlb.g:4807:2: rule__Class__Group__7__Impl rule__Class__Group__8
            {
            pushFollow(FOLLOW_42);
            rule__Class__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__7"


    // $ANTLR start "rule__Class__Group__7__Impl"
    // InternalXUmlb.g:4814:1: rule__Class__Group__7__Impl : ( ( rule__Class__Group_7__0 )? ) ;
    public final void rule__Class__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4818:1: ( ( ( rule__Class__Group_7__0 )? ) )
            // InternalXUmlb.g:4819:1: ( ( rule__Class__Group_7__0 )? )
            {
            // InternalXUmlb.g:4819:1: ( ( rule__Class__Group_7__0 )? )
            // InternalXUmlb.g:4820:2: ( rule__Class__Group_7__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_7()); 
            // InternalXUmlb.g:4821:2: ( rule__Class__Group_7__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==125) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalXUmlb.g:4821:3: rule__Class__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Class__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__7__Impl"


    // $ANTLR start "rule__Class__Group__8"
    // InternalXUmlb.g:4829:1: rule__Class__Group__8 : rule__Class__Group__8__Impl rule__Class__Group__9 ;
    public final void rule__Class__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4833:1: ( rule__Class__Group__8__Impl rule__Class__Group__9 )
            // InternalXUmlb.g:4834:2: rule__Class__Group__8__Impl rule__Class__Group__9
            {
            pushFollow(FOLLOW_42);
            rule__Class__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__8"


    // $ANTLR start "rule__Class__Group__8__Impl"
    // InternalXUmlb.g:4841:1: rule__Class__Group__8__Impl : ( ( rule__Class__Group_8__0 )? ) ;
    public final void rule__Class__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4845:1: ( ( ( rule__Class__Group_8__0 )? ) )
            // InternalXUmlb.g:4846:1: ( ( rule__Class__Group_8__0 )? )
            {
            // InternalXUmlb.g:4846:1: ( ( rule__Class__Group_8__0 )? )
            // InternalXUmlb.g:4847:2: ( rule__Class__Group_8__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_8()); 
            // InternalXUmlb.g:4848:2: ( rule__Class__Group_8__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==124) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalXUmlb.g:4848:3: rule__Class__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Class__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__8__Impl"


    // $ANTLR start "rule__Class__Group__9"
    // InternalXUmlb.g:4856:1: rule__Class__Group__9 : rule__Class__Group__9__Impl rule__Class__Group__10 ;
    public final void rule__Class__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4860:1: ( rule__Class__Group__9__Impl rule__Class__Group__10 )
            // InternalXUmlb.g:4861:2: rule__Class__Group__9__Impl rule__Class__Group__10
            {
            pushFollow(FOLLOW_42);
            rule__Class__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__9"


    // $ANTLR start "rule__Class__Group__9__Impl"
    // InternalXUmlb.g:4868:1: rule__Class__Group__9__Impl : ( ( rule__Class__Group_9__0 )? ) ;
    public final void rule__Class__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4872:1: ( ( ( rule__Class__Group_9__0 )? ) )
            // InternalXUmlb.g:4873:1: ( ( rule__Class__Group_9__0 )? )
            {
            // InternalXUmlb.g:4873:1: ( ( rule__Class__Group_9__0 )? )
            // InternalXUmlb.g:4874:2: ( rule__Class__Group_9__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_9()); 
            // InternalXUmlb.g:4875:2: ( rule__Class__Group_9__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==145) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalXUmlb.g:4875:3: rule__Class__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Class__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__9__Impl"


    // $ANTLR start "rule__Class__Group__10"
    // InternalXUmlb.g:4883:1: rule__Class__Group__10 : rule__Class__Group__10__Impl rule__Class__Group__11 ;
    public final void rule__Class__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4887:1: ( rule__Class__Group__10__Impl rule__Class__Group__11 )
            // InternalXUmlb.g:4888:2: rule__Class__Group__10__Impl rule__Class__Group__11
            {
            pushFollow(FOLLOW_42);
            rule__Class__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__10"


    // $ANTLR start "rule__Class__Group__10__Impl"
    // InternalXUmlb.g:4895:1: rule__Class__Group__10__Impl : ( ( rule__Class__Group_10__0 )? ) ;
    public final void rule__Class__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4899:1: ( ( ( rule__Class__Group_10__0 )? ) )
            // InternalXUmlb.g:4900:1: ( ( rule__Class__Group_10__0 )? )
            {
            // InternalXUmlb.g:4900:1: ( ( rule__Class__Group_10__0 )? )
            // InternalXUmlb.g:4901:2: ( rule__Class__Group_10__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_10()); 
            // InternalXUmlb.g:4902:2: ( rule__Class__Group_10__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==121) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalXUmlb.g:4902:3: rule__Class__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Class__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__10__Impl"


    // $ANTLR start "rule__Class__Group__11"
    // InternalXUmlb.g:4910:1: rule__Class__Group__11 : rule__Class__Group__11__Impl rule__Class__Group__12 ;
    public final void rule__Class__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4914:1: ( rule__Class__Group__11__Impl rule__Class__Group__12 )
            // InternalXUmlb.g:4915:2: rule__Class__Group__11__Impl rule__Class__Group__12
            {
            pushFollow(FOLLOW_42);
            rule__Class__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__11"


    // $ANTLR start "rule__Class__Group__11__Impl"
    // InternalXUmlb.g:4922:1: rule__Class__Group__11__Impl : ( ( rule__Class__Group_11__0 )? ) ;
    public final void rule__Class__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4926:1: ( ( ( rule__Class__Group_11__0 )? ) )
            // InternalXUmlb.g:4927:1: ( ( rule__Class__Group_11__0 )? )
            {
            // InternalXUmlb.g:4927:1: ( ( rule__Class__Group_11__0 )? )
            // InternalXUmlb.g:4928:2: ( rule__Class__Group_11__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_11()); 
            // InternalXUmlb.g:4929:2: ( rule__Class__Group_11__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==134) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalXUmlb.g:4929:3: rule__Class__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Class__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__11__Impl"


    // $ANTLR start "rule__Class__Group__12"
    // InternalXUmlb.g:4937:1: rule__Class__Group__12 : rule__Class__Group__12__Impl rule__Class__Group__13 ;
    public final void rule__Class__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4941:1: ( rule__Class__Group__12__Impl rule__Class__Group__13 )
            // InternalXUmlb.g:4942:2: rule__Class__Group__12__Impl rule__Class__Group__13
            {
            pushFollow(FOLLOW_42);
            rule__Class__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__12"


    // $ANTLR start "rule__Class__Group__12__Impl"
    // InternalXUmlb.g:4949:1: rule__Class__Group__12__Impl : ( ( rule__Class__ClassAttributesAssignment_12 )* ) ;
    public final void rule__Class__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4953:1: ( ( ( rule__Class__ClassAttributesAssignment_12 )* ) )
            // InternalXUmlb.g:4954:1: ( ( rule__Class__ClassAttributesAssignment_12 )* )
            {
            // InternalXUmlb.g:4954:1: ( ( rule__Class__ClassAttributesAssignment_12 )* )
            // InternalXUmlb.g:4955:2: ( rule__Class__ClassAttributesAssignment_12 )*
            {
             before(grammarAccess.getClassAccess().getClassAttributesAssignment_12()); 
            // InternalXUmlb.g:4956:2: ( rule__Class__ClassAttributesAssignment_12 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==150) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalXUmlb.g:4956:3: rule__Class__ClassAttributesAssignment_12
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__Class__ClassAttributesAssignment_12();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getClassAttributesAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__12__Impl"


    // $ANTLR start "rule__Class__Group__13"
    // InternalXUmlb.g:4964:1: rule__Class__Group__13 : rule__Class__Group__13__Impl rule__Class__Group__14 ;
    public final void rule__Class__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4968:1: ( rule__Class__Group__13__Impl rule__Class__Group__14 )
            // InternalXUmlb.g:4969:2: rule__Class__Group__13__Impl rule__Class__Group__14
            {
            pushFollow(FOLLOW_42);
            rule__Class__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__13"


    // $ANTLR start "rule__Class__Group__13__Impl"
    // InternalXUmlb.g:4976:1: rule__Class__Group__13__Impl : ( ( rule__Class__ConstraintsAssignment_13 )* ) ;
    public final void rule__Class__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4980:1: ( ( ( rule__Class__ConstraintsAssignment_13 )* ) )
            // InternalXUmlb.g:4981:1: ( ( rule__Class__ConstraintsAssignment_13 )* )
            {
            // InternalXUmlb.g:4981:1: ( ( rule__Class__ConstraintsAssignment_13 )* )
            // InternalXUmlb.g:4982:2: ( rule__Class__ConstraintsAssignment_13 )*
            {
             before(grammarAccess.getClassAccess().getConstraintsAssignment_13()); 
            // InternalXUmlb.g:4983:2: ( rule__Class__ConstraintsAssignment_13 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==151) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalXUmlb.g:4983:3: rule__Class__ConstraintsAssignment_13
            	    {
            	    pushFollow(FOLLOW_44);
            	    rule__Class__ConstraintsAssignment_13();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getConstraintsAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__13__Impl"


    // $ANTLR start "rule__Class__Group__14"
    // InternalXUmlb.g:4991:1: rule__Class__Group__14 : rule__Class__Group__14__Impl rule__Class__Group__15 ;
    public final void rule__Class__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:4995:1: ( rule__Class__Group__14__Impl rule__Class__Group__15 )
            // InternalXUmlb.g:4996:2: rule__Class__Group__14__Impl rule__Class__Group__15
            {
            pushFollow(FOLLOW_42);
            rule__Class__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__14"


    // $ANTLR start "rule__Class__Group__14__Impl"
    // InternalXUmlb.g:5003:1: rule__Class__Group__14__Impl : ( ( rule__Class__MethodsAssignment_14 )* ) ;
    public final void rule__Class__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5007:1: ( ( ( rule__Class__MethodsAssignment_14 )* ) )
            // InternalXUmlb.g:5008:1: ( ( rule__Class__MethodsAssignment_14 )* )
            {
            // InternalXUmlb.g:5008:1: ( ( rule__Class__MethodsAssignment_14 )* )
            // InternalXUmlb.g:5009:2: ( rule__Class__MethodsAssignment_14 )*
            {
             before(grammarAccess.getClassAccess().getMethodsAssignment_14()); 
            // InternalXUmlb.g:5010:2: ( rule__Class__MethodsAssignment_14 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==153) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalXUmlb.g:5010:3: rule__Class__MethodsAssignment_14
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__Class__MethodsAssignment_14();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getMethodsAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__14__Impl"


    // $ANTLR start "rule__Class__Group__15"
    // InternalXUmlb.g:5018:1: rule__Class__Group__15 : rule__Class__Group__15__Impl ;
    public final void rule__Class__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5022:1: ( rule__Class__Group__15__Impl )
            // InternalXUmlb.g:5023:2: rule__Class__Group__15__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group__15__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__15"


    // $ANTLR start "rule__Class__Group__15__Impl"
    // InternalXUmlb.g:5029:1: rule__Class__Group__15__Impl : ( ( rule__Class__Group_15__0 )? ) ;
    public final void rule__Class__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5033:1: ( ( ( rule__Class__Group_15__0 )? ) )
            // InternalXUmlb.g:5034:1: ( ( rule__Class__Group_15__0 )? )
            {
            // InternalXUmlb.g:5034:1: ( ( rule__Class__Group_15__0 )? )
            // InternalXUmlb.g:5035:2: ( rule__Class__Group_15__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_15()); 
            // InternalXUmlb.g:5036:2: ( rule__Class__Group_15__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==146) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalXUmlb.g:5036:3: rule__Class__Group_15__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Class__Group_15__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group__15__Impl"


    // $ANTLR start "rule__Class__Group_6__0"
    // InternalXUmlb.g:5045:1: rule__Class__Group_6__0 : rule__Class__Group_6__0__Impl rule__Class__Group_6__1 ;
    public final void rule__Class__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5049:1: ( rule__Class__Group_6__0__Impl rule__Class__Group_6__1 )
            // InternalXUmlb.g:5050:2: rule__Class__Group_6__0__Impl rule__Class__Group_6__1
            {
            pushFollow(FOLLOW_4);
            rule__Class__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_6__0"


    // $ANTLR start "rule__Class__Group_6__0__Impl"
    // InternalXUmlb.g:5057:1: rule__Class__Group_6__0__Impl : ( 'elaborates' ) ;
    public final void rule__Class__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5061:1: ( ( 'elaborates' ) )
            // InternalXUmlb.g:5062:1: ( 'elaborates' )
            {
            // InternalXUmlb.g:5062:1: ( 'elaborates' )
            // InternalXUmlb.g:5063:2: 'elaborates'
            {
             before(grammarAccess.getClassAccess().getElaboratesKeyword_6_0()); 
            match(input,120,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getElaboratesKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_6__0__Impl"


    // $ANTLR start "rule__Class__Group_6__1"
    // InternalXUmlb.g:5072:1: rule__Class__Group_6__1 : rule__Class__Group_6__1__Impl ;
    public final void rule__Class__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5076:1: ( rule__Class__Group_6__1__Impl )
            // InternalXUmlb.g:5077:2: rule__Class__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_6__1"


    // $ANTLR start "rule__Class__Group_6__1__Impl"
    // InternalXUmlb.g:5083:1: rule__Class__Group_6__1__Impl : ( ( rule__Class__ElaboratesAssignment_6_1 ) ) ;
    public final void rule__Class__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5087:1: ( ( ( rule__Class__ElaboratesAssignment_6_1 ) ) )
            // InternalXUmlb.g:5088:1: ( ( rule__Class__ElaboratesAssignment_6_1 ) )
            {
            // InternalXUmlb.g:5088:1: ( ( rule__Class__ElaboratesAssignment_6_1 ) )
            // InternalXUmlb.g:5089:2: ( rule__Class__ElaboratesAssignment_6_1 )
            {
             before(grammarAccess.getClassAccess().getElaboratesAssignment_6_1()); 
            // InternalXUmlb.g:5090:2: ( rule__Class__ElaboratesAssignment_6_1 )
            // InternalXUmlb.g:5090:3: rule__Class__ElaboratesAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Class__ElaboratesAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getElaboratesAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_6__1__Impl"


    // $ANTLR start "rule__Class__Group_7__0"
    // InternalXUmlb.g:5099:1: rule__Class__Group_7__0 : rule__Class__Group_7__0__Impl rule__Class__Group_7__1 ;
    public final void rule__Class__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5103:1: ( rule__Class__Group_7__0__Impl rule__Class__Group_7__1 )
            // InternalXUmlb.g:5104:2: rule__Class__Group_7__0__Impl rule__Class__Group_7__1
            {
            pushFollow(FOLLOW_15);
            rule__Class__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_7__0"


    // $ANTLR start "rule__Class__Group_7__0__Impl"
    // InternalXUmlb.g:5111:1: rule__Class__Group_7__0__Impl : ( 'selfName' ) ;
    public final void rule__Class__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5115:1: ( ( 'selfName' ) )
            // InternalXUmlb.g:5116:1: ( 'selfName' )
            {
            // InternalXUmlb.g:5116:1: ( 'selfName' )
            // InternalXUmlb.g:5117:2: 'selfName'
            {
             before(grammarAccess.getClassAccess().getSelfNameKeyword_7_0()); 
            match(input,125,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getSelfNameKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_7__0__Impl"


    // $ANTLR start "rule__Class__Group_7__1"
    // InternalXUmlb.g:5126:1: rule__Class__Group_7__1 : rule__Class__Group_7__1__Impl ;
    public final void rule__Class__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5130:1: ( rule__Class__Group_7__1__Impl )
            // InternalXUmlb.g:5131:2: rule__Class__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_7__1"


    // $ANTLR start "rule__Class__Group_7__1__Impl"
    // InternalXUmlb.g:5137:1: rule__Class__Group_7__1__Impl : ( ( rule__Class__SelfNameAssignment_7_1 ) ) ;
    public final void rule__Class__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5141:1: ( ( ( rule__Class__SelfNameAssignment_7_1 ) ) )
            // InternalXUmlb.g:5142:1: ( ( rule__Class__SelfNameAssignment_7_1 ) )
            {
            // InternalXUmlb.g:5142:1: ( ( rule__Class__SelfNameAssignment_7_1 ) )
            // InternalXUmlb.g:5143:2: ( rule__Class__SelfNameAssignment_7_1 )
            {
             before(grammarAccess.getClassAccess().getSelfNameAssignment_7_1()); 
            // InternalXUmlb.g:5144:2: ( rule__Class__SelfNameAssignment_7_1 )
            // InternalXUmlb.g:5144:3: rule__Class__SelfNameAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Class__SelfNameAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getSelfNameAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_7__1__Impl"


    // $ANTLR start "rule__Class__Group_8__0"
    // InternalXUmlb.g:5153:1: rule__Class__Group_8__0 : rule__Class__Group_8__0__Impl rule__Class__Group_8__1 ;
    public final void rule__Class__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5157:1: ( rule__Class__Group_8__0__Impl rule__Class__Group_8__1 )
            // InternalXUmlb.g:5158:2: rule__Class__Group_8__0__Impl rule__Class__Group_8__1
            {
            pushFollow(FOLLOW_15);
            rule__Class__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_8__0"


    // $ANTLR start "rule__Class__Group_8__0__Impl"
    // InternalXUmlb.g:5165:1: rule__Class__Group_8__0__Impl : ( 'instances' ) ;
    public final void rule__Class__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5169:1: ( ( 'instances' ) )
            // InternalXUmlb.g:5170:1: ( 'instances' )
            {
            // InternalXUmlb.g:5170:1: ( 'instances' )
            // InternalXUmlb.g:5171:2: 'instances'
            {
             before(grammarAccess.getClassAccess().getInstancesKeyword_8_0()); 
            match(input,124,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getInstancesKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_8__0__Impl"


    // $ANTLR start "rule__Class__Group_8__1"
    // InternalXUmlb.g:5180:1: rule__Class__Group_8__1 : rule__Class__Group_8__1__Impl ;
    public final void rule__Class__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5184:1: ( rule__Class__Group_8__1__Impl )
            // InternalXUmlb.g:5185:2: rule__Class__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_8__1"


    // $ANTLR start "rule__Class__Group_8__1__Impl"
    // InternalXUmlb.g:5191:1: rule__Class__Group_8__1__Impl : ( ( rule__Class__InstancesAssignment_8_1 ) ) ;
    public final void rule__Class__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5195:1: ( ( ( rule__Class__InstancesAssignment_8_1 ) ) )
            // InternalXUmlb.g:5196:1: ( ( rule__Class__InstancesAssignment_8_1 ) )
            {
            // InternalXUmlb.g:5196:1: ( ( rule__Class__InstancesAssignment_8_1 ) )
            // InternalXUmlb.g:5197:2: ( rule__Class__InstancesAssignment_8_1 )
            {
             before(grammarAccess.getClassAccess().getInstancesAssignment_8_1()); 
            // InternalXUmlb.g:5198:2: ( rule__Class__InstancesAssignment_8_1 )
            // InternalXUmlb.g:5198:3: rule__Class__InstancesAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__Class__InstancesAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getInstancesAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_8__1__Impl"


    // $ANTLR start "rule__Class__Group_9__0"
    // InternalXUmlb.g:5207:1: rule__Class__Group_9__0 : rule__Class__Group_9__0__Impl rule__Class__Group_9__1 ;
    public final void rule__Class__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5211:1: ( rule__Class__Group_9__0__Impl rule__Class__Group_9__1 )
            // InternalXUmlb.g:5212:2: rule__Class__Group_9__0__Impl rule__Class__Group_9__1
            {
            pushFollow(FOLLOW_4);
            rule__Class__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_9__0"


    // $ANTLR start "rule__Class__Group_9__0__Impl"
    // InternalXUmlb.g:5219:1: rule__Class__Group_9__0__Impl : ( 'supertypes' ) ;
    public final void rule__Class__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5223:1: ( ( 'supertypes' ) )
            // InternalXUmlb.g:5224:1: ( 'supertypes' )
            {
            // InternalXUmlb.g:5224:1: ( 'supertypes' )
            // InternalXUmlb.g:5225:2: 'supertypes'
            {
             before(grammarAccess.getClassAccess().getSupertypesKeyword_9_0()); 
            match(input,145,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getSupertypesKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_9__0__Impl"


    // $ANTLR start "rule__Class__Group_9__1"
    // InternalXUmlb.g:5234:1: rule__Class__Group_9__1 : rule__Class__Group_9__1__Impl ;
    public final void rule__Class__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5238:1: ( rule__Class__Group_9__1__Impl )
            // InternalXUmlb.g:5239:2: rule__Class__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_9__1"


    // $ANTLR start "rule__Class__Group_9__1__Impl"
    // InternalXUmlb.g:5245:1: rule__Class__Group_9__1__Impl : ( ( ( rule__Class__SupertypesAssignment_9_1 ) ) ( ( rule__Class__SupertypesAssignment_9_1 )* ) ) ;
    public final void rule__Class__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5249:1: ( ( ( ( rule__Class__SupertypesAssignment_9_1 ) ) ( ( rule__Class__SupertypesAssignment_9_1 )* ) ) )
            // InternalXUmlb.g:5250:1: ( ( ( rule__Class__SupertypesAssignment_9_1 ) ) ( ( rule__Class__SupertypesAssignment_9_1 )* ) )
            {
            // InternalXUmlb.g:5250:1: ( ( ( rule__Class__SupertypesAssignment_9_1 ) ) ( ( rule__Class__SupertypesAssignment_9_1 )* ) )
            // InternalXUmlb.g:5251:2: ( ( rule__Class__SupertypesAssignment_9_1 ) ) ( ( rule__Class__SupertypesAssignment_9_1 )* )
            {
            // InternalXUmlb.g:5251:2: ( ( rule__Class__SupertypesAssignment_9_1 ) )
            // InternalXUmlb.g:5252:3: ( rule__Class__SupertypesAssignment_9_1 )
            {
             before(grammarAccess.getClassAccess().getSupertypesAssignment_9_1()); 
            // InternalXUmlb.g:5253:3: ( rule__Class__SupertypesAssignment_9_1 )
            // InternalXUmlb.g:5253:4: rule__Class__SupertypesAssignment_9_1
            {
            pushFollow(FOLLOW_20);
            rule__Class__SupertypesAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getSupertypesAssignment_9_1()); 

            }

            // InternalXUmlb.g:5256:2: ( ( rule__Class__SupertypesAssignment_9_1 )* )
            // InternalXUmlb.g:5257:3: ( rule__Class__SupertypesAssignment_9_1 )*
            {
             before(grammarAccess.getClassAccess().getSupertypesAssignment_9_1()); 
            // InternalXUmlb.g:5258:3: ( rule__Class__SupertypesAssignment_9_1 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_ID) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalXUmlb.g:5258:4: rule__Class__SupertypesAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__Class__SupertypesAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getSupertypesAssignment_9_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_9__1__Impl"


    // $ANTLR start "rule__Class__Group_10__0"
    // InternalXUmlb.g:5268:1: rule__Class__Group_10__0 : rule__Class__Group_10__0__Impl rule__Class__Group_10__1 ;
    public final void rule__Class__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5272:1: ( rule__Class__Group_10__0__Impl rule__Class__Group_10__1 )
            // InternalXUmlb.g:5273:2: rule__Class__Group_10__0__Impl rule__Class__Group_10__1
            {
            pushFollow(FOLLOW_4);
            rule__Class__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_10__0"


    // $ANTLR start "rule__Class__Group_10__0__Impl"
    // InternalXUmlb.g:5280:1: rule__Class__Group_10__0__Impl : ( 'refines' ) ;
    public final void rule__Class__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5284:1: ( ( 'refines' ) )
            // InternalXUmlb.g:5285:1: ( 'refines' )
            {
            // InternalXUmlb.g:5285:1: ( 'refines' )
            // InternalXUmlb.g:5286:2: 'refines'
            {
             before(grammarAccess.getClassAccess().getRefinesKeyword_10_0()); 
            match(input,121,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getRefinesKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_10__0__Impl"


    // $ANTLR start "rule__Class__Group_10__1"
    // InternalXUmlb.g:5295:1: rule__Class__Group_10__1 : rule__Class__Group_10__1__Impl ;
    public final void rule__Class__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5299:1: ( rule__Class__Group_10__1__Impl )
            // InternalXUmlb.g:5300:2: rule__Class__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_10__1"


    // $ANTLR start "rule__Class__Group_10__1__Impl"
    // InternalXUmlb.g:5306:1: rule__Class__Group_10__1__Impl : ( ( rule__Class__RefinesAssignment_10_1 ) ) ;
    public final void rule__Class__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5310:1: ( ( ( rule__Class__RefinesAssignment_10_1 ) ) )
            // InternalXUmlb.g:5311:1: ( ( rule__Class__RefinesAssignment_10_1 ) )
            {
            // InternalXUmlb.g:5311:1: ( ( rule__Class__RefinesAssignment_10_1 ) )
            // InternalXUmlb.g:5312:2: ( rule__Class__RefinesAssignment_10_1 )
            {
             before(grammarAccess.getClassAccess().getRefinesAssignment_10_1()); 
            // InternalXUmlb.g:5313:2: ( rule__Class__RefinesAssignment_10_1 )
            // InternalXUmlb.g:5313:3: rule__Class__RefinesAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__Class__RefinesAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getRefinesAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_10__1__Impl"


    // $ANTLR start "rule__Class__Group_11__0"
    // InternalXUmlb.g:5322:1: rule__Class__Group_11__0 : rule__Class__Group_11__0__Impl rule__Class__Group_11__1 ;
    public final void rule__Class__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5326:1: ( rule__Class__Group_11__0__Impl rule__Class__Group_11__1 )
            // InternalXUmlb.g:5327:2: rule__Class__Group_11__0__Impl rule__Class__Group_11__1
            {
            pushFollow(FOLLOW_33);
            rule__Class__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_11__0"


    // $ANTLR start "rule__Class__Group_11__0__Impl"
    // InternalXUmlb.g:5334:1: rule__Class__Group_11__0__Impl : ( 'statemachines' ) ;
    public final void rule__Class__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5338:1: ( ( 'statemachines' ) )
            // InternalXUmlb.g:5339:1: ( 'statemachines' )
            {
            // InternalXUmlb.g:5339:1: ( 'statemachines' )
            // InternalXUmlb.g:5340:2: 'statemachines'
            {
             before(grammarAccess.getClassAccess().getStatemachinesKeyword_11_0()); 
            match(input,134,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getStatemachinesKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_11__0__Impl"


    // $ANTLR start "rule__Class__Group_11__1"
    // InternalXUmlb.g:5349:1: rule__Class__Group_11__1 : rule__Class__Group_11__1__Impl rule__Class__Group_11__2 ;
    public final void rule__Class__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5353:1: ( rule__Class__Group_11__1__Impl rule__Class__Group_11__2 )
            // InternalXUmlb.g:5354:2: rule__Class__Group_11__1__Impl rule__Class__Group_11__2
            {
            pushFollow(FOLLOW_7);
            rule__Class__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_11__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_11__1"


    // $ANTLR start "rule__Class__Group_11__1__Impl"
    // InternalXUmlb.g:5361:1: rule__Class__Group_11__1__Impl : ( 'begin' ) ;
    public final void rule__Class__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5365:1: ( ( 'begin' ) )
            // InternalXUmlb.g:5366:1: ( 'begin' )
            {
            // InternalXUmlb.g:5366:1: ( 'begin' )
            // InternalXUmlb.g:5367:2: 'begin'
            {
             before(grammarAccess.getClassAccess().getBeginKeyword_11_1()); 
            match(input,135,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getBeginKeyword_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_11__1__Impl"


    // $ANTLR start "rule__Class__Group_11__2"
    // InternalXUmlb.g:5376:1: rule__Class__Group_11__2 : rule__Class__Group_11__2__Impl rule__Class__Group_11__3 ;
    public final void rule__Class__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5380:1: ( rule__Class__Group_11__2__Impl rule__Class__Group_11__3 )
            // InternalXUmlb.g:5381:2: rule__Class__Group_11__2__Impl rule__Class__Group_11__3
            {
            pushFollow(FOLLOW_46);
            rule__Class__Group_11__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_11__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_11__2"


    // $ANTLR start "rule__Class__Group_11__2__Impl"
    // InternalXUmlb.g:5388:1: rule__Class__Group_11__2__Impl : ( ( ( rule__Class__StatemachinesAssignment_11_2 ) ) ( ( rule__Class__StatemachinesAssignment_11_2 )* ) ) ;
    public final void rule__Class__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5392:1: ( ( ( ( rule__Class__StatemachinesAssignment_11_2 ) ) ( ( rule__Class__StatemachinesAssignment_11_2 )* ) ) )
            // InternalXUmlb.g:5393:1: ( ( ( rule__Class__StatemachinesAssignment_11_2 ) ) ( ( rule__Class__StatemachinesAssignment_11_2 )* ) )
            {
            // InternalXUmlb.g:5393:1: ( ( ( rule__Class__StatemachinesAssignment_11_2 ) ) ( ( rule__Class__StatemachinesAssignment_11_2 )* ) )
            // InternalXUmlb.g:5394:2: ( ( rule__Class__StatemachinesAssignment_11_2 ) ) ( ( rule__Class__StatemachinesAssignment_11_2 )* )
            {
            // InternalXUmlb.g:5394:2: ( ( rule__Class__StatemachinesAssignment_11_2 ) )
            // InternalXUmlb.g:5395:3: ( rule__Class__StatemachinesAssignment_11_2 )
            {
             before(grammarAccess.getClassAccess().getStatemachinesAssignment_11_2()); 
            // InternalXUmlb.g:5396:3: ( rule__Class__StatemachinesAssignment_11_2 )
            // InternalXUmlb.g:5396:4: rule__Class__StatemachinesAssignment_11_2
            {
            pushFollow(FOLLOW_35);
            rule__Class__StatemachinesAssignment_11_2();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getStatemachinesAssignment_11_2()); 

            }

            // InternalXUmlb.g:5399:2: ( ( rule__Class__StatemachinesAssignment_11_2 )* )
            // InternalXUmlb.g:5400:3: ( rule__Class__StatemachinesAssignment_11_2 )*
            {
             before(grammarAccess.getClassAccess().getStatemachinesAssignment_11_2()); 
            // InternalXUmlb.g:5401:3: ( rule__Class__StatemachinesAssignment_11_2 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==122) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalXUmlb.g:5401:4: rule__Class__StatemachinesAssignment_11_2
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__Class__StatemachinesAssignment_11_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getStatemachinesAssignment_11_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_11__2__Impl"


    // $ANTLR start "rule__Class__Group_11__3"
    // InternalXUmlb.g:5410:1: rule__Class__Group_11__3 : rule__Class__Group_11__3__Impl ;
    public final void rule__Class__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5414:1: ( rule__Class__Group_11__3__Impl )
            // InternalXUmlb.g:5415:2: rule__Class__Group_11__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group_11__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_11__3"


    // $ANTLR start "rule__Class__Group_11__3__Impl"
    // InternalXUmlb.g:5421:1: rule__Class__Group_11__3__Impl : ( 'end' ) ;
    public final void rule__Class__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5425:1: ( ( 'end' ) )
            // InternalXUmlb.g:5426:1: ( 'end' )
            {
            // InternalXUmlb.g:5426:1: ( 'end' )
            // InternalXUmlb.g:5427:2: 'end'
            {
             before(grammarAccess.getClassAccess().getEndKeyword_11_3()); 
            match(input,123,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getEndKeyword_11_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_11__3__Impl"


    // $ANTLR start "rule__Class__Group_15__0"
    // InternalXUmlb.g:5437:1: rule__Class__Group_15__0 : rule__Class__Group_15__0__Impl rule__Class__Group_15__1 ;
    public final void rule__Class__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5441:1: ( rule__Class__Group_15__0__Impl rule__Class__Group_15__1 )
            // InternalXUmlb.g:5442:2: rule__Class__Group_15__0__Impl rule__Class__Group_15__1
            {
            pushFollow(FOLLOW_47);
            rule__Class__Group_15__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Class__Group_15__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_15__0"


    // $ANTLR start "rule__Class__Group_15__0__Impl"
    // InternalXUmlb.g:5449:1: rule__Class__Group_15__0__Impl : ( 'subtypeGroups' ) ;
    public final void rule__Class__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5453:1: ( ( 'subtypeGroups' ) )
            // InternalXUmlb.g:5454:1: ( 'subtypeGroups' )
            {
            // InternalXUmlb.g:5454:1: ( 'subtypeGroups' )
            // InternalXUmlb.g:5455:2: 'subtypeGroups'
            {
             before(grammarAccess.getClassAccess().getSubtypeGroupsKeyword_15_0()); 
            match(input,146,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getSubtypeGroupsKeyword_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_15__0__Impl"


    // $ANTLR start "rule__Class__Group_15__1"
    // InternalXUmlb.g:5464:1: rule__Class__Group_15__1 : rule__Class__Group_15__1__Impl ;
    public final void rule__Class__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5468:1: ( rule__Class__Group_15__1__Impl )
            // InternalXUmlb.g:5469:2: rule__Class__Group_15__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Class__Group_15__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_15__1"


    // $ANTLR start "rule__Class__Group_15__1__Impl"
    // InternalXUmlb.g:5475:1: rule__Class__Group_15__1__Impl : ( ( ( rule__Class__SubtypeGroupsAssignment_15_1 ) ) ( ( rule__Class__SubtypeGroupsAssignment_15_1 )* ) ) ;
    public final void rule__Class__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5479:1: ( ( ( ( rule__Class__SubtypeGroupsAssignment_15_1 ) ) ( ( rule__Class__SubtypeGroupsAssignment_15_1 )* ) ) )
            // InternalXUmlb.g:5480:1: ( ( ( rule__Class__SubtypeGroupsAssignment_15_1 ) ) ( ( rule__Class__SubtypeGroupsAssignment_15_1 )* ) )
            {
            // InternalXUmlb.g:5480:1: ( ( ( rule__Class__SubtypeGroupsAssignment_15_1 ) ) ( ( rule__Class__SubtypeGroupsAssignment_15_1 )* ) )
            // InternalXUmlb.g:5481:2: ( ( rule__Class__SubtypeGroupsAssignment_15_1 ) ) ( ( rule__Class__SubtypeGroupsAssignment_15_1 )* )
            {
            // InternalXUmlb.g:5481:2: ( ( rule__Class__SubtypeGroupsAssignment_15_1 ) )
            // InternalXUmlb.g:5482:3: ( rule__Class__SubtypeGroupsAssignment_15_1 )
            {
             before(grammarAccess.getClassAccess().getSubtypeGroupsAssignment_15_1()); 
            // InternalXUmlb.g:5483:3: ( rule__Class__SubtypeGroupsAssignment_15_1 )
            // InternalXUmlb.g:5483:4: rule__Class__SubtypeGroupsAssignment_15_1
            {
            pushFollow(FOLLOW_48);
            rule__Class__SubtypeGroupsAssignment_15_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getSubtypeGroupsAssignment_15_1()); 

            }

            // InternalXUmlb.g:5486:2: ( ( rule__Class__SubtypeGroupsAssignment_15_1 )* )
            // InternalXUmlb.g:5487:3: ( rule__Class__SubtypeGroupsAssignment_15_1 )*
            {
             before(grammarAccess.getClassAccess().getSubtypeGroupsAssignment_15_1()); 
            // InternalXUmlb.g:5488:3: ( rule__Class__SubtypeGroupsAssignment_15_1 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==149) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalXUmlb.g:5488:4: rule__Class__SubtypeGroupsAssignment_15_1
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__Class__SubtypeGroupsAssignment_15_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

             after(grammarAccess.getClassAccess().getSubtypeGroupsAssignment_15_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__Group_15__1__Impl"


    // $ANTLR start "rule__Association__Group__0"
    // InternalXUmlb.g:5498:1: rule__Association__Group__0 : rule__Association__Group__0__Impl rule__Association__Group__1 ;
    public final void rule__Association__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5502:1: ( rule__Association__Group__0__Impl rule__Association__Group__1 )
            // InternalXUmlb.g:5503:2: rule__Association__Group__0__Impl rule__Association__Group__1
            {
            pushFollow(FOLLOW_49);
            rule__Association__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__0"


    // $ANTLR start "rule__Association__Group__0__Impl"
    // InternalXUmlb.g:5510:1: rule__Association__Group__0__Impl : ( () ) ;
    public final void rule__Association__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5514:1: ( ( () ) )
            // InternalXUmlb.g:5515:1: ( () )
            {
            // InternalXUmlb.g:5515:1: ( () )
            // InternalXUmlb.g:5516:2: ()
            {
             before(grammarAccess.getAssociationAccess().getAssociationAction_0()); 
            // InternalXUmlb.g:5517:2: ()
            // InternalXUmlb.g:5517:3: 
            {
            }

             after(grammarAccess.getAssociationAccess().getAssociationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__0__Impl"


    // $ANTLR start "rule__Association__Group__1"
    // InternalXUmlb.g:5525:1: rule__Association__Group__1 : rule__Association__Group__1__Impl rule__Association__Group__2 ;
    public final void rule__Association__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5529:1: ( rule__Association__Group__1__Impl rule__Association__Group__2 )
            // InternalXUmlb.g:5530:2: rule__Association__Group__1__Impl rule__Association__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Association__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__1"


    // $ANTLR start "rule__Association__Group__1__Impl"
    // InternalXUmlb.g:5537:1: rule__Association__Group__1__Impl : ( 'association' ) ;
    public final void rule__Association__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5541:1: ( ( 'association' ) )
            // InternalXUmlb.g:5542:1: ( 'association' )
            {
            // InternalXUmlb.g:5542:1: ( 'association' )
            // InternalXUmlb.g:5543:2: 'association'
            {
             before(grammarAccess.getAssociationAccess().getAssociationKeyword_1()); 
            match(input,147,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getAssociationKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__1__Impl"


    // $ANTLR start "rule__Association__Group__2"
    // InternalXUmlb.g:5552:1: rule__Association__Group__2 : rule__Association__Group__2__Impl rule__Association__Group__3 ;
    public final void rule__Association__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5556:1: ( rule__Association__Group__2__Impl rule__Association__Group__3 )
            // InternalXUmlb.g:5557:2: rule__Association__Group__2__Impl rule__Association__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Association__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__2"


    // $ANTLR start "rule__Association__Group__2__Impl"
    // InternalXUmlb.g:5564:1: rule__Association__Group__2__Impl : ( ( rule__Association__NameAssignment_2 ) ) ;
    public final void rule__Association__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5568:1: ( ( ( rule__Association__NameAssignment_2 ) ) )
            // InternalXUmlb.g:5569:1: ( ( rule__Association__NameAssignment_2 ) )
            {
            // InternalXUmlb.g:5569:1: ( ( rule__Association__NameAssignment_2 ) )
            // InternalXUmlb.g:5570:2: ( rule__Association__NameAssignment_2 )
            {
             before(grammarAccess.getAssociationAccess().getNameAssignment_2()); 
            // InternalXUmlb.g:5571:2: ( rule__Association__NameAssignment_2 )
            // InternalXUmlb.g:5571:3: rule__Association__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Association__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAssociationAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__2__Impl"


    // $ANTLR start "rule__Association__Group__3"
    // InternalXUmlb.g:5579:1: rule__Association__Group__3 : rule__Association__Group__3__Impl rule__Association__Group__4 ;
    public final void rule__Association__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5583:1: ( rule__Association__Group__3__Impl rule__Association__Group__4 )
            // InternalXUmlb.g:5584:2: rule__Association__Group__3__Impl rule__Association__Group__4
            {
            pushFollow(FOLLOW_41);
            rule__Association__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__3"


    // $ANTLR start "rule__Association__Group__3__Impl"
    // InternalXUmlb.g:5591:1: rule__Association__Group__3__Impl : ( '(' ) ;
    public final void rule__Association__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5595:1: ( ( '(' ) )
            // InternalXUmlb.g:5596:1: ( '(' )
            {
            // InternalXUmlb.g:5596:1: ( '(' )
            // InternalXUmlb.g:5597:2: '('
            {
             before(grammarAccess.getAssociationAccess().getLeftParenthesisKeyword_3()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getLeftParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__3__Impl"


    // $ANTLR start "rule__Association__Group__4"
    // InternalXUmlb.g:5606:1: rule__Association__Group__4 : rule__Association__Group__4__Impl rule__Association__Group__5 ;
    public final void rule__Association__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5610:1: ( rule__Association__Group__4__Impl rule__Association__Group__5 )
            // InternalXUmlb.g:5611:2: rule__Association__Group__4__Impl rule__Association__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__Association__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__4"


    // $ANTLR start "rule__Association__Group__4__Impl"
    // InternalXUmlb.g:5618:1: rule__Association__Group__4__Impl : ( ( rule__Association__DataKindAssignment_4 ) ) ;
    public final void rule__Association__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5622:1: ( ( ( rule__Association__DataKindAssignment_4 ) ) )
            // InternalXUmlb.g:5623:1: ( ( rule__Association__DataKindAssignment_4 ) )
            {
            // InternalXUmlb.g:5623:1: ( ( rule__Association__DataKindAssignment_4 ) )
            // InternalXUmlb.g:5624:2: ( rule__Association__DataKindAssignment_4 )
            {
             before(grammarAccess.getAssociationAccess().getDataKindAssignment_4()); 
            // InternalXUmlb.g:5625:2: ( rule__Association__DataKindAssignment_4 )
            // InternalXUmlb.g:5625:3: rule__Association__DataKindAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Association__DataKindAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getAssociationAccess().getDataKindAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__4__Impl"


    // $ANTLR start "rule__Association__Group__5"
    // InternalXUmlb.g:5633:1: rule__Association__Group__5 : rule__Association__Group__5__Impl rule__Association__Group__6 ;
    public final void rule__Association__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5637:1: ( rule__Association__Group__5__Impl rule__Association__Group__6 )
            // InternalXUmlb.g:5638:2: rule__Association__Group__5__Impl rule__Association__Group__6
            {
            pushFollow(FOLLOW_50);
            rule__Association__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__5"


    // $ANTLR start "rule__Association__Group__5__Impl"
    // InternalXUmlb.g:5645:1: rule__Association__Group__5__Impl : ( ')' ) ;
    public final void rule__Association__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5649:1: ( ( ')' ) )
            // InternalXUmlb.g:5650:1: ( ')' )
            {
            // InternalXUmlb.g:5650:1: ( ')' )
            // InternalXUmlb.g:5651:2: ')'
            {
             before(grammarAccess.getAssociationAccess().getRightParenthesisKeyword_5()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__5__Impl"


    // $ANTLR start "rule__Association__Group__6"
    // InternalXUmlb.g:5660:1: rule__Association__Group__6 : rule__Association__Group__6__Impl rule__Association__Group__7 ;
    public final void rule__Association__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5664:1: ( rule__Association__Group__6__Impl rule__Association__Group__7 )
            // InternalXUmlb.g:5665:2: rule__Association__Group__6__Impl rule__Association__Group__7
            {
            pushFollow(FOLLOW_50);
            rule__Association__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__6"


    // $ANTLR start "rule__Association__Group__6__Impl"
    // InternalXUmlb.g:5672:1: rule__Association__Group__6__Impl : ( ( rule__Association__Group_6__0 )? ) ;
    public final void rule__Association__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5676:1: ( ( ( rule__Association__Group_6__0 )? ) )
            // InternalXUmlb.g:5677:1: ( ( rule__Association__Group_6__0 )? )
            {
            // InternalXUmlb.g:5677:1: ( ( rule__Association__Group_6__0 )? )
            // InternalXUmlb.g:5678:2: ( rule__Association__Group_6__0 )?
            {
             before(grammarAccess.getAssociationAccess().getGroup_6()); 
            // InternalXUmlb.g:5679:2: ( rule__Association__Group_6__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==120) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalXUmlb.g:5679:3: rule__Association__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Association__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssociationAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__6__Impl"


    // $ANTLR start "rule__Association__Group__7"
    // InternalXUmlb.g:5687:1: rule__Association__Group__7 : rule__Association__Group__7__Impl rule__Association__Group__8 ;
    public final void rule__Association__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5691:1: ( rule__Association__Group__7__Impl rule__Association__Group__8 )
            // InternalXUmlb.g:5692:2: rule__Association__Group__7__Impl rule__Association__Group__8
            {
            pushFollow(FOLLOW_50);
            rule__Association__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__7"


    // $ANTLR start "rule__Association__Group__7__Impl"
    // InternalXUmlb.g:5699:1: rule__Association__Group__7__Impl : ( ( rule__Association__FunctionalAssignment_7 )? ) ;
    public final void rule__Association__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5703:1: ( ( ( rule__Association__FunctionalAssignment_7 )? ) )
            // InternalXUmlb.g:5704:1: ( ( rule__Association__FunctionalAssignment_7 )? )
            {
            // InternalXUmlb.g:5704:1: ( ( rule__Association__FunctionalAssignment_7 )? )
            // InternalXUmlb.g:5705:2: ( rule__Association__FunctionalAssignment_7 )?
            {
             before(grammarAccess.getAssociationAccess().getFunctionalAssignment_7()); 
            // InternalXUmlb.g:5706:2: ( rule__Association__FunctionalAssignment_7 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==158) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalXUmlb.g:5706:3: rule__Association__FunctionalAssignment_7
                    {
                    pushFollow(FOLLOW_2);
                    rule__Association__FunctionalAssignment_7();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssociationAccess().getFunctionalAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__7__Impl"


    // $ANTLR start "rule__Association__Group__8"
    // InternalXUmlb.g:5714:1: rule__Association__Group__8 : rule__Association__Group__8__Impl rule__Association__Group__9 ;
    public final void rule__Association__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5718:1: ( rule__Association__Group__8__Impl rule__Association__Group__9 )
            // InternalXUmlb.g:5719:2: rule__Association__Group__8__Impl rule__Association__Group__9
            {
            pushFollow(FOLLOW_50);
            rule__Association__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__8"


    // $ANTLR start "rule__Association__Group__8__Impl"
    // InternalXUmlb.g:5726:1: rule__Association__Group__8__Impl : ( ( rule__Association__TotalAssignment_8 )? ) ;
    public final void rule__Association__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5730:1: ( ( ( rule__Association__TotalAssignment_8 )? ) )
            // InternalXUmlb.g:5731:1: ( ( rule__Association__TotalAssignment_8 )? )
            {
            // InternalXUmlb.g:5731:1: ( ( rule__Association__TotalAssignment_8 )? )
            // InternalXUmlb.g:5732:2: ( rule__Association__TotalAssignment_8 )?
            {
             before(grammarAccess.getAssociationAccess().getTotalAssignment_8()); 
            // InternalXUmlb.g:5733:2: ( rule__Association__TotalAssignment_8 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==159) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalXUmlb.g:5733:3: rule__Association__TotalAssignment_8
                    {
                    pushFollow(FOLLOW_2);
                    rule__Association__TotalAssignment_8();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssociationAccess().getTotalAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__8__Impl"


    // $ANTLR start "rule__Association__Group__9"
    // InternalXUmlb.g:5741:1: rule__Association__Group__9 : rule__Association__Group__9__Impl rule__Association__Group__10 ;
    public final void rule__Association__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5745:1: ( rule__Association__Group__9__Impl rule__Association__Group__10 )
            // InternalXUmlb.g:5746:2: rule__Association__Group__9__Impl rule__Association__Group__10
            {
            pushFollow(FOLLOW_50);
            rule__Association__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__9"


    // $ANTLR start "rule__Association__Group__9__Impl"
    // InternalXUmlb.g:5753:1: rule__Association__Group__9__Impl : ( ( rule__Association__SurjectiveAssignment_9 )? ) ;
    public final void rule__Association__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5757:1: ( ( ( rule__Association__SurjectiveAssignment_9 )? ) )
            // InternalXUmlb.g:5758:1: ( ( rule__Association__SurjectiveAssignment_9 )? )
            {
            // InternalXUmlb.g:5758:1: ( ( rule__Association__SurjectiveAssignment_9 )? )
            // InternalXUmlb.g:5759:2: ( rule__Association__SurjectiveAssignment_9 )?
            {
             before(grammarAccess.getAssociationAccess().getSurjectiveAssignment_9()); 
            // InternalXUmlb.g:5760:2: ( rule__Association__SurjectiveAssignment_9 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==160) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalXUmlb.g:5760:3: rule__Association__SurjectiveAssignment_9
                    {
                    pushFollow(FOLLOW_2);
                    rule__Association__SurjectiveAssignment_9();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssociationAccess().getSurjectiveAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__9__Impl"


    // $ANTLR start "rule__Association__Group__10"
    // InternalXUmlb.g:5768:1: rule__Association__Group__10 : rule__Association__Group__10__Impl rule__Association__Group__11 ;
    public final void rule__Association__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5772:1: ( rule__Association__Group__10__Impl rule__Association__Group__11 )
            // InternalXUmlb.g:5773:2: rule__Association__Group__10__Impl rule__Association__Group__11
            {
            pushFollow(FOLLOW_50);
            rule__Association__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__10"


    // $ANTLR start "rule__Association__Group__10__Impl"
    // InternalXUmlb.g:5780:1: rule__Association__Group__10__Impl : ( ( rule__Association__InjectiveAssignment_10 )? ) ;
    public final void rule__Association__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5784:1: ( ( ( rule__Association__InjectiveAssignment_10 )? ) )
            // InternalXUmlb.g:5785:1: ( ( rule__Association__InjectiveAssignment_10 )? )
            {
            // InternalXUmlb.g:5785:1: ( ( rule__Association__InjectiveAssignment_10 )? )
            // InternalXUmlb.g:5786:2: ( rule__Association__InjectiveAssignment_10 )?
            {
             before(grammarAccess.getAssociationAccess().getInjectiveAssignment_10()); 
            // InternalXUmlb.g:5787:2: ( rule__Association__InjectiveAssignment_10 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==161) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalXUmlb.g:5787:3: rule__Association__InjectiveAssignment_10
                    {
                    pushFollow(FOLLOW_2);
                    rule__Association__InjectiveAssignment_10();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssociationAccess().getInjectiveAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__10__Impl"


    // $ANTLR start "rule__Association__Group__11"
    // InternalXUmlb.g:5795:1: rule__Association__Group__11 : rule__Association__Group__11__Impl rule__Association__Group__12 ;
    public final void rule__Association__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5799:1: ( rule__Association__Group__11__Impl rule__Association__Group__12 )
            // InternalXUmlb.g:5800:2: rule__Association__Group__11__Impl rule__Association__Group__12
            {
            pushFollow(FOLLOW_50);
            rule__Association__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__11"


    // $ANTLR start "rule__Association__Group__11__Impl"
    // InternalXUmlb.g:5807:1: rule__Association__Group__11__Impl : ( ( rule__Association__Group_11__0 )? ) ;
    public final void rule__Association__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5811:1: ( ( ( rule__Association__Group_11__0 )? ) )
            // InternalXUmlb.g:5812:1: ( ( rule__Association__Group_11__0 )? )
            {
            // InternalXUmlb.g:5812:1: ( ( rule__Association__Group_11__0 )? )
            // InternalXUmlb.g:5813:2: ( rule__Association__Group_11__0 )?
            {
             before(grammarAccess.getAssociationAccess().getGroup_11()); 
            // InternalXUmlb.g:5814:2: ( rule__Association__Group_11__0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==148) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalXUmlb.g:5814:3: rule__Association__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Association__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssociationAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__11__Impl"


    // $ANTLR start "rule__Association__Group__12"
    // InternalXUmlb.g:5822:1: rule__Association__Group__12 : rule__Association__Group__12__Impl rule__Association__Group__13 ;
    public final void rule__Association__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5826:1: ( rule__Association__Group__12__Impl rule__Association__Group__13 )
            // InternalXUmlb.g:5827:2: rule__Association__Group__12__Impl rule__Association__Group__13
            {
            pushFollow(FOLLOW_4);
            rule__Association__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__12"


    // $ANTLR start "rule__Association__Group__12__Impl"
    // InternalXUmlb.g:5834:1: rule__Association__Group__12__Impl : ( 'source' ) ;
    public final void rule__Association__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5838:1: ( ( 'source' ) )
            // InternalXUmlb.g:5839:1: ( 'source' )
            {
            // InternalXUmlb.g:5839:1: ( 'source' )
            // InternalXUmlb.g:5840:2: 'source'
            {
             before(grammarAccess.getAssociationAccess().getSourceKeyword_12()); 
            match(input,127,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getSourceKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__12__Impl"


    // $ANTLR start "rule__Association__Group__13"
    // InternalXUmlb.g:5849:1: rule__Association__Group__13 : rule__Association__Group__13__Impl rule__Association__Group__14 ;
    public final void rule__Association__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5853:1: ( rule__Association__Group__13__Impl rule__Association__Group__14 )
            // InternalXUmlb.g:5854:2: rule__Association__Group__13__Impl rule__Association__Group__14
            {
            pushFollow(FOLLOW_18);
            rule__Association__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__13"


    // $ANTLR start "rule__Association__Group__13__Impl"
    // InternalXUmlb.g:5861:1: rule__Association__Group__13__Impl : ( ( rule__Association__SourceAssignment_13 ) ) ;
    public final void rule__Association__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5865:1: ( ( ( rule__Association__SourceAssignment_13 ) ) )
            // InternalXUmlb.g:5866:1: ( ( rule__Association__SourceAssignment_13 ) )
            {
            // InternalXUmlb.g:5866:1: ( ( rule__Association__SourceAssignment_13 ) )
            // InternalXUmlb.g:5867:2: ( rule__Association__SourceAssignment_13 )
            {
             before(grammarAccess.getAssociationAccess().getSourceAssignment_13()); 
            // InternalXUmlb.g:5868:2: ( rule__Association__SourceAssignment_13 )
            // InternalXUmlb.g:5868:3: rule__Association__SourceAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__Association__SourceAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getAssociationAccess().getSourceAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__13__Impl"


    // $ANTLR start "rule__Association__Group__14"
    // InternalXUmlb.g:5876:1: rule__Association__Group__14 : rule__Association__Group__14__Impl rule__Association__Group__15 ;
    public final void rule__Association__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5880:1: ( rule__Association__Group__14__Impl rule__Association__Group__15 )
            // InternalXUmlb.g:5881:2: rule__Association__Group__14__Impl rule__Association__Group__15
            {
            pushFollow(FOLLOW_4);
            rule__Association__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__14"


    // $ANTLR start "rule__Association__Group__14__Impl"
    // InternalXUmlb.g:5888:1: rule__Association__Group__14__Impl : ( 'target' ) ;
    public final void rule__Association__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5892:1: ( ( 'target' ) )
            // InternalXUmlb.g:5893:1: ( 'target' )
            {
            // InternalXUmlb.g:5893:1: ( 'target' )
            // InternalXUmlb.g:5894:2: 'target'
            {
             before(grammarAccess.getAssociationAccess().getTargetKeyword_14()); 
            match(input,128,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getTargetKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__14__Impl"


    // $ANTLR start "rule__Association__Group__15"
    // InternalXUmlb.g:5903:1: rule__Association__Group__15 : rule__Association__Group__15__Impl ;
    public final void rule__Association__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5907:1: ( rule__Association__Group__15__Impl )
            // InternalXUmlb.g:5908:2: rule__Association__Group__15__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Association__Group__15__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__15"


    // $ANTLR start "rule__Association__Group__15__Impl"
    // InternalXUmlb.g:5914:1: rule__Association__Group__15__Impl : ( ( rule__Association__TargetAssignment_15 ) ) ;
    public final void rule__Association__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5918:1: ( ( ( rule__Association__TargetAssignment_15 ) ) )
            // InternalXUmlb.g:5919:1: ( ( rule__Association__TargetAssignment_15 ) )
            {
            // InternalXUmlb.g:5919:1: ( ( rule__Association__TargetAssignment_15 ) )
            // InternalXUmlb.g:5920:2: ( rule__Association__TargetAssignment_15 )
            {
             before(grammarAccess.getAssociationAccess().getTargetAssignment_15()); 
            // InternalXUmlb.g:5921:2: ( rule__Association__TargetAssignment_15 )
            // InternalXUmlb.g:5921:3: rule__Association__TargetAssignment_15
            {
            pushFollow(FOLLOW_2);
            rule__Association__TargetAssignment_15();

            state._fsp--;


            }

             after(grammarAccess.getAssociationAccess().getTargetAssignment_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__15__Impl"


    // $ANTLR start "rule__Association__Group_6__0"
    // InternalXUmlb.g:5930:1: rule__Association__Group_6__0 : rule__Association__Group_6__0__Impl rule__Association__Group_6__1 ;
    public final void rule__Association__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5934:1: ( rule__Association__Group_6__0__Impl rule__Association__Group_6__1 )
            // InternalXUmlb.g:5935:2: rule__Association__Group_6__0__Impl rule__Association__Group_6__1
            {
            pushFollow(FOLLOW_4);
            rule__Association__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group_6__0"


    // $ANTLR start "rule__Association__Group_6__0__Impl"
    // InternalXUmlb.g:5942:1: rule__Association__Group_6__0__Impl : ( 'elaborates' ) ;
    public final void rule__Association__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5946:1: ( ( 'elaborates' ) )
            // InternalXUmlb.g:5947:1: ( 'elaborates' )
            {
            // InternalXUmlb.g:5947:1: ( 'elaborates' )
            // InternalXUmlb.g:5948:2: 'elaborates'
            {
             before(grammarAccess.getAssociationAccess().getElaboratesKeyword_6_0()); 
            match(input,120,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getElaboratesKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group_6__0__Impl"


    // $ANTLR start "rule__Association__Group_6__1"
    // InternalXUmlb.g:5957:1: rule__Association__Group_6__1 : rule__Association__Group_6__1__Impl ;
    public final void rule__Association__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5961:1: ( rule__Association__Group_6__1__Impl )
            // InternalXUmlb.g:5962:2: rule__Association__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Association__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group_6__1"


    // $ANTLR start "rule__Association__Group_6__1__Impl"
    // InternalXUmlb.g:5968:1: rule__Association__Group_6__1__Impl : ( ( rule__Association__ElaboratesAssignment_6_1 ) ) ;
    public final void rule__Association__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5972:1: ( ( ( rule__Association__ElaboratesAssignment_6_1 ) ) )
            // InternalXUmlb.g:5973:1: ( ( rule__Association__ElaboratesAssignment_6_1 ) )
            {
            // InternalXUmlb.g:5973:1: ( ( rule__Association__ElaboratesAssignment_6_1 ) )
            // InternalXUmlb.g:5974:2: ( rule__Association__ElaboratesAssignment_6_1 )
            {
             before(grammarAccess.getAssociationAccess().getElaboratesAssignment_6_1()); 
            // InternalXUmlb.g:5975:2: ( rule__Association__ElaboratesAssignment_6_1 )
            // InternalXUmlb.g:5975:3: rule__Association__ElaboratesAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Association__ElaboratesAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getAssociationAccess().getElaboratesAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group_6__1__Impl"


    // $ANTLR start "rule__Association__Group_11__0"
    // InternalXUmlb.g:5984:1: rule__Association__Group_11__0 : rule__Association__Group_11__0__Impl rule__Association__Group_11__1 ;
    public final void rule__Association__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:5988:1: ( rule__Association__Group_11__0__Impl rule__Association__Group_11__1 )
            // InternalXUmlb.g:5989:2: rule__Association__Group_11__0__Impl rule__Association__Group_11__1
            {
            pushFollow(FOLLOW_15);
            rule__Association__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group_11__0"


    // $ANTLR start "rule__Association__Group_11__0__Impl"
    // InternalXUmlb.g:5996:1: rule__Association__Group_11__0__Impl : ( 'initialValue' ) ;
    public final void rule__Association__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6000:1: ( ( 'initialValue' ) )
            // InternalXUmlb.g:6001:1: ( 'initialValue' )
            {
            // InternalXUmlb.g:6001:1: ( 'initialValue' )
            // InternalXUmlb.g:6002:2: 'initialValue'
            {
             before(grammarAccess.getAssociationAccess().getInitialValueKeyword_11_0()); 
            match(input,148,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getInitialValueKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group_11__0__Impl"


    // $ANTLR start "rule__Association__Group_11__1"
    // InternalXUmlb.g:6011:1: rule__Association__Group_11__1 : rule__Association__Group_11__1__Impl ;
    public final void rule__Association__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6015:1: ( rule__Association__Group_11__1__Impl )
            // InternalXUmlb.g:6016:2: rule__Association__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Association__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group_11__1"


    // $ANTLR start "rule__Association__Group_11__1__Impl"
    // InternalXUmlb.g:6022:1: rule__Association__Group_11__1__Impl : ( ( rule__Association__InitialValueAssignment_11_1 ) ) ;
    public final void rule__Association__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6026:1: ( ( ( rule__Association__InitialValueAssignment_11_1 ) ) )
            // InternalXUmlb.g:6027:1: ( ( rule__Association__InitialValueAssignment_11_1 ) )
            {
            // InternalXUmlb.g:6027:1: ( ( rule__Association__InitialValueAssignment_11_1 ) )
            // InternalXUmlb.g:6028:2: ( rule__Association__InitialValueAssignment_11_1 )
            {
             before(grammarAccess.getAssociationAccess().getInitialValueAssignment_11_1()); 
            // InternalXUmlb.g:6029:2: ( rule__Association__InitialValueAssignment_11_1 )
            // InternalXUmlb.g:6029:3: rule__Association__InitialValueAssignment_11_1
            {
            pushFollow(FOLLOW_2);
            rule__Association__InitialValueAssignment_11_1();

            state._fsp--;


            }

             after(grammarAccess.getAssociationAccess().getInitialValueAssignment_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group_11__1__Impl"


    // $ANTLR start "rule__SubtypeGroup__Group__0"
    // InternalXUmlb.g:6038:1: rule__SubtypeGroup__Group__0 : rule__SubtypeGroup__Group__0__Impl rule__SubtypeGroup__Group__1 ;
    public final void rule__SubtypeGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6042:1: ( rule__SubtypeGroup__Group__0__Impl rule__SubtypeGroup__Group__1 )
            // InternalXUmlb.g:6043:2: rule__SubtypeGroup__Group__0__Impl rule__SubtypeGroup__Group__1
            {
            pushFollow(FOLLOW_47);
            rule__SubtypeGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubtypeGroup__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__Group__0"


    // $ANTLR start "rule__SubtypeGroup__Group__0__Impl"
    // InternalXUmlb.g:6050:1: rule__SubtypeGroup__Group__0__Impl : ( () ) ;
    public final void rule__SubtypeGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6054:1: ( ( () ) )
            // InternalXUmlb.g:6055:1: ( () )
            {
            // InternalXUmlb.g:6055:1: ( () )
            // InternalXUmlb.g:6056:2: ()
            {
             before(grammarAccess.getSubtypeGroupAccess().getSubtypeGroupAction_0()); 
            // InternalXUmlb.g:6057:2: ()
            // InternalXUmlb.g:6057:3: 
            {
            }

             after(grammarAccess.getSubtypeGroupAccess().getSubtypeGroupAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__Group__0__Impl"


    // $ANTLR start "rule__SubtypeGroup__Group__1"
    // InternalXUmlb.g:6065:1: rule__SubtypeGroup__Group__1 : rule__SubtypeGroup__Group__1__Impl rule__SubtypeGroup__Group__2 ;
    public final void rule__SubtypeGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6069:1: ( rule__SubtypeGroup__Group__1__Impl rule__SubtypeGroup__Group__2 )
            // InternalXUmlb.g:6070:2: rule__SubtypeGroup__Group__1__Impl rule__SubtypeGroup__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__SubtypeGroup__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubtypeGroup__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__Group__1"


    // $ANTLR start "rule__SubtypeGroup__Group__1__Impl"
    // InternalXUmlb.g:6077:1: rule__SubtypeGroup__Group__1__Impl : ( 'SubtypeGroup' ) ;
    public final void rule__SubtypeGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6081:1: ( ( 'SubtypeGroup' ) )
            // InternalXUmlb.g:6082:1: ( 'SubtypeGroup' )
            {
            // InternalXUmlb.g:6082:1: ( 'SubtypeGroup' )
            // InternalXUmlb.g:6083:2: 'SubtypeGroup'
            {
             before(grammarAccess.getSubtypeGroupAccess().getSubtypeGroupKeyword_1()); 
            match(input,149,FOLLOW_2); 
             after(grammarAccess.getSubtypeGroupAccess().getSubtypeGroupKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__Group__1__Impl"


    // $ANTLR start "rule__SubtypeGroup__Group__2"
    // InternalXUmlb.g:6092:1: rule__SubtypeGroup__Group__2 : rule__SubtypeGroup__Group__2__Impl rule__SubtypeGroup__Group__3 ;
    public final void rule__SubtypeGroup__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6096:1: ( rule__SubtypeGroup__Group__2__Impl rule__SubtypeGroup__Group__3 )
            // InternalXUmlb.g:6097:2: rule__SubtypeGroup__Group__2__Impl rule__SubtypeGroup__Group__3
            {
            pushFollow(FOLLOW_51);
            rule__SubtypeGroup__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubtypeGroup__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__Group__2"


    // $ANTLR start "rule__SubtypeGroup__Group__2__Impl"
    // InternalXUmlb.g:6104:1: rule__SubtypeGroup__Group__2__Impl : ( ( rule__SubtypeGroup__NameAssignment_2 ) ) ;
    public final void rule__SubtypeGroup__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6108:1: ( ( ( rule__SubtypeGroup__NameAssignment_2 ) ) )
            // InternalXUmlb.g:6109:1: ( ( rule__SubtypeGroup__NameAssignment_2 ) )
            {
            // InternalXUmlb.g:6109:1: ( ( rule__SubtypeGroup__NameAssignment_2 ) )
            // InternalXUmlb.g:6110:2: ( rule__SubtypeGroup__NameAssignment_2 )
            {
             before(grammarAccess.getSubtypeGroupAccess().getNameAssignment_2()); 
            // InternalXUmlb.g:6111:2: ( rule__SubtypeGroup__NameAssignment_2 )
            // InternalXUmlb.g:6111:3: rule__SubtypeGroup__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SubtypeGroup__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSubtypeGroupAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__Group__2__Impl"


    // $ANTLR start "rule__SubtypeGroup__Group__3"
    // InternalXUmlb.g:6119:1: rule__SubtypeGroup__Group__3 : rule__SubtypeGroup__Group__3__Impl rule__SubtypeGroup__Group__4 ;
    public final void rule__SubtypeGroup__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6123:1: ( rule__SubtypeGroup__Group__3__Impl rule__SubtypeGroup__Group__4 )
            // InternalXUmlb.g:6124:2: rule__SubtypeGroup__Group__3__Impl rule__SubtypeGroup__Group__4
            {
            pushFollow(FOLLOW_51);
            rule__SubtypeGroup__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubtypeGroup__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__Group__3"


    // $ANTLR start "rule__SubtypeGroup__Group__3__Impl"
    // InternalXUmlb.g:6131:1: rule__SubtypeGroup__Group__3__Impl : ( ( rule__SubtypeGroup__CoverAssignment_3 )? ) ;
    public final void rule__SubtypeGroup__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6135:1: ( ( ( rule__SubtypeGroup__CoverAssignment_3 )? ) )
            // InternalXUmlb.g:6136:1: ( ( rule__SubtypeGroup__CoverAssignment_3 )? )
            {
            // InternalXUmlb.g:6136:1: ( ( rule__SubtypeGroup__CoverAssignment_3 )? )
            // InternalXUmlb.g:6137:2: ( rule__SubtypeGroup__CoverAssignment_3 )?
            {
             before(grammarAccess.getSubtypeGroupAccess().getCoverAssignment_3()); 
            // InternalXUmlb.g:6138:2: ( rule__SubtypeGroup__CoverAssignment_3 )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==162) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalXUmlb.g:6138:3: rule__SubtypeGroup__CoverAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__SubtypeGroup__CoverAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubtypeGroupAccess().getCoverAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__Group__3__Impl"


    // $ANTLR start "rule__SubtypeGroup__Group__4"
    // InternalXUmlb.g:6146:1: rule__SubtypeGroup__Group__4 : rule__SubtypeGroup__Group__4__Impl ;
    public final void rule__SubtypeGroup__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6150:1: ( rule__SubtypeGroup__Group__4__Impl )
            // InternalXUmlb.g:6151:2: rule__SubtypeGroup__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SubtypeGroup__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__Group__4"


    // $ANTLR start "rule__SubtypeGroup__Group__4__Impl"
    // InternalXUmlb.g:6157:1: rule__SubtypeGroup__Group__4__Impl : ( ( rule__SubtypeGroup__DisjointAssignment_4 )? ) ;
    public final void rule__SubtypeGroup__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6161:1: ( ( ( rule__SubtypeGroup__DisjointAssignment_4 )? ) )
            // InternalXUmlb.g:6162:1: ( ( rule__SubtypeGroup__DisjointAssignment_4 )? )
            {
            // InternalXUmlb.g:6162:1: ( ( rule__SubtypeGroup__DisjointAssignment_4 )? )
            // InternalXUmlb.g:6163:2: ( rule__SubtypeGroup__DisjointAssignment_4 )?
            {
             before(grammarAccess.getSubtypeGroupAccess().getDisjointAssignment_4()); 
            // InternalXUmlb.g:6164:2: ( rule__SubtypeGroup__DisjointAssignment_4 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==163) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalXUmlb.g:6164:3: rule__SubtypeGroup__DisjointAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__SubtypeGroup__DisjointAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubtypeGroupAccess().getDisjointAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__Group__4__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__0"
    // InternalXUmlb.g:6173:1: rule__ClassAttribute__Group__0 : rule__ClassAttribute__Group__0__Impl rule__ClassAttribute__Group__1 ;
    public final void rule__ClassAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6177:1: ( rule__ClassAttribute__Group__0__Impl rule__ClassAttribute__Group__1 )
            // InternalXUmlb.g:6178:2: rule__ClassAttribute__Group__0__Impl rule__ClassAttribute__Group__1
            {
            pushFollow(FOLLOW_52);
            rule__ClassAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__0"


    // $ANTLR start "rule__ClassAttribute__Group__0__Impl"
    // InternalXUmlb.g:6185:1: rule__ClassAttribute__Group__0__Impl : ( () ) ;
    public final void rule__ClassAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6189:1: ( ( () ) )
            // InternalXUmlb.g:6190:1: ( () )
            {
            // InternalXUmlb.g:6190:1: ( () )
            // InternalXUmlb.g:6191:2: ()
            {
             before(grammarAccess.getClassAttributeAccess().getClassAttributeAction_0()); 
            // InternalXUmlb.g:6192:2: ()
            // InternalXUmlb.g:6192:3: 
            {
            }

             after(grammarAccess.getClassAttributeAccess().getClassAttributeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__0__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__1"
    // InternalXUmlb.g:6200:1: rule__ClassAttribute__Group__1 : rule__ClassAttribute__Group__1__Impl rule__ClassAttribute__Group__2 ;
    public final void rule__ClassAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6204:1: ( rule__ClassAttribute__Group__1__Impl rule__ClassAttribute__Group__2 )
            // InternalXUmlb.g:6205:2: rule__ClassAttribute__Group__1__Impl rule__ClassAttribute__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ClassAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__1"


    // $ANTLR start "rule__ClassAttribute__Group__1__Impl"
    // InternalXUmlb.g:6212:1: rule__ClassAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__ClassAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6216:1: ( ( 'attribute' ) )
            // InternalXUmlb.g:6217:1: ( 'attribute' )
            {
            // InternalXUmlb.g:6217:1: ( 'attribute' )
            // InternalXUmlb.g:6218:2: 'attribute'
            {
             before(grammarAccess.getClassAttributeAccess().getAttributeKeyword_1()); 
            match(input,150,FOLLOW_2); 
             after(grammarAccess.getClassAttributeAccess().getAttributeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__1__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__2"
    // InternalXUmlb.g:6227:1: rule__ClassAttribute__Group__2 : rule__ClassAttribute__Group__2__Impl rule__ClassAttribute__Group__3 ;
    public final void rule__ClassAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6231:1: ( rule__ClassAttribute__Group__2__Impl rule__ClassAttribute__Group__3 )
            // InternalXUmlb.g:6232:2: rule__ClassAttribute__Group__2__Impl rule__ClassAttribute__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__ClassAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__2"


    // $ANTLR start "rule__ClassAttribute__Group__2__Impl"
    // InternalXUmlb.g:6239:1: rule__ClassAttribute__Group__2__Impl : ( ( rule__ClassAttribute__NameAssignment_2 ) ) ;
    public final void rule__ClassAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6243:1: ( ( ( rule__ClassAttribute__NameAssignment_2 ) ) )
            // InternalXUmlb.g:6244:1: ( ( rule__ClassAttribute__NameAssignment_2 ) )
            {
            // InternalXUmlb.g:6244:1: ( ( rule__ClassAttribute__NameAssignment_2 ) )
            // InternalXUmlb.g:6245:2: ( rule__ClassAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getClassAttributeAccess().getNameAssignment_2()); 
            // InternalXUmlb.g:6246:2: ( rule__ClassAttribute__NameAssignment_2 )
            // InternalXUmlb.g:6246:3: rule__ClassAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ClassAttribute__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getClassAttributeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__2__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__3"
    // InternalXUmlb.g:6254:1: rule__ClassAttribute__Group__3 : rule__ClassAttribute__Group__3__Impl rule__ClassAttribute__Group__4 ;
    public final void rule__ClassAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6258:1: ( rule__ClassAttribute__Group__3__Impl rule__ClassAttribute__Group__4 )
            // InternalXUmlb.g:6259:2: rule__ClassAttribute__Group__3__Impl rule__ClassAttribute__Group__4
            {
            pushFollow(FOLLOW_41);
            rule__ClassAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__3"


    // $ANTLR start "rule__ClassAttribute__Group__3__Impl"
    // InternalXUmlb.g:6266:1: rule__ClassAttribute__Group__3__Impl : ( '(' ) ;
    public final void rule__ClassAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6270:1: ( ( '(' ) )
            // InternalXUmlb.g:6271:1: ( '(' )
            {
            // InternalXUmlb.g:6271:1: ( '(' )
            // InternalXUmlb.g:6272:2: '('
            {
             before(grammarAccess.getClassAttributeAccess().getLeftParenthesisKeyword_3()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getClassAttributeAccess().getLeftParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__3__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__4"
    // InternalXUmlb.g:6281:1: rule__ClassAttribute__Group__4 : rule__ClassAttribute__Group__4__Impl rule__ClassAttribute__Group__5 ;
    public final void rule__ClassAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6285:1: ( rule__ClassAttribute__Group__4__Impl rule__ClassAttribute__Group__5 )
            // InternalXUmlb.g:6286:2: rule__ClassAttribute__Group__4__Impl rule__ClassAttribute__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__ClassAttribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__4"


    // $ANTLR start "rule__ClassAttribute__Group__4__Impl"
    // InternalXUmlb.g:6293:1: rule__ClassAttribute__Group__4__Impl : ( ( rule__ClassAttribute__DataKindAssignment_4 ) ) ;
    public final void rule__ClassAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6297:1: ( ( ( rule__ClassAttribute__DataKindAssignment_4 ) ) )
            // InternalXUmlb.g:6298:1: ( ( rule__ClassAttribute__DataKindAssignment_4 ) )
            {
            // InternalXUmlb.g:6298:1: ( ( rule__ClassAttribute__DataKindAssignment_4 ) )
            // InternalXUmlb.g:6299:2: ( rule__ClassAttribute__DataKindAssignment_4 )
            {
             before(grammarAccess.getClassAttributeAccess().getDataKindAssignment_4()); 
            // InternalXUmlb.g:6300:2: ( rule__ClassAttribute__DataKindAssignment_4 )
            // InternalXUmlb.g:6300:3: rule__ClassAttribute__DataKindAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ClassAttribute__DataKindAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getClassAttributeAccess().getDataKindAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__4__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__5"
    // InternalXUmlb.g:6308:1: rule__ClassAttribute__Group__5 : rule__ClassAttribute__Group__5__Impl rule__ClassAttribute__Group__6 ;
    public final void rule__ClassAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6312:1: ( rule__ClassAttribute__Group__5__Impl rule__ClassAttribute__Group__6 )
            // InternalXUmlb.g:6313:2: rule__ClassAttribute__Group__5__Impl rule__ClassAttribute__Group__6
            {
            pushFollow(FOLLOW_53);
            rule__ClassAttribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__5"


    // $ANTLR start "rule__ClassAttribute__Group__5__Impl"
    // InternalXUmlb.g:6320:1: rule__ClassAttribute__Group__5__Impl : ( ')' ) ;
    public final void rule__ClassAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6324:1: ( ( ')' ) )
            // InternalXUmlb.g:6325:1: ( ')' )
            {
            // InternalXUmlb.g:6325:1: ( ')' )
            // InternalXUmlb.g:6326:2: ')'
            {
             before(grammarAccess.getClassAttributeAccess().getRightParenthesisKeyword_5()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getClassAttributeAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__5__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__6"
    // InternalXUmlb.g:6335:1: rule__ClassAttribute__Group__6 : rule__ClassAttribute__Group__6__Impl rule__ClassAttribute__Group__7 ;
    public final void rule__ClassAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6339:1: ( rule__ClassAttribute__Group__6__Impl rule__ClassAttribute__Group__7 )
            // InternalXUmlb.g:6340:2: rule__ClassAttribute__Group__6__Impl rule__ClassAttribute__Group__7
            {
            pushFollow(FOLLOW_53);
            rule__ClassAttribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__6"


    // $ANTLR start "rule__ClassAttribute__Group__6__Impl"
    // InternalXUmlb.g:6347:1: rule__ClassAttribute__Group__6__Impl : ( ( rule__ClassAttribute__Group_6__0 )? ) ;
    public final void rule__ClassAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6351:1: ( ( ( rule__ClassAttribute__Group_6__0 )? ) )
            // InternalXUmlb.g:6352:1: ( ( rule__ClassAttribute__Group_6__0 )? )
            {
            // InternalXUmlb.g:6352:1: ( ( rule__ClassAttribute__Group_6__0 )? )
            // InternalXUmlb.g:6353:2: ( rule__ClassAttribute__Group_6__0 )?
            {
             before(grammarAccess.getClassAttributeAccess().getGroup_6()); 
            // InternalXUmlb.g:6354:2: ( rule__ClassAttribute__Group_6__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==120) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalXUmlb.g:6354:3: rule__ClassAttribute__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassAttribute__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAttributeAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__6__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__7"
    // InternalXUmlb.g:6362:1: rule__ClassAttribute__Group__7 : rule__ClassAttribute__Group__7__Impl rule__ClassAttribute__Group__8 ;
    public final void rule__ClassAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6366:1: ( rule__ClassAttribute__Group__7__Impl rule__ClassAttribute__Group__8 )
            // InternalXUmlb.g:6367:2: rule__ClassAttribute__Group__7__Impl rule__ClassAttribute__Group__8
            {
            pushFollow(FOLLOW_53);
            rule__ClassAttribute__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__7"


    // $ANTLR start "rule__ClassAttribute__Group__7__Impl"
    // InternalXUmlb.g:6374:1: rule__ClassAttribute__Group__7__Impl : ( ( rule__ClassAttribute__FunctionalAssignment_7 )? ) ;
    public final void rule__ClassAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6378:1: ( ( ( rule__ClassAttribute__FunctionalAssignment_7 )? ) )
            // InternalXUmlb.g:6379:1: ( ( rule__ClassAttribute__FunctionalAssignment_7 )? )
            {
            // InternalXUmlb.g:6379:1: ( ( rule__ClassAttribute__FunctionalAssignment_7 )? )
            // InternalXUmlb.g:6380:2: ( rule__ClassAttribute__FunctionalAssignment_7 )?
            {
             before(grammarAccess.getClassAttributeAccess().getFunctionalAssignment_7()); 
            // InternalXUmlb.g:6381:2: ( rule__ClassAttribute__FunctionalAssignment_7 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==158) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalXUmlb.g:6381:3: rule__ClassAttribute__FunctionalAssignment_7
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassAttribute__FunctionalAssignment_7();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAttributeAccess().getFunctionalAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__7__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__8"
    // InternalXUmlb.g:6389:1: rule__ClassAttribute__Group__8 : rule__ClassAttribute__Group__8__Impl rule__ClassAttribute__Group__9 ;
    public final void rule__ClassAttribute__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6393:1: ( rule__ClassAttribute__Group__8__Impl rule__ClassAttribute__Group__9 )
            // InternalXUmlb.g:6394:2: rule__ClassAttribute__Group__8__Impl rule__ClassAttribute__Group__9
            {
            pushFollow(FOLLOW_53);
            rule__ClassAttribute__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__8"


    // $ANTLR start "rule__ClassAttribute__Group__8__Impl"
    // InternalXUmlb.g:6401:1: rule__ClassAttribute__Group__8__Impl : ( ( rule__ClassAttribute__TotalAssignment_8 )? ) ;
    public final void rule__ClassAttribute__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6405:1: ( ( ( rule__ClassAttribute__TotalAssignment_8 )? ) )
            // InternalXUmlb.g:6406:1: ( ( rule__ClassAttribute__TotalAssignment_8 )? )
            {
            // InternalXUmlb.g:6406:1: ( ( rule__ClassAttribute__TotalAssignment_8 )? )
            // InternalXUmlb.g:6407:2: ( rule__ClassAttribute__TotalAssignment_8 )?
            {
             before(grammarAccess.getClassAttributeAccess().getTotalAssignment_8()); 
            // InternalXUmlb.g:6408:2: ( rule__ClassAttribute__TotalAssignment_8 )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==159) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalXUmlb.g:6408:3: rule__ClassAttribute__TotalAssignment_8
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassAttribute__TotalAssignment_8();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAttributeAccess().getTotalAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__8__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__9"
    // InternalXUmlb.g:6416:1: rule__ClassAttribute__Group__9 : rule__ClassAttribute__Group__9__Impl rule__ClassAttribute__Group__10 ;
    public final void rule__ClassAttribute__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6420:1: ( rule__ClassAttribute__Group__9__Impl rule__ClassAttribute__Group__10 )
            // InternalXUmlb.g:6421:2: rule__ClassAttribute__Group__9__Impl rule__ClassAttribute__Group__10
            {
            pushFollow(FOLLOW_53);
            rule__ClassAttribute__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__9"


    // $ANTLR start "rule__ClassAttribute__Group__9__Impl"
    // InternalXUmlb.g:6428:1: rule__ClassAttribute__Group__9__Impl : ( ( rule__ClassAttribute__SurjectiveAssignment_9 )? ) ;
    public final void rule__ClassAttribute__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6432:1: ( ( ( rule__ClassAttribute__SurjectiveAssignment_9 )? ) )
            // InternalXUmlb.g:6433:1: ( ( rule__ClassAttribute__SurjectiveAssignment_9 )? )
            {
            // InternalXUmlb.g:6433:1: ( ( rule__ClassAttribute__SurjectiveAssignment_9 )? )
            // InternalXUmlb.g:6434:2: ( rule__ClassAttribute__SurjectiveAssignment_9 )?
            {
             before(grammarAccess.getClassAttributeAccess().getSurjectiveAssignment_9()); 
            // InternalXUmlb.g:6435:2: ( rule__ClassAttribute__SurjectiveAssignment_9 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==160) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalXUmlb.g:6435:3: rule__ClassAttribute__SurjectiveAssignment_9
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassAttribute__SurjectiveAssignment_9();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAttributeAccess().getSurjectiveAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__9__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__10"
    // InternalXUmlb.g:6443:1: rule__ClassAttribute__Group__10 : rule__ClassAttribute__Group__10__Impl rule__ClassAttribute__Group__11 ;
    public final void rule__ClassAttribute__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6447:1: ( rule__ClassAttribute__Group__10__Impl rule__ClassAttribute__Group__11 )
            // InternalXUmlb.g:6448:2: rule__ClassAttribute__Group__10__Impl rule__ClassAttribute__Group__11
            {
            pushFollow(FOLLOW_53);
            rule__ClassAttribute__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__10"


    // $ANTLR start "rule__ClassAttribute__Group__10__Impl"
    // InternalXUmlb.g:6455:1: rule__ClassAttribute__Group__10__Impl : ( ( rule__ClassAttribute__InjectiveAssignment_10 )? ) ;
    public final void rule__ClassAttribute__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6459:1: ( ( ( rule__ClassAttribute__InjectiveAssignment_10 )? ) )
            // InternalXUmlb.g:6460:1: ( ( rule__ClassAttribute__InjectiveAssignment_10 )? )
            {
            // InternalXUmlb.g:6460:1: ( ( rule__ClassAttribute__InjectiveAssignment_10 )? )
            // InternalXUmlb.g:6461:2: ( rule__ClassAttribute__InjectiveAssignment_10 )?
            {
             before(grammarAccess.getClassAttributeAccess().getInjectiveAssignment_10()); 
            // InternalXUmlb.g:6462:2: ( rule__ClassAttribute__InjectiveAssignment_10 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==161) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalXUmlb.g:6462:3: rule__ClassAttribute__InjectiveAssignment_10
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassAttribute__InjectiveAssignment_10();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAttributeAccess().getInjectiveAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__10__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__11"
    // InternalXUmlb.g:6470:1: rule__ClassAttribute__Group__11 : rule__ClassAttribute__Group__11__Impl rule__ClassAttribute__Group__12 ;
    public final void rule__ClassAttribute__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6474:1: ( rule__ClassAttribute__Group__11__Impl rule__ClassAttribute__Group__12 )
            // InternalXUmlb.g:6475:2: rule__ClassAttribute__Group__11__Impl rule__ClassAttribute__Group__12
            {
            pushFollow(FOLLOW_53);
            rule__ClassAttribute__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__11"


    // $ANTLR start "rule__ClassAttribute__Group__11__Impl"
    // InternalXUmlb.g:6482:1: rule__ClassAttribute__Group__11__Impl : ( ( rule__ClassAttribute__Group_11__0 )? ) ;
    public final void rule__ClassAttribute__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6486:1: ( ( ( rule__ClassAttribute__Group_11__0 )? ) )
            // InternalXUmlb.g:6487:1: ( ( rule__ClassAttribute__Group_11__0 )? )
            {
            // InternalXUmlb.g:6487:1: ( ( rule__ClassAttribute__Group_11__0 )? )
            // InternalXUmlb.g:6488:2: ( rule__ClassAttribute__Group_11__0 )?
            {
             before(grammarAccess.getClassAttributeAccess().getGroup_11()); 
            // InternalXUmlb.g:6489:2: ( rule__ClassAttribute__Group_11__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==148) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalXUmlb.g:6489:3: rule__ClassAttribute__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassAttribute__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAttributeAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__11__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__12"
    // InternalXUmlb.g:6497:1: rule__ClassAttribute__Group__12 : rule__ClassAttribute__Group__12__Impl rule__ClassAttribute__Group__13 ;
    public final void rule__ClassAttribute__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6501:1: ( rule__ClassAttribute__Group__12__Impl rule__ClassAttribute__Group__13 )
            // InternalXUmlb.g:6502:2: rule__ClassAttribute__Group__12__Impl rule__ClassAttribute__Group__13
            {
            pushFollow(FOLLOW_15);
            rule__ClassAttribute__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__12"


    // $ANTLR start "rule__ClassAttribute__Group__12__Impl"
    // InternalXUmlb.g:6509:1: rule__ClassAttribute__Group__12__Impl : ( 'target' ) ;
    public final void rule__ClassAttribute__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6513:1: ( ( 'target' ) )
            // InternalXUmlb.g:6514:1: ( 'target' )
            {
            // InternalXUmlb.g:6514:1: ( 'target' )
            // InternalXUmlb.g:6515:2: 'target'
            {
             before(grammarAccess.getClassAttributeAccess().getTargetKeyword_12()); 
            match(input,128,FOLLOW_2); 
             after(grammarAccess.getClassAttributeAccess().getTargetKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__12__Impl"


    // $ANTLR start "rule__ClassAttribute__Group__13"
    // InternalXUmlb.g:6524:1: rule__ClassAttribute__Group__13 : rule__ClassAttribute__Group__13__Impl ;
    public final void rule__ClassAttribute__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6528:1: ( rule__ClassAttribute__Group__13__Impl )
            // InternalXUmlb.g:6529:2: rule__ClassAttribute__Group__13__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group__13__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__13"


    // $ANTLR start "rule__ClassAttribute__Group__13__Impl"
    // InternalXUmlb.g:6535:1: rule__ClassAttribute__Group__13__Impl : ( ( rule__ClassAttribute__TargetAssignment_13 ) ) ;
    public final void rule__ClassAttribute__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6539:1: ( ( ( rule__ClassAttribute__TargetAssignment_13 ) ) )
            // InternalXUmlb.g:6540:1: ( ( rule__ClassAttribute__TargetAssignment_13 ) )
            {
            // InternalXUmlb.g:6540:1: ( ( rule__ClassAttribute__TargetAssignment_13 ) )
            // InternalXUmlb.g:6541:2: ( rule__ClassAttribute__TargetAssignment_13 )
            {
             before(grammarAccess.getClassAttributeAccess().getTargetAssignment_13()); 
            // InternalXUmlb.g:6542:2: ( rule__ClassAttribute__TargetAssignment_13 )
            // InternalXUmlb.g:6542:3: rule__ClassAttribute__TargetAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__ClassAttribute__TargetAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getClassAttributeAccess().getTargetAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group__13__Impl"


    // $ANTLR start "rule__ClassAttribute__Group_6__0"
    // InternalXUmlb.g:6551:1: rule__ClassAttribute__Group_6__0 : rule__ClassAttribute__Group_6__0__Impl rule__ClassAttribute__Group_6__1 ;
    public final void rule__ClassAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6555:1: ( rule__ClassAttribute__Group_6__0__Impl rule__ClassAttribute__Group_6__1 )
            // InternalXUmlb.g:6556:2: rule__ClassAttribute__Group_6__0__Impl rule__ClassAttribute__Group_6__1
            {
            pushFollow(FOLLOW_4);
            rule__ClassAttribute__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group_6__0"


    // $ANTLR start "rule__ClassAttribute__Group_6__0__Impl"
    // InternalXUmlb.g:6563:1: rule__ClassAttribute__Group_6__0__Impl : ( 'elaborates' ) ;
    public final void rule__ClassAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6567:1: ( ( 'elaborates' ) )
            // InternalXUmlb.g:6568:1: ( 'elaborates' )
            {
            // InternalXUmlb.g:6568:1: ( 'elaborates' )
            // InternalXUmlb.g:6569:2: 'elaborates'
            {
             before(grammarAccess.getClassAttributeAccess().getElaboratesKeyword_6_0()); 
            match(input,120,FOLLOW_2); 
             after(grammarAccess.getClassAttributeAccess().getElaboratesKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group_6__0__Impl"


    // $ANTLR start "rule__ClassAttribute__Group_6__1"
    // InternalXUmlb.g:6578:1: rule__ClassAttribute__Group_6__1 : rule__ClassAttribute__Group_6__1__Impl ;
    public final void rule__ClassAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6582:1: ( rule__ClassAttribute__Group_6__1__Impl )
            // InternalXUmlb.g:6583:2: rule__ClassAttribute__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group_6__1"


    // $ANTLR start "rule__ClassAttribute__Group_6__1__Impl"
    // InternalXUmlb.g:6589:1: rule__ClassAttribute__Group_6__1__Impl : ( ( rule__ClassAttribute__ElaboratesAssignment_6_1 ) ) ;
    public final void rule__ClassAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6593:1: ( ( ( rule__ClassAttribute__ElaboratesAssignment_6_1 ) ) )
            // InternalXUmlb.g:6594:1: ( ( rule__ClassAttribute__ElaboratesAssignment_6_1 ) )
            {
            // InternalXUmlb.g:6594:1: ( ( rule__ClassAttribute__ElaboratesAssignment_6_1 ) )
            // InternalXUmlb.g:6595:2: ( rule__ClassAttribute__ElaboratesAssignment_6_1 )
            {
             before(grammarAccess.getClassAttributeAccess().getElaboratesAssignment_6_1()); 
            // InternalXUmlb.g:6596:2: ( rule__ClassAttribute__ElaboratesAssignment_6_1 )
            // InternalXUmlb.g:6596:3: rule__ClassAttribute__ElaboratesAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassAttribute__ElaboratesAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAttributeAccess().getElaboratesAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group_6__1__Impl"


    // $ANTLR start "rule__ClassAttribute__Group_11__0"
    // InternalXUmlb.g:6605:1: rule__ClassAttribute__Group_11__0 : rule__ClassAttribute__Group_11__0__Impl rule__ClassAttribute__Group_11__1 ;
    public final void rule__ClassAttribute__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6609:1: ( rule__ClassAttribute__Group_11__0__Impl rule__ClassAttribute__Group_11__1 )
            // InternalXUmlb.g:6610:2: rule__ClassAttribute__Group_11__0__Impl rule__ClassAttribute__Group_11__1
            {
            pushFollow(FOLLOW_15);
            rule__ClassAttribute__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group_11__0"


    // $ANTLR start "rule__ClassAttribute__Group_11__0__Impl"
    // InternalXUmlb.g:6617:1: rule__ClassAttribute__Group_11__0__Impl : ( 'initialValue' ) ;
    public final void rule__ClassAttribute__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6621:1: ( ( 'initialValue' ) )
            // InternalXUmlb.g:6622:1: ( 'initialValue' )
            {
            // InternalXUmlb.g:6622:1: ( 'initialValue' )
            // InternalXUmlb.g:6623:2: 'initialValue'
            {
             before(grammarAccess.getClassAttributeAccess().getInitialValueKeyword_11_0()); 
            match(input,148,FOLLOW_2); 
             after(grammarAccess.getClassAttributeAccess().getInitialValueKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group_11__0__Impl"


    // $ANTLR start "rule__ClassAttribute__Group_11__1"
    // InternalXUmlb.g:6632:1: rule__ClassAttribute__Group_11__1 : rule__ClassAttribute__Group_11__1__Impl ;
    public final void rule__ClassAttribute__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6636:1: ( rule__ClassAttribute__Group_11__1__Impl )
            // InternalXUmlb.g:6637:2: rule__ClassAttribute__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassAttribute__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group_11__1"


    // $ANTLR start "rule__ClassAttribute__Group_11__1__Impl"
    // InternalXUmlb.g:6643:1: rule__ClassAttribute__Group_11__1__Impl : ( ( rule__ClassAttribute__InitialValueAssignment_11_1 ) ) ;
    public final void rule__ClassAttribute__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6647:1: ( ( ( rule__ClassAttribute__InitialValueAssignment_11_1 ) ) )
            // InternalXUmlb.g:6648:1: ( ( rule__ClassAttribute__InitialValueAssignment_11_1 ) )
            {
            // InternalXUmlb.g:6648:1: ( ( rule__ClassAttribute__InitialValueAssignment_11_1 ) )
            // InternalXUmlb.g:6649:2: ( rule__ClassAttribute__InitialValueAssignment_11_1 )
            {
             before(grammarAccess.getClassAttributeAccess().getInitialValueAssignment_11_1()); 
            // InternalXUmlb.g:6650:2: ( rule__ClassAttribute__InitialValueAssignment_11_1 )
            // InternalXUmlb.g:6650:3: rule__ClassAttribute__InitialValueAssignment_11_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassAttribute__InitialValueAssignment_11_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAttributeAccess().getInitialValueAssignment_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__Group_11__1__Impl"


    // $ANTLR start "rule__ClassConstraint__Group__0"
    // InternalXUmlb.g:6659:1: rule__ClassConstraint__Group__0 : rule__ClassConstraint__Group__0__Impl rule__ClassConstraint__Group__1 ;
    public final void rule__ClassConstraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6663:1: ( rule__ClassConstraint__Group__0__Impl rule__ClassConstraint__Group__1 )
            // InternalXUmlb.g:6664:2: rule__ClassConstraint__Group__0__Impl rule__ClassConstraint__Group__1
            {
            pushFollow(FOLLOW_54);
            rule__ClassConstraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassConstraint__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__0"


    // $ANTLR start "rule__ClassConstraint__Group__0__Impl"
    // InternalXUmlb.g:6671:1: rule__ClassConstraint__Group__0__Impl : ( () ) ;
    public final void rule__ClassConstraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6675:1: ( ( () ) )
            // InternalXUmlb.g:6676:1: ( () )
            {
            // InternalXUmlb.g:6676:1: ( () )
            // InternalXUmlb.g:6677:2: ()
            {
             before(grammarAccess.getClassConstraintAccess().getClassConstraintAction_0()); 
            // InternalXUmlb.g:6678:2: ()
            // InternalXUmlb.g:6678:3: 
            {
            }

             after(grammarAccess.getClassConstraintAccess().getClassConstraintAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__0__Impl"


    // $ANTLR start "rule__ClassConstraint__Group__1"
    // InternalXUmlb.g:6686:1: rule__ClassConstraint__Group__1 : rule__ClassConstraint__Group__1__Impl rule__ClassConstraint__Group__2 ;
    public final void rule__ClassConstraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6690:1: ( rule__ClassConstraint__Group__1__Impl rule__ClassConstraint__Group__2 )
            // InternalXUmlb.g:6691:2: rule__ClassConstraint__Group__1__Impl rule__ClassConstraint__Group__2
            {
            pushFollow(FOLLOW_55);
            rule__ClassConstraint__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassConstraint__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__1"


    // $ANTLR start "rule__ClassConstraint__Group__1__Impl"
    // InternalXUmlb.g:6698:1: rule__ClassConstraint__Group__1__Impl : ( 'constraint' ) ;
    public final void rule__ClassConstraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6702:1: ( ( 'constraint' ) )
            // InternalXUmlb.g:6703:1: ( 'constraint' )
            {
            // InternalXUmlb.g:6703:1: ( 'constraint' )
            // InternalXUmlb.g:6704:2: 'constraint'
            {
             before(grammarAccess.getClassConstraintAccess().getConstraintKeyword_1()); 
            match(input,151,FOLLOW_2); 
             after(grammarAccess.getClassConstraintAccess().getConstraintKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__1__Impl"


    // $ANTLR start "rule__ClassConstraint__Group__2"
    // InternalXUmlb.g:6713:1: rule__ClassConstraint__Group__2 : rule__ClassConstraint__Group__2__Impl rule__ClassConstraint__Group__3 ;
    public final void rule__ClassConstraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6717:1: ( rule__ClassConstraint__Group__2__Impl rule__ClassConstraint__Group__3 )
            // InternalXUmlb.g:6718:2: rule__ClassConstraint__Group__2__Impl rule__ClassConstraint__Group__3
            {
            pushFollow(FOLLOW_55);
            rule__ClassConstraint__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassConstraint__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__2"


    // $ANTLR start "rule__ClassConstraint__Group__2__Impl"
    // InternalXUmlb.g:6725:1: rule__ClassConstraint__Group__2__Impl : ( ( rule__ClassConstraint__TheoremAssignment_2 )? ) ;
    public final void rule__ClassConstraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6729:1: ( ( ( rule__ClassConstraint__TheoremAssignment_2 )? ) )
            // InternalXUmlb.g:6730:1: ( ( rule__ClassConstraint__TheoremAssignment_2 )? )
            {
            // InternalXUmlb.g:6730:1: ( ( rule__ClassConstraint__TheoremAssignment_2 )? )
            // InternalXUmlb.g:6731:2: ( rule__ClassConstraint__TheoremAssignment_2 )?
            {
             before(grammarAccess.getClassConstraintAccess().getTheoremAssignment_2()); 
            // InternalXUmlb.g:6732:2: ( rule__ClassConstraint__TheoremAssignment_2 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==164) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalXUmlb.g:6732:3: rule__ClassConstraint__TheoremAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassConstraint__TheoremAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassConstraintAccess().getTheoremAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__2__Impl"


    // $ANTLR start "rule__ClassConstraint__Group__3"
    // InternalXUmlb.g:6740:1: rule__ClassConstraint__Group__3 : rule__ClassConstraint__Group__3__Impl rule__ClassConstraint__Group__4 ;
    public final void rule__ClassConstraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6744:1: ( rule__ClassConstraint__Group__3__Impl rule__ClassConstraint__Group__4 )
            // InternalXUmlb.g:6745:2: rule__ClassConstraint__Group__3__Impl rule__ClassConstraint__Group__4
            {
            pushFollow(FOLLOW_56);
            rule__ClassConstraint__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassConstraint__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__3"


    // $ANTLR start "rule__ClassConstraint__Group__3__Impl"
    // InternalXUmlb.g:6752:1: rule__ClassConstraint__Group__3__Impl : ( ( rule__ClassConstraint__NameAssignment_3 ) ) ;
    public final void rule__ClassConstraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6756:1: ( ( ( rule__ClassConstraint__NameAssignment_3 ) ) )
            // InternalXUmlb.g:6757:1: ( ( rule__ClassConstraint__NameAssignment_3 ) )
            {
            // InternalXUmlb.g:6757:1: ( ( rule__ClassConstraint__NameAssignment_3 ) )
            // InternalXUmlb.g:6758:2: ( rule__ClassConstraint__NameAssignment_3 )
            {
             before(grammarAccess.getClassConstraintAccess().getNameAssignment_3()); 
            // InternalXUmlb.g:6759:2: ( rule__ClassConstraint__NameAssignment_3 )
            // InternalXUmlb.g:6759:3: rule__ClassConstraint__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ClassConstraint__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getClassConstraintAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__3__Impl"


    // $ANTLR start "rule__ClassConstraint__Group__4"
    // InternalXUmlb.g:6767:1: rule__ClassConstraint__Group__4 : rule__ClassConstraint__Group__4__Impl rule__ClassConstraint__Group__5 ;
    public final void rule__ClassConstraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6771:1: ( rule__ClassConstraint__Group__4__Impl rule__ClassConstraint__Group__5 )
            // InternalXUmlb.g:6772:2: rule__ClassConstraint__Group__4__Impl rule__ClassConstraint__Group__5
            {
            pushFollow(FOLLOW_57);
            rule__ClassConstraint__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassConstraint__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__4"


    // $ANTLR start "rule__ClassConstraint__Group__4__Impl"
    // InternalXUmlb.g:6779:1: rule__ClassConstraint__Group__4__Impl : ( ( rule__ClassConstraint__PredicateAssignment_4 ) ) ;
    public final void rule__ClassConstraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6783:1: ( ( ( rule__ClassConstraint__PredicateAssignment_4 ) ) )
            // InternalXUmlb.g:6784:1: ( ( rule__ClassConstraint__PredicateAssignment_4 ) )
            {
            // InternalXUmlb.g:6784:1: ( ( rule__ClassConstraint__PredicateAssignment_4 ) )
            // InternalXUmlb.g:6785:2: ( rule__ClassConstraint__PredicateAssignment_4 )
            {
             before(grammarAccess.getClassConstraintAccess().getPredicateAssignment_4()); 
            // InternalXUmlb.g:6786:2: ( rule__ClassConstraint__PredicateAssignment_4 )
            // InternalXUmlb.g:6786:3: rule__ClassConstraint__PredicateAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ClassConstraint__PredicateAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getClassConstraintAccess().getPredicateAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__4__Impl"


    // $ANTLR start "rule__ClassConstraint__Group__5"
    // InternalXUmlb.g:6794:1: rule__ClassConstraint__Group__5 : rule__ClassConstraint__Group__5__Impl rule__ClassConstraint__Group__6 ;
    public final void rule__ClassConstraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6798:1: ( rule__ClassConstraint__Group__5__Impl rule__ClassConstraint__Group__6 )
            // InternalXUmlb.g:6799:2: rule__ClassConstraint__Group__5__Impl rule__ClassConstraint__Group__6
            {
            pushFollow(FOLLOW_4);
            rule__ClassConstraint__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassConstraint__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__5"


    // $ANTLR start "rule__ClassConstraint__Group__5__Impl"
    // InternalXUmlb.g:6806:1: rule__ClassConstraint__Group__5__Impl : ( 'component' ) ;
    public final void rule__ClassConstraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6810:1: ( ( 'component' ) )
            // InternalXUmlb.g:6811:1: ( 'component' )
            {
            // InternalXUmlb.g:6811:1: ( 'component' )
            // InternalXUmlb.g:6812:2: 'component'
            {
             before(grammarAccess.getClassConstraintAccess().getComponentKeyword_5()); 
            match(input,152,FOLLOW_2); 
             after(grammarAccess.getClassConstraintAccess().getComponentKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__5__Impl"


    // $ANTLR start "rule__ClassConstraint__Group__6"
    // InternalXUmlb.g:6821:1: rule__ClassConstraint__Group__6 : rule__ClassConstraint__Group__6__Impl ;
    public final void rule__ClassConstraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6825:1: ( rule__ClassConstraint__Group__6__Impl )
            // InternalXUmlb.g:6826:2: rule__ClassConstraint__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassConstraint__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__6"


    // $ANTLR start "rule__ClassConstraint__Group__6__Impl"
    // InternalXUmlb.g:6832:1: rule__ClassConstraint__Group__6__Impl : ( ( rule__ClassConstraint__ComponentAssignment_6 ) ) ;
    public final void rule__ClassConstraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6836:1: ( ( ( rule__ClassConstraint__ComponentAssignment_6 ) ) )
            // InternalXUmlb.g:6837:1: ( ( rule__ClassConstraint__ComponentAssignment_6 ) )
            {
            // InternalXUmlb.g:6837:1: ( ( rule__ClassConstraint__ComponentAssignment_6 ) )
            // InternalXUmlb.g:6838:2: ( rule__ClassConstraint__ComponentAssignment_6 )
            {
             before(grammarAccess.getClassConstraintAccess().getComponentAssignment_6()); 
            // InternalXUmlb.g:6839:2: ( rule__ClassConstraint__ComponentAssignment_6 )
            // InternalXUmlb.g:6839:3: rule__ClassConstraint__ComponentAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__ClassConstraint__ComponentAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getClassConstraintAccess().getComponentAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__Group__6__Impl"


    // $ANTLR start "rule__ClassMethod__Group__0"
    // InternalXUmlb.g:6848:1: rule__ClassMethod__Group__0 : rule__ClassMethod__Group__0__Impl rule__ClassMethod__Group__1 ;
    public final void rule__ClassMethod__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6852:1: ( rule__ClassMethod__Group__0__Impl rule__ClassMethod__Group__1 )
            // InternalXUmlb.g:6853:2: rule__ClassMethod__Group__0__Impl rule__ClassMethod__Group__1
            {
            pushFollow(FOLLOW_58);
            rule__ClassMethod__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__0"


    // $ANTLR start "rule__ClassMethod__Group__0__Impl"
    // InternalXUmlb.g:6860:1: rule__ClassMethod__Group__0__Impl : ( () ) ;
    public final void rule__ClassMethod__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6864:1: ( ( () ) )
            // InternalXUmlb.g:6865:1: ( () )
            {
            // InternalXUmlb.g:6865:1: ( () )
            // InternalXUmlb.g:6866:2: ()
            {
             before(grammarAccess.getClassMethodAccess().getClassMethodAction_0()); 
            // InternalXUmlb.g:6867:2: ()
            // InternalXUmlb.g:6867:3: 
            {
            }

             after(grammarAccess.getClassMethodAccess().getClassMethodAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__0__Impl"


    // $ANTLR start "rule__ClassMethod__Group__1"
    // InternalXUmlb.g:6875:1: rule__ClassMethod__Group__1 : rule__ClassMethod__Group__1__Impl rule__ClassMethod__Group__2 ;
    public final void rule__ClassMethod__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6879:1: ( rule__ClassMethod__Group__1__Impl rule__ClassMethod__Group__2 )
            // InternalXUmlb.g:6880:2: rule__ClassMethod__Group__1__Impl rule__ClassMethod__Group__2
            {
            pushFollow(FOLLOW_59);
            rule__ClassMethod__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__1"


    // $ANTLR start "rule__ClassMethod__Group__1__Impl"
    // InternalXUmlb.g:6887:1: rule__ClassMethod__Group__1__Impl : ( 'method' ) ;
    public final void rule__ClassMethod__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6891:1: ( ( 'method' ) )
            // InternalXUmlb.g:6892:1: ( 'method' )
            {
            // InternalXUmlb.g:6892:1: ( 'method' )
            // InternalXUmlb.g:6893:2: 'method'
            {
             before(grammarAccess.getClassMethodAccess().getMethodKeyword_1()); 
            match(input,153,FOLLOW_2); 
             after(grammarAccess.getClassMethodAccess().getMethodKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__1__Impl"


    // $ANTLR start "rule__ClassMethod__Group__2"
    // InternalXUmlb.g:6902:1: rule__ClassMethod__Group__2 : rule__ClassMethod__Group__2__Impl rule__ClassMethod__Group__3 ;
    public final void rule__ClassMethod__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6906:1: ( rule__ClassMethod__Group__2__Impl rule__ClassMethod__Group__3 )
            // InternalXUmlb.g:6907:2: rule__ClassMethod__Group__2__Impl rule__ClassMethod__Group__3
            {
            pushFollow(FOLLOW_60);
            rule__ClassMethod__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__2"


    // $ANTLR start "rule__ClassMethod__Group__2__Impl"
    // InternalXUmlb.g:6914:1: rule__ClassMethod__Group__2__Impl : ( 'kind' ) ;
    public final void rule__ClassMethod__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6918:1: ( ( 'kind' ) )
            // InternalXUmlb.g:6919:1: ( 'kind' )
            {
            // InternalXUmlb.g:6919:1: ( 'kind' )
            // InternalXUmlb.g:6920:2: 'kind'
            {
             before(grammarAccess.getClassMethodAccess().getKindKeyword_2()); 
            match(input,154,FOLLOW_2); 
             after(grammarAccess.getClassMethodAccess().getKindKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__2__Impl"


    // $ANTLR start "rule__ClassMethod__Group__3"
    // InternalXUmlb.g:6929:1: rule__ClassMethod__Group__3 : rule__ClassMethod__Group__3__Impl rule__ClassMethod__Group__4 ;
    public final void rule__ClassMethod__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6933:1: ( rule__ClassMethod__Group__3__Impl rule__ClassMethod__Group__4 )
            // InternalXUmlb.g:6934:2: rule__ClassMethod__Group__3__Impl rule__ClassMethod__Group__4
            {
            pushFollow(FOLLOW_61);
            rule__ClassMethod__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__3"


    // $ANTLR start "rule__ClassMethod__Group__3__Impl"
    // InternalXUmlb.g:6941:1: rule__ClassMethod__Group__3__Impl : ( ( rule__ClassMethod__KindAssignment_3 ) ) ;
    public final void rule__ClassMethod__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6945:1: ( ( ( rule__ClassMethod__KindAssignment_3 ) ) )
            // InternalXUmlb.g:6946:1: ( ( rule__ClassMethod__KindAssignment_3 ) )
            {
            // InternalXUmlb.g:6946:1: ( ( rule__ClassMethod__KindAssignment_3 ) )
            // InternalXUmlb.g:6947:2: ( rule__ClassMethod__KindAssignment_3 )
            {
             before(grammarAccess.getClassMethodAccess().getKindAssignment_3()); 
            // InternalXUmlb.g:6948:2: ( rule__ClassMethod__KindAssignment_3 )
            // InternalXUmlb.g:6948:3: rule__ClassMethod__KindAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ClassMethod__KindAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getClassMethodAccess().getKindAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__3__Impl"


    // $ANTLR start "rule__ClassMethod__Group__4"
    // InternalXUmlb.g:6956:1: rule__ClassMethod__Group__4 : rule__ClassMethod__Group__4__Impl rule__ClassMethod__Group__5 ;
    public final void rule__ClassMethod__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6960:1: ( rule__ClassMethod__Group__4__Impl rule__ClassMethod__Group__5 )
            // InternalXUmlb.g:6961:2: rule__ClassMethod__Group__4__Impl rule__ClassMethod__Group__5
            {
            pushFollow(FOLLOW_61);
            rule__ClassMethod__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__4"


    // $ANTLR start "rule__ClassMethod__Group__4__Impl"
    // InternalXUmlb.g:6968:1: rule__ClassMethod__Group__4__Impl : ( ( rule__ClassMethod__Group_4__0 )? ) ;
    public final void rule__ClassMethod__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6972:1: ( ( ( rule__ClassMethod__Group_4__0 )? ) )
            // InternalXUmlb.g:6973:1: ( ( rule__ClassMethod__Group_4__0 )? )
            {
            // InternalXUmlb.g:6973:1: ( ( rule__ClassMethod__Group_4__0 )? )
            // InternalXUmlb.g:6974:2: ( rule__ClassMethod__Group_4__0 )?
            {
             before(grammarAccess.getClassMethodAccess().getGroup_4()); 
            // InternalXUmlb.g:6975:2: ( rule__ClassMethod__Group_4__0 )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==120) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalXUmlb.g:6975:3: rule__ClassMethod__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMethod__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassMethodAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__4__Impl"


    // $ANTLR start "rule__ClassMethod__Group__5"
    // InternalXUmlb.g:6983:1: rule__ClassMethod__Group__5 : rule__ClassMethod__Group__5__Impl rule__ClassMethod__Group__6 ;
    public final void rule__ClassMethod__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6987:1: ( rule__ClassMethod__Group__5__Impl rule__ClassMethod__Group__6 )
            // InternalXUmlb.g:6988:2: rule__ClassMethod__Group__5__Impl rule__ClassMethod__Group__6
            {
            pushFollow(FOLLOW_61);
            rule__ClassMethod__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__5"


    // $ANTLR start "rule__ClassMethod__Group__5__Impl"
    // InternalXUmlb.g:6995:1: rule__ClassMethod__Group__5__Impl : ( ( rule__ClassMethod__ExtendedAssignment_5 )? ) ;
    public final void rule__ClassMethod__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:6999:1: ( ( ( rule__ClassMethod__ExtendedAssignment_5 )? ) )
            // InternalXUmlb.g:7000:1: ( ( rule__ClassMethod__ExtendedAssignment_5 )? )
            {
            // InternalXUmlb.g:7000:1: ( ( rule__ClassMethod__ExtendedAssignment_5 )? )
            // InternalXUmlb.g:7001:2: ( rule__ClassMethod__ExtendedAssignment_5 )?
            {
             before(grammarAccess.getClassMethodAccess().getExtendedAssignment_5()); 
            // InternalXUmlb.g:7002:2: ( rule__ClassMethod__ExtendedAssignment_5 )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==157) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalXUmlb.g:7002:3: rule__ClassMethod__ExtendedAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMethod__ExtendedAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassMethodAccess().getExtendedAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__5__Impl"


    // $ANTLR start "rule__ClassMethod__Group__6"
    // InternalXUmlb.g:7010:1: rule__ClassMethod__Group__6 : rule__ClassMethod__Group__6__Impl rule__ClassMethod__Group__7 ;
    public final void rule__ClassMethod__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7014:1: ( rule__ClassMethod__Group__6__Impl rule__ClassMethod__Group__7 )
            // InternalXUmlb.g:7015:2: rule__ClassMethod__Group__6__Impl rule__ClassMethod__Group__7
            {
            pushFollow(FOLLOW_61);
            rule__ClassMethod__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__6"


    // $ANTLR start "rule__ClassMethod__Group__6__Impl"
    // InternalXUmlb.g:7022:1: rule__ClassMethod__Group__6__Impl : ( ( rule__ClassMethod__Group_6__0 )? ) ;
    public final void rule__ClassMethod__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7026:1: ( ( ( rule__ClassMethod__Group_6__0 )? ) )
            // InternalXUmlb.g:7027:1: ( ( rule__ClassMethod__Group_6__0 )? )
            {
            // InternalXUmlb.g:7027:1: ( ( rule__ClassMethod__Group_6__0 )? )
            // InternalXUmlb.g:7028:2: ( rule__ClassMethod__Group_6__0 )?
            {
             before(grammarAccess.getClassMethodAccess().getGroup_6()); 
            // InternalXUmlb.g:7029:2: ( rule__ClassMethod__Group_6__0 )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==129) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalXUmlb.g:7029:3: rule__ClassMethod__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMethod__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassMethodAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__6__Impl"


    // $ANTLR start "rule__ClassMethod__Group__7"
    // InternalXUmlb.g:7037:1: rule__ClassMethod__Group__7 : rule__ClassMethod__Group__7__Impl rule__ClassMethod__Group__8 ;
    public final void rule__ClassMethod__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7041:1: ( rule__ClassMethod__Group__7__Impl rule__ClassMethod__Group__8 )
            // InternalXUmlb.g:7042:2: rule__ClassMethod__Group__7__Impl rule__ClassMethod__Group__8
            {
            pushFollow(FOLLOW_61);
            rule__ClassMethod__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__7"


    // $ANTLR start "rule__ClassMethod__Group__7__Impl"
    // InternalXUmlb.g:7049:1: rule__ClassMethod__Group__7__Impl : ( ( rule__ClassMethod__Group_7__0 )? ) ;
    public final void rule__ClassMethod__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7053:1: ( ( ( rule__ClassMethod__Group_7__0 )? ) )
            // InternalXUmlb.g:7054:1: ( ( rule__ClassMethod__Group_7__0 )? )
            {
            // InternalXUmlb.g:7054:1: ( ( rule__ClassMethod__Group_7__0 )? )
            // InternalXUmlb.g:7055:2: ( rule__ClassMethod__Group_7__0 )?
            {
             before(grammarAccess.getClassMethodAccess().getGroup_7()); 
            // InternalXUmlb.g:7056:2: ( rule__ClassMethod__Group_7__0 )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==130) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalXUmlb.g:7056:3: rule__ClassMethod__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMethod__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassMethodAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__7__Impl"


    // $ANTLR start "rule__ClassMethod__Group__8"
    // InternalXUmlb.g:7064:1: rule__ClassMethod__Group__8 : rule__ClassMethod__Group__8__Impl rule__ClassMethod__Group__9 ;
    public final void rule__ClassMethod__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7068:1: ( rule__ClassMethod__Group__8__Impl rule__ClassMethod__Group__9 )
            // InternalXUmlb.g:7069:2: rule__ClassMethod__Group__8__Impl rule__ClassMethod__Group__9
            {
            pushFollow(FOLLOW_61);
            rule__ClassMethod__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__8"


    // $ANTLR start "rule__ClassMethod__Group__8__Impl"
    // InternalXUmlb.g:7076:1: rule__ClassMethod__Group__8__Impl : ( ( rule__ClassMethod__Group_8__0 )? ) ;
    public final void rule__ClassMethod__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7080:1: ( ( ( rule__ClassMethod__Group_8__0 )? ) )
            // InternalXUmlb.g:7081:1: ( ( rule__ClassMethod__Group_8__0 )? )
            {
            // InternalXUmlb.g:7081:1: ( ( rule__ClassMethod__Group_8__0 )? )
            // InternalXUmlb.g:7082:2: ( rule__ClassMethod__Group_8__0 )?
            {
             before(grammarAccess.getClassMethodAccess().getGroup_8()); 
            // InternalXUmlb.g:7083:2: ( rule__ClassMethod__Group_8__0 )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==131) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalXUmlb.g:7083:3: rule__ClassMethod__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMethod__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassMethodAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__8__Impl"


    // $ANTLR start "rule__ClassMethod__Group__9"
    // InternalXUmlb.g:7091:1: rule__ClassMethod__Group__9 : rule__ClassMethod__Group__9__Impl rule__ClassMethod__Group__10 ;
    public final void rule__ClassMethod__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7095:1: ( rule__ClassMethod__Group__9__Impl rule__ClassMethod__Group__10 )
            // InternalXUmlb.g:7096:2: rule__ClassMethod__Group__9__Impl rule__ClassMethod__Group__10
            {
            pushFollow(FOLLOW_61);
            rule__ClassMethod__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__9"


    // $ANTLR start "rule__ClassMethod__Group__9__Impl"
    // InternalXUmlb.g:7103:1: rule__ClassMethod__Group__9__Impl : ( ( rule__ClassMethod__Group_9__0 )? ) ;
    public final void rule__ClassMethod__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7107:1: ( ( ( rule__ClassMethod__Group_9__0 )? ) )
            // InternalXUmlb.g:7108:1: ( ( rule__ClassMethod__Group_9__0 )? )
            {
            // InternalXUmlb.g:7108:1: ( ( rule__ClassMethod__Group_9__0 )? )
            // InternalXUmlb.g:7109:2: ( rule__ClassMethod__Group_9__0 )?
            {
             before(grammarAccess.getClassMethodAccess().getGroup_9()); 
            // InternalXUmlb.g:7110:2: ( rule__ClassMethod__Group_9__0 )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==132) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalXUmlb.g:7110:3: rule__ClassMethod__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassMethod__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassMethodAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__9__Impl"


    // $ANTLR start "rule__ClassMethod__Group__10"
    // InternalXUmlb.g:7118:1: rule__ClassMethod__Group__10 : rule__ClassMethod__Group__10__Impl ;
    public final void rule__ClassMethod__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7122:1: ( rule__ClassMethod__Group__10__Impl )
            // InternalXUmlb.g:7123:2: rule__ClassMethod__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__10"


    // $ANTLR start "rule__ClassMethod__Group__10__Impl"
    // InternalXUmlb.g:7129:1: rule__ClassMethod__Group__10__Impl : ( 'end' ) ;
    public final void rule__ClassMethod__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7133:1: ( ( 'end' ) )
            // InternalXUmlb.g:7134:1: ( 'end' )
            {
            // InternalXUmlb.g:7134:1: ( 'end' )
            // InternalXUmlb.g:7135:2: 'end'
            {
             before(grammarAccess.getClassMethodAccess().getEndKeyword_10()); 
            match(input,123,FOLLOW_2); 
             after(grammarAccess.getClassMethodAccess().getEndKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group__10__Impl"


    // $ANTLR start "rule__ClassMethod__Group_4__0"
    // InternalXUmlb.g:7145:1: rule__ClassMethod__Group_4__0 : rule__ClassMethod__Group_4__0__Impl rule__ClassMethod__Group_4__1 ;
    public final void rule__ClassMethod__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7149:1: ( rule__ClassMethod__Group_4__0__Impl rule__ClassMethod__Group_4__1 )
            // InternalXUmlb.g:7150:2: rule__ClassMethod__Group_4__0__Impl rule__ClassMethod__Group_4__1
            {
            pushFollow(FOLLOW_4);
            rule__ClassMethod__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_4__0"


    // $ANTLR start "rule__ClassMethod__Group_4__0__Impl"
    // InternalXUmlb.g:7157:1: rule__ClassMethod__Group_4__0__Impl : ( 'elaborates' ) ;
    public final void rule__ClassMethod__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7161:1: ( ( 'elaborates' ) )
            // InternalXUmlb.g:7162:1: ( 'elaborates' )
            {
            // InternalXUmlb.g:7162:1: ( 'elaborates' )
            // InternalXUmlb.g:7163:2: 'elaborates'
            {
             before(grammarAccess.getClassMethodAccess().getElaboratesKeyword_4_0()); 
            match(input,120,FOLLOW_2); 
             after(grammarAccess.getClassMethodAccess().getElaboratesKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_4__0__Impl"


    // $ANTLR start "rule__ClassMethod__Group_4__1"
    // InternalXUmlb.g:7172:1: rule__ClassMethod__Group_4__1 : rule__ClassMethod__Group_4__1__Impl ;
    public final void rule__ClassMethod__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7176:1: ( rule__ClassMethod__Group_4__1__Impl )
            // InternalXUmlb.g:7177:2: rule__ClassMethod__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_4__1"


    // $ANTLR start "rule__ClassMethod__Group_4__1__Impl"
    // InternalXUmlb.g:7183:1: rule__ClassMethod__Group_4__1__Impl : ( ( ( rule__ClassMethod__ElaboratesAssignment_4_1 ) ) ( ( rule__ClassMethod__ElaboratesAssignment_4_1 )* ) ) ;
    public final void rule__ClassMethod__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7187:1: ( ( ( ( rule__ClassMethod__ElaboratesAssignment_4_1 ) ) ( ( rule__ClassMethod__ElaboratesAssignment_4_1 )* ) ) )
            // InternalXUmlb.g:7188:1: ( ( ( rule__ClassMethod__ElaboratesAssignment_4_1 ) ) ( ( rule__ClassMethod__ElaboratesAssignment_4_1 )* ) )
            {
            // InternalXUmlb.g:7188:1: ( ( ( rule__ClassMethod__ElaboratesAssignment_4_1 ) ) ( ( rule__ClassMethod__ElaboratesAssignment_4_1 )* ) )
            // InternalXUmlb.g:7189:2: ( ( rule__ClassMethod__ElaboratesAssignment_4_1 ) ) ( ( rule__ClassMethod__ElaboratesAssignment_4_1 )* )
            {
            // InternalXUmlb.g:7189:2: ( ( rule__ClassMethod__ElaboratesAssignment_4_1 ) )
            // InternalXUmlb.g:7190:3: ( rule__ClassMethod__ElaboratesAssignment_4_1 )
            {
             before(grammarAccess.getClassMethodAccess().getElaboratesAssignment_4_1()); 
            // InternalXUmlb.g:7191:3: ( rule__ClassMethod__ElaboratesAssignment_4_1 )
            // InternalXUmlb.g:7191:4: rule__ClassMethod__ElaboratesAssignment_4_1
            {
            pushFollow(FOLLOW_20);
            rule__ClassMethod__ElaboratesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getClassMethodAccess().getElaboratesAssignment_4_1()); 

            }

            // InternalXUmlb.g:7194:2: ( ( rule__ClassMethod__ElaboratesAssignment_4_1 )* )
            // InternalXUmlb.g:7195:3: ( rule__ClassMethod__ElaboratesAssignment_4_1 )*
            {
             before(grammarAccess.getClassMethodAccess().getElaboratesAssignment_4_1()); 
            // InternalXUmlb.g:7196:3: ( rule__ClassMethod__ElaboratesAssignment_4_1 )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==RULE_ID) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalXUmlb.g:7196:4: rule__ClassMethod__ElaboratesAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__ClassMethod__ElaboratesAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

             after(grammarAccess.getClassMethodAccess().getElaboratesAssignment_4_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_4__1__Impl"


    // $ANTLR start "rule__ClassMethod__Group_6__0"
    // InternalXUmlb.g:7206:1: rule__ClassMethod__Group_6__0 : rule__ClassMethod__Group_6__0__Impl rule__ClassMethod__Group_6__1 ;
    public final void rule__ClassMethod__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7210:1: ( rule__ClassMethod__Group_6__0__Impl rule__ClassMethod__Group_6__1 )
            // InternalXUmlb.g:7211:2: rule__ClassMethod__Group_6__0__Impl rule__ClassMethod__Group_6__1
            {
            pushFollow(FOLLOW_4);
            rule__ClassMethod__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_6__0"


    // $ANTLR start "rule__ClassMethod__Group_6__0__Impl"
    // InternalXUmlb.g:7218:1: rule__ClassMethod__Group_6__0__Impl : ( 'any' ) ;
    public final void rule__ClassMethod__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7222:1: ( ( 'any' ) )
            // InternalXUmlb.g:7223:1: ( 'any' )
            {
            // InternalXUmlb.g:7223:1: ( 'any' )
            // InternalXUmlb.g:7224:2: 'any'
            {
             before(grammarAccess.getClassMethodAccess().getAnyKeyword_6_0()); 
            match(input,129,FOLLOW_2); 
             after(grammarAccess.getClassMethodAccess().getAnyKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_6__0__Impl"


    // $ANTLR start "rule__ClassMethod__Group_6__1"
    // InternalXUmlb.g:7233:1: rule__ClassMethod__Group_6__1 : rule__ClassMethod__Group_6__1__Impl rule__ClassMethod__Group_6__2 ;
    public final void rule__ClassMethod__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7237:1: ( rule__ClassMethod__Group_6__1__Impl rule__ClassMethod__Group_6__2 )
            // InternalXUmlb.g:7238:2: rule__ClassMethod__Group_6__1__Impl rule__ClassMethod__Group_6__2
            {
            pushFollow(FOLLOW_21);
            rule__ClassMethod__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_6__1"


    // $ANTLR start "rule__ClassMethod__Group_6__1__Impl"
    // InternalXUmlb.g:7245:1: rule__ClassMethod__Group_6__1__Impl : ( ( rule__ClassMethod__ParametersAssignment_6_1 ) ) ;
    public final void rule__ClassMethod__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7249:1: ( ( ( rule__ClassMethod__ParametersAssignment_6_1 ) ) )
            // InternalXUmlb.g:7250:1: ( ( rule__ClassMethod__ParametersAssignment_6_1 ) )
            {
            // InternalXUmlb.g:7250:1: ( ( rule__ClassMethod__ParametersAssignment_6_1 ) )
            // InternalXUmlb.g:7251:2: ( rule__ClassMethod__ParametersAssignment_6_1 )
            {
             before(grammarAccess.getClassMethodAccess().getParametersAssignment_6_1()); 
            // InternalXUmlb.g:7252:2: ( rule__ClassMethod__ParametersAssignment_6_1 )
            // InternalXUmlb.g:7252:3: rule__ClassMethod__ParametersAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassMethod__ParametersAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getClassMethodAccess().getParametersAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_6__1__Impl"


    // $ANTLR start "rule__ClassMethod__Group_6__2"
    // InternalXUmlb.g:7260:1: rule__ClassMethod__Group_6__2 : rule__ClassMethod__Group_6__2__Impl ;
    public final void rule__ClassMethod__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7264:1: ( rule__ClassMethod__Group_6__2__Impl )
            // InternalXUmlb.g:7265:2: rule__ClassMethod__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_6__2"


    // $ANTLR start "rule__ClassMethod__Group_6__2__Impl"
    // InternalXUmlb.g:7271:1: rule__ClassMethod__Group_6__2__Impl : ( ( rule__ClassMethod__Group_6_2__0 )* ) ;
    public final void rule__ClassMethod__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7275:1: ( ( ( rule__ClassMethod__Group_6_2__0 )* ) )
            // InternalXUmlb.g:7276:1: ( ( rule__ClassMethod__Group_6_2__0 )* )
            {
            // InternalXUmlb.g:7276:1: ( ( rule__ClassMethod__Group_6_2__0 )* )
            // InternalXUmlb.g:7277:2: ( rule__ClassMethod__Group_6_2__0 )*
            {
             before(grammarAccess.getClassMethodAccess().getGroup_6_2()); 
            // InternalXUmlb.g:7278:2: ( rule__ClassMethod__Group_6_2__0 )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==49) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalXUmlb.g:7278:3: rule__ClassMethod__Group_6_2__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__ClassMethod__Group_6_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);

             after(grammarAccess.getClassMethodAccess().getGroup_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_6__2__Impl"


    // $ANTLR start "rule__ClassMethod__Group_6_2__0"
    // InternalXUmlb.g:7287:1: rule__ClassMethod__Group_6_2__0 : rule__ClassMethod__Group_6_2__0__Impl rule__ClassMethod__Group_6_2__1 ;
    public final void rule__ClassMethod__Group_6_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7291:1: ( rule__ClassMethod__Group_6_2__0__Impl rule__ClassMethod__Group_6_2__1 )
            // InternalXUmlb.g:7292:2: rule__ClassMethod__Group_6_2__0__Impl rule__ClassMethod__Group_6_2__1
            {
            pushFollow(FOLLOW_4);
            rule__ClassMethod__Group_6_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_6_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_6_2__0"


    // $ANTLR start "rule__ClassMethod__Group_6_2__0__Impl"
    // InternalXUmlb.g:7299:1: rule__ClassMethod__Group_6_2__0__Impl : ( ',' ) ;
    public final void rule__ClassMethod__Group_6_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7303:1: ( ( ',' ) )
            // InternalXUmlb.g:7304:1: ( ',' )
            {
            // InternalXUmlb.g:7304:1: ( ',' )
            // InternalXUmlb.g:7305:2: ','
            {
             before(grammarAccess.getClassMethodAccess().getCommaKeyword_6_2_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getClassMethodAccess().getCommaKeyword_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_6_2__0__Impl"


    // $ANTLR start "rule__ClassMethod__Group_6_2__1"
    // InternalXUmlb.g:7314:1: rule__ClassMethod__Group_6_2__1 : rule__ClassMethod__Group_6_2__1__Impl ;
    public final void rule__ClassMethod__Group_6_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7318:1: ( rule__ClassMethod__Group_6_2__1__Impl )
            // InternalXUmlb.g:7319:2: rule__ClassMethod__Group_6_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_6_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_6_2__1"


    // $ANTLR start "rule__ClassMethod__Group_6_2__1__Impl"
    // InternalXUmlb.g:7325:1: rule__ClassMethod__Group_6_2__1__Impl : ( ( rule__ClassMethod__ParametersAssignment_6_2_1 ) ) ;
    public final void rule__ClassMethod__Group_6_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7329:1: ( ( ( rule__ClassMethod__ParametersAssignment_6_2_1 ) ) )
            // InternalXUmlb.g:7330:1: ( ( rule__ClassMethod__ParametersAssignment_6_2_1 ) )
            {
            // InternalXUmlb.g:7330:1: ( ( rule__ClassMethod__ParametersAssignment_6_2_1 ) )
            // InternalXUmlb.g:7331:2: ( rule__ClassMethod__ParametersAssignment_6_2_1 )
            {
             before(grammarAccess.getClassMethodAccess().getParametersAssignment_6_2_1()); 
            // InternalXUmlb.g:7332:2: ( rule__ClassMethod__ParametersAssignment_6_2_1 )
            // InternalXUmlb.g:7332:3: rule__ClassMethod__ParametersAssignment_6_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassMethod__ParametersAssignment_6_2_1();

            state._fsp--;


            }

             after(grammarAccess.getClassMethodAccess().getParametersAssignment_6_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_6_2__1__Impl"


    // $ANTLR start "rule__ClassMethod__Group_7__0"
    // InternalXUmlb.g:7341:1: rule__ClassMethod__Group_7__0 : rule__ClassMethod__Group_7__0__Impl rule__ClassMethod__Group_7__1 ;
    public final void rule__ClassMethod__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7345:1: ( rule__ClassMethod__Group_7__0__Impl rule__ClassMethod__Group_7__1 )
            // InternalXUmlb.g:7346:2: rule__ClassMethod__Group_7__0__Impl rule__ClassMethod__Group_7__1
            {
            pushFollow(FOLLOW_23);
            rule__ClassMethod__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_7__0"


    // $ANTLR start "rule__ClassMethod__Group_7__0__Impl"
    // InternalXUmlb.g:7353:1: rule__ClassMethod__Group_7__0__Impl : ( 'where' ) ;
    public final void rule__ClassMethod__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7357:1: ( ( 'where' ) )
            // InternalXUmlb.g:7358:1: ( 'where' )
            {
            // InternalXUmlb.g:7358:1: ( 'where' )
            // InternalXUmlb.g:7359:2: 'where'
            {
             before(grammarAccess.getClassMethodAccess().getWhereKeyword_7_0()); 
            match(input,130,FOLLOW_2); 
             after(grammarAccess.getClassMethodAccess().getWhereKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_7__0__Impl"


    // $ANTLR start "rule__ClassMethod__Group_7__1"
    // InternalXUmlb.g:7368:1: rule__ClassMethod__Group_7__1 : rule__ClassMethod__Group_7__1__Impl ;
    public final void rule__ClassMethod__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7372:1: ( rule__ClassMethod__Group_7__1__Impl )
            // InternalXUmlb.g:7373:2: rule__ClassMethod__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_7__1"


    // $ANTLR start "rule__ClassMethod__Group_7__1__Impl"
    // InternalXUmlb.g:7379:1: rule__ClassMethod__Group_7__1__Impl : ( ( ( rule__ClassMethod__GuardsAssignment_7_1 ) ) ( ( rule__ClassMethod__GuardsAssignment_7_1 )* ) ) ;
    public final void rule__ClassMethod__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7383:1: ( ( ( ( rule__ClassMethod__GuardsAssignment_7_1 ) ) ( ( rule__ClassMethod__GuardsAssignment_7_1 )* ) ) )
            // InternalXUmlb.g:7384:1: ( ( ( rule__ClassMethod__GuardsAssignment_7_1 ) ) ( ( rule__ClassMethod__GuardsAssignment_7_1 )* ) )
            {
            // InternalXUmlb.g:7384:1: ( ( ( rule__ClassMethod__GuardsAssignment_7_1 ) ) ( ( rule__ClassMethod__GuardsAssignment_7_1 )* ) )
            // InternalXUmlb.g:7385:2: ( ( rule__ClassMethod__GuardsAssignment_7_1 ) ) ( ( rule__ClassMethod__GuardsAssignment_7_1 )* )
            {
            // InternalXUmlb.g:7385:2: ( ( rule__ClassMethod__GuardsAssignment_7_1 ) )
            // InternalXUmlb.g:7386:3: ( rule__ClassMethod__GuardsAssignment_7_1 )
            {
             before(grammarAccess.getClassMethodAccess().getGuardsAssignment_7_1()); 
            // InternalXUmlb.g:7387:3: ( rule__ClassMethod__GuardsAssignment_7_1 )
            // InternalXUmlb.g:7387:4: rule__ClassMethod__GuardsAssignment_7_1
            {
            pushFollow(FOLLOW_24);
            rule__ClassMethod__GuardsAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getClassMethodAccess().getGuardsAssignment_7_1()); 

            }

            // InternalXUmlb.g:7390:2: ( ( rule__ClassMethod__GuardsAssignment_7_1 )* )
            // InternalXUmlb.g:7391:3: ( rule__ClassMethod__GuardsAssignment_7_1 )*
            {
             before(grammarAccess.getClassMethodAccess().getGuardsAssignment_7_1()); 
            // InternalXUmlb.g:7392:3: ( rule__ClassMethod__GuardsAssignment_7_1 )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==RULE_XLABEL||LA81_0==164) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalXUmlb.g:7392:4: rule__ClassMethod__GuardsAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__ClassMethod__GuardsAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);

             after(grammarAccess.getClassMethodAccess().getGuardsAssignment_7_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_7__1__Impl"


    // $ANTLR start "rule__ClassMethod__Group_8__0"
    // InternalXUmlb.g:7402:1: rule__ClassMethod__Group_8__0 : rule__ClassMethod__Group_8__0__Impl rule__ClassMethod__Group_8__1 ;
    public final void rule__ClassMethod__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7406:1: ( rule__ClassMethod__Group_8__0__Impl rule__ClassMethod__Group_8__1 )
            // InternalXUmlb.g:7407:2: rule__ClassMethod__Group_8__0__Impl rule__ClassMethod__Group_8__1
            {
            pushFollow(FOLLOW_25);
            rule__ClassMethod__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_8__0"


    // $ANTLR start "rule__ClassMethod__Group_8__0__Impl"
    // InternalXUmlb.g:7414:1: rule__ClassMethod__Group_8__0__Impl : ( 'then' ) ;
    public final void rule__ClassMethod__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7418:1: ( ( 'then' ) )
            // InternalXUmlb.g:7419:1: ( 'then' )
            {
            // InternalXUmlb.g:7419:1: ( 'then' )
            // InternalXUmlb.g:7420:2: 'then'
            {
             before(grammarAccess.getClassMethodAccess().getThenKeyword_8_0()); 
            match(input,131,FOLLOW_2); 
             after(grammarAccess.getClassMethodAccess().getThenKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_8__0__Impl"


    // $ANTLR start "rule__ClassMethod__Group_8__1"
    // InternalXUmlb.g:7429:1: rule__ClassMethod__Group_8__1 : rule__ClassMethod__Group_8__1__Impl ;
    public final void rule__ClassMethod__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7433:1: ( rule__ClassMethod__Group_8__1__Impl )
            // InternalXUmlb.g:7434:2: rule__ClassMethod__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_8__1"


    // $ANTLR start "rule__ClassMethod__Group_8__1__Impl"
    // InternalXUmlb.g:7440:1: rule__ClassMethod__Group_8__1__Impl : ( ( ( rule__ClassMethod__ActionsAssignment_8_1 ) ) ( ( rule__ClassMethod__ActionsAssignment_8_1 )* ) ) ;
    public final void rule__ClassMethod__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7444:1: ( ( ( ( rule__ClassMethod__ActionsAssignment_8_1 ) ) ( ( rule__ClassMethod__ActionsAssignment_8_1 )* ) ) )
            // InternalXUmlb.g:7445:1: ( ( ( rule__ClassMethod__ActionsAssignment_8_1 ) ) ( ( rule__ClassMethod__ActionsAssignment_8_1 )* ) )
            {
            // InternalXUmlb.g:7445:1: ( ( ( rule__ClassMethod__ActionsAssignment_8_1 ) ) ( ( rule__ClassMethod__ActionsAssignment_8_1 )* ) )
            // InternalXUmlb.g:7446:2: ( ( rule__ClassMethod__ActionsAssignment_8_1 ) ) ( ( rule__ClassMethod__ActionsAssignment_8_1 )* )
            {
            // InternalXUmlb.g:7446:2: ( ( rule__ClassMethod__ActionsAssignment_8_1 ) )
            // InternalXUmlb.g:7447:3: ( rule__ClassMethod__ActionsAssignment_8_1 )
            {
             before(grammarAccess.getClassMethodAccess().getActionsAssignment_8_1()); 
            // InternalXUmlb.g:7448:3: ( rule__ClassMethod__ActionsAssignment_8_1 )
            // InternalXUmlb.g:7448:4: rule__ClassMethod__ActionsAssignment_8_1
            {
            pushFollow(FOLLOW_26);
            rule__ClassMethod__ActionsAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getClassMethodAccess().getActionsAssignment_8_1()); 

            }

            // InternalXUmlb.g:7451:2: ( ( rule__ClassMethod__ActionsAssignment_8_1 )* )
            // InternalXUmlb.g:7452:3: ( rule__ClassMethod__ActionsAssignment_8_1 )*
            {
             before(grammarAccess.getClassMethodAccess().getActionsAssignment_8_1()); 
            // InternalXUmlb.g:7453:3: ( rule__ClassMethod__ActionsAssignment_8_1 )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==RULE_XLABEL) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalXUmlb.g:7453:4: rule__ClassMethod__ActionsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__ClassMethod__ActionsAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);

             after(grammarAccess.getClassMethodAccess().getActionsAssignment_8_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_8__1__Impl"


    // $ANTLR start "rule__ClassMethod__Group_9__0"
    // InternalXUmlb.g:7463:1: rule__ClassMethod__Group_9__0 : rule__ClassMethod__Group_9__0__Impl rule__ClassMethod__Group_9__1 ;
    public final void rule__ClassMethod__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7467:1: ( rule__ClassMethod__Group_9__0__Impl rule__ClassMethod__Group_9__1 )
            // InternalXUmlb.g:7468:2: rule__ClassMethod__Group_9__0__Impl rule__ClassMethod__Group_9__1
            {
            pushFollow(FOLLOW_25);
            rule__ClassMethod__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_9__0"


    // $ANTLR start "rule__ClassMethod__Group_9__0__Impl"
    // InternalXUmlb.g:7475:1: rule__ClassMethod__Group_9__0__Impl : ( 'with' ) ;
    public final void rule__ClassMethod__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7479:1: ( ( 'with' ) )
            // InternalXUmlb.g:7480:1: ( 'with' )
            {
            // InternalXUmlb.g:7480:1: ( 'with' )
            // InternalXUmlb.g:7481:2: 'with'
            {
             before(grammarAccess.getClassMethodAccess().getWithKeyword_9_0()); 
            match(input,132,FOLLOW_2); 
             after(grammarAccess.getClassMethodAccess().getWithKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_9__0__Impl"


    // $ANTLR start "rule__ClassMethod__Group_9__1"
    // InternalXUmlb.g:7490:1: rule__ClassMethod__Group_9__1 : rule__ClassMethod__Group_9__1__Impl ;
    public final void rule__ClassMethod__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7494:1: ( rule__ClassMethod__Group_9__1__Impl )
            // InternalXUmlb.g:7495:2: rule__ClassMethod__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassMethod__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_9__1"


    // $ANTLR start "rule__ClassMethod__Group_9__1__Impl"
    // InternalXUmlb.g:7501:1: rule__ClassMethod__Group_9__1__Impl : ( ( ( rule__ClassMethod__WitnessesAssignment_9_1 ) ) ( ( rule__ClassMethod__WitnessesAssignment_9_1 )* ) ) ;
    public final void rule__ClassMethod__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7505:1: ( ( ( ( rule__ClassMethod__WitnessesAssignment_9_1 ) ) ( ( rule__ClassMethod__WitnessesAssignment_9_1 )* ) ) )
            // InternalXUmlb.g:7506:1: ( ( ( rule__ClassMethod__WitnessesAssignment_9_1 ) ) ( ( rule__ClassMethod__WitnessesAssignment_9_1 )* ) )
            {
            // InternalXUmlb.g:7506:1: ( ( ( rule__ClassMethod__WitnessesAssignment_9_1 ) ) ( ( rule__ClassMethod__WitnessesAssignment_9_1 )* ) )
            // InternalXUmlb.g:7507:2: ( ( rule__ClassMethod__WitnessesAssignment_9_1 ) ) ( ( rule__ClassMethod__WitnessesAssignment_9_1 )* )
            {
            // InternalXUmlb.g:7507:2: ( ( rule__ClassMethod__WitnessesAssignment_9_1 ) )
            // InternalXUmlb.g:7508:3: ( rule__ClassMethod__WitnessesAssignment_9_1 )
            {
             before(grammarAccess.getClassMethodAccess().getWitnessesAssignment_9_1()); 
            // InternalXUmlb.g:7509:3: ( rule__ClassMethod__WitnessesAssignment_9_1 )
            // InternalXUmlb.g:7509:4: rule__ClassMethod__WitnessesAssignment_9_1
            {
            pushFollow(FOLLOW_26);
            rule__ClassMethod__WitnessesAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getClassMethodAccess().getWitnessesAssignment_9_1()); 

            }

            // InternalXUmlb.g:7512:2: ( ( rule__ClassMethod__WitnessesAssignment_9_1 )* )
            // InternalXUmlb.g:7513:3: ( rule__ClassMethod__WitnessesAssignment_9_1 )*
            {
             before(grammarAccess.getClassMethodAccess().getWitnessesAssignment_9_1()); 
            // InternalXUmlb.g:7514:3: ( rule__ClassMethod__WitnessesAssignment_9_1 )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==RULE_XLABEL) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalXUmlb.g:7514:4: rule__ClassMethod__WitnessesAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__ClassMethod__WitnessesAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);

             after(grammarAccess.getClassMethodAccess().getWitnessesAssignment_9_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__Group_9__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalXUmlb.g:7524:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7528:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalXUmlb.g:7529:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_62);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalXUmlb.g:7536:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7540:1: ( ( RULE_ID ) )
            // InternalXUmlb.g:7541:1: ( RULE_ID )
            {
            // InternalXUmlb.g:7541:1: ( RULE_ID )
            // InternalXUmlb.g:7542:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalXUmlb.g:7551:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7555:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalXUmlb.g:7556:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalXUmlb.g:7562:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )? ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7566:1: ( ( ( rule__QualifiedName__Group_1__0 )? ) )
            // InternalXUmlb.g:7567:1: ( ( rule__QualifiedName__Group_1__0 )? )
            {
            // InternalXUmlb.g:7567:1: ( ( rule__QualifiedName__Group_1__0 )? )
            // InternalXUmlb.g:7568:2: ( rule__QualifiedName__Group_1__0 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalXUmlb.g:7569:2: ( rule__QualifiedName__Group_1__0 )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==51) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalXUmlb.g:7569:3: rule__QualifiedName__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QualifiedName__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalXUmlb.g:7578:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7582:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalXUmlb.g:7583:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalXUmlb.g:7590:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7594:1: ( ( '.' ) )
            // InternalXUmlb.g:7595:1: ( '.' )
            {
            // InternalXUmlb.g:7595:1: ( '.' )
            // InternalXUmlb.g:7596:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalXUmlb.g:7605:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7609:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalXUmlb.g:7610:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalXUmlb.g:7616:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7620:1: ( ( RULE_ID ) )
            // InternalXUmlb.g:7621:1: ( RULE_ID )
            {
            // InternalXUmlb.g:7621:1: ( RULE_ID )
            // InternalXUmlb.g:7622:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0"
    // InternalXUmlb.g:7632:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 : rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1 ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7636:1: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1 )
            // InternalXUmlb.g:7637:2: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1
            {
            pushFollow(FOLLOW_63);
            rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl"
    // InternalXUmlb.g:7644:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl : ( '%' ) ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7648:1: ( ( '%' ) )
            // InternalXUmlb.g:7649:1: ( '%' )
            {
            // InternalXUmlb.g:7649:1: ( '%' )
            // InternalXUmlb.g:7650:2: '%'
            {
             before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPercentSignKeyword_32_0()); 
            match(input,155,FOLLOW_2); 
             after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPercentSignKeyword_32_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1"
    // InternalXUmlb.g:7659:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1 : rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7663:1: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl )
            // InternalXUmlb.g:7664:2: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl"
    // InternalXUmlb.g:7670:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl : ( '\\u22C2' ) ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7674:1: ( ( '\\u22C2' ) )
            // InternalXUmlb.g:7675:1: ( '\\u22C2' )
            {
            // InternalXUmlb.g:7675:1: ( '\\u22C2' )
            // InternalXUmlb.g:7676:2: '\\u22C2'
            {
             before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryIntersectionKeyword_32_1()); 
            match(input,156,FOLLOW_2); 
             after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryIntersectionKeyword_32_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl"


    // $ANTLR start "rule__Invariant__Group__0"
    // InternalXUmlb.g:7686:1: rule__Invariant__Group__0 : rule__Invariant__Group__0__Impl rule__Invariant__Group__1 ;
    public final void rule__Invariant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7690:1: ( rule__Invariant__Group__0__Impl rule__Invariant__Group__1 )
            // InternalXUmlb.g:7691:2: rule__Invariant__Group__0__Impl rule__Invariant__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Invariant__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Invariant__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__Group__0"


    // $ANTLR start "rule__Invariant__Group__0__Impl"
    // InternalXUmlb.g:7698:1: rule__Invariant__Group__0__Impl : ( ( rule__Invariant__TheoremAssignment_0 )? ) ;
    public final void rule__Invariant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7702:1: ( ( ( rule__Invariant__TheoremAssignment_0 )? ) )
            // InternalXUmlb.g:7703:1: ( ( rule__Invariant__TheoremAssignment_0 )? )
            {
            // InternalXUmlb.g:7703:1: ( ( rule__Invariant__TheoremAssignment_0 )? )
            // InternalXUmlb.g:7704:2: ( rule__Invariant__TheoremAssignment_0 )?
            {
             before(grammarAccess.getInvariantAccess().getTheoremAssignment_0()); 
            // InternalXUmlb.g:7705:2: ( rule__Invariant__TheoremAssignment_0 )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==164) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalXUmlb.g:7705:3: rule__Invariant__TheoremAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Invariant__TheoremAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInvariantAccess().getTheoremAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__Group__0__Impl"


    // $ANTLR start "rule__Invariant__Group__1"
    // InternalXUmlb.g:7713:1: rule__Invariant__Group__1 : rule__Invariant__Group__1__Impl rule__Invariant__Group__2 ;
    public final void rule__Invariant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7717:1: ( rule__Invariant__Group__1__Impl rule__Invariant__Group__2 )
            // InternalXUmlb.g:7718:2: rule__Invariant__Group__1__Impl rule__Invariant__Group__2
            {
            pushFollow(FOLLOW_56);
            rule__Invariant__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Invariant__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__Group__1"


    // $ANTLR start "rule__Invariant__Group__1__Impl"
    // InternalXUmlb.g:7725:1: rule__Invariant__Group__1__Impl : ( ( rule__Invariant__NameAssignment_1 ) ) ;
    public final void rule__Invariant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7729:1: ( ( ( rule__Invariant__NameAssignment_1 ) ) )
            // InternalXUmlb.g:7730:1: ( ( rule__Invariant__NameAssignment_1 ) )
            {
            // InternalXUmlb.g:7730:1: ( ( rule__Invariant__NameAssignment_1 ) )
            // InternalXUmlb.g:7731:2: ( rule__Invariant__NameAssignment_1 )
            {
             before(grammarAccess.getInvariantAccess().getNameAssignment_1()); 
            // InternalXUmlb.g:7732:2: ( rule__Invariant__NameAssignment_1 )
            // InternalXUmlb.g:7732:3: rule__Invariant__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Invariant__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getInvariantAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__Group__1__Impl"


    // $ANTLR start "rule__Invariant__Group__2"
    // InternalXUmlb.g:7740:1: rule__Invariant__Group__2 : rule__Invariant__Group__2__Impl ;
    public final void rule__Invariant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7744:1: ( rule__Invariant__Group__2__Impl )
            // InternalXUmlb.g:7745:2: rule__Invariant__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Invariant__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__Group__2"


    // $ANTLR start "rule__Invariant__Group__2__Impl"
    // InternalXUmlb.g:7751:1: rule__Invariant__Group__2__Impl : ( ( rule__Invariant__PredicateAssignment_2 ) ) ;
    public final void rule__Invariant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7755:1: ( ( ( rule__Invariant__PredicateAssignment_2 ) ) )
            // InternalXUmlb.g:7756:1: ( ( rule__Invariant__PredicateAssignment_2 ) )
            {
            // InternalXUmlb.g:7756:1: ( ( rule__Invariant__PredicateAssignment_2 ) )
            // InternalXUmlb.g:7757:2: ( rule__Invariant__PredicateAssignment_2 )
            {
             before(grammarAccess.getInvariantAccess().getPredicateAssignment_2()); 
            // InternalXUmlb.g:7758:2: ( rule__Invariant__PredicateAssignment_2 )
            // InternalXUmlb.g:7758:3: rule__Invariant__PredicateAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Invariant__PredicateAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getInvariantAccess().getPredicateAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__Group__2__Impl"


    // $ANTLR start "rule__Guard__Group__0"
    // InternalXUmlb.g:7767:1: rule__Guard__Group__0 : rule__Guard__Group__0__Impl rule__Guard__Group__1 ;
    public final void rule__Guard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7771:1: ( rule__Guard__Group__0__Impl rule__Guard__Group__1 )
            // InternalXUmlb.g:7772:2: rule__Guard__Group__0__Impl rule__Guard__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Guard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Guard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__0"


    // $ANTLR start "rule__Guard__Group__0__Impl"
    // InternalXUmlb.g:7779:1: rule__Guard__Group__0__Impl : ( ( rule__Guard__TheoremAssignment_0 )? ) ;
    public final void rule__Guard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7783:1: ( ( ( rule__Guard__TheoremAssignment_0 )? ) )
            // InternalXUmlb.g:7784:1: ( ( rule__Guard__TheoremAssignment_0 )? )
            {
            // InternalXUmlb.g:7784:1: ( ( rule__Guard__TheoremAssignment_0 )? )
            // InternalXUmlb.g:7785:2: ( rule__Guard__TheoremAssignment_0 )?
            {
             before(grammarAccess.getGuardAccess().getTheoremAssignment_0()); 
            // InternalXUmlb.g:7786:2: ( rule__Guard__TheoremAssignment_0 )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==164) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalXUmlb.g:7786:3: rule__Guard__TheoremAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Guard__TheoremAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGuardAccess().getTheoremAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__0__Impl"


    // $ANTLR start "rule__Guard__Group__1"
    // InternalXUmlb.g:7794:1: rule__Guard__Group__1 : rule__Guard__Group__1__Impl rule__Guard__Group__2 ;
    public final void rule__Guard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7798:1: ( rule__Guard__Group__1__Impl rule__Guard__Group__2 )
            // InternalXUmlb.g:7799:2: rule__Guard__Group__1__Impl rule__Guard__Group__2
            {
            pushFollow(FOLLOW_56);
            rule__Guard__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Guard__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__1"


    // $ANTLR start "rule__Guard__Group__1__Impl"
    // InternalXUmlb.g:7806:1: rule__Guard__Group__1__Impl : ( ( rule__Guard__NameAssignment_1 ) ) ;
    public final void rule__Guard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7810:1: ( ( ( rule__Guard__NameAssignment_1 ) ) )
            // InternalXUmlb.g:7811:1: ( ( rule__Guard__NameAssignment_1 ) )
            {
            // InternalXUmlb.g:7811:1: ( ( rule__Guard__NameAssignment_1 ) )
            // InternalXUmlb.g:7812:2: ( rule__Guard__NameAssignment_1 )
            {
             before(grammarAccess.getGuardAccess().getNameAssignment_1()); 
            // InternalXUmlb.g:7813:2: ( rule__Guard__NameAssignment_1 )
            // InternalXUmlb.g:7813:3: rule__Guard__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Guard__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGuardAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__1__Impl"


    // $ANTLR start "rule__Guard__Group__2"
    // InternalXUmlb.g:7821:1: rule__Guard__Group__2 : rule__Guard__Group__2__Impl ;
    public final void rule__Guard__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7825:1: ( rule__Guard__Group__2__Impl )
            // InternalXUmlb.g:7826:2: rule__Guard__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Guard__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__2"


    // $ANTLR start "rule__Guard__Group__2__Impl"
    // InternalXUmlb.g:7832:1: rule__Guard__Group__2__Impl : ( ( rule__Guard__PredicateAssignment_2 ) ) ;
    public final void rule__Guard__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7836:1: ( ( ( rule__Guard__PredicateAssignment_2 ) ) )
            // InternalXUmlb.g:7837:1: ( ( rule__Guard__PredicateAssignment_2 ) )
            {
            // InternalXUmlb.g:7837:1: ( ( rule__Guard__PredicateAssignment_2 ) )
            // InternalXUmlb.g:7838:2: ( rule__Guard__PredicateAssignment_2 )
            {
             before(grammarAccess.getGuardAccess().getPredicateAssignment_2()); 
            // InternalXUmlb.g:7839:2: ( rule__Guard__PredicateAssignment_2 )
            // InternalXUmlb.g:7839:3: rule__Guard__PredicateAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Guard__PredicateAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGuardAccess().getPredicateAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__2__Impl"


    // $ANTLR start "rule__Action__Group__0"
    // InternalXUmlb.g:7848:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7852:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // InternalXUmlb.g:7853:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FOLLOW_56);
            rule__Action__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0"


    // $ANTLR start "rule__Action__Group__0__Impl"
    // InternalXUmlb.g:7860:1: rule__Action__Group__0__Impl : ( ( rule__Action__NameAssignment_0 ) ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7864:1: ( ( ( rule__Action__NameAssignment_0 ) ) )
            // InternalXUmlb.g:7865:1: ( ( rule__Action__NameAssignment_0 ) )
            {
            // InternalXUmlb.g:7865:1: ( ( rule__Action__NameAssignment_0 ) )
            // InternalXUmlb.g:7866:2: ( rule__Action__NameAssignment_0 )
            {
             before(grammarAccess.getActionAccess().getNameAssignment_0()); 
            // InternalXUmlb.g:7867:2: ( rule__Action__NameAssignment_0 )
            // InternalXUmlb.g:7867:3: rule__Action__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Action__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0__Impl"


    // $ANTLR start "rule__Action__Group__1"
    // InternalXUmlb.g:7875:1: rule__Action__Group__1 : rule__Action__Group__1__Impl ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7879:1: ( rule__Action__Group__1__Impl )
            // InternalXUmlb.g:7880:2: rule__Action__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1"


    // $ANTLR start "rule__Action__Group__1__Impl"
    // InternalXUmlb.g:7886:1: rule__Action__Group__1__Impl : ( ( rule__Action__ActionAssignment_1 ) ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7890:1: ( ( ( rule__Action__ActionAssignment_1 ) ) )
            // InternalXUmlb.g:7891:1: ( ( rule__Action__ActionAssignment_1 ) )
            {
            // InternalXUmlb.g:7891:1: ( ( rule__Action__ActionAssignment_1 ) )
            // InternalXUmlb.g:7892:2: ( rule__Action__ActionAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getActionAssignment_1()); 
            // InternalXUmlb.g:7893:2: ( rule__Action__ActionAssignment_1 )
            // InternalXUmlb.g:7893:3: rule__Action__ActionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Action__ActionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getActionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1__Impl"


    // $ANTLR start "rule__Witness__Group__0"
    // InternalXUmlb.g:7902:1: rule__Witness__Group__0 : rule__Witness__Group__0__Impl rule__Witness__Group__1 ;
    public final void rule__Witness__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7906:1: ( rule__Witness__Group__0__Impl rule__Witness__Group__1 )
            // InternalXUmlb.g:7907:2: rule__Witness__Group__0__Impl rule__Witness__Group__1
            {
            pushFollow(FOLLOW_56);
            rule__Witness__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Witness__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Witness__Group__0"


    // $ANTLR start "rule__Witness__Group__0__Impl"
    // InternalXUmlb.g:7914:1: rule__Witness__Group__0__Impl : ( ( rule__Witness__NameAssignment_0 ) ) ;
    public final void rule__Witness__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7918:1: ( ( ( rule__Witness__NameAssignment_0 ) ) )
            // InternalXUmlb.g:7919:1: ( ( rule__Witness__NameAssignment_0 ) )
            {
            // InternalXUmlb.g:7919:1: ( ( rule__Witness__NameAssignment_0 ) )
            // InternalXUmlb.g:7920:2: ( rule__Witness__NameAssignment_0 )
            {
             before(grammarAccess.getWitnessAccess().getNameAssignment_0()); 
            // InternalXUmlb.g:7921:2: ( rule__Witness__NameAssignment_0 )
            // InternalXUmlb.g:7921:3: rule__Witness__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Witness__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getWitnessAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Witness__Group__0__Impl"


    // $ANTLR start "rule__Witness__Group__1"
    // InternalXUmlb.g:7929:1: rule__Witness__Group__1 : rule__Witness__Group__1__Impl ;
    public final void rule__Witness__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7933:1: ( rule__Witness__Group__1__Impl )
            // InternalXUmlb.g:7934:2: rule__Witness__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Witness__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Witness__Group__1"


    // $ANTLR start "rule__Witness__Group__1__Impl"
    // InternalXUmlb.g:7940:1: rule__Witness__Group__1__Impl : ( ( rule__Witness__PredicateAssignment_1 ) ) ;
    public final void rule__Witness__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7944:1: ( ( ( rule__Witness__PredicateAssignment_1 ) ) )
            // InternalXUmlb.g:7945:1: ( ( rule__Witness__PredicateAssignment_1 ) )
            {
            // InternalXUmlb.g:7945:1: ( ( rule__Witness__PredicateAssignment_1 ) )
            // InternalXUmlb.g:7946:2: ( rule__Witness__PredicateAssignment_1 )
            {
             before(grammarAccess.getWitnessAccess().getPredicateAssignment_1()); 
            // InternalXUmlb.g:7947:2: ( rule__Witness__PredicateAssignment_1 )
            // InternalXUmlb.g:7947:3: rule__Witness__PredicateAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Witness__PredicateAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWitnessAccess().getPredicateAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Witness__Group__1__Impl"


    // $ANTLR start "rule__XUMLB__NameAssignment_1"
    // InternalXUmlb.g:7956:1: rule__XUMLB__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__XUMLB__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7960:1: ( ( RULE_ID ) )
            // InternalXUmlb.g:7961:2: ( RULE_ID )
            {
            // InternalXUmlb.g:7961:2: ( RULE_ID )
            // InternalXUmlb.g:7962:3: RULE_ID
            {
             before(grammarAccess.getXUMLBAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXUMLBAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__NameAssignment_1"


    // $ANTLR start "rule__XUMLB__ElaboratesAssignment_2_1"
    // InternalXUmlb.g:7971:1: rule__XUMLB__ElaboratesAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__XUMLB__ElaboratesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7975:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:7976:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:7976:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:7977:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getXUMLBAccess().getElaboratesEventBNamedCommentedComponentElementCrossReference_2_1_0()); 
            // InternalXUmlb.g:7978:3: ( ruleQualifiedName )
            // InternalXUmlb.g:7979:4: ruleQualifiedName
            {
             before(grammarAccess.getXUMLBAccess().getElaboratesEventBNamedCommentedComponentElementQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getXUMLBAccess().getElaboratesEventBNamedCommentedComponentElementQualifiedNameParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getXUMLBAccess().getElaboratesEventBNamedCommentedComponentElementCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__ElaboratesAssignment_2_1"


    // $ANTLR start "rule__XUMLB__RefinesAssignment_3_1"
    // InternalXUmlb.g:7990:1: rule__XUMLB__RefinesAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__XUMLB__RefinesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:7994:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:7995:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:7995:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:7996:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getXUMLBAccess().getRefinesUMLBCrossReference_3_1_0()); 
            // InternalXUmlb.g:7997:3: ( ruleQualifiedName )
            // InternalXUmlb.g:7998:4: ruleQualifiedName
            {
             before(grammarAccess.getXUMLBAccess().getRefinesUMLBQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getXUMLBAccess().getRefinesUMLBQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getXUMLBAccess().getRefinesUMLBCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__RefinesAssignment_3_1"


    // $ANTLR start "rule__XUMLB__DiagramsAssignment_4"
    // InternalXUmlb.g:8009:1: rule__XUMLB__DiagramsAssignment_4 : ( ruleXDiagram ) ;
    public final void rule__XUMLB__DiagramsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8013:1: ( ( ruleXDiagram ) )
            // InternalXUmlb.g:8014:2: ( ruleXDiagram )
            {
            // InternalXUmlb.g:8014:2: ( ruleXDiagram )
            // InternalXUmlb.g:8015:3: ruleXDiagram
            {
             before(grammarAccess.getXUMLBAccess().getDiagramsXDiagramParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleXDiagram();

            state._fsp--;

             after(grammarAccess.getXUMLBAccess().getDiagramsXDiagramParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUMLB__DiagramsAssignment_4"


    // $ANTLR start "rule__Statemachine__NameAssignment_2"
    // InternalXUmlb.g:8024:1: rule__Statemachine__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Statemachine__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8028:1: ( ( RULE_ID ) )
            // InternalXUmlb.g:8029:2: ( RULE_ID )
            {
            // InternalXUmlb.g:8029:2: ( RULE_ID )
            // InternalXUmlb.g:8030:3: RULE_ID
            {
             before(grammarAccess.getStatemachineAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getStatemachineAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__NameAssignment_2"


    // $ANTLR start "rule__Statemachine__TranslationAssignment_4"
    // InternalXUmlb.g:8039:1: rule__Statemachine__TranslationAssignment_4 : ( ruleTranslationKind ) ;
    public final void rule__Statemachine__TranslationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8043:1: ( ( ruleTranslationKind ) )
            // InternalXUmlb.g:8044:2: ( ruleTranslationKind )
            {
            // InternalXUmlb.g:8044:2: ( ruleTranslationKind )
            // InternalXUmlb.g:8045:3: ruleTranslationKind
            {
             before(grammarAccess.getStatemachineAccess().getTranslationTranslationKindEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTranslationKind();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getTranslationTranslationKindEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__TranslationAssignment_4"


    // $ANTLR start "rule__Statemachine__RefinesAssignment_6_1"
    // InternalXUmlb.g:8054:1: rule__Statemachine__RefinesAssignment_6_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Statemachine__RefinesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8058:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8059:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8059:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8060:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getStatemachineAccess().getRefinesStatemachineCrossReference_6_1_0()); 
            // InternalXUmlb.g:8061:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8062:4: ruleQualifiedName
            {
             before(grammarAccess.getStatemachineAccess().getRefinesStatemachineQualifiedNameParserRuleCall_6_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getRefinesStatemachineQualifiedNameParserRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getStatemachineAccess().getRefinesStatemachineCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__RefinesAssignment_6_1"


    // $ANTLR start "rule__Statemachine__InstancesAssignment_7_1"
    // InternalXUmlb.g:8073:1: rule__Statemachine__InstancesAssignment_7_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Statemachine__InstancesAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8077:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8078:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8078:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8079:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getStatemachineAccess().getInstancesEventBNamedCommentedElementCrossReference_7_1_0()); 
            // InternalXUmlb.g:8080:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8081:4: ruleQualifiedName
            {
             before(grammarAccess.getStatemachineAccess().getInstancesEventBNamedCommentedElementQualifiedNameParserRuleCall_7_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getInstancesEventBNamedCommentedElementQualifiedNameParserRuleCall_7_1_0_1()); 

            }

             after(grammarAccess.getStatemachineAccess().getInstancesEventBNamedCommentedElementCrossReference_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__InstancesAssignment_7_1"


    // $ANTLR start "rule__Statemachine__SelfNameAssignment_7_3"
    // InternalXUmlb.g:8092:1: rule__Statemachine__SelfNameAssignment_7_3 : ( ruleEString ) ;
    public final void rule__Statemachine__SelfNameAssignment_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8096:1: ( ( ruleEString ) )
            // InternalXUmlb.g:8097:2: ( ruleEString )
            {
            // InternalXUmlb.g:8097:2: ( ruleEString )
            // InternalXUmlb.g:8098:3: ruleEString
            {
             before(grammarAccess.getStatemachineAccess().getSelfNameEStringParserRuleCall_7_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getSelfNameEStringParserRuleCall_7_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__SelfNameAssignment_7_3"


    // $ANTLR start "rule__Statemachine__NodesAssignment_8"
    // InternalXUmlb.g:8107:1: rule__Statemachine__NodesAssignment_8 : ( ruleAbstractNode ) ;
    public final void rule__Statemachine__NodesAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8111:1: ( ( ruleAbstractNode ) )
            // InternalXUmlb.g:8112:2: ( ruleAbstractNode )
            {
            // InternalXUmlb.g:8112:2: ( ruleAbstractNode )
            // InternalXUmlb.g:8113:3: ruleAbstractNode
            {
             before(grammarAccess.getStatemachineAccess().getNodesAbstractNodeParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleAbstractNode();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getNodesAbstractNodeParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__NodesAssignment_8"


    // $ANTLR start "rule__Statemachine__TransitionsAssignment_9"
    // InternalXUmlb.g:8122:1: rule__Statemachine__TransitionsAssignment_9 : ( ruleTransition ) ;
    public final void rule__Statemachine__TransitionsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8126:1: ( ( ruleTransition ) )
            // InternalXUmlb.g:8127:2: ( ruleTransition )
            {
            // InternalXUmlb.g:8127:2: ( ruleTransition )
            // InternalXUmlb.g:8128:3: ruleTransition
            {
             before(grammarAccess.getStatemachineAccess().getTransitionsTransitionParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getTransitionsTransitionParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__TransitionsAssignment_9"


    // $ANTLR start "rule__Transition__ElaboratesAssignment_2_1"
    // InternalXUmlb.g:8137:1: rule__Transition__ElaboratesAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Transition__ElaboratesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8141:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8142:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8142:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8143:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getTransitionAccess().getElaboratesEventCrossReference_2_1_0()); 
            // InternalXUmlb.g:8144:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8145:4: ruleQualifiedName
            {
             before(grammarAccess.getTransitionAccess().getElaboratesEventQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getElaboratesEventQualifiedNameParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getElaboratesEventCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__ElaboratesAssignment_2_1"


    // $ANTLR start "rule__Transition__ExtendedAssignment_3"
    // InternalXUmlb.g:8156:1: rule__Transition__ExtendedAssignment_3 : ( ( 'extended' ) ) ;
    public final void rule__Transition__ExtendedAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8160:1: ( ( ( 'extended' ) ) )
            // InternalXUmlb.g:8161:2: ( ( 'extended' ) )
            {
            // InternalXUmlb.g:8161:2: ( ( 'extended' ) )
            // InternalXUmlb.g:8162:3: ( 'extended' )
            {
             before(grammarAccess.getTransitionAccess().getExtendedExtendedKeyword_3_0()); 
            // InternalXUmlb.g:8163:3: ( 'extended' )
            // InternalXUmlb.g:8164:4: 'extended'
            {
             before(grammarAccess.getTransitionAccess().getExtendedExtendedKeyword_3_0()); 
            match(input,157,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getExtendedExtendedKeyword_3_0()); 

            }

             after(grammarAccess.getTransitionAccess().getExtendedExtendedKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__ExtendedAssignment_3"


    // $ANTLR start "rule__Transition__SourceAssignment_5"
    // InternalXUmlb.g:8175:1: rule__Transition__SourceAssignment_5 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Transition__SourceAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8179:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8180:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8180:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8181:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getTransitionAccess().getSourceAbstractNodeCrossReference_5_0()); 
            // InternalXUmlb.g:8182:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8183:4: ruleQualifiedName
            {
             before(grammarAccess.getTransitionAccess().getSourceAbstractNodeQualifiedNameParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getSourceAbstractNodeQualifiedNameParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getSourceAbstractNodeCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__SourceAssignment_5"


    // $ANTLR start "rule__Transition__TargetAssignment_7"
    // InternalXUmlb.g:8194:1: rule__Transition__TargetAssignment_7 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Transition__TargetAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8198:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8199:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8199:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8200:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getTransitionAccess().getTargetAbstractNodeCrossReference_7_0()); 
            // InternalXUmlb.g:8201:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8202:4: ruleQualifiedName
            {
             before(grammarAccess.getTransitionAccess().getTargetAbstractNodeQualifiedNameParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getTargetAbstractNodeQualifiedNameParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getTargetAbstractNodeCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__TargetAssignment_7"


    // $ANTLR start "rule__Transition__ParametersAssignment_8_1"
    // InternalXUmlb.g:8213:1: rule__Transition__ParametersAssignment_8_1 : ( ruleTypedParameter ) ;
    public final void rule__Transition__ParametersAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8217:1: ( ( ruleTypedParameter ) )
            // InternalXUmlb.g:8218:2: ( ruleTypedParameter )
            {
            // InternalXUmlb.g:8218:2: ( ruleTypedParameter )
            // InternalXUmlb.g:8219:3: ruleTypedParameter
            {
             before(grammarAccess.getTransitionAccess().getParametersTypedParameterParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTypedParameter();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getParametersTypedParameterParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__ParametersAssignment_8_1"


    // $ANTLR start "rule__Transition__ParametersAssignment_8_2_1"
    // InternalXUmlb.g:8228:1: rule__Transition__ParametersAssignment_8_2_1 : ( ruleTypedParameter ) ;
    public final void rule__Transition__ParametersAssignment_8_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8232:1: ( ( ruleTypedParameter ) )
            // InternalXUmlb.g:8233:2: ( ruleTypedParameter )
            {
            // InternalXUmlb.g:8233:2: ( ruleTypedParameter )
            // InternalXUmlb.g:8234:3: ruleTypedParameter
            {
             before(grammarAccess.getTransitionAccess().getParametersTypedParameterParserRuleCall_8_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTypedParameter();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getParametersTypedParameterParserRuleCall_8_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__ParametersAssignment_8_2_1"


    // $ANTLR start "rule__Transition__GuardsAssignment_9_1"
    // InternalXUmlb.g:8243:1: rule__Transition__GuardsAssignment_9_1 : ( ruleGuard ) ;
    public final void rule__Transition__GuardsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8247:1: ( ( ruleGuard ) )
            // InternalXUmlb.g:8248:2: ( ruleGuard )
            {
            // InternalXUmlb.g:8248:2: ( ruleGuard )
            // InternalXUmlb.g:8249:3: ruleGuard
            {
             before(grammarAccess.getTransitionAccess().getGuardsGuardParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGuard();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getGuardsGuardParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__GuardsAssignment_9_1"


    // $ANTLR start "rule__Transition__ActionsAssignment_10_1"
    // InternalXUmlb.g:8258:1: rule__Transition__ActionsAssignment_10_1 : ( ruleAction ) ;
    public final void rule__Transition__ActionsAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8262:1: ( ( ruleAction ) )
            // InternalXUmlb.g:8263:2: ( ruleAction )
            {
            // InternalXUmlb.g:8263:2: ( ruleAction )
            // InternalXUmlb.g:8264:3: ruleAction
            {
             before(grammarAccess.getTransitionAccess().getActionsActionParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getActionsActionParserRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__ActionsAssignment_10_1"


    // $ANTLR start "rule__Transition__WitnessesAssignment_11_1"
    // InternalXUmlb.g:8273:1: rule__Transition__WitnessesAssignment_11_1 : ( ruleWitness ) ;
    public final void rule__Transition__WitnessesAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8277:1: ( ( ruleWitness ) )
            // InternalXUmlb.g:8278:2: ( ruleWitness )
            {
            // InternalXUmlb.g:8278:2: ( ruleWitness )
            // InternalXUmlb.g:8279:3: ruleWitness
            {
             before(grammarAccess.getTransitionAccess().getWitnessesWitnessParserRuleCall_11_1_0()); 
            pushFollow(FOLLOW_2);
            ruleWitness();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getWitnessesWitnessParserRuleCall_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__WitnessesAssignment_11_1"


    // $ANTLR start "rule__TypedParameter__NameAssignment_0"
    // InternalXUmlb.g:8288:1: rule__TypedParameter__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__TypedParameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8292:1: ( ( RULE_ID ) )
            // InternalXUmlb.g:8293:2: ( RULE_ID )
            {
            // InternalXUmlb.g:8293:2: ( RULE_ID )
            // InternalXUmlb.g:8294:3: RULE_ID
            {
             before(grammarAccess.getTypedParameterAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTypedParameterAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedParameter__NameAssignment_0"


    // $ANTLR start "rule__TypedParameter__TypeAssignment_2"
    // InternalXUmlb.g:8303:1: rule__TypedParameter__TypeAssignment_2 : ( ruleXType ) ;
    public final void rule__TypedParameter__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8307:1: ( ( ruleXType ) )
            // InternalXUmlb.g:8308:2: ( ruleXType )
            {
            // InternalXUmlb.g:8308:2: ( ruleXType )
            // InternalXUmlb.g:8309:3: ruleXType
            {
             before(grammarAccess.getTypedParameterAccess().getTypeXTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleXType();

            state._fsp--;

             after(grammarAccess.getTypedParameterAccess().getTypeXTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedParameter__TypeAssignment_2"


    // $ANTLR start "rule__State__NameAssignment_2"
    // InternalXUmlb.g:8318:1: rule__State__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__State__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8322:1: ( ( ruleEString ) )
            // InternalXUmlb.g:8323:2: ( ruleEString )
            {
            // InternalXUmlb.g:8323:2: ( ruleEString )
            // InternalXUmlb.g:8324:3: ruleEString
            {
             before(grammarAccess.getStateAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getStateAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__NameAssignment_2"


    // $ANTLR start "rule__State__RefinesAssignment_3_1"
    // InternalXUmlb.g:8333:1: rule__State__RefinesAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__State__RefinesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8337:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8338:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8338:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8339:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getStateAccess().getRefinesStateCrossReference_3_1_0()); 
            // InternalXUmlb.g:8340:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8341:4: ruleQualifiedName
            {
             before(grammarAccess.getStateAccess().getRefinesStateQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getStateAccess().getRefinesStateQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getStateAccess().getRefinesStateCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__RefinesAssignment_3_1"


    // $ANTLR start "rule__State__StatemachinesAssignment_4_2"
    // InternalXUmlb.g:8352:1: rule__State__StatemachinesAssignment_4_2 : ( ruleStatemachine ) ;
    public final void rule__State__StatemachinesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8356:1: ( ( ruleStatemachine ) )
            // InternalXUmlb.g:8357:2: ( ruleStatemachine )
            {
            // InternalXUmlb.g:8357:2: ( ruleStatemachine )
            // InternalXUmlb.g:8358:3: ruleStatemachine
            {
             before(grammarAccess.getStateAccess().getStatemachinesStatemachineParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_2);
            ruleStatemachine();

            state._fsp--;

             after(grammarAccess.getStateAccess().getStatemachinesStatemachineParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__StatemachinesAssignment_4_2"


    // $ANTLR start "rule__State__StatemachinesAssignment_4_3"
    // InternalXUmlb.g:8367:1: rule__State__StatemachinesAssignment_4_3 : ( ruleStatemachine ) ;
    public final void rule__State__StatemachinesAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8371:1: ( ( ruleStatemachine ) )
            // InternalXUmlb.g:8372:2: ( ruleStatemachine )
            {
            // InternalXUmlb.g:8372:2: ( ruleStatemachine )
            // InternalXUmlb.g:8373:3: ruleStatemachine
            {
             before(grammarAccess.getStateAccess().getStatemachinesStatemachineParserRuleCall_4_3_0()); 
            pushFollow(FOLLOW_2);
            ruleStatemachine();

            state._fsp--;

             after(grammarAccess.getStateAccess().getStatemachinesStatemachineParserRuleCall_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__StatemachinesAssignment_4_3"


    // $ANTLR start "rule__State__InvariantsAssignment_5_1"
    // InternalXUmlb.g:8382:1: rule__State__InvariantsAssignment_5_1 : ( ruleInvariant ) ;
    public final void rule__State__InvariantsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8386:1: ( ( ruleInvariant ) )
            // InternalXUmlb.g:8387:2: ( ruleInvariant )
            {
            // InternalXUmlb.g:8387:2: ( ruleInvariant )
            // InternalXUmlb.g:8388:3: ruleInvariant
            {
             before(grammarAccess.getStateAccess().getInvariantsInvariantParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleInvariant();

            state._fsp--;

             after(grammarAccess.getStateAccess().getInvariantsInvariantParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__InvariantsAssignment_5_1"


    // $ANTLR start "rule__State__EntryActionsAssignment_6_1"
    // InternalXUmlb.g:8397:1: rule__State__EntryActionsAssignment_6_1 : ( ruleAction ) ;
    public final void rule__State__EntryActionsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8401:1: ( ( ruleAction ) )
            // InternalXUmlb.g:8402:2: ( ruleAction )
            {
            // InternalXUmlb.g:8402:2: ( ruleAction )
            // InternalXUmlb.g:8403:3: ruleAction
            {
             before(grammarAccess.getStateAccess().getEntryActionsActionParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getStateAccess().getEntryActionsActionParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__EntryActionsAssignment_6_1"


    // $ANTLR start "rule__State__ExitActionsAssignment_7_1"
    // InternalXUmlb.g:8412:1: rule__State__ExitActionsAssignment_7_1 : ( ruleAction ) ;
    public final void rule__State__ExitActionsAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8416:1: ( ( ruleAction ) )
            // InternalXUmlb.g:8417:2: ( ruleAction )
            {
            // InternalXUmlb.g:8417:2: ( ruleAction )
            // InternalXUmlb.g:8418:3: ruleAction
            {
             before(grammarAccess.getStateAccess().getExitActionsActionParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getStateAccess().getExitActionsActionParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__ExitActionsAssignment_7_1"


    // $ANTLR start "rule__Initial__NameAssignment_1"
    // InternalXUmlb.g:8427:1: rule__Initial__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Initial__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8431:1: ( ( ruleEString ) )
            // InternalXUmlb.g:8432:2: ( ruleEString )
            {
            // InternalXUmlb.g:8432:2: ( ruleEString )
            // InternalXUmlb.g:8433:3: ruleEString
            {
             before(grammarAccess.getInitialAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getInitialAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Initial__NameAssignment_1"


    // $ANTLR start "rule__Final__NameAssignment_1"
    // InternalXUmlb.g:8442:1: rule__Final__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Final__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8446:1: ( ( ruleEString ) )
            // InternalXUmlb.g:8447:2: ( ruleEString )
            {
            // InternalXUmlb.g:8447:2: ( ruleEString )
            // InternalXUmlb.g:8448:3: ruleEString
            {
             before(grammarAccess.getFinalAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFinalAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Final__NameAssignment_1"


    // $ANTLR start "rule__Any__NameAssignment_1"
    // InternalXUmlb.g:8457:1: rule__Any__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Any__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8461:1: ( ( ruleEString ) )
            // InternalXUmlb.g:8462:2: ( ruleEString )
            {
            // InternalXUmlb.g:8462:2: ( ruleEString )
            // InternalXUmlb.g:8463:3: ruleEString
            {
             before(grammarAccess.getAnyAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAnyAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Any__NameAssignment_1"


    // $ANTLR start "rule__Junction__NameAssignment_1"
    // InternalXUmlb.g:8472:1: rule__Junction__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Junction__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8476:1: ( ( ruleEString ) )
            // InternalXUmlb.g:8477:2: ( ruleEString )
            {
            // InternalXUmlb.g:8477:2: ( ruleEString )
            // InternalXUmlb.g:8478:3: ruleEString
            {
             before(grammarAccess.getJunctionAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getJunctionAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__NameAssignment_1"


    // $ANTLR start "rule__Fork__NameAssignment_1"
    // InternalXUmlb.g:8487:1: rule__Fork__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Fork__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8491:1: ( ( ruleEString ) )
            // InternalXUmlb.g:8492:2: ( ruleEString )
            {
            // InternalXUmlb.g:8492:2: ( ruleEString )
            // InternalXUmlb.g:8493:3: ruleEString
            {
             before(grammarAccess.getForkAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getForkAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fork__NameAssignment_1"


    // $ANTLR start "rule__Classdiagram__NameAssignment_2"
    // InternalXUmlb.g:8502:1: rule__Classdiagram__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Classdiagram__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8506:1: ( ( RULE_ID ) )
            // InternalXUmlb.g:8507:2: ( RULE_ID )
            {
            // InternalXUmlb.g:8507:2: ( RULE_ID )
            // InternalXUmlb.g:8508:3: RULE_ID
            {
             before(grammarAccess.getClassdiagramAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getClassdiagramAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__NameAssignment_2"


    // $ANTLR start "rule__Classdiagram__RefinesAssignment_3_1"
    // InternalXUmlb.g:8517:1: rule__Classdiagram__RefinesAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Classdiagram__RefinesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8521:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8522:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8522:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8523:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getClassdiagramAccess().getRefinesClassdiagramCrossReference_3_1_0()); 
            // InternalXUmlb.g:8524:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8525:4: ruleQualifiedName
            {
             before(grammarAccess.getClassdiagramAccess().getRefinesClassdiagramQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getClassdiagramAccess().getRefinesClassdiagramQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getClassdiagramAccess().getRefinesClassdiagramCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__RefinesAssignment_3_1"


    // $ANTLR start "rule__Classdiagram__ClassesAssignment_4"
    // InternalXUmlb.g:8536:1: rule__Classdiagram__ClassesAssignment_4 : ( ruleClass ) ;
    public final void rule__Classdiagram__ClassesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8540:1: ( ( ruleClass ) )
            // InternalXUmlb.g:8541:2: ( ruleClass )
            {
            // InternalXUmlb.g:8541:2: ( ruleClass )
            // InternalXUmlb.g:8542:3: ruleClass
            {
             before(grammarAccess.getClassdiagramAccess().getClassesClassParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getClassdiagramAccess().getClassesClassParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__ClassesAssignment_4"


    // $ANTLR start "rule__Classdiagram__AssociationsAssignment_5"
    // InternalXUmlb.g:8551:1: rule__Classdiagram__AssociationsAssignment_5 : ( ruleAssociation ) ;
    public final void rule__Classdiagram__AssociationsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8555:1: ( ( ruleAssociation ) )
            // InternalXUmlb.g:8556:2: ( ruleAssociation )
            {
            // InternalXUmlb.g:8556:2: ( ruleAssociation )
            // InternalXUmlb.g:8557:3: ruleAssociation
            {
             before(grammarAccess.getClassdiagramAccess().getAssociationsAssociationParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleAssociation();

            state._fsp--;

             after(grammarAccess.getClassdiagramAccess().getAssociationsAssociationParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classdiagram__AssociationsAssignment_5"


    // $ANTLR start "rule__Class__NameAssignment_2"
    // InternalXUmlb.g:8566:1: rule__Class__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Class__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8570:1: ( ( RULE_ID ) )
            // InternalXUmlb.g:8571:2: ( RULE_ID )
            {
            // InternalXUmlb.g:8571:2: ( RULE_ID )
            // InternalXUmlb.g:8572:3: RULE_ID
            {
             before(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__NameAssignment_2"


    // $ANTLR start "rule__Class__DataKindAssignment_4"
    // InternalXUmlb.g:8581:1: rule__Class__DataKindAssignment_4 : ( ruleDataKind ) ;
    public final void rule__Class__DataKindAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8585:1: ( ( ruleDataKind ) )
            // InternalXUmlb.g:8586:2: ( ruleDataKind )
            {
            // InternalXUmlb.g:8586:2: ( ruleDataKind )
            // InternalXUmlb.g:8587:3: ruleDataKind
            {
             before(grammarAccess.getClassAccess().getDataKindDataKindEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDataKind();

            state._fsp--;

             after(grammarAccess.getClassAccess().getDataKindDataKindEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__DataKindAssignment_4"


    // $ANTLR start "rule__Class__ElaboratesAssignment_6_1"
    // InternalXUmlb.g:8596:1: rule__Class__ElaboratesAssignment_6_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Class__ElaboratesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8600:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8601:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8601:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8602:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getClassAccess().getElaboratesEventBNamedCrossReference_6_1_0()); 
            // InternalXUmlb.g:8603:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8604:4: ruleQualifiedName
            {
             before(grammarAccess.getClassAccess().getElaboratesEventBNamedQualifiedNameParserRuleCall_6_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getClassAccess().getElaboratesEventBNamedQualifiedNameParserRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getClassAccess().getElaboratesEventBNamedCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__ElaboratesAssignment_6_1"


    // $ANTLR start "rule__Class__SelfNameAssignment_7_1"
    // InternalXUmlb.g:8615:1: rule__Class__SelfNameAssignment_7_1 : ( ruleEString ) ;
    public final void rule__Class__SelfNameAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8619:1: ( ( ruleEString ) )
            // InternalXUmlb.g:8620:2: ( ruleEString )
            {
            // InternalXUmlb.g:8620:2: ( ruleEString )
            // InternalXUmlb.g:8621:3: ruleEString
            {
             before(grammarAccess.getClassAccess().getSelfNameEStringParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getClassAccess().getSelfNameEStringParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__SelfNameAssignment_7_1"


    // $ANTLR start "rule__Class__InstancesAssignment_8_1"
    // InternalXUmlb.g:8630:1: rule__Class__InstancesAssignment_8_1 : ( ruleEString ) ;
    public final void rule__Class__InstancesAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8634:1: ( ( ruleEString ) )
            // InternalXUmlb.g:8635:2: ( ruleEString )
            {
            // InternalXUmlb.g:8635:2: ( ruleEString )
            // InternalXUmlb.g:8636:3: ruleEString
            {
             before(grammarAccess.getClassAccess().getInstancesEStringParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getClassAccess().getInstancesEStringParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__InstancesAssignment_8_1"


    // $ANTLR start "rule__Class__SupertypesAssignment_9_1"
    // InternalXUmlb.g:8645:1: rule__Class__SupertypesAssignment_9_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Class__SupertypesAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8649:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8650:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8650:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8651:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getClassAccess().getSupertypesClassCrossReference_9_1_0()); 
            // InternalXUmlb.g:8652:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8653:4: ruleQualifiedName
            {
             before(grammarAccess.getClassAccess().getSupertypesClassQualifiedNameParserRuleCall_9_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getClassAccess().getSupertypesClassQualifiedNameParserRuleCall_9_1_0_1()); 

            }

             after(grammarAccess.getClassAccess().getSupertypesClassCrossReference_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__SupertypesAssignment_9_1"


    // $ANTLR start "rule__Class__RefinesAssignment_10_1"
    // InternalXUmlb.g:8664:1: rule__Class__RefinesAssignment_10_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Class__RefinesAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8668:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8669:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8669:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8670:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getClassAccess().getRefinesClassCrossReference_10_1_0()); 
            // InternalXUmlb.g:8671:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8672:4: ruleQualifiedName
            {
             before(grammarAccess.getClassAccess().getRefinesClassQualifiedNameParserRuleCall_10_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getClassAccess().getRefinesClassQualifiedNameParserRuleCall_10_1_0_1()); 

            }

             after(grammarAccess.getClassAccess().getRefinesClassCrossReference_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__RefinesAssignment_10_1"


    // $ANTLR start "rule__Class__StatemachinesAssignment_11_2"
    // InternalXUmlb.g:8683:1: rule__Class__StatemachinesAssignment_11_2 : ( ruleStatemachine ) ;
    public final void rule__Class__StatemachinesAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8687:1: ( ( ruleStatemachine ) )
            // InternalXUmlb.g:8688:2: ( ruleStatemachine )
            {
            // InternalXUmlb.g:8688:2: ( ruleStatemachine )
            // InternalXUmlb.g:8689:3: ruleStatemachine
            {
             before(grammarAccess.getClassAccess().getStatemachinesStatemachineParserRuleCall_11_2_0()); 
            pushFollow(FOLLOW_2);
            ruleStatemachine();

            state._fsp--;

             after(grammarAccess.getClassAccess().getStatemachinesStatemachineParserRuleCall_11_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__StatemachinesAssignment_11_2"


    // $ANTLR start "rule__Class__ClassAttributesAssignment_12"
    // InternalXUmlb.g:8698:1: rule__Class__ClassAttributesAssignment_12 : ( ruleClassAttribute ) ;
    public final void rule__Class__ClassAttributesAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8702:1: ( ( ruleClassAttribute ) )
            // InternalXUmlb.g:8703:2: ( ruleClassAttribute )
            {
            // InternalXUmlb.g:8703:2: ( ruleClassAttribute )
            // InternalXUmlb.g:8704:3: ruleClassAttribute
            {
             before(grammarAccess.getClassAccess().getClassAttributesClassAttributeParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleClassAttribute();

            state._fsp--;

             after(grammarAccess.getClassAccess().getClassAttributesClassAttributeParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__ClassAttributesAssignment_12"


    // $ANTLR start "rule__Class__ConstraintsAssignment_13"
    // InternalXUmlb.g:8713:1: rule__Class__ConstraintsAssignment_13 : ( ruleClassConstraint ) ;
    public final void rule__Class__ConstraintsAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8717:1: ( ( ruleClassConstraint ) )
            // InternalXUmlb.g:8718:2: ( ruleClassConstraint )
            {
            // InternalXUmlb.g:8718:2: ( ruleClassConstraint )
            // InternalXUmlb.g:8719:3: ruleClassConstraint
            {
             before(grammarAccess.getClassAccess().getConstraintsClassConstraintParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleClassConstraint();

            state._fsp--;

             after(grammarAccess.getClassAccess().getConstraintsClassConstraintParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__ConstraintsAssignment_13"


    // $ANTLR start "rule__Class__MethodsAssignment_14"
    // InternalXUmlb.g:8728:1: rule__Class__MethodsAssignment_14 : ( ruleClassMethod ) ;
    public final void rule__Class__MethodsAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8732:1: ( ( ruleClassMethod ) )
            // InternalXUmlb.g:8733:2: ( ruleClassMethod )
            {
            // InternalXUmlb.g:8733:2: ( ruleClassMethod )
            // InternalXUmlb.g:8734:3: ruleClassMethod
            {
             before(grammarAccess.getClassAccess().getMethodsClassMethodParserRuleCall_14_0()); 
            pushFollow(FOLLOW_2);
            ruleClassMethod();

            state._fsp--;

             after(grammarAccess.getClassAccess().getMethodsClassMethodParserRuleCall_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__MethodsAssignment_14"


    // $ANTLR start "rule__Class__SubtypeGroupsAssignment_15_1"
    // InternalXUmlb.g:8743:1: rule__Class__SubtypeGroupsAssignment_15_1 : ( ruleSubtypeGroup ) ;
    public final void rule__Class__SubtypeGroupsAssignment_15_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8747:1: ( ( ruleSubtypeGroup ) )
            // InternalXUmlb.g:8748:2: ( ruleSubtypeGroup )
            {
            // InternalXUmlb.g:8748:2: ( ruleSubtypeGroup )
            // InternalXUmlb.g:8749:3: ruleSubtypeGroup
            {
             before(grammarAccess.getClassAccess().getSubtypeGroupsSubtypeGroupParserRuleCall_15_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSubtypeGroup();

            state._fsp--;

             after(grammarAccess.getClassAccess().getSubtypeGroupsSubtypeGroupParserRuleCall_15_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Class__SubtypeGroupsAssignment_15_1"


    // $ANTLR start "rule__Association__NameAssignment_2"
    // InternalXUmlb.g:8758:1: rule__Association__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Association__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8762:1: ( ( RULE_ID ) )
            // InternalXUmlb.g:8763:2: ( RULE_ID )
            {
            // InternalXUmlb.g:8763:2: ( RULE_ID )
            // InternalXUmlb.g:8764:3: RULE_ID
            {
             before(grammarAccess.getAssociationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__NameAssignment_2"


    // $ANTLR start "rule__Association__DataKindAssignment_4"
    // InternalXUmlb.g:8773:1: rule__Association__DataKindAssignment_4 : ( ruleDataKind ) ;
    public final void rule__Association__DataKindAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8777:1: ( ( ruleDataKind ) )
            // InternalXUmlb.g:8778:2: ( ruleDataKind )
            {
            // InternalXUmlb.g:8778:2: ( ruleDataKind )
            // InternalXUmlb.g:8779:3: ruleDataKind
            {
             before(grammarAccess.getAssociationAccess().getDataKindDataKindEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDataKind();

            state._fsp--;

             after(grammarAccess.getAssociationAccess().getDataKindDataKindEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__DataKindAssignment_4"


    // $ANTLR start "rule__Association__ElaboratesAssignment_6_1"
    // InternalXUmlb.g:8788:1: rule__Association__ElaboratesAssignment_6_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Association__ElaboratesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8792:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8793:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8793:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8794:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAssociationAccess().getElaboratesEventBNamedCrossReference_6_1_0()); 
            // InternalXUmlb.g:8795:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8796:4: ruleQualifiedName
            {
             before(grammarAccess.getAssociationAccess().getElaboratesEventBNamedQualifiedNameParserRuleCall_6_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getAssociationAccess().getElaboratesEventBNamedQualifiedNameParserRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getAssociationAccess().getElaboratesEventBNamedCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__ElaboratesAssignment_6_1"


    // $ANTLR start "rule__Association__FunctionalAssignment_7"
    // InternalXUmlb.g:8807:1: rule__Association__FunctionalAssignment_7 : ( ( 'functional' ) ) ;
    public final void rule__Association__FunctionalAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8811:1: ( ( ( 'functional' ) ) )
            // InternalXUmlb.g:8812:2: ( ( 'functional' ) )
            {
            // InternalXUmlb.g:8812:2: ( ( 'functional' ) )
            // InternalXUmlb.g:8813:3: ( 'functional' )
            {
             before(grammarAccess.getAssociationAccess().getFunctionalFunctionalKeyword_7_0()); 
            // InternalXUmlb.g:8814:3: ( 'functional' )
            // InternalXUmlb.g:8815:4: 'functional'
            {
             before(grammarAccess.getAssociationAccess().getFunctionalFunctionalKeyword_7_0()); 
            match(input,158,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getFunctionalFunctionalKeyword_7_0()); 

            }

             after(grammarAccess.getAssociationAccess().getFunctionalFunctionalKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__FunctionalAssignment_7"


    // $ANTLR start "rule__Association__TotalAssignment_8"
    // InternalXUmlb.g:8826:1: rule__Association__TotalAssignment_8 : ( ( 'total' ) ) ;
    public final void rule__Association__TotalAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8830:1: ( ( ( 'total' ) ) )
            // InternalXUmlb.g:8831:2: ( ( 'total' ) )
            {
            // InternalXUmlb.g:8831:2: ( ( 'total' ) )
            // InternalXUmlb.g:8832:3: ( 'total' )
            {
             before(grammarAccess.getAssociationAccess().getTotalTotalKeyword_8_0()); 
            // InternalXUmlb.g:8833:3: ( 'total' )
            // InternalXUmlb.g:8834:4: 'total'
            {
             before(grammarAccess.getAssociationAccess().getTotalTotalKeyword_8_0()); 
            match(input,159,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getTotalTotalKeyword_8_0()); 

            }

             after(grammarAccess.getAssociationAccess().getTotalTotalKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__TotalAssignment_8"


    // $ANTLR start "rule__Association__SurjectiveAssignment_9"
    // InternalXUmlb.g:8845:1: rule__Association__SurjectiveAssignment_9 : ( ( 'surjective' ) ) ;
    public final void rule__Association__SurjectiveAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8849:1: ( ( ( 'surjective' ) ) )
            // InternalXUmlb.g:8850:2: ( ( 'surjective' ) )
            {
            // InternalXUmlb.g:8850:2: ( ( 'surjective' ) )
            // InternalXUmlb.g:8851:3: ( 'surjective' )
            {
             before(grammarAccess.getAssociationAccess().getSurjectiveSurjectiveKeyword_9_0()); 
            // InternalXUmlb.g:8852:3: ( 'surjective' )
            // InternalXUmlb.g:8853:4: 'surjective'
            {
             before(grammarAccess.getAssociationAccess().getSurjectiveSurjectiveKeyword_9_0()); 
            match(input,160,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getSurjectiveSurjectiveKeyword_9_0()); 

            }

             after(grammarAccess.getAssociationAccess().getSurjectiveSurjectiveKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__SurjectiveAssignment_9"


    // $ANTLR start "rule__Association__InjectiveAssignment_10"
    // InternalXUmlb.g:8864:1: rule__Association__InjectiveAssignment_10 : ( ( 'injective' ) ) ;
    public final void rule__Association__InjectiveAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8868:1: ( ( ( 'injective' ) ) )
            // InternalXUmlb.g:8869:2: ( ( 'injective' ) )
            {
            // InternalXUmlb.g:8869:2: ( ( 'injective' ) )
            // InternalXUmlb.g:8870:3: ( 'injective' )
            {
             before(grammarAccess.getAssociationAccess().getInjectiveInjectiveKeyword_10_0()); 
            // InternalXUmlb.g:8871:3: ( 'injective' )
            // InternalXUmlb.g:8872:4: 'injective'
            {
             before(grammarAccess.getAssociationAccess().getInjectiveInjectiveKeyword_10_0()); 
            match(input,161,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getInjectiveInjectiveKeyword_10_0()); 

            }

             after(grammarAccess.getAssociationAccess().getInjectiveInjectiveKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__InjectiveAssignment_10"


    // $ANTLR start "rule__Association__InitialValueAssignment_11_1"
    // InternalXUmlb.g:8883:1: rule__Association__InitialValueAssignment_11_1 : ( ruleEString ) ;
    public final void rule__Association__InitialValueAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8887:1: ( ( ruleEString ) )
            // InternalXUmlb.g:8888:2: ( ruleEString )
            {
            // InternalXUmlb.g:8888:2: ( ruleEString )
            // InternalXUmlb.g:8889:3: ruleEString
            {
             before(grammarAccess.getAssociationAccess().getInitialValueEStringParserRuleCall_11_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAssociationAccess().getInitialValueEStringParserRuleCall_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__InitialValueAssignment_11_1"


    // $ANTLR start "rule__Association__SourceAssignment_13"
    // InternalXUmlb.g:8898:1: rule__Association__SourceAssignment_13 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Association__SourceAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8902:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8903:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8903:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8904:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAssociationAccess().getSourceClassCrossReference_13_0()); 
            // InternalXUmlb.g:8905:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8906:4: ruleQualifiedName
            {
             before(grammarAccess.getAssociationAccess().getSourceClassQualifiedNameParserRuleCall_13_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getAssociationAccess().getSourceClassQualifiedNameParserRuleCall_13_0_1()); 

            }

             after(grammarAccess.getAssociationAccess().getSourceClassCrossReference_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__SourceAssignment_13"


    // $ANTLR start "rule__Association__TargetAssignment_15"
    // InternalXUmlb.g:8917:1: rule__Association__TargetAssignment_15 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Association__TargetAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8921:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:8922:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:8922:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:8923:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAssociationAccess().getTargetClassCrossReference_15_0()); 
            // InternalXUmlb.g:8924:3: ( ruleQualifiedName )
            // InternalXUmlb.g:8925:4: ruleQualifiedName
            {
             before(grammarAccess.getAssociationAccess().getTargetClassQualifiedNameParserRuleCall_15_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getAssociationAccess().getTargetClassQualifiedNameParserRuleCall_15_0_1()); 

            }

             after(grammarAccess.getAssociationAccess().getTargetClassCrossReference_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__TargetAssignment_15"


    // $ANTLR start "rule__SubtypeGroup__NameAssignment_2"
    // InternalXUmlb.g:8936:1: rule__SubtypeGroup__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SubtypeGroup__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8940:1: ( ( RULE_ID ) )
            // InternalXUmlb.g:8941:2: ( RULE_ID )
            {
            // InternalXUmlb.g:8941:2: ( RULE_ID )
            // InternalXUmlb.g:8942:3: RULE_ID
            {
             before(grammarAccess.getSubtypeGroupAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSubtypeGroupAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__NameAssignment_2"


    // $ANTLR start "rule__SubtypeGroup__CoverAssignment_3"
    // InternalXUmlb.g:8951:1: rule__SubtypeGroup__CoverAssignment_3 : ( ( 'cover' ) ) ;
    public final void rule__SubtypeGroup__CoverAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8955:1: ( ( ( 'cover' ) ) )
            // InternalXUmlb.g:8956:2: ( ( 'cover' ) )
            {
            // InternalXUmlb.g:8956:2: ( ( 'cover' ) )
            // InternalXUmlb.g:8957:3: ( 'cover' )
            {
             before(grammarAccess.getSubtypeGroupAccess().getCoverCoverKeyword_3_0()); 
            // InternalXUmlb.g:8958:3: ( 'cover' )
            // InternalXUmlb.g:8959:4: 'cover'
            {
             before(grammarAccess.getSubtypeGroupAccess().getCoverCoverKeyword_3_0()); 
            match(input,162,FOLLOW_2); 
             after(grammarAccess.getSubtypeGroupAccess().getCoverCoverKeyword_3_0()); 

            }

             after(grammarAccess.getSubtypeGroupAccess().getCoverCoverKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__CoverAssignment_3"


    // $ANTLR start "rule__SubtypeGroup__DisjointAssignment_4"
    // InternalXUmlb.g:8970:1: rule__SubtypeGroup__DisjointAssignment_4 : ( ( 'disjoint' ) ) ;
    public final void rule__SubtypeGroup__DisjointAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8974:1: ( ( ( 'disjoint' ) ) )
            // InternalXUmlb.g:8975:2: ( ( 'disjoint' ) )
            {
            // InternalXUmlb.g:8975:2: ( ( 'disjoint' ) )
            // InternalXUmlb.g:8976:3: ( 'disjoint' )
            {
             before(grammarAccess.getSubtypeGroupAccess().getDisjointDisjointKeyword_4_0()); 
            // InternalXUmlb.g:8977:3: ( 'disjoint' )
            // InternalXUmlb.g:8978:4: 'disjoint'
            {
             before(grammarAccess.getSubtypeGroupAccess().getDisjointDisjointKeyword_4_0()); 
            match(input,163,FOLLOW_2); 
             after(grammarAccess.getSubtypeGroupAccess().getDisjointDisjointKeyword_4_0()); 

            }

             after(grammarAccess.getSubtypeGroupAccess().getDisjointDisjointKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubtypeGroup__DisjointAssignment_4"


    // $ANTLR start "rule__ClassAttribute__NameAssignment_2"
    // InternalXUmlb.g:8989:1: rule__ClassAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ClassAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:8993:1: ( ( RULE_ID ) )
            // InternalXUmlb.g:8994:2: ( RULE_ID )
            {
            // InternalXUmlb.g:8994:2: ( RULE_ID )
            // InternalXUmlb.g:8995:3: RULE_ID
            {
             before(grammarAccess.getClassAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getClassAttributeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__NameAssignment_2"


    // $ANTLR start "rule__ClassAttribute__DataKindAssignment_4"
    // InternalXUmlb.g:9004:1: rule__ClassAttribute__DataKindAssignment_4 : ( ruleDataKind ) ;
    public final void rule__ClassAttribute__DataKindAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9008:1: ( ( ruleDataKind ) )
            // InternalXUmlb.g:9009:2: ( ruleDataKind )
            {
            // InternalXUmlb.g:9009:2: ( ruleDataKind )
            // InternalXUmlb.g:9010:3: ruleDataKind
            {
             before(grammarAccess.getClassAttributeAccess().getDataKindDataKindEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDataKind();

            state._fsp--;

             after(grammarAccess.getClassAttributeAccess().getDataKindDataKindEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__DataKindAssignment_4"


    // $ANTLR start "rule__ClassAttribute__ElaboratesAssignment_6_1"
    // InternalXUmlb.g:9019:1: rule__ClassAttribute__ElaboratesAssignment_6_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ClassAttribute__ElaboratesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9023:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:9024:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:9024:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:9025:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getClassAttributeAccess().getElaboratesEventBNamedCrossReference_6_1_0()); 
            // InternalXUmlb.g:9026:3: ( ruleQualifiedName )
            // InternalXUmlb.g:9027:4: ruleQualifiedName
            {
             before(grammarAccess.getClassAttributeAccess().getElaboratesEventBNamedQualifiedNameParserRuleCall_6_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getClassAttributeAccess().getElaboratesEventBNamedQualifiedNameParserRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getClassAttributeAccess().getElaboratesEventBNamedCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__ElaboratesAssignment_6_1"


    // $ANTLR start "rule__ClassAttribute__FunctionalAssignment_7"
    // InternalXUmlb.g:9038:1: rule__ClassAttribute__FunctionalAssignment_7 : ( ( 'functional' ) ) ;
    public final void rule__ClassAttribute__FunctionalAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9042:1: ( ( ( 'functional' ) ) )
            // InternalXUmlb.g:9043:2: ( ( 'functional' ) )
            {
            // InternalXUmlb.g:9043:2: ( ( 'functional' ) )
            // InternalXUmlb.g:9044:3: ( 'functional' )
            {
             before(grammarAccess.getClassAttributeAccess().getFunctionalFunctionalKeyword_7_0()); 
            // InternalXUmlb.g:9045:3: ( 'functional' )
            // InternalXUmlb.g:9046:4: 'functional'
            {
             before(grammarAccess.getClassAttributeAccess().getFunctionalFunctionalKeyword_7_0()); 
            match(input,158,FOLLOW_2); 
             after(grammarAccess.getClassAttributeAccess().getFunctionalFunctionalKeyword_7_0()); 

            }

             after(grammarAccess.getClassAttributeAccess().getFunctionalFunctionalKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__FunctionalAssignment_7"


    // $ANTLR start "rule__ClassAttribute__TotalAssignment_8"
    // InternalXUmlb.g:9057:1: rule__ClassAttribute__TotalAssignment_8 : ( ( 'total' ) ) ;
    public final void rule__ClassAttribute__TotalAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9061:1: ( ( ( 'total' ) ) )
            // InternalXUmlb.g:9062:2: ( ( 'total' ) )
            {
            // InternalXUmlb.g:9062:2: ( ( 'total' ) )
            // InternalXUmlb.g:9063:3: ( 'total' )
            {
             before(grammarAccess.getClassAttributeAccess().getTotalTotalKeyword_8_0()); 
            // InternalXUmlb.g:9064:3: ( 'total' )
            // InternalXUmlb.g:9065:4: 'total'
            {
             before(grammarAccess.getClassAttributeAccess().getTotalTotalKeyword_8_0()); 
            match(input,159,FOLLOW_2); 
             after(grammarAccess.getClassAttributeAccess().getTotalTotalKeyword_8_0()); 

            }

             after(grammarAccess.getClassAttributeAccess().getTotalTotalKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__TotalAssignment_8"


    // $ANTLR start "rule__ClassAttribute__SurjectiveAssignment_9"
    // InternalXUmlb.g:9076:1: rule__ClassAttribute__SurjectiveAssignment_9 : ( ( 'surjective' ) ) ;
    public final void rule__ClassAttribute__SurjectiveAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9080:1: ( ( ( 'surjective' ) ) )
            // InternalXUmlb.g:9081:2: ( ( 'surjective' ) )
            {
            // InternalXUmlb.g:9081:2: ( ( 'surjective' ) )
            // InternalXUmlb.g:9082:3: ( 'surjective' )
            {
             before(grammarAccess.getClassAttributeAccess().getSurjectiveSurjectiveKeyword_9_0()); 
            // InternalXUmlb.g:9083:3: ( 'surjective' )
            // InternalXUmlb.g:9084:4: 'surjective'
            {
             before(grammarAccess.getClassAttributeAccess().getSurjectiveSurjectiveKeyword_9_0()); 
            match(input,160,FOLLOW_2); 
             after(grammarAccess.getClassAttributeAccess().getSurjectiveSurjectiveKeyword_9_0()); 

            }

             after(grammarAccess.getClassAttributeAccess().getSurjectiveSurjectiveKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__SurjectiveAssignment_9"


    // $ANTLR start "rule__ClassAttribute__InjectiveAssignment_10"
    // InternalXUmlb.g:9095:1: rule__ClassAttribute__InjectiveAssignment_10 : ( ( 'injective' ) ) ;
    public final void rule__ClassAttribute__InjectiveAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9099:1: ( ( ( 'injective' ) ) )
            // InternalXUmlb.g:9100:2: ( ( 'injective' ) )
            {
            // InternalXUmlb.g:9100:2: ( ( 'injective' ) )
            // InternalXUmlb.g:9101:3: ( 'injective' )
            {
             before(grammarAccess.getClassAttributeAccess().getInjectiveInjectiveKeyword_10_0()); 
            // InternalXUmlb.g:9102:3: ( 'injective' )
            // InternalXUmlb.g:9103:4: 'injective'
            {
             before(grammarAccess.getClassAttributeAccess().getInjectiveInjectiveKeyword_10_0()); 
            match(input,161,FOLLOW_2); 
             after(grammarAccess.getClassAttributeAccess().getInjectiveInjectiveKeyword_10_0()); 

            }

             after(grammarAccess.getClassAttributeAccess().getInjectiveInjectiveKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__InjectiveAssignment_10"


    // $ANTLR start "rule__ClassAttribute__InitialValueAssignment_11_1"
    // InternalXUmlb.g:9114:1: rule__ClassAttribute__InitialValueAssignment_11_1 : ( ruleEString ) ;
    public final void rule__ClassAttribute__InitialValueAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9118:1: ( ( ruleEString ) )
            // InternalXUmlb.g:9119:2: ( ruleEString )
            {
            // InternalXUmlb.g:9119:2: ( ruleEString )
            // InternalXUmlb.g:9120:3: ruleEString
            {
             before(grammarAccess.getClassAttributeAccess().getInitialValueEStringParserRuleCall_11_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getClassAttributeAccess().getInitialValueEStringParserRuleCall_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__InitialValueAssignment_11_1"


    // $ANTLR start "rule__ClassAttribute__TargetAssignment_13"
    // InternalXUmlb.g:9129:1: rule__ClassAttribute__TargetAssignment_13 : ( ruleEString ) ;
    public final void rule__ClassAttribute__TargetAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9133:1: ( ( ruleEString ) )
            // InternalXUmlb.g:9134:2: ( ruleEString )
            {
            // InternalXUmlb.g:9134:2: ( ruleEString )
            // InternalXUmlb.g:9135:3: ruleEString
            {
             before(grammarAccess.getClassAttributeAccess().getTargetEStringParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getClassAttributeAccess().getTargetEStringParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassAttribute__TargetAssignment_13"


    // $ANTLR start "rule__ClassConstraint__TheoremAssignment_2"
    // InternalXUmlb.g:9144:1: rule__ClassConstraint__TheoremAssignment_2 : ( ( 'theorem' ) ) ;
    public final void rule__ClassConstraint__TheoremAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9148:1: ( ( ( 'theorem' ) ) )
            // InternalXUmlb.g:9149:2: ( ( 'theorem' ) )
            {
            // InternalXUmlb.g:9149:2: ( ( 'theorem' ) )
            // InternalXUmlb.g:9150:3: ( 'theorem' )
            {
             before(grammarAccess.getClassConstraintAccess().getTheoremTheoremKeyword_2_0()); 
            // InternalXUmlb.g:9151:3: ( 'theorem' )
            // InternalXUmlb.g:9152:4: 'theorem'
            {
             before(grammarAccess.getClassConstraintAccess().getTheoremTheoremKeyword_2_0()); 
            match(input,164,FOLLOW_2); 
             after(grammarAccess.getClassConstraintAccess().getTheoremTheoremKeyword_2_0()); 

            }

             after(grammarAccess.getClassConstraintAccess().getTheoremTheoremKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__TheoremAssignment_2"


    // $ANTLR start "rule__ClassConstraint__NameAssignment_3"
    // InternalXUmlb.g:9163:1: rule__ClassConstraint__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__ClassConstraint__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9167:1: ( ( RULE_ID ) )
            // InternalXUmlb.g:9168:2: ( RULE_ID )
            {
            // InternalXUmlb.g:9168:2: ( RULE_ID )
            // InternalXUmlb.g:9169:3: RULE_ID
            {
             before(grammarAccess.getClassConstraintAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getClassConstraintAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__NameAssignment_3"


    // $ANTLR start "rule__ClassConstraint__PredicateAssignment_4"
    // InternalXUmlb.g:9178:1: rule__ClassConstraint__PredicateAssignment_4 : ( ruleXFormula ) ;
    public final void rule__ClassConstraint__PredicateAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9182:1: ( ( ruleXFormula ) )
            // InternalXUmlb.g:9183:2: ( ruleXFormula )
            {
            // InternalXUmlb.g:9183:2: ( ruleXFormula )
            // InternalXUmlb.g:9184:3: ruleXFormula
            {
             before(grammarAccess.getClassConstraintAccess().getPredicateXFormulaParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getClassConstraintAccess().getPredicateXFormulaParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__PredicateAssignment_4"


    // $ANTLR start "rule__ClassConstraint__ComponentAssignment_6"
    // InternalXUmlb.g:9193:1: rule__ClassConstraint__ComponentAssignment_6 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ClassConstraint__ComponentAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9197:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:9198:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:9198:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:9199:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getClassConstraintAccess().getComponentEventBNamedCommentedComponentElementCrossReference_6_0()); 
            // InternalXUmlb.g:9200:3: ( ruleQualifiedName )
            // InternalXUmlb.g:9201:4: ruleQualifiedName
            {
             before(grammarAccess.getClassConstraintAccess().getComponentEventBNamedCommentedComponentElementQualifiedNameParserRuleCall_6_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getClassConstraintAccess().getComponentEventBNamedCommentedComponentElementQualifiedNameParserRuleCall_6_0_1()); 

            }

             after(grammarAccess.getClassConstraintAccess().getComponentEventBNamedCommentedComponentElementCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassConstraint__ComponentAssignment_6"


    // $ANTLR start "rule__ClassMethod__KindAssignment_3"
    // InternalXUmlb.g:9212:1: rule__ClassMethod__KindAssignment_3 : ( ruleMethodKind ) ;
    public final void rule__ClassMethod__KindAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9216:1: ( ( ruleMethodKind ) )
            // InternalXUmlb.g:9217:2: ( ruleMethodKind )
            {
            // InternalXUmlb.g:9217:2: ( ruleMethodKind )
            // InternalXUmlb.g:9218:3: ruleMethodKind
            {
             before(grammarAccess.getClassMethodAccess().getKindMethodKindEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleMethodKind();

            state._fsp--;

             after(grammarAccess.getClassMethodAccess().getKindMethodKindEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__KindAssignment_3"


    // $ANTLR start "rule__ClassMethod__ElaboratesAssignment_4_1"
    // InternalXUmlb.g:9227:1: rule__ClassMethod__ElaboratesAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ClassMethod__ElaboratesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9231:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXUmlb.g:9232:2: ( ( ruleQualifiedName ) )
            {
            // InternalXUmlb.g:9232:2: ( ( ruleQualifiedName ) )
            // InternalXUmlb.g:9233:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getClassMethodAccess().getElaboratesEventCrossReference_4_1_0()); 
            // InternalXUmlb.g:9234:3: ( ruleQualifiedName )
            // InternalXUmlb.g:9235:4: ruleQualifiedName
            {
             before(grammarAccess.getClassMethodAccess().getElaboratesEventQualifiedNameParserRuleCall_4_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getClassMethodAccess().getElaboratesEventQualifiedNameParserRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getClassMethodAccess().getElaboratesEventCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__ElaboratesAssignment_4_1"


    // $ANTLR start "rule__ClassMethod__ExtendedAssignment_5"
    // InternalXUmlb.g:9246:1: rule__ClassMethod__ExtendedAssignment_5 : ( ( 'extended' ) ) ;
    public final void rule__ClassMethod__ExtendedAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9250:1: ( ( ( 'extended' ) ) )
            // InternalXUmlb.g:9251:2: ( ( 'extended' ) )
            {
            // InternalXUmlb.g:9251:2: ( ( 'extended' ) )
            // InternalXUmlb.g:9252:3: ( 'extended' )
            {
             before(grammarAccess.getClassMethodAccess().getExtendedExtendedKeyword_5_0()); 
            // InternalXUmlb.g:9253:3: ( 'extended' )
            // InternalXUmlb.g:9254:4: 'extended'
            {
             before(grammarAccess.getClassMethodAccess().getExtendedExtendedKeyword_5_0()); 
            match(input,157,FOLLOW_2); 
             after(grammarAccess.getClassMethodAccess().getExtendedExtendedKeyword_5_0()); 

            }

             after(grammarAccess.getClassMethodAccess().getExtendedExtendedKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__ExtendedAssignment_5"


    // $ANTLR start "rule__ClassMethod__ParametersAssignment_6_1"
    // InternalXUmlb.g:9265:1: rule__ClassMethod__ParametersAssignment_6_1 : ( ruleTypedParameter ) ;
    public final void rule__ClassMethod__ParametersAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9269:1: ( ( ruleTypedParameter ) )
            // InternalXUmlb.g:9270:2: ( ruleTypedParameter )
            {
            // InternalXUmlb.g:9270:2: ( ruleTypedParameter )
            // InternalXUmlb.g:9271:3: ruleTypedParameter
            {
             before(grammarAccess.getClassMethodAccess().getParametersTypedParameterParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTypedParameter();

            state._fsp--;

             after(grammarAccess.getClassMethodAccess().getParametersTypedParameterParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__ParametersAssignment_6_1"


    // $ANTLR start "rule__ClassMethod__ParametersAssignment_6_2_1"
    // InternalXUmlb.g:9280:1: rule__ClassMethod__ParametersAssignment_6_2_1 : ( ruleTypedParameter ) ;
    public final void rule__ClassMethod__ParametersAssignment_6_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9284:1: ( ( ruleTypedParameter ) )
            // InternalXUmlb.g:9285:2: ( ruleTypedParameter )
            {
            // InternalXUmlb.g:9285:2: ( ruleTypedParameter )
            // InternalXUmlb.g:9286:3: ruleTypedParameter
            {
             before(grammarAccess.getClassMethodAccess().getParametersTypedParameterParserRuleCall_6_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTypedParameter();

            state._fsp--;

             after(grammarAccess.getClassMethodAccess().getParametersTypedParameterParserRuleCall_6_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__ParametersAssignment_6_2_1"


    // $ANTLR start "rule__ClassMethod__GuardsAssignment_7_1"
    // InternalXUmlb.g:9295:1: rule__ClassMethod__GuardsAssignment_7_1 : ( ruleGuard ) ;
    public final void rule__ClassMethod__GuardsAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9299:1: ( ( ruleGuard ) )
            // InternalXUmlb.g:9300:2: ( ruleGuard )
            {
            // InternalXUmlb.g:9300:2: ( ruleGuard )
            // InternalXUmlb.g:9301:3: ruleGuard
            {
             before(grammarAccess.getClassMethodAccess().getGuardsGuardParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGuard();

            state._fsp--;

             after(grammarAccess.getClassMethodAccess().getGuardsGuardParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__GuardsAssignment_7_1"


    // $ANTLR start "rule__ClassMethod__ActionsAssignment_8_1"
    // InternalXUmlb.g:9310:1: rule__ClassMethod__ActionsAssignment_8_1 : ( ruleAction ) ;
    public final void rule__ClassMethod__ActionsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9314:1: ( ( ruleAction ) )
            // InternalXUmlb.g:9315:2: ( ruleAction )
            {
            // InternalXUmlb.g:9315:2: ( ruleAction )
            // InternalXUmlb.g:9316:3: ruleAction
            {
             before(grammarAccess.getClassMethodAccess().getActionsActionParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getClassMethodAccess().getActionsActionParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__ActionsAssignment_8_1"


    // $ANTLR start "rule__ClassMethod__WitnessesAssignment_9_1"
    // InternalXUmlb.g:9325:1: rule__ClassMethod__WitnessesAssignment_9_1 : ( ruleWitness ) ;
    public final void rule__ClassMethod__WitnessesAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9329:1: ( ( ruleWitness ) )
            // InternalXUmlb.g:9330:2: ( ruleWitness )
            {
            // InternalXUmlb.g:9330:2: ( ruleWitness )
            // InternalXUmlb.g:9331:3: ruleWitness
            {
             before(grammarAccess.getClassMethodAccess().getWitnessesWitnessParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleWitness();

            state._fsp--;

             after(grammarAccess.getClassMethodAccess().getWitnessesWitnessParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMethod__WitnessesAssignment_9_1"


    // $ANTLR start "rule__Invariant__TheoremAssignment_0"
    // InternalXUmlb.g:9340:1: rule__Invariant__TheoremAssignment_0 : ( ( 'theorem' ) ) ;
    public final void rule__Invariant__TheoremAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9344:1: ( ( ( 'theorem' ) ) )
            // InternalXUmlb.g:9345:2: ( ( 'theorem' ) )
            {
            // InternalXUmlb.g:9345:2: ( ( 'theorem' ) )
            // InternalXUmlb.g:9346:3: ( 'theorem' )
            {
             before(grammarAccess.getInvariantAccess().getTheoremTheoremKeyword_0_0()); 
            // InternalXUmlb.g:9347:3: ( 'theorem' )
            // InternalXUmlb.g:9348:4: 'theorem'
            {
             before(grammarAccess.getInvariantAccess().getTheoremTheoremKeyword_0_0()); 
            match(input,164,FOLLOW_2); 
             after(grammarAccess.getInvariantAccess().getTheoremTheoremKeyword_0_0()); 

            }

             after(grammarAccess.getInvariantAccess().getTheoremTheoremKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__TheoremAssignment_0"


    // $ANTLR start "rule__Invariant__NameAssignment_1"
    // InternalXUmlb.g:9359:1: rule__Invariant__NameAssignment_1 : ( RULE_XLABEL ) ;
    public final void rule__Invariant__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9363:1: ( ( RULE_XLABEL ) )
            // InternalXUmlb.g:9364:2: ( RULE_XLABEL )
            {
            // InternalXUmlb.g:9364:2: ( RULE_XLABEL )
            // InternalXUmlb.g:9365:3: RULE_XLABEL
            {
             before(grammarAccess.getInvariantAccess().getNameXLABELTerminalRuleCall_1_0()); 
            match(input,RULE_XLABEL,FOLLOW_2); 
             after(grammarAccess.getInvariantAccess().getNameXLABELTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__NameAssignment_1"


    // $ANTLR start "rule__Invariant__PredicateAssignment_2"
    // InternalXUmlb.g:9374:1: rule__Invariant__PredicateAssignment_2 : ( ruleXFormula ) ;
    public final void rule__Invariant__PredicateAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9378:1: ( ( ruleXFormula ) )
            // InternalXUmlb.g:9379:2: ( ruleXFormula )
            {
            // InternalXUmlb.g:9379:2: ( ruleXFormula )
            // InternalXUmlb.g:9380:3: ruleXFormula
            {
             before(grammarAccess.getInvariantAccess().getPredicateXFormulaParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getInvariantAccess().getPredicateXFormulaParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__PredicateAssignment_2"


    // $ANTLR start "rule__Guard__TheoremAssignment_0"
    // InternalXUmlb.g:9389:1: rule__Guard__TheoremAssignment_0 : ( ( 'theorem' ) ) ;
    public final void rule__Guard__TheoremAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9393:1: ( ( ( 'theorem' ) ) )
            // InternalXUmlb.g:9394:2: ( ( 'theorem' ) )
            {
            // InternalXUmlb.g:9394:2: ( ( 'theorem' ) )
            // InternalXUmlb.g:9395:3: ( 'theorem' )
            {
             before(grammarAccess.getGuardAccess().getTheoremTheoremKeyword_0_0()); 
            // InternalXUmlb.g:9396:3: ( 'theorem' )
            // InternalXUmlb.g:9397:4: 'theorem'
            {
             before(grammarAccess.getGuardAccess().getTheoremTheoremKeyword_0_0()); 
            match(input,164,FOLLOW_2); 
             after(grammarAccess.getGuardAccess().getTheoremTheoremKeyword_0_0()); 

            }

             after(grammarAccess.getGuardAccess().getTheoremTheoremKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__TheoremAssignment_0"


    // $ANTLR start "rule__Guard__NameAssignment_1"
    // InternalXUmlb.g:9408:1: rule__Guard__NameAssignment_1 : ( RULE_XLABEL ) ;
    public final void rule__Guard__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9412:1: ( ( RULE_XLABEL ) )
            // InternalXUmlb.g:9413:2: ( RULE_XLABEL )
            {
            // InternalXUmlb.g:9413:2: ( RULE_XLABEL )
            // InternalXUmlb.g:9414:3: RULE_XLABEL
            {
             before(grammarAccess.getGuardAccess().getNameXLABELTerminalRuleCall_1_0()); 
            match(input,RULE_XLABEL,FOLLOW_2); 
             after(grammarAccess.getGuardAccess().getNameXLABELTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__NameAssignment_1"


    // $ANTLR start "rule__Guard__PredicateAssignment_2"
    // InternalXUmlb.g:9423:1: rule__Guard__PredicateAssignment_2 : ( ruleXFormula ) ;
    public final void rule__Guard__PredicateAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9427:1: ( ( ruleXFormula ) )
            // InternalXUmlb.g:9428:2: ( ruleXFormula )
            {
            // InternalXUmlb.g:9428:2: ( ruleXFormula )
            // InternalXUmlb.g:9429:3: ruleXFormula
            {
             before(grammarAccess.getGuardAccess().getPredicateXFormulaParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getGuardAccess().getPredicateXFormulaParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__PredicateAssignment_2"


    // $ANTLR start "rule__Action__NameAssignment_0"
    // InternalXUmlb.g:9438:1: rule__Action__NameAssignment_0 : ( RULE_XLABEL ) ;
    public final void rule__Action__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9442:1: ( ( RULE_XLABEL ) )
            // InternalXUmlb.g:9443:2: ( RULE_XLABEL )
            {
            // InternalXUmlb.g:9443:2: ( RULE_XLABEL )
            // InternalXUmlb.g:9444:3: RULE_XLABEL
            {
             before(grammarAccess.getActionAccess().getNameXLABELTerminalRuleCall_0_0()); 
            match(input,RULE_XLABEL,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getNameXLABELTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__NameAssignment_0"


    // $ANTLR start "rule__Action__ActionAssignment_1"
    // InternalXUmlb.g:9453:1: rule__Action__ActionAssignment_1 : ( ruleXFormula ) ;
    public final void rule__Action__ActionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9457:1: ( ( ruleXFormula ) )
            // InternalXUmlb.g:9458:2: ( ruleXFormula )
            {
            // InternalXUmlb.g:9458:2: ( ruleXFormula )
            // InternalXUmlb.g:9459:3: ruleXFormula
            {
             before(grammarAccess.getActionAccess().getActionXFormulaParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getActionAccess().getActionXFormulaParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__ActionAssignment_1"


    // $ANTLR start "rule__Witness__NameAssignment_0"
    // InternalXUmlb.g:9468:1: rule__Witness__NameAssignment_0 : ( RULE_XLABEL ) ;
    public final void rule__Witness__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9472:1: ( ( RULE_XLABEL ) )
            // InternalXUmlb.g:9473:2: ( RULE_XLABEL )
            {
            // InternalXUmlb.g:9473:2: ( RULE_XLABEL )
            // InternalXUmlb.g:9474:3: RULE_XLABEL
            {
             before(grammarAccess.getWitnessAccess().getNameXLABELTerminalRuleCall_0_0()); 
            match(input,RULE_XLABEL,FOLLOW_2); 
             after(grammarAccess.getWitnessAccess().getNameXLABELTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Witness__NameAssignment_0"


    // $ANTLR start "rule__Witness__PredicateAssignment_1"
    // InternalXUmlb.g:9483:1: rule__Witness__PredicateAssignment_1 : ( ruleXFormula ) ;
    public final void rule__Witness__PredicateAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXUmlb.g:9487:1: ( ( ruleXFormula ) )
            // InternalXUmlb.g:9488:2: ( ruleXFormula )
            {
            // InternalXUmlb.g:9488:2: ( ruleXFormula )
            // InternalXUmlb.g:9489:3: ruleXFormula
            {
             before(grammarAccess.getWitnessAccess().getPredicateXFormulaParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getWitnessAccess().getPredicateXFormulaParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Witness__PredicateAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFFFFFFFFFFF052L,0x00003FFFFFFFFFFFL,0x0000000008000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0700000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0001C00000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x5A00000000000000L,0x0000000000007822L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000007822L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x8100000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L,0x000000000000001EL});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000080L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000082L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400003010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L,0x0000000000000740L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0C00000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0A00000000000000L,0x0000000000090000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0070000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x3300000000000000L,0x0000000002C60040L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x8100000000000000L,0x00000003C0100000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000C00000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L,0x00000003C0100001L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0xFFFFFFFFFFFFF050L,0x00003FFFFFFFFFFFL,0x0000000008000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x000E000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0900000000000000L,0x000000002000001EL});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000010000000L});

}