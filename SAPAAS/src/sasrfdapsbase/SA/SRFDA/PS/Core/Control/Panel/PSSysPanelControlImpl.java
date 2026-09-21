/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Calendar.PSSysCalendarParamImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartParamImpl;
import SA.SRFDA.PS.Core.Control.Dashboard.PSSysDashboardParamImpl;
import SA.SRFDA.PS.Core.Control.DataView.PSDEDataViewParamImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEEditFormParamImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDESearchFormParamImpl;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.List.PSDEListParamImpl;
import SA.SRFDA.PS.Core.Control.List.PSDEMobMDCtrlParamImpl;
import SA.SRFDA.PS.Core.Control.Map.PSSysMapParamImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelControl;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelItemImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarParamImpl;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeParamImpl;
import SA.SRFDA.PS.Core.Control.ViewPanel.PSDEViewPanelParamImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSPanelItem", typevalues={"CONTROL"})
public class PSSysPanelControlImpl
extends PSSysPanelItemImpl
implements IPSSysPanelControl {
    private IPSControl iPSControl = null;
    private String strViewFieldName = "";

    @Override
    protected void onInit() throws Exception {
        this.iPSControl = this.registerPSControl();
        super.onInit();
        this.strViewFieldName = this.psSysPanelItem.getFIELDNAME();
    }

    protected IPSControl registerPSControl() throws Exception {
        IPSControlContainer iPSControlContainer = this.getPSSysPanel().isLayoutPanel() ? this.getPSSysPanel().getPSAppView() : this.getPSSysPanel();
        String strCtrlName = this.getPSSysPanel().isLayoutPanel() ? String.valueOf(this.getPSSysPanel().getName()) + "_" + this.getName() : this.getName();
        boolean bEnableUIModelEx = this.getPSSysPanel().isEnableUIModelEx();
        if (bEnableUIModelEx) {
            strCtrlName = this.getName().toLowerCase();
        }
        strCtrlName = strCtrlName.toLowerCase();
        String strCtrlType = this.psSysPanelItem.getCTRLTYPE();
        if (StringHelper.compare((String)strCtrlType, (String)"CHART", (boolean)true) == 0) {
            PSDEChartParamImpl psDEChartParamImpl = new PSDEChartParamImpl();
            psDEChartParamImpl.setPSDEChartId(this.psSysPanelItem.getPSDECHARTID());
            psDEChartParamImpl.setPSDEDataSetId(this.psSysPanelItem.getPSDEDATASETID());
            psDEChartParamImpl.setActiveDataPSDELogicId(this.psSysPanelItem.getADPSDELOGICID());
            psDEChartParamImpl.setPSAjaxControlHandlerId(this.psSysPanelItem.getPSACHANDLERID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psDEChartParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psDEChartParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!this.psSysPanelItem.isACTIVEDATAMODENull() && this.psSysPanelItem.getACTIVEDATAMODE()) {
                psDEChartParamImpl.setActiveDataMode(true);
                psDEChartParamImpl.setActiveDataField(this.getViewFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psDEChartParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psDEChartParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "CHART", psDEChartParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("CHART");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEChartParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_chart", psDEChartParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"CALENDAR", (boolean)true) == 0) {
            PSSysCalendarParamImpl psSysCalendarParamImpl = new PSSysCalendarParamImpl();
            psSysCalendarParamImpl.setPSSysCalendarId(this.psSysPanelItem.getPSSYSCALENDARID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psSysCalendarParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psSysCalendarParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!this.psSysPanelItem.isACTIVEDATAMODENull() && this.psSysPanelItem.getACTIVEDATAMODE()) {
                psSysCalendarParamImpl.setActiveDataMode(true);
                psSysCalendarParamImpl.setActiveDataField(this.getViewFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psSysCalendarParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psSysCalendarParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "CALENDAR", psSysCalendarParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("CALENDAR");
            IPSControl iPSControl = iPSControlType.createPSControl(psSysCalendarParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_calendar", psSysCalendarParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"MAP", (boolean)true) == 0) {
            PSSysMapParamImpl psSysMapParamImpl = new PSSysMapParamImpl();
            psSysMapParamImpl.setPSSysMapViewId(this.psSysPanelItem.getPSSYSMAPVIEWID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psSysMapParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psSysMapParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!this.psSysPanelItem.isACTIVEDATAMODENull() && this.psSysPanelItem.getACTIVEDATAMODE()) {
                psSysMapParamImpl.setActiveDataMode(true);
                psSysMapParamImpl.setActiveDataField(this.getViewFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psSysMapParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psSysMapParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "MAP", psSysMapParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("MAP");
            IPSControl iPSControl = iPSControlType.createPSControl(psSysMapParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_map", psSysMapParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"DASHBOARD", (boolean)true) == 0) {
            PSSysDashboardParamImpl psSysDashboardParamImpl = new PSSysDashboardParamImpl();
            psSysDashboardParamImpl.setPSSysDashboardId(this.psSysPanelItem.getPSSYSDASHBOARDID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psSysDashboardParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psSysDashboardParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!this.psSysPanelItem.isACTIVEDATAMODENull() && this.psSysPanelItem.getACTIVEDATAMODE()) {
                psSysDashboardParamImpl.setActiveDataMode(true);
                psSysDashboardParamImpl.setActiveDataField(this.getViewFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psSysDashboardParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psSysDashboardParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "DASHBOARD", psSysDashboardParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("DASHBOARD");
            IPSControl iPSControl = iPSControlType.createPSControl(psSysDashboardParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_dashboard", psSysDashboardParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"DATAVIEW", (boolean)true) == 0) {
            PSDEDataViewParamImpl psDEDataViewParamImpl = new PSDEDataViewParamImpl();
            psDEDataViewParamImpl.setPSDEDataViewId(this.psSysPanelItem.getPSDEDATAVIEWID());
            psDEDataViewParamImpl.setPSDEDataSetId(this.psSysPanelItem.getPSDEDATASETID());
            psDEDataViewParamImpl.setActiveDataPSDELogicId(this.psSysPanelItem.getADPSDELOGICID());
            psDEDataViewParamImpl.setPSAjaxControlHandlerId(this.psSysPanelItem.getPSACHANDLERID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psDEDataViewParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psDEDataViewParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!this.psSysPanelItem.isACTIVEDATAMODENull() && this.psSysPanelItem.getACTIVEDATAMODE()) {
                psDEDataViewParamImpl.setActiveDataMode(true);
                psDEDataViewParamImpl.setActiveDataField(this.getViewFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psDEDataViewParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psDEDataViewParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "DATAVIEW", psDEDataViewParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("DATAVIEW");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEDataViewParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_dataview", psDEDataViewParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"FORM", (boolean)true) == 0) {
            PSDEEditFormParamImpl psDEFormParamImpl = new PSDEEditFormParamImpl();
            psDEFormParamImpl.setPSDEFormId(this.psSysPanelItem.getPSDEFORMID());
            psDEFormParamImpl.setPSAjaxControlHandlerId(this.psSysPanelItem.getPSACHANDLERID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psDEFormParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psDEFormParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!this.psSysPanelItem.isACTIVEDATAMODENull() && this.psSysPanelItem.getACTIVEDATAMODE()) {
                psDEFormParamImpl.setActiveDataMode(true);
                psDEFormParamImpl.setActiveDataField(this.getViewFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psDEFormParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psDEFormParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "FORM", psDEFormParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("FORM");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEFormParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_form", psDEFormParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"SEARCHFORM", (boolean)true) == 0) {
            PSDESearchFormParamImpl psDEFormParamImpl = new PSDESearchFormParamImpl();
            psDEFormParamImpl.setPSDEFormId(this.psSysPanelItem.getPSDESEARCHFORMID());
            psDEFormParamImpl.setPSAjaxControlHandlerId(this.psSysPanelItem.getPSACHANDLERID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psDEFormParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psDEFormParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psDEFormParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psDEFormParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "SEARCHFORM", psDEFormParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("SEARCHFORM");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEFormParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_searchform", psDEFormParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"GRID", (boolean)true) == 0) {
            PSDEGridParamImpl psDEGridParamImpl = new PSDEGridParamImpl();
            psDEGridParamImpl.setPSDEGridId(this.psSysPanelItem.getPSDEGRIDID());
            psDEGridParamImpl.setPSDEDataSetId(this.psSysPanelItem.getPSDEDATASETID());
            psDEGridParamImpl.setActiveDataPSDELogicId(this.psSysPanelItem.getADPSDELOGICID());
            psDEGridParamImpl.setPSAjaxControlHandlerId(this.psSysPanelItem.getPSACHANDLERID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psDEGridParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psDEGridParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!this.psSysPanelItem.isACTIVEDATAMODENull() && this.psSysPanelItem.getACTIVEDATAMODE()) {
                psDEGridParamImpl.setActiveDataMode(true);
                psDEGridParamImpl.setActiveDataField(this.getViewFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psDEGridParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psDEGridParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "GRID", psDEGridParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("GRID");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEGridParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_grid", psDEGridParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"LIST", (boolean)true) == 0) {
            PSDEListParamImpl psDEListParamImpl = new PSDEListParamImpl();
            psDEListParamImpl.setPSDEListId(this.psSysPanelItem.getPSDELISTID());
            psDEListParamImpl.setPSDEDataSetId(this.psSysPanelItem.getPSDEDATASETID());
            psDEListParamImpl.setActiveDataPSDELogicId(this.psSysPanelItem.getADPSDELOGICID());
            psDEListParamImpl.setPSAjaxControlHandlerId(this.psSysPanelItem.getPSACHANDLERID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psDEListParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psDEListParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!this.psSysPanelItem.isACTIVEDATAMODENull() && this.psSysPanelItem.getACTIVEDATAMODE()) {
                psDEListParamImpl.setActiveDataMode(true);
                psDEListParamImpl.setActiveDataField(this.getViewFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psDEListParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psDEListParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "LIST", psDEListParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("LIST");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEListParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_list", psDEListParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"MOBMDCTRL", (boolean)true) == 0) {
            PSDEMobMDCtrlParamImpl psDEListParamImpl = new PSDEMobMDCtrlParamImpl();
            psDEListParamImpl.setPSDEListId(this.psSysPanelItem.getPSDELISTID());
            psDEListParamImpl.setPSDEDataSetId(this.psSysPanelItem.getPSDEDATASETID());
            psDEListParamImpl.setActiveDataPSDELogicId(this.psSysPanelItem.getADPSDELOGICID());
            psDEListParamImpl.setPSAjaxControlHandlerId(this.psSysPanelItem.getPSACHANDLERID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psDEListParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psDEListParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!this.psSysPanelItem.isACTIVEDATAMODENull() && this.psSysPanelItem.getACTIVEDATAMODE()) {
                psDEListParamImpl.setActiveDataMode(true);
                psDEListParamImpl.setActiveDataField(this.getViewFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psDEListParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psDEListParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "MOBMDCTRL", psDEListParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("MOBMDCTRL");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEListParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_list", psDEListParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"TOOLBAR", (boolean)true) == 0) {
            PSDEToolbarParamImpl psDEToolbarParamImpl = new PSDEToolbarParamImpl();
            psDEToolbarParamImpl.setPSDEToolbarId(this.psSysPanelItem.getPSDETOOLBARID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psDEToolbarParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psDEToolbarParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psDEToolbarParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psDEToolbarParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "TOOLBAR", psDEToolbarParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("TOOLBAR");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEToolbarParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_toolbar", psDEToolbarParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"TREEVIEW", (boolean)true) == 0) {
            PSDETreeParamImpl psDETreeParamImpl = new PSDETreeParamImpl();
            psDETreeParamImpl.setPSDETreeId(this.psSysPanelItem.getPSDETREEVIEWID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psDETreeParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psDETreeParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!this.psSysPanelItem.isACTIVEDATAMODENull() && this.psSysPanelItem.getACTIVEDATAMODE()) {
                psDETreeParamImpl.setActiveDataMode(true);
                psDETreeParamImpl.setActiveDataField(this.getViewFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psDETreeParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psDETreeParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "TREEVIEW", psDETreeParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("TREEVIEW");
            IPSControl iPSControl = iPSControlType.createPSControl(psDETreeParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_tree", psDETreeParamImpl);
            return iPSControl;
        }
        if (StringHelper.compare((String)strCtrlType, (String)"VIEWPANEL", (boolean)true) == 0) {
            PSDEViewPanelParamImpl psDEViewPanelParamImpl = new PSDEViewPanelParamImpl();
            psDEViewPanelParamImpl.setPSDEViewId(this.psSysPanelItem.getPSDEVIEWBASEID());
            if (this.psSysPanelItem.getHEIGHT() > 0) {
                psDEViewPanelParamImpl.setHeight(Double.valueOf(this.psSysPanelItem.getHEIGHT()));
            }
            psDEViewPanelParamImpl.setCtrlParams(this.psSysPanelItem.getITEMPARAMS());
            if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getREFCTRLUSAGE())) {
                psDEViewPanelParamImpl.setInstallUIEngine(this.psSysPanelItem.getREFCTRLUSAGE());
                psDEViewPanelParamImpl.setRefCtrlName(this.psSysPanelItem.getREFCTRLNAME());
            }
            if (!this.getPSSystem().isEnableModelRT() || bEnableUIModelEx) {
                return iPSControlContainer.registerPSControl(strCtrlName, "VIEWPANEL", psDEViewPanelParamImpl);
            }
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("VIEWPANEL");
            IPSControl iPSControl = iPSControlType.createPSControl(psDEViewPanelParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), iPSControlContainer, String.valueOf(strCtrlName) + "_viewpanel", psDEViewPanelParamImpl);
            return iPSControl;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u5efa\u7acb\u9762\u677f\u90e8\u4ef6[%1$s]\uff0c\u65e0\u6cd5\u8bc6\u522b\u7684\u90e8\u4ef6\u7c7b\u578b[%2$s]", (Object)strCtrlName, (Object)strCtrlType));
    }

    @Override
    public void fillPSPanelFields(ArrayList<IPSPanelField> psSysViewPanelFieldList) {
    }

    @Override
    public void fillPSControls(ArrayList<IPSControl> psControlList) {
        if (this.getPSSystem().isEnableModelRT() && !this.getPSSysPanel().isEnableUIModelEx() && this.getPSControl() != null) {
            psControlList.add(this.getPSControl());
        }
    }

    @Override
    public String getModelType() {
        if (this.getPSSysPanel().isEnableUIModelEx()) {
            return "PSSYSVIEWPANELITEM_CTRLPOS";
        }
        return "PSSYSVIEWPANELITEM_CONTROL";
    }

    @Override
    protected String onGetItemType() {
        if (this.getPSSysPanel().isEnableUIModelEx()) {
            return "CTRLPOS";
        }
        return super.onGetItemType();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5bf9\u8c61", child=true)
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    @Override
    public String getFieldName() {
        return this.strViewFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6a21\u578b\u5c5e\u6027\u540d\u79f0", fields={"FIELDNAME"})
    public String getViewFieldName() {
        return this.getFieldName();
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (this.getPSSysPanel().isEnableUIModelEx()) {
            objectNode.remove("getPSControl");
            objectNode.remove("viewFieldName");
        }
    }
}

