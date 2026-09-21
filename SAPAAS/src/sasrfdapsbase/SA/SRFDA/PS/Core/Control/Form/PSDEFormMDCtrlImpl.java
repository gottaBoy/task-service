/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTOField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodReturn;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.DataView.PSDEDataViewParamImpl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormMDCtrl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormBaseGroupPanelImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormParamImpl;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.List.PSDEListParamImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormMDCtrlImpl
extends PSDEFormBaseGroupPanelImpl
implements IPSDEFormMDCtrl {
    private static final Log log = LogFactory.getLog(PSDEFormMDCtrlImpl.class);
    private int nBuildInAction = 0;
    private String strContentType = null;
    private IPSControl contentPSControl = null;
    private IPSDER1N iPSDER1N = null;
    private IPSDEField iPSDEField = null;
    private String strResetItemName = null;
    private ArrayList<String> resetItemNameList = null;
    private IPSAppDEField iPSAppDEField = null;
    private boolean bOne2OneForm = false;
    private IPSUIActionGroup iPSUIActionGroup = null;
    private String strGroupExtractMode = "ITEM";
    private Properties ctrlParams = null;

    @Override
    protected void onInit() throws Exception {
        IPSAppDEMethodReturn iPSAppDEMethodReturn;
        IPSDEEditForm iPSDEEditForm;
        String strResetItemName;
        this.strContentType = this.psDEFormDetail.getMDCTRLTYPE();
        if (StringHelper.IsNullOrEmpty((String)this.getContentType())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u591a\u6570\u636e\u90e8\u4ef6\u7c7b\u578b");
        }
        if (!this.psDEFormDetail.isBUILDINACTIONNull()) {
            this.nBuildInAction = this.psDEFormDetail.getBUILDINACTION();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSDEUAGROUPID())) {
            Iterator<IPSUIActionGroupDetail> psUIActionGroupDetails;
            if (this.iPSUIActionGroup == null) {
                if (this.getPSDEForm().getPSAppDataEntity() != null) {
                    this.iPSUIActionGroup = this.getPSDEForm().getPSAppDataEntity().getPSAppDEUIActionGroup(this.psDEFormDetail.getPSDEUAGROUPID(), true, this.getOwnedPSControl());
                }
                if (this.iPSUIActionGroup == null) {
                    this.iPSUIActionGroup = this.getPSDEForm().getPSDataEntity().getPSDEUIActionGroup(this.psDEFormDetail.getPSDEUAGROUPID());
                }
            }
            if ((psUIActionGroupDetails = this.iPSUIActionGroup.getPSUIActionGroupDetails()) != null) {
                while (psUIActionGroupDetails.hasNext()) {
                    IPSUIActionGroupDetail iPSUIActionGroupDetail = psUIActionGroupDetails.next();
                    IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                    if (iPSUIAction == null) continue;
                    if (this.isPrepareTemplV2logic()) {
                        PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this.getPSDEForm());
                        this.getPSDEForm().registerPSAppViewUIAction(iPSAppViewUIAction);
                        this.registerPSAppViewLogic(iPSAppViewUIAction, iPSUIActionGroupDetail);
                        continue;
                    }
                    this.getPSDEForm().getPSAppView().registerPSUIAction(iPSUIAction);
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getUPDATEDVT())) {
                this.strGroupExtractMode = this.psDEFormDetail.getUPDATEDVT();
            }
        }
        if (!this.isRepeatContent()) {
            if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSDEFID())) {
                this.iPSDEField = this.getPSDEForm().getPSDataEntity().getPSDEField(this.psDEFormDetail.getPSDEFID(), false);
                if (this.iPSDEField != null && this.getPSAppDEField() == null && this.getPSDEForm().getPSAppDataEntity() != null) {
                    this.iPSAppDEField = this.getPSDEForm().getPSAppDataEntity().getPSAppDEField(this.iPSDEField.getId(), true);
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getREFPSDERID())) {
                this.iPSDER1N = this.getPSSystem().getPSDER1N(this.psDEFormDetail.getREFPSDERID());
            }
        }
        if (StringHelper.IsNullOrEmpty((String)(strResetItemName = this.psDEFormDetail.getRESETITEMNAME())) && this.getPSDEField() != null && this.getPSDEField().getRestrictedPSDEField() != null) {
            strResetItemName = this.getPSDEField().getRestrictedPSDEField().getName().toLowerCase();
        }
        if (!StringHelper.IsNullOrEmpty((String)strResetItemName)) {
            String[] items;
            this.resetItemNameList = new ArrayList();
            String[] stringArray = items = StringHelper.SplitEx((String)strResetItemName);
            int n = items.length;
            int iPSAppViewUIAction = 0;
            while (iPSAppViewUIAction < n) {
                String strItem = stringArray[iPSAppViewUIAction];
                if (!this.resetItemNameList.contains(strItem = strItem.trim())) {
                    this.resetItemNameList.add(strItem);
                    this.getPSDEForm().hookPSDEFormItem(strItem, this);
                }
                ++iPSAppViewUIAction;
            }
            if (this.resetItemNameList.size() > 0) {
                this.strResetItemName = this.resetItemNameList.get(0);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getEDITORPARAMS())) {
            this.ctrlParams = PropertiesHelper.load((String)this.psDEFormDetail.getEDITORPARAMS());
        }
        this.onPrepareContentPSControl();
        if (this.getPSAppDEField() != null && StringHelper.Compare((String)this.getContentType(), (String)"FORM", (boolean)true) == 0 && this.getPSDEForm() instanceof IPSDEEditForm && (iPSDEEditForm = (IPSDEEditForm)this.getPSDEForm()).getGetPSControlAction() != null && iPSDEEditForm.getGetPSControlAction().getPSAppDEMethod() != null && (iPSAppDEMethodReturn = iPSDEEditForm.getGetPSControlAction().getPSAppDEMethod().getPSAppDEMethodReturn()) != null && "DTO".equals(iPSAppDEMethodReturn.getType())) {
            try {
                IPSAppDEMethodDTOField iPSAppDEMethodDTOField;
                IPSAppDEMethodDTO iPSAppDEMethodDTO = iPSAppDEMethodReturn.getPSAppDEMethodDTO();
                if (iPSAppDEMethodDTO != null && (iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true)) != null && "DTO".equals(iPSAppDEMethodDTOField.getType())) {
                    this.bOne2OneForm = true;
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
                throw ex;
            }
        }
        super.onInit();
    }

    @Override
    protected void onPreparePSDEFormDetails() throws Exception {
        if (StringHelper.Compare((String)this.getContentType(), (String)"REPEATER", (boolean)true) == 0) {
            super.onPreparePSDEFormDetails();
            return;
        }
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_MDCTRL";
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u90e8\u4ef6", child=true)
    public IPSControl getContentPSControl() {
        return this.contentPSControl;
    }

    @Override
    @PSModelRTMeta(description="\u591a\u6570\u636e\u63a7\u5236\u5173\u7cfb")
    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5efa\u64cd\u4f5c", codelist="FormMDCtrlAction", ignoredumpvalues="0", fields={"BUILDINACTION"})
    public int getBuildInActions() {
        return this.nBuildInAction;
    }

    @Override
    public boolean isEnableBuildInAction(int nAction) {
        return (this.getBuildInActions() & nAction) == nAction;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", codelist="FormDetailMDCtrlType", fields={"MDCTRLTYPE"})
    public String getContentType() {
        return this.strContentType;
    }

    protected void onPrepareContentPSControl() throws Exception {
        if (StringHelper.Compare((String)this.getContentType(), (String)"REPEATER", (boolean)true) == 0) {
            return;
        }
        if (StringHelper.Compare((String)this.getContentType(), (String)"LIST", (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getMDPSDELISTID())) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5217\u8868\u5bf9\u8c61"));
            }
            PSDEListParamImpl psDEListParamImpl = new PSDEListParamImpl();
            psDEListParamImpl.setPSDEListId(this.psDEFormDetail.getMDPSDELISTID());
            psDEListParamImpl.setLocalMode(true);
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("LIST");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEListParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), this.getPSDEForm(), String.valueOf(this.getName()) + "_list", psDEListParamImpl);
            this.contentPSControl = iPSControl;
            return;
        }
        if (StringHelper.Compare((String)this.getContentType(), (String)"GRID", (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getMDPSDEGRIDID())) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u8868\u683c\u5bf9\u8c61"));
            }
            PSDEGridParamImpl psDEGridParamImpl = new PSDEGridParamImpl();
            psDEGridParamImpl.setPSDEGridId(this.psDEFormDetail.getMDPSDEGRIDID());
            psDEGridParamImpl.setLocalMode(true);
            psDEGridParamImpl.setEditMode(1);
            psDEGridParamImpl.setEnableRowEdit(true);
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("GRID");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEGridParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), this.getPSDEForm(), String.valueOf(this.getName()) + "_grid", psDEGridParamImpl);
            this.contentPSControl = iPSControl;
            return;
        }
        if (StringHelper.Compare((String)this.getContentType(), (String)"DATAVIEW", (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getMDPSDEDATAVIEWID())) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5361\u7247\u89c6\u56fe\u5bf9\u8c61"));
            }
            PSDEDataViewParamImpl psDEDataViewParamImpl = new PSDEDataViewParamImpl();
            psDEDataViewParamImpl.setPSDEDataViewId(this.psDEFormDetail.getMDPSDEDATAVIEWID());
            psDEDataViewParamImpl.setLocalMode(true);
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("DATAVIEW");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEDataViewParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), this.getPSDEForm(), String.valueOf(this.getName()) + "_dataview", psDEDataViewParamImpl);
            this.contentPSControl = iPSControl;
            return;
        }
        if (StringHelper.Compare((String)this.getContentType(), (String)"FORM", (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getMDPSDEFORMID())) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u8868\u5355\u5bf9\u8c61"));
            }
            PSDEFormParamImpl psDEFormParamImpl = new PSDEFormParamImpl();
            psDEFormParamImpl.setPSDEFormId(this.psDEFormDetail.getMDPSDEFORMID());
            psDEFormParamImpl.setLocalMode(true);
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("FORM");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEFormParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), this.getPSDEForm(), String.valueOf(this.getName()) + "_form", psDEFormParamImpl);
            this.contentPSControl = iPSControl;
            return;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5185\u5bb9\u90e8\u4ef6\u7c7b\u578b[%1$s]", (Object)this.getContentType()));
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u540d\u79f0", hideempty2=true, ignorert=3)
    public String getResetItemName() {
        return this.strResetItemName;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u540d\u79f0\u96c6\u5408", child=true, hideempty2=true, fields={"RESETITEMNAME"})
    public Iterator<String> getResetItemNames() {
        if (this.resetItemNameList == null || this.resetItemNameList.size() == 0) {
            return null;
        }
        return this.resetItemNameList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, fields={"PSDEFID"})
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="1:1\u6570\u636e\u8868\u5355", ignoredumpvalues="false")
    public boolean isOne2OneForm() {
        return this.bOne2OneForm;
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u5c5e\u6027", fields={"FIELDNAME"})
    public String getFieldName() {
        return this.psDEFormDetail.getFIELDNAME();
    }

    @Override
    public String getPSDEFIUpdateId() {
        return this.psDEFormDetail.getPSDEFIUPDATEID();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8868\u5355\u9879\u66f4\u65b0", hideempty=true, dumpref=true, from="IPSDEForm", fields={"PSDEFIUPDATEID"})
    public IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEFIUpdateId())) {
            return null;
        }
        return this.getPSDEForm().getPSDEFormItemUpdate(this.getPSDEFIUpdateId());
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61", child=true, fields={"PSDEUAGROUPID"})
    public IPSUIActionGroup getPSUIActionGroup() {
        return this.iPSUIActionGroup;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5c55\u5f00\u6a21\u5f0f", codelist="UGExtractMode", fields={"UPDATEDVT"})
    public String getActionGroupExtractMode() {
        if (this.getPSUIActionGroup() == null) {
            return null;
        }
        return this.strGroupExtractMode;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f", codelist="FormTitleBarCloseMode", ignoredumpvalues="0", fields={"TITLEBARCLOSEMODE"})
    public int getTitleBarCloseMode() {
        return super.getTitleBarCloseMode();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u53c2\u6570\u96c6\u5408")
    public Properties getCtrlParams() {
        return this.ctrlParams;
    }
}

