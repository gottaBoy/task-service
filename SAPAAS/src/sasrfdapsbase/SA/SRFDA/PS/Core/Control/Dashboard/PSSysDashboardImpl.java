/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboardContainer;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSSysDashboard;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSSysDashboardLogic;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSSysDashboardParam;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBPortletPartParamImpl;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDashboardImpl;
import SA.SRFDA.PS.Core.Control.Dashboard.PSSysDashboardLogicImpl;
import SA.SRFDA.PS.Core.Control.Dashboard.PSSysDashboardParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysDashboard;
import SA.SRFDA.PS.Data.PSSysDashboardLogic;
import SA.SRFDA.PS.Data.PSSysDashboardPart;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"DASHBOARD"})
public class PSSysDashboardImpl
extends PSDashboardImpl
implements IPSSysDashboard {
    private static final Log log = LogFactory.getLog(PSSysDashboardImpl.class);
    protected PSSysDashboard psSysDashboard;
    protected PSSysDashboardParamImpl psSysDashboardParamImpl = null;
    private String strCodeName = "";
    private boolean bInvalidId = false;
    protected List<PSSysDashboardLogicImpl> psSysDashboardLogicList = new ArrayList<PSSysDashboardLogicImpl>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            if (iPSControlParam instanceof IPSSysDashboardParam) {
                String strLayoutMode;
                IPSSysDashboardParam iPSSysDashboardParam = (IPSSysDashboardParam)iPSControlParam;
                this.psSysDashboardParamImpl = new PSSysDashboardParamImpl();
                this.psSysDashboard = new PSSysDashboard();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSSysDashboardParam.getPSSysDashboardId())) {
                    CallResult callResult = this.getPSModelHelper().getPSSysDashboard(iPSSysDashboardParam.getPSSysDashboardId(), this.psSysDashboard);
                    if (callResult.isError()) {
                        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u6570\u636e\u770b\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    this.setId(this.psSysDashboard.getPSSYSDASHBOARDID());
                } else {
                    this.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                    this.bInvalidId = true;
                }
                this.setName(strName);
                this.setLogicName(this.psSysDashboard.getPSSYSDASHBOARDNAME());
                this.setPSObjectData(this.psSysDashboard);
                this.psSysDashboardParamImpl.setPSSysPFPluginId(this.psSysDashboard.getPSSYSPFPLUGINID());
                this.psSysDashboardParamImpl.setPSSysCssId(this.psSysDashboard.getPSSYSCSSID());
                this.psSysDashboardParamImpl.setPSDEUILogicGroupId(this.psSysDashboard.getPSCTRLLOGICGROUPID());
                this.psSysDashboardParamImpl.setColumnModels(this.calcColModels(this.psSysDashboard.getCOLMODEL()));
                this.strCodeName = this.psSysDashboard.getCODENAME();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                    this.strCodeName = this.getName();
                }
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strLayoutMode = this.psSysDashboard.getLAYOUTMODE()))) {
                    strLayoutMode = this.isDesignMode() ? this.getPreviewPSPF().getFormLayoutMode() : this.getPSAppView().getPSApplication().getPSPF().getPanelLayoutMode();
                }
                this.psSysDashboardParamImpl.setLayoutMode(strLayoutMode);
                this.psSysDashboardParamImpl.setFlexDir(this.psSysDashboard.getFLEXDIR());
                this.psSysDashboardParamImpl.setFlexAlign(this.psSysDashboard.getFLEXALIGN());
                this.psSysDashboardParamImpl.setFlexVAlign(this.psSysDashboard.getFLEXVALIGN());
                if (!this.psSysDashboard.isENABLECUSTOMIZEDNull()) {
                    this.psSysDashboardParamImpl.setEnableCustomized(this.psSysDashboard.getENABLECUSTOMIZED() > 0);
                    if (this.psSysDashboardParamImpl.isEnableCustomized().booleanValue()) {
                        this.psSysDashboardParamImpl.setCustomizeMode(this.psSysDashboard.getENABLECUSTOMIZED());
                    }
                }
                this.psSysDashboardParamImpl.setDashboardStyle(this.psSysDashboard.getDASHBOARDSTYLE());
                this.psSysDashboardParamImpl.setDashboardTag(this.psSysDashboard.getDASHBOARDTAG());
                this.psSysDashboardParamImpl.setDashboardTag2(this.psSysDashboard.getDASHBOARDTAG2());
                if (!this.psSysDashboard.isDASHBOARDNAVBARNull()) {
                    this.psSysDashboardParamImpl.setShowDashboardNavBar(this.psSysDashboard.getDASHBOARDNAVBAR());
                }
                this.psSysDashboardParamImpl.setNavBarPos(this.psSysDashboard.getNAVBARPOS());
                this.psSysDashboardParamImpl.setNavBarStyle(this.psSysDashboard.getNAVBARSTYLE());
                this.psSysDashboardParamImpl.setNavBarPSSysCssId(this.psSysDashboard.getNAVBARPSSYSCSSID());
                if (!this.psSysDashboard.isNAVBARWIDTHNull()) {
                    this.psSysDashboardParamImpl.setNavBarWidth(Double.valueOf(this.psSysDashboard.getNAVBARWIDTH()));
                }
                if (!this.psSysDashboard.isNAVBARHEIGHTNull()) {
                    this.psSysDashboardParamImpl.setNavBarHeight(Double.valueOf(this.psSysDashboard.getNAVBARHEIGHT()));
                }
                this.psSysDashboardParamImpl.merge(iPSControlParam);
                super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psSysDashboardParamImpl);
            } else {
                super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
            }
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
        super.onInit();
        if (this.psSysDashboardParamImpl != null && !this.bInvalidId) {
            this.onPreparePSSysDashboardParts();
            this.onPreparePSSysDashboardLogics();
        }
    }

    protected void onPreparePSSysDashboardParts() throws Exception {
        int nMaxColCount = 12;
        boolean bConvert12Ro24 = false;
        int nScale = 1;
        String strLayoutMode = this.getLayoutMode();
        if (this.isDesignMode() && SA.SRFramework.Utility.StringHelper.Compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            strLayoutMode = "TABLE_12COL";
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            nMaxColCount = 24;
            bConvert12Ro24 = this.isEnableCol12ToCol24();
            if (bConvert12Ro24) {
                nScale = 2;
            }
        }
        Vector<PSSysDashboardPart> psSysDashboardItemList = new Vector<PSSysDashboardPart>();
        CallResult callResult = this.getPSModelHelper().getPSSysDashboardParts(this.psSysDashboard.getPSSYSDASHBOARDID(), psSysDashboardItemList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u770b\u677f\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSSysDashboardPart> psSysDashboardPartMap = new HashMap<String, PSSysDashboardPart>();
        for (PSSysDashboardPart psSysDashboardItem : psSysDashboardItemList) {
            psSysDashboardPartMap.put(psSysDashboardItem.getPSSYSDBPARTID(), psSysDashboardItem);
        }
        ArrayList<PSSysDashboardPart> psSysDashboardItemList2 = new ArrayList<PSSysDashboardPart>();
        for (PSSysDashboardPart psSysDashboardItem : psSysDashboardItemList) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psSysDashboardItem.getPPSSYSDBPARTID())) {
                psSysDashboardItemList2.add(psSysDashboardItem);
                continue;
            }
            PSSysDashboardPart parentPSSysDashboardPart = (PSSysDashboardPart)((Object)psSysDashboardPartMap.get(psSysDashboardItem.getPPSSYSDBPARTID()));
            if (parentPSSysDashboardPart == null) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6570\u636e\u770b\u677f[%1$s]\u6210\u5458[%2$s]\u7236\u5bf9\u8c61\u65e0\u6548", (Object)this.getLogicName(), (Object)psSysDashboardItem.getPSSYSDBPARTNAME()));
            }
            parentPSSysDashboardPart.getChildPSSysDashboardParts(true).add(psSysDashboardItem);
        }
        this.registerPSSysDashboardParts(this, psSysDashboardItemList2, nMaxColCount, nScale);
    }

    protected void registerPSSysDashboardParts(IPSDashboardContainer iPSDashboardContainer, ArrayList<PSSysDashboardPart> psSysDashboardItemList, int nMaxColCount, int nScale) throws Exception {
        boolean bFirst = true;
        for (PSSysDashboardPart psSysDashboardItem : psSysDashboardItemList) {
            if (!psSysDashboardItem.isVALIDFLAGNull() && !psSysDashboardItem.getVALIDFLAG()) continue;
            PSDBPortletPartParamImpl psPortletParamImpl = new PSDBPortletPartParamImpl();
            psPortletParamImpl.setColumnId(psSysDashboardItem.getCOLID());
            if (bFirst) {
                psPortletParamImpl.setNewRowMode(true);
                bFirst = false;
            } else if (psSysDashboardItem.getNEWROWMODE()) {
                psPortletParamImpl.setNewRowMode(true);
            }
            if (!psSysDashboardItem.isLAYOUTMODENull()) {
                psPortletParamImpl.setLayoutMode(psSysDashboardItem.getLAYOUTMODE());
            }
            if (psSysDashboardItem.getCOLSPAN() > 0) {
                psPortletParamImpl.setColumnSpan(psSysDashboardItem.getCOLSPAN() * nScale);
            }
            if (psSysDashboardItem.getCOL_LG() > 0 && psSysDashboardItem.getCOL_LG() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColLG(psSysDashboardItem.getCOL_LG() * nScale);
            }
            if (psSysDashboardItem.getCOL_LG_OS() > 0 && psSysDashboardItem.getCOL_LG_OS() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColLGOffset(psSysDashboardItem.getCOL_LG_OS() * nScale);
            }
            if (psSysDashboardItem.getCOL_MD() > 0 && psSysDashboardItem.getCOL_MD() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColMD(psSysDashboardItem.getCOL_MD() * nScale);
            }
            if (psSysDashboardItem.getCOL_MD_OS() > 0 && psSysDashboardItem.getCOL_MD_OS() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColMDOffset(psSysDashboardItem.getCOL_MD_OS() * nScale);
            }
            if (psSysDashboardItem.getCOL_SM() > 0 && psSysDashboardItem.getCOL_SM() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColSM(psSysDashboardItem.getCOL_SM() * nScale);
            }
            if (psSysDashboardItem.getCOL_SM_OS() > 0 && psSysDashboardItem.getCOL_SM_OS() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColSMOffset(psSysDashboardItem.getCOL_SM_OS() * nScale);
            }
            if (psSysDashboardItem.getCOL_XS() > 0 && psSysDashboardItem.getCOL_XS() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColXS(psSysDashboardItem.getCOL_XS() * nScale);
            }
            if (psSysDashboardItem.getCOL_XS_OS() > 0 && psSysDashboardItem.getCOL_XS_OS() * nScale <= nMaxColCount) {
                psPortletParamImpl.setColXSOffset(psSysDashboardItem.getCOL_XS_OS() * nScale);
            }
            if (!psSysDashboardItem.isHEIGHTNull() && psSysDashboardItem.getHEIGHT() >= 0) {
                psPortletParamImpl.setHeight(new Double(psSysDashboardItem.getHEIGHT()));
            }
            if (!psSysDashboardItem.isWIDTHNull() && psSysDashboardItem.getWIDTH() >= 0) {
                psPortletParamImpl.setWidth(new Double(psSysDashboardItem.getWIDTH()));
            }
            if (!psSysDashboardItem.isSHOWTITLEBARNull()) {
                psPortletParamImpl.setShowTitleBar(psSysDashboardItem.getSHOWTITLEBAR());
            }
            if (psSysDashboardItem.getFLEXGROW() > 0) {
                psPortletParamImpl.setFlexGrow(psSysDashboardItem.getFLEXGROW());
            }
            if (!psSysDashboardItem.isFLEXALIGNNull()) {
                psPortletParamImpl.setFlexAlign(psSysDashboardItem.getFLEXALIGN());
            }
            if (!psSysDashboardItem.isFLEXVALIGNNull()) {
                psPortletParamImpl.setFlexVAlign(psSysDashboardItem.getFLEXVALIGN());
            }
            if (!psSysDashboardItem.isFLEXDIRNull()) {
                psPortletParamImpl.setFlexDir(psSysDashboardItem.getFLEXDIR());
            }
            if (!psSysDashboardItem.isBL_POSNull()) {
                psPortletParamImpl.setBorderLayoutPos(psSysDashboardItem.getBL_POS());
            }
            if (!psSysDashboardItem.isTITLEBARCLOSEMODENull()) {
                psPortletParamImpl.setTitleBarCloseMode(psSysDashboardItem.getTITLEBARCLOSEMODE());
            }
            if (!psSysDashboardItem.isCONTENTTYPENull()) {
                psPortletParamImpl.setContentType(psSysDashboardItem.getCONTENTTYPE());
            }
            if (!psSysDashboardItem.isRAWCONTENTNull()) {
                psPortletParamImpl.setRawContent(psSysDashboardItem.getRAWCONTENT());
            }
            if (!psSysDashboardItem.isHTMLCONTENTNull()) {
                psPortletParamImpl.setHtmlContent(psSysDashboardItem.getHTMLCONTENT());
            }
            if (!psSysDashboardItem.isPSSYSRESOURCEIDNull()) {
                psPortletParamImpl.setPSSysResourceId(psSysDashboardItem.getPSSYSRESOURCEID());
            }
            if (!psSysDashboardItem.isDYNACLASSNull()) {
                psPortletParamImpl.setDynaClass(psSysDashboardItem.getDYNACLASS());
            }
            psPortletParamImpl.setPSSysPortletId(psSysDashboardItem.getPSSYSPORTLETID());
            psPortletParamImpl.setPortletType(psSysDashboardItem.getDBPARTTYPE());
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psSysDashboardItem.getPORTLETTYPE())) {
                psPortletParamImpl.setPortletType(psSysDashboardItem.getPORTLETTYPE());
            }
            psPortletParamImpl.setPSSysPFPluginId(psSysDashboardItem.getPSSYSPFPLUGINID());
            psPortletParamImpl.setTitle(psSysDashboardItem.getTITLE());
            psPortletParamImpl.setTitlePSLanguageResId(psSysDashboardItem.getTITLEPSLANRESID());
            psPortletParamImpl.setPSSysCssId(psSysDashboardItem.getPSSYSCSSID());
            psPortletParamImpl.setPSSysImageId(psSysDashboardItem.getPSSYSIMAGEID());
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psSysDashboardItem.getPARTPARAMS())) {
                psPortletParamImpl.setCtrlParams(psSysDashboardItem.getPARTPARAMS());
            }
            if (!psSysDashboardItem.isENABLEANCHORNull()) {
                psPortletParamImpl.setEnableAnchor(psSysDashboardItem.getENABLEANCHOR());
            }
            IPSDBPortletPart iPSPortlet = (IPSDBPortletPart)this.registerPSControl(String.valueOf(this.getName()) + "_" + psSysDashboardItem.getPSSYSDBPARTNAME(), "PORTLET", psPortletParamImpl);
            iPSDashboardContainer.registerPSPortlet(iPSPortlet);
            if (psSysDashboardItem.getChildPSSysDashboardParts(false) == null || !(iPSPortlet instanceof IPSDashboardContainer)) continue;
            this.registerPSSysDashboardParts((IPSDashboardContainer)((Object)iPSPortlet), psSysDashboardItem.getChildPSSysDashboardParts(false), nMaxColCount, nScale);
        }
    }

    protected void onPreparePSSysDashboardLogics() throws Exception {
        this.psSysDashboardLogicList.clear();
        this.onPreparePSSysDashboardLogics(this.getId());
    }

    protected void onPreparePSSysDashboardLogics(String strPSSysDashboardId) throws Exception {
        Vector<PSSysDashboardLogic> psSysDashboardLogicList = new Vector<PSSysDashboardLogic>();
        CallResult callResult = this.getPSModelHelper().getPSSysDashboardLogics(strPSSysDashboardId, psSysDashboardLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u770b\u677f\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysDashboardLogic psSysDashboardLogic : psSysDashboardLogicList) {
            PSSysDashboardLogicImpl psSysDashboardLogicImpl = new PSSysDashboardLogicImpl();
            psSysDashboardLogicImpl.init(this.getDAGlobalHelper(), this, psSysDashboardLogic);
            this.psSysDashboardLogicList.add(psSysDashboardLogicImpl);
        }
    }

    protected double[] calcColModels(String strColumnModel) throws Exception {
        String strColumns = strColumnModel;
        String[] columns = null;
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strColumns = strColumns.trim()))) {
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
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strColumn) || SA.SRFramework.Utility.StringHelper.Compare((String)strColumn, (String)"*", (boolean)true) == 0) {
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
            return this.getPSApplication().getViewCodeName(null, this.strCodeName, null);
        }
        return super.getCodeName();
    }

    @Override
    protected boolean isExportModelAlways() {
        if (this.getPSAppDataEntity() != null) {
            return false;
        }
        return super.isExportModelAlways();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u770b\u677f\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSSysDashboardLogic> getPSSysDashboardLogics() {
        if (this.psSysDashboardLogicList == null || this.psSysDashboardLogicList.size() == 0) {
            return null;
        }
        return this.psSysDashboardLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psSysDashboardLogicList == null || this.psSysDashboardLogicList.size() == 0) {
            return null;
        }
        return this.psSysDashboardLogicList.iterator();
    }
}

