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
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.PSControlLogicImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLink;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNodeType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelLogic;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelLogicParamImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSViewLogic;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSPanelLogicLink;
import SA.SRFDA.PS.Data.PSPanelLogicLinkCond;
import SA.SRFDA.PS.Data.PSPanelLogicNode;
import SA.SRFDA.PS.Data.PSPanelLogicNodeParam;
import SA.SRFDA.PS.Data.PSPanelLogicParam;
import SA.SRFDA.PS.Data.PSSysPanelLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
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

public class PSSysPanelLogicImpl
extends PSObjectImpl
implements IPSSysPanelLogic {
    private static final Log log = LogFactory.getLog(PSSysPanelLogicImpl.class);
    private IPSSysPanel iPSSysPanel = null;
    protected PSSysPanelLogic psSysPanelLogic;
    protected Map<String, IPSPanelLogicNode> psPanelLogicNodeMap = new LinkedHashMap<String, IPSPanelLogicNode>();
    protected ArrayList<IPSPanelLogicLink> psPanelLogicLinkList = new ArrayList();
    protected Map<String, IPSPanelLogicParam> psPanelLogicParamMap = new LinkedHashMap<String, IPSPanelLogicParam>();
    private String strCodeName = "";
    private IPSPanelLogicNode startPSPanelLogicNode = null;
    private String strLogicTrigger = null;
    private String strEventNames = null;
    private String strDstLogicType = null;
    private IPSPanelItem eventPSPanelItem = null;
    private IPSPanelModel eventPSPanelModel = null;
    private IPSControlLogic iPSControlLogic = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEUILogic iPSAppDEUILogic = null;
    private IPSAppUILogic iPSAppUILogic = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEUIAction iPSDEUIAction = null;
    private PSAppViewUIActionProxy psAppViewUIActionProxy = null;
    private String strPSSysPFPluginId = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysPanel iPSSysPanel, PSSysPanelLogic psSysPanelLogic) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysPanel = iPSSysPanel;
            this.psSysPanelLogic = psSysPanelLogic;
            this.setId(this.psSysPanelLogic.getPSSYSVIEWPANELLOGICID());
            this.setName(this.psSysPanelLogic.getPSSYSVIEWPANELLOGICNAME());
            this.setPSObjectData(this.psSysPanelLogic);
            this.strCodeName = this.psSysPanelLogic.getCODENAME();
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSSysPanelLogicImpl.this.getModelType()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSSysPanelLogicImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSSysPanelLogicImpl.this.getModelType(), (Object)PSSysPanelLogicImpl.this.getId())) {
                            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        try {
                            PSSysPanelLogicImpl.this.onInit();
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSSysPanelLogicImpl.this.getModelType(), (Object)PSSysPanelLogicImpl.this.getId());
                        }
                        catch (Exception ex) {
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSSysPanelLogicImpl.this.getModelType(), (Object)PSSysPanelLogicImpl.this.getId());
                            throw ex;
                        }
                    }
                }
            });
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
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
        return this.psSysPanelLogic.getPSSYSVIEWPANELLOGICNAME();
    }

    @Override
    public IPSPanelLogicNode getStartPSPanelLogicNode() {
        return this.startPSPanelLogicNode;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void onInit() throws Exception {
        String strPSDEId;
        this.strLogicTrigger = this.psSysPanelLogic.getLOGICTYPE();
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strLogicTrigger, (String)"CTRLEVENT", (boolean)true) == 0) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelLogic.getPSSYSVIEWPANELITEMID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u89e6\u53d1\u4e8b\u4ef6\u7684\u9762\u677f\u9879");
            }
            this.eventPSPanelItem = this.getPSPanel().getPSPanelItem(this.psSysPanelLogic.getPSSYSVIEWPANELITEMID());
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelLogic.getCTRLEVENT())) {
                this.strEventNames = this.psSysPanelLogic.getCTRLEVENT();
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strLogicTrigger, (String)"PANELEVENT", (boolean)true) == 0 && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelLogic.getCTRLEVENT())) {
            this.strEventNames = this.psSysPanelLogic.getCTRLEVENT();
        }
        this.strDstLogicType = this.psSysPanelLogic.getDSTLOGICTYPE();
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strDstLogicType, (String)"SYSUILOGIC", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.strDstLogicType, (String)"SYSVIEWLOGIC", (boolean)true) == 0) {
            String strPSSysViewLogicId;
            if (this.getPSAppUILogic() == null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strPSSysViewLogicId = this.psSysPanelLogic.getPSSYSVIEWLOGICID()))) {
                this.iPSAppUILogic = this.getPSPanel().getPSAppView().getPSApplication().getPSAppUILogic(strPSSysViewLogicId);
            }
            if (this.getPSAppUILogic() == null) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u9762\u677f\u903b\u8f91[%1$s]\u6ca1\u6709\u6307\u5b9a\u9884\u7f6e\u754c\u9762\u903b\u8f91", (Object)this.getName()));
            }
            this.strDstLogicType = "SYSUILOGIC";
            if (this.getPSSysPanel().isEnableUIModelEx()) {
                this.strDstLogicType = "APPUILOGIC";
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strDstLogicType, (String)"DEUILOGIC", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.strDstLogicType, (String)"DELOGIC", (boolean)true) == 0) {
            strPSDEId = this.psSysPanelLogic.getPSDEID();
            PSDELogic psDELogic = ((IPSSystem)((Object)this.getPSSystemUtil())).getPSDELogicData(this.psSysPanelLogic.getPSDELOGICID(), true);
            if (psDELogic != null) {
                strPSDEId = psDELogic.getPSDEID();
            }
            this.iPSDataEntity = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDEId) ? this.getPSPanel().getPSAppView().getPSSystem().getPSDataEntity2(strPSDEId) : this.getPSPanel().getPSDataEntity();
            if (this.iPSDataEntity == null) {
                throw new Exception("\u5f53\u524d\u5b9e\u4f53\u65e0\u6548");
            }
            this.iPSAppDataEntity = this.getPSPanel().getPSAppView().getPSApplication().getPSAppDataEntity(this.iPSDataEntity, false);
            this.iPSAppDEUILogic = this.iPSAppDataEntity.getPSAppDEUILogic(this.psSysPanelLogic.getPSDELOGICID());
            this.strDstLogicType = "DEUILOGIC";
            if (this.getPSSysPanel().isEnableUIModelEx()) {
                this.strDstLogicType = "APPDEUILOGIC";
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strDstLogicType, (String)"DEUIACTION", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.strDstLogicType, (String)"APPVIEWUIACTION", (boolean)true) == 0) {
            strPSDEId = this.psSysPanelLogic.getPSDEID();
            this.iPSDataEntity = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDEId) ? this.getPSPanel().getPSAppView().getPSSystem().getPSDataEntity2(strPSDEId) : this.getPSPanel().getPSDataEntity();
            if (this.iPSDataEntity == null) {
                throw new Exception("\u5f53\u524d\u5b9e\u4f53\u65e0\u6548");
            }
            this.iPSAppDataEntity = this.getPSPanel().getPSAppView().getPSApplication().getPSAppDataEntity(this.iPSDataEntity, false);
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPanelLogic.getPSDEUIACTIONID())) throw new Exception("\u672a\u6307\u5b9a\u754c\u9762\u884c\u4e3a\u5bf9\u8c61");
            String strPSDEUIActonId = this.psSysPanelLogic.getPSDEUIACTIONID();
            if (this.iPSDEUIAction == null && this.getPSAppDataEntity() != null) {
                this.iPSDEUIAction = this.getPSAppDataEntity().getPSAppDEUIAction(strPSDEUIActonId, true, this.getPSSysPanel());
            }
            if (this.iPSDEUIAction != null) {
                if (this.getPSSysPanel().isPrepareTemplV2logic()) {
                    this.psAppViewUIActionProxy = new PSAppViewUIActionProxy(this.getPSSysPanel(), this.iPSDEUIAction, this.getPSSysPanel());
                    this.getPSSysPanel().registerPSAppViewUIAction(this.psAppViewUIActionProxy);
                } else {
                    this.getPSSysPanel().getPSAppView().registerPSUIAction(this.iPSDEUIAction);
                }
            }
            this.strDstLogicType = "APPVIEWUIACTION";
            if (this.getPSSysPanel().isEnableUIModelEx()) {
                this.strDstLogicType = "APPDEUIACTION";
                this.psAppViewUIActionProxy = null;
            } else {
                this.iPSDEUIAction = null;
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strDstLogicType, (String)"PFPLUGIN", (boolean)true) == 0) {
            this.strPSSysPFPluginId = this.psSysPanelLogic.getPSSYSPFPLUGINID();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSSysPFPluginId)) {
                throw new Exception("\u5e94\u7528\u524d\u7aef\u63d2\u4ef6\u65e0\u6548");
            }
            this.iPSSysPFPlugin = this.getPSAppView().getPSApplication().getPSSysPFPlugin(this.strPSSysPFPluginId, "APPVIEWLOGIC", null, null);
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getLogicTrigger(), (String)"PANELEVENT", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getLogicTrigger(), (String)"CTRLEVENT", (boolean)true) == 0) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSPanelItemName())) {
                if (!this.getPSPanel().hasPSControl(this.getPSPanelItemName())) {
                    this.setLogicTrigger("PANELEVENT");
                    this.iPSControlLogic = new PSControlLogicImpl(this){

                        @Override
                        public String getLogicTag() {
                            return PSSysPanelLogicImpl.this.getPSPanelItemName();
                        }

                        @Override
                        public String getEventNames() {
                            return ((IPSSysPanelLogic)this.getOwner()).getEventNames();
                        }

                        @Override
                        public String getEventArg() {
                            return ((IPSSysPanelLogic)this.getOwner()).getEventArg();
                        }

                        @Override
                        public String getEventArg2() {
                            return ((IPSSysPanelLogic)this.getOwner()).getEventArg2();
                        }

                        @Override
                        public IPSAppViewLogic getPSAppViewLogic() {
                            return (IPSSysPanelLogic)this.getOwner();
                        }
                    };
                    this.getPSPanel().registerPSControlLogic(this.iPSControlLogic);
                } else {
                    this.setLogicTrigger("CTRLEVENT");
                    IPSControl iPSControl = this.getPSPanel().getPSControl(this.getPSPanelItemName());
                    this.iPSControlLogic = new PSControlLogicImpl(this){

                        @Override
                        public String getLogicTag() {
                            return PSSysPanelLogicImpl.this.getPSPanelItemName();
                        }

                        @Override
                        public String getEventNames() {
                            return ((IPSSysPanelLogic)this.getOwner()).getEventNames();
                        }

                        @Override
                        public String getEventArg() {
                            return ((IPSSysPanelLogic)this.getOwner()).getEventArg();
                        }

                        @Override
                        public String getEventArg2() {
                            return ((IPSSysPanelLogic)this.getOwner()).getEventArg2();
                        }

                        @Override
                        public IPSAppViewLogic getPSAppViewLogic() {
                            return (IPSSysPanelLogic)this.getOwner();
                        }
                    };
                    iPSControl.registerPSControlLogic(this.iPSControlLogic);
                }
            } else {
                this.setLogicTrigger("CTRLEVENT");
                this.iPSControlLogic = new PSControlLogicImpl(this){

                    @Override
                    public String getLogicTag() {
                        return PSSysPanelLogicImpl.this.getPSPanel().getName();
                    }

                    @Override
                    public String getEventNames() {
                        return ((IPSSysPanelLogic)this.getOwner()).getEventNames();
                    }

                    @Override
                    public String getEventArg() {
                        return ((IPSSysPanelLogic)this.getOwner()).getEventArg();
                    }

                    @Override
                    public String getEventArg2() {
                        return ((IPSSysPanelLogic)this.getOwner()).getEventArg2();
                    }

                    @Override
                    public IPSAppViewLogic getPSAppViewLogic() {
                        return (IPSSysPanelLogic)this.getOwner();
                    }
                };
                this.getPSPanel().registerPSControlLogic(this.iPSControlLogic);
            }
        }
        super.onInit();
    }

    protected void onPreparePSPanelLogicNodes() throws Exception {
        this.psPanelLogicParamMap.clear();
        Vector<PSPanelLogicParam> psPanelLogicParamList = new Vector<PSPanelLogicParam>();
        CallResult callResult = this.getPSModelHelper().getPSPanelLogicParams(this.getId(), psPanelLogicParamList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u903b\u8f91\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSPanelLogicParam psPanelLogicParam : psPanelLogicParamList) {
            PSPanelLogicParamImpl iPSPanelLogicParam = new PSPanelLogicParamImpl();
            iPSPanelLogicParam.init(this.getDAGlobalHelper(), this, psPanelLogicParam);
            this.psPanelLogicParamMap.put(iPSPanelLogicParam.getId(), iPSPanelLogicParam);
        }
        this.psPanelLogicNodeMap.clear();
        Vector<PSPanelLogicNode> psPanelLogicNodeList = new Vector<PSPanelLogicNode>();
        callResult = this.getPSModelHelper().getPSPanelLogicNodes(this.getId(), psPanelLogicNodeList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u903b\u8f91\u8282\u70b9\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        LinkedHashMap<String, PSPanelLogicNode> psPanelLogicNodeMap = new LinkedHashMap<String, PSPanelLogicNode>();
        for (PSPanelLogicNode psPanelLogicNode : psPanelLogicNodeList) {
            psPanelLogicNodeMap.put(psPanelLogicNode.getPSPANELLOGICNODEID(), psPanelLogicNode);
        }
        this.psPanelLogicLinkList.clear();
        Vector<PSPanelLogicLink> psPanelLogicLinkList = new Vector<PSPanelLogicLink>();
        callResult = this.getPSModelHelper().getPSPanelLogicLinks(this.getId(), psPanelLogicLinkList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u903b\u8f91\u8fde\u63a5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        LinkedHashMap<String, PSPanelLogicLink> psPanelLogicLinkMap = new LinkedHashMap<String, PSPanelLogicLink>();
        for (PSPanelLogicLink psPanelLogicLink : psPanelLogicLinkList) {
            psPanelLogicLinkMap.put(psPanelLogicLink.getPSPANELLOGICLINKID(), psPanelLogicLink);
            PSPanelLogicNode psPanelLogicNode = (PSPanelLogicNode)((Object)psPanelLogicNodeMap.get(psPanelLogicLink.getSRCPSPANELLOGICNODEID()));
            if (psPanelLogicNode != null) {
                psPanelLogicNode.getPSPanelLogicLinks(true).add(psPanelLogicLink);
                continue;
            }
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u9762\u677f[%1$s]\u5904\u7406\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8282\u70b9[%3$s]", (Object)this.getPSPanel().getName(), (Object)this.getName(), (Object)psPanelLogicLink.getSRCPSPANELLOGICNODEID()));
        }
        Vector<PSPanelLogicNodeParam> psPanelLogicNodeParamList = new Vector<PSPanelLogicNodeParam>();
        callResult = this.getPSModelHelper().getPSPanelLogicNodeParams(this.getId(), psPanelLogicNodeParamList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u903b\u8f91\u8282\u70b9\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSPanelLogicNodeParam psPanelLogicNodeParam : psPanelLogicNodeParamList) {
            PSPanelLogicNode psPanelLogicNode = (PSPanelLogicNode)((Object)psPanelLogicNodeMap.get(psPanelLogicNodeParam.getPSPANELLOGICNODEID()));
            if (psPanelLogicNode != null) {
                psPanelLogicNode.getPSPanelLogicNodeParams(true).add(psPanelLogicNodeParam);
                continue;
            }
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u9762\u677f[%1$s]\u5904\u7406\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8282\u70b9[%3$s]", (Object)this.getPSPanel().getName(), (Object)this.getName(), (Object)psPanelLogicNodeParam.getPSPANELLOGICNODEID()));
        }
        Vector<PSPanelLogicLinkCond> psPanelLogicLinkCondList = new Vector<PSPanelLogicLinkCond>();
        callResult = this.getPSModelHelper().getPSPanelLogicLinkConds(this.getId(), psPanelLogicLinkCondList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u903b\u8f91\u8fde\u63a5\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        LinkedHashMap<String, PSPanelLogicLinkCond> psPanelLogicLinkCondMap = new LinkedHashMap<String, PSPanelLogicLinkCond>();
        for (PSPanelLogicLinkCond psPanelLogicLinkCond : psPanelLogicLinkCondList) {
            psPanelLogicLinkCondMap.put(psPanelLogicLinkCond.getPSPANELLLCONDID(), psPanelLogicLinkCond);
        }
        for (PSPanelLogicLinkCond psPanelLogicLinkCond : psPanelLogicLinkCondList) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psPanelLogicLinkCond.getPPSPANELLLCONDID())) continue;
            PSPanelLogicLinkCond parentPSPanelLogicLinkCond = (PSPanelLogicLinkCond)((Object)psPanelLogicLinkCondMap.get(psPanelLogicLinkCond.getPPSPANELLLCONDID()));
            parentPSPanelLogicLinkCond.getChildPSPanelLogicLinkConds(true).add(psPanelLogicLinkCond);
        }
        for (PSPanelLogicLinkCond psPanelLogicLinkCond : psPanelLogicLinkCondList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psPanelLogicLinkCond.getPPSPANELLLCONDID())) continue;
            PSPanelLogicLink psPanelLogicLink = (PSPanelLogicLink)((Object)psPanelLogicLinkMap.get(psPanelLogicLinkCond.getPSPANELLOGICLINKID()));
            if (psPanelLogicLink != null) {
                psPanelLogicLink.getPSPanelLogicLinkConds(true).add(psPanelLogicLinkCond);
                continue;
            }
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u9762\u677f[%1$s]\u5904\u7406\u903b\u8f91[%2$s]\u65e0\u6cd5\u83b7\u53d6\u8fde\u63a5[%3$s]", (Object)this.getPSPanel().getName(), (Object)this.getName(), (Object)psPanelLogicLinkCond.getPSPANELLOGICLINKID()));
        }
        for (PSPanelLogicNode psPanelLogicNode : psPanelLogicNodeList) {
            Iterator<IPSPanelLogicLink> psPanelLogicLinks;
            IPSPanelLogicNodeType iPSPanelLogicNodeType = this.getPSModelStorage().getPSPanelLogicNodeType(psPanelLogicNode.getLOGICNODETYPE());
            IPSPanelLogicNode iPSPanelLogicNode = iPSPanelLogicNodeType.createPSPanelLogicNode(psPanelLogicNode);
            iPSPanelLogicNode.init(this.getDAGlobalHelper(), this, psPanelLogicNode);
            this.psPanelLogicNodeMap.put(iPSPanelLogicNode.getId(), iPSPanelLogicNode);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSPanelLogicNode.getLogicNodeType(), (String)"BEGIN", (boolean)true) == 0) {
                this.startPSPanelLogicNode = iPSPanelLogicNode;
            }
            if ((psPanelLogicLinks = iPSPanelLogicNode.getPSPanelLogicLinks()) == null) continue;
            while (psPanelLogicLinks.hasNext()) {
                this.psPanelLogicLinkList.add(psPanelLogicLinks.next());
            }
        }
    }

    @Override
    public Iterator<IPSPanelLogicNode> getPSPanelLogicNodes() {
        return this.psPanelLogicNodeMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public Iterator<IPSPanelLogicParam> getPSPanelLogicParams() {
        if (this.psPanelLogicParamMap == null || this.psPanelLogicParamMap.size() == 0) {
            return null;
        }
        return this.psPanelLogicParamMap.values().iterator();
    }

    @Override
    public IPSPanelLogicParam getPSPanelLogicParam(String strPSPanelLogicParamId) throws Exception {
        IPSPanelLogicParam iPSPanelLogicParam = this.psPanelLogicParamMap.get(strPSPanelLogicParamId);
        if (iPSPanelLogicParam != null) {
            return iPSPanelLogicParam;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53c2\u6570[%1$s]", (Object)strPSPanelLogicParamId));
    }

    @Override
    public IPSPanelLogicNode getPSPanelLogicNode(String strPSPanelLogicNodeId) throws Exception {
        IPSPanelLogicNode iPSPanelLogicNode = this.psPanelLogicNodeMap.get(strPSPanelLogicNodeId);
        if (iPSPanelLogicNode != null) {
            return iPSPanelLogicNode;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8282\u70b9[%1$s]", (Object)strPSPanelLogicNodeId));
    }

    @Override
    public IPSSysPanel getPSSysPanel() {
        return this.iPSSysPanel;
    }

    @Override
    public IPSPanel getPSPanel() {
        return this.getPSSysPanel();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u903b\u8f91\u7c7b\u578b", codelist="ControlLogicType")
    public String getLogicType() {
        return this.strDstLogicType;
    }

    @Override
    public String getPSPanelItemName() {
        return this.psSysPanelLogic.getPSSYSVIEWPANELITEMNAME();
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u9879\u540d\u79f0", hideempty=true)
    public String getPSViewCtrlName() {
        return this.getPSPanelItemName();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u4e8b\u4ef6\u7684\u9762\u677f\u9879", hideempty=true)
    public IPSPanelItem getEventPSPanelItem() {
        return this.eventPSPanelItem;
    }

    @Override
    public String getEventName() {
        return this.strEventNames;
    }

    @Override
    public IPSPanelModel getEventPSPanelModel() {
        return this.eventPSPanelModel;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSPanel().getPSAppView().getPSSystem());
    }

    @Override
    public Iterator<IPSPanelLogicLink> getPSPanelLogicLinks() {
        return this.psPanelLogicLinkList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELLOGIC";
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSPanel().getPSSysModelInstId();
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysPanel().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysPanel().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u89e6\u53d1", codelist="PanelLogicType")
    public String getLogicTrigger() {
        return this.strLogicTrigger;
    }

    protected void setLogicTrigger(String strLogicTrigger) {
        this.strLogicTrigger = strLogicTrigger;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91", hideempty2=true, dumpref=true, from="IPSApplication")
    public IPSAppUILogic getPSAppUILogic() {
        return this.iPSAppUILogic;
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1")
    public int getTimer() {
        return this.psSysPanelLogic.GetParamIntValue("TIMER", 0);
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u540d\u79f0", hideempty2=true)
    public String getEventNames() {
        return this.strEventNames;
    }

    @Override
    public String getLogicParam() {
        return this.psSysPanelLogic.getParamStringValue("LOGICPARAM", null);
    }

    @Override
    public String getLogicParam2() {
        return this.psSysPanelLogic.getParamStringValue("LOGICPARAM2", null);
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u6570", hideempty2=true)
    public String getEventArg() {
        return this.psSysPanelLogic.getParamStringValue("CTRLEVENTARG", null);
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u65702", hideempty2=true)
    public String getEventArg2() {
        return this.psSysPanelLogic.getParamStringValue("CTRLEVENTARG2", null);
    }

    @Override
    @PSModelRTMeta(description="\u6ce8\u5165\u5c5e\u6027\u540d\u79f0", hideempty2=true)
    public String getAttrName() {
        return this.psSysPanelLogic.getParamStringValue("ATTRNAME", null);
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0", hideempty2=true)
    public String getItemName() {
        return this.psSysPanelLogic.getParamStringValue("ITEMNAME", null);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public Object getOwner() {
        return this;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true, dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91", hideempty2=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEUILogic getPSAppDEUILogic() {
        return this.iPSAppDEUILogic;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5bf9\u8c61", hideempty=true, child=true, fields={"PSDEUIACTIONID"})
    public IPSAppDEUIAction getPSAppDEUIAction() {
        if (this.iPSDEUIAction instanceof IPSAppDEUIAction) {
            return (IPSAppDEUIAction)this.iPSDEUIAction;
        }
        return null;
    }

    @Override
    public IPSViewLogic getPSViewLogic() {
        return this.getPSAppUILogic();
    }

    @Override
    public IPSAppViewLogic getPSAppViewLogic() {
        return null;
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.getPSPanel().getPSAppView();
    }

    @Override
    public IPSAppViewEngine getPSAppViewEngine() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u754c\u9762\u884c\u4e3a", dumpref=true)
    public IPSAppViewUIAction getPSAppViewUIAction() {
        return this.psAppViewUIActionProxy;
    }

    @Override
    public boolean isBuiltinLogic() {
        return false;
    }

    @Override
    public IPSControlContainer getPSControlContainer() {
        return this.getPSPanel();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true)
    public String getScriptCode() {
        return this.psSysPanelLogic.getCUSTOMCODE();
    }

    @Override
    public String getPSSysViewPanelId() {
        return this.psSysPanelLogic.getLAYOUTPSSYSVIEWPANELID();
    }

    @Override
    public String getPSSysPFPluginId() {
        return this.strPSSysPFPluginId;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u524d\u7aef\u63d2\u4ef6", hideempty=true, fields={"PSSYSPFPLUGINID"})
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }
}

