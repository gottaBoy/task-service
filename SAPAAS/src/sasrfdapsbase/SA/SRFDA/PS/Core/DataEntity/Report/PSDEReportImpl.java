/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Report;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReport;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReportItem;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.PSAppSysPanelPreviewViewImpl;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReportItem;
import SA.SRFDA.PS.Core.DataEntity.Report.PSDEReportItemImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEReport;
import SA.SRFDA.PS.Data.PSDEReportItem;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEReportImpl
extends PSDataEntityObjectImpl
implements IPSDEReport,
IPSAppDEReport,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEReportImpl.class);
    protected PSDEReport psDEReport;
    protected ArrayList<IPSDEReportItem> psDEReportItemList = new ArrayList();
    protected ArrayList<IPSAppDEReportItem> psAppDEReportItemList = new ArrayList();
    protected String strCodeName = "";
    private String strPSDEDataSetId = "";
    private IPSDEDataSet iPSDEDataSet = null;
    private String strPSDEDataSetId2 = "";
    private IPSDEDataSet iPSDEDataSet2 = null;
    private String strPSDEDataSetId3 = "";
    private IPSDEDataSet iPSDEDataSet3 = null;
    private String strPSDEDataSetId4 = "";
    private IPSDEDataSet iPSDEDataSet4 = null;
    private boolean bMultiPage = false;
    private boolean bEnableLog = false;
    private String strReportType = null;
    private String strReportFile = null;
    private IPSSysUniRes iPSSysUniRes = null;
    private int nExtendMode = 0;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private int nPOTime = -1;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEDataSet iPSAppDEDataSet = null;
    private IPSAppDEDataSet iPSAppDEDataSet2 = null;
    private IPSAppDEDataSet iPSAppDEDataSet3 = null;
    private IPSAppDEDataSet iPSAppDEDataSet4 = null;
    private Properties reportParams = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysBIScheme iPSSysBIScheme = null;
    private IPSSysBICube iPSSysBICube = null;
    private IPSSysBIReport iPSSysBIReport = null;
    private String strPSSysBICubeId = null;
    private String strPSSysBIReportId = null;
    private IPSAppBIScheme iPSAppBIScheme = null;
    private IPSAppBICube iPSAppBICube = null;
    private IPSAppBIReport iPSAppBIReport = null;
    private IPSLayoutPanel iPSLayoutPanel = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, PSDEReport psDEReport) throws Exception {
        this.iPSAppDataEntity = iPSAppDataEntity;
        this.init(iDAGlobalHelper, this.iPSAppDataEntity.getPSDataEntity(), psDEReport);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEReport psDEReport) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEReport = psDEReport;
            this.setId(psDEReport.getPSDEREPORTID());
            this.setName(psDEReport.getPSDEREPORTNAME());
            this.setPSObjectData(this.psDEReport);
            this.strCodeName = this.psDEReport.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!this.psDEReport.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEReport.getEXTENDMODE();
            }
            this.strPSDEDataSetId = this.psDEReport.getPSDEDSID();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId)) {
                this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.strPSDEDataSetId);
                if (this.getPSAppDataEntity() != null) {
                    this.iPSAppDEDataSet = this.getPSAppDataEntity().getPSAppDEDataSet(this.iPSDEDataSet, true);
                }
            }
            this.strPSDEDataSetId2 = this.psDEReport.getPSDEDSID2();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId2)) {
                this.iPSDEDataSet2 = this.getPSDataEntity().getPSDEDataSet(this.strPSDEDataSetId2);
                if (this.getPSAppDataEntity() != null) {
                    this.iPSAppDEDataSet2 = this.getPSAppDataEntity().getPSAppDEDataSet(this.iPSDEDataSet2, true);
                }
            }
            this.strPSDEDataSetId3 = this.psDEReport.getPSDEDSID3();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId3)) {
                this.iPSDEDataSet3 = this.getPSDataEntity().getPSDEDataSet(this.strPSDEDataSetId3);
                if (this.getPSAppDataEntity() != null) {
                    this.iPSAppDEDataSet3 = this.getPSAppDataEntity().getPSAppDEDataSet(this.iPSDEDataSet3, true);
                }
            }
            this.strPSDEDataSetId4 = this.psDEReport.getPSDEDSID4();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId4)) {
                this.iPSDEDataSet4 = this.getPSDataEntity().getPSDEDataSet(this.strPSDEDataSetId4);
                if (this.getPSAppDataEntity() != null) {
                    this.iPSAppDEDataSet4 = this.getPSAppDataEntity().getPSAppDEDataSet(this.iPSDEDataSet4, true);
                }
            }
            if (!this.psDEReport.isMULTIPAGENull()) {
                this.bMultiPage = this.psDEReport.getMULTIPAGE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEReport.getREPORTTYPE())) {
                this.strReportType = this.psDEReport.getREPORTTYPE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEReport.getREPORTFILE())) {
                this.strReportFile = this.psDEReport.getREPORTFILE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEReport.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSDataEntity().getPSSystem().getPSSysUniRes(this.psDEReport.getPSSYSUNIRESID());
            }
            if (!this.psDEReport.isPOTIMENull() && this.psDEReport.getPOTIME() > 0) {
                this.nPOTime = this.psDEReport.getPOTIME();
            }
            if ("SYSBICUBE".equals(this.getReportType()) || "DESYSBICUBES".equals(this.getReportType()) || "ALLSYSBICUBES".equals(this.getReportType()) || "SYSBIREPORT".equals(this.getReportType()) || "DESYSBIREPORTS".equals(this.getReportType()) || "SYSBICUBEREPORTS".equals(this.getReportType()) || "ALLSYSBIREPORTS".equals(this.getReportType())) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEReport.getPSSYSBISCHEMEID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u4f53\u7cfb");
                }
                this.iPSSysBIScheme = this.getPSSystem().getPSSysBIScheme(this.psDEReport.getPSSYSBISCHEMEID());
                if ("SYSBICUBE".equals(this.getReportType()) || "SYSBICUBEREPORTS".equals(this.getReportType())) {
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEReport.getPSSYSBICUBEID())) {
                        throw new Exception("\u672a\u6307\u5b9a\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53");
                    }
                    this.strPSSysBICubeId = this.psDEReport.getPSSYSBICUBEID();
                } else if ("SYSBIREPORT".equals(this.getReportType())) {
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEReport.getPSSYSBIREPORTID())) {
                        throw new Exception("\u672a\u6307\u5b9a\u7cfb\u7edf\u667a\u80fd\u62a5\u8868");
                    }
                    this.strPSSysBIReportId = this.psDEReport.getPSSYSBIREPORTID();
                }
                this.strPSDEDataSetId = "";
                this.iPSDEDataSet = null;
                this.strPSDEDataSetId2 = "";
                this.iPSDEDataSet2 = null;
                this.strPSDEDataSetId3 = "";
                this.iPSDEDataSet3 = null;
                this.strPSDEDataSetId4 = "";
                this.iPSDEDataSet4 = null;
                this.iPSAppDEDataSet = null;
                this.iPSAppDEDataSet2 = null;
                this.iPSAppDEDataSet3 = null;
                this.iPSAppDEDataSet4 = null;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEReport.getREPORTPARAMS())) {
                this.reportParams = PropertiesHelper.Load((String)this.psDEReport.getREPORTPARAMS());
            }
            this.onInit();
        }
        catch (Exception ex) {
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
        String strPSSysSFPluginId = this.psDEReport.getPSSYSSFPLUGINID();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEReport.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSAppDataEntity() != null ? this.getPSAppDataEntity().getPSApplication().getPSSysPFPlugin(this.psDEReport.getPSSYSPFPLUGINID(), "DEREPORT", null, null) : this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEReport.getPSSYSPFPLUGINID());
        }
        if (this.getPSAppDataEntity() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSLayoutPanelId())) {
            try {
                PSAppView psAppView = new PSAppView();
                psAppView.setPSAPPVIEWID("PSDEReportPanelView");
                psAppView.setPSAPPVIEWNAME("PSDEReportPanelView");
                PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
                psDEViewCtrl.setPSDEVIEWCTRLNAME("panel");
                psDEViewCtrl.setPSDEVIEWCTRLTYPE("PANEL");
                psDEViewCtrl.setPSSYSVIEWPANELID(this.getPSLayoutPanelId());
                PSAppSysPanelPreviewViewImpl psAppSysPanelPreviewViewImpl = new PSAppSysPanelPreviewViewImpl();
                psAppSysPanelPreviewViewImpl.init(this.getDAGlobalHelper(), this.getPSAppDataEntity().getPSApplication(), psAppView, this.getPSDataEntity(), psDEViewCtrl);
                this.iPSLayoutPanel = (IPSLayoutPanel)psAppSysPanelPreviewViewImpl.getPSControl("panel");
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        super.onInit();
        if (this.isMultiPage()) {
            this.onPreparePSDEReportItems();
        }
    }

    protected void onPreparePSDEReportItems() throws Exception {
        this.psDEReportItemList.clear();
        this.psAppDEReportItemList.clear();
        Vector<PSDEReportItem> psDEReportItemList = new Vector<PSDEReportItem>();
        CallResult callResult = this.getPSModelHelper().getPSDEReportItems(this.getId(), psDEReportItemList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u62a5\u8868\u5b50\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (this.getPSAppDataEntity() == null) {
            for (PSDEReportItem psDEReportItem : psDEReportItemList) {
                PSDEReportItemImpl iPSDEReportItem = new PSDEReportItemImpl();
                iPSDEReportItem.init(this.getDAGlobalHelper(), this, psDEReportItem);
                this.psDEReportItemList.add(iPSDEReportItem);
            }
        } else {
            for (PSDEReportItem psDEReportItem : psDEReportItemList) {
                PSDEReportItemImpl iPSDEReportItem = new PSDEReportItemImpl();
                iPSDEReportItem.init(this.getDAGlobalHelper(), this, psDEReportItem);
                this.psAppDEReportItemList.add(iPSDEReportItem);
            }
        }
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSysBICube();
        this.getPSSysBIReport();
        this.getPSAppBICube();
        this.getPSAppBIReport();
        if (this.getPSAppDataEntity() == null) {
            Iterator<IPSDEReportItem> psDEReportItems = this.getPSDEReportItems();
            if (psDEReportItems != null) {
                while (psDEReportItems.hasNext()) {
                    IPSDEReportItem iPSDEReportItem = psDEReportItems.next();
                    iPSDEReportItem.check();
                }
            }
        } else {
            Iterator<IPSAppDEReportItem> psDEReportItems = this.getPSAppDEReportItems();
            if (psDEReportItems != null) {
                while (psDEReportItems.hasNext()) {
                    IPSAppDEReportItem iPSDEReportItem = psDEReportItems.next();
                    iPSDEReportItem.check();
                }
            }
        }
        if (this.getPSLayoutPanel() != null) {
            this.getPSLayoutPanel().check();
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u9879\u96c6\u5408", hideempty2=true, child=true, ignorepf=true)
    public Iterator<IPSDEReportItem> getPSDEReportItems() {
        return this.psDEReportItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"PSDEDSID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    public String getPSDEDataSetId() {
        return this.strPSDEDataSetId;
    }

    @Override
    @PSModelRTMeta(description="\u591a\u9875\u62a5\u8868", ignoredumpvalues="false", fields={"MULTIPAGE"})
    public boolean isMultiPage() {
        return this.bMultiPage;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u65e5\u5fd7", ignoredumpvalues="false", fields={"ENABLELOG"})
    public boolean isEnableLog() {
        return this.bEnableLog;
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u7c7b\u578b", fields={"REPORTTYPE"})
    public String getReportType() {
        return this.strReportType;
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u8def\u5f84", ignorepf=true, fields={"REPORTFILE"})
    public String getReportFile() {
        return this.strReportFile;
    }

    @Override
    @PSModelRTMeta(description="\u6743\u9650\u7edf\u4e00\u8d44\u6e90\u5bf9\u8c61", dumpref=true, ignorepf=true)
    public IPSSysUniRes getPSSysUniRes() {
        return this.iPSSysUniRes;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90\u4ee3\u7801", doc="\u7b49\u540c\u8c03\u7528{@link #getPSSysUniRes}.getResCode()")
    public String getSysUniResCode() {
        if (this.getPSSysUniRes() == null) {
            return null;
        }
        return this.getPSSysUniRes().getResCode();
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDEREPORT";
        }
        return "PSDEREPORT";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c612", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"PSDEDSID2"})
    public IPSDEDataSet getPSDEDataSet2() {
        return this.iPSDEDataSet2;
    }

    @Override
    public String getPSDEDataSetId2() {
        return this.strPSDEDataSetId2;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c613", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"PSDEDSID3"})
    public IPSDEDataSet getPSDEDataSet3() {
        return this.iPSDEDataSet3;
    }

    @Override
    public String getPSDEDataSetId3() {
        return this.strPSDEDataSetId3;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c614", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"PSDEDSID4"})
    public IPSDEDataSet getPSDEDataSet4() {
        return this.iPSDEDataSet4;
    }

    @Override
    public String getPSDEDataSetId4() {
        return this.strPSDEDataSetId4;
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u6a21\u578b", ignorepf=true, fields={"REPORTMODEL"})
    public String getReportModel() {
        return this.psDEReport.getREPORTMODEL();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u6027\u80fd\u4f18\u5316\u9884\u8b66\u65f6\u957f\uff08ms\uff09", ignorepf=true, ignoredumpvalues="-1", fields={"POTIME"})
    public int getPOTime() {
        return this.nPOTime;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u5408", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEDSID"})
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u54082", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEDSID2"})
    public IPSAppDEDataSet getPSAppDEDataSet2() {
        return this.iPSAppDEDataSet2;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u54083", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEDSID3"})
    public IPSAppDEDataSet getPSAppDEDataSet3() {
        return this.iPSAppDEDataSet3;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u54084", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEDSID4"})
    public IPSAppDEDataSet getPSAppDEDataSet4() {
        return this.iPSAppDEDataSet4;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u62a5\u8868\u9879\u96c6\u5408", hideempty=true, child=true)
    public Iterator<IPSAppDEReportItem> getPSAppDEReportItems() {
        return this.psAppDEReportItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", codelist="ReportContentType", fields={"CONTENTTYPE"})
    public String getContentType() {
        return this.psDEReport.getCONTENTTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u6807\u8bb0", fields={"REPORTTAG"})
    public String getReportTag() {
        return this.psDEReport.getREPORTTAG();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u6807\u8bb02", fields={"REPORTTAG2"})
    public String getReportTag2() {
        return this.psDEReport.getREPORTTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", ignorepf=true, fields={"REPORTPARAMS"})
    public Properties getReportParams() {
        return this.reportParams;
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u754c\u9762\u6a21\u578b", fields={"REPORTUIMODEL"})
    public String getReportUIModel() {
        return this.psDEReport.getREPORTUIMODEL();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true, fields={"PSSYSPFPLUGINID"})
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u4f53\u7cfb", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSBISCHEMEID"})
    public IPSSysBIScheme getPSSysBIScheme() {
        return this.iPSSysBIScheme;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSBICUBEID"})
    public IPSSysBICube getPSSysBICube() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSSysBICubeId) && this.iPSSysBICube == null) {
            this.iPSSysBICube = this.getPSSysBIScheme().getPSSysBICube(this.strPSSysBICubeId);
        }
        return this.iPSSysBICube;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSBIREPORTID"})
    public IPSSysBIReport getPSSysBIReport() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSSysBIReportId) && this.iPSSysBIReport == null) {
            this.iPSSysBIReport = this.getPSSysBIScheme().getPSSysBIReport(this.strPSSysBIReportId);
        }
        return this.iPSSysBIReport;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u62a5\u8868\u4f53\u7cfb", hideempty=true, dumpref=true)
    public IPSAppBIScheme getPSAppBIScheme() throws Exception {
        if (this.iPSAppBIScheme == null && this.getPSSysBIScheme() != null && this.getPSAppDataEntity() != null) {
            this.iPSAppBIScheme = this.getPSAppDataEntity().getPSApplication().getPSAppBIScheme(this.getPSSysBIScheme());
        }
        return this.iPSAppBIScheme;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53", hideempty=true, dumpref=true, from="IPSAppBIScheme")
    public IPSAppBICube getPSAppBICube() throws Exception {
        if (this.iPSAppBICube == null && this.getPSSysBICube() != null && this.getPSAppBIScheme() != null) {
            this.iPSAppBICube = this.getPSAppBIScheme().getPSAppBICube(this.getPSSysBICube(), false);
        }
        return this.iPSAppBICube;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u62a5\u8868", hideempty=true, child=true, from="IPSAppBIScheme")
    public IPSAppBIReport getPSAppBIReport() throws Exception {
        if (this.iPSAppBIReport == null && this.getPSSysBIReport() != null && this.getPSAppBIScheme() != null) {
            this.iPSAppBIReport = this.getPSAppBIScheme().getPSAppBIReport(this.getPSSysBIReport(), false);
        }
        return this.iPSAppBIReport;
    }

    @Override
    public String getPSLayoutPanelId() {
        return this.psDEReport.getPSSYSVIEWPANELID();
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u9762\u677f", child=true)
    public IPSLayoutPanel getPSLayoutPanel() {
        return this.iPSLayoutPanel;
    }
}

