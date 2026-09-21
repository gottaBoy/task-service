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
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicNode;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
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

@PSModelPFIgnoreMeta
public class PSDEMSLogicImpl
extends PSDataEntityObjectImpl
implements IPSDEMSLogic,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEMSLogicImpl.class);
    protected PSDELogic psDELogic;
    protected Map<String, IPSDEMSLogicNode> psDEMSLogicNodeMap = new LinkedHashMap<String, IPSDEMSLogicNode>();
    protected ArrayList<IPSDEMSLogicLink> psDEMSLogicLinkList = new ArrayList();
    private String strCodeName = "";
    private IPSDEMSLogicNode defaultPSDEMSLogicNode = null;
    private String strDefaultParamName = "";
    private String strLogicType = "MAINSTATELOGIC";
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

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
                    if (!StringHelper.isNullOrEmpty((String)PSDEMSLogicImpl.this.getModelType()) && !StringHelper.isNullOrEmpty((String)PSDEMSLogicImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSDEMSLogicImpl.this.getModelType(), (Object)PSDEMSLogicImpl.this.getId())) {
                            throw new Exception(StringHelper.format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        try {
                            PSDEMSLogicImpl.this.onInit();
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEMSLogicImpl.this.getModelType(), (Object)PSDEMSLogicImpl.this.getId());
                        }
                        catch (Exception ex) {
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEMSLogicImpl.this.getModelType(), (Object)PSDEMSLogicImpl.this.getId());
                            throw ex;
                        }
                    } else {
                        PSDEMSLogicImpl.this.onInit();
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
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.psDELogic.getPSDELOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u9ed8\u8ba4\u72b6\u6001\u8282\u70b9", dumpref=true, from="__self__")
    public IPSDEMSLogicNode getDefaultPSDEMSLogicNode() {
        return this.defaultPSDEMSLogicNode;
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
        this.onPreparePSDEMSLogicNodes();
    }

    protected void onPreparePSDEMSLogicNodes() throws Exception {
        this.psDEMSLogicNodeMap.clear();
        Vector<PSDELogicNode> psDELogicNodeList = new Vector<PSDELogicNode>();
        CallResult callResult = this.getPSModelHelper().getPSDELogicNodes(this.getId(), psDELogicNodeList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u4e3b\u72b6\u6001\u903b\u8f91\u8282\u70b9\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDELogicNode> psDELogicNodeMap = new HashMap<String, PSDELogicNode>();
        for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
            if (!"MAINSTATE".equals(psDELogicNode.getLOGICNODETYPE())) continue;
            psDELogicNodeMap.put(psDELogicNode.getPSDELOGICNODEID(), psDELogicNode);
        }
        psDELogicNodeList.clear();
        psDELogicNodeList.addAll(psDELogicNodeMap.values());
        this.psDEMSLogicLinkList.clear();
        Vector<PSDELogicLink> psDELogicLinkList = new Vector<PSDELogicLink>();
        callResult = this.getPSModelHelper().getPSDELogicLinks(this.getId(), psDELogicLinkList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u903b\u8f91\u8fde\u63a5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDELogicLink> psDELogicLinkMap = new HashMap<String, PSDELogicLink>();
        HashMap<String, String> toPSDElogicLinkMap = new HashMap<String, String>();
        for (PSDELogicLink psDELogicLink : psDELogicLinkList) {
            psDELogicLinkMap.put(psDELogicLink.getPSDELOGICLINKID(), psDELogicLink);
            PSDELogicNode psDELogicNode = (PSDELogicNode)((Object)psDELogicNodeMap.get(psDELogicLink.getSRCPSDELOGICNODEID()));
            if (psDELogicNode != null) {
                psDELogicNode.getPSDELogicLinks(true).add(psDELogicLink);
                toPSDElogicLinkMap.put(psDELogicLink.getDSTPSDELOGICNODEID(), "");
                continue;
            }
            log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e3b\u72b6\u6001\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8282\u70b9[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicLink.getSRCPSDELOGICNODEID()));
        }
        Vector<PSDELogicLinkCond> psDELogicLinkCondList = new Vector<PSDELogicLinkCond>();
        callResult = this.getPSModelHelper().getPSDELogicLinkConds(this.getId(), psDELogicLinkCondList);
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
            log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e3b\u72b6\u6001\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8fde\u63a5[%3$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDELogicLinkCond.getPSDELOGICLINKID()));
        }
        ArrayList<IPSDEMSLogicNode> list = new ArrayList<IPSDEMSLogicNode>();
        for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
            IPSDELogicNodeType iPSDELogicNodeType = this.getPSModelStorage().getPSDELogicNodeType(psDELogicNode.getLOGICNODETYPE());
            IPSDEMSLogicNode iPSDEMSLogicNode = iPSDELogicNodeType.createPSDEMSLogicNode(psDELogicNode);
            iPSDEMSLogicNode.init(this.getDAGlobalHelper(), this, psDELogicNode);
            list.add(iPSDEMSLogicNode);
            if (!iPSDEMSLogicNode.isDefaultMode()) continue;
            if (this.defaultPSDEMSLogicNode == null) {
                this.defaultPSDEMSLogicNode = iPSDEMSLogicNode;
                continue;
            }
            throw new Exception(String.format("\u5b58\u5728\u591a\u4e2a\u9ed8\u8ba4\u72b6\u6001\u7684\u72b6\u6001\u8282\u70b9", new Object[0]));
        }
        PSDEMSLogicImpl.sortPSDEMSLogicNodeList(list);
        if (this.defaultPSDEMSLogicNode != null) {
            list.remove(this.defaultPSDEMSLogicNode);
            list.add(0, this.defaultPSDEMSLogicNode);
        }
        for (IPSDEMSLogicNode iPSDEMSLogicNode : list) {
            this.psDEMSLogicNodeMap.put(iPSDEMSLogicNode.getId(), iPSDEMSLogicNode);
            Iterator<IPSDEMSLogicLink> psDEMSLogicLinks = iPSDEMSLogicNode.getPSDEMSLogicLinks();
            if (psDEMSLogicLinks == null) continue;
            while (psDEMSLogicLinks.hasNext()) {
                this.psDEMSLogicLinkList.add(psDEMSLogicLinks.next());
            }
        }
    }

    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u903b\u8f91\u8282\u70b9\u96c6\u5408", child=true)
    public Iterator<IPSDEMSLogicNode> getPSDEMSLogicNodes() {
        return this.psDEMSLogicNodeMap.values().iterator();
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
    public IPSDEMSLogicNode getPSDEMSLogicNode(String strPSDEMSLogicNodeId) throws Exception {
        IPSDEMSLogicNode iPSDEMSLogicNode = this.psDEMSLogicNodeMap.get(strPSDEMSLogicNodeId);
        if (iPSDEMSLogicNode != null) {
            return iPSDEMSLogicNode;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8282\u70b9[%1$s]", (Object)strPSDEMSLogicNodeId));
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53c2\u6570\u540d\u79f0")
    public String getDefaultParamName() {
        return this.strDefaultParamName;
    }

    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u903b\u8f91\u8fde\u63a5\u96c6\u5408")
    public Iterator<IPSDEMSLogicLink> getPSDEMSLogicLinks() {
        return this.psDEMSLogicLinkList.iterator();
    }

    @Override
    public String getLogicType() {
        return this.strLogicType;
    }

    @Override
    public String getModelType() {
        return "PSDEMSLOGIC";
    }

    @Override
    public String getModelName(String strModelType) {
        return super.getModelName(strModelType);
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        return super.getModelClass(strModelType);
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
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
    public int getLogicHolder() {
        return 1;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb0", fields={"LOGICTAG"})
    public String getLogicTag() {
        return this.psDELogic.getLOGICTAG();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb02", fields={"LOGICTAG2"})
    public String getLogicTag2() {
        return this.psDELogic.getLOGICTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb03", fields={"LOGICTAG3"})
    public String getLogicTag3() {
        return this.psDELogic.getLOGICTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb04", fields={"LOGICTAG4"})
    public String getLogicTag4() {
        return this.psDELogic.getLOGICTAG4();
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

    public static void sortPSDEMSLogicNodeList(List<IPSDEMSLogicNode> list) {
        Collections.sort(list, new Comparator<Object>(){

            @Override
            public int compare(Object o1, Object o2) {
                int nRet = 0;
                IPSDEMSLogicNode i1 = (IPSDEMSLogicNode)o1;
                IPSDEMSLogicNode i2 = (IPSDEMSLogicNode)o2;
                if (i1.getOrderValue() >= 0 && i2.getOrderValue() >= 0 && (nRet = new Integer(i1.getOrderValue()).compareTo(i2.getOrderValue())) != 0) {
                    return nRet;
                }
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
}

