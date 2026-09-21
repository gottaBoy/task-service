/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.MainState;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicImpl;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysLogic;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Data.PSDEActionLogic;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.PS.Data.PSDELogicParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEMainStateDenyActionLogicImpl
extends PSDELogicImpl
implements IPSDEActionLogic {
    private static final Log log = LogFactory.getLog(PSDEMainStateDenyActionLogicImpl.class);
    protected ArrayList<IPSDEMainState> psDEMainStateList = new ArrayList();
    private IPSDEAction iPSDEAction = null;
    private Vector<PSDELogicParam> psDELogicParamList = new Vector();
    private Vector<PSDELogicNode> psDELogicNodeList = new Vector();
    private Vector<PSDELogicNodeParam> psDELogicNodeParamList = new Vector();
    private Vector<PSDELogicLink> psDELogicLinkList = new Vector();
    private Vector<PSDELogicLinkCond> psDELogicLinkCondList = new Vector();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEAction iPSDEAction, List<IPSDEMainState> psDEMainStateList) throws Exception {
        this.iPSDEAction = iPSDEAction;
        IPSDataEntity iPSDataEntity = this.iPSDEAction.getPSDataEntity();
        if (iPSDataEntity == null || iPSDataEntity.getKeyPSDEField() == null) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u53c2\u6570\u65e0\u6548"));
        }
        IPSDEAction getPSDEAction = iPSDataEntity.getPSDEAction("GET", true);
        if (getPSDEAction == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u672a\u63d0\u4f9b[GET]\u884c\u4e3a"));
        }
        this.psDEMainStateList.addAll(psDEMainStateList);
        Collections.sort(this.psDEMainStateList, new Comparator<IPSDEMainState>(){

            @Override
            public int compare(IPSDEMainState o1, IPSDEMainState o2) {
                if (!StringHelper.isNullOrEmpty((String)o2.getState3Value()) && StringHelper.isNullOrEmpty((String)o1.getState3Value())) {
                    return 1;
                }
                if (!StringHelper.isNullOrEmpty((String)o2.getState2Value()) && StringHelper.isNullOrEmpty((String)o1.getState2Value())) {
                    return 1;
                }
                return 0;
            }
        });
        PSDELogic psDELogic = new PSDELogic();
        psDELogic.setPSDELOGICID(StringHelper.format((String)"%1$s__MSDENY", (Object)iPSDEAction.getId()));
        psDELogic.setPSDELOGICNAME(StringHelper.format((String)"\u884c\u4e3a[%1$s]\u4e3b\u72b6\u6001\u62d2\u7edd\u903b\u8f91", (Object)iPSDEAction.getName()));
        psDELogic.setCODENAME(StringHelper.format((String)"%1$s__MSDeny", (Object)iPSDEAction.getCodeName()));
        psDELogic.setLOGICTYPE("DELOGIC");
        psDELogic.setLOGICHOLDER(1);
        psDELogic.set("AUTOMODEL", 1);
        PSDELogicParam defaultPSDELogicParam = null;
        PSDELogicParam tempPSDELogicParam = null;
        PSDELogicParam psDELogicParam = new PSDELogicParam();
        psDELogicParam.setPSDELOGICID(psDELogic.getPSDELOGICID());
        psDELogicParam.setPSDELOGICPARAMID(StringHelper.format((String)"%1$s__DEFAULT", (Object)psDELogic.getPSDELOGICID()));
        psDELogicParam.setPSDELOGICPARAMNAME("Default");
        psDELogicParam.setLOGICNAME("\u9ed8\u8ba4\u53d8\u91cf");
        psDELogicParam.setDEFAULTPARAM(true);
        psDELogicParam.setPARAMPSDEID(iPSDataEntity.getId());
        psDELogicParam.setPARAMPSDENAME(iPSDataEntity.getName());
        psDELogicParam.set("AUTOMODEL", 1);
        this.psDELogicParamList.add(psDELogicParam);
        defaultPSDELogicParam = psDELogicParam;
        psDELogicParam = new PSDELogicParam();
        psDELogicParam.setPSDELOGICID(psDELogic.getPSDELOGICID());
        psDELogicParam.setPSDELOGICPARAMID(StringHelper.format((String)"%1$s__TEMP", (Object)psDELogic.getPSDELOGICID()));
        psDELogicParam.setPSDELOGICPARAMNAME("Temp");
        psDELogicParam.setLOGICNAME("\u4e34\u65f6\u53d8\u91cf");
        psDELogicParam.setDEFAULTPARAM(false);
        psDELogicParam.setPARAMPSDEID(iPSDataEntity.getId());
        psDELogicParam.setPARAMPSDENAME(iPSDataEntity.getName());
        psDELogicParam.set("AUTOMODEL", 1);
        this.psDELogicParamList.add(psDELogicParam);
        tempPSDELogicParam = psDELogicParam;
        PSDELogicNode beginPSDELogicNode = null;
        PSDELogicNode preparePSDELogicNode = null;
        PSDELogicNode getPSDELogicNode = null;
        PSDELogicNode psDELogicNode = new PSDELogicNode();
        psDELogicNode.setPSDELOGICID(psDELogic.getPSDELOGICID());
        psDELogicNode.setPSDELOGICNODEID(StringHelper.format((String)"%1$s__BEGIN", (Object)psDELogic.getPSDELOGICID()));
        psDELogicNode.setPSDELOGICNODENAME("\u5f00\u59cb");
        psDELogicNode.setCODENAME("Begin");
        psDELogicNode.setLOGICNODETYPE("BEGIN");
        psDELogicNode.setPARALLELOUTPUT(false);
        psDELogicNode.set("AUTOMODEL", 1);
        this.psDELogicNodeList.add(psDELogicNode);
        beginPSDELogicNode = psDELogicNode;
        psDELogicNode = new PSDELogicNode();
        psDELogicNode.setPSDELOGICID(psDELogic.getPSDELOGICID());
        psDELogicNode.setPSDELOGICNODEID(StringHelper.format((String)"%1$s__PREPARETEMP", (Object)psDELogic.getPSDELOGICID()));
        psDELogicNode.setPSDELOGICNODENAME("\u51c6\u5907\u4e34\u65f6\u53c2\u6570");
        psDELogicNode.setCODENAME("PrepareTemp");
        psDELogicNode.setLOGICNODETYPE("PREPAREPARAM");
        psDELogicNode.setPARALLELOUTPUT(false);
        psDELogicNode.set("AUTOMODEL", 1);
        this.psDELogicNodeList.add(psDELogicNode);
        preparePSDELogicNode = psDELogicNode;
        PSDELogicNodeParam psDELogicNodeParam = new PSDELogicNodeParam();
        psDELogicNodeParam.setPSDELOGICID(psDELogic.getPSDELOGICID());
        psDELogicNodeParam.setPSDELOGICNODEID(psDELogicNode.getPSDELOGICNODEID());
        psDELogicNodeParam.setPSDELNPARAMID(StringHelper.format((String)"%1$s__PARAM1", (Object)psDELogicNode.getPSDELOGICNODEID()));
        psDELogicNodeParam.setPSDELNPARAMNAME("\u590d\u5236\u4e3b\u952e");
        psDELogicNodeParam.setPARAMTYPE("SETPARAMVALUE");
        psDELogicNodeParam.setSRCPSDLPARAMID(StringHelper.format((String)"%1$s__DEFAULT", (Object)psDELogic.getPSDELOGICID()));
        psDELogicNodeParam.setDSTPSDLPARAMID(StringHelper.format((String)"%1$s__TEMP", (Object)psDELogic.getPSDELOGICID()));
        psDELogicNodeParam.setSRCPSDEFID(iPSDataEntity.getKeyPSDEField().getId());
        psDELogicNodeParam.setSRCPSDEFNAME(iPSDataEntity.getKeyPSDEField().getName());
        psDELogicNodeParam.setDSTPSDEFID(iPSDataEntity.getKeyPSDEField().getId());
        psDELogicNodeParam.setDSTPSDEFNAME(iPSDataEntity.getKeyPSDEField().getName());
        psDELogicNodeParam.setSRCVALUETYPE("SRCDLPARAM");
        psDELogicNodeParam.set("AUTOMODEL", 1);
        this.psDELogicNodeParamList.add(psDELogicNodeParam);
        PSDELogicLink psDELogicLink = new PSDELogicLink();
        psDELogicLink.setPSDELOGICID(psDELogic.getPSDELOGICID());
        psDELogicLink.setPSDELOGICLINKID(psDELogicNode.getPSDELOGICNODEID());
        psDELogicLink.setPSDELOGICLINKNAME("\u9ed8\u8ba4\u8fde\u63a5");
        psDELogicLink.setDEFAULTLINK(true);
        psDELogicLink.setSRCPSDELOGICNODEID(beginPSDELogicNode.getPSDELOGICNODEID());
        psDELogicLink.setSRCPSDELOGICNODENAME(beginPSDELogicNode.getPSDELOGICNODENAME());
        psDELogicLink.setDSTPSDELOGICNODEID(preparePSDELogicNode.getPSDELOGICNODEID());
        psDELogicLink.setDSTPSDELOGICNODENAME(preparePSDELogicNode.getPSDELOGICNODENAME());
        psDELogicLink.set("AUTOMODEL", 1);
        this.psDELogicLinkList.add(psDELogicLink);
        psDELogicNode = new PSDELogicNode();
        psDELogicNode.setPSDELOGICID(psDELogic.getPSDELOGICID());
        psDELogicNode.setPSDELOGICNODEID(StringHelper.format((String)"%1$s__GET", (Object)psDELogic.getPSDELOGICID()));
        psDELogicNode.setPSDELOGICNODENAME("\u83b7\u53d6\u6570\u636e");
        psDELogicNode.setCODENAME("Get");
        psDELogicNode.setLOGICNODETYPE("DEACTION");
        psDELogicNode.setPARALLELOUTPUT(true);
        psDELogicNode.setDSTPSDEID(iPSDataEntity.getId());
        psDELogicNode.setDSTPSDENAME(iPSDataEntity.getName());
        psDELogicNode.setDSTPSDEACTIONID(getPSDEAction.getId());
        psDELogicNode.setDSTPSDEACTIONNAME(getPSDEAction.getName());
        psDELogicNode.setDSTPSDLPARAMID(tempPSDELogicParam.getPSDELOGICPARAMID());
        psDELogicNode.setDSTPSDLPARAMNAME(tempPSDELogicParam.getPSDELOGICPARAMNAME());
        psDELogicNode.set("AUTOMODEL", 1);
        this.psDELogicNodeList.add(psDELogicNode);
        getPSDELogicNode = psDELogicNode;
        psDELogicLink = new PSDELogicLink();
        psDELogicLink.setPSDELOGICID(psDELogic.getPSDELOGICID());
        psDELogicLink.setPSDELOGICLINKID(psDELogicNode.getPSDELOGICNODEID());
        psDELogicLink.setPSDELOGICLINKNAME("\u9ed8\u8ba4\u8fde\u63a5");
        psDELogicLink.setDEFAULTLINK(true);
        psDELogicLink.setSRCPSDELOGICNODEID(preparePSDELogicNode.getPSDELOGICNODEID());
        psDELogicLink.setSRCPSDELOGICNODENAME(preparePSDELogicNode.getPSDELOGICNODENAME());
        psDELogicLink.setDSTPSDELOGICNODEID(getPSDELogicNode.getPSDELOGICNODEID());
        psDELogicLink.setDSTPSDELOGICNODENAME(getPSDELogicNode.getPSDELOGICNODENAME());
        psDELogicLink.set("AUTOMODEL", 1);
        this.psDELogicLinkList.add(psDELogicLink);
        String strActionName = iPSDEAction.getLogicName();
        if (StringHelper.isNullOrEmpty((String)strActionName)) {
            strActionName = iPSDEAction.getName();
        }
        for (IPSDEMainState iPSDEMainState : this.psDEMainStateList) {
            PSDELogicLinkCond psDELogicLinkCond;
            PSDELogicNode psDELogicNode2 = new PSDELogicNode();
            psDELogicNode2.setPSDELOGICID(psDELogic.getPSDELOGICID());
            psDELogicNode2.setPSDELOGICNODEID(StringHelper.format((String)"%1$s__%2$s", (Object)psDELogic.getPSDELOGICID(), (Object)iPSDEMainState.getCodeName()));
            psDELogicNode2.setPSDELOGICNODENAME(StringHelper.format((String)"\u72b6\u6001[%1$s]\u62d2\u7edd[%2$s]\u64cd\u4f5c", (Object)iPSDEMainState.getName(), (Object)strActionName));
            psDELogicNode2.setCODENAME(StringHelper.format((String)"DenyBy%1$s", (Object)iPSDEMainState.getCodeName()));
            psDELogicNode2.setLOGICNODETYPE("THROWEXCEPTION");
            psDELogicNode2.setPARALLELOUTPUT(false);
            if (!StringHelper.isNullOrEmpty((String)iPSDEMainState.getActionDenyMsg())) {
                psDELogicNode2.setPARAM3(iPSDEMainState.getActionDenyMsg());
            } else {
                psDELogicNode2.setPARAM3(StringHelper.format((String)"\u72b6\u6001[%1$s]\u62d2\u7edd[%2$s]\u64cd\u4f5c", (Object)iPSDEMainState.getName(), (Object)strActionName));
            }
            psDELogicNode2.set("AUTOMODEL", 1);
            this.psDELogicNodeList.add(psDELogicNode2);
            PSDELogicLink psDELogicLink2 = new PSDELogicLink();
            psDELogicLink2.setPSDELOGICID(psDELogic.getPSDELOGICID());
            psDELogicLink2.setPSDELOGICLINKID(psDELogicNode2.getPSDELOGICNODEID());
            psDELogicLink2.setPSDELOGICLINKNAME(StringHelper.format((String)"\u72b6\u6001[%1$s]\u62d2\u7edd[%2$s]\u64cd\u4f5c", (Object)iPSDEMainState.getName(), (Object)strActionName));
            psDELogicLink2.setDEFAULTLINK(false);
            psDELogicLink2.setSRCPSDELOGICNODEID(getPSDELogicNode.getPSDELOGICNODEID());
            psDELogicLink2.setSRCPSDELOGICNODENAME(getPSDELogicNode.getPSDELOGICNODENAME());
            psDELogicLink2.setDSTPSDELOGICNODEID(psDELogicNode2.getPSDELOGICNODEID());
            psDELogicLink2.setDSTPSDELOGICNODENAME(psDELogicNode2.getPSDELOGICNODENAME());
            psDELogicLink2.set("AUTOMODEL", 1);
            this.psDELogicLinkList.add(psDELogicLink2);
            if (!StringHelper.isNullOrEmpty((String)iPSDEMainState.getStateValue()) && iPSDataEntity.getMainStatePSDEField() != null && StringHelper.compare((String)iPSDEMainState.getStateValue(), (String)"*", (boolean)false) != 0) {
                psDELogicLinkCond = new PSDELogicLinkCond();
                psDELogicLinkCond.setPSDELOGICID(psDELogic.getPSDELOGICID());
                psDELogicLinkCond.setPSDELOGICLINKID(psDELogicLink2.getPSDELOGICLINKID());
                psDELogicLinkCond.setPSDELOGICLINKNAME(psDELogicLink2.getPSDELOGICLINKNAME());
                psDELogicLinkCond.setPSDELLCONDID(StringHelper.format((String)"%1$s__%2$s", (Object)psDELogicNode2.getPSDELOGICNODEID(), (Object)iPSDataEntity.getMainStatePSDEField().getName()));
                psDELogicLinkCond.setPSDELLCONDNAME(StringHelper.format((String)"\u5c5e\u6027[%1$s]\u7b49\u4e8e[%2$s]", (Object)iPSDataEntity.getMainStatePSDEField().getName(), (Object)iPSDEMainState.getStateValue()));
                psDELogicLinkCond.setLOGICTYPE("SINGLE");
                psDELogicLinkCond.setDSTPSDLPARAMID(tempPSDELogicParam.getPSDELOGICPARAMID());
                psDELogicLinkCond.setDSTPSDLPARAMNAME(tempPSDELogicParam.getPSDELOGICPARAMNAME());
                psDELogicLinkCond.setDSTPSDEFID(iPSDataEntity.getMainStatePSDEField().getId());
                psDELogicLinkCond.setDSTPSDEFNAME(iPSDataEntity.getMainStatePSDEField().getName());
                psDELogicLinkCond.setCONDVALUE(iPSDEMainState.getStateValue());
                psDELogicLinkCond.setPSDBVALUEOPID("EQ");
                psDELogicLinkCond.setPSDBVALUEOPNAME("\u7b49\u4e8e(=)");
                psDELogicLinkCond.set("AUTOMODEL", 1);
                this.psDELogicLinkCondList.add(psDELogicLinkCond);
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEMainState.getState2Value()) && iPSDataEntity.getMainState2PSDEField() != null && StringHelper.compare((String)iPSDEMainState.getState2Value(), (String)"*", (boolean)false) != 0) {
                psDELogicLinkCond = new PSDELogicLinkCond();
                psDELogicLinkCond.setPSDELOGICID(psDELogic.getPSDELOGICID());
                psDELogicLinkCond.setPSDELOGICLINKID(psDELogicLink2.getPSDELOGICLINKID());
                psDELogicLinkCond.setPSDELOGICLINKNAME(psDELogicLink2.getPSDELOGICLINKNAME());
                psDELogicLinkCond.setPSDELLCONDID(StringHelper.format((String)"%1$s__%2$s", (Object)psDELogicNode2.getPSDELOGICNODEID(), (Object)iPSDataEntity.getMainState2PSDEField().getName()));
                psDELogicLinkCond.setPSDELLCONDNAME(StringHelper.format((String)"\u5c5e\u6027[%1$s]\u7b49\u4e8e[%2$s]", (Object)iPSDataEntity.getMainState2PSDEField().getName(), (Object)iPSDEMainState.getState2Value()));
                psDELogicLinkCond.setLOGICTYPE("SINGLE");
                psDELogicLinkCond.setDSTPSDLPARAMID(tempPSDELogicParam.getPSDELOGICPARAMID());
                psDELogicLinkCond.setDSTPSDLPARAMNAME(tempPSDELogicParam.getPSDELOGICPARAMNAME());
                psDELogicLinkCond.setDSTPSDEFID(iPSDataEntity.getMainState2PSDEField().getId());
                psDELogicLinkCond.setDSTPSDEFNAME(iPSDataEntity.getMainState2PSDEField().getName());
                psDELogicLinkCond.setCONDVALUE(iPSDEMainState.getState2Value());
                psDELogicLinkCond.setPSDBVALUEOPID("EQ");
                psDELogicLinkCond.setPSDBVALUEOPNAME("\u7b49\u4e8e(=)");
                psDELogicLinkCond.set("AUTOMODEL", 1);
                this.psDELogicLinkCondList.add(psDELogicLinkCond);
            }
            if (StringHelper.isNullOrEmpty((String)iPSDEMainState.getState3Value()) || iPSDataEntity.getMainState3PSDEField() == null || StringHelper.compare((String)iPSDEMainState.getState3Value(), (String)"*", (boolean)false) == 0) continue;
            psDELogicLinkCond = new PSDELogicLinkCond();
            psDELogicLinkCond.setPSDELOGICID(psDELogic.getPSDELOGICID());
            psDELogicLinkCond.setPSDELOGICLINKID(psDELogicLink2.getPSDELOGICLINKID());
            psDELogicLinkCond.setPSDELOGICLINKNAME(psDELogicLink2.getPSDELOGICLINKNAME());
            psDELogicLinkCond.setPSDELLCONDID(StringHelper.format((String)"%1$s__%2$s", (Object)psDELogicNode2.getPSDELOGICNODEID(), (Object)iPSDataEntity.getMainState3PSDEField().getName()));
            psDELogicLinkCond.setPSDELLCONDNAME(StringHelper.format((String)"\u5c5e\u6027[%1$s]\u7b49\u4e8e[%2$s]", (Object)iPSDataEntity.getMainState3PSDEField().getName(), (Object)iPSDEMainState.getState3Value()));
            psDELogicLinkCond.setLOGICTYPE("SINGLE");
            psDELogicLinkCond.setDSTPSDLPARAMID(tempPSDELogicParam.getPSDELOGICPARAMID());
            psDELogicLinkCond.setDSTPSDLPARAMNAME(tempPSDELogicParam.getPSDELOGICPARAMNAME());
            psDELogicLinkCond.setDSTPSDEFID(iPSDataEntity.getMainState3PSDEField().getId());
            psDELogicLinkCond.setDSTPSDEFNAME(iPSDataEntity.getMainState3PSDEField().getName());
            psDELogicLinkCond.setCONDVALUE(iPSDEMainState.getState3Value());
            psDELogicLinkCond.setPSDBVALUEOPID("EQ");
            psDELogicLinkCond.setPSDBVALUEOPNAME("\u7b49\u4e8e(=)");
            psDELogicLinkCond.set("AUTOMODEL", 1);
            this.psDELogicLinkCondList.add(psDELogicLinkCond);
        }
        super.init(iDAGlobalHelper, iPSDataEntity, psDELogic);
    }

    @Override
    protected Vector<PSDELogicParam> getPSDELogicParamDatas() throws Exception {
        return this.psDELogicParamList;
    }

    @Override
    protected Vector<PSDELogicNode> getPSDELogicNodeDatas() throws Exception {
        return this.psDELogicNodeList;
    }

    @Override
    protected Vector<PSDELogicLink> getPSDELogicLinkDatas() throws Exception {
        return this.psDELogicLinkList;
    }

    @Override
    protected Vector<PSDELogicNodeParam> getPSDELogicNodeParamDatas() throws Exception {
        return this.psDELogicNodeParamList;
    }

    @Override
    protected Vector<PSDELogicLinkCond> getPSDELogicLinkCondDatas() throws Exception {
        return this.psDELogicLinkCondList;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEAction iPSDEAction, PSDEActionLogic psDEActionLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    public String getAttachMode() {
        return "CHECK";
    }

    @Override
    public String getPSDELogicId() {
        return this.getId();
    }

    @Override
    public String getPSDELogicName() {
        return this.getName();
    }

    @Override
    public IPSDELogic getPSDELogic() throws Exception {
        return this;
    }

    @Override
    public boolean isInternalLogic() {
        return true;
    }

    @Override
    public IPSDataEntity getDstPSDE() throws Exception {
        return null;
    }

    @Override
    public IPSDEAction getDstPSDEAction() throws Exception {
        return null;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean isCloneParam() {
        return false;
    }

    @Override
    public boolean isIgnoreException() {
        return false;
    }

    @Override
    public int getActionLogicType() {
        return 1;
    }

    @Override
    public boolean isPrepareLast() {
        return false;
    }

    @Override
    public int getPrepareLastMode() {
        return 0;
    }

    @Override
    public IPSDENotify getPSDENotify() throws Exception {
        return null;
    }

    @Override
    public IPSDEMainState getPSDEMainState() throws Exception {
        return null;
    }

    @Override
    public IPSDEFValueRule getPSDEFValueRule() throws Exception {
        return null;
    }

    @Override
    public IPSDEDataSync getPSDEDataSync() throws Exception {
        return null;
    }

    @Override
    public IPSDEDataSet getDstPSDEDataSet() throws Exception {
        return null;
    }

    @Override
    public IPSDERBase getMajorPSDER() throws Exception {
        return null;
    }

    @Override
    public int getErrorCode() {
        return 0;
    }

    @Override
    public String getExceptionObj() {
        return null;
    }

    @Override
    public IPSDEField getPSDEField() throws Exception {
        return null;
    }

    @Override
    public IPSSysLogic getPSSysLogic() throws Exception {
        return null;
    }

    @Override
    public IPSSysSequence getPSSysSequence() throws Exception {
        return null;
    }

    @Override
    public IPSSysTranslator getPSSysTranslator() throws Exception {
        return null;
    }

    @Override
    public String getErrorInfo() {
        return null;
    }

    @Override
    public IPSLanguageRes getErrorInfoPSLanguageRes() throws Exception {
        return null;
    }

    @Override
    public Properties getLogicParams() {
        return null;
    }

    @Override
    public int getDataSyncEvent() {
        return 0;
    }

    @Override
    public IPSDELogic getDstPSDELogic() throws Exception {
        return null;
    }
}

