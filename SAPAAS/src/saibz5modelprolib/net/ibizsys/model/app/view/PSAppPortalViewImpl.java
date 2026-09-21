/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppPortalView
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.control.dashboard.IPSDashboard
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.app.view;

import java.util.Vector;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppPortalView;
import net.ibizsys.model.app.view.PSAppViewImpl;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.dashboard.IPSDashboard;
import net.ibizsys.model.control.dashboard.PSDBPortletParamPartImpl;
import net.ibizsys.model.control.dashboard.PSDashboardParamImpl;
import net.ibizsys.model.entity.PSAppPortalView;
import net.ibizsys.model.entity.PSAppPortalViewPart;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;

public class PSAppPortalViewImpl
extends PSAppViewImpl
implements IPSAppPortalView {
    protected PSAppPortalView psAppPortalView = new PSAppPortalView();
    protected boolean bDefaultPage = false;
    public static final String CTRL_DASHBOARD = "dashboard";
    public static final String CTRL_DASHBOARD2 = "db_";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        CallResult callResult = this.getPSModelQueryHelper().getPSAppPortalView(this.psApplicationView.getPSAPPVIEWID(), this.psAppPortalView);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u95e8\u6237\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (!this.psAppPortalView.isDEFAULTPAGENull()) {
            this.bDefaultPage = this.psAppPortalView.getDEFAULTPAGE();
        }
        IPSDashboard iPSDashboard = null;
        PSDashboardParamImpl psDashboardParamImpl = new PSDashboardParamImpl();
        psDashboardParamImpl.setColumnModels(this.calcColModels(this.psAppPortalView.getCOLMODEL()));
        iPSDashboard = (IPSDashboard)this.registerPSControl(CTRL_DASHBOARD, "DASHBOARD", psDashboardParamImpl);
        Vector<PSAppPortalViewPart> psAppPortalViewPartList = new Vector<PSAppPortalViewPart>();
        callResult = this.getPSModelQueryHelper().getPSAppPortalViewParts(this.psApplicationView.getPSAPPVIEWID(), psAppPortalViewPartList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u95e8\u6237\u89c6\u56fe\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        int nMaxColCount = 12;
        boolean bConvert12Ro24 = false;
        int nScale = 1;
        String strLayoutMode = this.getPSApplication().getPSApplicationUI().getFormLayoutMode();
        if (StringHelper.compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            nMaxColCount = 24;
            bConvert12Ro24 = this.getPSApplication().getPSApplicationUI().isEnableCol12ToCol24();
            if (bConvert12Ro24) {
                nScale = 2;
            }
        }
        boolean bFirst = true;
        for (PSAppPortalViewPart psAppPortalViewPart : psAppPortalViewPartList) {
            if (!psAppPortalViewPart.isVALIDFLAGNull() && !psAppPortalViewPart.getVALIDFLAG()) continue;
            PSDBPortletParamPartImpl psPortletParamImpl = new PSDBPortletParamPartImpl();
            psPortletParamImpl.setColumnId(psAppPortalViewPart.getCOLID());
            if (bFirst) {
                psPortletParamImpl.setNewRowMode(true);
                bFirst = false;
            } else if (psAppPortalViewPart.getNEWROWMODE()) {
                psPortletParamImpl.setNewRowMode(true);
            }
            if (psAppPortalViewPart.getCOLSPAN() > 0) {
                psPortletParamImpl.setColumnSpan(psAppPortalViewPart.getCOLSPAN() * nScale);
            }
            if (psAppPortalViewPart.getCOL_LG() > 0 && psAppPortalViewPart.getCOL_LG() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColLG(psAppPortalViewPart.getCOL_LG() * nScale);
            }
            if (psAppPortalViewPart.getCOL_LG_OS() > 0 && psAppPortalViewPart.getCOL_LG_OS() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColLGOffset(psAppPortalViewPart.getCOL_LG_OS() * nScale);
            }
            if (psAppPortalViewPart.getCOL_MD() > 0 && psAppPortalViewPart.getCOL_MD() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColMD(psAppPortalViewPart.getCOL_MD() * nScale);
            }
            if (psAppPortalViewPart.getCOL_MD_OS() > 0 && psAppPortalViewPart.getCOL_MD_OS() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColMDOffset(psAppPortalViewPart.getCOL_MD_OS() * nScale);
            }
            if (psAppPortalViewPart.getCOL_SM() > 0 && psAppPortalViewPart.getCOL_SM() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColSM(psAppPortalViewPart.getCOL_SM() * nScale);
            }
            if (psAppPortalViewPart.getCOL_SM_OS() > 0 && psAppPortalViewPart.getCOL_SM_OS() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColSMOffset(psAppPortalViewPart.getCOL_SM_OS() * nScale);
            }
            if (psAppPortalViewPart.getCOL_XS() > 0 && psAppPortalViewPart.getCOL_XS() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColXS(psAppPortalViewPart.getCOL_XS() * nScale);
            }
            if (psAppPortalViewPart.getCOL_XS_OS() > 0 && psAppPortalViewPart.getCOL_XS_OS() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColXSOffset(psAppPortalViewPart.getCOL_XS_OS() * nScale);
            }
            if (psAppPortalViewPart.getHEIGHT() > 0) {
                psPortletParamImpl.setHeight(new Double(psAppPortalViewPart.getHEIGHT()));
            }
            if (!psAppPortalViewPart.isSHOWTITLEBARNull()) {
                psPortletParamImpl.setShowTitleBar(psAppPortalViewPart.getSHOWTITLEBAR());
            }
            psPortletParamImpl.setPSSysPortletId(psAppPortalViewPart.getPSSYSPORTLETID());
            psPortletParamImpl.setPortletType(psAppPortalViewPart.getPORTLETTYPE());
            psPortletParamImpl.setAMListStyle(psAppPortalViewPart.getMOBAMTYLE());
            psPortletParamImpl.setPSAppMenuId(psAppPortalViewPart.getPSAPPMENUID());
            psPortletParamImpl.setAMPSSysPFPluginId(psAppPortalViewPart.getAMPSSYSPFPLUGINID());
            psPortletParamImpl.setTitle(psAppPortalViewPart.getTITLE());
            psPortletParamImpl.setTitlePSLanguageResId(psAppPortalViewPart.getTITLEPSLANRESID());
            if (StringHelper.compare((String)psAppPortalViewPart.getPVPARTTYPE(), (String)"APPMENU", (boolean)false) == 0) {
                psPortletParamImpl.setPortletType("APPMENU");
            }
            IPSDBPortletPart iPSPortlet = (IPSDBPortletPart)iPSDashboard.registerPSControl(CTRL_DASHBOARD2 + psAppPortalViewPart.getPSAPPPVPARTNAME(), "PORTLET", (IPSControlParam)psPortletParamImpl);
            iPSDashboard.registerPSPortlet(iPSPortlet);
        }
    }

    @PSModelRTMeta(description="\u542f\u7528\u6570\u636e\u6743\u9650")
    public boolean isEnableDP() {
        return true;
    }

    public boolean isEnableWF() {
        return false;
    }

    protected double[] calcColModels(String strColumnModel) throws Exception {
        String strColumns = strColumnModel;
        String[] columns = null;
        if (!StringHelper.isNullOrEmpty((String)(strColumns = strColumns.trim()))) {
            strColumns = strColumns.replace("\uff1b", ";");
            strColumns = strColumns.replace("\uff0c", ";");
            strColumns = strColumns.replace(",", ";");
            columns = strColumns.split("[;]");
        } else {
            columns = new String[]{"*"};
        }
        int nStarCount = 0;
        double[] columnWidths = new double[columns.length];
        double fTotal = 1.0;
        int i = 0;
        while (i < columns.length) {
            String strColumn = columns[i];
            if (StringHelper.isNullOrEmpty((String)strColumn) || StringHelper.compare((String)strColumn, (String)"*", (boolean)true) == 0) {
                ++nStarCount;
                columnWidths[i] = 0.0;
            } else if (strColumn.indexOf("%") == -1) {
                columnWidths[i] = Double.parseDouble(strColumn);
            } else {
                strColumn = strColumn.replace("%", "");
                columnWidths[i] = Double.parseDouble(strColumn) / 100.0;
                if (columnWidths[i] <= 1.0) {
                    fTotal -= columnWidths[i];
                }
            }
            ++i;
        }
        if (nStarCount > 0) {
            double fStarWidth = fTotal / (double)nStarCount;
            int i2 = 0;
            while (i2 < columns.length) {
                if (columnWidths[i2] == 0.0) {
                    columnWidths[i2] = fStarWidth;
                }
                ++i2;
            }
        }
        return columnWidths;
    }

    @Override
    public String getModelType() {
        return "PSAPPPORTALVIEW";
    }

    @PSModelRTMeta(description="\u5e94\u7528\u8d77\u59cb\u89c6\u56fe")
    public boolean isDefaultPage() {
        return this.bDefaultPage;
    }
}

