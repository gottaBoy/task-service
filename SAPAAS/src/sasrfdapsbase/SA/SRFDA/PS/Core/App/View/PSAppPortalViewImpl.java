/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppPortalView;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboardContainer;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBPortletPartParamImpl;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDashboardParamImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSAppPortalView;
import SA.SRFDA.PS.Data.PSAppPortalViewPart;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Vector;

public class PSAppPortalViewImpl
extends PSAppViewImpl
implements IPSAppPortalView {
    protected PSAppPortalView psAppPortalView = new PSAppPortalView();
    protected boolean bDefaultPage = false;
    public static final String CTRL_DASHBOARD = "dashboard";
    public static final String CTRL_DASHBOARD2 = "db_";
    private IPSDashboard iPSDashboard = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.initPSDashboard();
    }

    protected void initPSDashboard() throws Exception {
        String strLayoutMode;
        CallResult callResult = this.getPSModelHelper().getPSAppPortalView(this.psApplicationView.getPSAPPVIEWID(), this.psAppPortalView);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u95e8\u6237\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (!this.psAppPortalView.isDEFAULTPAGENull()) {
            this.bDefaultPage = this.psAppPortalView.getDEFAULTPAGE();
        }
        if (StringHelper.IsNullOrEmpty((String)(strLayoutMode = this.psAppPortalView.getLAYOUTMODE()))) {
            strLayoutMode = this.getPSApplication().getPSPF().getPanelLayoutMode();
        }
        PSDashboardParamImpl psDashboardParamImpl = new PSDashboardParamImpl();
        psDashboardParamImpl.setColumnModels(this.calcColModels(this.psAppPortalView.getCOLMODEL()));
        psDashboardParamImpl.setLayoutMode(strLayoutMode);
        psDashboardParamImpl.setFlexDir(this.psAppPortalView.getFLEXDIR());
        psDashboardParamImpl.setFlexAlign(this.psAppPortalView.getFLEXALIGN());
        psDashboardParamImpl.setFlexVAlign(this.psAppPortalView.getFLEXVALIGN());
        psDashboardParamImpl.setEnableCustomized(this.psAppPortalView.getENABLECUSTOMIZE() > 0);
        if (psDashboardParamImpl.isEnableCustomized().booleanValue()) {
            psDashboardParamImpl.setCustomizeMode(this.psAppPortalView.getENABLECUSTOMIZE());
        }
        psDashboardParamImpl.setDashboardStyle(this.psAppPortalView.getDASHBOARDSTYLE());
        psDashboardParamImpl.setDashboardTag(this.psAppPortalView.getDASHBOARDTAG());
        psDashboardParamImpl.setDashboardTag2(this.psAppPortalView.getDASHBOARDTAG2());
        if (!this.psAppPortalView.isDASHBOARDNAVBARNull()) {
            psDashboardParamImpl.setShowDashboardNavBar(this.psAppPortalView.getDASHBOARDNAVBAR());
        }
        psDashboardParamImpl.setNavBarPos(this.psAppPortalView.getNAVBARPOS());
        psDashboardParamImpl.setNavBarStyle(this.psAppPortalView.getNAVBARSTYLE());
        psDashboardParamImpl.setNavBarPSSysCssId(this.psAppPortalView.getNAVBARPSSYSCSSID());
        if (!this.psAppPortalView.isNAVBARWIDTHNull()) {
            psDashboardParamImpl.setNavBarWidth(Double.valueOf(this.psAppPortalView.getNAVBARWIDTH()));
        }
        if (!this.psAppPortalView.isNAVBARHEIGHTNull()) {
            psDashboardParamImpl.setNavBarHeight(Double.valueOf(this.psAppPortalView.getNAVBARHEIGHT()));
        }
        this.iPSDashboard = (IPSDashboard)this.registerPSControl(CTRL_DASHBOARD, "DASHBOARD", psDashboardParamImpl);
        Vector<PSAppPortalViewPart> psAppPortalViewPartList = new Vector<PSAppPortalViewPart>();
        callResult = this.getPSModelHelper().getPSAppPortalViewParts(this.psApplicationView.getPSAPPVIEWID(), psAppPortalViewPartList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u95e8\u6237\u89c6\u56fe\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        int nMaxColCount = 12;
        boolean bConvert12Ro24 = false;
        int nScale = 1;
        if (StringHelper.Compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            nMaxColCount = 24;
            bConvert12Ro24 = this.getPSApplication().getPSApplicationUI().isEnableCol12ToCol24();
            if (bConvert12Ro24) {
                nScale = 2;
            }
        }
        LinkedHashMap<String, PSAppPortalViewPart> psAppPortalViewPartMap = new LinkedHashMap<String, PSAppPortalViewPart>();
        for (PSAppPortalViewPart psAppPortalViewPart : psAppPortalViewPartList) {
            psAppPortalViewPartMap.put(psAppPortalViewPart.getPSAPPPVPARTID(), psAppPortalViewPart);
        }
        ArrayList<PSAppPortalViewPart> psAppPortalViewPartList2 = new ArrayList<PSAppPortalViewPart>();
        for (PSAppPortalViewPart psAppPortalViewPart : psAppPortalViewPartList) {
            if (StringHelper.IsNullOrEmpty((String)psAppPortalViewPart.getPPSAPPPVPARTID())) {
                psAppPortalViewPartList2.add(psAppPortalViewPart);
                continue;
            }
            PSAppPortalViewPart parentPSAppPortalViewPart = (PSAppPortalViewPart)((Object)psAppPortalViewPartMap.get(psAppPortalViewPart.getPPSAPPPVPARTID()));
            if (parentPSAppPortalViewPart == null) {
                throw new Exception(StringHelper.Format((String)"\u5e94\u7528\u6570\u636e\u770b\u677f\u89c6\u56fe[%1$s]\u6210\u5458[%2$s]\u7236\u5bf9\u8c61\u65e0\u6548", (Object)this.getName(), (Object)psAppPortalViewPart.getPSAPPPVPARTNAME()));
            }
            parentPSAppPortalViewPart.getChildPSAppPortalViewParts(true).add(psAppPortalViewPart);
        }
        this.registerPSAppPortalViewParts(this.iPSDashboard, psAppPortalViewPartList2, nMaxColCount, nScale);
    }

    protected void registerPSAppPortalViewParts(IPSDashboardContainer iPSDashboardContainer, ArrayList<PSAppPortalViewPart> psAppPortalViewPartList, int nMaxColCount, int nScale) throws Exception {
        boolean bFirst = true;
        for (PSAppPortalViewPart psAppPortalViewPart : psAppPortalViewPartList) {
            if (!psAppPortalViewPart.isVALIDFLAGNull() && !psAppPortalViewPart.getVALIDFLAG()) continue;
            PSDBPortletPartParamImpl psPortletParamImpl = new PSDBPortletPartParamImpl();
            psPortletParamImpl.setColumnId(psAppPortalViewPart.getCOLID());
            if (bFirst) {
                psPortletParamImpl.setNewRowMode(true);
                bFirst = false;
            } else if (psAppPortalViewPart.getNEWROWMODE()) {
                psPortletParamImpl.setNewRowMode(true);
            }
            if (!psAppPortalViewPart.isLAYOUTMODENull()) {
                psPortletParamImpl.setLayoutMode(psAppPortalViewPart.getLAYOUTMODE());
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
            if (!psAppPortalViewPart.isHEIGHTNull() && psAppPortalViewPart.getHEIGHT() >= 0) {
                psPortletParamImpl.setHeight(new Double(psAppPortalViewPart.getHEIGHT()));
            }
            if (!psAppPortalViewPart.isWIDTHNull() && psAppPortalViewPart.getWIDTH() >= 0) {
                psPortletParamImpl.setWidth(new Double(psAppPortalViewPart.getWIDTH()));
            }
            if (!psAppPortalViewPart.isSHOWTITLEBARNull()) {
                psPortletParamImpl.setShowTitleBar(psAppPortalViewPart.getSHOWTITLEBAR());
            }
            if (psAppPortalViewPart.getFLEXGROW() > 0) {
                psPortletParamImpl.setFlexGrow(psAppPortalViewPart.getFLEXGROW());
            }
            if (!psAppPortalViewPart.isFLEXBASISNull() && psAppPortalViewPart.getFLEXBASIS() >= 0) {
                psPortletParamImpl.setFlexBasis(psAppPortalViewPart.getFLEXBASIS());
            }
            if (!psAppPortalViewPart.isFLEXSHRINKNull() && psAppPortalViewPart.getFLEXSHRINK() >= 0) {
                psPortletParamImpl.setFlexShrink(psAppPortalViewPart.getFLEXSHRINK());
            }
            if (!psAppPortalViewPart.isFLEXALIGNNull()) {
                psPortletParamImpl.setFlexAlign(psAppPortalViewPart.getFLEXALIGN());
            }
            if (!psAppPortalViewPart.isFLEXVALIGNNull()) {
                psPortletParamImpl.setFlexVAlign(psAppPortalViewPart.getFLEXVALIGN());
            }
            if (!psAppPortalViewPart.isFLEXDIRNull()) {
                psPortletParamImpl.setFlexDir(psAppPortalViewPart.getFLEXDIR());
            }
            if (!psAppPortalViewPart.isBL_POSNull()) {
                psPortletParamImpl.setBorderLayoutPos(psAppPortalViewPart.getBL_POS());
            }
            if (!psAppPortalViewPart.isTITLEBARCLOSEMODENull()) {
                psPortletParamImpl.setTitleBarCloseMode(psAppPortalViewPart.getTITLEBARCLOSEMODE());
            }
            if (!psAppPortalViewPart.isCONTENTTYPENull()) {
                psPortletParamImpl.setContentType(psAppPortalViewPart.getCONTENTTYPE());
            }
            if (!psAppPortalViewPart.isRAWCONTENTNull()) {
                psPortletParamImpl.setRawContent(psAppPortalViewPart.getRAWCONTENT());
            }
            if (!psAppPortalViewPart.isHTMLCONTENTNull()) {
                psPortletParamImpl.setHtmlContent(psAppPortalViewPart.getHTMLCONTENT());
            }
            if (!psAppPortalViewPart.isPSSYSRESOURCEIDNull()) {
                psPortletParamImpl.setPSSysResourceId(psAppPortalViewPart.getPSSYSRESOURCEID());
            }
            if (!psAppPortalViewPart.isDYNACLASSNull()) {
                psPortletParamImpl.setDynaClass(psAppPortalViewPart.getDYNACLASS());
            }
            psPortletParamImpl.setPSSysPortletId(psAppPortalViewPart.getPSSYSPORTLETID());
            psPortletParamImpl.setPortletType(psAppPortalViewPart.getPVPARTTYPE());
            if (!StringHelper.IsNullOrEmpty((String)psAppPortalViewPart.getPORTLETTYPE())) {
                psPortletParamImpl.setPortletType(psAppPortalViewPart.getPORTLETTYPE());
            }
            if (!StringHelper.IsNullOrEmpty((String)psAppPortalViewPart.getPARTPARAMS())) {
                psPortletParamImpl.setCtrlParams(psAppPortalViewPart.getPARTPARAMS());
            }
            if (!psAppPortalViewPart.isENABLEANCHORNull()) {
                psPortletParamImpl.setEnableAnchor(psAppPortalViewPart.getENABLEANCHOR());
            }
            if (StringHelper.Compare((String)psAppPortalViewPart.getPVPARTTYPE(), (String)"APPMENU", (boolean)false) == 0) {
                psPortletParamImpl.setPortletType("APPMENU");
            }
            psPortletParamImpl.setAMListStyle(psAppPortalViewPart.getMOBAMTYLE());
            psPortletParamImpl.setPSAppMenuId(psAppPortalViewPart.getPSAPPMENUID());
            psPortletParamImpl.setPSSysPFPluginId(psAppPortalViewPart.getPSSYSPFPLUGINID());
            psPortletParamImpl.setAMPSSysPFPluginId(psAppPortalViewPart.getAMPSSYSPFPLUGINID());
            psPortletParamImpl.setTitle(psAppPortalViewPart.getTITLE());
            psPortletParamImpl.setTitlePSLanguageResId(psAppPortalViewPart.getTITLEPSLANRESID());
            psPortletParamImpl.setPSAppFuncPickupViewId(psAppPortalViewPart.getMENUPSAPPUTILVIEWID());
            psPortletParamImpl.setEmbededPSAppViewId(psAppPortalViewPart.getPSAPPVIEWID());
            psPortletParamImpl.setPSSysCssId(psAppPortalViewPart.getPSSYSCSSID());
            psPortletParamImpl.setPSSysImageId(psAppPortalViewPart.getPSSYSIMAGEID());
            IPSDBPortletPart iPSPortlet = (IPSDBPortletPart)this.getPSDashboard().registerPSControl(this.getPortletPartName(psAppPortalViewPart.getPSAPPPVPARTNAME()), "PORTLET", psPortletParamImpl);
            iPSDashboardContainer.registerPSPortlet(iPSPortlet);
            if (psAppPortalViewPart.getChildPSAppPortalViewParts(false) == null || !(iPSPortlet instanceof IPSDashboardContainer)) continue;
            this.registerPSAppPortalViewParts((IPSDashboardContainer)((Object)iPSPortlet), psAppPortalViewPart.getChildPSAppPortalViewParts(false), nMaxColCount, nScale);
        }
    }

    protected String getPortletPartName(String strName) {
        return CTRL_DASHBOARD2 + strName;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6570\u636e\u6743\u9650")
    public boolean isEnableDP() {
        return true;
    }

    @Override
    public boolean isEnableWF() {
        return false;
    }

    protected double[] calcColModels(String strColumnModel) throws Exception {
        String strColumns = strColumnModel;
        String[] columns = null;
        if (!StringHelper.IsNullOrEmpty((String)(strColumns = strColumns.trim()))) {
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
            if (StringHelper.IsNullOrEmpty((String)strColumn) || StringHelper.Compare((String)strColumn, (String)"*", (boolean)true) == 0) {
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

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8d77\u59cb\u89c6\u56fe", ignoredumpvalues="false", ignorert=3)
    public boolean isDefaultPage() {
        return this.bDefaultPage;
    }

    public IPSDashboard getPSDashboard() {
        return this.iPSDashboard;
    }

    protected void setPSDashboard(IPSDashboard iPSDashboard) {
        this.iPSDashboard = iPSDashboard;
    }

    @Override
    public boolean isEnablePullDownRefresh() {
        if (this.isMobileView()) {
            return true;
        }
        return true;
    }
}

