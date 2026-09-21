/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEViewLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicParamImpl;
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
import SA.SRFDA.PS.Data.PSDELogicParam;
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
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicImpl
extends PSDataEntityObjectImpl
implements IPSDELogic,
IPSAppDELogic,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDELogicImpl.class);
    protected PSDELogic psDELogic;
    protected Map<String, IPSDELogicNode> psDELogicNodeMap = new LinkedHashMap<String, IPSDELogicNode>();
    protected ArrayList<IPSDELogicLink> psDELogicLinkList = new ArrayList();
    protected Map<String, IPSDELogicParam> psDELogicParamMap = new LinkedHashMap<String, IPSDELogicParam>();
    private String strCodeName = "";
    private IPSDELogicNode startPSDELogicNode = null;
    private String strDefaultParamName = "DEFAULT";
    private String strLogicType = "";
    private String strLogicSubType = "NONE";
    private int nExtendMode = 0;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private int nLogicHolder = 3;
    private boolean bCustomCode = false;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private int nDebugMode = 0;
    private IPSDELogicParam defaultPSDELogicParam = null;

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
            if (!this.psDELogic.isEXTENDMODENull()) {
                this.nExtendMode = this.psDELogic.getEXTENDMODE();
            }
            this.nLogicHolder = !this.psDELogic.isLOGICHOLDERNull() ? this.psDELogic.getLOGICHOLDER() : this.getPSDataEntity().getDEHolder();
            if (!StringHelper.isNullOrEmpty((String)this.psDELogic.getLOGICSUBTYPE())) {
                this.strLogicSubType = this.psDELogic.getLOGICSUBTYPE();
            }
            if (!this.psDELogic.isCUSTOMMODENull()) {
                this.bCustomCode = this.psDELogic.getCUSTOMMODE();
            }
            if (!this.psDELogic.isDEBUGMODENull()) {
                this.nDebugMode = this.psDELogic.getDEBUGMODE();
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!StringHelper.isNullOrEmpty((String)PSDELogicImpl.this.getModelType()) && !StringHelper.isNullOrEmpty((String)PSDELogicImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSDELogicImpl.this.getModelType(), (Object)PSDELogicImpl.this.getId())) {
                            throw new Exception(StringHelper.format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        try {
                            PSDELogicImpl.this.onInit();
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDELogicImpl.this.getModelType(), (Object)PSDELogicImpl.this.getId());
                        }
                        catch (Exception ex) {
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDELogicImpl.this.getModelType(), (Object)PSDELogicImpl.this.getId());
                            throw ex;
                        }
                    } else {
                        PSDELogicImpl.this.onInit();
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
        Iterator<IPSDELogicLink> psDELogicLinks;
        Iterator<IPSDELogicNode> psDELogicNodes;
        int nRet = 0;
        Iterator<IPSDELogicParam> psDELogicParams = this.getPSDELogicParams();
        if (psDELogicParams != null) {
            while (psDELogicParams.hasNext()) {
                IPSDELogicParam iPSDELogicParam = psDELogicParams.next();
                nRet += iPSDELogicParam.check();
            }
        }
        if ((psDELogicNodes = this.getPSDELogicNodes()) != null) {
            while (psDELogicNodes.hasNext()) {
                IPSDELogicNode iPSDELogicNode = psDELogicNodes.next();
                nRet += iPSDELogicNode.check();
            }
        }
        if ((psDELogicLinks = this.getPSDELogicLinks()) != null) {
            while (psDELogicLinks.hasNext()) {
                IPSDELogicLink iPSDELogicLink = psDELogicLinks.next();
                nRet += iPSDELogicLink.check();
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
    @PSModelRTMeta(description="\u5f00\u59cb\u5904\u7406\u8282\u70b9", dumpref=true, from="__self__")
    public IPSDELogicNode getStartPSDELogicNode() {
        return this.startPSDELogicNode;
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
        if (!this.isCustomCode()) {
            this.onPreparePSDELogicNodes();
        }
    }

    protected void onPreparePSDELogicNodes() throws Exception {
        this.psDELogicParamMap.clear();
        Vector<PSDELogicParam> psDELogicParamList = this.getPSDELogicParamDatas();
        for (PSDELogicParam psDELogicParam : psDELogicParamList) {
            PSDELogicParamImpl iPSDELogicParam = new PSDELogicParamImpl();
            iPSDELogicParam.init(this.getDAGlobalHelper(), this, psDELogicParam);
            this.psDELogicParamMap.put(iPSDELogicParam.getId(), iPSDELogicParam);
            if (!iPSDELogicParam.isDefault()) continue;
            if (this.defaultPSDELogicParam != null) {
                throw new Exception(String.format("\u5b58\u5728\u591a\u4e2a\u9ed8\u8ba4\u903b\u8f91\u53c2\u6570", new Object[0]));
            }
            this.strDefaultParamName = iPSDELogicParam.getCodeName();
            this.defaultPSDELogicParam = iPSDELogicParam;
        }
        PSDELogicImpl.sortPSDELogicParamMap(this.psDELogicParamMap);
        this.psDELogicNodeMap.clear();
        Vector<PSDELogicNode> psDELogicNodeList = this.getPSDELogicNodeDatas();
        HashMap<String, PSDELogicNode> psDELogicNodeMap = new HashMap<String, PSDELogicNode>();
        for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
            psDELogicNodeMap.put(psDELogicNode.getPSDELOGICNODEID(), psDELogicNode);
        }
        this.psDELogicLinkList.clear();
        Vector<PSDELogicLink> psDELogicLinkList = this.getPSDELogicLinkDatas();
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
        Vector<PSDELogicNodeParam> psDELogicNodeParamList = this.getPSDELogicNodeParamDatas();
        for (PSDELogicNodeParam psDELogicNodeParam : psDELogicNodeParamList) {
            PSDELogicNode psDELogicNode = (PSDELogicNode)((Object)psDELogicNodeMap.get(psDELogicNodeParam.getPSDELOGICNODEID()));
            if (psDELogicNode != null) {
                psDELogicNode.getPSDELogicNodeParams(true).add(psDELogicNodeParam);
                continue;
            }
            log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5904\u7406\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8282\u70b9[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicNodeParam.getPSDELOGICNODEID()));
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
            log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5904\u7406\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8fde\u63a5[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicLinkCond.getPSDELOGICLINKID()));
        }
        ArrayList<IPSDELogicNode> list = new ArrayList<IPSDELogicNode>();
        for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
            IPSDELogicNodeType iPSDELogicNodeType = this.getPSModelStorage().getPSDELogicNodeType(psDELogicNode.getLOGICNODETYPE());
            IPSDELogicNode iPSDELogicNode = iPSDELogicNodeType.createPSDELogicNode(psDELogicNode);
            iPSDELogicNode.init(this.getDAGlobalHelper(), this, psDELogicNode);
            if (StringHelper.compare((String)iPSDELogicNode.getLogicNodeType(), (String)"BEGIN", (boolean)true) == 0) {
                this.startPSDELogicNode = iPSDELogicNode;
                list.add(0, iPSDELogicNode);
                continue;
            }
            list.add(iPSDELogicNode);
        }
        PSDELogicImpl.sortPSDELogicNodeList(list);
        if (this.startPSDELogicNode != null) {
            list.remove(this.startPSDELogicNode);
            list.add(0, this.startPSDELogicNode);
        }
        for (IPSDELogicNode iPSDELogicNode : list) {
            this.psDELogicNodeMap.put(iPSDELogicNode.getId(), iPSDELogicNode);
            Iterator<IPSDELogicLink> psDELogicLinks = iPSDELogicNode.getPSDELogicLinks();
            if (psDELogicLinks == null) continue;
            while (psDELogicLinks.hasNext()) {
                this.psDELogicLinkList.add(psDELogicLinks.next());
            }
        }
    }

    protected Vector<PSDELogicParam> getPSDELogicParamDatas() throws Exception {
        Vector<PSDELogicParam> psDELogicParamList = new Vector<PSDELogicParam>();
        CallResult callResult = this.getPSModelHelper().getPSDELogicParams(this.getId(), psDELogicParamList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return psDELogicParamList;
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
        Vector<PSDELogicLink> psDELogicLinkList = new Vector<PSDELogicLink>();
        CallResult callResult = this.getPSModelHelper().getPSDELogicLinks(this.getId(), psDELogicLinkList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u8fde\u63a5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return psDELogicLinkList;
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
    public Iterator<IPSDELogicNode> getPSDELogicNodes() {
        return this.psDELogicNodeMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=213)
    public Iterator<IPSDELogicParam> getPSDELogicParams() {
        if (this.psDELogicParamMap == null || this.psDELogicParamMap.size() == 0) {
            return null;
        }
        return this.psDELogicParamMap.values().iterator();
    }

    @Override
    public IPSDELogicParam getPSDELogicParam(String strPSDELogicParamId) throws Exception {
        IPSDELogicParam iPSDELogicParam = this.psDELogicParamMap.get(strPSDELogicParamId);
        if (iPSDELogicParam != null) {
            return iPSDELogicParam;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53c2\u6570[%1$s]", (Object)strPSDELogicParamId));
    }

    @Override
    public IPSDELogicNode getPSDELogicNode(String strPSDELogicNodeId) throws Exception {
        IPSDELogicNode iPSDELogicNode = this.psDELogicNodeMap.get(strPSDELogicNodeId);
        if (iPSDELogicNode != null) {
            return iPSDELogicNode;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8282\u70b9[%1$s]", (Object)strPSDELogicNodeId));
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53c2\u6570\u540d\u79f0")
    public String getDefaultParamName() {
        return this.strDefaultParamName;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u8fde\u63a5\u96c6\u5408", group="\u903b\u8f91", order=220)
    public Iterator<IPSDELogicLink> getPSDELogicLinks() {
        return this.psDELogicLinkList.iterator();
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    public String getLogicType() {
        return this.strLogicType;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDELOGIC";
        }
        return "PSDELOGIC";
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getModelName(String strModelType) {
        return super.getModelName(strModelType);
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        if (StringHelper.compare((String)strModelType, (String)"PSDELOGIC_VIEWLOGIC", (boolean)false) == 0) {
            return IPSDEViewLogic.class;
        }
        if (StringHelper.compare((String)strModelType, (String)"PSDELOGIC", (boolean)false) == 0) {
            return IPSDELogic.class;
        }
        if (StringHelper.compare((String)strModelType, (String)"PSAPPDELOGIC", (boolean)false) == 0) {
            return IPSAppDELogic.class;
        }
        if (StringHelper.compare((String)strModelType, (String)"PSAPPDEUILOGIC", (boolean)false) == 0) {
            return IPSAppDEUILogic.class;
        }
        return super.getModelClass(strModelType);
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6301\u6709\u8005", codelist="DELogicHolder", dump=false)
    public int getLogicHolder() {
        return this.nLogicHolder;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c")
    public boolean isEnableBackend() {
        return (this.getLogicHolder() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c")
    public boolean isEnableFront() {
        return (this.getLogicHolder() & 2) == 2;
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
    @PSModelRTMeta(description="\u903b\u8f91\u5b50\u7c7b", codelist="DELogicSubType", ignoredumpvalues="NONE", group="\u57fa\u672c", order=125, fields={"LOGICSUBTYPE"})
    public String getLogicSubType() {
        return this.strLogicSubType;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u811a\u672c\u4ee3\u7801", ignoredumpvalues="false", fields={"CUSTOMMODE"})
    public boolean isCustomCode() {
        return this.bCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.psDELogic.getCUSTOMCODE();
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

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u903b\u8f91\u53c2\u6570")
    public IPSDELogicParam getDefaultPSDELogicParam() {
        return this.defaultPSDELogicParam;
    }

    public static void sortPSDELogicNodeList(List<IPSDELogicNode> list) {
        Collections.sort(list, new Comparator<Object>(){

            @Override
            public int compare(Object o1, Object o2) {
                int nRet = 0;
                IPSDELogicNode i1 = (IPSDELogicNode)o1;
                IPSDELogicNode i2 = (IPSDELogicNode)o2;
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

    public static void sortPSDELogicParamMap(Map<String, IPSDELogicParam> map) {
        ArrayList<IPSDELogicParam> list = new ArrayList<IPSDELogicParam>();
        list.addAll(map.values());
        Collections.sort(list, new Comparator<Object>(){

            @Override
            public int compare(Object o1, Object o2) {
                int nRet = 0;
                IPSDELogicParam i1 = (IPSDELogicParam)o1;
                IPSDELogicParam i2 = (IPSDELogicParam)o2;
                if (i1.isDefault() && !i2.isDefault()) {
                    return -1;
                }
                if (!i1.isDefault() && i2.isDefault()) {
                    return 1;
                }
                nRet = StringHelper.compare((String)i1.getCodeName(), (String)i2.getCodeName(), (boolean)false);
                if (nRet != 0) {
                    return nRet;
                }
                nRet = StringHelper.compare((String)i1.getName(), (String)i2.getName(), (boolean)false);
                return nRet;
            }
        });
        map.clear();
        for (IPSDELogicParam iPSDELogicParam : list) {
            map.put(iPSDELogicParam.getId(), iPSDELogicParam);
        }
    }

    @Override
    public boolean isPrepareLast() {
        Iterator<IPSDELogicParam> psDELogicParams;
        if (this.isEnableBackend() && (psDELogicParams = this.getPSDELogicParams()) != null) {
            while (psDELogicParams.hasNext()) {
                IPSDELogicParam iPSDELogicParam = psDELogicParams.next();
                if (!iPSDELogicParam.isLastParam()) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u5230\u6307\u5b9a\u884c\u4e3a", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", fields={"ATTACHTOPSDEACTIONID"})
    public IPSDEAction getAttachToPSDEAction() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u5230\u6307\u5b9a\u6570\u636e\u96c6", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", fields={"ATTACHTOPSDEDATASETID"})
    public IPSDEDataSet getAttachToPSDEDataSet() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u6a21\u5f0f", hideempty=true, ignorepf=true, codelist="DEActionLogicAttachMode", fields={"ATTACHMODE"})
    public String getAttachMode() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u89e6\u53d1\u7b56\u7565", ignorepf=true, fields={"TIMERPOLICY"})
    public String getTimerPolicy() {
        return this.psDELogic.getTIMERPOLICY();
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u5f02\u5e38", ignoredumpvalues="false", fields={"IGNOREEXCEPTION"})
    public boolean isIgnoreException() {
        return this.psDELogic.getIGNOREEXCEPTION();
    }

    @Override
    @PSModelRTMeta(description="\u76d1\u63a7\u4e8b\u4ef6", fields={"EVENTS"})
    public String getEvents() {
        return this.psDELogic.getEVENTS();
    }

    @Override
    @PSModelRTMeta(description="\u76d1\u63a7\u4e8b\u4ef6\u6a21\u578b", fields={"EVENTMODEL"})
    public String getEventModel() {
        return this.psDELogic.getEVENTMODEL();
    }

    @Override
    @PSModelRTMeta(description="\u7ebf\u7a0b\u6a21\u5f0f", codelist="DELogicThreadRunMode", ignoredumpvalues="0", fields={"THREADRUNMODE"})
    public int getThreadMode() {
        return this.psDELogic.getTHREADRUNMODE();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u903b\u8f91", ignorepf=false, ignoredumpvalues="false", fields={"TEMPLFLAG"})
    public boolean isTemplate() {
        return this.psDELogic.getTEMPLFLAG();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528", ignorepf=false, ignoredumpvalues="true", fields={"VALIDFLAG"})
    public boolean isValid() {
        return true;
    }
}

