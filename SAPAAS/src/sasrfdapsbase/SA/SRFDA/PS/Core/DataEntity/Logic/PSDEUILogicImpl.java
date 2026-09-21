/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEViewLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicParamImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.PS.Data.PSDELogicParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUILogicImpl
extends PSDataEntityObjectImpl
implements IPSDEUILogic,
IPSAppDEUILogic,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEUILogicImpl.class);
    protected PSDELogic psDELogic;
    protected Map<String, IPSDEUILogicNode> psDEUILogicNodeMap = new LinkedHashMap<String, IPSDEUILogicNode>();
    protected ArrayList<IPSDEUILogicLink> psDEUILogicLinkList = new ArrayList();
    protected Map<String, IPSDEUILogicParam> psDEUILogicParamMap = new LinkedHashMap<String, IPSDEUILogicParam>();
    private String strCodeName = "";
    private IPSDEUILogicNode startPSDEUILogicNode = null;
    private String strDefaultParamName = "DEFAULT";
    private String strLogicType = "";
    private IPSAppDataEntity iPSAppDataEntity = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, PSDELogic psDELogic) throws Exception {
        this.iPSAppDataEntity = iPSAppDataEntity;
        this.init(iDAGlobalHelper, this.iPSAppDataEntity.getPSDataEntity(), psDELogic);
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDELogic psDELogic) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDELogic = psDELogic;
            this.setId(this.psDELogic.getPSDELOGICID());
            this.setName(this.psDELogic.getPSDELOGICNAME());
            this.setPSObjectData(this.psDELogic);
            this.strCodeName = this.psDELogic.getCODENAME();
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSDEUILogicImpl.this.getModelType()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSDEUILogicImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSDEUILogicImpl.this.getModelType(), (Object)PSDEUILogicImpl.this.getId())) {
                            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        try {
                            PSDEUILogicImpl.this.onInit();
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEUILogicImpl.this.getModelType(), (Object)PSDEUILogicImpl.this.getId());
                        }
                        catch (Exception ex) {
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEUILogicImpl.this.getModelType(), (Object)PSDEUILogicImpl.this.getId());
                            throw ex;
                        }
                    } else {
                        PSDEUILogicImpl.this.onInit();
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
        Iterator<IPSDEUILogicNode> psDEUILogicNodes = this.getPSDEUILogicNodes();
        if (psDEUILogicNodes != null) {
            while (psDEUILogicNodes.hasNext()) {
                IPSDEUILogicNode iPSDEUILogicNode = psDEUILogicNodes.next();
                try {
                    iPSDEUILogicNode.check();
                }
                catch (Exception ex) {
                    throw new Exception(String.format("\u68c0\u67e5\u903b\u8f91\u8282\u70b9[%1$s]\u5931\u8d25\uff0c%2$s", iPSDEUILogicNode.getName(), ex.getMessage()), ex);
                }
            }
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"PSDELOGICNAME"})
    public String getLogicName() {
        return this.psDELogic.getPSDELOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u5904\u7406\u8282\u70b9", dumpref=true, from="__self__")
    public IPSDEUILogicNode getStartPSDEUILogicNode() {
        return this.startPSDEUILogicNode;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDELogicNodes();
    }

    protected void onPreparePSDELogicNodes() throws Exception {
        this.psDEUILogicParamMap.clear();
        Vector<PSDELogicParam> psDELogicParamList = new Vector<PSDELogicParam>();
        CallResult callResult = this.getPSModelHelper().getPSDELogicParams(this.getId(), psDELogicParamList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u903b\u8f91\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDELogicParam psDELogicParam : psDELogicParamList) {
            PSDEUILogicParamImpl iPSDELogicParam = new PSDEUILogicParamImpl();
            iPSDELogicParam.init(this.getDAGlobalHelper(), this, psDELogicParam);
            this.psDEUILogicParamMap.put(iPSDELogicParam.getId(), iPSDELogicParam);
            if (!iPSDELogicParam.isDefault()) continue;
            this.strDefaultParamName = iPSDELogicParam.getCodeName();
        }
        this.psDEUILogicNodeMap.clear();
        Vector<PSDELogicNode> psDELogicNodeList = new Vector<PSDELogicNode>();
        callResult = this.getPSModelHelper().getPSDELogicNodes(this.getId(), psDELogicNodeList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u903b\u8f91\u8282\u70b9\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDELogicNode> psDELogicNodeMap = new HashMap<String, PSDELogicNode>();
        for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
            psDELogicNodeMap.put(psDELogicNode.getPSDELOGICNODEID(), psDELogicNode);
        }
        this.psDEUILogicLinkList.clear();
        Vector<PSDELogicLink> psDELogicLinkList = new Vector<PSDELogicLink>();
        callResult = this.getPSModelHelper().getPSDELogicLinks(this.getId(), psDELogicLinkList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u903b\u8f91\u8fde\u63a5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDELogicLink> psDELogicLinkMap = new HashMap<String, PSDELogicLink>();
        for (PSDELogicLink psDELogicLink : psDELogicLinkList) {
            psDELogicLinkMap.put(psDELogicLink.getPSDELOGICLINKID(), psDELogicLink);
            PSDELogicNode psDELogicNode = (PSDELogicNode)((Object)psDELogicNodeMap.get(psDELogicLink.getSRCPSDELOGICNODEID()));
            if (psDELogicNode != null) {
                psDELogicNode.getPSDELogicLinks(true).add(psDELogicLink);
                continue;
            }
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5904\u7406\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8282\u70b9[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicLink.getSRCPSDELOGICNODEID()));
        }
        Vector<PSDELogicNodeParam> psDELogicNodeParamList = new Vector<PSDELogicNodeParam>();
        callResult = this.getPSModelHelper().getPSDELogicNodeParams(this.getId(), psDELogicNodeParamList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u903b\u8f91\u8282\u70b9\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDELogicNodeParam psDELogicNodeParam : psDELogicNodeParamList) {
            PSDELogicNode psDELogicNode = (PSDELogicNode)((Object)psDELogicNodeMap.get(psDELogicNodeParam.getPSDELOGICNODEID()));
            if (psDELogicNode != null) {
                psDELogicNode.getPSDELogicNodeParams(true).add(psDELogicNodeParam);
                continue;
            }
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5904\u7406\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8282\u70b9[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicNodeParam.getPSDELOGICNODEID()));
        }
        Vector<PSDELogicLinkCond> psDELogicLinkCondList = new Vector<PSDELogicLinkCond>();
        callResult = this.getPSModelHelper().getPSDELogicLinkConds(this.getId(), psDELogicLinkCondList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u903b\u8f91\u8fde\u63a5\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDELogicLinkCond> psDELogicLinkCondMap = new HashMap<String, PSDELogicLinkCond>();
        for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
            psDELogicLinkCondMap.put(psDELogicLinkCond.getPSDELLCONDID(), psDELogicLinkCond);
        }
        for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDELogicLinkCond.getPPSDELLCONDID())) continue;
            PSDELogicLinkCond parentPSDELogicLinkCond = (PSDELogicLinkCond)((Object)psDELogicLinkCondMap.get(psDELogicLinkCond.getPPSDELLCONDID()));
            parentPSDELogicLinkCond.getChildPSDELogicLinkConds(true).add(psDELogicLinkCond);
        }
        for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDELogicLinkCond.getPPSDELLCONDID())) continue;
            PSDELogicLink psDELogicLink = (PSDELogicLink)((Object)psDELogicLinkMap.get(psDELogicLinkCond.getPSDELOGICLINKID()));
            if (psDELogicLink != null) {
                psDELogicLink.getPSDELogicLinkConds(true).add(psDELogicLinkCond);
                continue;
            }
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5904\u7406\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8fde\u63a5[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicLinkCond.getPSDELOGICLINKID()));
        }
        ArrayList<IPSDEUILogicNode> list = new ArrayList<IPSDEUILogicNode>();
        for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
            IPSDELogicNodeType iPSDELogicNodeType = this.getPSModelStorage().getPSDELogicNodeType(psDELogicNode.getLOGICNODETYPE());
            IPSDEUILogicNode iPSDEUILogicNode = iPSDELogicNodeType.createPSDEUILogicNode(psDELogicNode);
            iPSDEUILogicNode.init(this.getDAGlobalHelper(), this, psDELogicNode);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEUILogicNode.getLogicNodeType(), (String)"BEGIN", (boolean)true) == 0) {
                this.startPSDEUILogicNode = iPSDEUILogicNode;
                list.add(0, iPSDEUILogicNode);
                continue;
            }
            list.add(iPSDEUILogicNode);
        }
        for (IPSDEUILogicNode iPSDEUILogicNode : list) {
            this.psDEUILogicNodeMap.put(iPSDEUILogicNode.getId(), iPSDEUILogicNode);
            Iterator<IPSDEUILogicLink> psDEUILogicLinks = iPSDEUILogicNode.getPSDEUILogicLinks();
            if (psDEUILogicLinks == null) continue;
            while (psDEUILogicLinks.hasNext()) {
                this.psDEUILogicLinkList.add(psDEUILogicLinks.next());
            }
        }
    }

    @PSModelRTMeta(description="\u903b\u8f91\u5904\u7406\u8282\u70b9\u96c6\u5408", child=true, group="\u903b\u8f91", order=217)
    public Iterator<IPSDEUILogicNode> getPSDEUILogicNodes() {
        return this.psDEUILogicNodeMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u5904\u7406\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<IPSDEUILogicParam> getPSDEUILogicParams() {
        if (this.psDEUILogicParamMap == null || this.psDEUILogicParamMap.size() == 0) {
            return null;
        }
        return this.psDEUILogicParamMap.values().iterator();
    }

    @Override
    public IPSDEUILogicParam getPSDEUILogicParam(String strPSDEUILogicParamId) throws Exception {
        IPSDEUILogicParam iPSDEUILogicParam = this.psDEUILogicParamMap.get(strPSDEUILogicParamId);
        if (iPSDEUILogicParam != null) {
            return iPSDEUILogicParam;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53c2\u6570[%1$s]", (Object)strPSDEUILogicParamId));
    }

    @Override
    public IPSDEUILogicNode getPSDEUILogicNode(String strPSDEUILogicNodeId) throws Exception {
        IPSDEUILogicNode iPSDEUILogicNode = this.psDEUILogicNodeMap.get(strPSDEUILogicNodeId);
        if (iPSDEUILogicNode != null) {
            return iPSDEUILogicNode;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8282\u70b9[%1$s]", (Object)strPSDEUILogicNodeId));
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53c2\u6570\u540d\u79f0")
    public String getDefaultParamName() {
        return this.strDefaultParamName;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u5904\u7406\u8fde\u63a5\u96c6\u5408", group="\u903b\u8f91", order=219)
    public Iterator<IPSDEUILogicLink> getPSDEUILogicLinks() {
        return this.psDEUILogicLinkList.iterator();
    }

    @Override
    public String getLogicType() {
        return this.strLogicType;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDEUILOGIC";
        }
        return "PSDEUILOGIC";
    }

    @Override
    public String getModelName(String strModelType) {
        return super.getModelName(strModelType);
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strModelType, (String)"PSDELOGIC_VIEWLOGIC", (boolean)false) == 0) {
            return IPSDEViewLogic.class;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strModelType, (String)"PSDELOGIC", (boolean)false) == 0) {
            return IPSDELogic.class;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strModelType, (String)"PSAPPDELOGIC", (boolean)false) == 0) {
            return IPSAppDELogic.class;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strModelType, (String)"PSAPPDEUILOGIC", (boolean)false) == 0) {
            return IPSAppDEUILogic.class;
        }
        return super.getModelClass(strModelType);
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    public int getLogicHolder() {
        return 2;
    }

    @Override
    public IPSApplication getPSApplication() {
        if (this.getPSAppDataEntity() == null) {
            return null;
        }
        return this.getPSAppDataEntity().getPSApplication();
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.getPSDataEntity().getPSSystem();
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }
}

