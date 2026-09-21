/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.DataView;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSDEDataViewItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataViewItemImpl
extends PSObjectImpl
implements IPSDEDataViewItem {
    private static final Log log = LogFactory.getLog(PSDEDataViewItemImpl.class);
    private IPSDEDataView iPSDEDataView;
    private PSDEDataViewItem psDEDataViewItem;
    private String[] fields = null;
    private IPSCodeList iPSCodeList = null;
    private String strCLConvertMode = null;
    private String strValueFormat = "";
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;
    private boolean bEnableSort = false;
    private IPSLanguageRes capPSLanguageRes = null;
    private String strCaption = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;
    private String strItemType = "DATAITEM";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataView iPSDEDataView, PSDEDataViewItem psDEDataViewItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataView = iPSDEDataView;
            this.psDEDataViewItem = psDEDataViewItem;
            this.setId(this.psDEDataViewItem.getPSDELISTITEMID());
            this.setName(this.psDEDataViewItem.getPSDELISTITEMNAME());
            this.setPSObjectData(this.psDEDataViewItem);
            if (!StringHelper.isNullOrEmpty((String)psDEDataViewItem.getITEMTYPE())) {
                this.strItemType = psDEDataViewItem.getITEMTYPE();
            }
            boolean bUseDTO = false;
            if (this.getPSDEDataView() != null && this.getPSDEDataView().getPSAppView() != null && this.getPSDEDataView().getPSAppView().getPSApplication() != null) {
                bUseDTO = this.getPSDEDataView().getPSAppView().getPSApplication().isUseServiceApi();
            }
            this.iPSDEField = this.getPSDEDataView().getPSDataEntity().getPSDEField(this.getName(), true);
            if (this.iPSDEField != null && this.getPSDEDataView().getPSAppDataEntity() != null) {
                this.iPSAppDEField = this.getPSDEDataView().getPSAppDataEntity().getPSAppDEField(this.iPSDEField, true);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDataViewItem.getVALUEFORMAT())) {
                this.strValueFormat = this.psDEDataViewItem.getVALUEFORMAT();
            } else if (this.iPSDEField != null && bUseDTO && this.iPSAppDEField != null) {
                this.strValueFormat = this.iPSAppDEField.getValueFormat();
            }
            String strDataItems = this.psDEDataViewItem.getDATAITEMS();
            if (!StringHelper.isNullOrEmpty((String)strDataItems)) {
                strDataItems = strDataItems.toLowerCase();
                this.fields = StringHelper.splitEx((String)strDataItems);
            }
            if (!this.psDEDataViewItem.isNOSORTNull()) {
                this.bEnableSort = !this.psDEDataViewItem.getNOSORT();
            } else {
                boolean bl = this.bEnableSort = this.getPSDEField() != null && !this.getPSDEDataView().isNoSort();
            }
            if (!StringHelper.isNullOrEmpty((String)psDEDataViewItem.getPSCODELISTID())) {
                this.iPSCodeList = iPSDEDataView.getPSDataEntity().getPSSystem().getPSCodeList(psDEDataViewItem.getPSCODELISTID());
            } else if (this.iPSDEField != null) {
                this.iPSCodeList = this.iPSDEField.getPSCodeList();
            }
            if (this.iPSCodeList != null) {
                this.iPSCodeList = iPSDEDataView.getPSAppView().getPSApplication().getPSCodeList(this.iPSCodeList, true);
            }
            if (this.iPSCodeList != null) {
                this.strCLConvertMode = psDEDataViewItem.getCLCONVERTMODE();
                if (StringHelper.isNullOrEmpty((String)this.strCLConvertMode)) {
                    this.strCLConvertMode = "FRONT";
                }
            }
            this.strCaption = this.psDEDataViewItem.getCAPTION();
            if (!StringHelper.isNullOrEmpty((String)this.psDEDataViewItem.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDEDataView().getPSAppView().getPSApplication().getPSLanguageRes(this.psDEDataViewItem.getCAPPSLANRESID());
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
        if (StringHelper.compare((String)this.getItemType(), (String)"ACTIONITEM", (boolean)false) == 0 && !StringHelper.isNullOrEmpty((String)this.psDEDataViewItem.getPSDEUAGROUPID())) {
            Iterator psUIActionGroupDetails;
            if (this.iPSDEUIActionGroup == null && this.getPSDEDataView().getPSAppDataEntity() != null) {
                this.iPSDEUIActionGroup = this.getPSDEDataView().getPSAppDataEntity().getPSAppDEUIActionGroup(this.psDEDataViewItem.getPSDEUAGROUPID(), true, this.getOwnedPSControl());
            }
            if (this.iPSDEUIActionGroup == null) {
                this.iPSDEUIActionGroup = this.getPSDEDataView().getPSDataEntity().getPSDEUIActionGroup(this.psDEDataViewItem.getPSDEUAGROUPID());
            }
            if ((psUIActionGroupDetails = this.iPSDEUIActionGroup.getPSUIActionGroupDetails()) != null) {
                while (psUIActionGroupDetails.hasNext()) {
                    IPSUIActionGroupDetail iPSUIActionGroupDetail = (IPSUIActionGroupDetail)psUIActionGroupDetails.next();
                    IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                    if (iPSUIAction == null) continue;
                    if (this.getPSDEDataView().isPrepareTemplV2logic()) {
                        PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this.getPSDEDataView());
                        this.getPSDEDataView().registerPSAppViewUIAction(iPSAppViewUIAction);
                        this.registerPSAppViewLogic(iPSAppViewUIAction, iPSUIActionGroupDetail);
                        continue;
                    }
                    this.getPSDEDataView().getPSAppView().registerPSUIAction(iPSUIAction);
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
    @PSModelRTMeta(description="\u5b9e\u4f53\u5361\u7247\u89c6\u56fe")
    public IPSDEDataView getPSDEDataView() {
        return this.iPSDEDataView;
    }

    @Override
    public String[] getFields() {
        return this.fields;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u9879\u540d\u79f0", fields={"PSDELISTITEMNAME"})
    public String getDataItemName() {
        return this.getName().toLowerCase();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataView.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868", dumpref=true, fields={"PSCODELISTID"})
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"VALUEFORMAT"})
    public String getValueFormat() {
        return this.strValueFormat;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u8f6c\u6362\u6a21\u5f0f", codelist="CLConvertModes", fields={"CLCONVERTMODE"})
    public String getCLConvertMode() {
        return this.strCLConvertMode;
    }

    @Override
    public String getModelType() {
        return "PSDEDATAVIEWITEM";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEDataView() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEDataView().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataView().getPSAppView().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, doc="\u5c1d\u8bd5\u4f7f\u7528\u9879\u540d\u79f0\u8fdb\u884c\u5c5e\u6027\u83b7\u53d6")
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6392\u5e8f", fields={"NOSORT"})
    public boolean isEnableSort() {
        return this.bEnableSort;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSDEDataView();
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
        String strCtrlName = this.getPSDEDataView().getName();
        String strLogicTag = StringHelper.format((String)"%1$s_%2$s_%3$s_click", (Object)strCtrlName, (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSDEDataView(), psAppViewLogic, iPSAppViewUIAction);
        this.getPSDEDataView().registerPSAppViewLogic(psAppDEViewLogicImpl);
    }

    @Override
    @PSModelRTMeta(description="\u9879\u7c7b\u578b", codelist="ListItemType")
    public String getItemType() {
        return this.strItemType;
    }

    @Override
    public boolean isCustomCode() {
        return this.psDEDataViewItem.getCUSTOMMODE();
    }

    @Override
    public String getScriptCode() {
        if (this.isCustomCode()) {
            return this.psDEDataViewItem.getCUSTOMCODE();
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

