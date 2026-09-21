/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLink
 *  net.ibizsys.model.dataentity.logic.IPSDELogicNode
 *  net.ibizsys.model.dataentity.logic.IPSDELogicParam
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.logic.IPSDELogicLink;
import net.ibizsys.model.dataentity.logic.IPSDELogicNode;
import net.ibizsys.model.dataentity.logic.IPSDELogicNodeRuntime;
import net.ibizsys.model.dataentity.logic.IPSDELogicNodeType;
import net.ibizsys.model.dataentity.logic.IPSDELogicParam;
import net.ibizsys.model.dataentity.logic.PSDELogicParamImpl;
import net.ibizsys.model.entity.PSDELogic;
import net.ibizsys.model.entity.PSDELogicLink;
import net.ibizsys.model.entity.PSDELogicLinkCond;
import net.ibizsys.model.entity.PSDELogicNode;
import net.ibizsys.model.entity.PSDELogicNodeParam;
import net.ibizsys.model.entity.PSDELogicParam;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicImpl
extends PSDataEntityObjectImpl
implements IPSDELogic {
    private static final Log log = LogFactory.getLog(PSDELogicImpl.class);
    protected PSDELogic psDELogic;
    protected HashMap<String, IPSDELogicNode> psDELogicNodeMap = new HashMap();
    protected ArrayList<IPSDELogicLink> psDELogicLinkList = new ArrayList();
    protected HashMap<String, IPSDELogicParam> psDELogicParamMap = new HashMap();
    private String strCodeName = "";
    private IPSDELogicNode startPSDELogicNode = null;
    private String strDefaultParamName = "DEFAULT";
    private String strLogicType = "";
    private int nExtendMode = 0;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, PSDELogic psDELogic) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDataEntity(iPSDataEntity);
            this.psDELogic = psDELogic;
            this.setId(this.psDELogic.getPSDELOGICID());
            this.setName(this.psDELogic.getPSDELOGICNAME());
            this.setPSObjectData(this.psDELogic);
            this.strCodeName = this.psDELogic.getCODENAME();
            if (!this.psDELogic.isEXTENDMODENull()) {
                this.nExtendMode = this.psDELogic.getEXTENDMODE();
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!StringHelper.isNullOrEmpty((String)PSDELogicImpl.this.getModelType()) && !StringHelper.isNullOrEmpty((String)PSDELogicImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSDELogicImpl.this.getModelType(), (Object)PSDELogicImpl.this.getId())) {
                            throw new Exception(StringHelper.format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        PSDELogicImpl.this.onInit();
                        ActionSessionManager.getCurrentSession().unregisterRecursion(PSDELogicImpl.this.getModelType(), (Object)PSDELogicImpl.this.getId());
                    }
                }
            });
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.psDELogic.getPSDELOGICNAME();
    }

    @PSModelRTMeta(description="\u5f00\u59cb\u5904\u7406\u8282\u70b9")
    public IPSDELogicNode getStartPSDELogicNode() {
        return this.startPSDELogicNode;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDELogicNodes();
    }

    protected void onPreparePSDELogicNodes() throws Exception {
        this.psDELogicParamMap.clear();
        Vector<PSDELogicParam> psDELogicParamList = new Vector<PSDELogicParam>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDELogicParams(this.getId(), psDELogicParamList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDELogicParam psDELogicParam : psDELogicParamList) {
            PSDELogicParamImpl iPSDELogicParam = new PSDELogicParamImpl();
            iPSDELogicParam.init(this.getPSModelStorageContext(), this, psDELogicParam);
            this.psDELogicParamMap.put(iPSDELogicParam.getId(), iPSDELogicParam);
            if (!iPSDELogicParam.isDefault()) continue;
            this.strDefaultParamName = iPSDELogicParam.getCodeName();
        }
        this.psDELogicNodeMap.clear();
        Vector<PSDELogicNode> psDELogicNodeList = new Vector<PSDELogicNode>();
        callResult = this.getPSModelQueryHelper().getPSDELogicNodes(this.getId(), psDELogicNodeList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u8282\u70b9\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDELogicNode> psDELogicNodeMap = new HashMap<String, PSDELogicNode>();
        for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
            psDELogicNodeMap.put(psDELogicNode.getPSDELOGICNODEID(), psDELogicNode);
        }
        this.psDELogicLinkList.clear();
        Vector<PSDELogicLink> psDELogicLinkList = new Vector<PSDELogicLink>();
        callResult = this.getPSModelQueryHelper().getPSDELogicLinks(this.getId(), psDELogicLinkList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u8fde\u63a5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDELogicLink> psDELogicLinkMap = new HashMap<String, PSDELogicLink>();
        for (PSDELogicLink psDELogicLink : psDELogicLinkList) {
            psDELogicLinkMap.put(psDELogicLink.getPSDELOGICLINKID(), psDELogicLink);
            PSDELogicNode psDELogicNode = (PSDELogicNode)((Object)psDELogicNodeMap.get(psDELogicLink.getSRCPSDELOGICNODEID()));
            if (psDELogicNode != null) {
                psDELogicNode.getPSDELogicLinks(true).add(psDELogicLink);
                continue;
            }
            log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5904\u7406\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8282\u70b9[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicLink.getSRCPSDELOGICNODEID()));
        }
        Vector<PSDELogicNodeParam> psDELogicNodeParamList = new Vector<PSDELogicNodeParam>();
        callResult = this.getPSModelQueryHelper().getPSDELogicNodeParams(this.getId(), psDELogicNodeParamList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u8282\u70b9\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDELogicNodeParam psDELogicNodeParam : psDELogicNodeParamList) {
            PSDELogicNode psDELogicNode = (PSDELogicNode)((Object)psDELogicNodeMap.get(psDELogicNodeParam.getPSDELOGICNODEID()));
            if (psDELogicNode != null) {
                psDELogicNode.getPSDELogicNodeParams(true).add(psDELogicNodeParam);
                continue;
            }
            log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5904\u7406\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8282\u70b9[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicNodeParam.getPSDELOGICNODEID()));
        }
        Vector<PSDELogicLinkCond> psDELogicLinkCondList = new Vector<PSDELogicLinkCond>();
        callResult = this.getPSModelQueryHelper().getPSDELogicLinkConds(this.getId(), psDELogicLinkCondList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u8fde\u63a5\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
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
            log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5904\u7406\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8fde\u63a5[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicLinkCond.getPSDELOGICLINKID()));
        }
        for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
            Iterator psDELogicLinks;
            IPSDELogicNodeType iPSDELogicNodeType = this.getPSModelStorageContext().getPSDELogicNodeType(psDELogicNode.getLOGICNODETYPE());
            IPSDELogicNode iPSDELogicNode = iPSDELogicNodeType.createPSDELogicNode(psDELogicNode);
            ((IPSDELogicNodeRuntime)iPSDELogicNode).init(this.getPSModelStorageContext(), this, psDELogicNode);
            this.psDELogicNodeMap.put(iPSDELogicNode.getId(), iPSDELogicNode);
            if (StringHelper.compare((String)iPSDELogicNode.getLogicNodeType(), (String)"BEGIN", (boolean)true) == 0) {
                this.startPSDELogicNode = iPSDELogicNode;
            }
            if ((psDELogicLinks = iPSDELogicNode.getPSDELogicLinks()) == null) continue;
            while (psDELogicLinks.hasNext()) {
                this.psDELogicLinkList.add((IPSDELogicLink)psDELogicLinks.next());
            }
        }
    }

    @PSModelRTMeta(description="\u903b\u8f91\u5904\u7406\u8282\u70b9\u96c6\u5408")
    public Iterator<IPSDELogicNode> getPSDELogicNodes() {
        return this.psDELogicNodeMap.values().iterator();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u5904\u7406\u53c2\u6570\u96c6\u5408")
    public Iterator<IPSDELogicParam> getPSDELogicParams() {
        if (this.psDELogicParamMap == null || this.psDELogicParamMap.size() == 0) {
            return null;
        }
        return this.psDELogicParamMap.values().iterator();
    }

    public IPSDELogicParam getPSDELogicParam(String strPSDELogicParamId) throws Exception {
        IPSDELogicParam iPSDELogicParam = this.psDELogicParamMap.get(strPSDELogicParamId);
        if (iPSDELogicParam != null) {
            return iPSDELogicParam;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53c2\u6570[%1$s]", (Object)strPSDELogicParamId));
    }

    public IPSDELogicNode getPSDELogicNode(String strPSDELogicNodeId) throws Exception {
        IPSDELogicNode iPSDELogicNode = this.psDELogicNodeMap.get(strPSDELogicNodeId);
        if (iPSDELogicNode != null) {
            return iPSDELogicNode;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8282\u70b9[%1$s]", (Object)strPSDELogicNodeId));
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u53c2\u6570\u540d\u79f0")
    public String getDefaultParamName() {
        return this.strDefaultParamName;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u5904\u7406\u8fde\u63a5\u96c6\u5408")
    public Iterator<IPSDELogicLink> getPSDELogicLinks() {
        return this.psDELogicLinkList.iterator();
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    public String getLogicType() {
        return this.strLogicType;
    }

    public void init(IDataEntity iDataEntity) throws Exception {
    }
}

