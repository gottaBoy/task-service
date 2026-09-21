/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEMultiDataView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.codelist.IPSCodeItem
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDESearchForm
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainState
 *  net.ibizsys.model.der.IPSDERIndex
 *  net.ibizsys.model.der.IPSDERNN
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.view;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDEMultiDataView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRefRuntime;
import net.ibizsys.model.app.view.PSAppDEXDataViewImpl;
import net.ibizsys.model.app.view.PSAppViewRefImpl;
import net.ibizsys.model.codelist.IPSCodeItem;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDESearchForm;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityRuntime;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.der.IPSDER1NRuntime;
import net.ibizsys.model.der.IPSDERIndex;
import net.ibizsys.model.der.IPSDERNN;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.model.entity.PSDEViewCtrl;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
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

    @Override
    protected void onInit() throws Exception {
        this.strNewDataMode = this.psViewBase.getVIEWPARAM();
        this.strEditDataMode = this.psViewBase.getVIEWPARAM2();
        this.bEnableQuickSearch = this.isEnableQuickSearchDefault();
        if (!this.psViewBase.isVIEWPARAM5Null()) {
            this.bEnableQuickSearch = this.psViewBase.getVIEWPARAM5();
        }
        if (!this.isPickupMode()) {
            if (StringHelper.isNullOrEmpty((String)this.strNewDataMode)) {
                if (this.getPSDataEntityRuntime().getDEType() == 3) {
                    this.strNewDataMode = "ENABATADD";
                } else if (!StringHelper.isNullOrEmpty((String)this.getPSDataEntityRuntime().getIndexDEType())) {
                    this.strNewDataMode = "INDEXDE";
                } else if (this.getPSDataEntityRuntime().isEnableMultiForm()) {
                    this.strNewDataMode = "MULTIFORM";
                }
            }
            if (StringHelper.isNullOrEmpty((String)this.strEditDataMode) && StringHelper.compare((String)this.strNewDataMode, (String)"WIZARD", (boolean)true) != 0) {
                this.strEditDataMode = this.strNewDataMode;
            }
            if (StringHelper.isNullOrEmpty((String)this.strNewDataMode)) {
                this.strNewDataMode = "NORMAL";
            }
            if (StringHelper.isNullOrEmpty((String)this.strEditDataMode)) {
                this.strEditDataMode = "NORMAL";
            }
            if (StringHelper.compare((String)this.getNewDataMode(), (String)"ENABATADD", (boolean)true) == 0) {
                this.bEnableBatchAdd = true;
            }
            if (StringHelper.compare((String)this.getNewDataMode(), (String)"BATADDONLY", (boolean)true) == 0) {
                this.bEnableBatchAdd = true;
                this.bBatchAddOnly = true;
            }
        }
        super.onInit();
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("searchform");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDESearchForm) {
            this.iPSDESearchForm = (IPSDESearchForm)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    @PSModelRTMeta(description="\u6570\u636e\u9009\u62e9\u89c6\u56fe")
    public boolean isPickupMode() {
        return false;
    }

    @PSModelRTMeta(description="\u65b0\u5efa\u6570\u636e\u6a21\u5f0f", codelist="DEGridViewNewDataMode")
    public String getNewDataMode() {
        return this.strNewDataMode;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u6570\u636e\u6a21\u5f0f", codelist="DEGridViewEditDataMode")
    public String getEditDataMode() {
        return this.strEditDataMode;
    }

    @PSModelRTMeta(description="\u652f\u6301\u6279\u6dfb\u52a0")
    public boolean isEnableBatchAdd() {
        if (!this.isEnableNewData()) {
            return false;
        }
        return this.bEnableBatchAdd;
    }

    @PSModelRTMeta(description="\u53ea\u652f\u6301\u6279\u6dfb\u52a0")
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
        PSAppViewRefImpl iPSAppViewRef;
        PSAppViewRef psAppViewRef;
        String strPSAppDEViewId;
        String strViewRefMode2;
        IPSDataEntity minorPSDataEntity;
        IPSDERIndex iPSDERIndex;
        Iterator psDERIndexs;
        String strInfo;
        PSDEViewBase psDEViewBase;
        Iterator<PSDEViewBase> psDEViewBases;
        PSAppViewRefImpl iPSAppViewRef2;
        PSAppViewRef psAppViewRef2;
        String strPSAppDEViewId2;
        String strViewRefMode3;
        String strPDTParam2;
        IPSCodeItem iPSCodeItem;
        PSDEViewBase psDEViewBase2;
        Iterator psCodeItems;
        IPSCodeList mfPSCodeList;
        IPSDEField mfPSDEField;
        PSAppViewRef psAppViewRef3;
        String strPSAppDEViewId3;
        PSDEViewBase psDEViewBase3;
        String strViewRefModeDesc2;
        String strInfo2;
        IPSDEField iPSDEField;
        String strPDTHeader = "";
        if (this.isMobileView()) {
            strPDTHeader = "MOB";
        }
        String strPDTParamPre = this.getPDTParamPre();
        if (!this.isBatchAddOnly() && this.isEnableNewData()) {
            if (StringHelper.compare((String)this.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 || StringHelper.compare((String)this.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                iPSDEField = null;
                iPSDEField = StringHelper.compare((String)this.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? this.getPSDataEntityRuntime().getFormTypePSDEField() : this.getPSDataEntityRuntime().getIndexTypePSDEField();
                if (iPSDEField == null) {
                    strInfo2 = StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u6570\u636e\u5206\u7c7b\u5c5e\u6027", (Object)this.getPSDataEntityRuntime().getName());
                    log.warn((Object)strInfo2);
                    this.getPSApplicationRuntime().log(4, this, strInfo2);
                }
                if (!this.psAppViewRefMap.containsKey("NEWDATAWIZARD")) {
                    String strEditViewTag = "";
                    strViewRefModeDesc2 = "";
                    if (StringHelper.compare((String)this.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0) {
                        strEditViewTag = "FORMPICKUPVIEW";
                        strViewRefModeDesc2 = "\u65b0\u5efa\u5411\u5bfc\u89c6\u56fe|\u591a\u8868\u5355\u9009\u62e9\u89c6\u56fe";
                    } else {
                        strEditViewTag = "INDEXDEPICKUPVIEW";
                        strViewRefModeDesc2 = "\u65b0\u5efa\u5411\u5bfc\u89c6\u56fe|\u7d22\u5f15/\u7ee7\u627f\u5173\u7cfb\u9009\u62e9\u89c6\u56fe";
                    }
                    psDEViewBase3 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + strEditViewTag, true);
                    if (psDEViewBase3 != null) {
                        strPSAppDEViewId3 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                        psAppViewRef3 = new PSAppViewRef();
                        psAppViewRef3.setPSAPPVIEWREFNAME("NEWDATAWIZARD");
                        psAppViewRef3.setREFMODETEXT(strViewRefModeDesc2);
                        psAppViewRef3.setMINORPSAPPVIEWID(strPSAppDEViewId3);
                        psAppViewRef3.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                        PSAppViewRefImpl iPSAppViewRef3 = new PSAppViewRefImpl();
                        ((IPSAppViewRefRuntime)iPSAppViewRef3).init(this.getPSModelStorageContext(), this, psAppViewRef3);
                        this.psAppViewRefMap.put("NEWDATAWIZARD", iPSAppViewRef3);
                    } else {
                        String strInfo3 = StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u9884\u7f6e\u89c6\u56fe[%2$s]", (Object)this.getPSDataEntityRuntime().getName(), (Object)strEditViewTag);
                        this.logPSModelInfo(4, strInfo3);
                    }
                }
                if (StringHelper.compare((String)this.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0) {
                    mfPSDEField = this.getPSDataEntityRuntime().getFormTypePSDEField();
                    if (mfPSDEField != null && mfPSDEField.getPSCodeList() != null) {
                        mfPSCodeList = mfPSDEField.getPSCodeList();
                        psCodeItems = mfPSCodeList.getPSCodeItems();
                        if (psCodeItems != null) {
                            while (psCodeItems.hasNext()) {
                                psDEViewBase2 = null;
                                iPSCodeItem = (IPSCodeItem)psCodeItems.next();
                                if (this.isEnableWF()) {
                                    strPDTParam2 = StringHelper.format((String)"%1$s:%2$s:D", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName());
                                    psDEViewBase2 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam2, true);
                                }
                                if (psDEViewBase2 == null) {
                                    strPDTParam2 = StringHelper.format((String)"%1$s", (Object)iPSCodeItem.getValue());
                                    psDEViewBase2 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", strPDTParamPre, strPDTParam2, true);
                                }
                                if (psDEViewBase2 == null) continue;
                                strViewRefMode3 = "";
                                if (!this.isEnableNewData()) continue;
                                strViewRefMode3 = StringHelper.format((String)"%1$s:%2$s", (Object)"NEWDATA", (Object)iPSCodeItem.getValue());
                                if (this.psAppViewRefMap.containsKey(strViewRefMode3 = strViewRefMode3.toUpperCase())) continue;
                                strPSAppDEViewId2 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                psAppViewRef2 = new PSAppViewRef();
                                psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode3);
                                psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                                psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                psAppViewRef2.setParamValue("TRYMODE", true);
                                iPSAppViewRef2 = new PSAppViewRefImpl();
                                ((IPSAppViewRefRuntime)iPSAppViewRef2).init(this.getPSModelStorageContext(), this, psAppViewRef2);
                                this.psAppViewRefMap.put(strViewRefMode3, iPSAppViewRef2);
                            }
                        } else {
                            psDEViewBases = this.getPSDataEntityRuntime().getPSDEViewDatasByPDT(String.valueOf(strPDTHeader) + "EDITVIEW");
                            if (psDEViewBases != null) {
                                while (psDEViewBases.hasNext()) {
                                    psDEViewBase = psDEViewBases.next();
                                    if (StringHelper.isNullOrEmpty((String)psDEViewBase.getPDVTPARAM())) continue;
                                    strViewRefMode3 = "";
                                    if (!this.isEnableNewData()) continue;
                                    strViewRefMode3 = StringHelper.format((String)"%1$s:%2$s", (Object)"NEWDATA", (Object)psDEViewBase.getPDVTPARAM());
                                    if (this.psAppViewRefMap.containsKey(strViewRefMode3 = strViewRefMode3.toUpperCase())) continue;
                                    strPSAppDEViewId2 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                                    psAppViewRef2 = new PSAppViewRef();
                                    psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode3);
                                    psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                                    psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                                    psAppViewRef2.setParamValue("TRYMODE", true);
                                    iPSAppViewRef2 = new PSAppViewRefImpl();
                                    ((IPSAppViewRefRuntime)iPSAppViewRef2).init(this.getPSModelStorageContext(), this, psAppViewRef2);
                                    this.psAppViewRefMap.put(strViewRefMode3, iPSAppViewRef2);
                                }
                            }
                        }
                    } else {
                        strInfo = StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u591a\u8868\u5355\u8bc6\u522b\u5c5e\u6027\u6216\u76f8\u5e94\u4ee3\u7801\u8868", (Object)this.getPSDataEntityRuntime().getName());
                        log.warn((Object)strInfo);
                        this.getPSApplicationRuntime().log(4, this, strInfo);
                    }
                }
                if (StringHelper.compare((String)this.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0 && (psDERIndexs = this.getPSDataEntityRuntime().getPSDERIndexs(true)) != null) {
                    while (psDERIndexs.hasNext()) {
                        iPSDERIndex = (IPSDERIndex)psDERIndexs.next();
                        minorPSDataEntity = iPSDERIndex.getMinorPSDataEntity();
                        strViewRefMode2 = StringHelper.format((String)"%1$s:%2$s", (Object)"NEWDATA", (Object)iPSDERIndex.getTypeValue());
                        if (this.psAppViewRefMap.containsKey(strViewRefMode2) || (psDEViewBase = ((IPSDataEntityRuntime)minorPSDataEntity).getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", true)) == null) continue;
                        strPSAppDEViewId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                        psAppViewRef = new PSAppViewRef();
                        psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                        psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                        psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                        iPSAppViewRef = new PSAppViewRefImpl();
                        ((IPSAppViewRefRuntime)iPSAppViewRef).init(this.getPSModelStorageContext(), this, psAppViewRef);
                        this.registerPSAppViewRef(psAppViewRef);
                    }
                }
            }
            strViewRefMode = StringHelper.format((String)"%1$s", (Object)"NEWDATA");
            strViewRefModeDesc = "\u65b0\u5efa\u89c6\u56fe";
            iPSAppView = this.getRefPSAppView(strViewRefMode, true);
            if (iPSAppView == null) {
                psDEViewBase3 = null;
                if (this.isEnableWF()) {
                    if (!this.isWFIAMode()) {
                        strPDTParam = StringHelper.format((String)"%1$s:D", (Object)this.getPSDEWF().getCodeName());
                        strPDTParam = strPDTParam.toUpperCase();
                        psDEViewBase3 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam, true);
                    }
                } else {
                    psDEViewBase3 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", "", true);
                }
                if (psDEViewBase3 != null) {
                    strPSAppDEViewId3 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
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
            Iterator psDEMainStates;
            String strPDTParam3;
            if (StringHelper.compare((String)this.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0 || StringHelper.compare((String)this.getEditDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                iPSDEField = null;
                iPSDEField = StringHelper.compare((String)this.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? this.getPSDataEntityRuntime().getFormTypePSDEField() : this.getPSDataEntityRuntime().getIndexTypePSDEField();
                if (iPSDEField == null) {
                    strInfo2 = StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u6570\u636e\u5206\u7c7b\u5c5e\u6027", (Object)this.getPSDataEntityRuntime().getName());
                    log.warn((Object)strInfo2);
                    this.getPSApplicationRuntime().log(4, this, strInfo2);
                }
                if (StringHelper.compare((String)this.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0) {
                    mfPSDEField = this.getPSDataEntityRuntime().getFormTypePSDEField();
                    if (mfPSDEField != null && mfPSDEField.getPSCodeList() != null) {
                        mfPSCodeList = mfPSDEField.getPSCodeList();
                        psCodeItems = mfPSCodeList.getPSCodeItems();
                        if (psCodeItems != null) {
                            while (psCodeItems.hasNext()) {
                                psDEViewBase2 = null;
                                iPSCodeItem = (IPSCodeItem)psCodeItems.next();
                                if (this.isWFIAMode()) {
                                    if (StringHelper.isNullOrEmpty((String)this.getWFStepValue())) {
                                        IPSCodeList wfStepPSCodeList = this.getPSDEWF().getWFStepPSCodeList();
                                        Iterator psCodeItems2 = wfStepPSCodeList.getPSCodeItems();
                                        while (psCodeItems2.hasNext()) {
                                            IPSCodeItem wfStepCodeItem = (IPSCodeItem)psCodeItems2.next();
                                            Iterator psWFVersions = this.getPSWorkflow().getPSWFVersions();
                                            if (psWFVersions == null) continue;
                                            while (psWFVersions.hasNext()) {
                                                PSAppViewRefImpl iPSAppViewRef4;
                                                PSAppViewRef psAppViewRef4;
                                                String strPSAppDEViewId4;
                                                String strViewRefMode4;
                                                String strPDTParam4;
                                                IPSWFVersion iPSWFVersion = (IPSWFVersion)psWFVersions.next();
                                                if (iPSWFVersion.getWFVersion() == 1) {
                                                    strPDTParam4 = StringHelper.format((String)"%1$s:%2$s:W:%3$s", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName(), (Object)wfStepCodeItem.getValue());
                                                    psDEViewBase2 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam4, true);
                                                    if (psDEViewBase2 != null) {
                                                        strViewRefMode4 = "";
                                                        strViewRefMode4 = StringHelper.format((String)"%1$s:%2$s:%3$s", (Object)"EDITDATA", (Object)iPSCodeItem.getValue(), (Object)wfStepCodeItem.getValue());
                                                        if (!this.psAppViewRefMap.containsKey(strViewRefMode4 = strViewRefMode4.toUpperCase())) {
                                                            strPSAppDEViewId4 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                                            psAppViewRef4 = new PSAppViewRef();
                                                            psAppViewRef4.setPSAPPVIEWREFNAME(strViewRefMode4);
                                                            psAppViewRef4.setMINORPSAPPVIEWID(strPSAppDEViewId4);
                                                            psAppViewRef4.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                                            iPSAppViewRef4 = new PSAppViewRefImpl();
                                                            ((IPSAppViewRefRuntime)iPSAppViewRef4).init(this.getPSModelStorageContext(), this, psAppViewRef4);
                                                            this.psAppViewRefMap.put(strViewRefMode4, iPSAppViewRef4);
                                                        }
                                                    }
                                                }
                                                strPDTParam4 = StringHelper.format((String)"%1$s:%2$s:%4$sW:%3$s", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName(), (Object)wfStepCodeItem.getValue(), (Object)(iPSWFVersion.getWFVersion() == 1 ? "" : Integer.valueOf(iPSWFVersion.getWFVersion())));
                                                psDEViewBase2 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam4, true);
                                                if (psDEViewBase2 == null) continue;
                                                strViewRefMode4 = "";
                                                strViewRefMode4 = StringHelper.format((String)"%1$s:%2$s:%3$s@%4$s", (Object)"EDITDATA", (Object)iPSCodeItem.getValue(), (Object)wfStepCodeItem.getValue(), (Object)iPSWFVersion.getWFVersion());
                                                if (this.psAppViewRefMap.containsKey(strViewRefMode4 = strViewRefMode4.toUpperCase())) continue;
                                                strPSAppDEViewId4 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                                psAppViewRef4 = new PSAppViewRef();
                                                psAppViewRef4.setPSAPPVIEWREFNAME(strViewRefMode4);
                                                psAppViewRef4.setMINORPSAPPVIEWID(strPSAppDEViewId4);
                                                psAppViewRef4.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                                iPSAppViewRef4 = new PSAppViewRefImpl();
                                                ((IPSAppViewRefRuntime)iPSAppViewRef4).init(this.getPSModelStorageContext(), this, psAppViewRef4);
                                                this.psAppViewRefMap.put(strViewRefMode4, iPSAppViewRef4);
                                            }
                                        }
                                    } else {
                                        Iterator psWFVersions = this.getPSWorkflow().getPSWFVersions();
                                        if (psWFVersions != null) {
                                            while (psWFVersions.hasNext()) {
                                                PSAppViewRefImpl iPSAppViewRef5;
                                                PSAppViewRef psAppViewRef5;
                                                String strPSAppDEViewId5;
                                                String strViewRefMode5;
                                                String strPDTParam5;
                                                IPSWFVersion iPSWFVersion = (IPSWFVersion)psWFVersions.next();
                                                if (iPSWFVersion.getWFVersion() == 1) {
                                                    strPDTParam5 = StringHelper.format((String)"%1$s:%2$s:W:%3$s", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName(), (Object)this.getWFStepValue());
                                                    psDEViewBase2 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam5, true);
                                                    if (psDEViewBase2 != null) {
                                                        strViewRefMode5 = "";
                                                        strViewRefMode5 = StringHelper.format((String)"%1$s:%2$s:%3$s", (Object)"EDITDATA", (Object)iPSCodeItem.getValue(), (Object)this.getWFStepValue());
                                                        if (!this.psAppViewRefMap.containsKey(strViewRefMode5 = strViewRefMode5.toUpperCase())) {
                                                            strPSAppDEViewId5 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                                            psAppViewRef5 = new PSAppViewRef();
                                                            psAppViewRef5.setPSAPPVIEWREFNAME(strViewRefMode5);
                                                            psAppViewRef5.setMINORPSAPPVIEWID(strPSAppDEViewId5);
                                                            psAppViewRef5.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                                            iPSAppViewRef5 = new PSAppViewRefImpl();
                                                            ((IPSAppViewRefRuntime)iPSAppViewRef5).init(this.getPSModelStorageContext(), this, psAppViewRef5);
                                                            this.psAppViewRefMap.put(strViewRefMode5, iPSAppViewRef5);
                                                        }
                                                    }
                                                }
                                                strPDTParam5 = StringHelper.format((String)"%1$s:%2$s:%4$sW:%3$s", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName(), (Object)this.getWFStepValue(), (Object)(iPSWFVersion.getWFVersion() == 1 ? "" : Integer.valueOf(iPSWFVersion.getWFVersion())));
                                                psDEViewBase2 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam5, true);
                                                if (psDEViewBase2 == null) continue;
                                                strViewRefMode5 = "";
                                                strViewRefMode5 = StringHelper.format((String)"%1$s:%2$s:%3$s@%4$s", (Object)"EDITDATA", (Object)iPSCodeItem.getValue(), (Object)this.getWFStepValue(), (Object)iPSWFVersion.getWFVersion());
                                                if (this.psAppViewRefMap.containsKey(strViewRefMode5 = strViewRefMode5.toUpperCase())) continue;
                                                strPSAppDEViewId5 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                                psAppViewRef5 = new PSAppViewRef();
                                                psAppViewRef5.setPSAPPVIEWREFNAME(strViewRefMode5);
                                                psAppViewRef5.setMINORPSAPPVIEWID(strPSAppDEViewId5);
                                                psAppViewRef5.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                                iPSAppViewRef5 = new PSAppViewRefImpl();
                                                ((IPSAppViewRefRuntime)iPSAppViewRef5).init(this.getPSModelStorageContext(), this, psAppViewRef5);
                                                this.psAppViewRefMap.put(strViewRefMode5, iPSAppViewRef5);
                                            }
                                        }
                                    }
                                }
                                if (this.isEnableWF()) {
                                    strPDTParam2 = StringHelper.format((String)"%1$s:%2$s:D", (Object)iPSCodeItem.getValue(), (Object)this.getPSDEWF().getCodeName());
                                    psDEViewBase2 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam2, true);
                                }
                                if (psDEViewBase2 == null) {
                                    strPDTParam2 = StringHelper.format((String)"%1$s", (Object)iPSCodeItem.getValue());
                                    psDEViewBase2 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", strPDTParamPre, strPDTParam2, true);
                                }
                                if (psDEViewBase2 == null) continue;
                                strViewRefMode3 = "";
                                if (!this.isEnableEditData() && !this.isEnableViewData() || this.isWFIAMode()) continue;
                                strViewRefMode3 = StringHelper.format((String)"%1$s:%2$s", (Object)"EDITDATA", (Object)iPSCodeItem.getValue());
                                if (this.psAppViewRefMap.containsKey(strViewRefMode3 = strViewRefMode3.toUpperCase())) continue;
                                strPSAppDEViewId2 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                psAppViewRef2 = new PSAppViewRef();
                                psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode3);
                                psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                                psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                iPSAppViewRef2 = new PSAppViewRefImpl();
                                ((IPSAppViewRefRuntime)iPSAppViewRef2).init(this.getPSModelStorageContext(), this, psAppViewRef2);
                                this.psAppViewRefMap.put(strViewRefMode3, iPSAppViewRef2);
                            }
                        } else {
                            psDEViewBases = this.getPSDataEntityRuntime().getPSDEViewDatasByPDT(String.valueOf(strPDTHeader) + "EDITVIEW");
                            if (psDEViewBases != null) {
                                while (psDEViewBases.hasNext()) {
                                    psDEViewBase = psDEViewBases.next();
                                    if (StringHelper.isNullOrEmpty((String)psDEViewBase.getPDVTPARAM())) continue;
                                    strViewRefMode3 = "";
                                    if (!this.isEnableEditData() && !this.isEnableViewData() || this.isWFIAMode()) continue;
                                    strViewRefMode3 = StringHelper.format((String)"%1$s:%2$s", (Object)"EDITDATA", (Object)psDEViewBase.getPDVTPARAM());
                                    if (this.psAppViewRefMap.containsKey(strViewRefMode3 = strViewRefMode3.toUpperCase())) continue;
                                    strPSAppDEViewId2 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                                    psAppViewRef2 = new PSAppViewRef();
                                    psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode3);
                                    psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                                    psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                                    iPSAppViewRef2 = new PSAppViewRefImpl();
                                    ((IPSAppViewRefRuntime)iPSAppViewRef2).init(this.getPSModelStorageContext(), this, psAppViewRef2);
                                    this.psAppViewRefMap.put(strViewRefMode3, iPSAppViewRef2);
                                }
                            }
                        }
                    } else {
                        strInfo = StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u591a\u8868\u5355\u8bc6\u522b\u5c5e\u6027\u6216\u76f8\u5e94\u4ee3\u7801\u8868", (Object)this.getPSDataEntityRuntime().getName());
                        log.warn((Object)strInfo);
                        this.getPSApplicationRuntime().log(4, this, strInfo);
                    }
                }
                if (StringHelper.compare((String)this.getEditDataMode(), (String)"INDEXDE", (boolean)true) == 0 && (psDERIndexs = this.getPSDataEntityRuntime().getPSDERIndexs(true)) != null) {
                    while (psDERIndexs.hasNext()) {
                        iPSDERIndex = (IPSDERIndex)psDERIndexs.next();
                        minorPSDataEntity = iPSDERIndex.getMinorPSDataEntity();
                        strViewRefMode2 = StringHelper.format((String)"%1$s:%2$s", (Object)"EDITDATA", (Object)iPSDERIndex.getTypeValue());
                        if (this.psAppViewRefMap.containsKey(strViewRefMode2) || (psDEViewBase = ((IPSDataEntityRuntime)minorPSDataEntity).getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", true)) == null) continue;
                        strPSAppDEViewId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                        psAppViewRef = new PSAppViewRef();
                        psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                        psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                        psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                        iPSAppViewRef = new PSAppViewRefImpl();
                        ((IPSAppViewRefRuntime)iPSAppViewRef).init(this.getPSModelStorageContext(), this, psAppViewRef);
                        this.registerPSAppViewRef(psAppViewRef);
                    }
                }
            }
            if (this.isWFIAMode() && this.isEnableWF()) {
                if (!this.isDynamicView()) {
                    if (StringHelper.isNullOrEmpty((String)this.getWFStepValue())) {
                        IPSCodeList iPSCodeList = this.getPSDEWF().getWFStepPSDEField().getPSCodeList();
                        if (iPSCodeList != null && iPSCodeList.getPSCodeItems() != null) {
                            Iterator psCodeItems2 = iPSCodeList.getPSCodeItems();
                            while (psCodeItems2.hasNext()) {
                                IPSCodeItem iPSCodeItem2 = (IPSCodeItem)psCodeItems2.next();
                                Iterator psWFVersions = this.getPSWorkflow().getPSWFVersions();
                                if (psWFVersions == null) continue;
                                while (psWFVersions.hasNext()) {
                                    PSAppViewRef psAppViewRef6;
                                    String strPSAppDEViewId6;
                                    PSDEViewBase psDEViewBase4;
                                    String strViewRefMode6;
                                    IPSWFVersion iPSWFVersion = (IPSWFVersion)psWFVersions.next();
                                    if (iPSWFVersion.getWFVersion() == 1 && this.getRefPSAppView(strViewRefMode6 = StringHelper.format((String)"%1$s:%2$s", (Object)"EDITDATA", (Object)iPSCodeItem2.getValue()), true) == null) {
                                        strPDTParam2 = StringHelper.format((String)"%1$s:W:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)iPSCodeItem2.getValue());
                                        strPDTParam2 = strPDTParam2.toUpperCase();
                                        psDEViewBase4 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam2, true);
                                        if (psDEViewBase4 != null) {
                                            strPSAppDEViewId6 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase4.getPSDEVIEWBASEID());
                                            psAppViewRef6 = new PSAppViewRef();
                                            psAppViewRef6.setPSAPPVIEWREFNAME(strViewRefMode6);
                                            psAppViewRef6.setMINORPSAPPVIEWID(strPSAppDEViewId6);
                                            psAppViewRef6.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase4.getPSDEVIEWBASEID());
                                            psAppViewRef6.setParamValue("TRYMODE", true);
                                            this.registerPSAppViewRef(psAppViewRef6);
                                        }
                                    }
                                    if (this.getRefPSAppView(strViewRefMode6 = StringHelper.format((String)"%1$s:%2$s@%3$s", (Object)"EDITDATA", (Object)iPSCodeItem2.getValue(), (Object)iPSWFVersion.getWFVersion()), true) != null) continue;
                                    strPDTParam2 = StringHelper.format((String)"%1$s:%3$sW:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)iPSCodeItem2.getValue(), (Object)(iPSWFVersion.getWFVersion() == 1 ? "" : Integer.valueOf(iPSWFVersion.getWFVersion())));
                                    strPDTParam2 = strPDTParam2.toUpperCase();
                                    psDEViewBase4 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam2, true);
                                    if (psDEViewBase4 == null) continue;
                                    strPSAppDEViewId6 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase4.getPSDEVIEWBASEID());
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
                        Iterator psWFVersions = this.getPSWorkflow().getPSWFVersions();
                        if (psWFVersions != null) {
                            while (psWFVersions.hasNext()) {
                                IPSWFVersion iPSWFVersion = (IPSWFVersion)psWFVersions.next();
                                String strViewRefMode7 = StringHelper.format((String)"%1$s:%2$s@%3$s", (Object)"EDITDATA", (Object)this.getWFStepValue(), (Object)iPSWFVersion.getWFVersion());
                                if (this.getRefPSAppView(strViewRefMode7, true) != null) continue;
                                String strPDTParam6 = StringHelper.format((String)"%1$s:%3$sW:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)this.getWFStepValue(), (Object)(iPSWFVersion.getWFVersion() == 1 ? "" : Integer.valueOf(iPSWFVersion.getWFVersion())));
                                strPDTParam6 = strPDTParam6.toUpperCase();
                                psDEViewBase2 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam6, true);
                                if (psDEViewBase2 == null) continue;
                                String strPSAppDEViewId7 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                PSAppViewRef psAppViewRef7 = new PSAppViewRef();
                                psAppViewRef7.setPSAPPVIEWREFNAME(strViewRefMode7);
                                psAppViewRef7.setMINORPSAPPVIEWID(strPSAppDEViewId7);
                                psAppViewRef7.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                psAppViewRef7.setParamValue("TRYMODE", true);
                                this.registerPSAppViewRef(psAppViewRef7);
                            }
                        }
                    }
                } else {
                    strViewRefMode = StringHelper.format((String)"%1$s", (Object)"EDITDATAX");
                    if (this.getRefPSAppView(strViewRefMode, true) == null) {
                        PSDEViewBase psDEViewBase5 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT("REDIRECTVIEW", true);
                        if (psDEViewBase5 == null) {
                            strPDTParam3 = StringHelper.format((String)"%1$s:W", (Object)this.getPSDEWF().getCodeName());
                            strPDTParam3 = strPDTParam3.toUpperCase();
                            psDEViewBase5 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam3, true);
                        }
                        if (psDEViewBase5 != null) {
                            String strPSAppDEViewId8 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase5.getPSDEVIEWBASEID());
                            PSAppViewRef psAppViewRef8 = new PSAppViewRef();
                            psAppViewRef8.setPSAPPVIEWREFNAME(strViewRefMode);
                            psAppViewRef8.setMINORPSAPPVIEWID(strPSAppDEViewId8);
                            psAppViewRef8.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase5.getPSDEVIEWBASEID());
                            psAppViewRef8.setParamValue("TRYMODE", true);
                            this.registerPSAppViewRef(psAppViewRef8);
                        }
                    }
                    String strPDTParam7 = StringHelper.format((String)"%1$s:W", (Object)this.getPSDEWF().getCodeName());
                    strPDTParam7 = strPDTParam7.toUpperCase();
                    if (!StringHelper.isNullOrEmpty((String)strPDTParamPre)) {
                        strPDTParam7 = String.valueOf(strPDTParamPre) + strPDTParam7;
                    }
                    strPDTParam7 = String.valueOf(strPDTHeader) + "WFEDITVIEW" + ":" + strPDTParam7;
                    Iterator<PSDEViewBase> psDEViewBaseList = this.getPSDataEntityRuntime().getPSDEViewDatasByPDT(strPDTParam7);
                    if (psDEViewBaseList != null) {
                        while (psDEViewBaseList.hasNext()) {
                            psDEViewBase3 = psDEViewBaseList.next();
                            strPSAppDEViewId3 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
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
            if (!this.isWFIAMode() && (psDEMainStates = this.getPSDataEntityRuntime().getAllPSDEMainStates()) != null) {
                while (psDEMainStates.hasNext()) {
                    IPSDEMainState iPSDEMainState = (IPSDEMainState)psDEMainStates.next();
                    strPDTParam3 = StringHelper.format((String)"MSTAG:%1$s", (Object)iPSDEMainState.getMSTag());
                    strPDTParam3 = strPDTParam3.toUpperCase();
                    psDEViewBase3 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", strPDTParamPre, strPDTParam3, true);
                    if (psDEViewBase3 == null) continue;
                    strViewRefMode2 = StringHelper.format((String)"%1$s:MSTAG:%2$s", (Object)"EDITDATA", (Object)iPSDEMainState.getMSTag());
                    String strViewRefModeDesc3 = StringHelper.format((String)"\u7f16\u8f91\u89c6\u56fe|\u4e3b\u72b6\u6001[%1$s]", (Object)iPSDEMainState.getName());
                    if (this.psAppViewRefMap.containsKey(strViewRefMode2 = strViewRefMode2.toUpperCase())) continue;
                    strPSAppDEViewId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                    psAppViewRef = new PSAppViewRef();
                    psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                    psAppViewRef.setREFMODETEXT(strViewRefModeDesc3);
                    psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                    psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                    psAppViewRef.setParamValue("TRYMODE", true);
                    iPSAppViewRef = new PSAppViewRefImpl();
                    ((IPSAppViewRefRuntime)iPSAppViewRef).init(this.getPSModelStorageContext(), this, psAppViewRef);
                    this.psAppViewRefMap.put(strViewRefMode2, iPSAppViewRef);
                }
            }
            strViewRefMode = StringHelper.format((String)"%1$s", (Object)"EDITDATA");
            strViewRefModeDesc = "\u7f16\u8f91\u89c6\u56fe";
            iPSAppView = this.getRefPSAppView(strViewRefMode, true);
            if (iPSAppView == null) {
                psDEViewBase3 = null;
                if (this.isEnableWF()) {
                    if (this.isWFIAMode()) {
                        if (!StringHelper.isNullOrEmpty((String)this.getWFStepValue())) {
                            strPDTParam = StringHelper.format((String)"%1$s:W:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)this.getWFStepValue());
                            strPDTParam = strPDTParam.toUpperCase();
                            psDEViewBase3 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam, true);
                        } else {
                            strPDTParam = StringHelper.format((String)"%1$s:W", (Object)this.getPSDEWF().getCodeName());
                            strPDTParam = strPDTParam.toUpperCase();
                            psDEViewBase3 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam, true);
                        }
                    } else {
                        strPDTParam = StringHelper.format((String)"%1$s:D", (Object)this.getPSDEWF().getCodeName());
                        strPDTParam = strPDTParam.toUpperCase();
                        psDEViewBase3 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam, true);
                    }
                } else {
                    psDEViewBase3 = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", "", true);
                }
                if (psDEViewBase3 != null) {
                    strPSAppDEViewId3 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
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
            PSAppViewRefImpl iPSAppViewRef6;
            PSAppViewRef psAppViewRef9;
            String strPSAppDEViewId9;
            IPSDERNN iPSDERNN = this.getPSDataEntityRuntime().getPSDERNN();
            String strMPickupViewTag = StringHelper.format((String)"%1$s:%2$s", (Object)"MPICKUPVIEW", (Object)iPSDERNN.getFirstPSDER1N().getCodeName());
            strViewRefModeDesc2 = StringHelper.format((String)"\u6279\u6dfb\u52a0\u591a\u9009\u89c6\u56fe|%1$s", (Object)iPSDERNN.getFirstPSDER1N().getMajorPSDataEntity().getLogicName());
            if (!this.psAppViewRefMap.containsKey(strMPickupViewTag = strMPickupViewTag.toUpperCase()) && !StringHelper.isNullOrEmpty((String)((IPSDER1NRuntime)iPSDERNN.getFirstPSDER1N()).getRefMPickupPSDEViewId())) {
                strPSAppDEViewId9 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)((IPSDER1NRuntime)iPSDERNN.getFirstPSDER1N()).getRefMPickupPSDEViewId());
                psAppViewRef9 = new PSAppViewRef();
                psAppViewRef9.setPSAPPVIEWREFNAME(strMPickupViewTag);
                psAppViewRef9.setREFMODETEXT(strViewRefModeDesc2);
                psAppViewRef9.setMINORPSAPPVIEWID(strPSAppDEViewId9);
                psAppViewRef9.setParamValue("MINORPSDEVIEWBASEID", ((IPSDER1NRuntime)iPSDERNN.getFirstPSDER1N()).getRefMPickupPSDEViewId());
                psAppViewRef9.setParamValue("TRYMODE", true);
                iPSAppViewRef6 = new PSAppViewRefImpl();
                ((IPSAppViewRefRuntime)iPSAppViewRef6).init(this.getPSModelStorageContext(), this, psAppViewRef9);
                this.psAppViewRefMap.put(strMPickupViewTag, iPSAppViewRef6);
            }
            strMPickupViewTag = StringHelper.format((String)"%1$s:%2$s", (Object)"MPICKUPVIEW", (Object)iPSDERNN.getSecondPSDER1N().getCodeName());
            strViewRefModeDesc2 = StringHelper.format((String)"\u6279\u6dfb\u52a0\u591a\u9009\u89c6\u56fe|%1$s", (Object)iPSDERNN.getSecondPSDER1N().getMajorPSDataEntity().getLogicName());
            if (!this.psAppViewRefMap.containsKey(strMPickupViewTag = strMPickupViewTag.toUpperCase()) && !StringHelper.isNullOrEmpty((String)((IPSDER1NRuntime)iPSDERNN.getSecondPSDER1N()).getRefMPickupPSDEViewId())) {
                strPSAppDEViewId9 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)((IPSDER1NRuntime)iPSDERNN.getSecondPSDER1N()).getRefMPickupPSDEViewId());
                psAppViewRef9 = new PSAppViewRef();
                psAppViewRef9.setPSAPPVIEWREFNAME(strMPickupViewTag);
                psAppViewRef9.setREFMODETEXT(strViewRefModeDesc2);
                psAppViewRef9.setMINORPSAPPVIEWID(strPSAppDEViewId9);
                psAppViewRef9.setParamValue("MINORPSDEVIEWBASEID", ((IPSDER1NRuntime)iPSDERNN.getSecondPSDER1N()).getRefMPickupPSDEViewId());
                psAppViewRef9.setParamValue("TRYMODE", true);
                iPSAppViewRef6 = new PSAppViewRefImpl();
                ((IPSAppViewRefRuntime)iPSAppViewRef6).init(this.getPSModelStorageContext(), this, psAppViewRef9);
                this.psAppViewRefMap.put(strMPickupViewTag, iPSAppViewRef6);
            }
        }
    }

    @PSModelRTMeta(description="\u652f\u6301\u67e5\u770b\u6570\u636e")
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
    @PSModelRTMeta(description="\u652f\u6301\u65b0\u5efa\u6570\u636e")
    public boolean isEnableNewData() {
        if (this.isPickupMode()) {
            return false;
        }
        return super.isEnableNewData();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91\u6570\u636e")
    public boolean isEnableEditData() {
        if (this.isPickupMode()) {
            return false;
        }
        return super.isEnableEditData();
    }

    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u5bfc\u5165")
    public boolean isEnableImport() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x400L) > 0L;
        }
        return false;
    }

    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u5bfc\u51fa")
    public boolean isEnableExport() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x40L) > 0L;
        }
        return false;
    }

    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u8fc7\u6ee4")
    public boolean isEnableFilter() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x100L) > 0L;
        }
        return this.isEnableSearch();
    }

    @PSModelRTMeta(description="\u652f\u6301\u5feb\u901f\u641c\u7d22")
    public boolean isEnableQuickSearch() {
        return this.bEnableQuickSearch;
    }

    @PSModelRTMeta(description="\u652f\u6301\u641c\u7d22")
    public boolean isEnableSearch() {
        return this.getPSDESearchForm() != null;
    }

    @PSModelRTMeta(description="\u542f\u7528\u5feb\u901f\u5efa\u7acb")
    public boolean isEnableQuickCreate() {
        return StringHelper.compare((String)this.getNewDataMode(), (String)"WIZARD", (boolean)true) == 0;
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (this.isEnableQuickSearch()) {
            this.registerPSAppViewParam("UI.ENABLEQUICKSEARCH", "TRUE", "\u652f\u6301\u5feb\u901f\u641c\u7d22");
        }
        if (this.isEnableSearch()) {
            this.registerPSAppViewParam("UI.ENABLESEARCH", "TRUE", "\u652f\u6301\u641c\u5e38\u89c4\u7d22");
        }
        super.onPreparePSAppViewParams();
    }

    protected boolean isEnableQuickSearchDefault() {
        return this.bEnableQuickSearchDefault;
    }

    protected void setEnableQuickSearchDefault(boolean bEnableQuickSearchDefault) {
        this.bEnableQuickSearchDefault = bEnableQuickSearchDefault;
    }

    public IPSDESearchForm getPSDESearchForm() {
        return this.iPSDESearchForm;
    }

    protected boolean isIgnoreMDViewCheck() {
        return this.isPickupMode() || this.isPickupView();
    }
}

