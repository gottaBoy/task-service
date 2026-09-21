/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.control.dashboard.IPSSysDashboard
 *  net.ibizsys.model.control.dashboard.IPSSysDashboardParam
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.dashboard;

import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.dashboard.IPSSysDashboard;
import net.ibizsys.model.control.dashboard.IPSSysDashboardParam;
import net.ibizsys.model.control.dashboard.PSDBPortletParamPartImpl;
import net.ibizsys.model.control.dashboard.PSDashboardImpl;
import net.ibizsys.model.control.dashboard.PSSysDashboardParamImpl;
import net.ibizsys.model.entity.PSSysDashboard;
import net.ibizsys.model.entity.PSSysDashboardPart;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDashboardImpl
extends PSDashboardImpl
implements IPSSysDashboard {
    private static final Log log = LogFactory.getLog(PSSysDashboardImpl.class);
    protected PSSysDashboard psSysDashboard;
    protected PSSysDashboardParamImpl psSysDashboardParamImpl = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSControlContainer(iPSControlContainer);
            if (iPSControlParam instanceof IPSSysDashboardParam) {
                IPSSysDashboardParam iPSSysDashboardParam = (IPSSysDashboardParam)iPSControlParam;
                this.psSysDashboardParamImpl = new PSSysDashboardParamImpl();
                this.psSysDashboard = new PSSysDashboard();
                CallResult callResult = this.getPSModelQueryHelper().getPSSysDashboard(iPSSysDashboardParam.getPSSysDashboardId(), this.psSysDashboard);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u7cfb\u7edf\u6570\u636e\u770b\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psSysDashboard.getPSSYSDASHBOARDID());
                this.setName(strName);
                this.setLogicName(this.psSysDashboard.getPSSYSDASHBOARDNAME());
                this.setPSObjectData(this.psSysDashboard);
                this.psSysDashboardParamImpl.setColumnModels(this.calcColModels(this.psSysDashboard.getCOLMODEL()));
                this.psSysDashboardParamImpl.merge(iPSControlParam);
                super.init(iPSModelStorageContext, iPSControlContainer, strName, this.psSysDashboardParamImpl);
            } else {
                super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
            }
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.psSysDashboardParamImpl != null) {
            this.onPreparePSSysDashboardParts();
        }
    }

    protected void onPreparePSSysDashboardParts() throws Exception {
        int nMaxColCount = 12;
        boolean bConvert12Ro24 = false;
        int nScale = 1;
        String strLayoutMode = this.getPSAppView().getPSApplication().getPSApplicationUI().getFormLayoutMode();
        if (this.isDesignMode() && StringHelper.compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            strLayoutMode = "TABLE_12COL";
        }
        if (StringHelper.compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            nMaxColCount = 24;
            bConvert12Ro24 = this.isEnableCol12ToCol24();
            if (bConvert12Ro24) {
                nScale = 2;
            }
        }
        Vector<PSSysDashboardPart> psSysDashboardItemList = new Vector<PSSysDashboardPart>();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysDashboardParts(this.psSysDashboard.getPSSYSDASHBOARDID(), psSysDashboardItemList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6570\u636e\u770b\u677f\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        boolean bFirst = true;
        for (PSSysDashboardPart psSysDashboardItem : psSysDashboardItemList) {
            if (!psSysDashboardItem.isVALIDFLAGNull() && !psSysDashboardItem.getVALIDFLAG()) continue;
            PSDBPortletParamPartImpl psPortletParamImpl = new PSDBPortletParamPartImpl();
            psPortletParamImpl.setColumnId(psSysDashboardItem.getCOLID());
            if (bFirst) {
                psPortletParamImpl.setNewRowMode(true);
                bFirst = false;
            } else if (psSysDashboardItem.getNEWROWMODE()) {
                psPortletParamImpl.setNewRowMode(true);
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
            if (psSysDashboardItem.getHEIGHT() > 0) {
                psPortletParamImpl.setHeight(new Double(psSysDashboardItem.getHEIGHT()));
            }
            if (!psSysDashboardItem.isSHOWTITLEBARNull()) {
                psPortletParamImpl.setShowTitleBar(psSysDashboardItem.getSHOWTITLEBAR());
            }
            psPortletParamImpl.setPSSysPortletId(psSysDashboardItem.getPSSYSPORTLETID());
            psPortletParamImpl.setPortletType(psSysDashboardItem.getPORTLETTYPE());
            psPortletParamImpl.setTitle(psSysDashboardItem.getTITLE());
            psPortletParamImpl.setTitlePSLanguageResId(psSysDashboardItem.getTITLEPSLANRESID());
            IPSDBPortletPart iPSPortlet = (IPSDBPortletPart)this.registerPSControl(String.valueOf(this.getName()) + "_" + psSysDashboardItem.getPSSYSDBPARTNAME(), "PORTLET", psPortletParamImpl);
            this.registerPSPortlet(iPSPortlet);
        }
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
}

