/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.BuiltinPSAppUINewDataLogicImpl;
import SA.SRFDA.PS.Core.App.Logic.BuiltinPSAppUIOpenDataLogicImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppDEXDataViewImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Form.IPSDESearchForm;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControl;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBar;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERNN;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEMultiDataViewImpl
extends PSAppDEXDataViewImpl
implements IPSAppDEMultiDataView {
    private static final Log log = LogFactory.getLog(PSAppDEMultiDataViewImpl.class);
    protected String strNewDataMode = "";
    protected String strEditDataMode = "";
    private boolean bEnableBatchAdd = false;
    private boolean bBatchAddOnly = false;
    private boolean bEnableQuickSearch = true;
    private boolean bEnableQuickSearchDefault = true;
    private IPSDESearchForm iPSDESearchForm = null;
    private boolean bExpandSearchFormDefault = false;
    private boolean bExpandSearchForm = false;
    private String strActionAfterNewDataWizard = "DEFAULT";
    private IPSCodeList quickGroupPSCodeList = null;
    private IPSDESearchForm quickPSDESearchForm = null;
    private IPSSearchBar iPSSearchBar = null;

    @Override
    protected void onInit() throws Exception {
        this.strNewDataMode = this.psViewBase.getVIEWPARAM();
        this.strEditDataMode = this.psViewBase.getVIEWPARAM2();
        if (StringHelper.Compare((String)this.strNewDataMode, (String)"WIZARD2", (boolean)true) == 0) {
            this.strNewDataMode = "WIZARD";
            this.strActionAfterNewDataWizard = "OPENDATA";
        }
        this.bEnableQuickSearch = this.isEnableQuickSearchDefault();
        if (!this.psViewBase.isVIEWPARAM5Null()) {
            this.bEnableQuickSearch = this.psViewBase.getVIEWPARAM5();
        }
        this.bExpandSearchForm = this.isExpandSearchFormDefault();
        if (!this.psViewBase.isVIEWPARAM10Null()) {
            boolean bl = this.bExpandSearchForm = this.psViewBase.getVIEWPARAM10() == 1;
        }
        if (!this.isPickupMode()) {
            if (StringHelper.IsNullOrEmpty((String)this.strNewDataMode)) {
                if (this.getPSDataEntity().getDEType() == 3) {
                    this.strNewDataMode = "ENABATADD";
                } else if (!StringHelper.IsNullOrEmpty((String)this.getPSDataEntity().getIndexDEType())) {
                    this.strNewDataMode = "INDEXDE";
                } else if (this.getPSDataEntity().isEnableMultiForm()) {
                    this.strNewDataMode = "MULTIFORM";
                }
            }
            if (StringHelper.IsNullOrEmpty((String)this.strEditDataMode) && StringHelper.Compare((String)this.strNewDataMode, (String)"WIZARD", (boolean)true) != 0) {
                this.strEditDataMode = this.strNewDataMode;
            }
            if (StringHelper.IsNullOrEmpty((String)this.strNewDataMode)) {
                this.strNewDataMode = "NORMAL";
            }
            if (StringHelper.IsNullOrEmpty((String)this.strEditDataMode)) {
                this.strEditDataMode = "NORMAL";
            }
            if (StringHelper.Compare((String)this.getNewDataMode(), (String)"ENABATADD", (boolean)true) == 0) {
                this.bEnableBatchAdd = true;
            }
            if (StringHelper.Compare((String)this.getNewDataMode(), (String)"BATADDONLY", (boolean)true) == 0) {
                this.bEnableBatchAdd = true;
                this.bBatchAddOnly = true;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psViewBase.getGROUPPSCODELISTID())) {
            this.quickGroupPSCodeList = this.getPSApplication().getPSAppCodeList(this.psViewBase.getGROUPPSCODELISTID());
        }
        super.onInit();
        if ((this.isEnableUIModelEx() || this.getPSSysViewLayoutPanel() != null && this.getPSSysViewLayoutPanel().isViewProxyMode()) && this.getPSSearchBar() == null) {
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEVIEWCTRLID("searchbar");
            psDEViewCtrl.setPSDEVIEWCTRLNAME("searchbar");
            psDEViewCtrl.setPSSYSSEARCHBARID("SRFCURRENTVIEW");
            psDEViewCtrl.setPSDEVIEWCTRLTYPE("SEARCHBAR");
            IPSControl iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl);
            if (iPSControl instanceof IPSSearchBar) {
                this.iPSSearchBar = (IPSSearchBar)iPSControl;
            }
        }
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("searchbar");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSSearchBar) {
            this.iPSSearchBar = (IPSSearchBar)iPSControl;
        }
        if ((psDEViewCtrl = psDEViewCtrlMap.remove("quicksearchform")) != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDESearchForm) {
            this.quickPSDESearchForm = (IPSDESearchForm)iPSControl;
        }
        if ((psDEViewCtrl = psDEViewCtrlMap.remove("searchform")) != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDESearchForm) {
            this.iPSDESearchForm = (IPSDESearchForm)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u9009\u62e9\u89c6\u56fe", ignoredumpvalues="false")
    public boolean isPickupMode() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u65b0\u5efa\u6570\u636e\u6a21\u5f0f", codelist="DEGridViewNewDataMode", dump=false)
    public String getNewDataMode() {
        return this.strNewDataMode;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u6570\u636e\u6a21\u5f0f", codelist="DEGridViewEditDataMode", dump=false)
    public String getEditDataMode() {
        return this.strEditDataMode;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6279\u6dfb\u52a0", dump=false)
    public boolean isEnableBatchAdd() {
        if (!this.isEnableNewData()) {
            return false;
        }
        return this.bEnableBatchAdd;
    }

    @Override
    @PSModelRTMeta(description="\u53ea\u652f\u6301\u6279\u6dfb\u52a0", dump=false)
    public boolean isBatchAddOnly() {
        return this.bBatchAddOnly;
    }

    @Override
    protected void onPreparePSAppViewRefs() throws Exception {
        super.onPreparePSAppViewRefs();
        this.onPreparePSAppDEMultiDataViewRefs();
    }

    protected void onPreparePSAppDEMultiDataViewRefs() throws Exception {
        String strPDTParam;
        IPSAppView iPSAppView;
        String strViewRefModeDesc;
        String strViewRefMode;
        PSAppViewRef psAppViewRef;
        String strPSAppDEViewId;
        String strViewRefMode2;
        IPSDataEntity minorPSDataEntity;
        IPSDERIndex iPSDERIndex;
        Iterator<IPSDERIndex> psDERIndexs;
        String strInfo;
        PSDEViewBase psDEViewBase;
        Iterator<PSDEViewBase> psDEViewBases;
        PSAppViewRef psAppViewRef2;
        String strPSAppDEViewId2;
        String strViewRefMode3;
        String strPDTParam2;
        IPSCodeItem iPSCodeItem;
        PSDEViewBase psDEViewBase2;
        Iterator<IPSCodeItem> psCodeItems;
        IPSCodeList mfPSCodeList;
        IPSDEField mfPSDEField;
        PSAppViewRef psAppViewRef3;
        String strPSAppDEViewId3;
        PSDEViewBase psDEViewBase3;
        String strViewRefModeDesc2;
        String strInfo2;
        IPSDEField iPSDEField;
        String strPDTHeader = "";
        String strPDTParamPre = this.getPDTParamPre();
        if (!this.isBatchAddOnly() && this.isEnableNewData()) {
            if (StringHelper.Compare((String)this.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 || StringHelper.Compare((String)this.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                iPSDEField = null;
                iPSDEField = StringHelper.Compare((String)this.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? this.getPSDataEntity().getFormTypePSDEField() : this.getPSDataEntity().getIndexTypePSDEField();
                if (iPSDEField == null) {
                    strInfo2 = StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u6570\u636e\u5206\u7c7b\u5c5e\u6027", (Object)this.getPSDataEntity().getName());
                    log.warn((Object)strInfo2);
                    this.getPSApplicationRuntime().log(4, this, strInfo2);
                }
                if (this.getPSAppViewRef("NEWDATAWIZARD", true) == null) {
                    String strEditViewTag = "";
                    strViewRefModeDesc2 = "";
                    if (StringHelper.Compare((String)this.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0) {
                        strEditViewTag = this.isMobileView() ? "MOBFORMPICKUPVIEW" : "FORMPICKUPVIEW";
                        strViewRefModeDesc2 = "\u65b0\u5efa\u5411\u5bfc\u89c6\u56fe|\u591a\u8868\u5355\u9009\u62e9\u89c6\u56fe";
                    } else {
                        strEditViewTag = this.isMobileView() ? "MOBINDEXDEPICKUPVIEW" : "INDEXDEPICKUPVIEW";
                        strViewRefModeDesc2 = "\u65b0\u5efa\u5411\u5bfc\u89c6\u56fe|\u7d22\u5f15/\u7ee7\u627f\u5173\u7cfb\u9009\u62e9\u89c6\u56fe";
                    }
                    psDEViewBase3 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + strEditViewTag, true);
                    if (psDEViewBase3 != null) {
                        strPSAppDEViewId3 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                        psAppViewRef3 = new PSAppViewRef();
                        psAppViewRef3.setPSAPPVIEWREFNAME("NEWDATAWIZARD");
                        psAppViewRef3.setREFMODETEXT(strViewRefModeDesc2);
                        psAppViewRef3.setMINORPSAPPVIEWID(strPSAppDEViewId3);
                        psAppViewRef3.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                        this.registerPSAppViewRef(psAppViewRef3);
                    } else {
                        strPSAppDEViewId3 = StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u9884\u7f6e\u89c6\u56fe[%2$s]", (Object)this.getPSDataEntity().getName(), (Object)strEditViewTag);
                    }
                }
                if (StringHelper.Compare((String)this.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0) {
                    mfPSDEField = this.getPSDataEntity().getFormTypePSDEField();
                    if (mfPSDEField != null && mfPSDEField.getPSCodeList() != null) {
                        mfPSCodeList = mfPSDEField.getPSCodeList();
                        psCodeItems = mfPSCodeList.getPSCodeItems();
                        if (psCodeItems != null) {
                            while (psCodeItems.hasNext()) {
                                psDEViewBase2 = null;
                                iPSCodeItem = psCodeItems.next();
                                if (this.isEnableWF()) {
                                    strPDTParam2 = StringHelper.Format((String)"%1$s:%2$s:D", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName());
                                    psDEViewBase2 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam2, true);
                                }
                                if (psDEViewBase2 == null) {
                                    strPDTParam2 = StringHelper.Format((String)"%1$s", (Object)iPSCodeItem.getValue());
                                    psDEViewBase2 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), strPDTParamPre, strPDTParam2, true);
                                }
                                if (psDEViewBase2 == null) continue;
                                strViewRefMode3 = "";
                                if (!this.isEnableNewData()) continue;
                                strViewRefMode3 = StringHelper.Format((String)"%1$s:%2$s", (Object)"NEWDATA", (Object)iPSCodeItem.getValue());
                                if (this.getPSAppViewRef(strViewRefMode3 = strViewRefMode3.toUpperCase(), true) != null) continue;
                                strPSAppDEViewId2 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                psAppViewRef2 = new PSAppViewRef();
                                psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode3);
                                psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                                psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                psAppViewRef2.setParamValue("TRYMODE", true);
                                this.registerPSAppViewRef(psAppViewRef2);
                            }
                        } else {
                            psDEViewBases = this.getPSDataEntity().getPSDEViewDatasByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"));
                            if (psDEViewBases != null) {
                                while (psDEViewBases.hasNext()) {
                                    psDEViewBase = psDEViewBases.next();
                                    if (StringHelper.IsNullOrEmpty((String)psDEViewBase.getPDVTPARAM())) continue;
                                    strViewRefMode3 = "";
                                    if (!this.isEnableNewData()) continue;
                                    strViewRefMode3 = StringHelper.Format((String)"%1$s:%2$s", (Object)"NEWDATA", (Object)psDEViewBase.getPDVTPARAM());
                                    if (this.getPSAppViewRef(strViewRefMode3 = strViewRefMode3.toUpperCase(), true) != null) continue;
                                    strPSAppDEViewId2 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                                    psAppViewRef2 = new PSAppViewRef();
                                    psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode3);
                                    psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                                    psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                                    psAppViewRef2.setParamValue("TRYMODE", true);
                                    this.registerPSAppViewRef(psAppViewRef2);
                                }
                            }
                        }
                    } else {
                        strInfo = StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u591a\u8868\u5355\u8bc6\u522b\u5c5e\u6027\u6216\u76f8\u5e94\u4ee3\u7801\u8868", (Object)this.getPSDataEntity().getName());
                        log.warn((Object)strInfo);
                        this.getPSApplicationRuntime().log(4, this, strInfo);
                    }
                }
                if (StringHelper.Compare((String)this.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0 && (psDERIndexs = this.getPSDataEntity().getPSDERIndexs(true)) != null) {
                    while (psDERIndexs.hasNext()) {
                        iPSDERIndex = psDERIndexs.next();
                        minorPSDataEntity = iPSDERIndex.getMinorPSDataEntity();
                        strViewRefMode2 = StringHelper.Format((String)"%1$s:%2$s", (Object)"NEWDATA", (Object)iPSDERIndex.getTypeValue());
                        if (this.getPSAppViewRef(strViewRefMode2, true) != null || (psDEViewBase = minorPSDataEntity.getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), true)) == null) continue;
                        strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                        psAppViewRef = new PSAppViewRef();
                        psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                        psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                        psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                        this.registerPSAppViewRef(psAppViewRef);
                    }
                }
            }
            strViewRefMode = StringHelper.Format((String)"%1$s", (Object)"NEWDATA");
            strViewRefModeDesc = "\u65b0\u5efa\u89c6\u56fe";
            iPSAppView = this.getRefPSAppView(strViewRefMode, true);
            if (iPSAppView == null) {
                psDEViewBase3 = null;
                if (this.isEnableWF()) {
                    if (!this.isWFIAMode()) {
                        strPDTParam = StringHelper.Format((String)"%1$s:D", (Object)this.getPSDEWF().getCodeName());
                        strPDTParam = strPDTParam.toUpperCase();
                        psDEViewBase3 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam, true);
                    }
                } else {
                    psDEViewBase3 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), "", true);
                }
                if (psDEViewBase3 != null) {
                    strPSAppDEViewId3 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                    psAppViewRef3 = new PSAppViewRef();
                    psAppViewRef3.setPSAPPVIEWREFNAME(strViewRefMode);
                    psAppViewRef3.setREFMODETEXT(strViewRefModeDesc);
                    psAppViewRef3.setMINORPSAPPVIEWID(strPSAppDEViewId3);
                    psAppViewRef3.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                    psAppViewRef3.setParamValue("TRYMODE", true);
                    this.registerPSAppViewRef(psAppViewRef3);
                }
            }
        }
        if (this.isEnableEditData() || this.isEnableViewData()) {
            Iterator<IPSDEMainState> psDEMainStates;
            String strPDTParam3;
            if (StringHelper.Compare((String)this.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0 || StringHelper.Compare((String)this.getEditDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                iPSDEField = null;
                iPSDEField = StringHelper.Compare((String)this.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? this.getPSDataEntity().getFormTypePSDEField() : this.getPSDataEntity().getIndexTypePSDEField();
                if (iPSDEField == null) {
                    strInfo2 = StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u6570\u636e\u5206\u7c7b\u5c5e\u6027", (Object)this.getPSDataEntity().getName());
                    log.warn((Object)strInfo2);
                    this.getPSApplicationRuntime().log(4, this, strInfo2);
                }
                if (StringHelper.Compare((String)this.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0) {
                    mfPSDEField = this.getPSDataEntity().getFormTypePSDEField();
                    if (mfPSDEField != null && mfPSDEField.getPSCodeList() != null) {
                        mfPSCodeList = mfPSDEField.getPSCodeList();
                        psCodeItems = mfPSCodeList.getPSCodeItems();
                        if (psCodeItems != null) {
                            while (psCodeItems.hasNext()) {
                                psDEViewBase2 = null;
                                iPSCodeItem = psCodeItems.next();
                                if (this.isWFIAMode()) {
                                    if (StringHelper.IsNullOrEmpty((String)this.getWFStepValue())) {
                                        IPSCodeList wfStepPSCodeList = this.getPSDEWF().getWFStepPSCodeList();
                                        Iterator<IPSCodeItem> psCodeItems2 = wfStepPSCodeList.getPSCodeItems();
                                        while (psCodeItems2.hasNext()) {
                                            IPSCodeItem wfStepCodeItem = psCodeItems2.next();
                                            Iterator<IPSWFVersion> psWFVersions = this.getPSWorkflow().getPSWFVersions();
                                            if (psWFVersions == null) continue;
                                            while (psWFVersions.hasNext()) {
                                                PSAppViewRef psAppViewRef4;
                                                String strPSAppDEViewId4;
                                                String strViewRefMode4;
                                                String strPDTParam4;
                                                IPSWFVersion iPSWFVersion = psWFVersions.next();
                                                if (iPSWFVersion.getWFVersion() == 1) {
                                                    strPDTParam4 = StringHelper.Format((String)"%1$s:%2$s:W:%3$s", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName(), (Object)wfStepCodeItem.getValue());
                                                    psDEViewBase2 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam4, true);
                                                    if (psDEViewBase2 != null) {
                                                        strViewRefMode4 = "";
                                                        strViewRefMode4 = StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)"EDITDATA", (Object)iPSCodeItem.getValue(), (Object)wfStepCodeItem.getValue());
                                                        if (this.getPSAppViewRef(strViewRefMode4 = strViewRefMode4.toUpperCase(), true) == null) {
                                                            strPSAppDEViewId4 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                                            psAppViewRef4 = new PSAppViewRef();
                                                            psAppViewRef4.setPSAPPVIEWREFNAME(strViewRefMode4);
                                                            psAppViewRef4.setMINORPSAPPVIEWID(strPSAppDEViewId4);
                                                            psAppViewRef4.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                                            this.registerPSAppViewRef(psAppViewRef4);
                                                        }
                                                    }
                                                }
                                                strPDTParam4 = StringHelper.Format((String)"%1$s:%2$s:%4$sW:%3$s", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName(), (Object)wfStepCodeItem.getValue(), (Object)(iPSWFVersion.getWFVersion() == 1 ? "" : Integer.valueOf(iPSWFVersion.getWFVersion())));
                                                psDEViewBase2 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam4, true);
                                                if (psDEViewBase2 == null) continue;
                                                strViewRefMode4 = "";
                                                strViewRefMode4 = StringHelper.Format((String)"%1$s:%2$s:%3$s@%4$s", (Object)"EDITDATA", (Object)iPSCodeItem.getValue(), (Object)wfStepCodeItem.getValue(), (Object)iPSWFVersion.getWFVersion());
                                                if (this.getPSAppViewRef(strViewRefMode4 = strViewRefMode4.toUpperCase(), true) != null) continue;
                                                strPSAppDEViewId4 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                                psAppViewRef4 = new PSAppViewRef();
                                                psAppViewRef4.setPSAPPVIEWREFNAME(strViewRefMode4);
                                                psAppViewRef4.setMINORPSAPPVIEWID(strPSAppDEViewId4);
                                                psAppViewRef4.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                                this.registerPSAppViewRef(psAppViewRef4);
                                            }
                                        }
                                    } else {
                                        Iterator<IPSWFVersion> psWFVersions = this.getPSWorkflow().getPSWFVersions();
                                        if (psWFVersions != null) {
                                            while (psWFVersions.hasNext()) {
                                                PSAppViewRef psAppViewRef5;
                                                String strPSAppDEViewId5;
                                                String strViewRefMode5;
                                                String strPDTParam5;
                                                IPSWFVersion iPSWFVersion = psWFVersions.next();
                                                if (iPSWFVersion.getWFVersion() == 1) {
                                                    strPDTParam5 = StringHelper.Format((String)"%1$s:%2$s:W:%3$s", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName(), (Object)this.getWFStepValue());
                                                    psDEViewBase2 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam5, true);
                                                    if (psDEViewBase2 != null) {
                                                        strViewRefMode5 = "";
                                                        strViewRefMode5 = StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)"EDITDATA", (Object)iPSCodeItem.getValue(), (Object)this.getWFStepValue());
                                                        if (this.getPSAppViewRef(strViewRefMode5 = strViewRefMode5.toUpperCase(), true) == null) {
                                                            strPSAppDEViewId5 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                                            psAppViewRef5 = new PSAppViewRef();
                                                            psAppViewRef5.setPSAPPVIEWREFNAME(strViewRefMode5);
                                                            psAppViewRef5.setMINORPSAPPVIEWID(strPSAppDEViewId5);
                                                            psAppViewRef5.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                                            this.registerPSAppViewRef(psAppViewRef5);
                                                        }
                                                    }
                                                }
                                                strPDTParam5 = StringHelper.Format((String)"%1$s:%2$s:%4$sW:%3$s", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName(), (Object)this.getWFStepValue(), (Object)(iPSWFVersion.getWFVersion() == 1 ? "" : Integer.valueOf(iPSWFVersion.getWFVersion())));
                                                psDEViewBase2 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam5, true);
                                                if (psDEViewBase2 == null) continue;
                                                strViewRefMode5 = "";
                                                strViewRefMode5 = StringHelper.Format((String)"%1$s:%2$s:%3$s@%4$s", (Object)"EDITDATA", (Object)iPSCodeItem.getValue(), (Object)this.getWFStepValue(), (Object)iPSWFVersion.getWFVersion());
                                                if (this.getPSAppViewRef(strViewRefMode5 = strViewRefMode5.toUpperCase(), true) != null) continue;
                                                strPSAppDEViewId5 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                                psAppViewRef5 = new PSAppViewRef();
                                                psAppViewRef5.setPSAPPVIEWREFNAME(strViewRefMode5);
                                                psAppViewRef5.setMINORPSAPPVIEWID(strPSAppDEViewId5);
                                                psAppViewRef5.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                                this.registerPSAppViewRef(psAppViewRef5);
                                            }
                                        }
                                    }
                                }
                                if (this.isEnableWF()) {
                                    strPDTParam2 = StringHelper.Format((String)"%1$s:%2$s:D", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName());
                                    psDEViewBase2 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam2, true);
                                }
                                if (psDEViewBase2 == null) {
                                    strPDTParam2 = StringHelper.Format((String)"%1$s", (Object)iPSCodeItem.getValue());
                                    psDEViewBase2 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), strPDTParamPre, strPDTParam2, true);
                                }
                                if (psDEViewBase2 == null) continue;
                                strViewRefMode3 = "";
                                if (!this.isEnableEditData() && !this.isEnableViewData() || this.isWFIAMode()) continue;
                                strViewRefMode3 = StringHelper.Format((String)"%1$s:%2$s", (Object)"EDITDATA", (Object)iPSCodeItem.getValue());
                                if (this.getPSAppViewRef(strViewRefMode3 = strViewRefMode3.toUpperCase(), true) != null) continue;
                                strPSAppDEViewId2 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                psAppViewRef2 = new PSAppViewRef();
                                psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode3);
                                psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                                psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                this.registerPSAppViewRef(psAppViewRef2);
                            }
                        } else {
                            psDEViewBases = this.getPSDataEntity().getPSDEViewDatasByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"));
                            if (psDEViewBases != null) {
                                while (psDEViewBases.hasNext()) {
                                    psDEViewBase = psDEViewBases.next();
                                    if (StringHelper.IsNullOrEmpty((String)psDEViewBase.getPDVTPARAM())) continue;
                                    strViewRefMode3 = "";
                                    if (!this.isEnableEditData() && !this.isEnableViewData() || this.isWFIAMode()) continue;
                                    strViewRefMode3 = StringHelper.Format((String)"%1$s:%2$s", (Object)"EDITDATA", (Object)psDEViewBase.getPDVTPARAM());
                                    if (this.getPSAppViewRef(strViewRefMode3 = strViewRefMode3.toUpperCase(), true) != null) continue;
                                    strPSAppDEViewId2 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                                    psAppViewRef2 = new PSAppViewRef();
                                    psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode3);
                                    psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                                    psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                                    this.registerPSAppViewRef(psAppViewRef2);
                                }
                            }
                        }
                    } else {
                        strInfo = StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u591a\u8868\u5355\u8bc6\u522b\u5c5e\u6027\u6216\u76f8\u5e94\u4ee3\u7801\u8868", (Object)this.getPSDataEntity().getName());
                        log.warn((Object)strInfo);
                        this.getPSApplicationRuntime().log(4, this, strInfo);
                    }
                }
                if (StringHelper.Compare((String)this.getEditDataMode(), (String)"INDEXDE", (boolean)true) == 0 && (psDERIndexs = this.getPSDataEntity().getPSDERIndexs(true)) != null) {
                    while (psDERIndexs.hasNext()) {
                        IPSAppDataEntity minorPSAppDataEntity;
                        iPSDERIndex = psDERIndexs.next();
                        minorPSDataEntity = iPSDERIndex.getMinorPSDataEntity();
                        strViewRefMode2 = StringHelper.Format((String)"%1$s:%2$s", (Object)"EDITDATA", (Object)iPSDERIndex.getTypeValue());
                        if (this.getPSAppViewRef(strViewRefMode2, true) != null || (psDEViewBase = minorPSDataEntity.getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), true)) == null) continue;
                        strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                        psAppViewRef = new PSAppViewRef();
                        psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                        psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                        psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                        if (this.isEnableUIModelEx() && (minorPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(minorPSDataEntity, true)) != null && this.getPSAppDataEntity() != null) {
                            String strViewParams = String.format("%1$s%2$s=%%%3$s%%", "SRFNAVCTX.", minorPSAppDataEntity.getName(), this.getPSAppDataEntity().getName());
                            psAppViewRef.setVIEWPARAMS(strViewParams);
                        }
                        this.registerPSAppViewRef(psAppViewRef);
                    }
                }
            }
            if (this.isWFIAMode() && this.isEnableWF()) {
                if (!this.isDynamicView()) {
                    if (StringHelper.IsNullOrEmpty((String)this.getWFStepValue())) {
                        IPSCodeList iPSCodeList;
                        if (this.getPSDEWF().getWFStepPSDEField() != null && (iPSCodeList = this.getPSDEWF().getWFStepPSDEField().getPSCodeList()) != null && iPSCodeList.getPSCodeItems() != null) {
                            Iterator<IPSCodeItem> psCodeItems2 = iPSCodeList.getPSCodeItems();
                            while (psCodeItems2.hasNext()) {
                                IPSCodeItem iPSCodeItem2 = psCodeItems2.next();
                                Iterator<IPSWFVersion> psWFVersions = this.getPSWorkflow().getPSWFVersions();
                                if (psWFVersions == null) continue;
                                while (psWFVersions.hasNext()) {
                                    PSAppViewRef psAppViewRef6;
                                    String strPSAppDEViewId6;
                                    PSDEViewBase psDEViewBase4;
                                    String strViewRefMode6;
                                    IPSWFVersion iPSWFVersion = psWFVersions.next();
                                    if (iPSWFVersion.getWFVersion() == 1 && this.getRefPSAppView(strViewRefMode6 = StringHelper.Format((String)"%1$s:%2$s", (Object)"EDITDATA", (Object)iPSCodeItem2.getValue()), true) == null) {
                                        strPDTParam2 = StringHelper.Format((String)"%1$s:W:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)iPSCodeItem2.getValue());
                                        strPDTParam2 = strPDTParam2.toUpperCase();
                                        psDEViewBase4 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam2, true);
                                        if (psDEViewBase4 != null) {
                                            strPSAppDEViewId6 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase4.getPSDEVIEWBASEID());
                                            psAppViewRef6 = new PSAppViewRef();
                                            psAppViewRef6.setPSAPPVIEWREFNAME(strViewRefMode6);
                                            psAppViewRef6.setMINORPSAPPVIEWID(strPSAppDEViewId6);
                                            psAppViewRef6.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase4.getPSDEVIEWBASEID());
                                            psAppViewRef6.setParamValue("TRYMODE", true);
                                            this.registerPSAppViewRef(psAppViewRef6);
                                        }
                                    }
                                    if (this.getRefPSAppView(strViewRefMode6 = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"EDITDATA", (Object)iPSCodeItem2.getValue(), (Object)iPSWFVersion.getWFVersion()), true) != null) continue;
                                    strPDTParam2 = StringHelper.Format((String)"%1$s:%3$sW:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)iPSCodeItem2.getValue(), (Object)(iPSWFVersion.getWFVersion() == 1 ? "" : Integer.valueOf(iPSWFVersion.getWFVersion())));
                                    strPDTParam2 = strPDTParam2.toUpperCase();
                                    psDEViewBase4 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam2, true);
                                    if (psDEViewBase4 == null) continue;
                                    strPSAppDEViewId6 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase4.getPSDEVIEWBASEID());
                                    psAppViewRef6 = new PSAppViewRef();
                                    psAppViewRef6.setPSAPPVIEWREFNAME(strViewRefMode6);
                                    psAppViewRef6.setMINORPSAPPVIEWID(strPSAppDEViewId6);
                                    psAppViewRef6.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase4.getPSDEVIEWBASEID());
                                    psAppViewRef6.setParamValue("TRYMODE", true);
                                    this.registerPSAppViewRef(psAppViewRef6);
                                }
                            }
                        }
                    } else {
                        Iterator<IPSWFVersion> psWFVersions = this.getPSWorkflow().getPSWFVersions();
                        if (psWFVersions != null) {
                            while (psWFVersions.hasNext()) {
                                PSAppViewRef psAppViewRef7;
                                String strPSAppDEViewId7;
                                String strPDTParam6;
                                String strViewRefMode7;
                                IPSWFVersion iPSWFVersion = psWFVersions.next();
                                if (iPSWFVersion.getWFVersion() == 1 && this.getRefPSAppView(strViewRefMode7 = StringHelper.Format((String)"%1$s:%2$s", (Object)"EDITDATA", (Object)this.getWFStepValue()), true) == null) {
                                    strPDTParam6 = StringHelper.Format((String)"%1$s:W:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)this.getWFStepValue());
                                    strPDTParam6 = strPDTParam6.toUpperCase();
                                    psDEViewBase2 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam6, true);
                                    if (psDEViewBase2 != null) {
                                        strPSAppDEViewId7 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                        psAppViewRef7 = new PSAppViewRef();
                                        psAppViewRef7.setPSAPPVIEWREFNAME(strViewRefMode7);
                                        psAppViewRef7.setMINORPSAPPVIEWID(strPSAppDEViewId7);
                                        psAppViewRef7.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                        psAppViewRef7.setParamValue("TRYMODE", true);
                                        this.registerPSAppViewRef(psAppViewRef7);
                                    }
                                }
                                if (this.getRefPSAppView(strViewRefMode7 = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"EDITDATA", (Object)this.getWFStepValue(), (Object)iPSWFVersion.getWFVersion()), true) != null) continue;
                                strPDTParam6 = StringHelper.Format((String)"%1$s:%3$sW:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)this.getWFStepValue(), (Object)(iPSWFVersion.getWFVersion() == 1 ? "" : Integer.valueOf(iPSWFVersion.getWFVersion())));
                                strPDTParam6 = strPDTParam6.toUpperCase();
                                psDEViewBase2 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam6, true);
                                if (psDEViewBase2 == null) continue;
                                strPSAppDEViewId7 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                psAppViewRef7 = new PSAppViewRef();
                                psAppViewRef7.setPSAPPVIEWREFNAME(strViewRefMode7);
                                psAppViewRef7.setMINORPSAPPVIEWID(strPSAppDEViewId7);
                                psAppViewRef7.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                psAppViewRef7.setParamValue("TRYMODE", true);
                                this.registerPSAppViewRef(psAppViewRef7);
                            }
                        }
                    }
                } else {
                    strViewRefMode = StringHelper.Format((String)"%1$s", (Object)"EDITDATAX");
                    if (this.getRefPSAppView(strViewRefMode, true) == null) {
                        PSDEViewBase psDEViewBase5 = this.getPSDataEntity().getPSDEViewDataByPDT(this.isMobileView() ? "MOBREDIRECTVIEW" : "REDIRECTVIEW", true);
                        if (psDEViewBase5 == null) {
                            strPDTParam3 = StringHelper.Format((String)"%1$s:W", (Object)this.getPSDEWF().getCodeName());
                            strPDTParam3 = strPDTParam3.toUpperCase();
                            psDEViewBase5 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam3, true);
                        }
                        if (psDEViewBase5 != null) {
                            String strPSAppDEViewId8 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase5.getPSDEVIEWBASEID());
                            PSAppViewRef psAppViewRef8 = new PSAppViewRef();
                            psAppViewRef8.setPSAPPVIEWREFNAME(strViewRefMode);
                            psAppViewRef8.setMINORPSAPPVIEWID(strPSAppDEViewId8);
                            psAppViewRef8.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase5.getPSDEVIEWBASEID());
                            psAppViewRef8.setParamValue("TRYMODE", true);
                            this.registerPSAppViewRef(psAppViewRef8);
                        }
                    }
                    String strPDTParam7 = StringHelper.Format((String)"%1$s:W", (Object)this.getPSDEWF().getCodeName());
                    strPDTParam7 = strPDTParam7.toUpperCase();
                    if (!StringHelper.IsNullOrEmpty((String)strPDTParamPre)) {
                        strPDTParam7 = String.valueOf(strPDTParamPre) + strPDTParam7;
                    }
                    strPDTParam7 = String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW") + ":" + strPDTParam7;
                    Iterator<PSDEViewBase> psDEViewBaseList = this.getPSDataEntity().getPSDEViewDatasByPDT(strPDTParam7);
                    if (psDEViewBaseList != null) {
                        while (psDEViewBaseList.hasNext()) {
                            psDEViewBase3 = psDEViewBaseList.next();
                            strPSAppDEViewId3 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                            psAppViewRef3 = new PSAppViewRef();
                            psAppViewRef3.setPSAPPVIEWREFNAME(String.valueOf(strViewRefMode) + ":" + psDEViewBase3.getPDVTPARAM());
                            psAppViewRef3.setMINORPSAPPVIEWID(strPSAppDEViewId3);
                            psAppViewRef3.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                            psAppViewRef3.setParamValue("TRYMODE", true);
                            this.registerPSAppViewRef(psAppViewRef3);
                        }
                    }
                }
            }
            if (!this.isWFIAMode() && (psDEMainStates = this.getPSDataEntity().getAllPSDEMainStates()) != null) {
                while (psDEMainStates.hasNext()) {
                    IPSDEMainState iPSDEMainState = psDEMainStates.next();
                    strPDTParam3 = StringHelper.Format((String)"MSTAG:%1$s", (Object)iPSDEMainState.getMSTag());
                    strPDTParam3 = strPDTParam3.toUpperCase();
                    psDEViewBase3 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), strPDTParamPre, strPDTParam3, true);
                    if (psDEViewBase3 == null) continue;
                    strViewRefMode2 = StringHelper.Format((String)"%1$s:MSTAG:%2$s", (Object)"EDITDATA", (Object)iPSDEMainState.getMSTag());
                    String strViewRefModeDesc3 = StringHelper.Format((String)"\u7f16\u8f91\u89c6\u56fe|\u4e3b\u72b6\u6001[%1$s]", (Object)iPSDEMainState.getName());
                    if (this.getPSAppViewRef(strViewRefMode2 = strViewRefMode2.toUpperCase(), true) != null) continue;
                    strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                    psAppViewRef = new PSAppViewRef();
                    psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                    psAppViewRef.setREFMODETEXT(strViewRefModeDesc3);
                    psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                    psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                    psAppViewRef.setParamValue("TRYMODE", true);
                    this.registerPSAppViewRef(psAppViewRef);
                }
            }
            strViewRefMode = StringHelper.Format((String)"%1$s", (Object)"EDITDATA");
            strViewRefModeDesc = "\u7f16\u8f91\u89c6\u56fe";
            iPSAppView = this.getRefPSAppView(strViewRefMode, true);
            if (iPSAppView == null) {
                psDEViewBase3 = null;
                if (this.isEnableWF()) {
                    if (this.isWFIAMode()) {
                        if (!StringHelper.IsNullOrEmpty((String)this.getWFStepValue())) {
                            strPDTParam = StringHelper.Format((String)"%1$s:W:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)this.getWFStepValue());
                            strPDTParam = strPDTParam.toUpperCase();
                            psDEViewBase3 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam, true);
                        } else {
                            strPDTParam = StringHelper.Format((String)"%1$s:W", (Object)this.getPSDEWF().getCodeName());
                            strPDTParam = strPDTParam.toUpperCase();
                            psDEViewBase3 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam, true);
                        }
                    } else {
                        strPDTParam = StringHelper.Format((String)"%1$s:D", (Object)this.getPSDEWF().getCodeName());
                        strPDTParam = strPDTParam.toUpperCase();
                        psDEViewBase3 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBWFEDITVIEW" : "WFEDITVIEW"), strPDTParamPre, strPDTParam, true);
                    }
                } else {
                    psDEViewBase3 = this.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), "", true);
                }
                if (psDEViewBase3 != null) {
                    strPSAppDEViewId3 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                    psAppViewRef3 = new PSAppViewRef();
                    psAppViewRef3.setPSAPPVIEWREFNAME(strViewRefMode);
                    psAppViewRef3.setREFMODETEXT(strViewRefModeDesc);
                    psAppViewRef3.setMINORPSAPPVIEWID(strPSAppDEViewId3);
                    psAppViewRef3.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                    psAppViewRef3.setParamValue("TRYMODE", true);
                    this.registerPSAppViewRef(psAppViewRef3);
                }
            }
        }
        if (this.isEnableBatchAdd()) {
            PSAppViewRef psAppViewRef9;
            String strPSAppDEViewId9;
            IPSDERNN iPSDERNN = this.getPSDataEntity().getPSDERNN();
            String strMPickupViewTag = StringHelper.Format((String)"%1$s:%2$s", (Object)"MPICKUPVIEW", (Object)iPSDERNN.getFirstPSDER().getCodeName());
            strViewRefModeDesc2 = StringHelper.Format((String)"\u6279\u6dfb\u52a0\u591a\u9009\u89c6\u56fe|%1$s", (Object)iPSDERNN.getFirstPSDER().getMajorPSDataEntity().getLogicName());
            if (this.getPSAppViewRef(strMPickupViewTag = strMPickupViewTag.toUpperCase(), true) == null && !StringHelper.IsNullOrEmpty((String)iPSDERNN.getFirstPSDER().getRefMPickupPSDEViewId())) {
                strPSAppDEViewId9 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)iPSDERNN.getFirstPSDER().getRefMPickupPSDEViewId());
                psAppViewRef9 = new PSAppViewRef();
                psAppViewRef9.setPSAPPVIEWREFNAME(strMPickupViewTag);
                psAppViewRef9.setREFMODETEXT(strViewRefModeDesc2);
                psAppViewRef9.setMINORPSAPPVIEWID(strPSAppDEViewId9);
                psAppViewRef9.setParamValue("MINORPSDEVIEWBASEID", iPSDERNN.getFirstPSDER().getRefMPickupPSDEViewId());
                psAppViewRef9.setParamValue("TRYMODE", true);
                this.registerPSAppViewRef(psAppViewRef9);
            }
            strMPickupViewTag = StringHelper.Format((String)"%1$s:%2$s", (Object)"MPICKUPVIEW", (Object)iPSDERNN.getSecondPSDER().getCodeName());
            strViewRefModeDesc2 = StringHelper.Format((String)"\u6279\u6dfb\u52a0\u591a\u9009\u89c6\u56fe|%1$s", (Object)iPSDERNN.getSecondPSDER().getMajorPSDataEntity().getLogicName());
            if (this.getPSAppViewRef(strMPickupViewTag = strMPickupViewTag.toUpperCase(), true) == null && !StringHelper.IsNullOrEmpty((String)iPSDERNN.getSecondPSDER().getRefMPickupPSDEViewId())) {
                strPSAppDEViewId9 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)iPSDERNN.getSecondPSDER().getRefMPickupPSDEViewId());
                psAppViewRef9 = new PSAppViewRef();
                psAppViewRef9.setPSAPPVIEWREFNAME(strMPickupViewTag);
                psAppViewRef9.setREFMODETEXT(strViewRefModeDesc2);
                psAppViewRef9.setMINORPSAPPVIEWID(strPSAppDEViewId9);
                psAppViewRef9.setParamValue("MINORPSDEVIEWBASEID", iPSDERNN.getSecondPSDER().getRefMPickupPSDEViewId());
                psAppViewRef9.setParamValue("TRYMODE", true);
                this.registerPSAppViewRef(psAppViewRef9);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u67e5\u770b\u6570\u636e", dump=false)
    public boolean isEnableViewData() {
        if (this.isPickupMode()) {
            return false;
        }
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 4L) > 0L;
        }
        return !this.isEnableEditData();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u65b0\u5efa\u6570\u636e", dump=false)
    public boolean isEnableNewData() {
        if (this.isPickupMode()) {
            return false;
        }
        return super.isEnableNewData();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91\u6570\u636e", dump=false)
    public boolean isEnableEditData() {
        if (this.isPickupMode()) {
            return false;
        }
        return super.isEnableEditData();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u5bfc\u5165", ignoredumpvalues="false", ignorert=3)
    public boolean isEnableImport() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x400L) > 0L;
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u5bfc\u51fa", ignoredumpvalues="false", ignorert=3)
    public boolean isEnableExport() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x40L) > 0L;
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u8fc7\u6ee4", ignorert=3)
    public boolean isEnableFilter() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x100L) > 0L;
        }
        return this.isEnableSearch();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5feb\u901f\u641c\u7d22", ignoredumpvalues="false", ignorert=3, fields={"VIEWPARAM5"})
    public boolean isEnableQuickSearch() {
        return this.bEnableQuickSearch;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u641c\u7d22", ignoredumpvalues="false", ignorert=3, doc="\u5224\u65ad\u89c6\u56fe\u662f\u5426\u5b58\u5728\u641c\u7d22\u8868\u5355\u6216\u641c\u7d22\u680f")
    public boolean isEnableSearch() {
        return this.getPSDESearchForm() != null || this.getPSSearchBar() != null;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5feb\u901f\u5efa\u7acb", dump=false)
    public boolean isEnableQuickCreate() {
        return StringHelper.Compare((String)this.getNewDataMode(), (String)"WIZARD", (boolean)true) == 0;
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (!this.isPrepareTemplV2logic()) {
            if (this.isEnableQuickSearch()) {
                this.registerPSAppViewParam("UI.ENABLEQUICKSEARCH", "TRUE", "\u652f\u6301\u5feb\u901f\u641c\u7d22");
            }
            if (this.isEnableSearch()) {
                this.registerPSAppViewParam("UI.ENABLESEARCH", "TRUE", "\u652f\u6301\u641c\u5e38\u89c4\u7d22");
            }
        }
        super.onPreparePSAppViewParams();
    }

    protected boolean isEnableQuickSearchDefault() {
        return this.bEnableQuickSearchDefault;
    }

    protected void setEnableQuickSearchDefault(boolean bEnableQuickSearchDefault) {
        this.bEnableQuickSearchDefault = bEnableQuickSearchDefault;
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u8868\u5355\u90e8\u4ef6", hideempty=true)
    public IPSDESearchForm getPSDESearchForm() {
        return this.iPSDESearchForm;
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u641c\u7d22\u8868\u5355\u90e8\u4ef6", hideempty=true)
    public IPSDESearchForm getQuickPSDESearchForm() {
        return this.quickPSDESearchForm;
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u680f\u90e8\u4ef6", hideempty=true)
    public IPSSearchBar getPSSearchBar() {
        return this.iPSSearchBar;
    }

    @Override
    public int check() throws Exception {
        if (!this.isIgnoreMDViewCheck()) {
            Iterator<IPSAppView> psAppViews;
            if (!this.isBatchAddOnly()) {
                if (this.isEnableNewData()) {
                    if ((StringHelper.Compare((String)this.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 || StringHelper.Compare((String)this.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0) && (psAppViews = this.getRefPSAppViews("NEWDATAWIZARD")) == null) {
                        if (StringHelper.Compare((String)this.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0) {
                            this.logPSModelIssue(PSAppDEMultiDataViewImpl.createPSSysIssue("1011003"));
                        } else {
                            this.logPSModelIssue(PSAppDEMultiDataViewImpl.createPSSysIssue("1011004"));
                        }
                    }
                    if ((psAppViews = this.getRefPSAppViews("NEWDATA")) == null) {
                        if (this.getPSDataEntity().getPSDEViewDataByPDT(this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW", true) != null) {
                            this.logPSModelIssue(PSAppDEMultiDataViewImpl.createPSSysIssue("1011001"));
                        } else {
                            this.logPSModelIssue(PSAppDEMultiDataViewImpl.createPSSysIssue("1011006"));
                        }
                    }
                }
                if ((this.isEnableEditData() || this.isEnableViewData()) && (psAppViews = this.getRefPSAppViews("EDITDATA")) == null) {
                    if (this.getPSDataEntity().getPSDEViewDataByPDT(this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW", true) != null) {
                        this.logPSModelIssue(PSAppDEMultiDataViewImpl.createPSSysIssue("1011002"));
                    } else {
                        this.logPSModelIssue(PSAppDEMultiDataViewImpl.createPSSysIssue("1011007"));
                    }
                }
            }
            if (this.isEnableBatchAdd() && (psAppViews = this.getRefPSAppViews("MPICKUPVIEW")) == null) {
                this.logPSModelIssue(PSAppDEMultiDataViewImpl.createPSSysIssue("1011002"));
            }
        }
        return super.check();
    }

    protected boolean isIgnoreMDViewCheck() {
        return this.isPickupMode() || this.isPickupView();
    }

    protected boolean isExpandSearchFormDefault() {
        return this.bExpandSearchFormDefault;
    }

    protected void setExpandSearchFormDefault(boolean bExpandSearchFormDefault) {
        this.bExpandSearchFormDefault = bExpandSearchFormDefault;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355", ignoredumpvalues="false", fields={"VIEWPARAM10"})
    public boolean isExpandSearchForm() {
        return this.bExpandSearchForm;
    }

    @Override
    protected void onPreparePSDEViewLogics() throws Exception {
        super.onPreparePSDEViewLogics();
        if (this.isPrepareDefaultPSAppViewLogics() && this.isPreparePSAppViewNewOpenDataLogics()) {
            PSAppViewLogicImpl psAppViewLogicImpl;
            PSAppViewLogic psAppViewLogic;
            PSSysViewLogic psSysViewLogic;
            if (this.isEnableNewData() && this.getPSAppViewLogic("newdata", true) == null) {
                BuiltinPSAppUINewDataLogicImpl defaultPSAppViewNewDataLogicImpl = new BuiltinPSAppUINewDataLogicImpl();
                psSysViewLogic = new PSSysViewLogic();
                psSysViewLogic.setPSSYSVIEWLOGICID("APP_NEWDATA");
                psSysViewLogic.setPSSYSVIEWLOGICNAME("\u65b0\u5efa\u6570\u636e");
                defaultPSAppViewNewDataLogicImpl.init(this.getDAGlobalHelper(), this, psSysViewLogic);
                psAppViewLogic = new PSAppViewLogic();
                psAppViewLogic.setPSAPPVIEWLOGICID("newdata");
                psAppViewLogic.setPSAPPVIEWLOGICNAME("newdata");
                psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
                psAppViewLogicImpl = new PSAppViewLogicImpl();
                psAppViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this, psAppViewLogic, defaultPSAppViewNewDataLogicImpl);
                this.registerPSAppViewLogic(psAppViewLogicImpl);
            }
            if ((this.isEnableEditData() || this.isEnableViewData()) && this.getPSAppViewLogic("opendata", true) == null) {
                BuiltinPSAppUIOpenDataLogicImpl defaultPSAppViewOpenDataLogicImpl = new BuiltinPSAppUIOpenDataLogicImpl();
                psSysViewLogic = new PSSysViewLogic();
                psSysViewLogic.setPSSYSVIEWLOGICID("APP_OPENDATA");
                psSysViewLogic.setPSSYSVIEWLOGICNAME("\u6253\u5f00\u6570\u636e");
                defaultPSAppViewOpenDataLogicImpl.init(this.getDAGlobalHelper(), this, psSysViewLogic, true);
                psAppViewLogic = new PSAppViewLogic();
                psAppViewLogic.setPSAPPVIEWLOGICID("opendata");
                psAppViewLogic.setPSAPPVIEWLOGICNAME("opendata");
                psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
                psAppViewLogicImpl = new PSAppViewLogicImpl();
                psAppViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this, psAppViewLogic, defaultPSAppViewOpenDataLogicImpl);
                this.registerPSAppViewLogic(psAppViewLogicImpl);
            }
        }
    }

    protected boolean isPreparePSAppViewNewOpenDataLogics() {
        return true;
    }

    @Override
    public String getActionAfterNewDataWizard() {
        return this.strActionAfterNewDataWizard;
    }

    @Override
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception {
        Iterator<IPSControl> psControls = this.getPSControls();
        if (psControls != null) {
            while (psControls.hasNext()) {
                IPSMDAjaxControl iPSMDAjaxControl;
                IPSControl iPSControl = psControls.next();
                if (!(iPSControl instanceof IPSMDAjaxControl) || (iPSMDAjaxControl = (IPSMDAjaxControl)iPSControl).getPSMDAjaxControlHandler() == null || iPSMDAjaxControl.getPSMDAjaxControlHandler().getPSDEDataSet() == null || iPSMDAjaxControl.getPSMDAjaxControlHandler().getPSDEDataSet().getADPSDEDQConditions() == null) continue;
                return iPSMDAjaxControl.getPSMDAjaxControlHandler().getPSDEDataSet().getADPSDEDQConditions();
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5feb\u901f\u5206\u7ec4\u641c\u7d22", ignoredumpvalues="false", ignorert=3, doc="\u5224\u65ad\u89c6\u56fe\u662f\u5426\u5b58\u5728\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868{@link #getQuickGroupPSCodeList}")
    public boolean isEnableQuickGroup() {
        return this.getQuickGroupPSCodeList() != null;
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868", dumpref=true, ignorert=3, fields={"GROUPPSCODELISTID"})
    public IPSCodeList getQuickGroupPSCodeList() {
        return this.quickGroupPSCodeList;
    }
}

