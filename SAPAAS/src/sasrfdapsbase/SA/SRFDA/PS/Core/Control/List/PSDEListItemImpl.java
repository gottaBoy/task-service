/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSDEListItem;
import SA.SRFDA.PS.Core.Control.List.IPSList;
import SA.SRFDA.PS.Core.Control.List.PSListItemImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSDEListItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEListItemImpl
extends PSListItemImpl
implements IPSDEListItem {
    private static final Log log = LogFactory.getLog(PSDEListItemImpl.class);
    private IPSDEList iPSDEList;
    private PSDEListItem psDEListItem;
    private String[] fields = null;
    private int nWidth = 150;
    private IPSCodeList iPSCodeList = null;
    private boolean bEnableSort = true;
    private String strWidthString = "";
    private boolean bHiddenDataItem = false;
    private IPSSysPFPlugin renderPSSysPFPlugin = null;
    private String strAlign = "LEFT";
    private String strValueFormat = "";
    private String strCLConvertMode = null;
    private boolean bEnableItemPriv = false;
    private String strItemPrivId = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private String strGroupItem = null;
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;
    private String strCaption = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEList iPSDEList, PSDEListItem psDEListItem) throws Exception {
        try {
            String strDataItems;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEList = iPSDEList;
            this.psDEListItem = psDEListItem;
            this.setId(this.psDEListItem.getPSDELISTITEMID());
            this.setName(this.psDEListItem.getPSDELISTITEMNAME());
            this.setPSObjectData(this.psDEListItem);
            boolean bUseDTO = false;
            if (this.getPSDEList() != null && this.getPSDEList().getPSAppView() != null && this.getPSDEList().getPSAppView().getPSApplication() != null) {
                bUseDTO = this.getPSDEList().getPSAppView().getPSApplication().isUseServiceApi();
            }
            this.iPSDEField = this.getPSDEList().getPSDataEntity().getPSDEField(this.getName(), true);
            if (this.iPSDEField != null && this.getPSDEList().getPSAppDataEntity() != null) {
                this.iPSAppDEField = this.getPSDEList().getPSAppDataEntity().getPSAppDEField(this.iPSDEField, true);
            }
            if (!StringHelper.isNullOrEmpty((String)(strDataItems = this.psDEListItem.getDATAITEMS()))) {
                strDataItems = strDataItems.toLowerCase();
                this.fields = StringHelper.splitEx((String)strDataItems);
            }
            if (this.psDEListItem.getWIDTH() > 0) {
                this.nWidth = this.psDEListItem.getWIDTH();
            }
            if (!this.psDEListItem.isNOSORTNull()) {
                this.bEnableSort = !this.psDEListItem.getNOSORT();
            } else {
                boolean bl = this.bEnableSort = this.getPSDEField() != null && !this.getPSDEList().isNoSort();
            }
            if (!StringHelper.isNullOrEmpty((String)psDEListItem.getPSCODELISTID())) {
                this.iPSCodeList = iPSDEList.getPSDataEntity().getPSSystem().getPSCodeList(psDEListItem.getPSCODELISTID());
            } else if (this.iPSDEField != null) {
                this.iPSCodeList = this.iPSDEField.getPSCodeList();
            }
            if (this.iPSCodeList != null) {
                this.iPSCodeList = iPSDEList.getPSAppView().getPSApplication().getPSCodeList(this.iPSCodeList, true);
                this.strCLConvertMode = psDEListItem.getCLCONVERTMODE();
                if (StringHelper.isNullOrEmpty((String)this.strCLConvertMode)) {
                    this.strCLConvertMode = "FRONT";
                } else if (StringHelper.compare((String)this.strCLConvertMode, (String)"NONE", (boolean)true) == 0) {
                    this.iPSCodeList = null;
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEListItem.getVALUEFORMAT())) {
                this.strValueFormat = this.psDEListItem.getVALUEFORMAT();
            } else if (this.iPSDEField != null) {
                this.strValueFormat = this.iPSDEField.getValueFormat();
                if (bUseDTO && this.iPSAppDEField != null) {
                    this.strValueFormat = this.iPSAppDEField.getValueFormat();
                }
            }
            this.strWidthString = StringHelper.compare((String)this.psDEListItem.getWIDTHUNIT(), (String)"PX", (boolean)true) == 0 || StringHelper.isNullOrEmpty((String)this.psDEListItem.getWIDTHUNIT()) ? (this.nWidth > 0 ? StringHelper.format((String)"%1$spx", (Object)this.nWidth) : "0px") : (this.nWidth > 1 ? StringHelper.format((String)"%1$s*", (Object)this.nWidth) : "*");
            this.strGroupItem = this.psDEListItem.getGROUPITEM();
            if (StringHelper.compare((String)psDEListItem.getITEMTYPE(), (String)"DATAITEM", (boolean)true) == 0) {
                this.bHiddenDataItem = true;
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEListItem.getLCRPSSYSPFPLUGINID())) {
                this.renderPSSysPFPlugin = this.getPSDEList().getPSAppView().getPSApplication() != null ? this.getPSDEList().getPSAppView().getPSApplication().getPSSysPFPlugin(this.psDEListItem.getLCRPSSYSPFPLUGINID(), "CONTROLITEM", this.getPSDEList().getControlType(), this.getItemType()) : this.getPSDEList().getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEListItem.getLCRPSSYSPFPLUGINID());
                this.getPSDEList().getPSAppView().registerPSSysPFPlugin(this.renderPSSysPFPlugin);
            }
            if (!StringHelper.isNullOrEmpty((String)psDEListItem.getALIGN())) {
                this.setAlign(psDEListItem.getALIGN());
            }
            if (this.iPSDEField != null) {
                this.bEnableItemPriv = this.iPSDEField.isEnablePrivilege();
            }
            if (!this.psDEListItem.isENABLEITEMPRIVNull()) {
                this.bEnableItemPriv = this.psDEListItem.getENABLEITEMPRIV();
            }
            if (this.bEnableItemPriv && this.iPSDEField != null) {
                this.strItemPrivId = StringHelper.format((String)"%1$s|%2$s", (Object)this.iPSDEField.getPSDataEntity().getName(), (Object)this.iPSDEField.getName());
            }
            this.strCaption = this.psDEListItem.getCAPTION();
            if (!StringHelper.isNullOrEmpty((String)this.psDEListItem.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDEList().getPSAppView().getPSApplication().getPSLanguageRes(this.psDEListItem.getCAPPSLANRESID());
            }
            if (this.getPSDEField() != null) {
                if (StringHelper.isNullOrEmpty((String)this.getCaption())) {
                    this.strCaption = this.getPSDEField().getLogicName();
                }
                if (this.getCapPSLanguageRes() == null) {
                    this.capPSLanguageRes = this.getPSDEField().getLNPSLanguageRes();
                }
            }
            this.onInit();
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
    protected void onInit() throws Exception {
        if (StringHelper.compare((String)this.getItemType(), (String)"ACTIONITEM", (boolean)false) == 0 && !StringHelper.isNullOrEmpty((String)this.psDEListItem.getPSDEUAGROUPID())) {
            Iterator psUIActionGroupDetails;
            if (this.iPSDEUIActionGroup == null && this.getPSDEList().getPSAppDataEntity() != null) {
                this.iPSDEUIActionGroup = this.getPSDEList().getPSAppDataEntity().getPSAppDEUIActionGroup(this.psDEListItem.getPSDEUAGROUPID(), true, this.getOwnedPSControl());
            }
            if (this.iPSDEUIActionGroup == null) {
                this.iPSDEUIActionGroup = this.getPSDEList().getPSDataEntity().getPSDEUIActionGroup(this.psDEListItem.getPSDEUAGROUPID());
            }
            if ((psUIActionGroupDetails = this.iPSDEUIActionGroup.getPSUIActionGroupDetails()) != null) {
                while (psUIActionGroupDetails.hasNext()) {
                    IPSUIActionGroupDetail iPSUIActionGroupDetail = (IPSUIActionGroupDetail)psUIActionGroupDetails.next();
                    IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                    if (iPSUIAction == null) continue;
                    if (this.getPSDEList().isPrepareTemplV2logic()) {
                        PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this.getPSDEList());
                        this.getPSDEList().registerPSAppViewUIAction(iPSAppViewUIAction);
                        this.registerPSAppViewLogic(iPSAppViewUIAction, iPSUIActionGroupDetail);
                        continue;
                    }
                    this.getPSDEList().getPSAppView().registerPSUIAction(iPSUIAction);
                }
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        return this.strCaption;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u7c7b\u578b", codelist="ListItemType", fields={"ITEMTYPE"})
    public String getItemType() {
        return this.psDEListItem.getITEMTYPE();
    }

    @Override
    public int getItemPos() {
        return this.psDEListItem.getORDERVALUE();
    }

    @Override
    public IPSList getPSList() {
        return this.iPSDEList;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5217\u8868")
    public IPSDEList getPSDEList() {
        return this.iPSDEList;
    }

    @Override
    public String[] getFields() {
        return this.fields;
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6", fields={"WIDTH"})
    public int getWidth() {
        return this.nWidth;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u9879\u540d\u79f0", fields={"PSDELISTITEMNAME"})
    public String getDataItemName() {
        return this.getName().toLowerCase();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEList.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6392\u5e8f", fields={"NOSORT"})
    public boolean isEnableSort() {
        return this.bEnableSort;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868")
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5217\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", modelattr="getPSSysPFPlugin", hideempty=true)
    public IPSSysPFPlugin getRenderPSSysPFPlugin() {
        return this.renderPSSysPFPlugin;
    }

    protected void setRenderPSSysPFPlugin(IPSSysPFPlugin renderPSSysPFPlugin) {
        this.renderPSSysPFPlugin = renderPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u9f50\u65b9\u5f0f", codelist="GridColAlign", fields={"ALIGN"})
    public String getAlign() {
        return this.strAlign;
    }

    protected void setAlign(String strAlign) {
        this.strAlign = strAlign;
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u6570\u636e\u9879", ignoredumpvalues="false", doc="\u8ba1\u7b97\u9879\u7c7b\u578b{@link #getItemType}\u662f\u5426\u4e3a\u6570\u636e\u9879(DATAITEM)")
    public boolean isHiddenDataItem() {
        return this.bHiddenDataItem;
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6\u4e32")
    public String getWidthString() {
        return this.strWidthString;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"VALUEFORMAT"})
    public String getValueFormat() {
        return this.strValueFormat;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u8f93\u51fa\u6a21\u5f0f", codelist="CLConvertModes", hideempty2=true, fields={"CLCONVERTMODE"})
    public String getCLConvertMode() {
        return this.strCLConvertMode;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u9879\u6743\u9650\u63a7\u5236", ignoredumpvalues="false", fields={"ENABLEITEMPRIV"})
    public boolean isEnableItemPriv() {
        return this.bEnableItemPriv;
    }

    protected void setEnableItemPriv(boolean bEnableItemPriv) {
        this.bEnableItemPriv = bEnableItemPriv;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6743\u9650\u6807\u8bc6")
    public String getItemPrivId() {
        return this.strItemPrivId;
    }

    protected void setItemPrivId(String strItemPrivId) {
        this.strItemPrivId = strItemPrivId;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5206\u7ec4\u9879", fields={"GROUPITEM"})
    public String getGroupItem() {
        return this.strGroupItem;
    }

    protected void setGroupItem(String strGroupItem) {
        this.strGroupItem = strGroupItem;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEList().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDELISTITEM";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEList() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEList().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true)
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSDEList();
    }

    @Override
    public String getFullModelName() {
        if (this.getOwnedPSControl() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getOwnedPSControl().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4", child=true, fields={"PSDEUAGROUPID"})
    public IPSDEUIActionGroup getPSDEUIActionGroup() {
        return this.iPSDEUIActionGroup;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.getPSDEUIActionGroup() == null) {
            return;
        }
        Iterator<IPSDEUIAction> psDEUIActions = this.getPSDEUIActionGroup().getPSDEUIActions();
        if (psDEUIActions != null) {
            while (psDEUIActions.hasNext()) {
                IPSDEUIAction iPSDEUIAction = psDEUIActions.next();
                if (iPSDEUIAction.getFrontPSAppView(this) == null) continue;
                relatedAppViewList.add(iPSDEUIAction.getFrontPSAppView(this));
            }
        }
    }

    protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
        String strCtrlName = this.getPSDEList().getName();
        String strLogicTag = StringHelper.format((String)"%1$s_%2$s_%3$s_click", (Object)strCtrlName, (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSDEList(), psAppViewLogic, iPSAppViewUIAction);
        this.getPSDEList().registerPSAppViewLogic(psAppDEViewLogicImpl);
    }

    @Override
    public boolean isCustomCode() {
        return this.psDEListItem.getCUSTOMMODE();
    }

    @Override
    public String getScriptCode() {
        if (this.isCustomCode()) {
            return this.psDEListItem.getCUSTOMCODE();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlLogic> getPSControlLogics() {
        return this.onGetPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
        return this.getOwnedPSControl().getPSControlLogicsByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
        return this.onGetPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
        return this.getOwnedPSControl().getPSControlAttributesByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7ed8\u5236\u5668\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlRender> getPSControlRenders() {
        return this.onGetPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        return this.getOwnedPSControl().getPSControlRendersByItemName(this.getName());
    }
}

