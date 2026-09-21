/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowLink;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNode;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeType;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataFlowImpl
extends PSDataEntityObjectImpl
implements IPSDEDataFlow,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEDataFlowImpl.class);
    protected PSDELogic psDELogic;
    protected Map<String, IPSDEDataFlowNode> psDEDataFlowNodeMap = new LinkedHashMap<String, IPSDEDataFlowNode>();
    protected ArrayList<IPSDEDataFlowLink> psDEDataFlowLinkList = new ArrayList();
    private String strCodeName = "";
    private String strLogicType = "DATAFLOWLOGIC";
    private int nExtendMode = 0;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private int nDebugMode = 0;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDELogic psDELogic) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDELogic = psDELogic;
            this.setId(this.psDELogic.getPSDELOGICID());
            this.setName(this.psDELogic.getPSDELOGICNAME());
            this.setPSObjectData(this.psDELogic);
            this.strCodeName = this.psDELogic.getCODENAME();
            if (!this.psDELogic.isDEBUGMODENull()) {
                this.nDebugMode = this.psDELogic.getDEBUGMODE();
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!StringHelper.isNullOrEmpty((String)PSDEDataFlowImpl.this.getModelType()) && !StringHelper.isNullOrEmpty((String)PSDEDataFlowImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSDEDataFlowImpl.this.getModelType(), (Object)PSDEDataFlowImpl.this.getId())) {
                            throw new Exception(StringHelper.format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        try {
                            PSDEDataFlowImpl.this.onInit();
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEDataFlowImpl.this.getModelType(), (Object)PSDEDataFlowImpl.this.getId());
                        }
                        catch (Exception ex) {
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEDataFlowImpl.this.getModelType(), (Object)PSDEDataFlowImpl.this.getId());
                            throw ex;
                        }
                    } else {
                        PSDEDataFlowImpl.this.onInit();
                    }
                }
            });
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected int onCheck() throws Exception {
        Iterator<IPSDEDataFlowLink> psDEDataFlowLinks;
        int nRet = 0;
        Iterator<IPSDEDataFlowNode> psDEDataFlowNodes = this.getPSDEDataFlowNodes();
        if (psDEDataFlowNodes != null) {
            while (psDEDataFlowNodes.hasNext()) {
                IPSDEDataFlowNode iPSDEDataFlowNode = psDEDataFlowNodes.next();
                nRet += iPSDEDataFlowNode.check();
            }
        }
        if ((psDEDataFlowLinks = this.getPSDEDataFlowLinks()) != null) {
            while (psDEDataFlowLinks.hasNext()) {
                IPSDEDataFlowLink iPSDEDataFlowLink = psDEDataFlowLinks.next();
                nRet += iPSDEDataFlowLink.check();
            }
        }
        return nRet += super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"PSDELOGICNAME"})
    public String getLogicName() {
        return this.psDELogic.getPSDELOGICNAME();
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDELogic.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDELogic.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
        this.onPreparePSDEDataFlowNodes();
    }

    protected void onPreparePSDEDataFlowNodes() throws Exception {
        this.psDEDataFlowNodeMap.clear();
        Vector<PSDELogicNode> psDELogicNodeList = this.getPSDELogicNodeDatas();
        HashMap<String, PSDELogicNode> psDEDataFlowNodeMap = new HashMap<String, PSDELogicNode>();
        for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
            psDEDataFlowNodeMap.put(psDELogicNode.getPSDELOGICNODEID(), psDELogicNode);
        }
        this.psDEDataFlowLinkList.clear();
        Vector<PSDELogicLink> psDEDataFlowLinkList = this.getPSDELogicLinkDatas();
        HashMap<String, PSDELogicLink> psDELogicLinkMap = new HashMap<String, PSDELogicLink>();
        for (PSDELogicLink psDELogicLink : psDEDataFlowLinkList) {
            psDELogicLinkMap.put(psDELogicLink.getPSDELOGICLINKID(), psDELogicLink);
            PSDELogicNode psDELogicNode = (PSDELogicNode)((Object)psDEDataFlowNodeMap.get(psDELogicLink.getSRCPSDELOGICNODEID()));
            if (psDELogicNode != null) {
                psDELogicNode.getPSDELogicLinks(true).add(psDELogicLink);
                continue;
            }
            log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u6d41[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8282\u70b9[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicLink.getSRCPSDELOGICNODEID()));
        }
        Vector<PSDELogicNodeParam> psDELogicNodeParamList = this.getPSDELogicNodeParamDatas();
        for (PSDELogicNodeParam psDELogicNodeParam : psDELogicNodeParamList) {
            PSDELogicNode psDELogicNode = (PSDELogicNode)((Object)psDEDataFlowNodeMap.get(psDELogicNodeParam.getPSDELOGICNODEID()));
            if (psDELogicNode != null) {
                psDELogicNode.getPSDELogicNodeParams(true).add(psDELogicNodeParam);
                continue;
            }
            log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u6d41[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8282\u70b9[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicNodeParam.getPSDELOGICNODEID()));
        }
        Vector<PSDELogicLinkCond> psDELogicLinkCondList = this.getPSDELogicLinkCondDatas();
        HashMap<String, PSDELogicLinkCond> psDELogicLinkCondMap = new HashMap<String, PSDELogicLinkCond>();
        for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
            psDELogicLinkCondMap.put(psDELogicLinkCond.getPSDELLCONDID(), psDELogicLinkCond);
        }
        for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
            if (StringHelper.isNullOrEmpty((String)psDELogicLinkCond.getPPSDELLCONDID())) continue;
            PSDELogicLinkCond parentPSDELogicLinkCond = (PSDELogicLinkCond)((Object)psDELogicLinkCondMap.get(psDELogicLinkCond.getPPSDELLCONDID()));
            parentPSDELogicLinkCond.getChildPSDELogicLinkConds(true).add(psDELogicLinkCond);
        }
        for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
            if (!StringHelper.isNullOrEmpty((String)psDELogicLinkCond.getPPSDELLCONDID())) continue;
            PSDELogicLink psDELogicLink = (PSDELogicLink)((Object)psDELogicLinkMap.get(psDELogicLinkCond.getPSDELOGICLINKID()));
            if (psDELogicLink != null) {
                psDELogicLink.getPSDELogicLinkConds(true).add(psDELogicLinkCond);
                continue;
            }
            log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u6d41[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8fde\u63a5[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicLinkCond.getPSDELOGICLINKID()));
        }
        ArrayList<IPSDEDataFlowNode> list = new ArrayList<IPSDEDataFlowNode>();
        for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
            IPSDELogicNodeType iPSDELogicNodeType = this.getPSModelStorage().getPSDELogicNodeType(psDELogicNode.getLOGICNODETYPE());
            IPSDEDataFlowNode iPSDELogicNode = iPSDELogicNodeType.createPSDEDataFlowNode(psDELogicNode);
            iPSDELogicNode.init(this.getDAGlobalHelper(), this, psDELogicNode);
            list.add(iPSDELogicNode);
        }
        PSDEDataFlowImpl.sortPSDEDataFlowNodeList(list);
        for (IPSDEDataFlowNode iPSDEDataFlowNode : list) {
            this.psDEDataFlowNodeMap.put(iPSDEDataFlowNode.getId(), iPSDEDataFlowNode);
            Iterator<? extends IPSDEDataFlowLink> psDELogicLinks = iPSDEDataFlowNode.getPSDEDataFlowLinks();
            if (psDELogicLinks == null) continue;
            while (psDELogicLinks.hasNext()) {
                this.psDEDataFlowLinkList.add(psDELogicLinks.next());
            }
        }
    }

    protected Vector<PSDELogicNode> getPSDELogicNodeDatas() throws Exception {
        Vector<PSDELogicNode> psDELogicNodeList = new Vector<PSDELogicNode>();
        CallResult callResult = this.getPSModelHelper().getPSDELogicNodes(this.getId(), psDELogicNodeList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u8282\u70b9\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return psDELogicNodeList;
    }

    protected Vector<PSDELogicLink> getPSDELogicLinkDatas() throws Exception {
        Vector<PSDELogicLink> psDEDataFlowLinkList = new Vector<PSDELogicLink>();
        CallResult callResult = this.getPSModelHelper().getPSDELogicLinks(this.getId(), psDEDataFlowLinkList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u8fde\u63a5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataFlowLinkList;
    }

    protected Vector<PSDELogicNodeParam> getPSDELogicNodeParamDatas() throws Exception {
        Vector<PSDELogicNodeParam> psDELogicNodeParamList = new Vector<PSDELogicNodeParam>();
        CallResult callResult = this.getPSModelHelper().getPSDELogicNodeParams(this.getId(), psDELogicNodeParamList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u8282\u70b9\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return psDELogicNodeParamList;
    }

    protected Vector<PSDELogicLinkCond> getPSDELogicLinkCondDatas() throws Exception {
        Vector<PSDELogicLinkCond> psDELogicLinkCondList = new Vector<PSDELogicLinkCond>();
        CallResult callResult = this.getPSModelHelper().getPSDELogicLinkConds(this.getId(), psDELogicLinkCondList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u8fde\u63a5\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return psDELogicLinkCondList;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u5904\u7406\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<IPSDEDataFlowNode> getPSDEDataFlowNodes() {
        return this.psDEDataFlowNodeMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    public IPSDEDataFlowNode getPSDEDataFlowNode(String strPSDELogicNodeId) throws Exception {
        IPSDEDataFlowNode iPSDELogicNode = this.psDEDataFlowNodeMap.get(strPSDELogicNodeId);
        if (iPSDELogicNode != null) {
            return iPSDELogicNode;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8282\u70b9[%1$s]", (Object)strPSDELogicNodeId));
    }

    @PSModelRTMeta(description="\u903b\u8f91\u8fde\u63a5\u96c6\u5408", child=true, group="\u903b\u8f91", order=220)
    public Iterator<IPSDEDataFlowLink> getPSDEDataFlowLinks() {
        return this.psDEDataFlowLinkList.iterator();
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    public String getModelType() {
        return "PSDEDATAFLOW";
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.getPSDataEntity().getPSSystem();
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, ignorepf=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u8bd5\u6a21\u5f0f", codelist="DELogicDebugMode", ignoredumpvalues="0", fields={"DEBUGMODE"})
    public int getDebugMode() {
        return this.nDebugMode;
    }

    public static void sortPSDEDataFlowNodeList(List<IPSDEDataFlowNode> list) {
        Collections.sort(list, new Comparator<Object>(){

            @Override
            public int compare(Object o1, Object o2) {
                int nRet = 0;
                IPSDEDataFlowNode i1 = (IPSDEDataFlowNode)o1;
                IPSDEDataFlowNode i2 = (IPSDEDataFlowNode)o2;
                if (i1.getTopPos() >= 0 && i2.getTopPos() >= 0 && (nRet = new Integer(i1.getTopPos()).compareTo(i2.getTopPos())) != 0) {
                    return nRet;
                }
                if (i1.getLeftPos() >= 0 && i2.getLeftPos() >= 0 && (nRet = new Integer(i1.getLeftPos()).compareTo(i2.getLeftPos())) != 0) {
                    return nRet;
                }
                nRet = StringHelper.compare((String)i1.getCodeName(), (String)i2.getCodeName(), (boolean)false);
                if (nRet != 0) {
                    return nRet;
                }
                nRet = StringHelper.compare((String)i1.getName(), (String)i2.getName(), (boolean)false);
                return nRet;
            }
        });
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u5b50\u7c7b\u578b", codelist="DEDataFlowSubType", ignoredumpvalues="NONE", group="\u57fa\u672c", fields={"LOGICSUBTYPE"})
    public String getLogicSubType() {
        return this.psDELogic.getLOGICSUBTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u6d41\u903b\u8f91\u5305\u6a21\u578b", fields={"CUSTOMCODE"})
    public String getPackageModel() {
        return this.psDELogic.getCUSTOMCODE();
    }
}

