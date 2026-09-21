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

import SA.SRFDA.PS.Core.App.View.IPSAppDECalendarView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppDEMultiDataView2Impl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendar;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItem;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItemRV;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERNN;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DECALENDARVIEW", "DECALENDARVIEW9"})
public class PSAppDECalendarViewImpl
extends PSAppDEMultiDataView2Impl
implements IPSAppDEView,
IPSAppDECalendarView {
    private static final Log log = LogFactory.getLog(PSAppDECalendarViewImpl.class);
    private IPSSysCalendar iPSSysCalendar = null;

    @Override
    protected boolean isEnableQuickSearchDefault() {
        return false;
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("calendar");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSSysCalendar) {
            this.iPSSysCalendar = (IPSSysCalendar)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    public IPSSysCalendar getPSSysCalendar() {
        return this.iPSSysCalendar;
    }

    @Override
    protected void onPreparePSAppDEMultiDataViewRefs() throws Exception {
        if (this.getPSSysCalendar() == null || this.isPickupMode()) {
            return;
        }
        Iterator<IPSSysCalendarItem> psDECalendarItems = this.getPSSysCalendar().getPSSysCalendarItems();
        while (psDECalendarItems.hasNext()) {
            IPSSysCalendarItem iPSSysCalendarItem = psDECalendarItems.next();
            this.onPreparePSPSSysCalendarItemRefs(iPSSysCalendarItem);
        }
    }

    protected void onPreparePSPSSysCalendarItemRefs(IPSSysCalendarItem iPSSysCalendarItem) throws Exception {
        PSAppViewRef psAppViewRef;
        String strPSAppDEViewId;
        String strViewRefMode;
        if (iPSSysCalendarItem.getPSDataEntity() == null) {
            return;
        }
        String strPDTHeader = "";
        Iterator<IPSSysCalendarItemRV> psSysCalendarItemRVs = iPSSysCalendarItem.getPSSysCalendarItemRVs();
        if (psSysCalendarItemRVs != null) {
            while (psSysCalendarItemRVs.hasNext()) {
                IPSSysCalendarItemRV iPSSysCalendarItemRV = psSysCalendarItemRVs.next();
                strViewRefMode = StringHelper.Format((String)"%1$s@%2$s", (Object)iPSSysCalendarItemRV.getName(), (Object)iPSSysCalendarItem.getItemType());
                IPSAppView iPSAppView = this.getRefPSAppView(strViewRefMode, true);
                if (iPSAppView != null) continue;
                strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)iPSSysCalendarItemRV.getPSDEViewBaseId());
                psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", iPSSysCalendarItemRV.getPSDEViewBaseId());
                this.registerPSAppViewRef(psAppViewRef);
            }
        }
        if (!iPSSysCalendarItem.isBatchAddOnly()) {
            PSDEViewBase psDEViewBase;
            String strViewRefMode2;
            IPSAppView iPSAppView;
            PSAppViewRef psAppViewRef2;
            String strPSAppDEViewId2;
            IPSDataEntity minorPSDataEntity;
            IPSDERIndex iPSDERIndex;
            Iterator<IPSDERIndex> psDERIndexs;
            PSDEViewBase psDEViewBase2;
            Iterator<PSDEViewBase> psDEViewBases;
            String strPDTParam;
            IPSCodeItem iPSCodeItem;
            PSDEViewBase psDEViewBase3;
            Iterator<IPSCodeItem> psCodeItems;
            IPSDEField mfPSDEField;
            IPSCodeList mfPSCodeList;
            IPSDEField iPSDEField;
            if (iPSSysCalendarItem.isEnableNewData()) {
                if (StringHelper.Compare((String)iPSSysCalendarItem.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 || StringHelper.Compare((String)iPSSysCalendarItem.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                    iPSDEField = null;
                    iPSDEField = StringHelper.Compare((String)iPSSysCalendarItem.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? iPSSysCalendarItem.getPSDataEntity().getFormTypePSDEField() : iPSSysCalendarItem.getPSDataEntity().getIndexTypePSDEField();
                    if (iPSDEField == null) {
                        log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u6570\u636e\u5206\u7c7b\u5c5e\u6027", (Object)iPSSysCalendarItem.getPSDataEntity().getName()));
                    }
                    if (this.getPSAppViewRef(strViewRefMode = StringHelper.Format((String)"%1$s@%2$s", (Object)"NEWDATAWIZARD", (Object)iPSSysCalendarItem.getItemType()), true) == null) {
                        String strEditViewTag = "";
                        strEditViewTag = StringHelper.Compare((String)iPSSysCalendarItem.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? (this.isMobileView() ? "MOBFORMPICKUPVIEW" : "FORMPICKUPVIEW") : (this.isMobileView() ? "MOBINDEXDEPICKUPVIEW" : "INDEXDEPICKUPVIEW");
                        PSDEViewBase psDEViewBase4 = iPSSysCalendarItem.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + strEditViewTag, true);
                        if (psDEViewBase4 != null) {
                            String strPSAppDEViewId3 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase4.getPSDEVIEWBASEID());
                            PSAppViewRef psAppViewRef3 = new PSAppViewRef();
                            psAppViewRef3.setPSAPPVIEWREFNAME(strViewRefMode);
                            psAppViewRef3.setMINORPSAPPVIEWID(strPSAppDEViewId3);
                            psAppViewRef3.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase4.getPSDEVIEWBASEID());
                            this.registerPSAppViewRef(psAppViewRef3);
                        } else {
                            log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u9884\u7f6e\u89c6\u56fe[%2$s]", (Object)iPSSysCalendarItem.getPSDataEntity().getName(), (Object)strEditViewTag));
                        }
                    }
                    if (StringHelper.Compare((String)iPSSysCalendarItem.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 && (mfPSCodeList = (mfPSDEField = iPSSysCalendarItem.getPSDataEntity().getFormTypePSDEField()).getPSCodeList()) != null) {
                        PSAppViewRef psAppViewRef4;
                        String strPSAppDEViewId4;
                        psCodeItems = mfPSCodeList.getPSCodeItems();
                        if (psCodeItems != null) {
                            while (psCodeItems.hasNext()) {
                                psDEViewBase3 = null;
                                iPSCodeItem = psCodeItems.next();
                                if (psDEViewBase3 == null) {
                                    strPDTParam = StringHelper.Format((String)"%1$s", (Object)iPSCodeItem.getValue());
                                    psDEViewBase3 = iPSSysCalendarItem.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), strPDTParam, true);
                                }
                                if (psDEViewBase3 == null) continue;
                                strViewRefMode = "";
                                if (!iPSSysCalendarItem.isEnableNewData()) continue;
                                strViewRefMode = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"NEWDATA", (Object)iPSCodeItem.getValue(), (Object)iPSSysCalendarItem.getItemType());
                                if (this.getPSAppViewRef(strViewRefMode = strViewRefMode.toUpperCase(), true) != null) continue;
                                strPSAppDEViewId4 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                                psAppViewRef4 = new PSAppViewRef();
                                psAppViewRef4.setPSAPPVIEWREFNAME(strViewRefMode);
                                psAppViewRef4.setMINORPSAPPVIEWID(strPSAppDEViewId4);
                                psAppViewRef4.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                                this.registerPSAppViewRef(psAppViewRef4);
                            }
                        } else {
                            psDEViewBases = iPSSysCalendarItem.getPSDataEntity().getPSDEViewDatasByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"));
                            if (psDEViewBases != null) {
                                while (psDEViewBases.hasNext()) {
                                    psDEViewBase2 = psDEViewBases.next();
                                    if (StringHelper.IsNullOrEmpty((String)psDEViewBase2.getPDVTPARAM())) continue;
                                    strViewRefMode = "";
                                    if (!this.isEnableNewData()) continue;
                                    strViewRefMode = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"NEWDATA", (Object)psDEViewBase2.getPDVTPARAM(), (Object)iPSSysCalendarItem.getItemType());
                                    if (this.getPSAppViewRef(strViewRefMode = strViewRefMode.toUpperCase(), true) != null) continue;
                                    strPSAppDEViewId4 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                    psAppViewRef4 = new PSAppViewRef();
                                    psAppViewRef4.setPSAPPVIEWREFNAME(strViewRefMode);
                                    psAppViewRef4.setMINORPSAPPVIEWID(strPSAppDEViewId4);
                                    psAppViewRef4.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                    this.registerPSAppViewRef(psAppViewRef4);
                                }
                            }
                        }
                    }
                    if (StringHelper.Compare((String)iPSSysCalendarItem.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                        psDERIndexs = iPSSysCalendarItem.getPSDataEntity().getPSDERIndexs(true);
                        while (psDERIndexs.hasNext()) {
                            iPSDERIndex = psDERIndexs.next();
                            minorPSDataEntity = iPSDERIndex.getMinorPSDataEntity();
                            strViewRefMode = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"NEWDATA", (Object)iPSDERIndex.getTypeValue(), (Object)iPSSysCalendarItem.getItemType());
                            if (this.getPSAppViewRef(strViewRefMode, true) != null || (psDEViewBase3 = minorPSDataEntity.getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), true)) == null) continue;
                            strPSAppDEViewId2 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                            psAppViewRef2 = new PSAppViewRef();
                            psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode);
                            psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                            psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                            this.registerPSAppViewRef(psAppViewRef2);
                        }
                    }
                }
                if ((iPSAppView = this.getRefPSAppView(strViewRefMode2 = StringHelper.Format((String)"%1$s@%2$s", (Object)"NEWDATA", (Object)iPSSysCalendarItem.getItemType()), true)) == null) {
                    psDEViewBase = null;
                    psDEViewBase = iPSSysCalendarItem.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), "", true);
                    if (psDEViewBase != null) {
                        strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                        psAppViewRef = new PSAppViewRef();
                        psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                        psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                        psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                        this.registerPSAppViewRef(psAppViewRef);
                    }
                }
            }
            if (iPSSysCalendarItem.isEnableEditData() || iPSSysCalendarItem.isEnableViewData()) {
                if (StringHelper.Compare((String)iPSSysCalendarItem.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0 || StringHelper.Compare((String)iPSSysCalendarItem.getEditDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                    iPSDEField = null;
                    iPSDEField = StringHelper.Compare((String)iPSSysCalendarItem.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? iPSSysCalendarItem.getPSDataEntity().getFormTypePSDEField() : iPSSysCalendarItem.getPSDataEntity().getIndexTypePSDEField();
                    if (iPSDEField == null) {
                        log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u6570\u636e\u5206\u7c7b\u5c5e\u6027", (Object)iPSSysCalendarItem.getPSDataEntity().getName()));
                    }
                    strViewRefMode = "";
                    if (StringHelper.Compare((String)iPSSysCalendarItem.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0 && (mfPSCodeList = (mfPSDEField = iPSSysCalendarItem.getPSDataEntity().getFormTypePSDEField()).getPSCodeList()) != null) {
                        psCodeItems = mfPSCodeList.getPSCodeItems();
                        if (psCodeItems != null) {
                            while (psCodeItems.hasNext()) {
                                psDEViewBase3 = null;
                                iPSCodeItem = psCodeItems.next();
                                if (psDEViewBase3 == null) {
                                    strPDTParam = StringHelper.Format((String)"%1$s", (Object)iPSCodeItem.getValue());
                                    psDEViewBase3 = iPSSysCalendarItem.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), strPDTParam, true);
                                }
                                if (psDEViewBase3 == null) continue;
                                strViewRefMode = "";
                            }
                        } else {
                            psDEViewBases = iPSSysCalendarItem.getPSDataEntity().getPSDEViewDatasByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"));
                            if (psDEViewBases != null) {
                                while (psDEViewBases.hasNext()) {
                                    psDEViewBase2 = psDEViewBases.next();
                                    if (StringHelper.IsNullOrEmpty((String)psDEViewBase2.getPDVTPARAM())) continue;
                                    strViewRefMode = "";
                                    this.isWFIAMode();
                                }
                            }
                        }
                    }
                    if (StringHelper.Compare((String)iPSSysCalendarItem.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                        psDERIndexs = iPSSysCalendarItem.getPSDataEntity().getPSDERIndexs(true);
                        while (psDERIndexs.hasNext()) {
                            iPSDERIndex = psDERIndexs.next();
                            minorPSDataEntity = iPSDERIndex.getMinorPSDataEntity();
                            strViewRefMode = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"EDITDATA", (Object)iPSDERIndex.getTypeValue(), (Object)iPSSysCalendarItem.getItemType());
                            if (this.getPSAppViewRef(strViewRefMode, true) != null || (psDEViewBase3 = minorPSDataEntity.getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), true)) == null) continue;
                            strPSAppDEViewId2 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                            psAppViewRef2 = new PSAppViewRef();
                            psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode);
                            psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                            psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                            this.registerPSAppViewRef(psAppViewRef2);
                        }
                    }
                }
                if ((iPSAppView = this.getRefPSAppView(strViewRefMode2 = StringHelper.Format((String)"%1$s@%2$s", (Object)"EDITDATA", (Object)iPSSysCalendarItem.getItemType()), true)) == null) {
                    psDEViewBase = null;
                    psDEViewBase = iPSSysCalendarItem.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + (this.isMobileView() ? "MOBEDITVIEW" : "EDITVIEW"), "", true);
                    if (psDEViewBase != null) {
                        strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                        psAppViewRef = new PSAppViewRef();
                        psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                        psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                        psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                        this.registerPSAppViewRef(psAppViewRef);
                    }
                }
            }
        }
        if (iPSSysCalendarItem.isEnableBatchAdd()) {
            PSAppViewRef psAppViewRef5;
            String strPSAppDEViewId5;
            IPSDERNN iPSDERNN = iPSSysCalendarItem.getPSDataEntity().getPSDERNN();
            String strMPickupViewTag = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"MPICKUPVIEW", (Object)iPSDERNN.getFirstPSDER().getCodeName(), (Object)iPSSysCalendarItem.getItemType());
            if (this.getPSAppViewRef(strMPickupViewTag = strMPickupViewTag.toUpperCase(), true) == null && !StringHelper.IsNullOrEmpty((String)iPSDERNN.getFirstPSDER().getRefMPickupPSDEViewId())) {
                strPSAppDEViewId5 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)iPSDERNN.getFirstPSDER().getRefMPickupPSDEViewId());
                psAppViewRef5 = new PSAppViewRef();
                psAppViewRef5.setPSAPPVIEWREFNAME(strMPickupViewTag);
                psAppViewRef5.setMINORPSAPPVIEWID(strPSAppDEViewId5);
                psAppViewRef5.setParamValue("MINORPSDEVIEWBASEID", iPSDERNN.getFirstPSDER().getRefMPickupPSDEViewId());
                this.registerPSAppViewRef(psAppViewRef5);
            }
            strMPickupViewTag = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"MPICKUPVIEW", (Object)iPSDERNN.getSecondPSDER().getCodeName(), (Object)iPSSysCalendarItem.getItemType());
            if (this.getPSAppViewRef(strMPickupViewTag = strMPickupViewTag.toUpperCase(), true) == null && !StringHelper.IsNullOrEmpty((String)iPSDERNN.getSecondPSDER().getRefMPickupPSDEViewId())) {
                strPSAppDEViewId5 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)iPSDERNN.getSecondPSDER().getRefMPickupPSDEViewId());
                psAppViewRef5 = new PSAppViewRef();
                psAppViewRef5.setPSAPPVIEWREFNAME(strMPickupViewTag);
                psAppViewRef5.setMINORPSAPPVIEWID(strPSAppDEViewId5);
                psAppViewRef5.setParamValue("MINORPSDEVIEWBASEID", iPSDERNN.getSecondPSDER().getRefMPickupPSDEViewId());
                this.registerPSAppViewRef(psAppViewRef5);
            }
        }
    }

    @Override
    protected String onGetXDataControlName() {
        return "calendar";
    }
}

