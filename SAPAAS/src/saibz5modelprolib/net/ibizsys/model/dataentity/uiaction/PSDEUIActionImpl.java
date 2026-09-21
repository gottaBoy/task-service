/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControlXDataContainer
 *  net.ibizsys.model.control.toolbar.IPSDECMUIActionItem
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarItem
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.model.dataentity.priv.IPSDEOPPriv
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIAction
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.model.res.IPSSysPDTView
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.model.view.IPSUIActionGroup
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.uiaction;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Enumeration;
import java.util.Properties;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemUtil;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.control.toolbar.IPSDECMUIActionItem;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionRuntime;
import net.ibizsys.model.entity.PSDEUIAction;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.res.IPSSysPDTView;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSUIActionGroup;
import net.ibizsys.model.view.PSUIActionImpl;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUIActionImpl
extends PSUIActionImpl
implements IPSDEUIAction,
IPSDEUIActionRuntime {
    private static final Log log = LogFactory.getLog(PSDEUIActionImpl.class);
    protected PSDEUIAction psDEUIAction = null;
    private boolean bUIActionGroup = false;
    private String strUIActionTag = "";
    private String strUIActionFullTag = null;
    private String strCodeName = "";
    private IPSDEAction iPSDEAction = null;
    private boolean bValid = true;
    private IPSDataEntity iPSDataEntity = null;
    private IPSSysImage iPSSysImage = null;
    private IPSSystem iPSSystem = null;
    private long nTimeout = 60000L;
    private String strConfirmMsg = null;
    private boolean bReloadData = false;
    private String strSuccessMsg = null;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private boolean bCloseEditView = false;
    private String strViewLogicAttachMode = null;
    private String strViewLogicType = null;
    private String strPSDEViewLogicId = null;
    private String strPSSysViewLogicId = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private IPSLanguageRes cmPSLanguageRes = null;
    private IPSLanguageRes smPSLanguageRes = null;
    private int nNoPrivDisplayMode = 2;
    private boolean bHasNoPrivDisplayMode = false;
    private ObjectNode uiActionParamJO = null;
    private String strUIActionParam = null;
    private String strValueItem = null;
    private String strTextItem = null;
    private String strParamItem = null;
    private boolean bEnableRuntimeModel = false;
    private boolean bGlobalUIAction = false;
    private IPSUIAction nextPSUIAction = null;
    private boolean bPDTFrontView = false;
    private IPSSysPDTView iPSSysPDTView = null;
    private int nExtendMode = 0;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, IPSDataEntity iPSDataEntity, PSDEUIAction psDEUIAction) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDataEntity(iPSDataEntity);
            this.iPSSystem = iPSSystem;
            this.psDEUIAction = psDEUIAction;
            this.setId(this.psDEUIAction.getPSDEUIACTIONID());
            this.setName(this.psDEUIAction.getPSDEUIACTIONNAME());
            this.setPSObjectData(this.psDEUIAction);
            if (!this.psDEUIAction.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEUIAction.getEXTENDMODE();
            }
            this.strUIActionTag = this.psDEUIAction.getCODENAME();
            this.strCodeName = this.psDEUIAction.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psDEUIAction.getPSDEUIACTIONNAME();
            }
            if (StringHelper.compare((String)this.getUIActionMode(), (String)"SYS", (boolean)true) != 0 && iPSDataEntity != null) {
                this.strUIActionFullTag = StringHelper.format((String)"%1$s@%2$s", (Object)this.getUIActionTag(), (Object)iPSDataEntity.getCodeName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIAction.getPSDEACTIONID())) {
                this.iPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEUIAction.getPSDEACTIONID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIAction.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.iPSSystem.getPSSysImage(this.psDEUIAction.getPSSYSIMAGEID());
            }
            if (this.psDEUIAction.getTIMEOUT() > 0) {
                this.nTimeout = this.psDEUIAction.getTIMEOUT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIAction.getCONFIRMINFO())) {
                this.strConfirmMsg = this.psDEUIAction.getCONFIRMINFO();
            }
            if (!this.psDEUIAction.isRELOADDATANull()) {
                this.setReloadData(this.psDEUIAction.getRELOADDATA());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIAction.getSUCCESSINFO())) {
                this.strSuccessMsg = this.psDEUIAction.getSUCCESSINFO();
            }
            if (!StringHelper.isNullOrEmpty((String)psDEUIAction.getPSDEOPPRIVID())) {
                this.iPSDEOPPriv = this.iPSSystem.getPSDEOPPriv(psDEUIAction.getPSDEOPPRIVID());
            }
            if (!this.psDEUIAction.isCLOSEEDITVIEWNull()) {
                this.setCloseEditView(this.psDEUIAction.getCLOSEEDITVIEW());
            }
            if (!this.psDEUIAction.isGLOBALFLAGNull()) {
                this.setGlobalUIAction(psDEUIAction.getGLOBALFLAG());
            }
            if (!this.psDEUIAction.isENABLERTMODELNull()) {
                this.setEnableRuntimeModel(psDEUIAction.getENABLERTMODEL());
            }
            if (!this.psDEUIAction.isPDTVIEWFLAGNull()) {
                this.bPDTFrontView = psDEUIAction.getPDTVIEWFLAG();
            }
            if (this.isFrontPDTView() && StringHelper.isNullOrEmpty((String)this.getFrontPSSysPDTViewId())) {
                this.iPSSysPDTView = this.getPSSystem().getPSSysPDTView(this.getFrontPSSysPDTViewId());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIAction.getVLEXECMODE())) {
                this.strViewLogicAttachMode = this.psDEUIAction.getVLEXECMODE();
                this.strViewLogicType = this.psDEUIAction.getVIEWLOGICTYPE();
                this.strPSDEViewLogicId = this.psDEUIAction.getPSDEVIEWLOGICID();
                this.strPSSysViewLogicId = this.psDEUIAction.getPSSYSVIEWLOGICID();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIAction.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.iPSSystem.getPSLanguageRes(this.psDEUIAction.getCAPPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIAction.getTIPPSLANRESID())) {
                this.tooltipPSLanguageRes = this.iPSSystem.getPSLanguageRes(this.psDEUIAction.getTIPPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIAction.getCMPSLANRESID())) {
                this.cmPSLanguageRes = this.iPSSystem.getPSLanguageRes(this.psDEUIAction.getCMPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIAction.getSMPSLANRESID())) {
                this.smPSLanguageRes = this.iPSSystem.getPSLanguageRes(this.psDEUIAction.getSMPSLANRESID());
            }
            if (!this.psDEUIAction.isNOPRIVDMNull()) {
                this.bHasNoPrivDisplayMode = true;
                this.nNoPrivDisplayMode = this.psDEUIAction.getNOPRIVDM();
            }
            this.strUIActionParam = psDEUIAction.getUIACTIONPARAMS().trim();
            if (!StringHelper.isNullOrEmpty((String)this.strUIActionParam)) {
                if (this.strUIActionParam.charAt(0) == '{') {
                    this.uiActionParamJO = (ObjectNode)JsonNodeHelper.fromString((String)this.strUIActionParam);
                } else {
                    this.uiActionParamJO = JsonNodeHelper.createObjectNode();
                    Properties properties = PropertiesHelper.load((String)this.strUIActionParam);
                    Enumeration<Object> keys = properties.keys();
                    while (keys.hasMoreElements()) {
                        String strKey = keys.nextElement().toString();
                        String strValue = PropertiesHelper.getProperty((Properties)properties, (String)strKey);
                        this.uiActionParamJO.put(strKey, strValue);
                    }
                }
            }
            this.strValueItem = this.psDEUIAction.getDATAITEM().trim();
            this.strTextItem = this.psDEUIAction.getTEXTITEM().trim();
            this.strParamItem = this.psDEUIAction.getPARAMITEM().trim();
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!StringHelper.isNullOrEmpty((String)PSDEUIActionImpl.this.getModelType()) && !StringHelper.isNullOrEmpty((String)PSDEUIActionImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSDEUIActionImpl.this.getModelType(), (Object)PSDEUIActionImpl.this.getId())) {
                            throw new Exception(StringHelper.format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        PSDEUIActionImpl.this.onInit();
                        ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEUIActionImpl.this.getModelType(), (Object)PSDEUIActionImpl.this.getId());
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

    @Override
    protected void onInit() throws Exception {
        String strSysUIActionId = this.psDEUIAction.getPSSYSUIACTIONID();
        if (!StringHelper.isNullOrEmpty((String)strSysUIActionId)) {
            boolean bl = this.bUIActionGroup = strSysUIActionId.indexOf("VIEW_DEBHGROUP") == 0;
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEUIAction.getNEXTPSDEUIACTIONID())) {
            if (StringHelper.compare((String)this.getId(), (String)this.psDEUIAction.getNEXTPSDEUIACTIONID(), (boolean)false) == 0) {
                throw new Exception("\u4e0b\u4e00\u6b65\u754c\u9762\u884c\u4e3a\u4e0d\u80fd\u6307\u5411\u81ea\u5df1");
            }
            this.nextPSUIAction = this.getPSDataEntity().getPSDEUIAction(this.psDEUIAction.getNEXTPSDEUIACTIONID());
        }
        super.onInit();
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u6a21\u5f0f", codelist="DEUIActionType")
    public String getUIActionMode() {
        return this.psDEUIAction.getUIACTIONTYPE();
    }

    public String getCaption(String strLanguage) {
        return this.psDEUIAction.getCAPTION();
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7c7b\u578b", displayvalue="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a(DEUIACTION)")
    public String getUIActionType() {
        return "DEUIACTION";
    }

    public String getPSSysDEUIActionId(Object obj) throws Exception {
        return this.psDEUIAction.getPSSYSUIACTIONID();
    }

    public boolean isUIActionGroup(Object obj) throws Exception {
        return this.bUIActionGroup;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u6807\u8bb0")
    public String getUIActionTag() {
        if (StringHelper.isNullOrEmpty((String)this.strUIActionTag)) {
            return this.getId();
        }
        return this.strUIActionTag;
    }

    @PSModelRTMeta(description="\u884c\u4e3a\u64cd\u4f5c\u76ee\u6807", codelist="DEUIActionDataRange")
    public String getActionTarget() {
        return this.psDEUIAction.getACTIONTARGET();
    }

    @PSModelRTMeta(description="\u524d\u53f0\u5904\u7406\u7c7b\u578b", codelist="DEUIActionFrontType", hideempty2=true)
    public String getFrontProcessType() {
        return this.psDEUIAction.getFRONTPROTYPE();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u540e\u53f0\u8c03\u7528\u5b9e\u4f53\u884c\u4e3a", hideempty=true)
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    public boolean isValid(Object obj) throws Exception {
        return this.isValid();
    }

    protected boolean isValid() {
        return this.bValid;
    }

    protected void setValid(boolean bValid) {
        this.bValid = bValid;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    @Override
    public IPSUIActionGroup getPSUIActionGroup(Object obj) throws Exception {
        if (!this.isUIActionGroup(obj)) {
            return null;
        }
        if (obj instanceof IPSDEToolbarItem) {
            IPSDEToolbarItem iPSDEToolbarItem = (IPSDEToolbarItem)obj;
            return iPSDEToolbarItem.getPSDEToolbar().getPSDEUIActionGroup(this.getPSSysDEUIActionId(obj));
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5bf9\u8c61\uff0c\u7c7b\u578b\u4e3a[%1$s]", (Object)obj.getClass().getCanonicalName()));
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u56fe\u6807\u5bf9\u8c61", hideempty=true)
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    public String getTooltip(String strLanguage) {
        return this.psDEUIAction.getTOOLTIPINFO();
    }

    @PSModelRTMeta(description="Html\u9875\u9762\u8def\u5f84")
    public String getHtmlPageUrl() {
        return this.psDEUIAction.getHTMLPAGEURL();
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSSystem != null) {
            return ((IPSModelObjectRuntime)this.iPSSystem).getPSSysModelInstId();
        }
        if (this.iPSDataEntity != null) {
            return ((IPSModelObjectRuntime)this.iPSDataEntity).getPSSysModelInstId();
        }
        return null;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u8d85\u65f6\u65f6\u957f\uff08\u6beb\u79d2\uff09")
    public long getTimeout() {
        return this.nTimeout;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u786e\u8ba4\u4fe1\u606f", hideempty2=true)
    public String getConfirmMsg() {
        return this.strConfirmMsg;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u540e\u5237\u65b0\u5f53\u524d\u754c\u9762")
    public boolean isReloadData() {
        return this.bReloadData;
    }

    public void setReloadData(boolean bReloadData) {
        this.bReloadData = bReloadData;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u6210\u529f\u63d0\u793a\u4fe1\u606f", hideempty2=true)
    public String getSuccessMsg() {
        return this.strSuccessMsg;
    }

    public void setSuccessMsg(String strSuccessMsg) {
        this.strSuccessMsg = strSuccessMsg;
    }

    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u6743\u9650", hideempty2=true)
    public String getDataAccessAction() {
        if (this.iPSDEOPPriv != null) {
            return this.iPSDEOPPriv.getName();
        }
        return null;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u540e\u5173\u95ed\u7f16\u8f91\u89c6\u56fe")
    public boolean isCloseEditView() {
        return this.bCloseEditView;
    }

    public void setCloseEditView(boolean bCloseEditView) {
        this.bCloseEditView = bCloseEditView;
    }

    public boolean isEnableToggleMode() {
        return false;
    }

    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    public String getModelType() {
        return "PSDEUIACTION";
    }

    public void init(IDataEntity iDataEntity) throws Exception {
    }

    public String getViewLogicAttachMode() {
        return this.strViewLogicAttachMode;
    }

    public String getViewLogicType() {
        return this.strViewLogicType;
    }

    public String getPSDEUILogicId() {
        return this.strPSDEViewLogicId;
    }

    public String getPSSysViewLogicId() {
        return this.strPSSysViewLogicId;
    }

    protected IPSControlXDataContainer getPSControlXDataContainer(Object obj) {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSDECMUIActionItem iPSDECMUIActionItem;
        if (obj == null) {
            return null;
        }
        if (obj instanceof IPSDECMUIActionItem && (iPSDECMUIActionItem = (IPSDECMUIActionItem)obj).getPSDEContextMenu() != null) {
            return iPSDECMUIActionItem.getPSDEContextMenu().getPSControlXDataContainer();
        }
        if (obj instanceof IPSDETBUIActionItem && (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSDEToolbar() != null) {
            return iPSDETBUIActionItem.getPSDEToolbar().getPSControlXDataContainer();
        }
        return null;
    }

    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    @PSModelRTMeta(description="\u786e\u8ba4\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90", hideempty=true)
    public IPSLanguageRes getCMPSLanguageRes() {
        return this.cmPSLanguageRes;
    }

    @PSModelRTMeta(description="\u6210\u529f\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90", hideempty=true)
    public IPSLanguageRes getSMPSLanguageRes() {
        return this.smPSLanguageRes;
    }

    public int getNoPrivDisplayMode(IPSAppView iPSAppView) {
        if (this.bHasNoPrivDisplayMode || iPSAppView == null) {
            return this.nNoPrivDisplayMode;
        }
        return iPSAppView.getButtonNoPrivDisplayMode();
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.psDEUIAction.getCAPTION();
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f")
    public String getTooltip() {
        return this.psDEUIAction.getTOOLTIPINFO();
    }

    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() != null) {
            return this.getCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    public String getTooltipLanResTag() {
        if (this.getTooltipPSLanguageRes() != null) {
            return this.getTooltipPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f", hideempty2=true)
    public String getIconCls() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClass();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84", hideempty2=true)
    public String getIconPath() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePath();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f\uff08X\uff09", hideempty2=true)
    public String getIconClsX() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClassX();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84\uff08X\uff09", hideempty2=true)
    public String getIconPathX() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePathX();
        }
        return null;
    }

    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    public String getUIActionParam() {
        return this.strUIActionParam;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u53c2\u6570\u5bf9\u8c61", hideempty2=true)
    public ObjectNode getUIActionParamJO() {
        return this.uiActionParamJO;
    }

    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0", hideempty2=true)
    public String getValueItem() {
        return this.strValueItem;
    }

    @PSModelRTMeta(description="\u6587\u672c\u9879\u540d\u79f0", hideempty2=true)
    public String getTextItem() {
        return this.strTextItem;
    }

    @PSModelRTMeta(description="\u53c2\u6570\u9879\u540d\u79f0", hideempty2=true)
    public String getParamItem() {
        return this.strParamItem;
    }

    @PSModelRTMeta(description="\u652f\u6301\u8fd0\u884c\u65f6\u6a21\u578b")
    public boolean isEnableRuntimeModel() {
        return this.bEnableRuntimeModel;
    }

    @PSModelRTMeta(description="\u5168\u5c40\u754c\u9762\u884c\u4e3a")
    public boolean isGlobalUIAction() {
        return this.bGlobalUIAction;
    }

    public void setGlobalUIAction(boolean bGlobalUIAction) {
        this.bGlobalUIAction = bGlobalUIAction;
    }

    public void setEnableRuntimeModel(boolean bEnableRuntimeModel) {
        this.bEnableRuntimeModel = bEnableRuntimeModel;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u540e\u5173\u95ed\u5f39\u51fa\u89c6\u56fe")
    public boolean isClosePopupView() {
        return this.bCloseEditView;
    }

    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u754c\u9762\u884c\u4e3a", hideempty=true)
    public IPSUIAction getNextPSUIAction() {
        return this.nextPSUIAction;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5b8c\u5168\u6807\u8bb0")
    public String getUIActionFullTag() {
        if (StringHelper.isNullOrEmpty((String)this.strUIActionFullTag)) {
            return this.getUIActionTag();
        }
        return this.strUIActionFullTag;
    }

    public boolean isFrontPDTView() {
        return this.bPDTFrontView;
    }

    public String getFrontPSSysPDTViewId() {
        return this.psDEUIAction.getPSSYSPDTVIEWID();
    }

    public IPSSysPDTView getPSSysPDTView() {
        return this.iPSSysPDTView;
    }

    @Override
    public IPSAppView getFrontPSAppView(Object obj) throws Exception {
        if (this.isFrontPDTView()) {
            String strFrontPSSysPDTViewId = this.getFrontPSSysPDTViewId();
            if (!StringHelper.isNullOrEmpty((String)strFrontPSSysPDTViewId)) {
                IPSApplication iPSApplication = PSSystemUtil.getRefPSApplication(obj, false);
                IPSSysPDTView iPSSysPDTView = this.getPSSystem().getPSSysPDTView(strFrontPSSysPDTViewId);
                return PSSystemUtil.getPSAppView(iPSApplication, iPSSysPDTView, false);
            }
        } else {
            String strFrontPSDEViewId = this.getFrontPSDEViewId(obj);
            if (!StringHelper.isNullOrEmpty((String)strFrontPSDEViewId)) {
                IPSApplication iPSApplication = PSSystemUtil.getRefPSApplication(obj, false);
                String strPSAppViewId = KeyValueHelper.genUniqueId((String)iPSApplication.getId(), (String)strFrontPSDEViewId);
                return ((IPSApplicationRuntime)iPSApplication).getPSAppView(strPSAppViewId, strFrontPSDEViewId);
            }
        }
        return null;
    }

    @Override
    public String getFrontPSDEViewId(Object obj) {
        return this.getFrontPSDEViewId();
    }

    public String getFrontPSDEViewId() {
        if (this.isFrontPDTView() && this.getPSSysPDTView() != null) {
            return this.getPSSysPDTView().getPSDEViewBaseId();
        }
        return this.psDEUIAction.getPSDEVIEWBASEID();
    }
}

